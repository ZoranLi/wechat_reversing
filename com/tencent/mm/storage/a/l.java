package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class l extends i<k> implements a {
    public static final String[] gUx = new String[]{i.a(k.gTP, "EmotionDetailInfo")};
    public e gUz;

    public l(e eVar) {
        super(eVar, k.gTP, "EmotionDetailInfo", null);
        this.gUz = eVar;
    }

    public final String getTableName() {
        return "EmotionDetailInfo";
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final k Sn(String str) {
        k kVar = null;
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
        } else {
            String[] strArr = new String[]{"content", "lan"};
            String[] strArr2 = new String[]{str};
            Cursor a = this.gUz.a("EmotionDetailInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                kVar = new k();
                kVar.field_content = a.getBlob(0);
                kVar.field_lan = a.getString(1);
                kVar.field_productID = str;
            }
            if (a != null) {
                a.close();
            }
        }
        return kVar;
    }
}
