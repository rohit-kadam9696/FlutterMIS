package com.twd.flutter.android.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.twd.flutter.android.bean.BheavyResponse;
import com.twd.flutter.android.bean.BheavyResponse.BHeavyProductionData;
import com.twd.flutter.android.bean.CheavyResponse;
import com.twd.flutter.android.bean.CheavyResponse.CHeavyProductionData;
import com.twd.flutter.android.bean.ProductionResponse;
import com.twd.flutter.android.bean.ProductionResponse.ProductionSugarData;
import com.twd.flutter.android.bean.ServerError;
import com.twd.flutter.android.bean.SubSubstanceProductionResp;
import com.twd.flutter.android.bean.SubSubstanceProductionResp.ProductionSubSubstanceData;
import com.twd.flutter.android.bean.VarietyHangamCaneResponse;
import com.twd.flutter.android.bean.VarietyHangamCaneResponse.VarietyHangamCaneData;
import com.twd.flutter.android.constant.ConstantVeriables;

public class ProductionDao {
	 public ProductionResponse sugarProduction(ProductionResponse proResponse, Connection conn, String date) {
	        ProductionResponse proSugarResponse = new ProductionResponse();
	        Map<String, ProductionSugarData> productionSugarBeanMap = new HashMap<>();
	        int i = 1;
	        try {
	            String sql = "SELECT t.RESOURCENAME, t.VALUE1, t.VALUE2 FROM androidapp.mis_pre_processed t WHERE t.TRANS_DATE = ? AND t.FLAG = 71 AND NOT REGEXP_LIKE(t.RESOURCENAME, ?) ORDER BY t.SERIAL_NO";

	            try (PreparedStatement pst = conn.prepareStatement(sql)) {
	                pst.setString(1, date);
	                pst.setString(2, "^" + date + ".*");
	                try (ResultSet rs = pst.executeQuery()) {
	                    
	                    while (rs.next()) {
	                        String resourceName = rs.getString("RESOURCENAME");
	                       
	                        double value1 = rs.getDouble("VALUE1");
	                        double value2 = rs.getDouble("VALUE2");

	                        ProductionSugarData productionSugarData = new ProductionSugarData();
	                        productionSugarData.setResourceName(resourceName);
	                        productionSugarData.setValue1(value1);
	                        productionSugarData.setValue2(value2);

	                        productionSugarBeanMap.put(resourceName, productionSugarData);
	                    }
	                }
	            }

	            proSugarResponse.setProductionSugarBeanMap(productionSugarBeanMap);
	            proSugarResponse.setSuccess(true);

	        } catch (SQLException e) {
	            proResponse.setSuccess(false);
	            ServerError error = new ServerError();
	            error.setError(ConstantVeriables.ERROR_006);
	            error.setMsg("Crushing information not found: " + e.getMessage());
	            proResponse.setSe(error);
	            e.printStackTrace(); // Consider logging the exception
	        }

	        return proSugarResponse;
	    }

