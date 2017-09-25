package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.w;

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Location location = new Location();
            location.hCP = parcel.readFloat();
            location.hCQ = parcel.readFloat();
            location.accuracy = parcel.readInt();
            location.fPH = parcel.readInt();
            location.mac = parcel.readString();
            location.fPJ = parcel.readString();
            return location;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Location[i];
        }
    };
    public int accuracy;
    public int fPH;
    public String fPJ;
    public float hCP;
    public float hCQ;
    public String mac;

    public Location(float f, float f2, int i, int i2, String str, String str2) {
        this.hCP = f;
        this.hCQ = f2;
        this.accuracy = i;
        this.fPH = i2;
        this.mac = str;
        this.fPJ = str2;
    }

    public final boolean bDo() {
        if (this.hCP != -85.0f && this.hCQ != -1000.0f) {
            return false;
        }
        w.d("MicroMsg.Radar.Location", "mac and cellId is null");
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.hCP);
        parcel.writeFloat(this.hCQ);
        parcel.writeInt(this.accuracy);
        parcel.writeInt(this.fPH);
        parcel.writeString(this.mac);
        parcel.writeString(this.fPJ);
    }
}
