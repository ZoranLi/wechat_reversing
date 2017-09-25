package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.mm.be.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.y;

public final class m implements a {
    private Bitmap kcf = null;
    y<String, Bitmap> nbX = new y(20);

    public m() {
        try {
            this.kcf = b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
            this.kcf = d.a(this.kcf, false, (float) (this.kcf.getWidth() >> 1));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TrackAvatarCacheService", e, "", new Object[0]);
        }
    }

    public final Bitmap zo(String str) {
        if (bg.mA(str)) {
            return null;
        }
        w.d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", new Object[]{str, Integer.valueOf(this.nbX.size())});
        Bitmap bitmap = (Bitmap) this.nbX.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public final void o(String str, Bitmap bitmap) {
        if (this.nbX.get(str) != null) {
            Bitmap bitmap2 = (Bitmap) this.nbX.get(str);
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.nbX.remove(str);
        }
        this.nbX.put(str, bitmap);
        w.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[]{str, Integer.valueOf(this.nbX.size())});
    }
}
