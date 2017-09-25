package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.a.k;
import com.tencent.mm.bd.b;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.sdk.platformtools.bg;

public final class a extends b {
    private v jHh = new v();
    public w jHi = new w();
    final int jHj;
    final String jHk;
    final byte[] jHl;
    final String jHm;
    private boolean jHn = false;

    public a(String str, String str2, byte[] bArr, String str3, int i, int i2) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BackupAuthScene", "summerbak BackupAuthScene init, backupType[%d], stack:%s", new Object[]{Integer.valueOf(i2), bg.bJZ()});
        this.jHh.jMQ = new b(k.b(str.getBytes(), bArr));
        this.jHh.jOa = 0;
        this.jHh.ID = str3;
        this.jHh.jOb = i;
        this.jHk = str2;
        this.jHm = str3;
        this.jHl = bArr;
        this.jHj = i2;
    }

    public final int getType() {
        return 1;
    }

    public final com.tencent.mm.bd.a abn() {
        return this.jHi;
    }

    public final com.tencent.mm.bd.a abo() {
        return this.jHh;
    }

    public final void abp() {
        if (this.jHi.jNB != 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[]{Integer.valueOf(this.jHi.jNB)});
            e(4, this.jHi.jNB, "onSceneEnd status failed");
        } else if (this.jHm.equals(this.jHi.ID)) {
            String str = new String(k.a(this.jHi.jMQ.sYA, this.jHl));
            this.jHn = str.length() != this.jHk.length() ? false : str.equals(this.jHk);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[]{Boolean.valueOf(this.jHn)});
            if (this.jHn) {
                e(0, 0, "onSceneEnd auth success");
                this.jHh.jMQ = new b(k.b(this.jHk.getBytes(), this.jHl));
                this.jHh.jOa = 1;
                this.jHh.ID = this.jHm;
                cL(true);
                return;
            }
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
            e(4, -3, "onSceneEnd check ok failed");
        } else {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
            e(4, -1, "onSceneEnd not the same id");
        }
    }

    public final void cK(boolean z) {
        v vVar;
        if (z) {
            vVar = this.jHh;
            vVar.jOd |= c.jBd;
        }
        vVar = this.jHh;
        vVar.jOd |= c.jBe;
        vVar = this.jHh;
        vVar.jOd |= c.jBf;
    }

    public final boolean abq() {
        if ((this.jHi.jOd & c.jBd) == 0) {
            return false;
        }
        return true;
    }
}
