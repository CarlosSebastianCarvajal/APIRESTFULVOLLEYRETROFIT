package com.example.apirestful_volley_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_retrofit;
    Button btn_volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_retrofit = findViewById(R.id.btnRetrofit);
        btn_volley = findViewById(R.id.btnVolley);

        btn_retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RetrofitActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        btn_volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VolleyActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}