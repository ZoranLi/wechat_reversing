package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.w;

public final class AppBrandOnlineVideoProxy implements b {
    private OnlineVideoProxy iVP;
    private a iVQ;

    private static class OnlineVideoProxy extends MainProcessTask {
        public static final Creator<OnlineVideoProxy> CREATOR = new Creator<OnlineVideoProxy>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OnlineVideoProxy(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OnlineVideoProxy[i];
            }
        };
        final int START = 1;
        final int STOP = 4;
        String hYc;
        final int iVR = 0;
        final int iVS = 2;
        final int iVT = 3;
        int iVU;
        final int iVV = 10;
        final int iVW = 11;
        final int iVX = 12;
        final int iVY = 13;
        int iVZ;
        boolean iWa = false;
        int iWb;
        int iWc;
        a iWd;
        c iWe = new c(this) {
            final /* synthetic */ OnlineVideoProxy iWf;

            {
                this.iWf = r1;
            }

            public final void bj(int i, int i2) {
                this.iWf.iWb = i;
                this.iWf.iWc = i2;
                this.iWf.iVZ = 10;
                this.iWf.SL();
            }

            public final void bk(int i, int i2) {
                this.iWf.iWb = i;
                this.iWf.iWc = i2;
                this.iWf.iVZ = 11;
                this.iWf.SL();
            }

            public final void bl(int i, int i2) {
                this.iWf.iWb = i;
                this.iWf.iWc = i2;
                this.iWf.iVZ = 12;
                this.iWf.SL();
            }

            public final void w(String str, int i) {
                w.i("MicroMsg.AppBrandOnlineVideoProxy", "on finish [%s %d]", new Object[]{str, Integer.valueOf(i)});
                this.iWf.iWb = i;
                this.iWf.iVZ = 13;
                com.tencent.mm.plugin.appbrand.app.c.Qc().nX(this.iWf.hYc);
                this.iWf.SL();
            }
        };
        int length;
        int offset;
        String path;
        String url;

        public OnlineVideoProxy(Parcel parcel) {
            f(parcel);
        }

        public final void SK() {
            w.d("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess cdnMediaId[%s] clientState[%d] [%d %d]", new Object[]{this.hYc, Integer.valueOf(this.iVZ), Integer.valueOf(this.iWb), Integer.valueOf(this.iWc)});
            if (this.iWd != null) {
                switch (this.iVZ) {
                    case 10:
                        this.iWd.gK(this.iWb);
                        break;
                    case 11:
                        this.iWd.onDataAvailable(this.hYc, this.iWb, this.iWc);
                        break;
                    case 12:
                        this.iWd.f(this.hYc, this.iWb, this.iWc);
                        break;
                    case 13:
                        this.iWd.w(this.hYc, this.iWb);
                        break;
                }
                this.iVZ = 0;
                w.i("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess reset clientState[%d] ", new Object[]{Integer.valueOf(this.iVZ)});
            }
        }

