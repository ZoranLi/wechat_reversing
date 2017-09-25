package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.backup.h.n;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends com.tencent.mm.plugin.backup.f.b {
    private int jBq;
    private n jHK = new n();
    public o jHL = new o();

    public b(String str) {
        w.i("MicroMsg.BakOldStartScene", "init id:%s", new Object[]{str});
        this.jHK.ID = str;
        this.jBq = -22;
    }

    public final int getType() {
        return 3;
    }

    public final a abn() {
        return this.jHL;
    }

    public final a abo() {
        return this.jHK;
    }

    public final void abp() {
        w.i("MicroMsg.BakOldStartScene", "onSceneEnd");
        if (this.jHL.jNB == 0) {
            e(0, this.jHL.jNB, "BakOldStartScene ok");
            return;
        }
        w.e("MicroMsg.BakOldStartScene", "errType %d", new Object[]{Integer.valueOf(this.jHL.jNB)});
        e(4, this.jHL.jNB, "BakOldStartScene not success");
    }
}
