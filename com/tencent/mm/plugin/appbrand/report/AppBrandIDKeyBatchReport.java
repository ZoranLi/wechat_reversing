package com.tencent.mm.plugin.appbrand.report;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.protocal.c.bpy;
import com.tencent.mm.protocal.c.bpz;
import com.tencent.mm.protocal.c.bqe;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public final class AppBrandIDKeyBatchReport {
    private static volatile IDKeyBatchReportTask jfG;

    private static final class a {
        private static final byte[] jfH = new byte[0];

        public static void b(bqe com_tencent_mm_protocal_c_bqe) {
            synchronized (jfH) {
                AppBrandIDKeyBatchReport.Wl().jfK = com_tencent_mm_protocal_c_bqe;
                AppBrandIDKeyBatchReport.Wl().jfI = 3;
                AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.Wl());
            }
        }
    }

    private static final class b {
        private static volatile aj iRR = null;
        private static final ReentrantReadWriteLock jfL = new ReentrantReadWriteLock();
        private static volatile aj jfM = null;
        public static volatile int jfN;

        public static void Wo() {
            boolean z;
            final LinkedList Wq = Wq();
            if (bg.bV(Wq)) {
                z = false;
            } else {
                com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                aVar.hsm = new bpy();
                aVar.hsn = new bpz();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
                aVar.hsl = 1009;
                aVar.hso = 0;
                aVar.hsp = 0;
                com.tencent.mm.y.b BE = aVar.BE();
                auw com_tencent_mm_protocal_c_auw = new auw();
                com_tencent_mm_protocal_c_auw.jNO = Build.MANUFACTURER;
                com_tencent_mm_protocal_c_auw.tYu = 2;
                com_tencent_mm_protocal_c_auw.tlu = d.sYH;
                com_tencent_mm_protocal_c_auw.tlv = d.sYG;
                com_tencent_mm_protocal_c_auw.pyi = ab.getResources().getDisplayMetrics().widthPixels;
                com_tencent_mm_protocal_c_auw.tYv = ab.getResources().getDisplayMetrics().heightPixels;
                com_tencent_mm_protocal_c_auw.tlw = d.sYJ;
                com_tencent_mm_protocal_c_auw.tlx = d.sYK;
                com_tencent_mm_protocal_c_auw.tYw = ab.getResources().getConfiguration().locale.getLanguage();
                ((bpy) BE.hsj.hsr).uob = com_tencent_mm_protocal_c_auw;
                ((bpy) BE.hsj.hsr).uoa = Wq;
                u.a(BE, new com.tencent.mm.y.u.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                        if (i == 0 && i2 == 0) {
                            int i3 = ((bpz) bVar.hsk.hsr).uoc;
                            b.jfN = i3;
                            b.ip(i3);
                        } else {
                            Iterator it = Wq.iterator();
                            while (it.hasNext()) {
                                b.b((bqe) it.next());
                            }
                        }
                        return 0;
                    }
                }, true);
                z = true;
            }
            if (z) {
                int i = jfN;
                i = i <= 0 ? 300000 : (i + 5) * 60000;
                if (jfM != null) {
                    jfM.KH();
                    jfM = null;
                }
                aj ajVar = new aj(new com.tencent.mm.sdk.platformtools.aj.a() {
                    public final boolean oQ() {
                        b.Wp();
                        w.d("MicroMsg.AppBrandIDKeyBatchReport", "on timer expired in monitor timer!");
                        return true;
                    }
                }, false);
                jfM = ajVar;
                long j = (long) i;
                ajVar.v(j, j);
            }
        }

        public static void Wp() {
            if (iRR != null) {
                iRR.KH();
                iRR = null;
            }
        }

        public static void ip(int i) {
            int i2 = 60000;
            if (i > 0) {
                i2 = 60000 * i;
            }
            Wp();
            aj ajVar = new aj(new com.tencent.mm.sdk.platformtools.aj.a() {
                public final boolean oQ() {
                    w.d("MicroMsg.AppBrandIDKeyBatchReport", "startReport run in TimerTask!");
                    b.Wo();
                    return true;
                }
            }, true);
            iRR = ajVar;
            long j = (long) i2;
            ajVar.v(j, j);
        }

        public static void c(final bqe com_tencent_mm_protocal_c_bqe) {
            if (com_tencent_mm_protocal_c_bqe != null) {
                com.tencent.mm.plugin.appbrand.m.d.vL().D(new Runnable() {
                    public final void run() {
                        b.b(com_tencent_mm_protocal_c_bqe);
                    }
                });
            }
        }

        public static void b(bqe com_tencent_mm_protocal_c_bqe) {
            jfL.writeLock().lock();
            try {
                byte[] toByteArray = com_tencent_mm_protocal_c_bqe.toByteArray();
                File file = new File(AppBrandIDKeyBatchReport.Wm());
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(AppBrandIDKeyBatchReport.Wn());
                if (!file.exists()) {
                    file.createNewFile();
                }
                int length = toByteArray.length;
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new DataOutputStream(byteArrayOutputStream).writeInt(length);
                e.e(AppBrandIDKeyBatchReport.Wn(), byteArrayOutputStream.toByteArray());
                e.e(AppBrandIDKeyBatchReport.Wn(), toByteArray);
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrandIDKeyBatchReport", "appendToFile exception:%s", new Object[]{e.getMessage()});
                w.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
            } finally {
                jfL.writeLock().unlock();
            }
        }

        private static LinkedList<bqe> Wq() {
            ReadLock readLock = null;
            jfL.readLock().lock();
            try {
                File file = new File(AppBrandIDKeyBatchReport.Wn());
                if (file.exists()) {
                    LinkedList<bqe> linkedList = new LinkedList();
                    long length = file.length();
                    int i = 0;
                    while (true) {
                        byte[] c = e.c(AppBrandIDKeyBatchReport.Wn(), i, 4);
                        if (c == null) {
                            w.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
                            jfL.readLock().unlock();
                            Wr();
                            return null;
                        }
                        int readInt = new DataInputStream(new ByteArrayInputStream(c)).readInt();
                        linkedList.add((bqe) new bqe().aD(e.c(AppBrandIDKeyBatchReport.Wn(), i + 4, readInt)));
                        int i2 = (readInt + 4) + i;
                        if (((long) i2) >= length) {
                            jfL.readLock().unlock();
                            Wr();
                            return linkedList;
                        }
                        i = i2;
                    }
                } else {
                    w.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
                    return readLock;
                }
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[]{e.getMessage()});
                w.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
                return readLock;
            } finally {
                readLock = jfL.readLock();
                readLock.unlock();
                Wr();
            }
        }

        private static void Wr() {
            jfL.writeLock().lock();
            com.tencent.mm.loader.stub.b.deleteFile(AppBrandIDKeyBatchReport.Wn());
            jfL.writeLock().unlock();
        }
    }

    private static final class IDKeyBatchReportTask extends MainProcessTask {
        public static final Creator<IDKeyBatchReportTask> CREATOR = new Creator<IDKeyBatchReportTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IDKeyBatchReportTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IDKeyBatchReportTask[i];
            }
        };
        public int jfI;
        int jfJ;
        bqe jfK;

        IDKeyBatchReportTask() {
        }

        IDKeyBatchReportTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            if (1 == this.jfI) {
                b.ip(0);
                b.Wo();
            } else if (2 == this.jfI) {
                b.Wp();
            } else if (3 == this.jfI) {
                b.c(this.jfK);
            }
        }

        public final void f(Parcel parcel) {
            this.jfI = parcel.readInt();
            this.jfJ = parcel.readInt();
            if (3 == this.jfI) {
                try {
                    this.jfK = new bqe();
                    this.jfK.aD(parcel.createByteArray());
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[]{e});
                    this.jfK = null;
                }
            }
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.jfI);
            parcel.writeInt(this.jfJ);
            if (3 == this.jfI) {
                try {
                    parcel.writeByteArray(this.jfK.toByteArray());
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[]{e});
                }
            }
        }
    }

    public static IDKeyBatchReportTask Wl() {
        if (jfG == null) {
            jfG = new IDKeyBatchReportTask();
        }
        return jfG;
    }

    public static String Wm() {
        String str = h.vI().cachePath;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "appbrand/report/";
        com.tencent.mm.sdk.platformtools.h.KS(str);
        return str;
    }

    public static String Wn() {
        return Wm() + "WxaAppRecord";
    }

    public static void a(bqe com_tencent_mm_protocal_c_bqe) {
        if (ab.bJb()) {
            b.c(com_tencent_mm_protocal_c_bqe);
        } else {
            a.b(com_tencent_mm_protocal_c_bqe);
        }
    }
}
