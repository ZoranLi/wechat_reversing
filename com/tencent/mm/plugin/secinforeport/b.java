package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.protocal.c.auv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

enum b implements com.tencent.mm.plugin.secinforeport.a.a {
    ;

    static final class a {
        private static volatile long lastReportTime;

        static {
            lastReportTime = -1;
        }

        private static synchronized void sL() {
            DataInputStream dataInputStream;
            Throwable th;
            synchronized (a.class) {
                DataInputStream dataInputStream2 = null;
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(new File(h.vI().cachePath, d.nZC.BO("!#?'8/f((6(1$\u001f2*>(s826"))));
                    try {
                        lastReportTime = dataInputStream.readLong();
                        w.i("MicroMsg.SecInfoReporterImpl", "normsg stat load done.");
                        try {
                            dataInputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        try {
                            lastReportTime = 0;
                            w.e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.");
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            dataInputStream2 = dataInputStream;
                            th = th3;
                            if (dataInputStream2 != null) {
                                try {
                                    dataInputStream2.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    dataInputStream = null;
                    lastReportTime = 0;
                    w.e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.");
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    if (dataInputStream2 != null) {
                        dataInputStream2.close();
                    }
                    throw th;
                }
            }
            return;
        }

        private static synchronized void save() {
            DataOutputStream dataOutputStream;
            Throwable th;
            synchronized (a.class) {
                File file = new File(h.vI().cachePath, d.nZC.BO("!#?'8/f((6(1$\u001f2*>(s826"));
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                DataOutputStream dataOutputStream2 = null;
                try {
                    dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                    try {
                        dataOutputStream.writeLong(lastReportTime);
                        w.i("MicroMsg.SecInfoReporterImpl", "normsg stat save done.");
                        try {
                            dataOutputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        try {
                            w.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            dataOutputStream2 = dataOutputStream;
                            th = th3;
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    dataOutputStream = null;
                    w.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    throw th;
                }
            }
            return;
        }

        static synchronized boolean aZL() {
            boolean z = false;
            synchronized (a.class) {
                if (lastReportTime == -1) {
                    sL();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis < lastReportTime) {
                    lastReportTime = 0;
                    save();
                } else if (currentTimeMillis - lastReportTime > 86400000) {
                    lastReportTime = currentTimeMillis;
                    save();
                    z = true;
                }
            }
            return z;
        }
    }

    private b(String str) {
    }

    public final boolean aZL() {
        return a.aZL();
    }

    public final void Ea(String str) {
        int nextInt = new Random().nextInt();
        int length = str.length();
        int i = (length / 1000) + (length % 1000 > 0 ? 1 : 0);
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int min = Math.min(1000, length - i2);
            c.oTb.a(13690, nextInt + "," + i + "," + i3 + ",0,0" + ",," + str.substring(i2, i2 + min), false, true);
            i2 += min;
            i3++;
        }
        w.d("MicroMsg.SecInfoReporterImpl", "kvreport: ctxId: %d, dataLen: %d, pkgCount: %d", new Object[]{Integer.valueOf(nextInt), Integer.valueOf(length), Integer.valueOf(i)});
    }

    public final void bC(String str, final int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.uri = d.nZC.BO("Q\u001e\u001b\u0012W\u001b\u0011\u0019Y\u0018\u001d\u0010\u0000\u001e\u001d\u001c\t@\u000e\u0002\u0004F\u001a\u0002\u0016\n\u0016\u0017\u0001\r\t:0)?3?:3");
        aVar.hsl = 771;
        aVar.hsm = new auu();
        aVar.hsn = new auv();
        com.tencent.mm.y.b BE = aVar.BE();
        auu com_tencent_mm_protocal_c_auu = (auu) BE.hsj.hsr;
        com_tencent_mm_protocal_c_auu.tYt = i;
        com_tencent_mm_protocal_c_auu.tYs = str;
        c.oTb.a(416, 0, 1, false);
        u.a(BE, new com.tencent.mm.y.u.a(this) {
            final /* synthetic */ b phH;

            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    w.d("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d", new Object[]{Integer.valueOf(i)});
                    c.oTb.a(416, 1, 1, false);
                } else {
                    w.d("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2), str});
                    c.oTb.a(416, 2, 1, false);
                }
                return 0;
            }
        }, false);
    }
}
