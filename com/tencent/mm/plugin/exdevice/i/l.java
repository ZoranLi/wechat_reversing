package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.u.ap;
import junit.framework.Assert;

public final class l extends a {
    private final long hts = 15000;
    private c lhI = null;
    boolean lhJ = false;
    boolean lhK = false;
    Runnable lhL = new Runnable(this) {
        final /* synthetic */ l lhM;

        {
            this.lhM = r1;
        }

        public final void run() {
            this.lhM.lhJ = true;
            if (!this.lhM.lhK) {
                this.lhM.lhI.a(-1, -1, -2, "TimeOut", null);
            }
        }

        public final String toString() {
            return super.toString() + "|mAsyncTimeOut";
        }
    };

    public l(c cVar) {
        Assert.assertNotNull(cVar);
        this.lhI = cVar;
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        if (!this.lhK && !this.lhJ) {
            ap.vL().bJl().removeCallbacks(this.lhL);
            final long j2 = j;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            final p pVar2 = pVar;
            ap.vL().bJl().post(new Runnable(this) {
                final /* synthetic */ l lhM;

                public final void run() {
                    this.lhM.lhI.a(j2, i3, i4, str2, pVar2);
                }

                public final String toString() {
                    return super.toString() + "|onTaskEnd";
                }
            });
        }
    }
}
