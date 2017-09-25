package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_BYTE = 39;
    public static final String NAME = "cancelDownloadTask";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiCancelDownloadTask", "GameJsApiCancelDownloadTask");
        long optLong = jSONObject.optLong("download_id");
        if (optLong <= 0) {
            w.e("MicroMsg.GameJsApiCancelDownloadTask", "fail, invalid downloadId = " + optLong);
            dVar.x(i, a.d("cancel_download_task:fail_invalid_downloadid", null));
            return;
        }
        GWMainProcessTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 4;
        doDownloadTask.fCw = optLong;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.fFj) {
            dVar.x(i, a.d("cancel_download_task:ok", null));
        } else {
            dVar.x(i, a.d("cancel_download_task:fail", null));
        }
    }
}
