package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;

public class MultiTalkGroupData implements Parcelable {
    public static final Creator<MultiTalkGroupData> CREATOR = new Creator<MultiTalkGroupData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.wPf = bg.ap(parcel.readString(), "");
            multiTalkGroup.wPg = bg.ap(parcel.readString(), "");
            multiTalkGroup.wPh = bg.ap(parcel.readString(), "");
            multiTalkGroup.wLa = parcel.readInt();
            multiTalkGroup.wPi = bg.ap(parcel.readString(), "");
            int readInt = parcel.readInt();
            multiTalkGroup.wPj = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                multiTalkGroup.wPj.add(((MultiTalkGroupMemberData) parcel.readParcelable(MultiTalkGroupMemberData.class.getClassLoader())).nOQ);
            }
            return new MultiTalkGroupData(multiTalkGroup);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupData[i];
        }
    };
    private MultiTalkGroup nOP;

    public MultiTalkGroupData(MultiTalkGroup multiTalkGroup) {
        this.nOP = multiTalkGroup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bg.ap(this.nOP.wPf, ""));
        parcel.writeString(bg.ap(this.nOP.wPg, ""));
        parcel.writeString(bg.ap(this.nOP.wPh, ""));
        parcel.writeInt(this.nOP.wLa);
        parcel.writeString(bg.ap(this.nOP.wPi, ""));
        parcel.writeInt(this.nOP.wPj.size());
        for (int i2 = 0; i2 < this.nOP.wPj.size(); i2++) {
            parcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember) this.nOP.wPj.get(i2)), i);
        }
    }
}
