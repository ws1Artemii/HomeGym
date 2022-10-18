package com.example.session1.HelloActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragAndDropPermissions;
import android.view.View;

import com.example.session1.R;

public class Hello2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);

        SharedPreferences sp = getSharedPreferences("parameters", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        AppCompatButton female = findViewById(R.id.female);
        final boolean[] female_bool = {false};
        AppCompatButton male = findViewById(R.id.male);
        final boolean[] male_bool = {false};

        AppCompatButton next = findViewById(R.id.next);

        Drawable fw = getDrawable(R.drawable.female_xml_w);
        Drawable fy = getDrawable(R.drawable.female_xml_y);

        Drawable mw = getDrawable(R.drawable.male_xml_w);
        Drawable my = getDrawable(R.drawable.male_xml_y);
        Drawable by = getDrawable(R.drawable.boxbutton_y);

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!female_bool[0]) {
                    female_bool[0] = true;
                    male_bool[0] = false;
                    male.setBackground(mw);
                    female.setBackground(fy);
                    next.setBackground(by);
                    edit.putInt("gender", 0);
                }
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!male_bool[0]) {
                    male_bool[0] = true;
                    female_bool[0] = false;
                    male.setBackground(my);
                    female.setBackground(fw);
                    next.setBackground(by);
                    edit.putInt("gender", 1);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(female_bool[0] || male_bool[0]) {
                    edit.apply();
                    startActivity(new Intent(Hello2Activity.this, Hello3Activity.class));
                    finish();
                }
            }
        });
    }
}