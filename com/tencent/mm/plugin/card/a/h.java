package com.tencent.mm.plugin.card.a;

import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.t.f.a;
import java.util.Map;

public final class h {
    public int hiC;
    public String hiD;
    public String hiE;
    public String hiF;
    public String hiG;
    public String hiH;
    public String hiI;
    public String hiJ;
    public int ver;

    public static h b(a aVar) {
        Map map = aVar.hjZ;
        h hVar = new h();
        hVar.hiD = bg.ap((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
        hVar.hiC = o.aY((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
        hVar.hiE = bg.ap((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
        hVar.hiF = bg.ap((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        hVar.hiG = bg.ap((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
        hVar.hiH = bg.ap((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        hVar.hiI = bg.ap((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
        hVar.hiJ = bg.ap((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
        hVar.ver = o.aY((String) map.get(".msg.appmsg.giftcard_info.ver"));
        return hVar;
    }
}
