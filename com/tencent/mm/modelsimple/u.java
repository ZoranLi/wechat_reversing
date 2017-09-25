package com.tencent.mm.modelsimple;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.it;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.bmh;
import com.tencent.mm.protocal.c.bpn;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;

public final class u extends k implements j {
    private int errCode;
    private int errType;
    public e gUD;
    private String hSt;
    private String hSu;
    private boolean hSv;
    private boolean hSw;
    private int hSx;
    private int hSy;
    private boolean hSz;
    private int hsW;
    public final p htt;

    public static class a {
        public String fGV;
        public String fNG;
        public String hSD;
        public Bundle hSE;
        public int type;
        public String username;

        public final String toString() {
            return String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bg.Qj(this.fGV), this.hSD, this.fNG, this.hSE});
        }
    }

    public u(int i, String str, String str2, String str3) {
        this("", "", i, str, str2, str3, 0, "", false, false);
    }

    public u(String str, String str2, String str3, int i) {
        this(str, str2, 0, "", "", "", i, str3, false, false);
    }

    public u(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, boolean z, boolean z2) {
        int i3;
        this.hSt = "";
        this.hSu = "";
        this.hSv = false;
        this.hSw = false;
        this.errType = 0;
        this.errCode = 0;
        this.hsW = 3;
        this.hSx = 0;
        this.hSy = 0;
        this.hSz = false;
        String str7 = "MicroMsg.NetSceneManualAuth";
        StringBuilder append = new StringBuilder("summerauth NetSceneManualAuth this: ").append(this).append(" account: ").append(str).append(" rawPsw len: ");
        if (str2 == null) {
            i3 = -1;
        } else {
            i3 = str2.length();
        }
        w.d(str7, append.append(i3).append(" secCodetype: ").append(i).append(" secCode: ").append(str3).append(" sid: ").append(str4).append(" encryptKey: ").append(str5).append(" inputType: ").append(i2).append(" authTicket: ").append(str6).append(" useRawPwd: ").append(z).append(" isMobileAutoLogin: ").append(z2).append(" stack: ").append(bg.bJZ()).toString());
        this.hSw = z2;
        this.htt = new aq(701);
        d dVar = (d) this.htt.BG();
        int i4 = aq.ze().getInt("key_auth_update_version", 0);
        w.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(i4), Integer.valueOf(com.tencent.mm.protocal.d.sYN));
        if (i4 == 0) {
            dVar.sZw = 1;
            c.oTb.a(148, 0, 1, false);
            dVar.sZk = true;
        } else if (i4 < com.tencent.mm.protocal.d.sYN) {
            dVar.sZw = 16;
            c.oTb.a(148, 1, 1, false);
        } else {
            dVar.sZw = 1;
        }
        dVar.dj(0);
        akv com_tencent_mm_protocal_c_akv = new akv();
        akt com_tencent_mm_protocal_c_akt = new akt();
        dVar.sZj.tOB = com_tencent_mm_protocal_c_akv;
        dVar.sZj.tOC = com_tencent_mm_protocal_c_akt;
        com_tencent_mm_protocal_c_akt.tOA = i2;
        ek ekVar = new ek();
        com_tencent_mm_protocal_c_akt.thy = ekVar;
        ekVar.thq = str6;
        ekVar.tiw = 0;
        ekVar.thl = new avw().bb(new byte[0]);
        ekVar.thk = new avw().bb(new byte[0]);
        bmh com_tencent_mm_protocal_c_bmh = new bmh();
        ekVar.tiu = com_tencent_mm_protocal_c_bmh;
        com_tencent_mm_protocal_c_bmh.tjW = "";
        com_tencent_mm_protocal_c_bmh.tjV = "";
        com_tencent_mm_protocal_c_bmh.ulQ = "";
        bpn com_tencent_mm_protocal_c_bpn = new bpn();
        ekVar.tiv = com_tencent_mm_protocal_c_bpn;
        com_tencent_mm_protocal_c_bpn.tHj = "";
        com_tencent_mm_protocal_c_bpn.tHi = "";
        if (i == 1) {
            com_tencent_mm_protocal_c_bmh.tjW = str3;
            com_tencent_mm_protocal_c_bmh.tjV = str4;
            com_tencent_mm_protocal_c_bmh.ulQ = str5;
            com_tencent_mm_protocal_c_bpn.tHj = "";
            com_tencent_mm_protocal_c_bpn.tHi = "";
        } else if (i == 3) {
            com_tencent_mm_protocal_c_bmh.tjW = "";
            com_tencent_mm_protocal_c_bmh.tjV = "";
            com_tencent_mm_protocal_c_bmh.ulQ = "";
            com_tencent_mm_protocal_c_bpn.tHj = str3;
            com_tencent_mm_protocal_c_bpn.tHi = str4;
        }
        if (bg.mA(str) && h.vG().uV()) {
            c.oTb.a(148, 2, 1, false);
            this.hSt = (String) h.vI().vr().get(3, null);
            this.hSu = (String) h.vI().vr().get(19, null);
            i.e eVar = (i.e) this.htt.zg();
            str = bg.mz((String) h.vI().vr().get(2, null));
            if (bg.mA(str)) {
                str = new o(bg.a((Integer) h.vI().vr().get(9, null), 0)).toString();
            } else {
                eVar.ieb = str;
            }
        } else if (z || z2) {
            this.hSt = str2;
            this.hSu = str2;
        } else {
            this.hSt = bg.PR(bg.mz(str2));
            this.hSu = bg.PS(bg.mz(str2));
        }
        com_tencent_mm_protocal_c_akv.jNj = str;
        byte[] bArr = null;
        if (!(i == 1 || i == 3)) {
            if (i == 2) {
                bArr = h.vG().gXc.b(bg.getLong(str, 0), str3);
            } else if (bg.PJ(str)) {
                bArr = h.vG().gXc.a(bg.getLong(str, 0), this.hSu, true);
            }
        }
        String str8 = "MicroMsg.NetSceneManualAuth";
        String str9 = "summerauth loginbuf len:%d content:[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[1] = bg.Qj(bg.bl(bArr));
        w.i(str8, str9, objArr);
        avw com_tencent_mm_protocal_c_avw = new avw();
        if (bg.bm(bArr)) {
            bArr = new byte[0];
        }
        ekVar.tit = com_tencent_mm_protocal_c_avw.bb(bArr);
        com_tencent_mm_protocal_c_akv.tjK = this.hSu;
        com_tencent_mm_protocal_c_akv.tjU = this.hSt;
    }

    public final void kC(String str) {
        d dVar = (d) this.htt.BG();
        dVar.sZj.tOB.tjK = str;
        dVar.sZj.tOB.tjU = str;
        dVar.sZj.tOC.thy.tit = new avw().bb(new byte[0]);
        this.hSt = str;
        this.hSu = str;
    }

    public final int getType() {
        return 701;
    }

    protected final int ub() {
        return 5;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void a(a aVar) {
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final u Jg() {
        this.hSz = true;
        return this;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        d dVar = (d) pVar.BG();
        final i.e eVar = (i.e) pVar.zg();
        this.errType = i2;
        this.errCode = i3;
        bgf com_tencent_mm_protocal_c_bgf = eVar.sZm;
        if (com_tencent_mm_protocal_c_bgf == null) {
            w.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
            this.gUD.a(4, -1, "", this);
            c.oTb.a(148, 3, 1, false);
            return;
        }
        w.i("MicroMsg.NetSceneManualAuth", "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, com_tencent_mm_protocal_c_bgf, Integer.valueOf(com_tencent_mm_protocal_c_bgf.ugx), com_tencent_mm_protocal_c_bgf.ugy, com_tencent_mm_protocal_c_bgf.ugz, com_tencent_mm_protocal_c_bgf.ugA);
        int i4;
        if (i2 == 0 && i3 == 0) {
            if ((r2 & 2) != 0) {
                ap apVar = com_tencent_mm_protocal_c_bgf.ugz;
                if (apVar == null || bg.mA(apVar.jNj)) {
                    w.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
                    this.gUD.a(4, -1, "", this);
                    return;
                } else if (aq.b(pVar) == 2) {
                    c.oTb.a(148, 7, 1, false);
                    w.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", Integer.valueOf(this.hSy));
                    this.hSy++;
                    if (this.hSy > 1) {
                        this.gUD.a(4, -1, "", this);
                        return;
                    }
                    ((d) this.hsK.BG()).sZj.tOC.thy.tiw = 1;
                    a(this.hsD, this.gUD);
                    return;
                } else {
                    w.d("MicroMsg.NetSceneManualAuth", "summerauth decode succeed!");
                    h.vL().bJi();
                    w.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())));
                    com.tencent.mm.u.u.a(eVar.sZm, false);
                    ((PluginAuth) h.j(PluginAuth.class)).getHandleAuthResponseCallbacks().a(dVar, eVar, false);
                    if (this.hSw) {
                        h.vI().vr().set(2, dVar.sZj.tOB.jNj);
                    }
                    h.vH().gXC.a(new bb(new com.tencent.mm.u.bb.a(this) {
                        final /* synthetic */ u hSA;

                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar == null || eVar.Cc() == null || eVar.idY == null || eVar.sZm == null || eVar.sZm.ugy == null) {
                                c.oTb.a(148, 8, 1, false);
                                w.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
                                return;
                            }
                            w.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, uin:%d", bg.Qj(bg.bl(eVar.idY)), Integer.valueOf(eVar.sZm.ugy.leD));
                            eVar.Cc().i(eVar.idY, eVar.sZm.ugy.leD);
                        }
                    }), 0);
                    if (bg.f((Integer) h.vI().vr().get(15, null)) != 0) {
                        ((b) h.h(b.class)).Hy().gg(10);
                    }
                    if ((com_tencent_mm_protocal_c_bgf.ugy.tht & 8) == 0) {
                        Object xL = m.xL();
                        if (!TextUtils.isEmpty(xL)) {
                            h.vH().gXC.a(new r(xL), 0);
                        }
                    } else {
                        w.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", Integer.valueOf(com_tencent_mm_protocal_c_bgf.ugy.tht));
                        c.oTb.a(148, 9, 1, false);
                    }
                    int i5 = 4;
                    if (dVar.sZj.tOC.thy.tit != null && dVar.sZj.tOC.thy.tit.tZn > 0) {
                        i5 = 1;
                    } else if (dVar.sZj.tOC.tOA == 1) {
                        i5 = 2;
                    }
                    com.tencent.mm.plugin.report.b.d.o(1, i5, dVar.sZj.tOB.jNj);
                    if (i2 == 0 && i3 == 0) {
                        bad com_tencent_mm_protocal_c_bad = ((i.e) this.htt.zg()).sZm.ugy.thp;
                        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
                            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
                            while (it.hasNext()) {
                                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                                if (com_tencent_mm_protocal_c_bdv.oTD == 1) {
                                    i4 = bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 0);
                                    break;
                                }
                            }
                        }
                        i4 = 0;
                        com.tencent.mm.plugin.c.b.hi(i4);
                        w.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
                        com.tencent.mm.sdk.b.b itVar = new it();
                        itVar.fOs.fDU = true;
                        com.tencent.mm.sdk.b.a.urY.m(itVar);
                    }
                    h.vL().bJk();
                    this.gUD.a(i2, i3, str, this);
                    return;
                }
            }
            w.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
            this.gUD.a(4, -1, "", this);
        } else if (i2 == 4 && i3 == -301) {
            w.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
            c.oTb.a(148, 4, 1, false);
            if (com_tencent_mm_protocal_c_bgf == null || com_tencent_mm_protocal_c_bgf.ugA == null) {
                w.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
            } else {
                aq.a(true, com_tencent_mm_protocal_c_bgf.ugA.tjM, com_tencent_mm_protocal_c_bgf.ugA.tjN, com_tencent_mm_protocal_c_bgf.ugA.tjL);
            }
            this.hsW--;
            if (this.hsW <= 0) {
                w.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
                this.gUD.a(3, -1, "", this);
                return;
            }
            w.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", Integer.valueOf(this.hsW));
            a(this.hsD, this.gUD);
        } else if (!this.hSz && i2 == 4 && i3 == -102) {
            c.oTb.a(148, 5, 1, false);
            i4 = pVar.BG().sZA.ver;
            w.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            h.vL().D(new Runnable(this) {
                final /* synthetic */ u hSA;

                public final void run() {
                    new m().a(this.hSA.hsD, new e(this) {
                        final /* synthetic */ AnonymousClass1 hSB;

                        {
                            this.hSB = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                this.hSB.hSA.a(this.hSB.hSA.hsD, this.hSB.hSA.gUD);
                            } else {
                                this.hSB.hSA.gUD.a(i, i2, "", this.hSB.hSA);
                            }
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|onGYNetEnd1";
                }
            });
        } else if (i2 == 4 && i3 == -217) {
            this.gUD.a(i2, i3, str, this);
            c.oTb.a(148, 47, 1, false);
        } else if (i2 == 4 && i3 == -218) {
            this.gUD.a(i2, i3, str, this);
            c.oTb.a(148, 53, 1, false);
        } else {
            w.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", Integer.valueOf(i3), Integer.valueOf(i2), str);
            this.gUD.a(i2, i3, str, this);
            c.oTb.a(148, 6, 1, false);
        }
    }

    public final int Fx() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return 3;
        }
        int i;
        bad com_tencent_mm_protocal_c_bad = ((i.e) this.htt.zg()).sZm.ugy.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 6) {
                    i = bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 3);
                    break;
                }
            }
        }
        i = 3;
        return i;
    }

    public final String Jh() {
        return ((i.e) this.htt.zg()).sZm.ugy == null ? "" : ((i.e) this.htt.zg()).sZm.ugy.tho;
    }

    public final String FJ() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return "";
        }
        int Ji = Ji();
        if (Ji == 3) {
            if (((i.e) this.htt.zg()).sZm.ugy.thj != null) {
                return bg.mz(((i.e) this.htt.zg()).sZm.ugy.thj.tHi);
            }
        } else if (Ji == 1 && ((i.e) this.htt.zg()).sZm.ugy.thi != null) {
            return bg.mz(((i.e) this.htt.zg()).sZm.ugy.thi.tjV);
        }
        return "";
    }

    public final byte[] FI() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return new byte[0];
        }
        int Ji = Ji();
        if (Ji == 3) {
            if (((i.e) this.htt.zg()).sZm.ugy.thj != null) {
                return n.a(((i.e) this.htt.zg()).sZm.ugy.thj.tHl, new byte[0]);
            }
        } else if (Ji == 1) {
            if (((i.e) this.htt.zg()).sZm.ugy.thi != null) {
                return n.a(((i.e) this.htt.zg()).sZm.ugy.thi.tfh, new byte[0]);
            }
        } else if (Ji == 2 && ((d) this.htt.BG()).sZj.tOB != null) {
            h.vG().gXc.a(bg.getLong(((d) this.htt.BG()).sZj.tOB.jNj, 0), n.a(((i.e) this.htt.zg()).sZm.ugy.thh));
            return h.vG().gXc.R(bg.getLong(((d) this.htt.BG()).sZj.tOB.jNj, 0));
        }
        return new byte[0];
    }

    public final int Ji() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            w.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
            return 0;
        } else if (this.errType != 4) {
            w.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", Integer.valueOf(this.errType));
            return 0;
        } else if (this.errCode == -311) {
            return 2;
        } else {
            if (this.errCode == -6) {
                return 1;
            }
            return this.errCode == -310 ? 3 : 0;
        }
    }

    public final String Jj() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return "";
        }
        if (Ji() != 1 || ((i.e) this.htt.zg()).sZm.ugy.thi == null) {
            return "";
        }
        return ((i.e) this.htt.zg()).sZm.ugy.thi.ulQ != null ? ((i.e) this.htt.zg()).sZm.ugy.thi.ulQ : null;
    }

    public final String Fv() {
        return ((i.e) this.htt.zg()).sZm.ugy.thq;
    }

    public final String Jk() {
        return ((i.e) this.htt.zg()).sZm.ugz.tdA;
    }

    public final int Jl() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return 0;
        }
        int i;
        bad com_tencent_mm_protocal_c_bad = ((i.e) this.htt.zg()).sZm.ugy.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 11) {
                    i = bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final BindWordingContent Jm() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return null;
        }
        String str;
        BindWordingContent kv;
        bad com_tencent_mm_protocal_c_bad = ((i.e) this.htt.zg()).sZm.ugy.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 12) {
                    str = com_tencent_mm_protocal_c_bdv.ufb;
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            a aVar = new a();
            try {
                kv = a.kv(str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneManualAuth", e, "", new Object[0]);
                kv = null;
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.NetSceneManualAuth", e2, "", new Object[0]);
            }
            return kv;
        }
        kv = null;
        return kv;
    }

    public final String Jn() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return "";
        }
        bad com_tencent_mm_protocal_c_bad = ((i.e) this.htt.zg()).sZm.ugy.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 16) {
                    return com_tencent_mm_protocal_c_bdv.ufb;
                }
            }
        }
        return "";
    }

    public final int Jo() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return 0;
        }
        int i;
        bad com_tencent_mm_protocal_c_bad = ((i.e) this.htt.zg()).sZm.ugy.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 13) {
                    i = bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final boolean Jp() {
        if (((i.e) this.htt.zg()).sZm.ugy == null) {
            return true;
        }
        bad com_tencent_mm_protocal_c_bad = ((i.e) this.htt.zg()).sZm.ugy.thp;
        if (!(com_tencent_mm_protocal_c_bad == null || com_tencent_mm_protocal_c_bad.ubp == null || com_tencent_mm_protocal_c_bad.ubp.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bad.ubp.iterator();
            while (it.hasNext()) {
                bdv com_tencent_mm_protocal_c_bdv = (bdv) it.next();
                if (com_tencent_mm_protocal_c_bdv.oTD == 18) {
                    if (bg.getInt(com_tencent_mm_protocal_c_bdv.ufb, 0) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
