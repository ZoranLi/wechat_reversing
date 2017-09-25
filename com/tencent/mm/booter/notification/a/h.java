package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.R;
import com.tencent.mm.bi.b;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.lang.ref.WeakReference;

public final class h {
    private static WeakReference<TextPaint> gMx;
    private static int gMy = 0;
    private static int gMz = 0;
    public String gMv = "";
    public String gMw = "";
    public String mTitle = "";

    public static String a(Context context, String str, String str2, int i) {
        return com.tencent.mm.pluginsdk.ui.d.h.Ng(b.bKy().Qy(a(0, str2, str, i, context)));
    }

    public static String f(Context context, String str, String str2) {
        String gi;
        if (o.dH(str)) {
            gi = ay.gi(str2);
            if (gi != null) {
                gi = n.eK(gi.trim());
            } else {
                gi = n.eK(str);
            }
        } else {
            gi = n.eK(str);
        }
        if (str.contains("@bottle")) {
            return context.getResources().getQuantityString(R.j.dsx, 1, new Object[]{Integer.valueOf(1)});
        }
        if (bg.mA(gi) && o.dH(str)) {
            gi = context.getString(R.l.dVr);
        }
        return b.bKy().Qy(gi);
    }

    public static String b(x xVar) {
        Context context = ab.getContext();
        if (xVar == null) {
            return context.getString(R.l.dPF);
        }
        String city;
        if (RegionCodeDecoder.RR(xVar.getCountryCode())) {
            city = xVar.getCity();
            if (!bg.mA(city)) {
                return city;
            }
            city = n.eM(xVar.getProvince());
            if (!bg.mA(city)) {
                return city;
            }
            RegionCodeDecoder.bMP();
            return RegionCodeDecoder.getLocName(xVar.getCountryCode());
        }
        city = n.eM(xVar.getProvince());
        return bg.mA(city) ? context.getString(R.l.dPF) : city;
    }

    public static String b(au auVar, PString pString, PString pString2, PInt pInt, boolean z) {
        return bg.mz(a(auVar.field_imgPath, auVar.field_isSend, auVar.field_talker, com.tencent.mm.pluginsdk.ui.d.h.Ng(auVar.bMg() ? auVar.bMC() : auVar.field_content), auVar.field_type, ab.getContext(), pString, pString2, pInt, true, z));
    }

