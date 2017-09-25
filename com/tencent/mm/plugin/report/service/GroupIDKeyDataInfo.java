package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;

class GroupIDKeyDataInfo implements Parcelable {
    public static final Creator<GroupIDKeyDataInfo> CREATOR = new Creator<GroupIDKeyDataInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GroupIDKeyDataInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GroupIDKeyDataInfo[i];
        }
    };
    ArrayList<IDKey> oTA = new ArrayList();
    public boolean oTB;

    GroupIDKeyDataInfo(ArrayList<IDKey> arrayList, boolean z) {
        this.oTA = arrayList;
        this.oTB = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.oTA);
        parcel.writeInt(this.oTB ? 1 : 0);
    }

    protected GroupIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        parcel.readTypedList(this.oTA, IDKey.CREATOR);
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.oTB = z;
    }
}
