package com.example.tomislavrajic.simplenanopoolcheck.networking;

import com.example.tomislavrajic.simplenanopoolcheck.models.ResponseDataBalance;
import com.example.tomislavrajic.simplenanopoolcheck.models.ResponseDataReportedHashrates;
import com.example.tomislavrajic.simplenanopoolcheck.models.ResponseDataWorkers;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NanopoolAPI {

    String BASE_URL = "https://api.nanopool.org/v1/eth/";

    @GET("balance/{wallet_address}")
    Call<ResponseDataBalance> getBalancePayout(@Path("wallet_address") String walletAddress);

    @GET("reportedhashrate/{wallet_address}")
    Call<ResponseDataBalance> getReportedHashrate(@Path("wallet_address") String walletAddress);

    @GET("reportedhashrates/{wallet_address}")
    Call<ResponseDataReportedHashrates> getReportedHashrates(@Path("wallet_address") String walletAddress);

    @GET("workers/{wallet_address}")
    Call<ResponseDataWorkers> getWorkers(@Path("wallet_address") String walletAddress);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    NanopoolAPI service = retrofit.create(NanopoolAPI.class);
}