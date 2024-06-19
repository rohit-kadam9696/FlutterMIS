package com.twd.flutter.android.serviceInterface;

import org.json.JSONObject;

import com.twd.flutter.android.bean.LoginResponse;
import com.twd.flutter.android.bean.MasterDataResponse;
import com.twd.flutter.android.bean.ShiftwiseCrushingResponse;
import com.twd.flutter.android.bean.VarietyWiseCrushingResponse;
import com.twd.flutter.android.bean.VehicleTypeWarCrushingResponse;
import com.twd.flutter.android.bean.CaneYardCrushingResponse;

import com.twd.flutter.android.bean.CrushingResponse;
import com.twd.flutter.android.bean.GatWiseCrushingResponse;
import com.twd.flutter.android.bean.HangamWiseCrushingResponse;
import com.twd.flutter.android.bean.HourlyCrushingReponse;


public interface CrushingServiceInterface {

	ShiftwiseCrushingResponse crushingReportshiftwise(JSONObject reqObj, ShiftwiseCrushingResponse master,
				String yearCode, String date);

	CaneYardCrushingResponse caneyardres(JSONObject reqObj, CaneYardCrushingResponse caneyardres,
		 String yearCode, String date);

	HourlyCrushingReponse hourlyRes(JSONObject reqObj, HourlyCrushingReponse hourlyRes, String yearCode,
			String date);


	GatWiseCrushingResponse gatWiseResponse(JSONObject reqObj, GatWiseCrushingResponse gatResponse, String yearCode,
			String date);

	HangamWiseCrushingResponse hangamWiseResponse(JSONObject reqObj, HangamWiseCrushingResponse hangamResponse,
			String yearCode, String date);

	VarietyWiseCrushingResponse varietyWiseResponse(JSONObject reqObj, VarietyWiseCrushingResponse varietyResponse,
			String yearCode, String date);

	CrushingResponse crushing(JSONObject reqObj, String imei, String accessType, CrushingResponse crushingResponse,
			String yearCode,String date);

	VehicleTypeWarCrushingResponse vehicleWarResponse(JSONObject reqObj,
			VehicleTypeWarCrushingResponse vehicleWarResponse, String date);


}
