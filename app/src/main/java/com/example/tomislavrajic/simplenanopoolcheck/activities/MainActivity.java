package com.example.tomislavrajic.simplenanopoolcheck.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tomislavrajic.simplenanopoolcheck.R;
import com.example.tomislavrajic.simplenanopoolcheck.models.ResponseDataBalance;
import com.example.tomislavrajic.simplenanopoolcheck.networking.NanopoolAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String BALANCE_PAYOUT = "balancePayout";
    public static final String ADDRESS_PREFERENCES = "addressPrefs";
    public static final String WALLET_ADDRESS = "walletAddress";
    public static final String ADDRESS = "address";

    private EditText walletAddress;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        walletAddress = findViewById(R.id.wallet_address);
        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        Button saveButton = findViewById(R.id.save_bt);
        Button getInfoButton = findViewById(R.id.get_info_bt);

        sharedPreferences = getSharedPreferences(ADDRESS_PREFERENCES, Context.MODE_PRIVATE);
        walletAddress.setText(sharedPreferences.getString(WALLET_ADDRESS, getString(R.string.no_data)));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String addressInput = walletAddress.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(WALLET_ADDRESS, addressInput);
                editor.apply();
                Toast.makeText(MainActivity.this, R.string.wallet_address_saved, Toast.LENGTH_SHORT).show();
            }
        });

        getInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                final String walletAddress = MainActivity.this.walletAddress.getText().toString();
                NanopoolAPI.service.getBalancePayout(walletAddress).enqueue(new Callback<ResponseDataBalance>() {

                    @Override
                    public void onResponse(@NonNull Call<ResponseDataBalance> call, @NonNull Response<ResponseDataBalance> response) {
                        if (response.body().isStatus()) {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            assert response.body() != null;
                            intent.putExtra(BALANCE_PAYOUT, response.body().getData());
                            intent.putExtra(ADDRESS, walletAddress);
                            startActivity(intent);
                            progressBar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(MainActivity.this, R.string.account_not_found, Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseDataBalance> call, @NonNull Throwable t) {

                        progressBar.setVisibility(View.GONE);

                        Toast.makeText(MainActivity.this, R.string.failed_to_connect, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}