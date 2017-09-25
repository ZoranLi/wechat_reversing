package com.tencent.mm.plugin.appbrand.dynamic.performance.collector;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TimePoint implements Parcelable {
    public static final Creator<TimePoint> CREATOR = new Creator<TimePoint>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            TimePoint timePoint = new TimePoint();
            timePoint.name = parcel.readString();
            timePoint.time = parcel.readLong();
            timePoint.iIw = parcel.readInt();
            timePoint.iIx = (TimePoint) parcel.readParcelable(TimePoint.class.getClassLoader());
            return timePoint;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TimePoint[i];
        }
    };
    volatile int iIw;
    volatile TimePoint iIx;
    volatile String name;
    volatile long time;

    TimePoint() {
        this.name = "";
        this.time = 0;
    }

    public TimePoint(String str, long j) {
        this.name = str;
        this.time = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.time);
        parcel.writeInt(this.iIw);
        parcel.writeParcelable(this.iIx, i);
    }
}
