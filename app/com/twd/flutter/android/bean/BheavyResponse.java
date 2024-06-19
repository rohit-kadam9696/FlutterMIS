package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.SubSubstanceProductionResp.ProductionSubSubstanceData;

public class BheavyResponse extends MainResponse {
	 private Map<String, BHeavyProductionData> bheavyProductionBeanMap;
	 
	
   
  public Map<String, BHeavyProductionData> getBheavyProductionBeanMap() {
		return bheavyProductionBeanMap;
	}



	public void setBheavyProductionBeanMap(Map<String, BHeavyProductionData> bheavyProductionBeanMap) {
		this.bheavyProductionBeanMap = bheavyProductionBeanMap;
	}



public static class  BHeavyProductionData{
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