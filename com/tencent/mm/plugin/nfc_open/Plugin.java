package com.tencent.mm.plugin.nfc_open;

import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public k createApplication() {
        return null;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new a();
    }
}
