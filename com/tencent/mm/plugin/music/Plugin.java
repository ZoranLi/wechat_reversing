package com.tencent.mm.plugin.music;

import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public k createApplication() {
        return new b();
    }

    public com.tencent.mm.pluginsdk.d.b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new i();
    }
}
