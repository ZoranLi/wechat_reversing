package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.w;

public final class k implements OnGestureListener {
    private final Context context;
    private final int wB;
    private final int wC;
    public final GestureDetector wmJ = new GestureDetector(this.context, this);
    public a wmK;
    private final float wmL;
    private final float wmM;

    public interface a {
        void bWk();

        void bWl();

        void bWm();

        void bWn();
    }

    public k(Context context) {
        this.context = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.wB = viewConfiguration.getScaledMinimumFlingVelocity();
        this.wC = viewConfiguration.getScaledMaximumFlingVelocity();
        this.wmL = (float) b.a(context, 70.0f);
        this.wmM = (float) b.a(context, 50.0f);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.wmK == null) {
            return true;
        }
        w.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent2.getY()), Float.valueOf(f), Float.valueOf(f2));
        float abs = Math.abs(motionEvent2.getY() - motionEvent.getY());
        float abs2 = Math.abs(motionEvent2.getX() - motionEvent.getX());
        if (abs < this.wmM && f > 800.0f && abs2 > this.wmL) {
            this.wmK.bWl();
            return true;
        } else if (abs < this.wmM && f < -800.0f && abs2 < (-this.wmL)) {
            this.wmK.bWm();
            return true;
        } else if (abs2 < this.wmM && f2 > 800.0f) {
            this.wmK.bWn();
            return true;
        } else if (abs2 >= this.wmM || f2 >= -800.0f) {
            return false;
        } else {
            this.wmK.bWk();
            return true;
        }
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }
}
