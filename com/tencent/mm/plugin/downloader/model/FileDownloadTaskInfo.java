package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FileDownloadTaskInfo implements Parcelable {
    public static Creator<FileDownloadTaskInfo> CREATOR = new Creator<FileDownloadTaskInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FileDownloadTaskInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FileDownloadTaskInfo[0];
        }
    };
    public String appId = "";
    public String fFW = "";
    public int fLG = 2;
    public long fLg = 0;
    public long fLh = 0;
    public long id = -1;
    public boolean kHg = false;
    public String path = "";
    public int status = 0;
    public String url = "";

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.url);
        parcel.writeInt(this.status);
        parcel.writeString(this.path);
        parcel.writeString(this.fFW);
        parcel.writeString(this.appId);
        parcel.writeLong(this.fLg);
        parcel.writeLong(this.fLh);
        parcel.writeByte((byte) (this.kHg ? 1 : 0));
        parcel.writeInt(this.fLG);
    }

    public FileDownloadTaskInfo(Parcel parcel) {
        boolean z = true;
        this.id = parcel.readLong();
        this.url = parcel.readString();
        this.status = parcel.readInt();
        this.path = parcel.readString();
        this.fFW = parcel.readString();
        this.appId = parcel.readString();
        this.fLg = parcel.readLong();
        this.fLh = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.kHg = z;
        this.fLG = parcel.readInt();
    }
}
