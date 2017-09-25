package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;

final class s implements Runnable {
    private String appId = null;
    private int hSo = 0;
    private ae handler = null;
    private String url = null;

    public s(ae aeVar, String str, int i, String str2) {
        this.handler = aeVar;
        this.appId = str;
        this.hSo = i;
        this.url = str2;
    }

    public final void run() {
        if (this.appId != null && this.appId.length() != 0 && this.url != null && this.url.length() != 0) {
            u uVar = new u(this.appId, this.hSo, bg.Qc(this.url));
            Message obtain = Message.obtain();
            obtain.obj = uVar;
            this.handler.sendMessage(obtain);
        }
    }
}
