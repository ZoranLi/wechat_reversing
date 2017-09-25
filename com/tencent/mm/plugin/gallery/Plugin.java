package com.tencent.mm.plugin.gallery;

import com.tencent.mm.bj.g;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;
import java.util.HashMap;

public class Plugin implements c {
    public k createApplication() {
        return new k(this) {
            final /* synthetic */ Plugin mdO;

            {
                this.mdO = r1;
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
        return new am(this) {
            final /* synthetic */ Plugin mdO;

            {
                this.mdO = r1;
            }

            public final HashMap<Integer, g.c> uh() {
                return null;
            }

            public final void eD(int i) {
            }

            public final void aM(boolean z) {
            }

            public final void aN(boolean z) {
            }

            public final void onAccountRelease() {
            }
        };
    }
}
