package com.tencent.mm.plugin.location.model;

import com.tencent.mm.pluginsdk.m;

public final class f {
    private static double naX = -85.0d;
    private static double naY = -1000.0d;
    private static double naZ = -85.0d;
    private static double nba = -1000.0d;

    public static float r(float f, float f2) {
        if (f < 0.0f || f > 45.0f || f2 < 315.0f || f2 >= 360.0f) {
            return (f < 315.0f || f >= 360.0f || f2 < 0.0f || f2 > 45.0f) ? f2 : f2;
        } else {
            return f2 - 360.0f;
        }
    }

    public static float s(float f, float f2) {
        if ((f < 0.0f || f > 45.0f || f2 < 315.0f || f2 >= 360.0f) && f >= 315.0f && f < 360.0f && f2 >= 0.0f && f2 <= 45.0f) {
            return f - 360.0f;
        }
        return f;
    }

    public static double g(double d, double d2) {
        naZ = d;
        nba = d2;
        double atan2 = (naX == -85.0d || naY == -1000.0d) ? 0.0d : (Math.atan2(nba - naY, naZ - naX) * 180.0d) / 3.141592d;
        naX = naZ;
        naY = nba;
        return atan2;
    }

    public static boolean a(double d, double d2, double d3, double d4, int i, double d5) {
        if (i == 0) {
            if (d5 == 0.0d) {
                return false;
            }
            if (d5 <= 0.0d) {
                return false;
            }
        } else if (i != 1) {
            return false;
        } else {
            Object obj = (d2 == -85.0d || d == -1000.0d) ? null : (d3 == -1000.0d || d4 == -85.0d) ? null : m.d(d2, d, d4, d3) >= 5.0d ? 1 : null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static double i(int i, int i2, int i3, int i4) {
        return Math.sqrt((double) (((i - i3) * (i - i3)) + ((i2 - i4) * (i2 - i4))));
    }

    public static boolean g(double d) {
        return d >= 4.0d;
    }
}
