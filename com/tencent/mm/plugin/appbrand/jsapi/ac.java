package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends a {
    public static final int CTRL_INDEX = 169;
    public static final String NAME = "getClipboardData";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        ClipboardManager clipboardManager = (ClipboardManager) mVar.mContext.getSystemService("clipboard");
        if (clipboardManager == null) {
            w.i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            mVar.x(i, d("fail", null));
            return;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        Object obj = "";
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getText() != null) {
                obj = itemAt.getText().toString();
            }
        }
        w.d("MicroMsg.JsApiGetClipboardData", "stevyang retData %s", new Object[]{obj});
        Map hashMap = new HashMap();
        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, obj);
        mVar.x(i, d("ok", hashMap));
    }
}
