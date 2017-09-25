package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class aq implements a {
    public boolean hZl;
    public boolean hZm;
    public f hZp;
    public ax pXA;
    public LinkedList<ax> pXB;
    public Map<String, ax> pXC;
    public LinkedList<m> pXD;
    c pXE;
    c pXq;
    c pXr;

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Object[] hyW;
        final /* synthetic */ aq pXF;
        final /* synthetic */ String pXG;

        public AnonymousClass5(aq aqVar, String str, Object[] objArr) {
            this.pXF = aqVar;
            this.pXG = str;
            this.hyW = objArr;
        }

        public final void run() {
            o.KW().b(this.pXG, this.hyW);
            if (this.pXF.pXA != null && bg.eB(this.pXF.pXA.hYc, this.pXG)) {
                this.pXF.bfr();
            }
            this.pXF.pXB.remove((ax) this.pXF.pXC.get(this.pXG));
        }
    }

    public aq() {
        this.pXB = null;
        this.pXC = null;
        this.hZp = null;
        this.pXD = null;
        this.hZl = false;
        this.hZm = false;
        this.pXE = new c<kk>(this) {
            final /* synthetic */ aq pXF;

            {
                this.pXF = r2;
                this.usg = kk.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                kk kkVar = (kk) bVar;
                if (this.pXF.pXA != null && bg.eB(this.pXF.pXA.hYc, kkVar.fQO.mediaId)) {
                    if (kkVar.fQO.fEX != 0) {
                        this.pXF.bfq();
                    } else if (kkVar.fQO.fJK == 4 || kkVar.fQO.fJK == 6) {
                        this.pXF.bfr();
                    }
                }
                return false;
            }
        };
        this.pXq = new c<com.tencent.mm.e.a.f>(this) {
            final /* synthetic */ aq pXF;

            {
                this.pXF = r2;
                this.usg = com.tencent.mm.e.a.f.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                com.tencent.mm.e.a.f fVar = (com.tencent.mm.e.a.f) bVar;
                if (fVar.fCo.className.equals("En_424b8e16")) {
                    this.pXF.hZm = fVar.fCo.fCp;
                    w.d("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[]{Boolean.valueOf(this.pXF.hZm)});
                    if (this.pXF.hZm || this.pXF.hZl) {
                        this.pXF.bfp();
                    }
                    i KX = o.KX();
                    KX.hZm = this.pXF.hZm;
                    if (KX.hZm) {
                        KX.stopDownload();
                    }
                }
                return false;
            }
        };
        this.pXr = new c<ar>(this) {
            final /* synthetic */ aq pXF;

            {
                this.pXF = r2;
                this.usg = ar.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                ar arVar = (ar) bVar;
                this.pXF.hZl = arVar.fEf.fEg;
                w.d("MicroMsg.SnsVideoService", "set isInChatting:%b", new Object[]{Boolean.valueOf(this.pXF.hZl)});
                if (this.pXF.hZm || this.pXF.hZl) {
                    this.pXF.bfp();
                }
                if (!(this.pXF.hZl || this.pXF.hZm)) {
                    this.pXF.bfo();
                }
                i KX = o.KX();
                KX.hZl = this.pXF.hZl;
                if (KX.hZl) {
                    KX.stopDownload();
                } else {
                    KX.KP();
                }
                return false;
            }
        };
        this.pXA = null;
        this.pXB = new LinkedList();
        this.pXC = new HashMap();
        this.pXD = new LinkedList();
        com.tencent.mm.sdk.b.a.urY.b(this.pXE);
        com.tencent.mm.sdk.b.a.urY.b(this.pXq);
        com.tencent.mm.sdk.b.a.urY.b(this.pXr);
    }

    public final void bfo() {
        h.vL().D(new Runnable(this) {
            final /* synthetic */ aq pXF;

            {
                this.pXF = r1;
            }

            public final void run() {
                if (this.pXF.pXA == null && this.pXF.pXB.isEmpty() && this.pXF.hZp == null && !this.pXF.hZl && !this.pXF.hZm) {
                    Object obj;
                    m mVar = null;
                    com.tencent.mm.modelcdntran.i iVar = null;
                    PBool pBool = new PBool();
                    PInt pInt = new PInt();
                    synchronized (this.pXF.pXD) {
                        Iterator it = this.pXF.pXD.iterator();
                        while (it.hasNext()) {
                            mVar = (m) it.next();
                            aq aqVar = this.pXF;
                            if (mVar == null) {
                                pBool.value = true;
                                obj = null;
                            } else if (bg.az((long) mVar.field_createTime) >= 86400) {
                                pBool.value = true;
                                obj = null;
                            } else if (o.KX().bu(false)) {
                                pBool.value = true;
                                obj = null;
                            } else {
                                bbk m = ai.m(mVar);
                                if (m == null || m.ucC == null) {
                                    w.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
                                    pBool.value = true;
                                    obj = null;
                                } else {
                                    w.i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", new Object[]{Integer.valueOf(aqVar.hashCode()), mVar.bhy(), Integer.valueOf(m.ucC.tVv), Integer.valueOf(m.ucC.tVw), m.ucC.tVx});
                                    if (m.ucC.tVv <= 0) {
                                        w.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", new Object[]{Integer.valueOf(aqVar.hashCode())});
                                        pBool.value = true;
                                        obj = null;
                                    } else {
                                        pInt.value = m.ucC.tVv;
                                        if (!com.tencent.mm.modelcontrol.b.iT(m.ucC.tVx)) {
                                            int i;
                                            if (am.isWifi(ab.getContext())) {
                                                i = m.ucC.tVw | 1;
                                            } else if (am.is4G(ab.getContext())) {
                                                i = m.ucC.tVw | 2;
                                            } else if (am.is3G(ab.getContext())) {
                                                i = m.ucC.tVw | 4;
                                            } else {
                                                pBool.value = false;
                                                obj = null;
                                            }
                                            if (i > 0) {
                                                pBool.value = false;
                                                obj = 1;
                                            }
                                        }
                                        pBool.value = false;
                                        obj = null;
                                    }
                                }
                            }
                            if (pBool.value) {
                                it.remove();
                            }
                            if (obj != null) {
                                com.tencent.mm.modelcdntran.i iVar2;
                                int i2 = pInt.value;
                                if (mVar == null) {
                                    iVar2 = null;
                                } else {
                                    alh com_tencent_mm_protocal_c_alh = (alh) mVar.bhd().ufB.tsO.get(0);
                                    String bhy = mVar.bhy();
                                    String a = ap.a(bhy, com_tencent_mm_protocal_c_alh);
                                    if (bg.mA(a)) {
                                        boolean aS = e.aS(ap.Fs(com_tencent_mm_protocal_c_alh.mQY));
                                        String C = ap.C(com_tencent_mm_protocal_c_alh);
                                        r Ft = ap.Ft(bhy);
                                        if (Ft == null) {
                                            ap.bK(bhy, 30);
                                        } else {
                                            ap.c(Ft, 30);
                                        }
                                        w.i("MicroMsg.SnsVideoService", "preload stream download sns video %s mkDir %b", new Object[]{C, Boolean.valueOf(aS)});
                                        com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(com_tencent_mm_protocal_c_alh.mQY);
                                        aVar.pTY = com_tencent_mm_protocal_c_alh;
                                        an bLV = an.bLV();
                                        bLV.cIm = mVar.field_createTime;
                                        aVar.pYA = bLV;
                                        aVar.pYy = true;
                                        aVar.url = com_tencent_mm_protocal_c_alh.msN;
                                        int i3 = com_tencent_mm_protocal_c_alh.jOc;
                                        aVar.pYx = false;
                                        n.KT();
                                        o.KW();
                                        iVar = com.tencent.mm.modelcdntran.f.a(aVar.pYA, aVar.url, C, ap.lu(bhy), 2);
                                        if (iVar == null) {
                                            iVar2 = null;
                                        } else {
                                            iVar.fvn = com_tencent_mm_protocal_c_alh.tPD;
                                            iVar.field_preloadRatio = i2;
                                            iVar2 = iVar;
                                        }
                                    } else {
                                        w.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing.", new Object[]{a});
                                        o.KX().a(com_tencent_mm_protocal_c_alh.tPD, 3, (long) e.aN(a));
                                        g.oUh.a(354, 147, 1, false);
                                        iVar2 = null;
                                    }
                                }
                                if (iVar2 != null) {
                                    iVar = iVar2;
                                    break;
                                } else {
                                    it.remove();
                                    iVar = iVar2;
                                }
                            } else {
                                mVar = null;
                            }
                        }
                    }
                    if (mVar != null && iVar != null) {
                        obj = null;
                        if (iVar != null) {
                            try {
                                this.pXF.hZp = new f(iVar, mVar.bhy());
                                if (this.pXF.hZp.a(this.pXF) < 0) {
                                    w.w("MicroMsg.SnsVideoService", "%s curr preload task do scene error.", new Object[]{Integer.valueOf(this.pXF.hashCode())});
                                    obj = 1;
                                    this.pXF.hZp = null;
                                }
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.SnsVideoService", e, "", new Object[0]);
                                return;
                            }
                        }
                        obj = 1;
                        if (obj != null) {
                            synchronized (this.pXF.pXD) {
                                Iterator it2 = this.pXF.pXD.iterator();
                                while (it2.hasNext()) {
                                    m mVar2 = (m) it2.next();
                                    if (mVar2 != null && bg.eB(mVar2.bhy(), mVar.bhy())) {
                                        w.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[]{Integer.valueOf(this.pXF.hashCode()), mVar.bhy()});
                                        it2.remove();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public final void bfp() {
        w.d("MicroMsg.SnsVideoService", "%d stop preload %s", new Object[]{Integer.valueOf(hashCode()), bg.bJZ()});
        h.vL().D(new Runnable(this) {
            final /* synthetic */ aq pXF;

            {
                this.pXF = r1;
            }

            public final void run() {
                if (this.pXF.hZp != null) {
                    this.pXF.hZp.stop();
                }
                this.pXF.hZp = null;
            }
        });
    }

    public final void a(final f fVar, boolean z, int i, int i2) {
        if (fVar == null) {
            w.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        if (this.hZp != fVar) {
            w.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", new Object[]{Integer.valueOf(hashCode())});
        }
        w.i("MicroMsg.SnsVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[]{Integer.valueOf(hashCode()), fVar.KM(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
        h.vL().D(new Runnable(this) {
            final /* synthetic */ aq pXF;

            public final void run() {
                String str = fVar.fGN;
                synchronized (this.pXF.pXD) {
                    Iterator it = this.pXF.pXD.iterator();
                    while (it.hasNext()) {
                        m mVar = (m) it.next();
                        if (mVar != null && bg.eB(str, mVar.bhy())) {
                            w.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[]{Integer.valueOf(this.pXF.hashCode()), str});
                            it.remove();
                        }
                    }
                }
                o.KX().bt(false);
                if (this.pXF.hZp != null) {
                    this.pXF.hZp.hYQ = null;
                }
                this.pXF.hZp = null;
                this.pXF.KQ();
                this.pXF.bfo();
            }
        });
    }

    public final boolean KQ() {
        int i;
        long NA = bg.NA();
        w.i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(130), Long.valueOf(bg.Ny() - (((long) ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("SnsPreLoadVideoExpiredTime", 1)) * 86400))});
        List<r> a = o.KV().a(130, 1, r0);
        if (a == null || a.isEmpty()) {
            return false;
        }
        int i2 = 0;
        for (r rVar : a) {
            if (rVar != null) {
                try {
                    int i3;
                    String C = ap.C((alh) ae.beL().Gg(ap.Fr(rVar.getFileName())).bhd().ufB.tsO.get(0));
                    if (!bg.mA(C)) {
                        File file = new File(C);
                        if (file.exists()) {
                            long length = file.length();
                            w.i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", new Object[]{rVar.getFileName(), Long.valueOf(length), Integer.valueOf(rVar.fOA), Long.valueOf(rVar.ian), C});
                            if (length > 0 && length <= ((long) rVar.fOA)) {
                                file.delete();
                                i3 = i2 + 1;
                                rVar.fOA = 0;
                                rVar.fRW = 1;
                                t.e(rVar);
                                i2 = i3;
                            }
                        }
                    }
                    i3 = i2;
                    try {
                        rVar.fOA = 0;
                        rVar.fRW = 1;
                        t.e(rVar);
                        i2 = i3;
                    } catch (Exception e) {
                        i = i3;
                        i2 = i;
                    }
                } catch (Exception e2) {
                    i = i2;
                    i2 = i;
                }
            }
        }
        g.oUh.a(354, 145, (long) i2, false);
        w.i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(a.size()), Integer.valueOf(i2), Long.valueOf(bg.aB(NA))});
        return false;
    }

    public final boolean a(alh com_tencent_mm_protocal_c_alh, int i, String str, boolean z, final boolean z2, int i2) {
        int i3 = 0;
        if (com_tencent_mm_protocal_c_alh.tPh == 2) {
            w.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
            return false;
        }
        final ax axVar = new ax();
        axVar.hYc = ap.ap(i, com_tencent_mm_protocal_c_alh.msN);
        axVar.fVV = com_tencent_mm_protocal_c_alh;
        axVar.hFf = i;
        axVar.fGN = str;
        if (z) {
            i3 = 1;
        }
        axVar.hzt = i3;
        axVar.hzv = i2;
        h.vJ();
        h.vL().D(new Runnable(this) {
            final /* synthetic */ aq pXF;

            public final void run() {
                m Gg = ae.beL().Gg(axVar.fGN);
                axVar.pYw = Gg != null ? Gg.field_userName : "";
                w.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", new Object[]{Boolean.valueOf(z2), axVar});
                if (z2) {
                    this.pXF.pXB.offerFirst(axVar);
                } else {
                    this.pXF.pXB.offerLast(axVar);
                }
                this.pXF.pXC.put(axVar.hYc, axVar);
            }
        });
        if (z2) {
            bfq();
        }
        return true;
    }

    public final void bfq() {
        h.vJ();
        h.vL().D(new Runnable(this) {
            final /* synthetic */ aq pXF;

            {
                this.pXF = r1;
            }

            public final void run() {
                boolean z = true;
                if (this.pXF.pXB.isEmpty()) {
                    w.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
                    return;
                }
                ax axVar = (ax) this.pXF.pXB.poll();
                if (axVar == null) {
                    w.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[]{Integer.valueOf(this.pXF.pXB.size())});
                    return;
                }
                if (this.pXF.pXA == null || !axVar.hYc.equals(this.pXF.pXA.hYc)) {
                    z = false;
                }
                this.pXF.a(axVar, z);
            }
        });
    }

    public final boolean a(ax axVar, boolean z) {
        if (bg.mA(ap.a(axVar.fGN, axVar.fVV))) {
            boolean aS = e.aS(ap.Fs(axVar.fVV.mQY));
            String C = ap.C(axVar.fVV);
            r Ft = ap.Ft(axVar.fGN);
            if (Ft == null) {
                ap.bK(axVar.fGN, axVar.hzv);
            } else {
                ap.c(Ft, axVar.hzv);
            }
            w.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", new Object[]{C, Boolean.valueOf(aS)});
            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(axVar.fVV.mQY);
            aVar.pTY = axVar.fVV;
            an bLV = an.bLV();
            bLV.cIm = axVar.hFf;
            aVar.pYA = bLV;
            aVar.pYy = true;
            aVar.url = axVar.fVV.msN;
            int i = axVar.fVV.jOc;
            aVar.pYx = false;
            n.KT();
            o.KW();
            com.tencent.mm.modelcdntran.i a = com.tencent.mm.modelcdntran.f.a(aVar.pYA, aVar.url, C, ap.lu(axVar.fGN), axVar.hzt);
            if (a == null) {
                return false;
            }
            C = axVar.pYw;
            a.hzu = C;
            a.fOu = C;
            try {
                a.hzy = ai.m(ae.beL().Gg(axVar.fGN)).ucC.tVv;
            } catch (Exception e) {
            }
            this.pXA = axVar;
            this.pXA.hYc = a.field_mediaId;
            w.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", new Object[]{this.pXA.hYc, Boolean.valueOf(z)});
            o.KW().a(a, z);
            return true;
        }
        w.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", new Object[]{axVar.hYc, axVar.fGN, ap.a(axVar.fGN, axVar.fVV)});
        return false;
    }

    public final void bfr() {
        h.vJ();
        h.vL().D(new Runnable(this) {
            final /* synthetic */ aq pXF;

            {
                this.pXF = r1;
            }

            public final void run() {
                if (this.pXF.pXA != null) {
                    w.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", new Object[]{this.pXF.pXA.hYc});
                    this.pXF.pXC.remove(this.pXF.pXA.hYc);
                }
                this.pXF.pXA = null;
                this.pXF.bfq();
            }
        });
    }
}
