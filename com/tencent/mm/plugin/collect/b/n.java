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

public final class n extends h {
    private int aIo;
    public boolean hoD;
    public boolean kAU;
    public int kAV;
    public int kAW;
    public int kAX;
    public int kAY;
    public String kAZ;
    public long kAw;
    public List<f> kBa;

    public n(int i, long j, int i2, int i3) {
        this.hoD = false;
        this.kAU = false;
        this.kBa = new ArrayList();
        this.aIo = i2;
        this.kAW = 0;
        Map hashMap = new HashMap();
        hashMap.put(Columns.TYPE, String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("direction_flag", new StringBuilder("0").toString());
        hashMap.put("num", String.valueOf(i2));
        hashMap.put("choose_flag", String.valueOf(i3));
        x(hashMap);
    }

    public n(int i, long j, int i2, int i3, int i4, int i5) {
        this.hoD = false;
        this.kAU = false;
        this.kBa = new ArrayList();
        this.kAU = true;
        this.aIo = i3;
        this.kAW = i2;
        Map hashMap = new HashMap();
        hashMap.put(Columns.TYPE, String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("direction_flag", String.valueOf(i2));
        hashMap.put("num", String.valueOf(i3));
        hashMap.put("choose_flag", String.valueOf(i4));
        hashMap.put("try_num", String.valueOf(i5));
        x(hashMap);
    }

    public final int aki() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvrcdhissta";
    }

    public final int zi() {
        return 1993;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", new Object[]{jSONObject.toString()});
        this.kAV = jSONObject.optInt("choose_flag", 0);
        this.kAw = jSONObject.optLong("from_timestamp", -1);
        this.kAX = jSONObject.optInt("finish_flag", 0);
        this.kAY = jSONObject.optInt("try_num", 0);
        this.kAZ = jSONObject.optString("retmsg", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            w.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    f fVar = new f();
                    fVar.type = jSONObject2.optInt(Columns.TYPE, 0);
                    fVar.kAw = jSONObject2.optLong("from_timestamp", 0);
                    fVar.kAx = jSONObject2.optInt("total_num", 0);
                    fVar.kAy = jSONObject2.optInt("total_amt", 0);
                    this.kBa.add(fVar);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.kAX == 1) {
            w.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
            this.hoD = true;
        }
    }
}
