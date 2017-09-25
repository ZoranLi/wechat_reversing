package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.tencent.mm.sdk.platformtools.w;

@RemoteView
public class QImageView extends View {
    private static final a[] wxl = new a[]{a.MATRIX, a.FIT_XY, a.FIT_START, a.FIT_CENTER, a.FIT_END, a.CENTER, a.CENTER_CROP, a.CENTER_INSIDE};
    private static final ScaleToFit[] wxm = new ScaleToFit[]{ScaleToFit.FILL, ScaleToFit.START, ScaleToFit.CENTER, ScaleToFit.END};
    private int CS;
    private boolean Xa;
    private Uri apg;
    private int iO;
    private Context mContext;
    public Drawable mDrawable;
    public Matrix mMatrix;
    private ColorFilter mn;
    private int sPL;
    private int wwW;
    private a wwX;
    private boolean wwY;
    private boolean wwZ;
    private int wxa;
    private boolean wxb;
    private int[] wxc;
    private boolean wxd;
    private int wxe;
    private int wxf;
    private int wxg;
    private Matrix wxh;
    private final RectF wxi;
    private final RectF wxj;
    private boolean wxk;

    public enum a {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        final int wxv;

        private a(int i) {
            this.wxv = i;
        }
    }

    public QImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        caK();
    }

    public QImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.wwW = 0;
        this.wwY = false;
        this.wwZ = false;
        this.iO = Integer.MAX_VALUE;
        this.sPL = Integer.MAX_VALUE;
        this.CS = 255;
        this.wxa = 256;
        this.wxb = false;
        this.mDrawable = null;
        this.wxc = null;
        this.wxd = false;
        this.wxe = 0;
        this.wxh = null;
        this.wxi = new RectF();
        this.wxj = new RectF();
        this.Xa = false;
        this.mContext = context;
        caK();
        this.Xa = false;
        this.wwZ = false;
        this.iO = Integer.MAX_VALUE;
        this.sPL = Integer.MAX_VALUE;
        this.wxk = false;
    }

    private void caK() {
        this.mMatrix = new Matrix();
        this.wwX = a.FIT_CENTER;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.mDrawable == drawable || super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected boolean onSetAlpha(int i) {
        if (getBackground() != null) {
            return false;
        }
        int i2 = (i >> 7) + i;
        if (this.wxa == i2) {
            return true;
        }
        this.wxa = i2;
        this.wxb = true;
        caN();
        return true;
    }

    public final void setImageResource(int i) {
        if (this.apg != null || this.wwW != i) {
            w(null);
            this.wwW = i;
            this.apg = null;
            caL();
            invalidate();
        }
    }

    @TargetApi(11)
    public void setLayerType(int i, Paint paint) {
        if (!(this.mDrawable instanceof PictureDrawable) || i == 1) {
            super.setLayerType(i, paint);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mDrawable != drawable) {
            this.wwW = 0;
            this.apg = null;
            w(drawable);
            invalidate();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap));
    }

    private void caL() {
        Drawable drawable = null;
        if (this.mDrawable == null) {
            Resources resources = getResources();
            if (resources != null) {
                if (this.wwW != 0) {
                    try {
                        drawable = resources.getDrawable(this.wwW);
                    } catch (Exception e) {
                        w.w("ImageView", "Unable to find resource: " + this.wwW, e);
                        this.apg = drawable;
                    }
                } else if (this.apg == null) {
                    return;
                }
                w(drawable);
            }
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = this.wxf;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = this.wxg;
            }
            if (intrinsicWidth != this.wxf || intrinsicHeight != this.wxg) {
                this.wxf = intrinsicWidth;
                this.wxg = intrinsicHeight;
                requestLayout();
            }
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        } else if (this.wwX != aVar) {
            this.wwX = aVar;
            setWillNotCacheDrawing(this.wwX == a.CENTER);
            requestLayout();
            invalidate();
        }
    }

    public int[] onCreateDrawableState(int i) {
        if (this.wxc == null) {
            return super.onCreateDrawableState(i);
        }
        if (this.wxd) {
            return mergeDrawableStates(super.onCreateDrawableState(this.wxc.length + i), this.wxc);
        }
        return this.wxc;
    }

    private void w(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(this.wxe);
            this.wxf = drawable.getIntrinsicWidth();
            this.wxg = drawable.getIntrinsicHeight();
            caN();
            caM();
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        caL();
        float f = 0.0f;
        Object obj = null;
        Object obj2;
        if (this.mDrawable == null) {
            this.wxf = -1;
            this.wxg = -1;
            i3 = 0;
            obj2 = null;
            i4 = 0;
        } else {
            i5 = this.wxf;
            i3 = this.wxg;
            if (i5 <= 0) {
                i5 = 1;
            }
            if (i3 <= 0) {
                i3 = 1;
            }
            if (this.wwZ) {
                i4 = MeasureSpec.getMode(i);
                int mode = MeasureSpec.getMode(i2);
                obj = i4 != 1073741824 ? 1 : null;
                Object obj3 = mode != 1073741824 ? 1 : null;
                f = ((float) i5) / ((float) i3);
                i6 = i5;
                obj2 = obj3;
                i4 = i3;
                i3 = i6;
            } else {
                i6 = i5;
                obj2 = null;
                i4 = i3;
                i3 = i6;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (obj == null && r4 == null) {
            i4 += paddingTop + paddingBottom;
            i3 = Math.max(i3 + (paddingLeft + paddingRight), getSuggestedMinimumWidth());
            i5 = Math.max(i4, getSuggestedMinimumHeight());
            i4 = resolveSize(i3, i);
            i3 = resolveSize(i5, i2);
        } else {
            i3 = Z((i3 + paddingLeft) + paddingRight, this.iO, i);
            i4 = Z((i4 + paddingTop) + paddingBottom, this.sPL, i2);
            if (f == 0.0f || ((double) Math.abs((((float) ((i3 - paddingLeft) - paddingRight)) / ((float) ((i4 - paddingTop) - paddingBottom))) - f)) <= 1.0E-7d) {
                i6 = i4;
                i4 = i3;
                i3 = i6;
            } else {
                int i7;
                Object obj4;
                if (obj != null) {
                    i7 = (((int) (((float) ((i4 - paddingTop) - paddingBottom)) * f)) + paddingLeft) + paddingRight;
                    if (i7 <= i3) {
                        obj4 = 1;
                        if (obj4 == null && r4 != null) {
                            i3 = (((int) (((float) ((i7 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                            if (i3 <= i4) {
                                i4 = i7;
                            }
                        }
                        i3 = i4;
                        i4 = i7;
                    }
                }
                i7 = i3;
                obj4 = null;
                i3 = (((int) (((float) ((i7 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                if (i3 <= i4) {
                    i4 = i7;
                }
                i3 = i4;
                i4 = i7;
            }
        }
        setMeasuredDimension(i4, i3);
    }

    private static int Z(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i, size), i2);
            case 0:
                return Math.min(i, i2);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.wwY = true;
        caM();
    }

    private void caM() {
        float f = 0.0f;
        if (this.mDrawable != null && this.wwY) {
            int i = this.wxf;
            int i2 = this.wxg;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int i3 = ((i < 0 || width == i) && (i2 < 0 || height == i2)) ? 1 : 0;
            if (i <= 0 || i2 <= 0 || a.FIT_XY == this.wwX) {
                this.mDrawable.setBounds(0, 0, width, height);
                this.wxh = null;
                return;
            }
            this.mDrawable.setBounds(0, 0, i, i2);
            if (a.MATRIX == this.wwX) {
                if (this.mMatrix.isIdentity()) {
                    this.wxh = null;
                } else {
                    this.wxh = this.mMatrix;
                }
            } else if (i3 != 0) {
                this.wxh = null;
            } else if (a.CENTER == this.wwX) {
                this.wxh = this.mMatrix;
                this.wxh.setTranslate((float) ((int) ((((float) (width - i)) * 0.5f) + 0.5f)), (float) ((int) ((((float) (height - i2)) * 0.5f) + 0.5f)));
            } else if (a.CENTER_CROP == this.wwX) {
                this.wxh = this.mMatrix;
                if (i * height > width * i2) {
                    r0 = ((float) height) / ((float) i2);
                    r2 = (((float) width) - (((float) i) * r0)) * 0.5f;
                } else {
                    r0 = ((float) width) / ((float) i);
                    r2 = 0.0f;
                    f = (((float) height) - (((float) i2) * r0)) * 0.5f;
                }
                this.wxh.setScale(r0, r0);
                this.wxh.postTranslate((float) ((int) (r2 + 0.5f)), (float) ((int) (f + 0.5f)));
            } else if (a.CENTER_INSIDE == this.wwX) {
                this.wxh = this.mMatrix;
                if (i > width || i2 > height) {
                    r0 = Math.min(((float) width) / ((float) i), ((float) height) / ((float) i2));
                } else {
                    r0 = 1.0f;
                }
                f = (float) ((int) (((((float) width) - (((float) i) * r0)) * 0.5f) + 0.5f));
                r2 = (float) ((int) (((((float) height) - (((float) i2) * r0)) * 0.5f) + 0.5f));
                this.wxh.setScale(r0, r0);
                this.wxh.postTranslate(f, r2);
            } else {
                this.wxi.set(0.0f, 0.0f, (float) i, (float) i2);
                this.wxj.set(0.0f, 0.0f, (float) width, (float) height);
                this.wxh = this.mMatrix;
                this.wxh.setRectToRect(this.wxi, this.wxj, wxm[this.wwX.wxv - 1]);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.onDraw(canvas);
        if (this.mDrawable != null && this.wxf != 0 && this.wxg != 0) {
            if (this.wxh == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                this.mDrawable.draw(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (this.wxk) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            if (this.wxh != null) {
                canvas.concat(this.wxh);
            }
            this.mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    public int getBaseline() {
        return this.Xa ? getMeasuredHeight() : -1;
    }

    public final void setAlpha(int i) {
        int i2 = i & 255;
        if (this.CS != i2) {
            this.CS = i2;
            this.wxb = true;
            caN();
            invalidate();
        }
    }

    private void caN() {
        if (this.mDrawable != null && this.wxb) {
            this.mDrawable = this.mDrawable.mutate();
            this.mDrawable.setColorFilter(this.mn);
            this.mDrawable.setAlpha((this.CS * this.wxa) >> 8);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
