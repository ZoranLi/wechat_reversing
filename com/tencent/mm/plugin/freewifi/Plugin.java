package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public k createApplication() {
        return new g();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new j();
    }
}
