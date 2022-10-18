package com.example.session1.SignUpIn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.session1.R;

public class SignInActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText reppass;

    private AppCompatButton signin;

    private TextView signup;
    private TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        reppass = findViewById(R.id.repeatpassword);

        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);
        skip = findViewById(R.id.skip);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout.LayoutParams name_params = (LinearLayout.LayoutParams) name.getLayoutParams();
                LinearLayout.LayoutParams pass_params = (LinearLayout.LayoutParams) password.getLayoutParams();

                Animation a = new Animation() {
                    @Override
                    protected void applyTransformation(float interpolatedTime, Transformation t) {

                        name_params.bottomMargin = (int)(interpolatedTime * 68);
                        pass_params.bottomMargin = (int)(interpolatedTime * 68);

                        name.setLayoutParams(name_params);
                        password.setLayoutParams(pass_params);

                        email.setAlpha(interpolatedTime);
                        reppass.setAlpha(interpolatedTime);

                        signup.setAlpha(1 - interpolatedTime);
                        skip.setAlpha(1 - interpolatedTime);

                    }
                };

                email.setVisibility(View.VISIBLE);
                reppass.setVisibility(View.VISIBLE);
                skip.setVisibility(View.INVISIBLE);

                a.setDuration(500);
                a.setFillAfter(true);
                name.startAnimation(a);
                email.startAnimation(a);
                password.startAnimation(a);
                reppass.startAnimation(a);
                signup.startAnimation(a);
                skip.startAnimation(a);

            }
        });
    }
}