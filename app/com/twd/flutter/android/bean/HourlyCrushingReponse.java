package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.CaneYardCrushingResponse.CaneYardCrushingData;

public class HourlyCrushingReponse extends MainResponse{
	
	 private Map<Double, HourlyCrushingData> hourlyCrushingBeanMap;

	
	
	public Map<Double, HourlyCrushingData> getHourlyCrushingBeanMap() {
		return hourlyCrushingBeanMap;
	}



	public void setHourlyCrushingBeanMap(Map<Double, HourlyCrushingData> hourlyCrushingBeanMap) {
		this.hourlyCrushingBeanMap = hourlyCrushingBeanMap;
	}



	public class HourlyCrushingData {
        private double hour;
        private double crushingWt;
		public double getHour() {
			return hour;
		}
		public void setHour(double hour) {
			this.hour = hour;
		}
		public double getCrushingWt() {
			return crushingWt;
		}
		public void setCrushingWt(double crushingWt) {
			this.crushingWt = crushingWt;
		}
	
        
	}

}
