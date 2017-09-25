package com.tencent.mm.plugin.product.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public List<String> opn = new ArrayList();

    public d() {
        Oe();
    }

    private void Oe() {
        this.opn.clear();
        ap.yY();
        String str = (String) c.vr().get(270340, "");
        w.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : bg.f(str2.split(";"))) {
            if (!bg.mA(str2)) {
                this.opn.add(str2);
            }
        }
    }

    public final boolean aTl() {
        w.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.opn.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.opn) {
            if (!(bg.mA(str) || str.contains(";"))) {
                stringBuffer.append(str);
            }
        }
        w.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        ap.yY();
        c.vr().set(270340, stringBuffer.toString());
        return true;
    }
}
