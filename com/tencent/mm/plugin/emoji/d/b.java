package com.tencent.mm.plugin.emoji.d;

import android.graphics.Bitmap;
import com.tencent.mm.ah.a.c.l;
import com.tencent.mm.ah.a.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements l {
    private a<String, Bitmap> hJo = new a(ck.CTRL_INDEX);

    public final Bitmap gS(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return (Bitmap) this.hJo.get(str);
    }

    public final void b(String str, Bitmap bitmap) {
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            w.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
        } else {
            this.hJo.put(str, bitmap);
        }
    }

    public final void clear() {
        synchronized (this) {
            if (this.hJo != null) {
                Map snapshot = this.hJo.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value : snapshot.entrySet()) {
                        Bitmap bitmap = (Bitmap) value.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            w.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[]{bitmap.toString()});
                        }
                    }
                }
                this.hJo.clear();
            }
        }
    }
}
