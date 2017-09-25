package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.w;

public class CrashUploadAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        w.d("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
        if (a.bHL() == 0) {
            ExceptionMonitorService.dR(context);
        }
    }
}
