package com.tencent.mm.modelgeo;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tx;
import com.tencent.mm.protocal.c.ty;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends k implements j {
    private String fLL = "";
    public final b gUA;
    private e gUD;

    public d(double d, double d2) {
        a aVar = new a();
        aVar.hsm = new tx();
        aVar.hsn = new ty();
        aVar.uri = "/cgi-bin/micromsg-bin/getaddress";
        aVar.hsl = 655;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        tx txVar = (tx) this.gUA.hsj.hsr;
        txVar.tle = d;
        txVar.tld = d2;
    }

    public final int getType() {
        return 655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.fLL = ((ty) ((b) pVar).hsk.hsr).tCd;
            w.d("MicroMsg.NetSceneGetAddress", this.fLL);
            if (this.gUD != null) {
                this.gUD.a(i2, i3, str, this);
            }
        } else if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final Addr Gn() {
        if (bg.mA(this.fLL)) {
            return null;
        }
        Addr addr = new Addr();
        try {
            w.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[]{this.fLL});
            JSONObject jSONObject = new JSONObject(this.fLL);
            addr.hCO = jSONObject.optString("request_id");
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            addr.hCE = jSONArray.getJSONObject(1).getString("address_name");
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            addr.hCF = jSONObject2.getString("p");
            addr.hCG = jSONObject2.getString("c");
            addr.hCI = jSONObject2.getString("d");
            addr.hCJ = "";
            addr.hCK = "";
            addr.hCL = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("dtype");
                    if ("ST".equals(string)) {
                        addr.hCK = jSONObject2.getString("name");
                    } else if ("ST_NO".equals(string)) {
                        addr.hCL = jSONObject2.getString("name");
                    }
                    if ("FORMAT_ADDRESS".equals(string)) {
                        addr.hCM = jSONObject2.getString("rough_address_name");
                    }
                } catch (Exception e) {
                }
            }
            if (!bg.mA(addr.hCL)) {
                addr.hCK = "";
            }
            return addr;
        } catch (Exception e2) {
            return null;
        }
    }
}
