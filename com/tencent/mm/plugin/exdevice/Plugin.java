package com.tencent.mm.plugin.exdevice;

import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public k createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new ad();
    }
}
