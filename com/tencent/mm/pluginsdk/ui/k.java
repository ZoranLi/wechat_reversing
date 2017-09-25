package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;

public final class k {
    public static boolean u(final Context context, final String str, final String str2) {
        if (!ad.Pt("wap_reporter_shown")) {
            return false;
        }
        g.a(context, R.l.eLF, R.l.dIO, R.l.dIu, R.l.dGs, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Context context = context;
                String str = str;
                String str2 = str2;
                if (context == null) {
                    w.w("Micromsg.NetworkErrAlert", "reportViaWap: context is null");
                    return;
                }
                if (str == null) {
                    w.w("Micromsg.NetworkErrAlert", "reportViaWap: ip is null");
                }
                if (str2 == null) {
                    w.w("Micromsg.NetworkErrAlert", "reportViaWap: errMsg is null");
                }
                ap.yY();
                String str3 = (String) c.vr().get(2, null);
                str3 = ((("http://w.mail.qq.com/cgi-bin/mmfeedback?t=mmfeedback&f=xhtml" + "&u=" + Base64.encodeToString(str3.getBytes(), 8)) + "&i=" + Base64.encodeToString(bg.ap(str, "").getBytes(), 8)) + "&e=" + Base64.encodeToString(bg.ap(str2, "").getBytes(), 8)) + "&autologin=n";
                w.d("Micromsg.NetworkErrAlert", "upload error to " + str3);
                bg.F(context, str3);
            }
        }, null);
        return true;
    }

    public static boolean dD(final Context context) {
        if (!ad.Pt("network_doctor_shown")) {
            return false;
        }
        g.a(context, R.l.eDu, R.l.dIO, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            }
        }, null);
        return true;
    }
}
