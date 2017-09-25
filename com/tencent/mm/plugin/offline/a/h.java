package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bey;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends k implements j {
    private b gUA;
    private e gUD;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract int aki();

    public final void x(Map<String, String> map) {
        int zi;
        int i = 0;
        if (this.gUA == null) {
            a aVar = new a();
            aVar.hsm = new bey();
            aVar.hsn = new bez();
            String uri = getUri();
            zi = zi();
            aVar.uri = uri;
            aVar.hsl = zi;
            aVar.hso = 185;
            aVar.hsp = 1000000185;
            this.gUA = aVar.BE();
        }
        bey com_tencent_mm_protocal_c_bey = (bey) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bey.tKk = aki();
        com_tencent_mm_protocal_c_bey.tKl = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        for (Object obj : toArray) {
            Object obj2;
            uri = (String) map.get(obj2);
            if (!bg.mA(uri)) {
                if (i2 != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj2);
                stringBuilder.append("=");
                stringBuilder.append(uri);
                i2 = 1;
            }
        }
        String signWith3Des = TenpayUtil.signWith3Des(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        zi = 0;
        while (i < toArray.length) {
            int i3;
            obj2 = toArray[i];
            uri = (String) map.get(obj2);
            if (bg.mA(uri)) {
                i3 = zi;
            } else {
                if (zi != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj2);
                stringBuilder.append("=");
                stringBuilder.append(p.encode(uri));
                i3 = 1;
            }
            i++;
            zi = i3;
        }
        stringBuilder.append(zi != 0 ? "&" : "");
        stringBuilder.append("WCPaySign");
        stringBuilder.append("=");
        stringBuilder.append(signWith3Des);
        com_tencent_mm_protocal_c_bey.tKm = new avw().bb(stringBuilder.toString().getBytes());
    }

    public final int getType() {
        return 385;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aki() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        bez com_tencent_mm_protocal_c_bez = (bez) ((b) pVar).hsk.hsr;
        if (i2 != 0 || i3 != 0) {
            Map q = bh.q(str, "e");
            if (q != null) {
                w.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
                str = (String) q.get(".e.Content");
            }
        } else if (com_tencent_mm_protocal_c_bez.tKo == 0) {
            try {
                JSONObject jSONObject = new JSONObject(n.b(com_tencent_mm_protocal_c_bez.tKn));
                int i4 = jSONObject.getInt("retcode");
                String str2 = com_tencent_mm_protocal_c_bez.tVb;
                if (bg.mA(str2)) {
                    str2 = jSONObject.optString("retmsg");
                }
                int i5 = com_tencent_mm_protocal_c_bez.tVa;
                if (i4 == 0 && i5 == 0) {
                    a(i4, str2, jSONObject);
                } else {
                    w.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : " + i5);
                    if (i5 == 0) {
                        i3 = DownloadResult.CODE_UNDEFINED;
                    } else {
                        i3 = i5;
                    }
                    w.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : " + str2);
                    str = str2;
                    i2 = 1000;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", e, "", new Object[0]);
                str = ab.getContext().getString(R.l.ffj);
                i3 = 2;
                i2 = 1000;
            }
        } else {
            str = com_tencent_mm_protocal_c_bez.tKp;
            i3 = 2;
            i2 = 1000;
        }
        if (i2 != 0) {
            w.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aki() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        }
        this.gUD.a(i2, i3, str, this);
        w.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aki() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int zi() {
        return 385;
    }
}
