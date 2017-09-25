package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.w;

public class MovingImageButton extends ImageView {
    private int jYp;
    private int jYq;
    private int jdE;
    private int jdF;
    private Context mContext;
    private int mxB;
    private int snA = 0;
    private MarginLayoutParams snB;
    private final int snC = 100;
    private int snD;
    private boolean snE = false;
    public boolean snF = true;
    private int snx;
    private int sny;
    private int snz = 0;
    private int x;
    private int y;

    public MovingImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public MovingImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.snD = a.fromDPToPix(this.mContext, 100);
        this.jYp = a.dO(this.mContext);
        this.jYq = a.dP(this.mContext);
        this.mxB = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.snF) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.snz == 0 || this.snA == 0) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.snz = rect.right - rect.left;
            this.snA = rect.bottom - rect.top;
            w.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[]{Integer.valueOf(rect.right), Integer.valueOf(rect.top), Integer.valueOf(rect.left), Integer.valueOf(rect.bottom), Integer.valueOf(this.snz), Integer.valueOf(this.snA)});
        }
        this.x = (int) motionEvent.getRawX();
        this.y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                this.snx = this.x;
                this.sny = this.y;
                break;
            case 1:
                if (Math.abs(this.snx - this.x) + Math.abs(this.sny - this.y) <= this.mxB) {
                    performClick();
                    break;
                }
                if (this.y < this.snD) {
                    this.snB.topMargin = 0;
                } else if (this.y > this.snA - this.snD) {
                    this.snB.topMargin = this.snA - getHeight();
                } else if (this.x > this.snz / 2) {
                    this.snB.rightMargin = 0;
                } else {
                    this.snB.rightMargin = this.snz - getWidth();
                }
                requestLayout();
                break;
            case 2:
                int i = this.x - this.jdE;
                int i2 = this.y - this.jdF;
                if (!(i == 0 && i2 == 0)) {
                    this.snB = (MarginLayoutParams) getLayoutParams();
                    MarginLayoutParams marginLayoutParams = this.snB;
                    marginLayoutParams.rightMargin = (-i) + marginLayoutParams.rightMargin;
                    marginLayoutParams = this.snB;
                    marginLayoutParams.topMargin += i2;
                    if (this.snB.rightMargin < 0) {
                        this.snB.rightMargin = 0;
                    } else if (this.snB.rightMargin > this.snz - getWidth()) {
                        this.snB.rightMargin = this.snz - getWidth();
                    }
                    if (this.snB.topMargin < 0) {
                        this.snB.topMargin = 0;
                    } else if (this.snB.topMargin > this.snA - getHeight()) {
                        this.snB.topMargin = this.snA - getHeight();
                    }
                    requestLayout();
                    break;
                }
        }
        this.jdE = this.x;
        this.jdF = this.y;
        return true;
    }
}
