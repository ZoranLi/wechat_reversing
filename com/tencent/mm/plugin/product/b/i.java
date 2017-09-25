package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aai;
import com.tencent.mm.protocal.c.aaj;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends k implements j {
    private b gUA;
    private e gUD;
    public String mUrl;
    public LinkedList<od> opt;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new aai();
        aVar.hsn = new aaj();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdiscount";
        aVar.hsl = 579;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aai com_tencent_mm_protocal_c_aai = (aai) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aai.tnq = str;
        this.mUrl = str2;
        com_tencent_mm_protocal_c_aai.msN = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        aaj com_tencent_mm_protocal_c_aaj = (aaj) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0 && com_tencent_mm_protocal_c_aaj.tnr == 0) {
            w.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + com_tencent_mm_protocal_c_aaj.tGn);
            try {
                JSONArray optJSONArray = new JSONObject(com_tencent_mm_protocal_c_aaj.tGn).optJSONArray("discount_list");
                if (optJSONArray != null) {
                    this.opt = new LinkedList();
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                        od odVar = new od();
                        odVar.fDC = jSONObject.getString("title");
                        odVar.tmm = jSONObject.getInt("fee");
                        this.opt.add(odVar);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (i3 == 0 && com_tencent_mm_protocal_c_aaj.tnr != 0) {
            i3 = com_tencent_mm_protocal_c_aaj.tnr;
            str = com_tencent_mm_protocal_c_aaj.tns;
        }
        w.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + i3 + ", errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 579;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
