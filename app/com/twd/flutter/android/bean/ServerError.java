package com.twd.flutter.android.bean;

public class ServerError {
	 private String msg;
	 private Integer error;
	 private boolean popup;

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

		public Integer getError() {
			return error;
		}

		public void setError(Integer error) {
			this.error = error;
		}

		public boolean isPopup() {
			return popup;
		}

		public void setPopup(boolean popup) {
			this.popup = popup;
		}

   


}
