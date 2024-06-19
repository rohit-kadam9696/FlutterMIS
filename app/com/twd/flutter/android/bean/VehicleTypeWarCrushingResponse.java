package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.CaneYardCrushingResponse.CaneYardCrushingData;

public class VehicleTypeWarCrushingResponse extends MainResponse {
	
	 private Map<String, VehicleTypeWarData> vehicleCrushingBeanMap;
	 

	
	public Map<String, VehicleTypeWarData> getVehicleCrushingBeanMap() {
		return vehicleCrushingBeanMap;
	}



	public void setVehicleCrushingBeanMap(Map<String, VehicleTypeWarData> vehicleCrushingBeanMap) {
		this.vehicleCrushingBeanMap = vehicleCrushingBeanMap;
	}



	public class VehicleTypeWarData
	{
		    private double todayWt;
	        private double todateWt;
	        private String vvehicleType;
			public double getTodayWt() {
				return todayWt;
			}
			public void setTodayWt(double todayWt) {
				this.todayWt = todayWt;
			}
			public double getTodateWt() {
				return todateWt;
			}
			public void setTodateWt(double todateWt) {
				this.todateWt = todateWt;
			}
			public String getVvehicleType() {
				return vvehicleType;
			}
			public void setVvehicleType(String vvehicleType) {
				this.vvehicleType = vvehicleType;
			}
	        
	}

}
