package com.tencent.mm.plugin.bbom;

import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j implements e {
    static j jPU;

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 4 && !ap.vd().foreground) {
            switch (i2) {
                case -999999:
                    new ae().post(new Runnable(this) {
                        final /* synthetic */ j jPV;

                        {
                            this.jPV = r1;
                        }

                        public final void run() {
                            ap.hold();
                            MMAppMgr.kv(true);
                        }
                    });
                    return;
                case -311:
                case -310:
                case -205:
                case -72:
                case -9:
                case -6:
                case -4:
                case -3:
                    ap.getNotification().dc(ab.getContext().getString(R.l.ezj));
                    ap.hold();
                    return;
                case -140:
                    w.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", str);
                    if (bg.mA(str)) {
                        ap.getNotification().dc(ab.getContext().getString(R.l.ezj));
                    } else {
                        ap.getNotification().dc(str);
                    }
                    ap.hold();
                    return;
                case -100:
                    ap.getNotification().dc(ab.getContext().getString(R.l.ezi));
                    d.bd(ab.getContext());
                    ap.hold();
                    return;
                case -17:
                case -16:
                    SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("system_config_prefs", 0);
                    long j = sharedPreferences.getLong("recomended_update_ignore", -1);
                    if (j == -1 || bg.az(j) >= 86400) {
                        int i3;
                        af notification = ap.getNotification();
                        if (i2 == -17) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        notification.dN(i3);
                        sharedPreferences.edit().putLong("recomended_update_ignore", bg.Ny()).commit();
                        g.oUh.a(405, 27, 1, true);
                        return;
                    }
                    w.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=" + j);
                    return;
                default:
                    if (i == 0 && i2 == 0) {
                        ap.getNotification().ox();
                        return;
                    }
                    return;
            }
        }
    }
}
