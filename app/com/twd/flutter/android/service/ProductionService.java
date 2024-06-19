package com.twd.flutter.android.service;

import java.sql.Connection;

import org.json.JSONObject;

import com.twd.flutter.android.bean.BheavyResponse;
import com.twd.flutter.android.bean.CheavyResponse;
import com.twd.flutter.android.bean.ProductionResponse;
import com.twd.flutter.android.bean.SubSubstanceProductionResp;
import com.twd.flutter.android.constant.AppConstant;
import com.twd.flutter.android.constant.ConstantVeriables;
import com.twd.flutter.android.dao.ProductionDao;
import com.twd.flutter.android.serviceInterface.ProductionServiceInterface;
import com.twd.flutter.both.connection.DBConnection;

public class ProductionService implements ProductionServiceInterface {
	ProductionDao vhdao=new ProductionDao();

	public ProductionResponse sugarProduction(JSONObject reqObj, String imei, String accessType,
			ProductionResponse productionResponse, String yearCode, String date) {
		// TODO Auto-generated method stub
		 try(Connection conn=DBConnection.getConnection()) {
			 productionResponse= vhdao.sugarProduction(productionResponse, conn,date);
			}
			catch(Exception e)
			    {
				productionResponse=(ProductionResponse) AppConstant.ConfigureErrorMessage(productionResponse,"Load VarietyHangam By before current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return productionResponse;

	}

	@Override
	public SubSubstanceProductionResp subSubstanceProduction(JSONObject reqObj, String imei, String accessType,
			SubSubstanceProductionResp substanceRes, String yearCode, String date) {
		 try(Connection conn=DBConnection.getConnection()) {
			 substanceRes= vhdao.subSubstanceProduction(substanceRes, conn, date);
			 
			}
			catch(Exception e)
			    {
				substanceRes=(SubSubstanceProductionResp) AppConstant.ConfigureErrorMessage(substanceRes,"Load VarietyHangam By before current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return substanceRes;

	}

	@Override
	public BheavyResponse bheavyProductionDetails(JSONObject reqObj, String imei, String accessType,
			BheavyResponse bheavyResponse, String yearCode, String date) {

		 try(Connection conn=DBConnection.getConnection()) {
			 bheavyResponse= vhdao.bheavyProduction(bheavyResponse, conn, date);
			 
			}
			catch(Exception e)
			    {
				bheavyResponse=(BheavyResponse) AppConstant.ConfigureErrorMessage(bheavyResponse,"Load Heavy Production Data By before current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return bheavyResponse;

	}

	@Override
	public CheavyResponse cheavyProductionDetails(JSONObject reqObj, String imei, String accessType,
			CheavyResponse cheavyResponse, String yearCode, String date) {
		 try(Connection conn=DBConnection.getConnection()) {
			 cheavyResponse= vhdao.cheavyProduction(cheavyResponse, conn, date);
			 
			}
			catch(Exception e)
			    {
				cheavyResponse=(CheavyResponse) AppConstant.ConfigureErrorMessage(cheavyResponse,"Load Heavy Production Data By before current data " + e.getMessage(), ConstantVeriables.ERROR_006,true);
				  e.printStackTrace();
				}
		   return cheavyResponse;


	}

	


}
