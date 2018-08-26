package com.example.tomislavrajic.simplenanopoolcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Workers {

    @SerializedName("uid")
    @Expose
    private Integer uid;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("hashrate")
    @Expose
    private Integer hashrate;
    @SerializedName("lastShare")
    @Expose
    private Integer lastShare;
    @SerializedName("rating")
    @Expose
    private Integer rating;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getHashrate() {
        return hashrate;
    }

    public void setHashrate(Integer hashrate) {
        this.hashrate = hashrate;
    }

    public Integer getLastShare() {
        return lastShare;
    }

    public void setLastShare(Integer lastShare) {
        this.lastShare = lastShare;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
