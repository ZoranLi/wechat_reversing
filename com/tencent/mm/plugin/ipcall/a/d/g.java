package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ade;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;

public final class g extends k implements j {
    private b gUA = null;
    private e gUD;
    private ade mPQ = null;
    public adf mPR = null;

    public g(int i) {
        a aVar = new a();
        aVar.hsm = new ade();
        aVar.hsn = new adf();
        aVar.hsl = 257;
        aVar.uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mPQ = (ade) this.gUA.hsj.hsr;
        this.mPQ.tdM = i;
        ade com_tencent_mm_protocal_c_ade = this.mPQ;
        ap.yY();
        com_tencent_mm_protocal_c_ade.tIF = ((Integer) c.vr().get(w.a.uBU, Integer.valueOf(0))).intValue();
        com_tencent_mm_protocal_c_ade = this.mPQ;
        ap.yY();
        com_tencent_mm_protocal_c_ade.tIG = ((Integer) c.vr().get(w.a.uBI, Integer.valueOf(0))).intValue();
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[]{Integer.valueOf(this.mPQ.tdM), Integer.valueOf(this.mPQ.tIF), Integer.valueOf(this.mPQ.tIG)});
    }

    public final int getType() {
        return 257;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPR = (adf) ((b) pVar).hsk.hsr;
        if ((i2 == 0 || i3 == 0) && i2 == 0 && i3 == 0) {
            adf com_tencent_mm_protocal_c_adf = this.mPR;
            if (com_tencent_mm_protocal_c_adf != null) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[]{com_tencent_mm_protocal_c_adf.tIK, com_tencent_mm_protocal_c_adf.tIL, com_tencent_mm_protocal_c_adf.tIH, com_tencent_mm_protocal_c_adf.mQZ, com_tencent_mm_protocal_c_adf.fDC, com_tencent_mm_protocal_c_adf.msk, com_tencent_mm_protocal_c_adf.tII, com_tencent_mm_protocal_c_adf.tIJ, com_tencent_mm_protocal_c_adf.tIM, com_tencent_mm_protocal_c_adf.tIS});
                try {
                    ap.yY();
                    c.vr().a(w.a.uCO, bg.bo(com_tencent_mm_protocal_c_adf.toByteArray()));
                } catch (IOException e) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[]{e.getMessage()});
                }
            }
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
