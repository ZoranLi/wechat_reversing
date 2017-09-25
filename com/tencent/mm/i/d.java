package com.tencent.mm.i;

import android.view.ContextMenu.ContextMenuInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d {
    public static final int[] gTj = new int[]{1};
    HashMap<String, HashMap<String, String>> gTk = new HashMap();
    public Map<String, String> gTl = null;
    private int id;
    int version;

    public static class a {
        public String id;
        public String title;
        public String url;

        public a(String str, String str2, String str3) {
            this.id = str;
            this.title = str2;
            this.url = str3;
        }
    }

    public static class b implements ContextMenuInfo {
        private static int gTm = 10000;
        public final String arH;
        public final int id;
        public final String title;

        public b(String str, String str2) {
            int i = gTm;
            gTm = i + 1;
            this.id = i;
            this.arH = str;
            this.title = str2;
        }
    }

    public d(int i) {
        this.id = i;
    }

    static boolean dB(String str) {
        try {
            if (bg.mA(str)) {
                return false;
            }
            List<String> arrayList = new ArrayList();
            if (!bg.mA(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bg.mA(split[i])) {
                            arrayList.add(split[i]);
                        }
                    }
                }
            }
            String bIN = v.bIN();
            if (bg.mA(bIN)) {
                return false;
            }
            w.d("MicroMsg.ConfigListInfo", "locale is " + bIN);
            for (String str2 : arrayList) {
                if (str2.trim().toLowerCase().equals("other") && !bIN.equals("zh_CN")) {
                    w.d("MicroMsg.ConfigListInfo", "find other");
                    return true;
                } else if (str2.trim().toLowerCase().equals(bIN.trim().toLowerCase())) {
                    w.d("MicroMsg.ConfigListInfo", "find ");
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            w.e("MicroMsg.ConfigListInfo", "exception:%s", bg.g(e));
            w.d("MicroMsg.ConfigListInfo", "isContainLocale failed " + e.getMessage());
        }
    }

    private static LinkedList<a> c(Map<String, String> map, String str) {
        LinkedList<a> linkedList = null;
        int i = 0;
        while (true) {
            String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
            if (map.get(str2) == null) {
                break;
            }
            String str3 = str2 + ".id";
            String str4 = str2 + ".title";
            String str5 = str2 + ".url";
            if (!map.containsKey(str3)) {
                break;
            }
            LinkedList<a> linkedList2;
            a aVar = new a((String) map.get(str3), (String) map.get(str4), (String) map.get(str5));
            if (linkedList == null) {
                linkedList2 = new LinkedList();
            } else {
                linkedList2 = linkedList;
            }
            linkedList2.add(aVar);
            i++;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    public static LinkedList<a> j(Map<String, String> map) {
        LinkedList<a> linkedList = null;
        int i = 0;
        while (true) {
            String str = ".ConfigList.Config" + (i == 0 ? "" : Integer.valueOf(i));
            if (map.get(str + ".$name") == null) {
                break;
            }
            LinkedList<a> c;
            if (((String) map.get(str + ".$name")).equalsIgnoreCase("JDWebViewMenu")) {
                c = c(map, str + ".menuItems.menuItem");
                linkedList = c(map, str + ".menuItems.newMenuItem");
                if (c == null) {
                    break;
                } else if (linkedList != null && linkedList.size() > 0) {
                    w.d("MicroMsg.ConfigListInfo", "has menuItem2, %s, %s", Integer.valueOf(c.size()), Integer.valueOf(linkedList.size()));
                    c.addAll(linkedList);
                }
            } else {
                c = linkedList;
            }
            i++;
            linkedList = c;
        }
        return linkedList;
    }
}
