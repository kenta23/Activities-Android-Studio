package com.example.myactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnActivity1 (View view) {
        Intent Activity1 = new Intent(this, Helloworld.class);
        startActivity(Activity1);
    }

    public void btnActivity2 (View view) {
        Intent Activity2 = new Intent(this, CelsiusToFahrenheit.class);
        startActivity(Activity2);
    }
    public void btnActivity3 (View view) {
        Intent Activity3 = new Intent(this, Flashlight.class);
        startActivity(Activity3);
    }
}