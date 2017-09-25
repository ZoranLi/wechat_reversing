package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ap;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout {
    private Drawable eo;
    private Rect ep;
    private Rect eq;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eq = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cD, i, h.aS);
        this.eo = obtainStyledAttributes.getDrawable(i.cE);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        z.b((View) this, new t(this) {
            final /* synthetic */ ScrimInsetsFrameLayout er;

            {
                this.er = r1;
            }

            public final ap a(View view, ap apVar) {
                if (this.er.ep == null) {
                    this.er.ep = new Rect();
                }
                this.er.ep.set(apVar.getSystemWindowInsetLeft(), apVar.getSystemWindowInsetTop(), apVar.getSystemWindowInsetRight(), apVar.getSystemWindowInsetBottom());
                this.er.a(this.er.ep);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.er;
                boolean z = this.er.ep.isEmpty() || this.er.eo == null;
                scrimInsetsFrameLayout.setWillNotDraw(z);
                z.F(this.er);
                return apVar.ca();
            }
        });
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.ep != null && this.eo != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.eq.set(0, 0, width, this.ep.top);
            this.eo.setBounds(this.eq);
            this.eo.draw(canvas);
            this.eq.set(0, height - this.ep.bottom, width, height);
            this.eo.setBounds(this.eq);
            this.eo.draw(canvas);
            this.eq.set(0, this.ep.top, this.ep.left, height - this.ep.bottom);
            this.eo.setBounds(this.eq);
            this.eo.draw(canvas);
            this.eq.set(width - this.ep.right, this.ep.top, width, height - this.ep.bottom);
            this.eo.setBounds(this.eq);
            this.eo.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eo != null) {
            this.eo.setCallback(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eo != null) {
            this.eo.setCallback(null);
        }
    }

    public void a(Rect rect) {
    }
}
