package com.tencent.mm.sdk.a;

public final class b {
    public static boolean foreground = false;
    public static String urS = "unknow";
    private static c urT = null;
    private static boolean urU = false;
    private static String urV = null;
    private static boolean urW = false;
    private static boolean urX = false;

    public static void a(c cVar) {
        urT = cVar;
    }

    public static void r(String str, String str2) {
        if (urT != null) {
            urT.r(str, str2);
        }
    }

    public static void h(int i, String str) {
        if (urT != null) {
            urT.h(i, str);
        }
    }

    public static void aX(boolean z) {
        foreground = z;
    }

    public static void Pa(String str) {
        urS = str;
    }

    public static void a(a aVar) {
        if (urT != null) {
            urT.a(aVar);
        }
    }

    public static void jP(boolean z) {
        urW = z;
    }

    public static boolean bIs() {
        return urW;
    }

    public static void bIt() {
        urU = true;
    }

    public static boolean bIu() {
        return urU;
    }

    public static void Pb(String str) {
        urV = str;
    }

    public static String bIv() {
        return urV;
    }

    public static boolean bIw() {
        return urX;
    }

    public static void jQ(boolean z) {
        urX = z;
    }
}
