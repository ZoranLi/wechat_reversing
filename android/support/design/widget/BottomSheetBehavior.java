package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    private float eX;
    private int eY;
    public int eZ;
    public int fa;
    public boolean fb;
    public u fc;
    private boolean fd;
    private int fe;
    private boolean ff;
    public int fg;
    public WeakReference<V> fh;
    public WeakReference<View> fi;
    public a fj;
    private VelocityTracker fk;
    public int fl;
    private int fn;
    public boolean fo;
    private final android.support.v4.widget.u.a fp = new android.support.v4.widget.u.a(this) {
        final /* synthetic */ BottomSheetBehavior fq;

        {
            this.fq = r1;
        }

        public final boolean b(View view, int i) {
            if (this.fq.mState == 1) {
                return false;
            }
            if (this.fq.fo) {
                return false;
            }
            if (this.fq.mState == 3 && this.fq.fl == i) {
                View view2 = (View) this.fq.fi.get();
                if (view2 != null && z.h(view2, -1)) {
                    return false;
                }
            }
            return this.fq.fh != null && this.fq.fh.get() == view;
        }

        public final void a(View view, int i, int i2) {
            this.fq.i(i2);
        }

        public final void j(int i) {
            if (i == 1) {
                this.fq.h(1);
            }
        }

        public final void a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = this.fq.eZ;
            } else if (this.fq.fb && this.fq.a(view, f2)) {
                i = this.fq.fg;
                i2 = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - this.fq.eZ) < Math.abs(top - this.fq.fa)) {
                    i = this.fq.eZ;
                } else {
                    i = this.fq.fa;
                    i2 = 4;
                }
            } else {
                i = this.fq.fa;
                i2 = 4;
            }
            if (this.fq.fc.q(view.getLeft(), i)) {
                this.fq.h(2);
                z.a(view, new b(this.fq, view, i2));
                return;
            }
            this.fq.h(i2);
        }

        public final int c(View view, int i) {
            return n.b(i, this.fq.eZ, this.fq.fb ? this.fq.fg : this.fq.fa);
        }

        public final int d(View view, int i) {
            return view.getLeft();
        }

        public final int K() {
            if (this.fq.fb) {
                return this.fq.fg - this.fq.eZ;
            }
            return this.fq.fa - this.fq.eZ;
        }
    };
    public int mState = 4;

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final int state;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public static abstract class a {
        public abstract void d(float f);

        public abstract void k(int i);
    }

    private class b implements Runnable {
        final /* synthetic */ BottomSheetBehavior fq;
        private final int fr;
        private final View mView;

        public b(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.fq = bottomSheetBehavior;
            this.mView = view;
            this.fr = i;
        }

        public final void run() {
            if (this.fq.fc == null || !this.fq.fc.cH()) {
                this.fq.h(this.fr);
            } else {
                z.a(this.mView, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bm);
        g(obtainStyledAttributes.getDimensionPixelSize(i.bo, 0));
        this.fb = obtainStyledAttributes.getBoolean(i.bn, false);
        obtainStyledAttributes.recycle();
        this.eX = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, v), this.mState);
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, (View) v, savedState.getSuperState());
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (!(this.mState == 1 || this.mState == 2)) {
            if (z.aa(coordinatorLayout) && !z.aa(v)) {
                z.a((View) v, true);
            }
            coordinatorLayout.e(v, i);
        }
        this.fg = coordinatorLayout.getHeight();
        this.eZ = Math.max(0, this.fg - v.getHeight());
        this.fa = Math.max(this.fg - this.eY, this.eZ);
        if (this.mState == 3) {
            z.j(v, this.eZ);
        } else if (this.fb && this.mState == 5) {
            z.j(v, this.fg);
        } else if (this.mState == 4) {
            z.j(v, this.fa);
        }
        if (this.fc == null) {
            this.fc = u.a(coordinatorLayout, this.fp);
        }
        this.fh = new WeakReference(v);
        this.fi = new WeakReference(h((View) v));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int d = o.d(motionEvent);
        if (d == 0) {
            reset();
        }
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
        this.fk.addMovement(motionEvent);
        switch (d) {
            case 0:
                int x = (int) motionEvent.getX();
                this.fn = (int) motionEvent.getY();
                View view = (View) this.fi.get();
                if (view != null && coordinatorLayout.b(view, x, this.fn)) {
                    this.fl = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.fo = true;
                }
                boolean z = this.fl == -1 && !coordinatorLayout.b(v, x, this.fn);
                this.fd = z;
                break;
            case 1:
            case 3:
                this.fo = false;
                this.fl = -1;
                if (this.fd) {
                    this.fd = false;
                    return false;
                }
                break;
        }
        if (!this.fd && this.fc.j(motionEvent)) {
            return true;
        }
        view = (View) this.fi.get();
        if (d != 2 || view == null || this.fd || this.mState == 1 || coordinatorLayout.b(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.fn) - motionEvent.getY()) <= ((float) this.fc.iE)) {
            return false;
        }
        return true;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int d = o.d(motionEvent);
        if (this.mState == 1 && d == 0) {
            return true;
        }
        this.fc.k(motionEvent);
        if (d == 0) {
            reset();
        }
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
        this.fk.addMovement(motionEvent);
        if (d != 2 || this.fd || Math.abs(((float) this.fn) - motionEvent.getY()) <= ((float) this.fc.iE)) {
            return true;
        }
        this.fc.n(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        this.fe = 0;
        this.ff = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
        if (view == ((View) this.fi.get())) {
            int top = v.getTop();
            int i2 = top - i;
            if (i > 0) {
                if (i2 < this.eZ) {
                    iArr[1] = top - this.eZ;
                    z.j(v, -iArr[1]);
                    h(3);
                } else {
                    iArr[1] = i;
                    z.j(v, -i);
                    h(1);
                }
            } else if (i < 0 && !z.h(view, -1)) {
                if (i2 <= this.fa || this.fb) {
                    iArr[1] = i;
                    z.j(v, -i);
                    h(1);
                } else {
                    iArr[1] = top - this.fa;
                    z.j(v, -iArr[1]);
                    h(4);
                }
            }
            i(v.getTop());
            this.fe = i;
            this.ff = true;
        }
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.eZ) {
            h(3);
        } else if (view == this.fi.get() && this.ff) {
            int i2;
            if (this.fe > 0) {
                i2 = this.eZ;
            } else {
                if (this.fb) {
                    this.fk.computeCurrentVelocity(1000, this.eX);
                    if (a(v, y.b(this.fk, this.fl))) {
                        i2 = this.fg;
                        i = 5;
                    }
                }
                if (this.fe == 0) {
                    int top = v.getTop();
                    if (Math.abs(top - this.eZ) < Math.abs(top - this.fa)) {
                        i2 = this.eZ;
                    } else {
                        i2 = this.fa;
                        i = 4;
                    }
                } else {
                    i2 = this.fa;
                    i = 4;
                }
            }
            if (this.fc.e((View) v, v.getLeft(), i2)) {
                h(2);
                z.a((View) v, new b(this, v, i));
            } else {
                h(i);
            }
            this.ff = false;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.fi.get() && (this.mState != 3 || super.a(coordinatorLayout, (View) v, view, f, f2));
    }

    public final void g(int i) {
        this.eY = Math.max(0, i);
        this.fa = this.fg - i;
    }

    public final void h(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (((View) this.fh.get()) != null && this.fj != null) {
                this.fj.k(i);
            }
        }
    }

    private void reset() {
        this.fl = -1;
        if (this.fk != null) {
            this.fk.recycle();
            this.fk = null;
        }
    }

    public final boolean a(View view, float f) {
        if (view.getTop() >= this.fa && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.fa)) / ((float) this.eY) > 0.5f) {
            return true;
        }
        return false;
    }

    private View h(View view) {
        if (view instanceof p) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View h = h(viewGroup.getChildAt(i));
                if (h != null) {
                    return h;
                }
            }
        }
        return null;
    }

    public final void i(int i) {
        if (((View) this.fh.get()) != null && this.fj != null) {
            if (i > this.fa) {
                this.fj.d(((float) (this.fa - i)) / ((float) this.eY));
            } else {
                this.fj.d(((float) (this.fa - i)) / ((float) (this.fa - this.eZ)));
            }
        }
    }

    public static <V extends View> BottomSheetBehavior<V> i(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof d) {
            Behavior behavior = ((d) layoutParams).hu;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
