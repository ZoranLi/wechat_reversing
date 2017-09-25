package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends a {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    public final void a(final m mVar, final JSONObject jSONObject, final int i) {
        af.f(new Runnable(this) {
            final /* synthetic */ o iLm;

            public final void run() {
                d.vL().D(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 iLn;

                    {
                        this.iLn = r1;
                    }

                    public final void run() {
                        this.iLn.iLm.b(mVar, jSONObject, i);
                    }
                });
            }
        }, 100);
    }

    public final void b(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
            mVar.x(i, d("fail", null));
            return;
        }
        try {
            int i2 = jSONObject.getInt("canvasId");
            View il = b.jdc.il(i2);
            if (il == null) {
                w.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", new Object[]{Integer.valueOf(i2)});
                mVar.x(i, d("fail:get canvas by canvasId failed", null));
                return;
            }
            int measuredWidth = il.getMeasuredWidth();
            int measuredHeight = il.getMeasuredHeight();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
                int b2 = h.b(jSONObject, "x");
                int b3 = h.b(jSONObject, "y");
                int a = h.a(jSONObject, "width", measuredWidth);
                int a2 = h.a(jSONObject, "height", measuredHeight);
                if (b2 + a > measuredWidth) {
                    a = measuredWidth - b2;
                }
                if (b3 + a2 > measuredHeight) {
                    a2 = measuredHeight - b3;
                }
                int optInt = jSONObject.optInt("destWidth", a);
                int optInt2 = jSONObject.optInt("destHeight", a2);
                if (b2 < 0 || b3 < 0 || a <= 0 || a2 <= 0 || b2 + a > measuredWidth || b3 + a2 > measuredHeight || optInt <= 0 || optInt2 <= 0) {
                    w.e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", new Object[]{Integer.valueOf(b2), Integer.valueOf(b3), Integer.valueOf(a), Integer.valueOf(a2), Integer.valueOf(i2)});
                    mVar.x(i, d("fail:illegal arguments", null));
                    return;
                }
                Bitmap createBitmap2;
                if (il instanceof a) {
                    ((a) il).b(new e(createBitmap));
                } else {
                    il.draw(new e(createBitmap));
                }
                if (!(a == measuredWidth && a2 == measuredHeight)) {
                    createBitmap2 = Bitmap.createBitmap(createBitmap, b2, b3, a, a2, null, false);
                    createBitmap.recycle();
                    createBitmap = createBitmap2;
                }
                if (!(a == optInt && a2 == optInt2)) {
                    createBitmap2 = Bitmap.createScaledBitmap(createBitmap, optInt, optInt2, false);
                    createBitmap.recycle();
                    createBitmap = createBitmap2;
                }
                String aC = c.aC(b.ivH, "canvas_" + i2);
                try {
                    com.tencent.mm.sdk.platformtools.d.a(createBitmap, 100, CompressFormat.PNG, aC, true);
                    AppBrandLocalMediaObject b4 = c.b(b.ivH, aC, "png", true);
                    if (b4 == null) {
                        w.w("MicroMsg.JsApiCanvasToTempFilePath", "gen temp file failed, canvasId : %s.", new Object[]{Integer.valueOf(i2)});
                        mVar.x(i, d("fail:gen temp file failed", null));
                        return;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("tempFilePath", b4.fJz);
                    mVar.x(i, d("ok", hashMap));
                    w.v("MicroMsg.JsApiCanvasToTempFilePath", "save file(id : %s) to path : %s", new Object[]{b4.fJz, b4.hos});
                } catch (IOException e) {
                    w.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", new Object[]{Integer.valueOf(i2), e});
                    mVar.x(i, d("fail:write file failed", null));
                }
            } catch (Exception e2) {
                w.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[]{Integer.valueOf(i2), e2});
                mVar.x(i, d("fail:create bitmap failed", null));
            }
        } catch (JSONException e3) {
            w.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", new Object[]{e3});
            mVar.x(i, d("fail:canvasId do not exist", null));
        }
    }
}
