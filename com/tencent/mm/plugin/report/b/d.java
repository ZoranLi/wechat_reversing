package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.b.a.a.f;
import com.tencent.b.a.a.i;
import com.tencent.b.a.a.n;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.asu;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public final class d {
    private static i oTo = i.R(ab.getContext());
    public static int oTp = 2;

    public static String aXy() {
        try {
            i.a(new f() {
                public final void aH(String str) {
                    w.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", str, Integer.valueOf(d.oTp));
                    int i = d.oTp;
                    d.oTp = i - 1;
                    if (i <= 0) {
                        w.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", Integer.valueOf(d.oTp));
                        return;
                    }
                    a aVar = new a();
                    aVar.hsm = new asu();
                    aVar.hsn = new asv();
                    aVar.uri = "/cgi-bin/micromsg-bin/querymid";
                    aVar.hsl = 684;
                    b BE = aVar.BE();
                    ((asu) BE.hsj.hsr).iTT = str;
                    ((asu) BE.hsj.hsr).mtF = 1;
                    u.a(BE, new u.a(this) {
                        final /* synthetic */ AnonymousClass1 oTq;

                        {
                            this.oTq = r1;
                        }

                        public final int a(int i, int i2, String str, b bVar, k kVar) {
                            w.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            return 0;
                        }
                    }, true);
                }
            });
            w.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", oTo.nO(), oTo.nP());
            return oTo.nO();
        } catch (Throwable e) {
            w.e("MicroMsg.MidHelper", "QueryMid Error e:%s", bg.g(e));
            return "";
        }
    }

    public static void Dz(String str) {
        try {
            i iVar = oTo;
            if (i.mContext != null) {
                i.aQq = System.currentTimeMillis();
                n.aQB = -1;
                try {
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
                    edit.putLong("__MID_LAST_CHECK_TIME__", i.aQq);
                    edit.commit();
                } catch (Exception e) {
                }
                if (i.mHandler != null) {
                    i.mHandler.post(new com.tencent.b.a.a.i.AnonymousClass1(iVar, str));
                }
            }
            w.i("MicroMsg.MidHelper", "QueryMid local:%s", oTo.nP());
        } catch (Throwable e2) {
            w.e("MicroMsg.MidHelper", "procReturnData Error e:%s", bg.g(e2));
        }
    }

    public static int o(int i, int i2, String str) {
        if (h.vG().uV()) {
            long Ny = bg.Ny();
            if (i == 3 && bg.a((Long) h.vI().vr().get(331778, null), 0) >= Ny) {
                return 0;
            }
            int i3;
            if (am.is2G(ab.getContext())) {
                i3 = 1;
            } else if (am.isWifi(ab.getContext())) {
                i3 = 3;
            } else if (am.is3G(ab.getContext())) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            String aXy = aXy();
            w.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", Integer.valueOf(i), aXy);
            c.oTb.i(11402, aXy, Integer.valueOf(i), Integer.valueOf(i3), p.rB(), Integer.valueOf(i2), str, am.getISPName(ab.getContext()), Integer.valueOf(0), p.getDeviceID(ab.getContext()));
            h.vI().vr().set(331778, Long.valueOf(259200 + Ny));
            return 0;
        }
        w.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
        return -1;
    }
}
