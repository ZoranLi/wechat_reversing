package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.n;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public static void a(View view, JSONObject jSONObject) {
        if (view != null && jSONObject != null) {
            int qV = h.qV(jSONObject.optString("bgColor"));
            int iD = h.iD(jSONObject.optInt("borderRadius"));
            int iD2 = h.iD(jSONObject.optInt("borderWidth"));
            int qV2 = h.qV(jSONObject.optString("borderColor"));
            JSONArray optJSONArray = jSONObject.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                view.setPadding(h.iD(optJSONArray.optInt(3)), h.iD(optJSONArray.optInt(0)), h.iD(optJSONArray.optInt(1)), h.iD(optJSONArray.optInt(2)));
            }
            ShapeDrawable shapeDrawable = null;
            if (iD2 > 0) {
                float f = (float) iD;
                float f2 = (float) iD2;
                shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, new RectF(f2, f2, f2, f2), new float[]{f, f, f, f, f, f, f, f}));
                shapeDrawable.getPaint().setColor(qV2);
            }
            if (shapeDrawable == null) {
                view.setBackground(n.h(qV, (float) iD));
                return;
            }
            view.setBackground(new LayerDrawable(new Drawable[]{n.h(qV, (float) iD), shapeDrawable}));
        }
    }
}
