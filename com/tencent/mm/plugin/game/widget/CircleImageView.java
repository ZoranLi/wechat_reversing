package com.tencent.mm.plugin.game.widget;

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
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class CircleImageView extends ImageView {
    private static final Config hgI = Config.ARGB_8888;
    private static final ScaleType mHc = ScaleType.CENTER_CROP;
    private int hN;
    private Bitmap mBitmap;
    private final RectF mHd;
    private final RectF mHe;
    private final Paint mHf;
    private final Paint mHg;
    private int mHh;
    private float mHi;
    private float mHj;
    private boolean mHk;
    private boolean mHl;
    private boolean mHm;
    private ColorFilter mn;
    private BitmapShader tX;
    private final Matrix tY;
    private int ud;
    private int ue;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHd = new RectF();
        this.mHe = new RectF();
        this.tY = new Matrix();
        this.mHf = new Paint();
        this.mHg = new Paint();
        this.mHh = WebView.NIGHT_MODE_COLOR;
        this.hN = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fpm, i, 0);
        this.hN = obtainStyledAttributes.getDimensionPixelSize(R.n.fpp, 0);
        this.mHh = obtainStyledAttributes.getColor(R.n.fpn, WebView.NIGHT_MODE_COLOR);
        this.mHm = obtainStyledAttributes.getBoolean(R.n.fpo, false);
        obtainStyledAttributes.recycle();
        super.setScaleType(mHc);
        this.mHk = true;
        if (this.mHl) {
            setup();
            this.mHl = false;
        }
    }

    public ScaleType getScaleType() {
        return mHc;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != mHc) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.mHi, this.mHf);
            if (this.hN != 0) {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.mHj, this.mHg);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = p(drawable);
        setup();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.mBitmap = p(getDrawable());
        setup();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.mBitmap = p(getDrawable());
        setup();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mn) {
            this.mn = colorFilter;
            this.mHf.setColorFilter(this.mn);
            invalidate();
        }
    }

    private static Bitmap p(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, hgI);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), hgI);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void setup() {
        float f = 0.0f;
        if (!this.mHk) {
            this.mHl = true;
        } else if (this.mBitmap != null) {
            float height;
            float width;
            this.tX = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.mHf.setAntiAlias(true);
            this.mHf.setShader(this.tX);
            this.mHg.setStyle(Style.STROKE);
            this.mHg.setAntiAlias(true);
            this.mHg.setColor(this.mHh);
            this.mHg.setStrokeWidth((float) this.hN);
            this.ue = this.mBitmap.getHeight();
            this.ud = this.mBitmap.getWidth();
            this.mHe.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mHj = Math.min((this.mHe.height() - ((float) this.hN)) / 2.0f, (this.mHe.width() - ((float) this.hN)) / 2.0f);
            this.mHd.set(this.mHe);
            if (!this.mHm) {
                this.mHd.inset((float) this.hN, (float) this.hN);
            }
            this.mHi = Math.min(this.mHd.height() / 2.0f, this.mHd.width() / 2.0f);
            this.tY.set(null);
            if (((float) this.ud) * this.mHd.height() > this.mHd.width() * ((float) this.ue)) {
                height = this.mHd.height() / ((float) this.ue);
                width = (this.mHd.width() - (((float) this.ud) * height)) * 0.5f;
            } else {
                height = this.mHd.width() / ((float) this.ud);
                width = 0.0f;
                f = (this.mHd.height() - (((float) this.ue) * height)) * 0.5f;
            }
            this.tY.setScale(height, height);
            this.tY.postTranslate(((float) ((int) (width + 0.5f))) + this.mHd.left, ((float) ((int) (f + 0.5f))) + this.mHd.top);
            this.tX.setLocalMatrix(this.tY);
            invalidate();
        }
    }
}
