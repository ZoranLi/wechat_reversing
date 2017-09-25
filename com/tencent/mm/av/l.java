package com.tencent.mm.av;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.ff;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.d;
import java.util.HashMap;
import java.util.List;

public class l implements am {
    private static HashMap<Integer, c> gJr;
    public static int[] hXQ = new int[1000];
    public static int hXR = 0;
    private final int fxl = 0;
    private n hXI = new n();
    private g hXJ;
    private c hXK;
    private d hXL = new d();
    private i hXM;
    private k hXN;
    private final long hXO = 259200000;
    private final int hXP = 2;
    private com.tencent.mm.sdk.b.c hXS = new com.tencent.mm.sdk.b.c<ff>(this) {
        final /* synthetic */ l hXT;

        {
            this.hXT = r2;
            this.usg = ff.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ff ffVar = (ff) bVar;
            int i = ffVar.fJI.fJK;
            String str = ffVar.fJI.fJL;
            int i2 = ffVar.fJI.state;
            if (i == 1) {
                c Ky = l.Ky();
                b bVar2 = new b();
                bVar2.field_state = -1;
                Cursor a = Ky.gUz.a(String.format("select %s from %s where %s = %s", new Object[]{"state", "fmessage_conversation", "talker", g.dP(str)}), null, 2);
                if (a.moveToFirst()) {
                    bVar2.b(a);
                }
                a.close();
                i2 = bVar2.field_state;
            } else if (i == 0) {
                if (i2 == 2) {
                    l.Ky().D(str, 2);
                } else if (i2 == 1) {
                    l.Ky().D(str, 1);
                } else {
                    l.Ky().D(str, 0);
                }
            }
            ffVar.fJJ.state = i2;
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return i.gUx;
            }
        });
        gJr.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return k.gUx;
            }
        });
        gJr.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return m.gUx;
            }
        });
        gJr.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return g.gUx;
            }
        });
        gJr.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return c.gUx;
            }
        });
    }

    private static l Kw() {
        l lVar = (l) ap.yR().gs(l.class.getName());
        if (lVar != null) {
            return lVar;
        }
        Object lVar2 = new l();
        ap.yR().a(l.class.getName(), lVar2);
        return lVar2;
    }

    public static g Kx() {
        h.vG().uQ();
        if (Kw().hXJ == null) {
            l Kw = Kw();
            ap.yY();
            Kw.hXJ = new g(com.tencent.mm.u.c.wO());
            Kw().hXJ.a(Ky(), ap.vL().nJF.getLooper());
        }
        return Kw().hXJ;
    }

    public static c Ky() {
        h.vG().uQ();
        if (Kw().hXK == null) {
            l Kw = Kw();
            ap.yY();
            Kw.hXK = new c(com.tencent.mm.u.c.wO());
        }
        return Kw().hXK;
    }

    public static i Kz() {
        h.vG().uQ();
        if (Kw().hXM == null) {
            l Kw = Kw();
            ap.yY();
            Kw.hXM = new i(com.tencent.mm.u.c.wO());
        }
        return Kw().hXM;
    }

    public static k KA() {
        h.vG().uQ();
        if (Kw().hXN == null) {
            l Kw = Kw();
            ap.yY();
            Kw.hXN = new k(com.tencent.mm.u.c.wO());
        }
        return Kw().hXN;
    }

    public final void onAccountRelease() {
        d.c.aA(Integer.valueOf(37));
        d.c.aA(Integer.valueOf(40));
        a.urY.c(this.hXS);
        ap.getNotification().qi();
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(37), this.hXI);
        d.c.a(Integer.valueOf(40), this.hXL);
        a.urY.b(this.hXS);
        int Km = Ky().Km();
        long currentTimeMillis = System.currentTimeMillis();
        ap.yY();
        if (currentTimeMillis - bg.a((Long) com.tencent.mm.u.c.vr().get(340225, null), 0) > 259200000 && Km > 0) {
            List Kn = Ky().Kn();
            int size = Kn.size();
            String str = (String) Kn.get(0);
            Km = 1;
            while (Km < size) {
                String str2 = str + ", " + ((String) Kn.get(Km));
                Km++;
                str = str2;
            }
            b jvVar = new jv();
            jvVar.fQj.userName = null;
            jvVar.fQj.aIO = str;
            jvVar.fQj.type = 0;
            a.urY.m(jvVar);
            ap.yY();
            com.tencent.mm.u.c.vr().set(340225, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void aN(boolean z) {
    }
}
