package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.p.i;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bd;
import com.tencent.mm.u.be;
import com.tencent.mm.y.d;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public final class g implements am {
    private static HashMap<Integer, c> gJr;
    private be oJN;
    private c oJO = new c();
    private a oJP = new a();
    private d oJQ = new d();
    private f oJR = new f();

    public interface a {
        void aVY();
    }

    private static g aWa() {
        g gVar = (g) ap.yR().gs("plugin.readerapp");
        if (gVar != null) {
            return gVar;
        }
        Object gVar2 = new g();
        ap.yR().a("plugin.readerapp", gVar2);
        return gVar2;
    }

    public static be aWb() {
        h.vG().uQ();
        if (aWa().oJN == null) {
            g aWa = aWa();
            ap.yY();
            aWa.oJN = new be(com.tencent.mm.u.c.wO());
        }
        return aWa().oJN;
    }

    public final void onAccountRelease() {
        d.c.aA(Integer.valueOf(12399999));
        com.tencent.mm.sdk.b.a.urY.c(this.oJP);
        com.tencent.mm.sdk.b.a.urY.c(this.oJQ);
        com.tencent.mm.sdk.b.a.urY.c(this.oJR);
        i.a(e.oJM);
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return be.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
        if ((SQLiteGlobal.journalSizeLimit & i) != 0) {
            a(null);
        }
        if ((262144 & i) != 0) {
            b(null);
        }
    }

    public static void a(a aVar) {
        aWb().fg(20);
        ap.yY();
        com.tencent.mm.u.c.wW().Rl("newsapp");
        a(20, aVar);
    }

    public static void b(a aVar) {
        aWb().fg(11);
        ap.yY();
        com.tencent.mm.u.c.wW().Rl("blogapp");
        a(11, aVar);
    }

    public static void cQ(long j) {
        g(aWb().b(j, 20), 20);
    }

    public static void t(long j, int i) {
        g(aWb().c(j, i), i);
    }

    private static void g(List<bd> list, int i) {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 == 0) {
                    bg.deleteFile(s.n(((bd) list.get(i2)).zH(), i, "@T"));
                } else {
                    bg.deleteFile(s.n(((bd) list.get(i2)).zH(), i, "@S"));
                }
            }
        }
    }

    public static void c(final a aVar) {
        af.v(new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.aVY();
                }
            }
        });
    }

    private static void a(final int i, final a aVar) {
        if (ap.zb()) {
            ap.vL().D(new Runnable() {
                public final void run() {
                    int i = 0;
                    ap.yY();
                    File file = new File(com.tencent.mm.u.c.xb());
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            g.c(aVar);
                            return;
                        }
                        String format = String.format("reader_%d_", new Object[]{Integer.valueOf(i)});
                        String format2 = String.format("ReaderApp_%d", new Object[]{Integer.valueOf(i)});
                        while (i < listFiles.length) {
                            if (listFiles[i].getName().startsWith(format)) {
                                listFiles[i].delete();
                            }
                            if (listFiles[i].getName().startsWith(format2)) {
                                listFiles[i].delete();
                            }
                            i++;
                        }
                        g.c(aVar);
                        return;
                    }
                    g.c(aVar);
                }

                public final String toString() {
                    return super.toString() + "|deleteAllPic";
                }
            });
        } else {
            c(aVar);
        }
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(12399999), this.oJO);
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ g oJT;

            {
                this.oJT = r1;
            }

            public final void run() {
                if (ap.zb()) {
                    ap.yY();
                    bg.d(com.tencent.mm.u.c.xb(), "ReaderApp_", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
        com.tencent.mm.sdk.b.a.urY.b(this.oJP);
        com.tencent.mm.sdk.b.a.urY.b(this.oJQ);
        com.tencent.mm.sdk.b.a.urY.b(this.oJR);
        i.b(e.oJM);
    }

    public final void aN(boolean z) {
    }
}
