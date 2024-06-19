package com.twd.flutter.android.bean;

import java.util.Map;

import com.twd.flutter.android.bean.VarietyHangamCaneResponse.VarietyHangamCaneData;

public class GatHangamCurrentCaneResponse extends MainResponse {
	private Map<String, GatHangamCaneData> gatHangamCaneBeanMap;
	  public Map<String, GatHangamCaneData> getGatHangamCaneBeanMap() {
		return gatHangamCaneBeanMap;
	}


  public void setGatHangamCaneBeanMap(Map<String, GatHangamCaneData> gatHangamCaneBeanMap) {
		this.gatHangamCaneBeanMap = gatHangamCaneBeanMap;
	}
	public static class GatHangamCaneData {
        private double value1;
        private double value2;
        private double value3;
        private double value4;
        private double value5;
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

        public double getValue3() {
            return value3;
        }

        public void setValue3(double value3) {
            this.value3 = value3;
        }

        public double getValue4() {
            return value4;
        }

        public void setValue4(double value4) {
            this.value4 = value4;
        }

        public double getValue5() {
            return value5;
        }

        public void setValue5(double value5) {
            this.value5 = value5;
        }

        public String getResourceName() {
            return resourceName;
        }

        public void setResourceName(String resourceName) {
            this.resourceName = resourceName;
        }
    }

}
