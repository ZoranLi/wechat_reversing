package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.gk;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public class DoDownloadTask extends GWMainProcessTask {
    public static Creator<DoDownloadTask> CREATOR = new Creator<DoDownloadTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DoDownloadTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DoDownloadTask[i];
        }
    };
    public String appId;
    public String extInfo;
    public long fCw;
    public String fFW;
    public boolean fFj;
    public String mjV;
    public String mjW;
    public String mjX;
    public long mjY;
    public String packageName;
    public int scene;
    public int type;
    public String url;

    public final void PM() {
        boolean z = false;
        boolean z2 = true;
        w.i("MicroMsg.AddDownloadTask", "doDownloadTask, type = " + this.type);
        switch (this.type) {
            case 1:
                w.i("MicroMsg.AddDownloadTask", "addDownloadTask");
                b gkVar = new gk();
                gkVar.fLI.url = this.url;
                gkVar.fLI.fFW = this.fFW;
                gkVar.fLI.extInfo = this.extInfo;
                gkVar.fLI.appId = this.appId;
                gkVar.fLI.scene = this.scene;
                a.urY.m(gkVar);
                f.a aVar = new f.a();
                aVar.tL(this.url);
                aVar.tM(this.mjW);
                aVar.be(this.mjY);
                aVar.tN(this.mjV);
                aVar.tO(this.fFW);
                aVar.setAppId(this.appId);
                aVar.bl(this.packageName);
                aVar.dn(true);
                aVar.la(bg.getInt(this.mjX, 1));
                aVar.kc(this.scene);
                this.fCw = e.akM().a(aVar.kHa);
                return;
            case 2:
                w.i("MicroMsg.AddDownloadTask", af.NAME);
                z = e.akM().aV(this.fCw);
                break;
            case 3:
                w.i("MicroMsg.AddDownloadTask", ak.NAME);
                com.tencent.mm.plugin.downloader.b.a ba = d.ba(this.fCw);
                if (ba != null) {
                    ba.field_scene = this.scene;
                    d.b(ba);
                }
                z = e.akM().aW(this.fCw);
                break;
            case 4:
                w.i("MicroMsg.AddDownloadTask", f.NAME);
                if (e.akM().aT(this.fCw) <= 0) {
                    z2 = false;
                }
                this.fFj = z2;
                return;
            case 5:
                w.i("MicroMsg.AddDownloadTask", f.NAME);
                FileDownloadTaskInfo aU = e.akM().aU(this.fCw);
                if (aU.status != -1) {
                    if (aU.status == 3) {
                        if (com.tencent.mm.a.e.aO(aU.path)) {
                            z = q.e(ab.getContext(), Uri.fromFile(new File(aU.path)));
                            break;
                        }
                    }
                    w.e("MicroMsg.AddDownloadTask", "installDownloadTask fail, invalid status = " + aU.status);
                    break;
                }
                w.e("MicroMsg.AddDownloadTask", "installDownloadTask fail, apilevel not supported");
                break;
                break;
            default:
                return;
        }
        this.fFj = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.mjV);
        parcel.writeString(this.url);
        parcel.writeString(this.mjW);
        parcel.writeString(this.fFW);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.mjX);
        parcel.writeString(this.appId);
        parcel.writeString(this.packageName);
        parcel.writeLong(this.mjY);
        parcel.writeInt(this.scene);
        parcel.writeLong(this.fCw);
        parcel.writeByte((byte) (this.fFj ? 1 : 0));
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.type = parcel.readInt();
        this.mjV = parcel.readString();
        this.url = parcel.readString();
        this.mjW = parcel.readString();
        this.fFW = parcel.readString();
        this.extInfo = parcel.readString();
        this.mjX = parcel.readString();
        this.appId = parcel.readString();
        this.packageName = parcel.readString();
        this.mjY = parcel.readLong();
        this.scene = parcel.readInt();
        this.fCw = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.fFj = z;
    }

    public DoDownloadTask(Parcel parcel) {
        f(parcel);
    }
}
