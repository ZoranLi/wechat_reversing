package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.R;
import com.tencent.mm.e.a.oi;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class p extends k {
    b gUA;
    private e gUD;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String akf();

    public final void x(Map<String, String> map) {
        String xL = m.xL();
        ap.yY();
        x Rc = c.wR().Rc(xL);
        if (Rc != null) {
            map.put("province", Rc.bLi());
            map.put("city", Rc.getCityCode());
        }
        if (this.gUA == null) {
            a aVar = new a();
            aVar.hsm = new afa();
            aVar.hsn = new afb();
            aVar.uri = akf();
            aVar.hsl = getType();
            aVar.hso = 0;
            aVar.hsp = 0;
            this.gUA = aVar.BE();
            this.gUA.hsA = true;
        }
        afa com_tencent_mm_protocal_c_afa = (afa) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_afa.tKk = akg();
        com_tencent_mm_protocal_c_afa.tKl = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Object obj : toArray) {
            String str = (String) map.get(obj);
            if (!bg.mA(str)) {
                if (i != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj);
                stringBuilder.append("=");
                stringBuilder.append(str);
                i = true;
            }
        }
        w.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + com_tencent_mm_protocal_c_afa.tKk + ", req = " + stringBuilder.toString());
        com_tencent_mm_protocal_c_afa.tKm = new avw().bb(stringBuilder.toString().getBytes());
    }

    public final void d(int i, int i2, String str, com.tencent.mm.network.p pVar) {
        w.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + akg() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        afb com_tencent_mm_protocal_c_afb = (afb) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            int i3 = com_tencent_mm_protocal_c_afb.tKo;
            String b = n.b(com_tencent_mm_protocal_c_afb.tKn);
            if (i3 != 0 || bg.mA(b)) {
                str = com_tencent_mm_protocal_c_afb.tKp;
                i2 = 2;
                i = 1000;
            } else {
                i3 = com_tencent_mm_protocal_c_afb.fFG;
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    int i4 = jSONObject.getInt("retcode");
                    b = com_tencent_mm_protocal_c_afb.errorMsg;
                    if (bg.mA(b)) {
                        b = jSONObject.optString("retmsg");
                    }
                    if (jSONObject.has("showmess")) {
                        w.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
                        com.tencent.mm.plugin.wallet_core.model.a C = ac.C(jSONObject);
                        com.tencent.mm.sdk.b.b oiVar = new oi();
                        oiVar.fVw.fVx = C;
                        com.tencent.mm.sdk.b.a.urY.m(oiVar);
                    } else if (i4 == 0 && i3 == 0) {
                        a(i4, b, jSONObject);
                    } else {
                        int i5;
                        if (i3 == 0) {
                            i5 = DownloadResult.CODE_UNDEFINED;
                        } else {
                            i5 = i3;
                        }
                        str = b;
                        i2 = i5;
                        i = 1000;
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", e, "", new Object[0]);
                    str = ab.getContext().getString(R.l.ffj);
                    i2 = 2;
                    i = 1000;
                }
            }
        } else {
            Map q = bh.q(str, "e");
            if (q != null) {
                w.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
                str = (String) q.get(".e.Content");
            } else {
                str = ab.getContext().getString(R.l.ffj);
            }
        }
        if (i != 0) {
            w.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + akg() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.gUD.a(i, i2, str, this);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public int akg() {
        return -1;
    }

    public final int aHY() {
        return akg();
    }
}
