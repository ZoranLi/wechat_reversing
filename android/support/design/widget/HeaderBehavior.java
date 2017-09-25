package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private VelocityTracker fk;
    private int fl = -1;
    private Runnable iA;
    public q iB;
    private boolean iC;
    private int iD;
    private int iE = -1;

    private class a implements Runnable {
        private final CoordinatorLayout iF;
        private final V iG;
        final /* synthetic */ HeaderBehavior iH;

        a(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
            this.iH = headerBehavior;
            this.iF = coordinatorLayout;
            this.iG = v;
        }

        public final void run() {
            if (this.iG != null && this.iH.iB != null) {
                if (this.iH.iB.computeScrollOffset()) {
                    this.iH.c(this.iF, this.iG, this.iH.iB.getCurrY());
                    z.a(this.iG, (Runnable) this);
                    return;
                }
                this.iH.a(this.iF, this.iG);
            }
        }
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.iE < 0) {
            this.iE = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.iC) {
            return true;
        }
        int y;
        switch (o.d(motionEvent)) {
            case 0:
                this.iC = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (d(v) && coordinatorLayout.b(v, x, y)) {
                    this.iD = y;
                    this.fl = o.c(motionEvent, 0);
                    ae();
                    break;
                }
            case 1:
            case 3:
                this.iC = false;
                this.fl = -1;
                if (this.fk != null) {
                    this.fk.recycle();
                    this.fk = null;
                    break;
                }
                break;
            case 2:
                y = this.fl;
                if (y != -1) {
                    y = o.b(motionEvent, y);
                    if (y != -1) {
                        y = (int) o.e(motionEvent, y);
                        if (Math.abs(y - this.iD) > this.iE) {
                            this.iC = true;
                            this.iD = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.fk != null) {
            this.fk.addMovement(motionEvent);
        }
        return this.iC;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.iE < 0) {
            this.iE = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (o.d(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.b(v, (int) motionEvent.getX(), y) && d(v)) {
                    this.iD = y;
                    this.fl = o.c(motionEvent, 0);
                    ae();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.fk != null) {
                    this.fk.addMovement(motionEvent);
                    this.fk.computeCurrentVelocity(1000);
                    a(coordinatorLayout, v, -b(v), y.b(this.fk, this.fl));
                    break;
                }
                break;
            case 2:
                int b = o.b(motionEvent, this.fl);
                if (b != -1) {
                    b = (int) o.e(motionEvent, b);
                    int i = this.iD - b;
                    if (!this.iC && Math.abs(i) > this.iE) {
                        this.iC = true;
                        i = i > 0 ? i - this.iE : i + this.iE;
                    }
                    if (this.iC) {
                        this.iD = b;
                        b(coordinatorLayout, v, i, c(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.iC = false;
        this.fl = -1;
        if (this.fk != null) {
            this.fk.recycle();
            this.fk = null;
        }
        if (this.fk != null) {
            this.fk.addMovement(motionEvent);
        }
        return true;
    }

    final int c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int I = I();
        if (i2 == 0 || I < i2 || I > i3) {
            return 0;
        }
        int b = n.b(i, i2, i3);
        if (I == b) {
            return 0;
        }
        f(b);
        return I - b;
    }

    int H() {
        return I();
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, v, H() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, float f) {
        if (this.iA != null) {
            v.removeCallbacks(this.iA);
            this.iA = null;
        }
        if (this.iB == null) {
            this.iB = q.a(v.getContext(), null);
        }
        this.iB.a(I(), 0, Math.round(f), 0, 0, i, 0);
        if (this.iB.computeScrollOffset()) {
            this.iA = new a(this, coordinatorLayout, v);
            z.a((View) v, this.iA);
            return true;
        }
        a(coordinatorLayout, v);
        return false;
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean d(V v) {
        return false;
    }

    int c(V v) {
        return -v.getHeight();
    }

    int b(V v) {
        return v.getHeight();
    }

    private void ae() {
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
    }
}
