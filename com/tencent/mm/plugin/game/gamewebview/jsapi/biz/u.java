package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class u extends a {
    public static final int CTRL_BYTE = 1;
    public static final String NAME = "imagePreview";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        Context azK = dVar.azK();
        if (azK != null) {
            if (jSONObject == null) {
                w.e("MicroMsg.GameJsApiSendAppMessage", "fail, data is null");
                dVar.x(i, a.d("imagePreview:fail_invalid_data", null));
                return;
            }
            String optString = jSONObject.optString("current");
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray == null || optJSONArray.length() == 0) {
                w.e("MicroMsg.GameJsApiSendAppMessage", "fail, urls is null");
                dVar.x(i, a.d("imagePreview:fail_invalid_url", null));
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                Object optString2 = optJSONArray.optString(i2);
                if (bg.mA(optString2) || optString2.equalsIgnoreCase("null")) {
                    w.e("MicroMsg.GameJsApiSendAppMessage", "null url, i = %d", new Object[]{Integer.valueOf(i2)});
                } else {
                    if (bg.mz(optString2).startsWith("weixin://resourceid/")) {
                        optString2 = f.bwZ().IS(optString2).iDA;
                    }
                    arrayList.add(optString2);
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            String str = bg.mA(optString) ? strArr[0] : optString.startsWith("weixin://resourceid/") ? f.bwZ().IS(optString).iDA : optString;
            Intent intent = new Intent();
            optString = CookieManager.getInstance().getCookie(dVar.azN());
            if (!bg.mA(optString)) {
                intent.putExtra("cookie", optString);
            }
            intent.putExtra("nowUrl", str);
            intent.putExtra("urlList", strArr);
            intent.putExtra(Columns.TYPE, -255);
            intent.putExtra("isFromWebView", true);
            com.tencent.mm.bb.d.b(azK, "subapp", ".ui.gallery.GestureGalleryUI", intent);
            dVar.x(i, a.d("imagePreview:ok", null));
        }
    }
}
