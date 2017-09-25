package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

final class h extends Handler {
    private /* synthetic */ g aIU;

    h(g gVar) {
        this.aIU = gVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                this.aIU.aIV.cO(message.getData().getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE));
                return;
            case m.CTRL_INDEX /*200*/:
                this.aIU.aIV.a((a) message.obj);
                return;
            default:
                return;
        }
    }
}
