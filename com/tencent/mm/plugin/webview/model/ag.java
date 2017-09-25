package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.w;

public class ag {
    public static ag rXg;
    public boolean hasInit;
    public e rXh = null;

    public static ag bwr() {
        if (rXg != null) {
            return rXg;
        }
        synchronized (ag.class) {
            if (rXg == null) {
                rXg = new ag();
            }
        }
        return rXg;
    }

    public final void setNetWorkState(int i) {
        String str = "MicroMsg.WebViewVideoProxy";
        String str2 = "set networkd state = %d, callbacker == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.rXh == null);
        w.i(str, str2, objArr);
        if (this.rXh != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_video_proxy_net_state", i);
            try {
                this.rXh.d(5005, bundle);
            } catch (Exception e) {
                w.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[]{e.getMessage()});
            }
        }
    }
}
