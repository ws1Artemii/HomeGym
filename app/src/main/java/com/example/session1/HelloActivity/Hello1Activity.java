package com.example.session1.HelloActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.DrawableUtils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.session1.R;

public class Hello1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello1);

        SharedPreferences sp = getSharedPreferences("parameters", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        AppCompatButton welost = findViewById(R.id.welost);
        boolean[] welost_bool = {false};
        AppCompatButton yoga = findViewById(R.id.yoga);
        boolean[] yoga_bool = {false};
        AppCompatButton muscle = findViewById(R.id.muscle);
        boolean[] muscle_bool = {false};

        Drawable bw = getDrawable(R.drawable.boxbutton_w);
        Drawable by = getDrawable(R.drawable.boxbutton_y);

        welost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!welost_bool[0]) {
                    welost_bool[0] = true;
                    yoga_bool[0] = false;
                    muscle_bool[0] = false;
                    yoga.setBackground(bw);
                    muscle.setBackground(bw);
                    welost.setBackground(by);
                }
                else {
                    edit.putInt("type", 0);
                    edit.apply();
                    Next();
                }
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!yoga_bool[0]) {
                    welost_bool[0] = false;
                    yoga_bool[0] = true;
                    muscle_bool[0] = false;
                    yoga.setBackground(by);
                    muscle.setBackground(bw);
                    welost.setBackground(bw);
                }
                else {
                    edit.putInt("type", 1);
                    edit.apply();
                    Next();
                }
            }
        });
        muscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!muscle_bool[0]) {
                    welost_bool[0] = false;
                    yoga_bool[0] = false;
                    muscle_bool[0] = true;
                    yoga.setBackground(bw);
                    muscle.setBackground(by);
                    welost.setBackground(bw);
                }
                else {
                    edit.putInt("type", 2);
                    edit.apply();
                    Next();
                }
            }
        });
    }
    void Next() {
        startActivity(new Intent(Hello1Activity.this, Hello2Activity.class));
        finish();
    }
}