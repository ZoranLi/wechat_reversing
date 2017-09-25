package com.tencent.mm.plugin.mmsight.model.a;

import android.os.HandlerThread;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static int nDn = 4;
    static int nDo = 4;
    public ae handler;
    HandlerThread[] nDp;
    int nDq = 0;
    int nDr = 0;
    LinkedList<b> nDs = new LinkedList();
    a nDt;
    boolean nDu = false;
    com.tencent.mm.plugin.mmsight.model.a.b.a nDv = new com.tencent.mm.plugin.mmsight.model.a.b.a(this) {
        final /* synthetic */ a nDw;

        {
            this.nDw = r1;
        }

        public final void a(final b bVar) {
            this.nDw.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 nDy;

                public final void run() {
                    a aVar = this.nDy.nDw;
                    b bVar = bVar;
                    w.i("MicroMsg.ForwardMgr", "receive buf bufIndex: %d receiveIndex: %d", new Object[]{Integer.valueOf(bVar.nDC), Integer.valueOf(aVar.nDr)});
                    if (aVar.nDr == bVar.nDC) {
                        aVar.nDr++;
                        aVar.nDt.output(bVar.nDA);
                        aVar.aKX();
                        return;
                    }
                    aVar.nDs.add(bVar);
                    aVar.aKX();
                }
            });
        }
    };

    public interface a {
        void output(byte[] bArr);
    }

    public a(a aVar) {
        this.nDt = aVar;
        int intValue = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFe, Integer.valueOf(-1))).intValue();
        nDo = intValue;
        if (intValue == -1) {
            nDo = Runtime.getRuntime().availableProcessors();
            nDo = Math.min(nDn, nDo);
            w.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[]{Integer.valueOf(nDo), Integer.valueOf(Runtime.getRuntime().availableProcessors())});
        } else {
            w.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[]{Integer.valueOf(nDo)});
        }
        this.nDp = new HandlerThread[nDo];
        SightVideoJNI.initScaleAndRoateBuffer(nDo);
        for (intValue = 0; intValue < this.nDp.length; intValue++) {
            this.nDp[intValue] = e.cE("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_" + intValue, -1);
            this.nDp[intValue].start();
        }
        this.nDu = false;
    }

    final void aKX() {
        w.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[]{Integer.valueOf(this.nDs.size()), Integer.valueOf(this.nDr)});
        while (this.nDs.size() != 0) {
            int i;
            w.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[]{Integer.valueOf(this.nDs.size()), Integer.valueOf(this.nDr)});
            Iterator it = this.nDs.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.nDr == bVar.nDC) {
                    this.nDr++;
                    this.nDt.output(bVar.nDA);
                    this.nDs.remove(bVar);
                    i = 1;
                    continue;
                    break;
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                return;
            }
        }
    }

    public final boolean aKY() {
        return this.nDr == this.nDq;
    }

    public final void stop() {
        int i = 0;
        w.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[]{bg.bJZ().toString()});
        while (i < this.nDp.length) {
            if (this.nDp[i] != null) {
                this.nDp[i].quit();
                this.nDp[i] = null;
            }
            i++;
        }
        SightVideoJNI.releaseScaleAndRoateBuffer(nDo);
        this.nDu = true;
    }
}
