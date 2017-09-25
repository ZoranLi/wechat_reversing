package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.mm.plugin.nearby.a.f;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    private b jUU = new b(this) {
        final /* synthetic */ Plugin nVz;

        {
            this.nVz = r1;
        }

        public final a N(Context context, String str) {
            return new com.tencent.mm.plugin.nearby.ui.a(context);
        }
    };

    public k createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.jUU;
    }

    public am createSubCore() {
        return new f();
    }
}
