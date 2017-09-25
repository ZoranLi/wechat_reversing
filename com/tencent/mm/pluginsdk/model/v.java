package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.w;

public final class v extends FileObserver {
    private String pjg;
    private a sCS;

    public interface a {
        void bjR();
    }

    public v(String str, a aVar) {
        super(str);
        w.i("MicroMsg.ScreenshotObserver", "observer  " + str);
        this.sCS = aVar;
    }

    public final void onEvent(int i, String str) {
        if (str != null && i == 8) {
            if (this.pjg == null || !str.equalsIgnoreCase(this.pjg)) {
                this.pjg = str;
                this.sCS.bjR();
                w.i("MicroMsg.ScreenshotObserver", "Send event to listener. " + str);
            }
        }
    }

    public final void start() {
        super.startWatching();
    }

    public final void stop() {
        super.stopWatching();
    }
}
