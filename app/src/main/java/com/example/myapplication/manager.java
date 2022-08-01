package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

public class manager extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager);
        ListView list = findViewById(R.id.list);
        TextView select = findViewById(R.id.select);
        Button delebtn = findViewById(R.id.delebtn);
        Button manaLogoutbtn = findViewById(R.id.manaLogoutbtn);
        ArrayList<String> na = new ArrayList<>();
        for(int i = 0; i < MainActivity.v.size(); i++){
            na.add(MainActivity.v.get(i).name);
        }
        ArrayAdapter<String> adpater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, na);
        list.setAdapter(adpater);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String data = (String) adapterView.getItemAtPosition(position);
                select.setText(data);
            }
        });

        manaLogoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        delebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(select.getText().toString().isEmpty()){
                    na.remove(select.getText().toString());
                }
            }
        });

    }
}
