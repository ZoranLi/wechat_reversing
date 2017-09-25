package com.tencent.mm.plugin.favorite;

import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public k createApplication() {
        return new c();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new h();
    }
}
