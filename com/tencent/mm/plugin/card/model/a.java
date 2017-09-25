package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public String hib;
    public String jZG;
    public String kdE;
    public int kdF;
    public String kdG;
    public String kdH;
    public String kdI;
    public String kdJ;
    public String kdK;
    public int kdL;
    public String kdM;
    public int kdN;
    public String kdO;
    public String kdP;
    public String kdQ;
    public boolean kdR;
    public String title;
    public String userName;

    public static LinkedList<a> sp(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_cards"), false);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    public static LinkedList<a> sq(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_share_cards"), true);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> a(JSONArray jSONArray, boolean z) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            a aVar = new a();
            aVar.kdE = jSONObject.optString("card_tp_id");
            aVar.kdF = jSONObject.optInt("card_type");
            aVar.hib = jSONObject.optString("color");
            aVar.kdG = jSONObject.optString("logo_url");
            aVar.title = jSONObject.optString("title");
            aVar.kdH = jSONObject.optString("sub_title");
            aVar.kdI = jSONObject.optString("aux_title");
            aVar.kdJ = jSONObject.optString("encrypt_code");
            aVar.userName = jSONObject.optString("from_user_name");
            aVar.kdK = jSONObject.optString("app_id");
            aVar.kdL = jSONObject.optInt("end_time");
            aVar.kdM = jSONObject.optString("card_user_id");
            aVar.kdN = jSONObject.optInt("choose_optional");
            aVar.kdP = jSONObject.optString("invoice_item");
            aVar.kdQ = jSONObject.optString("invoice_status");
            aVar.kdO = jSONObject.optString("invoice_title");
            aVar.kdR = z;
            linkedList.add(aVar);
        }
        return linkedList;
    }
}
