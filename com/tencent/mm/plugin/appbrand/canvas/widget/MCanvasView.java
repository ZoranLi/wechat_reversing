package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MCanvasView extends View implements a {
    private final b iDs = new b(this);
    private final Set<OnAttachStateChangeListener> iDt = new LinkedHashSet();
    private Bitmap mBitmap;

    public MCanvasView(Context context) {
        super(context);
    }

    public MCanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mBitmap.getWidth() != measuredWidth || this.mBitmap.getHeight() != measuredHeight) {
                if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.mBitmap.recycle();
                }
                this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
                w.v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
            }
            if (this.mBitmap == null) {
                w.d("MicroMsg.MCanvasView", "bitmap is null.");
                return;
            }
            this.mBitmap.eraseColor(0);
            Canvas eVar = new e(this.mBitmap);
            b(eVar);
            canvas.drawBitmap(eVar.mBitmap, 0.0f, 0.0f, null);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            this.mBitmap.recycle();
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            w.v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
        }
    }

    public final boolean b(Canvas canvas) {
        return this.iDs.b(canvas);
    }

    public final void Rp() {
        postInvalidate();
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

    public final void j(Runnable runnable) {
        post(runnable);
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
        return 685;
    }

    public final int Rs() {
        return 684;
    }

    public final void setStartTime(long j) {
        this.iDs.iCW = j;
    }

    public final void Rt() {
        this.iDs.Rt();
    }
}
