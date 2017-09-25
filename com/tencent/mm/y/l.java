package com.tencent.mm.y;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afd;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.aq;

public abstract class l extends k implements j {
    protected int hsW = 3;
    private boolean hsX = false;

    public abstract void BO();

    public abstract e BP();

    public abstract void a(int i, int i2, String str, p pVar);

    public abstract hr c(p pVar);

    public abstract anh d(p pVar);

    public abstract afd e(p pVar);

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 4 && i3 == -301) {
            w.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[]{Integer.valueOf(this.hsW)});
            if (pVar != null) {
                w.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
                aq.a(true, c(pVar), d(pVar), e(pVar));
            }
            this.hsW--;
            if (this.hsW <= 0) {
                BO();
                this.hsX = false;
                return;
            }
            w.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
            a(this.hsD, BP());
            return;
        }
        a(i2, i3, str, pVar);
    }
}
