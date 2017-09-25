package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.bl.c;
import com.tencent.mm.e.a.ht;
import com.tencent.mm.e.a.rk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.m;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.b;
import java.io.File;
import java.util.Map;

public final class k extends a implements d {
    public static long a(File file, long j) {
        long j2;
        Throwable e;
        try {
            File[] listFiles = file.listFiles();
            j2 = 0;
            int i = 0;
            while (i < listFiles.length) {
                try {
                    if (listFiles[i].isDirectory()) {
                        j2 += a(listFiles[i], j);
                    } else {
                        if (listFiles[i].length() > j) {
                            w.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", Long.valueOf(listFiles[i].length()), listFiles[i].getPath());
                        }
                        j2 += listFiles[i].length();
                    }
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            j2 = 0;
            e = th;
            w.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", bg.g(e));
            return j2;
        }
        return j2;
    }

    public final b b(d.a aVar) {
        if (h.vG().uV()) {
            String str = aVar.hst.tff.tZr;
            w.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", str);
            if (!bg.mA(str)) {
                w.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", str);
                Map q = bh.q(str, "cmd");
                if (q != null) {
                    int i = bg.getInt((String) q.get(".cmd.trace.$code"), -1);
                    if (i <= 0) {
                        int i2 = bg.getInt((String) q.get(".cmd.hprof.$type"), -1);
                        if (i2 > 0) {
                            w.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", Integer.valueOf(i2));
                            c.yU(i2);
                        } else {
                            if ("android".equalsIgnoreCase((String) q.get(".cmd.hotpatch.$os"))) {
                                com.tencent.mm.sdk.b.b htVar = new ht();
                                htVar.fNn.fNo = (String) q.get(".cmd.hotpatch.xml.$url");
                                htVar.fNn.fNp = (String) q.get(".cmd.hotpatch.xml.$signature");
                                htVar.fNn.fNq = (String) q.get(".cmd.hotpatch.$url");
                                htVar.fNn.fNr = (String) q.get(".cmd.hotpatch.$signature");
                                com.tencent.mm.sdk.b.a.urY.a(htVar, Looper.myLooper());
                            } else {
                                String str2;
                                i2 = bg.getInt((String) q.get(".cmd.clearfile.$fb"), -1);
                                final long j;
                                if (i2 == 1) {
                                    j = (long) bg.getInt((String) q.get(".cmd.clearfile.$ps"), 1048576);
                                    h.vL().D(new Runnable(this) {
                                        final /* synthetic */ k hWQ;

                                        public final void run() {
                                            long Nz = bg.Nz();
                                            long a = k.a(new File(h.vI().cachePath), j);
                                            w.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), h.vI().cachePath);
                                            a = k.a(new File(h.vI().gYe), j);
                                            w.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), h.vI().gYe);
                                            a = k.a(new File(h.vI().gYe), j);
                                            w.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), h.vI().gYe);
                                            a = k.a(new File(h.vI().gYf), j);
                                            w.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), h.vI().gYf);
                                            a = k.a(new File(com.tencent.mm.storage.w.hgq), j);
                                            w.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), com.tencent.mm.storage.w.hgq);
                                            w.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", Long.valueOf(bg.Nz() - Nz));
                                        }
                                    });
                                } else if (i2 == 2) {
                                    str2 = (String) q.get(".cmd.clearfile.$pd");
                                    File file = new File(str2);
                                    String str3 = "MicroMsg.NetStatMsgExtension";
                                    String str4 = "clearfile delete :[%s] length:%s";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str2;
                                    objArr[1] = Long.valueOf(file.exists() ? file.length() : -1);
                                    w.i(str3, str4, objArr);
                                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                                    file = new File(str2);
                                    String str5 = "MicroMsg.NetStatMsgExtension";
                                    String str6 = "clearfile delete finish :[%s] length:%s";
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = str2;
                                    if (file.exists()) {
                                        j = file.length();
                                    } else {
                                        j = -1;
                                    }
                                    objArr2[1] = Long.valueOf(j);
                                    w.i(str5, str6, objArr2);
                                } else if (i2 == 3) {
                                    w.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + h.vI().vo() + ".tem");
                                    com.tencent.mm.loader.stub.b.deleteFile(h.vI().vo() + ".tem");
                                    com.tencent.mm.loader.stub.b.deleteFile(h.vI().vp() + ".tem");
                                    w.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + h.vI().vo() + ".tem");
                                }
                                final int i3 = bg.getInt((String) q.get(".cmd.updzh.$pt"), -1);
                                str2 = (String) q.get(".cmd.updzh.$pd");
                                w.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", Integer.valueOf(i3), str2);
                                if (i3 > 0 && !bg.mA(str2)) {
                                    h.vL().D(new Runnable(this) {
                                        final /* synthetic */ k hWQ;

                                        public final void run() {
                                            switch (i3) {
                                                case 1:
                                                    q.a(h.vI().gYf + str2, m.xL(), false, true);
                                                    return;
                                                case 2:
                                                    q.a(h.vI().cachePath + str2, m.xL(), false, true);
                                                    return;
                                                case 3:
                                                    q.a(str2, m.xL(), false, true);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }

                                        public final String toString() {
                                            return super.toString() + "|onPreAddMessage";
                                        }
                                    });
                                }
                            }
                        }
                    } else if (i == 6) {
                        com.tencent.mm.sdk.b.a.urY.m(new rk());
                    } else {
                        com.tencent.mm.bl.d.bOi().c(new com.tencent.mm.bl.d.a((String) q.get(".cmd.trace.$class"), i, bg.getInt((String) q.get(".cmd.trace.$size"), 0), bg.getInt((String) q.get(".cmd.trace.$type"), 0)));
                    }
                }
                w.bIP();
                h.vd().hsZ.hv(str);
                try {
                    Thread.sleep(50, 0);
                } catch (Exception e) {
                }
                LogLogic.initIPxxLogInfo();
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
            }
        } else {
            w.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
        }
        return null;
    }

    public final void a(int i, int i2, String str, int i3, String str2, boolean z) {
        final int i4 = i;
        final int i5 = i2;
        final String str3 = str;
        final int i6 = i3;
        final String str4 = str2;
        final boolean z2 = z;
        h.vL().e(new Runnable(this) {
            final /* synthetic */ k hWQ;

            public final void run() {
                k.b(i4, i5, i6, z2);
            }

            public final String toString() {
                return super.toString() + "|report";
            }
        }, 3000);
    }

    public final void g(int i, int i2, int i3, int i4) {
        if (h.vG().uV()) {
            w.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            if (i <= 0) {
                i = 0;
            }
            if (i2 <= 0) {
                i2 = 0;
            }
            m.s(i, i2, 0);
            if (i3 <= 0) {
                i3 = 0;
            }
            if (i4 <= 0) {
                i4 = 0;
            }
            m.t(i3, i4, 0);
        }
    }

    public static void b(int i, int i2, int i3, boolean z) {
        if (h.vG().uV()) {
            switch (i) {
                case 4:
                    w.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:" + i3);
                    if (z) {
                        m.s(i3, 0, i2);
                        return;
                    } else {
                        m.t(i3, 0, i2);
                        return;
                    }
                case 5:
                    w.d("MicroMsg.NetStatMsgExtension", "send bytes flow:" + i3);
                    if (z) {
                        m.s(0, i3, i2);
                        return;
                    } else {
                        m.t(0, i3, i2);
                        return;
                    }
                case 8:
                    ad.Pt("dns_failed_report");
                    return;
                default:
                    return;
            }
        }
    }

    public final void h(au auVar) {
    }
}
