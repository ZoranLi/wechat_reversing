package com.tencent.mm.plugin.fps_lighter;

import com.tencent.mm.plugin.fps_lighter.b.g;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public k createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        w.d("MicroMsg.FPSLighterCore.Plugin", "[createSubCore]");
        return new g();
    }
}
