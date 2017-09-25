package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import android.graphics.Paint.Style;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a {
    public volatile boolean iCN;
    public JSONArray iCO;
    public d iCP;
    private c iCQ;
    public a iCR;
    public volatile String iCS;
    public volatile boolean iCT;
    private Runnable iCU = new Runnable(this) {
        final /* synthetic */ b iCZ;

        {
            this.iCZ = r1;
        }

        public final void run() {
            this.iCZ.iCT = true;
        }
    };
    private Runnable iCV = new Runnable(this) {
        final /* synthetic */ b iCZ;

        {
            this.iCZ = r1;
        }

        public final void run() {
            boolean z = this.iCZ.iCT;
            this.iCZ.iCT = false;
            if (z && this.iCZ.iCN) {
                this.iCZ.iCR.Rp();
            }
        }
    };
    public volatile long iCW;
    protected long iCX;
    protected long iCY;
    protected int mCount;

    public b(a aVar) {
        this.iCR = aVar;
        this.iCP = new d();
        this.iCQ = new c();
    }

    public final boolean b(Canvas canvas) {
        this.iCN = false;
        if (this.iCO == null || this.iCO.length() == 0) {
            return false;
        }
        long j = this.iCW;
        long nanoTime = System.nanoTime();
        String str = this.iCS;
        if (j != 0) {
            c.aQ(str, "before_draw_actions");
        }
        d dVar = this.iCP;
        dVar.iDf.clear();
        dVar.iDg.clear();
        dVar.iDd.reset();
        dVar.iDe.reset();
        dVar.iDd.setStyle(Style.STROKE);
        dVar.iDe.setStyle(Style.FILL);
        dVar.iDd.setAntiAlias(true);
        dVar.iDe.setAntiAlias(true);
        dVar.iDd.setStrokeWidth((float) h.iD(1));
        dVar.iDe.setStrokeWidth((float) h.iD(1));
        for (int i = 0; i < this.iCO.length(); i++) {
            JSONObject optJSONObject = this.iCO.optJSONObject(i);
            if (optJSONObject != null) {
                try {
                    c cVar = this.iCQ;
                    d dVar2 = this.iCP;
                    String optString = optJSONObject.optString("method");
                    JSONArray optJSONArray = optJSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    com.tencent.mm.plugin.appbrand.canvas.a.c cVar2 = (com.tencent.mm.plugin.appbrand.canvas.a.c) cVar.iDb.get(optString);
                    if (cVar2 != null) {
                        cVar2.a(dVar2, canvas, optJSONArray);
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[]{e});
                }
            }
        }
        if (j != 0) {
            c.aQ(str, "after_draw_actions");
            c.print(str);
            long nanoTime2 = System.nanoTime();
            this.iCY = (nanoTime2 - nanoTime) + this.iCY;
            this.iCX = (nanoTime2 - j) + this.iCX;
            this.mCount++;
        }
        return true;
    }

    public final void Rp() {
    }

    public final void d(final JSONArray jSONArray) {
        this.iCR.j(new Runnable(this) {
            final /* synthetic */ b iCZ;

            public final void run() {
                this.iCZ.iCO = jSONArray;
                this.iCZ.iCN = true;
            }
        });
    }

    public final void e(final JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.iCR.j(new Runnable(this) {
                final /* synthetic */ b iCZ;

                public final void run() {
                    if (this.iCZ.iCO == null) {
                        this.iCZ.iCO = jSONArray;
                    } else {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.iCZ.iCO.put(jSONArray.opt(i));
                        }
                    }
                    this.iCZ.iCN = true;
                }
            });
        }
    }

    public final void Rq() {
        this.iCR.j(new Runnable(this) {
            final /* synthetic */ b iCZ;

            {
                this.iCZ = r1;
            }

            public final void run() {
                this.iCZ.iCO = null;
                this.iCZ.iCN = true;
            }
        });
    }

    public final void nU(String str) {
        this.iCP.iDc = str;
    }

    public final void onPause() {
        this.iCW = 0;
        this.iCR.j(this.iCU);
    }

    public final void onResume() {
        this.iCR.j(this.iCV);
    }

    public final void j(Runnable runnable) {
        if (!equals(this.iCR)) {
            this.iCR.j(runnable);
        }
    }

    public final boolean isPaused() {
        return this.iCT;
    }

    public final void nV(String str) {
        this.iCS = str;
    }

    public final int Rr() {
        if (equals(this.iCR)) {
            return 0;
        }
        return this.iCR.Rr();
    }

    public final int Rs() {
        if (equals(this.iCR)) {
            return 0;
        }
        return this.iCR.Rs();
    }

    public final void setStartTime(long j) {
        this.iCW = j;
    }

    public final void Rt() {
        int i = this.mCount;
        long j = this.iCY;
        long j2 = this.iCX;
        if (i > 0 && j > 0 && j2 > 0) {
            int Rr = this.iCR.Rr();
            j /= (long) i;
            int i2 = j <= 500000 ? 0 : j <= 1000000 ? 1 : j <= 2000000 ? 2 : j <= 3000000 ? 3 : j <= 4000000 ? 4 : j <= 5000000 ? 5 : 6;
            g.oUh.a((long) Rr, (long) i2, 1, false);
            Rr = this.iCR.Rs();
            j = j2 / ((long) i);
            i2 = j <= 20000000 ? 0 : j <= 25000000 ? 1 : j <= 30000000 ? 2 : j <= 35000000 ? 3 : j <= 40000000 ? 4 : j <= 50000000 ? 5 : j <= 60000000 ? 6 : j <= 70000000 ? 7 : j <= 80000000 ? 8 : 9;
            g.oUh.a((long) Rr, (long) i2, 1, false);
        }
    }
}
