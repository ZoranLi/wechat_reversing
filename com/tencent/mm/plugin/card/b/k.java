package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k {
    public static LinkedList<jc> aE(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                w.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
                return null;
            }
            LinkedList<jc> linkedList = new LinkedList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                jc jcVar = new jc();
                jcVar.kdE = optJSONObject.optString(i == 26 ? "cardId" : "card_id");
                jcVar.code = optJSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                linkedList.add(jcVar);
            }
            return linkedList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
