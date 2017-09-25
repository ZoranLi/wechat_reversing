package com.tencent.b.a.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import java.util.TimeZone;

final class b {
    static a aPV;
    Integer aPW = null;
    String aPX = null;

    static class a {
        String aPY;
        String aPZ = "2.21";
        DisplayMetrics aQa;
        int aQb = VERSION.SDK_INT;
        String aQc = Build.MANUFACTURER;
        String aQd = Locale.getDefault().getLanguage();
        String aQe = "WX";
        String aQf;
        String aQg;
        int aQh = 0;
        String aQi = null;
        String aQj = null;
        Context ctx = null;
        String imsi;
        String model = Build.MODEL;
        String packageName = null;
        String timezone;

        public a(Context context) {
            this.ctx = context.getApplicationContext();
            try {
                this.aPY = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
            }
            this.aQa = new DisplayMetrics();
            ((WindowManager) this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.aQa);
            if (s.k(context, "android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.aQf = telephonyManager.getSimOperator();
                    this.imsi = telephonyManager.getSubscriberId();
                }
            }
            this.timezone = TimeZone.getDefault().getID();
            this.aQg = s.aa(this.ctx);
            this.packageName = this.ctx.getPackageName();
            this.aQj = s.nU();
        }
    }

    private static synchronized a Q(Context context) {
        a aVar;
        synchronized (b.class) {
            if (aPV == null) {
                aPV = new a(context.getApplicationContext());
            }
            aVar = aPV;
        }
        return aVar;
    }

    public b(Context context) {
        try {
            Q(context);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                this.aPW = Integer.valueOf(telephonyManager.getNetworkType());
            }
            this.aPX = s.ab(context);
        } catch (Throwable th) {
        }
    }
}
