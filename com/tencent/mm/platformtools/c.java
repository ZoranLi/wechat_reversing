package com.tencent.mm.platformtools;

public final class c {
    public static String mp(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char d : toCharArray) {
            String d2 = SpellMap.d(d);
            if (d2 != null) {
                stringBuffer.append(d2);
            }
        }
        return stringBuffer.toString();
    }

    public static String mq(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = toCharArray.length;
        for (int i = 0; i < length; i++) {
            if (!Character.isSpace(toCharArray[i])) {
                String d = SpellMap.d(toCharArray[i]);
                if (d != null && d.length() > 0) {
                    stringBuffer.append(d.charAt(0));
                }
            }
        }
        return stringBuffer.toString().toUpperCase();
    }
}
