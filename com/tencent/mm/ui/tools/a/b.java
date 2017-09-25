package com.tencent.mm.ui.tools.a;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends a {
    private int RQ = 2048;
    private int aar = 2048;
    public int hP = JceStruct.JCE_MAX_STRING_LENGTH;
    private String ntE;
    public int wpl = 0;
    public int wpm = 0;
    public int wpn = 0;
    private a wpo;

    public interface a {
        void a(b bVar);

        void anf();
    }

    private b(String str) {
        this.ntE = str;
    }

    public static b Ur(String str) {
        return new b(str);
    }

    public final b Cg(int i) {
        this.aar = i;
        this.RQ = i;
        return this;
    }

    public final void a(a aVar) {
        this.wpo = aVar;
        bGm();
    }

    protected final int Ve() {
        boolean z;
        if (bg.mA(this.ntE)) {
            w.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
        }
        this.wpl = e.aN(this.ntE);
        String str = this.ntE;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.wpm = options.outWidth;
        this.wpn = options.outHeight;
        if (this.wpl <= this.hP) {
            if (!(this.wpl < 0)) {
                z = true;
                if (this.wpm > this.aar || this.wpn > this.RQ) {
                    w.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[]{Integer.valueOf(this.wpm), Integer.valueOf(this.wpn)});
                    z = false;
                }
                if (z) {
                    return 1;
                }
                w.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
                return 0;
            }
        }
        w.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[]{Integer.valueOf(this.wpl)});
        z = false;
        w.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[]{Integer.valueOf(this.wpm), Integer.valueOf(this.wpn)});
        z = false;
        if (z) {
            return 1;
        }
        w.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        return 0;
    }

    protected final void bGm() {
        if (this.wpo == null) {
            w.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
            return;
        }
        switch (Ve()) {
            case 0:
                this.wpo.a(this);
                return;
            case 1:
                this.wpo.anf();
                return;
            default:
                return;
        }
    }
}
