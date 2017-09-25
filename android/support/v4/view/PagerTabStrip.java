package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.smtt.sdk.WebView;

public class PagerTabStrip extends PagerTitleStrip {
    private final Rect eq = new Rect();
    private int iE;
    private int xA;
    private boolean xB;
    private float xC;
    private float xD;
    private int xq = this.xT;
    private int xr;
    private int xs;
    private int xt;
    private int xu;
    private int xv;
    private final Paint xw = new Paint();
    private int xx = 255;
    private boolean xy = false;
    private boolean xz = false;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xw.setColor(this.xq);
        float f = context.getResources().getDisplayMetrics().density;
        this.xr = (int) ((3.0f * f) + 0.5f);
        this.xs = (int) ((6.0f * f) + 0.5f);
        this.xt = (int) (64.0f * f);
        this.xv = (int) ((16.0f * f) + 0.5f);
        this.xA = (int) ((1.0f * f) + 0.5f);
        this.xu = (int) ((f * 32.0f) + 0.5f);
        this.iE = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        U(this.xL);
        setWillNotDraw(false);
        this.xG.setFocusable(true);
        this.xG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagerTabStrip xE;

            {
                this.xE = r1;
            }

            public final void onClick(View view) {
                this.xE.xF.Y(this.xE.xF.ys - 1);
            }
        });
        this.xI.setFocusable(true);
        this.xI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagerTabStrip xE;

            {
                this.xE = r1;
            }

            public final void onClick(View view) {
                this.xE.xF.Y(this.xE.xF.ys + 1);
            }
        });
        if (getBackground() == null) {
            this.xy = true;
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.xs) {
            i4 = this.xs;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public final void U(int i) {
        if (i < this.xt) {
            i = this.xt;
        }
        super.U(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.xz) {
            this.xy = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.xz) {
            this.xy = (WebView.NIGHT_MODE_COLOR & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.xz) {
            this.xy = i == 0;
        }
    }

    final int getMinHeight() {
        return Math.max(super.getMinHeight(), this.xu);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.xB) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.xC = x;
                this.xD = y;
                this.xB = false;
                break;
            case 1:
                if (x >= ((float) (this.xH.getLeft() - this.xv))) {
                    if (x > ((float) (this.xH.getRight() + this.xv))) {
                        this.xF.Y(this.xF.ys + 1);
                        break;
                    }
                }
                this.xF.Y(this.xF.ys - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.xC) > ((float) this.iE) || Math.abs(y - this.xD) > ((float) this.iE)) {
                    this.xB = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.xH.getLeft() - this.xv;
        int right = this.xH.getRight() + this.xv;
        int i = height - this.xr;
        this.xw.setColor((this.xx << 24) | (this.xq & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.xw);
        if (this.xy) {
            this.xw.setColor(WebView.NIGHT_MODE_COLOR | (this.xq & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.xA), (float) (getWidth() - getPaddingRight()), (float) height, this.xw);
        }
    }

    final void a(int i, float f, boolean z) {
        Rect rect = this.eq;
        int height = getHeight();
        int i2 = height - this.xr;
        rect.set(this.xH.getLeft() - this.xv, i2, this.xH.getRight() + this.xv, height);
        super.a(i, f, z);
        this.xx = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.xH.getLeft() - this.xv, i2, this.xH.getRight() + this.xv, height);
        invalidate(rect);
    }
}
