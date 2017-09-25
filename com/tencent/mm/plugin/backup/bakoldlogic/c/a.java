package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends b {
    private ab jMk = new ab();
    private ac jMl = new ac();

    public a(int i) {
        this.jMk.jMP = i;
    }

    public final com.tencent.mm.bd.a abn() {
        return this.jMl;
    }

    public final com.tencent.mm.bd.a abo() {
        return this.jMk;
    }

    public final void abp() {
        if (this.jMl.jNB == 0) {
            e(0, 0, "ok");
            return;
        }
        w.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[]{Integer.valueOf(this.jMk.jMP), Integer.valueOf(this.jMl.jNB)});
        e(4, this.jMl.jNB, "fail");
    }

    public final int getType() {
        return 3;
    }
}
