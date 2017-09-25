package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public LinkedList<a> hSY = new LinkedList();
    public String iconUrl;
    public int oVH;
    public int oVI;
    public int oVJ;
    public String oVK;
    public boolean oVL;
    public String title;
    public int type = 1;

    public static class a {
        public String arH;
        public String content;
        public String desc = "";
        public String fFa = "";
        public String hSX = "";
        public String hku = "";
        public String iconUrl = "";
        public String name = "";
        public String oVK;
        public String oVM = "";
        public String oVN = "";
        public String oVO = "";
        public String oVP = "";
        public String oVQ = "";
        public String oVR = "";
        public String oVS = "";
        public String oVT = "";
        public String oVU = "";
        public String oVV;
        public String oVW;
        public int showType;
        public String thumburl = "";
        public int type;
        public String username = "";

        public a(int i) {
            this.type = i;
        }
    }

    public static LinkedList<a> j(Map<String, String> map, String str) {
        LinkedList<a> linkedList = new LinkedList();
        Object obj = null;
        int i = 0;
        while (i < 1000) {
            Object obj2;
            a aVar = new a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            if (!bg.mA((String) map.get(str2 + ".$type"))) {
                aVar.type = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
            }
            aVar.title = bg.mz((String) map.get(str2 + ".$title"));
            aVar.iconUrl = bg.mz((String) map.get(str2 + ".$iconurl"));
            aVar.oVH = bg.getInt((String) map.get(str2 + ".$iconwidth"), 34);
            aVar.oVI = bg.getInt((String) map.get(str2 + ".$iconheight"), 34);
            aVar.oVK = bg.mz((String) map.get(str2 + ".$referkey"));
            aVar.oVJ = bg.getInt((String) map.get(str2 + ".$listshowtype"), 0);
            boolean z = false;
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < 1000) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!bg.mA((String) map.get(str3 + ".$type"))) {
                    boolean z2;
                    obj = null;
                    a k = k(map, str3);
                    if (k != null) {
                        linkedList2.add(k);
                        if (!k.a(k)) {
                            z2 = true;
                            i2++;
                            z = z2;
                        }
                    }
                    z2 = z;
                    i2++;
                    z = z2;
                } else if (obj != null) {
                    return linkedList;
                } else {
                    obj2 = 1;
                    aVar.hSY = linkedList2;
                    aVar.oVL = z;
                    linkedList.add(aVar);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            aVar.oVL = z;
            linkedList.add(aVar);
            i++;
            obj = obj2;
        }
        return linkedList;
    }

    public static a k(Map<String, String> map, String str) {
        int i = bg.getInt((String) map.get(str + ".$type"), 0);
        a aVar = new a(i);
        aVar.type = i;
        aVar.oVR = bg.mz((String) map.get(str + ".statid"));
        aVar.name = bg.mz((String) map.get(str + ".name"));
        aVar.desc = bg.mz((String) map.get(str + ".desc"));
        aVar.hku = bg.mz((String) map.get(str + ".digest"));
        aVar.showType = bg.getInt((String) map.get(str + ".showtype"), 0);
        aVar.oVM = bg.mz((String) map.get(str + ".image"));
        aVar.arH = bg.mz((String) map.get(str + ".$key"));
        aVar.iconUrl = bg.mz((String) map.get(str + ".iconurl"));
        if (i == 1) {
            aVar.hSX = bg.mz((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 2) {
            aVar.username = bg.mz((String) map.get(str + ".username"));
            aVar.fFa = bg.mz((String) map.get(str + ".nickname"));
            aVar.oVV = bg.mz((String) map.get(str + ".strbeforefollow"));
            aVar.oVW = bg.mz((String) map.get(str + ".strafterfollow"));
            return aVar;
        } else if (i == 3) {
            aVar.thumburl = bg.mz((String) map.get(str + ".thumburl"));
            aVar.hSX = bg.mz((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 4) {
            aVar.thumburl = bg.mz((String) map.get(str + ".thumburl"));
            aVar.username = bg.mz((String) map.get(str + ".username"));
            aVar.fFa = bg.mz((String) map.get(str + ".nickname"));
            return aVar;
        } else {
            if (i == 5) {
                aVar.oVO = bg.mz((String) map.get(str + ".wifiurl"));
                aVar.oVP = bg.mz((String) map.get(str + ".wapurl"));
                aVar.oVQ = bg.mz((String) map.get(str + ".weburl"));
                if (bg.mA(aVar.oVO) && bg.mA(aVar.oVP) && bg.mA(aVar.oVQ)) {
                    return null;
                }
            } else if (i != 6) {
                if (i == 7) {
                    aVar.thumburl = bg.mz((String) map.get(str + ".thumburl"));
                    aVar.oVN = bg.mz((String) map.get(str + ".playurl"));
                    return aVar;
                } else if (i == 9) {
                    aVar.oVS = bg.mz((String) map.get(str + ".productid"));
                    return aVar;
                } else if (i == 8) {
                    aVar.oVT = bg.mz((String) map.get(str + ".cardext"));
                    aVar.oVU = bg.mz((String) map.get(str + ".cardid"));
                    return aVar;
                } else if (i == 10) {
                    aVar.oVS = bg.mz((String) map.get(str + ".id"));
                    return aVar;
                } else if (i == 12) {
                    aVar.thumburl = bg.mz((String) map.get(str + ".image"));
                    aVar.hSX = bg.mz((String) map.get(str + ".link"));
                    return aVar;
                } else if (i == 22) {
                    aVar.content = bg.mz((String) map.get(str + ".content"));
                    aVar.hSX = bg.mz((String) map.get(str + ".link"));
                    aVar.fFa = bg.mz((String) map.get(str + ".nickname"));
                    aVar.thumburl = bg.mz((String) map.get(str + ".image"));
                    return aVar;
                } else if (i == 21) {
                    aVar.oVK = bg.mz((String) map.get(str + ".referkey"));
                    return aVar;
                } else {
                    aVar.hSX = bg.mz((String) map.get(str + ".link"));
                }
            }
            return aVar;
        }
    }
}
