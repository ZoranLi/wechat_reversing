package com.tencent.mm.plugin.qqmail;

import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public final class Plugin implements c {
    private a ozd = new a();

    public final k createApplication() {
        return new a();
    }

    public final b getContactWidgetFactory() {
        return this.ozd;
    }

    public final am createSubCore() {
        return new w();
    }
}
