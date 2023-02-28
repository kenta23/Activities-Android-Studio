package com.example.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Flashlight extends AppCompatActivity {

    private CameraManager myCameraManager;
    private String myCameraID;
    private boolean flashlight_power = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashlight);

        myCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        ImageButton btnSwitchOffOn = findViewById(R.id.imgbtn_switch_off_on);

        try {
            myCameraID = myCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }


        btnSwitchOffOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flashlight_power)
                {
                    btnSwitchOffOn.setImageResource(R.drawable.switch_off);
                    TurnOffFlashlight();

                    flashlight_power = false;
                    Toast.makeText(getApplicationContext(),"Flashlight has been turned off",Toast.LENGTH_SHORT).show();
                } else
                {
                    btnSwitchOffOn.setImageResource(R.drawable.switch_on);
                    TurnOnFlashlight();

                    flashlight_power = true;
                    Toast.makeText(getApplicationContext(),"Flashlight has been turned on",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void TurnOnFlashlight()
    {
        try {
            myCameraManager.setTorchMode(myCameraID, true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    private void TurnOffFlashlight()
    {
        try {
            myCameraManager.setTorchMode(myCameraID, false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

}