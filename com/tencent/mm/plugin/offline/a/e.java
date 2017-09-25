package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.R;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import org.json.JSONObject;

public final class e extends k {
    private final b gUA;
    private com.tencent.mm.y.e gUD;
    public int kAC = -1;
    private String kAD = "";
    private String ocA;
    private String ocB;
    private String ocC;
    private String ocD;
    public String ocu = "";
    public int ocv = -1;
    public String ocw = "";
    public int ocx = 1;
    public RealnameGuideHelper ocy;
    private String ocz;

    public e(int i, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new aoe();
        aVar.hsn = new aof();
        aVar.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
        aVar.hsl = 609;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aoe com_tencent_mm_protocal_c_aoe = (aoe) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aoe.tTn = i;
        com_tencent_mm_protocal_c_aoe.mQY = str;
        com_tencent_mm_protocal_c_aoe.rHx = str2;
        com_tencent_mm_protocal_c_aoe.tnu = h.btK();
        this.ocx = i;
    }

    public final int getType() {
        return 609;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void d(int i, int i2, String str, p pVar) {
        if (i != 0) {
            w.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : 609" + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        aof com_tencent_mm_protocal_c_aof = (aof) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            try {
                if (com_tencent_mm_protocal_c_aof.tFP != null) {
                    JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_aof.tFP);
                    this.ocu = jSONObject.optString("transaction_id");
                    this.kAC = jSONObject.optInt("retcode");
                    this.kAD = jSONObject.optString("retmsg");
                    this.ocv = jSONObject.optInt("wx_error_type");
                    this.ocw = jSONObject.optString("wx_error_msg");
                    w.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[]{jSONObject.toString()});
                    if (jSONObject.has("real_name_info")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                        this.ocz = optJSONObject.optString("guide_flag");
                        this.ocA = optJSONObject.optString("guide_wording");
                        this.ocB = optJSONObject.optString("left_button_wording");
                        this.ocC = optJSONObject.optString("right_button_wording");
                        this.ocD = optJSONObject.optString("upload_credit_url");
                        if ("1".equals(this.ocz) || "2".equals(this.ocz)) {
                            this.ocy = new RealnameGuideHelper();
                            this.ocy.a(this.ocz, this.ocA, this.ocB, this.ocC, this.ocD, 0);
                        }
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ab.getContext().getString(R.l.ffj);
            }
        }
        if (this.gUD != null) {
            this.gUD.a(i, i2, str, this);
        }
    }
}
