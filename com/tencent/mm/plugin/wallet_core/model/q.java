package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.d.a.c.h;
import com.tencent.mm.sdk.platformtools.w;
import java.security.Signature;

public enum q {
    ;
    
    public String lOH;
    public boolean lOI;
    private Signature rHC;
    public h rHD;

    private q(String str) {
        this.lOH = null;
        this.lOI = false;
        this.rHC = null;
        this.rHD = null;
    }

    public final void reset() {
        w.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
        this.rHC = null;
        this.lOH = null;
        this.lOI = false;
    }
}
