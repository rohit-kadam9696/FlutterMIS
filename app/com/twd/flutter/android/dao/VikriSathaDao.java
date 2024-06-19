package com.twd.flutter.android.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.twd.flutter.android.bean.MonthVarietyCurrentCaneResponse;
import com.twd.flutter.android.bean.ServerError;
import com.twd.flutter.android.bean.SubSubstanceResponse;
import com.twd.flutter.android.bean.SubSubstanceResponse.SubSubstanceData;
import com.twd.flutter.android.bean.SugarSaleResponse;
import com.twd.flutter.android.bean.SugarSaleResponse.SugarSaleData;
import com.twd.flutter.android.bean.SugarStockResponse;
import com.twd.flutter.android.bean.SugarStockResponse.SugarStockData;
import com.twd.flutter.android.bean.VikriSatha1Response;
import com.twd.flutter.android.bean.VikriSatha1Response.VikriSathaData;
import com.twd.flutter.android.bean.MonthVarietyCurrentCaneResponse.MonthVarietyCurrentData;
import com.twd.flutter.android.constant.ConstantVeriables;

public class VikriSathaDao {

	public VikriSatha1Response vikriSathaReport1(VikriSatha1Response vsResponse, Connection conn, String date,
			String yearCode) {
		int i=1;
		VikriSatha1Response vssugarRes = new VikriSatha1Response();
	    Map<String,VikriSathaData> vssugarMap = new HashMap<>();

	    try {
	        String sql = "select * from androidapp.mis_pre_processed_tbl t where t.trans_date=? and t.flag=80";
	        try (PreparedStatement pst = conn.prepareStatement(sql)) {
	        	pst.setString(i++,date);

	            try (ResultSet rs = pst.executeQuery()) {
	                while (rs.next()) {
	                    String resourceName = rs.getString("RESOURCENAME");
                     
	                  
	                    double value2 = rs.getDouble("Value2");
	                  
	                    VikriSatha1Response.VikriSathaData vsSugarData = vssugarMap.get(resourceName);
                 	  // VarietyHangamCaneResponse.VarietyHangamCaneData vhCaneCrushingData = vhCaneCrushingMap.get(resourceName);

	                    // Check if the key is present in the map
	                    if (vsSugarData==null) {
	                    	vsSugarData = new VikriSatha1Response.VikriSathaData();
	                    	vsSugarData.setResourceName(resourceName);
	                    	
	                    	vsSugarData.setValue2(value2);
	                    	
	                    	vssugarMap.put(resourceName, vsSugarData);
	                    } else {
	                    	System.out.println("Key already exists for resourceName: " + resourceName);
	                    }
	                }
	            }
	        }

	        vssugarRes.setVikriSathaSugarBeanMap(vssugarMap);
	        vssugarRes.setSuccess(true);

	    } catch (SQLException e) {
	    	vsResponse.setSuccess(false);
	        ServerError error = new ServerError();
	        error.setError(ConstantVeriables.ERROR_006);
	        error.setMsg("Crushing information not found: " + e.getMessage());
	        vsResponse.setSe(error);
	        e.printStackTrace(); // Consider logging the exception
	    }

	    return vssugarRes;

	}

