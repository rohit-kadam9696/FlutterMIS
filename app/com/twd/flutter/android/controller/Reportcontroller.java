package com.twd.flutter.android.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twd.flutter.android.bean.CaneYardCrushingResponse;

import com.twd.flutter.android.bean.CrushingResponse;
import com.twd.flutter.android.bean.GatWiseCrushingResponse;
import com.twd.flutter.android.bean.HangamWiseCrushingResponse;
import com.twd.flutter.android.bean.HourlyCrushingReponse;
import com.twd.flutter.android.bean.LoginResponse;
import com.twd.flutter.android.bean.MainResponse;
import com.twd.flutter.android.bean.MasterDataResponse;
import com.twd.flutter.android.bean.ShiftwiseCrushingResponse;
import com.twd.flutter.android.bean.VarietyWiseCrushingResponse;
import com.twd.flutter.android.bean.VehicleTypeWarCrushingResponse;
import com.twd.flutter.android.constant.Constant;
import com.twd.flutter.android.service.CrushingService;
import com.twd.flutter.android.service.LoginService;
import com.twd.flutter.android.serviceInterface.CrushingServiceInterface;
import com.twd.flutter.android.serviceInterface.LoginServiceInterface;


@WebServlet("/Reportcontroller")
public class Reportcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrushingServiceInterface crushing = new CrushingService();
	
     
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
			case "crushingreport":
				
				//System.out.println("crushingreport action "+action);
				
				CrushingResponse crushingResponse=new CrushingResponse();
				
				crushingResponse =crushing.crushing(reqObj, imei, accessType, crushingResponse,YearCode,date);
			   result=new JSONObject(crushingResponse);
			  
			 
		        try (PrintWriter out = response.getWriter()) {
		        out.print(result.toString());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        break;
              case "crushingReportshiftwise":
            	 ShiftwiseCrushingResponse master=new ShiftwiseCrushingResponse();
			 master =crushing.crushingReportshiftwise(reqObj,master,YearCode,date);
			       result=new JSONObject(master);
			     
		        try (PrintWriter out = response.getWriter()) {
		        out.print(result.toString());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        break;
		        
              case "caneyardshilakreport":
            	  CaneYardCrushingResponse caneyardres=new CaneYardCrushingResponse();
            	  caneyardres=crushing.caneyardres(reqObj, caneyardres, YearCode, date);
            	  result=new JSONObject(caneyardres);
			      
			       try (PrintWriter out = response.getWriter()) {
			          out.print(result.toString());
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        break;
			        
			        
              case "hourlyCrushingReport":
            	  HourlyCrushingReponse hourlyRes=new HourlyCrushingReponse();
            	  hourlyRes=crushing.hourlyRes(reqObj, hourlyRes, YearCode, date);
            	  result=new JSONObject(hourlyRes);
			    
			       try (PrintWriter out = response.getWriter()) {
			          out.print(result.toString());
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        break;  
			        
              case "gatWiseCrushingReport":
            	  GatWiseCrushingResponse gatResponse=new GatWiseCrushingResponse();
            	  gatResponse=crushing.gatWiseResponse(reqObj, gatResponse, YearCode, date);
            	  result=new JSONObject(gatResponse);
			       
			       try (PrintWriter out = response.getWriter()) {
			      out.print(result.toString());
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        break;   
			        
              case "hangamWiseCrushingReport":
            	  HangamWiseCrushingResponse hangamResponse=new HangamWiseCrushingResponse();
            	  hangamResponse=crushing.hangamWiseResponse(reqObj, hangamResponse, YearCode, date);
            	  result=new JSONObject(hangamResponse);
			      // System.out.println("HangamWiseCrushingResponse result"+result);
			       try (PrintWriter out = response.getWriter()) {
			        out.print(result.toString());
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        break;    
			        
              case "varietyWiseCrushingReport":
            	  VarietyWiseCrushingResponse varietyResponse=new VarietyWiseCrushingResponse();
            	  varietyResponse=crushing.varietyWiseResponse(reqObj, varietyResponse, YearCode, date);
            	  result=new JSONObject(varietyResponse);
			       //System.out.println("VarietyWiseCrushingResponse result"+result);
			       try (PrintWriter out = response.getWriter()) {
			         out.print(result.toString());
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        break;   
			        
			        
			        
              case "vehicleWarCrushingReport":
            	  VehicleTypeWarCrushingResponse vehicleWarResponse=new VehicleTypeWarCrushingResponse();
            	  vehicleWarResponse=crushing.vehicleWarResponse(reqObj, vehicleWarResponse, date);
            	  result=new JSONObject(vehicleWarResponse);
			    
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


