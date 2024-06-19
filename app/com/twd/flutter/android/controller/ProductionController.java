package com.twd.flutter.android.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twd.flutter.android.bean.BheavyResponse;
import com.twd.flutter.android.bean.CheavyResponse;
import com.twd.flutter.android.bean.CrushingResponse;
import com.twd.flutter.android.bean.ProductionResponse;
import com.twd.flutter.android.bean.SubSubstanceProductionResp;
import com.twd.flutter.android.constant.Constant;
import com.twd.flutter.android.service.ProductionService;
import com.twd.flutter.android.serviceInterface.ProductionServiceInterface;
//import com.twd.flutter.android.controlle;

@WebServlet("/ProductionController")
public class ProductionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ProductionServiceInterface production = new ProductionService();
	    
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
	            case "sugarProduction":
	               ProductionResponse productionResponse=new ProductionResponse();
	               productionResponse = production.sugarProduction(reqObj, imei, accessType, productionResponse,YearCode,date);
	                result=new JSONObject(productionResponse);
	               // System.out.println("sugar production: "+result);
	                try (PrintWriter out = response.getWriter()) {
	                    out.print(result.toString());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                break;
	            case "subSubstanceProduction":
	            	SubSubstanceProductionResp substanceRes=new SubSubstanceProductionResp();
	            	substanceRes=production.subSubstanceProduction(reqObj, imei, accessType, substanceRes, YearCode, date);
	            	 result=new JSONObject(substanceRes);
	            	 try (PrintWriter out = response.getWriter()) {
		                    out.print(result.toString());
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		                break;	
		                
	            case "heavyProduction":
	            	BheavyResponse bheavyResponse=new BheavyResponse();
	            	bheavyResponse=production.bheavyProductionDetails(reqObj, imei, accessType, bheavyResponse, YearCode, date);
	            	 result=new JSONObject(bheavyResponse);
	     
	            	 try (PrintWriter out = response.getWriter()) {
		                    out.print(result.toString());
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		                break; 
		          
	            case "cHeavyProduction":
	            	CheavyResponse cheavyResponse=new CheavyResponse();
	            	cheavyResponse=production.cheavyProductionDetails(reqObj, imei, accessType, cheavyResponse, YearCode, date);
	            	 result=new JSONObject(cheavyResponse);
	               System.out.println("cheavy result: "+result);
	            	 try (PrintWriter out = response.getWriter()) {
		                    out.print(result.toString());
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		                break; 
		 
		                
	        }
	    } catch (IOException | JSONException e) {
	        e.printStackTrace();
	    }
	}
}


