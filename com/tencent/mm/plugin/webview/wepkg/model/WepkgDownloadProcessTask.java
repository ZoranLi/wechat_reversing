package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class WepkgDownloadProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgDownloadProcessTask> CREATOR = new Creator<WepkgDownloadProcessTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WepkgDownloadProcessTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgDownloadProcessTask[i];
        }
    };
    public String downloadUrl;
    public String fFW;
    public int fileType;
    public String gaF;
    public String iAe;
    public Runnable iMD;
    public String sqw;
    public long sqx;
    public int sqy;
    public RetCode sqz;
    public String version;

    public WepkgDownloadProcessTask(Parcel parcel) {
        f(parcel);
    }

    public final void PM() {
        SM();
        WePkgDownloader.bAv().a(this.fileType, bg.mz(this.gaF), bg.mz(this.sqw), bg.mz(this.downloadUrl), this.sqx, bg.mz(this.version), bg.mz(this.fFW), this.sqy, new IWepkgUpdateCallback(this) {
            final /* synthetic */ WepkgDownloadProcessTask sqA;

            {
                this.sqA = r1;
            }

            public final void a(String str, String str2, RetCode retCode) {
                w.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[]{retCode});
                this.sqA.gaF = str;
                this.sqA.iAe = str2;
                this.sqA.sqz = retCode;
                this.sqA.SN();
                this.sqA.vM();
            }
        });
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public final void k(Parcel parcel) {
        this.fileType = parcel.readInt();
        this.gaF = parcel.readString();
        this.sqw = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.sqx = parcel.readLong();
        this.version = parcel.readString();
        this.fFW = parcel.readString();
        this.sqy = parcel.readInt();
        this.iAe = parcel.readString();
        this.sqz = (RetCode) parcel.readParcelable(RetCode.class.getClassLoader());
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeInt(this.fileType);
        parcel.writeString(this.gaF);
        parcel.writeString(this.sqw);
        parcel.writeString(this.downloadUrl);
        parcel.writeLong(this.sqx);
        parcel.writeString(this.version);
        parcel.writeString(this.fFW);
        parcel.writeInt(this.sqy);
        parcel.writeString(this.iAe);
        parcel.writeParcelable(this.sqz, i);
    }
}
