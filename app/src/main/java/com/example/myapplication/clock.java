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

public class clock extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock);
        TimePicker tp = findViewById(R.id.tp);
        Button tpbtn = findViewById(R.id.timebtn);
        TextView tptv = findViewById(R.id.timetv);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Integer hour = tp.getHour();
                Integer min = tp.getMinute();
                tptv.setText(hour + "시 " + min +"분");
            }
        });

        tpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MainActivity.class);
                Integer hour = tp.getHour();
                Integer min = tp.getMinute();
                tptv.setText(hour + "시 " + min +"분 예약");
                it.putExtra("time",hour + "시 " + min +"분");
                setResult(100, it);
                finish();
            }
        });
    }
}
