package com.twd.flutter.android.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.twd.flutter.android.bean.GatHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.PurviCaneNondVhangamResponse;
import com.twd.flutter.android.bean.PurviCaneNondVhangamResponse.PurviVarietyHangamCaneData;
import com.twd.flutter.android.bean.ServerError;
import com.twd.flutter.android.bean.VarietyHangamCaneResponse;
import com.twd.flutter.android.bean.GatHangamCurrentCaneResponse.GatHangamCaneData;
import com.twd.flutter.android.bean.MonthHangamCurrentCaneResponse.MonthHangamCurrentData;
import com.twd.flutter.android.bean.MonthVarietyCurrentCaneResponse.MonthVarietyCurrentData;
import com.twd.flutter.android.bean.MonthVarietyCurrentCaneResponse;
import com.twd.flutter.android.bean.MonthHangamCurrentCaneResponse;
import com.twd.flutter.android.bean.VarietyHangamCaneResponse.VarietyHangamCaneData;
import com.twd.flutter.android.constant.ConstantVeriables;

public class PurviCaneNondDao {

	public PurviCaneNondVhangamResponse purviVarietyHangamCaneNond(PurviCaneNondVhangamResponse vhResponse,
			Connection conn) {
		
		PurviCaneNondVhangamResponse pvhCaneResponse = new PurviCaneNondVhangamResponse();
		    Map<String, PurviVarietyHangamCaneData> pvhCaneCrushingMap = new HashMap<>();

		    try {
		        String sql = "select t.ResourceName,t.Value1,t.Value2,t.Value3,t.Value4,t.Value5 from androidapp.agri_mis_1_u t where t.flag=1" ; 
		        		
		        try (PreparedStatement pst = conn.prepareStatement(sql)) {

		            try (ResultSet rs = pst.executeQuery()) {
		                while (rs.next()) {
		                    String resourceName = rs.getString("RESOURCENAME");
	                     
		                    double value1 = rs.getDouble("Value1");
		                    double value2 = rs.getDouble("Value2");
		                    double value3 = rs.getDouble("Value3");
		                    double value4 = rs.getDouble("Value4");
		                    double value5 = rs.getDouble("Value5");
		                    PurviCaneNondVhangamResponse.PurviVarietyHangamCaneData pvhCaneCrushingData = pvhCaneCrushingMap.get(resourceName);
	                 	  
		                    if (pvhCaneCrushingData==null) {
		                    	pvhCaneCrushingData = new PurviCaneNondVhangamResponse.PurviVarietyHangamCaneData();
		                    	pvhCaneCrushingData.setResourceName(resourceName);
		                    	pvhCaneCrushingData.setValue1(value1);
		                    	pvhCaneCrushingData.setValue2(value2);
		                    	pvhCaneCrushingData.setValue3(value3);
		                    	pvhCaneCrushingData.setValue4(value4);
		                    	pvhCaneCrushingData.setValue5(value5);

		                        pvhCaneCrushingMap.put(resourceName, pvhCaneCrushingData);
		                    } else {
		                    	System.out.println("Key already exists for resourceName: " + resourceName);
		                    }
		                }
		            }
		        }

		        pvhCaneResponse.setPurviVarietyHangamCaneBeanMap(pvhCaneCrushingMap);
		        pvhCaneResponse.setSuccess(true);

		    } catch (SQLException e) {
		        vhResponse.setSuccess(false);
		        ServerError error = new ServerError();
		        error.setError(ConstantVeriables.ERROR_006);
		        error.setMsg("Crushing information not found: " + e.getMessage());
		        vhResponse.setSe(error);
		        e.printStackTrace(); // Consider logging the exception
		    }

		    return pvhCaneResponse;

	}

