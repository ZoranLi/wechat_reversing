package com.tencent.mm.plugin.multitalk.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;

public final class j {
    public ae nPW;
    public a nPX = new a(this);
    public a nPt;

    private class a {
        public int angle;
        public int h;
        public boolean lre;
        public Bitmap mhk;
        final /* synthetic */ j nPY;
        public int nPZ;
        public int nQa;
        public int[] nQb;
        public int w;

        public a(j jVar) {
            this.nPY = jVar;
        }
    }

    public class b implements Runnable {
        final /* synthetic */ j nPY;

        public b(j jVar) {
            this.nPY = jVar;
        }

        public final void run() {
            this.nPY.nPX.lre = true;
            if (this.nPY.nPX.mhk != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.nPY.nPt != null) {
                    this.nPY.nPt.a(m.xL(), this.nPY.nPX.mhk, this.nPY.nPX.nQa, this.nPY.nPX.angle);
                }
                if (System.currentTimeMillis() - currentTimeMillis > 30) {
                    w.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
                this.nPY.nPX.lre = false;
            }
            try {
                Thread.sleep(20);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MT.MultiTalkVideoNativeReceiver", e, "", new Object[0]);
            }
        }
    }

    public j(a aVar) {
        this.nPt = aVar;
    }
}
