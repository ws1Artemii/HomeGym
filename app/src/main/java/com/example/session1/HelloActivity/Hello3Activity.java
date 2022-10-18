package com.example.session1.HelloActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.session1.R;

public class Hello3Activity extends AppCompatActivity {

    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);

        SharedPreferences sp = getSharedPreferences("parameters", MODE_PRIVATE);
        edit = sp.edit();

        ImageView image = (ImageView) findViewById(R.id.image);

        if(sp.getInt("gender", 0) == 1)
            (image).setImageDrawable(getDrawable(R.drawable.male_image));

        AppCompatButton hands = findViewById(R.id.hands);
        boolean[] hands_bool = {false};
        AppCompatButton spine = findViewById(R.id.spine);
        boolean[] spine_bool = {false};
        AppCompatButton torso = findViewById(R.id.torso);
        boolean[] torso_bool = {false};
        AppCompatButton legs = findViewById(R.id.legs);
        boolean[] legs_bool = {false};

        Drawable bw = getDrawable(R.drawable.boxbutton_w);
        Drawable by = getDrawable(R.drawable.boxbutton_y);

        TranslateAnimation tl = new TranslateAnimation(image.getWidth(), 0, 0, 0);
        tl.setDuration(500);
        tl.setFillAfter(true);
        image.startAnimation(tl);
        image.setVisibility(View.VISIBLE);

        AlphaAnimation a = new AlphaAnimation(0, 1);
        a.setDuration(500);
        a.setFillAfter(true);

        hands.startAnimation(a);
        findViewById(R.id.line_hands).startAnimation(a);
        spine.startAnimation(a);
        findViewById(R.id.line_spine).startAnimation(a);
        torso.startAnimation(a);
        findViewById(R.id.line_torso1).startAnimation(a);
        findViewById(R.id.line_torso2).startAnimation(a);
        legs.startAnimation(a);
        findViewById(R.id.line_legs).startAnimation(a);

        hands.setVisibility(View.VISIBLE);
        findViewById(R.id.line_hands).setVisibility(View.VISIBLE);
        spine.setVisibility(View.VISIBLE);
        findViewById(R.id.line_spine).setVisibility(View.VISIBLE);
        torso.setVisibility(View.VISIBLE);
        findViewById(R.id.line_torso1).setVisibility(View.VISIBLE);
        findViewById(R.id.line_torso2).setVisibility(View.VISIBLE);
        legs.setVisibility(View.VISIBLE);
        findViewById(R.id.line_legs).setVisibility(View.VISIBLE);

        hands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!hands_bool[0]) {
                    hands_bool[0] = true;
                    spine_bool[0] = false;
                    torso_bool[0] = false;
                    legs_bool[0] = false;
                    view.setBackground(by);
                    spine.setBackground(bw);
                    torso.setBackground(bw);
                    legs.setBackground(bw);
                }
                else {
                    edit.putInt("muscle_group", 0);
                    Next();
                }
            }
        });
        spine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!spine_bool[0]) {
                    hands_bool[0] = false;
                    spine_bool[0] = true;
                    torso_bool[0] = false;
                    legs_bool[0] = false;
                    view.setBackground(by);
                    hands.setBackground(bw);
                    torso.setBackground(bw);
                    legs.setBackground(bw);
                }
                else {
                    edit.putInt("muscle_group", 1);
                    Next();
                }
            }
        });
        torso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!torso_bool[0]) {
                    hands_bool[0] = false;
                    spine_bool[0] = false;
                    torso_bool[0] = true;
                    legs_bool[0] = false;
                    view.setBackground(by);
                    spine.setBackground(bw);
                    hands.setBackground(bw);
                    legs.setBackground(bw);
                }
                else {
                    edit.putInt("muscle_group", 2);
                    Next();
                }
            }
        });
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!legs_bool[0]) {
                    hands_bool[0] = false;
                    spine_bool[0] = false;
                    torso_bool[0] = false;
                    legs_bool[0] = true;
                    view.setBackground(by);
                    spine.setBackground(bw);
                    torso.setBackground(bw);
                    hands.setBackground(bw);
                }
                else {
                    edit.putInt("muscle_group", 3);
                    Next();
                }
            }
        });
    }

    void Next() {
        edit.apply();
        startActivity(new Intent(Hello3Activity.this, Hello4Activity.class));
        finish();
    }
}