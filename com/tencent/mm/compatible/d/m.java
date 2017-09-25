package com.tencent.mm.compatible.d;

import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class m {
    private static Map<String, String> gQN = null;

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                return true;
            }
            return false;
        }
    }

    public static Map<String, String> rp() {
        if (gQN == null) {
            gQN = rv();
        }
        return gQN;
    }

    public static String rq() {
        if (gQN == null) {
            gQN = rv();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(": ");
        stringBuilder.append(b(gQN, "Features"));
        stringBuilder.append(": ");
        stringBuilder.append(b(gQN, "Processor"));
        stringBuilder.append(": ");
        stringBuilder.append(b(gQN, "CPU architecture"));
        stringBuilder.append(": ");
        stringBuilder.append(b(gQN, "Hardware"));
        stringBuilder.append(": ");
        stringBuilder.append(b(gQN, "Serial"));
        return stringBuilder.toString();
    }

    public static boolean rr() {
        if (gQN == null) {
            gQN = rv();
        }
        if (gQN != null) {
            String b = b(gQN, "Features");
            if (b != null && b.contains("neon")) {
                return true;
            }
            if (b != null && b.contains("asimd")) {
                return true;
            }
        }
        return false;
    }

    public static boolean rs() {
        try {
            return (VERSION.SDK_INT >= 4) && rr();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean rt() {
        if (gQN == null) {
            gQN = rv();
        }
        if (gQN == null) {
            return false;
        }
        String b = b(gQN, "CPU architecture");
        w.d("CpuFeatures", "arch " + b);
        if (b == null) {
            return false;
        }
        try {
            if (b.length() <= 0) {
                return false;
            }
            int i = bg.getInt(dt(ds(b)), 0);
            w.d("CpuFeatures", "armarch " + i);
            if (i >= 6) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            w.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            return false;
        }
    }

    public static int ru() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    private static boolean c(char c) {
        if (c < '0' || c > '9') {
            return false;
        }
        return true;
    }

    private static String ds(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (str.length() <= 0) {
                return str;
            }
            while (!c(str.charAt(0))) {
                if (str.length() == 1) {
                    return null;
                }
                str = str.substring(1);
            }
            return str;
        } catch (Throwable e) {
            w.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            return str;
        }
    }

    private static String dt(String str) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2 + 1;
            try {
                if (!c(str.charAt(i2)) || str.length() <= i) {
                    i2 = i - 1;
                } else {
                    i2 = i;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            }
        }
        i2 = i - 1;
        if (str.length() > i2 + 1 && i2 > 0) {
            str = str.substring(0, i2);
        }
        return str;
    }

    private static String b(Map<String, String> map, String str) {
        return (String) map.get(str);
    }

    public static HashMap<String, String> rv() {
        HashMap<String, String> hashMap = new HashMap();
        InputStream inputStream = null;
        try {
            inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split(":", 2);
                if (split != null && split.length >= 2) {
                    String trim = split[0].trim();
                    readLine = split[1].trim();
                    if (hashMap.get(trim) == null) {
                        hashMap.put(trim, readLine);
                    }
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("CpuFeatures", e2, "getCpu() failed.", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        }
        return hashMap;
    }
}
