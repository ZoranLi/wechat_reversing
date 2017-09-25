package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.a.e;
import com.tencent.mm.bi.b;
import com.tencent.mm.e.a.sj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bng;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.protocal.c.bni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11001));
        arrayList.add(Integer.valueOf(11004));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        InputStream open;
        Throwable e;
        if (i == 11001) {
            bng com_tencent_mm_protocal_c_bng = new bng();
            try {
                com_tencent_mm_protocal_c_bng.aD(bArr);
            } catch (IOException e2) {
            }
            if (b.bKy().uyc > com_tencent_mm_protocal_c_bng.tEM) {
                try {
                    open = ab.getContext().getAssets().open("color_emoji");
                    try {
                        byte[] c = com.tencent.mm.loader.stub.b.c(open);
                        e.b(open);
                        return c;
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            w.printErrStackTrace("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                            e.b(open);
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            e.b(open);
                            throw e;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    open = null;
                    w.printErrStackTrace("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                    e.b(open);
                    return null;
                } catch (Throwable th2) {
                    e = th2;
                    open = null;
                    e.b(open);
                    throw e;
                }
            }
        } else if (i == 11004) {
            a.vJ(9);
            bnh com_tencent_mm_protocal_c_bnh = new bnh();
            try {
                com_tencent_mm_protocal_c_bnh.aD(bArr);
            } catch (IOException e5) {
            }
            bni com_tencent_mm_protocal_c_bni = new bni();
            if (((c) h.j(c.class)).getEmojiMgr() != null) {
                for (com.tencent.mm.storage.a.c cVar : ((c) h.j(c.class)).getEmojiMgr().ud(com_tencent_mm_protocal_c_bnh.tmj)) {
                    if (!bg.mA(cVar.EP())) {
                        com_tencent_mm_protocal_c_bni.thN.add(cVar.EP());
                    }
                }
            }
            if (com_tencent_mm_protocal_c_bni.thN.size() == 0) {
                com.tencent.mm.sdk.b.b sjVar = new sj();
                String[] strArr = new String[]{com_tencent_mm_protocal_c_bnh.tmj};
                sjVar.gaa.gab = strArr;
                sjVar.gaa.fEG = 1;
                com.tencent.mm.sdk.b.a.urY.m(sjVar);
            }
            try {
                return com_tencent_mm_protocal_c_bni.toByteArray();
            } catch (IOException e6) {
            }
        }
        return null;
    }
}
