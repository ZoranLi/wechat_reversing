package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.e.a.cm;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.a.k;
import com.tencent.mm.u.ap;

public final class b extends d {
    private String kMS;
    private boolean kNn = false;
    private e kOj;
    private g kOr;

    public b(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.kMS = str;
    }

    public b(String str, byte b) {
        if (bg.mA(str)) {
            w.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.kMS = str;
        this.kNn = true;
    }

    public final void run() {
        if (this.kOj != null) {
            this.kOj.uA(getKey());
        } else {
            w.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
        }
        a aP = h.amc().kLb.aP(getKey(), true);
        if (this.kNn || aP == null || aP.field_sync != 2 || aP.field_status != 7) {
            this.kOr = new g(this.kMS);
            ap.vd().a(this.kOr, 0);
            xu xuVar = new xu();
            k Sn = h.amc().kLe.Sn(this.kMS);
            if (!(Sn == null || Sn.field_content == null)) {
                try {
                    xuVar.aD(Sn.field_content);
                } catch (Throwable e) {
                    w.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[]{bg.g(e)});
                }
            }
            if (xuVar.tEk == null) {
                ap.vd().a(new l(this.kMS, 15), 0);
                return;
            }
            return;
        }
        com.tencent.mm.sdk.b.b cmVar = new cm();
        cmVar.fFV.fFW = getKey();
        cmVar.fFV.fEG = 2;
        cmVar.fFV.success = true;
        com.tencent.mm.sdk.b.a.urY.m(cmVar);
    }

    public final String getKey() {
        return this.kMS == null ? "" : this.kMS;
    }

    public final void a(e eVar) {
        this.kOj = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (!(bg.mA(this.kMS) || bg.mA(bVar.getKey()) || !this.kMS.equals(bVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        if (this.kOr == null || bg.mA(this.kOr.hGx)) {
            w.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
            return;
        }
        com.tencent.mm.modelcdntran.g.El().iP(this.kOr.hGx);
        w.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[]{this.kOr.hGx});
    }
}
