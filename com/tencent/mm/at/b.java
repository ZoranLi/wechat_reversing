package com.tencent.mm.at;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.c.a.a.t;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.ap.k;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b {
    private static final byte[] hQu = "@wechat*weixin!!".getBytes();
    private static b hQv;
    int hQA = 30000;
    private int hQB = 3600;
    public c hQC;
    public List<d> hQD = new ArrayList();
    public List<d> hQE = new ArrayList();
    public c hQF = new c<e>(this) {
        final /* synthetic */ b hQS;

        {
            this.hQS = r2;
            this.usg = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!((e) bVar).fCm.fCn) {
                w.i("MicroMsg.SenseWhereHelper", "it is [deactivated mode], stop sense where sdk after %d", Integer.valueOf(Math.max(this.hQS.hQz, this.hQS.hQy)));
                b.II();
                this.hQS.gu(r0);
            }
            return false;
        }
    };
    aj hQG;
    public com.tencent.map.a.a.b hQH;
    int hQI;
    public com.tencent.map.a.a.c hQJ;
    public boolean hQw = false;
    af hQx;
    int hQy = Downloads.MIN_RETYR_AFTER;
    int hQz = Downloads.MIN_RETYR_AFTER;
    public long startTime = 0;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int hQK;
        final /* synthetic */ float hQL;
        final /* synthetic */ float hQM;
        final /* synthetic */ int hQN;
        final /* synthetic */ int hQO;
        final /* synthetic */ int hQP = 0;
        final /* synthetic */ String hQQ;
        final /* synthetic */ String hQR;
        final /* synthetic */ b hQS;

        public AnonymousClass1(b bVar, int i, float f, float f2, int i2, int i3, int i4, String str, String str2) {
            this.hQS = bVar;
            this.hQK = i;
            this.hQL = f;
            this.hQM = f2;
            this.hQN = i2;
            this.hQO = i3;
            this.hQQ = str;
            this.hQR = str2;
        }

        public final void run() {
            if (this.hQS.hQw) {
                w.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
            } else if (this.hQS.ID()) {
                int i;
                b.IE();
                if (this.hQS.hQE.size() == 0 && this.hQS.hQD.size() == 0) {
                    b bVar = this.hQS;
                    bVar.hQD.clear();
                    bVar.hQE.clear();
                    String str = (String) h.vI().vr().get(a.USERINFO_SENSE_WHERE_LOCATION_STRING, (Object) "");
                    if (bg.mA(str)) {
                        w.i("MicroMsg.SenseWhereHelper", "sense where location xml is null.");
                    } else {
                        Map q = f.q(str, "SenseWhere");
                        i = 0;
                        while (true) {
                            String str2 = ".SenseWhere.item" + (i == 0 ? "" : Integer.valueOf(i));
                            str = (String) q.get(str2 + ".$gpstype");
                            if (bg.mA(str)) {
                                break;
                            }
                            d dVar = new d();
                            dVar.hQY = str;
                            dVar.longitude = bg.getDouble((String) q.get(str2 + ".$longitude"), 0.0d);
                            dVar.latitude = bg.getDouble((String) q.get(str2 + ".$latitude"), 0.0d);
                            dVar.hQZ = bg.getDouble((String) q.get(str2 + ".$distance"), 0.0d);
                            if (dVar.hQZ > 5500000.0d) {
                                dVar.hQZ = 5500000.0d;
                            }
                            if ("1".equals(dVar.hQY)) {
                                bVar.hQD.add(dVar);
                            } else {
                                bVar.hQE.add(dVar);
                            }
                            i++;
                        }
                        g.oUh.a(345, 6, 1, false);
                        w.i("MicroMsg.SenseWhereHelper", "parse location finish earth[%d] mars[%d]", Integer.valueOf(bVar.hQE.size()), Integer.valueOf(bVar.hQD.size()));
                    }
                }
                if (this.hQS.a(this.hQK, this.hQL, this.hQM)) {
                    w.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", Integer.valueOf(this.hQK), Float.valueOf(this.hQL), Float.valueOf(this.hQM), Integer.valueOf(this.hQN));
                    this.hQS.hQw = true;
                    h.vI().vr().a(a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(bg.Ny()));
                    com.tencent.mm.sdk.b.a.urY.b(this.hQS.hQF);
                    if (this.hQS.hQC != null) {
                        this.hQS.hQC.finish();
                    }
                    this.hQS.hQI = 0;
                    this.hQS.startTime = bg.NA();
                    this.hQS.hQC = new c(this.hQL, this.hQM, this.hQO, this.hQP, this.hQQ, this.hQR, this.hQK, this.hQN);
                    Object IB = b.IB();
                    if (TextUtils.isEmpty(IB)) {
                        throw new NullPointerException("SenseWhereEngine:invalid imei!");
                    }
                    t.setImei(IB);
                    t.a(ab.getContext(), this.hQS.hQC);
                    b bVar2 = this.hQS;
                    bVar2.hQx = new af("sensewhere");
                    Handler fetchFreeHandler = ae.fetchFreeHandler(bVar2.hQx.nJF.getLooper());
                    i = this.hQS.hQy;
                    t.a(fetchFreeHandler, (long) this.hQS.hQz, this.hQS.hQH, this.hQS.hQJ);
                    b.IF();
                    this.hQS.gu(this.hQS.hQA);
                }
            } else {
                w.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
            }
        }
    }

    public static b IA() {
        if (hQv == null) {
            hQv = new b();
        }
        return hQv;
    }

    public b() {
        h.vJ();
        this.hQG = new aj(h.vL().nJF.getLooper(), new aj.a(this) {
            final /* synthetic */ b hQS;

            {
                this.hQS = r1;
            }

            public final boolean oQ() {
                w.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
                b.IG();
                this.hQS.IC();
                return false;
            }
        }, false);
        this.hQH = new com.tencent.map.a.a.b(this) {
            final /* synthetic */ b hQS;

            {
                this.hQS = r1;
            }

            public final void a(double d, double d2, int i, int i2, long j) {
                w.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
            }
        };
        this.hQI = 0;
        this.hQJ = new com.tencent.map.a.a.c(this) {
            final /* synthetic */ b hQS;

            {
                this.hQS = r1;
            }

            public final void g(int i, String str) {
                w.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", Integer.valueOf(i), str);
                if (i != 0) {
                    b bVar = this.hQS;
                    int i2 = bVar.hQI + 1;
                    bVar.hQI = i2;
                    if (i2 > 3) {
                        w.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", Integer.valueOf(3));
                        b.IH();
                        this.hQS.IC();
                    }
                }
            }
        };
    }

    public static String IB() {
        String rA = p.rA();
        h.vG();
        try {
            w.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new String(Base64.encode(new s().encrypt((rA + "_" + new o(com.tencent.mm.kernel.a.uH()).toString()).getBytes("UTF-8"), hQu), 0), "UTF-8"), bg.Qj(r1));
            return new String(Base64.encode(new s().encrypt((rA + "_" + new o(com.tencent.mm.kernel.a.uH()).toString()).getBytes("UTF-8"), hQu), 0), "UTF-8");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            w.e("MicroMsg.SenseWhereHelper", "create imei error: " + e.toString());
            return "";
        }
    }

    public final void IC() {
        h.vJ();
        h.vL().D(new Runnable(this) {
            final /* synthetic */ b hQS;

            {
                this.hQS = r1;
            }

            public final void run() {
                w.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
                com.tencent.mm.sdk.b.a.urY.c(this.hQS.hQF);
                t.nC();
                t.finish();
                if (this.hQS.hQC != null) {
                    this.hQS.hQC.finish();
                    this.hQS.hQC = null;
                }
                b bVar = this.hQS;
                if (bVar.hQx != null) {
                    bVar.hQx.nJF.quit();
                }
                bVar.hQx = null;
                this.hQS.hQG.KH();
                bVar = this.hQS;
                if (bVar.startTime > 0) {
                    w.d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", Long.valueOf((bg.NA() - bVar.startTime) / 1000), Integer.valueOf(bg.f((Integer) g.a((int) ((bg.NA() - bVar.startTime) / 1000), new int[]{5, 10, 20, 30}, 10, 14))));
                    g.oUh.a(345, (long) r0, 1, false);
                }
                this.hQS.hQw = false;
            }
        });
    }

    public final boolean ID() {
        h.vG();
        if (new o(com.tencent.mm.kernel.a.uH()).longValue() < 1000000) {
            w.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
            return false;
        }
        String value = com.tencent.mm.i.g.sV().getValue("AndroidSenseWhereArgs");
        if (bg.mA(value)) {
            w.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
            return false;
        }
        try {
            w.d("MicroMsg.SenseWhereHelper", "sense where config : " + value);
            String[] split = value.split(";");
            int i = bg.getInt(split[0], 0);
            h.vG();
            if (com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH() + 5, 100) > i) {
                w.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", Integer.valueOf(com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH() + 5, 100)), Integer.valueOf(i));
                return false;
            }
            this.hQz = bg.getInt(split[1], Downloads.MIN_RETYR_AFTER);
            this.hQy = bg.getInt(split[2], Downloads.MIN_RETYR_AFTER);
            this.hQA = bg.getInt(split[3], 30000);
            this.hQB = bg.getInt(split[4], 3600);
            w.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", Integer.valueOf(this.hQz), Integer.valueOf(this.hQy), Integer.valueOf(this.hQA), Integer.valueOf(this.hQB));
            if (bg.az(((Long) h.vI().vr().get(a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue()) > ((long) this.hQB)) {
                return true;
            }
            w.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", Long.valueOf(bg.az(((Long) h.vI().vr().get(a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue())), Integer.valueOf(this.hQB));
            return false;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            w.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + e.toString());
            w.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
            return false;
        }
    }

    public static void IE() {
        if (bg.az(bg.a((Long) h.vI().vr().get(a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, null), 0)) * 1000 > 21600000) {
            w.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
            h.vH().gXC.a(new k(36), 0);
            h.vI().vr().a(a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, Long.valueOf(bg.Ny()));
        }
    }

    public final boolean a(int i, float f, float f2) {
        List list;
        if (i == 1) {
            list = this.hQD;
        } else {
            list = this.hQE;
        }
        if (r2 == null || r2.size() <= 0) {
            w.i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
            return false;
        }
        boolean z;
        long NA = bg.NA();
        for (d dVar : r2) {
            w.d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(dVar.latitude), Double.valueOf(dVar.longitude), Double.valueOf(TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f)), Double.valueOf(dVar.hQZ));
            if (TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f) <= dVar.hQZ) {
                z = true;
                break;
            }
        }
        z = false;
        w.i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f), Boolean.valueOf(z), Long.valueOf(bg.aB(NA)));
        return z;
    }

    public final void gu(int i) {
        long j = (long) i;
        this.hQG.v(j, j);
    }

    public static void IF() {
        g.oUh.a(345, 1, 1, false);
    }

    public static void IG() {
        g.oUh.a(345, 2, 1, false);
    }

    public static void IH() {
        g.oUh.a(345, 3, 1, false);
    }

    public static void II() {
        g.oUh.a(345, 5, 1, false);
    }
}
