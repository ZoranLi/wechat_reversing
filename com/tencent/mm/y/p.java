package com.tencent.mm.y;

import com.tencent.mm.network.a.b;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.k;
import com.tencent.mm.network.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class p implements e {
    public final f htq;
    private o htr;

    public p(f fVar) {
        this.htq = fVar;
    }

    public final int a(q qVar, k kVar) {
        try {
            return this.htq.a(qVar, kVar);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            return -1;
        }
    }

    public final String getNetworkServerIp() {
        try {
            return this.htq.getNetworkServerIp();
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final String[] getIPsString(boolean z) {
        try {
            return this.htq.getIPsString(z);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final void cancel(int i) {
        try {
            this.htq.cancel(i);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", Integer.valueOf(i), e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void reset() {
        try {
            this.htq.reset();
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        try {
            this.htq.a(z, str, str2, iArr, iArr2, i, i2, str3, str4);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final c Cc() {
        try {
            if (this.htr == null) {
                this.htr = new o(this.htq.Mp());
            }
            return this.htr;
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final void a(b bVar) {
        try {
            this.htq.a(bVar);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void aZ(boolean z) {
        try {
            this.htq.aZ(z);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final boolean BS() {
        boolean z = true;
        try {
            z = this.htq.BS();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = e;
            w.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", objArr);
            objArr = new Object[z];
            objArr[0] = bg.g(e);
            w.e("MicroMsg.RDispatcher", "exception:%s", objArr);
        }
        return z;
    }

    public final h Cd() {
        try {
            return this.htq.Mr();
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final void a(ab abVar) {
        try {
            this.htq.a(abVar);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void hv(String str) {
        try {
            this.htq.hv(str);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", e);
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final int getHostByName(String str, List<String> list) {
        try {
            return this.htq.getHostByName(str, list);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            return -1;
        }
    }

    public final int a(String str, boolean z, List<String> list) {
        try {
            return this.htq.a(str, z, list);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            return -1;
        }
    }

    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        try {
            this.htq.setHostInfo(strArr, strArr2, iArr);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void a(int i, String str, int i2, boolean z) {
        try {
            this.htq.a(i, str, i2, z);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final String getIspId() {
        try {
            return this.htq.getIspId();
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final void setSignallingStrategy(long j, long j2) {
        try {
            this.htq.setSignallingStrategy(j, j2);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void keepSignalling() {
        try {
            this.htq.keepSignalling();
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void stopSignalling() {
        try {
            this.htq.stopSignalling();
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void a(n nVar) {
        try {
            this.htq.a(nVar);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void reportFailIp(String str) {
        try {
            this.htq.reportFailIp(str);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void hw(String str) {
        try {
            this.htq.hw(str);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void ba(boolean z) {
        try {
            this.htq.ba(z);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void bb(boolean z) {
        try {
            this.htq.bb(z);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void bc(boolean z) {
        try {
            this.htq.bc(z);
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }

    public final void Ce() {
        try {
            this.htq.Ce();
        } catch (Throwable e) {
            w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
        }
    }
}
