package com.example.sharescreen;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.util.Log;

import com.example.sharescreen.services.PermissionManager;
import com.example.sharescreen.services.Utility;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            ArrayList<String> toAsk = PermissionManager.getPermissionsToAsk(this);
            if(toAsk.size() > 0) {
                ActivityCompat.requestPermissions(this, toAsk.toArray(new String[0]), PermissionManager.PERMISSION_ALL);
            }
        } catch (Exception e) {
            AlertDialog alert = Utility.getAlertDialog(this, "Error", "Request permission not working", true);
            alert.show();
        }
    }
}