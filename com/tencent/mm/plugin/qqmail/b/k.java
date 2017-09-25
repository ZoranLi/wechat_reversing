package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class k {
    String fOu = null;
    private String[] ozT = null;
    private String[] ozU = null;
    private String[] ozV = null;
    String ozW = null;
    a[] ozX = null;
    a[] ozY = null;
    String ozq = null;

    public static class a {
        int fileSize;
        String fyF;
        String name;
        String ozZ;
    }

    public k(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        if (!bg.mA(str)) {
            this.fOu = str;
        }
        if (strArr == null || strArr.length <= 0) {
            this.ozT = null;
        } else {
            this.ozT = strArr;
        }
        if (strArr2 == null || strArr2.length <= 0) {
            this.ozU = null;
        } else {
            this.ozU = strArr2;
        }
        if (strArr3 == null || strArr3.length <= 0) {
            this.ozV = null;
        } else {
            this.ozV = strArr3;
        }
        if (bg.mA(str2)) {
            this.ozq = null;
        } else {
            this.ozq = str2;
        }
    }

    final String aUp() {
        if (this.ozT == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("To: ");
        for (String str : this.ozT) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String aUq() {
        if (this.ozU == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Cc: ");
        for (String str : this.ozU) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String aUr() {
        if (this.ozV == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Bcc: ");
        for (String str : this.ozU) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    public static String CR(String str) {
        String n;
        String str2 = null;
        String str3 = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%";
        int length = str3.length();
        try {
            n = g.n((str + "d$3^&xRw%&*_(").getBytes());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MailContentFormatter", e, "", new Object[0]);
            w.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e.getLocalizedMessage());
            n = str2;
        }
        char[] cArr = new char[(n.length() * 2)];
        int i = 0;
        for (int i2 = 0; i2 < n.length(); i2++) {
            int i3 = i + 1;
            cArr[i] = n.charAt(i2);
            char charAt = n.charAt(i2);
            i = i3 + 1;
            cArr[i3] = (char) (str3.charAt(charAt % length) + n.charAt(i2));
        }
        try {
            str2 = g.n(new String(cArr).getBytes("ISO-8859-1"));
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.MailContentFormatter", e2, "", new Object[0]);
            w.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e2.getLocalizedMessage());
        }
        return str2;
    }
}
