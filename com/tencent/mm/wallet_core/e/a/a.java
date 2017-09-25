package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.aqg;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.y.b;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a extends g {
    public abstract int btw();

    public final int bti() {
        return btw();
    }

    public final void y(boolean z, boolean z2) {
        b bVar = this.gUA;
        if (bVar == null) {
            com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
            aVar.hsm = new aqg();
            aVar.hsn = new aqh();
            aVar.uri = "/cgi-bin/mmpay-bin/payu";
            aVar.hsl = 1518;
            aVar.hso = 0;
            aVar.hsp = 0;
            bVar = aVar.BE();
            bVar.hsA = true;
        }
        b bVar2 = bVar;
        aqg com_tencent_mm_protocal_c_aqg = (aqg) bVar2.hsj.hsr;
        if (z) {
            com_tencent_mm_protocal_c_aqg.tKk = btw();
        }
        if (z2) {
            com_tencent_mm_protocal_c_aqg.tKl = 1;
        }
        this.gUA = bVar2;
    }

    public final int getType() {
        return 1518;
    }

    public final String HP(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, avw com_tencent_mm_protocal_c_avw) {
        ((aqg) bVar.hsj.hsr).tKm = com_tencent_mm_protocal_c_avw;
    }

    public final void b(b bVar, avw com_tencent_mm_protocal_c_avw) {
        ((aqg) bVar.hsj.hsr).tUZ = com_tencent_mm_protocal_c_avw;
    }

    public final l c(b bVar) {
        aqh com_tencent_mm_protocal_c_aqh = (aqh) bVar.hsk.hsr;
        l lVar = new l();
        lVar.tKq = com_tencent_mm_protocal_c_aqh.tKq;
        lVar.tKp = com_tencent_mm_protocal_c_aqh.tKp;
        lVar.tKo = com_tencent_mm_protocal_c_aqh.tKo;
        lVar.tKn = com_tencent_mm_protocal_c_aqh.tKn;
        lVar.leS = com_tencent_mm_protocal_c_aqh.tVb;
        lVar.wEg = com_tencent_mm_protocal_c_aqh.tVa;
        return lVar;
    }

    public int a(e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        if (m.xY()) {
            return a(eVar, this.gUA, this);
        }
        w.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
        eVar2.a(1000, -100868, "Pay Method Err", this);
        return 1;
    }

    public final void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(URLEncoder.encode(str));
    }
}
