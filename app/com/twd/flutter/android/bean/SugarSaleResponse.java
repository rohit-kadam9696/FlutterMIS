package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.VikriSatha1Response.VikriSathaData;

public class SugarSaleResponse extends MainResponse {
	
	private Map<String, SugarSaleData> sugarSaleBeanMap;
	
	public Map<String, SugarSaleData> getSugarSaleBeanMap() {
		return sugarSaleBeanMap;
	}
  public void setSugarSaleBeanMap(Map<String, SugarSaleData> sugarSaleBeanMap) {
		this.sugarSaleBeanMap = sugarSaleBeanMap;
	}

       public static class SugarSaleData{
		   private double todateQty;
	        private double todayQty;
	        private String gradeName;
	        private double todateAvgRate;
			public double getTodateQty() {
				return todateQty;
			}
			public void setTodateQty(double todateQty) {
				this.todateQty = todateQty;
			}
			public double getTodayQty() {
				return todayQty;
			}
			public void setTodayQty(double todayQty) {
				this.todayQty = todayQty;
			}
			public String getGradeName() {
				return gradeName;
			}
			public void setGradeName(String gradeName) {
				this.gradeName = gradeName;
			}
			public double getTodateAvgRate() {
				return todateAvgRate;
			}
			public void setTodateAvgRate(double todateAvgRate) {
				this.todateAvgRate = todateAvgRate;
			}
	        
	        
	}

}
