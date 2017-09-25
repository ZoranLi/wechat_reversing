package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;

final class h extends g {

    private static class a extends a {
        a(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new h(this, resources);
        }
    }

    h(Drawable drawable) {
        super(drawable);
    }

    h(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public final void setHotspot(float f, float f2) {
        this.mDrawable.setHotspot(f, f2);
    }

    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mDrawable.setHotspotBounds(i, i2, i3, i4);
    }

    public final void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    public final Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (br()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    public final void setTint(int i) {
        if (br()) {
            super.setTint(i);
        } else {
            this.mDrawable.setTint(i);
        }
    }

    public final void setTintMode(Mode mode) {
        if (br()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }

    public final boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    protected final boolean br() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.mDrawable;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable)) {
            return true;
        }
        return false;
    }

    final a bq() {
        return new a(this.tT);
    }
}
