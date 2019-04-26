package com.example.tomislavrajic.simplenanopoolcheck.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReportedHashrates {

    @SerializedName("worker")
    @Expose
    private String worker;

    @SerializedName("hashrate")
    @Expose
    private Double hashrate;

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public Double getHashrate() {
        return hashrate;
    }

    public void setHashrate(Double hashrate) {
        this.hashrate = hashrate;
    }
}