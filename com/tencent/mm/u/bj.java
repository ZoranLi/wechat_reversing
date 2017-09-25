package com.tencent.mm.u;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import junit.framework.Assert;

public final class bj implements d {
    public final b b(a aVar) {
        boolean z = true;
        bu buVar = aVar.hst;
        Assert.assertTrue(buVar != null);
        if (buVar.tff == null) {
            z = false;
        }
        Assert.assertTrue(z);
        String str = (String) bh.q(n.a(buVar.tff), "tips").get(".tips.tip.url");
        w.v("MicroMsg.SoftwareMsgExtension", "url:" + str);
        ap.yY();
        c.vr().set(12308, str);
        return null;
    }

    public final void h(au auVar) {
    }
}
