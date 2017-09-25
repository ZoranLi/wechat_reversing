package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.ao.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class an {
    public static ao uuz = null;

    public static String ey(String str, String str2) {
        String replace = PB(str).replace("+", "");
        if (uuz == null) {
            uuz = new ao();
        }
        int length;
        if (bg.mA(str2)) {
            for (a aVar : uuz.uuA) {
                if (replace.startsWith(aVar.uuC)) {
                    length = replace.length() - aVar.uuC.length();
                    if (length >= aVar.uuD && length <= aVar.uuE) {
                        w.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar.uuC, aVar.uuB, Integer.valueOf(aVar.uuE), Integer.valueOf(aVar.uuE));
                        return aVar.uuC;
                    }
                }
            }
        } else {
            for (a aVar2 : uuz.uuA) {
                if (replace.startsWith(aVar2.uuC)) {
                    length = replace.length() - aVar2.uuC.length();
                    if (length >= aVar2.uuD && length <= aVar2.uuE && str2.equalsIgnoreCase(aVar2.uuB)) {
                        w.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar2.uuC, aVar2.uuB, Integer.valueOf(aVar2.uuE), Integer.valueOf(aVar2.uuE));
                        return aVar2.uuC;
                    }
                }
            }
        }
        return null;
    }

    public static String yU(String str) {
        return ey(str, null);
    }

    public static String PA(String str) {
        if (bg.mA(str) || !bg.Qh(str).booleanValue()) {
            return str;
        }
        an anVar = new an();
        String str2 = "86";
        if (str.startsWith("+")) {
            str = str.replace("+", "");
            str2 = ey(str, null);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        return formatNumber(str2, str);
    }

    public static String PB(String str) {
        if (bg.mA(str)) {
            return "";
        }
        return str.replaceAll("[\\.\\-\\ ]", "").trim();
    }

    public static String PC(String str) {
        if (bg.mA(str)) {
            return "";
        }
        return str.replace("+", "");
    }

    public static String PD(String str) {
        if (bg.mA(str)) {
            return "";
        }
        return !str.startsWith("+") ? "+" + str : str;
    }

    public static String ez(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return "";
        }
        return str + "（+" + str2 + "）";
    }

    public static String formatNumber(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return str2;
        }
        if (uuz == null) {
            uuz = new ao();
        }
        for (a aVar : uuz.uuA) {
            if (!(aVar.uuC == null || !str.trim().toLowerCase().equals(aVar.uuC.trim().toLowerCase()) || aVar.uuF == null)) {
                String PB = PB(str2);
                if (PB != null && PB.length() > aVar.uuD) {
                    return PB;
                }
                for (b bVar : aVar.uuF) {
                    String Z;
                    int i;
                    int i2;
                    char charAt;
                    StringBuffer stringBuffer;
                    int length;
                    if (bg.mA(bVar.uuG)) {
                        if (aVar.uuF.size() > 1) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(PB);
                            int length2 = PB.length();
                            if (length2 <= cB(bVar.uuI, aVar.uuE)) {
                                while (stringBuffer2.toString().length() < aVar.uuE) {
                                    stringBuffer2.append("0");
                                }
                                Z = Z(bVar.uuI, bVar.uuH, stringBuffer2.toString());
                                PB = Z;
                                i = 0;
                                for (i2 = 0; i2 < PB.length(); i2++) {
                                    charAt = PB.charAt(i2);
                                    if (i >= length2) {
                                        PB = PB.substring(0, i2);
                                    }
                                    if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                        i++;
                                    }
                                }
                                return PB;
                            }
                        } else {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(PB);
                            length = PB.length();
                            while (stringBuffer.toString().length() < aVar.uuE) {
                                stringBuffer.append("0");
                            }
                            String Z2 = Z(bVar.uuI, bVar.uuH, stringBuffer.toString());
                            i = 0;
                            for (int i3 = 0; i3 < Z2.length(); i3++) {
                                charAt = Z2.charAt(i3);
                                if (i >= length) {
                                    Z2 = Z2.substring(0, i3);
                                }
                                if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                    i++;
                                }
                            }
                            return Z2;
                        }
                    } else if (Pattern.compile(bVar.uuG).matcher(PB).lookingAt()) {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(PB);
                        length = PB.length();
                        while (stringBuffer.toString().length() < aVar.uuE) {
                            stringBuffer.append(PB.charAt(length - 1));
                        }
                        Z = Z(bVar.uuI, bVar.uuH, stringBuffer.toString());
                        PB = Z;
                        i = 0;
                        for (i2 = 0; i2 < PB.length(); i2++) {
                            charAt = PB.charAt(i2);
                            if (i >= length) {
                                PB = PB.substring(0, i2);
                            }
                            if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                i++;
                            }
                        }
                        return PB;
                    }
                }
                continue;
            }
        }
        return str2;
    }

    private static int cB(String str, int i) {
        Pattern compile = Pattern.compile(str);
        Object obj = "1";
        int i2 = 0;
        while (i2 < i && !compile.matcher(obj).find()) {
            obj = obj + "1";
            i2++;
        }
        return i2 + 1;
    }

    private static String Z(String str, String str2, String str3) {
        Matcher matcher = Pattern.compile(str).matcher(str3);
        if (matcher.find()) {
            return matcher.replaceAll(str2);
        }
        return str3;
    }
}
