package com.example.tomislavrajic.simplenanopoolcheck.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.tomislavrajic.simplenanopoolcheck.R;
import com.example.tomislavrajic.simplenanopoolcheck.adapters.WorkerRecyclerViewAdapter;
import com.example.tomislavrajic.simplenanopoolcheck.models.ResponseDataBalance;
import com.example.tomislavrajic.simplenanopoolcheck.models.ResponseDataEtherscan;
import com.example.tomislavrajic.simplenanopoolcheck.models.ResponseDataReportedHashrates;
import com.example.tomislavrajic.simplenanopoolcheck.networking.EtherscanAPI;
import com.example.tomislavrajic.simplenanopoolcheck.networking.NanopoolAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mWorkerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mRecyclerView = findViewById(R.id.recycler_view);

        final TextView balancePayout = findViewById(R.id.balance_payout);
        double balPayout = getIntent().getDoubleExtra(MainActivity.BALANCE_PAYOUT, 0);
        String address = getIntent().getStringExtra("address");
        balancePayout.setText(String.valueOf(balPayout).substring(0, 12));

        getReportedHashrate(address);
        getBalanceEtherscan(address);
        getReportedHashrates(address);
    }

    private void getReportedHashrate(String address) {

        final TextView reportedHashrate = findViewById(R.id.reported_hashrate);

        NanopoolAPI.service.getReportedHashrate(address).enqueue(new Callback<ResponseDataBalance>() {
            @Override
            public void onResponse(@NonNull Call<ResponseDataBalance> call, @NonNull Response<ResponseDataBalance> response) {
                reportedHashrate.setText(String.valueOf(response.body().getData()));
            }

            @Override
            public void onFailure(@NonNull Call<ResponseDataBalance> call, @NonNull Throwable t) {

            }
        });
    }

    private void getBalanceEtherscan(String address) {

        final TextView balanceEtherscan = findViewById(R.id.balance);

        EtherscanAPI.service.getBalanceEtherscan(
                "balance",
                "account",
                address,
                "RBI9RZA28AS81N1EJKRZ2SGG83N91Y7AI7")
                .enqueue(new Callback<ResponseDataEtherscan>() {
                    @Override
                    public void onResponse(
                            @NonNull Call<ResponseDataEtherscan> call,
                            @NonNull Response<ResponseDataEtherscan> response) {
                        balanceEtherscan.setText(String.valueOf(response.body().getResult()).substring(0, 12));
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseDataEtherscan> call, @NonNull Throwable t) {
                    }
                });
    }

    private void getReportedHashrates(String address) {

        NanopoolAPI.service.getReportedHashrates(address).enqueue(new Callback<ResponseDataReportedHashrates>() {

            @Override
            public void onResponse(
                    @NonNull Call<ResponseDataReportedHashrates> call,
                    @NonNull Response<ResponseDataReportedHashrates> response) {
                mLayoutManager = new LinearLayoutManager(ResultActivity.this);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mWorkerAdapter = new WorkerRecyclerViewAdapter(response.body().getData());
                mRecyclerView.setAdapter(mWorkerAdapter);

            }

            @Override
            public void onFailure(@NonNull Call<ResponseDataReportedHashrates> call, @NonNull Throwable t) {
            }
        });
    }

}
