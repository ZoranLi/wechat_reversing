package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass6;
import com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass7;
import com.tencent.mm.plugin.webview.wepkg.utils.WepkgRunCgi;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.bpa;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.bpc;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.protocal.c.bpe;
import com.tencent.mm.protocal.c.bpf;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.protocal.c.bph;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.protocal.c.lj;
import com.tencent.mm.protocal.c.lq;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class WepkgVersionManager {

    public static final class WepkgNetSceneProcessTask extends BaseWepkgProcessTask {
        public static final Creator<WepkgNetSceneProcessTask> CREATOR = new Creator<WepkgNetSceneProcessTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new WepkgNetSceneProcessTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WepkgNetSceneProcessTask[i];
            }
        };
        public List<WepkgCheckReq> sro;

        private static class WepkgCheckReq implements Parcelable {
            public static final Creator<WepkgCheckReq> CREATOR = new Creator<WepkgCheckReq>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new WepkgCheckReq(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new WepkgCheckReq[i];
                }
            };
            public int scene;
            public String sqL;
            public String version;

            public WepkgCheckReq(Parcel parcel) {
                this.sqL = parcel.readString();
                this.version = parcel.readString();
                this.scene = parcel.readInt();
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(this.sqL);
                parcel.writeString(this.version);
                parcel.writeInt(this.scene);
            }
        }

        public WepkgNetSceneProcessTask() {
            this.sro = new ArrayList();
        }

        public WepkgNetSceneProcessTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            if (!bg.bV(this.sro)) {
                a aVar = new a();
                aVar.hsl = 1313;
                aVar.hso = 0;
                aVar.hsp = 0;
                aVar.uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
                com.tencent.mm.bd.a liVar = new li();
                for (WepkgCheckReq wepkgCheckReq : this.sro) {
                    lq lqVar = new lq();
                    lqVar.trY = wepkgCheckReq.sqL;
                    lqVar.jNP = wepkgCheckReq.version;
                    lqVar.tdM = wepkgCheckReq.scene;
                    liVar.trB.add(lqVar);
                }
                aVar.hsm = liVar;
                aVar.hsn = new lj();
                b BE = aVar.BE();
                WepkgRunCgi.a anonymousClass1 = new WepkgRunCgi.a(this) {
                    final /* synthetic */ WepkgNetSceneProcessTask srp;

                    {
                        this.srp = r1;
                    }

                    public final void a(int i, int i2, String str, b bVar) {
                        if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                            try {
                                final lj ljVar = (lj) bVar.hsk.hsr;
                                d.vL().D(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 srr;

                                    public final void run() {
                                        lj ljVar = ljVar;
                                        if (ljVar == null) {
                                            return;
                                        }
                                        if (bg.bV(ljVar.trC)) {
                                            w.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                                            return;
                                        }
                                        aqp com_tencent_mm_protocal_c_aqp = (aqp) ljVar.trC.get(0);
                                        if (com_tencent_mm_protocal_c_aqp != null) {
                                            String str = com_tencent_mm_protocal_c_aqp.trY;
                                            bpf com_tencent_mm_protocal_c_bpf = com_tencent_mm_protocal_c_aqp.tVj;
                                            bpb com_tencent_mm_protocal_c_bpb = com_tencent_mm_protocal_c_aqp.tVl;
                                            if (!bg.mA(str)) {
                                                if (com_tencent_mm_protocal_c_bpb != null && com_tencent_mm_protocal_c_bpb.unA) {
                                                    g.KD(str);
                                                } else if (com_tencent_mm_protocal_c_bpf != null && com_tencent_mm_protocal_c_bpf.unH != null) {
                                                    if (bg.mA(com_tencent_mm_protocal_c_bpf.unH.unB)) {
                                                        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                                        wepkgCrossProcessTask.ou = 2004;
                                                        wepkgCrossProcessTask.sqr.sqL = str;
                                                        if (ab.bJb()) {
                                                            d.vL().D(new AnonymousClass6(wepkgCrossProcessTask, null));
                                                            return;
                                                        }
                                                        wepkgCrossProcessTask.iMD = new AnonymousClass7(null, wepkgCrossProcessTask);
                                                        wepkgCrossProcessTask.SM();
                                                        WepkgMainProcessService.a(wepkgCrossProcessTask);
                                                        return;
                                                    }
                                                    boolean z = com_tencent_mm_protocal_c_bpf.unH.unC;
                                                    long j = (long) com_tencent_mm_protocal_c_bpf.unH.unD;
                                                    long j2 = (long) com_tencent_mm_protocal_c_bpf.unH.unE;
                                                    WepkgMainProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                                                    wepkgCrossProcessTask2.ou = 3004;
                                                    wepkgCrossProcessTask2.sqr.sqL = str;
                                                    wepkgCrossProcessTask2.sqr.srb = z;
                                                    wepkgCrossProcessTask2.sqr.srd = j;
                                                    wepkgCrossProcessTask2.sqr.sre = j2;
                                                    if (ab.bJb()) {
                                                        wepkgCrossProcessTask2.PM();
                                                    } else {
                                                        WepkgMainProcessService.b(wepkgCrossProcessTask2);
                                                    }
                                                    wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                                                    wepkgCrossProcessTask2.ou = 3009;
                                                    wepkgCrossProcessTask2.sqr.sqL = str;
                                                    if (ab.bJb()) {
                                                        wepkgCrossProcessTask2.PM();
                                                    } else {
                                                        WepkgMainProcessService.b(wepkgCrossProcessTask2);
                                                    }
                                                    wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                                                    wepkgCrossProcessTask2.ou = 4006;
                                                    wepkgCrossProcessTask2.sqt.sqL = str;
                                                    if (ab.bJb()) {
                                                        wepkgCrossProcessTask2.PM();
                                                    } else {
                                                        WepkgMainProcessService.b(wepkgCrossProcessTask2);
                                                    }
                                                    i bAB = i.bAB();
                                                    if (com_tencent_mm_protocal_c_aqp == null || com_tencent_mm_protocal_c_aqp.tVk == null) {
                                                        w.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                                                        if (com_tencent_mm_protocal_c_aqp != null) {
                                                            bAB.aE(com_tencent_mm_protocal_c_aqp.trY, false);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    bpa com_tencent_mm_protocal_c_bpa = com_tencent_mm_protocal_c_aqp.tVk.unL;
                                                    bpg com_tencent_mm_protocal_c_bpg = com_tencent_mm_protocal_c_aqp.tVk.unM;
                                                    if (com_tencent_mm_protocal_c_bpa == null && com_tencent_mm_protocal_c_bpg == null) {
                                                        w.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                                                        g.KD(com_tencent_mm_protocal_c_aqp.trY);
                                                        return;
                                                    }
                                                    WepkgMainProcessTask wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                                                    wepkgCrossProcessTask3.ou = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                                                    WepkgVersion wepkgVersion = wepkgCrossProcessTask3.sqr;
                                                    if (com_tencent_mm_protocal_c_aqp != null) {
                                                        wepkgVersion.sqL = com_tencent_mm_protocal_c_aqp.trY;
                                                        bpf com_tencent_mm_protocal_c_bpf2 = com_tencent_mm_protocal_c_aqp.tVj;
                                                        bph com_tencent_mm_protocal_c_bph = com_tencent_mm_protocal_c_aqp.tVk;
                                                        if (com_tencent_mm_protocal_c_bpf2 != null) {
                                                            wepkgVersion.appId = com_tencent_mm_protocal_c_bpf2.mtb;
                                                            bpc com_tencent_mm_protocal_c_bpc = com_tencent_mm_protocal_c_bpf2.unH;
                                                            if (com_tencent_mm_protocal_c_bpc != null) {
                                                                wepkgVersion.version = com_tencent_mm_protocal_c_bpc.unB;
                                                                wepkgVersion.srb = com_tencent_mm_protocal_c_bpc.unC;
                                                                wepkgVersion.srd = (long) com_tencent_mm_protocal_c_bpc.unD;
                                                                wepkgVersion.sre = (long) com_tencent_mm_protocal_c_bpc.unE;
                                                            }
                                                        }
                                                        if (com_tencent_mm_protocal_c_bph != null) {
                                                            wepkgVersion.gaj = com_tencent_mm_protocal_c_bph.unK;
                                                            wepkgVersion.charset = com_tencent_mm_protocal_c_bph.umt;
                                                            bpa com_tencent_mm_protocal_c_bpa2 = com_tencent_mm_protocal_c_bph.unL;
                                                            if (com_tencent_mm_protocal_c_bpa2 == null || com_tencent_mm_protocal_c_bpa2.unz == null || bg.mA(com_tencent_mm_protocal_c_bpa2.unz.tky)) {
                                                                wepkgVersion.sri = true;
                                                            } else {
                                                                wepkgVersion.fFW = com_tencent_mm_protocal_c_bpa2.unz.tup;
                                                                wepkgVersion.downloadUrl = com_tencent_mm_protocal_c_bpa2.unz.tky;
                                                                wepkgVersion.srg = com_tencent_mm_protocal_c_bpa2.unz.unG;
                                                                wepkgVersion.sqy = com_tencent_mm_protocal_c_bpa2.unz.unF;
                                                                wepkgVersion.sri = false;
                                                            }
                                                            bpg com_tencent_mm_protocal_c_bpg2 = com_tencent_mm_protocal_c_bph.unM;
                                                            if (com_tencent_mm_protocal_c_bpg2 != null) {
                                                                wepkgVersion.srk = com_tencent_mm_protocal_c_bpg2.unJ;
                                                            }
                                                            if (com_tencent_mm_protocal_c_bpg2 == null || bg.bV(com_tencent_mm_protocal_c_bpg2.unI) || !com_tencent_mm_protocal_c_bpg2.unJ) {
                                                                wepkgVersion.srj = true;
                                                            } else {
                                                                wepkgVersion.srj = false;
                                                            }
                                                            wepkgVersion.srl = 0;
                                                        }
                                                    }
                                                    bpg com_tencent_mm_protocal_c_bpg3 = com_tencent_mm_protocal_c_aqp.tVk.unM;
                                                    if (!(com_tencent_mm_protocal_c_bpg3 == null || bg.bV(com_tencent_mm_protocal_c_bpg3.unI))) {
                                                        List arrayList = new ArrayList();
                                                        Iterator it = com_tencent_mm_protocal_c_bpg3.unI.iterator();
                                                        while (it.hasNext()) {
                                                            bpe com_tencent_mm_protocal_c_bpe = (bpe) it.next();
                                                            WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                                                            String str2 = com_tencent_mm_protocal_c_aqp.trY;
                                                            String str3 = com_tencent_mm_protocal_c_aqp.tVj.unH.unB;
                                                            if (com_tencent_mm_protocal_c_bpe != null) {
                                                                wepkgPreloadFile.arH = d.ed(str2, com_tencent_mm_protocal_c_bpe.tAk);
                                                                wepkgPreloadFile.sqL = str2;
                                                                wepkgPreloadFile.version = str3;
                                                                wepkgPreloadFile.sqw = com_tencent_mm_protocal_c_bpe.tAk;
                                                                wepkgPreloadFile.mimeType = com_tencent_mm_protocal_c_bpe.tAm;
                                                                bpd com_tencent_mm_protocal_c_bpd = com_tencent_mm_protocal_c_bpe.unz;
                                                                if (com_tencent_mm_protocal_c_bpd != null) {
                                                                    wepkgPreloadFile.fFW = com_tencent_mm_protocal_c_bpd.tup;
                                                                    wepkgPreloadFile.downloadUrl = com_tencent_mm_protocal_c_bpd.tky;
                                                                    wepkgPreloadFile.size = com_tencent_mm_protocal_c_bpd.unG;
                                                                    wepkgPreloadFile.sqy = com_tencent_mm_protocal_c_bpd.unF;
                                                                }
                                                                wepkgPreloadFile.sqM = false;
                                                            }
                                                            arrayList.add(wepkgPreloadFile);
                                                        }
                                                        wepkgCrossProcessTask3.squ = arrayList;
                                                    }
                                                    if (ab.bJb()) {
                                                        wepkgCrossProcessTask3.PM();
                                                    } else {
                                                        WepkgMainProcessService.b(wepkgCrossProcessTask3);
                                                    }
                                                    bAB.aE(com_tencent_mm_protocal_c_aqp.trY, false);
                                                }
                                            }
                                        }
                                    }
                                });
                                return;
                            } catch (Exception e) {
                                w.e("MicroMsg.Wepkg.WepkgVersionManager", "get checkwepkgversion error");
                                return;
                            }
                        }
                        w.e("MicroMsg.Wepkg.WepkgVersionManager", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                    }
                };
                if (ab.bJb()) {
                    u.a(BE, new com.tencent.mm.plugin.webview.wepkg.utils.WepkgRunCgi.AnonymousClass1(anonymousClass1));
                    return;
                }
                WepkgMainProcessTask remoteCgiTask = new RemoteCgiTask();
                d.aN(remoteCgiTask);
                remoteCgiTask.mjF = BE;
                remoteCgiTask.srC = anonymousClass1;
                remoteCgiTask.mjD = 1;
                WepkgMainProcessService.a(remoteCgiTask);
            }
        }

        public final void SK() {
        }

        public final void k(Parcel parcel) {
            if (this.sro == null) {
                this.sro = new ArrayList();
            }
            parcel.readList(this.sro, WepkgCheckReq.class.getClassLoader());
        }

        public final void v(Parcel parcel, int i) {
            parcel.writeList(this.sro);
        }
    }

    public static void cp(String str, int i) {
        if (!bg.mA(str)) {
            WepkgVersion KH = h.KH(str);
            if (KH == null) {
                E(str, "", i);
                return;
            }
            long j = KH.srh;
            if (d.XH() >= j) {
                E(str, KH.version, i);
                final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.ou = 3003;
                wepkgCrossProcessTask.sqr.sqL = str;
                if (ab.bJb()) {
                    d.vL().D(new Runnable() {
                        public final void run() {
                            wepkgCrossProcessTask.PM();
                        }
                    });
                    return;
                } else {
                    WepkgMainProcessService.a(wepkgCrossProcessTask);
                    return;
                }
            }
            w.i("MicroMsg.Wepkg.WepkgVersionManager", "currTime[%s]s < nextCheckTime[%s]s, no net request", new Object[]{Long.valueOf(d.XH()), Long.valueOf(j)});
        }
    }

    private static void E(String str, String str2, int i) {
        w.i("MicroMsg.Wepkg.WepkgVersionManager", "pkgId = " + str + ", version = " + str2);
        LinkedList linkedList = new LinkedList();
        lq lqVar = new lq();
        lqVar.trY = str;
        lqVar.jNP = str2;
        lqVar.tdM = i;
        linkedList.add(lqVar);
        aq(linkedList);
    }

    private static void aq(LinkedList<lq> linkedList) {
        if (linkedList.size() != 0) {
            final WepkgMainProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                lq lqVar = (lq) it.next();
                WepkgCheckReq wepkgCheckReq = new WepkgCheckReq();
                wepkgCheckReq.sqL = lqVar.trY;
                wepkgCheckReq.version = lqVar.jNP;
                wepkgCheckReq.scene = lqVar.tdM;
                wepkgNetSceneProcessTask.sro.add(wepkgCheckReq);
            }
            if (ab.bJb()) {
                d.vL().D(new Runnable() {
                    public final void run() {
                        wepkgNetSceneProcessTask.PM();
                    }
                });
            } else {
                WepkgMainProcessService.a(wepkgNetSceneProcessTask);
            }
        }
    }
}
