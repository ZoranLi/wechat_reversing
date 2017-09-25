package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class a extends aj {
    public static int kMB = 0;
    private static a kMC;
    private static q kMD;
    private static e kME = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                a.kMB = 0;
                a.amh().v(50, 50);
                return;
            }
            a.amh().amj();
        }
    };

    public static class a implements com.tencent.mm.sdk.platformtools.aj.a {
        public a() {
            a.kMB = 0;
        }

        public final boolean oQ() {
            if (a.kMB >= 100) {
                a.kMB = 0;
                w.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
                b bVar = h.amc().kLb;
                com.tencent.mm.storage.a.a aVar = new com.tencent.mm.storage.a.a();
                aVar.field_productID = com.tencent.mm.plugin.emoji.h.a.aoK();
                aVar.field_packName = "emoji_custom_all";
                aVar.field_type = com.tencent.mm.storage.a.a.TYPE_SYSTEM;
                aVar.field_sort = 1;
                aVar.field_idx = 0;
                aVar.field_packType = 4;
                aVar.field_packFlag = 1;
                aVar.field_lastUseTime = System.currentTimeMillis();
                bVar.c(aVar);
                h.ame().d(com.tencent.mm.plugin.emoji.h.a.aoK(), 7, a.kMB, "");
                a.amk();
                return false;
            }
            h.ame().d(com.tencent.mm.plugin.emoji.h.a.aoK(), 6, a.kMB, "");
            a.kMB += 2;
            return true;
        }
    }

    public static final a amh() {
        if (kMC == null) {
            synchronized (a.class) {
                if (kMC == null) {
                    kMC = new a();
                }
            }
        } else {
            kMC.KH();
        }
        return kMC;
    }

    public static void ami() {
        kMB = 0;
        kMD = new q("com.tencent.xin.emoticon.tusiji", 1);
        ap.vd().a(kMD, 0);
        ap.vd().a(413, kME);
        w.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    }

    public final void amj() {
        KH();
        h.ame().d(com.tencent.mm.plugin.emoji.h.a.aoK(), 3, kMB, "");
        amk();
    }

    public static void amk() {
        if (kMD != null) {
            ap.vd().c(kMD);
        }
        ap.vd().b(413, kME);
        w.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    }

    private a() {
        super(new a(), true);
    }
}
