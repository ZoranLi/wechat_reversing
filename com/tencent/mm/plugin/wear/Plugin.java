package com.tencent.mm.plugin.wear;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public final class Plugin implements c {
    public final k createApplication() {
        return null;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final am createSubCore() {
        return new a();
    }
}
