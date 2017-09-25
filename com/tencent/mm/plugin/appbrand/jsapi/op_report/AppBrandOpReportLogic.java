package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.protocal.c.akn;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.protocal.c.avg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public final class AppBrandOpReportLogic {

    public static final class AppBrandOnOpReportStartEvent implements Parcelable {
        public static final Creator<AppBrandOnOpReportStartEvent> CREATOR = new Creator<AppBrandOnOpReportStartEvent>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AppBrandOnOpReportStartEvent(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AppBrandOnOpReportStartEvent[i];
            }
        };
        String appId;

        public static void pz(String str) {
            Parcelable appBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
            appBrandOnOpReportStartEvent.appId = str;
            d.a(appBrandOnOpReportStartEvent);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
        }

        AppBrandOnOpReportStartEvent() {
        }

        AppBrandOnOpReportStartEvent(Parcel parcel) {
            this.appId = parcel.readString();
        }
    }

    public static final class a {
        private static boolean iTR = false;

        public static synchronized void TS() {
            synchronized (a.class) {
                if (!iTR) {
                    MMToClientEvent.a(new com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a() {
                        public final void aF(Object obj) {
                            if (obj instanceof AppBrandOnOpReportStartEvent) {
                                h mW = com.tencent.mm.plugin.appbrand.b.mW(((AppBrandOnOpReportStartEvent) obj).appId);
                                if (mW != null) {
                                    a.pd(mW.ivH);
                                }
                            }
                        }
                    });
                    iTR = true;
                }
            }
        }
    }

    public static final class b {
        private static final SparseIntArray iTS = new SparseIntArray();

        public static int pA(String str) {
            int i = 0;
            if (!bg.mA(str)) {
                synchronized (iTS) {
                    i = iTS.get(str.hashCode(), 0);
                }
            }
            return i;
        }

        static void ag(String str, int i) {
            if (!bg.mA(str)) {
                synchronized (iTS) {
                    iTS.put(str.hashCode(), i);
                }
            }
        }

        static void a(ReportTask reportTask) {
            if (reportTask != null) {
                com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                aVar.hsl = 1345;
                aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose";
                aVar.hsn = new avg();
                final String str = reportTask.appId;
                com.tencent.mm.bd.a com_tencent_mm_protocal_c_avf = new avf();
                com_tencent_mm_protocal_c_avf.tYL = new akn();
                com_tencent_mm_protocal_c_avf.tYL.fTO = str;
                com_tencent_mm_protocal_c_avf.tYL.username = reportTask.username;
                com_tencent_mm_protocal_c_avf.tYL.tLJ = reportTask.iPk;
                com_tencent_mm_protocal_c_avf.tYL.tkv = reportTask.fWF;
                com_tencent_mm_protocal_c_avf.tYL.tdM = reportTask.scene;
                com_tencent_mm_protocal_c_avf.tYL.tOe = reportTask.fWL;
                com_tencent_mm_protocal_c_avf.tYL.tOf = 1;
                com_tencent_mm_protocal_c_avf.tYL.tOg = reportTask.fCO;
                com_tencent_mm_protocal_c_avf.tYL.tOh = reportTask.iRt;
                com_tencent_mm_protocal_c_avf.tAQ = reportTask.iTT;
                aVar.hsm = com_tencent_mm_protocal_c_avf;
                u.a(aVar.BE(), new com.tencent.mm.y.u.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                        if (i == 0 && i2 == 0) {
                            avg com_tencent_mm_protocal_c_avg = (avg) bVar.hsk.hsr;
                            if (com_tencent_mm_protocal_c_avg != null) {
                                b.ag(str, com_tencent_mm_protocal_c_avg.tYM);
                            }
                        }
                        return 0;
                    }
                }, true);
            }
        }
    }

    static final class ReportTask extends MainProcessTask {
        public static final Creator<ReportTask> CREATOR = new Creator<ReportTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ReportTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ReportTask[i];
            }
        };
        String appId;
        String fCO;
        int fWF;
        int fWL;
        int iPk;
        int iRt;
        String iTT;
        int scene;
        String username;

        public final void PM() {
            b.a(this);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.appId);
            parcel.writeString(this.username);
            parcel.writeInt(this.iPk);
            parcel.writeInt(this.fWF);
            parcel.writeInt(this.scene);
            parcel.writeInt(this.fWL);
            parcel.writeString(this.fCO);
            parcel.writeInt(this.iRt);
            parcel.writeString(this.iTT);
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.username = parcel.readString();
            this.iPk = parcel.readInt();
            this.fWF = parcel.readInt();
            this.scene = parcel.readInt();
            this.fWL = parcel.readInt();
            this.fCO = parcel.readString();
            this.iRt = parcel.readInt();
            this.iTT = parcel.readString();
        }

        ReportTask() {
        }

        ReportTask(Parcel parcel) {
            f(parcel);
        }
    }
}
