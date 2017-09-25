package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.bl.b;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static n c(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = l.wu().a(str, options, decodeResultLogger);
            if (a != null) {
                a = i.r(str, a);
            }
            w.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a});
            return n.g(a);
        } catch (OutOfMemoryError e) {
            b.bOh();
            w.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }

    public static Bitmap b(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = l.wu().a(str, options, decodeResultLogger);
            if (a != null) {
                a = i.r(str, a);
            }
            w.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a});
            return a;
        } catch (OutOfMemoryError e) {
            b.bOh();
            w.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }
}
