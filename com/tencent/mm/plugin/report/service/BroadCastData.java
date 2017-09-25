package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

class BroadCastData implements Parcelable {
    public static final Creator<BroadCastData> CREATOR = new Creator<BroadCastData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BroadCastData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BroadCastData[i];
        }
    };
    ArrayList<KVReportDataInfo> oTx = new ArrayList();
    ArrayList<StIDKeyDataInfo> oTy = new ArrayList();
    ArrayList<GroupIDKeyDataInfo> oTz = new ArrayList();

    public BroadCastData(BroadCastData broadCastData) {
        if (broadCastData != null) {
            this.oTx = new ArrayList(broadCastData.oTx);
            this.oTy = new ArrayList(broadCastData.oTy);
            this.oTz = new ArrayList(broadCastData.oTz);
        }
    }

    protected BroadCastData(Parcel parcel) {
        parcel.readTypedList(this.oTx, KVReportDataInfo.CREATOR);
        parcel.readTypedList(this.oTy, StIDKeyDataInfo.CREATOR);
        parcel.readTypedList(this.oTz, GroupIDKeyDataInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.oTx);
        parcel.writeTypedList(this.oTy);
        parcel.writeTypedList(this.oTz);
    }
}
