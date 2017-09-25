package com.tencent.mm.plugin.game.model;

import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public final class ah implements e {
    ArrayList<a> mrv;
    private boolean mrw = false;

    public static class a {
        public int hVl;
        public String mrx;

        public static a h(int i, Object... objArr) {
            a aVar = new a();
            aVar.hVl = i;
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            aVar.mrx = stringBuilder.toString();
            if (k.fLH > 0) {
                w.i("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString()});
            } else {
                w.d("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString()});
            }
            return aVar;
        }
    }

    public ah() {
        ap.vd().a(427, this);
        this.mrv = new ArrayList();
    }

    public final void a(a aVar) {
        if (!this.mrv.contains(aVar)) {
            this.mrv.add(aVar);
        }
        aBt();
    }

    private void aBt() {
        while (!this.mrw) {
            if (this.mrv == null || this.mrv.size() == 0) {
                w.d("MicroMsg.AppReportService", "report queue is null, no need do scnene");
                return;
            }
            a aVar = (a) this.mrv.remove(0);
            if (aVar != null) {
                this.mrw = true;
                ap.vd().a(new al(aVar.hVl, aVar.mrx), 0);
                return;
            }
        }
        w.i("MicroMsg.AppReportService", "is doing scene, wait for a minite");
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.mrw = false;
        aBt();
    }
}
