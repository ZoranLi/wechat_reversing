package com.tencent.mm.plugin.card.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mm.e.a.of;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;

public final class o extends c<of> {
    public o() {
        this.usg = of.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        of ofVar = (of) bVar;
        if (ofVar instanceof of) {
            Object obj = ofVar.fVp.fNg;
            long j = ofVar.fVp.fEU;
            String str = ofVar.fVp.fNh;
            d sV = g.sV(obj);
            if (sV == null) {
                w.e("ShareCardEventListener", "item == null");
            } else if (TextUtils.isEmpty(obj)) {
                w.e("ShareCardEventListener", "cardAppMsg is empty");
            } else {
                ap.yY();
                a ek = a.ek(com.tencent.mm.u.c.wT().cA(j).field_content);
                if (ek != null) {
                    ek.hiy = g.a(sV);
                    ek.fNg = obj;
                    ek.hiz = sV.keT;
                    ek.hiA = sV.fVn;
                    ek.hiB = sV.kdF;
                    Bitmap a = j.a(new m(ek.thumburl));
                    l.a(ek, ek.appId, sV.keT, str, null, a != null ? com.tencent.mm.sdk.platformtools.d.K(a) : null);
                    return true;
                }
            }
        }
        return false;
    }
}
