package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData implements Parcelable {
    public static final Creator<MultiTalkGroupMemberData> CREATOR = new Creator<MultiTalkGroupMemberData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.wPk = bg.ap(parcel.readString(), "");
            multiTalkGroupMember.wPl = bg.ap(parcel.readString(), "");
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.fOl = parcel.readInt();
            multiTalkGroupMember.wOf = parcel.readInt();
            return new MultiTalkGroupMemberData(multiTalkGroupMember);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMemberData[i];
        }
    };
    MultiTalkGroupMember nOQ;

    public MultiTalkGroupMemberData(MultiTalkGroupMember multiTalkGroupMember) {
        this.nOQ = multiTalkGroupMember;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bg.ap(this.nOQ.wPk, ""));
        parcel.writeString(bg.ap(this.nOQ.wPl, ""));
        parcel.writeInt(this.nOQ.status);
        parcel.writeInt(this.nOQ.fOl);
        parcel.writeInt(this.nOQ.wOf);
    }
}
