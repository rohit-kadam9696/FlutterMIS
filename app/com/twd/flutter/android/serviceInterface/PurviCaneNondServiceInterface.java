package com.twd.flutter.android.serviceInterface;

import org.json.JSONObject;

import com.twd.flutter.android.bean.GatHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthVarietyCurrentCaneResponse;
import com.twd.flutter.android.bean.PurviCaneNondVhangamResponse;

public interface PurviCaneNondServiceInterface {

	
	PurviCaneNondVhangamResponse PurviVarietyHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			PurviCaneNondVhangamResponse vhResponse);

	GatHangamCurrentCaneResponse PurviGatHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			GatHangamCurrentCaneResponse ghResponse);

	MonthHangamCurrentCaneResponse monthHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			MonthHangamCurrentCaneResponse mhResponse);

	MonthVarietyCurrentCaneResponse pudhilmonthVarietyCaneNond(JSONObject reqObj, String imei, String accessType,
			MonthVarietyCurrentCaneResponse mvResponse);

}
