package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.e.a.de;
import com.tencent.mm.e.a.df;
import com.tencent.mm.e.a.dg;
import com.tencent.mm.i.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelmulti.e;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class k {
    public static c gKi;
    public static float gKj = -85.0f;
    public static float gKk = -1000.0f;
    public static boolean gKl = false;
    public static Map<String, afo> gKm = new ConcurrentHashMap();
    public static List<afo> gKn = new CopyOnWriteArrayList();
    public static Boolean gKo = Boolean.valueOf(false);
    public static a gKp = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                w.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
                k.gKj = f2;
                k.gKk = f;
                k.gKl = true;
                if (k.gKi != null) {
                    k.gKi.c(k.gKp);
                    k.gKl = false;
                }
            } else {
                w.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
            }
            return false;
        }
    };
    private static aj gKq = new aj(Looper.getMainLooper(), new aj.a() {
        public final boolean oQ() {
            try {
                ap.yY();
                Boolean valueOf = Boolean.valueOf(bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false));
                List<String> sJ = g.sW().sJ();
                if (sJ != null) {
                    for (String str : sJ) {
                        w.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + valueOf + ",iBeacon = %s", str);
                        b dfVar = new df();
                        dfVar.fHa.fHc = str;
                        dfVar.fHa.fGZ = false;
                        if (!valueOf.booleanValue()) {
                            com.tencent.mm.sdk.b.a.urY.m(dfVar);
                        }
                    }
                    afq com_tencent_mm_protocal_c_afq = new afq();
                    com_tencent_mm_protocal_c_afq.latitude = (double) k.gKj;
                    com_tencent_mm_protocal_c_afq.longitude = (double) k.gKk;
                    ap.yY();
                    long a = bg.a((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, null), 0);
                    if (k.gKm.size() <= 0 || k.gKo.booleanValue() || k.gKn.size() <= 0) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                    } else {
                        k.gKo = Boolean.valueOf(true);
                        final com.tencent.mm.y.k eVar = new e(k.gKn, a, com_tencent_mm_protocal_c_afq);
                        w.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + a + ",beaconInfos size " + k.gKn.size() + ",info:" + k.gKn.toString());
                        ap.vd().a(1708, new com.tencent.mm.y.e(this) {
                            final /* synthetic */ AnonymousClass2 gKt;

                            public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                                if (i == 0 && i2 == 0) {
                                    uz uzVar = (uz) eVar.hKp.hsk.hsr;
                                    if (uzVar.result == 0) {
                                        aft com_tencent_mm_protocal_c_aft = uzVar.tCB;
                                        afo com_tencent_mm_protocal_c_afo = uzVar.tCD;
                                        Object obj = com_tencent_mm_protocal_c_aft.title + "," + com_tencent_mm_protocal_c_aft.desc + "," + com_tencent_mm_protocal_c_aft.tKP + "," + com_tencent_mm_protocal_c_aft.tKQ + "," + com_tencent_mm_protocal_c_afo.mry + "," + com_tencent_mm_protocal_c_afo.major + "," + com_tencent_mm_protocal_c_afo.minor;
                                        ap.yY();
                                        String[] split = bg.ap((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, null), "").split(",");
                                        Boolean valueOf = Boolean.valueOf(false);
                                        Boolean bool = valueOf;
                                        for (String equals : split) {
                                            if (equals.equals(com_tencent_mm_protocal_c_afo.mry + com_tencent_mm_protocal_c_afo.major + com_tencent_mm_protocal_c_afo.minor)) {
                                                bool = Boolean.valueOf(true);
                                            }
                                        }
                                        if (bool.booleanValue()) {
                                            ap.yY();
                                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.oUh.i(12653, Integer.valueOf(1), Integer.valueOf(1));
                                            com.tencent.mm.plugin.report.service.g.oUh.i(12653, Integer.valueOf(2), Integer.valueOf(1));
                                            ap.yY();
                                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, obj);
                                        }
                                    } else {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                    }
                                } else {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                }
                                ap.yY();
                                com.tencent.mm.u.c.uR();
                                com.tencent.mm.sdk.b.a.urY.m(new de());
                                k.gKo = Boolean.valueOf(false);
                                ap.vd().b(1708, (com.tencent.mm.y.e) this);
                            }
                        });
                        ap.vd().a(eVar, 0);
                    }
                    k.gKm.clear();
                    k.gKn.clear();
                    com.tencent.mm.sdk.b.a.urY.c(k.gKr);
                }
            } catch (Exception e) {
                w.e("MicroMsg.PostTaskStartRangeForIBeacon", e.getMessage());
            }
            return false;
        }
    }, true);
    public static com.tencent.mm.sdk.b.c gKr = new com.tencent.mm.sdk.b.c<dg>() {
        {
            this.usg = dg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            dg dgVar = (dg) bVar;
            if (dgVar != null && (dgVar instanceof dg)) {
                String str = dgVar.fHe.fHc;
                int i = dgVar.fHe.fHf;
                int i2 = dgVar.fHe.fHg;
                if (!k.gKm.containsKey(str + "," + i + "," + i2)) {
                    afo com_tencent_mm_protocal_c_afo = new afo();
                    com_tencent_mm_protocal_c_afo.mry = str;
                    com_tencent_mm_protocal_c_afo.major = i;
                    com_tencent_mm_protocal_c_afo.minor = 65535 & i2;
                    com_tencent_mm_protocal_c_afo.hQZ = dgVar.fHe.fHh;
                    k.gKm.put(str + "," + i + "," + i2, com_tencent_mm_protocal_c_afo);
                    if (dgVar.fHe.fHh >= 0.0d && k.gKn.size() > 0) {
                        int i3 = 0;
                        while (i3 < k.gKn.size()) {
                            afo com_tencent_mm_protocal_c_afo2 = (afo) k.gKn.get(i3);
                            if (dgVar.fHe.fHh >= com_tencent_mm_protocal_c_afo2.hQZ) {
                                if (i3 == k.gKn.size() - 1 && dgVar.fHe.fHh > com_tencent_mm_protocal_c_afo2.hQZ) {
                                    k.gKn.add(com_tencent_mm_protocal_c_afo);
                                    break;
                                }
                                i3++;
                            } else {
                                k.gKn.add(i3, com_tencent_mm_protocal_c_afo);
                                break;
                            }
                        }
                    }
                    k.gKn.add(com_tencent_mm_protocal_c_afo);
                }
                w.i("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(k.gKm.size()));
            }
            return false;
        }
    };

    public static void run() {
        if (ap.zb() && !ap.uP()) {
            ap.yY();
            Boolean valueOf = Boolean.valueOf(bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            w.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is " + valueOf);
            if (valueOf.booleanValue()) {
                long Ny = bg.Ny();
                ap.yY();
                long a = bg.a((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, null), 0);
                ap.yY();
                if (Ny - a > bg.a((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, null), 0)) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(false));
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, (Object) "");
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                    ap.yY();
                    com.tencent.mm.u.c.uR();
                    return;
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (VERSION.SDK_INT < 18 || defaultAdapter == null || defaultAdapter.getState() != 12) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                    return;
                }
                List<String> sJ = g.sW().sJ();
                if (sJ != null) {
                    for (String str : sJ) {
                        w.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", str);
                        b dfVar = new df();
                        dfVar.fHa.fHc = str;
                        dfVar.fHa.fGZ = true;
                        com.tencent.mm.sdk.b.a.urY.m(dfVar);
                    }
                    gKi = c.Gk();
                    if (gKq.bJq()) {
                        gKq.v(3000, 3000);
                    }
                    if (!(gKl || gKi == null)) {
                        gKi.b(gKp);
                    }
                    com.tencent.mm.sdk.b.a.urY.b(gKr);
                }
            }
        }
    }
}
