package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.i.f;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class a implements b {
    private final String TAG = "MicroMsg.NotificationObserver";
    private ae mHandler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ a nZT;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            final String string = message.getData().getString("com.tencent.mm.notification.observer");
            ap.vL().e(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 nZV;

                public final void run() {
                    int i = 0;
                    final int sR = f.sR();
                    ap.yY();
                    x Rc = c.wR().Rc(string);
                    final boolean tD = Rc == null ? false : Rc.tD();
                    if (!tD) {
                        i = f.dF(string);
                    }
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 nZZ;

                        public final void run() {
                            ap.getNotification().dO(sR);
                            if (!tD) {
                                ap.getNotification().l(string, i);
                            }
                            w.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[]{Integer.valueOf(sR), Integer.valueOf(i), Boolean.valueOf(tD)});
                            e.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 oaa;

                                {
                                    this.oaa = r1;
                                }

                                public final void run() {
                                    ap.getNotification().j(sR, string);
                                    if (this.oaa.nZZ.nZV.nZT.nZS) {
                                        this.oaa.nZZ.nZV.nZT.nZS = false;
                                        ap.getNotification().ax(false);
                                    }
                                }
                            }, "NotificationObserver");
                        }
                    });
                }
            }, 500);
        }
    };
    private final int nZR = 50;
    public boolean nZS = false;

    public final void a(int i, m mVar, Object obj) {
        w.i("MicroMsg.NotificationObserver", "event: %d", new Object[]{Integer.valueOf(i)});
        if (!(obj instanceof String) || bg.mA((String) obj)) {
            w.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        int i2;
        if (ap.yQ()) {
            i2 = 0;
        } else {
            ap.yY();
            i2 = (int) c.wR().Ra((String) obj).gTQ;
        }
        this.mHandler.removeMessages(i2);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("com.tencent.mm.notification.observer", (String) obj);
        obtain.setData(bundle);
        obtain.what = i2;
        this.mHandler.sendMessageDelayed(obtain, 50);
    }
}
