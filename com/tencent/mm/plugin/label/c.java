package com.tencent.mm.plugin.label;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class c {
    public static String cF(String str, String str2) {
        w.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[]{str, str2});
        if (bg.mA(str2)) {
            return str;
        }
        if (bg.mA(str)) {
            return str2 + "\u0000";
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        if (bg.f(str.split(",")).contains(str2)) {
            return str + "\u0000";
        }
        return str + "," + str2 + "\u0000";
    }

    public static String cG(String str, String str2) {
        w.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[]{str, str2});
        if (bg.mA(str2)) {
            return str;
        }
        if (bg.mA(str)) {
            return "";
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        List f = bg.f(str.split(","));
        if (!f.contains(str2)) {
            return str;
        }
        f.remove(str2);
        return aK(f);
    }

    public static String aK(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) list.get(i));
                if (i < size - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("\u0000");
        }
        return stringBuilder.toString();
    }
}
