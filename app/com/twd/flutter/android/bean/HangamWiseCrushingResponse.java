package com.twd.flutter.android.bean;

import java.util.Map;


	public class HangamWiseCrushingResponse  extends MainResponse {

		  private Map<String, HangamWiseCrushingData> hangamWiseCrushingBeanMap;

	    public Map<String, HangamWiseCrushingData> getHangamWiseCrushingBeanMap() {
			return hangamWiseCrushingBeanMap;
		}

		public void setHangamWiseCrushingBeanMap(Map<String, HangamWiseCrushingData> hangamWiseCrushingBeanMap) {
			this.hangamWiseCrushingBeanMap = hangamWiseCrushingBeanMap;
		}

		public static class HangamWiseCrushingData  {
	        private String hangam;
	        private double todayCrushing;
	        private double uptoTodayCrushingngWt1; // Corrected method name

	        public String getHangam() {
	            return hangam;
	        }

	        public void setHangam(String hangam) {
	            this.hangam = hangam;
	        }

	        public double getTodayCrushing() {
	            return todayCrushing;
	        }

	        public void setTodayCrushing(double todayCrushing) {
	            this.todayCrushing = todayCrushing;
	        }

			public double getUptoTodayCrushingngWt1() {
				return uptoTodayCrushingngWt1;
			}

			public void setUptoTodayCrushingngWt1(double uptoTodayCrushingngWt1) {
				this.uptoTodayCrushingngWt1 = uptoTodayCrushingngWt1;
			}

			
			

	      
	    }

	

	}


