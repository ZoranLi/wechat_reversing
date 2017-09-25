package com.tencent.mm.u;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;

public final class u {
    public static void a(bgf com_tencent_mm_protocal_c_bgf, boolean z) {
        int i;
        int i2 = com_tencent_mm_protocal_c_bgf.ugx;
        String str = "MicroMsg.HandleAuthResponse";
        String str2 = "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_bgf.ugy == null ? -1 : com_tencent_mm_protocal_c_bgf.ugy.ths);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = com_tencent_mm_protocal_c_bgf.ugy;
        objArr[3] = com_tencent_mm_protocal_c_bgf.ugz;
        objArr[4] = com_tencent_mm_protocal_c_bgf.ugA;
        objArr[5] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        int i3 = 0;
        if ((i2 & 1) != 0) {
            i3 = com_tencent_mm_protocal_c_bgf.ugy.leD;
        } else {
            w.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
        }
        h.vJ();
        h.eO(i3);
        t vr = h.vI().vr();
        vr.set(256, Boolean.valueOf(false));
        if ((i2 & 1) != 0) {
            if (com_tencent_mm_protocal_c_bgf.ugy.ths > 0) {
                vr.a(a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf((long) com_tencent_mm_protocal_c_bgf.ugy.ths));
                vr.a(a.USERINFO_UPDATE_UPDATE_TIME_LONG, Long.valueOf(bg.Ny()));
                vr.a(a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf((long) d.sYN));
                w.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", Integer.valueOf(com_tencent_mm_protocal_c_bgf.ugy.ths), Boolean.valueOf(z));
                if (z) {
                    long j;
                    c cVar = c.oTb;
                    if (com_tencent_mm_protocal_c_bgf.ugy.ths == 2) {
                        j = 19;
                    } else {
                        j = 41;
                    }
                    cVar.a(148, j, 1, true);
                } else {
                    c.oTb.a(148, com_tencent_mm_protocal_c_bgf.ugy.ths == 2 ? 10 : 11, 1, true);
                }
            } else {
                vr.a(a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf((long) com_tencent_mm_protocal_c_bgf.ugy.ths));
                vr.a(a.USERINFO_UPDATE_UPDATE_TIME_LONG, Long.valueOf(bg.Ny()));
                vr.a(a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf(0));
            }
        }
        if ((i2 & 2) != 0) {
            ap apVar = com_tencent_mm_protocal_c_bgf.ugz;
            w.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", o.getString(apVar.tdy), Integer.valueOf(apVar.jNB), apVar.jNj, apVar.jOp, apVar.tdz, apVar.tdA, apVar.hAI, Integer.valueOf(apVar.tdB), Integer.valueOf(apVar.tdC), apVar.tdD, Integer.valueOf(apVar.tdE), apVar.tdF, apVar.tdF, Integer.valueOf(apVar.tdH), apVar.tdI);
            if (!z) {
                vr.set(52, Integer.valueOf(apVar.tdC));
            }
            vr.set(9, Integer.valueOf(apVar.tdy));
            vr.set(7, Integer.valueOf(apVar.jNB));
            vr.set(2, apVar.jNj);
            vr.set(4, apVar.jOp);
            vr.set(5, apVar.tdz);
            vr.set(6, apVar.tdA);
            vr.set(42, apVar.hAI);
            vr.set(34, Integer.valueOf(apVar.tdB));
            h.vI().vs().RW(apVar.tdD);
            vr.set(64, Integer.valueOf(apVar.tdE));
            vr.set(21, apVar.tdF);
            vr.set(22, apVar.tdF);
            vr.set(17, Integer.valueOf(apVar.tdH));
            ao.hlW.L("login_weixin_username", apVar.jNj);
            ao.hlW.c(apVar.tdA, apVar.tdy, apVar.tdz);
        } else {
            w.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
        }
        boolean z2 = false;
        if ((i2 & 1) != 0) {
            boolean a;
            e eVar;
            boolean z3;
            dr drVar = com_tencent_mm_protocal_c_bgf.ugy;
            String str3 = drVar.thm;
            String bo = bg.bo(n.a(drVar.thn));
            w.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", drVar.thq, Integer.valueOf(drVar.thr), Integer.valueOf(drVar.ths), Integer.valueOf(drVar.tht), bg.Qj(str3), bg.Qj(bo), drVar.tdI);
            int i4 = drVar.thg;
            o oVar = new o(bg.f((Integer) vr.get(9, Integer.valueOf(0))));
            str = "MicroMsg.HandleAuthResponse";
            str2 = "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(i4);
            objArr[1] = oVar;
            if (drVar.thh == null) {
                i3 = -1;
            } else {
                i3 = drVar.thh.tZn;
            }
            objArr[2] = Integer.valueOf(i3);
            w.i(str, str2, objArr);
            if (i4 != 0) {
                if (i4 == 1) {
                    c.oTb.a(148, 20, 1, false);
                    a = h.vG().gXc.a(oVar.longValue(), n.a(drVar.thh));
                    w.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", Integer.valueOf(r3.length));
                    str = bg.bo(h.vG().gXc.S(oVar.longValue()));
                    vr.set(-1535680990, str3);
                    vr.set(46, bo);
                    vr.set(72, str);
                    vr.set(29, drVar.tdI);
                } else if (i4 == 2) {
                    c.oTb.a(148, 21, 1, false);
                    h.vG().gXc.T(oVar.longValue());
                    String bo2 = bg.bo(h.vG().gXc.S(oVar.longValue()));
                    vr.set(-1535680990, str3);
                    vr.set(46, bo);
                    vr.set(72, bo2);
                    vr.set(29, drVar.tdI);
                    a = false;
                } else {
                    w.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", Integer.valueOf(i4));
                }
                w.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", Integer.valueOf(i4));
                if (drVar.thi != null) {
                    str = bg.bo(n.a(drVar.thi.tjZ));
                    if (str != null && str.length() > 0) {
                        vr.set(47, str);
                        h.vI().gXW.set(18, str);
                    }
                    w.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", bg.Qj(str));
                }
                i = drVar.thu;
                w.i("MicroMsg.HandleAuthResponse", "summerauth mmtls:%d", Integer.valueOf(i));
                h.vI().gXW.set(47, Integer.valueOf(i));
                eVar = h.vH().gXC.hsZ;
                if (eVar != null) {
                    if ((i & 1) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    eVar.bc(z3);
                }
                z2 = a;
            }
            a = false;
            w.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", Integer.valueOf(i4));
            if (drVar.thi != null) {
                str = bg.bo(n.a(drVar.thi.tjZ));
                vr.set(47, str);
                h.vI().gXW.set(18, str);
                w.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", bg.Qj(str));
            }
            i = drVar.thu;
            w.i("MicroMsg.HandleAuthResponse", "summerauth mmtls:%d", Integer.valueOf(i));
            h.vI().gXW.set(47, Integer.valueOf(i));
            eVar = h.vH().gXC.hsZ;
            if (eVar != null) {
                if ((i & 1) != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                eVar.bc(z3);
            }
            z2 = a;
        } else {
            w.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
            c.oTb.a(148, 22, 1, false);
        }
        if ((i2 & 4) != 0) {
            c.oTb.a(148, 23, 1, false);
            anj com_tencent_mm_protocal_c_anj = com_tencent_mm_protocal_c_bgf.ugA;
            aq.a(false, com_tencent_mm_protocal_c_anj.tjM, com_tencent_mm_protocal_c_anj.tjN, com_tencent_mm_protocal_c_anj.tjL);
        } else {
            w.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
        }
        if (z) {
            i = 4;
            bo2 = m.xL();
            if (z2) {
                i = 1;
                bo2 = m.xK();
            }
            w.i("MicroMsg.HandleAuthResponse", "loginType %s", Integer.valueOf(i));
            com.tencent.mm.plugin.report.b.d.o(1, i, bo2);
        }
        vr.set(3, "");
        vr.set(19, "");
        vr.jY(true);
        h.vI().gXW.setInt(46, 0);
        a.wJ();
    }
}
