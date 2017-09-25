package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;

public final class c extends d {
    private String kMS;
    private e kOj;

    public c(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
        }
        this.kMS = str;
    }

    public final void run() {
        if (this.kOj != null) {
            this.kOj.uA(getKey());
        } else {
            w.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
        }
        com.tencent.mm.sdk.e.c aP = h.amc().kLb.aP(a.uKQ, false);
        aP.field_flag = 0;
        h.amc().kLb.a(aP);
        if (this.kOj != null) {
            this.kOj.k(getKey(), 2, true);
        }
    }

    public final String getKey() {
        return this.kMS == null ? "" : this.kMS;
    }

    public final void a(e eVar) {
        this.kOj = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (!(bg.mA(this.kMS) || bg.mA(cVar.getKey()) || !this.kMS.equals(cVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
