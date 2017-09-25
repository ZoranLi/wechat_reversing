package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryStatusItem> CREATOR = new Creator<RecoveryStatusItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
            recoveryStatusItem.processName = parcel.readString();
            recoveryStatusItem.mry = parcel.readString();
            recoveryStatusItem.clientVersion = parcel.readString();
            recoveryStatusItem.wQd = parcel.readInt();
            recoveryStatusItem.wQg = parcel.readInt();
            recoveryStatusItem.wQf = parcel.readInt();
            recoveryStatusItem.timestamp = parcel.readLong();
            return recoveryStatusItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryStatusItem[i];
        }
    };
    public String clientVersion;
    public String mry;
    public String processName;
    public long timestamp;
    public int wQd;
    public int wQf;
    public int wQg;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.processName);
        parcel.writeString(this.mry);
        parcel.writeString(this.clientVersion);
        parcel.writeInt(this.wQd);
        parcel.writeInt(this.wQg);
        parcel.writeInt(this.wQf);
        parcel.writeLong(this.timestamp);
    }

    public final boolean UY(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.processName = split[0];
            this.mry = split[1];
            this.clientVersion = split[2];
            this.wQd = Integer.valueOf(split[3]).intValue();
            this.wQg = Integer.valueOf(split[4]).intValue();
            this.wQf = Integer.valueOf(split[5]).intValue();
            this.timestamp = Long.valueOf(split[6]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final String cdz() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.mry);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.wQd);
        stringBuffer.append(",");
        stringBuffer.append(this.wQg);
        stringBuffer.append(",");
        stringBuffer.append(this.wQf);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }
}
