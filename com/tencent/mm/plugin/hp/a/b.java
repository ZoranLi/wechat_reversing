package com.tencent.mm.plugin.hp.a;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.b.a;
import com.tencent.mm.b.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.RandomAccessFile;

public final class b {
    public static int b(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null || str3 == null) {
            return -1;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            e.aU(str3);
            File file3 = new File(str2);
            if (file.exists() && file3.exists()) {
                int i;
                a aZ = a.aZ(str);
                if (aZ == null || aZ.fuR == null) {
                    i = 0;
                } else {
                    i = aZ.fuR.fuU + 8;
                    w.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", new Object[]{Integer.valueOf(i)});
                }
                if (d.a(randomAccessFile, file2, file3, i) != 1) {
                    w.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                    randomAccessFile.close();
                    return -1;
                }
                randomAccessFile.close();
                if (str4.equalsIgnoreCase(g.aV(str3))) {
                    com.tencent.mm.b.b bVar = new com.tencent.mm.b.b();
                    bVar.apkMd5 = str4;
                    new a(bVar).g(file2);
                    return 0;
                }
                w.i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", new Object[]{str4, g.aV(str4)});
                return -2;
            }
            w.e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", new Object[]{Boolean.valueOf(file.exists()), Boolean.valueOf(file2.exists()), Boolean.valueOf(file3.exists())});
            randomAccessFile.close();
            return -1;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", e, "merge apk failed.", new Object[0]);
            return -1;
        }
    }
}
