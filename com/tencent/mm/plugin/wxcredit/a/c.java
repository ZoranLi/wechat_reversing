package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c extends h {
    public double szv = 0.0d;

    public c(List<l> list, String str) {
        Map hashMap = new HashMap();
        hashMap.put("session_key", str);
        int i = 0;
        for (l lVar : list) {
            int i2;
            hashMap.put("qt_id_" + i, lVar.id);
            hashMap.put("ans_cont_" + i, lVar.nmZ);
            hashMap.put("level_" + i, lVar.level);
            hashMap.put("parent_id_" + i, lVar.szR);
            i++;
            if (lVar.szT == null || !"Y".equals(lVar.nmZ)) {
                i2 = i;
            } else {
                hashMap.put("qt_id_" + i, lVar.szT.id);
                hashMap.put("ans_cont_" + i, lVar.szT.nmZ);
                hashMap.put("level_" + i, lVar.szT.level);
                hashMap.put("parent_id_" + i, lVar.szT.szR);
                i2 = i + 1;
            }
            i = i2;
        }
        hashMap.put("total_num", String.valueOf(i));
        x(hashMap);
    }

    public final int aki() {
        return 60;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.szv = ((double) jSONObject.getInt("credit_amount")) / 100.0d;
            } catch (Throwable e) {
                w.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
