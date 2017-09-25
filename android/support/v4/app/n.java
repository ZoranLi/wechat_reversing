package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;

public abstract class n extends u {
    private final l qR;
    private p qS = null;
    private Fragment qT = null;

    public abstract Fragment I(int i);

    public n(l lVar) {
        this.qR = lVar;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.qS == null) {
            this.qS = this.qR.aV();
        }
        long j = (long) i;
        Fragment k = this.qR.k(b(viewGroup.getId(), j));
        if (k != null) {
            this.qS.c(k);
        } else {
            k = I(i);
            this.qS.a(viewGroup.getId(), k, b(viewGroup.getId(), j));
        }
        if (k != this.qT) {
            k.setMenuVisibility(false);
            k.setUserVisibleHint(false);
        }
        return k;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.qS == null) {
            this.qS = this.qR.aV();
        }
        this.qS.b((Fragment) obj);
    }

    public final void d(Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.qT) {
            if (this.qT != null) {
                this.qT.setMenuVisibility(false);
                this.qT.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.qT = fragment;
        }
    }

    public final void ba() {
        if (this.qS != null) {
            this.qS.commitAllowingStateLoss();
            this.qS = null;
            this.qR.executePendingTransactions();
        }
    }

    public final boolean a(View view, Object obj) {
        return ((Fragment) obj).mView == view;
    }

    public final Parcelable bb() {
        return null;
    }

    public final void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    private static String b(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
