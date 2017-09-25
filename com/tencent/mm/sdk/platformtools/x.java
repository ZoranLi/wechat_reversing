package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.a.k;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class x {
    private static final Pattern usK;
    private byte[] key;
    private final y<String, String> usL = new y(256);
    public final bd usM;

    static {
        String str = "⍆[0-9]+@";
        usK = Pattern.compile(((char) (str.charAt(0) ^ 56506)) + str.substring(1));
    }

    public x(String str) {
        try {
            this.key = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            this.key = str.getBytes();
        }
        this.usM = new bd(str);
    }

    public final String cA(String str, int i) {
        String substring = str.substring(0, i);
        if (this.usL.bu(substring)) {
            return (String) this.usL.get(substring);
        }
        int indexOf = str.indexOf(64, 1);
        int i2 = indexOf + 1;
        try {
            String str2 = new String(k.a(Base64.decode(str.substring(i2, Integer.parseInt(str.substring(1, indexOf)) + i2), 0), this.key), "UTF-8");
            this.usL.put(substring, str2);
            return str2;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.LogDecryptor", e, "", new Object[0]);
            return "[TD]" + substring;
        }
    }
}
