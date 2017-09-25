package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

@Deprecated
public final class Plugin implements c {
    public final k createApplication() {
        return null;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final am createSubCore() {
        return new com.tencent.mm.plugin.appbrand.app.c();
    }
}
