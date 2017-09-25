package com.tencent.mm.plugin.appbrand.m;

import android.graphics.Color;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    private static DisplayMetrics jnY = ab.getContext().getResources().getDisplayMetrics();

    public static int j(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 3) {
            return 0;
        }
        if (jSONArray.length() == 3) {
            return Color.rgb(jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
        }
        return Color.argb(jSONArray.optInt(3) & 255, jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
    }

    public static int at(String str, int i) {
        try {
            i = qV(str);
        } catch (Exception e) {
        }
        return i;
    }

    public static int qV(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return i;
        }
        if (str.charAt(i) == '#') {
            long parseLong;
            if (str.length() == 7) {
                parseLong = Long.parseLong(str.substring(1), 16) | -16777216;
            } else if (str.length() != 9) {
                throw new IllegalArgumentException("Unknown color");
            } else {
                parseLong = Long.parseLong(str.substring(1, 7), 16) | (Long.parseLong(str.substring(7, 9), 16) << 24);
            }
            return (int) parseLong;
        }
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException e) {
            return i;
        }
    }

    public static int iC(int i) {
        return jnY == null ? i : (int) (((float) i) / jnY.density);
    }

    public static float P(float f) {
        return jnY == null ? f : f / jnY.density;
    }

    public static int iD(int i) {
        return jnY == null ? i : (int) (jnY.density * ((float) i));
    }

    public static int b(JSONObject jSONObject, String str) {
        return a(jSONObject, str, 0);
    }

    public static int a(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null) {
            try {
                i = iD(jSONObject.getInt(str));
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static int a(JSONArray jSONArray, int i) {
        return b(jSONArray, i);
    }

    private static int b(JSONArray jSONArray, int i) {
        int i2 = 0;
        if (jSONArray != null) {
            try {
                i2 = iD(jSONArray.getInt(i));
            } catch (Exception e) {
            }
        }
        return i2;
    }

    public static float c(JSONArray jSONArray, int i) {
        return a(jSONArray, i, 0.0f);
    }

    public static float a(JSONArray jSONArray, int i, float f) {
        if (jSONArray == null) {
            return f;
        }
        try {
            float f2 = (float) jSONArray.getDouble(i);
            return jnY == null ? f2 : jnY.density * f2;
        } catch (Exception e) {
            return f;
        }
    }
}
