package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.b.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "onNetWorkChange";

    public final void i(int i, Bundle bundle) {
        w.i("MicroMsg.GameJsEventNetworkChange", "dispatch");
        if (bundle != null) {
            String string = bundle.getString(DownloadInfo.NETTYPE, "");
            com.tencent.mm.plugin.game.gamewebview.ui.d ns = com.tencent.mm.plugin.game.gamewebview.model.a.ns(i);
            if (ns != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(DownloadInfo.NETTYPE, string);
                    ns.ck(getName(), jSONObject.toString());
                } catch (Exception e) {
                    w.e("MicroMsg.GameJsEventNetworkChange", "ex : " + e.getMessage());
                }
            }
        }
    }
}
