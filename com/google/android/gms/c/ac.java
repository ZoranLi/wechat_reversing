package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ac {
    private static final Method aAq = kW();
    private static final Method aAr = kX();
    private static final Method aAs = kY();
    private static final Method aAt = kZ();
    private static final Method aAu = la();

    public static boolean L(Context context) {
        return context.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    private static int a(WorkSource workSource) {
        if (aAs != null) {
            try {
                return ((Integer) aAs.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return 0;
    }

    private static String a(WorkSource workSource, int i) {
        if (aAu != null) {
            try {
                return (String) aAu.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return null;
    }

    private static WorkSource b(int i, String str) {
        WorkSource workSource = new WorkSource();
        if (aAr != null) {
            if (str == null) {
                str = "";
            }
            try {
                aAr.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        } else if (aAq != null) {
            try {
                aAq.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return workSource;
    }

    public static List<String> b(WorkSource workSource) {
        int i = 0;
        int a = workSource == null ? 0 : a(workSource);
        if (a == 0) {
            return Collections.EMPTY_LIST;
        }
        List<String> arrayList = new ArrayList();
        while (i < a) {
            String a2 = a(workSource, i);
            if (!ab.ah(a2)) {
                arrayList.add(a2);
            }
            i++;
        }
        return arrayList;
    }

    public static WorkSource i(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            return applicationInfo != null ? b(applicationInfo.uid, str) : null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private static Method kW() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method kX() {
        Method method = null;
        if (z.cc(18)) {
            try {
                method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        return method;
    }

    private static Method kY() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
        }
        return method;
    }

    private static Method kZ() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method la() {
        Method method = null;
        if (z.cc(18)) {
            try {
                method = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        return method;
    }
}
