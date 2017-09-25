package com.tencent.mm.plugin.appbrand.h;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.as.n;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.ho;
import com.tencent.mm.e.a.st;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public class c {
    private static c jgU;
    public b jgV = new b();
    public com.tencent.mm.sdk.b.c jgW = new com.tencent.mm.sdk.b.c<bb>(this) {
        final /* synthetic */ c jgZ;

        {
            this.jgZ = r2;
            this.usg = bb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bb bbVar = (bb) bVar;
            if (bbVar.fEA.fEB == 40 && bbVar.fEA.fEC == 1) {
                File file = new File(bbVar.fEA.filePath);
                if (file.exists()) {
                    w.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                    File file2 = new File(n.Ij(), "temp");
                    File file3 = new File(file2, "wxa_fts_template.zip");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    e.p(file.getAbsolutePath(), file3.getAbsolutePath());
                    int eA = bg.eA(file3.getAbsolutePath(), file2.getAbsolutePath());
                    int i = 65900031;
                    if (eA >= 0) {
                        i = Integer.valueOf(n.l(new File(file2, "config.conf")).getProperty("version", "0")).intValue();
                    }
                    e.d(file2);
                    if (i > this.jgZ.jgV.akP) {
                        w.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.jgZ.jgV.akP), Integer.valueOf(i)});
                        if (c.b(file, new File(this.jgZ.jgV.jgT))) {
                            this.jgZ.refresh();
                        } else {
                            w.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                        }
                    } else {
                        w.i("MicroMsg.WxaFTSSearchCore", "res no need update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.jgZ.jgV.akP), Integer.valueOf(i)});
                    }
                } else {
                    w.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c jgX = new com.tencent.mm.sdk.b.c<ho>(this) {
        final /* synthetic */ c jgZ;

        {
            this.jgZ = r2;
            this.usg = ho.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            ((ho) bVar).fNc.fNd = this.jgZ.jgV.akP;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c jgY = new com.tencent.mm.sdk.b.c<st>(this) {
        final /* synthetic */ c jgZ;

        {
            this.jgZ = r2;
            this.usg = st.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            Object obj = ((st) bVar).gaI.gaJ;
            if (TextUtils.isEmpty(obj)) {
                return false;
            }
            if (obj.replace("//wxafts ", "").contains("delete")) {
                c cVar = this.jgZ;
                e.d(new File(n.Ij()));
                w.i("MicroMsg.WxaFTSSearchCore", "forceUnzipBasicTemplate");
                cVar.prepare();
            }
            return true;
        }
    };

    public static c Wz() {
        if (jgU == null) {
            synchronized (c.class) {
                if (jgU == null) {
                    jgU = new c();
                }
            }
        }
        return jgU;
    }

    private c() {
    }

    public final void prepare() {
        a.urY.b(this.jgW);
        a.urY.b(this.jgX);
        a.urY.b(this.jgY);
        refresh();
        File file = new File(this.jgV.jgT);
        w.d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", new Object[]{Integer.valueOf(this.jgV.akP), Integer.valueOf(65900031)});
        if (this.jgV.akP < 65900031 && b(file, "wxa_fts_template.zip")) {
            refresh();
        }
    }

    public final void refresh() {
        this.jgV.akP = n.Iy();
        this.jgV.jgT = n.Ij();
    }

    private static boolean b(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        File file3 = new File(file, str);
        String absolutePath = file3.getAbsolutePath();
        boolean be = d.be(absolutePath, str);
        if (be) {
            if (bg.eA(absolutePath, file3.getParent()) < 0) {
                w.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", new Object[]{Integer.valueOf(bg.eA(absolutePath, file3.getParent())), absolutePath, file3.getParent()});
                return false;
            }
            w.i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", new Object[]{file3.getAbsolutePath()});
        } else {
            w.i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", new Object[]{file3.getAbsolutePath()});
        }
        return be;
    }

    public static boolean b(File file, File file2) {
        e.d(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        if (bg.eA(file.getAbsolutePath(), file2.getAbsolutePath()) < 0) {
            w.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", new Object[]{Integer.valueOf(bg.eA(file.getAbsolutePath(), file2.getAbsolutePath())), file.getAbsolutePath(), file2.getAbsolutePath()});
            return false;
        }
        w.i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", new Object[]{file2.getAbsolutePath()});
        return true;
    }
}
