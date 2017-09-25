package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;

public final class Plugin implements c {
    private b jUU = new b(this) {
        final /* synthetic */ Plugin oJK;

        {
            this.oJK = r1;
        }

        public final a N(Context context, String str) {
            w.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", new Object[]{str});
            if ("widget_type_news".equals(str)) {
                return new com.tencent.mm.plugin.readerapp.ui.b(context);
            }
            return null;
        }
    };

    public final k createApplication() {
        return new com.tencent.mm.plugin.readerapp.a.a();
    }

    public final b getContactWidgetFactory() {
        return this.jUU;
    }

    public final am createSubCore() {
        return new g();
    }
}
