package com.tencent.mm.y;

import android.os.Looper;
import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.k.a;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class q extends a {
    private final k fGg;
    final ae handler;
    private final e hsD;
    private final e hsI;
    private final long hts = 330000;
    private p htt;
    private j htu;
    private boolean htv = false;
    private boolean htw = false;
    Runnable htx = new Runnable(this) {
        final /* synthetic */ q hty;

        {
            this.hty = r1;
        }

        public final void run() {
            int i = 0;
            if (this.hty.htv || this.hty.htw) {
                int i2;
                String str = "MicroMsg.RemoteOnGYNetEnd";
                String str2 = "time exceed But removeCallbacks failed hash:%d type:%d";
                Object[] objArr = new Object[2];
                if (this.hty.fGg == null) {
                    i2 = 0;
                } else {
                    i2 = this.hty.fGg.hashCode();
                }
                objArr[0] = Integer.valueOf(i2);
                if (this.hty.fGg != null) {
                    i = this.hty.fGg.getType();
                }
                objArr[1] = Integer.valueOf(i);
                w.e(str, str2, objArr);
                return;
            }
            final boolean a = this.hty.htv;
            final boolean b = this.hty.htw;
            String str3 = "MicroMsg.RemoteOnGYNetEnd";
            String str4 = "time exceed, force to callback hash:%d type:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(this.hty.fGg == null ? 0 : this.hty.fGg.hashCode());
            if (this.hty.fGg != null) {
                i = this.hty.fGg.getType();
            }
            objArr2[1] = Integer.valueOf(i);
            w.w(str3, str4, objArr2);
            this.hty.htv = true;
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 htB;

                public final void run() {
                    int i = 0;
                    this.htB.hty.hsD.hw("push process's network haven't callback in 5.5min!!!! cancelStatus:" + a + " hasCallbackStatus:" + b);
                    String str = "MicroMsg.RemoteOnGYNetEnd";
                    String str2 = "time exceed, force to callback . kill push fin. hash:%d type:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(this.htB.hty.fGg == null ? 0 : this.htB.hty.fGg.hashCode());
                    if (this.htB.hty.fGg != null) {
                        i = this.htB.hty.fGg.getType();
                    }
                    objArr[1] = Integer.valueOf(i);
                    w.w(str, str2, objArr);
                }
            }, "RemoteOnGYNetEnd_killPush");
            this.hty.htu.a(-1, 3, -1, "time exceed, force to callback", this.hty.htt, null);
        }
    };

    public q(p pVar, j jVar, k kVar, e eVar, e eVar2) {
        this.htt = pVar;
        this.htu = jVar;
        this.fGg = kVar;
        this.hsI = eVar;
        this.handler = Looper.myLooper() == null ? new ae(Looper.getMainLooper()) : new ae();
        this.hsD = eVar2;
    }

    public final void cancel() {
        this.htv = true;
        this.handler.removeCallbacks(this.htx);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        w.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.htv), Integer.valueOf(this.fGg.hashCode()), Integer.valueOf(this.htt.hashCode()));
        this.fGg.hsF = -1;
        if (!this.htv && !this.htw) {
            this.htw = true;
            this.handler.removeCallbacks(this.htx);
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final byte[] bArr2 = bArr;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ q hty;

                public final void run() {
                    if (this.hty.htv) {
                        w.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", Integer.valueOf(i4));
                        return;
                    }
                    int i = i5;
                    int i2 = i6;
                    if (10016 == r.iiW && !bg.mA(r.iiY)) {
                        w.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", r.iiY);
                        String[] split = r.iiY.split(",");
                        if (split != null && split.length == 3 && bg.getInt(split[0], -1) == this.hty.fGg.getType()) {
                            i = bg.getInt(split[1], 0);
                            i2 = bg.getInt(split[2], 0);
                            if (i == 999) {
                                w.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", r.iiY);
                                return;
                            }
                        }
                    }
                    w.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hty.htv), Integer.valueOf(this.hty.fGg.hashCode()));
                    this.hty.htu.a(i4, i, i2, str2, this.hty.htt, bArr2);
                    if (this.hty.fGg.BL() && !this.hty.fGg.hsJ) {
                        w.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", Integer.valueOf(this.hty.fGg.getType()));
                        w.bIP();
                    }
                }
            });
        }
    }
}
