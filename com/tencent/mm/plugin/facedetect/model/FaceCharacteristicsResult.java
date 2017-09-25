package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;

public class FaceCharacteristicsResult implements Parcelable {
    public static final Creator<FaceCharacteristicsResult> CREATOR = new Creator<FaceCharacteristicsResult>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceCharacteristicsResult(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceCharacteristicsResult[i];
        }
    };
    public int errCode;
    public String fPf;
    public FaceStatus lvM;

    protected FaceCharacteristicsResult(Parcel parcel) {
        this.errCode = parcel.readInt();
        this.fPf = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.lvM, i);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.fPf);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FaceCharacteristicsResult{mStatus=" + this.lvM + ", errCode=" + this.errCode + ", errMsg='" + this.fPf + '\'' + '}';
    }

    public static boolean mf(int i) {
        return i >= 10 && i < 100;
    }

    public static boolean mg(int i) {
        return i > 0 && i < 10;
    }

    public static boolean mh(int i) {
        return i <= 0;
    }

    public final void P(int i, String str) {
        this.errCode = i;
        this.fPf = str;
    }
}
