package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.a.aa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;

public class BakOldUSBReceiver extends BroadcastReceiver {
    private static String jJC = "MMBakchatServiceStart";
    private static String jJD = "MMBakchatServiceStop";

    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (jJC.equalsIgnoreCase(action)) {
                context.startService(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)));
                w.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
            } else if (jJD.equalsIgnoreCase(action)) {
                b aaVar = new aa();
                aaVar.fDh.fDi = context;
                a.urY.m(aaVar);
                w.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BakOldUSBReceiver", e, "onReceive:", new Object[0]);
        }
    }
}
