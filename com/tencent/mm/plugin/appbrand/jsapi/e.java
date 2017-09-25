package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import org.json.JSONObject;

public abstract class e extends b {
    private int iKS;
    private h ixr;
    public String mData;

    public final e a(c cVar) {
        if (cVar != null) {
            this.ixr = cVar.PI();
            this.iKS = cVar.hashCode();
        }
        return this;
    }

    public final e ad(String str, int i) {
        this.ixr = b.mW(str);
        this.iKS = i;
        return this;
    }

    public final e q(Map<String, Object> map) {
        d.r(map);
        this.mData = new JSONObject(map).toString();
        return this;
    }

    final boolean b(c cVar) {
        if (c.e(this.ixr).a(cVar, this, null).code == 1) {
            return true;
        }
        return false;
    }

    public final boolean SR() {
        if (this.ixr == null && !com.tencent.mm.sdk.a.b.bIu() && !com.tencent.mm.sdk.a.b.bIs()) {
            return false;
        }
        boolean z;
        boolean z2 = this.ixr.iwC.iAk.QD() == a.SUSPEND;
        boolean b = b(this.ixr.iwq);
        if (z2 || b) {
            z = true;
        } else {
            z = false;
        }
        if (com.tencent.mm.compatible.loader.a.a(l.iLc, getClass())) {
            boolean z3 = false;
        } else {
            int i = 1;
        }
        if (i != 0) {
            w.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", new Object[]{Boolean.valueOf(z), getName(), Integer.valueOf(SO()), Boolean.valueOf(z2), Boolean.valueOf(b)});
        }
        if (!z || this.ixr == null || this.ixr.iwq == null) {
            return false;
        }
        this.ixr.iwq.f(getName(), this.mData, this.iKS);
        return true;
    }

    public final boolean g(int[] iArr) {
        if (!b(this.ixr.iwr.VN().VC())) {
            w.d("MicroMsg.AppBrandJsApiEvent", "event name = %s, ctrlIndex = %d, perm denied", new Object[]{getName(), Integer.valueOf(SO())});
            return false;
        } else if (this.ixr == null || this.ixr.iwr == null) {
            return false;
        } else {
            this.ixr.iwr.c(getName(), this.mData, iArr);
            return true;
        }
    }
}
