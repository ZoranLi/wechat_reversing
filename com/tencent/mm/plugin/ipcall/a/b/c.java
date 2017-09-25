package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public boolean fOV;
    public boolean kmK;
    public com.tencent.mm.c.b.c mOJ;
    public final Object mOK;
    public int mOL;
    boolean mOM;
    int mON;
    public boolean mOO;
    com.tencent.mm.c.b.c.a mOP;

    private class a implements Runnable {
        final /* synthetic */ c mOQ;
        private com.tencent.mm.c.b.c mOR = null;

        public a(c cVar, com.tencent.mm.c.b.c cVar2) {
            this.mOQ = cVar;
            this.mOR = cVar2;
        }

        public final void run() {
            w.d("MicroMsg.IPCallRecorder", "do stopRecord");
            if (this.mOR != null) {
                this.mOR.oX();
                this.mOR = null;
                c cVar = this.mOQ;
                cVar.mOL = 92;
                cVar.mOM = true;
                cVar.mON = 0;
            }
        }
    }

    public c() {
        this.mOJ = null;
        this.mOK = new Object();
        this.fOV = false;
        this.kmK = false;
        this.mOL = 92;
        this.mOM = true;
        this.mON = 0;
        this.mOO = true;
        this.mOP = new com.tencent.mm.c.b.c.a(this) {
            final /* synthetic */ c mOQ;

            {
                this.mOQ = r1;
            }

            public final void d(byte[] bArr, int i) {
                int i2 = 0;
                synchronized (this.mOQ.mOK) {
                    int boY;
                    c cVar = this.mOQ;
                    if (cVar.mOL <= 10) {
                        cVar.mOL = 92;
                    }
                    a aVar = i.aEk().mOz;
                    if (aVar.mOt != null) {
                        boY = aVar.mOt.boY();
                    } else {
                        boY = 0;
                    }
                    cVar.mOL = ((boY + 24) + (cVar.mOL * 3)) / 4;
                    if (cVar.mOM) {
                        w.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
                        aVar = i.aEk().mOz;
                        if (aVar.mOt != null) {
                            i2 = aVar.mOt.boV();
                        }
                        cVar.mON = i2;
                        if (cVar.mON >= cVar.mOL) {
                            cVar.mON -= cVar.mOL;
                        }
                        cVar.mOL = cVar.mON;
                        cVar.mOM = false;
                    } else {
                        cVar.mOL = 0;
                    }
                    if (i.aEl().mMN == 5) {
                        if (this.mOQ.mOO) {
                            w.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                            this.mOQ.mOO = false;
                        }
                        i.aEi().mOV.recordCallback(bArr, i, this.mOQ.mOL);
                    }
                }
            }

            public final void ax(int i, int i2) {
            }
        };
        this.fOV = false;
    }

    public final void bQ(boolean z) {
        w.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[]{Boolean.valueOf(z)});
        if (this.fOV && this.mOJ != null) {
            this.mOJ.au(z);
        }
        this.kmK = z;
    }
}
