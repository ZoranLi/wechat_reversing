package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {
    public static j tj(String str) {
        w.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()");
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser json is empty");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.khb = jSONObject.optString("consumed_box_id");
            jVar.khc = jSONObject.optString("subscribe_wording");
            jVar.khd = jSONObject.optString("subscribe_app_username");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                w.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser cardItemListJson is null");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                q qVar = new q();
                qVar.fVm = optJSONObject.optString("card_ext");
                qVar.keL = f.q(optJSONObject.optJSONObject("card_tp_info"));
                arrayList.add(qVar);
            }
            jVar.kha = arrayList;
            w.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser() tempList size is" + arrayList.size());
            if (TextUtils.isEmpty(jVar.khb)) {
                w.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  consumed_box_id is empty");
            }
            if (TextUtils.isEmpty(jVar.khc)) {
                w.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  subscribe_wording is empty");
            }
            return jVar;
        } catch (Throwable e) {
            w.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser exception:" + e.getMessage());
            w.printErrStackTrace("MicroMsg.ShareCardConsumedInfoParser", e, "", new Object[0]);
            return null;
        }
    }
}
