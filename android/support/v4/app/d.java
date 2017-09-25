package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.q.AnonymousClass4;
import android.support.v4.e.g;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.wcdb.FileUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class d extends p implements Runnable {
    static final boolean nM = (VERSION.SDK_INT >= 21);
    int mIndex = -1;
    String mName;
    final m nN;
    a nO;
    a nP;
    int nQ;
    int nR;
    int nS;
    int nT;
    int nU;
    int nV;
    int nW;
    boolean nX;
    boolean nY = true;
    boolean nZ;
    int oa;
    CharSequence ob;
    int oc;
    CharSequence od;
    ArrayList<String> oe;
    ArrayList<String> of;

    static final class a {
        ArrayList<Fragment> oA;
        a os;
        a ot;
        int ou;
        Fragment ov;
        int ow;
        int ox;
        int oy;
        int oz;

        a() {
        }
    }

    public class b {
        public android.support.v4.e.a<String, String> oB = new android.support.v4.e.a();
        public ArrayList<View> oC = new ArrayList();
        public android.support.v4.app.q.a oD = new android.support.v4.app.q.a();
        public View oE;
        final /* synthetic */ d oh;

        public b(d dVar) {
            this.oh = dVar;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.nZ);
            if (this.nV != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.nV));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.nW));
            }
            if (!(this.nR == 0 && this.nS == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.nR));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.nS));
            }
            if (!(this.nT == 0 && this.nU == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.nT));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.nU));
            }
            if (!(this.oa == 0 && this.ob == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.oa));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.ob);
            }
            if (!(this.oc == 0 && this.od == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.oc));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.od);
            }
        }
        if (this.nO != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            a aVar = this.nO;
            while (aVar != null) {
                String str3;
                switch (aVar.ou) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + aVar.ou;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(aVar.ov);
                if (z) {
                    if (!(aVar.ow == 0 && aVar.ox == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.ow));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.ox));
                    }
                    if (!(aVar.oy == 0 && aVar.oz == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.oy));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.oz));
                    }
                }
                if (aVar.oA != null && aVar.oA.size() > 0) {
                    for (int i2 = 0; i2 < aVar.oA.size(); i2++) {
                        printWriter.print(str2);
                        if (aVar.oA.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.oA.get(i2));
                    }
                }
                aVar = aVar.os;
                i++;
            }
        }
    }

    public d(m mVar) {
        this.nN = mVar;
    }

    final void a(a aVar) {
        if (this.nO == null) {
            this.nP = aVar;
            this.nO = aVar;
        } else {
            aVar.ot = this.nP;
            this.nP.os = aVar;
            this.nP = aVar;
        }
        aVar.ow = this.nR;
        aVar.ox = this.nS;
        aVar.oy = this.nT;
        aVar.oz = this.nU;
        this.nQ++;
    }

    public final p a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public final p a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public final p a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.pg = this.nN;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.pk == 0 || fragment.pk == i) {
                fragment.pk = i;
                fragment.pl = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.pk + " now " + i);
            }
        }
        a aVar = new a();
        aVar.ou = i2;
        aVar.ov = fragment;
        a(aVar);
    }

    public final p b(int i, Fragment fragment) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, null, 2);
        return this;
    }

    public final p a(Fragment fragment) {
        a aVar = new a();
        aVar.ou = 3;
        aVar.ov = fragment;
        a(aVar);
        return this;
    }

    public final p b(Fragment fragment) {
        a aVar = new a();
        aVar.ou = 6;
        aVar.ov = fragment;
        a(aVar);
        return this;
    }

    public final p c(Fragment fragment) {
        a aVar = new a();
        aVar.ou = 7;
        aVar.ov = fragment;
        a(aVar);
        return this;
    }

    public final p g(int i, int i2) {
        this.nR = i;
        this.nS = i2;
        this.nT = 0;
        this.nU = 0;
        return this;
    }

    final void D(int i) {
        if (this.nX) {
            if (m.DEBUG) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i);
            }
            for (a aVar = this.nO; aVar != null; aVar = aVar.os) {
                Fragment fragment;
                if (aVar.ov != null) {
                    fragment = aVar.ov;
                    fragment.pf += i;
                    if (m.DEBUG) {
                        new StringBuilder("Bump nesting of ").append(aVar.ov).append(" to ").append(aVar.ov.pf);
                    }
                }
                if (aVar.oA != null) {
                    for (int size = aVar.oA.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) aVar.oA.get(size);
                        fragment.pf += i;
                        if (m.DEBUG) {
                            new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.pf);
                        }
                    }
                }
            }
        }
    }

    public final int commit() {
        return m(false);
    }

    public final int commitAllowingStateLoss() {
        return m(true);
    }

    private int m(boolean z) {
        if (this.nZ) {
            throw new IllegalStateException("commit already called");
        }
        if (m.DEBUG) {
            new StringBuilder("Commit: ").append(this);
            a("  ", new PrintWriter(new android.support.v4.e.d("FragmentManager")));
        }
        this.nZ = true;
        if (this.nX) {
            this.mIndex = this.nN.a(this);
        } else {
            this.mIndex = -1;
        }
        this.nN.a((Runnable) this, z);
        return this.mIndex;
    }

    public final void run() {
        if (m.DEBUG) {
            new StringBuilder("Run: ").append(this);
        }
        if (!this.nX || this.mIndex >= 0) {
            b a;
            D(1);
            if (!nM || this.nN.qr <= 0) {
                Object obj = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                a(sparseArray, sparseArray2);
                a = a(sparseArray, sparseArray2, false);
            }
            int i = a != null ? 0 : this.nW;
            int i2 = a != null ? 0 : this.nV;
            a aVar = this.nO;
            while (aVar != null) {
                int i3 = a != null ? 0 : aVar.ow;
                int i4 = a != null ? 0 : aVar.ox;
                Fragment fragment;
                switch (aVar.ou) {
                    case 1:
                        fragment = aVar.ov;
                        fragment.pt = i3;
                        this.nN.a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.ov;
                        int i5 = fragment2.pl;
                        if (this.nN.qk != null) {
                            int size = this.nN.qk.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.nN.qk.get(size);
                                if (m.DEBUG) {
                                    new StringBuilder("OP_REPLACE: adding=").append(fragment2).append(" old=").append(fragment);
                                }
                                if (fragment.pl == i5) {
                                    if (fragment == fragment2) {
                                        aVar.ov = null;
                                        fragment = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (aVar.oA == null) {
                                            aVar.oA = new ArrayList();
                                        }
                                        aVar.oA.add(fragment);
                                        fragment.pt = i4;
                                        if (this.nX) {
                                            fragment.pf++;
                                            if (m.DEBUG) {
                                                new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.pf);
                                            }
                                        }
                                        this.nN.a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.pt = i3;
                        this.nN.a(fragment2, false);
                        break;
                    case 3:
                        fragment = aVar.ov;
                        fragment.pt = i4;
                        this.nN.a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = aVar.ov;
                        fragment.pt = i4;
                        this.nN.b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = aVar.ov;
                        fragment.pt = i3;
                        this.nN.c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = aVar.ov;
                        fragment.pt = i4;
                        this.nN.d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = aVar.ov;
                        fragment.pt = i3;
                        this.nN.e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.ou);
                }
                aVar = aVar.os;
            }
            this.nN.a(this.nN.qr, i2, i, true);
            if (this.nX) {
                m mVar = this.nN;
                if (mVar.qm == null) {
                    mVar.qm = new ArrayList();
                }
                mVar.qm.add(this);
                mVar.aZ();
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.pl;
            if (i != 0 && !fragment.pm) {
                if (fragment.isAdded() && fragment.mView != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.pl;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.mState <= 0 && this.nN.qr > 0) {
                this.nN.h(fragment);
                this.nN.a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.nN.qs.onHasView()) {
            for (a aVar = this.nO; aVar != null; aVar = aVar.os) {
                switch (aVar.ou) {
                    case 1:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 2:
                        Fragment fragment = aVar.ov;
                        if (this.nN.qk != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.nN.qk.size(); i++) {
                                Fragment fragment3 = (Fragment) this.nN.qk.get(i);
                                if (fragment2 == null || fragment3.pl == fragment2.pl) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.pl);
                                    } else {
                                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 3:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 4:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 5:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 6:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 7:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.nN.qs.onHasView()) {
            for (a aVar = this.nP; aVar != null; aVar = aVar.ot) {
                switch (aVar.ou) {
                    case 1:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 2:
                        if (aVar.oA != null) {
                            for (int size = aVar.oA.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) aVar.oA.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 3:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 4:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 5:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 6:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    case 7:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.ov);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final b a(boolean z, b bVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (m.DEBUG) {
            new StringBuilder("popFromBackStack: ").append(this);
            a("  ", new PrintWriter(new android.support.v4.e.d("FragmentManager")));
        }
        if (nM && this.nN.qr > 0) {
            if (bVar == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    bVar = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                a(bVar, this.of, this.oe);
            }
        }
        D(-1);
        int i = bVar != null ? 0 : this.nW;
        int i2 = bVar != null ? 0 : this.nV;
        a aVar = this.nP;
        while (aVar != null) {
            int i3 = bVar != null ? 0 : aVar.oy;
            int i4 = bVar != null ? 0 : aVar.oz;
            Fragment fragment;
            Fragment fragment2;
            switch (aVar.ou) {
                case 1:
                    fragment = aVar.ov;
                    fragment.pt = i4;
                    this.nN.a(fragment, m.H(i2), i);
                    break;
                case 2:
                    fragment = aVar.ov;
                    if (fragment != null) {
                        fragment.pt = i4;
                        this.nN.a(fragment, m.H(i2), i);
                    }
                    if (aVar.oA == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < aVar.oA.size(); i5++) {
                        fragment2 = (Fragment) aVar.oA.get(i5);
                        fragment2.pt = i3;
                        this.nN.a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = aVar.ov;
                    fragment2.pt = i3;
                    this.nN.a(fragment2, false);
                    break;
                case 4:
                    fragment2 = aVar.ov;
                    fragment2.pt = i3;
                    this.nN.c(fragment2, m.H(i2), i);
                    break;
                case 5:
                    fragment = aVar.ov;
                    fragment.pt = i4;
                    this.nN.b(fragment, m.H(i2), i);
                    break;
                case 6:
                    fragment2 = aVar.ov;
                    fragment2.pt = i3;
                    this.nN.e(fragment2, m.H(i2), i);
                    break;
                case 7:
                    fragment2 = aVar.ov;
                    fragment2.pt = i3;
                    this.nN.d(fragment2, m.H(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.ou);
            }
            aVar = aVar.ot;
        }
        if (z) {
            this.nN.a(this.nN.qr, m.H(i2), i, true);
            bVar = null;
        }
        if (this.mIndex >= 0) {
            m mVar = this.nN;
            i4 = this.mIndex;
            synchronized (mVar) {
                mVar.qo.set(i4, null);
                if (mVar.qp == null) {
                    mVar.qp = new ArrayList();
                }
                if (m.DEBUG) {
                    mVar.qp.add(Integer.valueOf(i4));
                } else {
                    mVar.qp.add(Integer.valueOf(i4));
                }
            }
            this.mIndex = -1;
        }
        return bVar;
    }

    private b a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        b bVar = new b(this);
        bVar.oE = new View(this.nN.ph.mContext);
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (a(sparseArray.keyAt(i2), bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && a(i4, bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return bVar;
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, android.support.v4.e.a<String, View> aVar, View view) {
        if (obj == null) {
            return obj;
        }
        View view2 = fragment.mView;
        if (obj == null) {
            return obj;
        }
        q.a((ArrayList) arrayList, view2);
        if (aVar != null) {
            arrayList.removeAll(aVar.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view);
        q.b((Transition) obj, arrayList);
        return obj;
    }

    private android.support.v4.e.a<String, View> a(b bVar, Fragment fragment, boolean z) {
        android.support.v4.e.a aVar = new android.support.v4.e.a();
        if (this.oe != null) {
            q.a((Map) aVar, fragment.mView);
            if (z) {
                g.a((Map) aVar, this.of);
            } else {
                aVar = a(this.oe, this.of, aVar);
            }
        }
        ak akVar;
        if (z) {
            if (fragment.pJ != null) {
                akVar = fragment.pJ;
            }
            a(bVar, aVar, false);
        } else {
            if (fragment.pK != null) {
                akVar = fragment.pK;
            }
            b(bVar, aVar, false);
        }
        return aVar;
    }

    private boolean a(int i, b bVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        final View view = (ViewGroup) this.nN.qs.onFindViewById(i);
        if (view == null) {
            return false;
        }
        Object obj;
        Object obj2;
        Transition transition;
        Object obj3;
        android.support.v4.e.a aVar;
        Object obj4;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        final Fragment fragment2 = (Fragment) sparseArray.get(i);
        if (fragment == null) {
            obj = null;
        } else {
            Object obj5 = z ? fragment.pE == Fragment.oQ ? fragment.pD : fragment.pE : fragment.pB;
            obj = q.e(obj5);
        }
        if (fragment == null || fragment2 == null) {
            obj2 = null;
        } else {
            obj5 = z ? fragment2.pG == Fragment.oQ ? fragment2.pF : fragment2.pG : fragment.pF;
            if (obj5 == null) {
                obj2 = null;
            } else {
                transition = (Transition) obj5;
                if (transition == null) {
                    obj2 = null;
                } else {
                    obj2 = new TransitionSet();
                    obj2.addTransition(transition);
                }
            }
        }
        if (fragment2 == null) {
            obj3 = null;
        } else {
            obj5 = z ? fragment2.pC == Fragment.oQ ? fragment2.pB : fragment2.pC : fragment2.pD;
            obj3 = q.e(obj5);
        }
        final ArrayList arrayList = new ArrayList();
        if (obj2 != null) {
            android.support.v4.e.a a = a(bVar, fragment2, z);
            if (a.isEmpty()) {
                aVar = null;
                obj4 = null;
            } else {
                if ((z ? fragment2.pJ : fragment.pJ) != null) {
                    ArrayList arrayList2 = new ArrayList(a.keySet());
                    arrayList2 = new ArrayList(a.values());
                }
                final b bVar2 = bVar;
                final boolean z2 = z;
                view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final /* synthetic */ d oh;

                    public final boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (obj2 != null) {
                            android.support.v4.e.a a;
                            ak akVar;
                            d dVar;
                            b bVar;
                            View view;
                            q.a(obj2, arrayList);
                            arrayList.clear();
                            d dVar2 = this.oh;
                            b bVar2 = bVar2;
                            boolean z = z2;
                            Fragment fragment = fragment;
                            Map aVar = new android.support.v4.e.a();
                            View view2 = fragment.mView;
                            if (!(view2 == null || dVar2.oe == null)) {
                                q.a(aVar, view2);
                                if (z) {
                                    a = d.a(dVar2.oe, dVar2.of, (android.support.v4.e.a) aVar);
                                    if (z) {
                                        if (fragment.pJ != null) {
                                            akVar = fragment.pJ;
                                        }
                                        d.b(bVar2, a, true);
                                    } else {
                                        if (fragment.pK != null) {
                                            akVar = fragment.pK;
                                        }
                                        dVar2.a(bVar2, a, true);
                                    }
                                    q.a(obj2, bVar2.oE, a, arrayList);
                                    dVar = this.oh;
                                    bVar = bVar2;
                                    if (!(dVar.of == null || a.isEmpty())) {
                                        view = (View) a.get(dVar.of.get(0));
                                        if (view != null) {
                                            bVar.oD.rt = view;
                                        }
                                    }
                                    d.a(fragment, fragment2, z2, a);
                                } else {
                                    g.a(aVar, dVar2.of);
                                }
                            }
                            Map map = aVar;
                            if (z) {
                                if (fragment.pJ != null) {
                                    akVar = fragment.pJ;
                                }
                                d.b(bVar2, a, true);
                            } else {
                                if (fragment.pK != null) {
                                    akVar = fragment.pK;
                                }
                                dVar2.a(bVar2, a, true);
                            }
                            q.a(obj2, bVar2.oE, a, arrayList);
                            dVar = this.oh;
                            bVar = bVar2;
                            view = (View) a.get(dVar.of.get(0));
                            if (view != null) {
                                bVar.oD.rt = view;
                            }
                            d.a(fragment, fragment2, z2, a);
                        }
                        return true;
                    }
                });
                aVar = a;
                obj4 = obj2;
            }
        } else {
            aVar = null;
            obj4 = obj2;
        }
        if (obj == null && obj4 == null && obj3 == null) {
            return false;
        }
        Object obj6;
        ArrayList arrayList3 = new ArrayList();
        obj2 = a(obj3, fragment2, arrayList3, aVar, bVar.oE);
        if (!(this.of == null || aVar == null)) {
            View view2 = (View) aVar.get(this.of.get(0));
            if (view2 != null) {
                if (obj2 != null) {
                    q.a(obj2, view2);
                }
                if (obj4 != null) {
                    q.a(obj4, view2);
                }
            }
        }
        android.support.v4.app.q.b anonymousClass1 = new android.support.v4.app.q.b(this) {
            final /* synthetic */ d oh;

            public final View getView() {
                return fragment.mView;
            }
        };
        ArrayList arrayList4 = new ArrayList();
        Map aVar2 = new android.support.v4.e.a();
        if (fragment != null) {
            boolean booleanValue = z ? fragment.pH == null ? true : fragment.pH.booleanValue() : fragment.pI == null ? true : fragment.pI.booleanValue();
            z2 = booleanValue;
        } else {
            z2 = true;
        }
        transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj4;
        if (transition == null || transition2 == null) {
            z2 = true;
        }
        if (z2) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
            }
            obj6 = transitionSet;
        } else {
            if (transition2 != null && transition != null) {
                transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
            } else if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 != null) {
                obj6 = new TransitionSet();
                if (transition != null) {
                    obj6.addTransition(transition);
                }
                obj6.addTransition(transition3);
            } else {
                transition2 = transition;
            }
        }
        if (obj6 != null) {
            View view3 = bVar.oE;
            android.support.v4.app.q.a aVar3 = bVar.oD;
            Map map = bVar.oB;
            if (!(obj == null && obj4 == null)) {
                Transition transition4 = (Transition) obj;
                if (transition4 != null) {
                    transition4.addTarget(view3);
                }
                if (obj4 != null) {
                    q.a(obj4, view3, aVar, arrayList);
                }
                view.getViewTreeObserver().addOnPreDrawListener(new android.support.v4.app.q.AnonymousClass2(view, transition4, view3, anonymousClass1, map, aVar2, arrayList4));
                if (transition4 != null) {
                    transition4.setEpicenterCallback(new android.support.v4.app.q.AnonymousClass3(aVar3));
                }
            }
            final View view4 = view;
            final b bVar3 = bVar;
            final int i2 = i;
            final Object obj7 = obj6;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ d oh;

                public final boolean onPreDraw() {
                    view4.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.oh.a(bVar3, i2, obj7);
                    return true;
                }
            });
            q.a(obj6, bVar.oE, true);
            a(bVar, i, obj6);
            TransitionManager.beginDelayedTransition(view, (Transition) obj6);
            View view5 = bVar.oE;
            ArrayList arrayList5 = bVar.oC;
            Transition transition5 = (Transition) obj;
            Transition transition6 = (Transition) obj2;
            Transition transition7 = (Transition) obj4;
            Transition transition8 = (Transition) obj6;
            if (transition8 != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass4(view, transition5, arrayList4, transition6, arrayList3, transition7, arrayList, aVar2, arrayList5, transition8, view5));
            }
        }
        if (obj6 != null) {
            return true;
        }
        return false;
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z, android.support.v4.e.a<String, View> aVar) {
        if ((z ? fragment2.pJ : fragment.pJ) != null) {
            ArrayList arrayList = new ArrayList(aVar.keySet());
            arrayList = new ArrayList(aVar.values());
        }
    }

    static android.support.v4.e.a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, android.support.v4.e.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        android.support.v4.e.a<String, View> aVar2 = new android.support.v4.e.a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    public final void a(b bVar, int i, Object obj) {
        if (this.nN.qk != null) {
            for (int i2 = 0; i2 < this.nN.qk.size(); i2++) {
                Fragment fragment = (Fragment) this.nN.qk.get(i2);
                if (!(fragment.mView == null || fragment.pu == null || fragment.pl != i)) {
                    if (!fragment.pm) {
                        q.a(obj, fragment.mView, false);
                        bVar.oC.remove(fragment.mView);
                    } else if (!bVar.oC.contains(fragment.mView)) {
                        q.a(obj, fragment.mView, true);
                        bVar.oC.add(fragment.mView);
                    }
                }
            }
        }
    }

    private static void a(android.support.v4.e.a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.valueAt(i))) {
                    aVar.setValueAt(i, str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                a(bVar.oB, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    final void a(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = this.of == null ? 0 : this.of.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.oe.get(i);
            View view = (View) aVar.get((String) this.of.get(i));
            if (view != null) {
                String transitionName = view.getTransitionName();
                if (z) {
                    a(bVar.oB, str, transitionName);
                } else {
                    a(bVar.oB, transitionName, str);
                }
            }
        }
    }

    static void b(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) aVar.keyAt(i);
            String transitionName = ((View) aVar.valueAt(i)).getTransitionName();
            if (z) {
                a(bVar.oB, str, transitionName);
            } else {
                a(bVar.oB, transitionName, str);
            }
        }
    }
}
