package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.b.a;

public final class ChannelEventParcelable implements SafeParcelable {
    public static final Creator<ChannelEventParcelable> CREATOR = new ba();
    final ChannelImpl aGJ;
    final int aGK;
    final int aGL;
    final int mVersionCode;
    final int type;

    ChannelEventParcelable(int i, ChannelImpl channelImpl, int i2, int i3, int i4) {
        this.mVersionCode = i;
        this.aGJ = channelImpl;
        this.type = i2;
        this.aGK = i3;
        this.aGL = i4;
    }

    public final void a(a aVar) {
        switch (this.type) {
            case 1:
                aVar.a(this.aGJ);
                return;
            case 2:
                aVar.a(this.aGJ, this.aGK, this.aGL);
                return;
            case 3:
                aVar.b(this.aGJ, this.aGK, this.aGL);
                return;
            case 4:
                aVar.c(this.aGJ, this.aGK, this.aGL);
                return;
            default:
                new StringBuilder("Unknown type: ").append(this.type);
                return;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder("ChannelEventParcelable[versionCode=").append(this.mVersionCode).append(", channel=").append(this.aGJ).append(", type=");
        int i = this.type;
        switch (i) {
            case 1:
                str = "CHANNEL_OPENED";
                break;
            case 2:
                str = "CHANNEL_CLOSED";
                break;
            case 3:
                str = "INPUT_CLOSED";
                break;
            case 4:
                str = "OUTPUT_CLOSED";
                break;
            default:
                str = Integer.toString(i);
                break;
        }
        append = append.append(str).append(", closeReason=");
        i = this.aGK;
        switch (i) {
            case 0:
                str = "CLOSE_REASON_NORMAL";
                break;
            case 1:
                str = "CLOSE_REASON_DISCONNECTED";
                break;
            case 2:
                str = "CLOSE_REASON_REMOTE_CLOSE";
                break;
            case 3:
                str = "CLOSE_REASON_LOCAL_CLOSE";
                break;
            default:
                str = Integer.toString(i);
                break;
        }
        return append.append(str).append(", appErrorCode=").append(this.aGL).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ba.a(this, parcel, i);
    }
}
