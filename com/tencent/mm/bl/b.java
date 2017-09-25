package com.tencent.mm.bl;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String uNA = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/memory/");

    private static boolean bOe() {
        if (c.rZ()) {
            File file = new File(uNA);
            if (!file.exists()) {
                file.mkdirs();
            }
            return true;
        }
        w.i("MicroMsg.MemoryDumpManager", "Hprof sdcard is invalid");
        return false;
    }

    private static boolean H(boolean z, boolean z2) {
        if (!bOe()) {
            return false;
        }
        File file = new File(uNA);
        File[] listFiles = file.listFiles();
        if (listFiles.length == 0) {
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        long time = new Date().getTime();
        boolean z3 = true;
        for (File file2 : listFiles) {
            String name = file2.getName();
            int indexOf = name.indexOf(".hprof");
            if (indexOf > 0) {
                Object substring = name.substring(0, indexOf);
                try {
                    Date parse = simpleDateFormat.parse(substring);
                    if (parse == null) {
                        file2.delete();
                    } else {
                        long time2 = parse.getTime();
                        if (time2 >= time) {
                            file2.delete();
                        } else {
                            time2 = (time - time2) / 86400000;
                            if (time2 >= 3) {
                                file2.delete();
                            } else if (z && time2 < 1) {
                                z3 = false;
                            }
                        }
                    }
                } catch (ParseException e) {
                    w.e("MicroMsg.MemoryDumpManager", "hprofFileCheck parse date fail %s", substring);
                    file2.delete();
                }
            } else {
                file2.delete();
            }
        }
        File[] listFiles2 = file.listFiles();
        if (listFiles2.length <= 5) {
            return z3;
        }
        if (z2) {
            Toast.makeText(ab.getContext(), "dump fail, hprof file size exceed", 0).show();
        }
        w.w("MicroMsg.MemoryDumpManager", "hprofFileCheck hprofFileDir.length() too large " + listFiles2.length);
        return false;
    }

    public static String I(boolean z, boolean z2) {
        if (!H(z, z2)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(uNA).append(format).append(".hprof");
        String stringBuffer2 = stringBuffer.toString();
        if (B(new File(stringBuffer2).getParentFile())) {
            try {
                bOf();
                Debug.dumpHprofData(stringBuffer2);
                if (z2) {
                    Toast.makeText(ab.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
                }
                w.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", format, Long.valueOf(bg.aA(currentTimeMillis)));
                return stringBuffer2;
            } catch (Exception e) {
                w.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
                return null;
            }
        }
        w.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", stringBuffer2);
        return null;
    }

    public static String Sx(String str) {
        if (!bOe()) {
            return null;
        }
        String str2 = uNA + str + ".hprof";
        if (B(new File(str2).getParentFile())) {
            try {
                bOf();
                Debug.dumpHprofData(str2);
                Toast.makeText(ab.getContext(), str2 + " hprof file has saved ", 0).show();
                return str2;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MemoryDumpManager", e, "dumpHprofFile Exception", new Object[0]);
                return null;
            }
        }
        w.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", str2);
        return null;
    }

    public static String Sy(String str) {
        if (!bOe()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(uNA).append(str).append(".hprof");
        String stringBuffer2 = stringBuffer.toString();
        if (B(new File(stringBuffer2).getParentFile())) {
            try {
                bOf();
                Debug.dumpHprofData(stringBuffer2);
                Toast.makeText(ab.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
                w.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", str, Long.valueOf(bg.aA(currentTimeMillis)));
                File file = new File(stringBuffer2);
                if (file.exists()) {
                    stringBuffer2 = p.a(file, true, null);
                    if (stringBuffer2 != null) {
                        return stringBuffer2;
                    }
                    w.e("MicroMsg.MemoryDumpManager", "zip hprof file fail");
                    return null;
                }
                w.e("MicroMsg.MemoryDumpManager", "Hprof dump file is not exist");
                return null;
            } catch (Exception e) {
                w.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
                return null;
            }
        }
        w.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", stringBuffer2);
        return null;
    }

    private static boolean B(File file) {
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        return file.exists();
    }

    public static void bOf() {
        Runtime.getRuntime().gc();
        System.runFinalization();
    }

    public static void bOg() {
        InputStreamReader inputStreamReader;
        LineNumberReader lineNumberReader;
        InputStreamReader inputStreamReader2;
        Throwable th;
        Throwable th2;
        LineNumberReader lineNumberReader2 = null;
        if (VERSION.SDK_INT >= 14) {
            bOh();
            return;
        }
        try {
            Process exec = Runtime.getRuntime().exec("dumpsys meminfo " + Process.myPid());
            inputStreamReader = new InputStreamReader(exec.getInputStream());
            try {
                lineNumberReader = new LineNumberReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = lineNumberReader.readLine();
                        if (readLine != null) {
                            w.i("MicroMsg.MemoryDumpManager", readLine);
                        } else {
                            exec.waitFor();
                            exec.destroy();
                            try {
                                lineNumberReader.close();
                                inputStreamReader.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (IOException e2) {
                        inputStreamReader2 = inputStreamReader;
                    } catch (InterruptedException e3) {
                        lineNumberReader2 = lineNumberReader;
                    } catch (Throwable th3) {
                        th = th3;
                        lineNumberReader2 = lineNumberReader;
                        th2 = th;
                    }
                }
            } catch (IOException e4) {
                lineNumberReader = null;
                inputStreamReader2 = inputStreamReader;
                try {
                    w.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
                    if (lineNumberReader != null) {
                        try {
                            lineNumberReader.close();
                        } catch (IOException e5) {
                            return;
                        }
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = inputStreamReader2;
                    lineNumberReader2 = lineNumberReader;
                    th2 = th;
                    if (lineNumberReader2 != null) {
                        try {
                            lineNumberReader2.close();
                        } catch (IOException e6) {
                            throw th2;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    throw th2;
                }
            } catch (InterruptedException e7) {
                try {
                    w.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
                    if (lineNumberReader2 != null) {
                        try {
                            lineNumberReader2.close();
                        } catch (IOException e8) {
                            return;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    if (lineNumberReader2 != null) {
                        lineNumberReader2.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    throw th2;
                }
            }
        } catch (IOException e9) {
            lineNumberReader = null;
            w.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
        } catch (InterruptedException e10) {
            inputStreamReader = null;
            w.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
            if (lineNumberReader2 != null) {
                lineNumberReader2.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (Throwable th6) {
            th2 = th6;
            inputStreamReader = null;
            if (lineNumberReader2 != null) {
                lineNumberReader2.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th2;
        }
    }

    public static void bOh() {
        ActivityManager activityManager = (ActivityManager) ab.getContext().getSystemService("activity");
        w.i("MicroMsg.MemoryDumpManager", " wechat heap info ");
        w.i("MicroMsg.MemoryDumpManager", " Runtime.totalMemory " + Runtime.getRuntime().totalMemory());
        w.i("MicroMsg.MemoryDumpManager", " Runtime.freeMemory " + Runtime.getRuntime().freeMemory());
        w.i("MicroMsg.MemoryDumpManager", " Runtime.maxMemory " + Runtime.getRuntime().maxMemory());
        w.i("MicroMsg.MemoryDumpManager", " Debug.nativeHeapSize " + Debug.getNativeHeapSize());
        w.i("MicroMsg.MemoryDumpManager", " Debug.nativeHeapAllocatedSize " + Debug.getNativeHeapAllocatedSize());
        for (MemoryInfo memoryInfo : activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) {
            w.i("MicroMsg.MemoryDumpManager", " wechat memory info");
            w.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalPrivateDirty(): " + memoryInfo.getTotalPrivateDirty() + "\n");
            w.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalPss(): " + memoryInfo.getTotalPss() + "\n");
            w.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalSharedDirty(): " + memoryInfo.getTotalSharedDirty() + "\n");
        }
    }
}
