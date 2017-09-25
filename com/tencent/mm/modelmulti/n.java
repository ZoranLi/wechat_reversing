package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class n {
    public Boolean hLr = null;

    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ a hLs;
        final /* synthetic */ boolean hLt = false;
        final /* synthetic */ n hLu;

        AnonymousClass1(n nVar, a aVar, boolean z) {
            this.hLu = nVar;
            this.hLs = aVar;
        }

        public final void onReceive(Context context, Intent intent) {
            w.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", new Object[]{intent == null ? "" : intent.getAction()});
            if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                this.hLu.hLr = Boolean.valueOf(false);
            } else {
                this.hLu.hLr = Boolean.valueOf(true);
            }
            if (this.hLs != null) {
                this.hLs.bj(this.hLu.hLr.booleanValue());
            }
            if (this.hLt) {
                context.unregisterReceiver(this);
            }
        }
    }

    public interface a {
        void bj(boolean z);
    }

    public n(Context context, a aVar) {
        this.hLr = aY(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(new AnonymousClass1(this, aVar, false), intentFilter);
    }

    private Boolean aY(Context context) {
        try {
            w.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", new Object[]{(Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]), this.hLr});
            return (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
        } catch (Throwable e) {
            g.oUh.a(99, 154, 1, false);
            w.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[]{this.hLr, bg.g(e)});
            return null;
        }
    }
}
