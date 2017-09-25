package com.tencent.mm.modelfriend;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aq;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import java.util.Iterator;

public final class u extends k implements j {
    private e gUD;
    private int hsW;
    public p htt;

    public static class a extends i {
        private com.tencent.mm.protocal.p.a hBF = new com.tencent.mm.protocal.p.a();
        private b hBG = new b();

        public final int getType() {
            return 481;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/emailreg";
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hBG;
        }

        protected final d zf() {
            return this.hBF;
        }

        public final int BD() {
            return 1;
        }
    }

    private u(int i, String str, String str2, String str3) {
        this.hsW = 2;
        this.htt = new a();
        com.tencent.mm.protocal.p.a aVar = (com.tencent.mm.protocal.p.a) this.htt.BG();
        aVar.sZO.thO = i;
        aVar.sZO.tjk = str;
        aVar.sZO.leO = v.bIN();
        aVar.sZO.tjK = bg.PR(str2);
        aVar.sZO.tul = str3;
        aVar.sZO.thC = ap.uY();
        aVar.sZO.tum = com.tencent.mm.compatible.d.p.getSimCountryIso();
        aVar.sZO.tun = 1;
    }

    public u(String str, String str2, String str3) {
        this(2, str, str2, str3);
    }

    public u(String str, String str2) {
        this(1, str, str2, "");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        b bVar = (b) pVar.zg();
        if (i2 == 4 && i3 == -301) {
            aq.a(true, bVar.sZP.tjM, bVar.sZP.tjN, bVar.sZP.tjL);
            this.hsW--;
            if (this.hsW <= 0) {
                this.gUD.a(3, -1, "", this);
            } else {
                a(this.hsD, this.gUD);
            }
        } else if (i2 == 0 && i3 == 0) {
            aq.a(false, bVar.sZP.tjM, bVar.sZP.tjN, bVar.sZP.tjL);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.hi(FB());
            }
            this.gUD.a(i2, i3, str, this);
        } else {
            w.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gUD.a(i2, i3, str, this);
        }
    }

    protected final int ub() {
        return 5;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    public final int FB() {
        bad com_tencent_mm_protocal_c_bad = ((b) this.htt.zg()).sZP.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 1) {
                    return bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 0);
                }
            }
        }
        return 0;
    }

    public final int getType() {
        return 481;
    }
}
