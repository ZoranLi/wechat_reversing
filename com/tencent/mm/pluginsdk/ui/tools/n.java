package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.x;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class n {
    public static f dG(Context context) {
        if (bg.ap(p.gRl.gQD, "").equals("surface")) {
            w.i("MicroMsg.VideoViewFactory", "match full type surface");
            return new VideoSurfaceView(context);
        }
        String str = x.get("ro.mediatek.platform");
        Object obj = (str == null || !(str.startsWith("MT") || str.startsWith("mt"))) ? null : 1;
        if (obj != null) {
            w.i("MicroMsg.VideoViewFactory", "IS MTK platform");
            return new VideoSightView(context);
        }
        w.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
        return new VideoSightView(context);
    }
}
