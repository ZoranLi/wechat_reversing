package com.tencent.mm.plugin.sport.c;

import android.os.Looper;
import com.tencent.mm.e.a.fa;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ba;
import java.util.Calendar;
import org.json.JSONObject;

public final class b {
    public c<pq> qRk = new c<pq>(this) {
        final /* synthetic */ b qRu;

        {
            this.qRu = r2;
            this.usg = pq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pq pqVar = (pq) bVar;
            switch (pqVar.fWA.action) {
                case 1:
                case 2:
                case 3:
                    if (k.bmA()) {
                        boolean dR;
                        long bJU = bg.bJU() / 10000;
                        long F = h.F(513, 0);
                        long F2 = h.F(512, 0);
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(F);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        if (bJU != instance.getTimeInMillis() / 10000) {
                            F2 = 0;
                        }
                        if (pqVar.fWA.action == 1) {
                            dR = this.qRu.dR(F2);
                            com.tencent.mm.sdk.b.b faVar = new fa();
                            faVar.fJp.action = 1;
                            a.urY.a(faVar, Looper.getMainLooper());
                        } else {
                            dR = k.t(this.qRu.bms(), F2) ? this.qRu.dR(F2) : false;
                        }
                        w.i("MicroMsg.Sport.ExtApiStepManager", "upload step %d %d %b", new Object[]{Integer.valueOf(pqVar.fWA.action), Long.valueOf(F2), Boolean.valueOf(dR)});
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    public e qRl;
    public c qRr = new c<fa>(this) {
        final /* synthetic */ b qRu;

        {
            this.qRu = r2;
            this.usg = fa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return this.qRu.i((fa) bVar);
        }
    };
    private long qRs;
    private long qRt;

    public b() {
        this.qRr.bIy();
        this.qRk.bIy();
    }

    public final boolean i(com.tencent.mm.sdk.b.b bVar) {
        fa faVar = (fa) bVar;
        switch (faVar.fJp.action) {
            case 2:
                int i;
                long j = faVar.fJp.fJs;
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = faVar.fJp.fJt;
                com.tencent.mm.e.a.fa.b bVar2 = faVar.fJq;
                if (!k.bmm()) {
                    i = 3906;
                } else if (k.bmA()) {
                    long F = h.F(513, 0);
                    long F2 = h.F(512, 0);
                    w.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[]{Long.valueOf(F), Long.valueOf(F2), Long.valueOf(currentTimeMillis), Long.valueOf(j)});
                    if (currentTimeMillis - F < 300000) {
                        w.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
                        i = 3903;
                    } else {
                        JSONObject bmv = f.bmv();
                        if (!bg.w(currentTimeMillis, F)) {
                            F = bg.bJU();
                            F2 = 0;
                        }
                        long j3 = currentTimeMillis - F;
                        w.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[]{Long.valueOf((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))), Long.valueOf(j3), Long.valueOf(currentTimeMillis), Long.valueOf(F), Long.valueOf(((long) bmv.optInt("stepCounterMaxStep5m")) * ((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))))});
                        F2 = j - F2;
                        if (F2 < 0 || F2 > r14) {
                            w.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[]{Long.valueOf(F2), Long.valueOf(r14)});
                            i = 3904;
                        } else {
                            w.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[]{k.aq(currentTimeMillis), Long.valueOf(j)});
                            h.G(513, currentTimeMillis);
                            h.G(512, j);
                            h.G(514, j2);
                            i = 1;
                        }
                    }
                } else {
                    i = 3902;
                }
                bVar2.fJw = i;
                if (faVar.fJq.fJw == 1) {
                    if (this.qRs == 0) {
                        this.qRs = h.F(515, 0);
                    }
                    boolean s = k.s(this.qRs, System.currentTimeMillis());
                    boolean t = k.t(bms(), j);
                    if (s && t) {
                        dR(j);
                    }
                }
                faVar.fJq.fJv = true;
                break;
            case 3:
                try {
                    JSONObject optJSONObject = f.bmv().optJSONObject("extStepApiConfig");
                    if (optJSONObject != null) {
                        faVar.fJq.fJu = optJSONObject.toString();
                    }
                    if (bg.mA(faVar.fJq.fJu)) {
                        faVar.fJq.fJw = 3905;
                    } else {
                        faVar.fJq.fJw = 1;
                    }
                } catch (Exception e) {
                    faVar.fJq.fJw = 3905;
                }
                faVar.fJq.fJv = true;
                break;
        }
        return true;
    }

    public final boolean dR(long j) {
        if (this.qRl != null) {
            h.vd().c(this.qRl);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        w.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[]{k.aq(currentTimeMillis), Long.valueOf(j)});
        this.qRl = new e("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (currentTimeMillis / 1000), (int) j, ba.bMW(), 2);
        h.vd().a(this.qRl, 0);
        this.qRs = currentTimeMillis;
        h.G(515, currentTimeMillis);
        this.qRt = j;
        h.F(516, this.qRt);
        return true;
    }

    public final long bms() {
        if (this.qRt == 0) {
            this.qRt = h.F(516, 0);
        }
        return this.qRt;
    }
}
