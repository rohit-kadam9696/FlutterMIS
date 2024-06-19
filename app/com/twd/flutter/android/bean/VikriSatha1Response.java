package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.MonthHangamCurrentCaneResponse.MonthHangamCurrentData;

public class VikriSatha1Response extends MainResponse{
	private Map<String, VikriSathaData> vikriSathaSugarBeanMap;
	
	
	
	
	public Map<String, VikriSathaData> getVikriSathaSugarBeanMap() {
		return vikriSathaSugarBeanMap;
	}




	public void setVikriSathaSugarBeanMap(Map<String, VikriSathaData> vikriSathaSugarBeanMap) {
		this.vikriSathaSugarBeanMap = vikriSathaSugarBeanMap;
	}




	public static class VikriSathaData{
		

        private double value2;
      
        private String resourceName;

		public double getValue2() {
			return value2;
		}

		public void setValue2(double value2) {
			this.value2 = value2;
		}

		public String getResourceName() {
			return resourceName;
		}

		public void setResourceName(String resourceName) {
			this.resourceName = resourceName;
		}
        
	}

}
