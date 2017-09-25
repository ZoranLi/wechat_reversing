package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u {
    public static String TAG = "MicroMsg.WalletIndexPayMenu";
    public List<a> fRK = new LinkedList();

    public static class a {
        public int rHI;
        public String rHJ;
        public String rHK;
        public String rHL;
        public String rHM;
    }

    public u() {
        ap.yY();
        String str = (String) c.vr().get(com.tencent.mm.storage.w.a.uIc, "");
        this.fRK.clear();
        if (!bg.mA(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.rHI = jSONObject.optInt("paymenu_jump_type");
                    aVar.rHJ = jSONObject.optString("paymenu_jump_url");
                    aVar.rHK = jSONObject.optString("paymenu_path");
                    aVar.rHL = jSONObject.optString("paymenu_title");
                    aVar.rHM = jSONObject.optString("paymenu_username");
                    this.fRK.add(aVar);
                }
            } catch (JSONException e) {
            }
        }
    }

    public static void HV(String str) {
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uIc, str);
    }
}
