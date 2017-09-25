package com.tencent.mm.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class eo extends com.tencent.mm.sdk.b.b {
    public a fIr;
    public b fIs;

    public static final class a {
        public Context context;
        public String[] fCt;
        public int fIt = 0;
        public String[] selectionArgs;
        public Uri uri;
    }

    public static final class b {
        public Cursor fIu;
    }

    public eo() {
        this((byte) 0);
    }

    private eo(byte b) {
        this.fIr = new a();
        this.fIs = new b();
        this.use = false;
        this.nFq = null;
    }
}
