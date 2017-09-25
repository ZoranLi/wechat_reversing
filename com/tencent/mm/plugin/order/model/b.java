package com.tencent.mm.plugin.order.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public HashSet<String> ofJ = new HashSet();

    public b() {
        aue();
    }

    private void aue() {
        this.ofJ.clear();
        ap.yY();
        for (String str : bg.f(((String) c.vr().get(204803, "")).split(";"))) {
            if (!(bg.mA(str) || this.ofJ.contains(str))) {
                this.ofJ.add(str);
            }
        }
        ap.yY();
        c.vr().set(204817, Integer.valueOf(this.ofJ.size()));
        w.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.ofJ.size());
    }

    public final void aRA() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.ofJ.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bg.mA(str)) {
                stringBuffer.append(str + ";");
            }
        }
        ap.yY();
        c.vr().set(204803, stringBuffer.toString());
    }
}
