package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class date extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);
        DatePicker dp = findViewById(R.id.dp);
        Button dpbtn = findViewById(R.id.dpbtn);
        TextView dptv = findViewById(R.id.dptv);

        dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Integer month = dp.getMonth();
                Integer day = dp.getDayOfMonth();
                dptv.setText(month + "월 " + day +"일");
            }
        });

        dpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer month = dp.getMonth();
                Integer day = dp.getDayOfMonth();
                dptv.setText(month + "월 " + day +"일 예약");
                Intent it = new Intent(getApplicationContext(),MainActivity.class);
                it.putExtra("date",month + "월 " + day +"일");
                setResult(101, it);
                finish();
            }
        });
    }
}
