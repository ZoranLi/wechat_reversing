package com.tencent.recovery.wx.util;

class MyByteArray {
    public byte[] fuP;
    public int fuQ;

    public MyByteArray() {
        this.fuQ = 0;
        this.fuP = new byte[256];
    }

    public MyByteArray(byte b) {
        this.fuQ = 0;
        this.fuP = new byte[]{b};
    }

    public MyByteArray(byte[] bArr) {
        this.fuQ = 0;
        this.fuP = bArr;
    }
}
