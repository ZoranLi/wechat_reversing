package com.tencent.mm.bc;

import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class c {
    private static String NE(String str) {
        if (bg.mA(str)) {
            return "";
        }
        return str.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
    }

    public static String bGR() {
        String str;
        Throwable e;
        Throwable e2;
        String str2 = "";
        InputStream inputStream;
        try {
            inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                str = str2;
                while (true) {
                    try {
                        str2 = bufferedReader.readLine();
                        if (str2 == null) {
                            break;
                        } else if (!bg.mA(str2)) {
                            str = NE(str + str2 + ";");
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e4) {
                        w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e4));
                    }
                }
            } catch (Throwable e22) {
                e4 = e22;
                str = str2;
                try {
                    w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e4));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e42) {
                            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e42));
                        }
                    }
                    return str.replace(",", "_");
                } catch (Throwable th) {
                    e22 = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e422) {
                            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e422));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Throwable e222) {
            inputStream = null;
            e422 = e222;
            str = str2;
            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e422));
            if (inputStream != null) {
                inputStream.close();
            }
            return str.replace(",", "_");
        } catch (Throwable th2) {
            e222 = th2;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw e222;
        }
        return str.replace(",", "_");
    }

    public static String bGS() {
        InputStream inputStream;
        String str;
        Throwable e;
        Throwable e2;
        String str2 = "";
        try {
            inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/meminfo"}).start().getInputStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                str = str2;
                while (true) {
                    try {
                        str2 = bufferedReader.readLine();
                        if (str2 == null) {
                            break;
                        } else if (!bg.mA(str2)) {
                            str = NE(str + str2 + ";");
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e4) {
                        w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e4));
                    }
                }
            } catch (Throwable e22) {
                e4 = e22;
                str = str2;
                try {
                    w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e4));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e42) {
                            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e42));
                        }
                    }
                    return str.replace(",", "_");
                } catch (Throwable th) {
                    e22 = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e422) {
                            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e422));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Throwable e222) {
            inputStream = null;
            e422 = e222;
            str = str2;
            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e422));
            if (inputStream != null) {
                inputStream.close();
            }
            return str.replace(",", "_");
        } catch (Throwable th2) {
            e222 = th2;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw e222;
        }
        return str.replace(",", "_");
    }

    public static String bGT() {
        String str = "";
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = ab.getContext().getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = displayMetrics.density;
            float f2 = displayMetrics.xdpi;
            float f3 = displayMetrics.ydpi;
            str = (((("" + "width:" + String.valueOf(i) + ";") + "height:" + String.valueOf(i2) + ";") + "density:" + String.valueOf(f) + ";") + "xd:" + String.valueOf(f2) + ";") + "yd:" + String.valueOf(f3) + ";";
        } catch (Throwable e) {
            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(e));
        }
        return str.replace(",", "_");
    }

    public static String getRomInfo() {
        String str;
        String str2 = "";
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str2 = (str2 + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";";
            str = str2 + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            Throwable th = e;
            str = str2;
            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(th));
        }
        return str.replace(",", "_");
    }

    public static String bGU() {
        String str;
        String str2 = "";
        try {
            StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str2 = (str2 + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";";
            str = str2 + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            Throwable th = e;
            str = str2;
            w.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bg.g(th));
        }
        return str.replace(",", "_");
    }

    public static String bGV() {
        ap.yY();
        return (String) com.tencent.mm.u.c.vr().get(71, null);
    }
}
