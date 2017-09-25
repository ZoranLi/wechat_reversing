package com.tencent.mm.plugin.appbrand.n;

import com.tencent.mm.plugin.appbrand.n.d.d;
import com.tencent.mm.plugin.appbrand.n.d.d.a;
import com.tencent.mm.plugin.appbrand.n.e.e;
import com.tencent.mm.plugin.appbrand.n.e.i;
import java.net.InetSocketAddress;

public abstract class b implements d {
    public final i XO() {
        return new e();
    }

    public void c(d dVar) {
    }

    public final void a(a aVar, d dVar) {
        d eVar = new com.tencent.mm.plugin.appbrand.n.d.e(dVar);
        eVar.a(a.PONG);
        aVar.b(eVar);
    }

    public final String a(a aVar) {
        InetSocketAddress XN = aVar.XN();
        if (XN == null) {
            throw new com.tencent.mm.plugin.appbrand.n.c.d("socket not bound");
        }
        StringBuffer stringBuffer = new StringBuffer(90);
        stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
        stringBuffer.append(XN.getPort());
        stringBuffer.append("\" /></cross-domain-policy>\u0000");
        return stringBuffer.toString();
    }
}
