package com.tencent.mm.wallet_core.f.a;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import org.json.JSONObject;

public class e extends k {
    protected JSONObject wEB;
    public boolean wEC = false;
    public int wED = 0;
    public boolean wEE = false;

    public e(Map<String, String> map) {
        w.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
        x(map);
    }

    public final int aki() {
        return 1525;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payorderquery";
    }

    public int zi() {
        return 1525;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (r.ijT) {
            try {
                jSONObject = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
            } catch (Exception e) {
            }
        }
        w.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + i + "errMsg=" + str);
        this.wEB = jSONObject;
        if (jSONObject != null) {
            boolean z;
            w.d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", new Object[]{jSONObject.toString()});
            if (jSONObject.optInt("can_pay_retry") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.wEC = z;
            this.wED = jSONObject.optInt("show_retmsg_type");
        }
    }

    public final JSONObject ccs() {
        return this.wEB;
    }
}
