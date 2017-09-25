package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.m;
import java.util.List;

public class c extends com.tencent.mm.vending.app.a {

    public class a {
        final /* synthetic */ c iow;
        public List<String> iox;

        public a(c cVar) {
            this.iow = cVar;
        }
    }

    protected final void onCreate() {
        super.onCreate();
        a(a.class, new com.tencent.mm.vending.app.a.a<a>(this) {
            final /* synthetic */ c iow;

            {
                this.iow = r1;
            }

            protected final /* synthetic */ Object NX() {
                com.tencent.mm.vending.app.a aVar = this.iow;
                String stringExtra = aVar.wBK.getStringExtra("chatroom");
                if (bg.mA(stringExtra)) {
                    return null;
                }
                Object aVar2 = new a(aVar);
                aVar2.iox = h.mG(stringExtra);
                if (aVar2.iox == null || aVar2.iox.size() <= 0) {
                    return aVar2;
                }
                aVar2.iox.remove(m.xL());
                return aVar2;
            }
        });
    }
}
