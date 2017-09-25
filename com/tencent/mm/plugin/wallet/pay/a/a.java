package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.d;
import com.tencent.mm.plugin.wallet.pay.a.a.e;
import com.tencent.mm.plugin.wallet.pay.a.a.f;
import com.tencent.mm.plugin.wallet.pay.a.a.g;
import com.tencent.mm.plugin.wallet.pay.a.a.h;
import com.tencent.mm.plugin.wallet.pay.a.c.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static b a(Authen authen, Orders orders, boolean z) {
        if (authen == null || orders == null) {
            w.i("MicroMsg.CgiManager", "empty authen or orders");
            return null;
        }
        PayInfo payInfo = authen.oLz;
        String str = "";
        if (payInfo != null) {
            w.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.fJH;
        }
        if (bg.mA(str) && orders != null) {
            w.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.fJH;
        }
        if (bg.mA(str)) {
            w.i("MicroMsg.CgiManager", "empty reqKey!");
            return new b(authen, orders, z);
        }
        w.i("MicroMsg.CgiManager", "authen reqKey: %s", new Object[]{str});
        if (!(payInfo == null || orders == null)) {
            w.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fJH, orders.fJH});
        }
        w.i("MicroMsg.CgiManager", "authen go new split cgi");
        if (str.startsWith("sns_aa_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, z);
        }
        if (str.startsWith("sns_tf_")) {
            return new h(authen, orders, z);
        }
        if (str.startsWith("sns_ff_")) {
            return new d(authen, orders, z);
        }
        if (str.startsWith("ts_")) {
            return new e(authen, orders, z);
        }
        if (str.startsWith("sns_")) {
            return new g(authen, orders, z);
        }
        if (str.startsWith("offline_")) {
            return new f(authen, orders, z);
        }
        return new b(authen, orders, z);
    }

    public static com.tencent.mm.plugin.wallet.pay.a.c.e a(n nVar, Orders orders) {
        if (nVar == null || orders == null) {
            w.e("MicroMsg.CgiManager", "empty verify or orders");
            return null;
        }
        PayInfo payInfo = nVar.oLz;
        String str = "";
        if (payInfo != null) {
            w.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.fJH;
        }
        if (bg.mA(str)) {
            w.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.fJH;
        }
        if (bg.mA(str)) {
            w.i("MicroMsg.CgiManager", "empty reqKey!");
            return new com.tencent.mm.plugin.wallet.pay.a.c.e(nVar, orders);
        }
        if (payInfo != null) {
            w.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fJH, orders.fJH});
        }
        w.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[]{str});
        w.i("MicroMsg.CgiManager", "verify go new split cgi");
        if (str.startsWith("sns_aa_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.a(nVar, orders);
        }
        if (str.startsWith("sns_tf_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.g(nVar, orders);
        }
        if (str.startsWith("sns_ff_")) {
            return new c(nVar, orders);
        }
        if (str.startsWith("ts_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.d(nVar, orders);
        }
        if (str.startsWith("sns_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.c.f(nVar, orders);
        }
        return new com.tencent.mm.plugin.wallet.pay.a.c.e(nVar, orders);
    }
}
