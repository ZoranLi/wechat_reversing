package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.a.d;

public final class bd {
    private final d uvO;
    private y<String, String> uvP = new y(256);

    public bd(String str) {
        this.uvO = new d(str);
    }

    public final String decryptTag(String str) {
        try {
            if (str.startsWith("!")) {
                if (this.uvP.aV(str)) {
                    return (String) this.uvP.get(str);
                }
                String substring = str.substring(1);
                try {
                    String[] split = substring.split("@");
                    if (split.length > 1) {
                        String str2 = split[0];
                        int intValue = Integer.valueOf(split[0]).intValue();
                        String substring2 = substring.substring(str2.length() + 1, (str2.length() + 1) + intValue);
                        String str3 = this.uvO.aM(substring2) + substring.substring(intValue + (str2.length() + 1));
                        this.uvP.put(str, str3);
                        return str3;
                    }
                    str = substring;
                } catch (Throwable e) {
                    str = substring;
                    Throwable th = e;
                    w.printErrStackTrace("MicroMsg.TagDecrypter", th, "", new Object[0]);
                    str = "[td]" + str;
                    return str;
                }
            }
        } catch (Exception e2) {
            th = e2;
            w.printErrStackTrace("MicroMsg.TagDecrypter", th, "", new Object[0]);
            str = "[td]" + str;
            return str;
        }
        return str;
    }
}
