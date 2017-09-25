package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class q {
    public static boolean e(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.ApplicationUtil", "install app failed: " + uri.toString() + ", ex = " + e.getMessage());
            return false;
        }
    }

    public static boolean aS(Context context, String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (az(context, "com.android.vending") != null) {
            w.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", str);
            intent.setPackage("com.android.vending");
        } else {
            w.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", str);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", e.getMessage());
            try {
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                w.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", e2.getMessage());
                return false;
            }
        }
    }

    private static PackageInfo az(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str.length() == 0) {
            w.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
                w.w("MicroMsg.ApplicationUtil", "app not installed, packageName = " + str);
            }
        }
        return packageInfo;
    }

    public static String Ml(String str) {
        String str2 = null;
        if (!bg.mA(str)) {
            try {
                w.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", str, ab.getContext().getPackageManager().getPackageArchiveInfo(str, 0).packageName);
                str2 = r1.packageName;
            } catch (Exception e) {
                w.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", e.getMessage());
            }
        }
        return str2;
    }

    public static int Mm(String str) {
        int i = 0;
        if (!bg.mA(str)) {
            try {
                w.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", str, Integer.valueOf(ab.getContext().getPackageManager().getPackageArchiveInfo(str, 0).versionCode));
                i = r1.versionCode;
            } catch (Exception e) {
                w.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", e.getMessage());
            }
        }
        return i;
    }
}
