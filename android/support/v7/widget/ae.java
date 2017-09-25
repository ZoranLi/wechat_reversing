package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class ae extends Drawable {
    boolean abA = false;
    boolean abB = true;
    float abw;
    private final RectF abx;
    private final Rect aby;
    float abz;
    private final Paint fu;
    private PorterDuffColorFilter mm;
    private ColorStateList nk;
    private Mode nl;

    public ae(int i, float f) {
        this.abw = f;
        this.fu = new Paint(5);
        this.fu.setColor(i);
        this.abx = new RectF();
        this.aby = new Rect();
    }

    public final void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.fu;
        if (this.mm == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.mm);
            obj = 1;
        }
        canvas.drawRoundRect(this.abx, this.abw, this.abw, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    final void f(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.abx.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.aby.set(rect);
        if (this.abA) {
            float a = af.a(this.abz, this.abw, this.abB);
            this.aby.inset((int) Math.ceil((double) af.b(this.abz, this.abw, this.abB)), (int) Math.ceil((double) a));
            this.abx.set(this.aby);
        }
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        f(rect);
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.aby, this.abw);
    }

    public final void setAlpha(int i) {
        this.fu.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fu.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.nk = colorStateList;
        this.mm = b(this.nk, this.nl);
        invalidateSelf();
    }

    public final void setTintMode(Mode mode) {
        this.nl = mode;
        this.mm = b(this.nk, this.nl);
        invalidateSelf();
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.nk == null || this.nl == null) {
            return false;
        }
        this.mm = b(this.nk, this.nl);
        return true;
    }

    public final boolean isStateful() {
        return (this.nk != null && this.nk.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter b(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
