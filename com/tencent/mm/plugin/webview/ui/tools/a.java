package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.s;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, Integer> mjn;
    private static final Map<Integer, Integer> saw;
    private static final Map<Integer, Integer> sax;
    private static final Map<Integer, Integer> say;

    static {
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(-1), Integer.valueOf(5));
        hashMap.put(Integer.valueOf(-2), Integer.valueOf(6));
        hashMap.put(Integer.valueOf(-3), Integer.valueOf(7));
        hashMap.put(Integer.valueOf(-4), Integer.valueOf(8));
        hashMap.put(Integer.valueOf(-5), Integer.valueOf(9));
        hashMap.put(Integer.valueOf(-6), Integer.valueOf(10));
        hashMap.put(Integer.valueOf(-7), Integer.valueOf(11));
        hashMap.put(Integer.valueOf(-8), Integer.valueOf(12));
        hashMap.put(Integer.valueOf(-9), Integer.valueOf(13));
        hashMap.put(Integer.valueOf(-10), Integer.valueOf(14));
        hashMap.put(Integer.valueOf(-11), Integer.valueOf(15));
        hashMap.put(Integer.valueOf(-12), Integer.valueOf(16));
        hashMap.put(Integer.valueOf(-13), Integer.valueOf(17));
        hashMap.put(Integer.valueOf(-14), Integer.valueOf(18));
        hashMap.put(Integer.valueOf(-15), Integer.valueOf(19));
        saw = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(Integer.valueOf(-1), Integer.valueOf(4));
        hashMap.put(Integer.valueOf(-2), Integer.valueOf(5));
        hashMap.put(Integer.valueOf(-3), Integer.valueOf(6));
        hashMap.put(Integer.valueOf(-4), Integer.valueOf(7));
        hashMap.put(Integer.valueOf(-5), Integer.valueOf(8));
        hashMap.put(Integer.valueOf(-6), Integer.valueOf(9));
        sax = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), Integer.valueOf(0));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(1));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(2));
        say = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(u.NAME, Integer.valueOf(2));
        hashMap.put("profile", Integer.valueOf(3));
        hashMap.put("addContact", Integer.valueOf(4));
        hashMap.put("shareTimeline", Integer.valueOf(7));
        hashMap.put("scanQRCode", Integer.valueOf(8));
        hashMap.put(t.NAME, Integer.valueOf(10));
        hashMap.put(n.NAME, Integer.valueOf(11));
        hashMap.put("editAddress", Integer.valueOf(12));
        hashMap.put("getLatestAddress", Integer.valueOf(13));
        hashMap.put("jumpWCMall", Integer.valueOf(14));
        hashMap.put("geoLocation", Integer.valueOf(15));
        hashMap.put("openProductView", Integer.valueOf(16));
        hashMap.put("openProductViewWithPid", Integer.valueOf(16));
        hashMap.put(bf.NAME, Integer.valueOf(17));
        hashMap.put(s.NAME, Integer.valueOf(19));
        hashMap.put("connectToFreeWifi", Integer.valueOf(20));
        hashMap.put(JsApiStartRecordVoice.NAME, Integer.valueOf(21));
        hashMap.put("chooseImage", Integer.valueOf(22));
        hashMap.put("scanCover", Integer.valueOf(23));
        hashMap.put("openGameWebView", Integer.valueOf(28));
        mjn = Collections.unmodifiableMap(hashMap);
    }

    public static int we(int i) {
        Integer num = (Integer) saw.get(Integer.valueOf(i));
        if (num == null) {
            num = (Integer) saw.get(Integer.valueOf(-1));
        }
        return num.intValue();
    }

    public static int wf(int i) {
        Integer num = (Integer) sax.get(Integer.valueOf(i));
        if (num == null) {
            num = (Integer) sax.get(Integer.valueOf(-1));
        }
        return num.intValue();
    }

    public static int wg(int i) {
        Integer num = (Integer) say.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(-1);
        }
        return num.intValue();
    }

    public static int JB(String str) {
        Integer num = (Integer) mjn.get(str);
        if (num == null) {
            num = Integer.valueOf(-1);
        }
        return num.intValue();
    }

    public static int dX(long j) {
        if (j < 0) {
            return -1;
        }
        if (j <= 2000) {
            return 1;
        }
        if (j <= 6000) {
            return 2;
        }
        if (j <= 12000) {
            return 3;
        }
        if (j <= 60000) {
            return 4;
        }
        return 5;
    }
}
