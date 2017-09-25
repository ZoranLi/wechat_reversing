package com.tencent.mm.plugin.bottle;

import android.content.Context;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.plugin.bottle.ui.e;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public final class Plugin implements c {
    private b jUU = new b(this) {
        final /* synthetic */ Plugin jUV;

        {
            this.jUV = r1;
        }

        public final a N(Context context, String str) {
            return new e(context);
        }
    };

    public final k createApplication() {
        return new a();
    }

    public final am createSubCore() {
        return new i();
    }

    public final b getContactWidgetFactory() {
        return this.jUU;
    }
}
