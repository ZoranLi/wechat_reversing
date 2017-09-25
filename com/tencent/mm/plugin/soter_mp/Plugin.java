package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public Plugin() {
        w.i("SubCoreSoter", "soter plugin constructor");
    }

    public k createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new b();
    }
}
