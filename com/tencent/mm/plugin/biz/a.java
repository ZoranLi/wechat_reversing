package com.tencent.mm.plugin.biz;

import android.text.TextUtils;
import com.tencent.mm.modelbiz.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.h;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.mm.u.o;
import java.util.Iterator;
import java.util.Map;

public final class a implements com.tencent.mm.plugin.biz.a.a {
    public final String bq(String str, String str2) {
        String str3;
        Map q = bh.q(str, "msg");
        if (q == null) {
            w.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
            str3 = null;
        } else {
            str3 = (String) q.get(".msg.fromusername");
        }
        if (!bg.mA(str3) || o.fu(str2)) {
            str2 = str3;
        }
        if (bg.mA(str2)) {
            return "";
        }
        if (h.em(str2)) {
            WxaAttributes og = ((b) com.tencent.mm.kernel.h.h(b.class)).og(str2);
            if (!(og == null || TextUtils.isEmpty(og.field_nickname))) {
                return og.field_nickname;
            }
        }
        return ((com.tencent.mm.plugin.messenger.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.a.a.class)).eK(str2);
    }

    public final boolean em(String str) {
        return h.em(str);
    }

    public final String rT(String str) {
        Map q = bh.q(str, "msg");
        if (q == null) {
            w.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
            return " ";
        }
        int i = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        String ap = bg.ap((String) q.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        ap = (ap.equals("wx_f2f") || ap.equals("wx_md")) ? bg.mz((String) q.get(".msg.appmsg.title")) : i != 0 ? bg.mz((String) q.get(".msg.appmsg.mmreader.template_header.title")) : (String) q.get(".msg.appmsg.mmreader.category.item.title");
        return bg.mA(ap) ? " " : ap;
    }

    public final String rU(String str) {
        Map PF = aw.PF(str);
        if (PF == null) {
            k en = h.en(str);
            StringBuilder stringBuilder = new StringBuilder("");
            Iterator it = en.hkm.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (!bg.mA(lVar.title)) {
                    stringBuilder.append(lVar.title);
                    break;
                }
            }
            return stringBuilder.toString();
        }
        String str2 = (String) PF.get(".msg.appmsg.mmreader.category.item.title");
        return str2 == null ? "" : str2;
    }

    public final k rV(String str) {
        Map PF = aw.PF(str);
        if (PF == null) {
            return h.en(str);
        }
        int i = bg.getInt((String) PF.get(".msg.appmsg.mmreader.category.$type"), 0);
        String mz = bg.mz((String) PF.get(".msg.appmsg.mmreader.name"));
        int i2 = bg.getInt((String) PF.get(".msg.appmsg.mmreader.forbid_forward"), 0);
        int i3 = bg.getInt((String) PF.get(".msg.appmsg.mmreader.category.$count"), 0);
        String str2 = (String) PF.get(".msg.commenturl");
        k kVar = new k();
        kVar.type = i;
        kVar.name = mz;
        kVar.gxD = str2;
        kVar.hkn = i2;
        i = 0;
        while (i < i3) {
            l lVar = new l();
            String str3 = ".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i));
            lVar.title = (String) PF.get(str3 + ".title");
            lVar.url = (String) PF.get(str3 + ".url");
            lVar.hkq = (String) PF.get(str3 + ".shorturl");
            lVar.hkr = (String) PF.get(str3 + ".longurl");
            lVar.time = bg.getLong((String) PF.get(str3 + ".pub_time"), 0);
            lVar.hkt = (String) PF.get(str3 + ".tweetid");
            lVar.hku = (String) PF.get(str3 + ".digest");
            lVar.type = bg.getInt((String) PF.get(str3 + ".itemshowtype"), 0);
            lVar.hkw = bg.getInt((String) PF.get(str3 + ".play_length"), 0);
            lVar.hks = (String) PF.get(str3 + ".cover");
            lVar.hkv = bg.getInt((String) PF.get(str3 + ".del_flag"), 0);
            lVar.hkx = (String) PF.get(str3 + ".weapp_username");
            lVar.hky = (String) PF.get(str3 + ".weapp_path");
            lVar.hkz = bg.getInt((String) PF.get(str3 + ".weapp_version"), 0);
            lVar.hkA = bg.getInt((String) PF.get(str3 + ".weapp_state"), 0);
            lVar.hkB = (String) PF.get(str3 + ".weapp_appid");
            lVar.hkC = (String) PF.get(str3 + ".weapp_image_url");
            lVar.hkD = (String) PF.get(str3 + ".weapp_icon");
            lVar.hkE = (String) PF.get(str3 + ".weapp_nickname");
            kVar.hkm.add(lVar);
            i++;
        }
        kVar.hhm = i.l(PF);
        String mz2 = bg.mz((String) PF.get(".msg.fromusername"));
        if (!bg.mA(mz2)) {
            str2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(mz2).tK();
            kVar.fUR = mz2;
            kVar.fUS = str2;
        }
        return kVar;
    }
}
