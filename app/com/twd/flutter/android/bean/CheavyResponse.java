package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.BheavyResponse.BHeavyProductionData;

public class CheavyResponse extends MainResponse{
	
	 private Map<String, CHeavyProductionData> cheavyProductionBeanMap;
	 
	 

public Map<String, CHeavyProductionData> getCheavyProductionBeanMap() {
		return cheavyProductionBeanMap;
	}



	public void setCheavyProductionBeanMap(Map<String, CHeavyProductionData> cheavyProductionBeanMap) {
		this.cheavyProductionBeanMap = cheavyProductionBeanMap;
	}



public static class  CHeavyProductionData{

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