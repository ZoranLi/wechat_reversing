package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static final Pattern qau = Pattern.compile("\\{([\\s\\S]*?)\\}");
    public static String[] qav = new String[]{"{sex", "{username", "{richtext"};
    public static HashMap<String, a> qaw = new HashMap();

    enum a {
        OK,
        FAIL
    }

    public static String a(a aVar) {
        if (!qaw.containsKey(aVar.qaq)) {
            Object obj = aVar.qaq;
            if (bg.mA(obj)) {
                return aVar.qap;
            }
            Object obj2;
            do {
                Matcher matcher = qau.matcher(obj);
                if (matcher.find()) {
                    int groupCount = matcher.groupCount();
                    Object group = matcher.group();
                    w.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + groupCount + " " + group);
                    obj = obj.replace(group, "");
                    for (String indexOf : qav) {
                        if (group.indexOf(indexOf) >= 0) {
                            obj2 = 1;
                            continue;
                            break;
                        }
                    }
                    obj2 = null;
                    continue;
                } else {
                    qaw.put(aVar.qaq, a.OK);
                    return aVar.qaq;
                }
            } while (obj2 != null);
            qaw.put(aVar.qaq, a.FAIL);
            return aVar.qap;
        } else if (((a) qaw.get(aVar.qaq)) == a.OK) {
            return aVar.qaq;
        } else {
            return aVar.qap;
        }
    }
}
