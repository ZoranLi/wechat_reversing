package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.internal.w.a;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.n.c;
import com.google.android.gms.wearable.q;
import com.google.android.gms.wearable.r;
import java.util.List;

final class ap<T> extends a {
    q.a aHH;
    r.a aHI;
    b aHJ;
    k.a aHK;
    n.b aHL;
    c aHM;
    com.google.android.gms.wearable.b.a aHN;
    com.google.android.gms.wearable.a.a aHO;
    final IntentFilter[] aHP;
    final String aHQ;
    final String aHR;

    public final void a(DataHolder dataHolder) {
        if (this.aHJ != null) {
            try {
                this.aHJ.a(new e(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public final void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
    }

    public final void a(AncsNotificationParcelable ancsNotificationParcelable) {
    }

    public final void a(CapabilityInfoParcelable capabilityInfoParcelable) {
    }

    public final void a(ChannelEventParcelable channelEventParcelable) {
        if (this.aHN != null) {
            channelEventParcelable.a(this.aHN);
        }
    }

    public final void a(MessageEventParcelable messageEventParcelable) {
        if (this.aHK != null) {
            this.aHK.a(messageEventParcelable);
        }
    }

    public final void a(NodeParcelable nodeParcelable) {
        if (this.aHL != null) {
            this.aHL.a(nodeParcelable);
        }
    }

    public final void b(NodeParcelable nodeParcelable) {
        if (this.aHL != null) {
            this.aHL.b(nodeParcelable);
        }
    }

    public final void m(List<NodeParcelable> list) {
    }
}
