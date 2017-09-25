package com.tencent.mm.bg;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private static float density = -1.0f;
    private static float omC = 0.0f;
    private static a upl = null;
    private static SparseIntArray upm = new SparseIntArray();

    public interface a {
        ColorStateList bHA();

        Drawable bHB();

        int bHC();

        String bHD();

        int bHz();
    }

    public static int b(Context context, int i) {
        if (upl != null) {
            return upl.bHz();
        }
        if (context != null) {
            return context.getResources().getColor(i);
        }
        w.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i));
        return 0;
    }

    public static ColorStateList S(Context context, int i) {
        if (upl != null) {
            return upl.bHA();
        }
        if (context != null) {
            return context.getResources().getColorStateList(i);
        }
        w.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static Drawable a(Context context, int i) {
        if (upl != null) {
            return upl.bHB();
        }
        if (context != null) {
            return context.getResources().getDrawable(i);
        }
        w.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static int T(Context context, int i) {
        float f = 1.625f;
        float f2 = omC;
        if (f2 <= 1.625f) {
            f = f2;
        }
        int i2;
        if (upl != null) {
            i2 = upm.get(i, 0);
            if (i2 == 0) {
                i2 = upl.bHC();
                upm.put(i, i2);
            }
            return (int) (f * ((float) i2));
        } else if (context == null) {
            w.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = upm.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                upm.put(i, i2);
            }
            return (int) (f * ((float) i2));
        }
    }

    public static int U(Context context, int i) {
        int i2;
        if (upl != null) {
            i2 = upm.get(i, 0);
            if (i2 != 0) {
                return i2;
            }
            i2 = upl.bHC();
            upm.put(i, i2);
            return i2;
        } else if (context == null) {
            w.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = upm.get(i, 0);
            if (i2 != 0) {
                return i2;
            }
            i2 = context.getResources().getDimensionPixelSize(i);
            upm.put(i, i2);
            return i2;
        }
    }

    public static String V(Context context, int i) {
        if (upl != null) {
            return upl.bHD();
        }
        if (context != null) {
            return context.getResources().getString(i);
        }
        w.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i));
        return "";
    }

    public static float getDensity(Context context) {
        if (context == null) {
            context = ab.getContext();
        }
        if (density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int fromDPToPix(Context context, int i) {
        return Math.round(getDensity(context) * ((float) i));
    }

    public static int W(Context context, int i) {
        return Math.round(((float) i) / getDensity(context));
    }

    public static float dI(Context context) {
        if (omC == 0.0f) {
            if (context == null) {
                omC = 1.0f;
            } else {
                omC = context.getSharedPreferences(ab.bIX(), 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        return omC;
    }

    public static int dJ(Context context) {
        float dI = dI(context);
        if (dI == 0.875f) {
            return 1;
        }
        if (dI == 1.0f) {
            return 2;
        }
        if (dI == 1.125f) {
            return 3;
        }
        if (dI == 1.25f) {
            return 4;
        }
        if (dI == 1.375f) {
            return 5;
        }
        if (dI == 1.625f) {
            return 6;
        }
        if (dI == 1.875f) {
            return 7;
        }
        if (dI == 2.025f) {
            return 8;
        }
        return 2;
    }

    public static float dK(Context context) {
        if (dM(context)) {
            return 1.3f;
        }
        return 1.0f;
    }

    public static float dL(Context context) {
        if (dM(context)) {
            return 1.2f;
        }
        return 1.0f;
    }

    public static void e(Context context, float f) {
        Editor edit = context.getSharedPreferences(ab.bIX(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        omC = f;
    }

    public static boolean dM(Context context) {
        float dI = dI(context);
        omC = dI;
        return Float.compare(dI, 1.125f) > 0;
    }

    public static boolean dN(Context context) {
        float dI = dI(context);
        omC = dI;
        if (dI == 0.875f) {
            return true;
        }
        return false;
    }

    public static int dO(Context context) {
        if (upl != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        w.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
        return 0;
    }

    public static int dP(Context context) {
        if (upl != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        w.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
        return 0;
    }
}
