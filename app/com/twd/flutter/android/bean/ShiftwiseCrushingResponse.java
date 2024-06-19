package com.twd.flutter.android.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShiftwiseCrushingResponse extends MainResponse {

	 private Map<Double, ShiftCrushingData> shiftWiseCrushingBeanMap;

	    public Map<Double, ShiftCrushingData> getShiftWiseCrushingBeanMap() {
	        return shiftWiseCrushingBeanMap;
	    }

	    public void setShiftWiseCrushingBeanMap(Map<Double, ShiftCrushingData> shiftWiseCrushingBeanMap) {
	        this.shiftWiseCrushingBeanMap = shiftWiseCrushingBeanMap;
	    }
	    public class ShiftCrushingData {
	        private double shiftTodayCrushing;
	        private double shiftYeastrdayCrushing;
	        private String shiftNo;

	        public double getShiftTodayCrushing() {
	            return shiftTodayCrushing;
	        }

	        public void setShiftTodayCrushing(double shiftTodayCrushing) {
	            this.shiftTodayCrushing = shiftTodayCrushing;
	        }

	        public double getShiftYeastrdayCrushing() {
	            return shiftYeastrdayCrushing;
	        }

	        public void setShiftYeastrdayCrushing(double shiftYeastrdayCrushing) {
	            this.shiftYeastrdayCrushing = shiftYeastrdayCrushing;
	        }

			public String getShiftNo() {
				return shiftNo;
			}

			public void setShiftNo(String shiftNo) {
				this.shiftNo = shiftNo;
			}

			

			
			
}
}