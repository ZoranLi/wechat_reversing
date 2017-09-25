package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public abstract class b implements i {
    private boolean lYR;
    public boolean lYS;

    public abstract boolean onCreate();

    public abstract boolean tT();

    public b() {
        w.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", getName());
    }

    public final boolean axI() {
        return this.lYR;
    }

    public final void create() {
        w.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.lYR));
        if (!this.lYR && onCreate()) {
            w.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
            this.lYR = true;
        }
    }

    public final void destroy() {
        w.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", getName(), Boolean.valueOf(this.lYS), Boolean.valueOf(this.lYR));
        if (!this.lYS && this.lYR && tT()) {
            w.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
            this.lYS = true;
        }
    }

    public void a(String str, i iVar, int i, HashMap<String, String> hashMap) {
    }

    public void addSOSHistory(String str) {
    }

    public void deleteSOSHistory(String str) {
    }

    public a a(f fVar) {
        return null;
    }
}
