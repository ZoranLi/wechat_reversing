package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import junit.framework.Assert;

public class a implements c {
    private long lgm = -1;
    protected c lht = null;
    protected d lhu = null;
    private m lhv = null;

    public a(c cVar, d dVar) {
        this.lht = cVar;
        this.lhu = dVar;
    }

    public final void a(d dVar) {
        this.lhu = dVar;
    }

    public final boolean b(m mVar) {
        if (mVar == null) {
            w.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
            return false;
        } else if (this.lhv != null) {
            w.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
            return false;
        } else {
            w.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[]{Short.valueOf(this.lht.aoP()), Short.valueOf(this.lht.lax), Long.valueOf(this.lht.jUL)});
            p mVar2 = new m(this.lht, this);
            long a = mVar.a(mVar2);
            if (-1 == a) {
                w.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
                return false;
            }
            this.lhv = mVar2;
            this.lgm = a;
            m mVar3 = this.lhv;
            Assert.assertNotNull(mVar3.lhQ);
            l lVar = mVar3.lhQ;
            lVar.lhJ = false;
            lVar.lhK = false;
            ap.vL().bJl().postDelayed(lVar.lhL, 15000);
            return true;
        }
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        int i3 = 1;
        w.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(this.lht.jUL), Short.valueOf(this.lht.aoP()), Short.valueOf(this.lht.lax)});
        com.tencent.mm.plugin.exdevice.g.a.k(this.lht.jUL, i == 0 ? 1 : 0);
        if (pVar == null || pVar == this.lhv) {
            if (-1 == i && -2 == i2) {
                w.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
            }
            int i4 = this.lht.lay != null ? this.lht.lay.leR : 0;
            if (-5 == i4 || -3 == i4 || -4 == i4) {
                w.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[]{Integer.valueOf(this.lht.lay.leR), Long.valueOf(this.lht.jUL)});
                if (u.apV().laU == null || !u.apV().laU.bB(this.lht.jUL)) {
                    i3 = 0;
                }
                if (i3 == 0) {
                    w.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
                }
            }
            if (this.lhu != null) {
                this.lhu.a(j, i, i2, str);
            }
            this.lhv = null;
            return;
        }
        w.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
    }
}
