package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o extends h {
    private int aIo;
    public boolean hoD = false;
    public long kAw;
    public int kAx;
    public int kAy;
    public List<a> kBa = new ArrayList();
    public int type;

    public o(int i, long j, String str, int i2) {
        this.aIo = i2;
        Map hashMap = new HashMap();
        hashMap.put(Columns.TYPE, String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("last_bill_id", str);
        hashMap.put("num", String.valueOf(i2));
        x(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlist";
    }

    public final int zi() {
        return 1963;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kAx = jSONObject.optInt("total_num");
        this.kAy = jSONObject.optInt("total_amt");
        this.kAw = jSONObject.optLong("from_timestamp", 0);
        this.type = jSONObject.optInt(Columns.TYPE, 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            w.i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    a aVar = new a();
                    aVar.kAi = jSONObject2.optString("bill_id");
                    aVar.kAj = jSONObject2.optString("trans_id");
                    aVar.timestamp = jSONObject2.optLong("timestamp", 0);
                    aVar.desc = jSONObject2.optString("desc");
                    aVar.bPo = jSONObject2.optInt("fee", 0);
                    this.kBa.add(aVar);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.kBa.size() < this.aIo) {
            w.i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
            this.hoD = true;
        }
    }
}
