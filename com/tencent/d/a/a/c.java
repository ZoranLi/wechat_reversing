package com.tencent.d.a.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;

public final class c {
    public static boolean cfH() {
        return VERSION.SDK_INT >= 23;
    }

    static int hj(Context context) {
        Integer valueOf = Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getInt("key_fail_times", 0));
        com.tencent.d.a.c.c.i("Soter.SoterAntiBruteForceStrategy", "soter: current retry time: " + valueOf, new Object[0]);
        return valueOf.intValue();
    }

    static void am(Context context, int i) {
        com.tencent.d.a.c.c.i("Soter.SoterAntiBruteForceStrategy", "soter: setting to time: " + i, new Object[0]);
        if (i < 0) {
            com.tencent.d.a.c.c.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
        } else if (context == null) {
            com.tencent.d.a.c.c.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
        } else {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putInt("key_fail_times", i);
            edit.apply();
        }
    }

    private static void q(Context context, long j) {
        com.tencent.d.a.c.c.i("Soter.SoterAntiBruteForceStrategy", "soter: setting last freeze time: " + j, new Object[0]);
        if (j < -1) {
            com.tencent.d.a.c.c.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
        } else if (context == null) {
            com.tencent.d.a.c.c.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
        } else {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("key_last_freeze_time", j);
            edit.apply();
        }
    }

    static void hk(Context context) {
        am(context, 6);
        q(context, System.currentTimeMillis());
    }

    static void hl(Context context) {
        q(context, -1);
        am(context, 0);
    }

    public static boolean hm(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Long valueOf = Long.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getLong("key_last_freeze_time", -1));
        com.tencent.d.a.c.c.i("Soter.SoterAntiBruteForceStrategy", "soter: current last freeze time: " + valueOf, new Object[0]);
        int longValue = (int) ((currentTimeMillis - valueOf.longValue()) / 1000);
        com.tencent.d.a.c.c.i("Soter.SoterAntiBruteForceStrategy", "soter: tween sec after last freeze: " + longValue, new Object[0]);
        if (longValue <= 30) {
            return false;
        }
        com.tencent.d.a.c.c.d("Soter.SoterAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
        return true;
    }

    public static boolean hn(Context context) {
        if (hj(context) >= 5) {
            return false;
        }
        com.tencent.d.a.c.c.i("Soter.SoterAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
        return true;
    }
}
