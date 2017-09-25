package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.i;
import com.tencent.smtt.sdk.k;
import com.tencent.smtt.sdk.l;
import com.tencent.smtt.sdk.t;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.p;
import com.tencent.smtt.utils.q;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

public final class b {
    public static byte[] wXv;

    static {
        wXv = null;
        try {
            wXv = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
        }
    }

    public static JSONObject a(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            if (thirdAppInfoNew.sAppSignature == null) {
                jSONObject.put("SIGNATURE", "0");
            } else {
                jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            if (t.gu(context)) {
                jSONObject.put("HOST_COREVERSION", t.ceM());
            } else {
                jSONObject.put("HOST_COREVERSION", l.cem());
                jSONObject.put("DECOUPLE_COREVERSION", l.cem());
            }
            if (thirdAppInfoNew.iCoreType == 0) {
                jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
                jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
                int i = i.wUy;
                if (thirdAppInfoNew.localCoreVersion <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", k.fM(context).cel());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            try {
                if (QbSdk.getTID() == null) {
                    return jSONObject;
                }
                if (thirdAppInfoNew.sAppName.equals("com.tencent.mobileqq")) {
                    com.tencent.smtt.utils.k.cfq();
                    jSONObject.put("TID", com.tencent.smtt.utils.k.Vy(QbSdk.getTID()));
                    jSONObject.put("TIDTYPE", 1);
                    return jSONObject;
                } else if (!thirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
                    return jSONObject;
                } else {
                    jSONObject.put("TID", QbSdk.getTID());
                    jSONObject.put("TIDTYPE", 0);
                    return jSONObject;
                }
            } catch (Exception e) {
                return jSONObject;
            }
        } catch (Exception e2) {
            TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i, boolean z, long j) {
        String str4;
        ThirdAppInfoNew thirdAppInfoNew;
        int i2;
        String str5 = "";
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ("com.tencent.mobileqq".equals(applicationInfo.packageName)) {
                str5 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                    str5 = str5 + "." + QbSdk.getQQBuildNumber();
                }
            }
            str4 = str5;
        } catch (Exception e) {
            str4 = str5;
        } catch (Throwable th) {
            return;
        }
        final ThirdAppInfoNew thirdAppInfoNew2 = new ThirdAppInfoNew();
        thirdAppInfoNew2.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
        q.gZ(context);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        thirdAppInfoNew2.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        thirdAppInfoNew2.sGuid = str;
        if (z) {
            thirdAppInfoNew2.sQua2 = str2;
        } else {
            thirdAppInfoNew2.sQua2 = p.gW(context);
        }
        thirdAppInfoNew2.sLc = str3;
        str5 = c.gQ(context);
        String V = c.V(context);
        String gP = c.gP(context);
        Object gR = c.gR(context);
        if (!(V == null || "".equals(V))) {
            thirdAppInfoNew2.sImei = V;
        }
        if (!(gP == null || "".equals(gP))) {
            thirdAppInfoNew2.sImsi = gP;
        }
        if (!TextUtils.isEmpty(gR)) {
            thirdAppInfoNew2.sAndroidID = gR;
        }
        if (!(str5 == null || "".equals(str5))) {
            thirdAppInfoNew2.sMac = str5;
        }
        thirdAppInfoNew2.iPv = (long) i;
        ThirdAppInfoNew thirdAppInfoNew3;
        if (t.gu(context)) {
            if (!z) {
                thirdAppInfoNew3 = thirdAppInfoNew2;
                thirdAppInfoNew = thirdAppInfoNew3;
                i2 = 0;
            } else if (t.ceS()) {
                i2 = 2;
                thirdAppInfoNew = thirdAppInfoNew2;
            } else {
                i2 = 1;
                thirdAppInfoNew = thirdAppInfoNew2;
            }
        } else if (z) {
            i2 = 1;
            thirdAppInfoNew = thirdAppInfoNew2;
        } else {
            thirdAppInfoNew3 = thirdAppInfoNew2;
            thirdAppInfoNew = thirdAppInfoNew3;
            i2 = 0;
        }
        thirdAppInfoNew.iCoreType = i2;
        thirdAppInfoNew2.sAppVersionName = str4;
        thirdAppInfoNew2.sAppSignature = gJ(context);
        if (!z) {
            thirdAppInfoNew2.sWifiConnectedTime = j;
            thirdAppInfoNew2.localCoreVersion = QbSdk.getTbsVersion(context);
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread("HttpUtils") {
            public final void run() {
                if (VERSION.SDK_INT >= 8) {
                    if (b.wXv == null) {
                        try {
                            b.wXv = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
                        } catch (UnsupportedEncodingException e) {
                            b.wXv = null;
                            TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                        }
                    }
                    if (b.wXv == null) {
                        TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                        return;
                    }
                    String string = k.fM(applicationContext).wUG.getString("tbs_deskey_token", "");
                    String str = "";
                    String str2 = "";
                    if (TextUtils.isEmpty(string)) {
                        String str3 = str2;
                        str2 = str;
                        str = str3;
                    } else {
                        str2 = string.substring(0, string.indexOf("&"));
                        str = string.substring(string.indexOf("&") + 1, string.length());
                    }
                    boolean z = TextUtils.isEmpty(str2) || str2.length() != 96 || TextUtils.isEmpty(str) || str.length() != 24;
                    try {
                        JSONObject a;
                        q cfw = q.cfw();
                        if (z) {
                            StringBuilder append = new StringBuilder().append(cfw.wYu);
                            j.cfn();
                            str2 = append.append(j.cfo()).toString();
                        } else {
                            str2 = cfw.wYv + str2;
                        }
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setConnectTimeout(20000);
                        if (VERSION.SDK_INT > 13) {
                            httpURLConnection.setRequestProperty("Connection", "close");
                        }
                        try {
                            a = b.a(thirdAppInfoNew2, applicationContext);
                        } catch (Exception e2) {
                            a = null;
                        }
                        if (a == null) {
                            TbsLog.e("sdkreport", "post -- jsonData is null!");
                            return;
                        }
                        try {
                            byte[] bytes = a.toString().getBytes(ProtocolPackage.ServerEncoding);
                            byte[] bA = z ? j.cfn().bA(bytes) : j.j(bytes, str);
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bA.length));
                            try {
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(bA);
                                outputStream.flush();
                                if (httpURLConnection.getResponseCode() != m.CTRL_INDEX) {
                                    TbsLog.e("sdkreport", "Post failed -- not 200");
                                }
                            } catch (Throwable th) {
                                TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                            }
                        } catch (Throwable th2) {
                        }
                    } catch (IOException e3) {
                        TbsLog.e("sdkreport", "Post failed -- IOException:" + e3);
                    } catch (AssertionError e4) {
                        TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e4);
                    } catch (NoClassDefFoundError e5) {
                        TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e5);
                    }
                }
            }
        }.start();
    }

    private static String gJ(Context context) {
        String str = null;
        try {
            byte[] toByteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (toByteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(toByteArray);
                toByteArray = instance.digest();
                if (toByteArray != null) {
                    StringBuilder stringBuilder = new StringBuilder("");
                    if (toByteArray != null && toByteArray.length > 0) {
                        for (int i = 0; i < toByteArray.length; i++) {
                            String toUpperCase = Integer.toHexString(toByteArray[i] & 255).toUpperCase();
                            if (i > 0) {
                                stringBuilder.append(":");
                            }
                            if (toUpperCase.length() < 2) {
                                stringBuilder.append(0);
                            }
                            stringBuilder.append(toUpperCase);
                        }
                        str = stringBuilder.toString();
                    }
                }
            }
        } catch (Exception e) {
        }
        return str;
    }
}
