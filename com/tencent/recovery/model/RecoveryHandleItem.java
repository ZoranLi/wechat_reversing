package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryHandleItem> CREATOR = new Creator<RecoveryHandleItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
            recoveryHandleItem.mry = parcel.readString();
            recoveryHandleItem.clientVersion = parcel.readString();
            recoveryHandleItem.arH = parcel.readString();
            recoveryHandleItem.processName = parcel.readString();
            recoveryHandleItem.wQs = parcel.readString();
            recoveryHandleItem.timestamp = parcel.readLong();
            return recoveryHandleItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryHandleItem[i];
        }
    };
    public String arH;
    public String clientVersion;
    public String mry;
    public String processName;
    public long timestamp;
    public String wQs;

    public final String cdz() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.mry);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.arH);
        stringBuffer.append(",");
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.wQs);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }

    public final boolean UY(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.mry = split[0];
            this.clientVersion = split[1];
            this.arH = split[2];
            this.processName = split[3];
            this.wQs = split[4];
            this.timestamp = Long.valueOf(split[5]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mry);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.arH);
        parcel.writeString(this.processName);
        parcel.writeString(this.wQs);
        parcel.writeLong(this.timestamp);
    }
}
