package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import java.util.HashMap;

public final class h implements am {
    private boolean hLL = false;
    private boolean hLM = true;

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
        d.ajN();
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[]{Boolean.valueOf(z)});
    }

    public final void aN(boolean z) {
        w.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[]{Boolean.valueOf(z)});
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
        d.ajN();
    }
}
