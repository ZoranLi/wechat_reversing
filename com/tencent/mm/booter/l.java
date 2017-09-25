package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class l {
    public static void run() {
        int i = g.sV().getInt("EnableMMBitmapFactoryProb", 0);
        ap.yY();
        int aw = h.aw(c.uH(), 100);
        boolean z = b.bIu() || (i > 0 && aw >= 0 && aw <= i);
        MMBitmapFactory.setUseMMBitmapFactory(z);
        w.i("MicroMsg.PostTaskUpdateMMImgDecSwitch", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", Integer.valueOf(aw), Integer.valueOf(i), Boolean.valueOf(z));
    }
}