	 public SubSubstanceProductionResp subSubstanceProduction(SubSubstanceProductionResp substanceRes, Connection conn, String date) {
		    SubSubstanceProductionResp proSubstanceResponse = new SubSubstanceProductionResp();
		    Map<String, ProductionSubSubstanceData> productionBeanMap = new HashMap<>();

		    try {
		        String sql = "SELECT t.RESOURCENAME, t.VALUE1, t.VALUE2 FROM androidapp.mis_pre_processed t WHERE t.TRANS_DATE=? AND t.FLAG=72 ORDER BY t.SERIAL_NO";

		        try (PreparedStatement pst = conn.prepareStatement(sql)) {
		            pst.setString(1, date);

		            try (ResultSet rs = pst.executeQuery()) {
		                while (rs.next()) {
		                    String resourceName = rs.getString("RESOURCENAME");
		                    double value1 = rs.getDouble("VALUE1");
		                    double value2 = rs.getDouble("VALUE2");

		                    ProductionSubSubstanceData productionSubstanceData = new ProductionSubSubstanceData();
		                    productionSubstanceData.setResourceName(resourceName);
		                    productionSubstanceData.setValue1(value1);
		                    productionSubstanceData.setValue2(value2);

		                    productionBeanMap.put(resourceName, productionSubstanceData);
		                }
		            }
		        }
//		        if (productionBeanMap.isEmpty()) {
//		            System.out.println("ResultSet is empty");
//		            proSubstanceResponse.setSuccess(false);
//		            return proSubstanceResponse;
//		        }

		        proSubstanceResponse.setProductionSubSubstanceBeanMap(productionBeanMap);
		        proSubstanceResponse.setSuccess(true);

		    } catch (SQLException e) {
		        substanceRes.setSuccess(false);
		        ServerError error = new ServerError();
		        error.setError(ConstantVeriables.ERROR_006);
		        error.setMsg("Crushing information not found: " + e.getMessage());
		        substanceRes.setSe(error);
		        e.printStackTrace(); // Log the exception
		    }

		    return proSubstanceResponse;
		}
	 public BheavyResponse bheavyProduction(BheavyResponse bheavyResponse, Connection conn, String date) {
		  
		    BheavyResponse heavyResponse = new BheavyResponse();
		    Map<String, BHeavyProductionData> heavyBeanMap = new HashMap<>();

		    try {
		        String sql = "SELECT t.RESOURCENAME, t.VALUE1, t.VALUE2 FROM androidapp.mis_pre_processed t WHERE t.TRANS_DATE=? AND t.FLAG=73 ORDER BY t.SERIAL_NO";

		        try (PreparedStatement pst = conn.prepareStatement(sql)) {
		            pst.setString(1, date);

		            try (ResultSet rs = pst.executeQuery()) {
		                while (rs.next()) {
		                    String resourceName = rs.getString("RESOURCENAME");
		                    double value1 = rs.getDouble("VALUE1");
		                    double value2 = rs.getDouble("VALUE2");

		                    BHeavyProductionData bheavyData = new BHeavyProductionData();
		                    bheavyData.setResourceName(resourceName);
		                    bheavyData.setValue1(value1);
		                    bheavyData.setValue2(value2);

		                    heavyBeanMap.put(resourceName, bheavyData);
		                }
		            }
		        }

		        heavyResponse.setBheavyProductionBeanMap(heavyBeanMap);
		        heavyResponse.setSuccess(true);

		    } catch (SQLException e) {
		        bheavyResponse.setSuccess(false);
		        ServerError error = new ServerError();
		        error.setError(ConstantVeriables.ERROR_006);
		        error.setMsg("Bheavy Product information not found: " + e.getMessage());
		        bheavyResponse.setSe(error);
		        e.printStackTrace(); // Log the exception
		    }

		    return heavyResponse;
		}

	public CheavyResponse cheavyProduction(CheavyResponse cheavyResponse, Connection conn, String date) {
		CheavyResponse cpheavyResponse = new CheavyResponse();
		    Map<String, CHeavyProductionData> cheavyBeanMap = new HashMap<>();

		    try {
		        String sql = "SELECT t.RESOURCENAME, t.VALUE1, t.VALUE2 FROM androidapp.mis_pre_processed t WHERE t.TRANS_DATE=? AND t.FLAG=74 ORDER BY t.SERIAL_NO";

		        try (PreparedStatement pst = conn.prepareStatement(sql)) {
		            pst.setString(1, date);

		            try (ResultSet rs = pst.executeQuery()) {
		                while (rs.next()) {
		                    String resourceName = rs.getString("RESOURCENAME");
		                    double value1 = rs.getDouble("VALUE1");
		                    double value2 = rs.getDouble("VALUE2");

		                    CHeavyProductionData cheavyData = new CHeavyProductionData();
		                    cheavyData.setResourceName(resourceName);
		                    cheavyData.setValue1(value1);
		                    cheavyData.setValue2(value2);

		                    cheavyBeanMap.put(resourceName, cheavyData);
		                }
		            }
		        }

		        cpheavyResponse.setCheavyProductionBeanMap(cheavyBeanMap);
		        cpheavyResponse.setSuccess(true);

		    } catch (SQLException e) {
		    	cheavyResponse.setSuccess(false);
		        ServerError error = new ServerError();
		        error.setError(ConstantVeriables.ERROR_006);
		        error.setMsg("Cheavy Product information not found: " + e.getMessage());
		        cheavyResponse.setSe(error);
		        e.printStackTrace(); // Log the exception
		    }

		    return cpheavyResponse;

	}


			}
	
