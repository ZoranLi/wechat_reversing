package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends h {
    public List<l> szx;
    public int szy;
    public String token;

    public e(String str) {
        Map hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        x(hashMap);
    }

    public final int aki() {
        return 59;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.token = jSONObject.getString("session_key");
                this.szy = jSONObject.optInt("answer_times_left", -1);
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    Map hashMap = new HashMap();
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        l lVar = new l();
                        lVar.id = jSONObject2.getString("qt_id");
                        lVar.szR = jSONObject2.getString("parent_id");
                        lVar.type = jSONObject2.getString("qt_type");
                        lVar.desc = jSONObject2.getString("qt_cont");
                        lVar.szS = jSONObject2.getInt("ans_len");
                        lVar.khk = jSONObject2.getString("wording");
                        lVar.level = jSONObject2.getInt("level");
                        if (!hashMap.containsKey(lVar.szR) || "0".equals(lVar.szR)) {
                            hashMap.put(lVar.id, lVar);
                        } else {
                            ((l) hashMap.get(lVar.szR)).szT = lVar;
                        }
                    }
                    this.szx = new ArrayList(hashMap.values());
                    hashMap.clear();
                }
            } catch (Throwable e) {
                w.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
