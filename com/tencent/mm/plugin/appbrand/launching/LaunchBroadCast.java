package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class LaunchBroadCast implements Parcelable {
    public static final Creator<LaunchBroadCast> CREATOR = new Creator<LaunchBroadCast>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LaunchBroadCast(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchBroadCast[i];
        }
    };
    public String appId;
    public boolean fYp;
    public int iPk;
    public int iZz;
    public String username;

    static void a(String str, int i, int i2, boolean z) {
        Parcelable launchBroadCast = new LaunchBroadCast();
        launchBroadCast.username = null;
        launchBroadCast.appId = str;
        launchBroadCast.iPk = i;
        launchBroadCast.iZz = i2;
        launchBroadCast.fYp = z;
        d.a(launchBroadCast);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iPk);
        parcel.writeInt(this.iZz);
        parcel.writeByte(this.fYp ? (byte) 1 : (byte) 0);
    }

    private LaunchBroadCast() {
    }

    public LaunchBroadCast(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.iPk = parcel.readInt();
        this.iZz = parcel.readInt();
        this.fYp = parcel.readByte() != (byte) 0;
    }
}
