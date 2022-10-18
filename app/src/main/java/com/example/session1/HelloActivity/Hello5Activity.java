
package com.example.session1.HelloActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.session1.R;
import com.example.session1.SignUpIn.SignInActivity;
import com.example.session1.classes.CustomDialog;

public class Hello5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello5);

        SharedPreferences sp = getSharedPreferences("parameters", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        EditText h = findViewById(R.id.height);
        EditText w = findViewById(R.id.weight);

        AppCompatButton next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(h.getText().toString().equals("")) {
                    new CustomDialog("Enter your height").show(getSupportFragmentManager(), null);
                } else if(w.getText().toString().equals("")) {
                    new CustomDialog("Enter your weight").show(getSupportFragmentManager(), null);
                } else {
                    edit.putFloat("height", Float.parseFloat(h.getText().toString()) );
                    edit.putFloat("weight", Float.parseFloat(w.getText().toString()) );
                    edit.apply();

                    startActivity(new Intent(Hello5Activity.this, SignInActivity.class));
                    finish();
                }
            }
        });

    }
}