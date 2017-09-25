package com.tencent.mm.e.a;

import android.content.Context;

public final class ag extends com.tencent.mm.sdk.b.b {
    public a fDq;
    public b fDr;

    public static final class a {
        public int action = 0;
        public Context context;
        public String fDs;
        public long fDt = 0;
        public boolean fDu = false;
        public Runnable fDv;
        public int fromScene = 0;
        public int offset = 0;
        public String title;
    }

    public static final class b {
        public boolean fDw = false;
    }

    public ag() {
        this((byte) 0);
    }

    private ag(byte b) {
        this.fDq = new a();
        this.fDr = new b();
        this.use = false;
        this.nFq = null;
    }
}
