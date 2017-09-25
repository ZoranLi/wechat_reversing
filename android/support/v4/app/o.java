package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class o extends u {
    private final l qR;
    private p qS = null;
    private Fragment qT = null;
    private ArrayList<SavedState> qW = new ArrayList();
    private ArrayList<Fragment> qX = new ArrayList();

    public abstract Fragment I(int i);

    public o(l lVar) {
        this.qR = lVar;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.qX.size() > i) {
            Fragment fragment = (Fragment) this.qX.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.qS == null) {
            this.qS = this.qR.aV();
        }
        Fragment I = I(i);
        if (this.qW.size() > i) {
            SavedState savedState = (SavedState) this.qW.get(i);
            if (savedState != null) {
                if (I.mIndex >= 0) {
                    throw new IllegalStateException("Fragment already active");
                }
                Bundle bundle;
                if (savedState == null || savedState.pM == null) {
                    bundle = null;
                } else {
                    bundle = savedState.pM;
                }
                I.oT = bundle;
            }
        }
        while (this.qX.size() <= i) {
            this.qX.add(null);
        }
        I.setMenuVisibility(false);
        I.setUserVisibleHint(false);
        this.qX.set(i, I);
        this.qS.a(viewGroup.getId(), I);
        return I;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.qS == null) {
            this.qS = this.qR.aV();
        }
        while (this.qW.size() <= i) {
            this.qW.add(null);
        }
        this.qW.set(i, fragment.isAdded() ? this.qR.e(fragment) : null);
        this.qX.set(i, null);
        this.qS.a(fragment);
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
        Bundle bundle = null;
        if (this.qW.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.qW.size()];
            this.qW.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.qX.size(); i++) {
            Fragment fragment = (Fragment) this.qX.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.qR.a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public final void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.qW.clear();
            this.qX.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.qW.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment c = this.qR.c(bundle, str);
                    if (c != null) {
                        while (this.qX.size() <= parseInt) {
                            this.qX.add(null);
                        }
                        c.setMenuVisibility(false);
                        this.qX.set(parseInt, c);
                    }
                }
            }
        }
    }
}
