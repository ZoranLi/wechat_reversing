package com.tencent.mm.modelfriend;

import com.tencent.mm.e.a.fg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class f extends c<fg> {
    public f() {
        this.usg = fg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fg fgVar = (fg) bVar;
        if (fgVar instanceof fg) {
            fgVar.fJN.fJQ = true;
            if (!bg.mA(m.jh(fgVar.fJM.fJO))) {
                fgVar.fJN.fJQ = false;
            } else if (bg.mA(m.jh(fgVar.fJM.fJP))) {
                w.i("MicroMsg.FMessageMobileFilterListenerImpl", "mobile fmessage not found by phonemd5 or fullphonemd5");
            } else {
                fgVar.fJN.fJQ = false;
            }
        }
        return false;
    }
}
