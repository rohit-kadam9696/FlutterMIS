package com.twd.flutter.android.service;

import java.sql.Connection;

import org.json.JSONObject;

import com.twd.flutter.android.bean.GatHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthVarietyCurrentCaneResponse;
import com.twd.flutter.android.bean.PurviCaneNondVhangamResponse;
import com.twd.flutter.android.bean.VarietyHangamCaneResponse;
import com.twd.flutter.android.constant.AppConstant;
import com.twd.flutter.android.constant.ConstantVeriables;
import com.twd.flutter.android.dao.PurviCaneNondDao;
import com.twd.flutter.android.dao.VhangamCaneNondDao;
import com.twd.flutter.android.serviceInterface.CaneNondServiceInterface;
import com.twd.flutter.android.serviceInterface.PurviCaneNondServiceInterface;
import com.twd.flutter.both.connection.DBConnection;

public class PurviCaneNondService implements PurviCaneNondServiceInterface {
	PurviCaneNondDao vhdao=new PurviCaneNondDao();
	@Override
	public PurviCaneNondVhangamResponse PurviVarietyHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			PurviCaneNondVhangamResponse vhResponse) {
		
		 try(Connection conn=DBConnection.getConnection()) {
	            vhResponse= vhdao.purviVarietyHangamCaneNond(vhResponse, conn);
			}
			catch(Exception e)
			    {
			      vhResponse=(PurviCaneNondVhangamResponse) AppConstant.ConfigureErrorMessage(vhResponse,"Load VarietyHangam By before current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return vhResponse;

	}
	@Override
	public GatHangamCurrentCaneResponse PurviGatHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			GatHangamCurrentCaneResponse ghResponse) {
		 try(Connection conn=DBConnection.getConnection()) {
			 ghResponse= vhdao.purviGatHangamCaneNond(ghResponse, conn);
			}
			catch(Exception e)
			    {
				ghResponse=(GatHangamCurrentCaneResponse) AppConstant.ConfigureErrorMessage(ghResponse,"Load VarietyHangam By before current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return ghResponse;

	}
	@Override
	public MonthHangamCurrentCaneResponse monthHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			MonthHangamCurrentCaneResponse mhResponse) {
		 try(Connection conn=DBConnection.getConnection()) {
			 mhResponse= vhdao.purviGatHangamCaneNond(mhResponse, conn);
			}
			catch(Exception e)
			    {
				mhResponse=(MonthHangamCurrentCaneResponse) AppConstant.ConfigureErrorMessage(mhResponse,"Load VarietyHangam By before current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return mhResponse;


	}
	@Override
	public MonthVarietyCurrentCaneResponse pudhilmonthVarietyCaneNond(JSONObject reqObj, String imei, String accessType,
			MonthVarietyCurrentCaneResponse mvResponse) {
		 try(Connection conn=DBConnection.getConnection()) {
			 mvResponse= vhdao.pudhilMonthVarietyCaneNond(mvResponse, conn);
			}
			catch(Exception e)
			    {
				mvResponse=(MonthVarietyCurrentCaneResponse) AppConstant.ConfigureErrorMessage(mvResponse,"Load VarietyHangam By before current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return mvResponse;



	}


}
