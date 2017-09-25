package com.tencent.mm.e.a;

public final class ep extends com.tencent.mm.sdk.b.b {
    public a fIv;
    public b fIw;

    public static final class a {
        public String bssid;
        public int fIx;
        public String ssid;
        public int version = 1;
    }

    public static final class b {
        public String fIA;
        public int fIy = 0;
        public int fIz = 0;
    }

    public ep() {
        this((byte) 0);
    }

    private ep(byte b) {
        this.fIv = new a();
        this.fIw = new b();
        this.use = false;
        this.nFq = null;
    }
}
