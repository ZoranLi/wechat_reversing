package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.a.b;
import com.tencent.tinker.lib.c.c;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class a {
    private static a xgm;
    public static boolean xgn = false;
    public final Context context;
    public final boolean qPN;
    public int tinkerFlags;
    final boolean tinkerLoadVerifyFlag;
    public final File xgo;
    final b xgp;
    public final c xgq;
    public final d xgr;
    public final File xgs;
    public final File xgt;
    public final boolean xgu;
    public d xgv;
    public boolean xgw = false;

    public static class a {
        private final Context context;
        public int status = -1;
        private File xgo;
        public b xgp;
        public c xgq;
        public d xgr;
        private File xgs;
        private File xgt;
        private final boolean xgx;
        private final boolean xgy;
        public Boolean xgz;

        public a(Context context) {
            if (context == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.context = context;
            this.xgx = com.tencent.tinker.lib.e.b.hE(context);
            this.xgy = com.tencent.tinker.lib.e.b.ht(context);
            this.xgo = SharePatchFileUtil.hx(context);
            if (this.xgo == null) {
                com.tencent.tinker.lib.e.a.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
                return;
            }
            this.xgs = SharePatchFileUtil.VQ(this.xgo.getAbsolutePath());
            this.xgt = SharePatchFileUtil.VR(this.xgo.getAbsolutePath());
            com.tencent.tinker.lib.e.a.w("Tinker.Tinker", "tinker patch directory: %s", new Object[]{this.xgo});
        }

        public final a cgR() {
            if (this.status == -1) {
                this.status = 7;
            }
            if (this.xgq == null) {
                this.xgq = new com.tencent.tinker.lib.c.a(this.context);
            }
            if (this.xgr == null) {
                this.xgr = new com.tencent.tinker.lib.c.b(this.context);
            }
            if (this.xgp == null) {
                this.xgp = new com.tencent.tinker.lib.a.a(this.context);
            }
            if (this.xgz == null) {
                this.xgz = Boolean.valueOf(false);
            }
            return new a(this.context, this.status, this.xgq, this.xgr, this.xgp, this.xgo, this.xgs, this.xgt, this.xgx, this.xgy, this.xgz.booleanValue());
        }
    }

    public a(Context context, int i, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3) {
        this.context = context;
        this.xgp = bVar;
        this.xgq = cVar;
        this.xgr = dVar;
        this.tinkerFlags = i;
        this.xgo = file;
        this.xgs = file2;
        this.xgt = file3;
        this.qPN = z;
        this.tinkerLoadVerifyFlag = z3;
        this.xgu = z2;
    }

    public static a hp(Context context) {
        if (xgn) {
            if (xgm == null) {
                synchronized (a.class) {
                    if (xgm == null) {
                        xgm = new a(context).cgR();
                    }
                }
            }
            return xgm;
        }
        throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }

    public static void a(a aVar) {
        if (xgm != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        xgm = aVar;
    }

    public final void aDl() {
        if (this.xgo != null) {
            if (this.xgw) {
                com.tencent.tinker.lib.e.a.e("Tinker.Tinker", "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
            }
            SharePatchFileUtil.d(this.xgo);
        }
    }

    public final void P(File file) {
        if (this.xgo != null && file != null && file.exists()) {
            String VS = SharePatchFileUtil.VS(SharePatchFileUtil.X(file));
            if (this.xgo != null && VS != null) {
                SharePatchFileUtil.aP(this.xgo.getAbsolutePath() + "/" + VS);
            }
        }
    }
}
