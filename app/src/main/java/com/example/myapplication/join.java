package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Vector;

public class join extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        Button BackBtn = findViewById(R.id.BackBtn);
        EditText JoinNameEt = findViewById(R.id.JoinNameEt);
        EditText JoinIdEt = findViewById(R.id.JoinIdEt);
        EditText YearEt = findViewById(R.id.YearEt);
        EditText MonthEt = findViewById(R.id.MonthEt);
        EditText DayEt = findViewById(R.id.DayEt);
        EditText JoinPassEt = findViewById(R.id.JoinPassEt);
        EditText JoinPass2Et = findViewById(R.id.JoinPass2Et);
        Button PassOkBtn = findViewById(R.id.PassOkBtn);
        EditText JoinEmailEt = findViewById(R.id.JoinEmailEt);
        Button JoinEt = findViewById(R.id.JoinEt);

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        PassOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(JoinPassEt.getText().toString().equals(JoinPass2Et.getText().toString())) {
                    JoinEt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MainActivity.v.add(new member(JoinNameEt.getText().toString(),
                                    JoinIdEt.getText().toString(),
                                    YearEt.getText().toString(),
                                    MonthEt.getText().toString(),
                                    DayEt.getText().toString(),
                                    JoinPassEt.getText().toString(),
                                    JoinEmailEt.getText().toString()));
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}

