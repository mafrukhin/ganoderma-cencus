package id.co.ams_plantation;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import id.co.ams_plantation.R;
import com.google.gson.Gson;
import id.co.ams_plantation.Model.Estate;
import id.co.ams_plantation.Model.User;
import id.co.ams_plantation.Model.UserModuleAccess;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {
    private TextView tvName,tvKebun;
    boolean isPermissionOK = true;
    String strUser;
    String strEst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvKebun = (TextView) findViewById(R.id.tv_state);

        ArrayList<String> permissionList = new ArrayList<>();


        if(!checkPermission(Manifest.permission.INTERNET)) permissionList.add(Manifest.permission.INTERNET);
        if(!checkPermission(Manifest.permission.ACCESS_NETWORK_STATE))permissionList.add(Manifest.permission.ACCESS_NETWORK_STATE);
        if(!checkPermission(Manifest.permission.ACCESS_WIFI_STATE))permissionList.add(Manifest.permission.ACCESS_WIFI_STATE);
        if(!checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE))permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(!checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION))permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        if(!checkPermission(Manifest.permission.ACCESS_FINE_LOCATION))permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);

        String[] strPermission = new String[permissionList.size()];

        if(permissionList.size()>0){
            requestPermission(permissionList.toArray(strPermission),1);
        }else{
            screeningApplication();

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
    private void requestPermission(String[] permission,int reqcode){
        ActivityCompat.requestPermissions(this,permission,reqcode);
    }

    private void screeningApplication(){
        if(GlobalHelper.getUser()!=null && GlobalHelper.getEstate()!=null &&
                GlobalHelper.isPackageAvailable("id.co.ams_plantation.amsadminapps",getPackageManager())){
//              Log.i("if","true");
            authenticated();
        }else{
//            Log.i("else","True");

            WidgetHelper.showOKDialog(this,
                    "Warning",
                    "Anda tidak memiliki akses ke aplikasi ini!",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    }
            );
        }
    }
    private void authenticated(){

        String value = GlobalHelper.readFileContent(GlobalHelper.PATH_SELMOD_FILE);
        if(value == null){
            WidgetHelper.showOKDialog(this,
                    "Warning",
                    "Mohon Buka Admin Apps Dalam Mode Online Dahulu",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent intent = getPackageManager().getLaunchIntentForPackage("id.co.ams_plantation.amsadminapps");
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }
            );
            return;
        }
        try {
            Boolean bisaMasuk = false;
            JSONArray jsonArray = new JSONArray(Encrypts.decrypt(value));
            for (int i = 0; i < jsonArray.length(); i++) {
                Gson gson = new Gson();
                UserModuleAccess userModuleAccess = gson.fromJson(jsonArray.get(i).toString(), UserModuleAccess.class);
                if (userModuleAccess.getMdlAccCode().contains("PZO")) {
                    bisaMasuk = true;
                    break;
                }
            }
            if(bisaMasuk) {

                if (getIntent().getExtras() != null) {
                    if (getIntent().getExtras().containsKey("message")) {
                        String msg = getIntent().getExtras().getString("message");
                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                    }
                }

                strUser = GlobalVars.getFileContent(Encrypts.encrypt(GlobalVars.SELECTED_USER));
                strEst = GlobalVars.getFileContent(Encrypts.encrypt(GlobalVars.SELECTED_ESTATE));
                final Gson gson = new Gson();
                if(strUser!=null && strEst!=null) {
                    strUser = Encrypts.decrypt(strUser);
                    strEst = Encrypts.decrypt(strEst);
                    final User user = (User) gson.fromJson(strUser, User.class);
                    Estate estate = (Estate) gson.fromJson(strEst, Estate.class);
                    tvName.setText(user.getUserFullName());
                    tvKebun.setText(estate.getCompanyShortName() + " - " + estate.getEstCode() + " "
                            + estate.getEstName());
                }
//                final Gson gson = new Gson();
//                final File file = new File(GlobalVars.getDatabasePath(), Encrypts.encrypt(GlobalVars.PZO_USERAUTH));
//                Log.e("Apps", file.getAbsolutePath());

//                final WaspHash waspHash1 = GlobalVars.getTableHash(GlobalVars.PZO_PIEZOMETER);
//                final WaspHash waspHashNew = GlobalVars.getTableHash(GlobalVars.PZO_PIEZOMETER_NEW);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}