package com.twd.flutter.android.service;

import java.sql.Connection;

import org.json.JSONObject;

import com.twd.flutter.android.bean.ShiftwiseCrushingResponse;
import com.twd.flutter.android.bean.SubSubstanceResponse;
import com.twd.flutter.android.bean.SugarSaleResponse;
import com.twd.flutter.android.bean.SugarStockResponse;
import com.twd.flutter.android.bean.VikriSatha1Response;
import com.twd.flutter.android.constant.AppConstant;
import com.twd.flutter.android.constant.ConstantVeriables;
import com.twd.flutter.android.dao.VikriSathaDao;
import com.twd.flutter.android.serviceInterface.VikriSathaInterface;
import com.twd.flutter.both.connection.DBConnection;

public class VikriSathaService implements VikriSathaInterface {
	VikriSathaDao vsdao=new VikriSathaDao();

	public VikriSatha1Response vikriSathaReport1(JSONObject reqObj, String imei, String accessType,
			VikriSatha1Response vsResponse, String yearCode, String date) {
		try(Connection conn=DBConnection.getConnection()) {
			
			
			vsResponse= vsdao.vikriSathaReport1(vsResponse, conn, date, yearCode);
		
	}
		
		catch(Exception e)
		{
			vsResponse=(VikriSatha1Response) AppConstant.ConfigureErrorMessage(vsResponse,"Load crushingReport By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		
		}
		
		
		return vsResponse;

	}

	public SugarSaleResponse sugarSaleReport(JSONObject reqObj, String imei, String accessType,
			SugarSaleResponse sugarSaleResponse, String yearCode, String date) {
try(Connection conn=DBConnection.getConnection()) {
	sugarSaleResponse= vsdao.sugarSaleReport(sugarSaleResponse, conn, date, yearCode);
		
	}
		
		catch(Exception e)
		{
			sugarSaleResponse=(SugarSaleResponse) AppConstant.ConfigureErrorMessage(sugarSaleResponse,"Load SugarSale  By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
			e.printStackTrace();
		
		}
		
		
		return sugarSaleResponse;

	}

	public SugarStockResponse sugarStockReport(JSONObject reqObj, String imei, String accessType,
			SugarStockResponse sugarStockResponse, String yearCode, String date) {
		try(Connection conn=DBConnection.getConnection()) {
			sugarStockResponse= vsdao.sugarStockReport(sugarStockResponse, conn, date, yearCode);
				
			   }
              catch(Exception e)
				{
            	  sugarStockResponse=(SugarStockResponse) AppConstant.ConfigureErrorMessage(sugarStockResponse,"Load SugarStock  By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
					e.printStackTrace();
				}
			return sugarStockResponse;

	}

	public SubSubstanceResponse substanceSaleReport(JSONObject reqObj, String imei, String accessType,
			SubSubstanceResponse substanceSaleResponse, String yearCode, String date) {
		try(Connection conn=DBConnection.getConnection()) {
			substanceSaleResponse= vsdao.substanceSaleReport(substanceSaleResponse, conn, date, yearCode);
				
			   }
              catch(Exception e)
				{
            	  substanceSaleResponse=(SubSubstanceResponse) AppConstant.ConfigureErrorMessage(substanceSaleResponse,"Load SugarStock  By Date " + e.getMessage(), ConstantVeriables.ERROR_006,true);
					e.printStackTrace();
				}
			return substanceSaleResponse;


	}

}
