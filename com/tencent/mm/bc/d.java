package com.tencent.mm.bc;

import com.tencent.mm.ao.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d {

    public static class a {
        public int hOg = 0;
        public int hitCount = 0;

        public static String ad(Map<String, a> map) {
            StringBuilder stringBuilder = new StringBuilder();
            if (map != null) {
                try {
                    if (map.size() > 0) {
                        stringBuilder.append("<voiptenmin>");
                        for (Entry entry : map.entrySet()) {
                            Object key = entry.getKey();
                            a aVar = (a) entry.getValue();
                            stringBuilder.append("<" + key);
                            stringBuilder.append(" hitcount = \"");
                            stringBuilder.append(aVar.hitCount);
                            stringBuilder.append("\"");
                            stringBuilder.append(" sendcount = \"");
                            stringBuilder.append(aVar.hOg);
                            stringBuilder.append("\"");
                            stringBuilder.append("/>");
                        }
                        stringBuilder.append("</voiptenmin>");
                    }
                } catch (Throwable e) {
                    w.e("PostTaskTenMinutesLogicState", "exception:%s", bg.g(e));
                    return null;
                }
            }
            w.d("PostTaskTenMinutesLogicState", "mapToXml " + stringBuilder.toString());
            return stringBuilder.toString();
        }

        public static Map<String, a> NF(String str) {
            Throwable th;
            Map<String, a> map = null;
            w.d("PostTaskTenMinutesLogicState", "xml " + str);
            if (str == null) {
                return null;
            }
            try {
                Map q = bh.q(str, "voiptenmin");
                if (q == null || q.size() <= 0) {
                    return null;
                }
                Map<String, a> hashMap = new HashMap();
                try {
                    for (Entry entry : q.entrySet()) {
                        String str2 = (String) entry.getKey();
                        if (str2 == null) {
                            break;
                        }
                        String[] split = str2.split("\\.");
                        w.d("PostTaskTenMinutesLogicState", "key is " + str2);
                        w.d("PostTaskTenMinutesLogicState", "array is " + split.length);
                        if (str2 != null && split.length >= 4) {
                            a aVar;
                            w.d("PostTaskTenMinutesLogicState", "getValue is " + ((String) entry.getValue()) + "array[1] " + split[2]);
                            if (hashMap.containsKey(split[2])) {
                                aVar = (a) hashMap.get(split[2]);
                            } else {
                                aVar = new a();
                            }
                            if (str2.contains("hitcount")) {
                                aVar.hitCount = bg.getInt((String) entry.getValue(), 0);
                            } else if (str2.contains("sendcount")) {
                                aVar.hOg = bg.getInt((String) entry.getValue(), 0);
                            }
                            w.d("PostTaskTenMinutesLogicState", "hitCount " + aVar.hitCount + "sendCount " + aVar.hOg);
                            hashMap.put(split[2], aVar);
                        }
                    }
                    return hashMap;
                } catch (Throwable e) {
                    th = e;
                    map = hashMap;
                }
            } catch (Exception e2) {
                th = e2;
                w.e("PostTaskTenMinutesLogicState", "exception:%s", bg.g(th));
                return map;
            }
        }
    }

    public static void bGW() {
        Object obj = (!ap.zb() || ap.uP()) ? null : 1;
        if (obj != null && qf()) {
            ap.yY();
            String str = (String) c.vr().get(77829, null);
            if (str != null) {
                Map NF = a.NF(str);
                if (NF != null && NF.size() > 0) {
                    List linkedList = new LinkedList();
                    for (Entry entry : NF.entrySet()) {
                        a aVar = (a) entry.getValue();
                        if (aVar != null) {
                            int i = aVar.hitCount;
                            int i2 = aVar.hOg;
                            if (i > 0 || i2 > 0) {
                                linkedList.add(new com.tencent.mm.ao.i.a(10166, ((String) entry.getKey()) + "," + i + "," + i2));
                            }
                            w.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState  name " + ((String) entry.getKey()) + " " + i + "  " + i2);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        ap.yY();
                        c.wQ().b(new i(linkedList));
                        ap.yY();
                        c.vr().set(77829, null);
                    }
                }
            }
        }
        ap.yY();
        c.vr().set(77828, Long.valueOf(bg.Ny()));
        w.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState done ");
    }

    public static boolean qf() {
        ap.yY();
        return bg.az(bg.a((Long) c.vr().get(77828, null), 0)) * 1000 > 1800000;
    }
}
