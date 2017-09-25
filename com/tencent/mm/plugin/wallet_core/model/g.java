package com.tencent.mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.wallet_core.c.b;

public final class g {
    public int rED = 0;
    public String rEE = "";
    public int rEF = 0;
    public String rEG = "";
    public int rEH = 0;
    public b rEI = new b();

    public g(Bundle bundle) {
        this.rED = bundle.getInt("key_is_gen_cert", 0);
        this.rEF = bundle.getInt("key_is_hint_crt", 0);
        this.rEH = bundle.getInt("key_is_ignore_cert", 0);
        this.rEE = bundle.getString("key_crt_token", "");
        this.rEG = bundle.getString("key_crt_wording", "");
        this.rEI = new b(this.rEG);
    }

    public final boolean btF() {
        if (this.rEF == 0 || bg.mA(this.rEG)) {
            return false;
        }
        return true;
    }

    public final boolean btG() {
        if (this.rED == 1) {
            return true;
        }
        return false;
    }
}
