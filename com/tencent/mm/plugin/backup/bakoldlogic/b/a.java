package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.a.k;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.sdk.platformtools.bg;

public final class a extends b {
    final int jBq;
    public v jHh = new v();
    public w jHi = new w();
    private boolean jHn = false;
    final String jKI;
    final String jKJ;
    final byte[] key;

    public a(String str, String str2, byte[] bArr, String str3, int i, int i2) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[]{str3, str, str2, bg.bJZ()});
        this.jHh.jMQ = new com.tencent.mm.bd.b(k.b(str.getBytes(), bArr));
        this.jHh.jOa = 0;
        this.jHh.ID = str3;
        this.jHh.jOb = i;
        this.jKI = str2;
        this.jKJ = str3;
        this.key = bArr;
        this.jBq = i2;
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
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[]{Integer.valueOf(this.jHi.jNB)});
            js(30050002);
            e(4, this.jHi.jNB, "not not success");
        } else if (this.jKJ.equals(this.jHi.ID)) {
            String str = new String(k.a(this.jHi.jMQ.sYA, this.key));
            this.jHn = str.length() != this.jKI.length() ? false : str.equals(this.jKI);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[]{Boolean.valueOf(this.jHn)});
            if (this.jHn) {
                e(0, 0, "auth ok");
                this.jHh.jMQ = new com.tencent.mm.bd.b(k.b(this.jKI.getBytes(), this.key));
                this.jHh.jOa = 1;
                this.jHh.ID = this.jKJ;
                cL(true);
                return;
            }
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BakOldAuthScene", "check ok failed");
            js(30050002);
            e(4, 1, "not ok packet");
        } else {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BakOldAuthScene", "not the same id");
            js(30050028);
            e(4, -1, "not the same id");
        }
    }

    private void js(int i) {
        if (this.jBq == -22) {
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abU().jr(i);
        }
    }
}
