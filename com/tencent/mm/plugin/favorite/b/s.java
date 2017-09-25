package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class s {
    public static void a(Map<String, String> map, sd sdVar) {
        if (map == null || sdVar == null) {
            w.w("MicroMsg.FavTagParser", "maps is null or item is null");
            return;
        }
        sdVar.tzx.clear();
        int i = 0;
        while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            String str = (String) map.get(".favitem.taglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            sdVar.tzx.add(str);
            i++;
        }
        if (!sdVar.tzx.isEmpty()) {
            w.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[]{sdVar.tzx});
        }
        sdVar.tzw.clear();
        i = 0;
        while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str = (String) map.get(".favitem.recommendtaglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            sdVar.tzw.add(str);
            i++;
        }
        if (!sdVar.tzw.isEmpty()) {
            w.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[]{sdVar.tzw});
        }
    }

    public static String a(sd sdVar) {
        int i = 0;
        if (sdVar == null || (sdVar.tzx.isEmpty() && sdVar.tzw.isEmpty())) {
            w.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
            return "";
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int size = sdVar.tzx.size();
        stringBuffer.append("<taglist count='").append(size).append("'>");
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bg.PW((String) sdVar.tzx.get(i2))).append("</tag>");
        }
        stringBuffer.append("</taglist>");
        i2 = sdVar.tzw.size();
        stringBuffer.append("<recommendtaglist count='").append(i2).append("'>");
        while (i < i2) {
            stringBuffer.append("<tag>").append(bg.PW((String) sdVar.tzw.get(i))).append("</tag>");
            i++;
        }
        stringBuffer.append("</recommendtaglist>");
        return stringBuffer.toString();
    }
}
