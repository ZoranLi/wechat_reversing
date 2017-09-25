package com.tencent.mm.modelsimple;

import com.tencent.mm.e.b.af;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.Map;

public final class q extends k implements j {
    public static String hSd;
    public static String hSe;
    public static String hSf;
    public static String hSg;
    public static String hSh;
    public static String hSi;
    public static String hSj;
    public static String hSk;
    public static String hSl;
    public static String hSm;
    private static int hSn;
    private static int hSo = 0;
    private static int hSp = 22;
    private static int hSq = 0;
    private static boolean hSr = false;
    private e gUD;

    public static boolean gx(int i) {
        if (hSn == i) {
            return false;
        }
        return true;
    }

    public static int Ja() {
        return hSo;
    }

    public static boolean Jb() {
        return (hSq & 2) != 0;
    }

    public static boolean Jc() {
        return (hSp & 4) != 0;
    }

    public static void bo(boolean z) {
        if (z) {
            hSp |= 4;
        } else {
            hSp &= -5;
        }
    }

    public static int Jd() {
        return hSn;
    }

    public static boolean Je() {
        return (hSq & 512) != 0;
    }

    public static boolean Jf() {
        return (hSq & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0;
    }

    public q(int i) {
        hSn = i;
    }

    public final int getType() {
        return 526;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        com.tencent.mm.bd.a zoVar = new zo();
        zoVar.leO = v.bIN();
        w.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", zoVar.leO);
        aVar.hsm = zoVar;
        aVar.hsn = new zp();
        aVar.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
        aVar.hsl = 526;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUD = eVar2;
        return a(eVar, aVar.BE(), this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            zp zpVar = (zp) ((b) pVar).hsk.hsr;
            hSo = zpVar.tFU;
            w.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", Integer.valueOf(hSo), Integer.valueOf(zpVar.teT));
            Map q = bh.q(zpVar.tFT, "summary");
            int i4 = hSp;
            if (q != null) {
                int i5;
                int i6;
                hSd = (String) q.get(".summary.banner");
                w.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", Integer.valueOf(zpVar.tFR), zpVar.tFT);
                zo zoVar = (zo) ((b) pVar).hsj.hsr;
                Iterator it = zpVar.tFS.iterator();
                while (it.hasNext()) {
                    aog com_tencent_mm_protocal_c_aog = (aog) it.next();
                    if (com_tencent_mm_protocal_c_aog.tiB.bGX().hashCode() != zoVar.tYN.tiB.bGX().hashCode()) {
                        Map q2 = bh.q(com_tencent_mm_protocal_c_aog.tTp, "wording");
                        w.d("MicroMsg.NetSceneGetOnlineInfo", com_tencent_mm_protocal_c_aog.tTp);
                        if (q2 != null) {
                            hSe = (String) q2.get(".wording.title");
                            hSf = (String) q2.get(".wording.notify");
                            hSg = (String) q2.get(".wording.mute_title");
                            hSh = (String) q2.get(".wording.mute_tips");
                            hSi = (String) q2.get(".wording.exit");
                            hSj = (String) q2.get(".wording.exit_confirm");
                            hSk = (String) q2.get(".wording.lock_title");
                            hSl = (String) q2.get(".wording.mute_lock_title");
                            hSm = (String) q2.get(".wording.exit");
                        }
                        i5 = com_tencent_mm_protocal_c_aog.tTr;
                        i6 = zpVar.teT;
                        hSq = i6;
                        if ((i6 & 2) != 0) {
                            hSr = true;
                        } else {
                            hSr = false;
                        }
                        if (i5 != hSp) {
                            hSp = i5;
                            ap.yY();
                            c.uR();
                        }
                    }
                }
                i5 = i4;
                i6 = zpVar.teT;
                hSq = i6;
                if ((i6 & 2) != 0) {
                    hSr = false;
                } else {
                    hSr = true;
                }
                if (i5 != hSp) {
                    hSp = i5;
                    ap.yY();
                    c.uR();
                }
            }
            if ((zpVar.teT & 64) != 0) {
                ap.yY();
                af Rc = c.wR().Rc("filehelper");
                if (Rc == null || bg.mA(Rc.field_username)) {
                    com.tencent.mm.u.v.w(Rc);
                    ap.yY();
                    Rc = c.wR().Rc("filehelper");
                }
                if (!(Rc == null || com.tencent.mm.j.a.ez(Rc.field_type))) {
                    Rc.tc();
                    ap.yY();
                    c.wR().a(Rc.field_username, Rc);
                }
                ap.yY();
                ae Rm = c.wW().Rm("filehelper");
                if (Rm == null) {
                    Rm = new ae("filehelper");
                    Rm.s(bg.Nz());
                    ap.yY();
                    c.wW().d(Rm);
                } else {
                    Rm.s(bg.Nz());
                    ap.yY();
                    c.wW().a(Rm, "filehelper");
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
