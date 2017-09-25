package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.l;
import com.tencent.smtt.sdk.WebView;

public class CircularImageView extends ImageView {
    private static final String TAG = CircularImageView.class.getSimpleName();
    private Paint jXK;
    private boolean mEj;
    private int nIq;
    private boolean qmb;
    private boolean qmc;
    private int qmd;
    private int qme;
    private boolean qmf;
    private float qmg;
    private float qmh;
    private float qmi;
    private BitmapShader qmj;
    private Bitmap qmk;
    private Paint qml;
    private Paint qmm;
    private ColorFilter qmn;
    private int shadowColor;

    public CircularImageView(Context context) {
        this(context, null, l.pNi);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, l.pNi);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        int dimensionPixelOffset;
        float f = 0.0f;
        super(context, attributeSet, i);
        this.jXK = new Paint();
        this.jXK.setAntiAlias(true);
        this.qml = new Paint();
        this.qml.setAntiAlias(true);
        this.qml.setStyle(Style.STROKE);
        this.qmm = new Paint();
        this.qmm.setAntiAlias(true);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.pNg, i, 0);
        this.qmb = obtainStyledAttributes.getBoolean(l.pNj, false);
        this.qmc = obtainStyledAttributes.getBoolean(l.pNm, false);
        this.qmf = obtainStyledAttributes.getBoolean(l.pNq, false);
        if (this.qmb) {
            dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(l.pNl, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f));
            this.nIq = dimensionPixelOffset;
            if (this.qml != null) {
                this.qml.setStrokeWidth((float) dimensionPixelOffset);
            }
            requestLayout();
            invalidate();
            dimensionPixelOffset = obtainStyledAttributes.getColor(l.pNk, -1);
            if (this.qml != null) {
                this.qml.setColor(dimensionPixelOffset);
            }
            invalidate();
        }
        if (this.qmc) {
            dimensionPixelOffset = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
            this.qmn = new PorterDuffColorFilter(obtainStyledAttributes.getColor(l.pNn, 0), Mode.SRC_ATOP);
            invalidate();
            this.qme = obtainStyledAttributes.getDimensionPixelOffset(l.pNp, dimensionPixelOffset);
            requestLayout();
            invalidate();
            dimensionPixelOffset = obtainStyledAttributes.getColor(l.pNo, -16776961);
            if (this.qmm != null) {
                this.qmm.setColor(dimensionPixelOffset);
            }
            invalidate();
        }
        if (this.qmf) {
            this.qmg = obtainStyledAttributes.getFloat(l.pNu, 4.0f);
            this.qmh = obtainStyledAttributes.getFloat(l.pNs, 0.0f);
            this.qmi = obtainStyledAttributes.getFloat(l.pNt, 2.0f);
            this.shadowColor = obtainStyledAttributes.getColor(l.pNr, WebView.NIGHT_MODE_COLOR);
            this.qmf = true;
            if (this.qmf) {
                f = this.qmg;
            }
            this.qml.setShadowLayer(f, this.qmh, this.qmi, this.shadowColor);
            this.qmm.setShadowLayer(f, this.qmh, this.qmi, this.shadowColor);
        }
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas) {
        int i = 0;
        if (this.qmk != null && this.qmk.getHeight() != 0 && this.qmk.getWidth() != 0) {
            int i2 = this.qmd;
            this.qmd = getWidth() < getHeight() ? getWidth() : getHeight();
            if (i2 != this.qmd) {
                bgU();
            }
            this.jXK.setShader(this.qmj);
            int i3 = this.qmd / 2;
            if (this.qmc && this.mEj) {
                i = this.qme;
                i3 = (this.qmd - (i * 2)) / 2;
                this.jXK.setColorFilter(this.qmn);
                canvas.drawCircle((float) (i3 + i), (float) (i3 + i), ((float) (((this.qmd - (i * 2)) / 2) + i)) - 4.0f, this.qmm);
            } else if (this.qmb) {
                int i4 = this.nIq;
                int i5 = (this.qmd - (i4 * 2)) / 2;
                this.jXK.setColorFilter(null);
                canvas.drawArc(new RectF((float) ((i4 / 2) + 0), (float) ((i4 / 2) + 0), (float) (this.qmd - (i4 / 2)), (float) (this.qmd - (i4 / 2))), 360.0f, 360.0f, false, this.qml);
                i3 = i5;
                i = i4;
            } else {
                this.jXK.setColorFilter(null);
            }
            canvas.drawCircle((float) (i3 + i), (float) (i3 + i), (float) ((this.qmd - (i * 2)) / 2), this.jXK);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mEj = true;
                    break;
                case 1:
                case 3:
                case 4:
                case 8:
                    this.mEj = false;
                    break;
            }
            invalidate();
            return super.dispatchTouchEvent(motionEvent);
        }
        this.mEj = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.qmk = s(getDrawable());
        if (this.qmd > 0) {
            bgU();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.qmk = s(getDrawable());
        if (this.qmd > 0) {
            bgU();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.qmk = s(getDrawable());
        if (this.qmd > 0) {
            bgU();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.qmk = bitmap;
        if (this.qmd > 0) {
            bgU();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (!(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            size = this.qmd;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        if (!(mode2 == 1073741824 || mode2 == Integer.MIN_VALUE)) {
            mode = this.qmd;
        }
        setMeasuredDimension(size, mode + 2);
    }

    private static Bitmap s(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void bgU() {
        if (this.qmk != null) {
            this.qmj = new BitmapShader(this.qmk, TileMode.CLAMP, TileMode.CLAMP);
            if (this.qmd != this.qmk.getWidth() || this.qmd != this.qmk.getHeight()) {
                Matrix matrix = new Matrix();
                float width = ((float) this.qmd) / ((float) this.qmk.getWidth());
                matrix.setScale(width, width);
                this.qmj.setLocalMatrix(matrix);
            }
        }
    }

    public boolean isSelected() {
        return this.mEj;
    }
}
