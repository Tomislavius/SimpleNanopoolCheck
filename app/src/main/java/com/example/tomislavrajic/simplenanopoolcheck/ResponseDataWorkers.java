package com.example.tomislavrajic.simplenanopoolcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDataWorkers {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<Workers> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Workers> getData() {
        return data;
    }

    public void setData(List<Workers> data) {
        this.data = data;
    }
}
