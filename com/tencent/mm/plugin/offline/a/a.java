package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends k {
    private final b gUA;
    private e gUD;
    private ArrayList<String> iUM;
    private String ocp;
    private String ocq;

    public final int getType() {
        return 606;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void d(int i, int i2, String str, p pVar) {
        if (i != 0) {
            w.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : 606" + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        zn znVar = (zn) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            try {
                if (!TextUtils.isEmpty(znVar.tFP)) {
                    JSONObject jSONObject = new JSONObject(znVar.tFP);
                    int optInt = jSONObject.optInt("InitValue");
                    int optInt2 = jSONObject.optInt("FastChangedLimit");
                    this.ocq = jSONObject.optString("guide_tips");
                    com.tencent.mm.plugin.offline.c.a.qP(optInt);
                    com.tencent.mm.plugin.offline.c.a.qQ(optInt2);
                    w.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + optInt + " fastChangeValue:" + optInt2);
                }
                if (!TextUtils.isEmpty(znVar.tFQ)) {
                    D(new JSONObject(znVar.tFQ));
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ab.getContext().getString(R.l.ffj);
            }
        }
        if (this.gUD != null) {
            this.gUD.a(i, i2, str, this);
        }
    }

    private void D(JSONObject jSONObject) {
        this.ocp = jSONObject.optString("micropay_tips");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("head_url_list");
            if (jSONArray != null && jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.iUM.add((String) jSONArray.get(i));
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
        }
    }
}
