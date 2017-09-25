package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class al {

    public static class a implements g, e {
        public static int pXb = -1;
        Map<com.tencent.mm.plugin.sns.b.g.a, String> htd = new HashMap();
        private Map<String, Long> pXc = new HashMap();
        private Map<String, Integer> pXd = new HashMap();
        private int pXe = 0;
        public long pXf = 0;
        private LinkedList<String> pXg = new LinkedList();
        public Map<String, ArrayList<b>> pXh = new HashMap();
        public Map<String, Integer> pXi = new HashMap();

        public final void f(String str, ArrayList<b> arrayList) {
            this.pXh.put(str, arrayList);
        }

        public final Intent f(Intent intent, String str) {
            intent.putExtra("sns_userName", str);
            if (this.pXg != null && this.pXg.contains(str)) {
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
            }
            return intent;
        }

        public final void a(int i, String str, com.tencent.mm.plugin.sns.b.g.a aVar) {
            w.i("MicroMsg.SnsService", "startServer " + i + " " + aVar);
            ae.beK().gKJ = m.xL();
            ae.beK().bem();
            ae.beH().bdz();
            if (this.htd.isEmpty()) {
                h.vJ();
                h.vH().gXC.a(com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX, this);
                h.vJ();
                h.vH().gXC.a(com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, this);
            }
            if (!this.htd.containsKey(aVar)) {
                if (i == 1) {
                    this.htd.put(aVar, "@__weixintimtline");
                } else if (i == 2 || i == 3) {
                    this.htd.put(aVar, str);
                } else if (i == 4) {
                    this.htd.put(aVar, "@__classify_timeline");
                } else if (i == 5) {
                    this.htd.put(aVar, "");
                } else {
                    this.htd.put(aVar, "");
                }
            }
            switch (i) {
                case 1:
                    this.pXf = 0;
                    this.pXe = bfj();
                    x.Fc("@__weixintimtline");
                    return;
                case 2:
                    synchronized (this.pXc) {
                        this.pXc.put(str, Long.valueOf(0));
                    }
                    synchronized (this.pXd) {
                        if (!this.pXd.containsKey(str)) {
                            this.pXd.put(str, Integer.valueOf(bfj()));
                        }
                    }
                    z.Ff(str);
                    this.pXg.add(str);
                    return;
                default:
                    return;
            }
        }

        public final boolean a(com.tencent.mm.plugin.sns.b.g.a aVar, int i) {
            w.d("MicroMsg.SnsService", "closeServer");
            this.htd.remove(aVar);
            if (i == 2 && this.pXg.size() > 0) {
                this.pXg.removeLast();
            }
            if (this.htd.isEmpty()) {
                h.vJ();
                h.vH().gXC.b(com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX, this);
                h.vJ();
                h.vH().gXC.b(com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, this);
                am.release();
                com.tencent.mm.plugin.sns.storage.m.release();
                new ae(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ a pXj;

                    {
                        this.pXj = r1;
                    }

                    public final void run() {
                        a aVar = this.pXj;
                        if (!ae.beu() && aVar.htd.isEmpty()) {
                            ae.beI().bea();
                            w.d("MicroMsg.SnsService", "clean sns cache");
                        }
                    }
                }, 5000);
                ai.bfd();
                w.i("MicroMsg.SnsService", "close finish");
            }
            return true;
        }

        public final void b(int i, String str, boolean z, int i2) {
            if (!r.iiD) {
                w.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[]{str, Integer.valueOf(i), Long.valueOf(this.pXf), this.pXc});
                if (i == 2) {
                    if (z.Fe(str)) {
                        long j = 0;
                        synchronized (this.pXc) {
                            if (this.pXc.containsKey(str)) {
                                j = ((Long) this.pXc.get(str)).longValue();
                            }
                        }
                        if (j == 0) {
                            x.Fc(str);
                            return;
                        }
                        h.vJ();
                        h.vH().gXC.a(new z(str, j, z, i2), 0);
                    }
                } else if (i == 1) {
                    if (!x.Fb("@__weixintimtline")) {
                        return;
                    }
                    if (this.pXf == 0) {
                        x.Fc("@__weixintimtline");
                        return;
                    }
                    h.vJ();
                    h.vH().gXC.a(new x(this.pXf), 0);
                } else if (i == 3 || i != 4 || !m.Fb("@__classify_timeline")) {
                } else {
                    if (this.pXf == 0) {
                        m.Fc("@__classify_timeline");
                        return;
                    }
                    h.vJ();
                    h.vH().gXC.a(new m(""), 0);
                }
            }
        }

        public final void a(int i, String str, boolean z, int i2) {
            if (!r.iiD) {
                w.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[]{Integer.valueOf(i), str});
                if (i == 2) {
                    if (z.Fe(str)) {
                        h.vJ();
                        h.vH().gXC.a(new z(str, 0, z, i2), 0);
                    }
                } else if (i == 1) {
                    if (x.Fb("@__weixintimtline")) {
                        h.vJ();
                        h.vI().vr().set(68377, "");
                        h.vJ();
                        h.vH().gXC.a(new x(0), 0);
                    }
                } else if (i != 3 && i == 4 && m.Fb("@__classify_timeline")) {
                    h.vJ();
                    h.vH().gXC.a(new m(""), 0);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int Fo(java.lang.String r3) {
            /*
            r2 = this;
            r1 = r2.pXd;
            monitor-enter(r1);
            r0 = r2.pXd;	 Catch:{ all -> 0x0026 }
            r0 = r0.containsKey(r3);	 Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0020;
        L_0x000b:
            r0 = r2.pXd;	 Catch:{ all -> 0x0026 }
            r0 = r0.get(r3);	 Catch:{ all -> 0x0026 }
            r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0026 }
            r0 = r0.intValue();	 Catch:{ all -> 0x0026 }
            if (r0 <= 0) goto L_0x001b;
        L_0x0019:
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        L_0x001a:
            return r0;
        L_0x001b:
            r0 = com.tencent.mm.plugin.sns.data.i.bdB();	 Catch:{ all -> 0x0026 }
            goto L_0x0019;
        L_0x0020:
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
            r0 = com.tencent.mm.plugin.sns.data.i.bdB();
            goto L_0x001a;
        L_0x0026:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.al.a.Fo(java.lang.String):int");
        }

        public final int bfj() {
            return this.pXe > 0 ? this.pXe : i.bdB();
        }

        public final void w(long j, int i) {
            w.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[]{Long.valueOf(j)});
            if (i > 0) {
                this.pXe = i;
                i.sR(i);
            }
            if (j != 0) {
                this.pXf = j;
            }
        }

        public static int bfk() {
            if (pXb != -1) {
                return pXb;
            }
            int bdA = i.bdA();
            pXb = bdA;
            return bdA;
        }

        public final void a(int i, int i2, String str, k kVar) {
            Object obj;
            x xVar;
            int i3;
            z zVar;
            String str2;
            long j;
            d dVar;
            Iterator it;
            com.tencent.mm.plugin.sns.b.g.a aVar;
            String str3;
            String dg;
            boolean bdT;
            boolean bdV;
            boolean z;
            boolean bdU;
            w.i("MicroMsg.SnsService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
            if (!((i == 4 && i2 == 207) || (i == 4 && i2 == aq.CTRL_INDEX))) {
                if (i == 4 && (i2 == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN || i2 == 2004)) {
                    obj = 1;
                    if (obj != null) {
                        switch (kVar.getType()) {
                            case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                                xVar = (x) kVar;
                                w(xVar.pTP, xVar.pTR);
                                i3 = xVar.pTS;
                                if (pXb != i3) {
                                    i.sQ(i3);
                                }
                                pXb = i3;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                zVar = (z) kVar;
                                str2 = zVar.userName;
                                j = zVar.pTP;
                                i3 = zVar.pTR;
                                if (i3 > 0) {
                                    synchronized (this.pXd) {
                                        this.pXd.put(str2, Integer.valueOf(i3));
                                    }
                                }
                                if (j != 0) {
                                    synchronized (this.pXc) {
                                        this.pXc.put(str2, Long.valueOf(j));
                                    }
                                    break;
                                }
                                break;
                        }
                        if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                        }
                        dVar = (d) kVar;
                        it = new ArrayList(this.htd.keySet()).iterator();
                        while (it.hasNext()) {
                            aVar = (com.tencent.mm.plugin.sns.b.g.a) it.next();
                            if (!this.htd.containsKey(aVar)) {
                                str3 = (String) this.htd.get(aVar);
                                if (!dVar.getUserName().equals(str3)) {
                                    w.d("MicroMsg.SnsService", "notify ui " + str3);
                                    if (dVar.bdW() != 0) {
                                    }
                                    if (dVar.bdS()) {
                                        bdT = dVar.bdT();
                                        bdV = dVar.bdV();
                                        if (i != 4) {
                                        }
                                        aVar.a(bdT, dg, bdV, z, i2, dVar.bdY());
                                    } else {
                                        bdU = dVar.bdU();
                                        bdT = dVar.bdT();
                                        bdV = dVar.bdX();
                                        if (i != 4) {
                                        }
                                        aVar.a(bdU, bdT, dg, bdV, z, i2, dVar.bdY());
                                    }
                                }
                            }
                        }
                    }
                } else if (i == 4 && (i2 == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN || i2 == MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK)) {
                    obj = 1;
                    if (obj != null) {
                        switch (kVar.getType()) {
                            case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                                xVar = (x) kVar;
                                w(xVar.pTP, xVar.pTR);
                                i3 = xVar.pTS;
                                if (pXb != i3) {
                                    i.sQ(i3);
                                }
                                pXb = i3;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                zVar = (z) kVar;
                                str2 = zVar.userName;
                                j = zVar.pTP;
                                i3 = zVar.pTR;
                                if (i3 > 0) {
                                    synchronized (this.pXd) {
                                        this.pXd.put(str2, Integer.valueOf(i3));
                                    }
                                }
                                if (j != 0) {
                                    synchronized (this.pXc) {
                                        this.pXc.put(str2, Long.valueOf(j));
                                    }
                                    break;
                                }
                                break;
                        }
                        if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                        }
                        dVar = (d) kVar;
                        it = new ArrayList(this.htd.keySet()).iterator();
                        while (it.hasNext()) {
                            aVar = (com.tencent.mm.plugin.sns.b.g.a) it.next();
                            if (!this.htd.containsKey(aVar)) {
                                str3 = (String) this.htd.get(aVar);
                                if (!dVar.getUserName().equals(str3)) {
                                    w.d("MicroMsg.SnsService", "notify ui " + str3);
                                    if (dVar.bdW() != 0) {
                                    }
                                    if (dVar.bdS()) {
                                        bdT = dVar.bdT();
                                        bdV = dVar.bdV();
                                        if (i != 4) {
                                        }
                                        aVar.a(bdT, dg, bdV, z, i2, dVar.bdY());
                                    } else {
                                        bdU = dVar.bdU();
                                        bdT = dVar.bdT();
                                        bdV = dVar.bdX();
                                        if (i != 4) {
                                        }
                                        aVar.a(bdU, bdT, dg, bdV, z, i2, dVar.bdY());
                                    }
                                }
                            }
                        }
                    }
                } else if (!(i == 0 && i2 == 0)) {
                    obj = null;
                    if (obj != null) {
                        switch (kVar.getType()) {
                            case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                                xVar = (x) kVar;
                                w(xVar.pTP, xVar.pTR);
                                i3 = xVar.pTS;
                                if (pXb != i3) {
                                    i.sQ(i3);
                                }
                                pXb = i3;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                zVar = (z) kVar;
                                str2 = zVar.userName;
                                j = zVar.pTP;
                                i3 = zVar.pTR;
                                if (i3 > 0) {
                                    synchronized (this.pXd) {
                                        this.pXd.put(str2, Integer.valueOf(i3));
                                    }
                                }
                                if (j != 0) {
                                    synchronized (this.pXc) {
                                        this.pXc.put(str2, Long.valueOf(j));
                                    }
                                    break;
                                }
                                break;
                        }
                        if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX || kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX) {
                            dVar = (d) kVar;
                            it = new ArrayList(this.htd.keySet()).iterator();
                            while (it.hasNext()) {
                                aVar = (com.tencent.mm.plugin.sns.b.g.a) it.next();
                                if (!this.htd.containsKey(aVar)) {
                                    str3 = (String) this.htd.get(aVar);
                                    if (!dVar.getUserName().equals(str3)) {
                                        w.d("MicroMsg.SnsService", "notify ui " + str3);
                                        dg = dVar.bdW() != 0 ? "" : i.dg(dVar.bdW());
                                        if (dVar.bdS()) {
                                            bdU = dVar.bdU();
                                            bdT = dVar.bdT();
                                            bdV = dVar.bdX();
                                            z = i != 4 && (i2 == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN || i2 == 2004 || i2 == MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK);
                                            aVar.a(bdU, bdT, dg, bdV, z, i2, dVar.bdY());
                                        } else {
                                            bdT = dVar.bdT();
                                            bdV = dVar.bdV();
                                            z = i != 4 && (i2 == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN || i2 == 2004 || i2 == MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK);
                                            aVar.a(bdT, dg, bdV, z, i2, dVar.bdY());
                                        }
                                    }
                                }
                            }
                        }
                        return;
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                switch (kVar.getType()) {
                    case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                        xVar = (x) kVar;
                        w(xVar.pTP, xVar.pTR);
                        i3 = xVar.pTS;
                        if (pXb != i3) {
                            i.sQ(i3);
                        }
                        pXb = i3;
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                        zVar = (z) kVar;
                        str2 = zVar.userName;
                        j = zVar.pTP;
                        i3 = zVar.pTR;
                        if (i3 > 0) {
                            synchronized (this.pXd) {
                                this.pXd.put(str2, Integer.valueOf(i3));
                            }
                        }
                        if (j != 0) {
                            synchronized (this.pXc) {
                                this.pXc.put(str2, Long.valueOf(j));
                            }
                            break;
                        }
                        break;
                }
                if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                }
                dVar = (d) kVar;
                it = new ArrayList(this.htd.keySet()).iterator();
                while (it.hasNext()) {
                    aVar = (com.tencent.mm.plugin.sns.b.g.a) it.next();
                    if (!this.htd.containsKey(aVar)) {
                        str3 = (String) this.htd.get(aVar);
                        if (!dVar.getUserName().equals(str3)) {
                            w.d("MicroMsg.SnsService", "notify ui " + str3);
                            if (dVar.bdW() != 0) {
                            }
                            if (dVar.bdS()) {
                                bdT = dVar.bdT();
                                bdV = dVar.bdV();
                                if (i != 4) {
                                }
                                aVar.a(bdT, dg, bdV, z, i2, dVar.bdY());
                            } else {
                                bdU = dVar.bdU();
                                bdT = dVar.bdT();
                                bdV = dVar.bdX();
                                if (i != 4) {
                                }
                                aVar.a(bdU, bdT, dg, bdV, z, i2, dVar.bdY());
                            }
                        }
                    }
                }
            }
        }

        public static void Fp(String str) {
            ac beK = ae.beK();
            if (bg.mA(beK.gKJ)) {
                beK.gKJ = m.xL();
            }
            String str2 = beK.gKJ;
            com.tencent.mm.plugin.sns.storage.m Gf = com.tencent.mm.plugin.sns.storage.h.Gf(str);
            try {
                bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(Gf.field_attrBuf);
                Iterator it = com_tencent_mm_protocal_c_bbk.ucn.iterator();
                while (it.hasNext()) {
                    bba com_tencent_mm_protocal_c_bba = (bba) it.next();
                    if (com_tencent_mm_protocal_c_bba.tgG.equals(str2)) {
                        com_tencent_mm_protocal_c_bbk.ucn.remove(com_tencent_mm_protocal_c_bba);
                        com_tencent_mm_protocal_c_bbk.ucl--;
                        Gf.field_attrBuf = com_tencent_mm_protocal_c_bbk.toByteArray();
                        if (Gf.tE(32)) {
                            ae.beN().a(Gf.bhJ());
                        } else {
                            ae.beL().z(Gf);
                        }
                        if (!ae.beK().du(u.GA(str))) {
                            if (Gf.tE(32)) {
                                h.vJ();
                                h.vH().gXC.a(new q(u.GA(str), 5), 0);
                                return;
                            }
                            com.tencent.mm.plugin.sns.storage.a bhc = Gf.bhc();
                            String str3 = bhc != null ? "" : bhc.iHN;
                            com.tencent.mm.plugin.report.service.g.oUh.i(11855, new Object[]{Integer.valueOf(0), str3});
                            h.vJ();
                            h.vH().gXC.a(new q(u.GA(str), 7), 0);
                        }
                        return;
                    }
                }
            } catch (Exception e) {
            }
            if (!ae.beK().du(u.GA(str))) {
                return;
            }
            if (Gf.tE(32)) {
                h.vJ();
                h.vH().gXC.a(new q(u.GA(str), 5), 0);
                return;
            }
            com.tencent.mm.plugin.sns.storage.a bhc2 = Gf.bhc();
            if (bhc2 != null) {
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(11855, new Object[]{Integer.valueOf(0), str3});
            h.vJ();
            h.vH().gXC.a(new q(u.GA(str), 7), 0);
        }

        public static bba a(com.tencent.mm.plugin.sns.storage.m mVar, int i, String str) {
            return a(mVar, i, str, null, false, 0, 0);
        }

        public static bba a(com.tencent.mm.plugin.sns.storage.m mVar, int i, String str, bba com_tencent_mm_protocal_c_bba, int i2) {
            return a(mVar, i, str, com_tencent_mm_protocal_c_bba, false, i2);
        }

        public static bba a(com.tencent.mm.plugin.sns.storage.m mVar, int i, String str, bba com_tencent_mm_protocal_c_bba, boolean z, int i2) {
            return a(mVar, i, str, com_tencent_mm_protocal_c_bba, z, 0, i2);
        }

        private static bba a(com.tencent.mm.plugin.sns.storage.m mVar, int i, String str, bba com_tencent_mm_protocal_c_bba, boolean z, int i2, int i3) {
            String str2;
            bau com_tencent_mm_protocal_c_bau = new bau();
            com_tencent_mm_protocal_c_bau.opI = str;
            com_tencent_mm_protocal_c_bau.ogM = (int) (bg.Nz() / 1000);
            com_tencent_mm_protocal_c_bau.ubH = m.xN();
            com_tencent_mm_protocal_c_bau.tWt = m.xL();
            com_tencent_mm_protocal_c_bau.tfW = 0;
            com_tencent_mm_protocal_c_bau.ubI = ((com.tencent.mm.plugin.messenger.a.a) h.h(com.tencent.mm.plugin.messenger.a.a.class)).eK(mVar.field_userName);
            com_tencent_mm_protocal_c_bau.tvK = mVar.field_userName;
            com_tencent_mm_protocal_c_bau.jOc = i;
            com_tencent_mm_protocal_c_bau.ubP = i3;
            if (mVar.tE(32)) {
                com_tencent_mm_protocal_c_bau.ubM = com_tencent_mm_protocal_c_bba == null ? 0 : com_tencent_mm_protocal_c_bba.ubN;
            } else {
                com_tencent_mm_protocal_c_bau.ubJ = com_tencent_mm_protocal_c_bba == null ? 0 : com_tencent_mm_protocal_c_bba.ubK;
            }
            bau com_tencent_mm_protocal_c_bau2 = new bau();
            com_tencent_mm_protocal_c_bau2.tWt = com_tencent_mm_protocal_c_bba == null ? "" : com_tencent_mm_protocal_c_bba.tgG;
            bav com_tencent_mm_protocal_c_bav = new bav();
            com_tencent_mm_protocal_c_bav.tmx = mVar.field_snsId;
            com_tencent_mm_protocal_c_bav.ubR = com_tencent_mm_protocal_c_bau;
            com_tencent_mm_protocal_c_bav.ubS = com_tencent_mm_protocal_c_bau2;
            String str3 = "";
            if (mVar.tE(32)) {
                Object obj;
                com.tencent.mm.plugin.sns.storage.a bhc = mVar.bhc();
                if (bhc == null) {
                    obj = "";
                } else {
                    str2 = bhc.iHN;
                }
                str3 = bhc == null ? "" : bhc.pZI;
                if (com_tencent_mm_protocal_c_bau.jOc == 7) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11855, new Object[]{Integer.valueOf(1), obj});
                } else if (com_tencent_mm_protocal_c_bau.jOc == 8) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11855, new Object[]{Integer.valueOf(2), obj});
                }
                com.tencent.mm.plugin.sns.storage.e bhJ = mVar.bhJ();
                if (bhJ != null && bhJ.field_firstControlTime == 0) {
                    bhJ.field_firstControlTime = com_tencent_mm_protocal_c_bau.ogM;
                    ae.beN().b(bhJ.field_snsId, bhJ);
                }
            }
            str2 = com.tencent.mm.a.g.n((bg.NA()).getBytes());
            if (mVar.tE(32)) {
                str2 = "_AD_TAG_" + str2;
            }
            if (!ae.beK().a(str2, com_tencent_mm_protocal_c_bav)) {
                w.e("MicroMsg.SnsService", "can not add Comment");
            } else if (ac.Fg(str2)) {
                h.vJ();
                h.vH().gXC.a(new j(com_tencent_mm_protocal_c_bav, str2, str3), 0);
            } else {
                h.vJ();
                h.vH().gXC.a(new n(com_tencent_mm_protocal_c_bav, str2), 0);
            }
            if (!z) {
                return null;
            }
            bba com_tencent_mm_protocal_c_bba2 = new bba();
            com_tencent_mm_protocal_c_bba2.ogM = com_tencent_mm_protocal_c_bau.ogM;
            com_tencent_mm_protocal_c_bba2.jOc = com_tencent_mm_protocal_c_bau.jOc;
            com_tencent_mm_protocal_c_bba2.tfW = com_tencent_mm_protocal_c_bau.tfW;
            com_tencent_mm_protocal_c_bba2.tgG = com_tencent_mm_protocal_c_bau.tWt;
            com_tencent_mm_protocal_c_bba2.tNz = com_tencent_mm_protocal_c_bau.ubH;
            com_tencent_mm_protocal_c_bba2.opI = com_tencent_mm_protocal_c_bau.opI;
            com_tencent_mm_protocal_c_bba2.ubP = com_tencent_mm_protocal_c_bau.ubP;
            if (mVar.tE(32)) {
                com_tencent_mm_protocal_c_bba2.ubM = com_tencent_mm_protocal_c_bba == null ? 0 : com_tencent_mm_protocal_c_bba.ubN;
            } else {
                com_tencent_mm_protocal_c_bba2.ubJ = com_tencent_mm_protocal_c_bba == null ? 0 : com_tencent_mm_protocal_c_bba.ubK;
            }
            com_tencent_mm_protocal_c_bba2.uce = com_tencent_mm_protocal_c_bba == null ? "" : com_tencent_mm_protocal_c_bba.tgG;
            return com_tencent_mm_protocal_c_bba2;
        }

        public static bba a(com.tencent.mm.plugin.sns.storage.m mVar, int i, String str, String str2, int i2) {
            String str3;
            bau com_tencent_mm_protocal_c_bau = new bau();
            com_tencent_mm_protocal_c_bau.opI = str;
            com_tencent_mm_protocal_c_bau.ogM = (int) (bg.Nz() / 1000);
            com_tencent_mm_protocal_c_bau.ubH = m.xN();
            com_tencent_mm_protocal_c_bau.tWt = m.xL();
            com_tencent_mm_protocal_c_bau.tfW = i2;
            com_tencent_mm_protocal_c_bau.ubI = ((com.tencent.mm.plugin.messenger.a.a) h.h(com.tencent.mm.plugin.messenger.a.a.class)).eK(mVar.field_userName);
            com_tencent_mm_protocal_c_bau.tvK = mVar.field_userName;
            com_tencent_mm_protocal_c_bau.jOc = i;
            if (mVar.tE(32)) {
                com_tencent_mm_protocal_c_bau.ubM = 0;
            } else {
                com_tencent_mm_protocal_c_bau.ubJ = 0;
            }
            bau com_tencent_mm_protocal_c_bau2 = new bau();
            com_tencent_mm_protocal_c_bau2.tWt = str2;
            bav com_tencent_mm_protocal_c_bav = new bav();
            com_tencent_mm_protocal_c_bav.tmx = mVar.field_snsId;
            com_tencent_mm_protocal_c_bav.ubR = com_tencent_mm_protocal_c_bau;
            com_tencent_mm_protocal_c_bav.ubS = com_tencent_mm_protocal_c_bau2;
            String str4 = "";
            if (mVar.tE(32)) {
                Object obj;
                com.tencent.mm.plugin.sns.storage.a bhc = mVar.bhc();
                if (bhc == null) {
                    obj = "";
                } else {
                    str3 = bhc.iHN;
                }
                str4 = bhc == null ? "" : bhc.pZI;
                if (com_tencent_mm_protocal_c_bau.jOc == 7) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11855, new Object[]{Integer.valueOf(1), obj});
                } else if (com_tencent_mm_protocal_c_bau.jOc == 8) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11855, new Object[]{Integer.valueOf(2), obj});
                }
            }
            str3 = com.tencent.mm.a.g.n((bg.NA()).getBytes());
            if (mVar.tE(32)) {
                str3 = "_AD_TAG_" + str3;
            }
            if (!ae.beK().a(str3, com_tencent_mm_protocal_c_bav, str4)) {
                w.e("MicroMsg.SnsService", "can not add Comment");
            } else if (ac.Fg(str3)) {
                h.vJ();
                h.vH().gXC.a(new j(com_tencent_mm_protocal_c_bav, str3, str4), 0);
            } else {
                h.vJ();
                h.vH().gXC.a(new n(com_tencent_mm_protocal_c_bav, str3), 0);
            }
            return null;
        }

        public static void a(String str, int i, String str2, com.tencent.mm.plugin.sns.storage.m mVar, int i2) {
            if (i == 3 || i == 5) {
                bau com_tencent_mm_protocal_c_bau = new bau();
                com_tencent_mm_protocal_c_bau.opI = str2;
                com_tencent_mm_protocal_c_bau.ogM = (int) (System.currentTimeMillis() / 1000);
                com_tencent_mm_protocal_c_bau.ubH = m.xN();
                com_tencent_mm_protocal_c_bau.tWt = m.xL();
                com_tencent_mm_protocal_c_bau.tfW = i2;
                com_tencent_mm_protocal_c_bau.ubI = ((com.tencent.mm.plugin.messenger.a.a) h.h(com.tencent.mm.plugin.messenger.a.a.class)).eK(str);
                com_tencent_mm_protocal_c_bau.tvK = str;
                com_tencent_mm_protocal_c_bau.jOc = i;
                bav com_tencent_mm_protocal_c_bav = new bav();
                com_tencent_mm_protocal_c_bav.tmx = mVar.field_snsId;
                com_tencent_mm_protocal_c_bav.ubR = com_tencent_mm_protocal_c_bau;
                com_tencent_mm_protocal_c_bav.ubS = new bau();
                String n = com.tencent.mm.a.g.n((bg.NA()).getBytes());
                long j = mVar.field_snsId;
                try {
                    w.v("MicroMsg.SnsService", "comment stg inserted");
                    c iVar = new com.tencent.mm.plugin.sns.storage.i();
                    iVar.field_talker = str;
                    iVar.field_snsID = j;
                    iVar.field_createTime = (int) (System.currentTimeMillis() / 1000);
                    iVar.field_curActionBuf = com_tencent_mm_protocal_c_bau.toByteArray();
                    iVar.field_type = i;
                    iVar.field_isSend = true;
                    iVar.field_isRead = (short) 1;
                    ae.beP().b(iVar);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnsService", e, "", new Object[0]);
                }
                ae.beK().a(n, com_tencent_mm_protocal_c_bav);
            }
        }

        public final void EA(String str) {
            String accSnsPath = ae.getAccSnsPath();
            String str2 = str + "bg_";
            String str3 = str + "tbg_";
            if (FileOp.aO(str2)) {
                FileOp.deleteFile(am.du(accSnsPath, str) + str3);
                FileOp.h(am.du(accSnsPath, str), str2, str3);
            }
        }
    }
}
