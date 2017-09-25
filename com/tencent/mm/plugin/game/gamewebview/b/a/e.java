package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.b.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "onMediaFileUploadProgress";

    public final void i(int i, Bundle bundle) {
        w.i("MicroMsg.GameJsEventUploadMediaFileProgess", "invoke");
        if (bundle != null) {
            String string = bundle.getString("webview_jssdk_file_item_local_id");
            int i2 = bundle.getInt("webview_jssdk_file_item_progreess");
            d ns = com.tencent.mm.plugin.game.gamewebview.model.a.ns(i);
            if (ns != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("localId", string);
                    jSONObject.put("percent", i2);
                    ns.ck(getName(), jSONObject.toString());
                } catch (Exception e) {
                    w.e("MicroMsg.GameJsEventUploadMediaFileProgess", "ex : " + e.getMessage());
                }
            }
        }
    }
}
