package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.e;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.w;

public final class f extends ae {
    private int jUO;
    private a lhA;
    private e lhz;

    public f(int i, long j, int i2, int i3, byte[] bArr) {
        this.lhz = new e(j, i2, i3, bArr);
        this.jUO = i;
    }

    public final boolean a(m mVar, d dVar) {
        if (!u.apU().bz(this.lhz.jUL)) {
            w.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[]{Long.valueOf(this.lhz.jUL)});
            this.lhz.a(-2, "", new byte[0], new byte[0], 0, 0);
            this.lhA = new a(this.lhz, dVar);
            w.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.lhA.b(mVar))});
            return this.lhA.b(mVar);
        } else if (-5 == this.jUO || -3 == this.jUO || -4 == this.jUO) {
            w.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(this.jUO)});
            this.lhz.a(-1, "", new byte[0], new byte[0], 0, 0);
            this.lhA = new a(this.lhz, dVar);
            w.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.lhA.b(mVar))});
            return this.lhA.b(mVar);
        } else {
            com.tencent.mm.plugin.exdevice.e.f fVar = (com.tencent.mm.plugin.exdevice.e.f) this.lhz.aoS();
            if (fVar == null) {
                w.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
                this.lhz.a(-4, "", new byte[0], new byte[0], 0, 0);
                this.lhA = new a(this.lhz, dVar);
                w.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.lhA.b(mVar))});
                return this.lhA.b(mVar);
            }
            byte[] toByteArray;
            byte[] toByteArray2;
            if (fVar.leU != null) {
                toByteArray = fVar.leU.toByteArray();
            } else {
                toByteArray = null;
            }
            if (fVar.leT != null) {
                toByteArray2 = fVar.leT.toByteArray();
            } else {
                toByteArray2 = null;
            }
            ad.apA();
            int apb = d.apb();
            switch (apb) {
                case 1:
                case 2:
                    break;
                default:
                    w.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[]{Integer.valueOf(apb)});
                    break;
            }
            this.lhz.a(0, null, toByteArray2, toByteArray, apb, (int) (b.aqI() / 1000));
            this.lhA = new a(this.lhz, dVar);
            return this.lhA.b(mVar);
        }
    }
}
