package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class n extends i<m> implements a {
    public static final String[] gUx = new String[]{i.a(m.gTP, "EmotionRewardInfo")};
    public e gUz;

    public n(e eVar) {
        super(eVar, m.gTP, "EmotionRewardInfo", null);
        this.gUz = eVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final ya So(String str) {
        ya yaVar = null;
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
        } else {
            String[] strArr = new String[]{"content"};
            String[] strArr2 = new String[]{str};
            Cursor a = this.gUz.a("EmotionRewardInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                try {
                    ya yaVar2 = new ya();
                    yaVar2.aD(a.getBlob(0));
                    yaVar = yaVar2;
                } catch (Throwable e) {
                    w.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", new Object[]{bg.g(e)});
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return yaVar;
    }
}
