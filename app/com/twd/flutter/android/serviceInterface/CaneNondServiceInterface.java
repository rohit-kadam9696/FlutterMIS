package com.twd.flutter.android.serviceInterface;

import org.json.JSONObject;

import com.twd.flutter.android.bean.GatHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthVarietyCurrentCaneResponse;
import com.twd.flutter.android.bean.VarietyHangamCaneResponse;

public interface CaneNondServiceInterface {
	
	

	VarietyHangamCaneResponse varietyHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			VarietyHangamCaneResponse vhResponse);

	GatHangamCurrentCaneResponse gatHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			GatHangamCurrentCaneResponse ghResponse);

	MonthHangamCurrentCaneResponse monthHangamCaneNond(JSONObject reqObj, String imei, String accessType,
			MonthHangamCurrentCaneResponse mhResponse);

	MonthVarietyCurrentCaneResponse monthVarietyCaneNond(JSONObject reqObj, String imei, String accessType,
			MonthVarietyCurrentCaneResponse mvResponse);

}
