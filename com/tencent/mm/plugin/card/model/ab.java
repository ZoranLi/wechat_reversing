package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ab extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfG;
    public int kfS;
    public String kfT;
    public int kfU;
    public String kfV;

    public ab(LinkedList<iu> linkedList, int i, String str, String str2, String str3, String str4, String str5, int i2) {
        a aVar = new a();
        aVar.hsm = new we();
        aVar.hsn = new wf();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
        aVar.hsl = 690;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        we weVar = (we) this.gUA.hsj.hsr;
        weVar.tcT = linkedList;
        weVar.fVn = i;
        weVar.tfA = str;
        weVar.sign = str2;
        weVar.tcP = str3;
        weVar.tcO = str4;
        weVar.tDa = str5;
        weVar.tcQ = i2;
    }

    public final int getType() {
        return 690;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3 + " netType = 690");
        if (i2 == 0 && i3 == 0) {
            this.kfG = ((wf) this.gUA.hsk.hsr).kfG;
            if (TextUtils.isEmpty(this.kfG)) {
                w.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.kfG);
                    this.kfS = jSONObject.optInt("accept_button_status", 0);
                    this.kfT = jSONObject.optString("accept_button_wording");
                    this.kfU = jSONObject.optInt("private_status", 0);
                    this.kfV = jSONObject.optString("private_wording");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", e, "", new Object[0]);
                    w.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + e.getMessage());
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
