package com.example.broadcastbestpractice.broadcastreceiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

import com.example.broadcastbestpractice.activity.LoginActivity;
import com.example.broadcastbestpractice.widget.ActivityCollector;

/**
 * Created by SJC on 2016/9/1.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCollector.finishAll(); // 销毁所有活动
                        Intent mIntent = new Intent(context, LoginActivity.class);
                        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(mIntent); // 重新启动LoginActivity
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
        // 需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
