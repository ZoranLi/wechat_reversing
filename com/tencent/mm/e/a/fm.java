package com.tencent.mm.e.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.protocal.c.rm;

public final class fm extends com.tencent.mm.sdk.b.b {
    public a fKc;
    public b fKd;

    public static final class a {
        public Context context;
        public long fFx;
        public rm fKe;
        public ImageView fKf;
        public int fKg;
        public boolean fKh = false;
        public boolean fKi = false;
        public boolean fKj = true;
        public int height;
        public int maxWidth;
        public int opType = -1;
        public int width;
    }

    public static final class b {
        public Bitmap fKk;
        public int ret = -1;
    }

    public fm() {
        this((byte) 0);
    }

    private fm(byte b) {
        this.fKc = new a();
        this.fKd = new b();
        this.use = false;
        this.nFq = null;
    }
}
