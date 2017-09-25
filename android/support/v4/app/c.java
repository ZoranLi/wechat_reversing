package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class c {
    private static final b nL;

    private static class b {
        public String permissionToOp(String str) {
            return null;
        }

        public int a(Context context, String str, String str2) {
            return 1;
        }
    }

    private static class a extends b {
        public final String permissionToOp(String str) {
            return AppOpsManager.permissionToOp(str);
        }

        public final int a(Context context, String str, String str2) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            nL = new a();
        } else {
            nL = new b();
        }
    }

    public static String permissionToOp(String str) {
        return nL.permissionToOp(str);
    }

    public static int a(Context context, String str, String str2) {
        return nL.a(context, str, str2);
    }
}
