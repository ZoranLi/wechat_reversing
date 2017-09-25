package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.sdk.platformtools.ae;

public class MaskImageButton extends ImageButton {
    private int a = 90;
    private int b = 0;
    private int g = 0;
    private ae qpE = new ae(Looper.getMainLooper());
    private Runnable qpF = new Runnable(this) {
        final /* synthetic */ MaskImageButton wnu;

        {
            this.wnu = r1;
        }

        public final void run() {
            this.wnu.setPressed(false);
            this.wnu.invalidate();
        }
    };
    private int r = 0;
    public Object wnt;

    public MaskImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MaskImageButton wnu;

            {
                this.wnu = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        this.wnu.qpE.removeCallbacks(this.wnu.qpF);
                        break;
                    case 1:
                    case 3:
                        this.wnu.qpE.post(this.wnu.qpF);
                        break;
                }
                if (this.wnu.isClickable() || this.wnu.isLongClickable()) {
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
}
