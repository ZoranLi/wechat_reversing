package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bg;

final class e {
    int mhm = -1;
    private c mhn;

    public e(c cVar) {
        this.mhn = cVar;
    }

    final void nn(int i) {
        c cVar = this.mhn;
        if (cVar.mfl != null && cVar.mfl.size() > i && i >= 0) {
            long j = ((MediaItem) cVar.mfl.get(i)).meG;
            String str = ((MediaItem) cVar.mfl.get(i)).lAL;
            String str2 = ((MediaItem) cVar.mfl.get(i)).hTf;
            if (bg.mA(str)) {
                str = str2;
            }
            c.ayj().b(str, ((MediaItem) cVar.mfl.get(i)).getType(), str2, j);
        }
    }
}
