package com.tencent.mm.e.a;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.ui.snackbar.b.c;

public final class cb extends com.tencent.mm.sdk.b.b {
    public a fFA;
    public b fFB;

    public static final class a {
        public Activity activity;
        public String desc;
        public rv fFC;
        public se fFD;
        public int fFE = 0;
        public String fFF;
        public int fFG = 0;
        public int fFH = 0;
        public OnClickListener fFI;
        public c fFJ;
        public String fFs;
        public Fragment ov;
        public String title;
        public int type = 0;
    }

    public static final class b {
        public int ret = 0;
    }

    public cb() {
        this((byte) 0);
    }

    private cb(byte b) {
        this.fFA = new a();
        this.fFB = new b();
        this.use = false;
        this.nFq = null;
    }
}
