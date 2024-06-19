package com.twd.flutter.android.bean;

public class FarmerPlantationType {

    private int nfarmerPlantCode;
    private String vfarmerPlantName;

    public int getNfarmerPlantCode() {
        return nfarmerPlantCode;
    }

    public void setNfarmerPlantCode(int nfarmerPlantCode) {
        this.nfarmerPlantCode = nfarmerPlantCode;
    }

    public String getVfarmerPlantName() {
        return vfarmerPlantName;
    }

    public void setVfarmerPlantName(String vfarmerPlantName) {
        this.vfarmerPlantName = vfarmerPlantName;
    }

	@Override
	public String toString() {
		return "FarmerPlantationType [nfarmerPlantCode=" + nfarmerPlantCode + ", vfarmerPlantName=" + vfarmerPlantName
				+ "]";
	}
    
    
}
