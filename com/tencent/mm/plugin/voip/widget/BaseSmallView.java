package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public abstract class BaseSmallView extends FrameLayout {
    protected ae jsW;
    private WindowManager kSs;
    private OnClickListener mOnClickListener;
    private long mStartTime;
    CaptureView rhA;
    protected long rhL;
    private PointF rqI = new PointF();
    private Point rqJ = new Point();
    private Point rqK = new Point();
    private Point rqL = new Point();
    private Point rqM;
    private Runnable rqN = new Runnable(this) {
        final /* synthetic */ BaseSmallView rqO;

        {
            this.rqO = r1;
        }

        public final void run() {
            float currentTimeMillis = (((float) (System.currentTimeMillis() - this.rqO.mStartTime)) * 1.0f) / 200.0f;
            if (currentTimeMillis <= 1.0f) {
                this.rqO.jsW.postDelayed(this.rqO.rqN, 5);
                this.rqO.dr(this.rqO.rqK.x + ((int) (((((float) this.rqO.rqL.x) * 1.0f) - ((float) this.rqO.rqK.x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) this.rqO.rqL.y) * 1.0f) - ((float) this.rqO.rqK.y)))) + this.rqO.rqK.y);
                return;
            }
            this.rqO.dr(this.rqO.rqL.x, this.rqO.rqL.y);
            this.rqO.onAnimationEnd();
        }
    };

    public abstract void a(CaptureView captureView);

    public abstract void brc();

    public abstract void brd();

    public abstract void onAnimationEnd();

    public void a(int i, int i2, int[] iArr) {
    }

    public void bpR() {
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
    }

    public void dq(int i, int i2) {
    }

    public void uninit() {
        this.jsW.removeCallbacks(this.rqN);
        this.kSs = null;
        if (this.rhA != null) {
            removeView(this.rhA);
            this.rhA = null;
            w.d("MicroMsg.Voip.BaseSmallView", "CaptureView removed");
        }
    }

    public BaseSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kSs = (WindowManager) context.getSystemService("window");
        this.jsW = new ae();
        this.rqM = new Point(this.kSs.getDefaultDisplay().getWidth(), this.kSs.getDefaultDisplay().getHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.rqI.x = motionEvent.getRawX();
                this.rqI.y = motionEvent.getRawY();
                LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                this.rqJ.x = layoutParams.x;
                this.rqJ.y = layoutParams.y;
                break;
            case 1:
                if (Math.abs(motionEvent.getRawX() - this.rqI.x) < ((float) b.a(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.rqI.y) < ((float) b.a(getContext(), 3.0f)) && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                brc();
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                this.rqK.x = (int) Math.max(Math.min((rawX + ((float) this.rqJ.x)) - this.rqI.x, (float) this.rqM.x), 0.0f);
                this.rqK.y = (int) Math.max(Math.min((rawY + ((float) this.rqJ.y)) - this.rqI.y, (float) this.rqM.y), 0.0f);
                int a = b.a(getContext(), 5.0f);
                if (this.rqK.x + (getWidth() / 2) <= this.rqM.x / 2) {
                    this.rqL.x = a;
                } else {
                    this.rqL.x = (this.rqM.x - getWidth()) - a;
                }
                this.rqL.y = this.rqK.y;
                this.mStartTime = System.currentTimeMillis();
                this.jsW.postDelayed(this.rqN, 5);
                brd();
                break;
            case 2:
                dr((int) Math.max(Math.min((((float) this.rqJ.x) + motionEvent.getRawX()) - this.rqI.x, (float) this.rqM.x), 0.0f), (int) Math.max(Math.min((((float) this.rqJ.y) + motionEvent.getRawY()) - this.rqI.y, (float) this.rqM.y), 0.0f));
                break;
        }
        return true;
    }

    private void dr(int i, int i2) {
        if (this.kSs != null) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            w.d("MicroMsg.Voip.BaseSmallView", "updateWindowPosition, x: %d, y: %d", new Object[]{Integer.valueOf(layoutParams.x), Integer.valueOf(layoutParams.y)});
            try {
                this.kSs.updateViewLayout(this, layoutParams);
            } catch (Throwable th) {
                w.printErrStackTrace("MicroMsg.Voip.BaseSmallView", th, "", new Object[0]);
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void dS(long j) {
        this.rhL = j;
    }
}
