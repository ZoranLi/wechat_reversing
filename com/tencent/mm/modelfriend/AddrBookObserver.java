package com.tencent.mm.modelfriend;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.e.a.hx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Random;

public final class AddrBookObserver extends ContentObserver {
    private static boolean hAc = false;
    private static Intent hAd;
    private static ae handler = new ae(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            Context context = (Context) message.obj;
            if (AddrBookObserver.hAd == null) {
                AddrBookObserver.hAd = new Intent();
                AddrBookObserver.hAd.setClass(context, AddrBookService.class);
            }
            AddrBookObserver.hAd.putExtra(AddrBookService.hAe, new Random(System.currentTimeMillis()).nextFloat());
            try {
                w.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", Float.valueOf(new Random(System.currentTimeMillis()).nextFloat()));
                context.startService(AddrBookObserver.hAd);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AddrBookObserver", e, "startService failed", new Object[0]);
            }
        }
    };
    private final Context context;

    public static class AddrBookService extends Service {
        public static boolean hAc = false;
        public static String hAe = "key_sync_session";
        public static boolean hsG = false;
        private b hAf = new b(this) {
            final /* synthetic */ AddrBookService hAg;

            {
                this.hAg = r1;
            }

            public final void bg(boolean z) {
                if (z) {
                    System.currentTimeMillis();
                    ap.vd().a(new aa(m.Fs(), m.Fr()), 0);
                    this.hAg.stopSelf();
                    AddrBookService.hAc = false;
                    return;
                }
                w.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
                this.hAg.stopSelf();
                AddrBookService.hAc = false;
            }
        };

        public int onStartCommand(Intent intent, int i, int i2) {
            super.onStartCommand(intent, i, i2);
            String str = "MicroMsg.AddrBookObserver";
            String str2 = "service start intent:%b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            w.i(str, str2, objArr);
            if (intent == null) {
                w.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
                stopSelf();
            } else {
                float floatExtra = intent.getFloatExtra(hAe, -1.0f);
                if (floatExtra == -1.0f) {
                    w.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
                    stopSelf();
                } else {
                    SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences(ab.bIX(), 0);
                    if (sharedPreferences.getFloat(hAe, 0.0f) == floatExtra) {
                        w.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", Float.valueOf(sharedPreferences.getFloat(hAe, 0.0f)));
                        stopSelf();
                    } else {
                        sharedPreferences.edit().putFloat(hAe, floatExtra).commit();
                        w.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", Float.valueOf(floatExtra));
                        if (hsG) {
                            w.i("MicroMsg.AddrBookObserver", "service canceled");
                            hsG = false;
                            stopSelf();
                        } else if (ap.yQ()) {
                            w.e("MicroMsg.AddrBookObserver", "[onStartCommand] getCode is null, stop service");
                            stopSelf();
                        } else {
                            h.vG().initialize();
                            try {
                                if (ap.zb()) {
                                    if (d.aDM()) {
                                        a.urY.m(new hx());
                                    }
                                    if (!m.Fo() || m.Fk()) {
                                        w.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
                                        stopSelf();
                                    } else {
                                        w.i("MicroMsg.AddrBookObserver", "start sync");
                                        if (com.tencent.mm.modelsimple.d.bg(this)) {
                                            w.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
                                            stopSelf();
                                        } else {
                                            hAc = true;
                                            a.a(this.hAf);
                                        }
                                    }
                                } else {
                                    w.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
                                    stopSelf();
                                }
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.AddrBookObserver", e, "", new Object[0]);
                                w.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", e.getMessage());
                                stopSelf();
                            }
                        }
                    }
                }
            }
            return 2;
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    public AddrBookObserver(Context context) {
        super(ae.fetchFreeHandler());
        this.context = context;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        w.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
        if (hAc) {
            w.e("MicroMsg.AddrBookObserver", "isSyncing:" + hAc + ", is time to sync:true , return");
            return;
        }
        handler.removeMessages(0);
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = this.context;
        obtainMessage.what = 0;
        handler.sendMessageDelayed(obtainMessage, 20000);
    }
}
