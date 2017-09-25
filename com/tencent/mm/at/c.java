package com.tencent.mm.at;

import com.tencent.map.a.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c implements a, e {
    private float fOb;
    private float fPF;
    private int fPG;
    private int fPH;
    private String fPI;
    private String fPJ;
    public a hQT;
    public byte[] hQU;
    private aj hQV;
    private int hQW;
    public Object lock = new Object();
    private int scene;

    public c(float f, float f2, int i, int i2, String str, String str2, int i3, int i4) {
        h.vJ();
        this.hQV = new aj(h.vL().nJF.getLooper(), new aj.a(this) {
            final /* synthetic */ c hQX;

            {
                this.hQX = r1;
            }

            public final boolean oQ() {
                w.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
                if (this.hQX.hQT != null) {
                    h.vH().gXC.c(this.hQX.hQT);
                }
                this.hQX.hQT = null;
                this.hQX.hQU = null;
                synchronized (this.hQX.lock) {
                    this.hQX.lock.notifyAll();
                }
                return false;
            }
        }, false);
        this.fPF = f;
        this.fOb = f2;
        this.fPG = i;
        this.fPH = i2;
        this.fPI = str;
        this.fPJ = str2;
        this.hQW = i3;
        this.scene = i4;
        h.vH().gXC.a(752, (e) this);
    }

    public final void finish() {
        this.hQV.KH();
        if (this.hQT != null) {
            h.vH().gXC.c(this.hQT);
        }
        this.hQT = null;
        this.hQU = null;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        h.vH().gXC.b(752, (e) this);
    }

    public final byte[] m(byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            w.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : " + str);
            this.hQU = null;
            this.hQT = new a(this.fPF, this.fOb, this.fPG, this.fPH, this.fPI, this.fPJ, this.hQW, this.scene, str);
            h.vH().gXC.a(this.hQT, 0);
            this.hQV.v(60000, 60000);
            synchronized (this.lock) {
                this.lock.wait();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
            w.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + e.toString());
        }
        w.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", Boolean.valueOf(bg.bm(this.hQU)));
        return this.hQU;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.hQV.KH();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof a) {
                String ap = bg.ap(((a) kVar).hQt, "");
                w.d("MicroMsg.SenseWhereHttpUtil", "senseWhereResp: " + ap);
                try {
                    this.hQU = ap.getBytes("UTF-8");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
                    w.e("MicroMsg.SenseWhereHttpUtil", "string to byte[] error. " + e.toString());
                }
            } else {
                this.hQU = null;
            }
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        } else {
            w.w("MicroMsg.SenseWhereHttpUtil", "upload sense where info error. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            this.hQU = null;
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
            b.IA().IC();
            g.oUh.a(345, 4, 1, false);
        }
        this.hQT = null;
    }
}
