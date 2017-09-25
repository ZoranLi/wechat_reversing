package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    private b pnN = new b(this) {
        final /* synthetic */ Plugin pnO;

        {
            this.pnO = r1;
        }

        public final a N(Context context, String str) {
            return new com.tencent.mm.plugin.shake.ui.a(context);
        }
    };

    public k createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.pnN;
    }

    public am createSubCore() {
        return new m();
    }
}
