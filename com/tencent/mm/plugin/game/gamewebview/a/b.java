package com.tencent.mm.plugin.game.gamewebview.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.z;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<String, Integer> mjn;

    static {
        Map hashMap = new HashMap();
        mjn = hashMap;
        hashMap.put(a.NAME, Integer.valueOf(1));
        mjn.put(f.NAME, Integer.valueOf(2));
        mjn.put(af.NAME, Integer.valueOf(3));
        mjn.put(ak.NAME, Integer.valueOf(4));
        mjn.put(z.NAME, Integer.valueOf(5));
        mjn.put(ac.NAME, Integer.valueOf(6));
        mjn.put(GameJsApiSendAppMessage.NAME, Integer.valueOf(7));
    }

    public static int xs(String str) {
        if (mjn.containsKey(str)) {
            return ((Integer) mjn.get(str)).intValue();
        }
        return 0;
    }
}
