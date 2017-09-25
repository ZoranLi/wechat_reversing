package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.pb.common.c.d;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkGroup implements Parcelable {
    public static final Creator<MultiTalkGroup> CREATOR = new Creator<MultiTalkGroup>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.wPf = parcel.readString();
            multiTalkGroup.wPg = parcel.readString();
            multiTalkGroup.wPh = parcel.readString();
            multiTalkGroup.wLa = parcel.readInt();
            multiTalkGroup.wPi = parcel.readString();
            int readInt = parcel.readInt();
            multiTalkGroup.wPj = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) parcel.readParcelable(MultiTalkGroupMember.class.getClassLoader());
                if (multiTalkGroupMember != null) {
                    multiTalkGroup.wPj.add(multiTalkGroupMember);
                } else {
                    d.d("MultiTalkGroup", "CLTNOT readParcelable member = null");
                }
            }
            return multiTalkGroup;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroup[i];
        }
    };
    public int wLa;
    public String wPf = "";
    public String wPg = "";
    public String wPh = "";
    public String wPi = "";
    public List<MultiTalkGroupMember> wPj = new ArrayList();

    public String toString() {
        return "MultiTalkGroup [mMultiTalkGroupId=" + this.wPf + ", mMultiTalkClientGroupId=" + this.wPg + ", mWxGroupId=" + this.wPh + ", mRouteId=" + this.wLa + ", mCreatorUsrName=" + this.wPi + ", mMultiTalkGroupMemberList=" + this.wPj + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.wPf == null ? "" : this.wPf);
        parcel.writeString(this.wPg == null ? "" : this.wPg);
        parcel.writeString(this.wPh == null ? "" : this.wPh);
        parcel.writeInt(this.wLa);
        parcel.writeString(this.wPi == null ? "" : this.wPi);
        int size = this.wPj == null ? 0 : this.wPj.size();
        parcel.writeInt(size);
        while (i2 < size) {
            parcel.writeParcelable((MultiTalkGroupMember) this.wPj.get(i2), i);
            i2++;
        }
    }

    public int describeContents() {
        return 0;
    }
}
