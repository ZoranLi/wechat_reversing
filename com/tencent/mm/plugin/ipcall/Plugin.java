package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    b mMy = new b();

    public k createApplication() {
        return this.mMy;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return i.aEg();
    }
}
