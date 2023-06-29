package com.example.sharescreen.services;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PermissionManager {
    public static int PERMISSION_ALL = 1;
    public static boolean checkPermissions(AppCompatActivity activity, String requestedPermission) {
        return ContextCompat.checkSelfPermission(activity, requestedPermission) == PackageManager.PERMISSION_GRANTED;
    }
    public static String[] getPermissions(AppCompatActivity activity) throws PackageManager.NameNotFoundException {
        PackageInfo info = activity.getPackageManager().getPackageInfo(activity.getPackageName(), PackageManager.GET_PERMISSIONS);
        return info.requestedPermissions;
    }
    public static ArrayList<String> getPermissionsToAsk(AppCompatActivity activity) throws PackageManager.NameNotFoundException {
        ArrayList<String> permissionsToAsk = new ArrayList<String>();
        String[] neededPermissions = getPermissions(activity);
        for(String permission: neededPermissions) {
            if(!checkPermissions(activity, permission)) {
                permissionsToAsk.add(permission);
            }
        }
        return permissionsToAsk;
    }

}
