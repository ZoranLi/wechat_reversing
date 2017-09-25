package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagList implements Parcelable {
    public static final Creator<SnsTagList> CREATOR = new Creator<SnsTagList>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            SnsTagList snsTagList = new SnsTagList();
            snsTagList.pQV = parcel.readInt();
            for (int i = 0; i < snsTagList.pQV; i++) {
                snsTagList.pQW.add(Long.valueOf(parcel.readLong()));
            }
            return snsTagList;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsTagList[i];
        }
    };
    public int pQV = 0;
    public List<Long> pQW = new LinkedList();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        this.pQV = this.pQW.size();
        parcel.writeInt(this.pQV);
        for (Long longValue : this.pQW) {
            parcel.writeLong(longValue.longValue());
        }
    }
}