	public GatHangamCurrentCaneResponse purviGatHangamCaneNond(GatHangamCurrentCaneResponse ghResponse,
			Connection conn) {
		GatHangamCurrentCaneResponse pghCaneResponse = new GatHangamCurrentCaneResponse();

		Map<String,GatHangamCaneData> pghCaneCrushingMap = new HashMap<>();

	    try {
	        String sql = "select t.ResourceName,t.Value1,t.Value2,t.Value3,t.Value4,t.Value5 from androidapp.agri_mis_1_u t where t.flag=2";
	        try (PreparedStatement pst = conn.prepareStatement(sql)) {

	            try (ResultSet rs = pst.executeQuery()) {
	                while (rs.next()) {
	                    String resourceName = rs.getString("RESOURCENAME");
                     
	                    double value1 = rs.getDouble("Value1");
	                    double value2 = rs.getDouble("Value2");
	                    double value3 = rs.getDouble("Value3");
	                    double value4 = rs.getDouble("Value4");
	                    double value5 = rs.getDouble("Value5");
	                    GatHangamCurrentCaneResponse.GatHangamCaneData pghCaneCrushingData = pghCaneCrushingMap.get(resourceName);
                 	  // VarietyHangamCaneResponse.VarietyHangamCaneData vhCaneCrushingData = vhCaneCrushingMap.get(resourceName);

	                    // Check if the key is present in the map
	                    if (pghCaneCrushingData==null) {
	                    	pghCaneCrushingData = new GatHangamCurrentCaneResponse.GatHangamCaneData();
	                    	pghCaneCrushingData.setResourceName(resourceName);
	                    	pghCaneCrushingData.setValue1(value1);
	                    	pghCaneCrushingData.setValue2(value2);
	                    	pghCaneCrushingData.setValue3(value3);
	                    	pghCaneCrushingData.setValue4(value4);
	                    	pghCaneCrushingData.setValue5(value5);

	                        pghCaneCrushingMap.put(resourceName, pghCaneCrushingData);
	                    } else {
	                    	System.out.println("Key already exists for resourceName: " + resourceName);
	                    }
	                }
	            }
	        }

	        pghCaneResponse.setGatHangamCaneBeanMap(pghCaneCrushingMap);
	       pghCaneResponse.setSuccess(true);

	    } catch (SQLException e) {
	        ghResponse.setSuccess(false);
	        ServerError error = new ServerError();
	        error.setError(ConstantVeriables.ERROR_006);
	        error.setMsg("Crushing information not found: " + e.getMessage());
	        ghResponse.setSe(error);
	        e.printStackTrace(); // Consider logging the exception
	    }

	    return pghCaneResponse;


	}

	public MonthHangamCurrentCaneResponse purviGatHangamCaneNond(MonthHangamCurrentCaneResponse mhResponse,
			Connection conn) {
		MonthHangamCurrentCaneResponse mhCaneResponse = new MonthHangamCurrentCaneResponse();
	    Map<String,MonthHangamCurrentData> mhCaneCrushingMap = new HashMap<>();

	    try {
	        String sql = "select t.ResourceName,t.Value1,t.Value2,t.Value3,t.Value4,t.Value5 from androidapp.agri_mis_1_u t where t.flag=33 order by t.ResourceName" ; 

	        try (PreparedStatement pst = conn.prepareStatement(sql)) {

	            try (ResultSet rs = pst.executeQuery()) {
	                while (rs.next()) {
	                    String resourceName = rs.getString("RESOURCENAME");
                     
	                    double value1 = rs.getDouble("Value1");
	                    double value2 = rs.getDouble("Value2");
	                    double value3 = rs.getDouble("Value3");
	                    double value4 = rs.getDouble("Value4");
	                    double value5 = rs.getDouble("Value5");
	                    MonthHangamCurrentCaneResponse.MonthHangamCurrentData mhCaneCrushingData = mhCaneCrushingMap.get(resourceName);
                 	  // VarietyHangamCaneResponse.VarietyHangamCaneData vhCaneCrushingData = vhCaneCrushingMap.get(resourceName);

	                    // Check if the key is present in the map
	                    if (mhCaneCrushingData==null) {
	                    	mhCaneCrushingData = new MonthHangamCurrentCaneResponse.MonthHangamCurrentData();
	                    	mhCaneCrushingData.setResourceName(resourceName);
	                    	mhCaneCrushingData.setValue1(value1);
	                    	mhCaneCrushingData.setValue2(value2);
	                    	mhCaneCrushingData.setValue3(value3);
	                    	mhCaneCrushingData.setValue4(value4);
	                    	mhCaneCrushingData.setValue5(value5);

	                        mhCaneCrushingMap.put(resourceName, mhCaneCrushingData);
	                    } else {
	                    	System.out.println("Key already exists for resourceName: " + resourceName);
	                    }
	                }
	            }
	        }

	        mhCaneResponse.setMonthHangamCaneBeanMap(mhCaneCrushingMap);
	       mhCaneResponse.setSuccess(true);

	    } catch (SQLException e) {
	        mhResponse.setSuccess(false);
	        ServerError error = new ServerError();
	        error.setError(ConstantVeriables.ERROR_006);
	        error.setMsg("Crushing information not found: " + e.getMessage());
	        mhResponse.setSe(error);
	        e.printStackTrace(); // Consider logging the exception
	    }

	    return mhCaneResponse;

	}

