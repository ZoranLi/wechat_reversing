package com.tencent.mm.wallet_core.b.a;

import com.tencent.mm.R;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends k {
    private b gUA;
    private e gUD;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String akf();

    public abstract int akg();

    public final void x(Map<String, String> map) {
        if (this.gUA == null) {
            com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
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
        w.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + com_tencent_mm_protocal_c_afa.tKk + ", req = " + stringBuilder.toString());
        com_tencent_mm_protocal_c_afa.tKm = new avw().bb(stringBuilder.toString().getBytes());
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + akg() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str + " " + getType());
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
                    b = jSONObject.optString("retmsg");
                    if (bg.mA(b)) {
                        b = com_tencent_mm_protocal_c_afb.errorMsg;
                    }
                    if ((i4 == 0 && i3 == 0) || akh()) {
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
                    w.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", e, "", new Object[0]);
                    str = ab.getContext().getString(R.l.ffj);
                    i2 = 2;
                    i = 1000;
                }
            }
        } else {
            Map q = bh.q(str, "e");
            if (q != null) {
                w.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
                str = (String) q.get(".e.Content");
            } else {
                str = ab.getContext().getString(R.l.ffj);
            }
        }
        if (i != 0) {
            w.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + akg() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.gUD.a(i, i2, str, this);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public boolean akh() {
        return false;
    }
}
