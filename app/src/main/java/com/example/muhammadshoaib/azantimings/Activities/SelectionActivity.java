package com.example.muhammadshoaib.azantimings.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.muhammadshoaib.azantimings.SharedPreferencesConfig;

public class SelectionActivity extends AppCompatActivity implements View.OnClickListener {


    //Declaring necessory varriables
    private Button btnTwelve,btnTwentyFour,btnPreference;
    private String FORMAT_KEY="format_key";
    private Intent intent;
    private static final String MyPREFERENCES = "MyPrefs";
    private int formatValue = 24;
    private SharedPreferencesConfig sharedPreferencesConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        //Initializing buttons and make instance of SharedPreference Class
        btnTwelve = findViewById(R.id.btn_twelve);
        btnTwentyFour = findViewById(R.id.btn_twenty_four);
        btnPreference = findViewById(R.id.btn_preference);
        btnTwelve.setOnClickListener(this);
        btnTwentyFour.setOnClickListener(this);
        btnPreference.setOnClickListener(this);

        sharedPreferencesConfig=new SharedPreferencesConfig(this);
    }


    //this method will check which button is clicked
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            //if user clicks 12 hour format button it will show the next activity and format the data in twelve hour and set shared preference
            case R.id.btn_twelve:

                Intent intent = new Intent(this,MainActivity.class);
                formatValue = 12;
                intent.putExtra(FORMAT_KEY,formatValue);
                startActivity(intent);
                sharedPreferencesConfig.writeFormat(formatValue);
            break;

            //if user clicks 24 hour format button it will show the next activity and format the data in twenty four hour and set shared preference
            case R.id.btn_twenty_four:
                 intent = new Intent(this,MainActivity.class);
                 formatValue = 24;
                intent.putExtra(FORMAT_KEY,formatValue);
                startActivity(intent);
                sharedPreferencesConfig.writeFormat(formatValue);
                break;

                //if the user clicks this button ,it will retrive prefernece from shared preference and set the format in next actvity
            case R.id.btn_preference:

                formatValue = sharedPreferencesConfig.readFormat();
                intent = new Intent(this,MainActivity.class);
                intent.putExtra(FORMAT_KEY,formatValue);
                startActivity(intent);
                break;
        }

    }
}
