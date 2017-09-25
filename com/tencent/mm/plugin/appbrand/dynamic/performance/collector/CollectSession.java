package com.tencent.mm.plugin.appbrand.dynamic.performance.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public class CollectSession implements Parcelable {
    public static final Creator<CollectSession> CREATOR = new Creator<CollectSession>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            CollectSession collectSession = new CollectSession();
            collectSession.groupId = parcel.readString();
            collectSession.id = parcel.readString();
            collectSession.iIn = (TimePoint) parcel.readParcelable(CollectSession.class.getClassLoader());
            collectSession.iIq = parcel.readString();
            Bundle readBundle = parcel.readBundle();
            if (readBundle != null) {
                collectSession.fMb.putAll(readBundle);
            }
            TimePoint timePoint = collectSession.iIn;
            if (timePoint != null) {
                collectSession.iIp.put(timePoint.name, timePoint);
                while (timePoint.iIx != null) {
                    timePoint = timePoint.iIx;
                    collectSession.iIp.put(timePoint.name, timePoint);
                }
                collectSession.iIo = timePoint;
            }
            return collectSession;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CollectSession[i];
        }
    };
    public final Bundle fMb = new Bundle();
    String groupId;
    TimePoint iIn;
    TimePoint iIo;
    final Map<String, TimePoint> iIp = new HashMap();
    String iIq;
    String id;

    CollectSession() {
    }

    public CollectSession(String str) {
        this.id = str;
    }

    public final void oG(String str) {
        Assert.assertNull(this.iIn);
        this.iIn = new TimePoint(str, System.nanoTime());
        this.iIo = this.iIn;
        this.iIn.iIw = 1;
        this.iIp.put(str, this.iIn);
    }

    public final void oH(String str) {
        Assert.assertNotNull(this.iIo);
        long nanoTime = System.nanoTime();
        TimePoint timePoint = (TimePoint) this.iIp.get(str);
        if (timePoint == null) {
            timePoint = new TimePoint(str, nanoTime);
            timePoint.iIw = 1;
            this.iIp.put(str, timePoint);
            this.iIo.iIx = timePoint;
            this.iIo = timePoint;
            return;
        }
        timePoint.time = (nanoTime + (timePoint.time * ((long) timePoint.iIw))) / ((long) (timePoint.iIw + 1));
        timePoint.iIw++;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.iIn, i);
        parcel.writeString(this.iIq);
        parcel.writeBundle(this.fMb);
    }
}
