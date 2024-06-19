package com.twd.flutter.android.bean;

import java.io.Serializable;



public class MainResponse implements Serializable {
    private boolean success;
    private boolean update;
    private ServerError se;
    private AppUpdate updateResponse;

    private int nlocationId, nsugTypeId;

    private String vfullName, designation, slipboycode, mobileno, uniquestring, pggroups, yearCode, nuserRoleId, harvestingYearCode, perbygroup, vrrtgYear, vfertYear;
    private String fromTimeRawana, toTimeRawana;

    private String currentDateTime;
    private String areaMin, areaMax, intimationAcc, intimationMinDate, plantationAcc, plantationMaxDate, mapAllowIn, calculationAcc, loadTime,  onlineCalcualte,avargeTonnage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ServerError getSe() {
        return se;
    }

    public void setSe(ServerError se) {
        this.se = se;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSlipboycode() {
        return slipboycode;
    }

    public void setSlipboycode(String slipboycode) {
        this.slipboycode = slipboycode;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getUniquestring() {
        return uniquestring;
    }

    public void setUniquestring(String uniquestring) {
        this.uniquestring = uniquestring;
    }

    public String getPggroups() {
        return pggroups;
    }

    public void setPggroups(String pggroups) {
        this.pggroups = pggroups;
    }

    public String getPerbygroup() {
        return perbygroup;
    }

    public void setPerbygroup(String perbygroup) {
        this.perbygroup = perbygroup;
    }

    public String getHarvestingYearCode() {
        return harvestingYearCode;
    }

    public void setHarvestingYearCode(String harvestingYearCode) {
        this.harvestingYearCode = harvestingYearCode;
    }

    public String getVfullName() {
        return vfullName;
    }

    public void setVfullName(String vfullName) {
        this.vfullName = vfullName;
    }

    public String getYearCode() {
        return yearCode;
    }

    public void setYearCode(String yearCode) {
        this.yearCode = yearCode;
    }

    public String getNuserRoleId() {
        return nuserRoleId;
    }

    public void setNuserRoleId(String nuserRoleId) {
        this.nuserRoleId = nuserRoleId;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public AppUpdate getUpdateResponse() {
        return updateResponse;
    }

    public void setUpdateResponse(AppUpdate updateResponse) {
        this.updateResponse = updateResponse;
    }

    public String getVrrtgYear() {
        return vrrtgYear;
    }

    public void setVrrtgYear(String vrrtgYear) {
        this.vrrtgYear = vrrtgYear;
    }

    public String getVfertYear() {
        return vfertYear;
    }

    public void setVfertYear(String vfertYear) {
        this.vfertYear = vfertYear;
    }

    public String getFromTimeRawana() {
        return fromTimeRawana;
    }

    public void setFromTimeRawana(String fromTimeRawana) {
        this.fromTimeRawana = fromTimeRawana;
    }

    public String getToTimeRawana() {
        return toTimeRawana;
    }

    public void setToTimeRawana(String toTimeRawana) {
        this.toTimeRawana = toTimeRawana;
    }

    public int getNlocationId() {
        return nlocationId;
    }

    public void setNlocationId(int nlocationId) {
        this.nlocationId = nlocationId;
    }

    public int getNsugTypeId() {
        return nsugTypeId;
    }

    public void setNsugTypeId(int nsugTypeId) {
        this.nsugTypeId = nsugTypeId;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getAreaMin() {
        return areaMin;
    }

    public void setAreaMin(String areaMin) {
        this.areaMin = areaMin;
    }

    public String getAreaMax() {
        return areaMax;
    }

    public void setAreaMax(String areaMax) {
        this.areaMax = areaMax;
    }

    public String getIntimationAcc() {
        return intimationAcc;
    }

    public void setIntimationAcc(String intimationAcc) {
        this.intimationAcc = intimationAcc;
    }

    public String getIntimationMinDate() {
        return intimationMinDate;
    }

    public void setIntimationMinDate(String intimationMinDate) {
        this.intimationMinDate = intimationMinDate;
    }

    public String getPlantationAcc() {
        return plantationAcc;
    }

    public void setPlantationAcc(String plantationAcc) {
        this.plantationAcc = plantationAcc;
    }

    public String getPlantationMaxDate() {
        return plantationMaxDate;
    }

    public void setPlantationMaxDate(String plantationMaxDate) {
        this.plantationMaxDate = plantationMaxDate;
    }

    public String getMapAllowIn() {
        return mapAllowIn;
    }

    public void setMapAllowIn(String mapAllowIn) {
        this.mapAllowIn = mapAllowIn;
    }

    public String getCalculationAcc() {
        return calculationAcc;
    }

    public void setCalculationAcc(String calculationAcc) {
        this.calculationAcc = calculationAcc;
    }

    public String getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(String loadTime) {
        this.loadTime = loadTime;
    }

    public String getOnlineCalcualte() {
        return onlineCalcualte;
    }

    public void setOnlineCalcualte(String onlineCalcualte) {
        this.onlineCalcualte = onlineCalcualte;
    }

	public String getAvargeTonnage() {
		return avargeTonnage;
	}

	public void setAvargeTonnage(String avargeTonnage) {
		this.avargeTonnage = avargeTonnage;
	}
    
}
