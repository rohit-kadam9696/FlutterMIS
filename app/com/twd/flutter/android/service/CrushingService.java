package com.twd.flutter.android.service;

import java.sql.Connection;

import org.json.JSONObject;

import com.twd.flutter.android.bean.CaneYardCrushingResponse;

import com.twd.flutter.android.bean.CrushingResponse;
import com.twd.flutter.android.bean.GatWiseCrushingResponse;
import com.twd.flutter.android.bean.HangamWiseCrushingResponse;
import com.twd.flutter.android.bean.HourlyCrushingReponse;
import com.twd.flutter.android.bean.MasterDataResponse;
import com.twd.flutter.android.bean.ShiftwiseCrushingResponse;
import com.twd.flutter.android.bean.VarietyWiseCrushingResponse;
import com.twd.flutter.android.bean.VehicleTypeWarCrushingResponse;
import com.twd.flutter.android.constant.AppConstant;
import com.twd.flutter.android.constant.Constant;
import com.twd.flutter.android.constant.ConstantVeriables;
import com.twd.flutter.android.dao.CrushingDao;
import com.twd.flutter.android.dao.LoginDao;
import com.twd.flutter.android.serviceInterface.CrushingServiceInterface;
import com.twd.flutter.both.connection.DBConnection;
import com.twd.flutter.both.connection.DBConnection;
public class CrushingService implements CrushingServiceInterface{
	LoginDao login=new LoginDao();
	CrushingDao crushDao=new CrushingDao();
	
	@Override
	public ShiftwiseCrushingResponse crushingReportshiftwise(JSONObject reqObj,
			ShiftwiseCrushingResponse masterResponse, String yearCode,String date) {
		try(Connection conn=DBConnection.getConnection()) {
			
				
			masterResponse= crushDao.shiftWiseCrushingReport(masterResponse, conn, date, yearCode);
		
	}
		
		catch(Exception e)
		{
			masterResponse=(ShiftwiseCrushingResponse) AppConstant.ConfigureErrorMessage(masterResponse,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		
		}
		
		
		return masterResponse;
	}

	@Override
	public CaneYardCrushingResponse caneyardres(JSONObject reqObj, CaneYardCrushingResponse caneyardres,
			String yearCode, String date) {
		try(Connection conn=DBConnection.getConnection()) {
			
			
			caneyardres= crushDao.caneYardShilak(caneyardres, conn, date, yearCode);
		
	}
		
		catch(Exception e)
		{
			caneyardres=(CaneYardCrushingResponse) AppConstant.ConfigureErrorMessage(caneyardres,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		
		}
		
		
		return caneyardres;
	}

	@Override
	public HourlyCrushingReponse hourlyRes(JSONObject reqObj, HourlyCrushingReponse hourlyRes, String yearCode,
			String date) {
		
try(Connection conn=DBConnection.getConnection()) {
			
			
	hourlyRes= crushDao.hourlyCrushing(hourlyRes, conn, date, yearCode);
		
	}
		
		catch(Exception e)
		{
			hourlyRes=(HourlyCrushingReponse) AppConstant.ConfigureErrorMessage(hourlyRes,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		
		}
		
		
		return hourlyRes;
		
		
		
	}

	@Override
	public GatWiseCrushingResponse gatWiseResponse(JSONObject reqObj, GatWiseCrushingResponse gatResponse,
			String yearCode, String date) {
		try(Connection conn=DBConnection.getConnection()) {
			
			
			gatResponse= crushDao.gatWiseCrushingReport(gatResponse, conn, date, yearCode);
				
			}
				
				catch(Exception e)
				{
					gatResponse=(GatWiseCrushingResponse) AppConstant.ConfigureErrorMessage(gatResponse,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
					e.printStackTrace();
				
				}
				
				
				return gatResponse;
				
				
	}

	@Override
	public HangamWiseCrushingResponse hangamWiseResponse(JSONObject reqObj, HangamWiseCrushingResponse hangamResponse,
			String yearCode, String date) {
	try(Connection conn=DBConnection.getConnection()) {
			
			
		hangamResponse= crushDao.hangamWiseCrushingReport(hangamResponse, conn, date, yearCode);
				
			}
				
				catch(Exception e)
				{
					hangamResponse=(HangamWiseCrushingResponse) AppConstant.ConfigureErrorMessage(hangamResponse,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
					e.printStackTrace();
				
				}
				
				
				return hangamResponse;
				
		
	}

	@Override
	public VarietyWiseCrushingResponse varietyWiseResponse(JSONObject reqObj,
			VarietyWiseCrushingResponse varietyResponse, String yearCode, String date) {
		try(Connection conn=DBConnection.getConnection()) {
			
			
			varietyResponse= crushDao.varietyWiseCrushingReport(varietyResponse, conn, date, yearCode);
					
				}
					
					catch(Exception e)
					{
						varietyResponse=(VarietyWiseCrushingResponse) AppConstant.ConfigureErrorMessage(varietyResponse,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
						e.printStackTrace();
					
					}
					
					
					return varietyResponse;
				
	}

	@Override
	public CrushingResponse crushing(JSONObject reqObj, String imei, String accessType,
			CrushingResponse crushingResponse, String yearCode,String date) {
		
		
            try(Connection conn=DBConnection.getConnection()) {
			
			
            	crushingResponse= crushDao.crushing(conn, date, yearCode);
					
				}
					
					catch(Exception e)
					{
						crushingResponse=(CrushingResponse) AppConstant.ConfigureErrorMessage(crushingResponse,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
						e.printStackTrace();
					
					}
					
					
					return crushingResponse;
				
		
		
		
		
	}

	@Override
	public VehicleTypeWarCrushingResponse vehicleWarResponse(JSONObject reqObj,
			VehicleTypeWarCrushingResponse vehicleWarResponse, String date) {
		 try(Connection conn=DBConnection.getConnection()) {
				
				
			 vehicleWarResponse= crushDao.vehicleWarcReport(conn, date,vehicleWarResponse);
					
				}
					
					catch(Exception e)
					{
						vehicleWarResponse=(VehicleTypeWarCrushingResponse) AppConstant.ConfigureErrorMessage(vehicleWarResponse,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
						e.printStackTrace();
					
					}
					
					
					return vehicleWarResponse;
				
		
	}

	

	
	
	
}
	

	
