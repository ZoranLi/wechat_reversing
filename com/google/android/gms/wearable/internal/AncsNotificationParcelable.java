package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AncsNotificationParcelable implements SafeParcelable {
    public static final Creator<AncsNotificationParcelable> CREATOR = new av();
    final String aAU;
    String aDg;
    final String aGA;
    final String aGB;
    final String aGC;
    byte aGD;
    byte aGE;
    byte aGF;
    byte aGG;
    final String aGz;
    int dX;
    final int mVersionCode;

    AncsNotificationParcelable(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.dX = i2;
        this.mVersionCode = i;
        this.aAU = str;
        this.aGz = str2;
        this.aGA = str3;
        this.aGB = str4;
        this.aGC = str5;
        this.aDg = str6;
        this.aGD = b;
        this.aGE = b2;
        this.aGF = b3;
        this.aGG = b4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) obj;
        return this.aGG != ancsNotificationParcelable.aGG ? false : this.aGF != ancsNotificationParcelable.aGF ? false : this.aGE != ancsNotificationParcelable.aGE ? false : this.aGD != ancsNotificationParcelable.aGD ? false : this.dX != ancsNotificationParcelable.dX ? false : this.mVersionCode != ancsNotificationParcelable.mVersionCode ? false : !this.aAU.equals(ancsNotificationParcelable.aAU) ? false : (this.aGz == null ? ancsNotificationParcelable.aGz != null : !this.aGz.equals(ancsNotificationParcelable.aGz)) ? false : !this.aDg.equals(ancsNotificationParcelable.aDg) ? false : !this.aGA.equals(ancsNotificationParcelable.aGA) ? false : !this.aGC.equals(ancsNotificationParcelable.aGC) ? false : this.aGB.equals(ancsNotificationParcelable.aGB);
    }

    public int hashCode() {
        return (((((((((((((((((this.aGz != null ? this.aGz.hashCode() : 0) + (((((this.mVersionCode * 31) + this.dX) * 31) + this.aAU.hashCode()) * 31)) * 31) + this.aGA.hashCode()) * 31) + this.aGB.hashCode()) * 31) + this.aGC.hashCode()) * 31) + this.aDg.hashCode()) * 31) + this.aGD) * 31) + this.aGE) * 31) + this.aGF) * 31) + this.aGG;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.dX + ", mAppId='" + this.aAU + '\'' + ", mDateTime='" + this.aGz + '\'' + ", mNotificationText='" + this.aGA + '\'' + ", mTitle='" + this.aGB + '\'' + ", mSubtitle='" + this.aGC + '\'' + ", mDisplayName='" + this.aDg + '\'' + ", mEventId=" + this.aGD + ", mEventFlags=" + this.aGE + ", mCategoryId=" + this.aGF + ", mCategoryCount=" + this.aGG + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        av.a(this, parcel);
    }
}
