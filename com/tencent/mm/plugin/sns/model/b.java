package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.d;
import com.tencent.mm.plugin.sns.model.g.AnonymousClass9;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements com.tencent.mm.plugin.sns.model.a.b.a, e {
    static int pSx = 0;
    private static final int pSy = (VERSION.SDK_INT >= 14 ? 100 : 25);
    LinkedList<f> gMT;
    Set<b> gNx;
    ae handler;
    private int pSA;
    private int pSB;
    LinkedList<g> pSC;
    public HashMap<String, Long> pSD;
    public boolean pSE;
    public Set<a> pSF;
    Map<String, Long> pSG;
    Map<String, com.tencent.mm.plugin.sns.data.c> pSH;
    public long pSz;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String hZF;
        final /* synthetic */ b pSJ;
        final /* synthetic */ String uG;

        public AnonymousClass3(b bVar, String str, String str2) {
            this.pSJ = bVar;
            this.uG = str;
            this.hZF = str2;
        }

        public final void run() {
            if (this.pSJ.pSF != null) {
                for (a aVar : this.pSJ.pSF) {
                    if (aVar != null) {
                        aVar.dr(this.uG, this.hZF);
                    }
                }
            }
        }
    }

    public interface a {
        void dr(String str, String str2);
    }

    public interface b {
        void ES(String str);

        void ao(String str, boolean z);

        void ap(String str, boolean z);

        void bdD();
    }

    class c implements IdleHandler {
        final /* synthetic */ b pSJ;

        c(b bVar) {
            this.pSJ = bVar;
        }

        public final boolean queueIdle() {
            w.d("MicroMsg.DownloadManager", "I run idleHandler ");
            this.pSJ.pSz = bg.Ny();
            return this.pSJ.bdR();
        }
    }

    public static void bdO() {
    }

    public static boolean bdP() {
        return false;
    }

    public final void N(int i, boolean z) {
        this.pSB = i;
        try {
            String value;
            String str;
            if (am.isWifi(ab.getContext())) {
                value = com.tencent.mm.i.g.sV().getValue("SnsImgDownloadConcurrentCountForWifi");
            } else {
                value = com.tencent.mm.i.g.sV().getValue("SnsImgDownloadConcurrentCountForNotWifi");
            }
            if (bg.mA(value) && com.tencent.mm.sdk.a.b.bIu()) {
                str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
            } else {
                str = value;
            }
            if (!bg.mA(str)) {
                int i2;
                String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
                int PY = (bg.PY(split[1]) + (bg.PY(split[0]) * 60)) - ((((int) i.Eq()) - 8) * 60);
                if (PY < 0) {
                    i2 = PY + 1440;
                } else if (PY >= 1440) {
                    i2 = PY - 1440;
                } else {
                    i2 = PY;
                }
                String[] split2 = str.split(";");
                for (int i3 = 0; i3 < split2.length; i3++) {
                    if (!bg.mA(split2[i3])) {
                        split = split2[i3].split("-");
                        if (split == null || split.length < 4) {
                            w.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[]{Integer.valueOf(i3), str});
                        } else {
                            String[] split3 = split[0].split(":");
                            int PY2 = bg.PY(split3[1]) + (bg.PY(split3[0]) * 60);
                            String[] split4 = split[1].split(":");
                            w.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[]{Integer.valueOf(i3), Integer.valueOf(PY2), Integer.valueOf(bg.PY(split4[1]) + (bg.PY(split4[0]) * 60)), Integer.valueOf(i2), split[2], split[3]});
                            if (i2 <= bg.PY(split4[1]) + (bg.PY(split4[0]) * 60) && i2 > PY2) {
                                PY = bg.PY(z ? split[2] : split[3]);
                                if (PY > 0) {
                                    this.pSB = PY;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            w.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[]{bg.g(e)});
        }
        w.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[]{Integer.valueOf(this.pSB)});
    }

    public b() {
        this.handler = null;
        this.pSz = 0;
        this.pSA = 0;
        this.pSB = 2;
        this.pSC = new LinkedList();
        this.pSD = new HashMap();
        this.pSE = true;
        this.gNx = new HashSet();
        this.pSF = new HashSet();
        this.gMT = new LinkedList();
        this.pSG = new ConcurrentHashMap();
        this.pSH = new HashMap();
        this.handler = ae.ayz();
        bdQ();
    }

    private void bdQ() {
        this.gMT.clear();
        this.pSH.clear();
        this.pSG.clear();
        this.pSC.clear();
        this.pSD.clear();
    }

    public final boolean bdR() {
        if (this.pSC == null || this.pSC.size() <= 0) {
            return false;
        }
        g gVar = (g) this.pSC.remove();
        new ar().l(gVar);
        return true;
    }

    public final void a(final b bVar) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ b pSJ;

            public final void run() {
                e eVar = this.pSJ;
                eVar.gNx.add(bVar);
                int i = b.pSx + 1;
                b.pSx = i;
                if (i <= 1) {
                    h.vJ();
                    h.vH().gXC.a(bv.CTRL_INDEX, eVar);
                }
            }
        });
    }

    public final void b(final b bVar) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ b pSJ;

            public final void run() {
                e eVar = this.pSJ;
                eVar.gNx.remove(bVar);
                int i = b.pSx - 1;
                b.pSx = i;
                if (i <= 0) {
                    h.vJ();
                    h.vH().gXC.b(bv.CTRL_INDEX, eVar);
                }
            }
        });
    }

    public final boolean a(alh com_tencent_mm_protocal_c_alh, int i, com.tencent.mm.plugin.sns.data.e eVar, an anVar) {
        if (com_tencent_mm_protocal_c_alh == null) {
            w.e("MicroMsg.DownloadManager", "unknow case media is null " + bg.bJZ().toString());
            return false;
        }
        final alh com_tencent_mm_protocal_c_alh2 = com_tencent_mm_protocal_c_alh;
        final int i2 = i;
        final com.tencent.mm.plugin.sns.data.e eVar2 = eVar;
        final an anVar2 = anVar;
        ae.ayz().post(new Runnable(this) {
            final /* synthetic */ b pSJ;

            public final void run() {
                au.Fu(com_tencent_mm_protocal_c_alh2.mQY);
                b bVar = this.pSJ;
                alh com_tencent_mm_protocal_c_alh = com_tencent_mm_protocal_c_alh2;
                int i = i2;
                com.tencent.mm.plugin.sns.data.e eVar = eVar2;
                an anVar = anVar2;
                if (!i.EN(ae.xv())) {
                    w.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[]{ae.xv(), com.tencent.mm.compatible.util.e.hgs});
                } else if (com_tencent_mm_protocal_c_alh.mQY.startsWith("Locall_path") || com_tencent_mm_protocal_c_alh.mQY.startsWith("pre_temp_sns_pic")) {
                    w.d("MicroMsg.DownloadManager", "is a local img not need download");
                } else {
                    String ao = i.ao(i, com_tencent_mm_protocal_c_alh.mQY);
                    if (bVar.pSH.containsKey(ao)) {
                        Iterator it = bVar.gMT.iterator();
                        while (it.hasNext()) {
                            f fVar = (f) it.next();
                            if (fVar.fVV.mQY.equals(com_tencent_mm_protocal_c_alh.mQY) && fVar.requestType == i) {
                                if (bVar.gMT.remove(fVar)) {
                                    bVar.gMT.addLast(fVar);
                                }
                                w.v("MicroMsg.DownloadManager", "update the donwload list ");
                            }
                        }
                    } else {
                        w.d("MicroMsg.DownloadManager", "add list %s", new Object[]{com_tencent_mm_protocal_c_alh.mQY});
                        bVar.pSH.put(ao, new com.tencent.mm.plugin.sns.data.c(eVar, i));
                        bVar.gMT.add(new f(com_tencent_mm_protocal_c_alh, i, ao, anVar));
                    }
                    w.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[]{Integer.valueOf(ae.beK().bep()), Integer.valueOf(bVar.pSG.size())});
                    w.v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", new Object[]{Integer.valueOf(bVar.pSH.size()), Integer.valueOf(bVar.pSH.size()), Integer.valueOf(bVar.pSC.size())});
                    if (Looper.myLooper() == null) {
                        w.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
                        return;
                    }
                    Looper.myQueue().addIdleHandler(new c(bVar));
                    if ((bg.az(bVar.pSz) * 1000 > 300000 ? 1 : null) != null) {
                        bVar.handler.postDelayed(new Runnable(bVar) {
                            final /* synthetic */ b pSJ;

                            {
                                this.pSJ = r1;
                            }

                            public final void run() {
                                this.pSJ.bdR();
                            }
                        }, 500);
                    }
                    List<String> linkedList = new LinkedList();
                    for (Entry key : bVar.pSG.entrySet()) {
                        linkedList.add(key.getKey());
                    }
                    for (String str : linkedList) {
                        if (bVar.pSG.containsKey(str) && bg.az(((Long) bVar.pSG.get(str)).longValue()) * 1000 > 300000) {
                            w.d("MicroMsg.DownloadManager", "too long to download");
                            bVar.pSG.remove(str);
                            bVar.pSH.remove(str);
                        }
                    }
                    if (bVar.gMT.size() > 0) {
                        bVar.handler.postDelayed(new Runnable(bVar) {
                            final /* synthetic */ b pSJ;

                            {
                                this.pSJ = r1;
                            }

                            public final void run() {
                                this.pSJ.pq();
                            }
                        }, 500);
                    }
                }
            }
        });
        return true;
    }

    public final void EW(String str) {
        w.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str});
        com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) this.pSH.get(str);
        if (cVar != null) {
            com.tencent.mm.plugin.sns.data.e eVar = cVar.pQM;
            if (eVar != null) {
                alh com_tencent_mm_protocal_c_alh;
                g beI = ae.beI();
                alh com_tencent_mm_protocal_c_alh2 = (alh) eVar.fRK.get(0);
                for (int i = 1; i < eVar.fRK.size(); i++) {
                    alh com_tencent_mm_protocal_c_alh3 = (alh) eVar.fRK.get(i);
                    if (str != null && str.indexOf(com_tencent_mm_protocal_c_alh3.mQY) >= 0) {
                        com_tencent_mm_protocal_c_alh = com_tencent_mm_protocal_c_alh3;
                        break;
                    }
                }
                com_tencent_mm_protocal_c_alh = com_tencent_mm_protocal_c_alh2;
                String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                String f = eVar.pQS == 0 ? i.f(com_tencent_mm_protocal_c_alh) : eVar.pQS == 4 ? i.g(com_tencent_mm_protocal_c_alh) : eVar.pQS == 5 ? i.g(com_tencent_mm_protocal_c_alh) : i.e(com_tencent_mm_protocal_c_alh);
                if (!beI.pSR.aV(i.an(eVar.pQS, com_tencent_mm_protocal_c_alh.mQY))) {
                    new b(beI, i.an(eVar.pQS, com_tencent_mm_protocal_c_alh.mQY), du + f, du, com_tencent_mm_protocal_c_alh, eVar.pQS).l("");
                }
            }
        }
        this.pSH.remove(str);
    }

    public final void pq() {
        if (!this.pSE) {
            return;
        }
        if (ae.beu()) {
            bdQ();
        } else if (i.EN(ae.xv())) {
            int i = this.pSB;
            if (r.iiB > 0) {
                i = r.iiB;
            }
            if (this.gMT.size() > 0 && ae.beK().bep() + this.pSG.size() <= r2) {
                w.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[]{Integer.valueOf(ae.beK().bep()), Integer.valueOf(this.pSG.size()), Integer.valueOf(this.gMT.size()), Integer.valueOf(this.pSB)});
                f fVar = (f) this.gMT.removeLast();
                alh com_tencent_mm_protocal_c_alh = fVar.fVV;
                int i2 = fVar.requestType;
                String str = fVar.arH;
                if (!this.pSH.containsKey(str) || this.pSH.get(str) == null) {
                    this.pSH.remove(str);
                    return;
                }
                boolean z;
                String str2;
                int i3;
                Object obj;
                com.tencent.mm.plugin.sns.data.e eVar = ((com.tencent.mm.plugin.sns.data.c) this.pSH.get(str)).pQM;
                if (i2 == 1 || i2 == 5 || i2 == 7) {
                    z = true;
                    String str3 = com_tencent_mm_protocal_c_alh.tPi;
                    if (i2 == 7 && !bg.mA(com_tencent_mm_protocal_c_alh.tPs)) {
                        str3 = com_tencent_mm_protocal_c_alh.tPs;
                    }
                    int i4 = com_tencent_mm_protocal_c_alh.tPj;
                    if (bg.mA(str3) && com_tencent_mm_protocal_c_alh.jOc == 2) {
                        str2 = com_tencent_mm_protocal_c_alh.msN;
                        i3 = com_tencent_mm_protocal_c_alh.tPh;
                    } else {
                        i3 = i4;
                        str2 = str3;
                    }
                } else if (i2 == 6) {
                    z = false;
                    str2 = com_tencent_mm_protocal_c_alh.tPp;
                    i3 = com_tencent_mm_protocal_c_alh.tPh;
                } else {
                    z = false;
                    str2 = com_tencent_mm_protocal_c_alh.msN;
                    i3 = com_tencent_mm_protocal_c_alh.tPh;
                }
                if (str2 == null || str2.equals("")) {
                    w.d("MicroMsg.DownloadManager", "url  " + str2);
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    this.pSH.remove(str);
                } else if (i3 == 2) {
                    if (!ae.beK().isDownloading(str)) {
                        w.d("MicroMsg.DownloadManager", "to downLoad scene " + com_tencent_mm_protocal_c_alh.mQY + "  " + str2);
                        h.vJ();
                        h.vH().gXC.a(new o(com_tencent_mm_protocal_c_alh, com_tencent_mm_protocal_c_alh.mQY, str2, com_tencent_mm_protocal_c_alh.jOc, z, i2, str), 0);
                        ae.beK().Fh(str);
                    }
                } else if (i3 == 1 || i3 == 0) {
                    if (i3 == 0) {
                        w.e("MicroMsg.DownloadManager", "others http: urlType" + i3 + " -- url : " + str2 + " isThumb :" + z);
                    }
                    if (!this.pSG.containsKey(str)) {
                        w.d("MicroMsg.DownloadManager", "to downLoad cdn " + com_tencent_mm_protocal_c_alh.mQY + "  " + str2);
                        if (!(com_tencent_mm_protocal_c_alh == null || i2 == 6 || !this.pSD.containsKey(str))) {
                            long longValue = ((Long) this.pSD.get(str)).longValue();
                            if (System.currentTimeMillis() - longValue < 300000) {
                                this.pSH.remove(str);
                                w.w("MicroMsg.DownloadManager", "download error pass " + longValue + " url " + str2 + " id: " + com_tencent_mm_protocal_c_alh.mQY);
                                return;
                            }
                        }
                        this.pSG.put(str, Long.valueOf(bg.Ny()));
                        if (i2 == 2) {
                            h.vJ();
                            int a = bg.a((Integer) h.vI().vr().get(68391, null), 0);
                            h.vJ();
                            h.vI().vr().set(68391, Integer.valueOf(a + 1));
                        }
                        com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(com_tencent_mm_protocal_c_alh.mQY);
                        aVar.pTY = com_tencent_mm_protocal_c_alh;
                        aVar.pYA = fVar.pQT;
                        if (i2 == 4) {
                            aVar.pYy = true;
                        } else {
                            aVar.pYy = false;
                        }
                        aVar.url = str2;
                        i = com_tencent_mm_protocal_c_alh.jOc;
                        aVar.pYx = z;
                        aVar.pYz = i2;
                        aVar.pTX = str;
                        aVar.pQM = eVar;
                        com.tencent.mm.plugin.sns.model.a.b bVar = null;
                        if (i2 == 1 || i2 == 5 || i2 == 7) {
                            bVar = new com.tencent.mm.plugin.sns.model.a.g(this, aVar);
                        } else if (i2 == 4) {
                            w.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                            bVar = new com.tencent.mm.plugin.sns.model.a.f(this, aVar);
                        } else if (i2 == 2 || i2 == 3) {
                            bVar = new d(this, aVar);
                        } else if (i2 == 6) {
                            aVar.url = com_tencent_mm_protocal_c_alh.tPp;
                            aVar.fFW = com_tencent_mm_protocal_c_alh.tPr;
                            bVar = new com.tencent.mm.plugin.sns.model.a.c(this, aVar);
                        }
                        bVar.l("");
                    }
                } else {
                    this.pSH.remove(str);
                }
            }
        }
    }

    public final void a(int i, alh com_tencent_mm_protocal_c_alh, int i2, boolean z, String str, int i3) {
        if (!ae.beu()) {
            h.vJ();
            if (h.vG().uV()) {
                this.pSA += i3;
                if (this.pSA > 512000 && this.gMT.size() == 0) {
                    w.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[]{Integer.valueOf(this.pSA)});
                    com.tencent.mm.u.ag.a.hlT.aH(this.pSA, 0);
                    this.pSA = 0;
                }
                if (i == 1 || i == 3) {
                    this.pSD.put(str, Long.valueOf(System.currentTimeMillis()));
                }
                if (!(i == 3 || i != 1 || i2 == 3)) {
                    g beI = ae.beI();
                    w.d("MicroMsg.LazyerImageLoader2", "updateCache " + com_tencent_mm_protocal_c_alh.mQY);
                    n nVar = (n) beI.pSR.get(i.an(1, com_tencent_mm_protocal_c_alh.mQY));
                    if (i.a(nVar)) {
                        nVar.wy();
                        w.d("MicroMsg.LazyerImageLoader2", "force update");
                        ae.bey().post(new AnonymousClass9(beI, com_tencent_mm_protocal_c_alh));
                    }
                }
                for (b bVar : this.gNx) {
                    if (bVar != null) {
                        if (i != 2) {
                            if (i2 == 3) {
                                bVar.bdD();
                            } else if (i2 == 1 || i2 == 5 || i2 == 7) {
                                bVar.ES(com_tencent_mm_protocal_c_alh.mQY);
                            } else if (i2 == 2) {
                                bVar.ao(com_tencent_mm_protocal_c_alh.mQY, true);
                            } else if (i2 == 4 || i2 == 6) {
                                bVar.ap(com_tencent_mm_protocal_c_alh.mQY, true);
                            }
                        } else if (i2 == 2) {
                            bVar.ao(com_tencent_mm_protocal_c_alh.mQY, false);
                        } else if (i2 == 4 || i2 == 6) {
                            bVar.ap(com_tencent_mm_protocal_c_alh.mQY, false);
                        }
                    }
                }
                w.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s", new Object[]{str});
                this.pSG.remove(str);
                pq();
                EW(str);
                return;
            }
        }
        bdQ();
    }

    public final void EX(final String str) {
        ae.ayz().post(new Runnable(this) {
            final /* synthetic */ b pSJ;

            public final void run() {
                b bVar = this.pSJ;
                w.d("MicroMsg.DownloadManager", "onDownLoadFinish by scene %s", new Object[]{str});
                ae.beK().Fi(r1);
                bVar.pq();
                this.pSJ.EW(str);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        if (kVar.getType() == bv.CTRL_INDEX) {
            o oVar = (o) kVar;
            if (i == 0 && i2 == 0) {
                if (kVar.getType() == bv.CTRL_INDEX) {
                    for (b bVar : this.gNx) {
                        if (bVar != null) {
                            if (oVar.pTV == 3) {
                                bVar.bdD();
                            } else if (oVar.pTV == 1 || oVar.pTV == 5 || oVar.pTV == 7) {
                                bVar.ES(oVar.mediaId);
                            } else if (oVar.pTV == 2) {
                                bVar.ao(oVar.mediaId, true);
                            }
                        }
                    }
                }
            } else if (oVar.pTV == 2) {
                for (b bVar2 : this.gNx) {
                    if (bVar2 != null) {
                        bVar2.ao(oVar.mediaId, false);
                    }
                }
            }
        }
    }
}
