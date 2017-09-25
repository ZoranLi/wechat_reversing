package com.tencent.mm.e.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.y.k;
import java.util.List;

public final class fp extends com.tencent.mm.sdk.b.b {
    public a fKp;
    public b fKq;

    public static final class a {
        public Context context;
        public String desc;
        public rv fFC;
        public long fFx;
        public k fGg;
        public rm fKr;
        public Intent fKs;
        public com.tencent.mm.sdk.e.j.a fKt;
        public Runnable fKu;
        public String fKv;
        public int fKw = 0;
        public int fKx = 0;
        public ae handler;
        public String path;
        public String title;
        public String toUser;
        public int type = 0;
    }

    public static final class b {
        public rr fKA;
        public e fKB;
        public List fKC;
        public boolean fKD = false;
        public boolean fKE = false;
        public boolean fKF = false;
        public double fKG = 0.0d;
        public List fKy;
        public String fKz;
        public String path;
        public int ret = -1;
        public String thumbUrl;
    }

    public fp() {
        this((byte) 0);
    }

    private fp(byte b) {
        this.fKp = new a();
        this.fKq = new b();
        this.use = false;
        this.nFq = null;
    }
}
