package com.tencent.mm.e.a;

import android.content.Context;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.storage.au;
import java.util.List;

public final class lz extends com.tencent.mm.sdk.b.b {
    public a fTf;
    public b fTg;

    public static final class a {
        public Context context;
        public String desc;
        public long fGM = 0;
        public rm fKe;
        public String fKv;
        public String fKz;
        public cb fSJ;
        public String fTh;
        public rv fTi;
        public int fTj = 0;
        public au fTk;
        public List<au> fTl;
        public String fTm;
        public String fTn;
        public d fTo;
        public String title;
        public String toUser;
        public int type = 0;
    }

    public static final class b {
        public String fKz;
        public cb fSJ;
        public d fTo;
        public c fTp;
        public String fTq;
        public boolean fTr = false;
        public boolean fTs = false;
    }

    public lz() {
        this((byte) 0);
    }

    private lz(byte b) {
        this.fTf = new a();
        this.fTg = new b();
        this.use = false;
        this.nFq = null;
    }
}
