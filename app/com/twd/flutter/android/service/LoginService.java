package com.twd.flutter.android.service;

import java.sql.Connection;

import org.json.JSONObject;

import com.twd.flutter.android.bean.LoginResponse;
import com.twd.flutter.android.bean.MainResponse;
import com.twd.flutter.android.constant.AppConstant;
import com.twd.flutter.android.constant.ConstantVeriables;
import com.twd.flutter.android.constant.RandomString;
import com.twd.flutter.android.dao.LoginDao;
import com.twd.flutter.android.serviceInterface.LoginServiceInterface;
import com.twd.flutter.both.connection.DBConnection;

public class LoginService implements LoginServiceInterface{
	LoginDao login=new LoginDao();
	@Override
	public LoginResponse appLogin(JSONObject reqObj, String imei, String accessType, LoginResponse res) {
    
		
		try(Connection conn=DBConnection.getConnection())
		{
			String mobileno=reqObj.getString("mobileno");
	  	  
			res=login.verifyLogin(mobileno,accessType,conn);
			
			
			if(res.isSuccess())
			{
				String randamstring=RandomString.generateRandomString();
				res.setUniquestring(randamstring);
				res=login.checkUserHistory(accessType,res,conn);
				if(res.isSuccess())
				{
					res=login.updateImeiAndRandamString(accessType,res,imei,conn);
				}else
				{
					res=login.saveimeiAndRandamString(accessType,res,imei,conn);
				}
				if(res.isSuccess())
				{
					res=login.generateOTP(accessType,res,conn);
				}
			}
			
		} catch (Exception e) {
			res=(LoginResponse) AppConstant.ConfigureErrorMessage(res,"verify user " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return res;
	
	}
	@Override
	public MainResponse verifyOTP(MainResponse otpRes, JSONObject reqObj, String imei, String ramdomstring,
			String chit_boy_id, String accessType) {
	
		 try(Connection conn=DBConnection.getConnection())
		{
		 
		 otpRes=login.verifyUser(otpRes,chit_boy_id,ramdomstring,imei,accessType,conn);
		
		 if(otpRes.isSuccess())
			 otpRes=login.verifyOTP(otpRes,reqObj.getString("otp"),conn);
		
	  }catch (Exception e) {
			otpRes=(LoginResponse) AppConstant.ConfigureErrorMessage(otpRes,"otp verify " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return otpRes;
	}
		
	@Override
	public MainResponse resendOTP(MainResponse resendOTPRes, JSONObject reqObj, String imei, String ramdomstring,
			String chit_boy_id, String accessType) {
		try(Connection conn=DBConnection.getConnection())
		{
			resendOTPRes=login.verifyUser(resendOTPRes,chit_boy_id,ramdomstring,imei,accessType,conn);
			if(resendOTPRes.isSuccess())
			{
				String mobileno=reqObj.getString("mobileno");
				LoginResponse loginrRes=new LoginResponse();
				loginrRes.setMobileno(mobileno);
				loginrRes=login.generateOTP(accessType,loginrRes, conn);
				if(!loginrRes.isSuccess())
				{
					resendOTPRes.setSe(loginrRes.getSe());
					resendOTPRes.setSuccess(false);
				}
			}
	}catch (Exception e) {
			resendOTPRes=(LoginResponse) AppConstant.ConfigureErrorMessage(resendOTPRes,"resend otp " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return resendOTPRes;	
		}
	@Override
	public MainResponse checkAppUpdate(String versionId, String accessType,MainResponse appversionRes) {
		try(Connection conn=DBConnection.getConnection())
		{
			appversionRes=login.checkAppUpdate(appversionRes,versionId,accessType,conn);
		}catch (Exception e) {
			appversionRes=(LoginResponse) AppConstant.ConfigureErrorMessage(appversionRes,"app version " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return appversionRes;	
	
	}
	@Override
	public MainResponse verifyUser(MainResponse actionResponse, String chit_boy_id, String ramdomstring, String imei,
			String accessType) {
		try(Connection conn=DBConnection.getConnection())
		{
			actionResponse=login.verifyUser(actionResponse,chit_boy_id,ramdomstring,imei,accessType,conn);
		}catch (Exception e) {
			actionResponse=(LoginResponse) AppConstant.ConfigureErrorMessage(actionResponse,"verify user " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		}
		return actionResponse;
	}

	
	
	
}
