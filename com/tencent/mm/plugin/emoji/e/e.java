package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;

public class e {
    public static e kJU;
    public boolean aJi = false;
    private String arH;

    public static e alz() {
        if (kJU == null) {
            synchronized (e.class) {
                kJU = new e();
            }
        }
        return kJU;
    }

    public final String alA() {
        if (bg.mA(this.arH)) {
            this.arH = h.amc().kLa.getKey();
        }
        return this.arH;
    }

    public final boolean isEnable() {
        if (bg.mA(alA())) {
            return false;
        }
        return true;
    }

    public final boolean c(c cVar, boolean z) {
        if (cVar == null) {
            w.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
            return false;
        } else if (isEnable()) {
            String eN = cVar.eN(cVar.field_groupId, cVar.EP());
            if (com.tencent.mm.a.e.aO(eN)) {
                boolean z2 = false;
                byte[] c = com.tencent.mm.a.e.c(eN, 0, 10);
                if (c != null) {
                    try {
                        if (c.length >= 10) {
                            z2 = o.bg(c);
                        }
                    } catch (Throwable th) {
                        w.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                        z2 = false;
                    }
                }
                if (z || r2) {
                    int i;
                    long currentTimeMillis = System.currentTimeMillis();
                    int aN = com.tencent.mm.a.e.aN(eN);
                    if (aN > 1024) {
                        i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    } else {
                        i = aN;
                    }
                    Object c2 = com.tencent.mm.a.e.c(eN, 0, aN);
                    Object aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.c(eN, 0, i), alA().getBytes(), true, false);
                    if (bg.bm(aesCryptEcb) || bg.bm(c2)) {
                        i = -1;
                    } else {
                        System.arraycopy(aesCryptEcb, 0, c2, 0, i);
                        i = com.tencent.mm.a.e.b(eN, c2, c2.length);
                    }
                    if (i == 0) {
                        g.oUh.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        g.oUh.a(252, 6, 1, false);
                        cVar.field_reserved4 |= c.uLn;
                        cVar.field_size = aN;
                        h.amc().kLa.u(cVar);
                        w.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(c2.length), Long.valueOf(r8)});
                        return true;
                    }
                    w.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    g.oUh.a(252, 3, 1, false);
                    return false;
                }
                w.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
                return true;
            }
            w.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", new Object[]{eN});
            cVar.field_reserved4 = 0;
            h.amc().kLa.u(cVar);
            return false;
        } else {
            w.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
            return false;
        }
    }

    public final byte[] a(c cVar) {
        if (cVar == null) {
            w.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return null;
        }
        String eN = cVar.eN(cVar.field_groupId, cVar.EP());
        Object c = com.tencent.mm.a.e.c(eN, 0, com.tencent.mm.a.e.aN(eN));
        if (com.tencent.mm.a.e.aN(eN) <= 0 || c == null || c.length < 10) {
            w.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", new Object[]{eN});
            return null;
        }
        Object obj = new byte[10];
        System.arraycopy(c, 0, obj, 0, 10);
        if ((cVar.field_reserved4 & c.uLn) != c.uLn || o.bg(obj)) {
            return c;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int aN = com.tencent.mm.a.e.aN(eN);
        if (aN > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            aN = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] c2 = com.tencent.mm.a.e.c(eN, 0, aN);
        Object obj2 = null;
        if (!bg.mA(alA())) {
            obj2 = AesEcb.aesCryptEcb(c2, alA().getBytes(), false, false);
        }
        if (bg.bm(obj2) || bg.bm(c)) {
            g.oUh.a(252, 2, 1, false);
            w.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", new Object[]{eN});
            return c;
        }
        System.arraycopy(obj2, 0, c, 0, aN);
        g.oUh.a(252, 0, System.currentTimeMillis() - currentTimeMillis, false);
        g.oUh.a(252, 5, 1, false);
        w.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(c.length), Long.valueOf(r8)});
        return c;
    }

    public final boolean b(c cVar) {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if (cVar == null) {
            w.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return false;
        }
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        String eN = cVar.eN(cVar.field_groupId, cVar.EP());
        int aN = com.tencent.mm.a.e.aN(eN);
        if (aN <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            i = aN;
        }
        Object c = com.tencent.mm.a.e.c(eN, 0, i);
        if (com.tencent.mm.a.e.aN(eN) > 0 && c != null && c.length >= 10) {
            Object obj = new byte[10];
            System.arraycopy(c, 0, obj, 0, 10);
            if (o.bg(obj)) {
                z = true;
            } else if ((cVar.field_reserved4 & c.uLn) == c.uLn) {
                byte[] bArr = null;
                if (!bg.mA(alA())) {
                    bArr = AesEcb.aesCryptEcb(c, alA().getBytes(), false, false);
                }
                if (!bg.bm(bArr) && o.bg(bArr)) {
                    z = true;
                }
            }
            w.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z)});
            return z;
        }
        z = false;
        w.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z)});
        return z;
    }
}
