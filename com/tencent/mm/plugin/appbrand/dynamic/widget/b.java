package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;

public final class b {
    private static volatile boolean hbg = false;
    public static volatile int iJy = 0;

    public static void initialize() {
        a.post(new Runnable() {
            public final void run() {
                com.tencent.mm.ipcinvoker.wx_extension.a.a.uw();
                c dX = com.tencent.mm.ipcinvoker.wx_extension.a.a.dX("100284");
                if (dX == null) {
                    w.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
                } else if (dX.isValid()) {
                    try {
                        b.hH(bg.getInt((String) dX.bKK().get("mode"), 0));
                        w.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[]{Integer.valueOf(b.iJy)});
                    } catch (Throwable e) {
                        w.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[]{Log.getStackTraceString(e)});
                    }
                } else {
                    w.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is invalid.");
                }
            }
        });
    }

    public static void hH(int i) {
        iJy = i;
        hbg = true;
    }

    public static int Sp() {
        return iJy;
    }

    public static View aR(Context context) {
        if (!hbg) {
            initialize();
        }
        w.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", new Object[]{Integer.valueOf(iJy)});
        switch (iJy) {
            case 1:
                return new MTextureView(context);
            case 2:
                return new MSurfaceView(context);
            case 3:
                return new MCanvasView(context);
            case 4:
                return new MDrawableView(context);
            default:
                return new MHardwareAccelerateDrawableView(context);
        }
    }

    public static String Sq() {
        switch (iJy) {
            case 1:
                return "MTextureView";
            case 2:
                return "MSurfaceView";
            case 3:
                return "MCanvasView";
            case 4:
                return "MDrawableView";
            default:
                return "MHADrawableView";
        }
    }
}
