package com.tencent.mm.plugin.gif;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    public final int[] mJo = new int[6];

    public d(String str) {
        try {
            MMGIFJNI.recycle(MMGIFJNI.openByFilePath(str, this.mJo));
            w.i("MMGIFInfo", "width:%d height:%d", Integer.valueOf(this.mJo[0]), Integer.valueOf(this.mJo[1]));
        } catch (Throwable e) {
            w.e("MMGIFInfo", bg.g(e));
        }
    }
}
