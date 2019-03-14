package com.example.tomislavrajic.simplenanopoolcheck;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EtherscanAPI {

    String BASE_URL = "https://api.etherscan.io/";

    @GET("api")
    Call<ResponseDataEtherscan> getBalanceEtherscan(
            @Query("action") String action,
            @Query("module") String module,
            @Query("address") String address,
            @Query("apikey") String apiKey);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    EtherscanAPI service = retrofit.create(EtherscanAPI.class);
}
