package com.tencent.mm.modelsimple;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.o;
import com.tencent.mm.ao.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.as;
import com.tencent.mm.u.bb;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w extends k implements j {
    public e gUD;
    private final String hSG;
    private final String hSH;
    private final String hSI;
    private final String hSJ;
    private final String hSK;
    private final String hSL;
    private final int hSM;
    private final int hSN;
    private boolean hSO = true;
    public boolean hSP = false;
    private int hsW = 2;
    public p htt;

    public w(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + str + " nickname = " + str3);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + i + "bindEmail = " + str4 + " bindMobile = " + str5);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + i2 + " ticket: " + str6);
        this.hSN = i2;
        this.htt = new as();
        a aVar = (a) this.htt.BG();
        aVar.dj(0);
        aVar.tae.jNj = str;
        aVar.tae.tjK = bg.PR(str2);
        if (i2 == 4) {
            aVar.tae.tjK = str6;
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.NetSceneReg", "dkreg rand:" + str6 + " reqMd5:" + aVar.tae.tjK);
        }
        aVar.tae.jOp = str3;
        aVar.tae.tdy = i;
        aVar.tae.tdz = str4;
        aVar.tae.tdA = str5;
        aVar.tae.tuo = str6;
        aVar.tae.tHk = i2;
        aVar.tae.leN = bg.bJS();
        aVar.tae.tum = com.tencent.mm.compatible.d.p.getSimCountryIso();
        aVar.tae.leO = v.bIN();
        aVar.tae.thB = 0;
        aVar.tae.tSy = 0;
        aVar.tae.tSz = com.tencent.mm.compatible.d.p.getAndroidId();
        aVar.tae.twR = com.tencent.mm.compatible.d.p.rC();
        aVar.tae.tSA = ab.getContext().getSharedPreferences(ab.bIX(), 0).getString("installreferer", "");
        aVar.tae.tSB = d.nZC.qx(2);
        aVar.tae.tSC = ab.getContext().getSharedPreferences(ab.bIX() + "_google_aid", 4).getString("getgoogleaid", "");
        this.hSG = str;
        this.hSH = str2;
        this.hSI = str3;
        this.hSJ = str4;
        this.hSK = str5;
        this.hSM = i;
        this.hSL = "";
        boolean z = (str6 == null || str6.length() <= 0) && str4.length() <= 0;
        this.hSO = z;
        aVar.tae.thC = com.tencent.mm.kernel.a.uY();
    }

    public w(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, boolean z, boolean z2) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", str, bg.Qj(str2), str3, Integer.valueOf(i), str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, str11, str10, Boolean.valueOf(z), Boolean.valueOf(z2));
        this.hSN = i2;
        this.htt = new as();
        a aVar = (a) this.htt.BG();
        aVar.dj(0);
        aVar.tae.jNj = str;
        aVar.tae.tjK = bg.PR(str2);
        if (i2 == 4) {
            aVar.tae.tjK = str8;
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.NetSceneReg", "dkreg rand:" + str8 + " reqMd5:" + aVar.tae.tjK);
        }
        aVar.tae.jOp = str3;
        aVar.tae.tdy = i;
        aVar.tae.tdz = str4;
        aVar.tae.tdA = str5;
        aVar.tae.tuo = str8;
        aVar.tae.tHk = i2;
        aVar.tae.leN = bg.bJS();
        aVar.tae.tum = com.tencent.mm.compatible.d.p.getSimCountryIso();
        aVar.tae.leO = v.bIN();
        aVar.tae.thB = 0;
        aVar.tae.hAI = str9;
        aVar.tae.tHj = str11;
        aVar.tae.tHi = str10;
        aVar.tae.tjC = z ? 1 : 0;
        aVar.tae.tSx = z2 ? 1 : 0;
        aVar.tae.thC = com.tencent.mm.kernel.a.uY();
        aVar.tae.tSz = com.tencent.mm.compatible.d.p.getAndroidId();
        aVar.tae.twR = com.tencent.mm.compatible.d.p.rC();
        aVar.tae.tSA = ab.getContext().getSharedPreferences(ab.bIX(), 0).getString("installreferer", "");
        aVar.tae.tSB = d.nZC.qx(2);
        aVar.tae.tSC = ab.getContext().getSharedPreferences(ab.bIX() + "_google_aid", 4).getString("getgoogleaid", "");
        this.hSG = str;
        this.hSH = str2;
        this.hSI = str3;
        this.hSJ = str4;
        this.hSK = str5;
        this.hSM = i;
        this.hSL = str9;
        boolean z3 = (str8 == null || str8.length() <= 0) && (str4 == null || str4.length() <= 0);
        this.hSO = z3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    protected final int ub() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void a(a aVar) {
    }

    public final int getType() {
        return 126;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        final b bVar = (b) pVar.zg();
        if (i2 == 4 && i3 == -301) {
            aq.a(true, bVar.taf.tjM, bVar.taf.tjN, bVar.taf.tjL);
            this.hsW--;
            if (this.hsW <= 0) {
                this.gUD.a(3, -1, "", this);
            } else {
                a(this.hsD, this.gUD);
            }
        } else if (i2 == 4 && i3 == -102) {
            r4 = pVar.BG().sZA.ver;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(r4));
            h.vL().D(new Runnable(this) {
                final /* synthetic */ w hSQ;

                public final void run() {
                    new m().a(this.hSQ.hsD, new e(this) {
                        final /* synthetic */ AnonymousClass1 hSR;

                        {
                            this.hSR = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                this.hSR.hSQ.a(this.hSR.hSQ.hsD, this.hSR.hSQ.gUD);
                            } else {
                                this.hSR.hSQ.gUD.a(i, i2, "", this.hSR.hSQ);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 && i3 == 0) {
            a aVar = (a) pVar.BG();
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneReg", "dkreg: pass:" + bVar.taf.leF + " regtype:" + bVar.taf.tdC + " mode:" + aVar.tae.tHk);
            if (!(bVar.taf.leD == 0 || this.hSO)) {
                h.vJ();
                h.eO(bVar.taf.leD);
                if (aVar.tae.tHk == 4) {
                    h.vI().vr().set(2, aVar.tae.jNj);
                }
                h.vI().vr().set(16, Integer.valueOf(1));
                h.vI().vr().set(52, Integer.valueOf(bVar.taf.tdC));
                h.vI().vr().set(340240, Long.valueOf(System.currentTimeMillis()));
                h.vI().vr().set(340241, Boolean.valueOf(true));
                if (!(this.hSG == null || this.hSG.length() <= 0 || this.hSN == 1)) {
                    bVar.taf.jNj = this.hSG;
                }
                bVar.taf.tdz = this.hSJ;
                bVar.taf.jNB = 0;
                if (!h.vG().uV() || h.vI().vr() == null) {
                    r7 = new Object[3];
                    h.vG();
                    r7[1] = o.getString(com.tencent.mm.kernel.a.uH());
                    r7[2] = h.vI().vr();
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", r7);
                } else {
                    String str2 = this.hSL;
                    int i4 = this.hSM;
                    String str3 = this.hSI;
                    String str4 = this.hSK;
                    String str5 = bVar.taf.jNj;
                    String str6 = bVar.taf.tdz;
                    int i5 = bVar.taf.jNB;
                    String str7 = bVar.taf.tdF;
                    String str8 = bVar.taf.tdG;
                    int i6 = bVar.taf.tdH;
                    int i7 = bVar.taf.tSE;
                    String str9 = bVar.taf.tch;
                    String str10 = bVar.taf.tdI;
                    String str11 = bVar.taf.thm;
                    String str12 = bVar.taf.tSD;
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", str5, str2, o.getString(i4), str3, str6, str4, Integer.valueOf(i5), str7, str8, Integer.valueOf(i6), Integer.valueOf(i7), bg.Qj(str9), str10, Integer.valueOf(0), bg.Qj(str11), bg.Qj(null), bg.Qj(null), bg.Qj(null), Integer.valueOf(-1), str12, Integer.valueOf(0));
                    t vr = h.vI().vr();
                    ao.hlW.L("login_weixin_username", str5);
                    ao.hlW.c(str4, i4, str6);
                    vr.set(2, str5);
                    vr.set(42, str2);
                    vr.set(9, Integer.valueOf(i4));
                    vr.set(4, str3);
                    vr.set(5, str6);
                    vr.set(6, str4);
                    vr.set(7, Integer.valueOf(i5));
                    vr.set(21, str7);
                    vr.set(22, str8);
                    vr.set(57, Integer.valueOf(0));
                    vr.set(17, Integer.valueOf(i6));
                    vr.set(25, Integer.valueOf(i7));
                    vr.set(1, str9);
                    vr.set(29, str10);
                    vr.set(34, Integer.valueOf(0));
                    vr.set(256, Boolean.valueOf(false));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
                    vr.set(-1535680990, str11);
                    vr.set(46, null);
                    vr.set(72, null);
                    vr.set(64, Integer.valueOf(-1));
                    vr.jY(true);
                    ((PluginAuth) h.j(PluginAuth.class)).getHandleAuthResponseCallbacks().a(bVar, this.hSL, this.hSM, this.hSI, this.hSK, 0);
                }
                aq.a(false, bVar.taf.tjM, bVar.taf.tjN, bVar.taf.tjL);
                h.vI().vr().jY(true);
                h.vd().a(new bb(new bb.a(this) {
                    final /* synthetic */ w hSQ;

                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            eVar.Cc().i(bVar.idY, bVar.taf.leD);
                        }
                    }
                }), 0);
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneReg", "resp return flag" + bVar.taf.tSG);
                this.hSP = (bVar.taf.tSG & 1) != 0;
            }
            List linkedList = new LinkedList();
            linkedList.add(new i.a(21, "android-" + VERSION.SDK_INT + "-" + Build.MODEL));
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new i(linkedList));
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.hi(FB());
            }
            r4 = bVar.taf.thu;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneReg", "summerauth mmtls:%d", Integer.valueOf(r4));
            h.vJ();
            h.vI().gXW.set(47, Integer.valueOf(r4));
            com.tencent.mm.network.e eVar = h.vH().gXC.hsZ;
            if (eVar != null) {
                eVar.bc((r4 & 1) == 0);
            }
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final byte[] FI() {
        return n.a(((b) this.htt.zg()).taf.tHl, new byte[0]);
    }

    public final String FJ() {
        return ((b) this.htt.zg()).taf.tHi;
    }

    public final String Jq() {
        return ((b) this.htt.zg()).taf.tSK;
    }

    public final int FB() {
        bad com_tencent_mm_protocal_c_bad = ((b) this.htt.zg()).taf.thp;
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

    public final String Jr() {
        bad com_tencent_mm_protocal_c_bad = ((b) this.htt.zg()).taf.thp;
        String str = "";
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 2) {
                    return com_tencent_mm_protocal_c_bdv.ufb;
                }
            }
        }
        return str;
    }

    public final int Js() {
        bad com_tencent_mm_protocal_c_bad = ((b) this.htt.zg()).taf.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 3) {
                    return bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 2);
                }
            }
        }
        return 2;
    }

    public final String Jt() {
        bad com_tencent_mm_protocal_c_bad = ((b) this.htt.zg()).taf.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 17) {
                    return com_tencent_mm_protocal_c_bdv.ufb;
                }
            }
        }
        return null;
    }
}
