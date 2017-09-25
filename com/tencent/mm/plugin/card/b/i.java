package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class i {
    public static f sY(String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.keW = jSONObject.optString("empty_tips");
            fVar.keX = jSONObject.optString("shoppingmall_title");
            fVar.keY = jSONObject.optString("shoppingmall_url");
            fVar.keZ = jSONObject.optInt("is_show") != 0;
            return fVar;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardMallItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
