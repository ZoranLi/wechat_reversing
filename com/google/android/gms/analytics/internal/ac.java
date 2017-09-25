package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.c.aa;
import com.google.android.gms.common.internal.w;
import java.util.HashSet;
import java.util.Set;

public final class ac {
    private final q ajB;
    private volatile Boolean ajC;
    private String ajD;
    private Set<Integer> ajE;

    protected ac(q qVar) {
        w.Z(qVar);
        this.ajB = qVar;
    }

    public static boolean iK() {
        return ((Boolean) aj.ajP.get()).booleanValue();
    }

    public static int iL() {
        return ((Integer) aj.akm.get()).intValue();
    }

    public static long iM() {
        return ((Long) aj.ajX.get()).longValue();
    }

    public static long iN() {
        return ((Long) aj.aka.get()).longValue();
    }

    public static int iO() {
        return ((Integer) aj.akc.get()).intValue();
    }

    public static int iP() {
        return ((Integer) aj.akd.get()).intValue();
    }

    public static String iQ() {
        return (String) aj.akf.get();
    }

    public static String iR() {
        return (String) aj.ake.get();
    }

    public static String iS() {
        return (String) aj.akg.get();
    }

    public static long iU() {
        return ((Long) aj.aku.get()).longValue();
    }

    public final boolean iJ() {
        if (this.ajC == null) {
            synchronized (this) {
                if (this.ajC == null) {
                    ApplicationInfo applicationInfo = this.ajB.mContext.getApplicationInfo();
                    String m = aa.m(this.ajB.mContext, Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(m);
                        this.ajC = Boolean.valueOf(z);
                    }
                    if ((this.ajC == null || !this.ajC.booleanValue()) && "com.google.android.gms.analytics".equals(m)) {
                        this.ajC = Boolean.TRUE;
                    }
                    if (this.ajC == null) {
                        this.ajC = Boolean.TRUE;
                        this.ajB.ig().G("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.ajC.booleanValue();
    }

    public final Set<Integer> iT() {
        String str = (String) aj.akp.get();
        if (this.ajE == null || this.ajD == null || !this.ajD.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.ajD = str;
            this.ajE = hashSet;
        }
        return this.ajE;
    }
}
