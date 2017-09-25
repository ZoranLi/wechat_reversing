package com.tencent.mm.ah.a.g;

import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static long hJA = 0;
    public static final String hJz = (hgu + ".tmp");
    public static final String hgs = h.getExternalStorageDirectory().getAbsolutePath();
    public static final String hgu = (hgs + "/tencent/MicroMsg/");

    public static String Hi() {
        w.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", hJz + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())));
        File file = new File(hJz);
        if (!file.exists()) {
            file.mkdirs();
        }
        return r0;
    }

    public static boolean Hj() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - hJA > 86400000) {
            w.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
            hJA = currentTimeMillis;
            return true;
        }
        w.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
        return false;
    }

    public static boolean Hk() {
        File file = new File(hJz);
        try {
            if (!file.exists() || file.isFile()) {
                return true;
            }
            b(file, true);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
            return false;
        }
    }

    private static void b(File file, boolean z) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        if (!file2.isFile()) {
                            int i;
                            w.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(file2.lastModified()));
                            if (System.currentTimeMillis() - file2.lastModified() >= 259200000) {
                                i = 1;
                            } else {
                                boolean z2 = false;
                            }
                            if (i != 0 && z) {
                                b(file2, false);
                            }
                        } else if (file2 != null && file2.isFile() && file2.exists()) {
                            file2.delete();
                        }
                    }
                }
            }
            file.delete();
        }
    }
}
