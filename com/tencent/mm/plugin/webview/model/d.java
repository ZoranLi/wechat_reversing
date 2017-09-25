package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.by;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.b;
import com.tencent.mm.sdk.platformtools.at.c;
import com.tencent.mm.u.ap;

public final class d implements c<Integer, Long> {
    public static final String[] gUx = new String[]{i.a(iFJ, "JsLogBlockList")};
    private static final a iFJ = by.pw();
    public final g hnH;
    public final at<Integer, Long> rWu = new at(this, ap.vL().nJF.getLooper(), 100, 20, 300000, 1000);
    private long rWv;

    public d(g gVar) {
        this.hnH = gVar;
    }

    public final void bwe() {
        this.rWu.jV(true);
    }

    public final boolean Kc() {
        if (this.hnH.inTransaction()) {
            return false;
        }
        this.rWv = this.hnH.cs(Thread.currentThread().getId());
        if (this.rWv > 0) {
            return true;
        }
        return false;
    }

    public final void a(at<Integer, Long> atVar, b<Integer, Long> bVar) {
        switch (bVar.uvg) {
            case 1:
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("logId", (Integer) bVar.sWq);
                contentValues.put("liftTime", (Long) bVar.values);
                this.hnH.replace("JsLogBlockList", "logId", contentValues);
                return;
            case 2:
                this.hnH.delete("JsLogBlockList", "logId=" + bVar.sWq, null);
                return;
            default:
                return;
        }
    }

    public final void Kd() {
        if (this.rWv > 0) {
            this.hnH.aD(this.rWv);
        }
    }
}
