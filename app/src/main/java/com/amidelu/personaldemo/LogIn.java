package com.amidelu.personaldemo;

import android.graphics.LinearGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    EditText userEditText, passEditText;

    String dbName = "amidelu";
    int dbPass = 12345678;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userEditText = findViewById(R.id.usernameId);
        passEditText = findViewById(R.id.passwordId);


    }

    public void logInClick(View view) {
        String userName = userEditText.getText().toString();

        if (userName.isEmpty()) {
            showError(userEditText);

        }else {
            if (userName.length()<5) {
                userEditText.setError("Username is too short!");

            }else if (userName.equals(dbName)) {
                Toast.makeText(LogIn.this, "Username is valid", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(LogIn.this, "Username isn't valid", Toast.LENGTH_SHORT).show();
            }
        }

        String passWordText = passEditText.getText().toString();

        if (passWordText.isEmpty()) {
            showError(passEditText);

        } else if (passWordText.length()<6) {
            passEditText.setError("Password is too short");

        }else if (!TextUtils.isEmpty(passWordText)) {
            int passWord = Integer.parseInt(passWordText);

        }else {
            Toast.makeText(LogIn.this, "Password is correct", Toast.LENGTH_SHORT).show();

        }

    }

    private void showError (View v) {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        if (v.getId() == R.id.usernameId) {
            userEditText.startAnimation(shake);

        }else if (v.getId() == R.id.passwordId) {
            passEditText.startAnimation(shake);

        }

    }
}
