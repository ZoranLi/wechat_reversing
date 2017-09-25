package com.tencent.mm.modelbiz;

import android.net.Uri;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.ln;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import java.util.Iterator;
import java.util.LinkedList;

public final class j {
    private a gKp;
    public int hvO;
    private c hvP;
    private int hvQ;
    public int hvR;
    public boolean hvS;
    public b hvT;
    public String userName;

    protected j() {
        this.userName = null;
        this.hvO = 0;
        this.hvQ = 2;
        this.hvR = 10;
        this.hvS = false;
        this.hvT = new b(this) {
            final /* synthetic */ j hvU;

            {
                this.hvU = r1;
            }

            public final void a(int i, m mVar, Object obj) {
                if (obj == null || !(obj instanceof String)) {
                    w.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
                } else if (this.hvU.userName.equals((String) obj) && this.hvU.hvO == 1) {
                    w.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", this.hvU.userName);
                    this.hvU.ij(this.hvU.userName);
                    ((h) com.tencent.mm.kernel.h.h(h.class)).wR().b(this.hvU.hvT);
                }
            }
        };
        this.gKp = new a(this) {
            final /* synthetic */ j hvU;
            long lastReportTime = 0;

            {
                this.hvU = r3;
            }

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                if (!z) {
                    return true;
                }
                w.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", Float.valueOf(f2), Float.valueOf(f));
                if (bg.Ny() >= this.lastReportTime + ((long) this.hvU.hvR)) {
                    j.a(this.hvU.userName, 11, 0, f2, f, (int) d2, null);
                    this.lastReportTime = bg.Ny();
                }
                if (this.hvU.hvO == 2) {
                    this.hvU.DA();
                }
                if (!this.hvU.hvS) {
                    this.hvU.hvS = true;
                    n.a(2013, f, f2, (int) d2);
                }
                return true;
            }
        };
        this.hvR = bg.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sW().z("BrandService", "continueLocationReportInterval"), 5);
        if (this.hvR < this.hvQ) {
            this.hvR = this.hvQ;
        }
        w.i("MicroMsg.ReportLocation", "reportLocation interval %d", Integer.valueOf(this.hvR));
    }

    public final void b(final String str, final au auVar) {
        if (auVar == null || !auVar.bLX()) {
            a(str, 10, 0, 0.0f, 0.0f, 0, null);
        } else {
            com.tencent.mm.kernel.h.vL().D(new Runnable(this) {
                final /* synthetic */ j hvU;

                public final void run() {
                    LinkedList linkedList = new LinkedList();
                    k rV = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
                    if (rV == null || bg.bV(rV.hkm)) {
                        j.a(str, 10, 0, 0.0f, 0.0f, 0, null);
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = rV.hkm.iterator();
                    while (it.hasNext()) {
                        String str = ((l) it.next()).url;
                        if (!bg.mA(str)) {
                            Uri parse = Uri.parse(str);
                            String queryParameter = parse.getQueryParameter("mid");
                            str = parse.getQueryParameter("idx");
                            ln lnVar = new ln();
                            lnVar.trU = bg.getLong(queryParameter, 0);
                            lnVar.pjn = bg.getInt(str, 0);
                            linkedList.add(lnVar);
                            stringBuilder.append("mid:").append(queryParameter).append(",idx:").append(str).append("; ");
                        }
                    }
                    w.v("MicroMsg.ReportLocation", "click command : msgReport %s", stringBuilder.toString());
                    j.a(str, 10, 0, 0.0f, 0.0f, 0, linkedList);
                }
            });
        }
    }

    public static void ii(String str) {
        a(str, 12, 0, 0.0f, 0.0f, 0, null);
    }

    public final void ij(String str) {
        w.i("MicroMsg.ReportLocation", "Start report");
        this.userName = str;
        BizInfo hW = e.hW(str);
        if (hW != null) {
            if (this.hvO != 0) {
                DA();
            }
            this.hvO = 0;
            if (hW.CB()) {
                w.i("MicroMsg.ReportLocation", "need update contact %s", str);
                com.tencent.mm.x.b.he(str);
            }
            ExtInfo bd = hW.bd(false);
            if (bd == null) {
                return;
            }
            if (bd.CD() && hW.CA()) {
                this.hvP = c.Gk();
                bd = hW.bd(false);
                if (bd.hux != null) {
                    boolean z;
                    if (bg.getInt(bd.hux.optString("ReportLocationType"), 0) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bd.huK = z;
                }
                this.hvO = bd.huK ? 3 : 2;
                if (c.Gl() || c.Gm()) {
                    this.hvP.a(this.gKp, true);
                } else {
                    a(str, 11, 2, 0.0f, 0.0f, 0, null);
                }
            } else if (bd.CD() && !hW.CA()) {
                a(str, 11, 1, 0.0f, 0.0f, 0, null);
            }
        }
    }

    public final void DA() {
        w.i("MicroMsg.ReportLocation", "Stop report");
        this.hvO = 0;
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
        if (com.tencent.mm.kernel.h.vG().uV()) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wR().b(this.hvT);
        }
    }

    public static void a(String str, int i, int i2, float f, float f2, int i3, LinkedList<ln> linkedList) {
        String str2;
        if (i2 == 3) {
            str2 = "<event></event>";
        } else {
            str2 = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i3)});
        }
        w.i("MicroMsg.ReportLocation", "doScene, info: %s", str2);
        com.tencent.mm.kernel.h.vH().gXC.a(new p(str, i, str2, linkedList), 0);
    }
}
