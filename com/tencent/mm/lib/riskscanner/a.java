package com.tencent.mm.lib.riskscanner;

import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.PrintWriter;
import java.io.StringWriter;

final class a {
    private static ThreadLocal<Long> hbo = new ThreadLocal();

    public static void wi() {
        w.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
        c.oTb.a(590, 0, 1, true);
        hbo.set(Long.valueOf(bg.NA()));
    }

    public static void d(Throwable th) {
        StringWriter stringWriter;
        StringWriter stringWriter2;
        Throwable th2;
        PrintWriter printWriter = null;
        w.i("MicroMsg.RiskScannerReportService", "Report an exception with message: %s", th.getMessage());
        hbo.remove();
        c.oTb.a(590, 4, 1, true);
        PrintWriter printWriter2;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter2 = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter2);
                    printWriter2.flush();
                    c.oTb.a(14177, "-1," + stringWriter.toString().replace(",", "##"), false, true);
                    try {
                        stringWriter.close();
                    } catch (Throwable th3) {
                    }
                    try {
                        printWriter2.close();
                    } catch (Throwable th4) {
                    }
                } catch (Throwable th5) {
                    printWriter = printWriter2;
                    th2 = th5;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable th6) {
                        }
                    }
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th8) {
                th2 = th8;
                if (stringWriter != null) {
                    stringWriter.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th2;
            }
        } catch (Throwable th9) {
            th2 = th9;
            stringWriter = null;
            if (stringWriter != null) {
                stringWriter.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
            throw th2;
        }
    }

    public static void eT(int i) {
        w.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", Integer.valueOf(i));
        switch (i) {
            case -10:
                c.oTb.a(590, 2, 1, true);
                return;
            case 0:
                Long l = (Long) hbo.get();
                if (l != null) {
                    w.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", Long.valueOf(bg.NA() - l.longValue()));
                    c.oTb.c(590, 5, 1, (int) r4, true);
                    return;
                }
                c.oTb.a(590, 1, 1, true);
                return;
            default:
                c.oTb.a(590, 3, 1, true);
                return;
        }
    }
}
