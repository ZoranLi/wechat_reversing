package com.tencent.mm.plugin.fts.d.b;

import android.text.TextPaint;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public TextPaint haK;
    public boolean lZU;
    public boolean mdA;
    public List<a> mdB = new ArrayList();
    public int mdC = b.mdH;
    public int mdD = com.tencent.mm.plugin.fts.d.d.a.mcz;
    public float mdE;
    public CharSequence mdy;
    public String mdz;

    public static class a {
        public int mdF = -1;
        public int mdG = -1;
        public String mdz;

        public final boolean isAvailable() {
            return (this.mdF == -1 || this.mdG == -1) ? false : true;
        }

        public final String toString() {
            return String.format("HLIndexItem %s %d %d", new Object[]{this.mdz, Integer.valueOf(this.mdF), Integer.valueOf(this.mdG)});
        }
    }

    public enum b {
        ;

        static {
            mdH = 1;
            mdI = 2;
            mdJ = 3;
            mdK = new int[]{mdH, mdI, mdJ};
        }
    }

    public final boolean isAvailable() {
        return !bg.J(this.mdy) && (!bg.mA(this.mdz) || this.mdB.size() > 0);
    }

    public static final a d(CharSequence charSequence, String str) {
        a aVar = new a();
        aVar.mdy = charSequence;
        aVar.mdz = str;
        return aVar;
    }

    public static final a b(CharSequence charSequence, List<String> list) {
        a aVar = new a();
        aVar.mdy = charSequence;
        for (String str : list) {
            a aVar2 = new a();
            aVar2.mdz = str;
            aVar.mdB.add(aVar2);
        }
        return aVar;
    }

    public static final b a(CharSequence charSequence, List<String> list, int i, int i2) {
        Object aVar = new a();
        aVar.mdy = charSequence;
        aVar.mdC = i;
        aVar.mdD = i2;
        for (String str : list) {
            a aVar2 = new a();
            aVar2.mdz = str;
            aVar.mdB.add(aVar2);
        }
        return aVar;
    }

    public static final a a(CharSequence charSequence, String str, List<String> list) {
        a aVar = new a();
        aVar.mdy = charSequence;
        aVar.mdz = str;
        for (String str2 : list) {
            a aVar2 = new a();
            aVar2.mdz = str2;
            aVar.mdB.add(aVar2);
        }
        return aVar;
    }

    public static final a a(CharSequence charSequence, String str, List<String> list, boolean z, boolean z2) {
        a a = a(charSequence, str, list);
        a.lZU = z;
        a.mdA = z2;
        return a;
    }

    public static final a a(CharSequence charSequence, String str, List<String> list, boolean z, boolean z2, float f, TextPaint textPaint) {
        a a = a(charSequence, str, (List) list, z, z2);
        a.mdE = f;
        a.haK = textPaint;
        return a;
    }

    public static final a a(CharSequence charSequence, String str, List<String> list, float f, TextPaint textPaint) {
        a a = a(charSequence, str, list);
        a.mdE = f;
        a.haK = textPaint;
        return a;
    }
}
