package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ala;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import org.json.JSONObject;

public final class f extends k implements j {
    private final b gUA;
    private e gUD;
    public String kdr;
    public int kds = 0;
    public String kdt;
    public int kdu;
    public String kdv;
    public String kgY;

    public f(String str, int i, int i2, int i3) {
        a aVar = new a();
        aVar.hsm = new ala();
        aVar.hsn = new alb();
        aVar.uri = "/cgi-bin/micromsg-bin/marksharecard";
        aVar.hsl = 907;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ala com_tencent_mm_protocal_c_ala = (ala) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ala.fVl = str;
        com_tencent_mm_protocal_c_ala.tOK = i2;
        com_tencent_mm_protocal_c_ala.tOJ = i;
        com_tencent_mm_protocal_c_ala.scene = i3;
        this.kgY = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(907), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            alb com_tencent_mm_protocal_c_alb = (alb) this.gUA.hsk.hsr;
            w.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + com_tencent_mm_protocal_c_alb.kfG);
            Object obj = com_tencent_mm_protocal_c_alb.kfG;
            if (TextUtils.isEmpty(obj)) {
                w.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(obj);
                    this.kdr = jSONObject.optString("mark_user");
                    this.kds = jSONObject.optInt("mark_succ", 0);
                    this.kdt = jSONObject.optString("mark_card_id");
                    this.kdu = jSONObject.optInt("expire_time", 0);
                    this.kdv = jSONObject.optString("pay_qrcode_wording");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", e, "", new Object[0]);
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 907;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
