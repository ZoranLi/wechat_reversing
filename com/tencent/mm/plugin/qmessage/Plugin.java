package com.tencent.mm.plugin.qmessage;

import android.content.Context;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    private b jUU = new b(this) {
        final /* synthetic */ Plugin oyx;

        {
            this.oyx = r1;
        }

        public final a N(Context context, String str) {
            if ("widget_type_contact".equals(str)) {
                return new com.tencent.mm.plugin.qmessage.ui.a(context);
            }
            return new com.tencent.mm.plugin.qmessage.ui.b(context);
        }
    };

    public k createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.jUU;
    }

    public am createSubCore() {
        return new g();
    }
}
