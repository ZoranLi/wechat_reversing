package com.tencent.mm.plugin.photoedit;

import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public class Plugin implements c {
    public k createApplication() {
        return new k(this) {
            final /* synthetic */ Plugin oiM;

            {
                this.oiM = r1;
            }

            public final void a(i iVar) {
            }

            public final void a(h hVar) {
            }
        };
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new a();
    }
}
