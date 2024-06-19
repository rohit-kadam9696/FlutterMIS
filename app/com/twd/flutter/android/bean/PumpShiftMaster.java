package com.twd.flutter.android.bean;

public class PumpShiftMaster {

    private int nshiftId;
    private String vshiftName;
    private int startTime;
    private int endTime;
    private int totalHour;

    public int getNshiftId() {
        return nshiftId;
    }

    public void setNshiftId(int nshiftId) {
        this.nshiftId = nshiftId;
    }

    public String getVshiftName() {
        return vshiftName;
    }

    public void setVshiftName(String vshiftName) {
        this.vshiftName = vshiftName;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }


}
