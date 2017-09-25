package com.tencent.mm.svg.b;

import java.lang.reflect.Field;

public final class b {
    private static String fwY = "";
    private static boolean gZN = false;
    private static boolean uNw = false;
    private static boolean uNx = false;

    public static void bl(String str) {
        fwY = str;
    }

    public static final boolean bNZ() {
        return uNx;
    }

    public static final void kb(boolean z) {
        uNx = z;
    }

    private static final Object Sw(String str) {
        try {
            Class cls = Class.forName(fwY + ".svg.SVGBuildConfig");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (Throwable e) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e, "NoSuchFieldException", new Object[0]);
            return null;
        } catch (Throwable e2) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e2, "IllegalArgumentException", new Object[0]);
            return null;
        } catch (Throwable e22) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e22, "ClassNotFoundException", new Object[0]);
            return null;
        } catch (Throwable e222) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e222, "IllegalAccessException", new Object[0]);
            return null;
        }
    }

    public static final boolean bOa() {
        if (!gZN) {
            Object Sw = Sw("WxSVGCode");
            if (Sw == null) {
                uNw = false;
            } else {
                uNw = ((Boolean) Sw).booleanValue();
            }
            c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", Boolean.valueOf(uNw));
            gZN = true;
        }
        if (uNw) {
            return false;
        }
        return true;
    }

    public static final Class<?> bOb() {
        Object Sw = Sw("WxSVGRawClass");
        if (Sw != null) {
            return (Class) Sw;
        }
        return null;
    }

    public static long bOc() {
        return System.nanoTime();
    }

    public static long eD(long j) {
        return (System.nanoTime() - j) / 1000;
    }
}
