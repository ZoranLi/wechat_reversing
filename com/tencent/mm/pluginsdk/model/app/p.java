package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedHashMap;
import java.util.Map;

public final class p {
    public static String e(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            w.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
            return null;
        }
        String d = v.d(context.getSharedPreferences(ab.bIX(), 0));
        if (d == null || d.length() == 0) {
            d = "zh_CN";
        } else if (d.equals("en")) {
            d = "en_US";
        }
        return context.getString(g.kES, new Object[]{str, Integer.valueOf(d.sYN), d, d.DEVICE_TYPE, str2});
    }

    public static String t(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            w.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
            return null;
        }
        String d = v.d(context.getSharedPreferences(ab.bIX(), 0));
        if (d == null || d.length() == 0) {
            d = "zh_CN";
        } else if (d.equals("en")) {
            d = "en_US";
        }
        return context.getString(g.kET, new Object[]{str, Integer.valueOf(d.sYN), d, d.DEVICE_TYPE, str2, Integer.valueOf(0)});
    }

    public static String s(String str, String str2) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
            return null;
        }
        String str3;
        int indexOf = str.indexOf("#");
        String str4 = "";
        if (indexOf >= 0) {
            str4 = str.substring(indexOf);
            str = str.substring(0, indexOf);
            str3 = str4;
        } else {
            str3 = str4;
        }
        int indexOf2 = str.indexOf("?");
        str4 = "";
        if (indexOf2 >= 0) {
            str4 = str.substring(indexOf2 + 1);
            str = str.substring(0, indexOf2);
        }
        w.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", str3, str4, str);
        Map linkedHashMap = new LinkedHashMap();
        if (!bg.mA(str4)) {
            String[] split = str4.split("&");
            if (split != null && split.length > 0) {
                for (String str5 : split) {
                    String str52;
                    if (!bg.mA(str52)) {
                        Object substring;
                        Object substring2;
                        int indexOf3 = str52.indexOf("=");
                        w.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", Integer.valueOf(indexOf3));
                        if (indexOf3 >= 0) {
                            substring = str52.substring(0, indexOf3 + 1);
                            substring2 = str52.substring(indexOf3 + 1);
                        } else {
                            String str6 = str52;
                            str52 = "";
                            str4 = str6;
                        }
                        linkedHashMap.put(substring, substring2);
                    }
                }
            }
        }
        str4 = "from=";
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put(str4, str2);
        w.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", Integer.valueOf(linkedHashMap.size()));
        StringBuilder stringBuilder = new StringBuilder();
        for (String str42 : linkedHashMap.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str42);
            stringBuilder.append((String) linkedHashMap.get(str42));
        }
        str42 = str + "?" + stringBuilder.toString();
        if (!bg.mA(str3)) {
            str42 = str42 + str3;
        }
        w.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", str42);
        return str42;
    }

    public static boolean n(Context context, String str) {
        return az(context, str) != null;
    }

    public static PackageInfo az(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppUtil", "getPackageInfo, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
                w.w("MicroMsg.AppUtil", "app not installed, packageName = " + str);
            }
        }
        return packageInfo;
    }

    public static String aQ(Context context, String str) {
        Signature[] aR = aR(context, str);
        if (aR != null && aR.length != 0) {
            return Mj(com.tencent.mm.a.g.n(aR[0].toByteArray()));
        }
        w.e("MicroMsg.AppUtil", "signs is null");
        return null;
    }

    public static String Mi(String str) {
        if (str != null && str.length() != 0) {
            return Mj(str);
        }
        w.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        return null;
    }

    public static boolean b(Context context, f fVar, String str) {
        a aRv = a.a.aRv();
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
            aRv.c(fVar);
            return false;
        } else if (fVar == null) {
            w.i("MicroMsg.AppUtil", "app does not exist");
            return true;
        } else if (fVar.field_packageName == null || fVar.field_packageName.length() == 0) {
            w.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
            aRv.c(fVar);
            return false;
        } else if (fVar.field_signature == null || fVar.field_signature.length() == 0) {
            w.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
            aRv.c(fVar);
            return false;
        } else {
            Signature[] aR = aR(context, str);
            if (aR == null || aR.length == 0) {
                w.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
                aRv.c(fVar);
                return false;
            } else if (fVar.field_packageName.equals(str)) {
                w.i("MicroMsg.AppUtil", "server signatures:%s", fVar.field_signature);
                int length = aR.length;
                int i = 0;
                while (i < length) {
                    w.i("MicroMsg.AppUtil", "local signatures:%s", Mj(com.tencent.mm.a.g.n(aR[i].toByteArray())));
                    if (fVar.field_signature == null || !fVar.field_signature.equals(r6)) {
                        i++;
                    } else {
                        aRv.d(fVar);
                        return true;
                    }
                }
                w.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
                aRv.c(fVar);
                return false;
            } else {
                w.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", fVar.field_packageName, str);
                aRv.c(fVar);
                return false;
            }
        }
    }

    public static void aa(Bundle bundle) {
        bundle.putString(Token.WX_TOKEN_KEY, Token.WX_TOKEN_VALUE_MSG);
    }

    public static void ab(Bundle bundle) {
        bundle.putString(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
    }

    public static void g(Bundle bundle, String str) {
        bundle.putString(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        if (!bg.mA(str)) {
            bundle.putString(Token.WX_LAUNCH_PARAM_KEY, str);
        }
    }

    public static Signature[] aR(Context context, String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppUtil", "getSignature, packageName is null");
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            w.e("MicroMsg.AppUtil", "info is null, packageName = " + str);
            return null;
        } catch (NameNotFoundException e) {
            w.e("MicroMsg.AppUtil", "NameNotFoundException");
            return null;
        }
    }

    public static String Mj(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.toLowerCase());
        stringBuffer.append("mMHc ItnStR");
        return com.tencent.mm.a.g.n(stringBuffer.toString().getBytes());
    }

    public static boolean b(Context context, f fVar) {
        w.i("MicroMsg.AppUtil", "check the signature of the Application.");
        if (context == null) {
            w.e("MicroMsg.AppUtil", "context is null.");
            return true;
        } else if (fVar == null) {
            w.e("MicroMsg.AppUtil", "appInfo is null.");
            return true;
        } else if (bg.mA(fVar.field_packageName)) {
            w.e("MicroMsg.AppUtil", "packageName is null.");
            return true;
        } else if (bg.mA(fVar.field_signature)) {
            w.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", fVar.field_packageName);
            return true;
        } else {
            Signature[] aR = aR(context, fVar.field_packageName);
            if (aR == null || aR.length == 0) {
                w.e("MicroMsg.AppUtil", "apk signatures is null");
                return false;
            }
            for (Signature toByteArray : aR) {
                if (fVar.field_signature.equals(Mj(com.tencent.mm.a.g.n(toByteArray.toByteArray())))) {
                    w.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", fVar.field_appName, fVar.field_signature);
                    return true;
                }
            }
            w.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", fVar.field_appName);
            return false;
        }
    }

    public static void Mk(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.AppUtil", "appid is null");
            return;
        }
        SharedPreferences bIY = ab.bIY();
        if (bIY != null) {
            String string = bIY.getString("key_app_ids_registion_while_not_login", "");
            if (string.contains(str)) {
                w.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", str, string);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(string);
            bIY.edit().putString("key_app_ids_registion_while_not_login", stringBuilder.toString()).commit();
        }
    }

    public static void bDe() {
        ap.sEE = null;
        ap.sEF = -1;
    }
}
