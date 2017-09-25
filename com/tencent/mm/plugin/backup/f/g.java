package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.backup.h.n;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.sdk.platformtools.w;

public final class g extends b {
    public n jHK = new n();
    public o jHL = new o();

    public final /* bridge */ /* synthetic */ a abn() {
        return this.jHL;
    }

    public g(String str) {
        w.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[]{str});
        this.jHK.ID = str;
    }

    public final int getType() {
        return 3;
    }

    public final a abo() {
        return this.jHK;
    }

    public final void abp() {
        w.i("MicroMsg.BackupStartScene", "onSceneEnd.");
        if (this.jHL.jNB != 0) {
            e(4, this.jHL.jNB, "BackupStartScene onSceneEnd failed");
        } else {
            e(0, this.jHL.jNB, "BackupStartScene onSceneEnd success");
        }
    }
}
