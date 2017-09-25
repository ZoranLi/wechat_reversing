package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ah.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.HashSet;

public final class k implements a {
    private static k vTE;
    HashSet<Long> vTF = new HashSet();
    a vTG;

    private k() {
    }

    public static k bXy() {
        if (vTE == null) {
            vTE = new k();
        }
        return vTE;
    }

    public final boolean eU(long j) {
        return this.vTF.contains(Long.valueOf(j));
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.y.k kVar) {
        if (this.vTG != null) {
            this.vTG.a(j, j2, i, i2, obj, i3, i4, kVar);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.y.k kVar) {
        if (this.vTG != null) {
            this.vTG.a(j, j2, i, i2, obj, i3, i4, str, kVar);
        } else {
            ap.yY();
            w.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", Long.valueOf(c.wT().cA(j2).field_msgId));
            b.b(ab.getContext(), r2, false);
        }
        this.vTF.remove(Long.valueOf(j2));
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        if (this.vTG != null) {
            this.vTG.a(j, j2, i, i2, obj);
        }
        this.vTF.remove(Long.valueOf(j2));
    }
}
