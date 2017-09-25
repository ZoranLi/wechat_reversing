package com.tencent.mm.ah;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class m {
    public static m hHh;
    ConcurrentHashMap<Long, d> hHf = new ConcurrentHashMap();
    public c hHg = new c();
    public ConcurrentHashMap<Long, e> hHi = new ConcurrentHashMap();
    private ArrayList<Long> hHj = new ArrayList();
    ArrayList<e> hHk = new ArrayList();

    public static class a {
        static ae fuJ;
        public ReentrantLock fuH = new ReentrantLock();
        public Condition fuI = this.fuH.newCondition();
        int hFc;
        a hHl;

        public static class a {
            String hFj;
            PString hHo;
            PString hHp;
            PString hHq;
            PString hHr;
        }

        public static a a(final e eVar) {
            synchronized (a.class) {
                if (fuJ == null) {
                    HandlerThread handlerThread = new HandlerThread("big file gen Worker");
                    handlerThread.start();
                    fuJ = new ae(handlerThread.getLooper());
                }
            }
            a aVar = new a();
            eVar.hHH = aVar;
            fuJ.post(new Runnable(eVar.hHH) {
                final /* synthetic */ a hHn;

                public final void run() {
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    a aVar = new a();
                    aVar.hHo = new PString();
                    aVar.hHp = new PString();
                    aVar.hHq = new PString();
                    aVar.hHr = new PString();
                    aVar.hFj = n.GS().a(eVar.hHy, FileOp.ko(eVar.hHy), eVar.hFc, true, aVar.hHo, aVar.hHp, aVar.hHq, aVar.hHr, eVar.hHA, eVar.hHF);
                    this.hHn.fuH.lock();
                    try {
                        this.hHn.hHl = aVar;
                        this.hHn.fuI.signal();
                        w.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", eVar.hHy, Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                    } finally {
                        this.hHn.fuH.unlock();
                    }
                }
            });
            aVar.hFc = eVar.hFc;
            return aVar;
        }

        public final a GL() {
            this.fuH.lock();
            while (this.hHl == null) {
                try {
                    w.i("MicroMsg.SendImgSpeeder", "getResult await");
                    this.fuI.await();
                } catch (Exception e) {
                } finally {
                    this.fuH.unlock();
                }
            }
            return this.hHl;
        }
    }

    private static class b {
        com.tencent.mm.a.b hHs;
        String hHt;
    }

    public static class c {
        public LinkedList<b> hHu = new LinkedList();
        public LinkedList<b> hHv = new LinkedList();

        public final synchronized void GM() {
            int i = 0;
            synchronized (this) {
                int size = this.hHu.size();
                if (size <= 0) {
                    int i2 = 5 - size;
                    for (size = 0; size < i2; size++) {
                        this.hHu.add(jz(null));
                    }
                    w.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", Integer.valueOf(i2), Integer.valueOf(this.hHu.size()));
                    GN();
                }
                size = this.hHv.size();
                if (size <= 0) {
                    size = 5 - size;
                    while (i < size) {
                        this.hHv.add(jA(null));
                        i++;
                    }
                    GO();
                    w.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", Integer.valueOf(size), Integer.valueOf(this.hHv.size()));
                }
            }
        }

        public static b jz(String str) {
            b bVar = new b();
            if (bg.mA(str)) {
                bVar.hHt = f.GE();
            } else {
                bVar.hHt = str;
            }
            String a = n.GS().a(bVar.hHt, "", ".jpg", false);
            if (!jB(a)) {
                return null;
            }
            bVar.hHs = new com.tencent.mm.a.b(a);
            return bVar;
        }

        public static b jA(String str) {
            b bVar = new b();
            if (bg.mA(str)) {
                bVar.hHt = f.GE();
            } else {
                bVar.hHt = str;
            }
            String a = n.GS().a("THUMBNAIL_DIRPATH://th_" + bVar.hHt, "th_", "", false);
            if (!jB(a)) {
                return null;
            }
            bVar.hHs = new com.tencent.mm.a.b(a);
            return bVar;
        }

        private static boolean jB(String str) {
            if (FileOp.ki(str) <= 0) {
                return true;
            }
            w.e("MicroMsg.SendImgSpeeder", "file has exist %s", str);
            return false;
        }

        public final synchronized b ga(int i) {
            b bVar = null;
            synchronized (this) {
                if (i == 1) {
                    if (this.hHu.size() > 0) {
                        bVar = (b) this.hHu.remove();
                        GN();
                    } else {
                        bVar = jz(null);
                    }
                } else if (i == 2) {
                    if (this.hHv.size() > 0) {
                        bVar = (b) this.hHv.remove();
                        GO();
                    } else {
                        bVar = jA(null);
                    }
                }
                GM();
            }
            return bVar;
        }

        private synchronized void GN() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.hHu.size(); i++) {
                stringBuilder.append(((b) this.hHu.get(i)).hHt);
                if (i != this.hHu.size() - 1) {
                    stringBuilder.append("-");
                }
            }
            w.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", stringBuilder.toString());
            h.vI().vr().set(348176, stringBuilder.toString());
        }

        private synchronized void GO() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.hHv.size(); i++) {
                stringBuilder.append(((b) this.hHv.get(i)).hHt);
                if (i != this.hHv.size() - 1) {
                    stringBuilder.append("-");
                }
            }
            w.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", stringBuilder.toString());
            h.vI().vr().set(348177, stringBuilder.toString());
        }
    }

    public static class d {
        public long hHw;
        public long hHx;
    }

    public static class e {
        int cGa;
        long fGM;
        int fNB;
        int hFc;
        String hHA;
        long hHB;
        PString hHC;
        PInt hHD;
        PInt hHE;
        com.tencent.mm.a.b hHF;
        com.tencent.mm.a.b hHG;
        a hHH;
        public String hHy;
        String hHz;
        public String toUserName;
    }

    public static m GJ() {
        if (hHh == null) {
            synchronized (m.class) {
                if (hHh == null) {
                    hHh = new m();
                }
            }
        }
        return hHh;
    }

    public final ArrayList<Integer> jx(String str) {
        Collection<e> values = this.hHi.values();
        for (e eVar : values) {
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            eVar.hHB = n.GS().a(eVar.hHy, eVar.hFc, eVar.cGa, eVar.fNB, pString, pInt, pInt2, eVar.hHz, eVar.hHA, eVar.fGM, eVar.hHF, eVar.hHG, eVar.hHH);
            au cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(eVar.fGM);
            if (bg.mA(cA.field_imgPath)) {
                cA.cI(pString.value);
                cA.dH(pInt.value);
                cA.dI(pInt2.value);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(eVar.fGM, cA);
            }
        }
        if (!bg.mA(str)) {
            for (e eVar2 : values) {
                if (!str.equals(eVar2.toUserName)) {
                    this.hHi.remove(Long.valueOf(eVar2.fGM));
                    this.hHj.remove(Long.valueOf(eVar2.fGM));
                    w.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", str, eVar2.toUserName);
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < this.hHj.size(); i++) {
            arrayList.add(Integer.valueOf((int) ((e) this.hHi.get(this.hHj.get(i))).hHB));
        }
        this.hHi.clear();
        this.hHj.clear();
        w.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public final boolean am(long j) {
        return this.hHf.containsKey(Long.valueOf(j));
    }

    public final d an(long j) {
        return (d) this.hHf.get(Long.valueOf(j));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<java.lang.String> r15, boolean r16, int r17, int r18, java.lang.String r19, int r20) {
        /*
        r14 = this;
        r2 = "MicroMsg.SendImgSpeeder";
        r3 = "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r15.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = java.lang.Boolean.valueOf(r16);
        r4[r5] = r6;
        r5 = 2;
        r6 = java.lang.Integer.valueOf(r17);
        r4[r5] = r6;
        r5 = 3;
        r4[r5] = r19;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r2 = r14.hHk;
        r3 = r2.iterator();
    L_0x002e:
        r2 = r3.hasNext();
        if (r2 == 0) goto L_0x0075;
    L_0x0034:
        r2 = r3.next();
        r2 = (com.tencent.mm.ah.m.e) r2;
        r4 = r2.hHy;
        r4 = r15.contains(r4);
        if (r4 == 0) goto L_0x0064;
    L_0x0042:
        r4 = r2.toUserName;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 != 0) goto L_0x0054;
    L_0x004a:
        r4 = r2.toUserName;
        r0 = r19;
        r4 = r4.equalsIgnoreCase(r0);
        if (r4 == 0) goto L_0x0064;
    L_0x0054:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r19);
        if (r4 != 0) goto L_0x0068;
    L_0x005a:
        r4 = r2.toUserName;
        r0 = r19;
        r4 = r0.equalsIgnoreCase(r4);
        if (r4 != 0) goto L_0x0068;
    L_0x0064:
        r3.remove();
        goto L_0x002e;
    L_0x0068:
        r4 = r2.hHy;
        r0 = r19;
        r1 = r16;
        r4 = b(r4, r0, r1);
        r2.hFc = r4;
        goto L_0x002e;
    L_0x0075:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2 = r15.size();
        r4 = 9;
        if (r2 != r4) goto L_0x00b2;
    L_0x0082:
        r2 = 18;
        com.tencent.mm.plugin.report.service.f.rY(r2);
    L_0x0087:
        r4 = r15.iterator();
    L_0x008b:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x0117;
    L_0x0091:
        r2 = r4.next();
        r2 = (java.lang.String) r2;
        if (r2 == 0) goto L_0x00a8;
    L_0x0099:
        r5 = "";
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x00a8;
    L_0x00a2:
        r5 = com.tencent.mm.a.e.aO(r2);
        if (r5 != 0) goto L_0x00eb;
    L_0x00a8:
        r2 = "MicroMsg.SendImgSpeeder";
        r5 = " doSendImage : filePath is null or empty";
        com.tencent.mm.sdk.platformtools.w.d(r2, r5);
        goto L_0x008b;
    L_0x00b2:
        r2 = r15.size();
        r4 = 1;
        if (r2 != r4) goto L_0x00e5;
    L_0x00b9:
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r2 = com.tencent.mm.sdk.platformtools.am.isWifi(r2);
        r4 = 25;
        com.tencent.mm.plugin.report.service.f.rY(r4);
        if (r2 == 0) goto L_0x0087;
    L_0x00c8:
        r2 = 0;
        r2 = r15.get(r2);
        r2 = (java.lang.String) r2;
        r0 = r19;
        r1 = r16;
        r2 = com.tencent.mm.u.m.a(r2, r0, r1);
        if (r2 == 0) goto L_0x00df;
    L_0x00d9:
        r2 = 23;
        com.tencent.mm.plugin.report.service.f.rY(r2);
        goto L_0x0087;
    L_0x00df:
        r2 = 21;
        com.tencent.mm.plugin.report.service.f.rY(r2);
        goto L_0x0087;
    L_0x00e5:
        r2 = 24;
        com.tencent.mm.plugin.report.service.f.rY(r2);
        goto L_0x0087;
    L_0x00eb:
        r5 = com.tencent.mm.sdk.platformtools.o.Pj(r2);
        if (r5 == 0) goto L_0x010c;
    L_0x00f1:
        r5 = "MicroMsg.SendImgSpeeder";
        r6 = "[cpan] is gif coutinue. did not add filePath:%s filesize:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r2;
        r8 = 1;
        r2 = com.tencent.mm.a.e.aN(r2);
        r2 = java.lang.Integer.valueOf(r2);
        r7[r8] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);
        goto L_0x008b;
    L_0x010c:
        r5 = r14.jy(r2);
        if (r5 != 0) goto L_0x008b;
    L_0x0112:
        r3.add(r2);
        goto L_0x008b;
    L_0x0117:
        r9 = r3.iterator();
    L_0x011b:
        r2 = r9.hasNext();
        if (r2 == 0) goto L_0x0136;
    L_0x0121:
        r5 = r9.next();
        r5 = (java.lang.String) r5;
        r2 = r14;
        r3 = r17;
        r4 = r18;
        r6 = r19;
        r7 = r16;
        r8 = r20;
        r2.a(r3, r4, r5, r6, r7, r8);
        goto L_0x011b;
    L_0x0136:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r2 = com.tencent.mm.kernel.h.vI();
        r2 = r2.gYg;
        r3 = java.lang.Thread.currentThread();
        r4 = r3.getId();
        r8 = r2.cs(r4);
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.aJX();
        r3 = "SendImgSpeeder";
        r2.Ae(r3);
        r3 = 1;
        r2 = 0;
        r5 = r2;
    L_0x0162:
        r2 = r14.hHk;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x0219;
    L_0x016a:
        r2 = r14.hHk;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.ah.m.e) r2;
        r4 = r2.hHy;
        r4 = com.tencent.mm.sdk.platformtools.o.Pj(r4);
        if (r4 == 0) goto L_0x0189;
    L_0x017a:
        r2 = "MicroMsg.SendImgSpeeder";
        r4 = "[cpan] is gif coutinue. did not add to msg table";
        com.tencent.mm.sdk.platformtools.w.i(r2, r4);
        r2 = r3;
    L_0x0184:
        r3 = r5 + 1;
        r5 = r3;
        r3 = r2;
        goto L_0x0162;
    L_0x0189:
        r4 = 0;
        r7 = new com.tencent.mm.storage.au;
        r7.<init>();
        r3 = com.tencent.mm.u.o.fH(r19);
        r7.setType(r3);
        r0 = r19;
        r7.cH(r0);
        r3 = 1;
        r7.dw(r3);
        r3 = 1;
        r7.dv(r3);
        r3 = r2.hHC;
        r3 = r3.value;
        r7.cI(r3);
        r3 = r2.hHD;
        r3 = r3.value;
        r7.dH(r3);
        r3 = r2.hHE;
        r3 = r3.value;
        r7.dI(r3);
        r3 = com.tencent.mm.u.ba.zz();
        if (r3 == 0) goto L_0x01c6;
    L_0x01be:
        r10 = r7.gxF;
        r10 = r3.equals(r10);
        if (r10 == 0) goto L_0x01cc;
    L_0x01c6:
        if (r3 != 0) goto L_0x01cf;
    L_0x01c8:
        r10 = r7.gxF;
        if (r10 == 0) goto L_0x01cf;
    L_0x01cc:
        r7.cN(r3);
    L_0x01cf:
        r3 = com.tencent.mm.h.a.a.qB();
        r3.b(r7);
        r3 = r7.field_talker;
        r10 = com.tencent.mm.u.ay.gk(r3);
        r7.z(r10);
        r6.add(r7);
        r3 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r3 = com.tencent.mm.kernel.h.h(r3);
        r3 = (com.tencent.mm.plugin.messenger.foundation.a.h) r3;
        r3 = r3.aJX();
        r10 = r3.L(r7);
        r12 = 0;
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x0217;
    L_0x01f8:
        r3 = 1;
    L_0x01f9:
        junit.framework.Assert.assertTrue(r3);
        r2.fGM = r10;
        r3 = r14.hHi;
        r10 = r2.fGM;
        r7 = java.lang.Long.valueOf(r10);
        r3.put(r7, r2);
        r3 = r14.hHj;
        r10 = r2.fGM;
        r2 = java.lang.Long.valueOf(r10);
        r3.add(r2);
        r2 = r4;
        goto L_0x0184;
    L_0x0217:
        r3 = 0;
        goto L_0x01f9;
    L_0x0219:
        r2 = r14.hHk;
        r2.clear();
        r4 = 0;
        r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x022d;
    L_0x0224:
        r2 = com.tencent.mm.kernel.h.vI();
        r2 = r2.gYg;
        r2.aD(r8);
    L_0x022d:
        if (r3 == 0) goto L_0x0241;
    L_0x022f:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.h.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.aJX();
        r3 = "SendImgSpeeder";
        r2.Af(r3);
    L_0x0241:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ah.m.a(java.util.ArrayList, boolean, int, int, java.lang.String, int):void");
    }

    private boolean jy(String str) {
        Iterator it = this.hHk.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).hHy.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean GK() {
        if (this.hHk.size() <= 0 || com.tencent.mm.plugin.report.service.f.a.aXJ().oUd > 2) {
            return true;
        }
        w.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
        return false;
    }

    public final void a(int i, int i2, String str, String str2, boolean z, int i3) {
        if (!jy(str)) {
            com.tencent.mm.a.b bVar;
            com.tencent.mm.a.b bVar2;
            String str3;
            String str4;
            int b = b(str, str2, z);
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            if (GK()) {
                b ga = this.hHg.ga(1);
                b ga2 = this.hHg.ga(2);
                com.tencent.mm.a.b bVar3 = ga.hHs;
                bVar = ga2.hHs;
                bVar2 = bVar3;
                str3 = ga2.hHt;
                str4 = ga.hHt;
            } else {
                bVar = null;
                bVar2 = null;
                str3 = null;
                str4 = null;
            }
            f GS = n.GS();
            if (FileOp.aO(str)) {
                String str5 = "THUMBNAIL_DIRPATH://th_" + (bg.mA(str3) ? f.GE() : str3);
                String a = GS.a(str5, "th_", "", false);
                pString.value = str5;
                long NA = bg.NA();
                Bitmap a2 = GS.a(str, b, i2, pInt, pInt2, false, null, null);
                str5 = (String) GS.hFG.get(str);
                Object obj = str5 != null ? (Bitmap) GS.hFF.get(str5) : null;
                if (obj == null || obj.isRecycled()) {
                    obj = GS.a(str, true, com.tencent.mm.bg.a.getDensity(ab.getContext()), false, false, true, i3, true, a2);
                    GS.hFG.put(str, a);
                }
                if (obj != null) {
                    GS.hFF.k(a, obj);
                }
                w.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", Long.valueOf(bg.aB(NA)));
            } else {
                w.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
            }
            e eVar = new e();
            eVar.hHy = str;
            eVar.hFc = b;
            eVar.cGa = i;
            eVar.fNB = i2;
            eVar.hHz = str3;
            eVar.hHC = pString;
            eVar.hHE = pInt2;
            eVar.hHD = pInt;
            eVar.hHA = str4;
            eVar.hHG = bVar;
            eVar.hHF = bVar2;
            if (hHh.GK()) {
                a.a(eVar);
            }
            eVar.toUserName = str2;
            this.hHk.add(eVar);
            w.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", str, str2);
        }
    }

    private static int b(String str, String str2, boolean z) {
        return com.tencent.mm.u.m.a(str, str2, z) ? 1 : 0;
    }
}
