package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public final class z extends i<y> {
    public static final String[] gUx = new String[]{i.a(y.gTP, "GamePBCache")};

    public z(e eVar) {
        super(eVar, y.gTP, "GamePBCache", null);
    }

    public final byte[] xQ(String str) {
        if (bg.mA(str) || !v.bIN().equals(ab.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", v.bIN()))) {
            return null;
        }
        c yVar = new y();
        yVar.field_key = str;
        if (super.b(yVar, new String[0])) {
            return yVar.field_value;
        }
        return null;
    }

    public final boolean a(String str, a aVar) {
        boolean z = false;
        if (bg.mA(str) || aVar == null) {
            return z;
        }
        try {
            return o(str, aVar.toByteArray());
        } catch (IOException e) {
            w.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", new Object[]{e.getMessage()});
            return z;
        }
    }

    public final boolean o(String str, byte[] bArr) {
        boolean z = false;
        if (!(bArr == null || bArr.length == 0)) {
            c yVar = new y();
            yVar.field_key = str;
            if (super.b(yVar, new String[0])) {
                yVar.field_value = bArr;
                z = super.c(yVar, new String[0]);
            } else {
                yVar.field_value = bArr;
                z = super.b(yVar);
            }
            if (!z) {
                w.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
            }
        }
        return z;
    }
}
