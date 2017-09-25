package com.tencent.mm.plugin.extqlauncher;

import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public am createSubCore() {
        return new b();
    }

    public k createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }
}
