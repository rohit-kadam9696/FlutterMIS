package com.twd.flutter.android.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.twd.convertismtouni.DemoConvert2;
import com.twd.flutter.android.bean.AppUpdate;
import com.twd.flutter.android.bean.ConstantMessage;
import com.twd.flutter.android.bean.LoginResponse;
import com.twd.flutter.android.bean.MainResponse;
import com.twd.flutter.android.bean.MasterDataResponse;
import com.twd.flutter.android.bean.ServerError;
import com.twd.flutter.android.constant.AppConstant;
import com.twd.flutter.android.constant.ConstantVeriables;
import com.twd.flutter.android.constant.RandomString;

import com.twd.flutter.android.constant.Constant;

public class LoginDao {
	public LoginResponse verifyLogin(String mobileno, String accessType, Connection conn) {
		
		LoginResponse res=new LoginResponse();
		ServerError svr=new ServerError();
		try
		{
				try(PreparedStatement pst=conn.prepareStatement("select t.nuser_name,t.vactive,t.nuser_role_id from twderp.erp_m_user t  where  t.nmobile_no=?"))
				{
					int i=1;
					pst.setString(i++, mobileno);
					
					try(ResultSet rs=pst.executeQuery())
					{
						if(rs.next())
						{
							
							try(PreparedStatement pst1=conn.prepareStatement("select t1.napp_id  from  twderp.erp_m_app_role t1, twderp.erp_m_list t2 where t1.napp_id=t2.napp_id and t1.nuser_role_id=?  and t2.napp_id=?"))
							{
								i=1;
								pst1.setString(i++, rs.getString("nuser_role_id"));
								pst1.setString(i++, accessType);
								try(ResultSet rs1=pst1.executeQuery()){
									if(rs1.next())
									{
										res.setSuccess(true);
										res.setSlipboycode(rs.getString("nuser_name"));
										res.setChitBoyId(rs.getString("nuser_name"));
										res.setMobileno(mobileno);
										if(!rs.getString("vactive").equalsIgnoreCase("Y"))
										{
											res.setSuccess(false);
											svr.setError(ConstantVeriables.ERROR_003);
											svr.setMsg(ConstantMessage.deactiveUser);
											res.setSe(svr);
											return res;
										}
									}else
									{
										res.setSuccess(false);
										svr.setError(ConstantVeriables.ERROR_003);
										svr.setMsg(ConstantMessage.permissionNot);
										res.setSe(svr);
									}
								}
							}
						}else
						{
							res.setSuccess(false);
							svr.setError(ConstantVeriables.ERROR_004);
							svr.setMsg(ConstantMessage.userNotFound);
							res.setSe(svr);
						}
					}
				}
			} catch (SQLException e) {
				res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"verify user " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		
		return res;
	}

	public LoginResponse checkUserHistory(String accessType, LoginResponse res, Connection conn) {

		try(PreparedStatement pst=conn.prepareStatement("select t.nuserid from twderp.erp_app_t_user_tracker t where t.nuserid=? and t.napp_id=? "))
		{
			int i=1;
			pst.setString(i++, res.getChitBoyId());
			pst.setString(i++, accessType);
			try(ResultSet rs=pst.executeQuery())
			{
				if(rs.next())
				{
					res.setSuccess(true);
				}else
				{
					res.setSuccess(false);
				}
			}
		} catch (SQLException e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"App history " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	
	}

	public LoginResponse updateImeiAndRandamString(String accessType, LoginResponse res, String imei, Connection conn) {

		try(PreparedStatement pst=conn.prepareStatement("UPDATE twderp.erp_app_t_user_tracker SET vimei=?,vuniquestring=?,vuniquestring2=vuniquestring WHERE nuserid=? and napp_id=? "))
		{
			int i=1;
			pst.setString(i++, imei);
			pst.setString(i++, res.getUniquestring());
			pst.setString(i++, res.getChitBoyId());
			pst.setString(i++, accessType);
			int r=pst.executeUpdate();
			if(r>0)
				res.setSuccess(true);
			else
				res.setSuccess(false);
		} catch (SQLException e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"Save IMEI " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	
	}

	public LoginResponse saveimeiAndRandamString(String accessType, LoginResponse res, String imei, Connection conn) {

		try(PreparedStatement pst=conn.prepareStatement("insert into twderp.erp_app_t_user_tracker(nuserid,vimei,vuniquestring,vuniquestring2,napp_id)VALUES(?,?,?,?,?)"))
		{
			int i=1;
			pst.setString(i++, res.getChitBoyId());
			pst.setString(i++, imei);
			pst.setString(i++, res.getUniquestring());
			pst.setString(i++, res.getUniquestring());
			pst.setString(i++, accessType);
			int r=pst.executeUpdate();
			if(r>0)
				res.setSuccess(true);
			else
				res.setSuccess(false);
		} catch (SQLException e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"Save IMEI " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	
	}

	public LoginResponse generateOTP(String accessType, LoginResponse res, Connection conn) {


		try{
			try(PreparedStatement pst=conn.prepareStatement("update twderp.erp_app_t_otp set vstatus='E' WHERE vstatus='Y' AND nmobile_no=? AND napp_id=?")){
				int i = 1;
				pst.setString(i++, res.getMobileno());
				pst.setString(i++, accessType);
				pst.executeUpdate();
			}
			String otp = RandomString.generateRandomNumber();
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			try(PreparedStatement pst=conn.prepareStatement("insert into twderp.erp_app_t_otp(notp_id,votp,nmobile_no,dgenrated_date,dexprie_date,vstatus,napp_id) values(APP_OTP_SEQ.nextval,?,?,TO_DATE(?,'dd-Mon-yyyy HH24:mi:ss'),TO_DATE(?,'dd-Mon-yyyy HH24:mi:ss'),?,?)")){
				int i = 1;
				pst.setString(i++, otp);
				pst.setString(i++, res.getMobileno());
				pst.setString(i++, df.format(cal.getTime()));
				cal.add(Calendar.DAY_OF_MONTH, ConstantVeriables.otpexpiredate);
				pst.setString(i++, df.format(cal.getTime()));
				pst.setString(i++, "Y");
				pst.setString(i++, accessType);
				int r=pst.executeUpdate();
				if(r>0)
				{
					res.setSuccess(true);
					res=insertOtpRecord(res.getMobileno(),otp,ConstantMessage.otpmessage,res,conn);
				}
			}
		} catch (Exception e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"OTP Generate " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	
	
	}
	
	public MainResponse verifyOTP(MainResponse res, String otp, Connection conn) {
		try{
			
			
			try(PreparedStatement pst=conn.prepareStatement("update twderp.erp_app_t_otp set vstatus='U' WHERE vstatus='Y' AND nmobile_no=? and votp=?")){
				int i = 1;
				pst.setString(i++, res.getMobileno());
				pst.setString(i++, otp);
				int r=pst.executeUpdate();
				if(r>0)
				{
					res.setSuccess(true);
				}
				else
				{
					res.setSuccess(false);
					ServerError error=new ServerError();
					error.setError(ConstantVeriables.ERROR_006);
					error.setMsg("Wrong OTP");
					res.setSe(error);
				}
					
			}
		} catch (Exception e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"verify otp " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	}


	private LoginResponse insertOtpRecord(String mobileno, String otp, String otpmessage, LoginResponse res,
			Connection conn) {

		try {
		Date dt = new Date();
		String maxsrno="1";
	      SimpleDateFormat dateFormat;
	      dateFormat = new SimpleDateFormat("hh:mm:ss a");
	      try (PreparedStatement pst = conn.prepareStatement("select max(t.sr_no)+1 as maxsrno from sugarerp.sms_out t")) {
	    	  try(ResultSet rs=pst.executeQuery()) {
	    		  if(rs.next())
	    			  maxsrno= rs.getString("maxsrno");
	    		  
	    	  }
	      }
	      
		try (PreparedStatement pst = conn.prepareStatement("insert into sugarerp.sms_out(sr_no,MOBILE_NO ,MESSAGE_TYPE,INDIDUAL_CODE,STATUS,MEDIA,IN_TIME,MESSAGE,SMS_PARAMETER,IS_UNICODE)VALUES(?,?,?,?,?,?,?,?,?,?)")) {
			int i = 1;
			pst.setString(i++, maxsrno);
			pst.setString(i++, mobileno);
			pst.setString(i++, "OTP");
			pst.setString(i++, "0");
			pst.setString(i++, "N");
			pst.setString(i++, "WEB");			//pst.setString(i++, "SIM");
			pst.setString(i++,dateFormat.format(dt));
			pst.setString(i++,otp+otpmessage);
			pst.setString(i++,"T");			//pst.setString(i++,"0");
			pst.setString(i++,"N");

			pst.executeUpdate();
		}
		} catch (SQLException e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"send otp Issue " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	
	}

	public MainResponse checkAppUpdate(MainResponse appversionRes, String versionId, String accessType,
			Connection conn) {
		try(PreparedStatement pst=conn.prepareStatement("select t.vversionname,t.vupdate,t.vcomplusory,t.vhead,t.vmessage from twderp.erp_app_t_version t where t.nversionid=?  and t.napp_id=? "))
		{
			pst.setString(1, versionId);
			pst.setString(2, accessType);
			try(ResultSet rs=pst.executeQuery())
			{
				if(rs.next())
				{
					AppUpdate update=new AppUpdate();
					update.setForceUpdate(rs.getString("vcomplusory").equalsIgnoreCase("Y"));
					update.setHead(rs.getString("vhead"));
					update.setMessage(rs.getString("vmessage"));
					try(FileInputStream inputStream = new FileInputStream("D:\\3WD_Software\\app\\appurl.txt")) {     
					    String everything = IOUtils.toString(inputStream);
					    update.setUpdateUrl(everything);
					}
					appversionRes.setUpdateResponse(update);
					appversionRes.setUpdate(rs.getString("vcomplusory").equalsIgnoreCase("Y") || rs.getString("vupdate").equalsIgnoreCase("Y"));
				}else
				{
					appversionRes.setUpdate(false);
				}
			}
		} catch (Exception e) {
			appversionRes=(LoginResponse) AppConstant.ConfigureErrorMessage(appversionRes,"version " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return appversionRes;
	}

	public MainResponse verifyUser(MainResponse res, String chit_boy_id, String ramdomstring, String imei,
			String accessType, Connection conn) {
		
		   
		
		/*	System.out.println("verifyUser method imei "+ imei);
			System.out.println("verifyUser method ramdomstring "+ramdomstring);
			System.out.println("verifyUser method chit_boy_id "+ chit_boy_id);
			System.out.println("verifyUser method accessType " +accessType);*/
			
			
		ServerError svr=new ServerError();
		try
		{
			res.setCurrentDateTime(Constant.getCurrentDateTime());
			
			boolean isDateError=Constant.errorDate();
			
			
			if(!isDateError)
			{
				
				res.setSuccess(false);
				svr.setError(ConstantVeriables.ERROR_006);
				svr.setMsg(ConstantMessage.dateError);
				res.setSe(svr);
			}else
			{
				
				
				try(PreparedStatement pst=conn.prepareStatement("select t.nmobile_no,TO_NCHAR(t.vfull_name_local)as vfull_name,t.nuser_name,t.nuser_role_id,t.vactive,t2.vimei,t2.vuniquestring,t2.vuniquestring2,t.nlocation_id,t.nsug_type_id from twderp.erp_m_user t,twderp.erp_app_t_user_tracker t2 where  t.nuser_name=t2.nuserid AND t.nuser_name=? and t2.napp_id=? "))
				{
					
					int i=1;
					pst.setString(i++, chit_boy_id);
					pst.setString(i++, accessType);
					try(ResultSet rs=pst.executeQuery())
					{
						
						if(rs.next())
						{
							
								
							if(!rs.getString("vactive").equalsIgnoreCase("Y"))
							{
								res.setSuccess(false);
								svr.setError(ConstantVeriables.ERROR_003);
								svr.setMsg(ConstantMessage.deactiveUser);
								res.setSe(svr);
								return res;
							}else if(!rs.getString("vimei").equalsIgnoreCase(imei))
							{
								res.setSuccess(false);
								svr.setError(ConstantVeriables.ERROR_002);
								svr.setMsg(ConstantMessage.imeiChangemsg);
								res.setSe(svr);
								return res;
							}
								else if(!ramdomstring.trim().equals(rs.getString("vuniquestring")) && !ramdomstring.trim().equals(rs.getString("vuniquestring2")))
							{
								res.setSuccess(false);
								svr.setError(ConstantVeriables.ERROR_001);
								svr.setMsg(ConstantMessage.uniqueChangemsg);
								res.setSe(svr);
								return res;
							}else
							{
								res.setSuccess(true);
								//res.setDesignation(rs.getString("vsubdept_name_eng"));
								res.setMobileno(rs.getString("nmobile_no"));
								res.setNuserRoleId(rs.getString("nuser_role_id"));
								res.setSlipboycode(rs.getString("nuser_name"));
								//res.setFromTimeRawana(ConstantVeriables.fromTimeRawana);
								//res.setToTimeRawana(ConstantVeriables.toTimeRawana);
								res.setVfullName(DemoConvert2.ism_to_uni(rs.getString("vfull_name")));
								res.setNlocationId(rs.getInt("nlocation_id"));
								res.setNsugTypeId(rs.getInt("nsug_type_id"));
								res=permissionById(res, chit_boy_id, conn);
								res=validation(res,conn);
							}
						}else
						{
							res.setSuccess(false);
							svr.setError(ConstantVeriables.ERROR_004);
							svr.setMsg(ConstantMessage.userNotFound);
							res.setSe(svr);
						}
						res.setUniquestring(ramdomstring);
						res=updateRandamString(res,chit_boy_id, accessType,conn);
					}
				}
				
				try(PreparedStatement pst=conn.prepareStatement("select t.vseason_year from app_t_me_sugar t where t.vactive='A' group by t.vseason_year"))
				{
					try(ResultSet rs=pst.executeQuery())
					{
						if(rs.next())
						{
							res.setYearCode(rs.getString("vseason_year"));
						}
					}
				}
				
				res.setVfertYear("2024-2025");
				res.setHarvestingYearCode("2023-2024");
				
			}
		} catch (Exception e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"login issue " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	
	}

	private MainResponse updateRandamString(MainResponse res, String chit_boy_id, String accessType, Connection conn) {
		try(PreparedStatement pst=conn.prepareStatement("UPDATE APP_T_USER_TRACKER SET vuniquestring2=vuniquestring,vuniquestring=? WHERE nuserid=? and napp_id=?"))
		{
			String randamstring=RandomString.generateRandomString();
			int i=1;
			pst.setString(i++, randamstring);
			pst.setString(i++, chit_boy_id);
			pst.setString(i++, accessType);
			int r=pst.executeUpdate();
			if(r>0)
			{
				res.setSuccess(true);
				res.setUniquestring(randamstring);
			}
			else
				res.setSuccess(false);
		} catch (SQLException e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"update String " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	}

	private MainResponse validation(MainResponse res, Connection conn) {
		try
		{
			
			try(PreparedStatement pst=conn.prepareStatement("select t.nvalidation_id,t.vvalidation_name, t.vvalidation_value from app_m_validation t"))
			{
				
				try(ResultSet rs=pst.executeQuery())
				{
					while(rs.next())
					{
						String vvalidation_name=rs.getString("vvalidation_name");
						
						if(vvalidation_name.equalsIgnoreCase("area_min"))
							res.setAreaMin(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("area_max"))
							res.setAreaMax(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("intimation_acc"))
							res.setIntimationAcc(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("intimation_min_date"))
							res.setIntimationMinDate(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("plantation_acc"))
							res.setPlantationAcc(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("plantation_max_date"))
							res.setPlantationMaxDate(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("Map_Allow_In"))
							res.setMapAllowIn(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("Calculation_Acc"))
							res.setCalculationAcc(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("Load_Time"))
							res.setLoadTime(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("Online_Calculation"))
							res.setOnlineCalcualte(rs.getString("vvalidation_value"));
						else if (vvalidation_name.equalsIgnoreCase("Avarge_Tonnage"))
							res.setAvargeTonnage(rs.getString("vvalidation_value"));
					}
				}
			}
			
		}catch (SQLException e) {
			res=(MasterDataResponse) AppConstant.ConfigureErrorMessage(res,"menu list " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				e.printStackTrace();
			}
		return res;
	}

	

	private MainResponse permissionById(MainResponse res, String chit_boy_id, Connection conn) {
		try (PreparedStatement pst = conn.prepareStatement("select t.vimg_name,t.ngroupid,t.nid,TO_NCHAR(t.vname) as vname from APP_M_SUBMENU t,app_m_submenu_role t1 where t.nid=t1.nid and t1.nuser_role_id=? and t.ngroupid is not null and t.vactive='A' and t.ngroupid!=6 order by t.ngroupid, t.norder_android")) {
			int k = 1;
			pst.setString(k++, res.getNuserRoleId());
			try (ResultSet rs = pst.executeQuery()) {
				HashMap<String, ArrayList<HashMap<String, String>>> permisions = new HashMap<>();
				Set<String> pggroup = new HashSet<String>();
				while (rs.next()) {
					String pgroupid = rs.getString("ngroupid");
					String pid = rs.getString("nid");
					ArrayList<HashMap<String, String>> jar = null;
					if (permisions.containsKey(pgroupid)) {
						jar = permisions.get(pgroupid);
					} else {
						jar = new ArrayList<>();
					}
					HashMap<String, String> permObj = new HashMap<>();
					permObj.put("mnu_id", pid);
					permObj.put("mnu_name", DemoConvert2.ism_to_uni(rs.getString("vname")));
					permObj.put("vimg_name", rs.getString("vimg_name"));
					jar.add(permObj);
					permisions.put(pgroupid, jar);
					pggroup.add(pgroupid);
				}
				res.setPggroups(String.join(",", pggroup));
				res.setPerbygroup((new JSONObject(permisions)).toString());
			}
		} catch (SQLException e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"permission " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	}

}
