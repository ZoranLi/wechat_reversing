package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

final class dk {
    public String fZF;
    public String hir;
    public String hkq;
    public String hkr;
    public String hks;
    public String hkt;
    public String hku;
    public long time;
    public String title;
    public int type;
    public String url;

    dk() {
    }

    public static dk ai(Map<String, String> map) {
        dk dkVar = new dk();
        dkVar.title = (String) map.get(".msg.appmsg.mmreader.category.item.title");
        dkVar.url = (String) map.get(".msg.appmsg.mmreader.category.item.url");
        dkVar.fZF = (String) map.get(".msg.appmsg.mmreader.category.item.native_url");
        dkVar.hkq = (String) map.get(".msg.appmsg.mmreader.category.item.shorturl");
        dkVar.hkr = (String) map.get(".msg.appmsg.mmreader.category.item.longurl");
        dkVar.time = bg.getLong((String) map.get(".msg.appmsg.mmreader.category.item.pub_time"), 0);
        dkVar.hks = (String) map.get(".msg.appmsg.mmreader.category.item.cover");
        dkVar.hkt = (String) map.get(".msg.appmsg.mmreader.category.item.tweetid");
        dkVar.hku = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        dkVar.type = bg.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
        dkVar.hir = (String) map.get(".msg.appmsg.template_id");
        return dkVar;
    }
}
