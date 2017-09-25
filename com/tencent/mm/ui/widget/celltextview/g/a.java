package com.tencent.mm.ui.widget.celltextview.g;

import android.graphics.Paint;
import android.graphics.Rect;
import java.util.regex.Pattern;

public final class a {
    static Pattern vPN = Pattern.compile("[`\"~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？「」]$");
    private static Rect wzg = new Rect();

    public static boolean l(char c) {
        return (c >= 'a' && c <= 'z') || ((c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '_' || c == '-' || c == '@'));
    }

    public static boolean m(char c) {
        if (c == '、' || c == '）' || c == '，' || c == '。' || c == '》' || c == '】' || c == '」' || c == '？' || c == '；' || c == '：' || c == '”') {
            return true;
        }
        return false;
    }

    public static boolean n(char c) {
        if (c == '（' || c == '《' || c == '「' || c == '【' || c == '“') {
            return true;
        }
        return false;
    }

    public static int db(String str, int i) {
        for (int i2 = i; i2 >= 0; i2--) {
            if (!l(str.charAt(i2))) {
                return i2 + 1;
            }
        }
        return i;
    }

    public static int dc(String str, int i) {
        while (i >= 0) {
            if (!o(str.charAt(i))) {
                return i + 1;
            }
            i--;
        }
        return 0;
    }

    public static int dd(String str, int i) {
        while (i < str.length()) {
            if (!o(str.charAt(i))) {
                return i - 1;
            }
            i++;
        }
        return i - 1;
    }

    public static char cZ(String str, int i) {
        if (i < 0 || str == null || i >= str.length()) {
            return '\u0000';
        }
        return str.charAt(i);
    }

    public static char[] V(String str, int i, int i2) {
        int i3 = i2 - i;
        if (str == null || i < 0 || i > i2) {
            return new char[i3];
        }
        char[] cArr = new char[i3];
        if (i2 > str.length()) {
            i2 = str.length();
        }
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    public static boolean o(char c) {
        return vPN.matcher(Character.toString(c)).find();
    }

    public static float a(char c, Paint paint) {
        String valueOf = String.valueOf(c);
        float measureText = paint.measureText(valueOf);
        paint.getTextBounds(valueOf, 0, 1, wzg);
        int i = (int) (measureText - ((float) wzg.right));
        return i > 0 ? (float) i : 0.0f;
    }

    public static float b(char c, Paint paint) {
        paint.getTextBounds(String.valueOf(c), 0, 1, wzg);
        int i = wzg.left;
        return i > 0 ? (float) i : 0.0f;
    }
}
