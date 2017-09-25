package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class b {
    private static final b jgi = new b(true);
    public String appId;
    public int fCM;
    public String fCN;
    public String fCO;
    public String fFF;
    public int fWF;
    public int fWL;
    public String fWM;
    public h ixr;
    public int jfY;
    private final boolean jgh;
    public final LinkedList<String> jgj = new LinkedList();
    public boolean jgk = false;
    public String jgl;
    public long jgm;
    public long jgn;
    public String jgo;
    public int jgp;
    public String jgq;
    public long jgr;
    public int jgs;
    public int jgt;
    public String jgu;
    private boolean jgv = true;
    public int scene;

    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] ivI = new int[c.values().length];

        static {
            try {
                ivI[c.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ivI[c.HANG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ivI[c.LAUNCH_MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private b(boolean z) {
        this.jgh = z;
    }

    public static b Ww() {
        return jgi;
    }

    public static b a(h hVar, String str, LinkedList<String> linkedList) {
        b bVar = new b(false);
        bVar.fFF = str;
        AppBrandStatObject mZ = com.tencent.mm.plugin.appbrand.b.mZ(hVar.ivH);
        bVar.scene = mZ.scene;
        bVar.fCN = mZ.fCN;
        bVar.appId = hVar.ivH;
        bVar.ixr = hVar;
        bVar.fCM = hVar.iwo.iFk.izV + 1;
        bVar.fWF = hVar.iwo.iFk.izW;
        bVar.jfY = mZ.jfY;
        bVar.fWL = mZ.fWL;
        bVar.fWM = mZ.fWM;
        if (linkedList != null) {
            bVar.jgj.addAll(linkedList);
        }
        return bVar;
    }

    public final void d(m mVar) {
        int i;
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(this.appId);
        if (mY != null) {
            this.fWF = mY.iFk.izW;
            this.jgs = mY.iFl.izW;
        }
        this.jgr = mVar.jdl.jdu;
        this.jgm = Math.max(0, mVar.jdl.jdv);
        this.jgn = Math.max(0, mVar.jdl.jdt.jga);
        this.fCO = mVar.jde.jdU;
        this.jgu = mVar.jde.jdV;
        this.jgl = a.bz(ab.getContext());
        if (this.jgv) {
            i = 1;
        } else {
            i = 0;
        }
        this.jgt = i;
        this.jgv = false;
    }

    public final String toString() {
        return "kv_13536{scene=" + this.scene + ", sceneNote='" + this.fCN + '\'' + ", sessionId='" + this.fFF + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.fWF + ", appState=" + this.fCM + ", usedState=" + this.jfY + ", pagePath='" + this.fCO + '\'' + ", networkType='" + this.jgl + '\'' + ", costTime=" + this.jgm + ", stayTime=" + this.jgn + ", referPagePath='" + this.jgo + '\'' + ", targetAction=" + this.jgp + ", targetPagePath='" + this.jgq + '\'' + ", clickTimestamp=" + this.jgr + ", publicLibVersion=" + this.jgs + ", preScene=" + this.fWL + ", preSceneNote='" + this.fWM + '\'' + ", isEntrance=" + this.jgt + '}';
    }

    public final void qg() {
        if (!this.jgh) {
            w.i("MicroMsg.AppBrand.Report.kv_13536", "report " + toString());
            final Object[] objArr = new Object[]{Integer.valueOf(this.scene), this.fCN, this.fFF, this.appId, Integer.valueOf(this.fWF), Integer.valueOf(this.fCM), Integer.valueOf(this.jfY), this.fCO, this.jgl, Long.valueOf(this.jgm), Long.valueOf(this.jgn), this.jgo, Integer.valueOf(this.jgp), this.jgq, Long.valueOf(this.jgr), Integer.valueOf(this.jgs), Integer.valueOf(this.fWL), this.fWM, Integer.valueOf(this.jgt), this.jgu};
            Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ b jgx;

                public final void run() {
                    try {
                        String str = (String) objArr[objArr.length - 1];
                        if (!bg.mA(str)) {
                            int indexOf = str.indexOf(63);
                            if (indexOf < 0) {
                                str = "";
                            } else {
                                str = p.encode(str.substring(indexOf + 1, str.length()));
                            }
                            objArr[objArr.length - 1] = str;
                        }
                    } catch (Exception e) {
                        objArr[objArr.length - 1] = "";
                    }
                    g.oUh.i(13536, d.g(objArr));
                }
            };
            if (this.jgk) {
                anonymousClass1.run();
                try {
                    KVCommCrossProcessReceiver.aXE();
                    return;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", e, "sendKV", new Object[0]);
                    return;
                }
            }
            com.tencent.mm.plugin.appbrand.m.d.vL().D(anonymousClass1);
        }
    }
}
