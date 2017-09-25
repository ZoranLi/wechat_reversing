package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.c.f;
import com.tencent.mm.plugin.appbrand.widget.a.b;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Locale;

final class aa<Input extends EditText & y> {
    public final String TAG;
    final float jsF;
    final Input jvr;
    public f jvs;
    public MotionEvent jvt;
    public boolean jvu = false;
    public final Runnable jvv = new Runnable(this) {
        final /* synthetic */ aa jvx;

        {
            this.jvx = r1;
        }

        public final void run() {
            this.jvx.jvu = true;
            w.v(this.jvx.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
            this.jvx.jvr.postDelayed(this.jvx.jvw, (long) ViewConfiguration.getLongPressTimeout());
        }
    };
    public final Runnable jvw = new Runnable(this) {
        final /* synthetic */ aa jvx;

        {
            this.jvx = r1;
        }

        public final void run() {
            if (this.jvx.jvu) {
                f bD = c.bD(this.jvx.jvr);
                if (this.jvx.jvs == null || Math.abs(this.jvx.jvs.x - bD.x) > 1.0f || Math.abs(this.jvx.jvs.y - bD.y) > 1.0f) {
                    w.v(this.jvx.TAG, "check long press timeout, but view has moved.");
                } else if (this.jvx.jvt != null) {
                    this.jvx.jvu = false;
                    this.jvx.jvr.removeCallbacks(this.jvx.jvv);
                }
            }
        }
    };

    aa(Input input) {
        this.jvr = input;
        this.TAG = "MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[]{input.toString()});
        this.jsF = (float) ViewConfiguration.get(input.getContext()).getScaledTouchSlop();
    }

    final void Zr() {
        this.jvu = false;
        this.jvr.removeCallbacks(this.jvv);
        this.jvr.removeCallbacks(this.jvw);
        this.jvs = null;
        if (this.jvt != null) {
            this.jvt.recycle();
            this.jvt = null;
        }
    }

    final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        float x = motionEvent.getX(motionEvent.getActionIndex());
        float y = motionEvent.getY(motionEvent.getActionIndex());
        w.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[]{Float.valueOf(this.jsF), Float.valueOf(x), Float.valueOf(motionEvent2.getX(motionEvent2.getActionIndex())), Float.valueOf(y), Float.valueOf(motionEvent2.getY(motionEvent2.getActionIndex())), b.v(motionEvent), b.v(motionEvent2)});
        if (Math.abs(motionEvent2.getY(motionEvent2.getActionIndex()) - y) > this.jsF || Math.abs(r4 - x) > this.jsF) {
            return false;
        }
        return true;
    }
}
