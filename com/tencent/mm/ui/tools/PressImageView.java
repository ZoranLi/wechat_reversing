package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ae;
import junit.framework.Assert;

public class PressImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private int g = 0;
    private ae qpE = new ae();
    private Runnable qpF = new Runnable(this) {
        final /* synthetic */ PressImageView wnR;

        {
            this.wnR = r1;
        }

        public final void run() {
            this.wnR.setPressed(false);
            this.wnR.invalidate();
        }
    };
    private int r = 0;

    public PressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ PressImageView wnR;

            {
                this.wnR = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        this.wnR.qpE.removeCallbacks(this.wnR.qpF);
                        break;
                    case 1:
                    case 3:
                        this.wnR.qpE.post(this.wnR.qpF);
                        break;
                }
                if (this.wnR.isClickable() || this.wnR.isLongClickable()) {
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
}
