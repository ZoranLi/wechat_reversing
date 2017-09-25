package com.tencent.mm.plugin.appbrand.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public abstract class d {
    private final WeakReference<Activity> iAz;
    public final BroadcastReceiver tF = new BroadcastReceiver(this) {
        final String iAA = "reason";
        final String iAB = "homekey";
        final /* synthetic */ d iAC;

        {
            this.iAC = r2;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (stringExtra != null) {
                    w.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", new Object[]{intent.getAction(), stringExtra});
                    if (stringExtra.equals("homekey")) {
                        this.iAC.QG();
                    }
                }
            }
        }
    };

    public abstract void QG();

    public d(Activity activity) {
        this.iAz = new WeakReference(activity);
    }
}
