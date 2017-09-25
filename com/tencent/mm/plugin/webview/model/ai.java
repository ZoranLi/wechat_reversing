package com.tencent.mm.plugin.webview.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class ai {
    public static int mlK = 0;
    public static int rXu = 0;
    public l rXi;
    public j rXj;
    public k rXk;
    public i rXl;
    public e rXm;
    public a rXn;
    public f rXo;
    public c rXp;
    private d rXq;
    private h rXr;
    private g rXs;
    private b rXt;

    public static class a {
        public String fWY;
        public boolean rXv = false;
        public boolean rXw = false;
    }

    public static class b {
        public boolean rXx = false;
        public boolean rXy = false;
    }

    public static class c {
        public Object[] rXz = null;

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11577, this.rXz);
            }
        }
    }

    public class d {
        public int gaA;
        public String mkT = "";
        public HashMap<String, Long> rXA = new HashMap();
        public HashMap<String, Long> rXB = new HashMap();
        public boolean rXC = true;
        public String rXD;
        final /* synthetic */ ai rXE;

        public d(ai aiVar) {
            this.rXE = aiVar;
        }

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                String str;
                long longValue;
                Object[] objArr;
                int bwu = ai.bwu();
                for (Entry entry : this.rXA.entrySet()) {
                    str = (String) entry.getKey();
                    longValue = ((Long) entry.getValue()).longValue();
                    if (longValue >= 0 && longValue <= 180000) {
                        objArr = new Object[11];
                        objArr[0] = Integer.valueOf(5);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bwu);
                        if (str != null) {
                            str = str.replace(",", "!");
                        }
                        objArr[3] = str;
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ai.mlK);
                        objArr[8] = Integer.valueOf(ai.rXu);
                        objArr[9] = Integer.valueOf(this.gaA);
                        objArr[10] = this.rXD;
                        com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
                        if (ai.mlK == 1) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(32, 18, 1, true);
                            com.tencent.mm.plugin.report.service.g.oUh.a(32, 19, longValue, true);
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.a(32, 8, 1, true);
                        com.tencent.mm.plugin.report.service.g.oUh.a(32, 9, longValue, true);
                        w.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{Long.valueOf(longValue), Integer.valueOf(bwu), Integer.valueOf(ai.mlK), Integer.valueOf(ai.rXu), Integer.valueOf(this.gaA), this.rXD});
                    } else {
                        return;
                    }
                }
                for (Entry entry2 : this.rXB.entrySet()) {
                    str = (String) entry2.getKey();
                    longValue = ((Long) entry2.getValue()).longValue();
                    if (longValue >= 0 && longValue <= 180000) {
                        objArr = new Object[11];
                        objArr[0] = Integer.valueOf(6);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bwu);
                        if (str != null) {
                            str = str.replace(",", "!");
                        }
                        objArr[3] = str;
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ai.mlK);
                        objArr[8] = Integer.valueOf(ai.rXu);
                        objArr[9] = Integer.valueOf(this.gaA);
                        objArr[10] = this.rXD;
                        com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
                        if (ai.mlK == 1) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(32, 20, 1, true);
                            com.tencent.mm.plugin.report.service.g.oUh.a(32, 21, longValue, true);
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.a(32, 10, 1, true);
                        com.tencent.mm.plugin.report.service.g.oUh.a(32, 11, longValue, true);
                        w.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{Long.valueOf(longValue), Integer.valueOf(bwu), Integer.valueOf(ai.mlK), Integer.valueOf(ai.rXu), Integer.valueOf(this.gaA), this.rXD});
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public class e {
        public int gaA;
        public boolean kaI = false;
        public String rXD;
        final /* synthetic */ ai rXE;
        public long startTime = bg.Nz();
        public String url;

        public e(ai aiVar) {
            this.rXE = aiVar;
        }
    }

    public static class f {
        public Object[] rXz = null;

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11576, this.rXz);
            }
        }
    }

    public static class g {
        public List<String> rXF;
    }

    public static class h {
        public List<String> rXF;
    }

    public static class i {
        public String appId;
        public String fWY;
        long gKS = (System.currentTimeMillis() / 1000);
        public String gxO;
        public long jgn;
        public String mkU;
        public String qui;
        public String rXG;
        public String rXH;
        public long rXI;
        public int rXJ;
        public String rXK;
        public String rXL;
        public String rXM;
        public int rXN;
        public long rXO = -1;
        public int scene;
        public String title;
        public String username;
    }

    public class j {
        public int gaA;
        public String rXD;
        final /* synthetic */ ai rXE;
        public HashMap<String, Long> rXP = new HashMap();

        public j(ai aiVar) {
            this.rXE = aiVar;
        }

        public final void ax(String str, boolean z) {
            if (bg.mA(str)) {
                w.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
            } else if (!this.rXP.containsKey(str)) {
            } else {
                if (z) {
                    this.rXP.put(str, Long.valueOf(bg.Nz() - ((Long) this.rXP.get(str)).longValue()));
                    return;
                }
                this.rXP.put(str, Long.valueOf(-1));
            }
        }

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                int bwu = ai.bwu();
                for (Entry entry : this.rXP.entrySet()) {
                    String str = (String) entry.getKey();
                    long longValue = ((Long) entry.getValue()).longValue();
                    com.tencent.mm.plugin.report.service.g.oUh.a(32, 2, 1, true);
                    if (longValue == -1) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(32, 13, 1, true);
                        w.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[]{str, Integer.valueOf(bwu)});
                    }
                    if (longValue >= 0 && longValue <= 60000) {
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bwu);
                        objArr[3] = str == null ? str : str.replace(",", "!");
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ai.mlK);
                        objArr[8] = Integer.valueOf(ai.rXu);
                        objArr[9] = Integer.valueOf(this.gaA);
                        objArr[10] = this.rXD;
                        com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
                        w.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{str, Long.valueOf(longValue), Integer.valueOf(bwu), Integer.valueOf(this.gaA), this.rXD});
                        com.tencent.mm.plugin.report.service.g.oUh.a(32, 6, longValue, true);
                    }
                }
            }
        }
    }

    public class k {
        public int gaA;
        public String rXD;
        final /* synthetic */ ai rXE;
        public HashMap<String, Long> rXQ = new HashMap();

        public k(ai aiVar) {
            this.rXE = aiVar;
        }
    }

    public class l {
        public boolean fHO = true;
        public int gaA;
        public long jgm;
        public String rXD;
        final /* synthetic */ ai rXE;
        public String url;

        public l(ai aiVar) {
            this.rXE = aiVar;
        }
    }

    public static int bwu() {
        switch (am.getNetType(ab.getContext())) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 1:
            case 6:
            case 8:
                return 3;
            case 2:
            case 5:
            case 7:
                return 2;
            case 3:
            case 4:
                return 4;
            case 10:
                return 5;
            default:
                return 6;
        }
    }

    public static String bwv() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ab.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        w.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[]{activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo()});
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public final l bww() {
        if (this.rXi == null) {
            this.rXi = new l(this);
        }
        return this.rXi;
    }

    public final j bwx() {
        if (this.rXj == null) {
            this.rXj = new j(this);
        }
        return this.rXj;
    }

    public final k bwy() {
        if (this.rXk == null) {
            this.rXk = new k(this);
        }
        return this.rXk;
    }

    public final d bwz() {
        if (this.rXq == null) {
            this.rXq = new d(this);
        }
        return this.rXq;
    }

    public final i bwA() {
        if (this.rXl == null) {
            this.rXl = new i();
        }
        return this.rXl;
    }

    public final e bwB() {
        if (this.rXm == null) {
            this.rXm = new e(this);
        }
        return this.rXm;
    }

    public final a bwC() {
        if (this.rXn == null) {
            this.rXn = new a();
        }
        return this.rXn;
    }

    public final f bwD() {
        if (this.rXo == null) {
            this.rXo = new f();
        }
        return this.rXo;
    }

    public final c bwE() {
        if (this.rXp == null) {
            this.rXp = new c();
        }
        return this.rXp;
    }

    public final h bwF() {
        if (this.rXr == null) {
            this.rXr = new h();
        }
        return this.rXr;
    }

    public final g bwG() {
        if (this.rXs == null) {
            this.rXs = new g();
        }
        return this.rXs;
    }

    public final b bwH() {
        if (this.rXt == null) {
            this.rXt = new b();
        }
        return this.rXt;
    }

    public static void z(boolean z, boolean z2) {
        if (z) {
            mlK = 1;
        } else {
            mlK = 0;
        }
        if (z2) {
            rXu = 1;
        } else {
            rXu = 0;
        }
    }

    public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
        k bwy = bwy();
        if (dVar != null) {
            int bwu = bwu();
            for (Entry entry : bwy.rXQ.entrySet()) {
                String str = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                com.tencent.mm.plugin.report.service.g.oUh.a(32, 0, 1, true);
                if (longValue >= 0 && longValue <= 180000) {
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bwu);
                    objArr[3] = str == null ? str : str.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(mlK);
                    objArr[8] = Integer.valueOf(rXu);
                    objArr[9] = Integer.valueOf(bwy.gaA);
                    objArr[10] = bwy.rXD;
                    com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
                    com.tencent.mm.plugin.report.service.g.oUh.a(160, 0, 1, false);
                    if (-1 != com.tencent.mm.plugin.webview.ui.tools.a.dX(longValue)) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(160, (long) com.tencent.mm.plugin.webview.ui.tools.a.dX(longValue), 1, false);
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.a(32, 3, 1, true);
                    com.tencent.mm.plugin.report.service.g.oUh.a(32, 7, longValue, true);
                    if (rXu == 1) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(32, 16, 1, true);
                        com.tencent.mm.plugin.report.service.g.oUh.a(32, 17, longValue, true);
                    }
                    w.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{str, Long.valueOf(longValue), Integer.valueOf(bwu), Integer.valueOf(mlK), Integer.valueOf(rXu), Integer.valueOf(bwy.gaA), bwy.rXD});
                }
            }
        }
        i bwA = bwA();
        if (!bg.mA(bwA.rXH)) {
            w.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[]{bwA.rXH});
        }
        if (dVar != null) {
            Object obj;
            String str2 = "";
            try {
                Bundle d = dVar.d(23, new Bundle(0));
                if (d != null) {
                    str2 = d.getString("config_info_username");
                }
                obj = str2;
            } catch (RemoteException e) {
                w.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[]{e});
                String str3 = str2;
            }
            PString pString = new PString();
            w.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s", new Object[]{Integer.valueOf(10643), bwA.username, Long.valueOf(bwA.rXI), Integer.valueOf(bwA.rXJ), Integer.valueOf(bwA.scene), Long.valueOf(bwA.gKS), Long.valueOf(bwA.jgn), bwA.fWY, bwA.rXG, bwA.rXH, bwA.mkU, bwA.appId, bwA.rXK, bwA.rXL, obj, bwA.rXM, bwA.qui, ((com.tencent.mm.plugin.sns.b.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.h.class)).a(bwA.qui, pString), Integer.valueOf(bwA.rXN), bwA.title, bwA.gxO, pString.value});
            str2 = bwA.title;
            try {
                str2 = URLEncoder.encode(bwA.title, "UTF-8");
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.WebviewReporter", e2, "", new Object[0]);
            }
            Object[] objArr2 = new Object[20];
            objArr2[0] = bwA.username;
            objArr2[1] = Long.valueOf(bwA.rXI);
            objArr2[2] = Integer.valueOf(bwA.rXJ);
            objArr2[3] = Integer.valueOf(bwA.scene);
            objArr2[4] = Long.valueOf(bwA.gKS);
            objArr2[5] = Long.valueOf(bwA.jgn);
            objArr2[6] = bwA.fWY == null ? bwA.fWY : bwA.fWY.replace(",", "!");
            objArr2[7] = bwA.rXG;
            objArr2[8] = bwA.rXH;
            objArr2[9] = bwA.mkU;
            objArr2[10] = bwA.appId;
            objArr2[11] = bwA.rXK;
            objArr2[12] = bwA.rXL;
            objArr2[13] = obj;
            objArr2[14] = bwA.rXM == null ? bwA.rXM : bwA.rXM.replace(",", "!");
            objArr2[15] = r7;
            objArr2[16] = Integer.valueOf(bwA.rXN);
            objArr2[17] = str2;
            objArr2[18] = bwA.gxO;
            objArr2[19] = pString.value;
            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 10643, objArr2);
        }
        bwx().b(dVar);
        bwz().b(dVar);
        a bwC = bwC();
        if (dVar != null) {
            int bwu2 = bwu();
            if (!bwC.rXw) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bwC.fWY, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(bwu2));
            } else if (bwC.rXv) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bwC.fWY, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(bwu2));
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bwC.fWY, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(bwu2));
            }
        }
    }
}
