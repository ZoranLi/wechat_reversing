package com.tencent.mm.e.a;

import java.util.LinkedList;

public final class jg extends com.tencent.mm.sdk.b.b {
    public a fPy;
    public b fPz;

    public static final class a {
        public String chatroomName;
        public LinkedList<String> fPA;
        public boolean fPm = false;
        public int scene = 0;
    }

    public static final class b {
        public int errCode;
    }

    public jg() {
        this((byte) 0);
    }

    private jg(byte b) {
        this.fPy = new a();
        this.fPz = new b();
        this.use = false;
        this.nFq = null;
    }
}
