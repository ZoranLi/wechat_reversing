package com.tencent.mm.ah.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mm.ah.a.c.l;
import com.tencent.mm.ah.a.d.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import java.util.Map.Entry;

public final class f implements l {
    private a<String, Bitmap> hJo = new a(50);
    private a<String, Bitmap> hJp = new a(10);

    public final Bitmap gS(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return this.hJo.get(str) == null ? (Bitmap) this.hJp.get(str) : (Bitmap) this.hJo.get(str);
    }

    public final void b(String str, Bitmap bitmap) {
        if (bg.mA(str)) {
            w.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            w.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
        } else {
            long j;
            if (bitmap == null || !(bitmap instanceof Bitmap)) {
                j = 0;
            } else {
                Bitmap bitmap2 = bitmap;
                if (VERSION.SDK_INT >= 12) {
                    j = (long) bitmap2.getByteCount();
                } else {
                    j = (long) (bitmap2.getHeight() * bitmap2.getRowBytes());
                }
            }
            w.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", str, Long.valueOf(j), bg.ay(j));
            if (j > 524288) {
                this.hJp.put(str, bitmap);
            } else {
                this.hJo.put(str, bitmap);
            }
        }
    }

    public final void clear() {
        synchronized (this) {
            Map snapshot;
            Bitmap bitmap;
            if (this.hJo != null) {
                snapshot = this.hJo.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value : snapshot.entrySet()) {
                        bitmap = (Bitmap) value.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            w.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", bitmap.toString());
                        }
                    }
                }
                this.hJo.clear();
            }
            if (this.hJp != null) {
                snapshot = this.hJp.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value2 : snapshot.entrySet()) {
                        bitmap = (Bitmap) value2.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            w.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", bitmap.toString());
                        }
                    }
                }
                this.hJp.clear();
            }
        }
    }
}
