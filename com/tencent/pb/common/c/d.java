package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class d {
    public static int level = 0;
    private static int wOT = 2;
    private static boolean wOU = false;

    public static void v(boolean z, int i) {
        wOT = 0;
        wOU = true;
    }

    private static void w(int i, String str, String str2) {
        e chK = f.chK();
        if (chK != null) {
            chK.l(i, "MTSDK" + str, str2);
        }
    }

    public static void d(String str, Object... objArr) {
        if (wOU && wOT <= 1 && str != null) {
            w(1, str, " " + x(objArr));
        }
    }

    public static void j(String str, Object... objArr) {
        if (wOU && wOT <= 2) {
            w(2, str, " " + x(objArr));
        }
    }

    public static void k(String str, Object... objArr) {
        if (wOU && wOT <= 3 && str != null) {
            w(3, str, " " + x(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (wOU && wOT <= 4) {
            w(4, str, " " + x(objArr));
        }
    }

    private static String x(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(250);
        for (Object obj : objArr) {
            if (obj != null) {
                stringBuffer.append("|");
                if (obj instanceof Throwable) {
                    stringBuffer.append(((Throwable) obj).getMessage());
                } else {
                    stringBuffer.append(obj.toString());
                }
            }
        }
        return stringBuffer.toString();
    }
}
