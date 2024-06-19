package com.twd.flutter.android.constant;

import com.twd.flutter.android.bean.ConstantMessage;
import com.twd.flutter.android.bean.MainResponse;
import com.twd.flutter.android.bean.ServerError;

public class AppConstant {


	public static MainResponse ConfigureErrorMessage(MainResponse response, String message, int errorCode,boolean isPopup) {
		response.setSuccess(false);
		ServerError se = new ServerError();
		se.setError(errorCode);
		se.setMsg(message);
		se.setPopup(isPopup);
		response.setSe(se);
		return response;
	}

	public static MainResponse ConfigureMissingParamError(MainResponse response,boolean isPopup) {
		response.setSuccess(false);
		ServerError se = new ServerError();
		se.setError(ConstantVeriables.ERROR_006);
		se.setMsg(ConstantMessage.ErrorMissingParam);
		se.setPopup(isPopup);
		response.setSe(se);
		return response;
	} 


}
