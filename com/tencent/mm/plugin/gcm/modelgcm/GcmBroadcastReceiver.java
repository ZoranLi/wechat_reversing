package com.tencent.mm.plugin.gcm.modelgcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.gcm.a;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.e.a.gf;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

public class GcmBroadcastReceiver extends BroadcastReceiver {
    static List<Pair<Long, Long>> mHy = new LinkedList();
    private static WakerLock wakerlock = null;

    public static void aCm() {
        mHy.clear();
    }

    public void onReceive(Context context, Intent intent) {
        w.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive in.");
        String stringExtra;
        if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) {
            final a aCn = a.aCn();
            String aCp = aCn.aCp();
            stringExtra = intent.getStringExtra("registration_id");
            w.i("GcmBroadcastReceiver", "REGISTRATION intent received:" + intent.toString());
            if (intent.getStringExtra("error") == null && intent.getStringExtra("unregistered") == null && stringExtra != null && aCp.compareTo(stringExtra) != 0) {
                if (z.MM() == null) {
                    w.w("GcmBroadcastReceiver", "gcm reg id recv, but mmpushcore not init, id = " + stringExtra);
                } else {
                    aCn.ac(context, stringExtra);
                    z.MM().post(new Runnable() {
                        public final void run() {
                            aCn.aCr();
                        }
                    });
                }
            }
            c.oTb.a(452, 25, 1, false);
            return;
        }
        a aCn2 = a.aCn();
        if (aCn2 == null || bg.mA(aCn2.aCp())) {
            aCp = "GcmBroadcastReceiver";
            stringExtra = "Gcm push is not reg to server. reg == null[%b], isRegToSvr[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(aCn2 == null);
            objArr[1] = Boolean.valueOf(aCn2 == null ? false : aCn2.aCt());
            w.i(aCp, stringExtra, objArr);
            g.oUh.A(11250, new StringBuilder("1,2").toString());
            c.oTb.a(452, aCn2 == null ? 26 : 27, 1, false);
            return;
        }
        try {
            if (k.aK(context)) {
                w.i("GcmBroadcastReceiver", "Logout or exit MM. no need show Notification.");
                g.oUh.A(11250, new StringBuilder("1,2").toString());
                c.oTb.a(452, 28, 1, false);
                return;
            }
            Bundle extras = intent.getExtras();
            a.D(context);
            aCp = a.d(intent);
            if (extras.isEmpty()) {
                w.i("GcmBroadcastReceiver", "Intent extras is empty: ");
                g.oUh.A(11250, new StringBuilder("1,0").toString());
                c.oTb.a(452, 29, 1, false);
                return;
            }
            if ("send_error".equals(aCp)) {
                w.i("GcmBroadcastReceiver", "Send error: " + extras.toString());
                g.oUh.A(11250, new StringBuilder("1,1").toString());
                c.oTb.a(452, 30, 1, false);
            } else if ("deleted_messages".equals(aCp)) {
                w.i("GcmBroadcastReceiver", "Deleted messages on server.");
                g.oUh.A(11250, new StringBuilder("1,1").toString());
                c.oTb.a(452, 31, 1, false);
            } else if ("gcm".equals(aCp)) {
                long j;
                c.oTb.a(452, 32, 1, false);
                w.i("GcmBroadcastReceiver", "Received gcm msg. extras[%s]", extras.toString());
                stringExtra = extras.getString("seq");
                aCp = extras.getString(OpenSDKTool4Assistant.EXTRA_UIN);
                String string = extras.getString("cmd");
                long j2 = bg.mA(aCp) ? 0 : bg.getLong(aCp, 0);
                long j3 = bg.mA(stringExtra) ? 0 : bg.getLong(stringExtra, 0);
                if (bg.mA(string)) {
                    j = 0;
                } else {
                    j = bg.getLong(string, 0);
                }
                int uX = com.tencent.mm.kernel.a.uX();
                if (j2 == 0 || !Integer.toHexString(uX).equals(Long.toHexString(j2))) {
                    w.e("GcmBroadcastReceiver", "Logined user changed. no need show Notification.uin:" + j2 + ", oldUin:" + uX);
                    g.oUh.A(11250, new StringBuilder("1,3").toString());
                    c cVar = c.oTb;
                    if (j2 == 0) {
                        j = 33;
                    } else {
                        j = 34;
                    }
                    cVar.a(452, j, 1, false);
                    return;
                }
                Object obj;
                for (Pair pair : mHy) {
                    if (((Long) pair.first).longValue() == j && ((Long) pair.second).longValue() == j3) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    w.w("GcmBroadcastReceiver", "already has this seq:" + j3);
                    c.oTb.a(452, 35, 1, false);
                    return;
                }
                mHy.add(Pair.create(Long.valueOf(j), Long.valueOf(j3)));
                if (mHy.size() > 60) {
                    mHy.remove(0);
                }
                if (wakerlock == null) {
                    wakerlock = new WakerLock(context);
                    w.i("GcmBroadcastReceiver", "start new wakerlock");
                }
                wakerlock.lock(200, "GcmBroadcastReceiver.onReceive");
                b gfVar = new gf();
                gfVar.fLw.type = 13;
                com.tencent.mm.sdk.b.a.urY.m(gfVar);
            }
            w.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive out.");
        } catch (Throwable e) {
            w.e("GcmBroadcastReceiver", "GcmBroadcastReceiver error :" + e.toString());
            w.printErrStackTrace("GcmBroadcastReceiver", e, "", new Object[0]);
            c.oTb.a(452, 36, 1, false);
        }
    }
}
