package com.tencent.mm.plugin.normsg.utils;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Set;
import java.util.TreeSet;

public final class NativeLogic {

    public enum a implements com.tencent.mm.plugin.normsg.a.a {
        ;

        private a(String str) {
        }

        public final void qy(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                NativeLogic.checkMsgLevel();
            }
        }

        public final void qz(int i) {
            String str = ab.getContext().getApplicationInfo().sourceDir;
            h.vG();
            int uH = com.tencent.mm.kernel.a.uH();
            for (int i2 = 0; i2 < i; i2++) {
                NativeLogic.checkSoftType(str, uH);
            }
        }

        public final void qA(int i) {
            Context context = ab.getContext();
            String str = context.getApplicationInfo().sourceDir;
            h.vG();
            int uH = com.tencent.mm.kernel.a.uH();
            for (int i2 = 0; i2 < i; i2++) {
                NativeLogic.checkSoftType2(context, str, uH);
            }
        }

        public final void qB(int i) {
            Context context = ab.getContext();
            for (int i2 = 0; i2 < i; i2++) {
                NativeLogic.checkSoftType3(context);
            }
        }

        public final void qC(int i) {
            int i2 = 0;
            Context context = ab.getContext();
            Set treeSet = new TreeSet();
            for (int i3 = 0; i3 < i; i3++) {
                treeSet.clear();
                NativeLogic.checkSoftType4(context, treeSet, false);
            }
            Toast.makeText(context, treeSet.toString(), 1).show();
            while (i2 < i) {
                treeSet.clear();
                NativeLogic.checkSoftType4(context, treeSet, true);
                i2++;
            }
            Toast.makeText(context, treeSet.toString(), 1).show();
        }

        public final void qD(int i) {
            Context context = ab.getContext();
            for (int i2 = 0; i2 < i; i2++) {
                Toast.makeText(context, String.valueOf(NativeLogic.checkSoftType5()), 1).show();
            }
        }

        public final void qE(int i) {
            Context context = ab.getContext();
            for (int i2 = 0; i2 < i; i2++) {
                Toast.makeText(context, String.valueOf(NativeLogic.checkSoftType6(",")), 1).show();
            }
        }

        public final void qF(int i) {
            Context context = ab.getContext();
            for (int i2 = 0; i2 < i; i2++) {
                Toast.makeText(context, String.valueOf(NativeLogic.checkSoftType7()), 1).show();
            }
        }
    }

    public static native boolean checkMsgLevel();

    public static native byte[] checkSoftType(String str, int i);

    public static native byte[] checkSoftType2(Context context, String str, int i);

    public static native byte[] checkSoftType3(Context context);

    public static native void checkSoftType4(Context context, Set<String> set, boolean z);

    public static native long checkSoftType5();

    public static native String checkSoftType6(String str);

    public static native boolean checkSoftType7();

    private static native boolean secretMsgCheck(Object obj, Class cls);

    private static native int setLog(int i);

    public static boolean aPk() {
        long nanoTime = System.nanoTime();
        boolean checkMsgLevel = checkMsgLevel();
        w.i("MicroMsg.NativeLogic", "call checkMsgLevel, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        c.oTb.c(415, 1, 2, (int) r8, false);
        return checkMsgLevel;
    }

    public static byte[] bt(String str, int i) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType = checkSoftType(str, i);
        w.i("MicroMsg.NativeLogic", "call checkSoftType, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        c.oTb.c(415, 4, 5, (int) r8, false);
        return checkSoftType;
    }

    public static byte[] f(Context context, String str, int i) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType2 = checkSoftType2(context, str, i);
        w.i("MicroMsg.NativeLogic", "call checkSoftType2, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        c.oTb.c(415, 7, 8, (int) r8, false);
        return checkSoftType2;
    }

    public static byte[] cG(Context context) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType3 = checkSoftType3(context);
        w.i("MicroMsg.NativeLogic", "call checkSoftType3, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        c.oTb.c(415, 10, 11, (int) r8, false);
        return checkSoftType3;
    }

    public static void a(Context context, Set<String> set, boolean z) {
        long nanoTime = System.nanoTime();
        checkSoftType4(context, set, z);
        w.i("MicroMsg.NativeLogic", "call checkSoftType4, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        c.oTb.c(415, 13, 14, (int) r6, false);
    }

    public static long aPm() {
        long nanoTime = System.nanoTime();
        long checkSoftType5 = checkSoftType5();
        w.i("MicroMsg.NativeLogic", "call checkSoftType5, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        c.oTb.c(415, 16, 17, (int) r8, false);
        return checkSoftType5;
    }

    public static String BQ(String str) {
        long nanoTime = System.nanoTime();
        String checkSoftType6 = checkSoftType6(str);
        w.i("MicroMsg.NativeLogic", "call checkSoftType6, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        c.oTb.c(415, 19, 20, (int) r8, false);
        return checkSoftType6;
    }

    public static boolean a(Object obj, Class cls) {
        return secretMsgCheck(obj, cls);
    }

    public static boolean aPn() {
        long nanoTime = System.nanoTime();
        boolean checkSoftType7 = checkSoftType7();
        w.i("MicroMsg.NativeLogic", "call checkSoftType7, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        c.oTb.c(415, 22, 23, (int) r8, false);
        return checkSoftType7;
    }

    static {
        k.b("wechatnormsg", NativeLogic.class.getClassLoader());
    }
}
