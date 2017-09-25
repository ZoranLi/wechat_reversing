package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList implements Parcelable {
    public static final Creator<SnsCmdList> CREATOR = new Creator<SnsCmdList>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            int i = 0;
            SnsCmdList snsCmdList = new SnsCmdList();
            snsCmdList.pQN = parcel.readInt();
            snsCmdList.pQP.clear();
            for (int i2 = 0; i2 < snsCmdList.pQN; i2++) {
                snsCmdList.pQP.add(Integer.valueOf(parcel.readInt()));
            }
            snsCmdList.pQO = parcel.readInt();
            snsCmdList.pQQ.clear();
            while (i < snsCmdList.pQO) {
                snsCmdList.pQQ.add(Integer.valueOf(parcel.readInt()));
                i++;
            }
            return snsCmdList;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsCmdList[i];
        }
    };
    public int pQN = 0;
    public int pQO = 0;
    public List<Integer> pQP = new LinkedList();
    public List<Integer> pQQ = new LinkedList();

    public final void sO(int i) {
        this.pQP.add(Integer.valueOf(i));
    }

    public final void sP(int i) {
        this.pQQ.add(Integer.valueOf(i));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        this.pQN = this.pQP.size();
        parcel.writeInt(this.pQN);
        for (int i3 = 0; i3 < this.pQN; i3++) {
            parcel.writeInt(((Integer) this.pQP.get(i3)).intValue());
        }
        this.pQO = this.pQQ.size();
        parcel.writeInt(this.pQO);
        while (i2 < this.pQO) {
            parcel.writeInt(((Integer) this.pQQ.get(i2)).intValue());
            i2++;
        }
    }
}
