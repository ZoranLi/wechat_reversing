package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.fts.d.a.a;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.c.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.HashSet;

public final class g extends b implements b {
    private ae peL = new ae(Looper.getMainLooper());
    private k pgo;

    public g(c cVar, String str, int i) {
        super(cVar);
        Context context = cVar.getContext();
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(JsApiSetBackgroundAudioState.CTRL_INDEX));
        k kVar = (k) h.a(hashSet, context, this, i).get(0);
        kVar.fJL = str;
        if (o.dH(str)) {
            ap.yY();
            kVar.phm = c.xa().fV(str);
        }
        this.pgo = kVar;
    }

    public final void a(i iVar, String str) {
        sn(iVar.mS(0));
        notifyDataSetChanged();
        L(getCount(), true);
    }

    protected final a mT(int i) {
        a mT = this.pgo.mT(i);
        if (mT != null) {
            mT.mdf = i;
        }
        return mT;
    }

    protected final void aZo() {
        this.pgo.a(this.fRM, this.peL, new HashSet());
    }

    protected final boolean a(a aVar) {
        return false;
    }
}
