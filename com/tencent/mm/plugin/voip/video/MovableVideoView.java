package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.s;

public class MovableVideoView extends OpenGlView {
    int aar;
    private OnClickListener mOnClickListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private float ojW;
    private float ojX;
    int rpe;
    private int rpf;
    private int rpg;
    private long rph;

    public MovableVideoView(Context context) {
        this(context, null);
    }

    public MovableVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aar = 320;
        this.rpe = 240;
        this.rpf = 800;
        this.rpg = 480;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        w.d("MicroMsg.MovableVideoView", "event: " + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 0:
                this.ojW = motionEvent.getRawX();
                this.ojX = motionEvent.getRawY();
                this.rph = System.currentTimeMillis();
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (this.rph != 0 && currentTimeMillis - this.rph < 300 && currentTimeMillis - this.rph >= 0 && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                g.oUh.i(11079, new Object[]{Integer.valueOf(2)});
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.ojW;
                float rawY = motionEvent.getRawY() - this.ojX;
                if (Math.abs(rawX) > 1.0f || Math.abs(rawY) > 1.0f) {
                    LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                    int i2 = (int) (rawX + ((float) layoutParams.leftMargin));
                    int i3 = (int) (rawY + ((float) layoutParams.topMargin));
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > this.rpg) {
                        i2 = this.rpg;
                    }
                    layoutParams.leftMargin = i2;
                    if (i3 >= 0) {
                        i = i3 > this.rpf ? this.rpf : i3;
                    }
                    layoutParams.topMargin = i;
                    setLayoutParams(layoutParams);
                    this.ojW = motionEvent.getRawX();
                    this.ojX = motionEvent.getRawY();
                    break;
                }
        }
        return true;
    }

    public final void dn(int i, int i2) {
        this.aar = i;
        this.rpe = i2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.mScreenWidth == 0) {
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(i, i2);
        layoutParams.topMargin = a.fromDPToPix(getContext(), 12) + s.eR(getContext());
        layoutParams.leftMargin = ((this.mScreenWidth - this.aar) - layoutParams.topMargin) + s.eR(getContext());
        setLayoutParams(layoutParams);
        this.rpf = this.mScreenHeight - this.rpe;
        this.rpg = this.mScreenWidth - this.aar;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    public final void do(int i, int i2) {
        dn(i, i2);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void dp(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i, i2);
        layoutParams2.leftMargin = layoutParams.leftMargin;
        layoutParams2.topMargin = layoutParams.topMargin;
        this.aar = i;
        this.rpe = i2;
        setLayoutParams(layoutParams2);
    }
}
