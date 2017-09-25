package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.wallet_core.f.a.h;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends h {
    public String kAi;
    public long kAw;
    public int kAx;
    public int kAy;
    public int type;

    public m(String str, int i, long j) {
        this.kAi = str;
        Map hashMap = new HashMap();
        hashMap.put("bill_id", str);
        hashMap.put(Columns.TYPE, String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        x(hashMap);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frmrcvdrcd";
    }

    public final int zi() {
        return 1964;
    }

    public final int aki() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kAx = jSONObject.optInt("total_num", 0);
        this.kAy = jSONObject.optInt("total_amt", 0);
        this.type = jSONObject.optInt(Columns.TYPE, 0);
        this.kAw = jSONObject.optLong("from_timestamp", 0);
    }
}
