package com.yyang2.demo_broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by yyang2 on 5/29/2016.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context); //build a dialog
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are force to be offlice. please try to login again.");
        dialogBuilder.setCancelable(false); // set the dialog can not be canceled
        dialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
           @Override
            public void onClick(DialogInterface dialog, int which) {
               ActivityCollector.finishAll();// kill all activity
               Intent intent = new Intent(context, LoginActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);//restart loginActivity
           }
        });
        AlertDialog alertDialog = dialogBuilder.create(); // need to set AlertDialog's type, make sure it can pop out from broadcast receiver.
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

    }
}
