package com.tencent.mm.u.c;

import android.annotation.SuppressLint;
import com.tencent.mm.e.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.b;
import com.tencent.mm.storage.d;
import com.tencent.mm.u.am;
import com.tencent.mm.u.bp.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map;

public class c implements am {
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, com.tencent.mm.bj.g.c> gJr;
    private d hoQ;
    private b hoR;
    private a hoS = new a(this) {
        final /* synthetic */ c hoX;

        {
            this.hoX = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            String a = n.a(aVar.hst.tff);
            w.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s" + a);
            a.a gC = a.gC(a);
            if (gC != null) {
                c.Az().i(gC.hoO, 1);
                c.AA().i(gC.hoP, 2);
            }
        }
    };
    private com.tencent.mm.sdk.b.c hoT = new com.tencent.mm.sdk.b.c<e>(this) {
        final /* synthetic */ c hoX;

        {
            this.hoX = r2;
            this.usg = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((e) bVar).fCm.fCn) {
                b.Au();
            }
            return true;
        }
    };
    private j.a hoU = new j.a(this) {
        final /* synthetic */ c hoX;

        {
            this.hoX = r1;
        }

        public final void a(String str, l lVar) {
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                com.tencent.mm.storage.c dX = c.Az().dX("100205");
                if (dX.isValid()) {
                    Map bKK = dX.bKK();
                    int i = bg.getInt((String) bKK.get("main_thread_watch_enable"), 65535);
                    int i2 = bg.getInt((String) bKK.get("main_thread_watch_timeout"), Downloads.MIN_RETYR_AFTER);
                    int i3 = bg.getInt((String) bKK.get("main_thread_watch_log_loop"), 0);
                    ab.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", i2).putInt("main_thread_watch_log_loop", i3).putInt("main_thread_watch_report", bg.getInt((String) bKK.get("main_thread_watch_report"), 0)).commit();
                    w.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(r0));
                }
                c.AB();
            }
        }
    };
    private com.tencent.mm.vending.b.b hoV = null;
    private final com.tencent.mm.plugin.auth.a.a hoW = new com.tencent.mm.plugin.auth.a.a(this) {
        final /* synthetic */ c hoX;

        {
            this.hoX = r1;
        }

        public final void a(f fVar, g gVar, boolean z) {
            if (z) {
                if (fVar != null && (fVar instanceof i.a) && fVar.sZw == 12) {
                    b.Av();
                }
            } else if (fVar != null && fVar.sZw == 16) {
                b.Av();
            }
        }

        public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
        }
    };

    private static synchronized c Ay() {
        c cVar;
        synchronized (c.class) {
            cVar = (c) com.tencent.mm.u.l.o(c.class);
        }
        return cVar;
    }

    public static d Az() {
        h.vG().uQ();
        if (Ay().hoQ == null) {
            Ay().hoQ = new d(h.vI().gYg);
        }
        return Ay().hoQ;
    }

    public static b AA() {
        h.vG().uQ();
        if (Ay().hoR == null) {
            Ay().hoR = new b(h.vI().gYg);
        }
        return Ay().hoR;
    }

    public static void AB() {
        com.tencent.mm.storage.c dX = Az().dX("100229");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            int i = bg.getInt((String) bKK.get("UseSvrTime"), 0);
            ab.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("client_server_diff_time_enable", i).putInt("client_server_diff_time_interval", bg.getInt((String) bKK.get("MinDiffTime"), 0)).commit();
            w.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time enable[%d] diffTime[%d]", Integer.valueOf(i), Integer.valueOf(r0));
            return;
        }
        ab.getContext().getSharedPreferences("system_config_prefs", 4).edit().remove("client_server_diff_time_enable").remove("client_server_diff_time_interval").commit();
        w.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time abtest is not valid, then delete data");
    }

    public final void aM(boolean z) {
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("newabtest", this.hoS, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("newabtestinfo", this.hoS, true);
        com.tencent.mm.sdk.b.a.urY.b(this.hoT);
        Az().c(this.hoU);
        this.hoV = ((com.tencent.mm.plugin.auth.a.b) h.j(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.hoW);
    }

    public final void onAccountRelease() {
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("newabtest", this.hoS, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("newabtestinfo", this.hoS, true);
        com.tencent.mm.sdk.b.a.urY.c(this.hoT);
        Az().f(this.hoU);
        if (this.hoV != null) {
            this.hoV.dead();
            this.hoV = null;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return d.gUx;
            }
        });
        gJr.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return b.gUx;
            }
        });
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }
}
