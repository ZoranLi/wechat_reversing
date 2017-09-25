package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.b;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MDrawableView extends View implements a {
    private final b iDs = new b(this);
    private final Set<OnAttachStateChangeListener> iDt = new LinkedHashSet();

    public MDrawableView(Context context) {
        super(context);
        setLayerType(1, null);
    }

    public MDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, null);
    }

    public MDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(1, null);
    }

    protected void onDraw(Canvas canvas) {
        b(canvas);
    }

    public final void Rp() {
        postInvalidate();
    }

    public final void j(Runnable runnable) {
        post(runnable);
    }

    public final boolean b(Canvas canvas) {
        return this.iDs.b(canvas);
    }

    public final void d(JSONArray jSONArray) {
        this.iDs.d(jSONArray);
    }

    public final void e(JSONArray jSONArray) {
        this.iDs.e(jSONArray);
    }

    public final void Rq() {
        this.iDs.Rq();
    }

    public final void nU(String str) {
        this.iDs.nU(str);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        if (!this.iDt.contains(onAttachStateChangeListener)) {
            this.iDt.add(onAttachStateChangeListener);
            super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.iDt.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    public final void onPause() {
        this.iDs.onPause();
    }

    public final void onResume() {
        this.iDs.onResume();
    }

    public final boolean isPaused() {
        return this.iDs.iCT;
    }

    public final void nV(String str) {
        this.iDs.iCS = str;
    }

    public final int Rr() {
        return 667;
    }

    public final int Rs() {
        return 668;
    }

    public final void setStartTime(long j) {
        this.iDs.iCW = j;
    }

    public final void Rt() {
        this.iDs.Rt();
    }
}
