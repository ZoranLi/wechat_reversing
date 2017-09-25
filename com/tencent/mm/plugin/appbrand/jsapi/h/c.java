package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class c extends b {
    private int iLf;
    WeakReference<m> iNd;
    private d iUo;

    abstract void k(JSONObject jSONObject);

    c() {
    }

    final void a(d dVar, m mVar, JSONObject jSONObject, int i) {
        this.iUo = dVar;
        this.iNd = new WeakReference(mVar);
        this.iLf = i;
        k(jSONObject);
    }

    protected final View TT() {
        return this.iNd == null ? null : ((m) this.iNd.get()).jbY;
    }

    final void e(String str, Map<String, Object> map) {
        if (this.iNd != null && this.iNd.get() != null && this.iUo != null) {
            ((m) this.iNd.get()).x(this.iLf, this.iUo.d(str, map));
        }
    }
}
