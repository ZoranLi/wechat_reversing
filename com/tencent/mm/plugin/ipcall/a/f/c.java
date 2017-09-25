package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c extends b {
    private h mQN;

    public final int[] aEt() {
        return new int[]{824};
    }

    public final void onStop() {
        if (this.mQN != null) {
            ap.vd().c(this.mQN);
        }
    }

    public final int De() {
        return 5;
    }

    public final void oo() {
    }

    public final void onDestroy() {
    }

    public final void b(com.tencent.mm.plugin.ipcall.a.a.c cVar) {
        if (this.mNd != null) {
            this.mQN = new h(this.mNd.mNL, this.mNd.mNM, this.mNd.mNN);
            ap.vd().a(this.mQN, 0);
        }
    }

    public final int aEu() {
        return SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
    }

    public final void aEv() {
        w.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    }

    public final void aEw() {
        w.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
    }
}
