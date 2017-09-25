package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.Map;

public final class c {

    public static class a {
        public String field_id;
        public String field_playstatid;
        public String field_playurl;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public String field_topic;
        public String field_xml;
        public LinkedList<a> per;
    }

    public static a En(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        Map q = bh.q(str, "tv");
        if (q == null) {
            return null;
        }
        a aVar = new a();
        aVar.field_id = bg.mz((String) q.get(str2 + ".tv.id"));
        aVar.field_topic = bg.mz((String) q.get(str2 + ".tv.topic"));
        aVar.field_title = bg.mz((String) q.get(str2 + ".tv.title"));
        aVar.field_subtitle = bg.mz((String) q.get(str2 + ".tv.subtitle"));
        aVar.field_thumburl = bg.mz((String) q.get(str2 + ".tv.thumburl"));
        aVar.field_shareurl = bg.mz((String) q.get(str2 + ".tv.shareurl"));
        aVar.field_playurl = bg.mz((String) q.get(str2 + ".tv.playurl"));
        aVar.field_playstatid = bg.mz((String) q.get(str2 + ".tv.playurl$statid"));
        aVar.field_source = bg.mz((String) q.get(str2 + ".tv.source"));
        aVar.per = a.j(q, str2 + ".tv");
        aVar.field_xml = str;
        return aVar;
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("<tv>");
        if (!bg.mA(aVar.field_id)) {
            stringBuilder.append("<id>" + bg.PW(aVar.field_id) + "</id>");
        }
        stringBuilder.append("<title>" + bg.PW(aVar.field_title) + "</title>");
        stringBuilder.append("<subtitle>" + bg.PW(aVar.field_subtitle) + "</subtitle>");
        stringBuilder.append("<topic>" + bg.PW(aVar.field_topic) + "</topic>");
        stringBuilder.append("<thumburl>" + bg.PW(aVar.field_thumburl) + "</thumburl>");
        stringBuilder.append("<shareurl>" + bg.PW(aVar.field_shareurl) + "</shareurl>");
        if (bg.mA(aVar.field_playstatid)) {
            stringBuilder.append("<playurl>" + bg.PW(aVar.field_playurl) + "</playurl>");
        } else {
            stringBuilder.append("<playurl statid=\"" + aVar.field_playstatid + "\">" + bg.PW(aVar.field_playurl) + "</playurl>");
        }
        stringBuilder.append("<source>" + bg.PW(aVar.field_source) + "</source>");
        stringBuilder.append("</tv>");
        return stringBuilder.toString();
    }

    public static String a(Context context, a aVar) {
        com.tencent.mm.t.f.a aVar2 = new com.tencent.mm.t.f.a();
        aVar2.title = aVar.field_title;
        if (bg.mA(aVar.field_topic)) {
            aVar2.description = aVar.field_subtitle;
        } else {
            aVar2.description = aVar.field_topic;
        }
        aVar2.type = 20;
        aVar2.url = aVar.field_shareurl;
        aVar2.action = "";
        if (k.baQ()) {
            aVar2.appName = context.getString(R.l.ePu);
            aVar2.appId = "wxaf060266bfa9a35c";
        }
        aVar2.thumburl = aVar.field_thumburl;
        aVar2.hhP = b(aVar);
        return com.tencent.mm.t.f.a.a(aVar2, null, null);
    }
}
