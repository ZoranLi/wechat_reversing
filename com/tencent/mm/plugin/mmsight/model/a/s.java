package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mm.plugin.mmsight.model.a.d.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public final class s {
    public c nGc = c.Stop;
    public SparseArray<WeakReference<b>> nGd = new SparseArray();
    private ae nGe = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ s nGf;

        public final void handleMessage(Message message) {
            if (257 == message.what) {
                c cVar = (c) message.obj;
                for (int i = 0; i < this.nGf.nGd.size(); i++) {
                    if (((b) ((WeakReference) this.nGf.nGd.valueAt(i)).get()) != null) {
                        int[] iArr = AnonymousClass2.nGg;
                        cVar.ordinal();
                    }
                }
            } else if (258 == message.what) {
                r0 = (b) message.obj;
                if (r0 != null) {
                    this.nGf.nGd.put(r0.hashCode(), new WeakReference(r0));
                }
            } else if (259 == message.what) {
                r0 = (b) message.obj;
                if (r0 != null) {
                    this.nGf.nGd.remove(r0.hashCode());
                }
            }
        }
    };

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] nGg = new int[c.values().length];

        static {
            try {
                nGg[c.Start.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nGg[c.Stop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nGg[c.Sent.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nGg[c.Error.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(c cVar) {
        w.i("MicroMsg.SightMediaStatusHandler", "status change to %s", new Object[]{cVar.toString()});
        this.nGc = cVar;
        this.nGe.sendMessage(this.nGe.obtainMessage(257, cVar));
    }
}
