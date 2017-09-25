package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.af;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.ash;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.protocal.c.ask;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class w extends k implements j {
    public final b gUA;
    private e gUD = null;

    public w(int i) {
        a aVar = new a();
        aVar.hsm = new aam();
        aVar.hsn = new aan();
        aVar.uri = "/cgi-bin/micromsg-bin/getqqgroup";
        aVar.hsl = 143;
        aVar.hso = 38;
        aVar.hsp = 1000000038;
        this.gUA = aVar.BE();
        aam com_tencent_mm_protocal_c_aam = (aam) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aam.mtF = 1;
        com_tencent_mm_protocal_c_aam.tGq = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        aam com_tencent_mm_protocal_c_aam = (aam) this.gUA.hsj.hsr;
        if (com_tencent_mm_protocal_c_aam.mtF != 1 || af.Gb().fI(com_tencent_mm_protocal_c_aam.tGq) != null) {
            return a(eVar, this.gUA, this);
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
        return -1;
    }

    public final int getType() {
        return 143;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            aam com_tencent_mm_protocal_c_aam = (aam) this.gUA.hsj.hsr;
            aan com_tencent_mm_protocal_c_aan = (aan) this.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_aam.mtF == 0) {
                a(com_tencent_mm_protocal_c_aan.tGr);
            } else {
                ad adVar;
                List<ad> arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                List arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < com_tencent_mm_protocal_c_aan.tGs.jNd; i4++) {
                    Object obj;
                    k kVar;
                    h hVar;
                    ash com_tencent_mm_protocal_c_ash = (ash) com_tencent_mm_protocal_c_aan.tGs.tWK.get(i4);
                    int i5 = com_tencent_mm_protocal_c_aam.tGq;
                    com.tencent.mm.sdk.platformtools.w.v("MicroMsg.NetSceneGetQQGroup", "friend");
                    ad adVar2 = new ad();
                    adVar2.hCb = new o(com_tencent_mm_protocal_c_ash.tWG).longValue();
                    com.tencent.mm.x.b.d(adVar2.hCb, 3);
                    adVar2.hCd = i5;
                    adVar2.hCc = com_tencent_mm_protocal_c_ash.tWI;
                    if (com_tencent_mm_protocal_c_ash.tWI != 0) {
                        if (com_tencent_mm_protocal_c_ash.jNj == null || com_tencent_mm_protocal_c_ash.jNj.equals("")) {
                            obj = null;
                            arrayList.add(obj);
                            kVar = new k();
                            kVar.gkr = com_tencent_mm_protocal_c_ash.hAD;
                            kVar.gkA = com_tencent_mm_protocal_c_ash.hAH;
                            kVar.gkB = com_tencent_mm_protocal_c_ash.hAE;
                            kVar.gkC = com_tencent_mm_protocal_c_ash.hAF;
                            kVar.signature = com_tencent_mm_protocal_c_ash.hAG;
                            kVar.username = com_tencent_mm_protocal_c_ash.jNj;
                            arrayList2.add(kVar);
                            hVar = new h();
                            hVar.gkq = 3;
                            hVar.aV(true);
                            hVar.username = com_tencent_mm_protocal_c_ash.jNj;
                            hVar.hrB = com_tencent_mm_protocal_c_ash.tqb;
                            hVar.hrA = com_tencent_mm_protocal_c_ash.tqc;
                            arrayList3.add(hVar);
                        } else {
                            ap.yY();
                            af Rc = c.wR().Rc(com_tencent_mm_protocal_c_ash.jNj);
                            if (Rc != null && Rc.field_username.equals(com_tencent_mm_protocal_c_ash.jNj) && com.tencent.mm.j.a.ez(Rc.field_type)) {
                                adVar2.hCc = 2;
                            } else {
                                adVar2.hCc = 1;
                            }
                        }
                    }
                    adVar2.username = com_tencent_mm_protocal_c_ash.jNj;
                    adVar2.fFa = com_tencent_mm_protocal_c_ash.jOp;
                    adVar2.hCj = com_tencent_mm_protocal_c_ash.tWJ;
                    adVar2.hCk = com.tencent.mm.platformtools.c.mq(com_tencent_mm_protocal_c_ash.tWJ);
                    adVar2.hCl = com.tencent.mm.platformtools.c.mp(com_tencent_mm_protocal_c_ash.tWJ);
                    adVar2.hCe = com.tencent.mm.platformtools.c.mq(com_tencent_mm_protocal_c_ash.jOp);
                    adVar2.hCf = com.tencent.mm.platformtools.c.mp(com_tencent_mm_protocal_c_ash.jOp);
                    adVar2.hCg = com_tencent_mm_protocal_c_ash.tWH;
                    adVar2.hCh = com.tencent.mm.platformtools.c.mq(com_tencent_mm_protocal_c_ash.tWH);
                    adVar2.hCi = com.tencent.mm.platformtools.c.mp(com_tencent_mm_protocal_c_ash.tWH);
                    i5 = 32;
                    if (!bg.mA(adVar2.FU())) {
                        i5 = adVar2.FU().charAt(0);
                    } else if (!bg.mA(adVar2.FV())) {
                        i5 = adVar2.FV().charAt(0);
                    } else if (!bg.mA(adVar2.FR())) {
                        i5 = adVar2.FR().charAt(0);
                    } else if (!bg.mA(adVar2.FS())) {
                        i5 = adVar2.FS().charAt(0);
                    }
                    if (i5 >= 97 && i5 <= 122) {
                        i5 = (char) (i5 - 32);
                    } else if (i5 < 65 || i5 > 90) {
                        i5 = 123;
                    }
                    adVar2.hrx = i5;
                    ap.yY();
                    c.xB().eI(com_tencent_mm_protocal_c_ash.jNj, com_tencent_mm_protocal_c_ash.tBM);
                    com.tencent.mm.sdk.platformtools.w.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + adVar2.FQ() + "  remark: " + adVar2.FT());
                    ad adVar3 = adVar2;
                    arrayList.add(obj);
                    kVar = new k();
                    kVar.gkr = com_tencent_mm_protocal_c_ash.hAD;
                    kVar.gkA = com_tencent_mm_protocal_c_ash.hAH;
                    kVar.gkB = com_tencent_mm_protocal_c_ash.hAE;
                    kVar.gkC = com_tencent_mm_protocal_c_ash.hAF;
                    kVar.signature = com_tencent_mm_protocal_c_ash.hAG;
                    kVar.username = com_tencent_mm_protocal_c_ash.jNj;
                    arrayList2.add(kVar);
                    hVar = new h();
                    hVar.gkq = 3;
                    hVar.aV(true);
                    hVar.username = com_tencent_mm_protocal_c_ash.jNj;
                    hVar.hrB = com_tencent_mm_protocal_c_ash.tqb;
                    hVar.hrA = com_tencent_mm_protocal_c_ash.tqc;
                    arrayList3.add(hVar);
                }
                HashMap hashMap = new HashMap();
                ae Gd = af.Gd();
                int i6 = com_tencent_mm_protocal_c_aam.tGq;
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i6);
                Cursor a = Gd.hnH.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i6 + "\"", null, 0);
                while (a.moveToNext()) {
                    adVar = new ad();
                    adVar.b(a);
                    hashMap.put(Long.valueOf(adVar.hCb), adVar);
                }
                a.close();
                for (ad adVar4 : arrayList) {
                    if (hashMap.containsKey(Long.valueOf(adVar4.hCb))) {
                        adVar = (ad) hashMap.get(Long.valueOf(adVar4.hCb));
                        Object obj2 = !bg.r(Long.valueOf(adVar.hCb), Long.valueOf(adVar4.hCb)) ? null : !bg.r(Integer.valueOf(adVar.hCc), Integer.valueOf(adVar4.hCc)) ? null : !bg.r(Integer.valueOf(adVar.hCd), Integer.valueOf(adVar4.hCd)) ? null : !bg.r(adVar.username, adVar4.username) ? null : !bg.r(adVar.fFa, adVar4.fFa) ? null : !bg.r(adVar.hCe, adVar4.hCe) ? null : !bg.r(adVar.hCf, adVar4.hCf) ? null : !bg.r(adVar.hCg, adVar4.hCg) ? null : !bg.r(adVar.hCh, adVar4.hCh) ? null : !bg.r(adVar.hCi, adVar4.hCi) ? null : !bg.r(adVar.hCj, adVar4.hCj) ? null : !bg.r(adVar.hCk, adVar4.hCk) ? null : !bg.r(adVar.hCl, adVar4.hCl) ? null : !bg.r(adVar.hrv, adVar4.hrv) ? null : !bg.r(adVar.hrw, adVar4.hrw) ? null : !bg.r(Integer.valueOf(adVar.hrx), Integer.valueOf(adVar4.hrx)) ? null : !bg.r(Integer.valueOf(adVar.hry), Integer.valueOf(adVar4.hry)) ? null : 1;
                        if (obj2 == null) {
                            af.Gd().a(adVar4.hCb, adVar4);
                            hashMap.remove(Long.valueOf(adVar4.hCb));
                        }
                    } else {
                        af.Gd().a(adVar4);
                    }
                }
                for (Long longValue : hashMap.keySet()) {
                    long longValue2 = longValue.longValue();
                    m Gd2 = af.Gd();
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.QQListStorage", "delete: QQ:" + longValue2);
                    if (Gd2.hnH.delete("qqlist", "qq= ?", new String[]{String.valueOf(longValue2)}) > 0) {
                        Gd2.b(5, Gd2, String.valueOf(longValue2));
                    }
                }
                af.Ga().z(arrayList2);
                n.Bm().z(arrayList3);
                ab abVar = new ab();
                abVar.hBT = com_tencent_mm_protocal_c_aam.tGq;
                abVar.hBY = 0;
                abVar.hBX = (int) bg.Ny();
                abVar.fRW = 48;
                af.Gb().a(abVar);
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }

    private static void a(ask com_tencent_mm_protocal_c_ask) {
        Map map;
        ab abVar;
        Cursor a = af.Gb().hnH.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
        if (a == null) {
            map = null;
        } else if (a.getCount() <= 0) {
            a.close();
            map = null;
        } else {
            map = new HashMap();
            for (int i = 0; i < a.getCount(); i++) {
                a.moveToPosition(i);
                ab abVar2 = new ab();
                abVar2.b(a);
                map.put(Integer.valueOf(abVar2.hBT), abVar2);
            }
            a.close();
        }
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_ask.jNd; i2++) {
            asj com_tencent_mm_protocal_c_asj = (asj) com_tencent_mm_protocal_c_ask.tWM.get(i2);
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetQQGroup", "id:" + com_tencent_mm_protocal_c_asj.tGq + " name:" + com_tencent_mm_protocal_c_asj.tAB + " mem:" + com_tencent_mm_protocal_c_asj.tvO + " wei:" + com_tencent_mm_protocal_c_asj.tWL + " md5:" + com_tencent_mm_protocal_c_asj.tuy);
            if (com_tencent_mm_protocal_c_asj.tGq < 0) {
                abVar2 = null;
            } else {
                abVar2 = new ab();
                abVar2.hBT = com_tencent_mm_protocal_c_asj.tGq;
                abVar2.hCa = com_tencent_mm_protocal_c_asj.tAB;
                abVar2.hBU = com_tencent_mm_protocal_c_asj.tvO;
                abVar2.hBV = com_tencent_mm_protocal_c_asj.tWL;
                abVar2.hBZ = com_tencent_mm_protocal_c_asj.tuy;
            }
            if (abVar2 == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:" + i2);
            } else if (abVar2.hBU != 0) {
                if (map != null) {
                    abVar = (ab) map.get(Integer.valueOf(abVar2.hBT));
                } else {
                    abVar = null;
                }
                if (abVar == null) {
                    boolean z;
                    abVar2.hBW = (int) bg.Ny();
                    abVar2.hBX = (int) bg.Ny();
                    abVar2.hBY = 1;
                    ac Gb = af.Gb();
                    if (abVar2 != null) {
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.QQGroupStorage", "insert: name:" + abVar2.FN());
                        abVar2.fRW = -1;
                        if (((int) Gb.hnH.insert("qqgroup", "grouopid", abVar2.FL())) >= 0) {
                            Gb.doNotify();
                            z = true;
                            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + abVar2.FN() + " ret:" + z);
                        }
                    }
                    z = false;
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + abVar2.FN() + " ret:" + z);
                } else {
                    abVar.hBY = -1;
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetQQGroup", abVar2.FM() + " " + abVar.FM() + " " + abVar2.hBT);
                    if (!abVar.FM().equals(abVar2.FM())) {
                        abVar2.hBX = (int) bg.Ny();
                        abVar2.hBY = 1;
                        abVar2.fRW = -1;
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + abVar2.FN() + " ret:" + af.Gb().a(abVar2));
                    }
                }
            }
        }
        if (map != null) {
            for (Object obj : map.keySet()) {
                abVar = (ab) map.get(obj);
                if (abVar.hBY == 0) {
                    boolean z2;
                    ac Gb2 = af.Gb();
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.QQGroupStorage", "delete: id:" + abVar.hBT);
                    if (Gb2.hnH.delete("qqgroup", "grouopid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        Gb2.doNotify();
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + abVar.FN() + " ret:" + z2);
                    ae Gd = af.Gd();
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.QQListStorage", "delete: GroupID:" + abVar.hBT);
                    if (Gd.hnH.delete("qqlist", "groupid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + abVar.FN() + " ret:" + z2);
                }
            }
        }
    }
}
