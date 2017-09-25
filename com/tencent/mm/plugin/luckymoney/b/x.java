package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x extends z {
    public g nnG;
    public List<String> nnH;
    public String nnI;
    public String nnJ = null;
    public String nnw;

    public x(int i, int i2, int i3, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put(Columns.TYPE, String.valueOf(i3));
        hashMap.put("year", str);
        hashMap.put("ver", str2);
        hashMap.put("processContent", str3);
        x(hashMap);
    }

    public final int getType() {
        return 1514;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/qrylistwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            int i2;
            g gVar = new g();
            gVar.nmF = jSONObject.optInt("recTotalNum");
            gVar.nmG = jSONObject.optLong("recTotalAmount");
            gVar.nmH = jSONObject.optInt("sendTotalNum");
            gVar.nmI = jSONObject.optLong("sendTotalAmount");
            gVar.nms = jSONObject.optInt("isContinue");
            gVar.hPS = jSONObject.optInt("gameCount");
            JSONArray optJSONArray = jSONObject.optJSONArray("record");
            LinkedList linkedList = new LinkedList();
            if (optJSONArray != null) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    h hVar = new h();
                    hVar.nmJ = jSONObject2.optString("sendName");
                    hVar.nmj = jSONObject2.optString("sendHeadImg");
                    hVar.nmK = jSONObject2.optLong("receiveAmount");
                    hVar.nmL = jSONObject2.optString("receiveTime");
                    hVar.nme = jSONObject2.optInt("hbType");
                    hVar.nmM = jSONObject2.optString("sendTitle");
                    hVar.nmN = jSONObject2.optString("sendTime");
                    hVar.nmo = jSONObject2.optLong("totalAmount");
                    hVar.nmO = jSONObject2.optLong("totalNum");
                    hVar.nmm = jSONObject2.optLong("recNum");
                    hVar.status = jSONObject2.optInt(DownloadInfo.STATUS);
                    hVar.nmP = jSONObject2.optInt("thxCount");
                    hVar.nmp = jSONObject2.optString("receiveId");
                    hVar.njw = jSONObject2.optString("sendId");
                    hVar.nmA = jSONObject2.optInt("hbKind");
                    linkedList.add(hVar);
                }
            }
            gVar.nmB = linkedList;
            this.nnG = gVar;
            this.nnH = new ArrayList();
            String optString = jSONObject.optString("years");
            if (!bg.mA(optString)) {
                String[] split = optString.split("\\|");
                if (split != null) {
                    for (Object add : split) {
                        this.nnH.add(add);
                    }
                }
            }
            this.nnI = jSONObject.optString("recordYear");
            this.nnJ = jSONObject.optString("clickedUrl");
            this.nnw = jSONObject.optString("processContent");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", e, "", new Object[0]);
        }
    }

    public final boolean aHZ() {
        if (this.nnG == null || this.nnG.nms == 1) {
            return true;
        }
        return false;
    }
}
