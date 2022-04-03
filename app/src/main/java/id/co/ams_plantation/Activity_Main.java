package id.co.ams_plantation;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;

import id.co.ams_plantation.R;

import java.io.File;
import java.util.ArrayList;

public class Activity_Main extends AppCompatActivity {
    boolean isPermissionOK = true;
    private TextView tvName,tvKebun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvKebun = (TextView) findViewById(R.id.tv_state);
        String PathFolder = Environment.getExternalStorageDirectory() + "/" + "GAMAFiles" + "/";
        File savean = new File(PathFolder);
        if (!savean.exists()){
            savean.mkdir();
        }

        ArrayList<String> permissionList = new ArrayList<>();
        if(!checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE))permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        loadData();
        File dbPath = new File(GlobalVars.getDatabasePath());
        if (dbPath.exists()){
//            loadData();
        }
        else {
            Log.i("DBRoot","Not Found");
        }

    }

    private boolean checkPermission(String permission){
        int result = ContextCompat.checkSelfPermission(this,permission);
        if(result== PackageManager.PERMISSION_GRANTED){
            isPermissionOK &= true;
            return true;
        }else{
            isPermissionOK &=false;
            return false;
        }
    }

//    public void loadData(){
//        WaspDb db = WaspFactory.openOrCreateDatabase(GlobalVars.getDatabasePath(),
//                GlobalVars.DB_MASTER,
//                GlobalVars.getDatabasePass());
//        Log.i("LoadDataDB",db.toString());
//        if (db != null){
//            Log.i("LoadData","true");
//            WaspHash tblUser = db.openOrCreateHash(GlobalVars.SELECTED_USER);
//            WaspHash tblEstate = db.openOrCreateHash(GlobalVars.SELECTED_ESTATE);
//            HashMap<User,User> listUser= tblUser.getAllData();
//            User user = (User) tblUser.get(GlobalVars.SELECTED_USER);
//            Estate estate = (Estate) tblEstate.get(GlobalVars.SELECTED_ESTATE);
//
////            Log.i("DBUser",Integer.toString(tblUser.getAllValues().size()));
//            if (tblUser.getAllValues().size()>0){
//                Log.i("UserName",user.getUserFullName());
//                tvName.setText(user.getUserFullName());
//                tvKebun.setText(estate.getEstName());
//            }else {Log.i("UserName","Notfound");}
//        }
//        else Log.i("UserName","Notfound");
//
//
//    }

    private void requestPermission(String[] permission,int reqcode){
        ActivityCompat.requestPermissions(this,permission,reqcode);
    }
}
