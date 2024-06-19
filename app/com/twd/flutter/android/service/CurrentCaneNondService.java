package com.twd.flutter.android.service;

import java.sql.Connection;

import org.json.JSONObject;

import com.twd.flutter.android.bean.CaneYardCrushingResponse;
import com.twd.flutter.android.bean.GatHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthVarietyCurrentCaneResponse;
import com.twd.flutter.android.bean.VarietyHangamCaneResponse;
import com.twd.flutter.android.constant.AppConstant;
import com.twd.flutter.android.constant.ConstantVeriables;
import com.twd.flutter.android.dao.VhangamCaneNondDao;
import com.twd.flutter.android.serviceInterface.CaneNondServiceInterface;
import com.twd.flutter.both.connection.DBConnection;

public class CurrentCaneNondService implements CaneNondServiceInterface {
	VhangamCaneNondDao vhdao=new VhangamCaneNondDao();
	@Override
	public VarietyHangamCaneResponse varietyHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			VarietyHangamCaneResponse vhResponse) {
		
            try(Connection conn=DBConnection.getConnection()) {
            vhResponse= vhdao.varietyHangamCaneNond(vhResponse, conn);
		}
		catch(Exception e)
		    {
		      vhResponse=(VarietyHangamCaneResponse) AppConstant.ConfigureErrorMessage(vhResponse,"Load VarietyHangam By current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			  e.printStackTrace();
			}
	   return vhResponse;
	}
	@Override
	public GatHangamCurrentCaneResponse gatHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			GatHangamCurrentCaneResponse ghResponse) {
	       try(Connection conn=DBConnection.getConnection()) {
	    	   ghResponse= vhdao.gatHangamCaneNond(ghResponse, conn);
			}
			catch(Exception e)
			    {
				ghResponse=(GatHangamCurrentCaneResponse) AppConstant.ConfigureErrorMessage(ghResponse,"Load VarietyHangam By current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return ghResponse;
	}
	@Override
	public MonthHangamCurrentCaneResponse monthHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			MonthHangamCurrentCaneResponse mhResponse) {
		  try(Connection conn=DBConnection.getConnection()) {
			  mhResponse= vhdao.monthHangamCaneNond(mhResponse, conn);
			}
			catch(Exception e)
			    {
				mhResponse=(MonthHangamCurrentCaneResponse) AppConstant.ConfigureErrorMessage(mhResponse,"Load monthHangamCaneNond By current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return mhResponse;
	}
	@Override
	public MonthVarietyCurrentCaneResponse monthVarietyCaneNond(JSONObject reqObj, String imei, String accessType,
			MonthVarietyCurrentCaneResponse mvResponse) {
		try(Connection conn=DBConnection.getConnection()) {
			mvResponse= vhdao.monthVarietyCaneNond(mvResponse, conn);
			}
			catch(Exception e)
			    {
				mvResponse=(MonthVarietyCurrentCaneResponse) AppConstant.ConfigureErrorMessage(mvResponse,"Load MonthVarietyCaneNond By current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return mvResponse;
	}

}
