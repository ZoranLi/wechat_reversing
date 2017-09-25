package com.tencent.mm.modelstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.o;
import com.tencent.mm.a.q;
import com.tencent.mm.accessibility.AccessibilityCapture;
import com.tencent.mm.accessibility.AccessibilityCapture.APIProvider;
import com.tencent.mm.accessibility.AccessibilityCapture.Event;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public class c implements APIProvider {
    private static c hUO;
    aj hUP = null;
    private final int hUQ = 20971520;
    ArrayList<b> hUR = new ArrayList();
    private String hUS = null;
    private long hUT = 0;
    private ArrayList<c> hUU = new ArrayList();
    boolean hUV = false;
    Map<String, Boolean> hUW = new HashMap();
    private long hUX = 0;
    long hUY = 0;
    private List<d> hUZ = new ArrayList();
    public ae handler = null;

    private static class a {
        Map<String, Boolean> hUW = new HashMap();
        long hUX;
        long hUY;
        List<c> hVg = new ArrayList();

        static class a extends Exception {
            a(String str) {
                super(str);
            }

            a(Throwable th) {
                super(th);
            }
        }

        private a() {
        }

        public final String toString() {
            return "Config{nextUpdateInterval=" + this.hUX + ", samplePeriod=" + this.hUY + ", eventList=" + this.hVg + '}';
        }

        public static a kP(String str) {
            a aVar = new a();
            try {
                Map q = bh.q(str, "eventSampleConf");
                if (q == null) {
                    w.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", str);
                    throw new a("reportConfigMap is null");
                }
                aVar.hUX = bg.getLong((String) q.get(".eventSampleConf.nextUpdateInterval"), 0);
                if (aVar.hUX <= 0 || aVar.hUX > 432000) {
                    aVar.hUX = 432000;
                }
                aVar.hUY = bg.getLong((String) q.get(".eventSampleConf.samplePeriod"), 0);
                int i = 0;
                while (true) {
                    c cVar = new c();
                    String str2 = ".eventSampleConf.events.event" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                    int i2 = i + 1;
                    cVar.id = bg.getInt((String) q.get(str2 + SlookAirButtonFrequentContactAdapter.ID), 0);
                    if (cVar.id > 0) {
                        String str3;
                        int i3;
                        String str4;
                        cVar.hVj = bg.getLong((String) q.get(str2 + "expireTime"), 0);
                        cVar.name = (String) q.get(str2 + "name");
                        cVar.hVk = bg.getFloat((String) q.get(str2 + "rate"), 0.0f);
                        cVar.hVl = bg.getInt((String) q.get(str2 + "logId"), 0);
                        cVar.hVm = (String) q.get(str2 + "pages.$type");
                        ArrayList arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            str3 = str2 + "pages.page" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                            i3 = i + 1;
                            str4 = (String) q.get(str3 + "$id");
                            if (str4 == null) {
                                break;
                            }
                            boolean equals = ((String) q.get(str3 + "$action")).equals("true");
                            arrayList.add(new Pair(str4, Boolean.valueOf(equals)));
                            aVar.hUW.put(str4, Boolean.valueOf(equals));
                            i = i3;
                        }
                        cVar.hVn = arrayList;
                        arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            str3 = str2 + "specialPVPages.pageItem" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                            i3 = i + 1;
                            str4 = (String) q.get(str3 + "$prePage");
                            if (str4 == null) {
                                break;
                            }
                            arrayList.add(new Pair(str4, (String) q.get(str3 + "$page")));
                            i = i3;
                        }
                        cVar.hVo = arrayList;
                        aVar.hVg.add(cVar);
                        w.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", cVar);
                        i = i2;
                    } else {
                        w.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", aVar);
                        return aVar;
                    }
                }
            } catch (Throwable e) {
                throw new a(e);
            }
        }
    }

    static class b implements Serializable, Comparable<b> {
        long elapsedTime = 0;
        int fJA = 0;
        List<d> hUZ = null;
        String hVh = null;
        long hVi;
        long time = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((b) obj).time);
        }

        b() {
        }

        public final String toString() {
            return String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[]{this.hVh, Integer.valueOf(this.fJA), c.aq(this.time)});
        }
    }

    private static class c {
        long hVj;
        float hVk;
        int hVl;
        String hVm;
        ArrayList<Pair<String, Boolean>> hVn = new ArrayList();
        ArrayList<Pair<String, String>> hVo = new ArrayList();
        int id;
        String name;

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ReportConfigEvent{");
            stringBuilder.append("id=" + this.id);
            stringBuilder.append(", name='" + this.name + "'");
            stringBuilder.append(", expireTime=" + this.hVj);
            stringBuilder.append(", rate=" + this.hVk);
            stringBuilder.append(", logId=" + this.hVl);
            stringBuilder.append(", pagesType='" + this.hVm + "'");
            stringBuilder.append(", pageList=[");
            Iterator it = this.hVn.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                stringBuilder.append("{" + ((String) pair.first) + "," + pair.second + "}");
                stringBuilder.append(",");
            }
            stringBuilder.append("]");
            stringBuilder.append(", specialPVPages=[");
            it = this.hVo.iterator();
            while (it.hasNext()) {
                pair = (Pair) it.next();
                stringBuilder.append("{" + ((String) pair.first) + "," + ((String) pair.second) + "}");
                stringBuilder.append(",");
            }
            stringBuilder.append("]}");
            return stringBuilder.toString();
        }
    }

    static class d implements Serializable, Comparable<d> {
        String hVp = null;
        int left;
        long time = 0;
        int top;
        int type = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((d) obj).time);
        }

        d() {
        }

        public final String toString() {
            return String.format(Locale.getDefault(), "[%s,%s]", new Object[]{this.hVp, c.aq(this.time)});
        }
    }

    public static c JU() {
        if (hUO == null) {
            synchronized (c.class) {
                if (hUO == null) {
                    hUO = new c();
                }
            }
        }
        return hUO;
    }

    public void onEvent(Event event) {
        if (event != null && event.view != null && event.activity != null && event.activity.getComponentName() != null) {
            Object shortClassName = event.activity.getComponentName().getShortClassName();
            if (shortClassName.contains(".")) {
                shortClassName = shortClassName.substring(shortClassName.lastIndexOf(".") + 1);
            }
            if (this.hUV || this.hUW.containsKey(r0)) {
                d dVar = new d();
                long currentTimeMillis = System.currentTimeMillis();
                dVar.hVp = Integer.toHexString(event.view.getId());
                dVar.type = event.event.getEventType();
                dVar.time = event.elapsedTime;
                this.hUZ.add(dVar);
                int[] iArr = new int[2];
                event.view.getLocationOnScreen(iArr);
                dVar.left = iArr[0];
                dVar.top = iArr[1];
                w.d("MicroMsg.ClickFlowStatReceiver", "[oneliang]id:" + dVar.hVp + ",ui:" + event.activity.getComponentName().getShortClassName() + ",left:" + dVar.left + ",top:" + dVar.top + ",time:" + dVar.time + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public void v(String str, String str2, Object... objArr) {
        w.v("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void d(String str, String str2, Object... objArr) {
        w.d("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void i(String str, String str2, Object... objArr) {
        w.i("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void e(String str, String str2, Object... objArr) {
        w.e("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void post(Runnable runnable, String str) {
        if (this.handler != null) {
            this.handler.post(runnable);
        }
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        w.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", th, str2, objArr);
    }

    private c() {
        if (com.tencent.mm.sdk.a.b.bIu()) {
            Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", ab.bJb());
        }
        HandlerThread Qu = e.Qu("ClickFlow");
        Qu.start();
        this.handler = new ae(Qu.getLooper());
        this.hUP = new aj(Qu.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ c hVa;

            {
                this.hVa = r1;
            }

            public final boolean oQ() {
                w.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", Boolean.valueOf(l.dY(ab.getContext())), Boolean.valueOf(!bg.mA(c.bk(ab.getContext()))), c.bk(ab.getContext()));
                if (l.dY(ab.getContext()) && r0) {
                    return true;
                }
                this.hVa.handler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 hVb;

                    {
                        this.hVb = r1;
                    }

                    public final void run() {
                        this.hVb.hVa.qg();
                    }
                });
                return false;
            }
        }, true);
    }

    public final void JV() {
        long Nz = bg.Nz();
        w.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", (Boolean) new bb<Boolean>(this, Boolean.valueOf(false)) {
            final /* synthetic */ c hVa;

            protected final /* synthetic */ Object run() {
                this.hVa.qg();
                return Boolean.valueOf(true);
            }
        }.b(this.handler), Long.valueOf(bg.aA(Nz)));
    }

    public final void p(final Intent intent) {
        if (intent != null && intent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ c hVa;

                public final void run() {
                    String stringExtra = intent.getStringExtra("ui");
                    int intExtra = intent.getIntExtra("uiHashCode", 0);
                    int intExtra2 = intent.getIntExtra("opCode", 0);
                    long longExtra = intent.getLongExtra("nowMilliSecond", 0);
                    w.d("MicroMsg.ClickFlowStatReceiver", "onReceive op:%d ui:%s hash:0x%x time:%d, elapsed time:%d", Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Long.valueOf(bg.aA(longExtra)), Long.valueOf(intent.getLongExtra("elapsedRealtime", 0)));
                    if (2147483632 == intExtra2) {
                        this.hVa.qg();
                        return;
                    }
                    c cVar = this.hVa;
                    long Nz = bg.Nz();
                    if (TextUtils.isEmpty(stringExtra) || longExtra > Nz) {
                        w.e("MicroMsg.ClickFlowStatReceiver", "writeToList page:%s  start - time = %d", stringExtra, Long.valueOf(Nz - longExtra));
                        return;
                    }
                    b bVar = new b();
                    bVar.fJA = intExtra2;
                    bVar.hVh = stringExtra.contains(".") ? stringExtra.substring(stringExtra.lastIndexOf(".") + 1) : stringExtra;
                    if (3 == intExtra2 && ((cVar.hUV || (cVar.hUW.containsKey(bVar.hVh) && ((Boolean) cVar.hUW.get(bVar.hVh)).booleanValue())) && !AccessibilityCapture.isEnable())) {
                        Object obj = (com.tencent.mm.protocal.d.sYG == null || !com.tencent.mm.protocal.d.sYG.toLowerCase().startsWith("samsung")) ? null : 1;
                        if (obj == null) {
                            obj = 1;
                        } else {
                            int i = 0;
                            if (ab.bJb() && h.vJ().gYT && h.vG().uV()) {
                                h.vG();
                                if (!com.tencent.mm.kernel.a.uP()) {
                                    h.vG();
                                    i = com.tencent.mm.kernel.a.uH();
                                }
                            }
                            obj = (i == 0 || !c.a((long) i, 0.01f, cVar.hUY)) ? null : 1;
                        }
                        if (obj != null) {
                            AccessibilityCapture.enableAccessibilityCapture(ab.getContext(), cVar);
                        }
                    }
                    if (5 == intExtra2 || 6 == intExtra2) {
                        bVar.fJA = 4;
                    } else if (!(3 == intExtra2 || 4 == intExtra2)) {
                        w.i("MicroMsg.ClickFlowStatReceiver", "writeToList error opCode:%d  (%s)", Integer.valueOf(intExtra2), stringExtra);
                        return;
                    }
                    bVar.time = longExtra;
                    bVar.elapsedTime = r8;
                    cVar.hUR.add(bVar);
                    w.i("MicroMsg.ClickFlowStatReceiver", "ActivityState op:%d time:%s 0x%x %s useTime:%d", Integer.valueOf(bVar.fJA), c.aq(bVar.time), Integer.valueOf(intExtra), bVar.hVh, Long.valueOf(bg.aA(Nz)));
                    if (bVar.fJA == 3) {
                        cVar.hUP.KH();
                    } else if (bVar.fJA == 4) {
                        cVar.hUP.KH();
                        cVar.hUP.v(5000, 5000);
                    }
                }
            });
        }
    }

    public final void qg() {
        if (AccessibilityCapture.isEnable()) {
            AccessibilityCapture.disableAccessibilityCapture(ab.getContext());
        }
        if (this.hUR == null || this.hUR.size() == 0) {
            w.e("MicroMsg.ClickFlowStatReceiver", "page info array size is 0");
            return;
        }
        Pair g = g(this.hUR);
        this.hUR.clear();
        this.hUZ.clear();
        if (g == null) {
            w.e("MicroMsg.ClickFlowStatReceiver", "report failed :getResumeList return null ");
            return;
        }
        Object str;
        int intValue = ((Integer) g.first).intValue();
        ArrayList arrayList = (ArrayList) g.second;
        int i = 0;
        if (ab.bJb() && h.vG().uV()) {
            h.vG();
            if (!com.tencent.mm.kernel.a.uP()) {
                h.vG();
                i = com.tencent.mm.kernel.a.uH();
            }
        }
        if (i == 0) {
            w.e("MicroMsg.ClickFlowStatReceiver", "report get uin failed  , maybe AccNotReady,  but report it");
        }
        long longValue = new o(i).longValue();
        if (this.hUS == null) {
            this.hUS = com.tencent.mm.loader.stub.a.hgq + "ClickFlow/";
            File file = new File(this.hUS);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        final com.tencent.mm.sdk.e.a aVar = new com.tencent.mm.sdk.e.a(this.hUS + "stg_20971520_" + longValue + ".cfg");
        final String str2 = this.hUS + "ReportConfig_20971520_" + longValue + ".xml";
        if (this.hUU == null || this.hUU.size() == 0) {
            byte[] d = com.tencent.mm.a.e.d(str2, 0, -1);
            str = d != null ? new String(d) : "";
            try {
                if (com.tencent.mm.sdk.a.b.bIu() && com.tencent.mm.a.e.aO("/sdcard/reportConfig-android.xml")) {
                    d = com.tencent.mm.a.e.d("/sdcard/reportConfig-android.xml", 0, -1);
                    w.w("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString: use /sdcard/reportConfig-android.xml as config, cgi config is ignored!!!");
                    str = d != null ? new String(d) : "";
                }
                if (TextUtils.isEmpty(str)) {
                    w.i("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString xml is empty and don't use /sdcard/reportConfig-android.xml");
                } else {
                    a(a.kP(str));
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", e, "", new Object[0]);
                w.e("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString throwable :%s %s", e.getMessage(), bg.g(e));
                r(15013, bg.g(e));
            }
        }
        if (!ap(longValue)) {
            long Ny = bg.Ny();
            long a = bg.a(aVar.Qp("LAST_UPDATE_CONFIG"), 0);
            long j = a - Ny > 432000 ? 0 : a;
            str = (j <= 0 || this.hUX <= 0 || this.hUX + j < Ny) ? 1 : null;
            boolean z = str != null && this.hUT + 3600 < Ny;
            w.i("MicroMsg.ClickFlowStatReceiver", "readReportConfig shouldUpdate:%b now:%d lastCheckUpdateConfigDiff:%d lastUpdate:%d diff:%d  updateintval:%d", Boolean.valueOf(z), Long.valueOf(Ny), Long.valueOf(Ny - this.hUT), Long.valueOf(j), Long.valueOf(Ny - j), Long.valueOf(this.hUX));
            if (z) {
                com.tencent.mm.network.e eVar = h.vH().gXC.hsZ;
                if (eVar == null) {
                    w.d("MicroMsg.ClickFlowStatReceiver", "dispatcher is null");
                } else {
                    if (new i(new com.tencent.mm.bd.b(bg.PT(aVar.getValue("versionBuffer")))).a(eVar, new com.tencent.mm.y.e(this) {
                        final /* synthetic */ c hVa;

                        public final void a(int i, int i2, String str, k kVar) {
                            if (kVar.getType() == 1126 && i == 0 && i2 == 0) {
                                final yc ycVar = (yc) ((i) kVar).hWk.hsk.hsr;
                                if (ycVar == null) {
                                    w.e("MicroMsg.ClickFlowStatReceiver", "NetSceneUpdateEventConfig onSceneEnd resp is null");
                                } else {
                                    this.hVa.handler.post(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass4 hVf;

                                        public final void run() {
                                            String str = null;
                                            aVar.ab("LAST_UPDATE_CONFIG", bg.Ny());
                                            if (ycVar.tEF == null || ycVar.tEF.sYA.length <= 0 || ycVar.tED == null || ycVar.tED.sYA.length <= 0) {
                                                Integer num;
                                                Integer valueOf;
                                                String str2 = "MicroMsg.ClickFlowStatReceiver";
                                                String str3 = "OnSceneEnd NetSceneUpdateEventConfig failed, eventsampleconf:%s, versionbuffer:%s";
                                                Object[] objArr = new Object[2];
                                                if (ycVar.tEF == null) {
                                                    num = null;
                                                } else {
                                                    num = Integer.valueOf(ycVar.tEF.sYA.length);
                                                }
                                                objArr[0] = num;
                                                if (ycVar.tED != null) {
                                                    valueOf = Integer.valueOf(ycVar.tED.sYA.length);
                                                }
                                                objArr[1] = valueOf;
                                                w.e(str2, str3, objArr);
                                                return;
                                            }
                                            com.tencent.mm.plugin.report.c.oTb.a(346, 3, 1, false);
                                            str3 = bg.bo(ycVar.tED.sYA);
                                            String value = aVar.getValue("versionBuffer");
                                            aVar.eC("versionBuffer", str3);
                                            com.tencent.mm.bd.b bVar = ycVar.tEF;
                                            try {
                                                str = new String(q.q(bVar.sYA), "UTF-8");
                                            } catch (Throwable e) {
                                                int i;
                                                Throwable th = e;
                                                String str4 = "MicroMsg.ClickFlowStatReceiver";
                                                String str5 = "decompress failed, configString length %d, msg:%s  [%s]";
                                                Object[] objArr2 = new Object[3];
                                                if (bVar == null) {
                                                    i = 0;
                                                } else {
                                                    i = bVar.sYA.length;
                                                }
                                                objArr2[0] = Integer.valueOf(i);
                                                objArr2[1] = th.getMessage();
                                                objArr2[2] = bg.g(th);
                                                w.e(str4, str5, objArr2);
                                            }
                                            if (TextUtils.isEmpty(str)) {
                                                com.tencent.mm.plugin.report.c.oTb.a(346, 2, 1, false);
                                                return;
                                            }
                                            boolean z;
                                            try {
                                                a kP = a.kP(str);
                                                com.tencent.mm.a.e.b(str2, str.getBytes(), str.getBytes().length);
                                                this.hVf.hVa.a(kP);
                                                z = true;
                                            } catch (Throwable e2) {
                                                w.e("MicroMsg.ClickFlowStatReceiver", "readReportConfig failed :%s  [%s]", e2.getMessage(), bg.g(e2));
                                                z = false;
                                            }
                                            if (!str3.equals(value)) {
                                                long j;
                                                w.i("MicroMsg.ClickFlowStatReceiver", "idKeyStat, configOK:%b", Boolean.valueOf(z));
                                                com.tencent.mm.plugin.report.c cVar = com.tencent.mm.plugin.report.c.oTb;
                                                if (z) {
                                                    j = 0;
                                                } else {
                                                    j = 1;
                                                }
                                                cVar.a(346, j, 1, false);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }) == 0) {
                        this.hUT = Ny;
                    }
                }
            }
        }
        a(longValue, arrayList, aVar);
        a(longValue, arrayList, aVar, intValue);
        if (!ap(longValue)) {
            b(longValue, arrayList, aVar);
        }
    }

    private static boolean ap(long j) {
        return j == 0;
    }

    private Pair<Integer, ArrayList<b>> g(ArrayList<b> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        long Nz = bg.Nz();
        try {
            b bVar;
            Object arrayList3 = new ArrayList();
            long j = 0;
            int i = 0;
            while (i < arrayList.size()) {
                bVar = (b) arrayList.get(i);
                if (bVar.time < 0 || bVar.time > Nz || Nz - bVar.time > 50400000) {
                    w.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", Long.valueOf(bVar.time), Long.valueOf(Nz - bVar.time), Integer.valueOf(bVar.fJA), bVar.hVh);
                    return null;
                }
                long j2;
                if (bVar.fJA == 4) {
                    if (j < bVar.time) {
                        j2 = bVar.time;
                    }
                    j2 = j;
                } else if (bVar.fJA != 3) {
                    w.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", Integer.valueOf(bVar.fJA), bVar.hVh);
                    return null;
                } else {
                    arrayList3.add(bVar);
                    j2 = j;
                }
                i++;
                j = j2;
            }
            if (arrayList3.size() == 0) {
                return null;
            }
            Collections.sort(arrayList3);
            Collections.sort(this.hUZ);
            bVar = new b();
            Iterator it = arrayList3.iterator();
            b bVar2 = bVar;
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (!bVar.hVh.equals(bVar2.hVh)) {
                    a(bVar2, bVar.elapsedTime);
                    arrayList2.add(bVar);
                    bVar2.hVi = bVar.time;
                    bVar2 = bVar;
                } else if (bVar.time - bVar2.time > 10800000) {
                    w.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", Long.valueOf(bVar.time), Long.valueOf(bVar2.time));
                    bVar2.time = bVar.time;
                }
            }
            if (!arrayList2.isEmpty()) {
                a((b) arrayList2.get(arrayList2.size() - 1), j);
            }
            bVar2.hVi = ((b) arrayList.get(arrayList.size() - 1)).time;
            if (((b) arrayList2.get(arrayList2.size() - 1)).time > j) {
                ((b) arrayList2.get(arrayList2.size() - 1)).hVi = Nz;
            } else if (j > Nz) {
                ((b) arrayList2.get(arrayList2.size() - 1)).hVi = Nz;
            }
            if (((b) arrayList2.get(arrayList2.size() - 1)).hVi - ((b) arrayList2.get(0)).time > 50400000) {
                w.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
                return null;
            }
            w.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", Integer.valueOf(0), Integer.valueOf(arrayList2.size()), Long.valueOf(bg.aA(Nz)));
            return Pair.create(Integer.valueOf(0), arrayList2);
        } catch (Throwable e) {
            r(15008, bg.g(e));
            w.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", bg.g(e));
            return null;
        }
    }

    private void a(b bVar, long j) {
        if (bVar.elapsedTime > 0) {
            int b = b(bVar.elapsedTime, 0, this.hUZ.isEmpty() ? 0 : this.hUZ.size() - 1);
            if (b != -1) {
                if (bVar.hUZ == null) {
                    bVar.hUZ = new ArrayList();
                }
                int size = this.hUZ.size();
                int i = b;
                while (i < size) {
                    d dVar = (d) this.hUZ.get(i);
                    if (dVar.time > bVar.elapsedTime && dVar.time <= j) {
                        bVar.hUZ.add(dVar);
                    }
                    if (dVar.time < j) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private int b(long j, int i, int i2) {
        if (this.hUZ == null || this.hUZ.isEmpty()) {
            return -1;
        }
        int i3 = (i + i2) / 2;
        if (i2 - i == 0 || i2 - i == 1) {
            if (j < ((d) this.hUZ.get(i2)).time) {
                return i;
            }
            return i2;
        } else if (j < ((d) this.hUZ.get(i3)).time) {
            return b(j, i, i3);
        } else {
            return j > ((d) this.hUZ.get(i3)).time ? b(j, i3, i2) : i3;
        }
    }

    private static void r(int i, String str) {
        com.tencent.mm.plugin.report.c.oTb.A(13328, i + ",0,0,0,0,0,0,0,0,0,0,0,0," + str);
    }

    public final void a(a aVar) {
        this.hUX = aVar.hUX;
        if (this.hUX <= 0 || this.hUX > 432000) {
            this.hUX = 432000;
        }
        this.hUY = aVar.hUY;
        this.hUU.clear();
        this.hUU.addAll(aVar.hVg);
        this.hUW.clear();
        this.hUW.putAll(aVar.hUW);
        if (this.hUW.containsKey("*") && ((Boolean) this.hUW.get("*")).booleanValue()) {
            this.hUV = true;
        }
        w.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", Integer.valueOf(this.hUU.size()), Long.valueOf(this.hUX), Long.valueOf(this.hUY));
    }

    static boolean a(long j, float f, long j2) {
        if (com.tencent.mm.sdk.a.b.bIu()) {
            return true;
        }
        if (f <= 0.0f) {
            return false;
        }
        long j3;
        boolean z;
        int i = 10000 / ((int) (10000.0f * f));
        int i2 = (int) j;
        i2 = (i2 ^ (i2 >> 16)) * 73244475;
        i2 = (i2 ^ (i2 >> 16)) * 73244475;
        int i3 = ((i2 >> 16) ^ i2) % i;
        long Ny = bg.Ny();
        if (j2 == 0) {
            j3 = 259200;
        } else {
            j3 = j2;
        }
        if (i3 == ((int) ((Ny / j3) % ((long) i)))) {
            z = true;
        } else {
            z = false;
        }
        w.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", Boolean.valueOf(z), Long.valueOf(j), Float.valueOf(f), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(r5), Integer.valueOf(i3), Integer.valueOf(r1));
        return z;
    }

    private static void a(List<b> list, c cVar, SparseArray<String> sparseArray) {
        int i = 0;
        String str = cVar.hVm;
        int i2 = -1;
        switch (str.hashCode()) {
            case -929554094:
                if (str.equals("respective")) {
                    i2 = 1;
                    break;
                }
                break;
            case 3117816:
                if (str.equals("ends")) {
                    i2 = 2;
                    break;
                }
                break;
            case 3433103:
                if (str.equals("page")) {
                    i2 = 0;
                    break;
                }
                break;
            case 379114255:
                if (str.equals("continuous")) {
                    i2 = 3;
                    break;
                }
                break;
        }
        int i3;
        int i4;
        switch (i2) {
            case 0:
                w.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", cVar);
                sparseArray.put(cVar.hVl, bg.mz((String) sparseArray.get(cVar.hVl)) + cVar.id + ";");
                return;
            case 1:
                w.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", cVar);
                for (i2 = 0; i2 < list.size(); i2 = i3 + 1) {
                    i4 = 0;
                    i3 = i2;
                    while (i4 < cVar.hVn.size()) {
                        int size;
                        if (((String) ((Pair) cVar.hVn.get(i4)).first).equals(((b) list.get(i3)).hVh)) {
                            sparseArray.put(cVar.hVl, bg.mz((String) sparseArray.get(cVar.hVl)) + cVar.id + ";");
                            i4 = cVar.hVn.size();
                            size = list.size();
                        } else {
                            size = i3;
                        }
                        i4++;
                        i3 = size;
                    }
                }
                return;
            case 2:
                w.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", cVar);
                if (list.size() >= 2) {
                    if ((cVar.hVn.size() == 2 ? 1 : 0) == 0) {
                        w.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + cVar.hVn.toString());
                        return;
                    }
                    String str2 = (String) ((Pair) cVar.hVn.get(1)).first;
                    if (((b) list.get(0)).hVh.equals((String) ((Pair) cVar.hVn.get(0)).first) && ((b) list.get(list.size() - 1)).hVh.equals(str2)) {
                        sparseArray.put(cVar.hVl, bg.mz((String) sparseArray.get(cVar.hVl)) + cVar.id + ";");
                        return;
                    }
                    return;
                }
                return;
            case 3:
                w.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", cVar);
                List list2 = cVar.hVn;
                if (list2.size() > 0) {
                    for (i2 = list2.size() - 1; i2 < list.size(); i2 = (list2.size() - i4) + i3) {
                        i4 = list2.size() - 1;
                        i3 = i2;
                        while (((String) ((Pair) list2.get(i4)).first).equals(((b) list.get(i3)).hVh)) {
                            if (i4 == 0) {
                                i = 1;
                            } else {
                                i4--;
                                i3--;
                            }
                        }
                    }
                }
                if (i != 0) {
                    sparseArray.put(cVar.hVl, bg.mz((String) sparseArray.get(cVar.hVl)) + cVar.id + ";");
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar) {
        c cVar;
        long j2 = ((b) arrayList.get(0)).time;
        long j3 = ((b) arrayList.get(arrayList.size() - 1)).hVi;
        long Ny = bg.Ny();
        int i = 0;
        while (i < this.hUU.size()) {
            try {
                if ("app".equals(((c) this.hUU.get(i)).hVm)) {
                    cVar = (c) this.hUU.get(i);
                    break;
                }
                i++;
            } catch (Throwable e) {
                r(15004, bg.g(e));
                w.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", bg.g(e));
                return;
            }
        }
        cVar = null;
        if (cVar == null) {
            w.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
            if (ap(j)) {
                a(aVar, 13604, 100001, j2, j3);
            } else {
                w.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
            }
        } else if (cVar.hVj <= Ny || !a(j, cVar.hVk, this.hUY)) {
            w.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", cVar, Long.valueOf(Ny));
        } else {
            w.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", cVar, Long.valueOf(Ny));
            a(aVar, cVar.hVl, cVar.id, j2, j3);
        }
    }

    private static void a(com.tencent.mm.sdk.e.a aVar, int i, int i2, long j, long j2) {
        long Nz = bg.Nz();
        if (j > j2 || j < 0 || j2 < 0 || j > Nz || j2 > Nz) {
            w.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(Nz));
            return;
        }
        int f = bg.f(aVar.Qq("SEQ_" + i));
        aVar.cC("SEQ_" + i, f + 1);
        Nz = bg.c(aVar.Qp("LastQuit_" + i2));
        aVar.ab("LastQuit_" + i2, j2);
        if (Nz <= 0 || Nz > j) {
            Nz = j;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", 1).put("tbe", j / 1000).put("ten", j2 / 1000).put("in", (j2 - j) / 1000).put("lten", Nz / 1000).put("inbg", (j - Nz) / 1000);
        a(i, String.valueOf(i2), f, jSONObject.toString());
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar, int i) {
        try {
            int i2;
            long Nz = bg.Nz();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                JSONObject jSONObject = new JSONObject();
                b bVar = (b) arrayList.get(i3);
                if (bVar.hVi < bVar.time || bVar.time < 0 || bVar.hVi < 0 || bVar.hVi > Nz || bVar.time > Nz) {
                    w.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", Long.valueOf(bVar.time), Long.valueOf(bVar.hVi), Long.valueOf(Nz));
                    return;
                }
                jSONObject.put("p", bVar.hVh).put("tbe", bVar.time / 1000).put("in", (bVar.hVi - bVar.time) / 1000);
                if (!(bVar.hUZ == null || bVar.hUZ.isEmpty())) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < bVar.hUZ.size(); i4++) {
                        d dVar = (d) bVar.hUZ.get(i4);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("w", dVar.hVp).put("t", dVar.type).put("tbp", "{" + dVar.left + ";" + dVar.top + "}");
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("wf", jSONArray2);
                }
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("t", 2).put("errt", i).put("pf", jSONArray);
            if (ap(j)) {
                int f = bg.f(aVar.Qq("SEQ_13604"));
                aVar.cC("SEQ_13604", f + 1);
                a(13604, "100002", f, jSONObject3.toString());
            }
            SparseArray sparseArray = new SparseArray();
            if (this.hUU.size() == 0) {
                w.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
            }
            for (i2 = 0; i2 < this.hUU.size(); i2++) {
                c cVar = (c) this.hUU.get(i2);
                if (cVar.hVj > bg.Ny()) {
                    if (a(j, cVar.hVk, this.hUY)) {
                        a((List) arrayList, cVar, sparseArray);
                    }
                }
                w.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", cVar, Long.valueOf(bg.Ny()));
            }
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                String str = (String) sparseArray.get(keyAt);
                int f2 = bg.f(aVar.Qq("SEQ_" + keyAt));
                aVar.cC("SEQ_" + keyAt, f2 + 1);
                a(keyAt, str, f2, jSONObject3.toString());
            }
        } catch (Throwable e) {
            r(15005, bg.g(e));
            w.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", bg.g(e));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r38, java.util.ArrayList<com.tencent.mm.modelstat.c.b> r40, com.tencent.mm.sdk.e.a r41) {
        /*
        r37 = this;
        r18 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r4 = r40.size();
        r4 = r4 + -1;
        r0 = r40;
        r4 = r0.get(r4);
        r4 = (com.tencent.mm.modelstat.c.b) r4;
        r0 = r4.hVi;
        r20 = r0;
        r4 = 0;
        r4 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0020;
    L_0x001c:
        r4 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1));
        if (r4 <= 0) goto L_0x003b;
    L_0x0020:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "reportStat  ErrorTime end:%d now:%d";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = java.lang.Long.valueOf(r20);
        r6[r7] = r8;
        r7 = 1;
        r8 = java.lang.Long.valueOf(r18);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);
    L_0x003a:
        return;
    L_0x003b:
        r22 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r37;
        r5 = r0.hUS;
        r4 = r4.append(r5);
        r5 = "stg_20971520_";
        r4 = r4.append(r5);
        r0 = r38;
        r4 = r4.append(r0);
        r5 = ".HashMap";
        r4 = r4.append(r5);
        r17 = r4.toString();
        r6 = kO(r17);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = java.lang.Long.valueOf(r20);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r40;
        r6.put(r4, r0);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r6.entrySet();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.iterator();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x0079:
        r4 = r5.hasNext();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x00b0;
    L_0x007f:
        r4 = r5.next();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.getKey();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.Long) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = r4.longValue();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r8 = r8 + r10;
        r4 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1));
        if (r4 >= 0) goto L_0x0079;
    L_0x0097:
        r5.remove();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x0079;
    L_0x009b:
        r4 = move-exception;
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "report ev:4 exception : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bg.g(r4);
        r7[r8] = r4;
        com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
        goto L_0x003a;
    L_0x00b0:
        r0 = r37;
        r1 = r17;
        r0.b(r1, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = com.tencent.mm.sdk.a.b.bIu();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x0116;
    L_0x00bd:
        r4 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
    L_0x00c0:
        r7 = "LAST_REPORT_STATISITIC_TIME";
        r0 = r41;
        r7 = r0.Qp(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r8 = com.tencent.mm.sdk.platformtools.bg.a(r7, r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r8 + r4;
        r7 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1));
        if (r7 <= 0) goto L_0x011a;
    L_0x00d5:
        r6 = "MicroMsg.ClickFlowStatReceiver";
        r7 = "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d";
        r10 = 3;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r11 = 0;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10[r11] = r8;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 1;
        r9 = java.lang.Long.valueOf(r20);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10[r8] = r9;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 2;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10[r8] = r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.i(r6, r7, r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x00f8:
        r4 = move-exception;
        com.tencent.mm.loader.stub.b.deleteFile(r17);
        java.lang.System.gc();
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "OutOfMemoryError";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r5, r4, r6, r7);
        r5 = 15010; // 0x3aa2 float:2.1033E-41 double:7.416E-320;
        r4 = com.tencent.mm.sdk.platformtools.bg.g(r4);
        r(r5, r4);
        goto L_0x003a;
    L_0x0116:
        r4 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        goto L_0x00c0;
    L_0x011a:
        r4 = "LAST_REPORT_STATISITIC_TIME";
        r0 = r41;
        r1 = r20;
        r0.ab(r4, r1);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r24 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r24.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r6.keySet();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.iterator();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x0131:
        r4 = r5.hasNext();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x014f;
    L_0x0137:
        r4 = r5.next();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.Long) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r4.longValue();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r7 <= 0) goto L_0x0131;
    L_0x0145:
        r7 = r6.get(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r24;
        r0.put(r4, r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x0131;
    L_0x014f:
        r8 = 0;
        r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r25 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r25.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r26 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r26.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r27 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r27.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r28 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r28.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r29 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r29.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = 0;
        r4 = 0;
        r10 = r4;
    L_0x0172:
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r10 >= r4) goto L_0x0759;
    L_0x017c:
        r11 = "pagestat";
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.hVm;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r11.equals(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x0218;
    L_0x0191:
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r16 = r4;
    L_0x019d:
        r4 = r24.keySet();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r30 = r4.iterator();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x01a5:
        r4 = r30.hasNext();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x03e8;
    L_0x01ab:
        r4 = r30.next();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.Long) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r4.longValue();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x0756;
    L_0x01b9:
        r6 = r4.longValue();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r12 = r6;
    L_0x01be:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "find min key,min key,cur key:%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = 0;
        r11 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7[r10] = r11;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = 1;
        r7[r10] = r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r24;
        r4 = r0.get(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.util.ArrayList) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r5 + -1;
        r5 = r4.get(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (com.tencent.mm.modelstat.c.b) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r5.hVi;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = 0;
        r5 = r4.get(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (com.tencent.mm.modelstat.c.b) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6 - r10;
        r14 = r8 + r6;
        r6 = 0;
        r5 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
        if (r5 < 0) goto L_0x0203;
    L_0x01fc:
        r6 = 172800000; // 0xa4cb800 float:9.856849E-33 double:8.53745436E-316;
        r5 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x021d;
    L_0x0203:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "reportStat ErrorTime sumInFg:%d";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = 0;
        r8 = java.lang.Long.valueOf(r14);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x0218:
        r4 = r10 + 1;
        r10 = r4;
        goto L_0x0172;
    L_0x021d:
        r6 = 0;
        r5 = 0;
        r10 = r5;
        r11 = r6;
    L_0x0221:
        r5 = r4.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r10 >= r5) goto L_0x0398;
    L_0x0227:
        r5 = r4.get(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (com.tencent.mm.modelstat.c.b) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = "MicroMsg.ClickFlowStatReceiver";
        r8 = "pageIntervalMap page:%s old:%d  new[%d,%d,%d]";
        r6 = 5;
        r9 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 0;
        r0 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31 = r0;
        r9[r6] = r31;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31 = 1;
        r6 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r25;
        r6 = r0.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = com.tencent.mm.sdk.platformtools.bg.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9[r31] = r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 2;
        r0 = r5.hVi;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = r0;
        r31 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9[r6] = r31;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 3;
        r0 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = r0;
        r31 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9[r6] = r31;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 4;
        r0 = r5.hVi;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = r0;
        r0 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r34 = r0;
        r32 = r32 - r34;
        r31 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9[r6] = r31;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.v(r7, r8, r9);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r5.hVi;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6 - r8;
        r8 = 0;
        r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r8 < 0) goto L_0x028f;
    L_0x0288:
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r8 <= 0) goto L_0x0753;
    L_0x028f:
        r8 = "MicroMsg.ClickFlowStatReceiver";
        r9 = "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d";
        r31 = 4;
        r0 = r31;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31 = r0;
        r32 = 0;
        r0 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r34 = r0;
        r33 = java.lang.Long.valueOf(r34);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31[r32] = r33;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 1;
        r0 = r5.hVi;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r34 = r0;
        r33 = java.lang.Long.valueOf(r34);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31[r32] = r33;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 2;
        r33 = java.lang.Long.valueOf(r18);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31[r32] = r33;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 3;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31[r32] = r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r31;
        com.tencent.mm.sdk.platformtools.w.e(r8, r9, r0);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 0;
        r8 = r6;
    L_0x02cd:
        r7 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r25;
        r6 = r0.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = com.tencent.mm.sdk.platformtools.bg.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = r8 + r32;
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r25;
        r0.put(r7, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r26;
        r6 = r0.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = com.tencent.mm.sdk.platformtools.bg.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 1;
        r8 = r8 + r32;
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r26;
        r0.put(r7, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r11 == 0) goto L_0x033c;
    L_0x0307:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r11.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = ",";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r6.toString();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r28;
        r6 = r0.get(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = com.tencent.mm.sdk.platformtools.bg.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 1;
        r8 = r8 + r32;
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r28;
        r0.put(r7, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x033c:
        r6 = r5.hUZ;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r6 == 0) goto L_0x0392;
    L_0x0340:
        r6 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r6 = r0.containsKey(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r6 == 0) goto L_0x0384;
    L_0x034a:
        r6 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r6 = r0.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.util.Map) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r6;
    L_0x0355:
        r6 = 0;
        r8 = r6;
    L_0x0357:
        r6 = r5.hUZ;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r8 >= r6) goto L_0x0392;
    L_0x035f:
        r6 = r5.hUZ;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (com.tencent.mm.modelstat.c.d) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9 = r6.hVp;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.hVp;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r7.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = com.tencent.mm.sdk.platformtools.bg.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r34 = 1;
        r32 = r32 + r34;
        r6 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7.put(r9, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r8 + 1;
        r8 = r6;
        goto L_0x0357;
    L_0x0384:
        r6 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r5.hVh;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r0.put(r7, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r6;
        goto L_0x0355;
    L_0x0392:
        r6 = r10 + 1;
        r10 = r6;
        r11 = r5;
        goto L_0x0221;
    L_0x0398:
        if (r16 == 0) goto L_0x03e4;
    L_0x039a:
        r0 = r16;
        r4 = r0.hVo;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r4.iterator();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x03a2:
        r4 = r6.hasNext();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x03e4;
    L_0x03a8:
        r4 = r6.next();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (android.util.Pair) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.first;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r7.append(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = ",";
        r7 = r5.append(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.second;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r7.append(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r28;
        r7 = r0.containsKey(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r7 == 0) goto L_0x03a2;
    L_0x03d6:
        r4 = r4.second;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r28;
        r5 = r0.get(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r27;
        r0.put(r4, r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x03a2;
    L_0x03e4:
        r6 = r12;
        r8 = r14;
        goto L_0x01a5;
    L_0x03e8:
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r24;
        r4 = r0.get(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.util.ArrayList) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = 0;
        r4 = r4.get(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.b) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r4.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "min key:%s,tbe:%s";
        r12 = 2;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r13 = 0;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r12[r13] = r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 1;
        r7 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r12[r6] = r7;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r12);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1));
        if (r4 > 0) goto L_0x0421;
    L_0x041b:
        r4 = 0;
        r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x043d;
    L_0x0421:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "reportStat ErroTime tbe:%d now:%d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = 0;
        r8 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = 1;
        r8 = java.lang.Long.valueOf(r18);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x043d:
        r5 = 0;
        r4 = 0;
        r6 = r4;
    L_0x0440:
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = r4.size();	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        if (r6 >= r4) goto L_0x0750;
    L_0x044a:
        r7 = "appstat";
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r6);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = r4.hVm;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = r7.equals(r4);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x0680;
    L_0x045f:
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r6);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
    L_0x0469:
        if (r4 == 0) goto L_0x06bc;
    L_0x046b:
        r6 = r20 - r10;
        r6 = r6 - r8;
        r12 = 0;
        r5 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r5 <= 0) goto L_0x06bc;
    L_0x0474:
        r6 = r4.hVj;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r5 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1));
        if (r5 <= 0) goto L_0x0685;
    L_0x047a:
        r5 = r4.hVk;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r0 = r37;
        r6 = r0.hUY;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r0 = r38;
        r5 = a(r0, r5, r6);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        if (r5 == 0) goto L_0x0685;
    L_0x0488:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "type: appstat, handle %s, now:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r12 = 0;
        r7[r12] = r4;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r12 = 1;
        r13 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7[r12] = r13;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r6 = "SEQ_";
        r5.<init>(r6);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r6 = r4.hVl;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r0 = r41;
        r5 = r0.Qq(r5);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r5 = com.tencent.mm.sdk.platformtools.bg.f(r5);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7 = "SEQ_";
        r6.<init>(r7);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7 = r4.hVl;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7 = r5 + 1;
        r0 = r41;
        r0.cC(r6, r7);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r6.<init>();	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7 = "t";
        r12 = 5;
        r7 = r6.put(r7, r12);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r12 = "tbe";
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r10 / r14;
        r7 = r7.put(r12, r14);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r12 = "ten";
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r20 / r14;
        r7 = r7.put(r12, r14);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r12 = "in";
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r8 / r14;
        r7 = r7.put(r12, r14);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r12 = "inbg";
        r14 = r20 - r10;
        r8 = r14 - r8;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r8 / r14;
        r7 = r7.put(r12, r8);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r8 = "swc";
        r9 = r24.size();	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7.put(r8, r9);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7 = r4.hVl;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r8.<init>();	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = r4.id;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = r8.append(r4);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        a(r7, r4, r5, r6);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
    L_0x0531:
        r5 = 0;
        r4 = 0;
        r6 = r4;
    L_0x0534:
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.size();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        if (r6 >= r4) goto L_0x074d;
    L_0x053e:
        r7 = "pagestat";
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r6);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.hVm;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r7.equals(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x06d8;
    L_0x0553:
        r0 = r37;
        r4 = r0.hUU;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r6);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r6 = r4;
    L_0x055e:
        if (r6 == 0) goto L_0x0742;
    L_0x0560:
        r4 = r6.hVj;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1));
        if (r4 <= 0) goto L_0x072a;
    L_0x0566:
        r4 = r6.hVk;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r0 = r37;
        r8 = r0.hUY;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r0 = r38;
        r4 = a(r0, r4, r8);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x072a;
    L_0x0574:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "type: pagestat, handle %s, now:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r7[r8] = r6;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r8 = 1;
        r9 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r7);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = "SEQ_";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = r6.hVl;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r0 = r41;
        r4 = r0.Qq(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r7 = com.tencent.mm.sdk.platformtools.bg.f(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = "SEQ_";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = r6.hVl;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = r7 + 1;
        r0 = r41;
        r0.cC(r4, r5);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r8 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r8.<init>();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r25.keySet();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r9 = r4.iterator();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
    L_0x05cc:
        r4 = r9.hasNext();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x06e8;
    L_0x05d2:
        r4 = r9.next();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r12 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r12.<init>();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = "p";
        r13 = r12.put(r5, r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r14 = "in";
        r0 = r25;
        r5 = r0.get(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = (java.lang.Long) r5;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r18 = r5.longValue();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r22 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r18 = r18 / r22;
        r0 = r18;
        r5 = r13.put(r14, r0);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r13 = "c";
        r0 = r26;
        r14 = r0.get(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = r5.put(r13, r14);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r13 = "c2";
        r0 = r27;
        r14 = r0.get(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5.put(r13, r14);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r5 = r0.containsKey(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        if (r5 == 0) goto L_0x06e3;
    L_0x061e:
        r13 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r13.<init>();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r4 = r0.get(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r0 = r4;
        r0 = (java.util.Map) r0;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = r0;
        r4 = r5.keySet();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r14 = r4.iterator();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
    L_0x0635:
        r4 = r14.hasNext();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x06dd;
    L_0x063b:
        r4 = r14.next();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r15 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r15.<init>();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r16 = "w";
        r0 = r16;
        r16 = r15.put(r0, r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r18 = "c";
        r4 = r5.get(r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r0 = r16;
        r1 = r18;
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r13.put(r15);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        goto L_0x0635;
    L_0x0661:
        r4 = move-exception;
        r5 = 15007; // 0x3a9f float:2.1029E-41 double:7.4144E-320;
        r6 = com.tencent.mm.sdk.platformtools.bg.g(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r(r5, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "report ev:4 exception : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bg.g(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7[r8] = r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x0680:
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x0440;
    L_0x0685:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "type: appstat, skip %s, now:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r7[r8] = r4;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = 1;
        r8 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7[r4] = r8;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        goto L_0x0531;
    L_0x069d:
        r4 = move-exception;
        r5 = 15006; // 0x3a9e float:2.1028E-41 double:7.414E-320;
        r6 = com.tencent.mm.sdk.platformtools.bg.g(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r(r5, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "report ev:3 exception : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bg.g(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7[r8] = r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x0531;
    L_0x06bc:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r12 = 0;
        r7[r12] = r4;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r4 = 1;
        r12 = r20 - r10;
        r8 = r12 - r8;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        r7[r4] = r8;	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);	 Catch:{ Exception -> 0x069d, OutOfMemoryError -> 0x00f8 }
        goto L_0x0531;
    L_0x06d8:
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x0534;
    L_0x06dd:
        r4 = "wa";
        r12.put(r4, r13);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
    L_0x06e3:
        r8.put(r12);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        goto L_0x05cc;
    L_0x06e8:
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4.<init>();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = "t";
        r9 = 6;
        r5 = r4.put(r5, r9);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r9 = "tbe";
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        r5 = r5.put(r9, r10);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r9 = "ten";
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r20 / r10;
        r5 = r5.put(r9, r10);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r9 = "pa";
        r5.put(r9, r8);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r5 = r6.hVl;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r8.<init>();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r6 = r6.id;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r6 = r8.append(r6);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        a(r5, r6, r7, r4);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x072a:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "type: pagestat, skip %s, now:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r7[r8] = r6;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r6 = 1;
        r8 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        r7[r6] = r8;	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r7);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x0742:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "type: pagestat, skip null";
        com.tencent.mm.sdk.platformtools.w.i(r4, r5);	 Catch:{ Exception -> 0x0661, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x074d:
        r6 = r5;
        goto L_0x055e;
    L_0x0750:
        r4 = r5;
        goto L_0x0469;
    L_0x0753:
        r8 = r6;
        goto L_0x02cd;
    L_0x0756:
        r12 = r6;
        goto L_0x01be;
    L_0x0759:
        r16 = r5;
        goto L_0x019d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.c.b(long, java.util.ArrayList, com.tencent.mm.sdk.e.a):void");
    }

    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Long, ArrayList<b>> kO(String str) {
        ObjectInputStream objectInputStream;
        Throwable th;
        InputStream inputStream;
        FileInputStream fileInputStream = null;
        long Nz = bg.Nz();
        try {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                w.w("MicroMsg.ClickFlowStatReceiver", "readStorage not exist path[%s]", str);
                return new HashMap();
            }
            InputStream fileInputStream2 = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream2);
                try {
                    HashMap<Long, ArrayList<b>> hashMap = (HashMap) objectInputStream.readObject();
                    w.i("MicroMsg.ClickFlowStatReceiver", "readStorage keys count:%d readTime:%d", Integer.valueOf(hashMap.size()), Long.valueOf(bg.aA(Nz)));
                    try {
                        objectInputStream.close();
                    } catch (Exception e) {
                    }
                    try {
                        fileInputStream2.close();
                        return hashMap;
                    } catch (Exception e2) {
                        return hashMap;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = fileInputStream2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                inputStream = fileInputStream2;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private synchronized void b(String str, HashMap<Long, ArrayList<b>> hashMap) {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream = null;
        synchronized (this) {
            FileOutputStream fileOutputStream2;
            try {
                long Nz = bg.Nz();
                fileOutputStream2 = new FileOutputStream(str);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    try {
                        w.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bg.g(e));
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e = th;
                        fileOutputStream2 = fileOutputStream;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectOutputStream = null;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
                try {
                    objectOutputStream.writeObject(hashMap);
                    fileOutputStream2.flush();
                    w.i("MicroMsg.ClickFlowStatReceiver", "writeStorage count:%d time:%d", Integer.valueOf(hashMap.size()), Long.valueOf(bg.aA(Nz)));
                    try {
                        objectOutputStream.close();
                    } catch (Exception e7) {
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e8) {
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileOutputStream = fileOutputStream2;
                    w.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bg.g(e));
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return;
                } catch (Throwable th3) {
                    e = th3;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
            } catch (Exception e10) {
                e = e10;
                objectOutputStream = null;
                w.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bg.g(e));
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return;
            } catch (Throwable th4) {
                e = th4;
                objectOutputStream = null;
                fileOutputStream2 = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw e;
            }
        }
        return;
    }

    private static void a(int i, String str, int i2, String str2) {
        try {
            String replace = str2.replace(",", ";");
            int ceil = (int) Math.ceil(((double) replace.length()) / 6000.0d);
            for (int i3 = 0; i3 < ceil; i3++) {
                w.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", Integer.valueOf(i), str, str + "," + i2 + "," + i3 + "," + ceil + ",0,0,," + replace.substring(i3 * 6000, Math.min((i3 + 1) * 6000, replace.length())));
                com.tencent.mm.plugin.report.c.oTb.a(346, 4, 1, false);
                com.tencent.mm.plugin.report.c.oTb.a(i, r11, true, true);
            }
        } catch (Throwable e) {
            r(15009, bg.g(e));
            w.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", bg.g(e));
        }
    }

    public static String aq(long j) {
        if (j < 100000000000L) {
            return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j * 1000));
        }
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j)) + String.format(Locale.getDefault(), ".%03d", new Object[]{Long.valueOf(j % 1000)});
    }

    public static String bk(Context context) {
        int i;
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals("com.tencent.mm") || runningAppProcessInfo.processName.equals("com.tencent.mm:tools"))) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i == 0) {
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String className;
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    return "";
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        return null;
                    }
                    className = componentName.getClassName();
                    if (className.contains(".")) {
                        return className.substring(className.lastIndexOf(".") + 1);
                    }
                    return className;
                }
                return "";
            }
            className = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (className.contains(".")) {
                return className.substring(className.lastIndexOf(".") + 1);
            }
            return className;
        } catch (Throwable e) {
            w.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", e.getMessage(), bg.g(e));
        }
    }
}
