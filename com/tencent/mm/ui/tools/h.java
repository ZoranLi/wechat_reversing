package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h implements InputFilter {
    private int jtU;
    private int jtV;

    public enum a {
        ;

        static {
            wmF = 1;
            wmG = 2;
            wmH = new int[]{wmF, wmG};
        }
    }

    public h(int i, int i2) {
        this.jtU = i;
        this.jtV = i2;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (cY(spanned.toString(), this.jtV) + cY(charSequence.toString(), this.jtV) > this.jtU) {
            return "";
        }
        return charSequence;
    }

    public static int cY(String str, int i) {
        if (i == a.wmF) {
            if (bg.mA(str)) {
                return 0;
            }
            return str.length();
        } else if (i == a.wmG) {
            return Un(str);
        } else {
            return 0;
        }
    }

    public static int Un(String str) {
        int i = 0;
        if (bg.mA(str)) {
            return 0;
        }
        int Uo = Uo(str) + str.length();
        if (!bg.mA(str)) {
            int i2 = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt >= '\u0000' && charAt <= '') {
                    i2++;
                }
                i++;
            }
            i = str.length() - (i2 + Uo(str));
        }
        return i + Uo;
    }

    public static int Uo(String str) {
        if (bg.mA(str)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i = 0;
        while (matcher.find()) {
            int i2 = 0;
            while (i2 <= matcher.groupCount()) {
                i2++;
                i++;
            }
        }
        return i;
    }

    public static int aI(int i, String str) {
        if (v.bIJ()) {
            return Math.round(((float) (i - Math.round((float) Un(str)))) / 2.0f);
        }
        return i - Un(str);
    }

    public static int aJ(int i, String str) {
        if (v.bIJ()) {
            return Math.round(((float) (Math.round((float) Un(str)) - i)) / 2.0f);
        }
        return Un(str) - i;
    }
}
