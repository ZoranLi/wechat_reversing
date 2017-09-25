package com.tencent.mm.y;

import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bc;
import junit.framework.Assert;

public abstract class k {
    public int aIo = -99;
    public e hsD;
    public long hsE = bg.NA();
    public int hsF = -1;
    public boolean hsG = false;
    private q hsH;
    e hsI;
    public boolean hsJ;
    public p hsK;
    int priority = 0;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] hsO = new int[b.BN().length];

        static {
            try {
                hsO[b.hsS - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hsO[b.hsU - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hsO[b.hsT - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    protected enum a {
        EStatusCheckFailed,
        EReachMaxLimit
    }

    protected enum b {
        ;

        public static int[] BN() {
            return (int[]) hsV.clone();
        }

        static {
            hsS = 1;
            hsT = 2;
            hsU = 3;
            hsV = new int[]{hsS, hsT, hsU};
        }
    }

    public abstract int a(e eVar, e eVar2);

    public abstract int getType();

    public void a(a aVar) {
    }

    public int a(p pVar) {
        return b.hsS;
    }

    public boolean BI() {
        return false;
    }

    public int ub() {
        return 1;
    }

    public boolean BJ() {
        return this.aIo <= 0;
    }

    public boolean BK() {
        return false;
    }

    public final void c(e eVar) {
        this.hsE = bg.NA();
        this.hsD = eVar;
    }

    public boolean BL() {
        return ub() == 1;
    }

    public int a(e eVar, final p pVar, j jVar) {
        c(eVar);
        this.hsK = pVar;
        final j a = bc.a(jVar);
        if (this.aIo == -99) {
            this.aIo = ub();
            w.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.aIo);
        }
        if (ub() > 1) {
            switch (AnonymousClass2.hsO[a(pVar) - 1]) {
                case 1:
                    Assert.assertTrue("scene security verification not passed, type=" + pVar.getType() + ", uri=" + pVar.getUri() + ", CHECK NOW", false);
                    break;
                case 2:
                    w.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + pVar.getType() + ", uri=" + pVar.getUri());
                    this.aIo--;
                    a(a.EStatusCheckFailed);
                    this.hsF = -1;
                    return this.hsF;
                case 3:
                    break;
                default:
                    Assert.assertTrue("invalid security verification status", false);
                    break;
            }
        }
        if (BJ()) {
            w.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + ub());
            a(a.EReachMaxLimit);
            this.hsF = -1;
            return this.hsF;
        }
        this.aIo--;
        q sVar = new s(pVar);
        if (!(this.hsH == null || BK())) {
            this.hsH.cancel();
        }
        this.hsH = new q(pVar, a, this, this.hsI, eVar);
        this.hsF = eVar.a(sVar, this.hsH);
        w.i("MicroMsg.NetSceneBase", "dispatcher send, %s", Integer.valueOf(this.hsF));
        if (this.hsF < 0) {
            w.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.hsF), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(pVar.getType()));
            new ae().post(new Runnable(this) {
                final /* synthetic */ k hsN;

                public final void run() {
                    w.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.hsN.hsF), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(pVar.getType()));
                    a.a(-1, 3, -1, "send to network failed", pVar, null);
                    w.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.hsN.hsF), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(pVar.getType()));
                }
            });
            return 99999999;
        }
        q qVar = this.hsH;
        qVar.handler.postDelayed(qVar.htx, 330000);
        return this.hsF;
    }

    public final int BM() {
        return this.hsK == null ? 0 : this.hsK.hashCode();
    }

    public void cancel() {
        w.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", Integer.valueOf(this.hsF), Integer.valueOf(hashCode()), Integer.valueOf(getType()));
        this.hsG = true;
        if (this.hsH != null) {
            this.hsH.cancel();
        }
        if (this.hsF != -1 && this.hsD != null) {
            int i = this.hsF;
            this.hsF = -1;
            this.hsD.cancel(i);
        }
    }

    public boolean a(k kVar) {
        return false;
    }

    public boolean b(k kVar) {
        return false;
    }

    public String getInfo() {
        return "";
    }
}
