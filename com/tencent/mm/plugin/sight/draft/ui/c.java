package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;

public abstract class c {
    public f<String, Bitmap> pwx = new f(24);
    private Bitmap pwy;

    private static final class a implements Runnable {
        String arH;
        String path;
        WeakReference<c> pwA;
        boolean pwz;

        public final void run() {
            Bitmap Pg = d.Pg(this.path);
            c cVar = (c) this.pwA.get();
            if (cVar != null) {
                if (!(bg.mA(this.arH) || Pg == null)) {
                    cVar.pwx.put(this.arH, Pg);
                }
                Runnable bVar = new b();
                bVar.arH = this.arH;
                bVar.mhk = Pg;
                bVar.pwA = this.pwA;
                if (this.pwz) {
                    af.v(bVar);
                }
            }
        }
    }

    private static final class b implements Runnable {
        String arH;
        Bitmap mhk;
        WeakReference<c> pwA;

        public final void run() {
            c cVar = (c) this.pwA.get();
            if (cVar != null) {
                cVar.q(this.arH, this.mhk);
            }
        }
    }

    public abstract void q(String str, Bitmap bitmap);

    public final Bitmap n(String str, String str2, boolean z) {
        if (bg.mA(str)) {
            return bcF();
        }
        Bitmap bitmap = (Bitmap) this.pwx.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        Object aVar = new a();
        aVar.arH = str;
        aVar.path = str2;
        aVar.pwz = z;
        aVar.pwA = new WeakReference(this);
        if (z) {
            ap.vL().D(aVar);
        } else {
            aVar.run();
            bitmap = (Bitmap) this.pwx.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        return bcF();
    }

    private Bitmap bcF() {
        if (this.pwy == null) {
            this.pwy = d.yp(R.k.dyJ);
        }
        return this.pwy;
    }
}
