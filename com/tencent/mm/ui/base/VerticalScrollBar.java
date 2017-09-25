package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public abstract class VerticalScrollBar extends View {
    private float hbf;
    private Paint jXK;
    private float mTA;
    private o mTB;
    private TextView mTC;
    private int mTD;
    public float mTv;
    public int mTw;
    public String[] mTx;
    private int mTy;
    private float mTz = 0.0f;
    public a vpW;

    public interface a {
        void sd(String str);
    }

    public abstract int aEZ();

    public abstract void aez();

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aez();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mTD = b.a(context, 3.0f);
        View inflate = inflate(context, aEZ(), null);
        int a = b.a(context, (float) this.mTw);
        this.mTB = new o(inflate, a, a);
        this.mTC = (TextView) inflate.findViewById(g.cFe);
        this.jXK = new Paint();
        this.jXK.setAntiAlias(true);
        this.jXK.setColor(-11119018);
        this.jXK.setTextAlign(Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        this.hbf = ((float) measuredHeight) / (((float) this.mTx.length) * this.mTv);
        this.jXK.setTextSize(this.hbf);
        if (this.mTz != this.hbf) {
            this.mTz = this.hbf;
            post(new Runnable(this) {
                final /* synthetic */ VerticalScrollBar vpX;

                public final void run() {
                    if (this.vpX.mTx.length > 0) {
                        int measureText = ((int) this.vpX.jXK.measureText(this.vpX.mTx[this.vpX.mTx.length - 1])) + com.tencent.mm.bg.a.fromDPToPix(this.vpX.getContext(), 8);
                        if (measureText > measuredWidth) {
                            LayoutParams layoutParams = this.vpX.getLayoutParams();
                            layoutParams.width = measureText;
                            layoutParams.height = measuredHeight;
                            this.vpX.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
        }
        for (measuredHeight = 0; measuredHeight < this.mTx.length; measuredHeight++) {
            canvas.drawText(this.mTx[measuredHeight], ((float) measuredWidth) / 2.0f, this.hbf + ((((float) measuredHeight) * this.hbf) * this.mTv), this.jXK);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.mTA = motionEvent.getY();
            if (this.mTA < 0.0f) {
                this.mTA = 0.0f;
            }
            if (this.mTA > ((float) getMeasuredHeight())) {
                this.mTA = (float) getMeasuredHeight();
            }
            setBackgroundDrawable(com.tencent.mm.bg.a.a(getContext(), f.bjr));
            int i = (int) (this.mTA / (this.hbf * this.mTv));
            if (i >= this.mTx.length) {
                i = this.mTx.length - 1;
            }
            this.mTy = i;
            if (this.mTy == -1) {
                this.mTC.setText(k.ePv);
            } else {
                this.mTC.setText(this.mTx[this.mTy]);
            }
            this.mTB.showAtLocation(this, 17, 0, 0);
            if (this.vpW != null) {
                if (this.mTy == -1) {
                    this.vpW.sd(com.tencent.mm.bg.a.V(getContext(), k.ePv));
                } else {
                    this.vpW.sd(this.mTx[this.mTy]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setBackgroundResource(0);
            this.mTB.dismiss();
        }
        return true;
    }
}
