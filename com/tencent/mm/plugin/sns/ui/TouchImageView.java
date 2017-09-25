package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public class TouchImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private boolean fFU = true;
    private int g = 0;
    private Rect qLj = new Rect();
    private Paint qLk = new Paint();
    ae qpE;
    Runnable qpF;
    private int r = 0;

    public TouchImageView(Context context) {
        super(context);
        init();
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.qpE = new ae();
        this.qpF = new Runnable(this) {
            final /* synthetic */ TouchImageView qLl;

            {
                this.qLl = r1;
            }

            public final void run() {
                this.qLl.setPressed(false);
                this.qLl.invalidate();
            }
        };
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ TouchImageView qLl;

            {
                this.qLl = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.qLl.fFU) {
                    return false;
                }
                TouchImageView touchImageView = this.qLl;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        touchImageView.qpE.removeCallbacks(touchImageView.qpF);
                        break;
                    case 1:
                    case 3:
                        touchImageView.qpE.post(touchImageView.qpF);
                        break;
                }
                if (touchImageView.isClickable() || touchImageView.isLongClickable()) {
                    return false;
                }
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            this.qLj.left = getPaddingLeft();
            this.qLj.top = getPaddingTop();
            this.qLj.right = getWidth() - getPaddingRight();
            this.qLj.bottom = getHeight() - getPaddingBottom();
            this.qLk.setARGB(this.a, this.r, this.g, this.b);
            canvas.drawRect(this.qLj, this.qLk);
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    }
}
