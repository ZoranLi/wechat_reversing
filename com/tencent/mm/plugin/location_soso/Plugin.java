package com.tencent.mm.plugin.location_soso;

import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.tencentmap.mapsdk.map.g;
import com.tencent.tencentmap.mapsdk.map.g.b;

public class Plugin implements c {
    public static final String TAG = "MicroMsg.Plugin";

    public Plugin() {
        w.d(TAG, "initLoctionInit");
        g.xbp = new b() {
            public void collectErrorInfo(String str) {
                w.i(Plugin.TAG, "error by map " + str);
            }
        };
    }

    public k createApplication() {
        return null;
    }

    public com.tencent.mm.pluginsdk.d.b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return null;
    }
}
