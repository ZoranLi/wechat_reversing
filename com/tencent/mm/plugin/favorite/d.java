package com.tencent.mm.plugin.favorite;

import com.tencent.mm.e.a.fm;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.y;

public final class d extends c<fm> {
    private y<Long, j> lDr;
    private g lDs;

    public d() {
        this.lDr = new y(10);
        this.usg = fm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        j jVar;
        fm fmVar = (fm) bVar;
        if (fmVar.fKc.fFx == 0) {
            jVar = null;
        } else if (fmVar.fKc.fKj) {
            jVar = h.ata().bT(fmVar.fKc.fFx);
            if (jVar != null) {
                this.lDr.put(Long.valueOf(fmVar.fKc.fFx), jVar);
            }
        } else {
            j jVar2 = (j) this.lDr.get(Long.valueOf(fmVar.fKc.fFx));
            String str = "MicroMsg.FavImageServiceListener";
            String str2 = "get item from cache itemInfo is null? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(jVar2 == null);
            w.d(str, str2, objArr);
            if (jVar2 == null) {
                jVar = h.ata().bT(fmVar.fKc.fFx);
                if (jVar != null) {
                    this.lDr.put(Long.valueOf(fmVar.fKc.fFx), jVar);
                }
            } else {
                jVar = jVar2;
            }
        }
        w.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[]{Integer.valueOf(fmVar.fKc.opType), Long.valueOf(fmVar.fKc.fFx)});
        if (jVar != null || fmVar.fKc.opType == 3 || fmVar.fKc.opType == 4) {
            switch (fmVar.fKc.opType) {
                case 0:
                    fmVar.fKd.fKk = g.a(fmVar.fKc.fKe, jVar);
                    break;
                case 1:
                    if (this.lDs != null) {
                        this.lDs.b(fmVar.fKc.fKf, fmVar.fKc.fKe, jVar, fmVar.fKc.fKg, fmVar.fKc.width, fmVar.fKc.height);
                        break;
                    }
                    w.w("MicroMsg.FavImageServiceListener", "imageServer is null");
                    break;
                case 2:
                    w.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[]{Boolean.valueOf(fmVar.fKc.fKh)});
                    if (!fmVar.fKc.fKh) {
                        fmVar.fKd.fKk = g.b(fmVar.fKc.fKe, jVar, fmVar.fKc.maxWidth);
                        break;
                    }
                    fmVar.fKd.fKk = g.j(fmVar.fKc.fKe);
                    break;
                case 3:
                    w.d("MicroMsg.FavImageServiceListener", "create image server");
                    if (this.lDs != null) {
                        this.lDs.destory();
                    }
                    this.lDs = new g(fmVar.fKc.context, 16);
                    break;
                case 4:
                    w.d("MicroMsg.FavImageServiceListener", "destroy image server");
                    if (this.lDs != null) {
                        this.lDs.destory();
                        this.lDs = null;
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
