package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends i {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ LinkedList mpp;

        AnonymousClass1(LinkedList linkedList) {
            this.mpp = linkedList;
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            Iterator it = this.mpp.iterator();
            while (it.hasNext()) {
                Iterator it2 = i.n(((j) it.next()).optJSONArray("items")).iterator();
                while (it2.hasNext()) {
                    c cVar = (c) it2.next();
                    if (!bg.mA(cVar.field_appId)) {
                        linkedList.add(cVar.field_appId);
                    }
                }
            }
            it = c.aCh().iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!linkedList.contains(fVar.field_appId)) {
                    an.aRr().b(fVar, new String[0]);
                    w.i("MicroMsg.GameDataSearchGameList", "delete appid : " + fVar.field_appId);
                }
            }
        }
    }

    protected j(String str) {
        super(str);
    }

    public final void aAI() {
        LinkedList n = i.n(optJSONArray("items"));
        Iterator it = n.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            cVar.bE(cVar.moz);
        }
        d.U(n);
    }
}
