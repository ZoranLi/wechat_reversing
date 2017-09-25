package com.tencent.mm.e.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.g.c;

public final class ie extends com.tencent.mm.sdk.b.b {
    public a fNI;
    public b fNJ;

    public static final class a {
        public String appId;
        public Context context;
        public Bundle fFu;
        public WXMediaMessage fNK;
        public c fNL;
        public int showType;
    }

    public static final class b {
        public boolean fNM;
    }

    public ie() {
        this((byte) 0);
    }

    private ie(byte b) {
        this.fNI = new a();
        this.fNJ = new b();
        this.use = false;
        this.nFq = null;
    }
}
