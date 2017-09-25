package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class d implements a<Boolean, Boolean> {
    private b ink = null;

    public final /* synthetic */ Object call(Object obj) {
        w.v("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo isNeedSaveDeviceInfo: %b", new Object[]{(Boolean) obj});
        if (((Boolean) obj).booleanValue()) {
            this.ink = g.cbB();
            SharedPreferences bIY = ab.bIY();
            if (bIY != null) {
                w.i("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo old cpuId: %s, old uid: %s", new Object[]{bIY.getString("cpu_id", null), bIY.getString("uid", null)});
                if (bg.mA(bIY.getString("cpu_id", null)) || bg.mA(r0)) {
                    com.tencent.d.a.c.g cfF = com.tencent.d.a.a.cfF();
                    if (cfF != null) {
                        String str = cfF.qPZ;
                        String valueOf = String.valueOf(cfF.uid);
                        if (!(bg.mA(str) || bg.mA(valueOf))) {
                            com.tencent.mm.plugin.soter.c.b.dG(str, valueOf);
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(true);
    }
}
