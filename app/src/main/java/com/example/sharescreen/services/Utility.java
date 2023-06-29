package com.example.sharescreen.services;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Utility {
    public static AlertDialog getAlertDialog(
            AppCompatActivity activity,
            String title,
            String message,
            boolean isCancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setCancelable(isCancelable);
        return builder.create();
    }
}
