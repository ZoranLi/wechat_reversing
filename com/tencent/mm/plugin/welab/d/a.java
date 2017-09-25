package com.tencent.mm.plugin.welab.d;

import android.app.Activity;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.b.ca;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;

public final class a implements b {
    public final void c(Activity activity, String str) {
        ca KV = ((d) h.h(d.class)).KV(str);
        com.tencent.mm.sdk.b.b prVar = new pr();
        prVar.fWB.userName = KV.field_WeAppUser;
        prVar.fWB.fWD = KV.field_WeAppPath;
        prVar.fWB.scene = 1051;
        prVar.fWB.fWE = KV.field_WeAppDebugMode;
        prVar.fWB.fCN = String.format("%s:%s:%s:%s", new Object[]{(String) h.vI().vr().get(2, null), KV.field_expId, KV.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000)});
        com.tencent.mm.sdk.b.a.urY.m(prVar);
    }

    public final String bAN() {
        return null;
    }

    public final String bAO() {
        return null;
    }
}
