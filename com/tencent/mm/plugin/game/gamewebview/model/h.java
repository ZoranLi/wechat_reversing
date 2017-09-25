package com.tencent.mm.plugin.game.gamewebview.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class h {
    public static void c(d dVar) {
        dVar.xJ(GameJsApiSendAppMessage.NAME);
        if (dVar.aY(GameJsApiSendAppMessage.NAME, 89)) {
            dVar.ck("menu:share:appmessage", "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String IU = dVar.IU();
            jSONObject.put("link", IU);
            jSONObject.put("desc", IU);
            jSONObject.put("title", dVar.getTitle());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
        }
        dVar.cl(GameJsApiSendAppMessage.NAME, jSONObject.toString());
    }

    public static void a(d dVar, JSONObject jSONObject) {
        int i;
        String substring;
        String optString = jSONObject.optString("link");
        c.d dVar2 = (c.d) dVar.mnj.get(dVar.azN());
        if (TextUtils.isEmpty(optString) || dVar2 == null || dVar2.sjK == null || dVar2.sjK.size() <= 0) {
            i = 0;
        } else {
            int i2;
            List<String> linkedList = new LinkedList();
            int indexOf = optString.indexOf("://");
            String substring2 = optString.substring((indexOf == -1 ? 1 : 3) + indexOf);
            for (String substring3 : dVar2.sjK) {
                if (!TextUtils.isEmpty(substring3)) {
                    int indexOf2 = substring3.indexOf("://");
                    if (indexOf2 == -1) {
                        i2 = 1;
                    } else {
                        i2 = 3;
                    }
                    substring3 = substring3.substring(i2 + indexOf2);
                    if (substring2.startsWith(substring3)) {
                        i2 = 0;
                        break;
                    } else if (!substring3.contains("/")) {
                        linkedList.add(substring3);
                    }
                }
            }
            i2 = 1;
            if (!(i2 == 0 || linkedList.isEmpty())) {
                String host = URI.create(optString).getHost();
                for (String substring32 : linkedList) {
                    if (host.endsWith(substring32)) {
                        i = 0;
                        break;
                    }
                }
            }
            i = i2;
        }
        if (i != 0) {
            try {
                substring32 = dVar.IU();
                jSONObject.put("img_url", "");
                jSONObject.put("link", substring32);
                jSONObject.put("desc", substring32);
                jSONObject.put("title", dVar.getTitle());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
            }
        }
    }
}
