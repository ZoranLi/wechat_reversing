package com.tencent.mm.modelstat;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.m.a;
import com.tencent.mm.network.w;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.y.d;
import java.util.HashMap;

public class p implements am {
    private static HashMap<Integer, c> gJr;
    private f hXA = null;
    private k hXx = new k();
    private l hXy;
    private w hXz = new w();
    private m hyk = new a(this) {
        final /* synthetic */ p hXB;

        {
            this.hXB = r1;
        }

        public final void cU(int i) {
            if (i == 4 || i == 6) {
                h.vL().e(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 hXC;

                    {
                        this.hXC = r1;
                    }

                    public final void run() {
                        if (h.vG().uV()) {
                            p.Kf().JZ();
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|onNetworkChange";
                    }
                }, 3000);
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", Integer.valueOf(i));
                n.gI(2);
            }
        }
    };

    public static f Kf() {
        h.vG().uQ();
        if (Kg().hXA == null) {
            Kg().hXA = new f(com.tencent.mm.storage.w.hgq);
        }
        return Kg().hXA;
    }

    private static p Kg() {
        return (p) l.o(p.class);
    }

    public static l Kh() {
        h.vG().uQ();
        if (Kg().hXy == null) {
            Kg().hXy = new l(h.vI().gYg);
        }
        return Kg().hXy;
    }

    public static void e(e eVar) {
        boolean z;
        String str = "MicroMsg.SubCoreStat";
        String str2 = "dknetstat setNetworkMoniter  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        if (eVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = bg.bJZ();
        com.tencent.mm.sdk.platformtools.w.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Kg().hXx);
        }
    }

    public static void f(e eVar) {
        String str = "MicroMsg.SubCoreStat";
        String str2 = "setKVReportMonitor  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(eVar == null);
        objArr[1] = bg.bJZ();
        com.tencent.mm.sdk.platformtools.w.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Kg().hXz);
        }
    }

    public final void onAccountRelease() {
        h.vH().b(this.hyk);
        d.c.aA(Integer.valueOf(9998));
        this.hXx = new k();
        ag.a.hlT = null;
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return l.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(9998), this.hXx);
        h.vH().a(this.hyk);
        ag.a.hlT = new ag.e(this) {
            final /* synthetic */ p hXB;

            {
                this.hXB = r1;
            }

            public final void aH(int i, int i2) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), bg.bJZ());
                m.r(i, i2, 0);
            }
        };
    }

    public final void aN(boolean z) {
    }
}
