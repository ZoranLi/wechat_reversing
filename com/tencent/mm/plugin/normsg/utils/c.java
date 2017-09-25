package com.tencent.mm.plugin.normsg.utils;

import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c {
    private static String[] nZJ = new String[]{BR(ab.getContext().getFilesDir().getParent() + "/dumeq/tekcos/ved/"), BR(ab.getContext().getFilesDir().getParent() + "/epip_umeq/ved/")};
    private static String[] nZK = new String[]{BR(ab.getContext().getFilesDir().getParent() + "/hsifdlog")};
    private static String[] nZL = new String[]{BR(ab.getContext().getFilesDir().getParent() + "/os.umeq_gubed_collam_cbil/bil/metsys/"), BR(ab.getContext().getFilesDir().getParent() + "/ecart_umeq/sys/"), BR(ab.getContext().getFilesDir().getParent() + "/sporp-umeq/nib/metsys/")};
    public static boolean nZM;
    public static boolean nZN;
    public static boolean nZO;

    static {
        String str;
        Throwable th;
        nZM = false;
        nZN = false;
        nZO = false;
        for (String file : nZJ) {
            if (new File(file).exists()) {
                nZM = true;
                break;
            }
        }
        File file2 = new File("/proc/tty/drivers");
        if (file2.exists() && file2.canRead() && file2.length() > 0) {
            byte[] bArr = new byte[((int) file2.length())];
            InputStream inputStream = null;
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    inputStream = fileInputStream;
                    th = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
            str = new String(bArr);
            while (r0 < r4) {
                if (!str.contains(r5)) {
                    nZN = true;
                    break;
                }
            }
        }
        while (r0 < r3) {
            if (new File(r2).exists()) {
                nZO = true;
                return;
            }
        }
    }

    private static String BR(String str) {
        String[] strArr = new String[]{ab.getContext().getFilesDir().getParent(), str, c.class.toString()};
        return new StringBuilder(strArr[1].substring(strArr[0].length() + 1)).reverse().toString();
    }
}
