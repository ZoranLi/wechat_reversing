package com.tencent.mm.a;

final class i {
    public byte[] fuP;
    public int fuQ;

    public i() {
        this.fuQ = 0;
        this.fuP = new byte[256];
    }

    public i(byte b) {
        this.fuQ = 0;
        this.fuP = new byte[]{b};
    }

    public i(byte[] bArr) {
        this.fuQ = 0;
        this.fuP = bArr;
    }
}
