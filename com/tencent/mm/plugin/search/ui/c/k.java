package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.q;
import java.util.HashSet;
import java.util.List;

public final class k extends c {
    public String fJL;
    public q phm;

    public k(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final int getType() {
        return JsApiSetBackgroundAudioState.CTRL_INDEX;
    }

    protected final a a(ae aeVar, HashSet<String> hashSet) {
        f fVar = new f();
        fVar.fRM = this.fRM;
        fVar.fJL = this.fJL;
        fVar.mag = this;
        fVar.handler = aeVar;
        fVar.lZZ = 3;
        return ((l) h.j(l.class)).search(3, fVar);
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        i.a aVar = new i.a();
        aVar.hPq = -2;
        aVar.iJD = this.iJD;
        aVar.mcR = list;
        this.mcy.add(aVar);
    }

    protected final com.tencent.mm.plugin.fts.d.a.b b(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b jVar = new j(i);
        jVar.fJL = this.fJL;
        jVar.count = aVar.mcR.size();
        return jVar;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.a aVar2 = null;
        int i2 = i - 1;
        if (i2 < aVar.mcR.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.a.i iVar = (com.tencent.mm.plugin.fts.a.a.i) aVar.mcR.get(i2);
            com.tencent.mm.plugin.fts.d.a.a iVar2 = new com.tencent.mm.plugin.search.ui.a.i(i2);
            iVar2.iJC = iVar;
            iVar2.iJD = aVar.iJD;
            iVar2.phm = this.phm;
            iVar2.cc(iVar.type, iVar.hPr);
            aVar2 = iVar2;
        }
        if (aVar2 != null) {
            aVar2.mdg = i + 1;
        }
        return aVar2;
    }
}
