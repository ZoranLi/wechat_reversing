package com.tencent.mm.plugin.clean.b;

import android.os.Looper;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.clean.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;
import java.util.ArrayList;

public final class e extends Thread implements com.tencent.mm.plugin.clean.b.a.a.a {
    private long endTime = 0;
    private ae hgN = new ae(Looper.getMainLooper());
    private boolean isStop;
    private int kyA = 0;
    private g kyL;
    private ArrayList<a> kyM;
    private int kyN = 0;
    private b kyx;
    private int kyz = 0;
    private long startTime = 0;

    class a extends com.tencent.mm.plugin.clean.b.a.a {
        final /* synthetic */ e kyO;
        private a kyP;

        public a(e eVar, a aVar) {
            this.kyO = eVar;
            super(eVar);
            this.kyP = aVar;
        }

        public final void execute() {
            ap.yY();
            ce cA = c.wT().cA(this.kyP.fEU);
            if (cA.field_msgId != 0) {
                cA.gxI |= 1;
                cA.gtA = true;
                ap.yY();
                c.wT().a(this.kyP.fEU, cA);
            }
            File file = new File(this.kyP.filePath);
            this.kyO.kyN = (int) (((long) this.kyO.kyN) + file.length());
            file.delete();
        }
    }

    public e(b bVar, g gVar, ArrayList<a> arrayList) {
        this.kyx = bVar;
        this.kyL = gVar;
        this.kyM = arrayList;
    }

    public final void run() {
        this.startTime = System.currentTimeMillis();
        this.kyz = this.kyM.size();
        w.d("MicroMsg.DeleteFileController", "totalTaskCount=%d", new Object[]{Integer.valueOf(this.kyz)});
        if (this.kyz == 0) {
            ajG();
            return;
        }
        int i = 0;
        while (!this.isStop && i < this.kyM.size()) {
            w.d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", new Object[]{Integer.valueOf(i), ((a) this.kyM.get(i)).filePath});
            com.tencent.mm.plugin.clean.b.a.a aVar = new a(this, r0);
            while (!this.kyx.b(aVar)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            w.d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", new Object[]{r0.filePath});
            i++;
        }
    }

    private void ajG() {
        this.endTime = System.currentTimeMillis();
        w.i("MicroMsg.DeleteFileController", "totalUserTime:%d", new Object[]{Long.valueOf(this.endTime - this.startTime)});
        if (this.kyL != null && !this.isStop) {
            this.hgN.post(new Runnable(this) {
                final /* synthetic */ e kyO;

                {
                    this.kyO = r1;
                }

                public final void run() {
                    this.kyO.kyL.aR((long) this.kyO.kyN);
                }
            });
        }
    }

    public final void ajR() {
        w.i("MicroMsg.DeleteFileController", "stop analyseController");
        this.isStop = true;
        interrupt();
    }

    public final void a(com.tencent.mm.plugin.clean.b.a.a aVar) {
        interrupt();
        this.kyA++;
        if (!(this.kyL == null || this.isStop)) {
            this.hgN.post(new Runnable(this) {
                final /* synthetic */ e kyO;

                {
                    this.kyO = r1;
                }

                public final void run() {
                    this.kyO.kyL.bM(this.kyO.kyA, this.kyO.kyz);
                }
            });
        }
        if (this.kyA == this.kyz) {
            ajG();
        }
    }
}
