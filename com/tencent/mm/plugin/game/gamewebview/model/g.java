package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.InputStream;

public final class g {
    public static WebResourceResponse xC(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.GameWebViewResourceInterrupter", "url is null, return ");
            return null;
        } else if (bg.mA(str) || !str.startsWith("weixin://resourceid/")) {
            return null;
        } else {
            w.i("MicroMsg.GameWebViewResourceInterrupter", "it is wechat resource is, should intercept");
            try {
                WebResourceResponse webResourceResponse;
                GWMainProcessTask commonLogicTask = new CommonLogicTask();
                commonLogicTask.type = 8;
                commonLogicTask.lHw.putString("localId", str);
                GameWebViewMainProcessService.b(commonLogicTask);
                InputStream IY = ah.IY(commonLogicTask.lHw.getString("file_path"));
                if (IY != null) {
                    webResourceResponse = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, IY);
                } else {
                    webResourceResponse = null;
                }
                return webResourceResponse;
            } catch (Exception e) {
                w.e("MicroMsg.GameWebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[]{e.getMessage()});
                return null;
            }
        }
    }
}
