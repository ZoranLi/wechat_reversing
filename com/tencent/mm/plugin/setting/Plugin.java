package com.tencent.mm.plugin.setting;

import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;

public final class Plugin implements c {
    public Plugin() {
        w.i("MicroMsg.Plugin.setting", "setting constructor " + System.currentTimeMillis());
    }

    public final k createApplication() {
        w.i("MicroMsg.Plugin.setting", "setting createApplication " + System.currentTimeMillis());
        return new a();
    }

    public final b getContactWidgetFactory() {
        w.i("MicroMsg.Plugin.setting", "setting getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final am createSubCore() {
        w.i("MicroMsg.Plugin.setting", "setting createSubCore " + System.currentTimeMillis());
        return new b();
    }
}
