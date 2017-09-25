package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.ae;

public class MaskImageView extends TagImageView {
    private int a = 90;
    private int b = 0;
    boolean fFU = true;
    private int g = 0;
    private ae qpE = new ae(Looper.getMainLooper());
    private Runnable qpF = new Runnable(this) {
        final /* synthetic */ MaskImageView quW;

        {
            this.quW = r1;
        }

        public final void run() {
            this.quW.setPressed(false);
            this.quW.invalidate();
        }
    };
    private int r = 0;

    public MaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MaskImageView quW;

            {
                this.quW = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.quW.fFU) {
                    return this.quW.d(view, motionEvent);
                }
                return false;
            }
        });
        super.setContentDescription(getContext().getResources().getString(j.pLn));
    }

    public final boolean d(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                this.qpE.removeCallbacks(this.qpF);
                break;
            case 1:
            case 3:
                this.qpE.post(this.qpF);
                break;
        }
        if (isClickable() || isLongClickable()) {
            return false;
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
