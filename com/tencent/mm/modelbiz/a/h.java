package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.g;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.protocal.c.bgh;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.protocal.c.bgj;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.protocal.c.mo;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.mt;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.ye;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h implements e {
    private HashSet<a> hxf = new HashSet();
    private HashSet<a> hxg = new HashSet();
    private final Object hxh = new Object();
    private f<String, Long> hxi = new f(64);
    private HashSet<a> hxj = new HashSet();
    private HashSet<a> hxk = new HashSet();
    private final Object hxl = new Object();
    private f<String, Long> hxm = new f(64);

    public static class a {
        public String fQl;
        public String id;

        public a(String str, String str2) {
            this.fQl = str;
            this.id = str2;
        }

        public boolean equals(Object obj) {
            if (obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if ((this.fQl != null || aVar.fQl != null) && (this.fQl == null || !this.fQl.equals(aVar.fQl))) {
                return false;
            }
            if ((this.id != null || aVar.id != null) && (this.id == null || !this.id.equals(aVar.id))) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.fQl.hashCode() + this.id.hashCode();
        }
    }

    public h() {
        com.tencent.mm.kernel.h.vH().gXC.a(1352, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1365, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1353, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1354, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1357, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1356, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1355, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1358, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1367, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1361, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1389, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.a(1315, (e) this);
    }

    protected final void finalize() {
        com.tencent.mm.kernel.h.vH().gXC.b(1352, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1365, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1353, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1354, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1357, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1356, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1355, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1358, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1367, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1361, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1389, (e) this);
        com.tencent.mm.kernel.h.vH().gXC.b(1315, (e) this);
        super.finalize();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(i == 0 && i2 == 0)) {
            w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
            if (!(kVar.getType() == 1365 || kVar.getType() == 1353)) {
                return;
            }
        }
        int i3;
        boolean a;
        int i4;
        m mVar;
        String str2;
        String str3;
        switch (kVar.getType()) {
            case 1315:
                kVar = (m) kVar;
                mo Ea = kVar.Ea();
                i3 = 0;
                if (Ea == null || Ea.tkR == null || Ea.tkR.ret != 0) {
                    if (Ea == null || Ea.tkR == null) {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(Ea.tkR.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && Ea.tsX == null && Ea.tsW == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (Ea.tsX != null) {
                        a = a(Ea.tsX, Ea.tkL);
                        if (a) {
                            kVar.hxu = Ea.tsX.tkM;
                        }
                    } else {
                        a = a(Ea.tsW, Ea.tkL, true);
                        if (a) {
                            kVar.hxu = Ea.tsW.tAE.tkF;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        mVar = (m) kVar.data;
                        if (mVar != null) {
                            mVar.a(i4, kVar);
                            return;
                        }
                        return;
                    }
                }
                i4 = i3;
                mVar = (m) kVar.data;
                if (mVar != null) {
                    mVar.a(i4, kVar);
                    return;
                }
                return;
            case 1352:
                o oVar = (o) kVar;
                vf vfVar = (oVar.gUA == null || oVar.gUA.hsk.hsr == null) ? null : (vf) oVar.gUA.hsk.hsr;
                ve veVar = (oVar.gUA == null || oVar.gUA.hsj.hsr == null) ? null : (ve) oVar.gUA.hsj.hsr;
                boolean z = oVar.hxv;
                if (vfVar != null && vfVar.tkR != null && vfVar.tkR.ret == 0) {
                    a(vfVar.ttc, veVar.tkL, z);
                    return;
                } else if (vfVar == null || vfVar.tkR == null) {
                    w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(vfVar.tkR.ret));
                    return;
                }
            case 1353:
                kVar = (r) kVar;
                mVar = (m) kVar.data;
                if (mVar == null) {
                    synchronized (this.hxl) {
                        this.hxk.clear();
                    }
                    DZ();
                }
                if (i == 0 && i2 == 0) {
                    int i5;
                    vj vjVar = (kVar.gUA == null || kVar.gUA.hsk.hsr == null) ? null : (vj) kVar.gUA.hsk.hsr;
                    i4 = 0;
                    if (vjVar == null || vjVar.tkR == null || vjVar.tkR.ret != 0) {
                        if (vjVar == null || vjVar.tkR == null) {
                            w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(vjVar.tkR.ret));
                        }
                        i4 = -1;
                    }
                    if (i4 < 0 || vjVar.tkS != null) {
                        i5 = i4;
                    } else {
                        w.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
                        i5 = -1;
                    }
                    if (i5 >= 0) {
                        com.tencent.mm.sdk.e.e eVar = com.tencent.mm.modelbiz.w.DL().gUz;
                        long j = 0;
                        if (eVar instanceof g) {
                            j = ((g) eVar).cs(Thread.currentThread().getId());
                        }
                        for (int i6 = 0; i6 < vjVar.tkS.size(); i6++) {
                            w.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", ((gx) vjVar.tkS.get(i6)).khr);
                            j jVar = new j();
                            jVar.field_userId = ((gx) vjVar.tkS.get(i6)).tkM;
                            jVar.field_userName = ((gx) vjVar.tkS.get(i6)).khr;
                            str2 = jVar.field_userId;
                            str2 = (str2 == null || kVar.hxx == null) ? null : (String) kVar.hxx.get(str2);
                            jVar.field_brandUserName = str2;
                            jVar.field_UserVersion = ((gx) vjVar.tkS.get(i6)).ver;
                            jVar.field_headImageUrl = ((gx) vjVar.tkS.get(i6)).tkG;
                            jVar.field_profileUrl = ((gx) vjVar.tkS.get(i6)).tkU;
                            jVar.field_bitFlag = ((gx) vjVar.tkS.get(i6)).tkH;
                            jVar.field_addMemberUrl = ((gx) vjVar.tkS.get(i6)).tkK;
                            jVar.field_needToUpdate = false;
                            j iD = com.tencent.mm.modelbiz.w.DL().iD(((gx) vjVar.tkS.get(i6)).tkM);
                            a = iD == null ? false : iD.fu(16);
                            boolean fu = jVar.fu(16);
                            if (iD == null) {
                                com.tencent.mm.modelbiz.w.DL().a(jVar);
                            } else {
                                com.tencent.mm.modelbiz.w.DL().b(jVar);
                            }
                            if (a != fu) {
                                c iq = com.tencent.mm.modelbiz.w.DJ().iq(jVar.field_userId);
                                if (iq != null) {
                                    if (a && !fu) {
                                        com.tencent.mm.modelbiz.w.DK().Z(iq.field_bizChatLocalId);
                                    } else if (!a && fu) {
                                        com.tencent.mm.modelbiz.w.DK().Y(iq.field_bizChatLocalId);
                                    }
                                }
                            }
                        }
                        if (eVar instanceof g) {
                            com.tencent.mm.kernel.h.vI().gYg.aD(j);
                        }
                    }
                    if (mVar != null) {
                        mVar.a(i5, kVar);
                        return;
                    }
                    return;
                }
                return;
            case 1354:
                int i7;
                kVar = (q) kVar;
                vh vhVar = (kVar.gUA == null || kVar.gUA.hsk.hsr == null) ? null : (vh) kVar.gUA.hsk.hsr;
                vg vgVar = kVar.gUA == null ? null : (vg) kVar.gUA.hsj.hsr;
                if (vhVar == null || vhVar.tkR == null || vhVar.tkR.ret != 0) {
                    if (vhVar == null || vhVar.tkR == null) {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(vhVar.tkR.ret));
                    }
                    i7 = -1;
                } else {
                    i7 = 0;
                }
                if (i7 >= 0) {
                    k DL = com.tencent.mm.modelbiz.w.DL();
                    String str4 = vgVar.tkL;
                    gx gxVar = vhVar.tkO;
                    if (gxVar == null || bg.mA(str4)) {
                        w.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
                    } else {
                        w.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", str4, gxVar.tkM, Boolean.valueOf(bg.mA(gxVar.tkK)));
                        f iB = com.tencent.mm.modelbiz.w.DM().iB(str4);
                        if (iB == null) {
                            iB = new f();
                            iB.field_brandUserName = str4;
                            iB.field_userId = gxVar.tkM;
                            com.tencent.mm.modelbiz.w.DM().a(iB);
                        } else {
                            iB.field_userId = gxVar.tkM;
                            com.tencent.mm.modelbiz.w.DM().b(iB);
                            w.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
                        }
                        j jVar2 = new j();
                        jVar2.field_userId = gxVar.tkM;
                        jVar2.field_userName = gxVar.khr;
                        jVar2.field_brandUserName = str4;
                        jVar2.field_UserVersion = gxVar.ver;
                        jVar2.field_headImageUrl = gxVar.tkG;
                        jVar2.field_profileUrl = gxVar.tkU;
                        jVar2.field_bitFlag = gxVar.tkH;
                        jVar2.field_needToUpdate = false;
                        jVar2.field_addMemberUrl = gxVar.tkK;
                        if (!DL.b(jVar2)) {
                            DL.a(jVar2);
                        }
                        DL.hwI.put(str4, jVar2.field_userId);
                    }
                }
                mVar = (m) kVar.data;
                if (mVar != null) {
                    mVar.a(i7, kVar);
                    return;
                }
                return;
            case 1355:
                kVar = (n) kVar;
                mt Eb = kVar.Eb();
                ms Ec = kVar.Ec();
                i3 = 0;
                if (Eb == null || Eb.tkR == null || Eb.tkR.ret != 0) {
                    if (Eb == null || Eb.tkR == null) {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(Eb.tkR.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    i4 = a(Eb.ttc, Ec.tkL, true) ? 0 : -1;
                } else {
                    i4 = i3;
                }
                mVar = (m) kVar.data;
                if (mVar != null) {
                    mVar.a(i4, kVar);
                    return;
                }
                return;
            case 1356:
                kVar = (w) kVar;
                bgj com_tencent_mm_protocal_c_bgj = (kVar.gUA == null || kVar.gUA.hsk.hsr == null) ? null : (bgj) kVar.gUA.hsk.hsr;
                bgi com_tencent_mm_protocal_c_bgi = (kVar.gUA == null || kVar.gUA.hsj.hsr == null) ? null : (bgi) kVar.gUA.hsj.hsr;
                i3 = 0;
                if (com_tencent_mm_protocal_c_bgj == null || com_tencent_mm_protocal_c_bgj.tkR == null || com_tencent_mm_protocal_c_bgj.tkR.ret != 0 || com_tencent_mm_protocal_c_bgj.tAE == null) {
                    if (com_tencent_mm_protocal_c_bgj == null || com_tencent_mm_protocal_c_bgj.tkR == null) {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(com_tencent_mm_protocal_c_bgj.tkR.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    c iq2 = com.tencent.mm.modelbiz.w.DJ().iq(com_tencent_mm_protocal_c_bgj.tAE.tkF);
                    if (iq2 == null) {
                        str3 = "MicroMsg.BizChatNetworkMgr";
                        String str5 = "bizChatInfo == null:%s, resp.chat == null:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(iq2 == null);
                        objArr[1] = Boolean.valueOf(com_tencent_mm_protocal_c_bgj.tAE == null);
                        w.w(str3, str5, objArr);
                        i3 = -1;
                    }
                    if (i3 < 0 || ((iq2.field_bitFlag == com_tencent_mm_protocal_c_bgj.tAE.tkH || !iq2.DW()) && com_tencent_mm_protocal_c_bgj.tAE.ver <= iq2.field_chatVersion)) {
                        i4 = -1;
                    } else {
                        iq2.field_chatType = com_tencent_mm_protocal_c_bgj.tAE.type;
                        iq2.field_headImageUrl = com_tencent_mm_protocal_c_bgj.tAE.tkG;
                        iq2.field_chatName = com_tencent_mm_protocal_c_bgj.tAE.name;
                        iq2.field_chatVersion = com_tencent_mm_protocal_c_bgj.tAE.ver;
                        iq2.field_needToUpdate = false;
                        iq2.field_bitFlag = com_tencent_mm_protocal_c_bgj.tAE.tkH;
                        iq2.field_maxMemberCnt = com_tencent_mm_protocal_c_bgj.tAE.tkI;
                        iq2.field_ownerUserId = com_tencent_mm_protocal_c_bgj.tAE.tkJ;
                        iq2.field_addMemberUrl = com_tencent_mm_protocal_c_bgj.tAE.tkK;
                        iq2.field_brandUserName = com_tencent_mm_protocal_c_bgi.tkL;
                        com.tencent.mm.modelbiz.w.DJ().b(iq2);
                        i4 = i3;
                    }
                } else {
                    i4 = i3;
                }
                mVar = (m) kVar.data;
                if (mVar != null) {
                    mVar.a(i4, kVar);
                    return;
                }
                return;
            case 1357:
                w.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
                kVar = (x) kVar;
                bgh com_tencent_mm_protocal_c_bgh = (kVar.gUA == null || kVar.gUA.hsk.hsr == null) ? null : (bgh) kVar.gUA.hsk.hsr;
                bgg com_tencent_mm_protocal_c_bgg = (kVar.gUA == null || kVar.gUA.hsj.hsr == null) ? null : (bgg) kVar.gUA.hsj.hsr;
                if (com_tencent_mm_protocal_c_bgh != null && com_tencent_mm_protocal_c_bgh.tkR != null && com_tencent_mm_protocal_c_bgh.tkR.ret == 0) {
                    i4 = a(com_tencent_mm_protocal_c_bgh.ttc, com_tencent_mm_protocal_c_bgg.tkL, false) ? 0 : -1;
                    mVar = (m) kVar.data;
                    if (mVar != null) {
                        mVar.a(i4, kVar);
                        return;
                    }
                    return;
                } else if (com_tencent_mm_protocal_c_bgh == null || com_tencent_mm_protocal_c_bgh.tkR == null) {
                    w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(com_tencent_mm_protocal_c_bgh.tkR.ret));
                    return;
                }
            case 1358:
                return;
            case 1365:
                synchronized (this.hxh) {
                    this.hxg.clear();
                }
                DY();
                if (i == 0 && i2 == 0) {
                    p pVar = (p) kVar;
                    vd vdVar = (pVar.gUA == null || pVar.gUA.hsk.hsr == null) ? null : (vd) pVar.gUA.hsk.hsr;
                    if (vdVar != null && vdVar.tkR != null && vdVar.tkR.ret == 0) {
                        LinkedList linkedList = vdVar.tCK;
                        if (linkedList == null || linkedList.size() == 0) {
                            w.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
                            return;
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ss ssVar = (ss) it.next();
                            str2 = ssVar.tAE.tkF;
                            str2 = (str2 == null || pVar.hxw == null) ? null : (String) pVar.hxw.get(str2);
                            a(ssVar, str2, false);
                        }
                        return;
                    } else if (vdVar == null || vdVar.tkR == null) {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        return;
                    } else {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(vdVar.tkR.ret));
                        return;
                    }
                }
                return;
            case 1367:
                s sVar = (s) kVar;
                ye yeVar = (sVar.gUA == null || sVar.gUA.hsk.hsr == null) ? null : (ye) sVar.gUA.hsk.hsr;
                yd ydVar = (sVar.gUA == null || sVar.gUA.hsj.hsr == null) ? null : (yd) sVar.gUA.hsj.hsr;
                if (yeVar != null && yeVar.tkR != null && yeVar.tkR.ret == 0) {
                    List<String> list = yeVar.tEG;
                    d DJ = com.tencent.mm.modelbiz.w.DJ();
                    str3 = ydVar.tkL;
                    List<String> arrayList = new ArrayList();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select bizChatServId from BizChatInfo");
                    stringBuilder.append(" where brandUserName = '").append(str3).append("'");
                    stringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
                    Cursor rawQuery = DJ.rawQuery(stringBuilder.toString(), new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            do {
                                arrayList.add(rawQuery.getString(0));
                            } while (rawQuery.moveToNext());
                        }
                        rawQuery.close();
                    }
                    for (String str6 : arrayList) {
                        if (!list.contains(str6)) {
                            c iq3 = com.tencent.mm.modelbiz.w.DJ().iq(str6);
                            if (iq3 != null) {
                                iq3.field_bitFlag &= -9;
                                com.tencent.mm.modelbiz.w.DJ().b(iq3);
                            }
                        }
                    }
                    for (String str62 : list) {
                        if (!arrayList.contains(str62)) {
                            c iq4 = com.tencent.mm.modelbiz.w.DJ().iq(str62);
                            if (iq4 == null) {
                                iq4 = new c();
                                iq4.field_bizChatServId = str62;
                                iq4.field_brandUserName = ydVar.tkL;
                                iq4.field_bitFlag |= 8;
                                com.tencent.mm.modelbiz.w.DJ().a(iq4);
                            } else {
                                iq4.field_bitFlag |= 8;
                                com.tencent.mm.modelbiz.w.DJ().b(iq4);
                            }
                        }
                    }
                    a(yeVar.tEG, ydVar.tkL);
                    return;
                } else if (yeVar == null || yeVar.tkR == null) {
                    w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(yeVar.tkR.ret));
                    return;
                }
            case 1389:
                kVar = (t) kVar;
                aga Ed = kVar.Ed();
                i3 = 0;
                if (Ed == null || Ed.tkR == null || Ed.tkR.ret != 0) {
                    if (Ed == null || Ed.tkR == null) {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        w.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(Ed.tkR.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && Ed.tsX == null && Ed.tsW == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (Ed.tsX != null) {
                        a = a(Ed.tsX, Ed.tkL);
                        if (a) {
                            kVar.hxu = Ed.tsX.tkM;
                        }
                    } else {
                        a = a(Ed.tsW, Ed.tkL, true);
                        if (a) {
                            kVar.hxu = Ed.tsW.tAE.tkF;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        mVar = (m) kVar.data;
                        if (mVar != null) {
                            mVar.a(i4, kVar);
                            return;
                        }
                        return;
                    }
                }
                i4 = i3;
                mVar = (m) kVar.data;
                if (mVar != null) {
                    mVar.a(i4, kVar);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void f(k kVar) {
        com.tencent.mm.kernel.h.vH().gXC.c(kVar);
    }

    public final void W(String str, String str2) {
        Long l = (Long) this.hxi.get(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.hxh) {
                a aVar = new a(str2, str);
                if (this.hxg.contains(aVar)) {
                    return;
                }
                this.hxf.add(aVar);
                this.hxi.put(str, new Long(currentTimeMillis));
                DY();
            }
        }
    }

    public final void a(LinkedList<String> linkedList, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hxh) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                a aVar = new a(str, str2);
                if (!this.hxg.contains(aVar)) {
                    this.hxf.add(aVar);
                    this.hxi.put(str2, new Long(currentTimeMillis));
                }
            }
            DY();
        }
    }

    private void DY() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.hxh) {
            if (!this.hxg.isEmpty()) {
            } else if (this.hxf.isEmpty()) {
            } else {
                Iterator it = this.hxf.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    gr grVar = new gr();
                    grVar.tkL = aVar.fQl;
                    grVar.tkF = aVar.id;
                    linkedList.add(grVar);
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                this.hxg.addAll(this.hxf);
                this.hxf.clear();
                com.tencent.mm.kernel.h.vH().gXC.a(new p(linkedList), 0);
            }
        }
    }

    public final void X(String str, String str2) {
        Long l = (Long) this.hxm.get(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            Y(str, str2);
        }
    }

    public final void Y(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hxl) {
            a aVar = new a(str2, str);
            if (this.hxk.contains(aVar)) {
                return;
            }
            this.hxj.add(aVar);
            this.hxm.put(str, new Long(currentTimeMillis));
            DZ();
        }
    }

    public final void b(LinkedList<String> linkedList, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hxl) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                a aVar = new a(str, str2);
                if (this.hxk.contains(aVar)) {
                    return;
                } else {
                    this.hxj.add(aVar);
                    this.hxm.put(str2, new Long(currentTimeMillis));
                }
            }
            DZ();
        }
    }

    private void DZ() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.hxl) {
            if (!this.hxk.isEmpty()) {
            } else if (this.hxj.isEmpty()) {
            } else {
                LinkedList linkedList2;
                HashMap hashMap = new HashMap();
                Iterator it = this.hxj.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    linkedList2 = (LinkedList) hashMap.get(aVar.fQl);
                    if (linkedList2 == null) {
                        linkedList2 = new LinkedList();
                        hashMap.put(aVar.fQl, linkedList2);
                    }
                    linkedList2.add(aVar.id);
                }
                for (String str : hashMap.keySet()) {
                    linkedList2 = (LinkedList) hashMap.get(str);
                    if (!(linkedList2 == null || linkedList2.isEmpty())) {
                        hp hpVar = new hp();
                        hpVar.tkL = str;
                        hpVar.tlL = linkedList2;
                        linkedList.add(hpVar);
                    }
                }
                this.hxk.addAll(this.hxj);
                this.hxj.clear();
                com.tencent.mm.kernel.h.vH().gXC.a(new r(linkedList, null), 0);
            }
        }
    }

    public static void Z(String str, String str2) {
        com.tencent.mm.kernel.h.vH().gXC.a(new o(str, str2), 0);
    }

    public static void a(String str, String str2, m mVar) {
        if (mVar != null) {
            j iv = e.iv(str2);
            if (iv == null || iv.field_userId.equals(str)) {
                a(str2, mVar);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            hp hpVar = new hp();
            hpVar.tkL = str2;
            hpVar.tlL = linkedList;
            linkedList = new LinkedList();
            linkedList.add(hpVar);
            com.tencent.mm.kernel.h.vH().gXC.a(new r(linkedList, mVar), 0);
        }
    }

    public static void a(String str, m mVar) {
        com.tencent.mm.kernel.h.vH().gXC.a(new q(str, mVar), 0);
    }

    public static n a(String str, ss ssVar, m mVar) {
        k nVar = new n(str, ssVar, mVar);
        com.tencent.mm.kernel.h.vH().gXC.a(nVar, 0);
        return nVar;
    }

    public static x a(String str, String str2, gt gtVar, gt gtVar2, m mVar) {
        k xVar = new x(str, str2, gtVar, gtVar2, mVar);
        com.tencent.mm.kernel.h.vH().gXC.a(xVar, 0);
        return xVar;
    }

    public static w a(String str, gq gqVar, m mVar) {
        k wVar = new w(str, gqVar, mVar);
        com.tencent.mm.kernel.h.vH().gXC.a(wVar, 0);
        return wVar;
    }

    private static boolean a(gx gxVar, String str) {
        if (bg.mA(str) || bg.mA(gxVar.tkM)) {
            return false;
        }
        j jVar = new j();
        jVar.field_userId = gxVar.tkM;
        jVar.field_userName = gxVar.khr;
        jVar.field_brandUserName = str;
        jVar.field_headImageUrl = gxVar.tkG;
        jVar.field_profileUrl = gxVar.tkU;
        jVar.field_UserVersion = gxVar.ver;
        jVar.field_addMemberUrl = gxVar.tkK;
        if (!com.tencent.mm.modelbiz.w.DL().b(jVar)) {
            com.tencent.mm.modelbiz.w.DL().a(jVar);
        }
        c cVar = new c();
        cVar.field_bizChatServId = jVar.field_userId;
        cVar.field_brandUserName = jVar.field_brandUserName;
        cVar.field_chatName = jVar.field_userName;
        cVar.field_chatType = 1;
        if (e.e(cVar) != null) {
            return true;
        }
        return false;
    }

    private static boolean a(ss ssVar, String str, boolean z) {
        w.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
        if (ssVar == null || ssVar.tAE == null || bg.mA(str)) {
            w.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
            return false;
        }
        boolean z2;
        c cVar;
        c iq = com.tencent.mm.modelbiz.w.DJ().iq(ssVar.tAE.tkF);
        if (iq == null) {
            w.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
            iq = new c();
            iq.field_bizChatServId = ssVar.tAE.tkF;
            iq.field_brandUserName = str;
            z2 = true;
            cVar = iq;
            z = true;
        } else {
            z2 = false;
            cVar = iq;
        }
        if (ssVar.tkN == null) {
            w.w("MicroMsg.BizChatNetworkMgr", "members==null");
            return false;
        }
        Iterator it;
        if (cVar.DW() || ssVar.tAE.ver > cVar.field_chatVersion) {
            cVar.field_chatType = ssVar.tAE.type;
            cVar.field_headImageUrl = ssVar.tAE.tkG;
            cVar.field_chatName = ssVar.tAE.name;
            cVar.field_chatVersion = ssVar.tAE.ver;
            cVar.field_needToUpdate = false;
            cVar.field_bitFlag = ssVar.tAE.tkH;
            cVar.field_maxMemberCnt = ssVar.tAE.tkI;
            cVar.field_ownerUserId = ssVar.tAE.tkJ;
            cVar.field_addMemberUrl = ssVar.tAE.tkK;
            cVar.field_brandUserName = str;
            List linkedList = new LinkedList();
            it = ssVar.tkN.iterator();
            while (it.hasNext()) {
                linkedList.add(((gs) it.next()).tkM);
            }
            cVar.field_userList = bg.c(linkedList, ";");
            if (z2) {
                com.tencent.mm.modelbiz.w.DJ().a(cVar);
            } else {
                com.tencent.mm.modelbiz.w.DJ().b(cVar);
            }
        }
        e.h(cVar);
        gs gsVar;
        if (z) {
            hp hpVar = new hp();
            hpVar.tkL = cVar.field_brandUserName;
            LinkedList linkedList2 = new LinkedList();
            it = ssVar.tkN.iterator();
            while (it.hasNext()) {
                int i;
                gsVar = (gs) it.next();
                k DL = com.tencent.mm.modelbiz.w.DL();
                String str2 = gsVar.tkM;
                if (bg.mA(str2)) {
                    w.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
                    i = -1;
                } else {
                    j iD = DL.iD(str2);
                    if (iD != null) {
                        i = iD.field_UserVersion;
                    } else {
                        w.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
                        i = -1;
                    }
                }
                if (((long) gsVar.ver) > ((long) i)) {
                    linkedList2.add(gsVar.tkM);
                }
            }
            if (linkedList2.size() > 0) {
                hpVar.tlL = linkedList2;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(hpVar);
                com.tencent.mm.kernel.h.vH().gXC.a(new r(linkedList3, null), 0);
            }
        } else {
            com.tencent.mm.sdk.e.e eVar = com.tencent.mm.modelbiz.w.DL().gUz;
            long j = 0;
            if (eVar instanceof g) {
                j = ((g) eVar).cs(Thread.currentThread().getId());
            }
            Iterator it2 = ssVar.tkN.iterator();
            while (it2.hasNext()) {
                gsVar = (gs) it2.next();
                j iD2 = com.tencent.mm.modelbiz.w.DL().iD(gsVar.tkM);
                if (iD2 == null) {
                    iD2 = new j();
                    iD2.field_userId = gsVar.tkM;
                    iD2.field_userName = gsVar.khr;
                    iD2.field_brandUserName = cVar.field_brandUserName;
                    iD2.field_needToUpdate = true;
                    com.tencent.mm.modelbiz.w.DL().a(iD2);
                } else if (gsVar.ver > iD2.field_UserVersion) {
                    iD2.field_needToUpdate = true;
                    com.tencent.mm.modelbiz.w.DL().b(iD2);
                }
            }
            if (eVar instanceof g) {
                com.tencent.mm.kernel.h.vI().gYg.aD(j);
            }
        }
        return true;
    }
}
