package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.ShiftwiseCrushingResponse.ShiftCrushingData;

public class CaneYardCrushingResponse extends MainResponse{
	 private Map<String, CaneYardCrushingData> caneYardCrushingBeanMap;

	   
	


		public Map<String, CaneYardCrushingData> getCaneYardCrushingBeanMap() {
		return caneYardCrushingBeanMap;
	}





	public void setCaneYardCrushingBeanMap(Map<String, CaneYardCrushingData> caneYardCrushingBeanMap) {
		this.caneYardCrushingBeanMap = caneYardCrushingBeanMap;
	}





		public class CaneYardCrushingData {
	        private double cnt;
	        private double avgTonnage;
	        private String vehicleType;
			public double getCnt() {
				return cnt;
			}
			public void setCnt(double cnt) {
				this.cnt = cnt;
			}
			public double getAvgTonnage() {
				return avgTonnage;
			}
			public void setAvgTonnage(double avgTonnage) {
				this.avgTonnage = avgTonnage;
			}
			public String getVehicleType() {
				return vehicleType;
			}
			public void setVehicleType(String vehicleType2) {
				this.vehicleType = vehicleType2;
			}

	       
			
}

}
