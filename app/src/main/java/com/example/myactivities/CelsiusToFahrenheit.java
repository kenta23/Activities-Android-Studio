package com.example.myactivities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CelsiusToFahrenheit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celsius_to_fahrenheit);

        Button btnConvert;
        EditText editTextCelsius;
        TextView textViewtvResult;

        btnConvert = (Button) findViewById(R.id.btnConvert);
        editTextCelsius = (EditText) findViewById(R.id.editCelsius);
        textViewtvResult = (TextView) findViewById(R.id.tvResult);

        btnConvert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        double celsius = Double.parseDouble(editTextCelsius.getText().toString());
                        double fahrenheit = (celsius * 1.8) + 32;
                        double numFormat = (double) (Math.round(fahrenheit * 100.0 ) / 100.0) ;
                        textViewtvResult.setText("Fahrenheit = "+numFormat);
                    }
                }
        );

    }
}