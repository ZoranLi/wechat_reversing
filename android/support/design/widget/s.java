package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class s<V extends View> extends Behavior<V> {
    public u fc;
    private boolean fd;
    private final android.support.v4.widget.u.a fp = new android.support.v4.widget.u.a(this) {
        private int fl = -1;
        private int jN;
        final /* synthetic */ s jO;

        {
            this.jO = r2;
        }

        public final boolean b(View view, int i) {
            return this.fl == -1 && this.jO.r(view);
        }

        public final void f(View view, int i) {
            this.fl = i;
            this.jN = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public final void j(int i) {
            if (this.jO.jG != null) {
                this.jO.jG.w(i);
            }
        }

        public final void a(View view, float f, float f2) {
            boolean z;
            int i;
            boolean z2 = true;
            this.fl = -1;
            int width = view.getWidth();
            if (f != 0.0f) {
                z = z.J(view) == 1;
                z = this.jO.jJ == 2 ? true : this.jO.jJ == 0 ? z ? f < 0.0f : f > 0.0f : this.jO.jJ == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                z = Math.abs(view.getLeft() - this.jN) >= Math.round(((float) view.getWidth()) * this.jO.jK);
            }
            if (z) {
                i = view.getLeft() < this.jN ? this.jN - width : this.jN + width;
            } else {
                i = this.jN;
                z2 = false;
            }
            if (this.jO.fc.q(i, view.getTop())) {
                z.a(view, new b(this.jO, view, z2));
            } else if (z2 && this.jO.jG != null) {
                this.jO.jG.onDismiss(view);
            }
        }

        public final int s(View view) {
            return view.getWidth();
        }

        public final int d(View view, int i) {
            int width;
            int i2;
            Object obj = z.J(view) == 1 ? 1 : null;
            if (this.jO.jJ == 0) {
                if (obj != null) {
                    width = this.jN - view.getWidth();
                    i2 = this.jN;
                } else {
                    width = this.jN;
                    i2 = this.jN + view.getWidth();
                }
            } else if (this.jO.jJ != 1) {
                width = this.jN - view.getWidth();
                i2 = this.jN + view.getWidth();
            } else if (obj != null) {
                width = this.jN;
                i2 = this.jN + view.getWidth();
            } else {
                width = this.jN - view.getWidth();
                i2 = this.jN;
            }
            return s.d(width, i, i2);
        }

        public final int c(View view, int i) {
            return view.getTop();
        }

        public final void a(View view, int i, int i2) {
            float width = ((float) this.jN) + (((float) view.getWidth()) * this.jO.jL);
            float width2 = ((float) this.jN) + (((float) view.getWidth()) * this.jO.jM);
            if (((float) i) <= width) {
                z.d(view, 1.0f);
            } else if (((float) i) >= width2) {
                z.d(view, 0.0f);
            } else {
                z.d(view, s.l(1.0f - s.c(width, width2, (float) i)));
            }
        }
    };
    public a jG;
    private float jH = 0.0f;
    private boolean jI;
    public int jJ = 2;
    public float jK = 0.5f;
    public float jL = 0.0f;
    public float jM = 0.5f;

    public interface a {
        void onDismiss(View view);

        void w(int i);
    }

    private class b implements Runnable {
        final /* synthetic */ s jO;
        private final boolean jP;
        private final View mView;

        b(s sVar, View view, boolean z) {
            this.jO = sVar;
            this.mView = view;
            this.jP = z;
        }

        public final void run() {
            if (this.jO.fc != null && this.jO.fc.cH()) {
                z.a(this.mView, (Runnable) this);
            } else if (this.jP && this.jO.jG != null) {
                this.jO.jG.onDismiss(this.mView);
            }
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (o.d(motionEvent)) {
            case 1:
            case 3:
                if (this.fd) {
                    this.fd = false;
                    return false;
                }
                break;
            default:
                boolean z;
                if (coordinatorLayout.b(v, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    z = false;
                } else {
                    z = true;
                }
                this.fd = z;
                break;
        }
        if (this.fd) {
            return false;
        }
        if (this.fc == null) {
            u a;
            if (this.jI) {
                a = u.a((ViewGroup) coordinatorLayout, this.jH, this.fp);
            } else {
                a = u.a(coordinatorLayout, this.fp);
            }
            this.fc = a;
        }
        return this.fc.j(motionEvent);
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.fc == null) {
            return false;
        }
        this.fc.k(motionEvent);
        return true;
    }

    public boolean r(View view) {
        return true;
    }

    public static float l(float f) {
        return Math.min(Math.max(0.0f, f), 1.0f);
    }

    public static int d(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    static float c(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
