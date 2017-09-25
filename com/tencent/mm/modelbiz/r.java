package com.tencent.mm.modelbiz;

import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import org.json.JSONObject;

public final class r extends k implements j {
    private Object data;
    public b gUA;
    private e gUD;

    public static void a(e eVar) {
        h.vH().gXC.b(1285, eVar);
    }

    public static boolean k(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_user_name", str2);
            jSONObject.put("bizchat_id", str3);
            return h.vH().gXC.a(new r(str, jSONObject.toString()), 0);
        } catch (Exception e) {
            return false;
        }
    }

    private r(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new vo();
        aVar.hsn = new vp();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
        aVar.hsl = 1285;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        vo voVar = (vo) this.gUA.hsj.hsr;
        voVar.tsS = str;
        voVar.ou = 1;
        voVar.data = str2;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1285;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
        return a(eVar, this.gUA, this);
    }
}
