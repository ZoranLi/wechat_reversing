package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.protocal.c.aav;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import org.json.JSONObject;

public final class b extends k implements j {
    private com.tencent.mm.y.b gUA;
    private e gUD;
    private long rDd = 10;

    public b() {
        w.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
        a aVar = new a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_aau = new aau();
        com_tencent_mm_protocal_c_aau.tnu = h.btK();
        aVar.hsm = com_tencent_mm_protocal_c_aau;
        aVar.hsn = new aav();
        aVar.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
        aVar.hsl = 1666;
        this.gUA = aVar.BE();
        this.gUA.hsA = true;
    }

    public final int getType() {
        return 1666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            long j;
            aav com_tencent_mm_protocal_c_aav = (aav) ((com.tencent.mm.y.b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_aav.tGN <= 0) {
                j = this.rDd;
            } else {
                j = com_tencent_mm_protocal_c_aav.tGN;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bindcardTitle", com_tencent_mm_protocal_c_aav.tGG);
                jSONObject.put("bindcardSubTitle", com_tencent_mm_protocal_c_aav.tGH);
                jSONObject.put("bindIdTitle", com_tencent_mm_protocal_c_aav.tGI);
                jSONObject.put("bindIdSubTitle", com_tencent_mm_protocal_c_aav.tGJ);
                jSONObject.put("extral_wording", com_tencent_mm_protocal_c_aav.tGK);
                jSONObject.put("question_answer_switch", com_tencent_mm_protocal_c_aav.tGL);
                jSONObject.put("question_answer_url", com_tencent_mm_protocal_c_aav.tGM);
                jSONObject.put("cache_time", j);
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.put("isShowBindCard", com_tencent_mm_protocal_c_aav.tGO);
                jSONObject.put("isShowBindCardVerify", com_tencent_mm_protocal_c_aav.tGQ);
                jSONObject.put("isShowBindId", com_tencent_mm_protocal_c_aav.tGP);
                jSONObject.put("bindCardVerifyTitle", com_tencent_mm_protocal_c_aav.tGR);
                jSONObject.put("bindCardVerifySubtitle", com_tencent_mm_protocal_c_aav.tGS);
                jSONObject.put("bindCardVerifyAlertViewRightBtnTxt", com_tencent_mm_protocal_c_aav.tGT);
                jSONObject.put("bindCardVerifyAlertViewContent", com_tencent_mm_protocal_c_aav.tGU);
                jSONObject.put("isShowBindCardVerifyAlertView", com_tencent_mm_protocal_c_aav.tGV);
                if (com_tencent_mm_protocal_c_aav.tGW != null && com_tencent_mm_protocal_c_aav.tGW.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Object obj = null;
                    Iterator it = com_tencent_mm_protocal_c_aav.tGW.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (obj != null) {
                            stringBuffer.append("\n");
                        }
                        stringBuffer.append(str2);
                        int i4 = 1;
                    }
                    jSONObject.put("cache_header_titles", stringBuffer.toString());
                }
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uDJ, jSONObject.toString());
                ap.yY();
                c.vr().jY(true);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", e, "", new Object[0]);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
