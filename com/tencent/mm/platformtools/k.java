package com.tencent.mm.platformtools;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;

public final class k implements Runnable {
    String fTm;
    String hkV;
    String ihY;

    public k(String str, String str2, String str3) {
        this.fTm = str;
        this.hkV = str2;
        this.ihY = str3;
    }

    public final void run() {
        if (!bg.mA(this.fTm) && !bg.mA(this.hkV)) {
            w.d("MicroMsg.MoveDataFiles", "MoveDataFiles %s :" + this.fTm + " to :" + this.hkV, this.ihY);
            if (f.rZ() && this.hkV.substring(0, e.hgu.length()).equals(e.hgu)) {
                j.p(this.fTm + "/" + this.ihY, this.hkV + "/" + this.ihY, true);
            }
        }
    }
}
