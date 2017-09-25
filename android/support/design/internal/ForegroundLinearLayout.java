package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import com.tencent.mm.plugin.gif.MMGIFException;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable dH;
    private final Rect dI;
    private final Rect dJ;
    private int dK;
    protected boolean dL;
    boolean dM;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dI = new Rect();
        this.dJ = new Rect();
        this.dK = 119;
        this.dL = true;
        this.dM = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ce, i, 0);
        this.dK = obtainStyledAttributes.getInt(i.cg, this.dK);
        Drawable drawable = obtainStyledAttributes.getDrawable(i.cf);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.dL = obtainStyledAttributes.getBoolean(i.ch, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.dK;
    }

    public void setForegroundGravity(int i) {
        if (this.dK != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 0) {
                i2 |= 48;
            }
            this.dK = i2;
            if (this.dK == 119 && this.dH != null) {
                this.dH.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.dH;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.dH != null) {
            this.dH.jumpToCurrentState();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.dH != null && this.dH.isStateful()) {
            this.dH.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.dH != drawable) {
            if (this.dH != null) {
                this.dH.setCallback(null);
                unscheduleDrawable(this.dH);
            }
            this.dH = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.dK == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.dH;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dM |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dM = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.dH != null) {
            Drawable drawable = this.dH;
            if (this.dM) {
                this.dM = false;
                Rect rect = this.dI;
                Rect rect2 = this.dJ;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.dL) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.dK, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.dH != null) {
            this.dH.setHotspot(f, f2);
        }
    }
}
