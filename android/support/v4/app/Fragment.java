package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.e.c;
import android.support.v4.e.i;
import android.support.v4.view.h;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.wcdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final i<String, Class<?>> oP = new i();
    static final Object oQ = new Object();
    int mIndex = -1;
    int mState = 0;
    String mTag;
    public View mView;
    View oR;
    int oS;
    Bundle oT;
    SparseArray<Parcelable> oU;
    String oV;
    public Bundle oW;
    Fragment oX;
    int oY = -1;
    int oZ;
    boolean pA;
    Object pB = null;
    Object pC = oQ;
    Object pD = null;
    Object pE = oQ;
    Object pF = null;
    Object pG = oQ;
    Boolean pH;
    Boolean pI;
    ak pJ = null;
    ak pK = null;
    boolean pa;
    public boolean pb;
    boolean pc;
    boolean pd;
    boolean pe;
    int pf;
    m pg;
    k ph;
    m pi;
    public Fragment pj;
    int pk;
    int pl;
    public boolean pm;
    boolean pn;
    boolean po;
    boolean pp;
    boolean pq;
    boolean pr = true;
    boolean ps;
    int pt;
    ViewGroup pu;
    View pv;
    boolean pw;
    boolean px = true;
    t py;
    boolean pz;

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final Bundle pM;

        SavedState(Bundle bundle) {
            this.pM = bundle;
        }

        SavedState(Parcel parcel) {
            this.pM = parcel.readBundle();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.pM);
        }
    }

    public static class a extends RuntimeException {
        public a(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static Fragment b(Context context, String str) {
        return a(context, str, null);
    }

    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) oP.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                oP.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.oW = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (Exception e2) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e22);
        }
    }

    static boolean c(Context context, String str) {
        try {
            Class cls = (Class) oP.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                oP.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void c(int i, Fragment fragment) {
        this.mIndex = i;
        if (fragment != null) {
            this.oV = fragment.oV + ":" + this.mIndex;
        } else {
            this.oV = "android:fragment:" + this.mIndex;
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        c.a(this, stringBuilder);
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.pk != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.pk));
        }
        if (this.mTag != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void setArguments(Bundle bundle) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.oW = bundle;
    }

    public Context getContext() {
        return this.ph == null ? null : this.ph.mContext;
    }

    public final FragmentActivity aG() {
        return this.ph == null ? null : (FragmentActivity) this.ph.qb;
    }

    public final Resources getResources() {
        if (this.ph != null) {
            return this.ph.mContext.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final boolean isAdded() {
        return this.ph != null && this.pa;
    }

    public void onHiddenChanged(boolean z) {
    }

    public final void aH() {
        if (!this.pq) {
            this.pq = true;
            if (isAdded() && !this.pm) {
                this.ph.aT();
            }
        }
    }

    public final void setMenuVisibility(boolean z) {
        if (this.pr != z) {
            this.pr = z;
            if (this.pq && isAdded() && !this.pm) {
                this.ph.aT();
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.px && z && this.mState < 4) {
            this.pg.f(this);
        }
        this.px = z;
        this.pw = !z;
    }

    public boolean getUserVisibleHint() {
        return this.px;
    }

    public final s aI() {
        if (this.py != null) {
            return this.py;
        }
        if (this.ph == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.pA = true;
        this.py = this.ph.a(this.oV, this.pz, true);
        return this.py;
    }

    public void startActivity(Intent intent) {
        if (this.ph == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.ph.b(this, intent, -1, null);
    }

    public final void startActivityForResult(Intent intent, int i) {
        if (this.ph == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.ph.b(this, intent, i, null);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public static void aJ() {
    }

    public LayoutInflater c(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = this.ph.onGetLayoutInflater();
        if (this.pi == null) {
            aN();
            if (this.mState >= 5) {
                this.pi.dispatchResume();
            } else if (this.mState >= 4) {
                this.pi.dispatchStart();
            } else if (this.mState >= 2) {
                this.pi.dispatchActivityCreated();
            } else if (this.mState > 0) {
                this.pi.dispatchCreate();
            }
        }
        h.a(onGetLayoutInflater, this.pi);
        return onGetLayoutInflater;
    }

    public final void aK() {
        this.ps = true;
        if ((this.ph == null ? null : this.ph.qb) != null) {
            this.ps = false;
            this.ps = true;
        }
    }

    public void onAttach(Context context) {
        this.ps = true;
        Activity activity = this.ph == null ? null : this.ph.qb;
        if (activity != null) {
            this.ps = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.ps = true;
    }

    public static Animation aL() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        this.ps = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void aM() {
    }

    public void onActivityCreated(Bundle bundle) {
        this.ps = true;
    }

    public void onStart() {
        this.ps = true;
        if (!this.pz) {
            this.pz = true;
            if (!this.pA) {
                this.pA = true;
                this.py = this.ph.a(this.oV, this.pz, false);
            }
            if (this.py != null) {
                this.py.bd();
            }
        }
    }

    public void onResume() {
        this.ps = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.ps = true;
    }

    public void onPause() {
        this.ps = true;
    }

    public void onStop() {
        this.ps = true;
    }

    public void onLowMemory() {
        this.ps = true;
    }

    public void onDestroyView() {
        this.ps = true;
    }

    public void onDestroy() {
        this.ps = true;
        if (!this.pA) {
            this.pA = true;
            this.py = this.ph.a(this.oV, this.pz, false);
        }
        if (this.py != null) {
            this.py.bi();
        }
    }

    public void onDetach() {
        this.ps = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public static void onDestroyOptionsMenu() {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        aG().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.pk));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.pl));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.oV);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.pf);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.pa);
        printWriter.print(" mRemoving=");
        printWriter.print(this.pb);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.pc);
        printWriter.print(" mInLayout=");
        printWriter.println(this.pd);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.pm);
        printWriter.print(" mDetached=");
        printWriter.print(this.pn);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.pr);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.pq);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.po);
        printWriter.print(" mRetaining=");
        printWriter.print(this.pp);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.px);
        if (this.pg != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.pg);
        }
        if (this.ph != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.ph);
        }
        if (this.pj != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.pj);
        }
        if (this.oW != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.oW);
        }
        if (this.oT != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.oT);
        }
        if (this.oU != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.oU);
        }
        if (this.oX != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.oX);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.oZ);
        }
        if (this.pt != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.pt);
        }
        if (this.pu != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.pu);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.pv != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (this.oR != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.oR);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.oS);
        }
        if (this.py != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.py.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.pi != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.pi + ":");
            this.pi.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    final void aN() {
        this.pi = new m();
        this.pi.a(this.ph, new i(this) {
            final /* synthetic */ Fragment pL;

            {
                this.pL = r1;
            }

            public final View onFindViewById(int i) {
                if (this.pL.mView != null) {
                    return this.pL.mView.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public final boolean onHasView() {
                return this.pL.mView != null;
            }
        }, this);
    }

    final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.pi != null) {
            this.pi.qw = false;
        }
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    final void d(Bundle bundle) {
        onSaveInstanceState(bundle);
        if (this.pi != null) {
            Parcelable saveAllState = this.pi.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable("android:support:fragments", saveAllState);
            }
        }
    }

    final void aO() {
        if (this.pi != null) {
            this.pi.G(2);
        }
        this.mState = 2;
        if (this.pz) {
            this.pz = false;
            if (!this.pA) {
                this.pA = true;
                this.py = this.ph.a(this.oV, this.pz, false);
            }
            if (this.py == null) {
                return;
            }
            if (this.ph.qe) {
                this.py.bf();
            } else {
                this.py.be();
            }
        }
    }
}
