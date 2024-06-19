package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.SugarSaleResponse.SugarSaleData;

public class SugarStockResponse extends MainResponse {
	
	
	private Map<String, SugarStockData> sugarStockBeanMap;
	
	public Map<String, SugarStockData> getSugarStockBeanMap() {
		return sugarStockBeanMap;
	}

	public void setSugarStockBeanMap(Map<String, SugarStockData> sugarStockBeanMap) {
		this.sugarStockBeanMap = sugarStockBeanMap;
	}

	public static class SugarStockData{
		    private String vgradeName;
	        private double bal;
			public String getVgradeName() {
				return vgradeName;
			}
			public void setVgradeName(String vgradeName) {
				this.vgradeName = vgradeName;
			}
			public double getBal() {
				return bal;
			}
			public void setBal(double bal) {
				this.bal = bal;
			}
	        
	        
	        
	}

}
