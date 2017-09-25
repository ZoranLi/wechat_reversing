package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.network.p;
import org.json.JSONObject;

public final class l extends h {
    public String obT;

    public final int aki() {
        return 78;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.obT = jSONObject.optString("barcode");
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
    }
}
