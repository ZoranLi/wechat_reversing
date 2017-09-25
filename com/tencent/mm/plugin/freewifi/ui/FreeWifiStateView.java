package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.sdk.platformtools.ae;

public class FreeWifiStateView extends ImageView {
    private int bottom;
    private Paint fu;
    private ae hgN;
    private int left;
    int lkG;
    private int lkH;
    private Runnable lkI;
    private Context mContext;
    private int right;
    private int state;
    private int top;

    public FreeWifiStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FreeWifiStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lkG = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lkH = -1;
        this.lkI = new Runnable(this) {
            final /* synthetic */ FreeWifiStateView lXz;

            {
                this.lXz = r1;
            }

            public final void run() {
                this.lXz.invalidate();
            }
        };
        this.mContext = context;
        this.fu = new Paint();
        this.fu.setAntiAlias(true);
        this.fu.setStyle(Style.STROKE);
        this.left = a.fromDPToPix(this.mContext, 2);
        this.top = this.left;
        this.lkH = a.fromDPToPix(this.mContext, 3);
        this.hgN = new ae(Looper.getMainLooper());
    }

    public final void setState(int i) {
        this.state = i;
        lX(10);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.state == 1) {
            int width = getWidth() / 2;
            this.fu.setARGB(255, 103, ag.CTRL_INDEX, 79);
            this.fu.setStrokeWidth((float) this.lkH);
            if (this.right == -1) {
                this.right = (width * 2) - this.left;
            }
            if (this.bottom == -1) {
                this.bottom = this.right;
            }
            canvas.drawArc(new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom), 270.0f, (float) this.lkG, false, this.fu);
            this.lkG += 5;
            if (this.lkG > 365) {
                this.lkG = 0;
            }
            lX(100);
        }
    }

    private void lX(int i) {
        this.hgN.removeCallbacks(this.lkI);
        this.hgN.postDelayed(this.lkI, (long) i);
    }
}
