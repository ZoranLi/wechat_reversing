package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.x;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.normsg.utils.NativeLogic;
import com.tencent.mm.plugin.normsg.utils.c;
import com.tencent.mm.plugin.normsg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

enum b implements com.tencent.mm.plugin.normsg.a.b {
    ;

    private b(String str) {
    }

    public final String l(boolean z, boolean z2) {
        Context applicationContext = ab.getContext().getApplicationContext();
        String str = applicationContext.getApplicationInfo().sourceDir;
        WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        String bssid = connectionInfo.getBSSID();
        int versionCode = getVersionCode();
        int i = aPg() ? 1 : 0;
        int i2 = NativeLogic.aPk() ? 1 : 0;
        int i3 = Debug.isDebuggerConnected() ? 1 : 0;
        h.vG();
        byte[] bt = NativeLogic.bt(str, a.uH());
        h.vG();
        byte[] f = NativeLogic.f(applicationContext, str, a.uH());
        byte[] cG = NativeLogic.cG(applicationContext);
        String f2 = com.tencent.mm.plugin.normsg.utils.a.f(bt, 0, bt.length);
        String f3 = com.tencent.mm.plugin.normsg.utils.a.f(f, 0, f.length);
        String f4 = com.tencent.mm.plugin.normsg.utils.a.f(cG, 0, cG.length);
        int i4 = (c.nZM || c.nZN || c.nZO) ? 1 : 0;
        String charSequence = applicationContext.getPackageManager().getApplicationLabel(applicationContext.getApplicationInfo()).toString();
        String str2 = "";
        if (z) {
            Bundle aM = com.tencent.mm.lib.riskscanner.a.a.aM(applicationContext);
            if (aM != null && aM.getInt("errCode", -100) == 0) {
                cG = aM.getByteArray("reqBufferBase64");
                if (cG != null) {
                    str2 = Base64.encodeToString(cG, 2);
                }
            }
        }
        String str3 = "";
        if (z2) {
            str3 = ap(applicationContext, ",");
        }
        Map rN = p.rN();
        r17 = new Object[46][];
        r17[0] = new Object[]{"\u001d$\u001b>\"8\u001e2?\u0010.<6", Integer.valueOf(i)};
        r17[1] = new Object[]{"\u001c!4\u00180 24", Integer.valueOf(i2)};
        r17[2] = new Object[]{"\u001e'\u001104\u0013>019>.><", Integer.valueOf(i3)};
        r17[3] = new Object[]{"\u000194\u001c4%?i", f2};
        r17[4] = new Object[]{"\u000194\u001c4%?j", f3};
        r17[5] = new Object[]{"\u000194\u001c4%?k", f4};
        r17[6] = new Object[]{"\u0013#'\u0006 %?7?", y(rN)};
        r17[7] = new Object[]{"\u00011%?8\u0012\"\f>*", p.rI()};
        r17[8] = new Object[]{"\u001e!\u000119\u00002*", p.rJ()};
        r17[9] = new Object[]{"\u0014\u0013\u001a\u0011", p.rA()};
        r17[10] = new Object[]{"\u0011=6';>2\u0010\u001c", p.getAndroidId()};
        r17[11] = new Object[]{"\u00029?93\u00061)384", p.rM()};
        r17[12] = new Object[]{"\u00038>82\u0019:>>4", p.rF()};
        r17[13] = new Object[]{"\u0016&\"\u0013> 6\u001f2+1,", Integer.valueOf(p.rO())};
        r17[14] = new Object[]{"\u001f/+\u0011\u000f", A(rN)};
        r17[15] = new Object[]{"\u001c,(\b>.", B(rN)};
        r17[16] = new Object[]{"\u0013#'\u00061%?84", C(rN)};
        r17[17] = new Object[]{"\r80=\u0017\u0018\u001b", p.rC()};
        r17[18] = new Object[]{"\u0011!%\u001134 .(<+", z(rN)};
        r17[19] = new Object[]{"\u000e\r\u0016\u001c", ssid};
        r17[20] = new Object[]{"\f,\u00144=7", p.ax(applicationContext)};
        r17[21] = new Object[]{"\u001e\f\r\u0010\u001c", bssid};
        r17[22] = new Object[]{"\u001f\r\u0012\u00124?7", aPh()};
        r17[23] = new Object[]{"\u000e6;\u0015;4=", ab.getPackageName()};
        r17[24] = new Object[]{"\u001c(57>\u001f\b", x.get("ro.build.fingerprint")};
        r17[25] = new Object[]{"\u0011%8:3\u0016:;)<", Build.BOARD};
        r17[26] = new Object[]{"\u0014 =?6\u0013?0*13:><*", Build.BOOTLOADER};
        r17[27] = new Object[]{"\u0011%8:3\u0016';5<", Build.BRAND};
        r17[28] = new Object[]{"\u0010$9;2\u00111-3:=", Build.DEVICE};
        r17[29] = new Object[]{"\u001c(57>\u0011\u000f", Build.HARDWARE};
        r17[30] = new Object[]{"\u0017#><5\u0002!39+<,", Build.PRODUCT};
        r17[31] = new Object[]{"\u0019 \u000309\"\u00137.", Integer.valueOf(i4)};
        r17[32] = new Object[]{"\u001879%730((,:*", x.get("ro.product.manufacturer")};
        r17[33] = new Object[]{"\u0001:<:0\u0018\"5", aPi()};
        r17[34] = new Object[]{"\u00108(\u000f#)=", Ik()};
        r17[35] = new Object[]{"\u00153'5\u000798,", e.hgp};
        Object[] objArr = new Object[2];
        objArr[0] = "\u00182!\u0011!'\u00062?";
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.normsg.utils.b.nZG ? 1 : 0);
        r17[36] = objArr;
        objArr = new Object[2];
        objArr[0] = "\u001c6%\u000098'\u000e4>:6/";
        objArr[1] = Integer.valueOf(d.nZP ? 1 : 0);
        r17[37] = objArr;
        r17[38] = new Object[]{"\u00044\"$?::\u00185==", Integer.valueOf(versionCode)};
        r17[39] = new Object[]{"\u000b#89+'+\"\u0005)%01\r/>:8.\u0015;4=", ab.getContext().getClassLoader().getClass().getName()};
        r17[40] = new Object[]{"\u001f-,\u0015;4=", charSequence};
        r17[41] = new Object[]{"\u0005\u0006\u001a?#,\u0002.!''!\u0002.*<+", gb(false)};
        r17[42] = new Object[]{"\u001a\"9&\u001f,//\u0012&3\u00071! <*", str2};
        r17[43] = new Object[]{"\u001b3*\u00193-+", Long.valueOf(NativeLogic.aPm())};
        r17[44] = new Object[]{"\u0002*$ /%%\u000f,/(98!+?;=!+\u00005#(6?8\u0013?+", NativeLogic.BQ(",")};
        r17[45] = new Object[]{"\u0005!==)'&  \u0017'\"+\"%8\u0015186+", str3};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<st>");
        for (i2 = 0; i2 < 46; i2++) {
            Object[] objArr2 = r17[i2];
            String BP = BP(BO((String) objArr2[0]));
            stringBuilder.append('<').append(BP).append('>').append(BP(String.valueOf(objArr2[1]))).append('<').append('/').append(BP).append('>');
        }
        stringBuilder.append("</st>");
        return stringBuilder.toString();
    }

    public final String BO(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) ((str.charAt(i) ^ -89) ^ ((byte) (((i + 1) ^ length) ^ -1))));
        }
        return stringBuilder.toString();
    }

    private static String BP(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuilder.append("&quot;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                case '\'':
                    stringBuilder.append("&apos;");
                    break;
                case ',':
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
                case '<':
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
                default:
                    if (charAt <= '~') {
                        stringBuilder.append(charAt);
                        break;
                    }
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public final String qx(int i) {
        String str;
        String str2;
        String str3 = "";
        if (h.vG().uV()) {
            str = (String) h.vI().vr().get(79, "");
        } else {
            str = str3;
        }
        h.vL().e(new Runnable(this) {
            final /* synthetic */ b nZy;

            {
                this.nZy = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r10 = this;
                r9 = 0;
                r0 = com.tencent.mm.kernel.h.vG();
                r0 = r0.uV();
                if (r0 != 0) goto L_0x000c;
            L_0x000b:
                return;
            L_0x000c:
                r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0111 }
                r2 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ Exception -> 0x0111 }
                r3 = r2.getApplicationInfo();	 Catch:{ Exception -> 0x0111 }
                r3 = r3.sourceDir;	 Catch:{ Exception -> 0x0111 }
                com.tencent.mm.kernel.h.vG();	 Catch:{ Exception -> 0x0111 }
                r4 = com.tencent.mm.kernel.a.uH();	 Catch:{ Exception -> 0x0111 }
                r4 = com.tencent.mm.plugin.normsg.utils.NativeLogic.bt(r3, r4);	 Catch:{ Exception -> 0x0111 }
                com.tencent.mm.kernel.h.vG();	 Catch:{ Exception -> 0x0111 }
                r5 = com.tencent.mm.kernel.a.uH();	 Catch:{ Exception -> 0x0111 }
                r2 = com.tencent.mm.plugin.normsg.utils.NativeLogic.f(r2, r3, r5);	 Catch:{ Exception -> 0x0111 }
                r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0111 }
                r6 = r6 - r0;
                r0 = "<k25>%s</k25>";
                r1 = 1;
                r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0111 }
                r3 = 0;
                r5 = 0;
                r8 = r4.length;	 Catch:{ Exception -> 0x0111 }
                r4 = com.tencent.mm.plugin.normsg.utils.a.f(r4, r5, r8);	 Catch:{ Exception -> 0x0111 }
                r1[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r1 = java.lang.String.format(r0, r1);	 Catch:{ Exception -> 0x0111 }
                if (r2 == 0) goto L_0x00ad;
            L_0x004a:
                r0 = r2.length;	 Catch:{ Exception -> 0x0111 }
                r3 = 8;
                if (r0 != r3) goto L_0x011f;
            L_0x004f:
                r0 = 0;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0111 }
                r3 = 0;
                r4 = 3;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0111 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r3 = 3;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0111 }
                r0 = 1;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0111 }
                r3 = 1;
                r4 = 2;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0111 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r3 = 2;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0111 }
                r0 = 4;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0111 }
                r3 = 4;
                r4 = 7;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0111 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r3 = 7;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0111 }
                r0 = 5;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0111 }
                r3 = 5;
                r4 = 6;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0111 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r3 = 6;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0111 }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
                r0.<init>();	 Catch:{ Exception -> 0x0111 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
                r1 = "<k28>%s</k28><k29>%s</k29>";
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0111 }
                r4 = 0;
                r5 = 0;
                r8 = 4;
                r5 = com.tencent.mm.plugin.normsg.utils.a.f(r2, r5, r8);	 Catch:{ Exception -> 0x0111 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0111 }
                r4 = 1;
                r5 = 4;
                r8 = 8;
                r2 = com.tencent.mm.plugin.normsg.utils.a.f(r2, r5, r8);	 Catch:{ Exception -> 0x0111 }
                r3[r4] = r2;	 Catch:{ Exception -> 0x0111 }
                r1 = java.lang.String.format(r1, r3);	 Catch:{ Exception -> 0x0111 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
                r1 = r0.toString();	 Catch:{ Exception -> 0x0111 }
            L_0x00ad:
                r0 = "mp.weixin.qq.com";
                r0 = java.net.Inet4Address.getByName(r0);	 Catch:{ Exception -> 0x0145 }
                r0 = r0.getHostAddress();	 Catch:{ Exception -> 0x0145 }
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0145 }
                r2.<init>();	 Catch:{ Exception -> 0x0145 }
                r2 = r2.append(r1);	 Catch:{ Exception -> 0x0145 }
                r3 = "<k32>%s</k32>";
                r4 = 1;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0145 }
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.bg.mz(r0);	 Catch:{ Exception -> 0x0145 }
                r4[r5] = r0;	 Catch:{ Exception -> 0x0145 }
                r0 = java.lang.String.format(r3, r4);	 Catch:{ Exception -> 0x0145 }
                r0 = r2.append(r0);	 Catch:{ Exception -> 0x0145 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0145 }
            L_0x00da:
                r1 = "MicroMsg.NormsgSourceImpl";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
                r3 = "checkSoftType2 [time: ";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0111 }
                r2 = r2.append(r6);	 Catch:{ Exception -> 0x0111 }
                r3 = ", value: ";
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0111 }
                r2 = r2.append(r0);	 Catch:{ Exception -> 0x0111 }
                r3 = "]";
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0111 }
                r2 = r2.toString();	 Catch:{ Exception -> 0x0111 }
                com.tencent.mm.sdk.platformtools.w.i(r1, r2);	 Catch:{ Exception -> 0x0111 }
                r1 = com.tencent.mm.kernel.h.vI();	 Catch:{ Exception -> 0x0111 }
                r1 = r1.vr();	 Catch:{ Exception -> 0x0111 }
                r2 = 79;
                r1.set(r2, r0);	 Catch:{ Exception -> 0x0111 }
                goto L_0x000b;
            L_0x0111:
                r0 = move-exception;
                r1 = "MicroMsg.NormsgSourceImpl";
                r2 = "Failed checkSoftType2.";
                r3 = new java.lang.Object[r9];
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
                goto L_0x000b;
            L_0x011f:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
                r0.<init>();	 Catch:{ Exception -> 0x0111 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
                r1 = "<k27>%s</k27>";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0111 }
                r4 = 0;
                r5 = 0;
                r8 = r2.length;	 Catch:{ Exception -> 0x0111 }
                r2 = com.tencent.mm.plugin.normsg.utils.a.f(r2, r5, r8);	 Catch:{ Exception -> 0x0111 }
                r3[r4] = r2;	 Catch:{ Exception -> 0x0111 }
                r1 = java.lang.String.format(r1, r3);	 Catch:{ Exception -> 0x0111 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
                r1 = r0.toString();	 Catch:{ Exception -> 0x0111 }
                goto L_0x00ad;
            L_0x0145:
                r0 = move-exception;
                r2 = "MicroMsg.NormsgSourceImpl";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0111 }
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);	 Catch:{ Exception -> 0x0111 }
                r4[r5] = r0;	 Catch:{ Exception -> 0x0111 }
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ Exception -> 0x0111 }
                r0 = r1;
                goto L_0x00da;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.normsg.b.1.run():void");
            }

            public final String toString() {
                return super.toString() + "|checkSoftTypeExtra";
            }
        }, 5000);
        str3 = "";
        if (h.vG().uV()) {
            str2 = h.vI().gYg.uLX.uLA ? "1" : "0";
        } else {
            str2 = str3;
        }
        Context applicationContext = ab.getContext().getApplicationContext();
        WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        String bssid = connectionInfo.getBSSID();
        int i2 = aPg() ? 1 : 0;
        int i3 = NativeLogic.aPk() ? 1 : 0;
        int i4 = Debug.isDebuggerConnected() ? 1 : 0;
        int i5 = (c.nZM || c.nZN || c.nZO) ? 1 : 0;
        int i6 = com.tencent.mm.plugin.normsg.utils.b.nZG ? 1 : 0;
        int i7 = d.nZP ? 1 : 0;
        byte[] cG = NativeLogic.cG(applicationContext);
        String f = cG != null ? com.tencent.mm.plugin.normsg.utils.a.f(cG, 0, cG.length) : "";
        int versionCode = getVersionCode();
        String cz = cz(versionCode, i);
        Map rN = p.rN();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>").append(y(rN)).append("</k1><k2>").append(p.rI()).append("</k2><k3>").append(p.rJ()).append("</k3><k4>").append(p.rA()).append("</k4><k5>").append(p.rK()).append("</k5><k6>").append(p.rL()).append("</k6><k7>").append(p.getAndroidId()).append("</k7><k8>").append(p.rM()).append("</k8><k9>").append(p.rF()).append("</k9><k10>").append(p.rO()).append("</k10><k11>").append(bg.mz(A(rN))).append("</k11><k12>").append(bg.mz(B(rN))).append("</k12><k13>").append(bg.mz(C(rN))).append("</k13><k14>").append(p.rC()).append("</k14><k15>").append(p.rH()).append("</k15><k16>").append(bg.mz(z(rN))).append("</k16><k18>").append(f).append("</k18><k21>").append(bg.mz(ssid)).append("</k21><k22>").append(bg.mz(p.ax(applicationContext))).append("</k22><k24>").append(bg.mz(bssid)).append("</k24><k26>").append(i4).append("</k26><k30>").append(bg.mz(aPh())).append("</k30><k33>").append(ab.getPackageName()).append("</k33><k34>").append(bg.mz(x.get("ro.build.fingerprint"))).append("</k34><k35>").append(bg.mz(Build.BOARD)).append("</k35><k36>").append(bg.mz(Build.BOOTLOADER)).append("</k36><k37>").append(bg.mz(Build.BRAND)).append("</k37><k38>").append(bg.mz(Build.DEVICE)).append("</k38><k39>").append(bg.mz(Build.HARDWARE)).append("</k39><k40>").append(bg.mz(Build.PRODUCT)).append("</k40><k41>").append(i5).append("</k41><k42>").append(bg.mz(x.get("ro.product.manufacturer"))).append("</k42><k43>").append(System.getString(ab.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0").append("</k44><k45>").append(aPi()).append("</k45><k46>").append(str2).append("</k46><k47>").append(Ik()).append("</k47><k48>").append(p.rA()).append("</k48><k49>").append(e.hgp).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(bg.mz(cz)).append("</k58><k59>").append(i).append("</k59></softtype>");
        return stringBuilder.toString();
    }

    private static boolean aPg() {
        Context context = ab.getContext();
        if (context == null) {
            w.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
            return false;
        } else if (Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private static String y(Map<String, String> map) {
        String str = (String) map.get("model name");
        if (str == null) {
            return p.rG()[0];
        }
        return str;
    }

    private static String z(Map<String, String> map) {
        String str = (String) map.get("features");
        if (str == null) {
            return (String) map.get("flags");
        }
        return str;
    }

    private static String A(Map<String, String> map) {
        return (String) map.get("hardware");
    }

    private static String B(Map<String, String> map) {
        return (String) map.get("revision");
    }

    private static String C(Map<String, String> map) {
        return (String) map.get("serial");
    }

    private static String aPh() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ab.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getExtraInfo();
        }
        return null;
    }

    private static String aPi() {
        String mz = bg.mz(bg.eo(ab.getContext()));
        if (mz.length() > 0) {
            return g.n(mz.getBytes());
        }
        return mz;
    }

    private static String cz(int i, int i2) {
        PackageInfo packageInfo;
        com.tencent.mm.plugin.report.c cVar;
        Object[] objArr;
        String str = "";
        try {
            packageInfo = ab.getContext().getPackageManager().getPackageInfo(ab.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            w.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ab.getPackageName());
        }
        if (packageInfo == null) {
            return str;
        }
        try {
            str = com.tencent.mm.b.c.h(new File(packageInfo.applicationInfo.sourceDir));
            if (!bg.mA(str)) {
                return str;
            }
            com.tencent.mm.plugin.report.c.oTb.a(322, 13, 1, true);
            cVar = com.tencent.mm.plugin.report.c.oTb;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4013);
            objArr[1] = String.format("%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            cVar.i(11098, objArr);
            return str;
        } catch (Exception e2) {
            w.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + e2.getMessage());
            str = "0";
            com.tencent.mm.plugin.report.c.oTb.a(322, 12, 1, true);
            cVar = com.tencent.mm.plugin.report.c.oTb;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4012);
            objArr[1] = String.format("%s|%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r9.getMessage()});
            cVar.i(11098, objArr);
            return str;
        }
    }

    private static int getVersionCode() {
        PackageInfo packageInfo;
        try {
            packageInfo = ab.getContext().getPackageManager().getPackageInfo(ab.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            w.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ab.getPackageName());
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    private static String Ik() {
        String str = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ab.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            return activeNetworkInfo.getSubtype();
        } catch (Throwable e) {
            w.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[]{bg.g(e)});
            return str;
        }
    }

    public final String gb(boolean z) {
        Object treeSet = new TreeSet();
        NativeLogic.a(ab.getContext(), treeSet, z);
        StringBuilder stringBuilder = new StringBuilder(8192);
        Iterator it = treeSet.iterator();
        treeSet = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (treeSet != null) {
                treeSet = null;
            } else {
                stringBuilder.append(',');
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public final String aPj() {
        List<PackageInfo> installedPackages = ab.getContext().getPackageManager().getInstalledPackages(0);
        StringBuilder stringBuilder = new StringBuilder(8192);
        for (PackageInfo packageInfo : installedPackages) {
            stringBuilder.append(packageInfo.packageName).append('\n');
        }
        return stringBuilder.toString();
    }

    private String ap(Context context, String str) {
        Context context2 = context;
        while (context2 != null) {
            try {
                if (!(context2 instanceof ContextWrapper)) {
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            } catch (Throwable th) {
                w.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "unexpected exception.", new Object[0]);
                return "";
            }
        }
        Method declaredMethod = Class.forName(BO("\u001c\u0013\u0010T\u001a\u0016\u001d\u0004\u0018\u001d\u0011\\\u001a\u001e\u0005\u000b\u001d\u0002\f\u0006E\u0007\u001aH%\r\u000b\u0006\u0006\u0012(0+9/4:4")).getDeclaredMethod(BO("./?\u000f\" ;%96\f&/#$,"), new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(null, new Object[0]);
        Class cls = Class.forName(BO("'+ 1-($a!>b\u0018/;>>50\u00192<07:,\u0013=/3/="));
        Class cls2 = Class.forName(BO("*&-< %)l,3o\u000f\u0005-+>>*"));
        Method declaredMethod2 = cls.getDeclaredMethod(BO("3\"\u00199\"0&=;:="), new Class[]{cls2});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(null, new Object[]{invoke});
        cls = Class.forName(BO("#+=-c\"..&l\u001007/)?"));
        declaredMethod2 = invoke.getClass().getDeclaredMethod(BO("45%\u00052&#38="), new Class[]{cls});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(invoke, new Object[]{BO(".<?0;>=")});
        declaredMethod2 = Class.forName(BO("\u001f\u0013\u0018\t\u0015\u0010\u001cY\u0015\u001a\u001a\u0007\u0017\u001f\u0004A\u001e\u0000B\":\b\u000b\f\u0007\u0002\u0001.\u0003\u000f\u00018;/x\b.,:")).getDeclaredMethod(BO("3\"\u00199\"0&=;:="), new Class[]{cls2});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(null, new Object[]{invoke});
        cls = Class.forName(BO("\u001d\u0011\u001a\u000b\u0017\u0012\u001e[\u0015\u0007\u0006_1\u0003\u0002\u0001\u0005\f\u000f\u001d\u0001\u0004\u00045\u0005\u0004\r\u0000\u0007\u0006/<2>9<*"));
        cls2 = Class.forName(BO("/#(9% ,i'54m\u0001..+;%(\u00127)4"));
        Class cls3 = Class.forName(BO("\u001a\u0016\u001d\f\u0010\u0015\u0019\\\u0010\u001f\u001f\u0002\u0012\u001a\u0001D\u001b\u0005G'?\r\u000e\t\u0002\u0007\u0004+\u0006\n\u0004=>*"));
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{cls2, cls3});
        declaredConstructor.setAccessible(true);
        invoke = declaredConstructor.newInstance(new Object[]{context2, invoke});
        Method declaredMethod3 = cls.getDeclaredMethod(BO("*+;\u0001'9?%)*\"$\u0011# 7<9:+"), new Class[]{Integer.TYPE});
        declaredMethod3.setAccessible(true);
        List list = (List) declaredMethod3.invoke(invoke, new Object[]{Integer.valueOf(0)});
        if (list == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (Object next : list) {
            int i2;
            if (i != 0) {
                i2 = 0;
            } else {
                stringBuilder.append(str);
                i2 = i;
            }
            String str2 = (String) next.getClass().getDeclaredField(BO("\"03<721\u0015;4=")).get(next);
            Object next2 = next2.getClass().getDeclaredField(BO("7%$?;21+722\u00124?7")).get(next2);
            Class cls4 = Class.forName(BO("\u001a\u0016\u001d\f\u0010\u0015\u0019\\\u0010\u001f\u001f\u0002\u0012\u001a\u0001D\u001b\u0005G>\u000e\u000f\u0006\u0003\u0004\u0005(\u0012\u0002\t,4=7"));
            Class cls5 = Class.forName(BO("\u0019\u0015\u001e\u000f\u0013\u0016\u001a_\u0013\u001c\u001c\u0001\u0011\u0019\u0002G\u0018\u0006D=\r\f\u0005\u0000\u0007\u0006/\u0004\n\u0006\u0001<*"));
            Method declaredMethod4 = cls4.getDeclaredMethod(BO("<<31\u001864<4"), new Class[]{cls5});
            declaredMethod4.setAccessible(true);
            stringBuilder.append(str2).append('#').append(declaredMethod4.invoke(next2, new Object[]{invoke}).toString());
            i = i2;
        }
        return stringBuilder.toString();
    }

    public final boolean aPk() {
        return NativeLogic.aPk();
    }

    public final boolean a(Object obj, Class cls) {
        return NativeLogic.a(obj, cls);
    }

    public final byte[] aPl() {
        try {
            Context applicationContext = ab.getContext().getApplicationContext();
            String str = applicationContext.getApplicationInfo().sourceDir;
            WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
            String ssid = connectionInfo.getSSID();
            String bssid = connectionInfo.getBSSID();
            int versionCode = getVersionCode();
            int i = aPg() ? 1 : 0;
            int i2 = NativeLogic.aPk() ? 1 : 0;
            int i3 = Debug.isDebuggerConnected() ? 1 : 0;
            h.vG();
            byte[] bt = NativeLogic.bt(str, a.uH());
            h.vG();
            byte[] f = NativeLogic.f(applicationContext, str, a.uH());
            byte[] cG = NativeLogic.cG(applicationContext);
            String f2 = com.tencent.mm.plugin.normsg.utils.a.f(bt, 0, bt.length);
            str = com.tencent.mm.plugin.normsg.utils.a.f(f, 0, f.length);
            String f3 = com.tencent.mm.plugin.normsg.utils.a.f(cG, 0, cG.length);
            int i4 = (c.nZM || c.nZN || c.nZO) ? 1 : 0;
            String charSequence = applicationContext.getPackageManager().getApplicationLabel(applicationContext.getApplicationInfo()).toString();
            Map rN = p.rN();
            r15 = new Object[44][];
            r15[0] = new Object[]{"\u001d$\u001b>\"8\u001e2?\u0010.<6", Integer.valueOf(i)};
            r15[1] = new Object[]{"\u001c!4\u00180 24", Integer.valueOf(i2)};
            r15[2] = new Object[]{"\u001e'\u001104\u0013>019>.><", Integer.valueOf(i3)};
            r15[3] = new Object[]{"\u000194\u001c4%?i", f2};
            r15[4] = new Object[]{"\u000194\u001c4%?j", str};
            r15[5] = new Object[]{"\u000194\u001c4%?k", f3};
            r15[6] = new Object[]{"\u0013#'\u0006 %?7?", y(rN)};
            r15[7] = new Object[]{"\u00011%?8\u0012\"\f>*", p.rI()};
            r15[8] = new Object[]{"\u001e!\u000119\u00002*", p.rJ()};
            r15[9] = new Object[]{"\u0014\u0013\u001a\u0011", p.rA()};
            r15[10] = new Object[]{"\u0011=6';>2\u0010\u001c", p.getAndroidId()};
            r15[11] = new Object[]{"\u00029?93\u00061)384", p.rM()};
            r15[12] = new Object[]{"\u00038>82\u0019:>>4", p.rF()};
            r15[13] = new Object[]{"\u0016&\"\u0013> 6\u001f2+1,", Integer.valueOf(p.rO())};
            r15[14] = new Object[]{"\u001f/+\u0011\u000f", A(rN)};
            r15[15] = new Object[]{"\u001c,(\b>.", B(rN)};
            r15[16] = new Object[]{"\u0013#'\u00061%?84", C(rN)};
            r15[17] = new Object[]{"\r80=\u0017\u0018\u001b", p.rC()};
            r15[18] = new Object[]{"\u0011!%\u001134 .(<+", z(rN)};
            r15[19] = new Object[]{"\u000e\r\u0016\u001c", ssid};
            r15[20] = new Object[]{"\f,\u00144=7", p.ax(applicationContext)};
            r15[21] = new Object[]{"\u001e\f\r\u0010\u001c", bssid};
            r15[22] = new Object[]{"\u001f\r\u0012\u00124?7", aPh()};
            r15[23] = new Object[]{"\u000e6;\u0015;4=", ab.getPackageName()};
            r15[24] = new Object[]{"\u001c(57>\u001f\b", x.get("ro.build.fingerprint")};
            r15[25] = new Object[]{"\u0011%8:3\u0016:;)<", Build.BOARD};
            r15[26] = new Object[]{"\u0014 =?6\u0013?0*13:><*", Build.BOOTLOADER};
            r15[27] = new Object[]{"\u0011%8:3\u0016';5<", Build.BRAND};
            r15[28] = new Object[]{"\u0010$9;2\u00111-3:=", Build.DEVICE};
            r15[29] = new Object[]{"\u001c(57>\u0011\u000f", Build.HARDWARE};
            r15[30] = new Object[]{"\u0017#><5\u0002!39+<,", Build.PRODUCT};
            r15[31] = new Object[]{"\u0019 \u000309\"\u00137.", Integer.valueOf(i4)};
            r15[32] = new Object[]{"\u001879%730((,:*", x.get("ro.product.manufacturer")};
            r15[33] = new Object[]{"\u0001:<:0\u0018\"5", aPi()};
            r15[34] = new Object[]{"\u00108(\u000f#)=", Ik()};
            r15[35] = new Object[]{"\u00153'5\u000798,", e.hgp};
            Object[] objArr = new Object[2];
            objArr[0] = "\u00182!\u0011!'\u00062?";
            objArr[1] = Integer.valueOf(com.tencent.mm.plugin.normsg.utils.b.nZG ? 1 : 0);
            r15[36] = objArr;
            objArr = new Object[2];
            objArr[0] = "\u001c6%\u000098'\u000e4>:6/";
            objArr[1] = Integer.valueOf(d.nZP ? 1 : 0);
            r15[37] = objArr;
            r15[38] = new Object[]{"\u00044\"$?::\u00185==", Integer.valueOf(versionCode)};
            r15[39] = new Object[]{"\u000b#89+'+\"\u0005)%01\r/>:8.\u0015;4=", ab.getContext().getClassLoader().getClass().getName()};
            r15[40] = new Object[]{"\u001f-,\u0015;4=", charSequence};
            r15[41] = new Object[]{"\u0005\u0006\u001a?#,\u0002.!''!\u0002.*<+", gb(true)};
            r15[42] = new Object[]{"\u001b3*\u00193-+", Long.valueOf(NativeLogic.aPm())};
            r15[43] = new Object[]{"\u0002*$ /%%\u000f,/(98!+?;=!+\u00005#(6?8\u0013?+", NativeLogic.BQ(",")};
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<st>");
            for (i3 = 0; i3 < 44; i3++) {
                Object[] objArr2 = r15[i3];
                String BP = BP(BO((String) objArr2[0]));
                stringBuilder.append('<').append(BP).append('>').append(BP(String.valueOf(objArr2[1]))).append('<').append('/').append(BP).append('>');
            }
            stringBuilder.append("</st>");
            return stringBuilder.toString().getBytes();
        } catch (Throwable th) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            com.tencent.mm.plugin.report.service.g.oUh.d("BriefSecInfoCrash", stringWriter.toString(), null);
            printWriter.close();
            return new byte[0];
        }
    }
}
