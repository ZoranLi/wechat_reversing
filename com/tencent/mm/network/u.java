package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class u {
    public HttpsURLConnection ifc;

    public u(String str) {
        this(new URL(str));
    }

    private u(URL url) {
        this.ifc = null;
        try {
            this.ifc = (HttpsURLConnection) url.openConnection();
        } catch (Throwable e) {
            w.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", e.getMessage());
            w.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bg.g(e));
        } catch (Throwable e2) {
            w.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", e2.getMessage());
            w.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bg.g(e2));
        } catch (Throwable e22) {
            w.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + e22.getMessage());
            w.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bg.g(e22));
        }
    }
}
