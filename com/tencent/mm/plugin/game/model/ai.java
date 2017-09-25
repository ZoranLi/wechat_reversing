package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.plugin.game.model.ah.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai {
    private static String mry = null;
    private static String mrz = "";

    public static void a(Context context, int i, int i2, String str, int i3, String str2) {
        w.i("MicroMsg.GameReportUtil", "reportExposureInfo : 10" + " , " + i + " , " + i2 + " , 1" + " , 0 , " + bg.mz(str) + " , " + i3 + " , 0 , " + bg.mz(null) + " , " + bg.mz(null) + " , " + bg.mz(str2));
        g.oUh.i(13384, new Object[]{Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1), Integer.valueOf(0), str, Integer.valueOf(i3), Integer.valueOf(0), null, Integer.valueOf(bg.getInt(null, 0)), Integer.valueOf(ck(context)), str2});
    }

    public static void a(Context context, String str, long j, int i) {
        g.oUh.i(14416, new Object[]{str, Long.valueOf(j), Integer.valueOf(ck(context)), Integer.valueOf(i)});
    }

    public static void m(Context context, String str, String str2) {
        w.d("MicroMsg.GameReportUtil", "reportRegToWx, appId = " + str + ", pkgName = " + str2);
        if (bg.mA(str)) {
            w.e("MicroMsg.GameReportUtil", "reportRegToWx fail, appId is null");
            return;
        }
        g.oUh.i(10534, new Object[]{str, Integer.valueOf(Y(context, str2)), aBu(), Long.valueOf(System.currentTimeMillis() / 1000)});
    }

    public static void a(String str, String str2, int i, int i2, String str3, long j) {
        w.d("MicroMsg.GameReportUtil", "reportReadMsg, appId = " + str);
        if (bg.mA(str)) {
            w.e("MicroMsg.GameReportUtil", "reportReadMsg fail, appId is null");
            return;
        }
        w.d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = " + new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(j)).toString());
        g.oUh.i(10532, new Object[]{str, r0, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)});
    }

    public static void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5) {
        w.d("MicroMsg.GameReportUtil", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", new Object[]{str, str2, Long.valueOf(j), str5});
        if (bg.mA(str)) {
            w.e("MicroMsg.GameReportUtil", "reportMsgClick fail, appId is null");
            return;
        }
        if (context == null) {
            context = ab.getContext();
        }
        if (com.tencent.mm.pluginsdk.model.app.g.aJ(str, false) == null) {
            w.e("MicroMsg.GameReportUtil", "reportMsgClick fail, appinfo is null");
            return;
        }
        SubCoreGameCenter.aBD().a(a.h(10531, str, Integer.valueOf(Y(context, str2)), aBu(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(ck(context)), bg.mz(r0.field_packageName), bg.mz(r0.field_signature), Long.toString(j), "", str5));
    }

    public static void e(String str, int i, int i2, int i3) {
        w.d("MicroMsg.GameReportUtil", "reportGameDetail, appId = " + str + ", scene = " + i2);
        if (bg.mA(str)) {
            w.e("MicroMsg.GameReportUtil", "reportGameDetail fail, appId is null");
            return;
        }
        g.oUh.i(10700, new Object[]{str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static void a(String str, String str2, int i, int i2, String str3, int i3) {
        w.d("MicroMsg.GameReportUtil", "rejectGameMsg, fromUserName = " + str + ", appId = " + str2 + ", msgType = " + i + ", scene = " + i2 + ", actionName = " + str3);
        if (bg.mA(str2)) {
            w.e("MicroMsg.GameReportUtil", "rejectGameMsg fail, appId is null");
            return;
        }
        g.oUh.i(10546, new Object[]{str, str2, Integer.valueOf(i), aBu(), Integer.valueOf(i2), str3, Integer.valueOf(i3)});
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        w.d("MicroMsg.GameReportUtil", "reportMsgClick, appId = " + str + ", pkgName = " + str2);
        if (bg.mA(str)) {
            w.e("MicroMsg.GameReportUtil", "reportDelGameMsg fail, appId is null");
            return;
        }
        if (context == null) {
            context = ab.getContext();
        }
        SubCoreGameCenter.aBD().a(a.h(10583, str, Integer.valueOf(Y(context, str2)), aBu(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(ck(context))));
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str) {
        a(context, i, i2, i3, i4, 0, null, i5, 0, null, null, str);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2) {
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, null, str2);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2, String str3) {
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, str2, str3);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, String str2, String str3, String str4) {
        SubCoreGameCenter.aBD().a(a.h(12909, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), Integer.valueOf(i7), str2, Integer.valueOf(bg.getInt(str3, 0)), Integer.valueOf(ck(context)), str4));
    }

    public static String xR(String str) {
        if (bg.mA(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Exception exception = e;
            String str2 = "";
            w.e("MicroMsg.GameReportUtil", exception.getMessage());
            return str2;
        }
    }

    private static String xS(String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GameReportUtil", e, "", new Object[0]);
        }
        return str;
    }

    public static String u(Map<String, String> map) {
        if (map.size() == 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
                w.e("MicroMsg.GameReportUtil", e.getMessage());
                return "";
            }
        }
        try {
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e2) {
            w.e("MicroMsg.GameReportUtil", e2.getMessage());
            return "";
        }
    }

    public static String co(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("function_type", str);
            jSONObject.put("function_value", str2);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GameReportUtil", e, "", new Object[0]);
        }
        return xR(jSONObject.toString());
    }

    public static String H(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, str3);
        } catch (Exception e) {
            w.e("MicroMsg.GameReportUtil", e.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            return cp(str, jSONObject.toString());
        }
        return str;
    }

    private static String cp(String str, String str2) {
        if (bg.mA(str)) {
            return str2;
        }
        String xS = xS(str);
        String xS2 = xS(str2);
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(xS);
        } catch (Exception e) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject(xS2);
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str3 = (String) keys.next();
                        jSONObject2.put(str3, jSONObject.opt(str3));
                    } catch (Exception e2) {
                        return "";
                    }
                }
            }
            return xR(jSONObject2.toString());
        } catch (JSONException e3) {
            return "";
        }
    }

    public static void a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        long currentTimeMillis = System.currentTimeMillis();
        SubCoreGameCenter.aBD().a(a.h(10737, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), Integer.valueOf(1), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(0), str2, "", str3, Integer.valueOf(ck(ab.getContext())), Integer.valueOf(0), Integer.valueOf(1), str4, str5));
    }

    public static void a(String str, int i, int i2, long j, long j2, String str2, int i3, int i4, String str3, long j3, int i5) {
        SubCoreGameCenter.aBD().a(a.h(14567, str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), xR(str2), Integer.valueOf(ck(ab.getContext())), Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j3), Integer.valueOf(i5)));
    }

    public static void I(String str, String str2, String str3) {
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.GameReportUtil", "null open or null username");
            return;
        }
        g.oUh.i(10738, new Object[]{str, str2, str, str3});
    }

    private static int Y(Context context, String str) {
        PackageInfo az = p.az(context, str);
        return az == null ? 0 : az.versionCode;
    }

    private static String aBu() {
        if (mry == null) {
            String rB = com.tencent.mm.compatible.d.p.rB();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < rB.length() - 1; i++) {
                stringBuilder.append(Integer.toHexString(rB.charAt(i)));
            }
            stringBuilder.append("00");
            mry = stringBuilder.toString();
        }
        return mry;
    }

    public static int ck(Context context) {
        if (am.is3G(context)) {
            return 4;
        }
        if (am.is4G(context)) {
            return 5;
        }
        switch (am.getNetType(context)) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            default:
                return 6;
        }
    }

    public static void xT(String str) {
        mrz = str;
    }
}
