package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class j {
    private static int gSS = -1;
    private static int gST = -1;
    private static boolean gSU = false;
    private static int gSV = -1;
    private static int gSW = -1;

    public static void sg() {
        gSU = false;
    }

    public static final int c(Context context, boolean z) {
        if (gSU) {
            return aC(context);
        }
        if (gSS > 0 && z) {
            return gSS;
        }
        if (gSU) {
            return aC(context);
        }
        if (!aE(context)) {
            return ab.bIY().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
        }
        int i = ab.bIY().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(context, cs.CTRL_INDEX));
        gSS = i;
        return i;
    }

    @TargetApi(11)
    public static final void f(Activity activity) {
        if (activity != null) {
            int height;
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            if (activity instanceof AppCompatActivity) {
                if (((AppCompatActivity) activity).cO().cP() != null) {
                    height = ((AppCompatActivity) activity).cO().cP().getHeight();
                }
                height = a.e(activity);
            } else {
                if (activity.getActionBar() != null) {
                    height = activity.getActionBar().getHeight();
                }
                height = a.e(activity);
            }
            gST = (activity.getResources().getDisplayMetrics().heightPixels - height) - i;
        }
    }

    public static final int sh() {
        return gST;
    }

    public static final boolean o(Context context, int i) {
        if (gSS == i) {
            return true;
        }
        if (!aE(context)) {
            return false;
        }
        if (i < 0) {
            return false;
        }
        gSS = i;
        w.d("MicroMsg.KeyBordUtil", "save keybord: %d", Integer.valueOf(i));
        return ab.bIY().edit().putInt("com.tencent.mm.compatible.util.keybord.height", i).commit();
    }

    public static final int aB(Context context) {
        if (gSU) {
            return aC(context);
        }
        if (gSV > 0) {
            return gSV;
        }
        if (!aE(context)) {
            return 1140;
        }
        int fromDPToPix = a.fromDPToPix(context, 380);
        gSV = fromDPToPix;
        return fromDPToPix;
    }

    public static final int aC(Context context) {
        if (gSW > 0) {
            return gSW;
        }
        if (!aE(context)) {
            return gSW * 3;
        }
        int fromDPToPix = a.fromDPToPix(context, cs.CTRL_INDEX);
        gSW = fromDPToPix;
        return fromDPToPix;
    }

    public static final int p(Context context, int i) {
        int aC = aC(context);
        int aB;
        if (aF(context)) {
            if (i <= 0) {
                i = c(context, true);
            }
            aB = aB(context);
            if (i > aB) {
                return aB;
            }
            if (i < aC) {
                return aC;
            }
            return i;
        }
        aB = (int) (((double) aC) / 1.5d);
        aC = aG(context)[0];
        if (aB > aC / 2) {
            return aC / 2;
        }
        return aB;
    }

    public static final int aD(Context context) {
        return p(context, -1);
    }

    private static final boolean aE(Context context) {
        if (context == null) {
            context = ab.getContext();
        }
        return context != null;
    }

    public static boolean aF(Context context) {
        int[] aG = aG(context);
        return aG[0] < aG[1] ? true : true;
    }

    public static int[] aG(Context context) {
        Context context2;
        if (context == null) {
            context2 = ab.getContext();
        } else {
            context2 = context;
        }
        int[] iArr = new int[2];
        if (context2 instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context2).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public static int g(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }
}
