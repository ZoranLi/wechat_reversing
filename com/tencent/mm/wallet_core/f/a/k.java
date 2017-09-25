package com.tencent.mm.wallet_core.f.a;

import org.json.JSONObject;

public abstract class k extends h {
    private int errCode = 0;
    private String fPf = "";
    public boolean rzL = false;
    private boolean wER = false;
    public boolean wES = false;
    public boolean wET = false;

    public final void y(boolean z, boolean z2) {
        super.y(z, z2);
    }

    public void a(int i, String str, JSONObject jSONObject) {
        this.errCode = i;
        this.fPf = str;
    }

    public boolean bfA() {
        return false;
    }

    public final boolean aXd() {
        return !this.wES;
    }
}
