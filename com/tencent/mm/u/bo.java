package com.tencent.mm.u;

import com.tencent.mm.e.a.qg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class bo {
    private a hog = null;
    private long hoh = 0;
    private long hoi = 0;
    private String hoj = "";
    private int hok = 1;

    public interface a {
        boolean zZ();
    }

    public bo(a aVar) {
        Assert.assertTrue(true);
        this.hog = aVar;
        zT();
    }

    private void zT() {
        this.hok = 1;
        this.hoh = 0;
        this.hoi = 0;
        this.hoj = "";
    }

    public final synchronized boolean O(long j) {
        boolean z = true;
        synchronized (this) {
            long Nz = bg.Nz();
            this.hoj = bg.bJZ().toString();
            if (this.hok == 1) {
                this.hoi = Nz;
                this.hoh = j;
                w.i("MicroMsg.SyncPauser", "requestToPause currState:STATE_RUNNING timeout:%d %s", Long.valueOf(j), this.hoj);
                this.hok = 2;
                if (this.hog.zZ()) {
                    zV();
                }
            } else {
                long j2 = this.hoi + this.hoh;
                Nz += j;
                if (Nz > j2) {
                    this.hoh += Nz - j2;
                }
                w.i("MicroMsg.SyncPauser", "requestToPause currState:%s ParamTimeout:%d diff:%s newTimeout:%s %s", Integer.valueOf(this.hok), Long.valueOf(j), Long.valueOf(Nz - j2), Long.valueOf(this.hoh), this.hoj);
                z = false;
            }
        }
        return z;
    }

    public final synchronized void zU() {
        w.d("MicroMsg.SyncPauser", "restartSync currState:%d %s", Integer.valueOf(this.hok), bg.bJZ());
        if (this.hok == 1) {
            w.d("MicroMsg.SyncPauser", "warning: restartSync but currState has been STATE_RUNNING %s", bg.bJZ());
        } else {
            zT();
            b qgVar = new qg();
            qgVar.fXm.status = 1;
            com.tencent.mm.sdk.b.a.urY.m(qgVar);
        }
    }

    public final synchronized void zV() {
        if (this.hok != 2) {
            w.e("MicroMsg.SyncPauser", "ERR: setFullPause but currState is %d  %s", Integer.valueOf(this.hok), bg.bJZ());
        } else {
            w.d("MicroMsg.SyncPauser", "setFullPause waitTime:%d %s", Long.valueOf(bg.aA(this.hoi)), bg.bJZ());
            this.hok = 3;
            b qgVar = new qg();
            qgVar.fXm.status = 3;
            com.tencent.mm.sdk.b.a.urY.m(qgVar);
        }
    }

    private synchronized void zW() {
        if (this.hok != 1 && this.hoh + this.hoi < bg.Nz()) {
            zU();
        }
    }

    public final synchronized boolean zX() {
        zW();
        return this.hok == 2;
    }

    public final synchronized boolean zY() {
        zW();
        return this.hok == 3;
    }
}
