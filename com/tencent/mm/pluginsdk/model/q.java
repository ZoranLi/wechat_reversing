package com.tencent.mm.pluginsdk.model;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.QbSdk;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q extends t {
    public static final String[] sCF = new String[]{"application/msword", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/pdf", "application/epub+zip", "text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/zip", "application/rar"};
    public static final int[] sCG = new int[]{R.k.dtv, R.k.dtk, R.k.dtc, R.k.dti, R.k.dtb, R.k.dtn, R.k.dtv, R.k.dtc, R.k.dtk, R.k.dtm, R.k.dtm};
    public static final int[] sCH = new int[]{R.k.dtv, R.k.dtk, R.k.dtc, R.k.dti, R.k.dtb, R.k.dtn, R.k.dtv, R.k.dtc, R.k.dtk, R.k.dtm, R.k.dtm};

    public static class a {
        public int sCI = -1;
        public String sCJ = "";
        public int ver = -1;
    }

    private static class b {
        public String classname = "";
        public String sCK = "";
    }

    public final boolean dt(Context context) {
        a dv = dv(context);
        if (dv.sCI == -1) {
            return false;
        }
        if (dv.sCI != 2 || dv.ver >= 33) {
            return true;
        }
        return false;
    }

    public static boolean LU(String str) {
        for (String equals : sCF) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean du(Context context) {
        if (dv(context).sCI == -1) {
            return false;
        }
        return true;
    }

    public final boolean LN(String str) {
        if ("com.tencent.mtt".equals(str) || "com.tencent.qbx".equals(str) || "com.tencent.mtt.x86".equals(str) || "com.tencent.qbx5".equals(str)) {
            return true;
        }
        return false;
    }

    public final String Nn() {
        return "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10318";
    }

    public final String bCA() {
        return "qq_browser.apk";
    }

    public final com.tencent.mm.pluginsdk.model.u.a bCB() {
        com.tencent.mm.pluginsdk.model.u.a aVar = new com.tencent.mm.pluginsdk.model.u.a();
        aVar.sCO = R.l.eHe;
        aVar.sCQ = R.l.eHf;
        aVar.sCN = R.g.bfO;
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null || resolveInfo.activityInfo.packageName == null) {
            return null;
        }
        String str = resolveInfo.activityInfo.packageName;
        if ("com.qihoo.browser".equals(str)) {
            return "360浏览器";
        }
        if ("com.mx.browser".equals(str)) {
            return "傲游云浏览器";
        }
        if ("com.dolphin.browser.xf".equals(str)) {
            return "海豚浏览器";
        }
        if ("com.UCMobile".equals(str)) {
            return "UC浏览器";
        }
        if ("com.baidu.browser.apps".equals(str)) {
            return "百度浏览器";
        }
        if ("sogou.mobile.explorer".equals(str)) {
            return "搜狗浏览器";
        }
        if ("com.ijinshan.browser".equals(str)) {
            return "猎豹浏览器";
        }
        if ("com.mediawoz.xbrowser".equals(str)) {
            return "GO浏览器";
        }
        if ("com.oupeng.browser".equals(str)) {
            return "欧朋浏览器";
        }
        if ("com.tiantianmini.android.browser".equals(str)) {
            return "天天浏览器";
        }
        CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
        if (loadLabel != null) {
            Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
            if (matcher.find()) {
                return matcher.replaceAll("");
            }
        }
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }

    public static int aP(Context context, String str) {
        if (context == null) {
            return 3;
        }
        boolean z;
        if (str == null || str.length() == 0) {
            z = false;
        } else {
            String trim = str.trim();
            int indexOf = trim.toLowerCase().indexOf("://");
            int indexOf2 = trim.toLowerCase().indexOf(46);
            z = (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) ? trim.toLowerCase().contains("://") : false;
        }
        if (!z) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            if (parse.getScheme().toLowerCase().equals("qb")) {
                Object obj;
                a dv = dv(context);
                if (dv.sCI == -1) {
                    obj = null;
                } else if (dv.sCI != 2 || dv.ver >= 42) {
                    indexOf = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    parse = Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375" + URLEncoder.encode(str, "UTF-8"));
                }
            }
            a dv2 = dv(context);
            if (dv2.sCI == -1) {
                return 4;
            }
            if (dv2.sCI == 2 && dv2.ver < 33) {
                return 5;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            b c;
            if (dv2.sCI == 2) {
                if (dv2.ver >= 33 && dv2.ver <= 39) {
                    intent.setClassName("com.tencent.mtt", "com.tencent.mtt.PhotoEditUI");
                } else if (dv2.ver >= 40 && dv2.ver <= 45) {
                    intent.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                } else if (dv2.ver >= 46) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    c = c(context, parse);
                    if (!(c == null || TextUtils.isEmpty(c.classname))) {
                        intent.setClassName(c.sCK, c.classname);
                    }
                }
            } else if (dv2.sCI == 1) {
                if (dv2.ver == 1) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.PhotoEditUI");
                } else if (dv2.ver == 2) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                }
            } else if (dv2.sCI != 0) {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                c = c(context, parse);
                if (!(c == null || TextUtils.isEmpty(c.classname))) {
                    intent.setClassName(c.sCK, c.classname);
                }
            } else if (dv2.ver >= 4 && dv2.ver <= 6) {
                intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
            } else if (dv2.ver > 6) {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                c = c(context, parse);
                if (!(c == null || TextUtils.isEmpty(c.classname))) {
                    intent.setClassName(c.sCK, c.classname);
                }
            }
            intent.setData(parse);
            try {
                intent.putExtra("loginType", 24);
                intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
                intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 0);
                context.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException e) {
                return 4;
            }
        } catch (Exception e2) {
            return 2;
        }
    }

    private static a dv(Context context) {
        a aVar = new a();
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                aVar.sCI = 2;
                aVar.sCJ = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    aVar.ver = packageInfo.versionCode;
                    aVar.sCJ += packageInfo.versionName.replaceAll("\\.", "");
                    return aVar;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                aVar.sCI = 0;
                aVar.sCJ = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    aVar.sCI = 1;
                    aVar.sCJ = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                        aVar.sCI = 2;
                        aVar.sCJ = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            aVar.sCI = 2;
                            aVar.sCJ = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                b c = c(context, Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375"));
                                if (!(c == null || TextUtils.isEmpty(c.sCK))) {
                                    packageInfo = packageManager.getPackageInfo(c.sCK, 0);
                                    aVar.sCI = 2;
                                    aVar.sCJ = "ADRQB_";
                                }
                            } catch (Exception e6) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                aVar.ver = packageInfo.versionCode;
                aVar.sCJ += packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception e7) {
        }
        return aVar;
    }

    private static b c(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains("com.tencent.mtt")) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.sCK = resolveInfo.activityInfo.packageName;
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.sCK = resolveInfo.activityInfo.packageName;
            }
        }
        return bVar;
    }

    public final boolean v(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                if (str.contains("com.tencent.mtt")) {
                    return true;
                }
                if (str.contains("com.tencent.qbx")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int LV(String str) {
        Object obj = null;
        if (str != null && str.length() > 0) {
            obj = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (obj == null || obj.length() == 0) {
            obj = "*/" + str;
        }
        int i = -1;
        for (int i2 = 0; i2 < sCF.length; i2++) {
            if (sCF[i2].equals(obj)) {
                i = i2;
            }
        }
        return i != -1 ? sCG[i] : R.k.dto;
    }
}
