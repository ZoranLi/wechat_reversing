package com.tencent.mm.plugin.webview;

import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.d.f;
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
        return new f();
    }
}
