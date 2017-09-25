package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.mm.R;

public class GameCenterListView extends ListView {
    static boolean mxD;
    static int mxF;
    private View QB;
    private Context mContext;
    private float mxA;
    private int mxB;
    private boolean mxC;
    private boolean mxE;
    private ImageView mxG;
    private ImageView mxH;
    private boolean mxz;
    private Scroller yw;

    public GameCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mxB = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.yw = new Scroller(this.mContext);
        super.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ GameCenterListView mxI;

            {
                this.mxI = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0 && this.mxI.QB != null && this.mxI.QB.getTop() == 0) {
                    this.mxI.mxC = true;
                } else {
                    this.mxI.mxC = false;
                }
            }
        });
    }

    public static void eI(boolean z) {
        mxD = z;
    }

    public static void nG(int i) {
        mxF = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.mxz) {
            this.QB = getChildAt(0);
            this.mxH = (ImageView) this.QB.findViewById(R.h.cFH);
            this.mxG = (ImageView) this.QB.findViewById(R.h.bsI);
            this.mxz = true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!mxD || this.QB == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mxE = false;
                this.mxA = motionEvent.getRawY();
                break;
            case 2:
                if (this.mxC) {
                    if (this.mxE) {
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.mxA);
                    if (this.QB.getPaddingTop() <= mxF + this.mxB) {
                        if (rawY > 0 && Math.abs(rawY) >= this.mxB) {
                            this.mxE = true;
                            this.yw.startScroll(0, this.QB.getPaddingTop(), 0, -this.QB.getPaddingTop(), 500);
                            this.mxG.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                    } else if (this.QB.getPaddingTop() >= (-this.mxB) && rawY < 0 && Math.abs(rawY) >= this.mxB) {
                        this.mxE = true;
                        this.yw.startScroll(0, 0, 0, mxF, 500);
                        this.mxG.setClickable(false);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.QB != null && this.yw.computeScrollOffset()) {
            int currY = this.yw.getCurrY();
            this.QB.setPadding(0, currY, 0, 0);
            float f = (((float) (mxF - currY)) / ((float) mxF)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.mxH.setAlpha(i);
            this.mxG.setAlpha(currY);
            invalidate();
        }
    }
}
