package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.x;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;

public enum g {
    ;
    
    private static final Method jkT = null;

    public static Drawable c(Context context, int i, int i2) {
        Bitmap decodeResource = a.decodeResource(context.getResources(), i);
        if (decodeResource == null) {
            return null;
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), decodeResource);
        bitmapDrawable.setColorFilter(i2, Mode.SRC_ATOP);
        return bitmapDrawable;
    }

    public static void r(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    public static i bA(final Context context) {
        View inflate = View.inflate(context, R.i.cUM, null);
        final i iVar = new i(context, R.m.foq);
        iVar.setContentView(inflate);
        iVar.setCancelable(true);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (context instanceof MMActivity) {
                    ((MMActivity) context).finish();
                }
                iVar.setOnCancelListener(null);
            }
        });
        return iVar;
    }

    public static int[] Xf() {
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        return r1;
    }

    public static int g(int i, float f) {
        return d.d(i, WebView.NIGHT_MODE_COLOR, f);
    }

    public static void a(Window window) {
        x.a(window);
    }

    public static void a(Window window, boolean z) {
        if (window != null && window.getDecorView() != null && VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= 8192;
            } else {
                systemUiVisibility &= -8193;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
    }

    public static boolean b(Window window) {
        if (window == null || window.getDecorView() == null || VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & 8192) == 0) {
            return false;
        }
        return true;
    }

    private static boolean r(Activity activity) {
        try {
            Method method = jkT;
            if (method != null) {
                method.setAccessible(true);
                return ((Boolean) method.invoke(activity, new Object[0])).booleanValue();
            }
            w.d("MicroMsg.AppBrandUIUtil", "isInMultiWindowMode method null");
            return false;
        } catch (Exception e) {
            w.d("MicroMsg.AppBrandUIUtil", "isInMultiWindowMode, exp %s", new Object[]{e});
        }
    }

    public static Activity bB(Context context) {
        Context context2;
        if (context == null || !(context instanceof ContextWrapper) || (context instanceof Activity)) {
            context2 = context;
        } else {
            context2 = ((ContextWrapper) context).getBaseContext();
        }
        return context2 instanceof Activity ? (Activity) context2 : null;
    }

    public static boolean bF(View view) {
        if (VERSION.SDK_INT < 24) {
            return false;
        }
        if (view == null) {
            return false;
        }
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (context instanceof Activity) && r((Activity) context);
    }

    public static int WW() {
        return s.ab(ab.getContext(), com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 25));
    }

    public static boolean sf() {
        return h.sf();
    }
}
