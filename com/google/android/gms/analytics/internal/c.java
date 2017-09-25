package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    final long ahA;
    final int ahB;
    final boolean ahC;
    private final String ahD;
    final Map<String, String> ahx;
    final List<Command> ahy;
    final long ahz;

    public c(n nVar, Map<String, String> map, long j) {
        this(nVar, map, j, true, 0, 0, null);
    }

    public c(n nVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(nVar, map, j, z, j2, i, null);
    }

    public c(n nVar, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        String a;
        w.Z(nVar);
        w.Z(map);
        this.ahA = j;
        this.ahC = z;
        this.ahz = j2;
        this.ahB = i;
        this.ahy = list != null ? list : Collections.EMPTY_LIST;
        this.ahD = h(list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (S(entry.getKey())) {
                a = a(nVar, entry.getKey());
                if (a != null) {
                    hashMap.put(a, b(nVar, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!S(entry2.getKey())) {
                a = a(nVar, entry2.getKey());
                if (a != null) {
                    hashMap.put(a, b(nVar, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.ahD)) {
            k.a(hashMap, "_v", this.ahD);
            if (this.ahD.equals("ma4.0.0") || this.ahD.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.ahx = Collections.unmodifiableMap(hashMap);
    }

    private static boolean S(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private static String a(n nVar, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            nVar.c("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private static String b(n nVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        obj2 = obj2.substring(0, 8192);
        nVar.c("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    private static String h(List<Command> list) {
        CharSequence charSequence;
        if (list != null) {
            for (Command command : list) {
                if ("appendVersion".equals(command.ahk)) {
                    charSequence = command.mValue;
                    break;
                }
            }
        }
        charSequence = null;
        return TextUtils.isEmpty(charSequence) ? null : charSequence;
    }

    final String c(String str, String str2) {
        w.U(str);
        w.b(!str.startsWith("&"), "Short param name required");
        String str3 = (String) this.ahx.get(str);
        return str3 != null ? str3 : str2;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.ahA);
        if (this.ahz != 0) {
            stringBuffer.append(", dbId=").append(this.ahz);
        }
        if (((long) this.ahB) != 0) {
            stringBuffer.append(", appUID=").append(this.ahB);
        }
        List<String> arrayList = new ArrayList(this.ahx.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.ahx.get(str));
        }
        return stringBuffer.toString();
    }
}
