package com.tencent.c.d.a;

import com.tencent.c.d.b.a;
import com.tencent.c.d.b.c;
import com.tencent.c.e.g;
import java.io.File;

public final class f {
    private static boolean F(File file) {
        try {
            if ((c.Vf(file.getAbsolutePath()) & 2048) > 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            g.i(e);
            return false;
        }
    }

    public static boolean cdI() {
        if (com.tencent.c.d.b.f.cdK()) {
            g.Vi("SetuidBitChecker : SELinux is enforcing");
            return false;
        }
        try {
            boolean z;
            File[] listFiles;
            String str = new String(a.Ve("/proc/mounts"));
            g.d("SetuidBitChecker mounts : " + str);
            for (String str2 : str.split("\n")) {
                if (str2.contains(" /system ")) {
                    if (str2.contains(",nosuid")) {
                        g.Vi("SetuidBitChecker : nosuid found");
                        z = true;
                        if (!z) {
                            return false;
                        }
                        if (c.isAvailable()) {
                            listFiles = new File("/system/bin").listFiles();
                            if (listFiles != null) {
                                while (r2 < r4) {
                                    if ("run-as".equals(r5.getName()) || !F(r5)) {
                                    } else {
                                        g.Vi("SetuidBitChecker s-bit found : " + r5.getAbsolutePath());
                                        return true;
                                    }
                                }
                            }
                            listFiles = new File("/system/xbin").listFiles();
                            if (listFiles != null) {
                                for (File file : listFiles) {
                                    if (F(file)) {
                                        g.Vi("SetuidBitChecker s-bit found : " + file.getAbsolutePath());
                                        return true;
                                    }
                                }
                            }
                            g.Vi("SetuidBitChecker s-bit not found");
                            return false;
                        }
                        g.Vi("SetuidBitChecker : OsUtil isn't available");
                        return false;
                    }
                    z = false;
                    if (!z) {
                        return false;
                    }
                    if (c.isAvailable()) {
                        listFiles = new File("/system/bin").listFiles();
                        if (listFiles != null) {
                            for (File file2 : listFiles) {
                                if ("run-as".equals(file2.getName())) {
                                }
                            }
                        }
                        listFiles = new File("/system/xbin").listFiles();
                        if (listFiles != null) {
                            while (r2 < r4) {
                                if (F(file2)) {
                                } else {
                                    g.Vi("SetuidBitChecker s-bit found : " + file2.getAbsolutePath());
                                    return true;
                                }
                            }
                        }
                        g.Vi("SetuidBitChecker s-bit not found");
                        return false;
                    }
                    g.Vi("SetuidBitChecker : OsUtil isn't available");
                    return false;
                }
            }
            z = false;
            if (!z) {
                return false;
            }
            if (c.isAvailable()) {
                g.Vi("SetuidBitChecker : OsUtil isn't available");
                return false;
            }
            listFiles = new File("/system/bin").listFiles();
            if (listFiles != null) {
                for (File file22 : listFiles) {
                    if ("run-as".equals(file22.getName())) {
                    }
                }
            }
            listFiles = new File("/system/xbin").listFiles();
            if (listFiles != null) {
                for (File file222 : listFiles) {
                    if (F(file222)) {
                        g.Vi("SetuidBitChecker s-bit found : " + file222.getAbsolutePath());
                        return true;
                    }
                }
            }
            g.Vi("SetuidBitChecker s-bit not found");
            return false;
        } catch (Throwable e) {
            g.i(e);
            return false;
        }
    }
}
