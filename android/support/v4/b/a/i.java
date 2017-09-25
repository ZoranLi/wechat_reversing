package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;

public abstract class i extends Drawable {
    public final Paint fu = new Paint(3);
    public float iW;
    final Bitmap mBitmap;
    private int tV = JsApiSetBackgroundAudioState.CTRL_INDEX;
    private int tW = 119;
    public final BitmapShader tX;
    private final Matrix tY = new Matrix();
    final Rect tZ = new Rect();
    private final RectF ua = new RectF();
    private boolean ub = true;
    public boolean uc;
    private int ud;
    private int ue;

    public void setFilterBitmap(boolean z) {
        this.fu.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.fu.setDither(z);
        invalidateSelf();
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    final void bs() {
        if (this.ub) {
            if (this.uc) {
                int min = Math.min(this.ud, this.ue);
                a(this.tW, min, min, getBounds(), this.tZ);
                int min2 = Math.min(this.tZ.width(), this.tZ.height());
                this.tZ.inset(Math.max(0, (this.tZ.width() - min2) / 2), Math.max(0, (this.tZ.height() - min2) / 2));
                this.iW = ((float) min2) * 0.5f;
            } else {
                a(this.tW, this.ud, this.ue, getBounds(), this.tZ);
            }
            this.ua.set(this.tZ);
            if (this.tX != null) {
                this.tY.setTranslate(this.ua.left, this.ua.top);
                this.tY.preScale(this.ua.width() / ((float) this.mBitmap.getWidth()), this.ua.height() / ((float) this.mBitmap.getHeight()));
                this.tX.setLocalMatrix(this.tY);
                this.fu.setShader(this.tX);
            }
            this.ub = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bs();
            if (this.fu.getShader() == null) {
                canvas.drawBitmap(bitmap, null, this.tZ, this.fu);
            } else {
                canvas.drawRoundRect(this.ua, this.iW, this.iW, this.fu);
            }
        }
    }

    public void setAlpha(int i) {
        if (i != this.fu.getAlpha()) {
            this.fu.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.fu.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.fu.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.fu.getColorFilter();
    }

    public final void bt() {
        this.uc = true;
        this.ub = true;
        bu();
        this.fu.setShader(this.tX);
        invalidateSelf();
    }

    private void bu() {
        this.iW = (float) (Math.min(this.ue, this.ud) / 2);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.uc) {
            bu();
        }
        this.ub = true;
    }

    public int getIntrinsicWidth() {
        return this.ud;
    }

    public int getIntrinsicHeight() {
        return this.ue;
    }

    public int getOpacity() {
        if (this.tW != 119 || this.uc) {
            return -3;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.hasAlpha() || this.fu.getAlpha() < 255 || n(this.iW)) {
            return -3;
        }
        return -1;
    }

    i(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.tV = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            this.ud = this.mBitmap.getScaledWidth(this.tV);
            this.ue = this.mBitmap.getScaledHeight(this.tV);
            this.tX = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            return;
        }
        this.ue = -1;
        this.ud = -1;
        this.tX = null;
    }

    public static boolean n(float f) {
        return f > 0.05f;
    }
}
