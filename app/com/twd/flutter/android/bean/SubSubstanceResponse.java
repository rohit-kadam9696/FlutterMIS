package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.SugarStockResponse.SugarStockData;

public class SubSubstanceResponse extends MainResponse {
	
	private Map<String, SubSubstanceData>subSubstanceBeanMap;
	
	
	
	public Map<String, SubSubstanceData> getSubSubstanceBeanMap() {
		return subSubstanceBeanMap;
	}



	public void setSubSubstanceBeanMap(Map<String, SubSubstanceData> subSubstanceBeanMap) {
		this.subSubstanceBeanMap = subSubstanceBeanMap;
	}



	public class SubSubstanceData{
		 private String perticular;
	        private double today;
	        private double todate;
	        private double todateRate;
		
			public String getPerticular() {
				return perticular;
			}
			public void setPerticular(String perticular) {
				this.perticular = perticular;
			}
			public double getToday() {
				return today;
			}
			public void setToday(double today) {
				this.today = today;
			}
			public double getTodate() {
				return todate;
			}
			public void setTodate(double todate) {
				this.todate = todate;
			}
			public double getTodateRate() {
				return todateRate;
			}
			public void setTodateRate(double todateRate) {
				this.todateRate = todateRate;
			}
	        
	}

}
