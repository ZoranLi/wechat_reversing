package com.tencent.mm.modelfriend;

import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.aq;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import java.util.Iterator;

public final class s extends k implements j {
    public static a hBz;
    public e gUD;
    private int hsW;
    public final p htt;

    public interface a {
        String FF();
    }

    public static class b extends i {
        private final com.tencent.mm.protocal.m.a hBD = new com.tencent.mm.protocal.m.a();
        private final com.tencent.mm.protocal.m.b hBE = new com.tencent.mm.protocal.m.b();

        protected final d zf() {
            return this.hBD;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hBE;
        }

        public final int getType() {
            return com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bindopmobileforreg";
        }

        public final int BD() {
            return 1;
        }
    }

    public s(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, 11, str2, 0, str3, str4);
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.htt.BG();
        aVar.sZG.tjD = str5;
        aVar.sZG.tjE = str6;
    }

    public s(String str, int i, String str2, int i2, String str3, String str4) {
        this(str, i, str2, 0, str3);
        ((com.tencent.mm.protocal.m.a) this.htt.BG()).sZG.thq = str4;
    }

    public s(String str, int i, String str2, int i2, String str3) {
        this.gUD = null;
        this.hsW = 2;
        this.htt = new b();
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.htt.BG();
        aVar.sZG.thO = i;
        w.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        aVar.sZG.tjy = str;
        aVar.sZG.tjz = str2;
        aVar.sZG.tjA = i2;
        aVar.sZG.tjB = str3;
        aVar.sZG.leO = v.bIN();
        aVar.sZG.thC = com.tencent.mm.kernel.a.uY();
        if (bg.mA(aVar.sZG.tjD) && bg.mA(aVar.sZG.tjE)) {
            aVar.sZG.tjD = hBz != null ? hBz.FF() : "";
            aVar.sZG.tjE = com.tencent.mm.protocal.d.sYL;
        }
    }

    public final void fG(int i) {
        ((com.tencent.mm.protocal.m.a) this.htt.BG()).sZG.tjG = i;
    }

    public final void fH(int i) {
        ((com.tencent.mm.protocal.m.a) this.htt.BG()).sZG.tjH = i;
    }

    public final int AJ() {
        return ((com.tencent.mm.protocal.m.a) this.htt.BG()).sZG.thO;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.htt.BG();
        if (aVar.sZG.tjy == null || aVar.sZG.tjy.length() <= 0) {
            w.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + aVar.sZG.tjy);
            return -1;
        } else if ((aVar.sZG.thO != 6 && aVar.sZG.thO != 9) || (aVar.sZG.tjz != null && aVar.sZG.tjz.length() > 0)) {
            return a(eVar, this.htt, this);
        } else {
            w.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + aVar.sZG.tjy);
            return -1;
        }
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX;
    }

    protected final int ub() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.protocal.m.b bVar = (com.tencent.mm.protocal.m.b) pVar.zg();
        if (i2 == 4 && i3 == -301) {
            aq.a(true, bVar.sZH.tjM, bVar.sZH.tjN, bVar.sZH.tjL);
            this.hsW--;
            if (this.hsW <= 0) {
                this.gUD.a(3, -1, "", this);
            } else {
                a(this.hsD, this.gUD);
            }
        } else if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.BG().sZA.ver;
            w.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            h.vL().D(new Runnable(this) {
                final /* synthetic */ s hBB;

                public final void run() {
                    new m().a(this.hBB.hsD, new e(this) {
                        final /* synthetic */ AnonymousClass1 hBC;

                        {
                            this.hBC = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                this.hBC.hBB.a(this.hBC.hBB.hsD, this.hBC.hBB.gUD);
                            } else {
                                this.hBC.hBB.gUD.a(i, i2, "", this.hBC.hBB);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 && i3 == 0) {
            aq.a(false, bVar.sZH.tjM, bVar.sZH.tjN, bVar.sZH.tjL);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.hi(FB());
            }
            this.gUD.a(i2, i3, str, this);
        } else {
            w.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final String Ft() {
        return ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.tjK;
    }

    public final String getUsername() {
        return ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.tgG;
    }

    public final String Fu() {
        return ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.fGV;
    }

    public final String Fv() {
        return ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thq;
    }

    public final String Fw() {
        return ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.tjR;
    }

    public final int Fx() {
        bad com_tencent_mm_protocal_c_bad = ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 6) {
                    return bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 3);
                }
            }
        }
        return 3;
    }

    public final int Fy() {
        bad com_tencent_mm_protocal_c_bad = ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 4) {
                    return bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 30);
                }
            }
        }
        return 30;
    }

    public final int Fz() {
        bad com_tencent_mm_protocal_c_bad = ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 5) {
                    return bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 0);
                }
            }
        }
        return 0;
    }

    public final boolean FA() {
        int i;
        bad com_tencent_mm_protocal_c_bad = ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 7) {
                    i = bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    private int FB() {
        bad com_tencent_mm_protocal_c_bad = ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thp;
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

    public final boolean FC() {
        int i;
        bad com_tencent_mm_protocal_c_bad = ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 10) {
                    i = bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    public final String FD() {
        bad com_tencent_mm_protocal_c_bad = ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 14) {
                    return com_tencent_mm_protocal_c_bdv.ufb;
                }
            }
        }
        return null;
    }

    public final String FE() {
        bad com_tencent_mm_protocal_c_bad = ((com.tencent.mm.protocal.m.b) this.htt.zg()).sZH.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 15) {
                    return com_tencent_mm_protocal_c_bdv.ufb;
                }
            }
        }
        return null;
    }
}
