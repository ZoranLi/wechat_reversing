package com.tencent.mm.pluginsdk.k.a.e;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public enum b {
    ;

    public static String ab(Map<String, List<String>> map) {
        if (map == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(bg.ap((String) entry.getKey(), "null"));
            stringBuilder.append(" : ");
            List<String> list = (List) entry.getValue();
            if (list != null && list.size() > 0) {
                for (String mz : list) {
                    stringBuilder.append(bg.mz(mz)).append("|");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
