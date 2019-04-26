package com.example.tomislavrajic.simplenanopoolcheck.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDataWorkers {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<Worker> data = null;

    public Boolean getStatus() {
        return status;
    }

    public List<Worker> getData() {
        return data;
    }
}