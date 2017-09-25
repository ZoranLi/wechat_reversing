package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class d extends Drawable implements Callback, c, l {
    static final Mode mk = Mode.SRC_IN;
    Drawable mDrawable;
    private boolean mo;
    private int tQ;
    private Mode tR;
    private boolean tS;
    a tT;

    protected static abstract class a extends ConstantState {
        int ma;
        ColorStateList nk = null;
        Mode nl = d.mk;
        ConstantState tU;

        public abstract Drawable newDrawable(Resources resources);

        a(a aVar) {
            if (aVar != null) {
                this.ma = aVar.ma;
                this.tU = aVar.tU;
                this.nk = aVar.nk;
                this.nl = aVar.nl;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.tU != null ? this.tU.getChangingConfigurations() : 0) | this.ma;
        }
    }

    private static class b extends a {
        b(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d(a aVar, Resources resources) {
        this.tT = aVar;
        if (this.tT != null && this.tT.tU != null) {
            j(a(this.tT.tU, resources));
        }
    }

    d(Drawable drawable) {
        this.tT = bq();
        j(drawable);
    }

    protected Drawable a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.mDrawable.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.tT != null ? this.tT.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!br() || this.tT == null) ? null : this.tT.nk;
        return (colorStateList != null && colorStateList.isStateful()) || this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return c(iArr) || this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.tT != null) {
            if ((this.tT.tU != null ? 1 : null) != null) {
                this.tT.ma = getChangingConfigurations();
                return this.tT;
            }
        }
        return null;
    }

    public Drawable mutate() {
        if (!this.mo && super.mutate() == this) {
            this.tT = bq();
            if (this.mDrawable != null) {
                this.mDrawable.mutate();
            }
            if (this.tT != null) {
                this.tT.tU = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
            }
            this.mo = true;
        }
        return this;
    }

    a bq() {
        return new b(this.tT);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.mDrawable.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.tT.nk = colorStateList;
        c(getState());
    }

    public void setTintMode(Mode mode) {
        this.tT.nl = mode;
        c(getState());
    }

    private boolean c(int[] iArr) {
        if (!br()) {
            return false;
        }
        ColorStateList colorStateList = this.tT.nk;
        Mode mode = this.tT.nl;
        if (colorStateList == null || mode == null) {
            this.tS = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.tS && colorForState == this.tQ && mode == this.tR) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.tQ = colorForState;
        this.tR = mode;
        this.tS = true;
        return true;
    }

    public final Drawable bp() {
        return this.mDrawable;
    }

    public final void j(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.tT != null) {
                this.tT.tU = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean br() {
        return true;
    }
}
