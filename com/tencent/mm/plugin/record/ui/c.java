package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.e.a.fm;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;

public final class c implements a {
    public c(Context context) {
        b fmVar = new fm();
        fmVar.fKc.context = context;
        com.tencent.mm.sdk.b.a.urY.m(fmVar);
    }

    public final void a(a.a aVar) {
        w.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[]{Long.valueOf(aVar.oPl)});
        b fmVar = new fm();
        fmVar.fKc.opType = 1;
        fmVar.fKc.fKf = aVar.fKf;
        fmVar.fKc.fKe = aVar.fKe;
        fmVar.fKc.fFx = aVar.oPl;
        fmVar.fKc.fKg = aVar.fKg;
        fmVar.fKc.width = aVar.width;
        fmVar.fKc.height = aVar.height;
        com.tencent.mm.sdk.b.a.urY.m(fmVar);
    }

    public final Bitmap a(com.tencent.mm.plugin.record.ui.h.a.c cVar) {
        b fmVar = new fm();
        fmVar.fKc.opType = 0;
        fmVar.fKc.fKe = cVar.fKe;
        fmVar.fKc.fFx = cVar.oPl;
        com.tencent.mm.sdk.b.a.urY.m(fmVar);
        w.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[]{Long.valueOf(cVar.oPl), fmVar.fKd.fKk});
        return fmVar.fKd.fKk;
    }

    public final Bitmap a(a.b bVar) {
        b fmVar = new fm();
        fmVar.fKc.opType = 2;
        fmVar.fKc.fKj = false;
        if (bVar.fKh) {
            fmVar.fKc.fKe = bVar.fKe;
            fmVar.fKc.fKh = bVar.fKh;
        } else {
            fmVar.fKc.fKe = bVar.fKe;
            fmVar.fKc.fFx = bVar.oPl;
            fmVar.fKc.maxWidth = bVar.maxWidth;
            fmVar.fKc.fKi = bVar.fKi;
        }
        com.tencent.mm.sdk.b.a.urY.m(fmVar);
        w.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[]{Long.valueOf(bVar.oPl), bVar.fKe.lKv, fmVar.fKd.fKk, Boolean.valueOf(fmVar.fKc.fKh)});
        return fmVar.fKd.fKk;
    }

    public final void aWI() {
        b fmVar = new fm();
        fmVar.fKc.opType = 4;
        com.tencent.mm.sdk.b.a.urY.m(fmVar);
    }
}
