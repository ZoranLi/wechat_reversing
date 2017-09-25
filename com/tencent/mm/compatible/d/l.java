package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public final class l {
    static int gQL = 0;
    static String gQM = null;

    public static int rl() {
        int i;
        int i2 = 15;
        int i3 = m.rs() ? 7 : m.rt() ? 3 : 1;
        if (p.gRb.gQO && p.gRb.gQQ == 0) {
            w.d("MicroMsg.CpuChecker", "disable armv6 by server ");
            i3 &= -3;
        }
        if (p.gRb.gQO && p.gRb.gQP == 0) {
            w.d("MicroMsg.CpuChecker", "disable armv7 by server ");
            i3 &= -5;
        }
        int ru = m.ru();
        if (ru > 16) {
            ru = 15;
        } else if (ru <= 0) {
            ru = 1;
        }
        int i4 = bg.getInt(rm(), 0) / 1000;
        if (ru > 4) {
            i = i4 * 4;
        } else if (ru > 2) {
            i = i4 * 2;
        } else if (ru > 1) {
            i = (i4 * 3) >> 1;
        } else {
            i = i4;
        }
        i /= 100;
        if (i > 30) {
            i = 30;
        } else if (i < 5) {
            i = 5;
        }
        if (i > 5 || ru < 4) {
            i2 = i;
        }
        i3 = ((i3 + (ru << 4)) << 8) + i2;
        gQL = i3;
        return i3;
    }

    public static String rm() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            str = "";
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CpuChecker", e, "", new Object[0]);
            str = "0";
        }
        if (str.length() == 0) {
            return "0";
        }
        return str.trim();
    }

    public static String rn() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            str = "";
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CpuChecker", e, "", new Object[0]);
            str = "0";
        }
        if (str.length() == 0) {
            return "0";
        }
        return str.trim();
    }

    public static String ro() {
        BufferedReader bufferedReader;
        String readLine;
        Throwable e;
        Reader reader;
        FileReader fileReader = null;
        try {
            Reader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    readLine = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                        fileReader2.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    reader = fileReader2;
                    try {
                        w.printErrStackTrace("MicroMsg.CpuChecker", e, "", new Object[0]);
                        readLine = "0";
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        if (readLine.length() != 0) {
                            return "0";
                        }
                        return readLine.trim();
                    } catch (Throwable th) {
                        e = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e5) {
                                throw e;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    reader = fileReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw e;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader = null;
                reader = fileReader2;
                w.printErrStackTrace("MicroMsg.CpuChecker", e, "", new Object[0]);
                readLine = "0";
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                if (readLine.length() != 0) {
                    return readLine.trim();
                }
                return "0";
            } catch (Throwable th3) {
                e = th3;
                bufferedReader = null;
                reader = fileReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader = null;
            w.printErrStackTrace("MicroMsg.CpuChecker", e, "", new Object[0]);
            readLine = "0";
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            if (readLine.length() != 0) {
                return readLine.trim();
            }
            return "0";
        } catch (Throwable th4) {
            e = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            throw e;
        }
        if (readLine.length() != 0) {
            return "0";
        }
        return readLine.trim();
    }
}
