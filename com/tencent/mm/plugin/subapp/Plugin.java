package com.tencent.mm.plugin.subapp;

import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;

public final class Plugin implements c {
    public Plugin() {
        w.i("MicroMsg.Plugin.subapp", "subapp constructor " + System.currentTimeMillis());
    }

    public final k createApplication() {
        w.i("MicroMsg.Plugin.subapp", "subapp createApplication " + System.currentTimeMillis());
        return new b();
    }

    public final b getContactWidgetFactory() {
        w.i("MicroMsg.Plugin.subapp", "subapp getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final am createSubCore() {
        w.i("MicroMsg.Plugin.subapp", "subapp createSubCore " + System.currentTimeMillis());
        return new a();
    }
}
