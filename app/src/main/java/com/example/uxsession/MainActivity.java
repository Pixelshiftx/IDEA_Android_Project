package com.example.uxsession;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button loginB;
    private EditText unameLog, passLog;
    private TextView errMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        //if input is fulfilled
        loginB.setOnClickListener(v -> {
            if (CheckInputs())
            {
                OpenHomePage();
            }
        });
    }

    //open page + pass username value
    protected void OpenHomePage()
    {
        Intent userPass = new Intent(this, Menu.class);

        String storeUname = unameLog.getText().toString();
        userPass.putExtra("UserName",storeUname);
        startActivity(userPass);
    }

    //find view
    protected void findViews()
    {
        loginB = findViewById(R.id.loginButton);
        unameLog = findViewById(R.id.usernameInput);
        passLog = findViewById(R.id.passwordInput);
        errMsg = findViewById(R.id.errorText);
    }

    //check input
    protected boolean CheckInputs() {
        if (unameLog.length() == 0) {
            errMsg.setVisibility(View.VISIBLE);
            unameLog.setError("Username must be filled!");
            errMsg.setText("Username must be filled!");
            return false;
        }

        else if (unameLog.length() <8 || unameLog.length()>24) {
            errMsg.setVisibility(View.VISIBLE);
            unameLog.setError("Username length must be between 8 and 24!");
            errMsg.setText("Username length must be between 8 and 24!");
            return false;
        }
        else if (passLog.length() == 0) {
            errMsg.setVisibility(View.VISIBLE);
            passLog.setError("Password must be filled!");
            errMsg.setText("Password must be filled!");
            return false;
        }
        return true;
    }
}