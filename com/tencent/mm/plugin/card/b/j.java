package com.tencent.mm.plugin.card.b;

import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.c.jn;
import com.tencent.mm.protocal.c.jo;
import com.tencent.mm.protocal.c.jp;
import com.tencent.mm.protocal.c.wo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    public static void a(LinkedList<jn> linkedList, int i) {
        if (linkedList != null) {
            int size = linkedList.size();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                jn jnVar = (jn) linkedList.get(i2);
                c aga = al.aga();
                String str = jnVar.fVl;
                int i3 = ((size - i2) * 10) + i;
                String str2 = jnVar.khm;
                int i4 = jnVar.kdL;
                if (bg.mA(str)) {
                    w.w("MicroMsg.CardInfoStorage", "cardId null");
                } else {
                    aga.gUz.eE("UserCardInfo", "update UserCardInfo set stickyIndex=" + i3 + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + i4 + " where card_id='" + str + "'");
                }
            }
        }
    }

    public static void F(LinkedList<jn> linkedList) {
        if (linkedList != null) {
            for (int i = 0; i < linkedList.size(); i++) {
                jn jnVar = (jn) linkedList.get(i);
                al.aga().gUz.eE("UserCardInfo", "update UserCardInfo set stickyIndex=0" + ", label_wording='" + (jnVar.tpy != null ? jnVar.tpy : "") + "' where card_id='" + jnVar.fVl + "'");
            }
        }
    }

    public static wo sZ(String str) {
        boolean z = true;
        if (bg.mA(str)) {
            w.w("MicroMsg.CardStickyHelper", "jsonRet null");
            return null;
        }
        wo woVar = new wo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            woVar.tDe = jSONObject.optString("layout_buff");
            jSONObject = jSONObject.getJSONObject("list");
            if (jSONObject == null) {
                return woVar;
            }
            woVar.tDh = new jp();
            woVar.tDh.tpA = w(jSONObject.optJSONObject("expiring_list"));
            woVar.tDh.tpB = w(jSONObject.optJSONObject("member_card_list"));
            woVar.tDh.tpC = w(jSONObject.optJSONObject("nearby_list"));
            woVar.tDh.tpD = w(jSONObject.optJSONObject("label_list"));
            woVar.tDi = jSONObject.optString("red_dot_wording");
            if (jSONObject.optInt("show_red_dot", 0) != 1) {
                z = false;
            }
            woVar.tDj = z;
            Object optString = jSONObject.optString("title");
            if (optString == null) {
                optString = "";
            }
            al.agf().putValue("key_card_entrance_tips", optString);
            woVar.tDk = jSONObject.optInt("top_scene", 100);
            return woVar;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
            return woVar;
        }
    }

    private static jo w(JSONObject jSONObject) {
        if (jSONObject == null) {
            w.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
            return null;
        }
        jo joVar = new jo();
        joVar.tpz = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("item_list");
            for (int i = 0; i < jSONArray.length(); i++) {
                jn jnVar;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    jnVar = null;
                } else {
                    jnVar = new jn();
                    jnVar.khm = jSONObject2.optString("announcement");
                    jnVar.fVl = jSONObject2.optString("card_id");
                    jnVar.kdL = jSONObject2.optInt("end_time", 0);
                    jnVar.tpx = jSONObject2.optInt("update_time", 0);
                    jnVar.tpy = jSONObject2.optString("label_wording");
                }
                if (jnVar == null || (((long) jnVar.kdL) <= bg.Ny() && jnVar.kdL != 0)) {
                    w.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
                } else {
                    joVar.tpz.add(jnVar);
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        return joVar;
    }
}
