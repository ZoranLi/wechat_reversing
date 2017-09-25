package com.tencent.mm.platformtools;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.sdk.platformtools.bg;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class SpellMap {
    public static HashMap<String, String> iig = new HashMap();

    public static native String spellGetJni(int i, int i2);

    public static String d(char c) {
        int e = e(c);
        if (e < 65536) {
            return String.valueOf(c);
        }
        int i = e >> 16;
        e &= 255;
        String spellGetJni = (i < 129 || i > 253) ? null : (e < 63 || e > i.CTRL_BYTE) ? null : spellGetJni(i - 129, e - 63);
        if (spellGetJni == null) {
            return null;
        }
        String[] split = spellGetJni.split(",");
        if (split == null || split.length < 2) {
            return spellGetJni;
        }
        return split[0];
    }

    private static int e(char c) {
        if (c <= '') {
            return c;
        }
        try {
            byte[] bytes = String.valueOf(c).getBytes("GBK");
            if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
                return '\u0000';
            }
            if (bytes.length == 1) {
                return bytes[0];
            }
            return bytes.length == 2 ? ((bytes[0] + 256) << 16) + (bytes[1] + 256) : '\u0000';
        } catch (UnsupportedEncodingException e) {
            return '\u0000';
        }
    }

    public static final String mx(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c > '㐀') {
                String str2 = (String) iig.get(String.valueOf(c));
                if (!bg.mA(str2)) {
                    stringBuffer.append(str2);
                }
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
