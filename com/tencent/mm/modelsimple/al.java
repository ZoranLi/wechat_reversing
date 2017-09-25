package com.tencent.mm.modelsimple;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;

public final class al {
    public static e gUD = null;
    public static boolean hTa = false;
    private static int hTb = 3;
    private static long hTc = 0;

    public static void run() {
        if (hTa) {
            w.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
            return;
        }
        if (hTc == 0 || bg.aB(hTc) > 180000) {
            hTc = bg.NA();
            hTb = 3;
        }
        if (hTb <= 0) {
            w.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
            return;
        }
        hTb--;
        final String str = com.tencent.mm.compatible.util.e.gSG + "temp.avatar.hd";
        if (new File(str).exists()) {
            if (gUD == null) {
                gUD = new e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        w.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            b.deleteFile(str);
                        }
                        al.hTa = false;
                        ap.vd().b(157, al.gUD);
                    }
                };
            }
            ap.vd().a(157, gUD);
            ap.vd().a(new l(1, str), 0);
            hTa = true;
            return;
        }
        w.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
    }
}
