package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;
class member{
    String name;
    String id;
    String pass;
    String year;
    String month;
    String day;
    String email;
    member(String name, String id, String pass, String year, String month, String day, String email){
        this.name = name;
        this.id = id;
        this.pass = pass;
        this.year = year;
        this.month = month;
        this.day = day;
        this.email = email;
    }
}
public class MainActivity extends AppCompatActivity {
    static Vector<member> v = new Vector<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText idEt = findViewById(R.id.IdET);
        EditText paEt = findViewById(R.id.PassET);
        Button Loginbtn = findViewById(R.id.LoginBtn);
        Button managebtn = findViewById(R.id.ManaBtn);
        Button LoginUpBtn = findViewById(R.id.LoginUpBtn);

        Vector<String> log = new Vector<>();


        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < v.size(); i++){
                    if(idEt.getText().toString().equals(v.get(i).id) && paEt.getText().toString().equals(v.get(i).pass)) {
                        Intent it = new Intent(getApplicationContext(), page1.class);
                        startActivity(it);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "로그인 실패!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        managebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idEt.getText().toString().equals("1") && paEt.getText().toString().equals("1")) {
                    Intent it = new Intent(getApplicationContext(), manager.class);
                    startActivity(it);
                }
            }
        });

        LoginUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), join.class);
                startActivity(intent);
            }
        });
    }
}
