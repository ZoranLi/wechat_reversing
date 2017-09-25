package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.a;
import com.tencent.mm.y.b;

public class IPCRunCgiRespWrapper implements Parcelable {
    public static final Creator<IPCRunCgiRespWrapper> CREATOR = new Creator<IPCRunCgiRespWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IPCRunCgiRespWrapper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCRunCgiRespWrapper[i];
        }
    };
    public int errCode;
    public int errType;
    public String fPf;
    public b gUA;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errType);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.fPf);
        c.a(this.gUA, parcel);
    }

    IPCRunCgiRespWrapper(Parcel parcel) {
        this.errType = parcel.readInt();
        this.errCode = parcel.readInt();
        this.fPf = parcel.readString();
        this.gUA = (b) c.a(a.class.getName(), parcel);
    }

    public static IPCRunCgiRespWrapper ux() {
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
        iPCRunCgiRespWrapper.gUA = null;
        iPCRunCgiRespWrapper.fPf = null;
        iPCRunCgiRespWrapper.errType = 3;
        iPCRunCgiRespWrapper.errCode = -2;
        return iPCRunCgiRespWrapper;
    }
}
