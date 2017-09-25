package com.tencent.mm.plugin.notification;

import com.tencent.mm.plugin.notification.d.e;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    a oab = new a();

    public k createApplication() {
        return this.oab;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return e.aPN();
    }
}
