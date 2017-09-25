package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout extends LinearLayout {
    boolean fFU = false;
    private List<MaskImageView> fRK = new LinkedList();
    private ae qpE = new ae();
    private Runnable qpF = new Runnable(this) {
        final /* synthetic */ MaskLinearLayout quX;

        {
            this.quX = r1;
        }

        public final void run() {
            this.quX.setPressed(false);
            MaskLinearLayout.a(this.quX);
            this.quX.invalidate();
        }
    };

    static /* synthetic */ void a(MaskLinearLayout maskLinearLayout) {
        if (maskLinearLayout.isPressed()) {
            maskLinearLayout.setBackgroundResource(e.pAp);
        } else {
            maskLinearLayout.setBackgroundResource(0);
        }
    }

    public MaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MaskLinearLayout quX;

            {
                this.quX = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                w.e("test", "touch: " + motionEvent.getAction());
                if (this.quX.fFU) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            view.setPressed(true);
                            MaskLinearLayout.a(this.quX);
                            view.invalidate();
                            this.quX.qpE.removeCallbacks(this.quX.qpF);
                            break;
                        case 1:
                        case 3:
                            this.quX.qpE.post(this.quX.qpF);
                            break;
                    }
                    if (this.quX.fRK != null) {
                        for (MaskImageView maskImageView : this.quX.fRK) {
                            maskImageView.d(maskImageView, motionEvent);
                        }
                    }
                }
                return false;
            }
        });
    }

    public final void b(MaskImageView maskImageView) {
        this.fRK.add(maskImageView);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }
}
