package com.tencent.mm.plugin.photoedit.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.util.SparseArray;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.photoedit.c.c;
import com.tencent.mm.plugin.photoedit.f.d.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

public final class d implements c<com.tencent.mm.plugin.photoedit.f.d> {
    private Stack<com.tencent.mm.plugin.photoedit.f.d> okR;
    private Stack<com.tencent.mm.plugin.photoedit.f.d> okS;
    private SparseArray<String> okU;
    private HashMap<String, Bitmap> okV;

    public final /* synthetic */ Object pop() {
        if (this.okR.size() > 0) {
            return (com.tencent.mm.plugin.photoedit.f.d) this.okR.pop();
        }
        w.e("MicroMsg.MosaicCache", "[pop]");
        return null;
    }

    public final void onCreate() {
        w.i("MicroMsg.MosaicCache", "[onCreate]");
        this.okR = new Stack();
        this.okU = new SparseArray();
        this.okV = new HashMap();
    }

    public final void onDestroy() {
        Iterator it;
        w.i("MicroMsg.MosaicCache", "[onDestroy]");
        if (this.okR != null) {
            it = this.okR.iterator();
            while (it.hasNext()) {
                it.next();
                com.tencent.mm.plugin.photoedit.f.d.clear();
            }
            this.okR.clear();
        }
        if (this.okS != null) {
            it = this.okS.iterator();
            while (it.hasNext()) {
                it.next();
                com.tencent.mm.plugin.photoedit.f.d.clear();
            }
            this.okS.clear();
        }
        for (int i = 0; i < this.okU.size(); i++) {
            FileOp.deleteFile((String) this.okU.valueAt(i));
        }
        this.okU.clear();
        for (Entry value : this.okV.entrySet()) {
            Bitmap bitmap = (Bitmap) value.getValue();
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        this.okV.clear();
    }

    public final void gf(boolean z) {
        w.i("MicroMsg.MosaicCache", "[onSave] size:%s", Integer.valueOf(this.okR.size()));
        if (this.okS != null) {
            this.okS.clear();
        }
        this.okS = (Stack) this.okR.clone();
        if (z) {
            this.okR.clear();
        }
    }

    public final void aSi() {
        w.i("MicroMsg.MosaicCache", "[onRestore] size:%s", Integer.valueOf(this.okR.size()));
        this.okR.clear();
        if (this.okS != null) {
            w.i("MicroMsg.MosaicCache", "[onRestore] %s", Integer.valueOf(this.okS.size()));
            this.okR.addAll(this.okS);
        }
    }

    public final void a(Canvas canvas, boolean z, Object... objArr) {
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.okR.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.photoedit.f.d) it.next()).a(canvas, objArr);
            }
            return;
        }
        com.tencent.mm.plugin.photoedit.f.d dVar = (this.okR == null || this.okR.size() <= 0) ? null : (com.tencent.mm.plugin.photoedit.f.d) this.okR.peek();
        if (dVar != null && dVar.okK == a.ONE) {
            dVar.a(canvas, objArr);
        }
    }

    public final void h(Canvas canvas) {
        Bitmap aSk = aSk();
        if (aSk != null && !aSk.isRecycled()) {
            canvas.drawBitmap(aSk, 0.0f, 0.0f, null);
        }
    }

    public final void v(Bitmap bitmap) {
        final Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        final String Cx = com.tencent.mm.plugin.photoedit.g.a.Cx(com.tencent.mm.plugin.photoedit.b.a.MOSAIC.toString());
        w.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", Cx, Integer.valueOf(gg(true)));
        String str = (String) this.okU.get(gg(true));
        if (!bg.mA(str)) {
            FileOp.deleteFile(str);
            this.okU.remove(gg(true));
        }
        this.okU.put(gg(true), Cx);
        this.okV.put(Cx, copy);
        e.bKs();
        e.a(new Runnable(this) {
            final /* synthetic */ d ola;

            public final void run() {
                try {
                    com.tencent.mm.sdk.platformtools.d.a(copy, 100, CompressFormat.PNG, Cx, true);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MosaicCache", e, "", new Object[0]);
                }
            }
        }, "[saveCacheToLocal] mosaic path:" + Cx);
    }

    public final Bitmap aSk() {
        String str = (String) this.okU.get(gg(true));
        if (bg.mA(str)) {
            w.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
            return null;
        }
        Bitmap bitmap;
        w.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", str, Integer.valueOf(gg(true)));
        if (this.okV.containsKey(str)) {
            bitmap = (Bitmap) this.okV.get(str);
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            w.i("MicroMsg.MosaicCache", "");
            bitmap = com.tencent.mm.sdk.platformtools.d.Pg(str);
            w.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
        }
        if (bitmap == null) {
            w.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", str);
            return null;
        }
        Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        bitmap.recycle();
        return copy;
    }

    public final boolean aSl() {
        return gg(true) > 0;
    }

    public final void a(com.tencent.mm.plugin.photoedit.f.d dVar) {
        if (this.okR != null) {
            this.okR.push(dVar);
        }
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
