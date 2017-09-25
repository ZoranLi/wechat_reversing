package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.canvas.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class e implements c {
    public final String getMethod() {
        return "drawImage";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 3) {
            return false;
        }
        String optString = jSONArray.optString(0);
        float c = h.c(jSONArray, 1);
        float c2 = h.c(jSONArray, 2);
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        Bitmap gN;
        if (optString.startsWith("wxfile://")) {
            AppBrandLocalMediaObject aH = c.aH(dVar.iDc, optString);
            if (aH == null || TextUtils.isEmpty(aH.hos)) {
                return false;
            }
            String str = aH.hos;
            if (!str.startsWith("file://")) {
                str = "file://" + str;
            }
            gN = b.AY().gN(str);
        } else if (optString.startsWith("https://") || optString.startsWith("http://")) {
            Bitmap gN2 = b.AY().gN(optString);
            if (gN2 == null) {
                b.AY().gO(optString);
                gN = gN2;
            } else {
                gN = gN2;
            }
        } else {
            gN = a.aK(dVar.iDc, optString);
        }
        if (gN == null || gN.isRecycled()) {
            return false;
        }
        float iD = (float) h.iD(gN.getWidth());
        float iD2 = (float) h.iD(gN.getHeight());
        if (jSONArray.length() >= 5) {
            iD = h.a(jSONArray, 3, iD);
            iD2 = h.a(jSONArray, 4, iD2);
        }
        canvas.drawBitmap(gN, new Rect(0, 0, gN.getWidth(), gN.getHeight()), new RectF(c, c2, iD + c, iD2 + c2), null);
        return true;
    }
}
