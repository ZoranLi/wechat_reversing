package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.protocal.c.awc;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private b gUA;
    private e gUD;
    public awd itd;

    public i(com.tencent.mm.plugin.o.a.b bVar) {
        a aVar = new a();
        aVar.hsm = new awc();
        aVar.hsn = new awd();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        aVar.hsl = 1180;
        this.gUA = aVar.BE();
        awc com_tencent_mm_protocal_c_awc = (awc) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_awc.cGa = 2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("{\"user_uin\":");
        ap.yY();
        stringBuilder.append(stringBuilder2.append(c.uH()).append(" ,\"user_data_list\": [").toString());
        if (bVar.type.equals("0")) {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.mLW + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + bVar.mLY + "\"},{\"key\": \"bank_number\",\"value\": \"" + bVar.mLZ + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.mMc + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + bVar.mMe + "\"},{\"key\": \"bank_name\",\"value\": \"" + bVar.mMa + "\"}]}}");
        } else {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.mLW + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.mLX + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.mMd + "\"},{\"key\": \"email\",\"value\": \"" + bVar.gku + "\"}]}}");
        }
        stringBuilder.append("]}");
        com_tencent_mm_protocal_c_awc.tHM = stringBuilder.toString();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            this.itd = (awd) ((b) pVar).hsk.hsr;
            if (!(this.itd == null || this.itd.tZv == null || this.itd.tZv.size() <= 0 || this.itd.tZv.get(0) == null)) {
                w.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((aei) this.itd.tZv.get(0)).ttF);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1180;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
