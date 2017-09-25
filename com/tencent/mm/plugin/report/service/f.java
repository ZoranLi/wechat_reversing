package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.StatFs;
import android.util.SparseArray;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.plugin.appbrand.jsapi.cc;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class f {
    private static SparseArray<Long> oTW = new SparseArray();
    private static SparseArray<HashMap<Integer, Integer>> oTX = new SparseArray();
    private static boolean oTY = true;
    private static long oTZ = 0;
    private static long oUa = 0;
    private static long oUb = 0;

    public static final class a {
        public static a oUg;
        public volatile boolean hasInit;
        public long[] oUc;
        public int oUd;
        public String oUe;
        public long oUf;

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

        public static synchronized a aXJ() {
            a aVar;
            synchronized (a.class) {
                if (oUg == null) {
                    aVar = new a();
                    oUg = aVar;
                    aVar.oUd = ru();
                    oUg.oUe = ro();
                    a aVar2 = oUg;
                    ActivityManager activityManager = (ActivityManager) ab.getContext().getSystemService("activity");
                    MemoryInfo memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    aVar2.oUf = memoryInfo.availMem >> 10;
                    aVar = oUg;
                    long[] jArr = new long[2];
                    StatFs statFs = new StatFs(h.getDataDirectory().getPath());
                    jArr[0] = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                    StatFs statFs2 = new StatFs(h.getDataDirectory().getPath());
                    jArr[1] = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                    aVar.oUc = jArr;
                    oUg.hasInit = true;
                }
                aVar = oUg;
            }
            return aVar;
        }

        private static String ro() {
            String trim;
            Throwable e;
            Throwable th;
            String str = "N/A";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
                trim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                } catch (FileNotFoundException e2) {
                    e = e2;
                    w.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                    return trim;
                } catch (IOException e3) {
                    e = e3;
                    w.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                    return trim;
                }
            } catch (Throwable e4) {
                th = e4;
                trim = str;
                e = th;
                w.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                return trim;
            } catch (Throwable e42) {
                th = e42;
                trim = str;
                e = th;
                w.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                return trim;
            }
            return trim;
        }

        private static int ru() {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                return 1;
            }
        }
    }

    public static void rY(int i) {
        if (oTY) {
            oTW.put(i, Long.valueOf(bg.Nz()));
            w.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(bg.Nz()));
        }
    }

    public static void cU(long j) {
        if (oTY) {
            w.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", Integer.valueOf(8), Long.valueOf(j));
            oTW.put(8, Long.valueOf(j));
        }
    }

    public static void rZ(int i) {
        if (oTY) {
            Long l = (Long) oTW.get(i);
            if (l != null && l.longValue() != -1) {
                oTW.put(i, Long.valueOf(-1));
                long Nz = bg.Nz() - l.longValue();
                if (Nz > 0) {
                    switch (i) {
                        case 8:
                            if (!ab.usY) {
                                B(1, Nz);
                                A(GameJsApiGetOpenDeviceId.CTRL_BYTE, Nz);
                                g.oUh.c(23, 1, 2, (int) Nz, false);
                                break;
                            }
                            g.oUh.c(23, 4, 5, (int) Nz, false);
                            break;
                        case 9:
                            B(3, Nz);
                            A(cc.CTRL_INDEX, Nz);
                            g.oUh.c(27, 1, 2, (int) Nz, false);
                            break;
                        case 10:
                            B(2, Nz);
                            A(JsApiOpenWeRunSetting.CTRL_INDEX, Nz);
                            g.oUh.c(28, 1, 2, (int) Nz, false);
                            break;
                        case 12:
                            B(6, Nz);
                            break;
                        case 13:
                            B(7, Nz);
                            break;
                        case 14:
                            B(8, Nz);
                            break;
                        case 18:
                            B(10, Nz);
                            break;
                        case 19:
                            B(9, Nz);
                            break;
                        case 20:
                            B(12, Nz);
                            break;
                        case 21:
                            B(11, Nz);
                            break;
                        case 22:
                            B(13, Nz);
                            break;
                        case 23:
                            B(16, Nz);
                            break;
                        case 24:
                            B(15, Nz);
                            break;
                        case 25:
                            B(14, Nz);
                            break;
                    }
                    w.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(Nz));
                }
            }
        }
    }

    private static void A(int i, long j) {
        if (j > 0) {
            if (j < 1000) {
                g.oUh.L(i, 0, 1);
            } else if (j < 2000) {
                g.oUh.L(i, 0, 3);
            } else if (j < 5000) {
                g.oUh.L(i, 0, 5);
            } else if (j < 10000) {
                g.oUh.L(i, 0, 7);
            } else {
                g.oUh.L(i, 0, 9);
            }
        }
    }

    private static void B(int i, long j) {
        long currentTimeMillis;
        if (i == 6) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= oTZ + 60000) {
                oTZ = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 7) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= oUa + 60000) {
                oUa = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 8) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= oUb + 60000) {
                oUb = currentTimeMillis;
            } else {
                return;
            }
        }
        if (a.aXJ().hasInit) {
            g.oUh.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(r0.oUd), Long.valueOf(r0.oUc[0]), Long.valueOf(r0.oUc[1]), Long.valueOf(r0.oUf));
            return;
        }
        g.oUh.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j));
    }

    public static void sa(int i) {
        if (oTY) {
            w.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", Integer.valueOf(i));
            oTW.put(i, Long.valueOf(-1));
        }
    }
}