        public final void PM() {
            w.d("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess cdnMediaId[%s] state[%d]", new Object[]{this.hYc, Integer.valueOf(this.iVU)});
            String str;
            int i;
            int i2;
            switch (this.iVU) {
                case 1:
                    com.tencent.mm.plugin.appbrand.c.b Qc = com.tencent.mm.plugin.appbrand.app.c.Qc();
                    Qc.iDI.put(this.hYc, this.iWe);
                    Qc = com.tencent.mm.plugin.appbrand.app.c.Qc();
                    w.i("MicroMsg.AppbrandCdnService", "add online video task [%s] url[%s] path[%s]", new Object[]{this.hYc, this.url, this.path});
                    i iVar = new i();
                    iVar.field_mediaId = r1;
                    iVar.field_fullpath = r3;
                    iVar.url = r2;
                    iVar.hzz = Qc.iDJ;
                    iVar.hzt = 1;
                    iVar.hzo = 3;
                    o.KW().a(iVar, false);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.app.c.Qc();
                    str = this.hYc;
                    i = this.offset;
                    i2 = this.length;
                    w.i("MicroMsg.AppbrandCdnService", "request online video task [%s]", new Object[]{str});
                    o.KW();
                    f.e(str, i, i2);
                    break;
                case 3:
                    com.tencent.mm.plugin.appbrand.app.c.Qc();
                    str = this.hYc;
                    i = this.offset;
                    i2 = this.length;
                    w.i("MicroMsg.AppbrandCdnService", "check online video task [%s]", new Object[]{str});
                    this.iWa = o.KW().isVideoDataAvailable(str, i, i2);
                    SL();
                    return;
                case 4:
                    com.tencent.mm.plugin.appbrand.app.c.Qc().nX(this.hYc);
                    com.tencent.mm.plugin.appbrand.app.c.Qc();
                    w.i("MicroMsg.AppbrandCdnService", "cancel online video task [%s]", new Object[]{this.hYc});
                    o.KW().b(str, null);
                    break;
                default:
                    w.w("MicroMsg.AppBrandOnlineVideoProxy", "unknow state ");
                    break;
            }
            this.iVU = 0;
            w.i("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess reset mainState[%d] ", new Object[]{Integer.valueOf(this.iVU)});
            SL();
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.hYc = parcel.readString();
            this.iVU = parcel.readInt();
            this.path = parcel.readString();
            this.url = parcel.readString();
            this.offset = parcel.readInt();
            this.length = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.iWa = z;
            this.iVZ = parcel.readInt();
            this.iWb = parcel.readInt();
            this.iWc = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hYc);
            parcel.writeInt(this.iVU);
            parcel.writeString(this.path);
            parcel.writeString(this.url);
            parcel.writeInt(this.offset);
            parcel.writeInt(this.length);
            parcel.writeInt(this.iWa ? 1 : 0);
            parcel.writeInt(this.iVZ);
            parcel.writeInt(this.iWb);
            parcel.writeInt(this.iWc);
        }
    }

    public final void n(String str, String str2, String str3) {
        w.i("MicroMsg.AppBrandOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[]{Integer.valueOf(hashCode()), str, str2, str3});
        if (this.iVP == null) {
            this.iVP = new OnlineVideoProxy();
            this.iVP.iWd = this.iVQ;
            this.iVP.SM();
        }
        MainProcessTask mainProcessTask = this.iVP;
        w.i("MicroMsg.AppBrandOnlineVideoProxy", "%s OnlineVideoProxy start http stream[%s %s %s] ", new Object[]{Integer.valueOf(mainProcessTask.hashCode()), str, str2, str3});
        mainProcessTask.hYc = str;
        mainProcessTask.path = str2;
        mainProcessTask.url = str3;
        mainProcessTask.iVU = 1;
        AppBrandMainProcessService.a(mainProcessTask);
    }

    public final void lk(String str) {
        w.i("MicroMsg.AppBrandOnlineVideoProxy", "%s stop http stream[%s]", new Object[]{Integer.valueOf(hashCode()), str});
        if (this.iVP != null) {
            this.iVP.iWd = null;
            MainProcessTask mainProcessTask = this.iVP;
            mainProcessTask.iVU = 4;
            AppBrandMainProcessService.a(mainProcessTask);
            this.iVP.SN();
        }
        this.iVP = null;
    }

    public final void g(String str, int i, int i2) {
        w.i("MicroMsg.AppBrandOnlineVideoProxy", "%s requestVideoData [%s, %d %d]", new Object[]{Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.iVP != null) {
            MainProcessTask mainProcessTask = this.iVP;
            mainProcessTask.offset = i;
            mainProcessTask.length = i2;
            mainProcessTask.iVU = 2;
            AppBrandMainProcessService.a(mainProcessTask);
        }
    }

    public final boolean ba(int i, int i2) {
        if (this.iVP == null) {
            return false;
        }
        MainProcessTask mainProcessTask = this.iVP;
        mainProcessTask.offset = i;
        mainProcessTask.length = i2;
        mainProcessTask.iVU = 3;
        AppBrandMainProcessService.b(mainProcessTask);
        return mainProcessTask.iWa;
    }

    public final void a(a aVar) {
        this.iVQ = aVar;
        if (this.iVP != null) {
            this.iVP.iWd = aVar;
        }
    }
}
