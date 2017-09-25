package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel;

import com.tencent.mm.a.e;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.f;
import java.util.LinkedList;

public final class h extends b {
    private static int progress;
    private String filePath;
    private int hrs = 0;
    x jHw = new x();
    private y jHx = new y();
    private f jKw = null;
    private byte[] jKx;
    private int offset = 0;
    private int start = 0;
    private int type;

    public h(String str, int i, LinkedList<eh> linkedList, String str2, f fVar) {
        this.jHw.jOf = str;
        this.jHw.jOg = i;
        this.type = i;
        if (i == 1) {
            ei eiVar = new ei();
            eiVar.jNe = linkedList;
            eiVar.jNd = linkedList.size();
            try {
                this.jKx = eiVar.toByteArray();
                this.hrs = this.jKx.length;
            } catch (Throwable e) {
                w.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
                w.printErrStackTrace("MicroMsg.BakSceneDataPush", e, "", new Object[0]);
            }
        } else {
            this.filePath = str2;
            this.hrs = e.aN(str2);
        }
        int i2 = this.hrs % 16;
        this.jHw.jOh = (16 - i2) + this.hrs;
        w.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[]{this.jHw.jOf, Integer.valueOf(this.jHw.jOg), Integer.valueOf(this.hrs), Integer.valueOf(this.jHw.jOh)});
        this.jKw = fVar;
    }

    public static void setProgress(int i) {
        w.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[]{Integer.valueOf(i)});
        progress = i;
    }

    public final boolean abt() {
        int i;
        byte[] bArr;
        long j = 524288;
        if (this.type == 1) {
            i = this.hrs;
            bArr = this.jKx;
        } else {
            if (((long) (this.hrs - this.offset)) <= 524288) {
                j = (long) (this.hrs - this.offset);
            }
            int i2 = (int) j;
            Object obj = null;
            int i3 = 3;
            while (true) {
                int i4 = i3 - 1;
                if (i3 > 0 && obj == null) {
                    if (!bg.mA(this.filePath)) {
                        String str = this.filePath;
                        ap.yY();
                        if (str.startsWith(c.xi())) {
                            w.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[]{this.filePath.substring(this.filePath.lastIndexOf("/") + 1)});
                            com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(r3);
                            if (ub == null || (ub.field_reserved4 & com.tencent.mm.storage.a.c.uLn) != com.tencent.mm.storage.a.c.uLn) {
                                obj = e.c(this.filePath, this.offset, i2);
                                i3 = i4;
                            } else {
                                obj = new byte[i2];
                                System.arraycopy(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(ub), this.offset, obj, 0, i2);
                                i3 = i4;
                            }
                        }
                    }
                    obj = e.c(this.filePath, this.offset, i2);
                    i3 = i4;
                } else if (obj == null) {
                    w.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[]{Integer.valueOf(this.offset), Integer.valueOf(i2)});
                }
            }
            if (obj == null) {
                w.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[]{Integer.valueOf(this.offset), Integer.valueOf(i2)});
            }
            int i5 = i2;
            Object obj2 = obj;
            i = i5;
        }
        this.start = this.offset;
        this.offset = i + this.start;
        this.jHw.jOi = this.start;
        this.jHw.jOj = (bArr == null ? 0 : bArr.length) + this.start;
        this.jHw.jMQ = new com.tencent.mm.bd.b(bArr);
        this.jHw.jOl = progress;
        w.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[]{this.jHw.jOf, Integer.valueOf(this.hrs), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(bArr.length)});
        return super.abt();
    }

    public final a abn() {
        return this.jHx;
    }

    public final a abo() {
        return this.jHw;
    }

    public final void abp() {
        w.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[]{this.jHx.jOf, Integer.valueOf(this.jHx.jOg), Integer.valueOf(this.jHx.jOi), Integer.valueOf(this.jHx.jOj), Integer.valueOf(this.jHx.jNB)});
        if (this.jHx.jNB != 0) {
            w.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[]{Integer.valueOf(this.jHx.jNB)});
            e(4, this.jHx.jNB, "error");
            return;
        }
        this.jKw.a(this.jHw.jOj - this.jHw.jOi, this.hrs, this);
        if (this.offset == this.hrs) {
            w.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[]{this.jHw.jOf, Integer.valueOf(this.hrs)});
            e(0, 0, "success");
            return;
        }
        abt();
    }

    public final int getType() {
        return 6;
    }
}
