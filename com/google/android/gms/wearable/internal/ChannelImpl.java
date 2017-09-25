package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.internal.ao.AnonymousClass2;
import java.util.concurrent.FutureTask;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new bb();
    final String aFN;
    public final String aGM;
    final String aGN;
    final int mVersionCode;

    class AnonymousClass1 extends aw<Status> {
        final /* synthetic */ Uri aGO;
        final /* synthetic */ boolean aGP = false;
        final /* synthetic */ ChannelImpl aGQ;

        AnonymousClass1(ChannelImpl channelImpl, c cVar, Uri uri, boolean z) {
            this.aGQ = channelImpl;
            this.aGO = uri;
            super(cVar);
        }

        public final /* synthetic */ g b(Status status) {
            return status;
        }

        protected final /* synthetic */ void b(b bVar) {
            ao aoVar = (ao) bVar;
            String str = this.aGQ.aGM;
            Uri uri = this.aGO;
            boolean z = this.aGP;
            try {
                w.Z(this);
                w.Z(str);
                w.Z(uri);
                aoVar.aHu.submit(new FutureTask(new AnonymousClass2(aoVar, uri, this, z, str), null));
            } catch (RuntimeException e) {
                c(new Status(8));
                throw e;
            }
        }
    }

    ChannelImpl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.aGM = (String) w.Z(str);
        this.aFN = (String) w.Z(str2);
        this.aGN = (String) w.Z(str3);
    }

    public final e<Status> a(c cVar, Uri uri) {
        w.h(cVar, "client is null");
        w.h(uri, "uri is null");
        return cVar.b(new AnonymousClass1(this, cVar, uri, false));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.aGM.equals(channelImpl.aGM) && v.d(channelImpl.aFN, this.aFN) && v.d(channelImpl.aGN, this.aGN) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public final String getPath() {
        return this.aGN;
    }

    public int hashCode() {
        return this.aGM.hashCode();
    }

    public final String mB() {
        return this.aFN;
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.aGM + '\'' + ", nodeId='" + this.aFN + '\'' + ", path='" + this.aGN + '\'' + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        bb.a(this, parcel);
    }
}
