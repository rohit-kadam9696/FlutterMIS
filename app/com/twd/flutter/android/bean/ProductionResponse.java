package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.VarietyHangamCaneResponse.VarietyHangamCaneData;

public class ProductionResponse extends MainResponse{
	 private Map<String, ProductionSugarData> productionSugarBeanMap;
	 

	  	    public Map<String, ProductionSugarData> getProductionSugarBeanMap() {
		return productionSugarBeanMap;
	}


	public void setProductionSugarBeanMap(Map<String, ProductionSugarData> productionSugarBeanMap) {
		this.productionSugarBeanMap = productionSugarBeanMap;
	}


			public static class ProductionSugarData {
	        private double value1;
	        private double value2;
	        private String resourceName;

	        public double getValue1() {
	            return value1;
	        }

	        public void setValue1(double value1) {
	            this.value1 = value1;
	        }

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
