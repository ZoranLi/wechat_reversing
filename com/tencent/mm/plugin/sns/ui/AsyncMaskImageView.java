package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public class AsyncMaskImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private boolean fFU = true;
    private int g = 0;
    ae qpE = new ae();
    Runnable qpF = new Runnable(this) {
        final /* synthetic */ AsyncMaskImageView qpG;

        {
            this.qpG = r1;
        }

        public final void run() {
            this.qpG.setPressed(false);
            this.qpG.invalidate();
        }
    };
    private int r = 0;

    public AsyncMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AsyncMaskImageView qpG;

            {
                this.qpG = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.qpG.fFU) {
                    return false;
                }
                AsyncMaskImageView asyncMaskImageView = this.qpG;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        asyncMaskImageView.qpE.removeCallbacks(asyncMaskImageView.qpF);
                        break;
                    case 1:
                    case 3:
                        asyncMaskImageView.qpE.post(asyncMaskImageView.qpF);
                        break;
                }
                if (asyncMaskImageView.isClickable() || asyncMaskImageView.isLongClickable()) {
                    return false;
                }
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
    }

    @Deprecated
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
