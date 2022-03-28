package com.halo.profileui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class WidgetHelper {
    public static AlertDialog showOKDialog(Context context,
                                           String title,
                                           String message,
                                           DialogInterface.OnClickListener onClickListener){
//        View view = (View) LayoutInflater.from(context).inflate(R.layout.custom_upload_dialog_layout,null);
        AlertDialog alertDialog = new AlertDialog
                .Builder(context, R.style.MyAlertDialogStyle)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK",onClickListener)
                .create();
        alertDialog.show();
        return alertDialog;
    }
}
