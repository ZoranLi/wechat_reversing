package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

final class g {
    public c aIV;
    Handler aIW = new h(this);

    public final void a(int i) {
        Message obtainMessage = this.aIW.obtainMessage(100);
        Bundle bundle = new Bundle();
        bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i);
        obtainMessage.setData(bundle);
        this.aIW.sendMessage(obtainMessage);
    }
}
