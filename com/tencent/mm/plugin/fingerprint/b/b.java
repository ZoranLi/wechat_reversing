package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bcw;
import com.tencent.mm.protocal.c.bcx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tenpay.android.wechat.TenpayUtil;

public final class b extends d implements j {
    public final com.tencent.mm.y.b gUA;
    private e gUD;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new bcw();
        aVar.hsn = new bcx();
        aVar.uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
        aVar.hsl = 1638;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bcw com_tencent_mm_protocal_c_bcw = (bcw) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bcw.udL = str;
        com_tencent_mm_protocal_c_bcw.signature = str2;
        com_tencent_mm_protocal_c_bcw.udM = str3;
        com_tencent_mm_protocal_c_bcw.udN = TenpayUtil.signWith3Des("passwd=" + com_tencent_mm_protocal_c_bcw.udM);
    }

    public final void c(int i, int i2, String str, p pVar) {
        w.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            w.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
            com.tencent.mm.plugin.fingerprint.a.e.el(true);
        } else {
            w.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
        }
        this.gUD.a(i, i2, "", this);
    }

    public final void avA() {
        w.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
        if (this.gUD != null) {
            this.gUD.a(4, -1, "", this);
        }
    }

    public final void bY(int i, int i2) {
        w.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i2)});
        if (this.gUD != null) {
            this.gUD.a(4, -1, "", this);
        }
    }

    public final int getType() {
        return 1638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
