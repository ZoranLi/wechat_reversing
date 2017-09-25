package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.aud;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bby;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.ca;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public final class a {
    private static final String pSu;
    private static LinkedHashMap<Long, Integer> pSv;
    private static Comparator<bba> pSw = new Comparator<bba>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((bba) obj).ogM - ((bba) obj2).ogM;
        }
    };

    static {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        pSu = stringBuilder.append(h.vI().cachePath).append("sns_recvd_ad").toString();
    }

    public static void a(baq com_tencent_mm_protocal_c_baq) {
        if (com_tencent_mm_protocal_c_baq == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (com_tencent_mm_protocal_c_baq.ubC == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            e c = c(com_tencent_mm_protocal_c_baq);
            if (c == null) {
                return;
            }
            if (ae.beN().dA(com_tencent_mm_protocal_c_baq.ubC.tmx)) {
                w.i("MicroMsg.AdSnsInfoStorageLogic", "ind this adobj and update" + com_tencent_mm_protocal_c_baq.ubC.tmx);
                ae.beN().b(com_tencent_mm_protocal_c_baq.ubC.tmx, c);
                return;
            }
            w.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + com_tencent_mm_protocal_c_baq.ubC.tmx);
        }
    }

    public static void a(bby com_tencent_mm_protocal_c_bby) {
        b(b(com_tencent_mm_protocal_c_bby));
    }

    public static void b(baq com_tencent_mm_protocal_c_baq) {
        if (com_tencent_mm_protocal_c_baq == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (com_tencent_mm_protocal_c_baq.ubC == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            ae.beN().a(com_tencent_mm_protocal_c_baq.ubC.tmx, c(com_tencent_mm_protocal_c_baq));
        }
    }

    private static e c(baq com_tencent_mm_protocal_c_baq) {
        e eVar;
        e dz = ae.beN().dz(com_tencent_mm_protocal_c_baq.ubC.tmx);
        bbk com_tencent_mm_protocal_c_bbk = com_tencent_mm_protocal_c_baq.ubC;
        String str = null;
        if (dz == null) {
            eVar = new e();
        } else {
            str = dz.bhd().qui;
            eVar = dz;
        }
        String b = n.b(com_tencent_mm_protocal_c_bbk.ucj);
        if (bg.mA(b)) {
            return null;
        }
        if (!eVar.Ge(b)) {
            return null;
        }
        if (!bg.mA(str)) {
            bfc bhd = eVar.bhd();
            bhd.qui = str;
            eVar.b(bhd);
        }
        com_tencent_mm_protocal_c_bbk.ucA = ai.b(com_tencent_mm_protocal_c_bbk.ucA, eVar.field_attrBuf);
        w.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx)});
        com_tencent_mm_protocal_c_bbk.ucj.bb(new byte[0]);
        eVar.field_userName = com_tencent_mm_protocal_c_bbk.tgG;
        if (com_tencent_mm_protocal_c_baq.ubD != null) {
            eVar.field_recxml = n.a(com_tencent_mm_protocal_c_baq.ubD);
            str = EU(eVar.field_recxml);
            if (!(bg.mA(str) || str.equals(eVar.field_adxml))) {
                w.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml " + str);
                eVar.field_adxml = str;
            }
        }
        eVar.field_likeFlag = com_tencent_mm_protocal_c_bbk.uck;
        long j = com_tencent_mm_protocal_c_bbk.tmx;
        eVar.field_snsId = j;
        if (j != 0) {
            eVar.field_stringSeq = i.df(j);
            eVar.field_stringSeq = i.EL(eVar.field_stringSeq);
            w.d("MicroMsg.AdSnsInfo", j + " stringSeq " + eVar.field_stringSeq);
        }
        eVar.tC(2);
        eVar.tC(32);
        try {
            bbk com_tencent_mm_protocal_c_bbk2;
            List<bba> linkedList;
            Iterator it;
            bba com_tencent_mm_protocal_c_bba;
            Iterator it2;
            bba com_tencent_mm_protocal_c_bba2;
            af Rc;
            if (eVar.field_attrBuf == null) {
                com_tencent_mm_protocal_c_bbk2 = new bbk();
            } else {
                com_tencent_mm_protocal_c_bbk2 = (bbk) new bbk().aD(eVar.field_attrBuf);
            }
            if (!(com_tencent_mm_protocal_c_bbk2 == null || com_tencent_mm_protocal_c_bbk2.ucq == null)) {
                linkedList = new LinkedList();
                it = com_tencent_mm_protocal_c_bbk.ucq.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bba = (bba) it.next();
                    if (com_tencent_mm_protocal_c_bba.tQU > 0) {
                        linkedList.add(com_tencent_mm_protocal_c_bba);
                        it2 = com_tencent_mm_protocal_c_bbk2.ucq.iterator();
                        while (it2.hasNext()) {
                            com_tencent_mm_protocal_c_bba2 = (bba) it2.next();
                            if (com_tencent_mm_protocal_c_bba2.ubN == com_tencent_mm_protocal_c_bba.ubN) {
                                com_tencent_mm_protocal_c_bbk2.ucq.remove(com_tencent_mm_protocal_c_bba2);
                                break;
                            }
                        }
                    }
                }
                for (bba com_tencent_mm_protocal_c_bba3 : linkedList) {
                    com_tencent_mm_protocal_c_bbk.ucq.remove(com_tencent_mm_protocal_c_bba3);
                }
                linkedList.clear();
                Iterator it3 = com_tencent_mm_protocal_c_bbk2.ucq.iterator();
                while (it3.hasNext()) {
                    com_tencent_mm_protocal_c_bba3 = (bba) it3.next();
                    if (!(b(com_tencent_mm_protocal_c_bba3, com_tencent_mm_protocal_c_bbk.ucq) || com_tencent_mm_protocal_c_bba3.ubN == 0)) {
                        h.vJ();
                        Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(com_tencent_mm_protocal_c_bba3.tgG);
                        if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type) || Rc.tA()) {
                            w.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + com_tencent_mm_protocal_c_bba3.tgG);
                        } else {
                            com_tencent_mm_protocal_c_bbk.ucq.add(com_tencent_mm_protocal_c_bba3);
                            com_tencent_mm_protocal_c_bbk.ucp = com_tencent_mm_protocal_c_bbk.ucq.size();
                        }
                    }
                }
            }
            Collections.sort(com_tencent_mm_protocal_c_bbk.ucq, pSw);
            if (com_tencent_mm_protocal_c_bbk.ucn != null) {
                linkedList = new LinkedList();
                it = com_tencent_mm_protocal_c_bbk.ucn.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bba3 = (bba) it.next();
                    if (com_tencent_mm_protocal_c_bba3.tQU > 0) {
                        linkedList.add(com_tencent_mm_protocal_c_bba3);
                        it2 = com_tencent_mm_protocal_c_bbk2.ucn.iterator();
                        while (it2.hasNext()) {
                            com_tencent_mm_protocal_c_bba2 = (bba) it2.next();
                            if (!bg.mA(com_tencent_mm_protocal_c_bba2.tgG)) {
                                if (com_tencent_mm_protocal_c_bba2.tgG.equals(com_tencent_mm_protocal_c_bba3.tgG)) {
                                }
                            }
                            com_tencent_mm_protocal_c_bbk2.ucn.remove(com_tencent_mm_protocal_c_bba2);
                        }
                    }
                }
                for (bba com_tencent_mm_protocal_c_bba32 : linkedList) {
                    com_tencent_mm_protocal_c_bbk.ucn.remove(com_tencent_mm_protocal_c_bba32);
                }
                linkedList.clear();
                if (!(com_tencent_mm_protocal_c_bbk2 == null || com_tencent_mm_protocal_c_bbk2.ucn == null)) {
                    Iterator it4 = com_tencent_mm_protocal_c_bbk2.ucn.iterator();
                    while (it4.hasNext()) {
                        com_tencent_mm_protocal_c_bba32 = (bba) it4.next();
                        if (!a(com_tencent_mm_protocal_c_bba32, com_tencent_mm_protocal_c_bbk.ucn)) {
                            h.vJ();
                            Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(com_tencent_mm_protocal_c_bba32.tgG);
                            if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type) || Rc.tA()) {
                                w.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + com_tencent_mm_protocal_c_bba32.tgG);
                            } else {
                                com_tencent_mm_protocal_c_bbk.ucn.add(com_tencent_mm_protocal_c_bba32);
                                com_tencent_mm_protocal_c_bbk.ucm = com_tencent_mm_protocal_c_bbk.ucn.size();
                            }
                        }
                    }
                }
                Collections.sort(com_tencent_mm_protocal_c_bbk.ucn, pSw);
            }
        } catch (Throwable e) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "error " + e.getMessage());
            w.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        try {
            eVar.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
        }
        bfc bhd2 = eVar.bhd();
        bhd2.jNj = com_tencent_mm_protocal_c_bbk.tgG;
        eVar.field_pravited = bhd2.tPk;
        w.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + com_tencent_mm_protocal_c_bbk.tQZ + " " + com_tencent_mm_protocal_c_bbk.ucq.size() + " " + com_tencent_mm_protocal_c_bbk.ucn.size());
        eVar.b(bhd2);
        eVar.field_type = bhd2.ufB.tsN;
        eVar.field_subType = bhd2.ufB.tsP;
        return eVar;
    }

    private static String EU(String str) {
        String str2 = "<adxml";
        if (TextUtils.isEmpty(str) || str.startsWith(str2)) {
            return str;
        }
        String str3 = "</adxml>";
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(str3);
        if (lastIndexOf < 0 || lastIndexOf <= indexOf) {
            return str;
        }
        return str.substring(indexOf, str3.length() + lastIndexOf);
    }

    private static boolean a(bba com_tencent_mm_protocal_c_bba, List<bba> list) {
        for (bba com_tencent_mm_protocal_c_bba2 : list) {
            if (!bg.mA(com_tencent_mm_protocal_c_bba.tgG) && com_tencent_mm_protocal_c_bba.tgG.equals(com_tencent_mm_protocal_c_bba2.tgG)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(bba com_tencent_mm_protocal_c_bba, List<bba> list) {
        for (bba com_tencent_mm_protocal_c_bba2 : list) {
            if (com_tencent_mm_protocal_c_bba.ubN == com_tencent_mm_protocal_c_bba2.ubN && com_tencent_mm_protocal_c_bba2.ubN != 0) {
                return true;
            }
        }
        return false;
    }

    private static void a(ca caVar, int i, int i2, com.tencent.mm.plugin.sns.storage.a aVar) {
        if (caVar == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (caVar.tfu == null || caVar.tfu.ubC == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            bbk com_tencent_mm_protocal_c_bbk = caVar.tfu.ubC;
            e c = c(caVar.tfu);
            bfc bhd = c.bhd();
            bdi com_tencent_mm_protocal_c_bdi = new bdi();
            com_tencent_mm_protocal_c_bdi.ueA = new bdj();
            com_tencent_mm_protocal_c_bdi.ueA.ueE = aVar.pZI;
            com_tencent_mm_protocal_c_bdi.ueA.ueD = bhd.mQY;
            com_tencent_mm_protocal_c_bdi.ueA.cGa = c.getSource();
            com_tencent_mm_protocal_c_bdi.ueA.qna = o.a(com_tencent_mm_protocal_c_bdi.ueA);
            if (bhd.ufB.tsN == 1) {
                com_tencent_mm_protocal_c_bdi.ueA.hTr = 1;
            } else if (bhd.ufB.tsN == 15) {
                com_tencent_mm_protocal_c_bdi.ueA.hTr = 2;
            } else {
                com_tencent_mm_protocal_c_bdi.ueA.hTr = 0;
            }
            bdj com_tencent_mm_protocal_c_bdj = com_tencent_mm_protocal_c_bdi.ueA;
            b bhb = c.bhb();
            com_tencent_mm_protocal_c_bdj.ueF = bhb == null ? 0 : bhb.qet;
            try {
                w.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[]{bhd.mQY, Base64.encodeToString(com_tencent_mm_protocal_c_bdi.toByteArray(), 0).replace("\n", ""), com_tencent_mm_protocal_c_bdi.ueA.ueD, com_tencent_mm_protocal_c_bdi.ueA.ueE});
                bhd.qui = r0;
                c.b(bhd);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            if (c != null) {
                c.field_createTime = i;
                c.field_exposureTime = 0;
                c.field_createAdTime = i2;
                c.field_recxml = n.a(caVar.tfu.ubD);
                c.field_adinfo = n.a(caVar.tfv);
                c.field_adxml = EU(c.field_recxml);
                ae.beN().a(com_tencent_mm_protocal_c_bbk.tmx, c);
            }
        }
    }

    private static baq b(bby com_tencent_mm_protocal_c_bby) {
        if (com_tencent_mm_protocal_c_bby == null) {
            return null;
        }
        baq com_tencent_mm_protocal_c_baq = new baq();
        com_tencent_mm_protocal_c_baq.ubD = com_tencent_mm_protocal_c_bby.udc;
        if (com_tencent_mm_protocal_c_baq.ubD == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
        }
        com_tencent_mm_protocal_c_baq.ubC = com_tencent_mm_protocal_c_bby.ubC;
        return com_tencent_mm_protocal_c_baq;
    }

    private static ca a(aud com_tencent_mm_protocal_c_aud) {
        if (com_tencent_mm_protocal_c_aud == null) {
            return null;
        }
        ca caVar = new ca();
        caVar.tfv = com_tencent_mm_protocal_c_aud.tXU;
        if (caVar.tfv == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
            return null;
        }
        caVar.tfu = b(com_tencent_mm_protocal_c_aud.tXT);
        return caVar;
    }

    public static void b(aud com_tencent_mm_protocal_c_aud) {
        ca a = a(com_tencent_mm_protocal_c_aud);
        if (a != null) {
            com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(n.a(a.tfv));
            int i = aVar.qdF;
            int i2 = i <= 0 ? 1 : i + 1;
            int Gt = ae.beL().Gt("");
            w.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Gt)});
            com.tencent.mm.plugin.sns.storage.n beL = ae.beL();
            String str = "";
            String str2 = (com.tencent.mm.plugin.sns.storage.n.qnz + " from SnsInfo where ") + com.tencent.mm.plugin.sns.storage.n.bhN();
            if (com.tencent.mm.plugin.sns.storage.n.Go(str)) {
                str2 = str2 + " AND " + beL.Gp(str);
            }
            String str3 = ((((str2 + " AND createTime >= " + Gt) + " UNION ") + com.tencent.mm.plugin.sns.storage.n.qnz + " from AdSnsInfo where createTime" + " > " + Gt) + com.tencent.mm.plugin.sns.storage.n.qnA) + " limit " + i2;
            w.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str3 + " limtiSeq: " + str);
            Cursor rawQuery = beL.gUz.rawQuery(str3, null);
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                w.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
                i2 = (int) bg.Ny();
            } else {
                w.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[]{Integer.valueOf(rawQuery.getCount())});
                m mVar = new m();
                if (i < 0) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                if (rawQuery.moveToPosition(i2)) {
                    mVar.b(rawQuery);
                } else {
                    rawQuery.moveToLast();
                    mVar.b(rawQuery);
                }
                i2 = mVar.field_createTime + 1;
            }
            rawQuery.close();
            w.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + a.tfu.ubC.tmx + " ,createTime " + i2);
            a(a, i2, (int) bg.Ny(), aVar);
            a(a);
        }
    }

    public static void d(LinkedList<aud> linkedList, LinkedList<bbk> linkedList2) {
        if (linkedList != null) {
            LinkedList ae = ae(linkedList);
            w.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + ae.size() + " recObj to AdvertiseObj");
            Iterator it = ae.iterator();
            while (it.hasNext()) {
                ca caVar = (ca) it.next();
                if (dh(caVar.tfu.ubC.tmx)) {
                    w.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + caVar.tfu.ubC.tmx);
                    it.remove();
                }
            }
            a(ae, linkedList2, true);
        }
    }

    public static void e(LinkedList<ca> linkedList, LinkedList<bbk> linkedList2) {
        a(linkedList, linkedList2, false);
    }

    private static LinkedList<ca> ae(LinkedList<aud> linkedList) {
        LinkedList<ca> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ca a = a((aud) it.next());
            if (a != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    private static void a(LinkedList<ca> linkedList, LinkedList<bbk> linkedList2, boolean z) {
        if (linkedList != null && linkedList2 != null && linkedList2.size() != 0) {
            int a = a((bbk) linkedList2.get(linkedList2.size() - 1));
            for (int i = 0; i < linkedList.size(); i++) {
                ca caVar = (ca) linkedList.get(i);
                if (caVar == null) {
                    w.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
                } else if (caVar.tfu == null) {
                    w.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
                } else if (caVar.tfu.ubC == null) {
                    w.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
                } else if (z && ae.beN().dA(caVar.tfu.ubC.tmx)) {
                    w.i("MicroMsg.AdSnsInfoStorageLogic", "snsId %d already exist, ignore ", new Object[]{Long.valueOf(caVar.tfu.ubC.tmx)});
                } else {
                    String a2 = n.a(caVar.tfv);
                    String a3 = n.a(caVar.tfu.ubD);
                    String b = n.b(caVar.tfu.ubC.ucj);
                    com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(a2);
                    w.i("MicroMsg.AdSnsInfoStorageLogic", "skXml " + a2);
                    w.i("MicroMsg.AdSnsInfoStorageLogic", "adXml " + a3);
                    w.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + b + "\r\n");
                    b bVar = new b(a3);
                    if (bVar.qeu == 0 || !dh(bVar.qeu)) {
                        int i2 = a + 1;
                        if (aVar.qdF >= linkedList2.size() || aVar.qdF < 0) {
                            w.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aVar.qdF);
                        } else {
                            i2 = a((bbk) linkedList2.get(aVar.qdF)) + 1;
                            w.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i2 + " pos " + aVar.qdF);
                        }
                        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                        w.i("MicroMsg.AdSnsInfoStorageLogic", "gettime " + currentTimeMillis);
                        a(caVar, i2, currentTimeMillis, aVar);
                        di(caVar.tfu.ubC.tmx);
                        di(bVar.qeu);
                    } else {
                        w.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + bVar.qeu);
                    }
                }
            }
        }
    }

    public static void af(LinkedList<aud> linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            LinkedList ae = ae(linkedList);
            w.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + ae.size() + " recObj to AdvertiseObj");
            ag(ae);
        }
    }

    public static void ag(LinkedList<ca> linkedList) {
        if (linkedList != null) {
            for (int i = 0; i < linkedList.size(); i++) {
                a((ca) linkedList.get(i));
            }
        }
    }

    private static void a(ca caVar) {
        String a = n.a(caVar.tfu.ubD);
        if (!bg.mA(a) && new b(a).qdV) {
            f.bgX().d("adId", a, "adxml", 0);
        }
    }

    public static void ah(LinkedList<bbk> linkedList) {
        if (linkedList != null) {
            com.tencent.mm.plugin.sns.storage.n beL = ae.beL();
            for (int i = 0; i < linkedList.size(); i++) {
                bbk com_tencent_mm_protocal_c_bbk = (bbk) linkedList.get(i);
                if (com_tencent_mm_protocal_c_bbk != null) {
                    m dG = beL.dG(com_tencent_mm_protocal_c_bbk.tmx);
                    if (dG != null) {
                        bfc bhd = dG.bhd();
                        if (!(bhd == null || bg.mA(bhd.qsQ))) {
                            f.bgX().d("adId", bhd.qsQ, "adxml", 0);
                        }
                    }
                }
            }
        }
    }

    public static void EV(String str) {
        if (!bg.mA(str)) {
            f.bgX().d("adId", str, "adxml", 1);
        }
    }

    private static int a(bbk com_tencent_mm_protocal_c_bbk) {
        m dG = ae.beL().dG(com_tencent_mm_protocal_c_bbk.tmx);
        return dG == null ? com_tencent_mm_protocal_c_bbk.ogM : dG.field_createTime;
    }

    public static boolean a(long j, bav com_tencent_mm_protocal_c_bav, int i, int i2, int i3, boolean z) {
        if (com_tencent_mm_protocal_c_bav != null) {
            bau com_tencent_mm_protocal_c_bau = com_tencent_mm_protocal_c_bav.ubR;
            if (!(com_tencent_mm_protocal_c_bau.jOc == 7 || com_tencent_mm_protocal_c_bau.jOc == 8)) {
                return false;
            }
        }
        String xL = com.tencent.mm.u.m.xL();
        if (com_tencent_mm_protocal_c_bav != null && com_tencent_mm_protocal_c_bav.ubS != null && com_tencent_mm_protocal_c_bav.ubS.tWt != null && com_tencent_mm_protocal_c_bav.ubS.tWt.equals(xL)) {
            return true;
        }
        e dz = ae.beN().dz(j);
        try {
            m Gf;
            com.tencent.mm.plugin.sns.storage.a bhc;
            bba com_tencent_mm_protocal_c_bba;
            int i4;
            bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(dz.field_attrBuf);
            com_tencent_mm_protocal_c_bbk.tmx = j;
            int i5 = dz.field_firstControlTime;
            bau com_tencent_mm_protocal_c_bau2 = com_tencent_mm_protocal_c_bav.ubR;
            g gVar;
            Object[] objArr;
            if (com_tencent_mm_protocal_c_bau2.jOc == 7) {
                if (i2 > 0 && i5 + i2 < com_tencent_mm_protocal_c_bau2.ogM) {
                    if (z) {
                        Gf = ae.beL().Gf(dz.bhe());
                        if (Gf != null) {
                            bhc = Gf.bhc();
                            if (bhc != null) {
                                gVar = g.oUh;
                                objArr = new Object[7];
                                objArr[0] = Long.valueOf(u.GA(dz.bhe()));
                                objArr[1] = bhc.iHN;
                                objArr[2] = Integer.valueOf(2);
                                objArr[3] = Integer.valueOf(1);
                                objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_bbk.ucn != null ? com_tencent_mm_protocal_c_bbk.ucn.size() : 0);
                                objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_bbk.ucq != null ? com_tencent_mm_protocal_c_bbk.ucq.size() : 0);
                                objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                gVar.i(13182, objArr);
                            } else {
                                w.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            w.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    w.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionLikeTimeLimit: " + i2 + " curAction.createTime: " + com_tencent_mm_protocal_c_bau2.ogM + "is over the time limit!");
                    return false;
                }
            } else if (com_tencent_mm_protocal_c_bau2.jOc == 8 && i3 > 0 && i5 + i3 < com_tencent_mm_protocal_c_bau2.ogM) {
                if (z) {
                    Gf = ae.beL().Gf(dz.bhe());
                    if (Gf != null) {
                        bhc = Gf.bhc();
                        if (bhc != null) {
                            gVar = g.oUh;
                            objArr = new Object[7];
                            objArr[0] = Long.valueOf(u.GA(dz.bhe()));
                            objArr[1] = bhc.iHN;
                            objArr[2] = Integer.valueOf(2);
                            objArr[3] = Integer.valueOf(2);
                            objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_bbk.ucn != null ? com_tencent_mm_protocal_c_bbk.ucn.size() : 0);
                            objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_bbk.ucq != null ? com_tencent_mm_protocal_c_bbk.ucq.size() : 0);
                            objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            gVar.i(13182, objArr);
                        } else {
                            w.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        w.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                w.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionCommentTimeLimit: " + i3 + " curAction.createTime: " + com_tencent_mm_protocal_c_bau2.ogM + "is over the time limit!");
                return false;
            }
            int i6 = 0;
            Iterator it = com_tencent_mm_protocal_c_bbk.ucn.iterator();
            while (it.hasNext()) {
                com_tencent_mm_protocal_c_bba = (bba) it.next();
                if (com_tencent_mm_protocal_c_bba.ogM <= i5 || !(com_tencent_mm_protocal_c_bba == null || com_tencent_mm_protocal_c_bba.tgG == null || !com_tencent_mm_protocal_c_bba.tgG.equals(xL))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            int i7 = i6 + 0;
            i6 = 0;
            Iterator it2 = com_tencent_mm_protocal_c_bbk.ucq.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_bba = (bba) it2.next();
                if (com_tencent_mm_protocal_c_bba.ogM <= i5 || !(com_tencent_mm_protocal_c_bba == null || com_tencent_mm_protocal_c_bba.tgG == null || !com_tencent_mm_protocal_c_bba.tgG.equals(xL))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            i4 = i7 + i6;
            w.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i4 + " firstCreateTime " + i5 + " actionLimit: " + i + " actionLikeTimeLimit: " + i2 + " actionCommentTimeLimit: " + i3);
            if (i4 >= i) {
                if (z) {
                    Gf = ae.beL().Gf(dz.bhe());
                    if (Gf != null) {
                        bhc = Gf.bhc();
                        if (bhc != null) {
                            g gVar2 = g.oUh;
                            Object[] objArr2 = new Object[7];
                            objArr2[0] = Long.valueOf(u.GA(dz.bhe()));
                            objArr2[1] = bhc.iHN;
                            objArr2[2] = Integer.valueOf(1);
                            objArr2[3] = Integer.valueOf(2);
                            objArr2[4] = Integer.valueOf(com_tencent_mm_protocal_c_bbk.ucn != null ? com_tencent_mm_protocal_c_bbk.ucn.size() : 0);
                            objArr2[5] = Integer.valueOf(com_tencent_mm_protocal_c_bbk.ucq != null ? com_tencent_mm_protocal_c_bbk.ucq.size() : 0);
                            objArr2[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            gVar2.i(13182, objArr2);
                        } else {
                            w.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        w.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                return false;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    public static boolean a(long j, bav com_tencent_mm_protocal_c_bav) {
        bau com_tencent_mm_protocal_c_bau = com_tencent_mm_protocal_c_bav.ubR;
        if (com_tencent_mm_protocal_c_bau.jOc != 7 && com_tencent_mm_protocal_c_bau.jOc != 8) {
            return false;
        }
        e dz = ae.beN().dz(j);
        if (dz == null) {
            w.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null " + j);
            return false;
        }
        try {
            bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(dz.field_attrBuf);
            com_tencent_mm_protocal_c_bbk.tmx = j;
            Iterator it;
            bba com_tencent_mm_protocal_c_bba;
            if (com_tencent_mm_protocal_c_bau.jOc == 7) {
                it = com_tencent_mm_protocal_c_bbk.ucn.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bba = (bba) it.next();
                    if (com_tencent_mm_protocal_c_bba.ogM == com_tencent_mm_protocal_c_bau.ogM && com_tencent_mm_protocal_c_bba.tgG.equals(com_tencent_mm_protocal_c_bau.tWt)) {
                        w.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + com_tencent_mm_protocal_c_bba.ogM + " ");
                        return false;
                    }
                }
                com_tencent_mm_protocal_c_bbk.ucn.add(ac.a(com_tencent_mm_protocal_c_bav));
            } else if (com_tencent_mm_protocal_c_bau.jOc == 8) {
                it = com_tencent_mm_protocal_c_bbk.ucq.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bba = (bba) it.next();
                    if (com_tencent_mm_protocal_c_bba.ogM == com_tencent_mm_protocal_c_bau.ogM && com_tencent_mm_protocal_c_bba.tgG.equals(com_tencent_mm_protocal_c_bau.tWt)) {
                        w.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + com_tencent_mm_protocal_c_bba.ogM + " ");
                        return false;
                    }
                }
                com_tencent_mm_protocal_c_bbk.ucq.add(ac.a(com_tencent_mm_protocal_c_bav));
            }
            dz.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
            ae.beN().a(com_tencent_mm_protocal_c_bbk.tmx, dz);
        } catch (Throwable e) {
            w.e("MicroMsg.AdSnsInfoStorageLogic", "e " + e.getMessage());
            w.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    private static boolean dh(long j) {
        bdN();
        return pSv.get(Long.valueOf(j)) != null;
    }

    private static void bdN() {
        ObjectInput objectInputStream;
        Throwable e;
        if (pSv == null) {
            byte[] Mx = com.tencent.mm.pluginsdk.k.a.e.a.Mx(pSu);
            if (Mx != null) {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Mx));
                    try {
                        pSv = (LinkedHashMap) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                        }
                    } catch (StreamCorruptedException e3) {
                        e = e3;
                        try {
                            w.e("MicroMsg.AdSnsInfoStorageLogic", bg.g(e));
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (pSv != null) {
                                pSv = new LinkedHashMap<Long, Integer>(((int) Math.ceil(666.6666870117188d)) + 1) {
                                    protected final boolean removeEldestEntry(Entry<Long, Integer> entry) {
                                        if (size() > 500 && entry != null) {
                                            w.i("MicroMsg.AdSnsInfoStorageLogic", "remove eldest ad snsId " + entry.getKey());
                                        }
                                        return size() > 500;
                                    }
                                };
                            }
                        } catch (Throwable th) {
                            e = th;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        w.e("MicroMsg.AdSnsInfoStorageLogic", bg.g(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (pSv != null) {
                            pSv = /* anonymous class already generated */;
                        }
                    } catch (ClassNotFoundException e8) {
                        e = e8;
                        w.e("MicroMsg.AdSnsInfoStorageLogic", bg.g(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (pSv != null) {
                            pSv = /* anonymous class already generated */;
                        }
                    }
                } catch (StreamCorruptedException e10) {
                    e = e10;
                    objectInputStream = null;
                    w.e("MicroMsg.AdSnsInfoStorageLogic", bg.g(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (pSv != null) {
                        pSv = /* anonymous class already generated */;
                    }
                } catch (IOException e11) {
                    e = e11;
                    objectInputStream = null;
                    w.e("MicroMsg.AdSnsInfoStorageLogic", bg.g(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (pSv != null) {
                        pSv = /* anonymous class already generated */;
                    }
                } catch (ClassNotFoundException e12) {
                    e = e12;
                    objectInputStream = null;
                    w.e("MicroMsg.AdSnsInfoStorageLogic", bg.g(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (pSv != null) {
                        pSv = /* anonymous class already generated */;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e;
                }
            }
            if (pSv != null) {
                pSv = /* anonymous class already generated */;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void di(long r4) {
        /*
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = pSv;
        if (r0 != 0) goto L_0x000e;
    L_0x000b:
        bdN();
    L_0x000e:
        r0 = pSv;
        r1 = java.lang.Long.valueOf(r4);
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r0.put(r1, r2);
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r0 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x003d }
        r0.<init>(r1);	 Catch:{ IOException -> 0x003d }
        r2 = pSv;	 Catch:{ IOException -> 0x003d }
        r0.writeObject(r2);	 Catch:{ IOException -> 0x003d }
        r0.flush();	 Catch:{ IOException -> 0x003d }
        r0 = r1.toByteArray();	 Catch:{ IOException -> 0x003d }
        r2 = pSu;	 Catch:{ IOException -> 0x003d }
        com.tencent.mm.pluginsdk.k.a.e.a.v(r2, r0);	 Catch:{ IOException -> 0x003d }
        r1.close();	 Catch:{ IOException -> 0x003b }
        goto L_0x0006;
    L_0x003b:
        r0 = move-exception;
        goto L_0x0006;
    L_0x003d:
        r0 = move-exception;
        r2 = "MicroMsg.AdSnsInfoStorageLogic";
        r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);	 Catch:{ all -> 0x004e }
        com.tencent.mm.sdk.platformtools.w.e(r2, r0);	 Catch:{ all -> 0x004e }
        r1.close();	 Catch:{ IOException -> 0x004c }
        goto L_0x0006;
    L_0x004c:
        r0 = move-exception;
        goto L_0x0006;
    L_0x004e:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0053 }
    L_0x0052:
        throw r0;
    L_0x0053:
        r1 = move-exception;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.a.di(long):void");
    }
}
