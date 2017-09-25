package com.tencent.mm.e.a;

import android.content.Context;
import android.os.Bundle;

public final class gr extends com.tencent.mm.sdk.b.b {
    public a fLZ;
    public b fMa;

    public static final class a {
        public int actionCode;
        public Context context;
        public Bundle fMb;
        public String result;
        public String username;
    }

    public static final class b {
        public int ret = 0;
    }

    public gr() {
        this((byte) 0);
    }

    private gr(byte b) {
        this.fLZ = new a();
        this.fMa = new b();
        this.use = false;
        this.nFq = null;
    }
}
