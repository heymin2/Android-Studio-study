package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etxt1 = findViewById(R.id.etxt1);
        EditText etxt2 = findViewById(R.id.etxt2);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etxt1.length() > 0 && etxt2.length() > 0) {
                    Intent it = new Intent(getApplicationContext(), date.class);
                    startActivityForResult(it, 100);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etxt1.length() > 0 && etxt2.length() > 0) {
                    Intent it = new Intent(getApplicationContext(), clock.class);
                    startActivityForResult(it, 101);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101){
            String time = data.getStringExtra("time");

            tv1.setText(time);
        } else if(requestCode==100){
            String date = data.getStringExtra("date");
            tv2.setText(date);
        }
    }
}