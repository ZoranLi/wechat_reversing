package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.protocal.c.ajp;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ai {
    private static Map<String, bbk> pWW = new ConcurrentHashMap();

    public static List<m> a(String str, boolean z, String str2, boolean z2) {
        Cursor a;
        if (z2) {
            a = ae.beL().a(false, str, 10, z, str2);
        } else {
            a = ae.beL().a(false, str, 0, z, str2);
        }
        List<m> arrayList = new ArrayList();
        if (a.getCount() == 0) {
            a.close();
            return arrayList;
        }
        if (a.moveToFirst()) {
            do {
                m mVar = new m();
                mVar.b(a);
                arrayList.add(mVar);
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    public static m Fk(String str) {
        Cursor a = ae.beL().a(true, str, 1, false, "");
        if (a.getCount() == 0) {
            a.close();
            return null;
        }
        a.moveToFirst();
        m mVar = new m();
        mVar.b(a);
        if (a.isClosed()) {
            return mVar;
        }
        a.close();
        return mVar;
    }

    public static void bfd() {
        if (pWW != null) {
            pWW.clear();
        }
    }

    public static bbk m(m mVar) {
        try {
            bbk c = ae.beK().c((bbk) new bbk().aD(mVar.field_attrBuf));
            pWW.clear();
            return c;
        } catch (Throwable e) {
            w.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new bbk();
        }
    }

    public static bbk n(m mVar) {
        try {
            bbk com_tencent_mm_protocal_c_bbk;
            if (mVar.qnj == null) {
                mVar.qnj = g.n(mVar.field_content) + g.n(mVar.field_attrBuf);
            }
            if (pWW.containsKey(mVar.qnj)) {
                com_tencent_mm_protocal_c_bbk = (bbk) pWW.get(mVar.qnj);
                if (com_tencent_mm_protocal_c_bbk != null) {
                    ae.beK().c(com_tencent_mm_protocal_c_bbk);
                    return com_tencent_mm_protocal_c_bbk;
                }
            }
            com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(mVar.field_attrBuf);
            pWW.put(mVar.qnj, com_tencent_mm_protocal_c_bbk);
            ae.beK().c(com_tencent_mm_protocal_c_bbk);
            return com_tencent_mm_protocal_c_bbk;
        } catch (Throwable e) {
            w.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new bbk();
        }
    }

    public static void b(long j, bav com_tencent_mm_protocal_c_bav) {
        bau com_tencent_mm_protocal_c_bau = com_tencent_mm_protocal_c_bav.ubR;
        if (com_tencent_mm_protocal_c_bau.jOc == 9) {
            m dG = ae.beL().dG(j);
            if (dG != null) {
                try {
                    bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(dG.field_attrBuf);
                    com_tencent_mm_protocal_c_bbk.tmx = j;
                    Iterator it = com_tencent_mm_protocal_c_bbk.ucq.iterator();
                    while (it.hasNext()) {
                        bba com_tencent_mm_protocal_c_bba = (bba) it.next();
                        if (com_tencent_mm_protocal_c_bba.ubK == com_tencent_mm_protocal_c_bau.ubK && !bg.mA(com_tencent_mm_protocal_c_bba.tgG) && com_tencent_mm_protocal_c_bba.tgG.equals(com_tencent_mm_protocal_c_bau.tWt)) {
                            com_tencent_mm_protocal_c_bbk.ucq.remove(com_tencent_mm_protocal_c_bba);
                            break;
                        }
                    }
                    dG.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
                    ae.beL().a(com_tencent_mm_protocal_c_bbk.tmx, dG);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void c(long j, bav com_tencent_mm_protocal_c_bav) {
        bau com_tencent_mm_protocal_c_bau = com_tencent_mm_protocal_c_bav.ubR;
        if (com_tencent_mm_protocal_c_bau.jOc == 13) {
            m dG = ae.beL().dG(j);
            if (dG != null) {
                try {
                    bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(dG.field_attrBuf);
                    com_tencent_mm_protocal_c_bbk.tmx = j;
                    if (com_tencent_mm_protocal_c_bbk.ucB == null) {
                        com_tencent_mm_protocal_c_bbk.ucB = new bbz();
                    }
                    if (com_tencent_mm_protocal_c_bau.jOc == 13) {
                        Iterator it = com_tencent_mm_protocal_c_bbk.ucB.ude.iterator();
                        while (it.hasNext()) {
                            if (((bbg) it.next()).tgG.equals(com_tencent_mm_protocal_c_bau.tWt)) {
                                return;
                            }
                        }
                        bbg com_tencent_mm_protocal_c_bbg = new bbg();
                        com_tencent_mm_protocal_c_bbg.ubO = com_tencent_mm_protocal_c_bau.ubO;
                        com_tencent_mm_protocal_c_bbg.ogM = com_tencent_mm_protocal_c_bau.ogM;
                        com_tencent_mm_protocal_c_bbg.tgG = com_tencent_mm_protocal_c_bau.tWt;
                        com_tencent_mm_protocal_c_bbk.ucB.ude.add(com_tencent_mm_protocal_c_bbg);
                        com_tencent_mm_protocal_c_bbk.ucB.udd = com_tencent_mm_protocal_c_bbk.ucB.ude.size();
                    }
                    dG.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
                    ae.beL().a(com_tencent_mm_protocal_c_bbk.tmx, dG);
                } catch (Throwable e) {
                    w.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + e.getMessage());
                    w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static boolean a(long j, bav com_tencent_mm_protocal_c_bav) {
        bau com_tencent_mm_protocal_c_bau = com_tencent_mm_protocal_c_bav.ubR;
        if (com_tencent_mm_protocal_c_bau.jOc != 1 && com_tencent_mm_protocal_c_bau.jOc != 2) {
            return true;
        }
        m dG = ae.beL().dG(j);
        if (dG == null) {
            return true;
        }
        if (dG.field_type != 21 || com.tencent.mm.plugin.sns.lucky.a.g.bdF()) {
            try {
                bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(dG.field_attrBuf);
                com_tencent_mm_protocal_c_bbk.tmx = j;
                Iterator it;
                bba com_tencent_mm_protocal_c_bba;
                if (com_tencent_mm_protocal_c_bau.jOc == 1) {
                    it = com_tencent_mm_protocal_c_bbk.ucn.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_bba = (bba) it.next();
                        if (com_tencent_mm_protocal_c_bba.ogM == com_tencent_mm_protocal_c_bau.ogM && com_tencent_mm_protocal_c_bba.tgG.equals(com_tencent_mm_protocal_c_bau.tWt)) {
                            return true;
                        }
                    }
                    com_tencent_mm_protocal_c_bbk.ucn.add(ac.a(com_tencent_mm_protocal_c_bav));
                } else if (com_tencent_mm_protocal_c_bau.jOc == 2) {
                    it = com_tencent_mm_protocal_c_bbk.ucq.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_bba = (bba) it.next();
                        if (com_tencent_mm_protocal_c_bba.ogM == com_tencent_mm_protocal_c_bau.ogM && com_tencent_mm_protocal_c_bba.tgG.equals(com_tencent_mm_protocal_c_bau.tWt)) {
                            return true;
                        }
                    }
                    com_tencent_mm_protocal_c_bbk.ucq.add(ac.a(com_tencent_mm_protocal_c_bav));
                }
                dG.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
                ae.beL().a(com_tencent_mm_protocal_c_bbk.tmx, dG);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            }
            return true;
        }
        w.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
        return false;
    }

    public static long d(bbk com_tencent_mm_protocal_c_bbk) {
        String str = "";
        m dG = ae.beL().dG(com_tencent_mm_protocal_c_bbk.tmx);
        if (dG == null) {
            dG = new m();
        }
        return a(dG, com_tencent_mm_protocal_c_bbk, str, 0);
    }

    private static long a(m mVar, bbk com_tencent_mm_protocal_c_bbk, String str, int i) {
        int i2 = 1;
        if (mVar == null) {
            mVar = new m();
        }
        if (!ae.beK().dr(mVar.field_snsId)) {
            return com_tencent_mm_protocal_c_bbk.tmx;
        }
        if (com_tencent_mm_protocal_c_bbk.ucu != 0) {
            w.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + com_tencent_mm_protocal_c_bbk.tmx + "  " + i.df(com_tencent_mm_protocal_c_bbk.tmx));
            if (mVar.tE(i)) {
                i2 = 0;
            } else {
                mVar.tC(i);
            }
            if (i2 != 0) {
                ae.beL().a(com_tencent_mm_protocal_c_bbk.tmx, mVar);
            }
            return com_tencent_mm_protocal_c_bbk.tmx;
        }
        LinkedList linkedList = com_tencent_mm_protocal_c_bbk.ucq;
        w.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx), Integer.valueOf(linkedList.size()), i.df(com_tencent_mm_protocal_c_bbk.tmx)});
        if (com_tencent_mm_protocal_c_bbk.ucj == null || com_tencent_mm_protocal_c_bbk.ucj.tZp == null) {
            w.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
            return com_tencent_mm_protocal_c_bbk.tmx;
        }
        String str2 = new String(com_tencent_mm_protocal_c_bbk.ucj.tZp.toByteArray());
        w.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx)});
        if (bg.mA(str2)) {
            return com_tencent_mm_protocal_c_bbk.tmx;
        }
        if (!mVar.Ge(str2)) {
            return com_tencent_mm_protocal_c_bbk.tmx;
        }
        int i3;
        com_tencent_mm_protocal_c_bbk.ucA = b(com_tencent_mm_protocal_c_bbk.ucA, mVar.field_attrBuf);
        w.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx)});
        com_tencent_mm_protocal_c_bbk.ucj.bb(new byte[0]);
        mVar.field_userName = com_tencent_mm_protocal_c_bbk.tgG;
        mVar.fN(com_tencent_mm_protocal_c_bbk.ogM);
        mVar.field_likeFlag = com_tencent_mm_protocal_c_bbk.uck;
        mVar.dC(com_tencent_mm_protocal_c_bbk.tmx);
        mVar.dE(com_tencent_mm_protocal_c_bbk.tmx);
        mVar.tC(i);
        try {
            mVar.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
        }
        bfc bhd = mVar.bhd();
        bhd.jNj = com_tencent_mm_protocal_c_bbk.tgG;
        int i4 = bhd.tPk;
        mVar.field_pravited = i4;
        w.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx), Integer.valueOf(com_tencent_mm_protocal_c_bbk.tQZ)});
        if ((com_tencent_mm_protocal_c_bbk.tQZ & 1) > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            mVar.bhv();
        } else {
            mVar.bhw();
        }
        if (i4 != 1 || i == 4) {
            if (i4 == 1 || (!str.equals(com_tencent_mm_protocal_c_bbk.tgG) && i == 4)) {
                mVar.bhs();
            }
            mVar.b(bhd);
            mVar.field_type = bhd.ufB.tsN;
            mVar.field_subType = bhd.ufB.tsP;
            ae.beL().a(com_tencent_mm_protocal_c_bbk.tmx, mVar);
            return com_tencent_mm_protocal_c_bbk.tmx;
        }
        w.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        return 0;
    }

    public static avw b(avw com_tencent_mm_protocal_c_avw, byte[] bArr) {
        if (bArr != null) {
            try {
                avw com_tencent_mm_protocal_c_avw2 = ((bbk) new bbk().aD(bArr)).ucA;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                return null;
            }
        }
        com_tencent_mm_protocal_c_avw2 = null;
        if (com_tencent_mm_protocal_c_avw == null) {
            return com_tencent_mm_protocal_c_avw2;
        }
        bbs com_tencent_mm_protocal_c_bbs = new bbs();
        if (com_tencent_mm_protocal_c_avw2 != null) {
            com_tencent_mm_protocal_c_bbs = (bbs) com_tencent_mm_protocal_c_bbs.aD(com_tencent_mm_protocal_c_avw2.tZp.sYA);
        }
        bbs com_tencent_mm_protocal_c_bbs2 = (bbs) new bbs().aD(com_tencent_mm_protocal_c_avw.tZp.sYA);
        if (com_tencent_mm_protocal_c_bbs2.ucP == null) {
            com_tencent_mm_protocal_c_bbs2.ucP = com_tencent_mm_protocal_c_bbs.ucP;
        }
        if (com_tencent_mm_protocal_c_bbs.ucO == null) {
            com_tencent_mm_protocal_c_bbs2.ucO = null;
        } else if (com_tencent_mm_protocal_c_bbs2.ucO == null) {
            com_tencent_mm_protocal_c_bbs2.ucO = com_tencent_mm_protocal_c_bbs.ucO;
        }
        return new avw().bb(com_tencent_mm_protocal_c_bbs2.toByteArray());
    }

    private static String bp(List<String> list) {
        String str = "";
        for (String str2 : list) {
            if (str.length() == 0) {
                str = str2;
            } else {
                str = str + "," + str2;
            }
        }
        return str;
    }

    public static void a(String str, int i, LinkedList<bbk> linkedList, String str2) {
        if (linkedList != null && !linkedList.isEmpty()) {
            String str3;
            String str4;
            Cursor rawQuery;
            n beL = ae.beL();
            List arrayList = new ArrayList();
            List linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                bbk com_tencent_mm_protocal_c_bbk = (bbk) linkedList.get(i2);
                m dG = beL.dG(com_tencent_mm_protocal_c_bbk.tmx);
                if (dG == null) {
                    dG = new m();
                }
                if (a(dG, com_tencent_mm_protocal_c_bbk, str, i) != 0) {
                    if (linkedList2.size() < 3 && (dG.field_type == 1 || dG.field_type == 15)) {
                        linkedList2.add(i.df(dG.field_snsId));
                    }
                    arrayList.add(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx));
                }
            }
            if ((i == 4 || i == 8) && str2.equals("")) {
                k Gk = ae.beO().Gk(str);
                List f = bg.f(bg.ap(Gk != null ? Gk.field_newerIds : "", "").split(","));
                w.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + bp(linkedList2));
                while (linkedList2.size() < 3 && f.size() > 0) {
                    str3 = (String) f.remove(0);
                    if (str3 != null) {
                        int i3 = 0;
                        while (i3 < linkedList2.size()) {
                            str4 = (String) linkedList2.get(i3);
                            if (str3.compareTo(str4) == 0) {
                                break;
                            } else if (str3.compareTo(str4) > 0) {
                                linkedList2.add(0, str3);
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (!linkedList2.contains(str3)) {
                            linkedList2.add(str3);
                        }
                    }
                }
                w.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + bp(linkedList2));
                ae.beO().dD(str, bp(linkedList2));
            }
            str3 = i.EL(i.df(((bbk) linkedList.getLast()).tmx));
            w.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + str2 + "  -  " + str3);
            n beL2;
            if (i == 2) {
                beL2 = ae.beL();
                str4 = n.bhP();
                if (str2 == null || !str2.equals("")) {
                    str4 = str4 + " AND " + beL2.Gs(str2);
                }
                if (n.Go(str3)) {
                    str4 = str4 + " AND " + beL2.Gp(str3);
                }
                w.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = beL2.gUz.rawQuery(str4, null);
            } else {
                beL2 = ae.beL();
                str4 = n.c(true, str, i == 4);
                if (n.Go(str2)) {
                    str4 = str4 + " AND " + beL2.Gs(str2);
                }
                if (n.Go(str3)) {
                    str4 = str4 + " AND " + beL2.Gp(str3);
                }
                w.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = beL2.gUz.rawQuery(str4, null);
            }
            if (rawQuery == null) {
                return;
            }
            if (rawQuery.moveToFirst()) {
                do {
                    m mVar = new m();
                    mVar.b(rawQuery);
                    long j = mVar.field_snsId;
                    if (mVar.bhz()) {
                        w.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
                    } else if (mVar.bhA()) {
                        w.d("MicroMsg.SnsInfoStorageLogic", "die one ");
                    } else if (!arrayList.contains(Long.valueOf(j))) {
                        mVar.tF(i);
                        ae.beL().b(j, mVar);
                        w.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + j + " source " + i);
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                return;
            }
            rawQuery.close();
        }
    }

    public static boolean O(int i, boolean z) {
        if (!z || i <= 0) {
            return false;
        }
        return true;
    }

    public static boolean te(int i) {
        ali com_tencent_mm_protocal_c_ali;
        Throwable th;
        int i2;
        q dH;
        w.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　" + i);
        m tH = ae.beL().tH(i);
        if (tH == null) {
            return false;
        }
        int i3;
        alk com_tencent_mm_protocal_c_alk;
        tH.bhB();
        tH.fN((int) (System.currentTimeMillis() / 1000));
        ali com_tencent_mm_protocal_c_ali2 = null;
        try {
            ali com_tencent_mm_protocal_c_ali3 = (ali) new ali().aD(tH.field_postBuf);
            try {
                com_tencent_mm_protocal_c_ali3.hqX = 0;
                com_tencent_mm_protocal_c_ali3.tPJ = System.currentTimeMillis();
                tH.field_postBuf = com_tencent_mm_protocal_c_ali3.toByteArray();
                com_tencent_mm_protocal_c_ali = com_tencent_mm_protocal_c_ali3;
            } catch (Throwable e) {
                Throwable th2 = e;
                com_tencent_mm_protocal_c_ali2 = com_tencent_mm_protocal_c_ali3;
                th = th2;
                w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", th, "", new Object[0]);
                com_tencent_mm_protocal_c_ali = com_tencent_mm_protocal_c_ali2;
                if (com_tencent_mm_protocal_c_ali != null) {
                    return false;
                }
                ae.beL().b(i, tH);
                for (i2 = 0; i2 < com_tencent_mm_protocal_c_ali.tPG.size(); i2++) {
                    i3 = ((ajp) com_tencent_mm_protocal_c_ali.tPG.get(i2)).tNq;
                    dH = ae.beA().dH((long) i3);
                    if (dH == null) {
                        dH.offset = 0;
                        try {
                            com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
                            if (com_tencent_mm_protocal_c_alk.tQe == 0) {
                                com_tencent_mm_protocal_c_alk.tQe = 2;
                                com_tencent_mm_protocal_c_alk.tQf = "";
                                dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
                                ae.beA().a(i3, dH);
                            } else {
                                continue;
                            }
                        } catch (Exception e2) {
                            w.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                            return false;
                        }
                    }
                }
                return true;
            }
        } catch (Exception e3) {
            th = e3;
            w.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", th, "", new Object[0]);
            com_tencent_mm_protocal_c_ali = com_tencent_mm_protocal_c_ali2;
            if (com_tencent_mm_protocal_c_ali != null) {
                return false;
            }
            ae.beL().b(i, tH);
            for (i2 = 0; i2 < com_tencent_mm_protocal_c_ali.tPG.size(); i2++) {
                i3 = ((ajp) com_tencent_mm_protocal_c_ali.tPG.get(i2)).tNq;
                dH = ae.beA().dH((long) i3);
                if (dH == null) {
                    dH.offset = 0;
                    com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
                    if (com_tencent_mm_protocal_c_alk.tQe == 0) {
                        continue;
                    } else {
                        com_tencent_mm_protocal_c_alk.tQe = 2;
                        com_tencent_mm_protocal_c_alk.tQf = "";
                        dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
                        ae.beA().a(i3, dH);
                    }
                }
            }
            return true;
        }
        if (com_tencent_mm_protocal_c_ali != null) {
            return false;
        }
        ae.beL().b(i, tH);
        for (i2 = 0; i2 < com_tencent_mm_protocal_c_ali.tPG.size(); i2++) {
            i3 = ((ajp) com_tencent_mm_protocal_c_ali.tPG.get(i2)).tNq;
            dH = ae.beA().dH((long) i3);
            if (dH == null) {
                dH.offset = 0;
                com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
                if (com_tencent_mm_protocal_c_alk.tQe == 0) {
                    continue;
                } else {
                    com_tencent_mm_protocal_c_alk.tQe = 2;
                    com_tencent_mm_protocal_c_alk.tQf = "";
                    dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
                    ae.beA().a(i3, dH);
                }
            }
        }
        return true;
    }

    public static boolean Fl(String str) {
        return com.tencent.mm.u.m.xL().equals(str.trim());
    }

    public static List<m> bfe() {
        List arrayList = new ArrayList();
        n beL = ae.beL();
        Cursor rawQuery = beL.gUz.rawQuery(n.bhQ() + " AND " + n.qnG + " AND  (snsId = 0  ) ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
        } else {
            rawQuery.moveToFirst();
            do {
                m mVar = new m();
                mVar.b(rawQuery);
                arrayList.add(mVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
        }
        return arrayList;
    }

    public static String Fm(String str) {
        int i = 1;
        List linkedList = new LinkedList();
        Cursor cursor = ae.beQ().getCursor();
        if (cursor.moveToFirst()) {
            do {
                s sVar = new s();
                sVar.b(cursor);
                linkedList.add(bg.ap(sVar.field_tagName, ""));
            } while (cursor.moveToNext());
        }
        cursor.close();
        String str2 = str;
        while (linkedList.contains(str2)) {
            StringBuilder append = new StringBuilder().append(str);
            int i2 = i + 1;
            str2 = append.append(i).toString();
            i = i2;
        }
        return str2;
    }

    public static m tf(int i) {
        m mVar = new m();
        n beL = ae.beL();
        w.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[]{((n.bhR() + " and createTime < " + i) + n.qnA) + " LIMIT 1"});
        Cursor rawQuery = beL.gUz.rawQuery(r3, null);
        if (rawQuery == null) {
            rawQuery = null;
        }
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            mVar.b(rawQuery);
            rawQuery.close();
            return mVar;
        }
        rawQuery.close();
        return null;
    }

    public static List<b> dt(String str, String str2) {
        int i = 0;
        List<b> arrayList = new ArrayList();
        cc ccVar = null;
        try {
            String str3 = str2 + str + "_ARTISTF.mm";
            String str4 = str2 + str + "_ARTIST.mm";
            if (FileOp.aO(str3)) {
                ccVar = (cc) new cc().aD(FileOp.c(str3, 0, (int) FileOp.ki(str3)));
            }
            if (ccVar == null) {
                FileOp.deleteFile(str3);
                ccVar = a.FP(new String(FileOp.c(str4, 0, (int) FileOp.ki(str4))));
                FileOp.b(str3, ccVar.toByteArray(), -1);
            }
            Iterator it = ccVar.tfz.iterator();
            while (it.hasNext()) {
                aeg com_tencent_mm_protocal_c_aeg = (aeg) it.next();
                str4 = com_tencent_mm_protocal_c_aeg.msj;
                Iterator it2 = com_tencent_mm_protocal_c_aeg.tsO.iterator();
                while (it2.hasNext()) {
                    alh com_tencent_mm_protocal_c_alh = (alh) it2.next();
                    com_tencent_mm_protocal_c_alh.msk = str4;
                    b bVar = new b();
                    bVar.fVV = com_tencent_mm_protocal_c_alh;
                    bVar.qaD = "";
                    int i2 = i + 1;
                    bVar.qaE = i;
                    arrayList.add(bVar);
                    i = i2;
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
        }
        return arrayList;
    }

    public static alh a(m mVar, int i) {
        if (ae.beu() || mVar == null) {
            return null;
        }
        bfc bhd = mVar.bhd();
        if (bhd.ufB == null || bhd.ufB.tsO.size() == 0 || bhd.ufB.tsO.size() <= i) {
            return null;
        }
        return (alh) bhd.ufB.tsO.get(i);
    }

    public static alh a(m mVar, String str) {
        bfc bhd = mVar.bhd();
        if (bhd.ufB == null || bhd.ufB.tsO.size() == 0) {
            return null;
        }
        Iterator it = bhd.ufB.tsO.iterator();
        while (it.hasNext()) {
            alh com_tencent_mm_protocal_c_alh = (alh) it.next();
            if (com_tencent_mm_protocal_c_alh.mQY.equals(str)) {
                return com_tencent_mm_protocal_c_alh;
            }
        }
        return null;
    }

    public static List<b> Fn(String str) {
        List<b> arrayList = new ArrayList();
        if (ae.beu()) {
            return arrayList;
        }
        m Gg = h.Gg(str);
        if (Gg == null) {
            return arrayList;
        }
        bfc bhd = Gg.bhd();
        if (bhd.ufB == null || bhd.ufB.tsO.size() == 0) {
            return arrayList;
        }
        arrayList.clear();
        Iterator it = bhd.ufB.tsO.iterator();
        int i = 0;
        while (it.hasNext()) {
            alh com_tencent_mm_protocal_c_alh = (alh) it.next();
            b bVar = new b();
            bVar.fVV = com_tencent_mm_protocal_c_alh;
            bVar.qaD = str;
            bVar.hFf = bhd.ogM;
            int i2 = i + 1;
            bVar.qaE = i;
            arrayList.add(bVar);
            i = i2;
        }
        return arrayList;
    }

    public static List<b> bq(List<String> list) {
        List<b> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        for (String str : list) {
            b bVar = new b();
            alh com_tencent_mm_protocal_c_alh = new alh();
            com_tencent_mm_protocal_c_alh.mQY = "pre_temp_extend_pic" + str;
            bVar.fVV = com_tencent_mm_protocal_c_alh;
            bVar.qaD = "";
            int i2 = i + 1;
            bVar.qaE = i;
            arrayList.add(bVar);
            i = i2;
        }
        return arrayList;
    }

    public static void tg(int i) {
        w.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　" + i);
        m tH = ae.beL().tH(i);
        if (tH != null) {
            if (((tH.field_localFlag & 64) > 0 ? 1 : null) != null) {
                tH.field_localFlag &= -65;
            }
            ae.beL().b(i, tH);
        }
    }

    public static void bff() {
        Cursor bM = ae.beL().bM("", 0);
        if (bM != null) {
            w.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
            while (bM.moveToNext()) {
                m mVar = new m();
                mVar.b(bM);
                w.i("MicroMsg.SnsInfoStorageLogic", mVar.bhe());
            }
            w.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
            bM.close();
        }
    }
}
