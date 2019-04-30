package com.amidelu.personaldemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

//    Global variable declared
    EditText userEditText, passEditText;
    TextView registerText;
    Intent intent;
    String dbUser = "amidelu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userEditText = findViewById(R.id.usernameId);
        passEditText = findViewById(R.id.passwordId);
        registerText = findViewById(R.id.registerId);

    }

//    Login condition and transfer to next activity after successful validation pass
    public void logInClick(View view) {

        String userNameValid = userEditText.getText().toString();

        if (checkValidation() && userNameValid.equals(dbUser)) {

            intent = new Intent(LogIn.this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(LogIn.this, "Please check User ID or Password", Toast.LENGTH_SHORT).show();
        }

    }

//    Boolean method for error checking process and calling blank field animation from anim
    private boolean checkValidation() {

        boolean confirmed = true;

        String userName = userEditText.getText().toString();

        if (userName.isEmpty()) {
            showError(userEditText);
            confirmed = false;

        }else {
            if (userName.length()<5) {
                userEditText.setError("Username is too short!");
                confirmed = false;

            }
        }

        String passWordText = passEditText.getText().toString();

        if (passWordText.isEmpty()) {
            showError(passEditText);
            confirmed = false;

        } else if (passWordText.length()<6) {
            passEditText.setError("Password is too short");
            confirmed = false;

        }

        return confirmed;
    }


//    Defining Blank field animation method
    private void showError (View v) {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        if (v.getId() == R.id.usernameId) {
            userEditText.startAnimation(shake);

        }else if (v.getId() == R.id.passwordId) {
            passEditText.startAnimation(shake);

        }

    }

    public void registerClick(View view) {
                intent = new Intent(LogIn.this, Register.class);
                startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LogIn.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

}
