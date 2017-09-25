package com.tencent.mapsdk.rastercore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import java.io.BufferedInputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public class a {
    public static StringBuffer a = new StringBuffer(e.CTRL_INDEX);
    private static final String b = a.class.getSimpleName();
    public static boolean c = false;
    public static WeakReference<com.tencent.mapsdk.rastercore.d.e> d = null;

    @SuppressLint({"NewApi"})
    public static String a() {
        Object obj = "";
        Context a = com.tencent.mapsdk.rastercore.d.e.a();
        if (VERSION.SDK_INT < 23 || (a != null && a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            obj = ((TelephonyManager) a.getSystemService("phone")).getDeviceId();
        }
        return TextUtils.isEmpty(obj) ? "noIMEI" : obj;
    }

    public static void a(com.tencent.mapsdk.rastercore.d.e eVar) {
        d = new WeakReference(eVar);
        if (!c) {
            new Thread() {
                public final void run() {
                    String charSequence;
                    DisplayMetrics displayMetrics;
                    int i;
                    int i2;
                    int i3;
                    StringBuffer stringBuffer;
                    HttpURLConnection httpURLConnection;
                    String headerField;
                    boolean z;
                    a.c = true;
                    String str = "https://apikey.map.qq.com/mkey/index.php/mkey/check?";
                    try {
                        String encode = URLEncoder.encode(com.tencent.mapsdk.rastercore.f.a.a(com.tencent.mapsdk.rastercore.d.e.a()), "UTF-8");
                        a.a.append("key=");
                        a.a.append(encode);
                    } catch (Exception e) {
                    }
                    a.a.append("&output=json");
                    a.a.append("&pf=and_2Dmap");
                    a.a.append("&ver=");
                    try {
                        a.a.append(URLEncoder.encode("1.2.8.29dc259", "UTF-8"));
                    } catch (Exception e2) {
                    }
                    try {
                        a.a.append("&hm=");
                        a.a.append(URLEncoder.encode(Build.MODEL, "UTF-8"));
                        a.a.append("&os=A");
                        a.a.append(VERSION.SDK_INT);
                        a.a.append("&pid=");
                        a.a.append(URLEncoder.encode(com.tencent.mapsdk.rastercore.d.e.a().getPackageName(), "UTF-8"));
                        a.a.append("&nt=");
                        a.a.append(URLEncoder.encode(a.b()));
                    } catch (Exception e3) {
                    }
                    a.a.append("&suid=");
                    a.a.append(a.a());
                    try {
                        PackageManager packageManager = com.tencent.mapsdk.rastercore.d.e.a().getPackageManager();
                        PackageInfo packageInfo = packageManager.getPackageInfo(com.tencent.mapsdk.rastercore.d.e.a().getPackageName(), 0);
                        charSequence = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                        try {
                            encode = packageInfo.versionName;
                            if (TextUtils.isEmpty(encode)) {
                                encode = null;
                            }
                        } catch (Exception e4) {
                            encode = charSequence;
                            charSequence = encode;
                            encode = null;
                            if (charSequence != null) {
                                a.a.append("&ref=");
                                try {
                                    a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
                                } catch (Exception e5) {
                                }
                            }
                            if (encode != null) {
                                a.a.append("&psv=");
                                try {
                                    a.a.append(URLEncoder.encode(encode, "UTF-8"));
                                } catch (Exception e6) {
                                }
                            }
                            displayMetrics = com.tencent.mapsdk.rastercore.d.e.a().getResources().getDisplayMetrics();
                            i = displayMetrics.densityDpi;
                            i2 = displayMetrics.widthPixels;
                            i3 = displayMetrics.heightPixels;
                            a.a.append("&dpi=");
                            a.a.append(i);
                            a.a.append("&scrn=");
                            a.a.append(i2);
                            a.a.append("*");
                            a.a.append(i3);
                            stringBuffer = a.a;
                            while (i2 < 2) {
                                try {
                                    httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
                                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                                    if (httpURLConnection.getResponseCode() != m.CTRL_INDEX) {
                                        headerField = httpURLConnection.getHeaderField("Content-Encoding");
                                        if (headerField == null) {
                                        }
                                        a.a(new String(com.tencent.mapsdk.rastercore.d.a.a(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                                        break;
                                    }
                                    continue;
                                } catch (Exception e7) {
                                }
                            }
                            a.c = false;
                        }
                    } catch (Exception e8) {
                        encode = null;
                        charSequence = encode;
                        encode = null;
                        if (charSequence != null) {
                            a.a.append("&ref=");
                            a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
                        }
                        if (encode != null) {
                            a.a.append("&psv=");
                            a.a.append(URLEncoder.encode(encode, "UTF-8"));
                        }
                        displayMetrics = com.tencent.mapsdk.rastercore.d.e.a().getResources().getDisplayMetrics();
                        i = displayMetrics.densityDpi;
                        i2 = displayMetrics.widthPixels;
                        i3 = displayMetrics.heightPixels;
                        a.a.append("&dpi=");
                        a.a.append(i);
                        a.a.append("&scrn=");
                        a.a.append(i2);
                        a.a.append("*");
                        a.a.append(i3);
                        stringBuffer = a.a;
                        for (i2 = 0; i2 < 2; i2++) {
                            httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
                            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                            if (httpURLConnection.getResponseCode() != m.CTRL_INDEX) {
                                headerField = httpURLConnection.getHeaderField("Content-Encoding");
                                if (headerField == null) {
                                }
                                if (z) {
                                }
                                a.a(new String(com.tencent.mapsdk.rastercore.d.a.a(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                                break;
                            }
                            continue;
                        }
                        a.c = false;
                    }
                    if (charSequence != null) {
                        a.a.append("&ref=");
                        a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
                    }
                    if (encode != null) {
                        a.a.append("&psv=");
                        a.a.append(URLEncoder.encode(encode, "UTF-8"));
                    }
                    try {
                        displayMetrics = com.tencent.mapsdk.rastercore.d.e.a().getResources().getDisplayMetrics();
                        i = displayMetrics.densityDpi;
                        i2 = displayMetrics.widthPixels;
                        i3 = displayMetrics.heightPixels;
                        a.a.append("&dpi=");
                        a.a.append(i);
                        a.a.append("&scrn=");
                        a.a.append(i2);
                        a.a.append("*");
                        a.a.append(i3);
                    } catch (Exception e9) {
                    }
                    stringBuffer = a.a;
                    for (i2 = 0; i2 < 2; i2++) {
                        httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        if (httpURLConnection.getResponseCode() != m.CTRL_INDEX) {
                            headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            z = headerField == null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip");
                            if (z) {
                            }
                            a.a(new String(com.tencent.mapsdk.rastercore.d.a.a(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                            break;
                        }
                        continue;
                    }
                    a.c = false;
                }
            }.start();
        }
    }

    static /* synthetic */ void a(String str) {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getJSONObject("info").getInt("error") != -1) {
                if (jSONObject.getJSONObject("detail").getJSONObject("cfg").optJSONObject("raster_base_map_world") != null) {
                    z = true;
                }
                if (com.tencent.mapsdk.rastercore.d.e.r() != z) {
                    com.tencent.mapsdk.rastercore.d.e.e(z);
                    com.tencent.mapsdk.rastercore.d.e.d(z);
                    if (d.get() != null) {
                        ((com.tencent.mapsdk.rastercore.d.e) d.get()).d().post(new Runnable() {
                            public final void run() {
                                ((com.tencent.mapsdk.rastercore.d.e) a.d.get()).a(false, false);
                            }
                        });
                    }
                }
            } else if (jSONObject.getJSONObject("info").getString("msg").equals("KEY_NOT_EXISTS")) {
                com.tencent.mapsdk.rastercore.d.e.c(false);
            }
        } catch (Exception e) {
            new StringBuilder("checkJsonResult gets error:").append(e.getMessage());
        }
    }

    static /* synthetic */ String b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.mapsdk.rastercore.d.e.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "";
    }
}
