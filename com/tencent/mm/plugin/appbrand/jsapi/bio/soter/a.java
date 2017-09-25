package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;

public final class a {
    private static byte iRv = (byte) 1;
    private static byte iRw = (byte) 2;
    private static byte iRx = (byte) 4;
    private static byte iRy = (byte) 8;

    public static JSONArray hM(int i) {
        if (i <= 0) {
            return new JSONArray();
        }
        Collection arrayList = new ArrayList(3);
        if ((iRv & i) == iRv) {
            arrayList.add("fingerPrint");
        }
        if ((iRy & i) == iRy) {
            arrayList.add("facial");
        }
        if ((iRw & i) == iRw) {
            arrayList.add("speech");
        }
        w.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", new Object[]{arrayList.toString()});
        return new JSONArray(arrayList);
    }

    public static String h(JSONArray jSONArray) {
        String str = "MicroMsg.AppBrandSoterTranslateUtil";
        String str2 = "hy: translating string array: %s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONArray == null ? null : jSONArray.toString();
        w.i(str, str2, objArr);
        if (jSONArray == null || jSONArray.length() == 0) {
            return "0x00";
        }
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                str2 = jSONArray.getString(i2);
                if ("fingerPrint".equals(str2)) {
                    i = (byte) (i | iRv);
                } else if ("facial".equals(str2)) {
                    i = (byte) (i | iRy);
                } else if ("speech".equals(str2)) {
                    i = (byte) (i | iRw);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrandSoterTranslateUtil", e, "hy: json error in translate", new Object[0]);
            }
        }
        w.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", new Object[]{"0x" + Integer.toHexString(i)});
        return "0x" + Integer.toHexString(i);
    }
}
