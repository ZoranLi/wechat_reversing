package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class v extends a {
    public static final int CTRL_BYTE = 41;
    public static final String NAME = "installDownloadTask";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiGetNetworkType", "invoke");
        if (jSONObject != null) {
            long optLong = jSONObject.optLong("download_id", -1);
            if (optLong > 0) {
                GWMainProcessTask doDownloadTask = new DoDownloadTask();
                doDownloadTask.type = 5;
                doDownloadTask.fCw = optLong;
                GameWebViewMainProcessService.b(doDownloadTask);
                if (doDownloadTask.fFj) {
                    dVar.x(i, a.d("install_download_task:ok", null));
                    return;
                } else {
                    dVar.x(i, a.d("install_download_task:fail", null));
                    return;
                }
            }
        }
        w.i("MicroMsg.GameJsApiGetNetworkType", "data is null");
        dVar.x(i, a.d("install_download_task:fail_invalid_data", null));
    }
}
