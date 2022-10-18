package com.example.session1.HelloActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.session1.R;

public class Hello4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello4);

        SharedPreferences sp = getSharedPreferences("parameters", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        ConstraintLayout newbie = findViewById(R.id.newbie);
        boolean[] newbie_bool = {false};
        ConstraintLayout advanced = findViewById(R.id.advanced);
        boolean[] advanced_bool = {false};
        ConstraintLayout keepon = findViewById(R.id.keepon);
        boolean[] keepon_bool = {false};

        Drawable bw = getDrawable(R.drawable.boxbutton_w);
        Drawable by = getDrawable(R.drawable.boxbutton_y);

        AppCompatButton next = findViewById(R.id.next);

        newbie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!newbie_bool[0]) {
                    view.setBackground(by);
                    next.setBackground(by);
                    keepon.setBackground(bw);
                    advanced.setBackground(bw);
                    newbie_bool[0] = true;
                    advanced_bool[0] = false;
                    keepon_bool[0] = false;
                    edit.putInt("level", 0);
                }
            }
        });
        keepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!keepon_bool[0]) {
                    view.setBackground(by);
                    next.setBackground(by);
                    newbie.setBackground(bw);
                    advanced.setBackground(bw);
                    newbie_bool[0] = false;
                    advanced_bool[0] = false;
                    keepon_bool[0] = true;
                    edit.putInt("level", 1);
                }
            }
        });
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!advanced_bool[0]) {
                    view.setBackground(by);
                    next.setBackground(by);
                    newbie.setBackground(bw);
                    keepon.setBackground(bw);
                    newbie_bool[0] = false;
                    advanced_bool[0] = true;
                    keepon_bool[0] = false;
                    edit.putInt("level", 2);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newbie_bool[0] || advanced_bool[0] || keepon_bool[0]) {
                    edit.apply();
                    Next();
                }
            }
        });
    }

    void Next() {
        startActivity(new Intent(Hello4Activity.this, Hello5Activity.class));
        finish();
    }
}