	public MonthVarietyCurrentCaneResponse pudhilMonthVarietyCaneNond(MonthVarietyCurrentCaneResponse mvResponse,
			Connection conn) {
	
		MonthVarietyCurrentCaneResponse mvCaneResponse = new MonthVarietyCurrentCaneResponse();
	    Map<String,MonthVarietyCurrentData> mvCaneCrushingMap = new HashMap<>();

	    try {
	        String sql = "select t.ResourceName,t.Value1,t.Value2,t.Value3,t.Value4,t.Value5 from androidapp.agri_mis_1_u t where t.flag=44";
	        try (PreparedStatement pst = conn.prepareStatement(sql)) {

	            try (ResultSet rs = pst.executeQuery()) {
	                while (rs.next()) {
	                    String resourceName = rs.getString("RESOURCENAME");
                     
	                    double value1 = rs.getDouble("Value1");
	                    double value2 = rs.getDouble("Value2");
	                    double value3 = rs.getDouble("Value3");
	                    double value4 = rs.getDouble("Value4");
	                    double value5 = rs.getDouble("Value5");
	                    MonthVarietyCurrentCaneResponse.MonthVarietyCurrentData mvCaneCrushingData = mvCaneCrushingMap.get(resourceName);
                 	  // VarietyHangamCaneResponse.VarietyHangamCaneData vhCaneCrushingData = vhCaneCrushingMap.get(resourceName);

	                    // Check if the key is present in the map
	                    if (mvCaneCrushingData==null) {
	                    	mvCaneCrushingData = new MonthVarietyCurrentCaneResponse.MonthVarietyCurrentData();
	                    	mvCaneCrushingData.setResourceName(resourceName);
	                    	mvCaneCrushingData.setValue1(value1);
	                    	mvCaneCrushingData.setValue2(value2);
	                    	mvCaneCrushingData.setValue3(value3);
	                    	mvCaneCrushingData.setValue4(value4);
	                    	mvCaneCrushingData.setValue5(value5);

	                        mvCaneCrushingMap.put(resourceName, mvCaneCrushingData);
	                    } else {
	                    	System.out.println("Key already exists for resourceName: " + resourceName);
	                    }
	                }
	            }
	        }

	        mvCaneResponse.setMonthVarietyCaneBeanMap(mvCaneCrushingMap);
	        mvCaneResponse.setSuccess(true);

	    } catch (SQLException e) {
	    	mvResponse.setSuccess(false);
	        ServerError error = new ServerError();
	        error.setError(ConstantVeriables.ERROR_006);
	        error.setMsg("Crushing information not found: " + e.getMessage());
	        mvResponse.setSe(error);
	        e.printStackTrace(); // Consider logging the exception
	    }

	    return mvCaneResponse;

	}

}