	public SugarSaleResponse sugarSaleReport(SugarSaleResponse sugarSaleResponse, Connection conn, String date,
			String yearCode) {
		int i=1;
		SugarSaleResponse vssugarSaleRes = new SugarSaleResponse();
	    Map<String,SugarSaleData> sugarSaleMap = new HashMap<>();

	    try {
	        String sql = "select t.grade_name,t.today_qty,t.todate_qty,t.todate_avg_RATE from androidapp.web_sugar_sale t where t.rdate=?";
	        try (PreparedStatement pst = conn.prepareStatement(sql)) {
	        	pst.setString(i++,date);

	            try (ResultSet rs = pst.executeQuery()) {
	                while (rs.next()) {
	                  String gradeName = rs.getString("GRADE_NAME");
	                  double todayQty=rs.getDouble("TODAY_QTY");
	                  double todateQty=rs.getDouble("TODATE_QTY");
                      double todateAvgRate = rs.getDouble("TODATE_AVG_RATE");
	                  
                      SugarSaleResponse.SugarSaleData sugarData = sugarSaleMap.get(gradeName);
                 	  
	                    if (sugarData==null) {
	                    	sugarData = new SugarSaleResponse.SugarSaleData();
	                        sugarData.setGradeName(gradeName);
	                    	sugarData.setTodayQty(todayQty);
	                    	sugarData.setTodateQty(todateQty);
	                    	sugarData.setTodateAvgRate(todateAvgRate);
                            sugarSaleMap.put(gradeName, sugarData);
	                       }
	                    else {
	                    	System.out.println("Key already exists for gradeName: " + gradeName);
	                         }
	                }
	            }
	        }
	        vssugarSaleRes.setSugarSaleBeanMap(sugarSaleMap);
	        vssugarSaleRes.setSuccess(true);

	    } catch (SQLException e) {
	    	sugarSaleResponse.setSuccess(false);
	        ServerError error = new ServerError();
	        error.setError(ConstantVeriables.ERROR_006);
	        error.setMsg("Sugar sale information not found: " + e.getMessage());
	        sugarSaleResponse.setSe(error);
	        e.printStackTrace(); 
	    }

	    return vssugarSaleRes;
}

	public SugarStockResponse sugarStockReport(SugarStockResponse sugarStockResponse, Connection conn, String date,
			String yearCode) {
		int i=1;
		SugarStockResponse vssugarStockRes = new SugarStockResponse();
	    Map<String,SugarStockData> sugarStockMap = new HashMap<>();

	    try {
	        String sql = "select t.VGARDE_NAME,t.BAL from androidapp.web_sugar_stock t where t.RDATE=?";
	        try (PreparedStatement pst = conn.prepareStatement(sql)) {
	        	pst.setString(i++,date);

	            try (ResultSet rs = pst.executeQuery()) {
	                while (rs.next()) {
	                  String vgradeName = rs.getString("VGARDE_NAME");
	                  double bal=rs.getDouble("BAL");
	                 
	                  SugarStockResponse.SugarStockData sugarStockData = sugarStockMap.get(vgradeName);
                 	  
	                    if (sugarStockData==null) {
	                    	sugarStockData = new  SugarStockResponse.SugarStockData();
	                    	sugarStockData.setVgradeName(vgradeName);
	                    	sugarStockData.setBal(bal);
                            sugarStockMap.put(vgradeName, sugarStockData);
	                       }
	                    else {
	                    	System.out.println("Key already exists for vgradeName: " + vgradeName);
	                         }
	                }
	            }
	        }
	        vssugarStockRes.setSugarStockBeanMap(sugarStockMap);
	        vssugarStockRes.setSuccess(true);

	    } catch (SQLException e) {
	    	sugarStockResponse.setSuccess(false);
	        ServerError error = new ServerError();
	        error.setError(ConstantVeriables.ERROR_006);
	        error.setMsg("Sugar stock information not found: " + e.getMessage());
	        sugarStockResponse.setSe(error);
	        e.printStackTrace(); 
	    }

	    return vssugarStockRes;

	}

	public SubSubstanceResponse substanceSaleReport(SubSubstanceResponse substanceSaleResponse, Connection conn, String date, String yearCode) {
        int i = 1;
        SubSubstanceResponse substanceRes = new SubSubstanceResponse();
        Map<String, SubSubstanceData> substanceMap = new HashMap<>();

        try {
            String sql = "select t.perticular, t.today, t.todate, t.todate_RATE from androidapp.web_dist_sale1 t where t.rdate=?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(i++, date);

                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String perticular = rs.getString("PERTICULAR");
                        double today = rs.getDouble("TODAY");
                        double todate = rs.getDouble("TODATE");
                        double todateRate = rs.getDouble("TODATE_RATE");

                        SubSubstanceResponse.SubSubstanceData substanceData = substanceMap.get(perticular);

                        if (substanceData == null) {
                            substanceData = substanceRes.new SubSubstanceData();
                            substanceData.setPerticular(perticular);
                            substanceData.setToday(today);
                            substanceData.setTodate(todate);
                            substanceData.setTodateRate(todateRate);

                            substanceMap.put(perticular, substanceData);
                        } 
                    }
                }
            }
            substanceRes.setSubSubstanceBeanMap(substanceMap);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException
        }

        return substanceRes;
    }
}
