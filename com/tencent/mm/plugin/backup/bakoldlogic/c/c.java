package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.e;
import com.tencent.mm.bd.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.bakoldlogic.a.d;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ad;
import com.tencent.mm.plugin.backup.h.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.f;
import java.io.File;

public final class c extends b {
    private static int progress;
    private int hrs;
    public String id;
    private f jKw = null;
    private ad jMm = new ad();
    private ae jMn = new ae();
    private String jMo;
    private byte[] key;
    private int offset = 0;
    private int start = 0;

    public c(String str, String str2, int i, int i2, f fVar, byte[] bArr) {
        if (i == 1) {
            this.jMo = str + "backupItem/" + d.rD(str2);
        } else {
            this.jMo = str + "backupMeida/" + d.rD(str2);
        }
        this.id = str2;
        this.jMm.jOf = str2;
        this.jMm.jOg = i;
        this.hrs = i2;
        w.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[]{this.jMm.jOf, Integer.valueOf(this.jMm.jOg), Integer.valueOf(this.hrs)});
        this.jKw = fVar;
        this.key = bArr;
    }

    public final boolean abt() {
        int i;
        long j = 524288;
        w.i("MicroMsg.BakSceneRestoreData", "doSecne");
        int i2 = this.hrs;
        if (this.jMm.jOg == 2) {
            if (((long) (this.hrs - this.offset)) <= 524288) {
                j = (long) (this.hrs - this.offset);
            }
            i = (int) j;
        } else {
            i = i2;
        }
        this.start = this.offset;
        this.offset = i + this.start;
        this.jMm.jOi = this.start;
        this.jMm.jOj = this.offset;
        this.jMm.jOl = progress;
        return super.abt();
    }

    public static void setProgress(int i) {
        w.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[]{Integer.valueOf(i)});
        progress = i;
    }

    public final a abn() {
        return this.jMn;
    }

    public final a abo() {
        return this.jMm;
    }

    public final void abp() {
        w.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[]{this.jMn.jOf, Integer.valueOf(this.jMn.jOg), Integer.valueOf(this.jMn.jOi), Integer.valueOf(this.jMn.jOj), Integer.valueOf(this.jMn.jNB)});
        if (this.jMn.jNB != 0 && this.jMn.jNB != 10) {
            e(4, this.jMn.jNB, "error");
        } else if (this.jMn.jOi == this.start && this.jMn.jOj == this.offset) {
            byte[] aesCryptEcb;
            this.jKw.a(this.jMm.jOj - this.jMm.jOi, this.hrs, this);
            byte[] bArr = this.jMn.jMQ.sYA;
            if (this.key != null) {
                aesCryptEcb = AesEcb.aesCryptEcb(bArr, this.key, false, this.offset == this.hrs);
            } else {
                aesCryptEcb = bArr;
            }
            String str = this.jMo;
            String str2 = this.id;
            File file = new File(str + str2);
            long length = file.exists() ? file.length() : 0;
            e.a(str, str2, aesCryptEcb);
            File file2 = new File(str + str2);
            if (length == (file2.exists() ? file2.length() : 0)) {
                w.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[]{str + str2});
                e.a(str, str2, aesCryptEcb);
            }
            str = "MicroMsg.BakSceneRestoreData";
            String str3 = "onSceneEnd appendbuf len:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aesCryptEcb == null ? 0 : aesCryptEcb.length);
            w.i(str, str3, objArr);
            if (this.offset == this.hrs) {
                w.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[]{this.id, Integer.valueOf(this.hrs)});
                e(0, 0, "success");
                return;
            }
            abt();
        } else {
            w.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[]{Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.jMn.jOi), Integer.valueOf(this.jMn.jOj)});
            e(3, -1, "error");
        }
    }

    public final int getType() {
        return 7;
    }
}
