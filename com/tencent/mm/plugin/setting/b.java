package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.d.f;
import com.tencent.mm.y.d;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public final class b implements am {
    private a phL = new a(this) {
        final /* synthetic */ b phO;

        {
            this.phO = r1;
        }

        public final void a(d.a aVar) {
            String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q != null) {
                String ap = bg.ap((String) q.get(".sysmsg.RedPoints.redPoint.path"), "");
                int PY = bg.PY(bg.ap((String) q.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
                bg.PY(bg.ap((String) q.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
                if (!bg.mA(ap)) {
                    if (ap.equals("my_setting_privaty_recentOption")) {
                        ap.yY();
                        if (((Integer) c.vr().get(com.tencent.mm.storage.w.a.uGy, Integer.valueOf(0))).intValue() < PY) {
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.uGy, Integer.valueOf(PY));
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.uGz, Integer.valueOf(PY));
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.uGB, Integer.valueOf(PY));
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.uGD, Integer.valueOf(PY));
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.uGF, Integer.valueOf(PY));
                            com.tencent.mm.q.c.uk().t(266260, true);
                        }
                    } else if (ap.equals("my_setting_plugin_switch")) {
                        String ap2 = bg.ap((String) q.get(".sysmsg.RedPoints.redPoint.ext"), "");
                        if (!bg.mA(ap2)) {
                            ap.yY();
                            if (((Integer) c.vr().get(com.tencent.mm.storage.w.a.uHv, Integer.valueOf(0))).intValue() < PY) {
                                Object concat;
                                ap.yY();
                                c.vr().a(com.tencent.mm.storage.w.a.uHv, Integer.valueOf(PY));
                                ap.yY();
                                a = (String) c.vr().get(com.tencent.mm.storage.w.a.uHw, "");
                                if (bg.mA(a)) {
                                    a = ap2;
                                } else {
                                    concat = ap2.concat(",").concat(a);
                                }
                                ap.yY();
                                c.vr().a(com.tencent.mm.storage.w.a.uHw, concat);
                                com.tencent.mm.q.c.uk().t(262158, true);
                            }
                        }
                    }
                }
            }
        }
    };
    private m phM = new m(this) {
        final /* synthetic */ b phO;

        {
            this.phO = r1;
        }

        public final void b(String str, Map<String, String> map) {
            if (map != null) {
                String str2 = (String) map.get(".sysmsg.showtrustedfriends.wording");
                if (!bg.mA(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra(f.uOC, str2);
                    com.tencent.mm.bb.d.b(ab.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", intent);
                }
            }
        }
    };
    private a phN = new a(this) {
        final /* synthetic */ b phO;

        {
            this.phO = r1;
        }

        public final void a(d.a aVar) {
            String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q != null) {
                int i = bg.getInt((String) q.get(".sysmsg.crowdtest.$clientversion"), 0);
                if (i > com.tencent.mm.protocal.d.sYN) {
                    long j = 0;
                    try {
                        j = new SimpleDateFormat("yyyy-MM-dd").parse((String) q.get(".sysmsg.crowdtest.apply.$expire")).getTime();
                    } catch (Exception e) {
                    }
                    if (j < System.currentTimeMillis()) {
                        b.aZM();
                        return;
                    }
                    a = (String) q.get(".sysmsg.crowdtest.apply.link");
                    String str = (String) q.get(".sysmsg.crowdtest.feedback.link");
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uHr, Integer.valueOf(i));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uHs, Long.valueOf(j));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uHt, a);
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uHu, str);
                    int i2 = bg.getInt((String) q.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
                    com.tencent.mm.q.c.uk().t(262157, i2 > 0);
                    if (i2 < 3) {
                        com.tencent.mm.q.c.uk().aE(262157, 266261);
                    }
                    if (i2 < 2) {
                        com.tencent.mm.q.c.uk().aE(262157, 266262);
                    }
                }
            }
        }
    };

    public b() {
        w.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
        w.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
        ap.getSysCmdMsgExtension().a("redpointinfo", this.phL, true);
        ap.getSysCmdMsgExtension().a("crowdtest", this.phN, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.phM);
        ap.yY();
        int intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uHr, Integer.valueOf(com.tencent.mm.protocal.d.sYN))).intValue();
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.uHs, Long.valueOf(0))).longValue();
        if (intValue <= com.tencent.mm.protocal.d.sYN || longValue < System.currentTimeMillis()) {
            aZM();
        }
        if (z) {
            int xW = (com.tencent.mm.u.m.xW() & -1048577) & -4194305;
            ap.yY();
            c.vr().set(34, Integer.valueOf(xW));
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_aqr = new aqr();
            com_tencent_mm_protocal_c_aqr.tdB = 1048576;
            com_tencent_mm_protocal_c_aqr.tVo = 0;
            ap.yY();
            c.wQ().b(new e.a(39, com_tencent_mm_protocal_c_aqr));
            com_tencent_mm_protocal_c_aqr = new aqr();
            com_tencent_mm_protocal_c_aqr.tdB = 4194304;
            com_tencent_mm_protocal_c_aqr.tVo = 0;
            ap.yY();
            c.wQ().b(new e.a(39, com_tencent_mm_protocal_c_aqr));
            w.i("MicroMsg.SubCoreSetting", "set void default open");
        }
    }

    public final void aN(boolean z) {
        w.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
        ap.getSysCmdMsgExtension().b("redpointinfo", this.phL, true);
        ap.getSysCmdMsgExtension().b("crowdtest", this.phN, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.phM);
    }

    public static void aZM() {
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uHs, Long.valueOf(0));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uHt, "");
        com.tencent.mm.q.c.uk().t(262157, false);
    }
}
