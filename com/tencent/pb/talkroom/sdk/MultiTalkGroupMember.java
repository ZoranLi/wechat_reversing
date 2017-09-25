package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember implements Parcelable {
    public static final Creator<MultiTalkGroupMember> CREATOR = new Creator<MultiTalkGroupMember>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.wPk = parcel.readString();
            multiTalkGroupMember.wPl = parcel.readString();
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.fOl = parcel.readInt();
            multiTalkGroupMember.wOf = parcel.readInt();
            return multiTalkGroupMember;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMember[i];
        }
    };
    public int fOl;
    public int status;
    public int wOf;
    public String wPk = "";
    public String wPl = "";

    public String toString() {
        return "MultiTalkGroupMember [usrName=" + this.wPk + ", inviteUsrName=" + this.wPl + ", status=" + this.status + ", reason=" + this.fOl + ", inviteTime=" + this.wOf + "]";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.wPk == null ? "" : this.wPk);
        parcel.writeString(this.wPl == null ? "" : this.wPl);
        parcel.writeInt(this.status);
        parcel.writeInt(this.fOl);
        parcel.writeInt(this.wOf);
    }
}
