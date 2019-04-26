package com.example.tomislavrajic.simplenanopoolcheck.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

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

    public ArrayList<ReportedHashrates> getData() {
        return data;
    }
}