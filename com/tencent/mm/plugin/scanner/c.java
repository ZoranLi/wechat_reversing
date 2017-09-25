package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.history.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.HashMap;

public final class c implements am {
    private static HashMap<Integer, com.tencent.mm.bj.g.c> gJr;
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, com.tencent.mm.bj.g.c> oUw = new HashMap();
    public String gYf;
    private a oUx;
    private j oVA = new j();
    private m oVB = new m();
    private b oVC;
    private com.tencent.mm.plugin.scanner.a.b oVD = new com.tencent.mm.plugin.scanner.a.b();
    public com.tencent.mm.plugin.z.a.b oVz = new com.tencent.mm.plugin.z.a.b();

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return b.gUx;
            }
        });
    }

    public static c aXW() {
        c cVar = (c) ap.yR().gs("plugin.scanner");
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        ap.yR().a("plugin.scanner", cVar2);
        return cVar2;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.oVA);
        com.tencent.mm.sdk.b.a.urY.c(this.oVB.oWE);
        com.tencent.mm.sdk.b.a.urY.c(this.oVB.oWF);
        com.tencent.mm.plugin.scanner.a.b bVar = this.oVD;
        com.tencent.mm.sdk.b.a.urY.c(bVar.oWb);
        com.tencent.mm.sdk.b.a.urY.c(bVar.oWc);
        bVar.aXY();
        com.tencent.mm.plugin.z.a.b bVar2 = this.oVz;
        bVar2.hHV.clear();
        bVar2.oGe.clear();
        bVar2.oGf.clear();
        if (this.oUx != null) {
            this.oUx.ha(hashCode());
            this.oUx = null;
        }
        this.gYf = "";
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        this.oUx = g.a(hashCode(), stringBuilder.append(com.tencent.mm.u.c.xu()).append("CommonOneMicroMsg.db").toString(), oUw, false);
        com.tencent.mm.plugin.scanner.a.b bVar = this.oVD;
        com.tencent.mm.sdk.b.a.urY.b(bVar.oWb);
        com.tencent.mm.sdk.b.a.urY.b(bVar.oWc);
        com.tencent.mm.sdk.b.a.urY.b(this.oVA);
        com.tencent.mm.sdk.b.a.urY.b(this.oVB.oWE);
        com.tencent.mm.sdk.b.a.urY.b(this.oVB.oWF);
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ c oVE;

            {
                this.oVE = r1;
            }

            public final void run() {
                if (!ap.zb()) {
                    return;
                }
                if (bg.mA(this.oVE.gYf)) {
                    w.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
                } else {
                    bg.d(this.oVE.gYf + "image/scan/img", "scanbook", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void aN(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("onSdcardMount ");
        ap.yY();
        w.d("MicroMsg.scanner.SubCoreScanner", stringBuilder.append(com.tencent.mm.u.c.xv()).toString());
        c aXW = aXW();
        ap.yY();
        String xv = com.tencent.mm.u.c.xv();
        w.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : " + xv);
        aXW.gYf = xv;
        File file = new File(xv);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(xv + "image/scan/img");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(xv + "image/scan/music");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String xv() {
        return aXW().gYf;
    }

    public final String dl(String str, String str2) {
        if (!ap.zb() || bg.mA(str)) {
            return "";
        }
        return String.format("%s/scanbook%s_%s", new Object[]{this.gYf + "image/scan/img", str2, com.tencent.mm.a.g.n(str.getBytes())});
    }

    public static b aXX() {
        h.vG().uQ();
        if (aXW().oVC == null) {
            c aXW = aXW();
            ap.yY();
            aXW.oVC = new b(com.tencent.mm.u.c.wO());
        }
        return aXW().oVC;
    }
}
