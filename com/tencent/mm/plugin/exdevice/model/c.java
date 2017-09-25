package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.plugin.exdevice.i.d;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c implements d {
    public static c laT;
    private byte[] gJW = new byte[0];
    private final Map<Integer, Set<d>> htd = new HashMap();
    public m laU;
    a laV = new a(this) {
        final /* synthetic */ d lbi;

        {
            this.lbi = r1;
        }

        public final void apa() {
            if (this.lbi.lba == null) {
                this.lbi.lba = new c();
                this.lbi.lba.lgD = null;
            }
            this.lbi.lba.bT(ab.getContext());
        }
    };
    Vector<ae> laW = new Vector();
    private af laX = new af("ExdeviceHandlerThread");

    public interface a {
        void apa();
    }

    public final boolean a(final ae aeVar) {
        this.laX.D(new Runnable(this) {
            final /* synthetic */ c laY;

            public final void run() {
                boolean z = true;
                Object obj = this.laY;
                ae aeVar = aeVar;
                if (obj.laU == null) {
                    w.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
                    if (obj.laV != null) {
                        w.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
                        obj.laV.apa();
                        new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(obj) {
                            private long hto = 10;
                            final /* synthetic */ c laY;

                            {
                                this.laY = r3;
                            }

                            public final boolean oQ() {
                                if (this.laY.laU == null) {
                                    long j = this.hto;
                                    this.hto = j - 1;
                                    if (j > 0) {
                                        return true;
                                    }
                                }
                                w.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", new Object[]{Long.valueOf(this.hto)});
                                if (this.hto > 0) {
                                    this.laY.aoZ();
                                }
                                return false;
                            }
                        }, true).v(100, 100);
                    } else {
                        w.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
                    }
                    z = false;
                }
                if (z) {
                    aeVar.a(obj.laU, obj);
                } else {
                    obj.laW.add(aeVar);
                }
            }
        });
        return true;
    }

    public final void aoZ() {
        w.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[]{Integer.valueOf(this.laW.size())});
        if (!this.laW.isEmpty()) {
            a((ae) this.laW.remove(0));
        }
    }

    public final void a(long j, int i, int i2, String str) {
        w.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(this.laW.size())});
        synchronized (this.gJW) {
            aoZ();
        }
    }
}
