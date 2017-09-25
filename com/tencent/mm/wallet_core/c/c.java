package com.tencent.mm.wallet_core.c;

public final class c {
    public int errCode;
    public int errType;
    public String fPf;
    public int wDU;

    public c(int i, int i2, String str) {
        this.wDU = 0;
        c(i, i2, str, 0);
    }

    public final void c(int i, int i2, String str, int i3) {
        this.errType = i;
        this.errCode = i2;
        this.fPf = str;
        this.wDU = i3;
    }

    public c() {
        this.wDU = 0;
        this.errType = 0;
        this.errCode = 0;
        this.fPf = "";
        this.wDU = 0;
    }
}
