package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new Creator<ResultReceiver>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };
    public final Handler mHandler = null;
    public final boolean vq = false;
    public a vr;

    class b implements Runnable {
        final /* synthetic */ ResultReceiver vs;
        final int vt;
        final Bundle vu;

        public b(ResultReceiver resultReceiver, int i, Bundle bundle) {
            this.vs = resultReceiver;
            this.vt = i;
            this.vu = bundle;
        }

        public final void run() {
            this.vs.onReceiveResult(this.vt, this.vu);
        }
    }

    class a extends android.support.v4.os.a.a {
        final /* synthetic */ ResultReceiver vs;

        a(ResultReceiver resultReceiver) {
            this.vs = resultReceiver;
        }

        public final void send(int i, Bundle bundle) {
            if (this.vs.mHandler != null) {
                this.vs.mHandler.post(new b(this.vs, i, bundle));
            } else {
                this.vs.onReceiveResult(i, bundle);
            }
        }
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.vr == null) {
                this.vr = new a(this);
            }
            parcel.writeStrongBinder(this.vr.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.vr = android.support.v4.os.a.a.b(parcel.readStrongBinder());
    }
}
