package com.example.tomislavrajic.simplenanopoolcheck;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NanopoolAPI {

    String BASE_URL = "https://api.nanopool.org/v1/eth/";

    // u GET metodu dodajemo endpoint i proslijedjujemo wallet adresu
    @GET("balance/{wallet_address}")
    //Metodom Call zovemo custom klasu u kojoj su definisane varijable, kreiramo custom metodu kojoj
    //cemo proslijediti adresu koju korisnik unese i koja ce se dodati na URL
    Call<ResponseDataBalance> getBalancePayout(@Path("wallet_address") String walletAddress);

    @GET("reportedhashrate/{wallet_address}")
    Call<ResponseDataBalance> getReportedHashrate(@Path("wallet_address") String walletAddress);

    @GET("reportedhashrates/{wallet_address}")
    Call<ResponseDataReportedHashrates> getReportedHashrates(@Path("wallet_address") String walletAddress);

    @GET("workers/{wallet_address}")
    Call<ResponseDataWorkers> getWorkers(@Path("wallet_address") String walletAddress);

    //Kreiramo objekat retrofit kojim zovemo metodu Builder
    Retrofit retrofit = new Retrofit.Builder()
            //zovemo metodu baseUrl kojoj proslijedjujemo nas URL
            .baseUrl(BASE_URL)
            //zovemo metodu kojoj proslijedjuemo Json koji ce se namapirati u java klasu
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //kreiramo objekat service kako bi mogli koristiti metodu
    NanopoolAPI service = retrofit.create(NanopoolAPI.class);
}
