package android.support.b.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.support.v4.b.a.l;
import android.util.AttributeSet;

@TargetApi(21)
abstract class e extends Drawable implements l {
    Drawable mj;

    e() {
    }

    static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.mj != null) {
            this.mj.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.mj != null) {
            return a.f(this.mj);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.mj != null) {
            return this.mj.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mj != null) {
            this.mj.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.mj != null) {
            a.a(this.mj, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.mj != null) {
            a.a(this.mj, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.mj != null) {
            this.mj.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.mj != null) {
            a.b(this.mj);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.mj != null) {
            a.a(this.mj, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.mj != null) {
            a.c(this.mj);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.mj != null) {
            a.a(this.mj, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.mj != null) {
            a.i(this.mj);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.mj != null) {
            this.mj.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.mj != null) {
            return this.mj.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.mj != null) {
            return this.mj.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.mj != null) {
            return this.mj.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.mj != null) {
            return this.mj.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.mj != null) {
            return this.mj.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.mj != null) {
            return this.mj.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.mj != null) {
            this.mj.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.mj != null) {
            return this.mj.setState(iArr);
        }
        return super.setState(iArr);
    }
}
