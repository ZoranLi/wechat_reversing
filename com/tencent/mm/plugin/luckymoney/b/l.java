package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.n;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l {
    public static e z(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            eVar.nme = jSONObject.optInt("hbType");
            eVar.fZG = jSONObject.optInt("hbStatus");
            eVar.nmf = jSONObject.optString("statusMess");
            eVar.nmg = jSONObject.optString("gameMess");
            eVar.nmh = jSONObject.optString("wishing");
            eVar.nmi = jSONObject.optString("sendNick");
            eVar.nmj = jSONObject.optString("sendHeadImg");
            eVar.njw = jSONObject.optString("sendId");
            eVar.nmk = jSONObject.optString("adMessage");
            eVar.nml = jSONObject.optString("adUrl");
            eVar.fZT = jSONObject.optLong("amount");
            eVar.nmm = jSONObject.optLong("recNum");
            eVar.nmn = jSONObject.optLong("recAmount");
            eVar.kAx = jSONObject.optInt("totalNum");
            eVar.nmo = jSONObject.optLong("totalAmount");
            eVar.nmp = jSONObject.optString("receiveId");
            eVar.nmq = jSONObject.optInt("hasWriteAnswer");
            eVar.nmr = jSONObject.optInt("isSender");
            eVar.nms = jSONObject.optInt("isContinue");
            eVar.nmt = jSONObject.optString("headTitle");
            eVar.fZH = jSONObject.optInt("receiveStatus");
            eVar.nmu = jSONObject.optInt("canShare");
            eVar.njA = jSONObject.optInt("jumpChange");
            eVar.njC = jSONObject.optString("changeWording");
            eVar.njB = jSONObject.optString("changeUrl");
            eVar.nmA = jSONObject.optInt("hbKind");
            eVar.njD = jSONObject.optString("externMess");
            eVar.nmD = jSONObject.optString("sendUserName");
            if (bg.mA(eVar.nmi) && !bg.mA(eVar.nmD)) {
                eVar.nmi = n.eK(eVar.nmD);
            }
            eVar.nmv = new a();
            JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
            if (optJSONObject != null) {
                eVar.nmv.gPD = optJSONObject.optInt("enable");
                eVar.nmv.nlQ = optJSONObject.optString("fissionContent");
                eVar.nmv.nlP = optJSONObject.optString("fissionUrl");
            }
            eVar.nmw = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("operationHeader");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    eVar.nmw.add(B(optJSONArray.getJSONObject(i)));
                }
            }
            eVar.nmy = jSONObject.optString("watermark");
            eVar.nmz = jSONObject.optString("context");
            eVar.nmC = jSONObject.optString("contextMd5");
            eVar.resourceId = jSONObject.optInt("resourceId");
            eVar.nmx = B(jSONObject.optJSONObject("operationTail"));
            eVar.nmB = A(jSONObject);
        }
        return eVar;
    }

    private static LinkedList<m> A(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("record");
        LinkedList<m> linkedList = new LinkedList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                m mVar = new m();
                if (jSONObject2 != null) {
                    mVar.nmX = jSONObject2.optString("receiveName");
                    mVar.nmY = jSONObject2.optString("receiveHeadImg");
                    mVar.nmK = jSONObject2.optLong("receiveAmount");
                    mVar.nmL = jSONObject2.optString("receiveTime");
                    mVar.nmZ = jSONObject2.optString("answer");
                    mVar.nmp = jSONObject2.optString("receiveId");
                    mVar.nna = jSONObject2.optString("gameTips");
                    mVar.userName = jSONObject2.optString("userName");
                    if (bg.mA(mVar.nmX) && !bg.mA(mVar.userName)) {
                        mVar.nmX = n.eK(mVar.userName);
                    }
                }
                linkedList.add(mVar);
            }
        }
        return linkedList;
    }

    public static ag B(JSONObject jSONObject) {
        ag agVar = new ag();
        if (jSONObject != null) {
            agVar.gPD = jSONObject.optInt("enable", 0);
            agVar.content = jSONObject.optString("content");
            agVar.iconUrl = jSONObject.optString("iconUrl");
            agVar.type = jSONObject.optString(Columns.TYPE);
            agVar.name = jSONObject.optString("name");
            agVar.nnX = jSONObject.optInt("ossKey");
            agVar.nnY = jSONObject.optInt("focus");
        }
        return agVar;
    }
}
