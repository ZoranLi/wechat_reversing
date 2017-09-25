package com.tencent.mm.plugin.sport;

import com.tencent.mm.plugin.sport.c.l;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public k createApplication() {
        return new b();
    }

    public b getContactWidgetFactory() {
        return new com.tencent.mm.plugin.sport.ui.a.b();
    }

    public am createSubCore() {
        return new l();
    }
}
