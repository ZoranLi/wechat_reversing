package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.fts.d.j.a;
import com.tencent.mm.plugin.fts.d.j.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;

public final class e {
    public static boolean a(CharSequence charSequence, TextView textView) {
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(charSequence, BufferType.SPANNABLE);
        textView.setVisibility(0);
        return true;
    }

    public static boolean a(String str, TextView textView) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(str);
        textView.setVisibility(0);
        return true;
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i) {
        a(context, imageView, str, str2, i, true, 0, 0);
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i, int i2, int i3) {
        a(context, imageView, str, str2, i, false, i2, i3);
    }

    private static void a(Context context, ImageView imageView, String str, String str2, int i, boolean z, int i2, int i3) {
        h.aye().a(imageView, str, str2, z, i2, i3);
        if (!bg.mA(str) || !bg.mA(str2)) {
            Bitmap a = h.aye().a(str, str2, z, i2, i3);
            if (a == null || a.isRecycled()) {
                if (i > 0) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(a.transparent);
                }
                h.aye().a(context, imageView, str, str2, z, i2, i3);
            } else {
                g.a.a(context.getResources(), a, imageView);
            }
            imageView.setVisibility(0);
        } else if (i <= 0 || (bg.mA(str) && bg.mA(str2))) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
    }

    public static String mU(int i) {
        int i2 = 0;
        switch (i) {
            case -13:
                i2 = g.mda;
                break;
            case -11:
                i2 = g.mcZ;
                break;
            case -8:
                i2 = g.enm;
                break;
            case -7:
                i2 = g.mcW;
                break;
            case -6:
                i2 = g.mcV;
                break;
            case -5:
                i2 = g.mcX;
                break;
            case -4:
                i2 = g.enf;
                break;
            case -3:
                i2 = g.ene;
                break;
            case -2:
                i2 = g.mcY;
                break;
            case -1:
                i2 = g.mcU;
                break;
        }
        if (i2 == 0) {
            return null;
        }
        return ab.getContext().getString(i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.CharSequence a(android.content.Context r10, java.util.List<com.tencent.mm.plugin.fts.a.a.d> r11, java.lang.String[] r12, java.util.List<java.lang.String> r13, android.text.TextPaint r14, java.lang.String r15) {
        /*
        r0 = com.tencent.mm.plugin.fts.a.l.class;
        r0 = com.tencent.mm.kernel.h.j(r0);
        r0 = (com.tencent.mm.plugin.fts.a.l) r0;
        r1 = new com.tencent.mm.plugin.fts.d.e$1;
        r1.<init>(r0);
        java.util.Arrays.sort(r12, r1);
        r9 = new android.text.SpannableStringBuilder;
        r9.<init>();
        r0 = 0;
        r2 = r0;
    L_0x0017:
        r0 = r11.size();
        if (r2 >= r0) goto L_0x00a2;
    L_0x001d:
        r0 = r11.get(r2);
        r0 = (com.tencent.mm.plugin.fts.a.a.d) r0;
        r1 = r0.lZP;
        r3 = r12.length;
        if (r1 >= r3) goto L_0x0065;
    L_0x0028:
        r1 = r0.lZP;
        r3 = r12[r1];
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r1 != 0) goto L_0x0065;
    L_0x0032:
        r1 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r1 = com.tencent.mm.kernel.h.h(r1);
        r1 = (com.tencent.mm.plugin.messenger.foundation.a.h) r1;
        r1 = r1.wR();
        r1 = r1.Rc(r3);
        if (r1 == 0) goto L_0x0065;
    L_0x0044:
        r3 = r1.field_username;
        r4 = com.tencent.mm.u.o.a(r1, r3);
        r5 = r0.hPr;
        switch(r5) {
            case 29: goto L_0x0091;
            case 30: goto L_0x008e;
            case 31: goto L_0x008b;
            case 32: goto L_0x009b;
            case 33: goto L_0x0094;
            case 34: goto L_0x007c;
            case 35: goto L_0x0079;
            case 36: goto L_0x0076;
            case 37: goto L_0x0069;
            default: goto L_0x004f;
        };
    L_0x004f:
        r1 = r0.lZR;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x0065;
    L_0x0057:
        r1 = r0.lZR;
        r1 = r1.contains(r15);
        if (r1 == 0) goto L_0x0065;
    L_0x005f:
        r1 = r0.lZT;
        r1 = r1 + 10;
        r0.lZT = r1;
    L_0x0065:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0017;
    L_0x0069:
        r1 = r1.pA();
        r1 = com.tencent.mm.plugin.fts.a.d.ch(r3, r1);
        r0.lZR = r1;
        r0.lZS = r4;
        goto L_0x004f;
    L_0x0076:
        r3 = 1;
        r0.lZV = r3;
    L_0x0079:
        r3 = 1;
        r0.lZU = r3;
    L_0x007c:
        r3 = r1.field_nickname;
        r0.lZR = r3;
        r1 = r1.field_nickname;
        r1 = r1.equals(r4);
        if (r1 != 0) goto L_0x004f;
    L_0x0088:
        r0.lZS = r4;
        goto L_0x004f;
    L_0x008b:
        r1 = 1;
        r0.lZV = r1;
    L_0x008e:
        r1 = 1;
        r0.lZU = r1;
    L_0x0091:
        r0.lZR = r4;
        goto L_0x004f;
    L_0x0094:
        r1 = r0.content;
        r0.lZR = r1;
        r0.lZS = r4;
        goto L_0x004f;
    L_0x009b:
        r1 = r1.gkK;
        r0.lZR = r1;
        r0.lZS = r4;
        goto L_0x004f;
    L_0x00a2:
        r0 = new com.tencent.mm.plugin.fts.d.e$2;
        r0.<init>();
        java.util.Collections.sort(r11, r0);
        r0 = 0;
        r8 = r0;
    L_0x00ac:
        r0 = r11.size();
        if (r8 >= r0) goto L_0x0188;
    L_0x00b2:
        r0 = r13.size();
        if (r8 >= r0) goto L_0x0188;
    L_0x00b8:
        r0 = r11.get(r8);
        r7 = r0;
        r7 = (com.tencent.mm.plugin.fts.a.a.d) r7;
        r0 = r7.lZR;
        r1 = r14.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.h.b(r10, r0, r1);
        r1 = r9.length();
        if (r1 <= 0) goto L_0x00d5;
    L_0x00cf:
        r1 = ", ";
        r9.append(r1);
    L_0x00d5:
        r3 = r7.lZU;
        r4 = r7.lZV;
        r1 = com.tencent.mm.plugin.fts.d.f.a.mcJ;
        r1 = r1 + -100;
        r5 = (float) r1;
        r1 = r15;
        r2 = r13;
        r6 = r14;
        r1 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5, r6);
        r2 = com.tencent.mm.plugin.fts.d.f.a(r1);
        r1 = r7.lZS;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x0118;
    L_0x00f1:
        r1 = new com.tencent.mm.plugin.fts.d.b.a;
        r1.<init>();
        r1.mdy = r0;
        r1.mdB = r2;
        r0 = r7.lZU;
        r1.lZU = r0;
        r0 = r7.lZV;
        r1.mdA = r0;
        r0 = com.tencent.mm.plugin.fts.d.f.a.mcJ;
        r0 = r0 + -100;
        r0 = (float) r0;
        r1.mdE = r0;
        r1.haK = r14;
        r0 = com.tencent.mm.plugin.fts.d.f.b(r1);
        r0 = r0.mdL;
        r9.append(r0);
    L_0x0114:
        r0 = r8 + 1;
        r8 = r0;
        goto L_0x00ac;
    L_0x0118:
        r1 = r7.lZS;
        r3 = r14.getTextSize();
        r1 = com.tencent.mm.pluginsdk.ui.d.h.b(r10, r1, r3);
        r3 = 2;
        r3 = new java.lang.CharSequence[r3];
        r4 = 0;
        r3[r4] = r1;
        r1 = 1;
        r4 = "(";
        r3[r1] = r4;
        r3 = android.text.TextUtils.concat(r3);
        r4 = r3.length();
        r5 = r2.iterator();
    L_0x013a:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x0151;
    L_0x0140:
        r1 = r5.next();
        r1 = (com.tencent.mm.plugin.fts.d.b.a.a) r1;
        r6 = r1.mdF;
        r6 = r6 + r4;
        r1.mdF = r6;
        r6 = r1.mdG;
        r6 = r6 + r4;
        r1.mdG = r6;
        goto L_0x013a;
    L_0x0151:
        r1 = new com.tencent.mm.plugin.fts.d.b.a;
        r1.<init>();
        r4 = 3;
        r4 = new java.lang.CharSequence[r4];
        r5 = 0;
        r4[r5] = r3;
        r3 = 1;
        r4[r3] = r0;
        r0 = 2;
        r3 = ")";
        r4[r0] = r3;
        r0 = android.text.TextUtils.concat(r4);
        r1.mdy = r0;
        r1.mdB = r2;
        r0 = r7.lZU;
        r1.lZU = r0;
        r0 = r7.lZV;
        r1.mdA = r0;
        r0 = com.tencent.mm.plugin.fts.d.f.a.mcJ;
        r0 = r0 + -100;
        r0 = (float) r0;
        r1.mdE = r0;
        r1.haK = r14;
        r0 = com.tencent.mm.plugin.fts.d.f.b(r1);
        r0 = r0.mdL;
        r9.append(r0);
        goto L_0x0114;
    L_0x0188:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.d.e.a(android.content.Context, java.util.List, java.lang.String[], java.util.List, android.text.TextPaint, java.lang.String):java.lang.CharSequence");
    }
}
