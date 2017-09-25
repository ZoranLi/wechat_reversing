package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.bc;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.File;

public final class c extends com.tencent.mm.sdk.b.c<bc> {
    public c() {
        this.usg = bc.class.getName().hashCode();
    }

    private static boolean a(bc bcVar) {
        if (bcVar.fEF.fEB == 37) {
            if (bcVar.fEF.fEC == 5 && bcVar.fEF.fEG == 2) {
                i alH = i.alH();
                w.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    b.deleteFile(stringBuilder.append(com.tencent.mm.u.c.xu()).append("eggingfo.ini").toString());
                    e.d(new File(i.alI(), i.kKf));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                }
                alH.kKw = null;
            }
            if (bcVar.fEF.fEG == 0) {
                w.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[]{Integer.valueOf(bcVar.fEF.fEB), Integer.valueOf(bcVar.fEF.fEC)});
            }
        }
        return false;
    }
}
