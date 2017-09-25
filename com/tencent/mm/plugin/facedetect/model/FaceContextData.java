package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import junit.framework.Assert;

public class FaceContextData implements Parcelable {
    public static final Creator<FaceContextData> CREATOR = new Creator<FaceContextData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceContextData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceContextData[i];
        }
    };
    private static FaceContextData lvN = null;
    public long lvO = -1;

    public static void a(FaceContextData faceContextData) {
        if (faceContextData == null) {
            lvN = null;
        } else if (lvN != null) {
            b(faceContextData);
        } else {
            synchronized (FaceContextData.class) {
                if (lvN != null) {
                    b(faceContextData);
                    return;
                }
                lvN = faceContextData;
            }
        }
    }

    private static void b(FaceContextData faceContextData) {
        boolean z = (lvN == null || faceContextData == null) ? false : true;
        Assert.assertTrue(z);
        lvN.lvO = faceContextData.lvO;
    }

    public static synchronized FaceContextData arw() {
        FaceContextData faceContextData;
        synchronized (FaceContextData.class) {
            faceContextData = lvN;
        }
        return faceContextData;
    }

    protected FaceContextData(Parcel parcel) {
        this.lvO = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.lvO);
    }
}
