package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

abstract class b extends com.tencent.mm.plugin.appbrand.jsapi.a {

    interface a {
        void Tn();
    }

    protected abstract void a(m mVar, JSONObject jSONObject, int i, a aVar);

    b() {
    }

    public void a(m mVar, JSONObject jSONObject, int i) {
        final e d = a.d(mVar.ixr);
        final m mVar2 = mVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i2 = i;
        AnonymousClass1 anonymousClass1 = new a(this) {
            final /* synthetic */ b iQH;

            public final void Tq() {
                w.i("MicroMsg.AppBrand.BaseAuthJsApi", "about to call AuthInvoke, api[%s]", new Object[]{this.iQH.getName()});
                this.iQH.a(mVar2, jSONObject2, i2, d);
            }

            public final String toString() {
                return hashCode() + "|" + this.iQH.getName();
            }
        };
        if (!d.Tp()) {
            synchronized (d.jnS) {
                d.jnS.offer(anonymousClass1);
            }
            d.yw(1);
        }
    }

    final void a(m mVar, int i, String str) {
        mVar.x(i, d(str, null));
    }

    protected final MMActivity a(m mVar) {
        return super.a(mVar);
    }
}
