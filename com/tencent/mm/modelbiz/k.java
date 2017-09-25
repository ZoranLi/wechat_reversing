package com.tencent.mm.modelbiz;

import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.storage.e;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class k implements b, d, n {
    private o hvW;
    private p hvX;

    public final o wU() {
        return this.hvW;
    }

    public final p wV() {
        return this.hvX;
    }

    public final String xo() {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        return stringBuilder.append(h.vI().gYf).append("brandicon/").toString();
    }

    public final void onDataBaseOpened(g gVar, g gVar2) {
        c aJX = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX();
        e oVar = new o(aJX);
        this.hvW = oVar;
        aJX.a(oVar);
        this.hvX = new p(((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW());
    }

    public final void onDataBaseClosed(g gVar, g gVar2) {
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"brandicon/"});
        return linkedList;
    }
}
