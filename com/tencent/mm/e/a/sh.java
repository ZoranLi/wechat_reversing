package com.tencent.mm.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class sh extends com.tencent.mm.sdk.b.b {
    public a fZN;
    public b fZO;

    public static final class a {
        public Context context;
        public int fIt = 0;
        public String fZP;
        public Uri uri;
    }

    public static final class b {
        public Cursor fIu;
    }

    public sh() {
        this((byte) 0);
    }

    private sh(byte b) {
        this.fZN = new a();
        this.fZO = new b();
        this.use = false;
        this.nFq = null;
    }
}
