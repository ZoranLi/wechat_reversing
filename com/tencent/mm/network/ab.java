package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import com.tencent.mm.network.h.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class ab extends a {
    private aj hqQ = new aj(new aj.a(this) {
        final /* synthetic */ ab ifI;

        {
            this.ifI = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.NetworkEvent", "listeners ct : %d", Integer.valueOf(this.ifI.ifH.beginBroadcast()));
            for (int i = r0 - 1; i >= 0; i--) {
                try {
                    ((m) this.ifI.ifH.getBroadcastItem(i)).cU(this.ifI.ifE);
                } catch (Throwable e) {
                    w.e("MicroMsg.NetworkEvent", "exception:%s", bg.g(e));
                }
            }
            this.ifI.ifH.finishBroadcast();
            return false;
        }
    }, false);
    private int ifE = 4;
    private long ifF;
    private int ifG = 0;
    private final RemoteCallbackList<m> ifH = new RemoteCallbackList();

    public final int Ms() {
        w.i("MicroMsg.NetworkEvent", "getNowStatus = %d", Integer.valueOf(0 > bg.az(this.ifF) ? 5 : this.ifE));
        return 0 > bg.az(this.ifF) ? 5 : this.ifE;
    }

    public final boolean c(m mVar) {
        try {
            this.ifH.register(mVar);
        } catch (Throwable e) {
            w.e("MicroMsg.NetworkEvent", "addListener %s", e);
            w.e("MicroMsg.NetworkEvent", "exception:%s", bg.g(e));
        }
        return true;
    }

    public final boolean d(m mVar) {
        boolean z = false;
        try {
            z = this.ifH.unregister(mVar);
        } catch (Throwable e) {
            w.e("MicroMsg.NetworkEvent", "removeListener %s", e);
            w.e("MicroMsg.NetworkEvent", "exception:%s", bg.g(e));
        }
        return z;
    }

    public final void Mt() {
        this.ifH.kill();
    }

    public final void gY(int i) {
        int i2 = 0;
        w.i("MicroMsg.NetworkEvent", "networkChange : %d", Integer.valueOf(i));
        if (i != this.ifE) {
            if (3 != i) {
                if (2 == i) {
                    if (!(this.ifE == 0 || this.ifE == 1)) {
                        this.ifG++;
                        if (this.ifG > 0) {
                            this.ifE = 2;
                            i2 = 1;
                        }
                    }
                } else if (4 == i) {
                    this.ifG = 0;
                    this.ifE = 4;
                    i2 = 1;
                }
                this.ifE = i;
                i2 = 1;
            } else if (this.ifE == 2) {
                this.ifE = i;
                i2 = 1;
            }
        }
        if (i2 != 0) {
            if (i == 0 || i == 6) {
                this.hqQ.v(1000, 1000);
            }
        }
    }

    public final long Mu() {
        return this.ifF;
    }
}
