package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.o;

public class IPCallCountryCodeScrollbar extends View {
    public static final String[] mTu = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private float hbf;
    private Paint jXK;
    private float mTA;
    private o mTB;
    private TextView mTC;
    private int mTD;
    a mTE;
    protected float mTv = 1.3f;
    protected int mTw = 79;
    protected String[] mTx = new String[]{"↑"};
    private int mTy;
    private float mTz = 0.0f;

    public interface a {
        void sd(String str);
    }

    public final void yH(String str) {
        int i = 0;
        int i2 = 0;
        for (String equals : mTu) {
            if (equals.equals(str)) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            str = "#";
        }
        int length = this.mTx.length + 1;
        String[] strArr = new String[length];
        String[] strArr2 = this.mTx;
        int length2 = strArr2.length;
        i2 = 0;
        while (i2 < length2) {
            String str2 = strArr2[i2];
            if (!str2.equals(str)) {
                strArr[i] = str2;
                i++;
                i2++;
            } else {
                return;
            }
        }
        strArr[length - 1] = str;
        this.mTx = strArr;
    }

    public IPCallCountryCodeScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mTD = b.a(context, 3.0f);
        View inflate = inflate(context, R.i.dox, null);
        int a = b.a(context, (float) this.mTw);
        this.mTB = new o(inflate, a, a);
        this.mTC = (TextView) inflate.findViewById(R.h.cFe);
        this.jXK = new Paint();
        this.jXK.setAntiAlias(true);
        this.jXK.setColor(-11119018);
        this.jXK.setTextAlign(Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        this.hbf = ((float) measuredHeight) / (((float) this.mTx.length) * this.mTv);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aXI);
        if (this.hbf > ((float) dimensionPixelSize)) {
            this.hbf = (float) dimensionPixelSize;
        }
        this.jXK.setTextSize(this.hbf);
        if (this.mTz != this.hbf) {
            this.mTz = this.hbf;
            post(new Runnable(this) {
                final /* synthetic */ IPCallCountryCodeScrollbar mTH;

                public final void run() {
                    if (this.mTH.mTx.length > 0) {
                        int measureText = ((int) this.mTH.jXK.measureText(this.mTH.mTx[this.mTH.mTx.length - 1])) + com.tencent.mm.bg.a.fromDPToPix(this.mTH.getContext(), 8);
                        if (measureText > measuredWidth) {
                            LayoutParams layoutParams = this.mTH.getLayoutParams();
                            layoutParams.width = measureText;
                            layoutParams.height = measuredHeight;
                            this.mTH.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
        }
        if (this.hbf == ((float) dimensionPixelSize)) {
            float length = (((float) measuredHeight) - ((((float) this.mTx.length) * this.hbf) * this.mTv)) / 2.0f;
            while (i < this.mTx.length) {
                canvas.drawText(this.mTx[i], ((float) measuredWidth) / 2.0f, (this.hbf + length) + ((((float) i) * this.hbf) * this.mTv), this.jXK);
                i++;
            }
            return;
        }
        while (i < this.mTx.length) {
            canvas.drawText(this.mTx[i], ((float) measuredWidth) / 2.0f, this.hbf + ((((float) i) * this.hbf) * this.mTv), this.jXK);
            i++;
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
            setBackgroundDrawable(com.tencent.mm.bg.a.a(getContext(), R.g.bjr));
            float f = this.hbf * this.mTv;
            int measuredHeight = (int) ((this.mTA - ((((float) getMeasuredHeight()) - (((float) this.mTx.length) * f)) / 2.0f)) / f);
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            if (measuredHeight >= this.mTx.length) {
                measuredHeight = this.mTx.length - 1;
            }
            this.mTy = measuredHeight;
            if (this.mTy == -1) {
                this.mTC.setText(R.l.ePv);
            } else {
                this.mTC.setText(this.mTx[this.mTy]);
            }
            this.mTB.showAtLocation(this, 17, 0, 0);
            if (this.mTE != null) {
                if (this.mTy == -1) {
                    this.mTE.sd(com.tencent.mm.bg.a.V(getContext(), R.l.ePv));
                } else {
                    this.mTE.sd(this.mTx[this.mTy]);
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
