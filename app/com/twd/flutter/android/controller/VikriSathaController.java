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
import com.twd.flutter.android.bean.CrushingResponse;
import com.twd.flutter.android.bean.SubSubstanceResponse;
import com.twd.flutter.android.bean.SugarSaleResponse;
import com.twd.flutter.android.bean.SugarStockResponse;
import com.twd.flutter.android.bean.VikriSatha1Response;
import com.twd.flutter.android.constant.Constant;
import com.twd.flutter.android.service.VikriSathaService;

/**
 * Servlet implementation class VikriSathaController
 */
@WebServlet("/VikriSathaController")
public class VikriSathaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VikriSathaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VikriSathaService vsservice=new VikriSathaService();
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
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			
		    JsonNode json = objectMapper.readTree(jsonBody.toString());
			String action = json.get("action").toString();
			String YearCode = json.get("YearCode").toString();
		
			String mobileNo = json.get("mobileNo").toString();
	  	    String imei = json.get("imei").toString();
			String randomString = json.get("randomString").toString();
			String versionId = json.get("versionId").toString();
			String chitBoyId = json.get("chitBoyId").toString();
			String accessType = request.getParameter("accessType");
			
	        String date = json.get("date").toString();
	        if (date != null) {
	            date = Constant.replaceAll(date, "\"", "");
	        }
			JSONObject reqObj=new JSONObject(jsonBody.toString());
			
		
		
		        
	        action = Constant.replaceAll(action, "\"", "");
			mobileNo = Constant.replaceAll(mobileNo, "\"", "");
			imei=Constant.replaceAll(imei,"\"", "");
			randomString = Constant.replaceAll(randomString, "\"", "");
			versionId = Constant.replaceAll(versionId, "\"", "");
			chitBoyId=Constant.replaceAll(chitBoyId,"\"", "");
			YearCode=Constant.replaceAll(YearCode,"\"", "");
			
			
			
		       
        JSONObject result=null;
			if(accessType==null || accessType.trim().isEmpty())
				accessType="1";       
			switch(action) {
			case "vikrisatha1":
				VikriSatha1Response vsResponse=new VikriSatha1Response();
		       vsResponse =vsservice.vikriSathaReport1(reqObj, imei, accessType, vsResponse,YearCode,date);
			   result=new JSONObject(vsResponse);
	          try (PrintWriter out = response.getWriter()) {
		        out.print(result.toString());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        break;
		        
			case "sugarsale":
				SugarSaleResponse sugarSaleResponse=new SugarSaleResponse();
				sugarSaleResponse =vsservice.sugarSaleReport(reqObj, imei, accessType, sugarSaleResponse,YearCode,date);
			    result=new JSONObject(sugarSaleResponse);
			    try (PrintWriter out = response.getWriter()) {
		        out.print(result.toString());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        break;
	
			case "sugarstock":
				SugarStockResponse sugarStockResponse=new SugarStockResponse();
				sugarStockResponse =vsservice.sugarStockReport(reqObj, imei, accessType, sugarStockResponse,YearCode,date);
			    result=new JSONObject(sugarStockResponse);
			    
			    try (PrintWriter out = response.getWriter()) {
		        out.print(result.toString());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        break;
	
			case "subsubstancesale":
				SubSubstanceResponse substanceSaleResponse=new SubSubstanceResponse();
				substanceSaleResponse =vsservice.substanceSaleReport(reqObj, imei, accessType, substanceSaleResponse,YearCode,date);
			    result=new JSONObject(substanceSaleResponse);
			    System.out.println("subsubstancesale result "+result);
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
