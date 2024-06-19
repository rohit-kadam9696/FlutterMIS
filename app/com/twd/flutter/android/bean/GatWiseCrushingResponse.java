package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.HourlyCrushingReponse.HourlyCrushingData;

public class GatWiseCrushingResponse extends MainResponse{
	
	
	 private Map<String, GatWiseCrushingData> gatWiseCrushingBeanMap;
	 
	
	public Map<String, GatWiseCrushingData> getGatWiseCrushingBeanMap() {
		return gatWiseCrushingBeanMap;
	}


	public void setGatWiseCrushingBeanMap(Map<String, GatWiseCrushingData> gatWiseCrushingBeanMap) {
		this.gatWiseCrushingBeanMap = gatWiseCrushingBeanMap;
	}


	public class GatWiseCrushingData {
        private String department;
        private double todayCrushing;
		public double uptoTodayCrushingngWt;
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public double getTodayCrushing() {
			return todayCrushing;
		}
		public void setTodayCrushing(double todayCrushing) {
			this.todayCrushing = todayCrushing;
		}
		public double getUptoTodayCrushingngWt() {
			return uptoTodayCrushingngWt;
		}
		public void setUptoTodayCrushingngWt(double uptoTodayCrushingngWt) {
			this.uptoTodayCrushingngWt = uptoTodayCrushingngWt;
		}
		
		
		}
	
        

}
