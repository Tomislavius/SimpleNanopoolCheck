package com.example.tomislavrajic.simplenanopoolcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseDataReportedHashrates {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private ArrayList<ReportedHashrates> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<ReportedHashrates> getData() {
        return data;
    }

    public void setData(ArrayList<ReportedHashrates> data) {
        this.data = data;
    }
}
