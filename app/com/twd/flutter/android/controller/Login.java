package com.twd.flutter.android.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twd.flutter.android.bean.LoginResponse;
import com.twd.flutter.android.bean.MainResponse;
import com.twd.flutter.android.bean.ServerError;
import com.twd.flutter.android.constant.Constant;
import com.twd.flutter.android.constant.ConstantVeriables;
import com.twd.flutter.android.service.LoginService;
import com.twd.flutter.android.serviceInterface.LoginServiceInterface;








/**
 * Servlet implementation class Login
 */
@WebServlet("/app_login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServiceInterface login = new LoginService();
        MainResponse mainresponse=new LoginResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		PrintWriter pw=response.getWriter();
		BufferedReader reader = request.getReader();
		StringBuilder jsonBody = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			jsonBody.append(line);
		}
		reader.close();
		System.out.println("json body: " + jsonBody.toString());
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			
		    JsonNode json = objectMapper.readTree(jsonBody.toString());
			String action = json.get("action").toString();
			
			String mobileno = json.get("mobileno").toString();
	  	    String imei = json.get("imei").toString();
			String randomString = json.get("randomString").toString();
			String versionId = json.get("versionId").toString();
			String chitBoyId = json.get("chitBoyId").toString();
			String accessType = request.getParameter("accessType");
		
			
			JSONObject reqObj=new JSONObject(jsonBody.toString());
			System.out.println("reqObj is: "+reqObj);
		
			
			action = Constant.replaceAll(action, "\"", "");
			mobileno = Constant.replaceAll(mobileno, "\"", "");
			imei=Constant.replaceAll(imei,"\"", "");
			randomString = Constant.replaceAll(randomString, "\"", "");
			versionId = Constant.replaceAll(versionId, "\"", "");
			chitBoyId=Constant.replaceAll(chitBoyId,"\"", "");
	
			JSONObject result=null;
			if(accessType==null || accessType.trim().isEmpty())
				accessType="1";
		
			
		//	String otp = json.get("otp").toString();       
			switch(action) {
		
			case "Login":
				LoginResponse loginRes=new LoginResponse();
			   loginRes=login.appLogin(reqObj,imei,accessType,loginRes);
		    	result=new JSONObject(loginRes);
		    	try (PrintWriter out = response.getWriter()) {
		            out.print(result.toString());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        break;
		 
			case "verifyotp":
			 mainresponse=login.verifyOTP(mainresponse,reqObj,imei,randomString,chitBoyId,accessType);
			result=new JSONObject(mainresponse);
	        try (PrintWriter out = response.getWriter()) {
				           out.print(result.toString());
				        } catch (IOException e) {
				            e.printStackTrace();
				      }
					break;
                    
			case "resendotp":
				mainresponse=login.resendOTP(mainresponse,reqObj,imei,randomString,chitBoyId,accessType);
				result=new JSONObject(mainresponse);
				System.out.println("resend otp result: "+result);
				try (PrintWriter out = response.getWriter()) {
			           out.print(result.toString());
			        } catch (IOException e) {
			            e.printStackTrace();
			      }
				break;
			
		
	
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	
}

}
