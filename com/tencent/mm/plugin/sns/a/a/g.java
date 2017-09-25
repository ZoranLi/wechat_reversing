package com.tencent.mm.plugin.sns.a.a;

import android.app.Activity;
import android.view.View;
import com.tencent.mm.e.a.jq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.c.bb;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class g implements b {
    public static Map<String, Integer> pPg = new HashMap();
    public Activity activity;
    public long jXw = 0;
    public int nXW = 1;
    public HashMap<String, Long> pOX = new HashMap();
    public HashSet<Long> pOY = new HashSet();
    public Map<String, Long> pOZ = new HashMap();
    public int pOu = 0;
    public Map<String, Integer> pPa = new HashMap();
    public HashSet<Long> pPb = new HashSet();
    public Map<Long, h> pPc = new HashMap();
    public Map<String, a> pPd = new HashMap();
    private LinkedList<String> pPe = new LinkedList();
    private Map<String, Integer> pPf = new HashMap();
    private int pPh = 0;
    public View pPi = null;
    private a pPj = null;
    private int pPk = -1;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int iVb;
        final /* synthetic */ long pPl;
        final /* synthetic */ g pPm;
        final /* synthetic */ boolean pPn = true;

        AnonymousClass2(g gVar, long j, int i, boolean z) {
            this.pPm = gVar;
            this.pPl = j;
            this.iVb = i;
        }

        public final void run() {
            this.pPm.e(this.pPl, this.iVb, this.pPn);
        }
    }

    static class a {
        public String fWy;
        public String hTm;
        public long hTn;
        public int knu;
        public int position;
        public long time;

        public a(long j, String str, int i, String str2, int i2, long j2) {
            this.time = j;
            this.fWy = str;
            this.position = i;
            this.hTm = str2;
            this.hTn = j2;
            this.knu = i2;
        }
    }

    public final boolean cZ(long j) {
        return this.pOY.contains(Long.valueOf(j));
    }

    public g(int i) {
        this.nXW = i;
    }

    public final void onResume() {
        if (this.jXw > 0) {
            long aB = bg.aB(this.jXw);
            for (String str : this.pPd.keySet()) {
                w.i("MicroMsg.SnsAdStatistic", "before Key " + str + " " + ((a) this.pPd.get(str)).time);
            }
            for (String str2 : this.pPd.keySet()) {
                a aVar = (a) this.pPd.get(str2);
                aVar.time -= aB;
            }
            for (String str22 : this.pPd.keySet()) {
                w.i("MicroMsg.SnsAdStatistic", "update Key " + str22 + " " + ((a) this.pPd.get(str22)).time);
            }
        }
    }

    public final void da(final long j) {
        af.v(new Runnable(this) {
            final /* synthetic */ g pPm;

            public final void run() {
                if (this.pPm.cZ(j)) {
                    g gVar = this.pPm;
                    long j = j;
                    h hVar = gVar.pPc.containsKey(Long.valueOf(j)) ? (h) gVar.pPc.get(Long.valueOf(j)) : new h("timeline");
                    hVar.pPq = 1;
                    hVar.pPx.pQt++;
                    gVar.pPc.put(Long.valueOf(j), hVar);
                }
            }
        });
    }

    public final void u(long j, int i) {
        af.v(new AnonymousClass2(this, j, i, true));
    }

    public final void e(long j, int i, boolean z) {
        h hVar;
        if (this.pPc.containsKey(Long.valueOf(j))) {
            hVar = (h) this.pPc.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (i > 0) {
            hVar.pPx.pQv = i;
        }
        hVar.pPq = z ? 1 : 0;
        this.pPc.put(Long.valueOf(j), hVar);
    }

    public final void l(long j, boolean z) {
        h hVar;
        if (this.pPc.containsKey(Long.valueOf(j))) {
            hVar = (h) this.pPc.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (z) {
            hVar.pPx.pQw = 2;
        } else {
            hVar.pPx.pQw = 1;
        }
        hVar.pPx.pQx = 1;
        this.pPc.put(Long.valueOf(j), hVar);
    }

    public final void p(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        af.v(new Runnable(this) {
            final /* synthetic */ g pPm;

            public final void run() {
                if (this.pPm.cZ(j3)) {
                    g gVar = this.pPm;
                    long j = j4;
                    if (!gVar.pPb.contains(Long.valueOf(j))) {
                        gVar.pPb.add(Long.valueOf(j));
                    }
                }
            }
        });
    }

    public final boolean db(long j) {
        if (this.pPb.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public final void q(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        af.v(new Runnable(this) {
            final /* synthetic */ g pPm;

            public final void run() {
                if (this.pPm.cZ(j3)) {
                    g gVar = this.pPm;
                    long j = j3;
                    long j2 = j4;
                    h hVar = gVar.pPc.containsKey(Long.valueOf(j)) ? (h) gVar.pPc.get(Long.valueOf(j)) : new h("timeline");
                    if (hVar.pPx.pQy == 0) {
                        hVar.pPx.pQy = j2;
                    }
                    gVar.pPc.put(Long.valueOf(j), hVar);
                }
            }
        });
    }

    public final void a(int i, String str, String str2, boolean z, View view, long j, be beVar, bbk com_tencent_mm_protocal_c_bbk, int i2, int i3) {
        this.pOY.add(Long.valueOf(j));
        this.pOX.put(str, Long.valueOf(j));
        if (this.pPk == -1) {
            this.pPk = this.activity == null ? -1 : e.ds(this.activity);
        }
        if (this.pPj == null && view != null && ae.pVr) {
            this.pPj = new a(beVar == null ? null : beVar.qKA, j, view, this.pOu, this.pPi, this.pPk, this.nXW, com_tencent_mm_protocal_c_bbk, i);
            a aVar = this.pPj;
            aVar.pOC = System.currentTimeMillis();
            ae.ayz().post(new Runnable(aVar) {
                final /* synthetic */ a pOV;

                {
                    this.pOV = r1;
                }

                public final void run() {
                    if (!this.pOV.pOo) {
                        this.pOV.bdm();
                    }
                }
            });
        }
        if (this.pOZ.containsKey(str)) {
            long aB = bg.aB(((Long) this.pOZ.get(str)).longValue());
            if (aB < 1200000) {
                int intValue = this.pPa.containsKey(str) ? ((Integer) this.pPa.get(str)).intValue() : 0;
                if (intValue >= 2) {
                    w.i("MicroMsg.SnsAdStatistic", "passed localid " + str + " viewid " + str2 + " passedTime: " + aB);
                    return;
                }
                this.pPa.put(str, Integer.valueOf(intValue + 1));
            } else {
                this.pOZ.put(str, Long.valueOf(bg.NA()));
                this.pPa.put(str, Integer.valueOf(0));
            }
        }
        if (!this.pPd.containsKey(str)) {
            k dVar;
            this.pPd.put(str, new a(bg.NA(), str, i, str2, i2, j));
            w.i("MicroMsg.SnsAdStatistic", "onAdAdded " + i + " " + str + "  isExposure: " + z);
            if (i2 == 9) {
                h hVar;
                if (this.pPc.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.pPc.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.pPs = bg.NA();
                this.pPc.put(Long.valueOf(j), hVar);
            }
            if (!this.pPe.contains(str)) {
                this.pPe.add(str);
                w.i("MicroMsg.SnsAdStatistic", "exposures item " + str);
                this.pPf.put(str, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            }
            m Gg = ae.beL().Gg(str);
            b bha = Gg.bha();
            bfc bhd = Gg.bhd();
            com.tencent.mm.protocal.c.be beVar2 = null;
            if (this.pPj != null && ae.pVr) {
                beVar2 = this.pPj.bdn();
            }
            c bhJ = Gg.bhJ();
            int i4 = 0;
            if (i3 == 1) {
                i4 = bhJ.field_exposureCount + 1;
                bhJ.field_exposureCount = i4;
                ae.beN().c(bhJ, new String[0]);
            }
            if (bha.bfI()) {
                dVar = new d(str2, this.nXW, beVar2, 3, i4);
            } else if (bha.bfJ()) {
                if (bhd == null || bhd.ufB.tsN != 15 || bhd.ufI == 1) {
                    dVar = new d(str2, this.nXW, beVar2, 4, i4);
                } else {
                    dVar = new d(str2, this.nXW, beVar2, 5, i4);
                }
            } else if (i2 == 9) {
                dVar = new d(str2, this.nXW, beVar2, 2, i4);
            } else {
                dVar = new d(str2, this.nXW, beVar2, 1, i4);
            }
            h.vJ();
            h.vH().gXC.a(dVar, 0);
        }
    }

    public final void q(int i, String str, String str2) {
        if (this.pOX.containsKey(str)) {
            this.pOY.remove(Long.valueOf(((Long) this.pOX.remove(str)).longValue()));
        }
        bb bbVar = null;
        com.tencent.mm.protocal.c.be beVar = null;
        if (this.pPj != null && ae.pVr) {
            a aVar = this.pPj;
            aVar.kgf = true;
            aVar.pOD = System.currentTimeMillis();
            aVar = this.pPj;
            if (aVar.pOy < 0) {
                aVar.pOT = 2;
            } else {
                aVar.pOT = 1;
            }
            if (aVar.pOA < 0) {
                aVar.pOU = 2;
            } else {
                aVar.pOU = 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.df(aVar.hTn) + ",");
            stringBuilder.append(aVar.hTo + ",");
            stringBuilder.append(aVar.pOT + ",");
            stringBuilder.append(aVar.pOU + ",");
            stringBuilder.append(aVar.pOQ + ",");
            stringBuilder.append(aVar.pOR + ",");
            stringBuilder.append(aVar.pOS + ",");
            stringBuilder.append(aVar.pOC + ",");
            stringBuilder.append(aVar.pOD + ",");
            if (aVar.pOG > 0 && aVar.pOJ == 0) {
                aVar.pOJ = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.pOG + ",");
            stringBuilder.append(aVar.pOJ + ",");
            if (aVar.pOM > 0 && aVar.pOP == 0) {
                aVar.pOP = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.pOM + ",");
            stringBuilder.append(aVar.pOP);
            f.a(aVar.hTn, stringBuilder);
            w.i("MicroMsg.AdViewStatic", "report " + stringBuilder.toString());
            bbVar = new bb();
            bbVar.tew = aVar.pOM;
            bbVar.tex = aVar.pOP;
            bbVar.pOT = aVar.pOT;
            bbVar.pOU = aVar.pOU;
            bbVar.ter = (float) aVar.pOQ;
            bbVar.tes = (float) aVar.pOR;
            bbVar.tet = (float) aVar.pOS;
            bbVar.teu = aVar.pOG;
            bbVar.tev = aVar.pOJ;
            bbVar.startTime = aVar.pOC;
            bbVar.endTime = aVar.pOD;
            ae.beF().i(12010, stringBuilder.toString());
            com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
            gz.kG(i.df(aVar.hTn)).kG(aVar.hTo).gC(aVar.pOT).gC(aVar.pOU).gC(aVar.pOQ).gC(aVar.pOR).gC(aVar.pOS).kG(aVar.pOC).kG(aVar.pOD).kG(aVar.pOG).kG(aVar.pOJ).kG(aVar.pOM).kG(aVar.pOP);
            gz.JE();
            com.tencent.mm.sdk.b.b jqVar = new jq();
            jqVar.fQd.position = aVar.position;
            com.tencent.mm.sdk.b.a.urY.m(jqVar);
            if (r.ijB) {
                int nextInt = new Random(System.currentTimeMillis()).nextInt(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) + 10;
                w.i("MicroMsg.AdViewStatic", "run on test kv " + nextInt);
                for (int i2 = 0; i2 < nextInt; i2++) {
                    ae.beF().i(12010, stringBuilder.toString());
                }
            }
            beVar = this.pPj.bdn();
            this.pPj = null;
        }
        if (this.pPd.containsKey(str)) {
            a aVar2 = (a) this.pPd.remove(str);
            this.pOZ.put(str, Long.valueOf(bg.NA()));
            if (aVar2 != null) {
                long aB = bg.aB(aVar2.time);
                w.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + i + " " + str + " " + aB + " ");
                m Gg = ae.beL().Gg(str);
                if (Gg != null) {
                    int i3;
                    String str3;
                    String str4 = "";
                    bfc bhd = Gg.bhd();
                    b bha = Gg.bha();
                    if (bha.bfI()) {
                        i3 = 3;
                        str3 = str4;
                    } else if (bha.bfJ()) {
                        if (bhd == null || bhd.ufB.tsN != 15 || bhd.ufI == 1) {
                            i3 = 4;
                            str3 = str4;
                        } else {
                            String bdp;
                            i3 = 5;
                            r1 = (h) this.pPc.remove(Long.valueOf(aVar2.hTn));
                            if (r1 != null) {
                                r1.sM(0);
                                bdp = r1.bdp();
                            } else {
                                bdp = str4;
                            }
                            this.pPb.remove(Long.valueOf(aVar2.hTn));
                            str3 = bdp;
                        }
                    } else if (aVar2.knu == 9) {
                        i3 = 2;
                        r1 = (h) this.pPc.remove(Long.valueOf(aVar2.hTn));
                        if (r1 != null) {
                            r1.sM(0);
                            str4 = r1.bdp();
                        }
                        this.pPb.remove(Long.valueOf(aVar2.hTn));
                        str3 = str4;
                    } else {
                        i3 = 1;
                        str3 = str4;
                    }
                    k dVar = new d(str2, this.nXW, 2, (int) aB, bbVar, beVar, i3, str3, -1);
                    h.vJ();
                    h.vH().gXC.a(dVar, 0);
                    return;
                }
                return;
            }
            return;
        }
        w.i("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + i + " " + str);
    }

    public final void bdo() {
        if (this.pPj != null && ae.pVr) {
            this.pPj.bdm();
        }
    }

    public final void clear() {
        String str;
        w.i("MicroMsg.SnsAdStatistic", "clean the adRemove" + this.pPe.size());
        List<String> linkedList = new LinkedList();
        for (String str2 : this.pPd.keySet()) {
            linkedList.add(str2);
        }
        for (String str22 : linkedList) {
            a aVar = (a) this.pPd.get(str22);
            q(aVar.position, aVar.fWy, aVar.hTm);
        }
        Iterator it = this.pPe.iterator();
        while (it.hasNext()) {
            str22 = (String) it.next();
            com.tencent.mm.plugin.sns.storage.e tD = ae.beN().tD(u.GB(str22));
            if (tD != null) {
                int intValue;
                m bhf = tD.bhf();
                tD.field_localFlag |= FileUtils.S_IWUSR;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (this.pPf.containsKey(str22)) {
                    intValue = ((Integer) this.pPf.get(str22)).intValue();
                } else {
                    intValue = currentTimeMillis;
                }
                if (tD.field_exposureTime <= 0) {
                    tD.field_exposureTime = intValue;
                }
                bhf.field_localFlag |= FileUtils.S_IWUSR;
                ae.beL().b(bhf.field_snsId, bhf);
                ae.beN().b(tD.field_snsId, tD);
            }
        }
        this.pPe.clear();
        this.pPf.clear();
    }
}
