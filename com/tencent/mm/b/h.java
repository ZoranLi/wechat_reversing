package com.tencent.mm.b;

import java.io.File;
import java.io.RandomAccessFile;

public final class h {
    public static int b(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null || str3 == null) {
            return -1;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            File file3 = new File(str2);
            if (file.exists() && file3.exists()) {
                int i;
                a aZ = a.aZ(str);
                if (aZ == null || aZ.fuR == null) {
                    i = 0;
                } else {
                    i = aZ.fuR.fuU + 8;
                    System.out.println("MicroMsg.MergePatchApk:extLen = " + i);
                }
                if (d.a(randomAccessFile, file2, file3, i) != 1) {
                    System.out.println("MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                    randomAccessFile.close();
                    return -1;
                }
                randomAccessFile.close();
                if (!str4.equalsIgnoreCase(g.aV(str3))) {
                    return -2;
                }
                b bVar = new b();
                bVar.apkMd5 = str4;
                new a(bVar).g(file2);
                return 0;
            }
            System.err.println("MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=" + file.exists() + ", newFile.exists()=" + file2.exists() + ", patch.exists()=" + file3.exists());
            randomAccessFile.close();
            return -1;
        } catch (Exception e) {
            System.out.println("MicroMsg.MergePatchApk:Exception in merge()");
            return -1;
        }
    }
}
