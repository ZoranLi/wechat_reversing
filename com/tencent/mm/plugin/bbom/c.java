package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.av.f;
import com.tencent.mm.e.a.el;
import com.tencent.mm.e.a.gv;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.a.iw;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.a.qj;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qo;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.bz;
import com.tencent.mm.j.a;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.messenger.foundation.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.amf;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class c implements b, e {
    public final void a(x xVar, x xVar2, ame com_tencent_mm_protocal_c_ame, byte[] bArr, boolean z) {
        Object obj;
        String str;
        String str2 = xVar.field_username;
        String str3 = xVar.field_encryptUsername;
        if (!(xVar2 == null || bg.mz(xVar2.gkL).equals(bg.mz(com_tencent_mm_protocal_c_ame.tQV)))) {
            com.tencent.mm.ar.c.Ih();
            com.tencent.mm.ar.c.jW(str2);
        }
        if (bg.bm(bArr)) {
            a(xVar, com_tencent_mm_protocal_c_ame, true);
        } else if (x.yC(xVar.field_verifyFlag)) {
            a(com_tencent_mm_protocal_c_ame, str2, xVar, true);
        }
        if (xVar2 == null || a.ez(xVar2.field_type) || !a.ez(xVar.field_type)) {
            obj = null;
        } else {
            obj = 1;
        }
        String str4 = "MicroMsg.BigBallContactAssemblerImpl";
        String str5 = "username:%s PhoneNumList size:%s";
        Object[] objArr = new Object[2];
        objArr[0] = xVar.field_username;
        if (com_tencent_mm_protocal_c_ame.tQW == null) {
            str = "";
        } else {
            str = Integer.valueOf(bg.f(Integer.valueOf(com_tencent_mm_protocal_c_ame.tQW.tVf.size())));
        }
        objArr[1] = str;
        w.i(str4, str5, objArr);
        StringBuffer stringBuffer = new StringBuffer();
        if (!(com_tencent_mm_protocal_c_ame.tQW == null || com_tencent_mm_protocal_c_ame.tQW.tVf == null)) {
            Iterator it = com_tencent_mm_protocal_c_ame.tQW.tVf.iterator();
            while (it.hasNext()) {
                aqk com_tencent_mm_protocal_c_aqk = (aqk) it.next();
                if (com_tencent_mm_protocal_c_aqk.tVe != null) {
                    stringBuffer.append(com_tencent_mm_protocal_c_aqk.tVe + ",");
                }
            }
        }
        w.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", xVar.field_username, stringBuffer.toString());
        str = null;
        if (xVar2 != null) {
            str = xVar2.gkQ;
        }
        if (str == null || str.equals("")) {
            ap.yY();
            bb AI = com.tencent.mm.u.c.wS().AI(str3);
            if (AI != null) {
                str = AI.field_conPhone;
            }
        }
        w.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", xVar.field_username, bg.mz(str));
        if (!bg.mA(str)) {
            int i;
            Object obj2 = null;
            Object obj3 = null;
            for (String str6 : str.split(",")) {
                if (!bg.mA(stringBuffer.toString())) {
                    String[] split = stringBuffer.toString().split(",");
                    int length = split.length;
                    int i2 = 0;
                    while (i2 < length) {
                        if (str6.equals(split[i2])) {
                            obj2 = null;
                            break;
                        } else {
                            i2++;
                            i = 1;
                        }
                    }
                    if (obj2 != null) {
                        stringBuffer.append(str6);
                        obj3 = 1;
                    }
                }
            }
            if (obj3 != null) {
                com.tencent.mm.bd.a com_tencent_mm_protocal_c_amr = new amr();
                com_tencent_mm_protocal_c_amr.tRa = xVar.field_username;
                aql com_tencent_mm_protocal_c_aql = new aql();
                if (!bg.mA(stringBuffer.toString())) {
                    String[] split2 = stringBuffer.toString().split(",");
                    com_tencent_mm_protocal_c_aql.jNd = split2.length;
                    com_tencent_mm_protocal_c_aql.tVf = new LinkedList();
                    for (String str7 : split2) {
                        aqk com_tencent_mm_protocal_c_aqk2 = new aqk();
                        com_tencent_mm_protocal_c_aqk2.tVe = str7;
                        com_tencent_mm_protocal_c_aql.tVf.add(com_tencent_mm_protocal_c_aqk2);
                    }
                    com_tencent_mm_protocal_c_amr.tQW = com_tencent_mm_protocal_c_aql;
                    ap.yY();
                    com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(60, com_tencent_mm_protocal_c_amr));
                }
            }
            if (obj != null && 15 == com_tencent_mm_protocal_c_ame.tfW) {
                g gVar = g.oUh;
                Object[] objArr2 = new Object[4];
                objArr2[0] = xVar.field_username;
                objArr2[1] = Integer.valueOf(3);
                objArr2[2] = Integer.valueOf(bg.mA(af.FY().iZ(xVar.field_username).EP()) ? 0 : 1);
                if (stringBuffer.toString().split(",").length >= 5) {
                    i = 5;
                } else {
                    i = stringBuffer.toString().split(",").length;
                }
                objArr2[3] = Integer.valueOf(i);
                gVar.i(12040, objArr2);
            }
        }
        w.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", xVar.field_username, stringBuffer.toString());
        str = stringBuffer.toString();
        if (!bg.mA(str)) {
            w.i("MicroMsg.BigBallContactAssemblerImpl", str);
            xVar.cr(str);
        }
        if (!(o.dH(str2) || com_tencent_mm_protocal_c_ame.tDC == null)) {
            j.a(str2, com_tencent_mm_protocal_c_ame.tDC);
        }
        boolean z2 = false;
        ap.yY();
        bb AI2 = com.tencent.mm.u.c.wS().AI(xVar.field_username);
        if (bg.mA(xVar.field_conRemark)) {
            if ((AI2 == null || bg.mA(AI2.field_encryptUsername)) && !bg.mA(str3)) {
                ap.yY();
                AI2 = com.tencent.mm.u.c.wS().AI(str3);
            }
            if (!(AI2 == null || bg.mA(AI2.field_encryptUsername))) {
                w.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + AI2.field_encryptUsername);
                xVar.bP(AI2.field_conRemark);
                xVar.bV(com.tencent.mm.platformtools.c.mp(AI2.field_conRemark));
                xVar.bW(com.tencent.mm.platformtools.c.mq(AI2.field_conRemark));
                z2 = a(xVar, AI2);
            }
            switch (xVar.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.modelfriend.b bVar = null;
                    if (com_tencent_mm_protocal_c_ame != null && !bg.mA(com_tencent_mm_protocal_c_ame.tQO)) {
                        w.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", com_tencent_mm_protocal_c_ame.tQO, com_tencent_mm_protocal_c_ame.tQP);
                        com.tencent.mm.modelfriend.c FY = af.FY();
                        String str8 = com_tencent_mm_protocal_c_ame.tQO;
                        str5 = com_tencent_mm_protocal_c_ame.tQP;
                        bVar = FY.ja(str8);
                        if (bVar == null) {
                            bVar = FY.ja(str5);
                        }
                    } else if (!bg.mA(str3)) {
                        bVar = af.FY().iZ(str3);
                    }
                    if (bVar == null) {
                        w.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
                    } else {
                        w.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", bg.mz(bVar.ER()), bg.mz(bVar.getUsername()), Boolean.valueOf(bVar.Fa()));
                    }
                    if (!(bVar == null || bg.mA(bVar.ER()) || !bVar.Fa())) {
                        w.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", bVar.ER(), bVar.getUsername(), Boolean.valueOf(z2));
                        bVar.username = xVar.field_username;
                        bVar.status = 2;
                        bVar.EZ();
                        if (!z2) {
                            xVar.bP(bVar.ER());
                            xVar.bV(com.tencent.mm.platformtools.c.mp(bVar.ER()));
                            xVar.bW(com.tencent.mm.platformtools.c.mq(bVar.ER()));
                            z2 = true;
                        }
                        if (a.ez(xVar.field_type)) {
                            w.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", bVar.ER(), bVar.getUsername(), Boolean.valueOf(z2));
                            af.FY().a(bVar.EP(), bVar);
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if (!(AI2 == null || bg.mA(xVar.gkK) || xVar.gkK.equals(AI2.field_conDescription))) {
            a(xVar, AI2);
        }
        z2 = false;
        w.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", xVar.field_username, Boolean.valueOf(z2), str3);
        if (z2) {
            o.u(xVar);
        }
        str = null;
        ap.yY();
        com.tencent.mm.sdk.e.c AI3 = com.tencent.mm.u.c.wS().AI(xVar.field_encryptUsername);
        if (AI3 != null) {
            str = AI3.field_contactLabels;
        }
        if (bg.mA(str)) {
            ap.yY();
            AI3 = com.tencent.mm.u.c.wS().AI(xVar.field_username);
            if (AI3 != null) {
                str = AI3.field_contactLabels;
            }
        }
        if (!bg.mA(str)) {
            com.tencent.mm.plugin.label.a.a.aFG().cE(xVar.field_username, str);
            AI3.field_contactLabels = "";
            ap.yY();
            com.tencent.mm.u.c.wS().a(AI3);
        }
    }

    public final void b(x xVar, x xVar2, ame com_tencent_mm_protocal_c_ame, byte[] bArr, boolean z) {
        Object obj;
        com.tencent.mm.sdk.b.b qoVar;
        int i;
        Object obj2;
        BizInfo hO;
        String str;
        long currentTimeMillis;
        aj Rm;
        ae Rm2;
        au Ai;
        String str2 = xVar.field_username;
        String str3 = xVar.field_encryptUsername;
        if (o.dH(str2)) {
            String aGl;
            if (com_tencent_mm_protocal_c_ame.tDC != null) {
                Iterator it;
                jz jzVar;
                LinkedList linkedList = com_tencent_mm_protocal_c_ame.tDC.tpX;
                if (l.a.sBx == null) {
                    obj = null;
                } else {
                    aGl = l.a.sBx.aGl();
                    if (!bg.mA(aGl) && aGl.equals(str2) && o.dH(str2)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                jzVar = (jz) it.next();
                                if (!bg.mA(jzVar.jNj) && jzVar.jNj.equals(m.xL())) {
                                    obj = null;
                                    break;
                                }
                            }
                        }
                        if (l.a.sBy != null) {
                            if (l.a.sBy.cH(str2, m.xL())) {
                                w.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
                                qoVar = new qo();
                                qoVar.fXG.userName = str2;
                                com.tencent.mm.sdk.b.a.urY.m(qoVar);
                            }
                            l.a.sBy.a(str2, null, 0.0d, 0.0d, "", "", "");
                        }
                        if (!(l.a.sBx == null || bg.mA(l.a.sBy.aGv()))) {
                            w.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", l.a.sBx.aGl());
                            qoVar = new el();
                            qoVar.fIn.username = l.a.sBx.aGl();
                            com.tencent.mm.sdk.b.a.urY.m(qoVar);
                        }
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    linkedList = com_tencent_mm_protocal_c_ame.tDC.tpX;
                    com.tencent.mm.sdk.b.b qkVar = new qk();
                    qkVar.fXu.fXw = true;
                    com.tencent.mm.sdk.b.a.urY.m(qkVar);
                    if (!bg.mA(str2) && o.dH(str2) && !bg.mA(qkVar.fXv.fXy) && str2.equals(qkVar.fXv.fXy)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                jzVar = (jz) it.next();
                                if (!bg.mA(jzVar.jNj)) {
                                    if (jzVar.jNj.equals(m.xL())) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (l.a.sBr != null) {
                            l.a.sBr.a(str2, null, "", "", 0);
                        }
                        qoVar = new qk();
                        qoVar.fXu.fXx = true;
                        com.tencent.mm.sdk.b.a.urY.m(qoVar);
                        qoVar = new qj();
                        qoVar.fXs.fXt = true;
                        com.tencent.mm.sdk.b.a.urY.m(qoVar);
                    }
                }
                linkedList = com_tencent_mm_protocal_c_ame.tDC.tpX;
                if (l.a.sBz != null && linkedList != null) {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        jzVar = (jz) it.next();
                        if (bg.mA(jzVar.jNj) || !jzVar.jNj.equals(m.xL())) {
                        }
                    }
                    obj = 1;
                    if (!(obj == null || l.a.sBz == null)) {
                        l.a.sBz.AY(str2);
                    }
                }
                obj = null;
                l.a.sBz.AY(str2);
            }
            aGl = "MicroMsg.BigBallContactAssemblerImpl";
            String str4 = "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ";
            Object[] objArr = new Object[9];
            objArr[0] = str2;
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_ame.tDC == null ? 0 : com_tencent_mm_protocal_c_ame.tDC.ksW);
            objArr[2] = com_tencent_mm_protocal_c_ame.tQJ;
            objArr[3] = com_tencent_mm_protocal_c_ame.tQI;
            objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_ame.tQT);
            objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_ame.tQS);
            objArr[6] = com_tencent_mm_protocal_c_ame.mvZ;
            objArr[7] = Integer.valueOf(com_tencent_mm_protocal_c_ame.tQR);
            if (com_tencent_mm_protocal_c_ame.tDC == null) {
                i = -1;
            } else {
                i = com_tencent_mm_protocal_c_ame.tDC.tpY;
            }
            objArr[8] = Integer.valueOf(i);
            w.i(aGl, str4, objArr);
            if (!(com_tencent_mm_protocal_c_ame.tDC == null || com_tencent_mm_protocal_c_ame.tDC.ksW == 0)) {
                com.tencent.mm.g.a.a.a aVar = new com.tencent.mm.g.a.a.a();
                aVar.type = com_tencent_mm_protocal_c_ame.tQT;
                aVar.gMU = com_tencent_mm_protocal_c_ame.tQS;
                aVar.gMV = com_tencent_mm_protocal_c_ame.mvZ;
                aVar.gMW = com_tencent_mm_protocal_c_ame.tQR;
                if (com_tencent_mm_protocal_c_ame.tDC.tpY == 0) {
                    aVar.fPC = com_tencent_mm_protocal_c_ame.tQR;
                }
                if (j.q(str2, com_tencent_mm_protocal_c_ame.tQR)) {
                    com.tencent.mm.sdk.b.a.urY.m(new gv());
                    j.r(str2, com_tencent_mm_protocal_c_ame.tQT);
                }
                com.tencent.mm.sdk.b.b jhVar = new jh();
                jhVar.fPB.chatroomName = str2;
                jhVar.fPB.fPC = aVar.fPC;
                j.a(str2, com_tencent_mm_protocal_c_ame.tQI, com_tencent_mm_protocal_c_ame.tDC, m.xL(), aVar, jhVar);
            }
        }
        if (!a.ez(xVar.field_type)) {
            if (!(((xVar.field_type & 2) != 0 ? 1 : null) != null || x.eO(xVar.field_username) || o.dH(xVar.field_username))) {
                w.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", xVar.field_username, Integer.valueOf(xVar.field_type));
                ap.yY();
                com.tencent.mm.u.c.wW().Rl(xVar.field_username);
            }
        }
        if ((xVar.field_type & 2048) != 0) {
            if (xVar2 == null || (xVar2.field_type & 2048) != (xVar.field_type & 2048)) {
                if (com.tencent.mm.modelbiz.e.ia(xVar.field_username) && !com.tencent.mm.modelbiz.e.dr(xVar.field_username)) {
                    z(xVar);
                } else if (xVar.bLe() && com.tencent.mm.modelbiz.e.hY(xVar.field_username) && xVar != null && xVar.bLe() && com.tencent.mm.modelbiz.e.hY(xVar.field_username)) {
                    w.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + xVar.field_username);
                    ap.yY();
                    ae Rm3 = com.tencent.mm.u.c.wW().Rm(xVar.field_username);
                    com.tencent.mm.modelbiz.w.DH().hO(xVar.field_username);
                    if (Rm3 == null) {
                        ap.yY();
                        if (com.tencent.mm.u.c.wW().Rm("officialaccounts") == null) {
                            Rm3 = new ae("officialaccounts");
                            Rm3.bLB();
                            ap.yY();
                            com.tencent.mm.u.c.wW().d(Rm3);
                        }
                        Rm3 = new ae(xVar.field_username);
                        Rm3.cw("officialaccounts");
                        ap.yY();
                        com.tencent.mm.u.c.wW().d(Rm3);
                    }
                }
            }
        } else if ((xVar2 == null || (xVar2.field_type & 2048) != (xVar.field_type & 2048)) && com.tencent.mm.modelbiz.e.ia(xVar.field_username) && !com.tencent.mm.modelbiz.e.dr(xVar.field_username)) {
            z(xVar);
        }
        if (xVar2 == null || a.ez(xVar2.field_type) || !a.ez(xVar.field_type)) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            ap.yY();
            bb AI = com.tencent.mm.u.c.wS().AI(str2);
            if ((AI == null || bg.mA(AI.field_encryptUsername)) && !bg.mA(str3)) {
                ap.yY();
                AI = com.tencent.mm.u.c.wS().AI(str3);
            }
            if (!(AI == null || bg.mA(AI.field_encryptUsername))) {
                ap.yY();
                com.tencent.mm.u.c.wS().AJ(AI.field_encryptUsername);
            }
        }
        if (com.tencent.mm.modelbiz.e.hZ(xVar.field_username)) {
            com.tencent.mm.modelbiz.w.DO();
            com.tencent.mm.modelbiz.c.a(xVar.field_username, null);
            if (obj2 != null && com.tencent.mm.modelbiz.e.ia(xVar.field_username)) {
                if (com.tencent.mm.modelbiz.e.dr(xVar.field_username)) {
                    com.tencent.mm.modelbiz.w.DN();
                    h.a(xVar.field_username, null);
                } else if (com.tencent.mm.modelbiz.e.ie(xVar.field_username)) {
                    ap.yY();
                    if (com.tencent.mm.u.c.wW().Rm(xVar.field_username) == null) {
                        hO = com.tencent.mm.modelbiz.w.DH().hO(xVar.field_username);
                        ae aeVar = new ae(xVar.field_username);
                        if (hO.CJ()) {
                            aeVar.cw(null);
                        } else {
                            w.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", hO.CO(), xVar.field_username);
                            aeVar.cw(bg.mz(hO.CO()));
                        }
                        aeVar.bLB();
                        ap.yY();
                        com.tencent.mm.u.c.wW().d(aeVar);
                    }
                }
            }
        }
        hO = com.tencent.mm.modelbiz.e.hW(xVar.field_username);
        if (hO != null) {
            ExtInfo bd = hO.bd(false);
            if (bd != null) {
                i = 0;
                if (bd.hux != null) {
                    i = bd.hux.optInt("WXAppType", 0);
                }
                if (i != 0) {
                    obj = 1;
                    if (obj != null) {
                        com.tencent.mm.modelbiz.w.DR();
                        str = xVar.field_username;
                        if (!bg.mA(str)) {
                            hO = com.tencent.mm.modelbiz.w.DH().hO(str);
                            hO.field_attrSyncVersion = null;
                            hO.field_incrementUpdateTime = 0;
                            com.tencent.mm.modelbiz.w.DH().e(hO);
                        }
                    }
                    if ((xVar.field_type & 8) == 0) {
                        if (xVar2 == null || (xVar2.field_type & 8) != (xVar.field_type & 8)) {
                            ap.yY();
                            com.tencent.mm.u.c.wW().e(new String[]{xVar.field_username}, "@blacklist");
                        }
                    } else if (xVar2 == null || (xVar2.field_type & 8) != (xVar.field_type & 8)) {
                        ap.yY();
                        com.tencent.mm.u.c.wW().e(new String[]{xVar.field_username}, "");
                    }
                    if (!z) {
                        if (xVar != null && xVar.bLe() && a.ez(xVar.field_type)) {
                            currentTimeMillis = System.currentTimeMillis();
                            ap.yY();
                            Rm = com.tencent.mm.u.c.wW().Rm(xVar.field_username);
                            if (Rm != null && Rm.eC(4194304)) {
                                ap.yY();
                                boolean b = com.tencent.mm.u.c.wW().b(xVar.field_username, 4194304, false, Rm.field_attrflag);
                                w.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", xVar.field_username, Boolean.valueOf(b), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        }
                        if (xVar2 != null && ((int) xVar2.gTQ) > 0 && xVar2.gkI != 0 && xVar2.gkJ == 0 && xVar.gkJ == 1) {
                            w.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", xVar.field_username);
                            ap.yY();
                            com.tencent.mm.u.c.wW().RA(xVar.field_username);
                            ap.yY();
                            Rm2 = com.tencent.mm.u.c.wW().Rm("officialaccounts");
                            if (Rm2 != null) {
                                ap.yY();
                                Rm2.dt(com.tencent.mm.u.c.wW().bLK());
                                w.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", Integer.valueOf(Rm2.field_unReadCount));
                                ap.yY();
                                str = com.tencent.mm.u.c.wW().Rx("officialaccounts");
                                ap.yY();
                                Ai = com.tencent.mm.u.c.wT().Ai(str);
                                if (Ai != null || Ai.field_msgId <= 0) {
                                    Rm2.bLB();
                                } else {
                                    Rm2.W(Ai);
                                    Rm2.setContent(Ai.field_talker + ":" + Ai.field_content);
                                    Rm2.ct(Integer.toString(Ai.field_type));
                                    ap.yY();
                                    as.b oG = com.tencent.mm.u.c.wW().oG();
                                    if (oG != null) {
                                        PString pString = new PString();
                                        PString pString2 = new PString();
                                        PInt pInt = new PInt();
                                        Ai.cH("officialaccounts");
                                        Ai.setContent(Rm2.field_content);
                                        oG.a(Ai, pString, pString2, pInt, true);
                                        Rm2.cu(pString.value);
                                        Rm2.cv(pString2.value);
                                        Rm2.dx(pInt.value);
                                    }
                                }
                                ap.yY();
                                com.tencent.mm.u.c.wW().a(Rm2, Rm2.field_username);
                            }
                        }
                    }
                    if (obj2 != null) {
                        qoVar = new iw();
                        qoVar.fOH.username = xVar.field_username;
                        qoVar.fOH.fOI = xVar.fOI;
                        com.tencent.mm.sdk.b.a.urY.m(qoVar);
                    }
                    if (obj2 != null && com_tencent_mm_protocal_c_ame.tfW == 18) {
                        qoVar = new ig();
                        qoVar.fNP.fNQ = xVar.field_encryptUsername;
                        qoVar.fNP.type = 2;
                        com.tencent.mm.av.l.Kz().ld(qoVar.fNP.fNQ);
                        com.tencent.mm.sdk.b.a.urY.m(qoVar);
                    }
                    if (obj2 != null) {
                        ay(xVar.field_username, com_tencent_mm_protocal_c_ame.tfW);
                    }
                    com.tencent.mm.plugin.label.a.a.aFG().aFA();
                }
            }
        }
        obj = null;
        if (obj != null) {
            com.tencent.mm.modelbiz.w.DR();
            str = xVar.field_username;
            if (bg.mA(str)) {
                hO = com.tencent.mm.modelbiz.w.DH().hO(str);
                hO.field_attrSyncVersion = null;
                hO.field_incrementUpdateTime = 0;
                com.tencent.mm.modelbiz.w.DH().e(hO);
            }
        }
        if ((xVar.field_type & 8) == 0) {
            ap.yY();
            com.tencent.mm.u.c.wW().e(new String[]{xVar.field_username}, "");
        } else {
            ap.yY();
            com.tencent.mm.u.c.wW().e(new String[]{xVar.field_username}, "@blacklist");
        }
        if (z) {
            currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            Rm = com.tencent.mm.u.c.wW().Rm(xVar.field_username);
            ap.yY();
            boolean b2 = com.tencent.mm.u.c.wW().b(xVar.field_username, 4194304, false, Rm.field_attrflag);
            w.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", xVar.field_username, Boolean.valueOf(b2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            w.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", xVar.field_username);
            ap.yY();
            com.tencent.mm.u.c.wW().RA(xVar.field_username);
            ap.yY();
            Rm2 = com.tencent.mm.u.c.wW().Rm("officialaccounts");
            if (Rm2 != null) {
                ap.yY();
                Rm2.dt(com.tencent.mm.u.c.wW().bLK());
                w.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", Integer.valueOf(Rm2.field_unReadCount));
                ap.yY();
                str = com.tencent.mm.u.c.wW().Rx("officialaccounts");
                ap.yY();
                Ai = com.tencent.mm.u.c.wT().Ai(str);
                if (Ai != null) {
                }
                Rm2.bLB();
                ap.yY();
                com.tencent.mm.u.c.wW().a(Rm2, Rm2.field_username);
            }
        }
        if (obj2 != null) {
            qoVar = new iw();
            qoVar.fOH.username = xVar.field_username;
            qoVar.fOH.fOI = xVar.fOI;
            com.tencent.mm.sdk.b.a.urY.m(qoVar);
        }
        qoVar = new ig();
        qoVar.fNP.fNQ = xVar.field_encryptUsername;
        qoVar.fNP.type = 2;
        com.tencent.mm.av.l.Kz().ld(qoVar.fNP.fNQ);
        com.tencent.mm.sdk.b.a.urY.m(qoVar);
        if (obj2 != null) {
            ay(xVar.field_username, com_tencent_mm_protocal_c_ame.tfW);
        }
        com.tencent.mm.plugin.label.a.a.aFG().aFA();
    }

    private static void a(ame com_tencent_mm_protocal_c_ame, String str, x xVar, boolean z) {
        String xL = m.xL();
        if (xL != null && !xL.equals(str)) {
            BizInfo hO = com.tencent.mm.modelbiz.w.DH().hO(str);
            hO.field_username = str;
            hO.field_brandList = com_tencent_mm_protocal_c_ame.hAN;
            my myVar = com_tencent_mm_protocal_c_ame.tMW;
            if (myVar != null) {
                hO.field_brandFlag = myVar.hAR;
                hO.field_brandInfo = myVar.hAT;
                hO.field_brandIconURL = myVar.hAU;
                hO.field_extInfo = myVar.hAS;
                if (z) {
                    hO.field_attrSyncVersion = null;
                    hO.field_incrementUpdateTime = 0;
                    w.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", str);
                }
                if (!bg.mA(hO.field_extInfo)) {
                    hO.bd(true);
                }
            }
            if (!(hO.bd(false) == null || hO.bd(false).De() != 3 || hO.bd(false).Di() == null || bg.mA(hO.CO()))) {
                hO.field_enterpriseFather = hO.CO();
                w.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", str, hO.field_enterpriseFather);
            }
            if (!com.tencent.mm.modelbiz.w.DH().e(hO)) {
                com.tencent.mm.modelbiz.w.DH().d(hO);
            }
            xVar.dq(hO.field_type);
        }
    }

    public static boolean a(x xVar, ame com_tencent_mm_protocal_c_ame, boolean z) {
        if (xVar == null || bg.mA(xVar.field_username)) {
            w.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
            return false;
        }
        String str = xVar.field_username;
        String str2 = xVar.field_encryptUsername;
        n.Bm().a(com.tencent.mm.x.b.a(str, com_tencent_mm_protocal_c_ame));
        bcp com_tencent_mm_protocal_c_bcp = com_tencent_mm_protocal_c_ame.tMV;
        if (!(xVar.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_bcp == null)) {
            w.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + com_tencent_mm_protocal_c_bcp.hAO + " " + com_tencent_mm_protocal_c_ame.ttp);
            w.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + com_tencent_mm_protocal_c_bcp.hAP);
            w.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bcp.hAQ);
            w.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bcp.udF);
            if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                com.tencent.mm.plugin.sns.b.m.pQB.a(xVar.field_username, com_tencent_mm_protocal_c_bcp);
            }
        }
        if (a.ez(xVar.field_type)) {
            boolean D = com.tencent.mm.av.l.Ky().D(str, 1);
            if (D) {
                w.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = " + str);
            } else {
                D = com.tencent.mm.av.l.Ky().D(str2, 1);
                w.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = " + str2);
            }
            w.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = " + D);
        }
        if (a.ez(xVar.field_type) && (xVar.getSource() == 10 || xVar.getSource() == 13)) {
            Context context = ab.getContext();
            str2 = xVar.field_username;
            String str3 = xVar.field_encryptUsername;
            if (d.bf(context)) {
                com.tencent.mm.sdk.f.e.b(new com.tencent.mm.modelsimple.b(context, d.bh(context), str2, str3), "MMAccountManager_updateSpecifiedContact").start();
            } else {
                d.A(context, null);
                w.d("MicroMsg.MMAccountManager", "no account added or not current account");
            }
            com.tencent.mm.modelfriend.b iZ = af.FY().iZ(xVar.field_encryptUsername);
            if (!(iZ == null || bg.mA(iZ.hAC))) {
                iZ.username = xVar.field_username;
                w.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr " + af.FY().a(iZ.hAC, iZ));
            }
        }
        a(com_tencent_mm_protocal_c_ame, str, xVar, z);
        return true;
    }

    private static boolean a(x xVar, bb bbVar) {
        boolean z = false;
        if (!bg.mA(bbVar.field_conDescription)) {
            xVar.cl(bbVar.field_conDescription);
        }
        if (!o.eT(xVar.field_username) && a.ez(xVar.field_type)) {
            z = true;
            if (!bg.mA(bbVar.field_conDescription)) {
                com.tencent.mm.bd.a com_tencent_mm_protocal_c_amf = new amf();
                com_tencent_mm_protocal_c_amf.tRa = xVar.field_username;
                com_tencent_mm_protocal_c_amf.msk = bbVar.field_conDescription;
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(54, com_tencent_mm_protocal_c_amf));
            }
        }
        return z;
    }

    private static void z(x xVar) {
        if (xVar != null && com.tencent.mm.modelbiz.e.ia(xVar.field_username) && !com.tencent.mm.modelbiz.e.dr(xVar.field_username)) {
            ap.yY();
            ae Rm = com.tencent.mm.u.c.wW().Rm(xVar.field_username);
            BizInfo hO = com.tencent.mm.modelbiz.w.DH().hO(xVar.field_username);
            if (com.tencent.mm.modelbiz.e.ie(hO.field_username) && Rm == null) {
                Rm = new ae(hO.field_username);
                w.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", hO.CO(), hO.field_username);
                Rm.cw(bg.mz(hO.CO()));
                Rm.bLB();
                ap.yY();
                com.tencent.mm.u.c.wW().d(Rm);
            }
        }
    }

    private static void ay(String str, int i) {
        f[] fVarArr;
        com.tencent.mm.av.h[] hVarArr;
        com.tencent.mm.pluginsdk.ui.preference.b[] a;
        com.tencent.mm.av.j[] jVarArr;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            w.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
            com.tencent.mm.av.j[] lj = com.tencent.mm.av.l.KA().lj(str);
            fVarArr = null;
            hVarArr = null;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ab.getContext(), lj);
            jVarArr = lj;
        } else if (i == 18) {
            w.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
            bz[] le = com.tencent.mm.av.l.Kz().le(str);
            fVarArr = null;
            bz[] bzVarArr = le;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ab.getContext(), le);
            jVarArr = null;
        } else {
            f[] kZ = com.tencent.mm.av.l.Kx().kZ(str);
            fVarArr = kZ;
            hVarArr = null;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ab.getContext(), kZ);
            jVarArr = null;
        }
        if (a != null) {
            int i2 = 0;
            int length = a.length;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                com.tencent.mm.pluginsdk.ui.preference.b bVar = a[i3];
                au auVar = new au();
                auVar.setContent(bVar.hku);
                int fG = o.fG(bVar.username);
                if (fVarArr != null) {
                    i4 = i2 + 1;
                    auVar.z(fVarArr[i2].field_createTime);
                } else if (hVarArr != null) {
                    i4 = i2 + 1;
                    auVar.z(hVarArr[i2].field_createtime * 1000);
                } else if (jVarArr != null) {
                    i4 = i2 + 1;
                    auVar.z(jVarArr[i2].field_createtime * 1000);
                } else {
                    i4 = i2;
                }
                auVar.cH(bVar.username);
                auVar.setType(fG);
                if (bVar.fZK) {
                    auVar.dv(2);
                    auVar.dw(1);
                } else {
                    auVar.dv(6);
                    auVar.dw(0);
                }
                ap.yY();
                long L = com.tencent.mm.u.c.wT().L(auVar);
                Assert.assertTrue(L != -1);
                w.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = " + L);
                i3++;
                i2 = i4;
            }
            au auVar2 = new au();
            if (fVarArr != null) {
                auVar2.z(fVarArr[fVarArr.length - 1].field_createTime + 1);
            } else if (hVarArr != null) {
                auVar2.z((hVarArr[hVarArr.length - 1].field_createtime * 1000) + 1);
            } else if (jVarArr != null) {
                auVar2.z((jVarArr[jVarArr.length - 1].field_createtime * 1000) + 1);
            }
            auVar2.cH(str);
            auVar2.setContent(ab.getContext().getString(R.l.eYy));
            auVar2.setType(10000);
            auVar2.dv(6);
            auVar2.dw(0);
            ap.yY();
            com.tencent.mm.u.c.wT().L(auVar2);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar.getType() != 681 || i != 0 || i2 != 0) {
            return;
        }
        if (com.tencent.mm.kernel.h.vG().gXp) {
            List<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> list = ((com.tencent.mm.ao.a) kVar).hNp;
            Set<String> hashSet = new HashSet();
            try {
                for (com.tencent.mm.plugin.messenger.foundation.a.a.e.b bVar : list) {
                    if (bVar.getCmdId() == 2) {
                        hashSet.add(com.tencent.mm.platformtools.n.a(((ame) new ame().aD(bVar.getBuffer())).ttp));
                    } else if (bVar.getCmdId() == 54) {
                        hashSet.add(((amf) new amf().aD(bVar.getBuffer())).tRa);
                    } else if (bVar.getCmdId() == 60) {
                        hashSet.add(((amr) new amr().aD(bVar.getBuffer())).tRa);
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", e, "BaseProtoBuf parseFrom error!", new Object[0]);
            }
            for (String str2 : hashSet) {
                if (!bg.mA(str2)) {
                    ag.a.hlS.a(str2, null, null);
                }
            }
            return;
        }
        w.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
    }
}
