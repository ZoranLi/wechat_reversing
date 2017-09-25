package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.File;
import java.io.IOException;

public final class b {

    static class a implements Runnable {
        private File lfm;
        private String url;

        a(String str, File file) {
            this.url = str;
            this.lfm = file;
        }

        public final void run() {
            byte[] Qc = bg.Qc(this.url);
            if (Qc != null) {
                FileOp.k(this.lfm.getAbsolutePath(), Qc);
            }
        }

        public final String toString() {
            return super.toString() + "|DownloadRunnable";
        }
    }

    public static String uZ(String str) {
        if (bg.mA(str) || "#".equals(str)) {
            return "";
        }
        File file = new File(d.apG(), aa.Pq(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            w.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[]{e.toString()});
        }
        ap.vL().D(new a(str, file));
        return "";
    }
}
