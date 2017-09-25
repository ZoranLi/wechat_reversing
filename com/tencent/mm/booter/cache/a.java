package com.tencent.mm.booter.cache;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends com.tencent.mm.cache.b.a {
    public static a gKV;
    private final f<String, Bitmap> gKW;

    private a() {
        Context context = ab.getContext();
        String str = "BACKGROUND_BITMAP_CACHE_LIMIT";
        if (com.tencent.mm.platformtools.a.a.values == null) {
            try {
                com.tencent.mm.platformtools.a.a.values = q.Pl(bg.convertStreamToString(context.getAssets().open("profile.ini")));
            } catch (Throwable e) {
                w.e("MicroMsg.ProfileUtil", "exception:%s", bg.g(e));
            }
        }
        this.gKW = new f(bg.getInt(com.tencent.mm.platformtools.a.a.values == null ? null : (String) com.tencent.mm.platformtools.a.a.values.get(str), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN));
    }

    public static void prepare() {
        if (gKV == null) {
            gKV = new a();
        }
    }

    public static void destroy() {
        if (gKV != null) {
            gKV.gKW.clear();
        }
    }

    public final Bitmap getBitmap(String str) {
        w.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", str);
        return (Bitmap) this.gKW.get(str);
    }

    public final MCacheItem cZ(String str) {
        w.v("MicroMsg.MMCacheImpl", "getting cache item: %s", str);
        return null;
    }

    public final void a(String str, Bitmap bitmap) {
        w.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", str);
        this.gKW.k(str, bitmap);
    }

    public final void da(String str) {
        w.v("MicroMsg.MMCacheImpl", "setting cache item: %s", str);
    }
}
