package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ae;

class SendDataToDeviceProgressBar extends ImageView {
    private int bottom;
    private Paint fu;
    private ae hgN;
    private int left;
    private int lkG;
    private int lkH;
    private Runnable lkI;
    private int mBN;
    private Context mContext;
    private int right;
    private int top;

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lkG = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lkH = -1;
        this.mBN = 10;
        this.lkI = new Runnable(this) {
            final /* synthetic */ SendDataToDeviceProgressBar vOn;

            {
                this.vOn = r1;
            }

            public final void run() {
                this.vOn.invalidate();
            }
        };
        setImageResource(R.g.biD);
        this.mContext = context;
        this.fu = new Paint();
        this.fu.setAntiAlias(true);
        this.fu.setStyle(Style.STROKE);
        this.left = this.mContext.getResources().getDimensionPixelSize(R.f.baV);
        this.top = this.left;
        this.lkH = this.mContext.getResources().getDimensionPixelSize(R.f.baW);
        this.hgN = new ae(Looper.getMainLooper());
    }

    public final void setProgress(int i) {
        if (i >= 100) {
            i = 100;
        }
        this.lkG = (int) ((((float) i) / 100.0f) * 360.0f);
        this.hgN.removeCallbacks(this.lkI);
        this.hgN.postDelayed(this.lkI, 0);
    }

    public final int getProgress() {
        return (int) ((((float) this.lkG) / 360.0f) * 100.0f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.fu.setColor(this.mContext.getResources().getColor(R.e.aVu));
        this.fu.setStrokeWidth((float) this.lkH);
        if (this.right == -1) {
            this.right = (width * 2) - this.left;
        }
        if (this.bottom == -1) {
            this.bottom = this.right;
        }
        RectF rectF = new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom);
        canvas.drawArc(rectF, 270.0f, (float) this.lkG, false, this.fu);
        width = this.lkG + 270;
        if (width > 360) {
            width -= 360;
        }
        this.fu.setColor(this.mContext.getResources().getColor(R.e.aVt));
        canvas.drawArc(rectF, (float) width, (float) (360 - this.lkG), false, this.fu);
    }
}
