package com.tencent.mm.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class eu extends com.tencent.mm.sdk.b.b {
    public a fIY;
    public b fIZ;

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

    public eu() {
        this((byte) 0);
    }

    private eu(byte b) {
        this.fIY = new a();
        this.fIZ = new b();
        this.use = false;
        this.nFq = null;
    }
}
