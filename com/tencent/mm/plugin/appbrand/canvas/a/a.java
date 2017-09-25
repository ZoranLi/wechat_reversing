package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;

public final class a implements c {
    public final String getMethod() {
        return "clearRect";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float c = h.c(jSONArray, 0);
        float c2 = h.c(jSONArray, 1);
        float c3 = h.c(jSONArray, 2);
        float c4 = h.c(jSONArray, 3);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof e) {
                e eVar = (e) canvas;
                float f = c + c3;
                float f2 = c2 + c4;
                Bitmap bitmap = eVar.mBitmap;
                RectF rectF = new RectF(c, c2, f, f2);
                RectF rectF2 = new RectF(0.0f, 0.0f, (float) eVar.mBitmap.getWidth(), (float) eVar.mBitmap.getHeight());
                Op op = Op.XOR;
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                canvas2.clipRect(rectF);
                canvas2.clipRect(rectF2, op);
                canvas2.drawBitmap(bitmap, 0.0f, 0.0f, null);
                if (!(createBitmap == null || createBitmap.isRecycled())) {
                    eVar.mBitmap.eraseColor(0);
                    eVar.drawBitmap(createBitmap, 0.0f, 0.0f, null);
                    createBitmap.recycle();
                }
                w.v("MicroMsg.ClearRectAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", new Object[]{Float.valueOf(c), Float.valueOf(c2), Float.valueOf(c3), Float.valueOf(c4)});
                return true;
            } else if (dVar.iDi != null) {
                canvas.drawRect(c, c2, c + c3, c2 + c4, dVar.iDi);
                w.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[]{Float.valueOf(c), Float.valueOf(c2), Float.valueOf(c3), Float.valueOf(c4)});
                return true;
            } else {
                w.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", new Object[]{Float.valueOf(c), Float.valueOf(c2), Float.valueOf(c3), Float.valueOf(c4)});
                return false;
            }
        } else if (dVar.iDi != null) {
            canvas.drawRect(c, c2, c + c3, c2 + c4, dVar.iDi);
            w.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[]{Float.valueOf(c), Float.valueOf(c2), Float.valueOf(c3), Float.valueOf(c4)});
            return true;
        } else {
            canvas.drawRect(c, c2, c + c3, c2 + c4, dVar.iDh);
            w.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", new Object[]{Float.valueOf(c), Float.valueOf(c2), Float.valueOf(c3), Float.valueOf(c4)});
            return true;
        }
    }
}
