package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bg;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa extends z {
    public String nmh;
    public String nmp;

    public aa(String str, String str2, String str3, String str4) {
        this.nmp = str3;
        this.nmh = str2;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("receiveId", str3);
        hashMap.put("wishing", URLEncoder.encode(bg.mz(str2)));
        hashMap.put("ver", str4);
        x(hashMap);
    }

    public final int getType() {
        return 1682;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/wishwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
