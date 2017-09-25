package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class f {

    public static class a {
        public static int mcJ;

        static {
            mcJ = 0;
            Context context = ab.getContext();
            mcJ = ((com.tencent.mm.bg.a.dO(context) - (com.tencent.mm.bg.a.T(context, b.mcT) * 2)) - com.tencent.mm.bg.a.T(context, b.aXB)) - com.tencent.mm.bg.a.T(context, b.mcT);
        }
    }

    public static final com.tencent.mm.plugin.fts.d.b.b a(String str, String str2, com.tencent.mm.plugin.fts.d.b.a aVar) {
        com.tencent.mm.plugin.fts.d.b.b b = b(aVar);
        b.mdL = TextUtils.concat(new CharSequence[]{str, b.mdL, str2});
        return b;
    }

    public static final List<com.tencent.mm.plugin.fts.d.b.a.a> a(com.tencent.mm.plugin.fts.d.b.a aVar) {
        List<com.tencent.mm.plugin.fts.d.b.a.a> arrayList = new ArrayList();
        if (!aVar.isAvailable()) {
            return arrayList;
        }
        com.tencent.mm.plugin.fts.d.b.a.a aVar2;
        String mx = SpellMap.mx(aVar.mdy.toString().toLowerCase());
        ArrayList arrayList2 = new ArrayList();
        if (aVar.lZU) {
            List Y = Y(mx, aVar.mdA);
        } else {
            Object obj = arrayList2;
        }
        if (!bg.mA(aVar.mdz)) {
            aVar2 = new com.tencent.mm.plugin.fts.d.b.a.a();
            if (aVar.lZU) {
                a(Y, aVar.mdz, aVar2);
            } else {
                a(mx, aVar.mdz, aVar2);
            }
            if (aVar2.isAvailable()) {
                arrayList.add(aVar2);
                return arrayList;
            }
        }
        if (aVar.mdB.size() > 0) {
            for (com.tencent.mm.plugin.fts.d.b.a.a aVar22 : aVar.mdB) {
                if (!(aVar22.isAvailable() || bg.mA(aVar22.mdz))) {
                    if (aVar.lZU) {
                        a(Y, aVar22.mdz, aVar22);
                    } else {
                        a(mx, aVar22.mdz, aVar22);
                    }
                }
                if (aVar22.isAvailable()) {
                    arrayList.add(aVar22);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.tencent.mm.plugin.fts.d.b.b b(com.tencent.mm.plugin.fts.d.b.a r14) {
        /*
        r13 = -1;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = 0;
    L_0x0004:
        r3 = new com.tencent.mm.plugin.fts.d.b.b;
        r3.<init>();
        r0 = r14.isAvailable();
        if (r0 != 0) goto L_0x0021;
    L_0x000f:
        r0 = r14.mdy;
        r0 = r0.toString();
        r1 = "";
        r0 = com.tencent.mm.sdk.platformtools.bg.ap(r0, r1);
        r3.mdL = r0;
        r3.aMA = r13;
    L_0x0020:
        return r3;
    L_0x0021:
        r0 = r14.mdy;
        r0 = r0 instanceof android.text.SpannableString;
        if (r0 == 0) goto L_0x006c;
    L_0x0027:
        r0 = r14.mdy;
        r0 = (android.text.SpannableString) r0;
        r2 = r0;
    L_0x002c:
        r0 = r14.mdy;
        r0 = r0.toString();
        r0 = r0.toLowerCase();
        r5 = com.tencent.mm.platformtools.SpellMap.mx(r0);
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r14.lZU;
        if (r1 == 0) goto L_0x0237;
    L_0x0043:
        r0 = r14.mdA;
        r0 = Y(r5, r0);
        r1 = r0;
    L_0x004a:
        r0 = r14.mdz;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0082;
    L_0x0052:
        r0 = new com.tencent.mm.plugin.fts.d.b.a$a;
        r0.<init>();
        r4 = r14.lZU;
        if (r4 == 0) goto L_0x0075;
    L_0x005b:
        r4 = r14.mdz;
        a(r1, r4, r0);
    L_0x0060:
        r4 = r0.isAvailable();
        if (r4 == 0) goto L_0x0082;
    L_0x0066:
        r0 = a(r2, r0, r14);	 Catch:{ Exception -> 0x007b }
    L_0x006a:
        r3 = r0;
        goto L_0x0020;
    L_0x006c:
        r0 = new android.text.SpannableString;
        r1 = r14.mdy;
        r0.<init>(r1);
        r2 = r0;
        goto L_0x002c;
    L_0x0075:
        r4 = r14.mdz;
        a(r5, r4, r0);
        goto L_0x0060;
    L_0x007b:
        r0 = move-exception;
        r3.mdL = r2;
        r3.aMA = r11;
        r0 = r3;
        goto L_0x006a;
    L_0x0082:
        r3.aMA = r13;
        r3.mdL = r2;
        r0 = r14.mdB;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x022e;
    L_0x008e:
        r4 = 0;
        r0 = r14.mdB;
        r6 = r0.iterator();
    L_0x0095:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x00c8;
    L_0x009b:
        r0 = r6.next();
        r0 = (com.tencent.mm.plugin.fts.d.b.a.a) r0;
        r7 = r0.isAvailable();
        if (r7 != 0) goto L_0x00b8;
    L_0x00a7:
        r7 = r0.mdz;
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r7 != 0) goto L_0x00b8;
    L_0x00af:
        r7 = r14.lZU;
        if (r7 == 0) goto L_0x00c2;
    L_0x00b3:
        r7 = r0.mdz;
        a(r1, r7, r0);
    L_0x00b8:
        r7 = r0.isAvailable();
        if (r7 == 0) goto L_0x0234;
    L_0x00be:
        if (r4 != 0) goto L_0x0234;
    L_0x00c0:
        r4 = r0;
        goto L_0x0095;
    L_0x00c2:
        r7 = r0.mdz;
        a(r5, r7, r0);
        goto L_0x00b8;
    L_0x00c8:
        if (r4 == 0) goto L_0x0020;
    L_0x00ca:
        r0 = r14.mdE;
        r1 = 0;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x020b;
    L_0x00d1:
        r0 = r14.haK;
        if (r0 == 0) goto L_0x020b;
    L_0x00d5:
        r1 = new com.tencent.mm.plugin.fts.d.b.a;
        r1.<init>();
        r0 = r14.mdE;	 Catch:{ Exception -> 0x017b }
        r3 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r3 = r3.getTextSize();	 Catch:{ Exception -> 0x017b }
        r3 = r3 * r12;
        r0 = r0 - r3;
        r3 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r5 = "…";
        r3 = r3.measureText(r5);	 Catch:{ Exception -> 0x017b }
        r5 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r6 = 0;
        r7 = r4.mdF;	 Catch:{ Exception -> 0x017b }
        r5 = r5.measureText(r2, r6, r7);	 Catch:{ Exception -> 0x017b }
        r6 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r7 = r4.mdF;	 Catch:{ Exception -> 0x017b }
        r8 = r4.mdG;	 Catch:{ Exception -> 0x017b }
        r6 = r6.measureText(r2, r7, r8);	 Catch:{ Exception -> 0x017b }
        r7 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r8 = r4.mdG;	 Catch:{ Exception -> 0x017b }
        r9 = r2.length();	 Catch:{ Exception -> 0x017b }
        r7 = r7.measureText(r2, r8, r9);	 Catch:{ Exception -> 0x017b }
        r8 = r5 + r6;
        r8 = r8 + r7;
        r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r8 >= 0) goto L_0x013f;
    L_0x0113:
        r0 = r2;
    L_0x0114:
        r1.mdy = r0;	 Catch:{ Exception -> 0x017b }
    L_0x0116:
        r0 = r14.lZU;
        r1.lZU = r0;
        r0 = r14.mdA;
        r1.mdA = r0;
        r0 = r14.mdB;
        r2 = r0.iterator();
    L_0x0124:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0208;
    L_0x012a:
        r0 = r2.next();
        r0 = (com.tencent.mm.plugin.fts.d.b.a.a) r0;
        r3 = new com.tencent.mm.plugin.fts.d.b.a$a;
        r3.<init>();
        r0 = r0.mdz;
        r3.mdz = r0;
        r0 = r1.mdB;
        r0.add(r3);
        goto L_0x0124;
    L_0x013f:
        r8 = new android.text.SpannableString;	 Catch:{ Exception -> 0x017b }
        r9 = r4.mdF;	 Catch:{ Exception -> 0x017b }
        r10 = r4.mdG;	 Catch:{ Exception -> 0x017b }
        r9 = r2.subSequence(r9, r10);	 Catch:{ Exception -> 0x017b }
        r8.<init>(r9);	 Catch:{ Exception -> 0x017b }
        r9 = r5 + r6;
        r9 = r9 + r3;
        r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r9 >= 0) goto L_0x017f;
    L_0x0153:
        r3 = new android.text.SpannableStringBuilder;	 Catch:{ Exception -> 0x017b }
        r7 = 0;
        r9 = r4.mdF;	 Catch:{ Exception -> 0x017b }
        r3.<init>(r2, r7, r9);	 Catch:{ Exception -> 0x017b }
        r3.append(r8);	 Catch:{ Exception -> 0x017b }
        r0 = r0 - r5;
        r0 = r0 - r6;
        r4 = r4.mdG;	 Catch:{ Exception -> 0x017b }
        r5 = r2.length();	 Catch:{ Exception -> 0x017b }
        r4 = r2.subSequence(r4, r5);	 Catch:{ Exception -> 0x017b }
        r5 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r6 = android.text.TextUtils.TruncateAt.END;	 Catch:{ Exception -> 0x017b }
        r0 = android.text.TextUtils.ellipsize(r4, r5, r0, r6);	 Catch:{ Exception -> 0x017b }
        r3.append(r0);	 Catch:{ Exception -> 0x017b }
        r0 = new android.text.SpannableString;	 Catch:{ Exception -> 0x017b }
        r0.<init>(r3);	 Catch:{ Exception -> 0x017b }
        goto L_0x0114;
    L_0x017b:
        r0 = move-exception;
        r1.mdy = r2;
        goto L_0x0116;
    L_0x017f:
        r5 = r3 + r6;
        r5 = r5 + r7;
        r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r5 >= 0) goto L_0x01b2;
    L_0x0186:
        r3 = new android.text.SpannableStringBuilder;	 Catch:{ Exception -> 0x017b }
        r3.<init>();	 Catch:{ Exception -> 0x017b }
        r0 = r0 - r6;
        r0 = r0 - r7;
        r5 = 0;
        r6 = r4.mdF;	 Catch:{ Exception -> 0x017b }
        r5 = r2.subSequence(r5, r6);	 Catch:{ Exception -> 0x017b }
        r6 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r7 = android.text.TextUtils.TruncateAt.START;	 Catch:{ Exception -> 0x017b }
        r0 = android.text.TextUtils.ellipsize(r5, r6, r0, r7);	 Catch:{ Exception -> 0x017b }
        r3.append(r0);	 Catch:{ Exception -> 0x017b }
        r3.append(r8);	 Catch:{ Exception -> 0x017b }
        r0 = r4.mdG;	 Catch:{ Exception -> 0x017b }
        r4 = r2.length();	 Catch:{ Exception -> 0x017b }
        r3.append(r2, r0, r4);	 Catch:{ Exception -> 0x017b }
        r0 = new android.text.SpannableString;	 Catch:{ Exception -> 0x017b }
        r0.<init>(r3);	 Catch:{ Exception -> 0x017b }
        goto L_0x0114;
    L_0x01b2:
        r5 = r3 + r6;
        r3 = r3 + r5;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 < 0) goto L_0x01d0;
    L_0x01b9:
        r3 = new android.text.SpannableStringBuilder;	 Catch:{ Exception -> 0x017b }
        r3.<init>();	 Catch:{ Exception -> 0x017b }
        r4 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r5 = android.text.TextUtils.TruncateAt.END;	 Catch:{ Exception -> 0x017b }
        r0 = android.text.TextUtils.ellipsize(r8, r4, r0, r5);	 Catch:{ Exception -> 0x017b }
        r3.append(r0);	 Catch:{ Exception -> 0x017b }
        r0 = new android.text.SpannableString;	 Catch:{ Exception -> 0x017b }
        r0.<init>(r3);	 Catch:{ Exception -> 0x017b }
        goto L_0x0114;
    L_0x01d0:
        r3 = new android.text.SpannableStringBuilder;	 Catch:{ Exception -> 0x017b }
        r3.<init>();	 Catch:{ Exception -> 0x017b }
        r0 = r0 - r6;
        r0 = r0 / r12;
        r5 = 0;
        r6 = r4.mdF;	 Catch:{ Exception -> 0x017b }
        r5 = r2.subSequence(r5, r6);	 Catch:{ Exception -> 0x017b }
        r4 = r4.mdG;	 Catch:{ Exception -> 0x017b }
        r6 = r2.length();	 Catch:{ Exception -> 0x017b }
        r4 = r2.subSequence(r4, r6);	 Catch:{ Exception -> 0x017b }
        r6 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r7 = android.text.TextUtils.TruncateAt.START;	 Catch:{ Exception -> 0x017b }
        r5 = android.text.TextUtils.ellipsize(r5, r6, r0, r7);	 Catch:{ Exception -> 0x017b }
        r3.append(r5);	 Catch:{ Exception -> 0x017b }
        r3.append(r8);	 Catch:{ Exception -> 0x017b }
        r5 = r14.haK;	 Catch:{ Exception -> 0x017b }
        r6 = android.text.TextUtils.TruncateAt.END;	 Catch:{ Exception -> 0x017b }
        r0 = android.text.TextUtils.ellipsize(r4, r5, r0, r6);	 Catch:{ Exception -> 0x017b }
        r3.append(r0);	 Catch:{ Exception -> 0x017b }
        r0 = new android.text.SpannableString;	 Catch:{ Exception -> 0x017b }
        r0.<init>(r3);	 Catch:{ Exception -> 0x017b }
        goto L_0x0114;
    L_0x0208:
        r14 = r1;
        goto L_0x0004;
    L_0x020b:
        r0 = r14.mdB;
        r4 = r0.iterator();
        r1 = r3;
    L_0x0212:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x022f;
    L_0x0218:
        r0 = r4.next();
        r0 = (com.tencent.mm.plugin.fts.d.b.a.a) r0;
        r3 = r0.isAvailable();
        if (r3 == 0) goto L_0x0232;
    L_0x0224:
        r0 = a(r2, r0, r14);
        r3 = r0.aMA;
        if (r3 != 0) goto L_0x0232;
    L_0x022c:
        r1 = r0;
        goto L_0x0212;
    L_0x022e:
        r1 = r3;
    L_0x022f:
        r3 = r1;
        goto L_0x0020;
    L_0x0232:
        r0 = r1;
        goto L_0x022c;
    L_0x0234:
        r0 = r4;
        goto L_0x00c0;
    L_0x0237:
        r1 = r0;
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.d.f.b(com.tencent.mm.plugin.fts.d.b.a):com.tencent.mm.plugin.fts.d.b.b");
    }

    private static com.tencent.mm.plugin.fts.d.b.b a(SpannableString spannableString, com.tencent.mm.plugin.fts.d.b.a.a aVar, com.tencent.mm.plugin.fts.d.b.a aVar2) {
        if (aVar2.mdE <= 0.0f || aVar2.haK == null) {
            return b(spannableString, aVar, aVar2);
        }
        return c(spannableString, aVar, aVar2);
    }

    private static List<String> Y(String str, boolean z) {
        List arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (d.f(charAt)) {
                String d = SpellMap.d(charAt);
                if (d == null || d.length() <= 1) {
                    arrayList.add("");
                } else if (z) {
                    arrayList.add(d.substring(0, 1).toLowerCase());
                } else {
                    arrayList.add(d);
                }
            } else {
                arrayList.add("");
            }
        }
        return arrayList;
    }

    private static void a(String str, String str2, com.tencent.mm.plugin.fts.d.b.a.a aVar) {
        aVar.mdz = SpellMap.mx(str2.toLowerCase());
        int indexOf = str.indexOf(aVar.mdz);
        if (indexOf >= 0) {
            aVar.mdF = indexOf;
            aVar.mdG = indexOf + aVar.mdz.length();
        }
    }

    private static void a(List<String> list, String str, com.tencent.mm.plugin.fts.d.b.a.a aVar) {
        aVar.mdz = SpellMap.mx(str.toLowerCase());
        for (int i = 0; i < list.size(); i++) {
            String str2 = (String) list.get(i);
            if (!bg.mA(str2)) {
                if (str2.startsWith(aVar.mdz)) {
                    if (aVar.mdF < 0) {
                        aVar.mdF = i;
                    }
                    aVar.mdG = i + 1;
                    return;
                } else if (aVar.mdz.startsWith(str2)) {
                    int i2 = i + 1;
                    String str3 = str2;
                    while (i2 < list.size() && !bg.mA((String) list.get(i2))) {
                        str3 = str3 + ((String) list.get(i2));
                        if (aVar.mdz.length() > str3.length() && aVar.mdz.startsWith(str3)) {
                            i2++;
                        } else if (aVar.mdz.length() <= str3.length() && str3.startsWith(aVar.mdz)) {
                            aVar.mdF = i;
                            aVar.mdG = i2 + 1;
                        }
                    }
                }
            }
        }
    }

    private static com.tencent.mm.plugin.fts.d.b.b b(SpannableString spannableString, com.tencent.mm.plugin.fts.d.b.a.a aVar, com.tencent.mm.plugin.fts.d.b.a aVar2) {
        Object backgroundColorSpan;
        com.tencent.mm.plugin.fts.d.b.b bVar = new com.tencent.mm.plugin.fts.d.b.b();
        if (aVar2.mdC == com.tencent.mm.plugin.fts.d.b.a.b.mdI) {
            backgroundColorSpan = new BackgroundColorSpan(aVar2.mdD);
        } else {
            backgroundColorSpan = new ForegroundColorSpan(aVar2.mdD);
        }
        try {
            spannableString.setSpan(backgroundColorSpan, aVar.mdF, aVar.mdG, 33);
            bVar.mdL = spannableString;
            bVar.aMA = 0;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FTS.FTSUIHighlightLogic", e, "setSpan %s", aVar.toString());
            bVar.mdL = spannableString;
            bVar.aMA = -1;
        }
        return bVar;
    }

    private static com.tencent.mm.plugin.fts.d.b.b c(SpannableString spannableString, com.tencent.mm.plugin.fts.d.b.a.a aVar, com.tencent.mm.plugin.fts.d.b.a aVar2) {
        com.tencent.mm.plugin.fts.d.b.b bVar = new com.tencent.mm.plugin.fts.d.b.b();
        float textSize = aVar2.mdE - (aVar2.haK.getTextSize() * 2.0f);
        float measureText = aVar2.haK.measureText("…");
        float measureText2 = aVar2.haK.measureText(spannableString, 0, aVar.mdF);
        float measureText3 = aVar2.haK.measureText(spannableString, aVar.mdF, aVar.mdG);
        float measureText4 = aVar2.haK.measureText(spannableString, aVar.mdG, spannableString.length());
        if ((measureText2 + measureText3) + measureText4 < textSize) {
            return b(spannableString, aVar, aVar2);
        }
        Object backgroundColorSpan;
        if (aVar2.mdC == com.tencent.mm.plugin.fts.d.b.a.b.mdI) {
            backgroundColorSpan = new BackgroundColorSpan(aVar2.mdD);
        } else {
            backgroundColorSpan = new ForegroundColorSpan(aVar2.mdD);
        }
        CharSequence spannableString2 = new SpannableString(spannableString.subSequence(aVar.mdF, aVar.mdG));
        try {
            spannableString2.setSpan(backgroundColorSpan, 0, spannableString2.length(), 33);
            CharSequence spannableStringBuilder;
            if ((measureText2 + measureText3) + measureText < textSize) {
                spannableStringBuilder = new SpannableStringBuilder(spannableString, 0, aVar.mdF);
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString.subSequence(aVar.mdG, spannableString.length()), aVar2.haK, (textSize - measureText2) - measureText3, TruncateAt.END));
                bVar.mdL = spannableStringBuilder;
            } else if ((measureText + measureText3) + measureText4 < textSize) {
                spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString.subSequence(0, aVar.mdF), aVar2.haK, (textSize - measureText3) - measureText4, TruncateAt.START));
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(spannableString, aVar.mdG, spannableString.length());
                bVar.mdL = spannableStringBuilder;
            } else if ((measureText + measureText3) + measureText >= textSize) {
                spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString2, aVar2.haK, textSize, TruncateAt.END));
                bVar.mdL = spannableStringBuilder;
            } else {
                spannableStringBuilder = new SpannableStringBuilder();
                textSize = (textSize - measureText3) / 2.0f;
                CharSequence subSequence = spannableString.subSequence(0, aVar.mdF);
                CharSequence subSequence2 = spannableString.subSequence(aVar.mdG, spannableString.length());
                spannableStringBuilder.append(TextUtils.ellipsize(subSequence, aVar2.haK, textSize, TruncateAt.START));
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(TextUtils.ellipsize(subSequence2, aVar2.haK, textSize, TruncateAt.END));
                bVar.mdL = spannableStringBuilder;
            }
            bVar.aMA = 0;
            return bVar;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FTS.FTSUIHighlightLogic", e, "setSpan %s", aVar.toString());
            bVar.aMA = -1;
            bVar.mdL = spannableString;
            return bVar;
        }
    }
}
