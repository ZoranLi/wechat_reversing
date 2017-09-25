package com.tencent.mm.plugin.fps_lighter.e;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class b {
    private static final FileFilter lQS = new FileFilter() {
        public final boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };

    public static int avN() {
        if (VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int ws = ws("/sys/devices/system/cpu/possible");
            if (ws == -1) {
                ws = ws("/sys/devices/system/cpu/present");
            }
            if (ws == -1) {
                return new File("/sys/devices/system/cpu/").listFiles(lQS).length;
            }
            return ws;
        } catch (SecurityException e) {
            return -1;
        } catch (NullPointerException e2) {
            return -1;
        }
    }

    private static int ws(String str) {
        InputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        int i = -1;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null && readLine.matches("0-[\\d]+$")) {
                        i = Integer.valueOf(readLine.substring(2)).intValue() + 1;
                    }
                    try {
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.DeviceInfo", e, "", new Object[0]);
                    }
                } catch (IOException e2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.DeviceInfo", e3, "", new Object[0]);
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e32) {
                            w.printErrStackTrace("MicroMsg.DeviceInfo", e32, "", new Object[0]);
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return i;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return i;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return i;
    }

    public static int avO() {
        int i;
        int i2 = -1;
        for (int i3 = 0; i3 < avN(); i3++) {
            File file = new File("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq");
            if (file.exists()) {
                byte[] bArr = new byte[FileUtils.S_IWUSR];
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    i = 0;
                    while (Character.isDigit(bArr[i]) && i < FileUtils.S_IWUSR) {
                        i++;
                    }
                    Integer valueOf = Integer.valueOf(bg.PY(new String(bArr, 0, i)));
                    if (valueOf.intValue() > i2) {
                        i2 = valueOf.intValue();
                    }
                    fileInputStream.close();
                } catch (NumberFormatException e) {
                    fileInputStream.close();
                } catch (IOException e2) {
                    return -1;
                } catch (Throwable th) {
                    fileInputStream.close();
                }
            }
        }
        if (i2 != -1) {
            return i2;
        }
        FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
        i = a("cpu MHz", fileInputStream2) * 1000;
        if (i > i2) {
            i2 = i;
        }
        fileInputStream2.close();
        return i2;
    }

    @TargetApi(16)
    public static long cc(Context context) {
        FileInputStream fileInputStream;
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            long a = ((long) a("MemTotal", fileInputStream)) * AppSupportContentFlag.MMAPP_SUPPORT_XLS;
            try {
                fileInputStream.close();
                return a;
            } catch (IOException e) {
                return a;
            }
        } catch (IOException e2) {
            return -1;
        } catch (Throwable th) {
            fileInputStream.close();
        }
    }

    private static int a(String str, FileInputStream fileInputStream) {
        int i = 0;
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            int read = fileInputStream.read(bArr);
            while (i < read) {
                if (bArr[i] == (byte) 10 || i == 0) {
                    if (bArr[i] == (byte) 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            while (i2 < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && bArr[i2] != (byte) 10) {
                                if (Character.isDigit(bArr[i2])) {
                                    i = i2 + 1;
                                    while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && Character.isDigit(bArr[i])) {
                                        i++;
                                    }
                                    return bg.PY(new String(bArr, 0, i2, i - i2));
                                }
                                i2++;
                            }
                            return -1;
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException e) {
        } catch (NumberFormatException e2) {
        }
        return -1;
    }
}
