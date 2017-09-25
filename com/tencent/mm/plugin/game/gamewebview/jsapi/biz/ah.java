package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class ah extends a {
    public static final int CTRL_BYTE = 252;
    public static final String NAME = "previewVideo";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
        if (jSONObject == null || bg.mA(jSONObject.optString("localId"))) {
            w.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
            dVar.x(i, a.d("previewVideo:fail_invalid_data", null));
            return;
        }
        WebViewJSSDKFileItem xu = com.tencent.mm.plugin.game.gamewebview.a.d.xu(jSONObject.optString("localId"));
        if (xu == null || TextUtils.isEmpty(xu.iDA) || !e.aO(xu.iDA)) {
            w.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", new Object[]{r0});
            dVar.x(i, a.d("previewVideo:fail", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_video_path", xu.iDA);
        Context azK = dVar.azK();
        azK.uSV = new MMActivity.a(this) {
            final /* synthetic */ ah mkO;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.mkO.hashCode() & 65535)) {
                    d dVar;
                    int i3;
                    ah ahVar;
                    switch (i2) {
                        case -1:
                            dVar = dVar;
                            i3 = i;
                            ahVar = this.mkO;
                            dVar.x(i3, a.d("previewVideo:ok", null));
                            return;
                        case 0:
                            dVar = dVar;
                            i3 = i;
                            ahVar = this.mkO;
                            dVar.x(i3, a.d("previewVideo:cancel", null));
                            return;
                        default:
                            dVar = dVar;
                            i3 = i;
                            ahVar = this.mkO;
                            dVar.x(i3, a.d("previewVideo:fail", null));
                            return;
                    }
                }
            }
        };
        com.tencent.mm.bb.d.b(azK, "card", ".ui.CardGiftVideoUI", intent, hashCode() & 65535);
    }
}
