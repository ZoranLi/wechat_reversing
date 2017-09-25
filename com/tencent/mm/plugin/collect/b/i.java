package com.tencent.mm.plugin.collect.b;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.protocal.c.jk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends k implements j {
    private final String TAG = "MicroMsg.NetSceneF2fQrcode";
    private b gUA;
    private e gUD;
    public jk kAB;

    public i() {
        a aVar = new a();
        aVar.hsm = new jj();
        aVar.hsn = new jk();
        aVar.hsl = 1588;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1588;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.kAB = (jk) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        w.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[]{this.kAB.url, this.kAB.rDD, this.kAB.tpr});
        if (!bg.mA(this.kAB.url)) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uIw, this.kAB.url);
        }
        if (!bg.mA(this.kAB.rDD)) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uIx, this.kAB.rDD);
        }
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uIz, this.kAB.tpr);
        JSONObject a = a(this.kAB.tpq);
        JSONArray ah = ah(this.kAB.tpp);
        if (a != null) {
            w.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[]{a.toString()});
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uIy, a.toString());
        }
        if (ah != null) {
            w.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[]{ah.toString()});
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uIA, ah.toString());
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    private JSONArray ah(List<alp> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() == 0) {
            w.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
            return null;
        }
        int i = 0;
        while (i < list.size()) {
            try {
                JSONObject a = a((alp) list.get(i));
                if (a != null) {
                    jSONArray.put(i, a);
                }
                i++;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
                return null;
            }
        }
        return jSONArray;
    }

    private static JSONObject a(alp com_tencent_mm_protocal_c_alp) {
        int i = (com_tencent_mm_protocal_c_alp == null || bg.mA(com_tencent_mm_protocal_c_alp.fNG)) ? 0 : 1;
        if (i == 0) {
            w.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Columns.TYPE, com_tencent_mm_protocal_c_alp.type);
            jSONObject.put("wording", com_tencent_mm_protocal_c_alp.fNG);
            jSONObject.put(SlookSmartClipMetaTag.TAG_TYPE_URL, com_tencent_mm_protocal_c_alp.url);
            jSONObject.put("waapp_username", com_tencent_mm_protocal_c_alp.tQu);
            jSONObject.put("waapp_path", com_tencent_mm_protocal_c_alp.tQv);
            return jSONObject;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
            return null;
        }
    }
}
