package com.example.chikara.vollynetworkcommunication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mResultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.progressBar);
        mResultTV = findViewById(R.id.resultTV);


        new VolleyConnection(this, "",
                new VolleyConnection.VolleyResultListener() {
                    @Override
                    public void onSuccess(String response) {
                        mProgressBar.setVisibility(View.GONE);
                        mResultTV.setText("Response is :- " + "\n\n" + response);
                    }

                    @Override
                    public void onError(String errorMessage) {
                        mProgressBar.setVisibility(View.GONE);
                        mResultTV.setText("Response is :- " + "\n\n" + errorMessage);
                    }
                });
    }

}
