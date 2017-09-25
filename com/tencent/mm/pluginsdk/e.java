package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.s.a.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.l;

public final class e {
    public static int dr(Context context) {
        int height;
        if (context instanceof MMActivity) {
            l lVar = ((MMActivity) context).uSU;
            height = lVar.Gx == null ? 0 : lVar.Gx.getHeight();
        } else {
            height = 0;
        }
        if (height <= 0) {
            return context.getResources().getDimensionPixelSize(com.tencent.mm.s.a.e.aWS);
        }
        return height;
    }

    public static void R(Activity activity) {
        if (VERSION.SDK_INT < 16) {
            return;
        }
        if (activity instanceof AppCompatActivity) {
            ((AppCompatActivity) activity).aq(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
        } else {
            activity.requestWindowFeature(9);
        }
    }

    public static void f(MMActivity mMActivity) {
        if (VERSION.SDK_INT >= 16) {
            mMActivity.aq(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
        }
    }

    public static void g(final MMActivity mMActivity) {
        if (VERSION.SDK_INT >= 16) {
            mMActivity.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    mMActivity.getWindow().getDecorView().setSystemUiVisibility(mMActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    w.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", Integer.valueOf(a.e(mMActivity)), Integer.valueOf(com.tencent.mm.bg.a.fromDPToPix(mMActivity, 2)));
                    mMActivity.uSU.uTa.setPadding(0, r0 - com.tencent.mm.bg.a.fromDPToPix(mMActivity, 2), 0, 0);
                }
            });
        }
    }

    public static void a(final MMFragmentActivity mMFragmentActivity, final View view) {
        if (VERSION.SDK_INT >= 16) {
            mMFragmentActivity.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    mMFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(mMFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    w.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", Integer.valueOf(a.e(mMFragmentActivity)));
                    if (view != null) {
                        view.setPadding(0, r0, 0, 0);
                    }
                }
            });
        }
    }

    public static int bG(Context context) {
        int i = 0;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(c.actionBarSize, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i > 0) {
            return i;
        }
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return context.getResources().getDimensionPixelSize(com.tencent.mm.s.a.e.aWR);
        }
        return context.getResources().getDimensionPixelSize(com.tencent.mm.s.a.e.aWS);
    }

    public static int ds(Context context) {
        int ab = s.ab(context, -1);
        Rect rect;
        if (ab > 0) {
            rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top > ab ? 0 : ab;
        } else if (!(context instanceof Activity)) {
            return com.tencent.mm.bg.a.fromDPToPix(context, 20);
        } else {
            rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            ab = ((Activity) context).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) context).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (ab - rect.height() < 0 || iArr[1] <= m.CTRL_INDEX) {
                return rect.top;
            }
            return ab - rect.height();
        }
    }
}
