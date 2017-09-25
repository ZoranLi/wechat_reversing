package com.tencent.mm.ah.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ah.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c implements Runnable {
    private String arH;
    private Bitmap bitmap;
    private b hJr;
    private com.tencent.mm.ah.a.c hJt;
    private String url;

    public c(String str, com.tencent.mm.ah.a.c cVar, Bitmap bitmap, b bVar, String str2) {
        this.url = str;
        this.hJt = cVar;
        this.bitmap = bitmap;
        this.hJr = bVar;
        this.arH = str2;
    }

    public final void run() {
        if (bg.mA(this.url) || this.hJt == null || this.bitmap == null || this.bitmap.isRecycled() || this.hJr == null) {
            w.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
            return;
        }
        if (this.url.equals((String) this.hJr.hIj.get(Integer.valueOf(this.hJt.He())))) {
            com.tencent.mm.ah.a.c cVar = this.hJt;
            Bitmap bitmap = this.bitmap;
            if (Looper.myLooper() == Looper.getMainLooper() && cVar.hIl != null) {
                ImageView imageView = (ImageView) cVar.hIl.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
            this.hJr.a(this.hJt);
            return;
        }
        w.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
    }
}
