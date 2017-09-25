package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public final class g {
    public static d sV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        Map q = bh.q(str, "msg");
        dVar.keR = (String) q.get(".msg.appmsg.carditem.from_username");
        dVar.fVl = (String) q.get(".msg.appmsg.carditem.card_id");
        dVar.kdF = sX((String) q.get(".msg.appmsg.carditem.card_type"));
        dVar.fVn = sX((String) q.get(".msg.appmsg.carditem.from_scene"));
        dVar.hib = (String) q.get(".msg.appmsg.carditem.color");
        dVar.keS = (String) q.get(".msg.appmsg.carditem.card_type_name");
        dVar.keT = (String) q.get(".msg.appmsg.carditem.brand_name");
        dVar.fVm = (String) q.get(".msg.appmsg.carditem.card_ext");
        dVar.keU = sX((String) q.get(".msg.appmsg.carditem.is_recommend"));
        dVar.keV = (String) q.get(".msg.appmsg.carditem.recommend_card_id");
        return dVar;
    }

    public static String sW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) bh.q(str, "msg").get(".msg.appmsg.fromusername");
    }

    private static int sX(String str) {
        if (TextUtils.isEmpty(str) || !l.tb(str)) {
            return 0;
        }
        return Integer.valueOf(str).intValue();
    }

    public static String a(d dVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<from_username>").append(dVar.keR).append("</from_username>");
        stringBuilder.append("<card_id>").append(dVar.fVl).append("</card_id>");
        stringBuilder.append("<card_type>").append(dVar.kdF).append("</card_type>");
        stringBuilder.append("<from_scene>").append(dVar.fVn).append("</from_scene>");
        stringBuilder.append("<color>").append(dVar.hib).append("</color>");
        stringBuilder.append("<card_type_name>").append(dVar.keS).append("</card_type_name>");
        stringBuilder.append("<brand_name>").append(dVar.keT).append("</brand_name>");
        if (TextUtils.isEmpty(dVar.fVm)) {
            stringBuilder.append("<card_ext></card_ext>");
        } else {
            stringBuilder.append("<card_ext>").append(dVar.fVm).append("</card_ext>");
        }
        stringBuilder.append("<is_recommend>").append(dVar.keU).append("</is_recommend>");
        stringBuilder.append("<recommend_card_id>").append(dVar.keV).append("</recommend_card_id>");
        return stringBuilder.toString();
    }
}
