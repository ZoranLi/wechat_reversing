package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public class VolumeMeter extends ImageView implements Runnable {
    private Paint jXK;
    private Context mContext;
    private boolean nfG = false;
    private boolean nfH = false;
    private View nfI;
    private int nfJ = -1;
    private int nfK = -1;
    private ae nfL = null;
    private float nfM;
    private float nfN;
    private float nfO;
    private float nfP;
    private int nfQ = -6751336;
    private int nfR = 70;
    private float nfS = 0.5f;
    private float nfT = 0.001f;
    private int nfU = 20;
    private float nfV;
    private float nfW;
    private float nfX = 0.0f;
    private float nfY = 40.0f;
    private float nfZ = 30.0f;

    public void run() {
        if (this.nfG) {
            float f;
            float f2 = this.nfO;
            if (this.nfN > this.nfM) {
                f = (this.nfN - this.nfM) / this.nfZ;
                if (f > this.nfS) {
                    f = this.nfS;
                } else if (f < this.nfT) {
                    f = this.nfT;
                }
                f += f2;
            } else if (this.nfN <= this.nfM) {
                f = (this.nfM - this.nfN) / this.nfY;
                if (f > this.nfS) {
                    f = this.nfS;
                } else if (f < this.nfT) {
                    f = this.nfT;
                }
                f = f2 - f;
            } else {
                f = f2;
            }
            this.nfO = f;
            this.nfP = this.nfO;
            this.nfX = ((float) ((260.0d * Math.sqrt((double) this.nfO)) - ((double) (130.0f * this.nfO)))) / DownloadHelper.SAVE_FATOR;
            postInvalidate();
            this.nfL.postDelayed(this, (long) this.nfU);
        }
    }

    public VolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public VolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.jXK = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getWidth();
        getHeight();
        if (!(this.nfI == null || this.nfI.getVisibility() == 4)) {
            int[] iArr = new int[2];
            this.nfI.getLocationInWindow(iArr);
            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                int width = this.nfI.getWidth();
                int height = this.nfI.getHeight();
                if (!(width == 0 || height == 0)) {
                    int a = b.a(this.mContext, 50.0f);
                    this.nfJ = iArr[0] + (width / 2);
                    this.nfK = (iArr[1] + (height / 2)) - (a / 2);
                    this.nfW = (float) (width / 2);
                    this.nfV = ((float) (width / 2)) * 2.0f;
                }
            }
        }
        if (this.nfJ >= 0 && this.nfK >= 0) {
            this.jXK.setColor(this.nfQ);
            this.jXK.setAlpha(this.nfR);
            float a2 = (float) b.a(this.mContext, this.nfX);
            if (a2 > this.nfV) {
                a2 = this.nfV;
            }
            if (a2 < this.nfW) {
                a2 = this.nfW;
            }
            canvas.drawCircle((float) this.nfJ, (float) this.nfK, a2, this.jXK);
        }
    }
}
