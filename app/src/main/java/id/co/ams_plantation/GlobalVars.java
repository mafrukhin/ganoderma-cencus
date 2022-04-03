package id.co.ams_plantation;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class GlobalVars {
    public static final String EXTERNAL_DIR_FILES = "/AMSApp/files";
    public static final String SELECTED_USER = "User";
    public static final String SELECTED_ESTATE = "SelEstate";
    public static String getDatabasePath(){
//        Log.e("Storage",Environment.getDataDirectory() + EXTERNAL_DIR_FILES +"/");
//        return Environment.getExternalStorageDirectory() + EXTERNAL_DIR_FILES +"/db/";
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
}