    public static String a(int i, String str, String str2, int i2, Context context) {
        return bg.mz(a(null, i, str, str2, i2, context, new PString(), new PString(), new PInt(), false, false));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, int r22, android.content.Context r23, com.tencent.mm.pointers.PString r24, com.tencent.mm.pointers.PString r25, com.tencent.mm.pointers.PInt r26, boolean r27, boolean r28) {
        /*
        r5 = "context is null";
        if (r23 == 0) goto L_0x0032;
    L_0x0005:
        r4 = 1;
    L_0x0006:
        junit.framework.Assert.assertTrue(r5, r4);
        r5 = "username is null";
        if (r20 == 0) goto L_0x0034;
    L_0x000e:
        r4 = r20.length();
        if (r4 <= 0) goto L_0x0034;
    L_0x0014:
        r4 = 1;
    L_0x0015:
        junit.framework.Assert.assertTrue(r5, r4);
        if (r27 != 0) goto L_0x005b;
    L_0x001a:
        r4 = com.tencent.mm.u.o.fa(r20);
        if (r4 == 0) goto L_0x0036;
    L_0x0020:
        r4 = com.tencent.mm.u.m.yd();
        if (r4 != 0) goto L_0x0036;
    L_0x0026:
        r4 = 1;
    L_0x0027:
        if (r4 == 0) goto L_0x005b;
    L_0x0029:
        r4 = com.tencent.mm.R.l.eTy;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x0031:
        return r4;
    L_0x0032:
        r4 = 0;
        goto L_0x0006;
    L_0x0034:
        r4 = 0;
        goto L_0x0015;
    L_0x0036:
        r4 = com.tencent.mm.u.o.fc(r20);
        if (r4 == 0) goto L_0x004b;
    L_0x003c:
        r4 = com.tencent.mm.u.m.xP();
        r4 = r4 & 64;
        if (r4 == 0) goto L_0x0049;
    L_0x0044:
        r4 = 1;
    L_0x0045:
        if (r4 != 0) goto L_0x004b;
    L_0x0047:
        r4 = 1;
        goto L_0x0027;
    L_0x0049:
        r4 = 0;
        goto L_0x0045;
    L_0x004b:
        r4 = com.tencent.mm.u.o.fg(r20);
        if (r4 == 0) goto L_0x0059;
    L_0x0051:
        r4 = com.tencent.mm.u.m.yg();
        if (r4 != 0) goto L_0x0059;
    L_0x0057:
        r4 = 1;
        goto L_0x0027;
    L_0x0059:
        r4 = 0;
        goto L_0x0027;
    L_0x005b:
        r16 = 0;
        r15 = 0;
        r4 = com.tencent.mm.u.o.fg(r20);
        if (r4 == 0) goto L_0x00d1;
    L_0x0064:
        if (r27 == 0) goto L_0x006a;
    L_0x0066:
        r4 = "";
        goto L_0x0031;
    L_0x006a:
        r5 = com.tencent.mm.u.m.yg();
        com.tencent.mm.u.ap.yY();
        r4 = com.tencent.mm.u.c.vr();
        r6 = 65793; // 0x10101 float:9.2196E-41 double:3.2506E-319;
        r7 = 0;
        r4 = r4.get(r6, r7);
        r4 = (java.lang.Long) r4;
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bg.a(r4, r6);
        if (r5 != 0) goto L_0x0090;
    L_0x0087:
        r4 = com.tencent.mm.R.l.eTy;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0031;
    L_0x0090:
        r4 = 0;
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x009f;
    L_0x0096:
        r4 = com.tencent.mm.R.l.elK;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0031;
    L_0x009f:
        r4 = com.tencent.mm.sdk.platformtools.bg.az(r6);
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r8;
        r8 = 1209600000; // 0x48190800 float:156704.0 double:5.97621805E-315;
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r4 <= 0) goto L_0x00cc;
    L_0x00ad:
        r4 = com.tencent.mm.R.l.elJ;
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bg.az(r6);
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r10;
        r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r6 = r6 / r10;
        r6 = java.lang.Long.valueOf(r6);
        r5[r8] = r6;
        r0 = r23;
        r4 = r0.getString(r4, r5);
        goto L_0x0031;
    L_0x00cc:
        r4 = "";
        goto L_0x0031;
    L_0x00d1:
        r14 = "";
        r6 = "";
        r5 = "";
        r4 = 0;
        if (r21 == 0) goto L_0x12f5;
    L_0x00dd:
        if (r27 == 0) goto L_0x12f5;
    L_0x00df:
        r4 = 1;
        r21 = dk(r21);
        r11 = r4;
    L_0x00e5:
        r0 = r21;
        r1 = r24;
        r1.value = r0;
        if (r19 != 0) goto L_0x12ef;
    L_0x00ed:
        r4 = com.tencent.mm.u.o.dH(r20);
        if (r4 == 0) goto L_0x12ef;
    L_0x00f3:
        r4 = com.tencent.mm.u.ay.gh(r21);
        if (r4 <= 0) goto L_0x12ef;
    L_0x00f9:
        r5 = 0;
        r0 = r21;
        r5 = r0.substring(r5, r4);
        r6 = r5.trim();
        r0 = r20;
        r5 = com.tencent.mm.u.n.E(r6, r0);
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r21;
        r7 = r7.append(r0);
        r8 = " ";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r4 = r4 + 1;
        r4 = r7.substring(r4);
        r12 = r5;
        r13 = r6;
    L_0x0128:
        r5 = 0;
        r6 = com.tencent.mm.u.o.fu(r20);
        if (r6 != 0) goto L_0x0135;
    L_0x012f:
        r6 = com.tencent.mm.u.o.fD(r20);
        if (r6 == 0) goto L_0x0176;
    L_0x0135:
        r6 = ":";
        r0 = r21;
        r6 = r0.indexOf(r6);
        r7 = -1;
        if (r6 == r7) goto L_0x0154;
    L_0x0141:
        r7 = 0;
        r0 = r21;
        r7 = r0.substring(r7, r6);
        r0 = r25;
        r0.value = r7;
        r6 = r6 + 1;
        r0 = r21;
        r21 = r0.substring(r6);
    L_0x0154:
        r17 = r5;
        r7 = r21;
    L_0x0158:
        switch(r22) {
            case -1879048191: goto L_0x037c;
            case -1879048190: goto L_0x037c;
            case -1879048189: goto L_0x037c;
            case -1879048188: goto L_0x03cc;
            case -1879048186: goto L_0x0951;
            case -1879048185: goto L_0x09c2;
            case -1879048183: goto L_0x09c2;
            case -1879048176: goto L_0x09c2;
            case 3: goto L_0x01b4;
            case 11: goto L_0x0252;
            case 13: goto L_0x0235;
            case 23: goto L_0x01b4;
            case 33: goto L_0x01b4;
            case 34: goto L_0x0268;
            case 35: goto L_0x0498;
            case 36: goto L_0x0252;
            case 37: goto L_0x03dc;
            case 39: goto L_0x0235;
            case 40: goto L_0x0464;
            case 42: goto L_0x04cd;
            case 43: goto L_0x02ea;
            case 47: goto L_0x01f3;
            case 48: goto L_0x058c;
            case 49: goto L_0x0a0d;
            case 50: goto L_0x038c;
            case 52: goto L_0x03bc;
            case 53: goto L_0x038c;
            case 55: goto L_0x0ff2;
            case 57: goto L_0x0ff2;
            case 62: goto L_0x02ea;
            case 1048625: goto L_0x01f3;
            case 12299999: goto L_0x036c;
            case 16777265: goto L_0x0a0d;
            case 268435505: goto L_0x0a0d;
            case 285212721: goto L_0x0fb8;
            case 318767153: goto L_0x0fd9;
            case 335544369: goto L_0x05e7;
            case 369098801: goto L_0x07b5;
            case 402653233: goto L_0x0638;
            case 419430449: goto L_0x067b;
            case 436207665: goto L_0x0706;
            case 452984881: goto L_0x0813;
            case 469762097: goto L_0x0706;
            case 486539313: goto L_0x0fb8;
            case 503316529: goto L_0x1005;
            case 520093745: goto L_0x08b6;
            case 553648177: goto L_0x0a0d;
            default: goto L_0x015b;
        };
    L_0x015b:
        r4 = r14;
        r5 = r15;
        r6 = r16;
    L_0x015f:
        r8 = com.tencent.mm.u.o.fb(r20);
        if (r8 == 0) goto L_0x112a;
    L_0x0165:
        r5 = 1;
        r0 = r19;
        if (r5 != r0) goto L_0x105d;
    L_0x016a:
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r5 != 0) goto L_0x103c;
    L_0x0170:
        r0 = r24;
        r0.value = r4;
        goto L_0x0031;
    L_0x0176:
        com.tencent.mm.u.ap.yY();
        r6 = com.tencent.mm.u.c.wW();
        r0 = r20;
        r6 = r6.Rm(r0);
        if (r6 == 0) goto L_0x018d;
    L_0x0185:
        r7 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r6 = r6.eC(r7);
        if (r6 != 0) goto L_0x018f;
    L_0x018d:
        if (r28 == 0) goto L_0x12e9;
    L_0x018f:
        r5 = 1;
        r6 = ":";
        r0 = r21;
        r6 = r0.indexOf(r6);
        r7 = -1;
        if (r6 == r7) goto L_0x12e9;
    L_0x019c:
        r7 = 0;
        r0 = r21;
        r7 = r0.substring(r7, r6);
        r0 = r25;
        r0.value = r7;
        r6 = r6 + 1;
        r0 = r21;
        r21 = r0.substring(r6);
        r17 = r5;
        r7 = r21;
        goto L_0x0158;
    L_0x01b4:
        r4 = com.tencent.mm.R.l.dIi;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x01eb;
    L_0x01c2:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x01d6:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x01ef;
    L_0x01dc:
        r5 = "%s: ";
    L_0x01df:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x01eb:
        r4 = "";
        goto L_0x01d6;
    L_0x01ef:
        r5 = "";
        goto L_0x01df;
    L_0x01f3:
        r5 = com.tencent.mm.storage.aj.RD(r7);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = r5.iah;
        r4 = r4.append(r6);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.toString();
        if (r18 == 0) goto L_0x022c;
    L_0x020f:
        r6 = r18.length();
        r7 = 32;
        if (r6 != r7) goto L_0x022c;
    L_0x0217:
        r6 = "";
        r0 = r24;
        r0.value = r6;
        r5 = r5.iah;
        r0 = r25;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x022c:
        r6 = com.tencent.mm.R.l.dGL;
        r0 = r23;
        r18 = r0.getString(r6);
        goto L_0x0217;
    L_0x0235:
        r4 = com.tencent.mm.R.l.dIi;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0252:
        r8 = 0;
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0268:
        r4 = com.tencent.mm.storage.x.QM(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x026e:
        r4 = com.tencent.mm.storage.x.QO(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x0274:
        r4 = com.tencent.mm.u.o.fa(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x027a:
        r4 = com.tencent.mm.u.o.fc(r20);
        if (r4 == 0) goto L_0x029d;
    L_0x0280:
        r4 = com.tencent.mm.R.l.dIY;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x029d:
        if (r7 == 0) goto L_0x02d9;
    L_0x029f:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x02d9;
    L_0x02a5:
        r4 = com.tencent.mm.u.o.fb(r20);
        if (r4 != 0) goto L_0x02d9;
    L_0x02ab:
        r4 = com.tencent.mm.u.o.dH(r20);
        if (r4 == 0) goto L_0x02e6;
    L_0x02b1:
        r4 = new com.tencent.mm.modelvoice.n;
        r4.<init>(r7);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r4.iah;
        r5 = r5.append(r6);
        r6 = ": ";
        r5 = r5.append(r6);
        r7 = r5.toString();
        r5 = "%s:";
        r0 = r24;
        r0.value = r5;
        r4 = r4.iah;
        r0 = r25;
        r0.value = r4;
    L_0x02d9:
        r4 = com.tencent.mm.R.l.dIY;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x02e6:
        r7 = "";
        goto L_0x02d9;
    L_0x02ea:
        r4 = com.tencent.mm.storage.x.QM(r20);
        if (r4 != 0) goto L_0x0302;
    L_0x02f0:
        r4 = com.tencent.mm.storage.x.QO(r20);
        if (r4 != 0) goto L_0x0302;
    L_0x02f6:
        r4 = com.tencent.mm.u.o.fa(r20);
        if (r4 != 0) goto L_0x0302;
    L_0x02fc:
        r4 = com.tencent.mm.u.o.fc(r20);
        if (r4 == 0) goto L_0x031f;
    L_0x0302:
        r4 = com.tencent.mm.R.l.dIX;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x031f:
        if (r7 == 0) goto L_0x035b;
    L_0x0321:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x035b;
    L_0x0327:
        r4 = com.tencent.mm.u.o.fb(r20);
        if (r4 != 0) goto L_0x035b;
    L_0x032d:
        r4 = com.tencent.mm.u.o.dH(r20);
        if (r4 == 0) goto L_0x0368;
    L_0x0333:
        r4 = new com.tencent.mm.modelvideo.p;
        r4.<init>(r7);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r4.iah;
        r5 = r5.append(r6);
        r6 = ": ";
        r5 = r5.append(r6);
        r7 = r5.toString();
        r5 = "%s:";
        r0 = r24;
        r0.value = r5;
        r4 = r4.iah;
        r0 = r25;
        r0.value = r4;
    L_0x035b:
        r4 = com.tencent.mm.R.l.dIX;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0368:
        r7 = "";
        goto L_0x035b;
    L_0x036c:
        r7 = "";
        r4 = com.tencent.mm.R.l.dJb;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x037c:
        r7 = "";
        r4 = com.tencent.mm.R.l.dJa;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x038c:
        r4 = com.tencent.mm.storage.au.uJR;
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x03a4;
    L_0x0394:
        r7 = "";
        r4 = com.tencent.mm.R.l.dJb;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x03a4:
        r4 = com.tencent.mm.storage.au.uJQ;
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x015b;
    L_0x03ac:
        r7 = "";
        r4 = com.tencent.mm.R.l.dJc;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x03bc:
        r7 = "";
        r4 = com.tencent.mm.R.l.dJb;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x03cc:
        r7 = "";
        r4 = com.tencent.mm.R.l.dJc;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x03dc:
        if (r7 == 0) goto L_0x015b;
    L_0x03de:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x03e4:
        r4 = com.tencent.mm.storage.au.d.RI(r7);
        r5 = r4.rUK;
        if (r5 == 0) goto L_0x040f;
    L_0x03ec:
        r5 = r4.rUK;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x040f;
    L_0x03f4:
        r5 = r4.scene;
        switch(r5) {
            case 18: goto L_0x0415;
            case 19: goto L_0x03f9;
            case 20: goto L_0x03f9;
            case 21: goto L_0x03f9;
            case 22: goto L_0x042e;
            case 23: goto L_0x042e;
            case 24: goto L_0x042e;
            case 25: goto L_0x0447;
            case 26: goto L_0x042e;
            case 27: goto L_0x042e;
            case 28: goto L_0x042e;
            case 29: goto L_0x042e;
            default: goto L_0x03f9;
        };
    L_0x03f9:
        r5 = com.tencent.mm.R.l.emf;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r7 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r7;
    L_0x040f:
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0415:
        r5 = com.tencent.mm.R.l.elP;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x042e:
        r5 = com.tencent.mm.R.l.elZ;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0447:
        r5 = com.tencent.mm.R.l.eli;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0464:
        if (r7 == 0) goto L_0x015b;
    L_0x0466:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x046c:
        r4 = com.tencent.mm.storage.au.a.RF(r7);
        r5 = r4.rUK;
        if (r5 == 0) goto L_0x0492;
    L_0x0474:
        r5 = r4.rUK;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x0492;
    L_0x047c:
        r5 = com.tencent.mm.R.l.ely;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r7 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r7;
    L_0x0492:
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0498:
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x04a2:
        com.tencent.mm.u.ap.yY();
        r4 = com.tencent.mm.u.c.wT();
        r4 = r4.At(r7);
        r5 = com.tencent.mm.R.l.elI;
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r4.hRP;
        r6[r7] = r8;
        r7 = 1;
        r4 = r4.title;
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x04cd:
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x04d7:
        r4 = com.tencent.mm.u.o.dH(r20);
        if (r4 == 0) goto L_0x04e7;
    L_0x04dd:
        r4 = com.tencent.mm.u.ay.gi(r7);
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 == 0) goto L_0x04e9;
    L_0x04e7:
        r4 = r20;
    L_0x04e9:
        com.tencent.mm.u.ap.yY();
        r5 = com.tencent.mm.u.c.wT();
        r6 = r5.Av(r7);
        com.tencent.mm.u.ap.yY();
        r5 = com.tencent.mm.u.c.wR();
        r5 = r5.Rc(r4);
        r5 = r5.tL();
        r7 = com.tencent.mm.u.o.dH(r5);
        if (r7 == 0) goto L_0x0511;
    L_0x0509:
        r5 = com.tencent.mm.u.j.eD(r5);
        r5 = com.tencent.mm.u.j.s(r5);
    L_0x0511:
        r7 = 1;
        r0 = r19;
        if (r0 != r7) goto L_0x0551;
    L_0x0516:
        r7 = com.tencent.mm.R.l.elj;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r5;
        r5 = 1;
        r9 = r6.getDisplayName();
        r8[r5] = r9;
        r0 = r23;
        r7 = r0.getString(r7, r8);
        r5 = com.tencent.mm.R.l.elj;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "%s";
        r8[r9] = r10;
        r9 = 1;
        r6 = r6.getDisplayName();
        r8[r9] = r6;
        r0 = r23;
        r5 = r0.getString(r5, r8);
        r0 = r24;
        r0.value = r5;
        r0 = r25;
        r0.value = r4;
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0551:
        r7 = com.tencent.mm.R.l.elk;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r5;
        r5 = 1;
        r9 = r6.getDisplayName();
        r8[r5] = r9;
        r0 = r23;
        r7 = r0.getString(r7, r8);
        r5 = com.tencent.mm.R.l.elk;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "%s";
        r8[r9] = r10;
        r9 = 1;
        r6 = r6.getDisplayName();
        r8[r9] = r6;
        r0 = r23;
        r5 = r0.getString(r5, r8);
        r0 = r24;
        r0.value = r5;
        r0 = r25;
        r0.value = r4;
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x058c:
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x0596:
        r4 = com.tencent.mm.u.o.dH(r20);
        if (r4 == 0) goto L_0x12e5;
    L_0x059c:
        r4 = com.tencent.mm.u.ay.gh(r7);
        r5 = -1;
        if (r4 == r5) goto L_0x12e1;
    L_0x05a3:
        r5 = 0;
        r4 = r7.substring(r5, r4);
        r4 = r4.trim();
    L_0x05ac:
        com.tencent.mm.u.ay.gj(r7);
        r5 = r4;
    L_0x05b0:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x05c8;
    L_0x05b5:
        r4 = com.tencent.mm.R.l.ewp;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x05c8:
        r4 = com.tencent.mm.R.l.ewp;
        r0 = r23;
        r4 = r0.getString(r4);
        r6 = com.tencent.mm.R.l.ewp;
        r0 = r23;
        r6 = r0.getString(r6);
        r0 = r24;
        r0.value = r6;
        r0 = r25;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x05e7:
        r4 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r4 = com.tencent.mm.t.f.a.ek(r4);
        r5 = r4.hhL;
        if (r5 == 0) goto L_0x062f;
    L_0x05f3:
        r5 = r4.hhL;
        r6 = 1;
        if (r5 != r6) goto L_0x0613;
    L_0x05f8:
        r4 = com.tencent.mm.R.l.ePi;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x0600:
        r7 = "";
        r0 = r25;
        r0.value = r13;
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0613:
        r5 = r4.hhL;
        r6 = 2;
        if (r5 != r6) goto L_0x0621;
    L_0x0618:
        r4 = com.tencent.mm.R.l.ePk;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0600;
    L_0x0621:
        r4 = r4.hhL;
        r5 = 3;
        if (r4 != r5) goto L_0x062f;
    L_0x0626:
        r4 = com.tencent.mm.R.l.ePj;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0600;
    L_0x062f:
        r4 = com.tencent.mm.R.l.ePl;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0600;
    L_0x0638:
        r5 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.t.f.a.ek(r5);
        if (r5 == 0) goto L_0x066f;
    L_0x0648:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = com.tencent.mm.R.l.ePt;
        r0 = r23;
        r6 = r0.getString(r6);
        r4 = r4.append(r6);
        r5 = r5.title;
        r5 = com.tencent.mm.sdk.platformtools.bg.mz(r5);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        r0 = r24;
        r4 = r0.value;
    L_0x066f:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x067b:
        r5 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.t.f.a.ek(r5);
        if (r5 == 0) goto L_0x06a4;
    L_0x068b:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x06b0;
    L_0x0690:
        r4 = 1;
    L_0x0691:
        r6 = r5.his;
        switch(r6) {
            case 1: goto L_0x06b2;
            case 2: goto L_0x0696;
            case 3: goto L_0x06ce;
            case 4: goto L_0x06ea;
            default: goto L_0x0696;
        };
    L_0x0696:
        r4 = r5.title;
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r4);
        r0 = r24;
        r0.value = r4;
    L_0x06a0:
        r0 = r24;
        r4 = r0.value;
    L_0x06a4:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x06b0:
        r4 = 0;
        goto L_0x0691;
    L_0x06b2:
        if (r4 == 0) goto L_0x06c1;
    L_0x06b4:
        r4 = com.tencent.mm.R.l.dJh;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06c1:
        r4 = com.tencent.mm.R.l.dJk;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06ce:
        if (r4 == 0) goto L_0x06dd;
    L_0x06d0:
        r4 = com.tencent.mm.R.l.dJi;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06dd:
        r4 = com.tencent.mm.R.l.dJf;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06ea:
        if (r4 == 0) goto L_0x06f9;
    L_0x06ec:
        r4 = com.tencent.mm.R.l.dJj;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06f9:
        r4 = com.tencent.mm.R.l.dJg;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x0706:
        r5 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.t.f.a.ek(r5);
        if (r5 == 0) goto L_0x0745;
    L_0x0716:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x0759;
    L_0x071b:
        r4 = 1;
    L_0x071c:
        if (r4 == 0) goto L_0x075b;
    L_0x071e:
        r4 = new java.lang.StringBuilder;
        r6 = "[";
        r4.<init>(r6);
        r6 = r5.hiT;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.hiQ;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
    L_0x0741:
        r0 = r24;
        r4 = r0.value;
    L_0x0745:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x12d9;
    L_0x074b:
        if (r17 != 0) goto L_0x12d9;
    L_0x074d:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0759:
        r4 = 0;
        goto L_0x071c;
    L_0x075b:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r12);
        if (r4 != 0) goto L_0x0791;
    L_0x0761:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = com.tencent.mm.sdk.platformtools.bg.mz(r12);
        r4 = r4.append(r6);
        r6 = ": [";
        r4 = r4.append(r6);
        r6 = r5.hiT;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.hiP;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x0741;
    L_0x0791:
        r4 = new java.lang.StringBuilder;
        r6 = "[";
        r4.<init>(r6);
        r6 = r5.hiT;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.hiP;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x0741;
    L_0x07b5:
        r4 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r4 = com.tencent.mm.t.f.a.ek(r4);
        r4 = r4.hhL;
        switch(r4) {
            case 10000: goto L_0x07fd;
            case 20000: goto L_0x0806;
            default: goto L_0x07c2;
        };
    L_0x07c2:
        r4 = com.tencent.mm.R.l.dIk;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x07ca:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x080f;
    L_0x07d0:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r13);
        r6 = ": ";
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x07e4:
        r6 = com.tencent.mm.u.o.fu(r20);
        if (r6 != 0) goto L_0x07f0;
    L_0x07ea:
        if (r17 != 0) goto L_0x07f0;
    L_0x07ec:
        r0 = r25;
        r0.value = r13;
    L_0x07f0:
        r6 = "";
        r0 = r24;
        r0.value = r6;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015f;
    L_0x07fd:
        r4 = com.tencent.mm.R.l.dIl;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x07ca;
    L_0x0806:
        r4 = com.tencent.mm.R.l.dIn;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x07ca;
    L_0x080f:
        r5 = "";
        goto L_0x07e4;
    L_0x0813:
        r4 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r5 = com.tencent.mm.t.f.a.ek(r4);
        if (r5 != 0) goto L_0x082b;
    L_0x081d:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.w.e(r4, r5);
        r4 = "";
        goto L_0x0031;
    L_0x082b:
        r18 = "";
        r4 = com.tencent.mm.R.l.dRv;
        r0 = r23;
        r6 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x088e;
    L_0x083c:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r7 = ": ";
        r4 = r4.append(r7);
        r4 = r4.append(r6);
        r7 = r5.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
    L_0x085a:
        r7 = com.tencent.mm.u.o.fu(r20);
        if (r7 != 0) goto L_0x0866;
    L_0x0860:
        if (r17 != 0) goto L_0x0866;
    L_0x0862:
        r0 = r25;
        r0.value = r13;
    L_0x0866:
        r7 = r13.length();
        if (r7 <= 0) goto L_0x08a2;
    L_0x086c:
        r7 = new java.lang.StringBuilder;
        r8 = "%s: ";
        r7.<init>(r8);
        r6 = r7.append(r6);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x0882:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x088e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r6);
        r7 = r5.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
        goto L_0x085a;
    L_0x08a2:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r6 = r7.append(r6);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
        goto L_0x0882;
    L_0x08b6:
        r4 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r4 = com.tencent.mm.t.f.a.ek(r4);
        if (r4 != 0) goto L_0x08ce;
    L_0x08c0:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.w.e(r4, r5);
        r4 = "";
        goto L_0x0031;
    L_0x08ce:
        r18 = "";
        r5 = com.tencent.mm.R.l.dRv;
        r0 = r23;
        r5 = r0.getString(r5);
        r6 = 1;
        r0 = r19;
        if (r0 != r6) goto L_0x0921;
    L_0x08de:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r4 = r4.hiG;
        r4 = r5.append(r4);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x091f;
    L_0x08f7:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0907:
        r0 = r24;
        r0.value = r4;
    L_0x090b:
        r4 = com.tencent.mm.u.o.fu(r20);
        if (r4 != 0) goto L_0x12d1;
    L_0x0911:
        if (r17 != 0) goto L_0x12d1;
    L_0x0913:
        r0 = r25;
        r0.value = r13;
        r4 = r18;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015f;
    L_0x091f:
        r4 = r5;
        goto L_0x0907;
    L_0x0921:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r4 = r4.hiF;
        r4 = r5.append(r4);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x094f;
    L_0x093a:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x094a:
        r0 = r24;
        r0.value = r4;
        goto L_0x090b;
    L_0x094f:
        r4 = r5;
        goto L_0x094a;
    L_0x0951:
        r4 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r5 = com.tencent.mm.t.f.a.ek(r4);
        if (r5 != 0) goto L_0x0969;
    L_0x095b:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.w.e(r4, r5);
        r4 = "";
        goto L_0x0031;
    L_0x0969:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x09bc;
    L_0x0972:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r6 = r5.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x098c:
        r6 = com.tencent.mm.u.o.fu(r20);
        if (r6 != 0) goto L_0x0998;
    L_0x0992:
        if (r17 != 0) goto L_0x0998;
    L_0x0994:
        r0 = r25;
        r0.value = r13;
    L_0x0998:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x09bf;
    L_0x099e:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x09b0:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x09bc:
        r4 = r5.title;
        goto L_0x098c;
    L_0x09bf:
        r5 = r5.title;
        goto L_0x09b0;
    L_0x09c2:
        r4 = com.tencent.mm.R.l.dDm;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0a05;
    L_0x09d0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x09e4:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x09f0;
    L_0x09ea:
        if (r17 != 0) goto L_0x09f0;
    L_0x09ec:
        r0 = r25;
        r0.value = r13;
    L_0x09f0:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0a09;
    L_0x09f6:
        r5 = "%s: ";
    L_0x09f9:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0a05:
        r4 = "";
        goto L_0x09e4;
    L_0x0a09:
        r5 = "";
        goto L_0x09f9;
    L_0x0a0d:
        r4 = com.tencent.mm.sdk.platformtools.bg.PX(r4);
        r8 = com.tencent.mm.t.f.a.ek(r4);
        if (r8 != 0) goto L_0x0a25;
    L_0x0a17:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.w.e(r4, r5);
        r4 = "";
        goto L_0x0031;
    L_0x0a25:
        r5 = r8.type;
        switch(r5) {
            case 1: goto L_0x0a3a;
            case 2: goto L_0x0a93;
            case 3: goto L_0x0ade;
            case 4: goto L_0x0b29;
            case 5: goto L_0x0c0a;
            case 6: goto L_0x0b74;
            case 7: goto L_0x0bbf;
            case 8: goto L_0x0cee;
            case 9: goto L_0x0a2a;
            case 10: goto L_0x0a2a;
            case 11: goto L_0x0a2a;
            case 12: goto L_0x0a2a;
            case 13: goto L_0x0a2a;
            case 14: goto L_0x0a2a;
            case 15: goto L_0x0d2f;
            case 16: goto L_0x0ea0;
            case 17: goto L_0x0db1;
            case 18: goto L_0x0a2a;
            case 19: goto L_0x0e0a;
            case 20: goto L_0x0a2a;
            case 21: goto L_0x0a2a;
            case 22: goto L_0x0a2a;
            case 23: goto L_0x0a2a;
            case 24: goto L_0x0e55;
            case 25: goto L_0x0d70;
            case 26: goto L_0x0d2f;
            case 27: goto L_0x0d2f;
            case 28: goto L_0x0a2a;
            case 29: goto L_0x0a2a;
            case 30: goto L_0x0a2a;
            case 31: goto L_0x0a2a;
            case 32: goto L_0x0a2a;
            case 33: goto L_0x0c5d;
            case 34: goto L_0x0f11;
            case 35: goto L_0x0a2a;
            case 36: goto L_0x0c5d;
            case 37: goto L_0x0a2a;
            case 38: goto L_0x0a2a;
            case 39: goto L_0x0a2a;
            case 40: goto L_0x0f94;
            default: goto L_0x0a2a;
        };
    L_0x0a2a:
        r4 = com.tencent.mm.R.l.dDm;
        r0 = r23;
        r4 = r0.getString(r4);
        r7 = "";
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0a3a:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0a8d;
    L_0x0a43:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r8.title;
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0a5d:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0a69;
    L_0x0a63:
        if (r17 != 0) goto L_0x0a69;
    L_0x0a65:
        r0 = r25;
        r0.value = r13;
    L_0x0a69:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0a90;
    L_0x0a6f:
        r5 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r5.<init>(r6);
        r6 = r8.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0a81:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0a8d:
        r4 = r8.title;
        goto L_0x0a5d;
    L_0x0a90:
        r5 = r8.title;
        goto L_0x0a81;
    L_0x0a93:
        r4 = com.tencent.mm.R.l.dIi;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ad6;
    L_0x0aa1:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0ab5:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0ac1;
    L_0x0abb:
        if (r17 != 0) goto L_0x0ac1;
    L_0x0abd:
        r0 = r25;
        r0.value = r13;
    L_0x0ac1:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0ada;
    L_0x0ac7:
        r5 = "%s: ";
    L_0x0aca:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0ad6:
        r4 = "";
        goto L_0x0ab5;
    L_0x0ada:
        r5 = "";
        goto L_0x0aca;
    L_0x0ade:
        r4 = com.tencent.mm.R.l.dHI;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b21;
    L_0x0aec:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b00:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0b0c;
    L_0x0b06:
        if (r17 != 0) goto L_0x0b0c;
    L_0x0b08:
        r0 = r25;
        r0.value = r13;
    L_0x0b0c:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b25;
    L_0x0b12:
        r5 = "%s: ";
    L_0x0b15:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r8.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0b21:
        r4 = "";
        goto L_0x0b00;
    L_0x0b25:
        r5 = "";
        goto L_0x0b15;
    L_0x0b29:
        r4 = com.tencent.mm.R.l.dIX;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b6c;
    L_0x0b37:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b4b:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0b57;
    L_0x0b51:
        if (r17 != 0) goto L_0x0b57;
    L_0x0b53:
        r0 = r25;
        r0.value = r13;
    L_0x0b57:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b70;
    L_0x0b5d:
        r5 = "%s: ";
    L_0x0b60:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r8.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0b6c:
        r4 = "";
        goto L_0x0b4b;
    L_0x0b70:
        r5 = "";
        goto L_0x0b60;
    L_0x0b74:
        r4 = com.tencent.mm.R.l.dHn;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0bb7;
    L_0x0b82:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b96:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0ba2;
    L_0x0b9c:
        if (r17 != 0) goto L_0x0ba2;
    L_0x0b9e:
        r0 = r25;
        r0.value = r13;
    L_0x0ba2:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0bbb;
    L_0x0ba8:
        r5 = "%s: ";
    L_0x0bab:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r8.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0bb7:
        r4 = "";
        goto L_0x0b96;
    L_0x0bbb:
        r5 = "";
        goto L_0x0bab;
    L_0x0bbf:
        r4 = com.tencent.mm.R.l.dDm;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0c02;
    L_0x0bcd:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0be1:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0bed;
    L_0x0be7:
        if (r17 != 0) goto L_0x0bed;
    L_0x0be9:
        r0 = r25;
        r0.value = r13;
    L_0x0bed:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0c06;
    L_0x0bf3:
        r5 = "%s: ";
    L_0x0bf6:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0c02:
        r4 = "";
        goto L_0x0be1;
    L_0x0c06:
        r5 = "";
        goto L_0x0bf6;
    L_0x0c0a:
        r4 = com.tencent.mm.R.l.dIU;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0c55;
    L_0x0c18:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0c2c:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0c3e;
    L_0x0c32:
        if (r17 != 0) goto L_0x0c3e;
    L_0x0c34:
        r5 = com.tencent.mm.u.o.fD(r20);
        if (r5 != 0) goto L_0x0c3e;
    L_0x0c3a:
        r0 = r25;
        r0.value = r13;
    L_0x0c3e:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0c59;
    L_0x0c44:
        r5 = "%s: ";
    L_0x0c47:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r8.getTitle();
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0c55:
        r4 = "";
        goto L_0x0c2c;
    L_0x0c59:
        r5 = "";
        goto L_0x0c47;
    L_0x0c5d:
        r18 = "";
        r4 = com.tencent.mm.R.l.dDP;
        r0 = r23;
        r5 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0cc6;
    L_0x0c6e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r6 = r8.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x0c8c:
        r6 = com.tencent.mm.u.o.fu(r20);
        if (r6 != 0) goto L_0x0c9e;
    L_0x0c92:
        if (r17 != 0) goto L_0x0c9e;
    L_0x0c94:
        r6 = com.tencent.mm.u.o.fD(r20);
        if (r6 != 0) goto L_0x0c9e;
    L_0x0c9a:
        r0 = r25;
        r0.value = r13;
    L_0x0c9e:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0cda;
    L_0x0ca4:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r6 = r8.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0cba:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0cc6:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r6 = r8.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
        goto L_0x0c8c;
    L_0x0cda:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = r8.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
        goto L_0x0cba;
    L_0x0cee:
        r4 = com.tencent.mm.R.l.dGM;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0d2b;
    L_0x0cfc:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0d10:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0d1c;
    L_0x0d16:
        if (r17 != 0) goto L_0x0d1c;
    L_0x0d18:
        r0 = r25;
        r0.value = r13;
    L_0x0d1c:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0d2b:
        r4 = "";
        goto L_0x0d10;
    L_0x0d2f:
        r4 = com.tencent.mm.R.l.dGN;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0d6c;
    L_0x0d3d:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0d51:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0d5d;
    L_0x0d57:
        if (r17 != 0) goto L_0x0d5d;
    L_0x0d59:
        r0 = r25;
        r0.value = r13;
    L_0x0d5d:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0d6c:
        r4 = "";
        goto L_0x0d51;
    L_0x0d70:
        r4 = com.tencent.mm.R.l.dGD;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0dad;
    L_0x0d7e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0d92:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0d9e;
    L_0x0d98:
        if (r17 != 0) goto L_0x0d9e;
    L_0x0d9a:
        r0 = r25;
        r0.value = r13;
    L_0x0d9e:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0dad:
        r4 = "";
        goto L_0x0d92;
    L_0x0db1:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e04;
    L_0x0dba:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r8.title;
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0dd4:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0de0;
    L_0x0dda:
        if (r17 != 0) goto L_0x0de0;
    L_0x0ddc:
        r0 = r25;
        r0.value = r13;
    L_0x0de0:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0e07;
    L_0x0de6:
        r5 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r5.<init>(r6);
        r6 = r8.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0df8:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0e04:
        r4 = r8.title;
        goto L_0x0dd4;
    L_0x0e07:
        r5 = r8.title;
        goto L_0x0df8;
    L_0x0e0a:
        r4 = com.tencent.mm.R.l.dIr;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e4d;
    L_0x0e18:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e2c:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0e38;
    L_0x0e32:
        if (r17 != 0) goto L_0x0e38;
    L_0x0e34:
        r0 = r25;
        r0.value = r13;
    L_0x0e38:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0e51;
    L_0x0e3e:
        r5 = "%s: ";
    L_0x0e41:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0e4d:
        r4 = "";
        goto L_0x0e2c;
    L_0x0e51:
        r5 = "";
        goto L_0x0e41;
    L_0x0e55:
        r4 = com.tencent.mm.R.l.ejR;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e98;
    L_0x0e63:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e77:
        r5 = com.tencent.mm.u.o.fu(r20);
        if (r5 != 0) goto L_0x0e83;
    L_0x0e7d:
        if (r17 != 0) goto L_0x0e83;
    L_0x0e7f:
        r0 = r25;
        r0.value = r13;
    L_0x0e83:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0e9c;
    L_0x0e89:
        r5 = "%s: ";
    L_0x0e8c:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0e98:
        r4 = "";
        goto L_0x0e77;
    L_0x0e9c:
        r5 = "";
        goto L_0x0e8c;
    L_0x0ea0:
        r18 = "";
        r4 = com.tencent.mm.R.l.dRv;
        r0 = r23;
        r5 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0efd;
    L_0x0eb1:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r6 = r8.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x0ecf:
        r6 = com.tencent.mm.u.o.fu(r20);
        if (r6 != 0) goto L_0x0edb;
    L_0x0ed5:
        if (r17 != 0) goto L_0x0edb;
    L_0x0ed7:
        r0 = r25;
        r0.value = r13;
    L_0x0edb:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0ef1;
    L_0x0ee1:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x0ef1:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0efd:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r6 = r8.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
        goto L_0x0ecf;
    L_0x0f11:
        r18 = "";
        r4 = com.tencent.mm.R.l.dRv;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = 1;
        r0 = r19;
        if (r0 != r5) goto L_0x0f64;
    L_0x0f21:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = r8.hiG;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0f62;
    L_0x0f3a:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0f4a:
        r0 = r24;
        r0.value = r4;
    L_0x0f4e:
        r4 = com.tencent.mm.u.o.fu(r20);
        if (r4 != 0) goto L_0x12d1;
    L_0x0f54:
        if (r17 != 0) goto L_0x12d1;
    L_0x0f56:
        r0 = r25;
        r0.value = r13;
        r4 = r18;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015f;
    L_0x0f62:
        r4 = r5;
        goto L_0x0f4a;
    L_0x0f64:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = r8.hiF;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0f92;
    L_0x0f7d:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0f8d:
        r0 = r24;
        r0.value = r4;
        goto L_0x0f4e;
    L_0x0f92:
        r4 = r5;
        goto L_0x0f8d;
    L_0x0f94:
        r4 = com.tencent.mm.t.j.eo(r4);
        r4 = r4.hkp;
        r5 = 19;
        if (r4 != r5) goto L_0x0fab;
    L_0x0f9e:
        r4 = com.tencent.mm.R.l.dIr;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0fab:
        r4 = com.tencent.mm.R.l.dDm;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0fb8:
        if (r11 == 0) goto L_0x0fbe;
    L_0x0fba:
        r7 = dl(r7);
    L_0x0fbe:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.h.h(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r4 = r4.rU(r7);
        r4 = dk(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0fd9:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.h.h(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r4 = r4.rT(r7);
        r0 = r24;
        r0.value = r4;
        r0 = r24;
        r4 = r0.value;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0ff2:
        r4 = com.tencent.mm.aa.a.a.iG(r7);
        r4 = com.tencent.mm.aa.a.b(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x1005:
        r7 = "";
        r4 = com.tencent.mm.t.f.a.ek(r4);
        if (r4 == 0) goto L_0x015b;
    L_0x100e:
        r4 = r4.content;	 Catch:{ Exception -> 0x1026 }
        r5 = "UTF-8";
        r7 = java.net.URLDecoder.decode(r4, r5);	 Catch:{ Exception -> 0x1026 }
        r4 = com.tencent.mm.pluginsdk.ui.d.h.Ng(r7);	 Catch:{ Exception -> 0x1026 }
        r0 = r24;
        r0.value = r4;	 Catch:{ Exception -> 0x12c9 }
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x1026:
        r4 = move-exception;
        r5 = r4;
        r4 = r7;
    L_0x1029:
        r6 = "MicroMsg.Notification.Wording";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r6, r5, r7, r8);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x103c:
        r4 = "@bottle:";
        r4 = r7.split(r4);
        r5 = r4.length;
        r6 = 1;
        if (r5 <= r6) goto L_0x1053;
    L_0x1047:
        r5 = 1;
        r5 = r4[r5];
        r0 = r24;
        r0.value = r5;
        r5 = 1;
        r4 = r4[r5];
        goto L_0x0031;
    L_0x1053:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = 0;
        goto L_0x0031;
    L_0x105d:
        r5 = 0;
        r6 = ":";
        r6 = r7.split(r6);
        if (r6 == 0) goto L_0x106a;
    L_0x1067:
        r8 = r6.length;
        if (r8 > 0) goto L_0x1074;
    L_0x106a:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = 0;
        goto L_0x0031;
    L_0x1074:
        r8 = 0;
        r6 = r6[r8];
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r8 != 0) goto L_0x10a0;
    L_0x107d:
        com.tencent.mm.u.ap.yY();
        r8 = com.tencent.mm.u.c.wR();
        r6 = r8.Rc(r6);
        if (r6 == 0) goto L_0x1094;
    L_0x108a:
        r8 = r6.getCity();
        if (r8 == 0) goto L_0x1094;
    L_0x1090:
        r5 = r6.getCity();
    L_0x1094:
        if (r5 == 0) goto L_0x109c;
    L_0x1096:
        r8 = r5.length();
        if (r8 > 0) goto L_0x10a0;
    L_0x109c:
        r5 = r6.getProvince();
    L_0x10a0:
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r6 != 0) goto L_0x10dc;
    L_0x10a6:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r5);
        r7 = ": ";
        r6 = r6.append(r7);
        r6 = r6.append(r4);
        r6 = r6.toString();
        r0 = r24;
        r0.value = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = ": ";
        r5 = r5.append(r6);
        r4 = r5.append(r4);
        r4 = r4.toString();
        goto L_0x0031;
    L_0x10dc:
        r4 = "@bottle:";
        r4 = r7.split(r4);
        r6 = r4.length;
        r7 = 1;
        if (r6 <= r7) goto L_0x1123;
    L_0x10e7:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r5);
        r7 = ": ";
        r6 = r6.append(r7);
        r7 = 1;
        r7 = r4[r7];
        r6 = r6.append(r7);
        r6 = r6.toString();
        r0 = r24;
        r0.value = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = ": ";
        r5 = r5.append(r6);
        r6 = 1;
        r4 = r4[r6];
        r4 = r5.append(r4);
        r4 = r4.toString();
        goto L_0x0031;
    L_0x1123:
        r0 = r24;
        r0.value = r5;
        r4 = r5;
        goto L_0x0031;
    L_0x112a:
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r8 == 0) goto L_0x1137;
    L_0x1130:
        r8 = "";
        r0 = r24;
        r0.value = r8;
    L_0x1137:
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r13);
        if (r8 != 0) goto L_0x11ef;
    L_0x113d:
        if (r12 == 0) goto L_0x1149;
    L_0x113f:
        r8 = r12.length();
        if (r8 <= 0) goto L_0x1149;
    L_0x1145:
        r7 = i(r7, r13, r12);
    L_0x1149:
        r0 = r25;
        r8 = r0.value;
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r8 == 0) goto L_0x1166;
    L_0x1153:
        r0 = r24;
        r8 = r0.value;
        r9 = "%s";
        r8 = i(r8, r13, r9);
        r0 = r24;
        r0.value = r8;
        r0 = r25;
        r0.value = r13;
    L_0x1166:
        r7 = com.tencent.mm.compatible.util.n.dz(r7);
        r0 = r24;
        r8 = r0.value;
        r8 = com.tencent.mm.compatible.util.n.dz(r8);
        r0 = r24;
        r0.value = r8;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r7 = r8.append(r7);
        r7 = r7.append(r4);
        r7 = r7.toString();
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r24;
        r9 = r0.value;
        r8 = r8.append(r9);
        r4 = r8.append(r4);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        if (r27 == 0) goto L_0x11cd;
    L_0x11a2:
        r0 = r24;
        r4 = r0.value;
        r4 = r4.length();
        r8 = 32;
        if (r4 != r8) goto L_0x11ed;
    L_0x11ae:
        r4 = 47;
        r0 = r22;
        if (r0 == r4) goto L_0x11bb;
    L_0x11b4:
        r4 = 1048625; // 0x100031 float:1.469437E-39 double:5.180896E-318;
        r0 = r22;
        if (r0 != r4) goto L_0x11ed;
    L_0x11bb:
        r0 = r24;
        r0.value = r7;
        r4 = 1;
    L_0x11c0:
        if (r4 != 0) goto L_0x11cd;
    L_0x11c2:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
    L_0x11cd:
        if (r6 == 0) goto L_0x12ce;
    L_0x11cf:
        r4 = new java.lang.StringBuilder;
        r6 = " ";
        r4.<init>(r6);
        r5 = com.tencent.mm.sdk.platformtools.bg.mz(r5);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r4 = r7.concat(r4);
    L_0x11e7:
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r4);
        goto L_0x0031;
    L_0x11ed:
        r4 = 0;
        goto L_0x11c0;
    L_0x11ef:
        r8 = com.tencent.mm.u.o.fu(r20);
        if (r8 != 0) goto L_0x11fd;
    L_0x11f5:
        if (r17 != 0) goto L_0x11fd;
    L_0x11f7:
        r8 = com.tencent.mm.u.o.fD(r20);
        if (r8 == 0) goto L_0x12ae;
    L_0x11fd:
        if (r4 == 0) goto L_0x1206;
    L_0x11ff:
        r8 = r4.length();
        if (r8 <= 0) goto L_0x1206;
    L_0x1205:
        r7 = r4;
    L_0x1206:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r4 == 0) goto L_0x121f;
    L_0x120c:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = "";
        r0 = r25;
        r0.value = r4;
        r4 = "";
        goto L_0x0031;
    L_0x121f:
        if (r19 != 0) goto L_0x1267;
    L_0x1221:
        r4 = new java.lang.StringBuilder;
        r8 = "%s:";
        r4.<init>(r8);
        r4 = r4.append(r7);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
    L_0x1235:
        if (r27 == 0) goto L_0x128c;
    L_0x1237:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
        r4 = r7;
    L_0x1243:
        if (r6 == 0) goto L_0x125b;
    L_0x1245:
        if (r5 == 0) goto L_0x125b;
    L_0x1247:
        r6 = new java.lang.StringBuilder;
        r7 = " ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r5 = r5.toString();
        r4 = r4.concat(r5);
    L_0x125b:
        if (r11 == 0) goto L_0x1261;
    L_0x125d:
        r4 = dl(r4);
    L_0x1261:
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r4);
        goto L_0x0031;
    L_0x1267:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.R.l.dHC;
        r0 = r23;
        r8 = r0.getString(r8);
        r4 = r4.append(r8);
        r8 = ":";
        r4 = r4.append(r8);
        r4 = r4.append(r7);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x1235;
    L_0x128c:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r25;
        r5 = r0.value;
        r5 = com.tencent.mm.u.n.eK(r5);
        r4 = r4.append(r5);
        r5 = ":";
        r4 = r4.append(r5);
        r4 = r4.append(r7);
        r4 = r4.toString();
        goto L_0x0031;
    L_0x12ae:
        if (r4 == 0) goto L_0x12cc;
    L_0x12b0:
        r8 = r4.length();
        if (r8 <= 0) goto L_0x12cc;
    L_0x12b6:
        r0 = r24;
        r0.value = r4;
    L_0x12ba:
        if (r27 == 0) goto L_0x1243;
    L_0x12bc:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
        goto L_0x1243;
    L_0x12c9:
        r5 = move-exception;
        goto L_0x1029;
    L_0x12cc:
        r4 = r7;
        goto L_0x12ba;
    L_0x12ce:
        r4 = r7;
        goto L_0x11e7;
    L_0x12d1:
        r4 = r18;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015f;
    L_0x12d9:
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x12e1:
        r4 = r20;
        goto L_0x05ac;
    L_0x12e5:
        r5 = r20;
        goto L_0x05b0;
    L_0x12e9:
        r17 = r5;
        r7 = r21;
        goto L_0x0158;
    L_0x12ef:
        r4 = r21;
        r12 = r5;
        r13 = r6;
        goto L_0x0128;
    L_0x12f5:
        r11 = r4;
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.a.h.a(java.lang.String, int, java.lang.String, java.lang.String, int, android.content.Context, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PInt, boolean, boolean):java.lang.String");
    }

    private static String a(Context context, int i, String str, String str2, String str3, PString pString, PString pString2) {
        String str4 = "";
        if (o.fa(str) || o.fc(str)) {
            if (str2 != null) {
                int indexOf = str2.indexOf(":");
                if (indexOf >= 0 && indexOf < str2.length()) {
                    String substring = str2.substring(0, indexOf);
                    if (x.QM(substring) || x.QO(substring)) {
                        str4 = n.eK(substring);
                        pString2.value = substring;
                        str2 = str2.substring(indexOf + 1);
                    }
                }
            }
        } else if (x.QM(str) || x.QO(str)) {
            n.eK(str);
            pString2.value = str;
            if (i == 1) {
                StringBuilder append = new StringBuilder().append(context.getString(R.l.elM, new Object[]{""}));
                if (str3 != null) {
                    str2 = str3;
                }
                pString.value = append.append(str2).toString();
                pString2.value = "";
                return pString.value;
            }
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            pString2.value = "";
            return pString.value;
        }
        if (bg.mz(str4).length() <= 0) {
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            return pString.value;
        }
        pString.value = context.getString(i == 1 ? R.l.elM : R.l.elW) + (str3 == null ? str2 : str3);
        append = new StringBuilder().append(context.getString(i == 1 ? R.l.elM : R.l.elW, new Object[]{str4}));
        if (str3 != null) {
            str2 = str3;
        }
        return append.append(str2).toString();
    }

    private static String dk(String str) {
        if (str != null) {
            return str.replaceAll("%", "%%");
        }
        return str;
    }

    private static String i(String str, String str2, String str3) {
        if (bg.mA(str) || bg.mA(str2) || bg.mA(str3)) {
            return str;
        }
        int indexOf = str.indexOf(str2);
        return indexOf >= 0 ? str.substring(0, indexOf) + str3 + str.substring(indexOf + str2.length()) : str;
    }

    private static String dl(String str) {
        if (str != null) {
            return str.replaceAll("%%", "%");
        }
        return str;
    }

    public static String dm(String str) {
        if (str == null) {
            return "";
        }
        return str.length() >= ck.CTRL_INDEX ? str.substring(0, ck.CTRL_INDEX) + "..." : str;
    }

    private static void a(int i, PString pString, PString pString2, PInt pInt) {
        int i2 = ck.CTRL_INDEX;
        if (pString.value.length() != 32 || (i != 47 && i != 1048625)) {
            if (pString.value.length() >= ck.CTRL_INDEX) {
                String str = pString.value;
                String str2 = pString.value;
                while (i2 < str2.length()) {
                    if (str2.charAt(i2) != '%') {
                        break;
                    }
                    i2++;
                }
                i2 = str2.length();
                pString.value = str.substring(0, i2);
            }
            TextPaint textPaint = gMx == null ? null : (TextPaint) gMx.get();
            if (pString.value.replace("%%", "").contains("%s") || textPaint == null) {
                pInt.value = 0;
                return;
            }
            CharSequence format;
            try {
                format = String.format(pString.value, new Object[]{pString2.value});
            } catch (Exception e) {
                format = pString.value;
            }
            pString.value = TextUtils.ellipsize(format, textPaint, (float) (gMy > 0 ? gMy : BackwardSupportUtil.b.a(ab.getContext(), 200.0f)), TruncateAt.END).toString();
            pInt.value = 1;
        }
    }

    public static void dX(int i) {
        gMy = i;
    }

    public static void dY(int i) {
        gMz = i;
    }

    public static void a(TextPaint textPaint) {
        if (gMx == null || gMx.get() == null) {
            gMx = new WeakReference(textPaint);
        }
    }

    public static String c(Context context, String str, boolean z) {
        return z ? b.bKy().Qy(str) : context.getString(R.l.esH);
    }

    public static String a(Context context, String str, int i, int i2, int i3, boolean z) {
        if (z) {
            String Qy = b.bKy().Qy(str);
            if (i3 <= 1) {
                return Qy;
            }
            return context.getResources().getQuantityString(R.j.dsy, i3, new Object[]{Integer.valueOf(i3)}) + Qy;
        }
        return context.getResources().getQuantityString(R.j.dsz, i, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static String d(Context context, String str, boolean z) {
        if (z) {
            return b.bKy().Qy(str);
        }
        return context.getString(R.l.eED);
    }
}
