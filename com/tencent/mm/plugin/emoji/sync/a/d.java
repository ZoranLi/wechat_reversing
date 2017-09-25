package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;

public final class d extends com.tencent.mm.plugin.emoji.sync.d {
    private String igL;
    private e kOj;
    private k kOs;
    private c kOt;

    public d(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
        }
        this.igL = str;
        this.kOt = h.amc().kLa.Si(this.igL);
    }

    public final void run() {
        if (this.kOj != null) {
            this.kOj.uA(this.igL);
        } else {
            w.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
        }
        if (this.kOt == null) {
            this.kOj.k(this.igL, 1, false);
            return;
        }
        this.kOs = new f(this.kOt);
        ap.vd().a(this.kOs, 0);
    }

    public final String getKey() {
        return this.igL;
    }

    public final void a(e eVar) {
        this.kOj = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (!(bg.mA(this.igL) || bg.mA(dVar.igL) || !this.igL.equals(dVar.igL))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
