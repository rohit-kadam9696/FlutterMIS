package com.twd.flutter.android.serviceInterface;

import org.json.JSONObject;

import com.twd.flutter.android.bean.BheavyResponse;
import com.twd.flutter.android.bean.CheavyResponse;
import com.twd.flutter.android.bean.ProductionResponse;
import com.twd.flutter.android.bean.SubSubstanceProductionResp;

public interface ProductionServiceInterface {

	ProductionResponse sugarProduction(JSONObject reqObj, String imei, String accessType,
			ProductionResponse productionResponse, String yearCode, String date);

	SubSubstanceProductionResp subSubstanceProduction(JSONObject reqObj, String imei, String accessType,
			SubSubstanceProductionResp substanceRes, String yearCode, String date);

	BheavyResponse bheavyProductionDetails(JSONObject reqObj, String imei, String accessType,
			BheavyResponse bheavyResponse, String yearCode, String date);

	CheavyResponse cheavyProductionDetails(JSONObject reqObj, String imei, String accessType,
			CheavyResponse cheavyResponse, String yearCode, String date);

	
}
