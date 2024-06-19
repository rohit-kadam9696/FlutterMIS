package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.HangamWiseCrushingResponse.HangamWiseCrushingData;

public class VarietyWiseCrushingResponse extends MainResponse {
	
	  private Map<String, VarietyWiseCrushingData> varietyWiseCrushingBeanMap;

	    
		public Map<String, VarietyWiseCrushingData> getVarietyWiseCrushingBeanMap() {
		return varietyWiseCrushingBeanMap;
	}


	public void setVarietyWiseCrushingBeanMap(Map<String, VarietyWiseCrushingData> varietyWiseCrushingBeanMap) {
		this.varietyWiseCrushingBeanMap = varietyWiseCrushingBeanMap;
	}


		public static class VarietyWiseCrushingData  {
	        private String varietyName;
	        private double todayCrushingWt;
	        private double uptoTodayCrushingWt; // Corrected method name
			public String getVarietyName() {
				return varietyName;
			}
			public void setVarietyName(String varietyName) {
				this.varietyName = varietyName;
			}
			public double getTodayCrushingWt() {
				return todayCrushingWt;
			}
			public void setTodayCrushingWt(double todayCrushingWt) {
				this.todayCrushingWt = todayCrushingWt;
			}
			public double getUptoTodayCrushingWt() {
				return uptoTodayCrushingWt;
			}
			public void setUptoTodayCrushingWt(double uptoTodayCrushingWt) {
				this.uptoTodayCrushingWt = uptoTodayCrushingWt;
			}
			

	     

	      
	    }

	
}
