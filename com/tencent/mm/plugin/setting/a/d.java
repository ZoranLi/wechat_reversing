package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends k implements j {
    private b gUA;
    private e gUD;

    public d() {
        a aVar = new a();
        aVar.hsm = new acd();
        aVar.hsn = new ace();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.hsl = 1191;
        this.gUA = aVar.BE();
        acd com_tencent_mm_protocal_c_acd = (acd) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_acd.cGa = 2;
        LinkedList linkedList = new LinkedList();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        com_tencent_mm_protocal_c_acd.tHL = linkedList;
        com_tencent_mm_protocal_c_acd.tHK = false;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
            ace com_tencent_mm_protocal_c_ace = (ace) ((b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_ace.tHM != null) {
                try {
                    boolean z = new JSONObject(com_tencent_mm_protocal_c_ace.tHM).getBoolean("has_invoice_info");
                    w.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is .." + z);
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uGI, Boolean.valueOf(z));
                } catch (JSONException e) {
                    w.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1191;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
