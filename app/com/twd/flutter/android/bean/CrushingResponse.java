package com.twd.flutter.android.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrushingResponse extends MainResponse {

	 
			
	
	    private double todayCrushing;
	    private double uptoTodayCrushing;

	    // Default constructor
	    public CrushingResponse() {
	    }

	    // Parameterized constructor
	    public CrushingResponse(double todayCrushing, double uptoTodayCrushing) {
	        this.todayCrushing = todayCrushing;
	        this.uptoTodayCrushing = uptoTodayCrushing;
	    }

	   
	    public double getTodayCrushing() {
	        return todayCrushing;
	    }

	    public void setTodayCrushing(double todayCrushing) {
	        this.todayCrushing = todayCrushing;
	    }

	    public double getUptoTodayCrushing() {
	        return uptoTodayCrushing;
	    }

	    public void setUptoTodayCrushing(double uptoTodayCrushing) {
	        this.uptoTodayCrushing = uptoTodayCrushing;
	    }
	}

