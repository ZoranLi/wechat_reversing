package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.zw;
import com.tencent.mm.protocal.c.zx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends k implements j {
    private b gUA;
    private e gUD;
    private String nvf;
    public ArrayList<MallFunction> nvg;
    public ArrayList<MallNews> nvh;
    public ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> nvi;
    public SparseArray<String> nvj;
    public int nvk;

    public a(int i, String str) {
        this(i, str, null, null);
    }

    public a(int i, String str, String str2, String str3, String str4) {
        this(i, str, str3, String.format("appid=%s&funcid=%s&url=%s", new Object[]{str2, str3, URLEncoder.encode(str4, "ISO-8859-1").toString()}));
    }

    private a(int i, String str, String str2, String str3) {
        this.nvg = null;
        this.nvh = null;
        this.nvi = null;
        this.nvj = null;
        this.nvk = 0;
        this.nvk = i;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new zw();
        aVar.hsn = new zx();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
        aVar.hsl = 495;
        aVar.hso = GameJsApiGetOpenDeviceId.CTRL_BYTE;
        aVar.hsp = 1000000227;
        this.gUA = aVar.BE();
        zw zwVar = (zw) this.gUA.hsj.hsr;
        zwVar.tGc = str;
        LinkedList linkedList = new LinkedList();
        List buD;
        if (bg.mA(str2)) {
            buD = c.buC().buD();
        } else {
            List list;
            MallNews mallNews = (MallNews) c.buC().rIU.get(str2);
            if (mallNews == null || bg.mA(mallNews.fGV)) {
                list = null;
            } else {
                buD = new ArrayList();
                buD.add(mallNews.fGV);
                list = buD;
            }
            buD = list;
        }
        if (r2 != null && r2.size() > 0) {
            String str4 = "";
            for (String str5 : r2) {
                avx com_tencent_mm_protocal_c_avx = new avx();
                com_tencent_mm_protocal_c_avx.OV(str5);
                linkedList.add(com_tencent_mm_protocal_c_avx);
                str4 = str4 + "; + " + str5;
            }
            w.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : " + str4);
        }
        zwVar.tGe = linkedList;
        zwVar.tGd = linkedList.size();
        if (bg.mA(str3)) {
            zwVar.mvZ = String.format("tpa_country=%s", new Object[]{Integer.valueOf(i)});
        } else {
            zwVar.mvZ = String.format("%s&tpa_country=%s", new Object[]{str3, Integer.valueOf(i)});
        }
        this.nvf = str2;
        w.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + str + " ExtInfo: " + zwVar.mvZ);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            zx zxVar = (zx) ((b) pVar).hsk.hsr;
            w.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.nvk + " " + zxVar.tGf);
            try {
                if (!bg.mA(zxVar.tGf)) {
                    JSONObject jSONObject = new JSONObject(zxVar.tGf);
                    String optString = jSONObject.optString("pay_func_list");
                    this.nvg = com.tencent.mm.plugin.wallet_core.model.mall.b.w(new JSONArray(optString));
                    m.btX().b(this.nvk, optString, jSONObject.optString("global_activity_list"), jSONObject.optString("pay_banner_list"), jSONObject.optString("type_info_list"));
                    c.aIQ().nvl.clear();
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", e, "", new Object[0]);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 495;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
