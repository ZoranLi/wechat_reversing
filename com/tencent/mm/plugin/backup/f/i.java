package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.h.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class i {
    public a jEh;
    public long jHP = 0;
    private long jHQ = 0;
    public boolean jHR = false;
    public Boolean jHS = null;

    public interface a {
        void vM();
    }

    public i(a aVar) {
        this.jEh = aVar;
    }

    public final void abz() {
        this.jHP = bg.Nz();
        w.d("MicroMsg.HeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[]{Long.valueOf(this.jHP)});
        this.jHR = false;
    }

    public final void abA() {
        this.jHQ = this.jHQ == Long.MAX_VALUE ? 0 : this.jHQ + 1;
        e eVar = new e();
        eVar.jHQ = this.jHQ;
        try {
            w.i("MicroMsg.HeartBeatHandler", "send heartbeat req, ack:%d", new Object[]{Long.valueOf(eVar.jHQ)});
            b.r(eVar.toByteArray(), 9);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.HeartBeatHandler", e, "buf to BackupHeartBeatRequest err.", new Object[0]);
        }
    }

    public final void stop() {
        if (this.jHS != null) {
            this.jHS = Boolean.valueOf(true);
        }
    }

    public final void start() {
        boolean z = true;
        Assert.assertTrue("HeartBeatTimeoutCallback is null", this.jEh != null);
        String str = "New HeartBeatHandler EveryTime !";
        if (this.jHS != null) {
            z = false;
        }
        Assert.assertTrue(str, z);
        w.i("MicroMsg.HeartBeatHandler", "start backup heart beat handler.");
        abz();
        this.jHS = Boolean.valueOf(false);
        com.tencent.mm.sdk.f.e.b(new Runnable(this) {
            final /* synthetic */ i jHT;

            {
                this.jHT = r1;
            }

            public final void run() {
                while (!this.jHT.jHS.booleanValue()) {
                    try {
                        Thread.sleep(15000);
                    } catch (Exception e) {
                    }
                    if (!this.jHT.jHS.booleanValue()) {
                        w.d("MicroMsg.HeartBeatHandler", "heartBeatTimeStamp[%d]", new Object[]{Long.valueOf(this.jHT.jHP)});
                        if (bg.aA(this.jHT.jHP) >= 15000) {
                            if (this.jHT.jHR) {
                                w.e("MicroMsg.HeartBeatHandler", "Timeout Now ! timeDiff:%d, heartBeatTimeStamp:%d", new Object[]{Long.valueOf(r0), Long.valueOf(this.jHT.jHP)});
                                this.jHT.jEh.vM();
                                this.jHT.abz();
                                this.jHT.stop();
                                return;
                            }
                            this.jHT.abA();
                            this.jHT.abz();
                            this.jHT.jHR = true;
                        }
                    } else {
                        return;
                    }
                }
            }
        }, "BackupSendBackupHeartBeat").start();
        abA();
    }
}
