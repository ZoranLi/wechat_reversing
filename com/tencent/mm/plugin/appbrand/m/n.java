package com.tencent.mm.plugin.appbrand.m;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

public final class n {
    public static ShapeDrawable h(int i, float f) {
        float[] fArr = new float[]{f, f, f, f, f, f, f, f};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }
}
