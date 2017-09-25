package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static List<a> gWk = new LinkedList();
    private static Map<String, a> gWl = new HashMap();

    public static a an(Object obj) {
        for (a aVar : gWk) {
            if (aVar.am(obj)) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(Object obj, Parcel parcel) {
        a an = an(obj);
        if (an != null) {
            an.a(obj, parcel);
        }
    }

    public static Object a(String str, Parcel parcel) {
        a aVar = (a) gWl.get(str);
        if (aVar != null) {
            return aVar.d(parcel);
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !gWk.contains(aVar)) {
            gWl.put(aVar.getClass().getName(), aVar);
            gWk.add(aVar);
        }
    }
}
