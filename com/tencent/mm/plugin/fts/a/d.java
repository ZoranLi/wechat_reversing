package com.tencent.mm.plugin.fts.a;

import android.database.DatabaseUtils;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static final HashMap<String, String> lZF = new HashMap();
    private static String[] lZG = new String[]{"wxid_", "wx_", "gh_"};

    public static String wX(String str) {
        if (o.dH(str)) {
            return str;
        }
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc == null) {
            return str;
        }
        if (!bg.mA(Rc.field_conRemarkPYFull)) {
            return Rc.field_conRemarkPYFull;
        }
        if (!bg.mA(Rc.pC())) {
            return Rc.pC();
        }
        if (bg.mA(Rc.pA())) {
            return str;
        }
        return Rc.pA();
    }

    public static final HashMap<String, String> axJ() {
        HashMap<String, String> hashMap = new HashMap();
        for (Entry entry : lZF.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    public static final void aD(List<i> list) {
        lZF.clear();
        for (i iVar : list) {
            if (iVar.userData instanceof String) {
                lZF.put(iVar.lZO, (String) iVar.userData);
            } else {
                lZF.put(iVar.lZO, "");
            }
        }
    }

    public static String k(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('(');
        for (int append : iArr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    public static final String s(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        for (String str : strArr) {
            Object obj;
            stringBuilder.append("\"");
            stringBuilder.append(str);
            char charAt = str.charAt(str.length() - 1);
            if (charAt >= '0' && charAt <= '9') {
                obj = 1;
            } else if (charAt >= 'A' && charAt <= 'Z') {
                r0 = 1;
            } else if (charAt < 'a' || charAt > 'z') {
                obj = null;
            } else {
                r0 = 1;
            }
            if (obj != null) {
                stringBuilder.append("\"* ");
            } else {
                stringBuilder.append("\" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static int b(int[] iArr, int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        if (i == i2) {
            return 0;
        }
        int i4 = i >= iArr.length ? Integer.MAX_VALUE : iArr[i];
        if (i2 < iArr.length) {
            i3 = iArr[i2];
        }
        return i4 - i3;
    }

    public static int a(Map<Integer, Integer> map, int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        if (i == i2) {
            return 0;
        }
        Integer num = (Integer) map.get(Integer.valueOf(i));
        int intValue = num == null ? Integer.MAX_VALUE : num.intValue();
        num = (Integer) map.get(Integer.valueOf(i2));
        if (num != null) {
            i3 = num.intValue();
        }
        return intValue - i3;
    }

    public static List<i> a(List<i> list, final Map<Integer, Integer> map) {
        int i;
        int i2;
        Comparator anonymousClass1 = new Comparator<i>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return d.a(map, ((i) obj).type, ((i) obj2).type);
            }
        };
        i iVar = new i();
        iVar.type = 131073;
        int binarySearch = Collections.binarySearch(list, iVar, anonymousClass1);
        iVar.type = 131074;
        int binarySearch2 = Collections.binarySearch(list, iVar, anonymousClass1);
        if (binarySearch < 0) {
            i = (-binarySearch) - 1;
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || ((i) list.get(i2)).type != 131073) {
                    i = i2 + 1;
                } else {
                    binarySearch = i2;
                }
            }
            i = i2 + 1;
        }
        if (binarySearch2 < 0) {
            binarySearch = (-binarySearch2) - 1;
        } else {
            int size = list.size();
            i2 = binarySearch2 + 1;
            while (i2 < size && ((i) list.get(i2)).type == 131074) {
                i2++;
            }
            binarySearch = i2;
        }
        return list.subList(i, binarySearch);
    }

    public static String wY(String str) {
        if (str != null) {
            return str.replace('*', ' ').trim();
        }
        return null;
    }

    public static final String wZ(String str) {
        return SpellMap.mx(((a) com.tencent.mm.kernel.h.h(a.class)).bJ(str, "‎"));
    }

    public static String ch(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        for (String startsWith : lZG) {
            if (str.startsWith(startsWith)) {
                return null;
            }
        }
        if (str.indexOf(64) >= 0) {
            return null;
        }
        return str;
    }

    public static boolean f(char c) {
        return c >= '一' && c <= '龥';
    }

    public static String X(String str, boolean z) {
        if (str == null) {
            return null;
        }
        String toLowerCase = wZ(str).toLowerCase();
        List<String[]> arrayList = new ArrayList();
        List list = null;
        int i = 0;
        for (int i2 = 0; i2 < toLowerCase.length(); i2++) {
            char charAt = toLowerCase.charAt(i2);
            if (f(charAt)) {
                String d = SpellMap.d(charAt);
                if (d != null && d.length() > 1) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    if (z) {
                        list.add(String.valueOf(d.charAt(0)));
                        i = 1;
                    } else {
                        list.add(d);
                        i = 1;
                    }
                }
            }
            if (list == null || list.size() <= 0) {
                arrayList.add(null);
            } else {
                arrayList.add((String[]) list.toArray(new String[0]));
            }
            list = null;
        }
        if (list != null && list.size() > 0) {
            arrayList.add((String[]) list.toArray(new String[0]));
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String[] strArr : arrayList) {
            if (strArr != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    for (int i4 = i3; i4 < strArr.length; i4++) {
                        stringBuffer2.append(strArr[i4]);
                    }
                    stringBuffer2.append("‍");
                }
                stringBuffer.append(stringBuffer2.toString());
            } else {
                stringBuffer.append("‍");
            }
        }
        if (i != 0) {
            return stringBuffer.toString();
        }
        return "";
    }

    public static String t(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append('(');
        for (String sqlEscapeString : strArr) {
            stringBuilder.append(DatabaseUtils.sqlEscapeString(sqlEscapeString) + ',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    public static boolean f(int[] iArr, int i) {
        return Arrays.binarySearch(iArr, i) >= 0;
    }

    public static boolean b(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }
}
