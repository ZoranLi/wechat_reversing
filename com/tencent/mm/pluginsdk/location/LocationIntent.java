package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.sdk.platformtools.bg;

public class LocationIntent implements Parcelable {
    public static final Creator<LocationIntent> CREATOR = new Creator<LocationIntent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            LocationIntent locationIntent = new LocationIntent();
            locationIntent.lat = parcel.readDouble();
            locationIntent.lng = parcel.readDouble();
            locationIntent.fOd = parcel.readInt();
            locationIntent.label = parcel.readString();
            locationIntent.ndv = bg.ap(parcel.readString(), "");
            locationIntent.sBQ = bg.ap(parcel.readString(), "");
            locationIntent.naS = bg.ap(parcel.readString(), "");
            locationIntent.sBR = parcel.readInt();
            locationIntent.hCX = (Addr) parcel.readParcelable(Addr.class.getClassLoader());
            return locationIntent;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationIntent[i];
        }
    };
    public int fOd = 0;
    public Addr hCX = null;
    public String label = "";
    public double lat;
    public double lng;
    public String naS;
    public String ndv = "";
    public String sBQ = "";
    public int sBR = 0;

    public final String bmG() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lat " + this.lat + ";");
        stringBuffer.append("lng " + this.lng + ";");
        stringBuffer.append("scale " + this.fOd + ";");
        stringBuffer.append("label " + this.label + ";");
        stringBuffer.append("poiname " + this.ndv + ";");
        stringBuffer.append("infourl " + this.sBQ + ";");
        stringBuffer.append("locTypeId " + this.naS + ";");
        stringBuffer.append("poiType " + this.sBR + ";");
        if (this.hCX != null) {
            stringBuffer.append("addr " + this.hCX.toString() + ";");
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeInt(this.fOd);
        parcel.writeString(this.label);
        parcel.writeString(this.ndv);
        parcel.writeString(this.sBQ);
        parcel.writeString(this.naS);
        parcel.writeInt(this.sBR);
        parcel.writeParcelable(this.hCX, i);
    }
}
