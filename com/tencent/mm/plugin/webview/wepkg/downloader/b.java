package com.tencent.mm.plugin.webview.wepkg.downloader;

import com.tencent.mm.pluginsdk.k.a.d.t;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class b {
    public static Object lock = new Object();
    public static b spf;
    h spg = new h(TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new t("WepkgDownloaderPool", "WepkgDownloaderThread"));

    public static b bAr() {
        if (spf == null) {
            synchronized (lock) {
                if (spf == null) {
                    spf = new b();
                }
            }
        }
        return spf;
    }
}
