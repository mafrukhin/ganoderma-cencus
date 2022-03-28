package com.halo.profileui;

import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.halo.profileui.Model.Estate;
import com.halo.profileui.Model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

//import id.co.ams_plantation.testukhin.model.Estate;
//import id.co.ams_plantation.testukhin.model.User;

public class GlobalHelper {
    public static final String SELECTED_USER = "User";
    public static final String SELECTED_ESTATE = "SelEstate";
    public static final String PASSWORD_ENCRYPT = "KopiNikmatGakBikinKembung";
    public static final String ESTATE_FULL_NAME = "EstateFullName";
    public static final String EXTERNAL_DIR_FILES = "/AMSApp/files";
    public static final String PATH_SELMOD_FILE = Environment.getExternalStorageDirectory() + GlobalHelper.EXTERNAL_DIR_FILES +"/db/ModFile";
    public static final String FONT_CORBERT = "CorbertCondensed-Regular.otf";
    public static final int TYPE_2DMAP = 1;
    public static final int TYPE_KMLBLOCK = 2;
    public static final int TYPE_TPK = 3;
    public static final int TYPE_VKM = 4;

    public static String getDatabasePath(){
        Log.e("Storage", Environment.getDataDirectory() + EXTERNAL_DIR_FILES +"/");
        return Environment.getExternalStorageDirectory() + EXTERNAL_DIR_FILES +"/db/";
    }

    public static String getFileContent(String fileName){
        File file = new File(getDatabasePath(),fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFileContent2(String fileName){
        Log.i(GlobalHelper.class.getSimpleName(), "getFileContent2: fileName:"+fileName);
        File file = new File(fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isFileContentAvailable(String fileName){
        File file = new File(getDatabasePath(),fileName);
        return file.exists();
    }
    public static User getUser(){
        Gson gson = new Gson();
        Log.e("Encryp", Encrypts.encrypt(SELECTED_USER));
        if(isFileContentAvailable(Encrypts.encrypt(SELECTED_USER))){
            User user = gson.fromJson(
                    Encrypts.decrypt(getFileContent(Encrypts.encrypt(SELECTED_USER))),
                    User.class);
            Log.e("User",gson.toJson(user));
            return user;
        }
        return null;
    }
    public static Estate getEstate(){
        Gson gson = new Gson();
        if(isFileContentAvailable(Encrypts.encrypt(SELECTED_ESTATE))){
            Estate estate = gson.fromJson(
                    Encrypts.decrypt(getFileContent(Encrypts.encrypt(SELECTED_ESTATE))),
                    Estate.class);
            Log.e("User",gson.toJson(estate));
            return estate;
        }
        return null;
    }
    public static boolean isPackageAvailable(String packagename, PackageManager packageManager){
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static String readFileContent(String path){
        try{
            File root = new File(path);
            File file = new File(root.getParentFile(),Encrypts.encrypt(root.getName()));

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=bufferedReader.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            Toast.makeText(MainActivity.getContext(),
//                    e.toString(), Toast.LENGTH_SHORT);
            Log.i("Toast",e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("Toast",e.toString());
//            Toast.makeText(PZOApp.getContext(),
//                    e.toString(), Toast.LENGTH_SHORT);
        }
        return null;
    }
}
