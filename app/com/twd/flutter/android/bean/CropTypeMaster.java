package com.twd.flutter.android.bean;

public class CropTypeMaster {

    private int ncropId;
    private String vcropName;

    public int getNcropId() {
        return ncropId;
    }

    public void setNcropId(int ncropId) {
        this.ncropId = ncropId;
    }

    public String getVcropName() {
        return vcropName;
    }

    public void setVcropName(String vcropName) {
        this.vcropName = vcropName;
    }

	@Override
	public String toString() {
		return "CropTypeMaster [ncropId=" + ncropId + ", vcropName=" + vcropName + "]";
	}

}
