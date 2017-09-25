package com.tencent.mm.plugin.photoedit.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.mm.plugin.photoedit.c.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Stack;

public final class a implements c<com.tencent.mm.plugin.photoedit.f.a> {
    public Stack<com.tencent.mm.plugin.photoedit.f.a> okR;
    private Stack<com.tencent.mm.plugin.photoedit.f.a> okS;
    public Matrix okT = new Matrix();

    public final /* synthetic */ Object pop() {
        return aSj();
    }

    public final void onCreate() {
        w.i("MicroMsg.CropCache", "[onCreate]");
        this.okR = new Stack();
    }

    public final void onDestroy() {
        if (this.okR != null) {
            this.okR.clear();
        }
        if (this.okS != null) {
            this.okS.clear();
        }
        this.okT.reset();
    }

    public final void gf(boolean z) {
        w.i("MicroMsg.CropCache", "[onSave] size:%s", Integer.valueOf(this.okR.size()));
        if (this.okS != null) {
            this.okS.clear();
        }
        this.okS = (Stack) this.okR.clone();
        if (z) {
            this.okR.clear();
        }
    }

    public final void aSi() {
        w.i("MicroMsg.CropCache", "[onRestore] size:%s", Integer.valueOf(this.okR.size()));
        this.okR.clear();
        if (this.okS != null) {
            w.i("MicroMsg.CropCache", "[onRestore] %s", Integer.valueOf(this.okS.size()));
            this.okR.addAll(this.okS);
        }
    }

    public final com.tencent.mm.plugin.photoedit.f.a aSj() {
        if (this.okR.size() > 0) {
            return (com.tencent.mm.plugin.photoedit.f.a) this.okR.pop();
        }
        w.e("MicroMsg.CropCache", "[pop]");
        return null;
    }

    public final void a(com.tencent.mm.plugin.photoedit.f.a aVar) {
        if (this.okR != null) {
            this.okR.push(aVar);
        }
    }

    public final void a(Canvas canvas, boolean z, Object... objArr) {
    }

    public final void h(Canvas canvas) {
    }

    public final void v(Bitmap bitmap) {
    }

    public final Bitmap aSk() {
        return null;
    }

    public final boolean aSl() {
        return gg(true) > 0;
    }

    public final com.tencent.mm.plugin.photoedit.f.a aSm() {
        if (this.okR == null || this.okR.size() <= 0) {
            return null;
        }
        return (com.tencent.mm.plugin.photoedit.f.a) this.okR.peek();
    }

    public final int gg(boolean z) {
        if (z) {
            if (this.okR != null) {
                return this.okR.size();
            }
            return 0;
        } else if (this.okS != null) {
            return this.okS.size();
        } else {
            return 0;
        }
    }
}
