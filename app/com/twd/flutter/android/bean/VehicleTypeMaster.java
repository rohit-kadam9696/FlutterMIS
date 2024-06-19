package com.twd.flutter.android.bean;

public class VehicleTypeMaster {
    private int nvehicleTypeId;
    private String vvehicleTypeNameLocal;
    private int nemptyLimit;
    private int nloadLimit;

    public int getNvehicleTypeId() {
        return nvehicleTypeId;
    }

    public void setNvehicleTypeId(int nvehicleTypeId) {
        this.nvehicleTypeId = nvehicleTypeId;
    }

    public String getVvehicleTypeNameLocal() {
        return vvehicleTypeNameLocal;
    }

    public void setVvehicleTypeNameLocal(String vvehicleTypeNameLocal) {
        this.vvehicleTypeNameLocal = vvehicleTypeNameLocal;
    }

	public int getNemptyLimit() {
		return nemptyLimit;
	}

	public void setNemptyLimit(int nemptyLimit) {
		this.nemptyLimit = nemptyLimit;
	}

	public int getNloadLimit() {
		return nloadLimit;
	}

	public void setNloadLimit(int nloadLimit) {
		this.nloadLimit = nloadLimit;
	}



}
