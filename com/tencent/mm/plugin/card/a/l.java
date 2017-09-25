package com.tencent.mm.plugin.card.a;

import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l implements e {
    public float gKj = -85.0f;
    public float gKk = -1000.0f;
    private long iCd = 0;

    public final void o(float f, float f2) {
        this.gKj = f;
        this.gKk = f2;
        this.iCd = System.currentTimeMillis() / 1000;
    }

    public final void m(String str, String str2, int i) {
        if ((System.currentTimeMillis() / 1000) - this.iCd > 1800) {
            this.gKj = -85.0f;
            this.gKk = -1000.0f;
            w.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
        }
        if (this.gKj == -85.0f) {
            w.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
        }
        if (this.gKk == -1000.0f) {
            w.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
        }
        ap.vd().a(1253, this);
        ap.vd().a(new u(this.gKj, this.gKk, str, str2, i), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ap.vd().b(1253, this);
    }
}
