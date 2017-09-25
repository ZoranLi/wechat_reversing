package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.as.b;
import com.tencent.mm.as.d;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.boz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class h extends b implements j {
    private e gUD;
    private com.tencent.mm.y.b hKp;
    private boz rWm;
    d.b rWo;

    public h(d.b bVar) {
        this.rWo = bVar;
        this.hPj = bVar.fDs;
        this.hPi = bVar.scene;
        this.hPg = bVar.fRO;
        if (bg.mA(bVar.fDs)) {
            w.e("MicroMsg.FTS.NetSceneWebSuggest", "keyword is unavailable");
            return;
        }
        w.i("MicroMsg.FTS.NetSceneWebSuggest", "Constructors: query=%s", new Object[]{bVar.fDs});
        a aVar = new a();
        aVar.hsl = 1161;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
        aVar.hsm = new boy();
        aVar.hsn = new boz();
        this.hKp = aVar.BE();
        boy com_tencent_mm_protocal_c_boy = (boy) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_boy.tAN = bVar.fDs;
        com_tencent_mm_protocal_c_boy.tlY = (long) bVar.hPq;
        com_tencent_mm_protocal_c_boy.umf = d.hPo;
        com_tencent_mm_protocal_c_boy.tYD = bVar.hPp;
        com_tencent_mm_protocal_c_boy.tOl = d.AU();
        com_tencent_mm_protocal_c_boy.tdM = bVar.scene;
        com_tencent_mm_protocal_c_boy.umj = d.gm(bVar.scene);
        if (bVar.hPH != null) {
            try {
                com_tencent_mm_protocal_c_boy.uny = new com.tencent.mm.bd.b(bVar.hPH.toByteArray());
            } catch (Exception e) {
            }
        }
        if (bVar.hPG != null) {
            try {
                com_tencent_mm_protocal_c_boy.unx = new com.tencent.mm.bd.b(bVar.hPG.toByteArray());
            } catch (IOException e2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(bVar.hPy);
            com_tencent_mm_protocal_c_boy.unu = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                com_tencent_mm_protocal_c_boy.unu.add(URLDecoder.decode(jSONArray.getString(i), "UTF-8"));
            }
        } catch (Throwable e3) {
            w.printErrStackTrace("MicroMsg.FTS.NetSceneWebSuggest", e3, "decode json error", new Object[0]);
        }
        String str = "MicroMsg.FTS.NetSceneWebSuggest";
        String str2 = "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(bVar.hPq);
        objArr[1] = Boolean.valueOf(com_tencent_mm_protocal_c_boy.tOl != null);
        objArr[2] = Integer.valueOf(bVar.scene);
        objArr[3] = Integer.valueOf(bVar.hPq);
        objArr[4] = Integer.valueOf(bVar.hPp);
        objArr[5] = Integer.valueOf(bVar.fRO);
        w.i(str, str2, objArr);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.FTS.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.rWm = (boz) this.hKp.hsk.hsr;
            if (this.rWm != null) {
                w.v("MicroMsg.FTS.NetSceneWebSuggest", "return data\n%s", new Object[]{this.rWm.tlt});
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1161;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final String AS() {
        return this.rWm != null ? this.rWm.tlt : "";
    }
}
