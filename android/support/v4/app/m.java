package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.e.c;
import android.support.v4.e.d;
import android.support.v4.view.k;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.wcdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class m extends l implements k {
    static boolean DEBUG = false;
    static final Interpolator qD = new DecelerateInterpolator(2.5f);
    static final Interpolator qE = new DecelerateInterpolator(DownloadHelper.SAVE_FATOR);
    static final Interpolator qF = new AccelerateInterpolator(2.5f);
    static final Interpolator qG = new AccelerateInterpolator(DownloadHelper.SAVE_FATOR);
    static final boolean qf;
    static Field qu = null;
    k ph;
    Bundle qA = null;
    SparseArray<Parcelable> qB = null;
    Runnable qC = new Runnable(this) {
        final /* synthetic */ m qH;

        {
            this.qH = r1;
        }

        public final void run() {
            this.qH.execPendingActions();
        }
    };
    ArrayList<Runnable> qg;
    Runnable[] qh;
    boolean qi;
    ArrayList<Fragment> qj;
    ArrayList<Fragment> qk;
    ArrayList<Integer> ql;
    ArrayList<d> qm;
    ArrayList<Fragment> qn;
    ArrayList<d> qo;
    ArrayList<Integer> qp;
    ArrayList<Object> qq;
    int qr = 0;
    i qs;
    Fragment qt;
    boolean qv;
    boolean qw;
    boolean qx;
    String qy;
    boolean qz;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ m qH;
        final /* synthetic */ int qI = 1;
        final /* synthetic */ int val$id;

        AnonymousClass3(m mVar, int i, int i2) {
            this.qH = mVar;
            this.val$id = i;
        }

        public final void run() {
            m mVar = this.qH;
            k kVar = this.qH.ph;
            mVar.h(this.val$id, this.qI);
        }
    }

    static class a implements AnimationListener {
        public View mView = null;
        private AnimationListener qK = null;
        private boolean qL = false;

        public a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.mView = view;
            }
        }

        public a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.qK = animationListener;
                this.mView = view;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.mView != null) {
                this.qL = m.a(this.mView, animation);
                if (this.qL) {
                    this.mView.post(new Runnable(this) {
                        final /* synthetic */ a qM;

                        {
                            this.qM = r1;
                        }

                        public final void run() {
                            z.a(this.qM.mView, 2, null);
                        }
                    });
                }
            }
            if (this.qK != null) {
                this.qK.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.mView != null && this.qL) {
                this.mView.post(new Runnable(this) {
                    final /* synthetic */ a qM;

                    {
                        this.qM = r1;
                    }

                    public final void run() {
                        z.a(this.qM.mView, 0, null);
                    }
                });
            }
            if (this.qK != null) {
                this.qK.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.qK != null) {
                this.qK.onAnimationRepeat(animation);
            }
        }
    }

    static class b {
        public static final int[] qN = new int[]{16842755, 16842960, 16842961};
    }

    m() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        qf = z;
    }

    static boolean a(View view, Animation animation) {
        if (VERSION.SDK_INT < 19 || z.I(view) != 0 || !z.ad(view)) {
            return false;
        }
        boolean z;
        if (animation instanceof AlphaAnimation) {
            z = true;
        } else {
            if (animation instanceof AnimationSet) {
                List animations = ((AnimationSet) animation).getAnimations();
                for (int i = 0; i < animations.size(); i++) {
                    if (animations.get(i) instanceof AlphaAnimation) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    private void a(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new d("FragmentManager"));
        if (this.ph != null) {
            try {
                this.ph.a("  ", printWriter, new String[0]);
            } catch (Exception e) {
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
            }
        }
        throw runtimeException;
    }

    public final p aV() {
        return new d(this);
    }

    public final boolean executePendingTransactions() {
        return execPendingActions();
    }

    public final void popBackStack() {
        a(new Runnable(this) {
            final /* synthetic */ m qH;

            {
                this.qH = r1;
            }

            public final void run() {
                m mVar = this.qH;
                k kVar = this.qH.ph;
                mVar.h(-1, 0);
            }
        }, false);
    }

    public final boolean popBackStackImmediate() {
        aY();
        execPendingActions();
        return h(-1, 0);
    }

    public final void F(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new AnonymousClass3(this, i, 1), false);
    }

    public final void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public final Fragment c(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.qj.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.qj.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public final List<Fragment> aW() {
        return this.qj;
    }

    public final SavedState e(Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        Bundle j = j(fragment);
        if (j != null) {
            return new SavedState(j);
        }
        return null;
    }

    public final boolean isDestroyed() {
        return this.qx;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.qt != null) {
            c.a(this.qt, stringBuilder);
        } else {
            c.a(this.ph, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.qj != null) {
            size = this.qj.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.qj.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.qk != null) {
            size = this.qk.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.qk.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.qn != null) {
            size = this.qn.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.qn.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.qm != null) {
            size = this.qm.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    d dVar = (d) this.qm.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(dVar.toString());
                    dVar.a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.qo != null) {
                int size2 = this.qo.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        dVar = (d) this.qo.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(dVar);
                    }
                }
            }
            if (this.qp != null && this.qp.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.qp.toArray()));
            }
        }
        if (this.qg != null) {
            i = this.qg.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.qg.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.ph);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.qs);
        if (this.qt != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.qt);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.qr);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.qw);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.qx);
        if (this.qv) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.qv);
        }
        if (this.qy != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.qy);
        }
        if (this.ql != null && this.ql.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.ql.toArray()));
        }
    }

    private static Animation a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(qD);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(qE);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private static Animation f(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(qE);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    private Animation a(Fragment fragment, int i, boolean z, int i2) {
        int i3 = fragment.pt;
        Fragment.aL();
        if (fragment.pt != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.ph.mContext, fragment.pt);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        Object obj = -1;
        switch (i) {
            case 4097:
                if (!z) {
                    obj = 2;
                    break;
                }
                obj = 1;
                break;
            case 4099:
                if (!z) {
                    obj = 6;
                    break;
                }
                obj = 5;
                break;
            case 8194:
                if (!z) {
                    obj = 4;
                    break;
                }
                obj = 3;
                break;
        }
        if (obj < null) {
            return null;
        }
        switch (obj) {
            case 1:
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return f(0.0f, 1.0f);
            case 6:
                return f(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.ph.onHasWindowAnimations()) {
                    i2 = this.ph.onGetWindowAnimations();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public final void f(Fragment fragment) {
        if (!fragment.pw) {
            return;
        }
        if (this.qi) {
            this.qz = true;
            return;
        }
        fragment.pw = false;
        a(fragment, this.qr, 0, 0, false);
    }

    private static void b(View view, Animation animation) {
        if (view != null && animation != null && a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (qu == null) {
                    Field declaredField = Animation.class.getDeclaredField("mListener");
                    qu = declaredField;
                    declaredField.setAccessible(true);
                }
                animationListener = (AnimationListener) qu.get(animation);
            } catch (NoSuchFieldException e) {
                animationListener = null;
            } catch (IllegalAccessException e2) {
                animationListener = null;
            }
            animation.setAnimationListener(new a(view, animation, animationListener));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(final android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.pa;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.pn;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.pb;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.mState;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.mState;
    L_0x001a:
        r0 = r11.pw;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.mState;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.mState;
        if (r0 >= r12) goto L_0x038c;
    L_0x0029:
        r0 = r11.pc;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.pd;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.oR;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.oR = r7;
        r2 = r11.oS;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.mState;
        switch(r0) {
            case 0: goto L_0x006f;
            case 1: goto L_0x0196;
            case 2: goto L_0x02d9;
            case 3: goto L_0x02d9;
            case 4: goto L_0x0331;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.mState;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = new java.lang.StringBuilder;
        r1 = "moveToState: Fragment state for ";
        r0.<init>(r1);
        r0 = r0.append(r11);
        r1 = " not updated inline; expected state ";
        r0 = r0.append(r1);
        r0 = r0.append(r12);
        r1 = " found ";
        r0 = r0.append(r1);
        r1 = r11.mState;
        r0.append(r1);
        r11.mState = r12;
        goto L_0x0031;
    L_0x006f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x007e;
    L_0x0073:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x007e:
        r0 = r11.oT;
        if (r0 == 0) goto L_0x00c8;
    L_0x0082:
        r0 = r11.oT;
        r1 = r10.ph;
        r1 = r1.mContext;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.oT;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.oU = r0;
        r0 = r11.oT;
        r1 = "android:target_state";
        r0 = r10.c(r0, r1);
        r11.oX = r0;
        r0 = r11.oX;
        if (r0 == 0) goto L_0x00b4;
    L_0x00a9:
        r0 = r11.oT;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.oZ = r0;
    L_0x00b4:
        r0 = r11.oT;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.px = r0;
        r0 = r11.px;
        if (r0 != 0) goto L_0x00c8;
    L_0x00c3:
        r11.pw = r5;
        if (r12 <= r6) goto L_0x00c8;
    L_0x00c7:
        r12 = r6;
    L_0x00c8:
        r0 = r10.ph;
        r11.ph = r0;
        r0 = r10.qt;
        r11.pj = r0;
        r0 = r10.qt;
        if (r0 == 0) goto L_0x0104;
    L_0x00d4:
        r0 = r10.qt;
        r0 = r0.pi;
    L_0x00d8:
        r11.pg = r0;
        r11.ps = r3;
        r0 = r10.ph;
        r0 = r0.mContext;
        r11.onAttach(r0);
        r0 = r11.ps;
        if (r0 != 0) goto L_0x0109;
    L_0x00e7:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0104:
        r0 = r10.ph;
        r0 = r0.pg;
        goto L_0x00d8;
    L_0x0109:
        r0 = r11.pj;
        r0 = r11.pp;
        if (r0 != 0) goto L_0x015d;
    L_0x010f:
        r0 = r11.oT;
        r1 = r11.pi;
        if (r1 == 0) goto L_0x0119;
    L_0x0115:
        r1 = r11.pi;
        r1.qw = r3;
    L_0x0119:
        r11.mState = r5;
        r11.ps = r3;
        r11.onCreate(r0);
        r1 = r11.ps;
        if (r1 != 0) goto L_0x0141;
    L_0x0124:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onCreate()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0141:
        if (r0 == 0) goto L_0x015d;
    L_0x0143:
        r1 = "android:support:fragments";
        r0 = r0.getParcelable(r1);
        if (r0 == 0) goto L_0x015d;
    L_0x014c:
        r1 = r11.pi;
        if (r1 != 0) goto L_0x0153;
    L_0x0150:
        r11.aN();
    L_0x0153:
        r1 = r11.pi;
        r1.restoreAllState(r0, r7);
        r0 = r11.pi;
        r0.dispatchCreate();
    L_0x015d:
        r11.pp = r3;
        r0 = r11.pc;
        if (r0 == 0) goto L_0x0196;
    L_0x0163:
        r0 = r11.oT;
        r0 = r11.c(r0);
        r1 = r11.oT;
        r0 = r11.a(r0, r7, r1);
        r11.mView = r0;
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0286;
    L_0x0175:
        r0 = r11.mView;
        r11.pv = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x027c;
    L_0x017f:
        r0 = r11.mView;
        android.support.v4.view.z.ac(r0);
    L_0x0184:
        r0 = r11.pm;
        if (r0 == 0) goto L_0x018f;
    L_0x0188:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x018f:
        r0 = r11.mView;
        r0 = r11.oT;
        r11.aM();
    L_0x0196:
        if (r12 <= r5) goto L_0x02d9;
    L_0x0198:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x01a7;
    L_0x019c:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x01a7:
        r0 = r11.pc;
        if (r0 != 0) goto L_0x0249;
    L_0x01ab:
        r0 = r11.pl;
        if (r0 == 0) goto L_0x05c4;
    L_0x01af:
        r0 = r10.qs;
        r1 = r11.pl;
        r0 = r0.onFindViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01fd;
    L_0x01bb:
        r1 = r11.pe;
        if (r1 != 0) goto L_0x01fd;
    L_0x01bf:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r4 = "No view found for id 0x";
        r2.<init>(r4);
        r4 = r11.pl;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.getResources();
        r8 = r11.pl;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.a(r1);
    L_0x01fd:
        r11.pu = r0;
        r1 = r11.oT;
        r1 = r11.c(r1);
        r2 = r11.oT;
        r1 = r11.a(r1, r0, r2);
        r11.mView = r1;
        r1 = r11.mView;
        if (r1 == 0) goto L_0x0293;
    L_0x0211:
        r1 = r11.mView;
        r11.pv = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x028a;
    L_0x021b:
        r1 = r11.mView;
        android.support.v4.view.z.ac(r1);
    L_0x0220:
        if (r0 == 0) goto L_0x0237;
    L_0x0222:
        r1 = r10.a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0232;
    L_0x0228:
        r2 = r11.mView;
        b(r2, r1);
        r2 = r11.mView;
        r2.startAnimation(r1);
    L_0x0232:
        r1 = r11.mView;
        r0.addView(r1);
    L_0x0237:
        r0 = r11.pm;
        if (r0 == 0) goto L_0x0242;
    L_0x023b:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0242:
        r0 = r11.mView;
        r0 = r11.oT;
        r11.aM();
    L_0x0249:
        r0 = r11.oT;
        r1 = r11.pi;
        if (r1 == 0) goto L_0x0253;
    L_0x024f:
        r1 = r11.pi;
        r1.qw = r3;
    L_0x0253:
        r1 = 2;
        r11.mState = r1;
        r11.ps = r3;
        r11.onActivityCreated(r0);
        r0 = r11.ps;
        if (r0 != 0) goto L_0x0296;
    L_0x025f:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onActivityCreated()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x027c:
        r0 = r11.mView;
        r0 = android.support.v4.app.v.z(r0);
        r11.mView = r0;
        goto L_0x0184;
    L_0x0286:
        r11.pv = r7;
        goto L_0x0196;
    L_0x028a:
        r1 = r11.mView;
        r1 = android.support.v4.app.v.z(r1);
        r11.mView = r1;
        goto L_0x0220;
    L_0x0293:
        r11.pv = r7;
        goto L_0x0249;
    L_0x0296:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x029f;
    L_0x029a:
        r0 = r11.pi;
        r0.dispatchActivityCreated();
    L_0x029f:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x02d7;
    L_0x02a3:
        r0 = r11.oT;
        r0 = r11.oU;
        if (r0 == 0) goto L_0x02b2;
    L_0x02a9:
        r0 = r11.pv;
        r1 = r11.oU;
        r0.restoreHierarchyState(r1);
        r11.oU = r7;
    L_0x02b2:
        r11.ps = r3;
        r11.ps = r5;
        r0 = r11.ps;
        if (r0 != 0) goto L_0x02d7;
    L_0x02ba:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onViewStateRestored()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x02d7:
        r11.oT = r7;
    L_0x02d9:
        if (r12 <= r6) goto L_0x0331;
    L_0x02db:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02ea;
    L_0x02df:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto STARTED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x02ea:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x02f7;
    L_0x02ee:
        r0 = r11.pi;
        r0.qw = r3;
        r0 = r11.pi;
        r0.execPendingActions();
    L_0x02f7:
        r11.mState = r9;
        r11.ps = r3;
        r11.onStart();
        r0 = r11.ps;
        if (r0 != 0) goto L_0x031f;
    L_0x0302:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStart()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x031f:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x0328;
    L_0x0323:
        r0 = r11.pi;
        r0.dispatchStart();
    L_0x0328:
        r0 = r11.py;
        if (r0 == 0) goto L_0x0331;
    L_0x032c:
        r0 = r11.py;
        r0.bh();
    L_0x0331:
        if (r12 <= r9) goto L_0x0045;
    L_0x0333:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0342;
    L_0x0337:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto RESUMED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0342:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x034f;
    L_0x0346:
        r0 = r11.pi;
        r0.qw = r3;
        r0 = r11.pi;
        r0.execPendingActions();
    L_0x034f:
        r0 = 5;
        r11.mState = r0;
        r11.ps = r3;
        r11.onResume();
        r0 = r11.ps;
        if (r0 != 0) goto L_0x0378;
    L_0x035b:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onResume()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0378:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x0386;
    L_0x037c:
        r0 = r11.pi;
        r0.dispatchResume();
        r0 = r11.pi;
        r0.execPendingActions();
    L_0x0386:
        r11.oT = r7;
        r11.oU = r7;
        goto L_0x0045;
    L_0x038c:
        r0 = r11.mState;
        if (r0 <= r12) goto L_0x0045;
    L_0x0390:
        r0 = r11.mState;
        switch(r0) {
            case 1: goto L_0x0397;
            case 2: goto L_0x044a;
            case 3: goto L_0x0436;
            case 4: goto L_0x03f4;
            case 5: goto L_0x03b1;
            default: goto L_0x0395;
        };
    L_0x0395:
        goto L_0x0045;
    L_0x0397:
        if (r12 > 0) goto L_0x0045;
    L_0x0399:
        r0 = r10.qx;
        if (r0 == 0) goto L_0x03a8;
    L_0x039d:
        r0 = r11.oR;
        if (r0 == 0) goto L_0x03a8;
    L_0x03a1:
        r0 = r11.oR;
        r11.oR = r7;
        r0.clearAnimation();
    L_0x03a8:
        r0 = r11.oR;
        if (r0 == 0) goto L_0x04e3;
    L_0x03ac:
        r11.oS = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x03b1:
        r0 = 5;
        if (r12 >= r0) goto L_0x03f4;
    L_0x03b4:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x03c3;
    L_0x03b8:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom RESUMED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x03c3:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x03cc;
    L_0x03c7:
        r0 = r11.pi;
        r0.G(r9);
    L_0x03cc:
        r11.mState = r9;
        r11.ps = r3;
        r11.onPause();
        r0 = r11.ps;
        if (r0 != 0) goto L_0x03f4;
    L_0x03d7:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onPause()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03f4:
        if (r12 >= r9) goto L_0x0436;
    L_0x03f6:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0405;
    L_0x03fa:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STARTED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0405:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x040e;
    L_0x0409:
        r0 = r11.pi;
        r0.dispatchStop();
    L_0x040e:
        r11.mState = r6;
        r11.ps = r3;
        r11.onStop();
        r0 = r11.ps;
        if (r0 != 0) goto L_0x0436;
    L_0x0419:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStop()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0436:
        if (r12 >= r6) goto L_0x044a;
    L_0x0438:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0447;
    L_0x043c:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STOPPED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0447:
        r11.aO();
    L_0x044a:
        r0 = 2;
        if (r12 >= r0) goto L_0x0397;
    L_0x044d:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x045c;
    L_0x0451:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x045c:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x046f;
    L_0x0460:
        r0 = r10.ph;
        r0 = r0.aS();
        if (r0 == 0) goto L_0x046f;
    L_0x0468:
        r0 = r11.oU;
        if (r0 != 0) goto L_0x046f;
    L_0x046c:
        r10.i(r11);
    L_0x046f:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x0478;
    L_0x0473:
        r0 = r11.pi;
        r0.G(r5);
    L_0x0478:
        r11.mState = r5;
        r11.ps = r3;
        r11.onDestroyView();
        r0 = r11.ps;
        if (r0 != 0) goto L_0x04a0;
    L_0x0483:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroyView()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x04a0:
        r0 = r11.py;
        if (r0 == 0) goto L_0x04a9;
    L_0x04a4:
        r0 = r11.py;
        r0.bg();
    L_0x04a9:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x04db;
    L_0x04ad:
        r0 = r11.pu;
        if (r0 == 0) goto L_0x04db;
    L_0x04b1:
        r0 = r10.qr;
        if (r0 <= 0) goto L_0x05c1;
    L_0x04b5:
        r0 = r10.qx;
        if (r0 != 0) goto L_0x05c1;
    L_0x04b9:
        r0 = r10.a(r11, r13, r3, r14);
    L_0x04bd:
        if (r0 == 0) goto L_0x04d4;
    L_0x04bf:
        r1 = r11.mView;
        r11.oR = r1;
        r11.oS = r12;
        r1 = r11.mView;
        r2 = new android.support.v4.app.m$4;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.mView;
        r1.startAnimation(r0);
    L_0x04d4:
        r0 = r11.pu;
        r1 = r11.mView;
        r0.removeView(r1);
    L_0x04db:
        r11.pu = r7;
        r11.mView = r7;
        r11.pv = r7;
        goto L_0x0397;
    L_0x04e3:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x04f2;
    L_0x04e7:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x04f2:
        r0 = r11.pp;
        if (r0 != 0) goto L_0x0527;
    L_0x04f6:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x04ff;
    L_0x04fa:
        r0 = r11.pi;
        r0.dispatchDestroy();
    L_0x04ff:
        r11.mState = r3;
        r11.ps = r3;
        r11.onDestroy();
        r0 = r11.ps;
        if (r0 != 0) goto L_0x0529;
    L_0x050a:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroy()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0527:
        r11.mState = r3;
    L_0x0529:
        r11.ps = r3;
        r11.onDetach();
        r0 = r11.ps;
        if (r0 != 0) goto L_0x054f;
    L_0x0532:
        r0 = new android.support.v4.app.al;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x054f:
        if (r15 != 0) goto L_0x0045;
    L_0x0551:
        r0 = r11.pp;
        if (r0 != 0) goto L_0x05b7;
    L_0x0555:
        r0 = r11.mIndex;
        if (r0 < 0) goto L_0x0045;
    L_0x0559:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0568;
    L_0x055d:
        r0 = new java.lang.StringBuilder;
        r1 = "Freeing fragment index ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0568:
        r0 = r10.qj;
        r1 = r11.mIndex;
        r0.set(r1, r7);
        r0 = r10.ql;
        if (r0 != 0) goto L_0x057a;
    L_0x0573:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.ql = r0;
    L_0x057a:
        r0 = r10.ql;
        r1 = r11.mIndex;
        r1 = java.lang.Integer.valueOf(r1);
        r0.add(r1);
        r0 = r10.ph;
        r1 = r11.oV;
        r0.j(r1);
        r0 = -1;
        r11.mIndex = r0;
        r11.oV = r7;
        r11.pa = r3;
        r11.pb = r3;
        r11.pc = r3;
        r11.pd = r3;
        r11.pe = r3;
        r11.pf = r3;
        r11.pg = r7;
        r11.pi = r7;
        r11.ph = r7;
        r11.pk = r3;
        r11.pl = r3;
        r11.mTag = r7;
        r11.pm = r3;
        r11.pn = r3;
        r11.pp = r3;
        r11.py = r7;
        r11.pz = r3;
        r11.pA = r3;
        goto L_0x0045;
    L_0x05b7:
        r11.ph = r7;
        r11.pj = r7;
        r11.pg = r7;
        r11.pi = r7;
        goto L_0x0045;
    L_0x05c1:
        r0 = r7;
        goto L_0x04bd;
    L_0x05c4:
        r0 = r7;
        goto L_0x01fd;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.m.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void g(Fragment fragment) {
        a(fragment, this.qr, 0, 0, false);
    }

    final void G(int i) {
        a(i, 0, 0, false);
    }

    final void a(int i, int i2, int i3, boolean z) {
        if (this.ph == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.qr != i) {
            this.qr = i;
            if (this.qj != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.qj.size()) {
                    int bc;
                    Fragment fragment = (Fragment) this.qj.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.py != null) {
                            bc = i5 | fragment.py.bc();
                            i4++;
                            i5 = bc;
                        }
                    }
                    bc = i5;
                    i4++;
                    i5 = bc;
                }
                if (i5 == 0) {
                    aX();
                }
                if (this.qv && this.ph != null && this.qr == 5) {
                    this.ph.aT();
                    this.qv = false;
                }
            }
        }
    }

    final void aX() {
        if (this.qj != null) {
            for (int i = 0; i < this.qj.size(); i++) {
                Fragment fragment = (Fragment) this.qj.get(i);
                if (fragment != null) {
                    f(fragment);
                }
            }
        }
    }

    final void h(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.ql == null || this.ql.size() <= 0) {
                if (this.qj == null) {
                    this.qj = new ArrayList();
                }
                fragment.c(this.qj.size(), this.qt);
                this.qj.add(fragment);
            } else {
                fragment.c(((Integer) this.ql.remove(this.ql.size() - 1)).intValue(), this.qt);
                this.qj.set(fragment.mIndex, fragment);
            }
            if (DEBUG) {
                new StringBuilder("Allocated fragment index ").append(fragment);
            }
        }
    }

    public final void a(Fragment fragment, boolean z) {
        if (this.qk == null) {
            this.qk = new ArrayList();
        }
        if (DEBUG) {
            new StringBuilder("add: ").append(fragment);
        }
        h(fragment);
        if (!fragment.pn) {
            if (this.qk.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.qk.add(fragment);
            fragment.pa = true;
            fragment.pb = false;
            if (fragment.pq && fragment.pr) {
                this.qv = true;
            }
            if (z) {
                g(fragment);
            }
        }
    }

    public final void a(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("remove: ").append(fragment).append(" nesting=").append(fragment.pf);
        }
        boolean z = !(fragment.pf > 0);
        if (!fragment.pn || z) {
            int i3;
            if (this.qk != null) {
                this.qk.remove(fragment);
            }
            if (fragment.pq && fragment.pr) {
                this.qv = true;
            }
            fragment.pa = false;
            fragment.pb = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            a(fragment, i3, i, i2, false);
        }
    }

    public final void b(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("hide: ").append(fragment);
        }
        if (!fragment.pm) {
            fragment.pm = true;
            if (fragment.mView != null) {
                Animation a = a(fragment, i, false, i2);
                if (a != null) {
                    b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.pa && fragment.pq && fragment.pr) {
                this.qv = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public final void c(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.pm) {
            fragment.pm = false;
            if (fragment.mView != null) {
                Animation a = a(fragment, i, true, i2);
                if (a != null) {
                    b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.pa && fragment.pq && fragment.pr) {
                this.qv = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public final void d(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.pn) {
            fragment.pn = true;
            if (fragment.pa) {
                if (this.qk != null) {
                    if (DEBUG) {
                        new StringBuilder("remove from detach: ").append(fragment);
                    }
                    this.qk.remove(fragment);
                }
                if (fragment.pq && fragment.pr) {
                    this.qv = true;
                }
                fragment.pa = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public final void e(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.pn) {
            fragment.pn = false;
            if (!fragment.pa) {
                if (this.qk == null) {
                    this.qk = new ArrayList();
                }
                if (this.qk.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (DEBUG) {
                    new StringBuilder("add from attach: ").append(fragment);
                }
                this.qk.add(fragment);
                fragment.pa = true;
                if (fragment.pq && fragment.pr) {
                    this.qv = true;
                }
                a(fragment, this.qr, i, i2, false);
            }
        }
    }

    public final Fragment E(int i) {
        int size;
        Fragment fragment;
        if (this.qk != null) {
            for (size = this.qk.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.qk.get(size);
                if (fragment != null && fragment.pk == i) {
                    return fragment;
                }
            }
        }
        if (this.qj != null) {
            for (size = this.qj.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.qj.get(size);
                if (fragment != null && fragment.pk == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment k(String str) {
        int size;
        Fragment fragment;
        if (!(this.qk == null || str == null)) {
            for (size = this.qk.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.qk.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.qj == null || str == null)) {
            for (size = this.qj.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.qj.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment i(String str) {
        if (!(this.qj == null || str == null)) {
            for (int size = this.qj.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.qj.get(size);
                if (fragment != null) {
                    if (!str.equals(fragment.oV)) {
                        fragment = fragment.pi != null ? fragment.pi.i(str) : null;
                    }
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void aY() {
        if (this.qw) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.qy != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.qy);
        }
    }

    public final void a(Runnable runnable, boolean z) {
        if (!z) {
            aY();
        }
        synchronized (this) {
            if (this.qx || this.ph == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.qg == null) {
                this.qg = new ArrayList();
            }
            this.qg.add(runnable);
            if (this.qg.size() == 1) {
                this.ph.mHandler.removeCallbacks(this.qC);
                this.ph.mHandler.post(this.qC);
            }
        }
    }

    public final int a(d dVar) {
        int size;
        synchronized (this) {
            if (this.qp == null || this.qp.size() <= 0) {
                if (this.qo == null) {
                    this.qo = new ArrayList();
                }
                size = this.qo.size();
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(size).append(" to ").append(dVar);
                }
                this.qo.add(dVar);
            } else {
                size = ((Integer) this.qp.remove(this.qp.size() - 1)).intValue();
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(size).append(" with ").append(dVar);
                }
                this.qo.set(size, dVar);
            }
        }
        return size;
    }

    private void a(int i, d dVar) {
        synchronized (this) {
            if (this.qo == null) {
                this.qo = new ArrayList();
            }
            int size = this.qo.size();
            if (i < size) {
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(i).append(" to ").append(dVar);
                }
                this.qo.set(i, dVar);
            } else {
                while (size < i) {
                    this.qo.add(null);
                    if (this.qp == null) {
                        this.qp = new ArrayList();
                    }
                    if (DEBUG) {
                        this.qp.add(Integer.valueOf(size));
                        size++;
                    } else {
                        this.qp.add(Integer.valueOf(size));
                        size++;
                    }
                }
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(i).append(" with ").append(dVar);
                }
                this.qo.add(dVar);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean execPendingActions() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.qi;
        if (r1 == 0) goto L_0x000f;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000f:
        r1 = android.os.Looper.myLooper();
        r3 = r6.ph;
        r3 = r3.mHandler;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001d:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.qg;	 Catch:{ all -> 0x009b }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.qg;	 Catch:{ all -> 0x009b }
        r3 = r3.size();	 Catch:{ all -> 0x009b }
        if (r3 != 0) goto L_0x005e;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r0 = r6.qz;
        if (r0 == 0) goto L_0x00a9;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.qj;
        r0 = r0.size();
        if (r4 >= r0) goto L_0x00a2;
    L_0x0043:
        r0 = r6.qj;
        r0 = r0.get(r4);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x00aa;
    L_0x004d:
        r5 = r0.py;
        if (r5 == 0) goto L_0x00aa;
    L_0x0051:
        r0 = r0.py;
        r0 = r0.bc();
        r3 = r3 | r0;
        r0 = r3;
    L_0x0059:
        r3 = r4 + 1;
        r4 = r3;
        r3 = r0;
        goto L_0x003b;
    L_0x005e:
        r1 = r6.qg;	 Catch:{ all -> 0x009b }
        r3 = r1.size();	 Catch:{ all -> 0x009b }
        r1 = r6.qh;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x006d;
    L_0x0068:
        r1 = r6.qh;	 Catch:{ all -> 0x009b }
        r1 = r1.length;	 Catch:{ all -> 0x009b }
        if (r1 >= r3) goto L_0x0071;
    L_0x006d:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009b }
        r6.qh = r1;	 Catch:{ all -> 0x009b }
    L_0x0071:
        r1 = r6.qg;	 Catch:{ all -> 0x009b }
        r4 = r6.qh;	 Catch:{ all -> 0x009b }
        r1.toArray(r4);	 Catch:{ all -> 0x009b }
        r1 = r6.qg;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = r6.ph;	 Catch:{ all -> 0x009b }
        r1 = r1.mHandler;	 Catch:{ all -> 0x009b }
        r4 = r6.qC;	 Catch:{ all -> 0x009b }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009b }
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r6.qi = r0;
        r1 = r2;
    L_0x008a:
        if (r1 >= r3) goto L_0x009e;
    L_0x008c:
        r4 = r6.qh;
        r4 = r4[r1];
        r4.run();
        r4 = r6.qh;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008a;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r6.qi = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a2:
        if (r3 != 0) goto L_0x00a9;
    L_0x00a4:
        r6.qz = r2;
        r6.aX();
    L_0x00a9:
        return r1;
    L_0x00aa:
        r0 = r3;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.m.execPendingActions():boolean");
    }

    final void aZ() {
        if (this.qq != null) {
            for (int i = 0; i < this.qq.size(); i++) {
                this.qq.get(i);
            }
        }
    }

    final boolean h(int i, int i2) {
        if (this.qm == null) {
            return false;
        }
        int i3;
        d dVar;
        if (i >= 0 || (i2 & 1) != 0) {
            int size;
            i3 = -1;
            if (i >= 0) {
                size = this.qm.size() - 1;
                while (size >= 0) {
                    dVar = (d) this.qm.get(size);
                    if (i >= 0 && i == dVar.mIndex) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        dVar = (d) this.qm.get(size);
                        if (i < 0 || i != dVar.mIndex) {
                            break;
                        }
                        size--;
                    }
                }
                i3 = size;
            }
            if (i3 == this.qm.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size = this.qm.size() - 1; size > i3; size--) {
                arrayList.add(this.qm.remove(size));
            }
            int size2 = arrayList.size() - 1;
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            for (size = 0; size <= size2; size++) {
                ((d) arrayList.get(size)).b(sparseArray, sparseArray2);
            }
            android.support.v4.app.d.b bVar = null;
            int i4 = 0;
            while (i4 <= size2) {
                boolean z;
                if (DEBUG) {
                    new StringBuilder("Popping back stack state: ").append(arrayList.get(i4));
                }
                dVar = (d) arrayList.get(i4);
                if (i4 == size2) {
                    z = true;
                } else {
                    z = false;
                }
                i4++;
                bVar = dVar.a(z, bVar, sparseArray, sparseArray2);
            }
        } else {
            i3 = this.qm.size() - 1;
            if (i3 < 0) {
                return false;
            }
            dVar = (d) this.qm.remove(i3);
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            dVar.b(sparseArray3, sparseArray4);
            dVar.a(true, null, sparseArray3, sparseArray4);
        }
        aZ();
        return true;
    }

    private void i(Fragment fragment) {
        if (fragment.pv != null) {
            if (this.qB == null) {
                this.qB = new SparseArray();
            } else {
                this.qB.clear();
            }
            fragment.pv.saveHierarchyState(this.qB);
            if (this.qB.size() > 0) {
                fragment.oU = this.qB;
                this.qB = null;
            }
        }
    }

    private Bundle j(Fragment fragment) {
        Bundle bundle;
        if (this.qA == null) {
            this.qA = new Bundle();
        }
        fragment.d(this.qA);
        if (this.qA.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.qA;
            this.qA = null;
        }
        if (fragment.mView != null) {
            i(fragment);
        }
        if (fragment.oU != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.oU);
        }
        if (!fragment.px) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.px);
        }
        return bundle;
    }

    final Parcelable saveAllState() {
        BackStackState[] backStackStateArr = null;
        execPendingActions();
        if (qf) {
            this.qw = true;
        }
        if (this.qj == null || this.qj.size() <= 0) {
            return null;
        }
        int size = this.qj.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.qj.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.oT != null) {
                    fragmentState.oT = fragment.oT;
                } else {
                    fragmentState.oT = j(fragment);
                    if (fragment.oX != null) {
                        if (fragment.oX.mIndex < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.oX));
                        }
                        if (fragmentState.oT == null) {
                            fragmentState.oT = new Bundle();
                        }
                        a(fragmentState.oT, "android:target_state", fragment.oX);
                        if (fragment.oZ != 0) {
                            fragmentState.oT.putInt("android:target_req_state", fragment.oZ);
                        }
                    }
                }
                if (DEBUG) {
                    new StringBuilder("Saved state of ").append(fragment).append(": ").append(fragmentState.oT);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (!z) {
            return null;
        }
        int[] iArr;
        int i2;
        FragmentManagerState fragmentManagerState;
        if (this.qk != null) {
            i = this.qk.size();
            if (i > 0) {
                iArr = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    iArr[i2] = ((Fragment) this.qk.get(i2)).mIndex;
                    if (iArr[i2] < 0) {
                        a(new IllegalStateException("Failure saving state: active " + this.qk.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (DEBUG) {
                        new StringBuilder("saveAllState: adding fragment #").append(i2).append(": ").append(this.qk.get(i2));
                    }
                }
                if (this.qm != null) {
                    i = this.qm.size();
                    if (i > 0) {
                        backStackStateArr = new BackStackState[i];
                        for (i2 = 0; i2 < i; i2++) {
                            backStackStateArr[i2] = new BackStackState((d) this.qm.get(i2));
                            if (DEBUG) {
                                new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.qm.get(i2));
                            }
                        }
                    }
                }
                fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.qO = fragmentStateArr;
                fragmentManagerState.qP = iArr;
                fragmentManagerState.qQ = backStackStateArr;
                return fragmentManagerState;
            }
        }
        iArr = null;
        if (this.qm != null) {
            i = this.qm.size();
            if (i > 0) {
                backStackStateArr = new BackStackState[i];
                for (i2 = 0; i2 < i; i2++) {
                    backStackStateArr[i2] = new BackStackState((d) this.qm.get(i2));
                    if (DEBUG) {
                        new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.qm.get(i2));
                    }
                }
            }
        }
        fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.qO = fragmentStateArr;
        fragmentManagerState.qP = iArr;
        fragmentManagerState.qQ = backStackStateArr;
        return fragmentManagerState;
    }

    final void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.qO != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: re-attaching retained ").append(fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.qO[fragment.mIndex];
                        fragmentState.qV = fragment;
                        fragment.oU = null;
                        fragment.pf = 0;
                        fragment.pd = false;
                        fragment.pa = false;
                        fragment.oX = null;
                        if (fragmentState.oT != null) {
                            fragmentState.oT.setClassLoader(this.ph.mContext.getClassLoader());
                            fragment.oU = fragmentState.oT.getSparseParcelableArray("android:view_state");
                            fragment.oT = fragmentState.oT;
                        }
                    }
                }
                this.qj = new ArrayList(fragmentManagerState.qO.length);
                if (this.ql != null) {
                    this.ql.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.qO.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.qO[i2];
                    if (fragmentState2 != null) {
                        k kVar = this.ph;
                        Fragment fragment2 = this.qt;
                        if (fragmentState2.qV == null) {
                            Context context = kVar.mContext;
                            if (fragmentState2.oW != null) {
                                fragmentState2.oW.setClassLoader(context.getClassLoader());
                            }
                            fragmentState2.qV = Fragment.a(context, fragmentState2.qU, fragmentState2.oW);
                            if (fragmentState2.oT != null) {
                                fragmentState2.oT.setClassLoader(context.getClassLoader());
                                fragmentState2.qV.oT = fragmentState2.oT;
                            }
                            fragmentState2.qV.c(fragmentState2.mIndex, fragment2);
                            fragmentState2.qV.pc = fragmentState2.pc;
                            fragmentState2.qV.pe = true;
                            fragmentState2.qV.pk = fragmentState2.pk;
                            fragmentState2.qV.pl = fragmentState2.pl;
                            fragmentState2.qV.mTag = fragmentState2.mTag;
                            fragmentState2.qV.po = fragmentState2.po;
                            fragmentState2.qV.pn = fragmentState2.pn;
                            fragmentState2.qV.pg = kVar.pg;
                            if (DEBUG) {
                                new StringBuilder("Instantiated fragment ").append(fragmentState2.qV);
                            }
                        }
                        Fragment fragment3 = fragmentState2.qV;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: active #").append(i2).append(": ").append(fragment3);
                        }
                        this.qj.add(fragment3);
                        fragmentState2.qV = null;
                    } else {
                        this.qj.add(null);
                        if (this.ql == null) {
                            this.ql = new ArrayList();
                        }
                        if (DEBUG) {
                            this.ql.add(Integer.valueOf(i2));
                        } else {
                            this.ql.add(Integer.valueOf(i2));
                        }
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.oY >= 0) {
                            if (fragment.oY < this.qj.size()) {
                                fragment.oX = (Fragment) this.qj.get(fragment.oY);
                            } else {
                                new StringBuilder("Re-attaching retained fragment ").append(fragment).append(" target no longer exists: ").append(fragment.oY);
                                fragment.oX = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.qP != null) {
                    this.qk = new ArrayList(fragmentManagerState.qP.length);
                    for (i = 0; i < fragmentManagerState.qP.length; i++) {
                        fragment = (Fragment) this.qj.get(fragmentManagerState.qP[i]);
                        if (fragment == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.qP[i]));
                        }
                        fragment.pa = true;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: added #").append(i).append(": ").append(fragment);
                        }
                        if (this.qk.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.qk.add(fragment);
                    }
                } else {
                    this.qk = null;
                }
                if (fragmentManagerState.qQ != null) {
                    this.qm = new ArrayList(fragmentManagerState.qQ.length);
                    for (i2 = 0; i2 < fragmentManagerState.qQ.length; i2++) {
                        d a = fragmentManagerState.qQ[i2].a(this);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: back stack #").append(i2).append(" (index ").append(a.mIndex).append("): ").append(a);
                            a.a("  ", new PrintWriter(new d("FragmentManager")), false);
                        }
                        this.qm.add(a);
                        if (a.mIndex >= 0) {
                            a(a.mIndex, a);
                        }
                    }
                    return;
                }
                this.qm = null;
            }
        }
    }

    public final void a(k kVar, i iVar, Fragment fragment) {
        if (this.ph != null) {
            throw new IllegalStateException("Already attached");
        }
        this.ph = kVar;
        this.qs = iVar;
        this.qt = fragment;
    }

    public final void dispatchCreate() {
        this.qw = false;
        G(1);
    }

    public final void dispatchActivityCreated() {
        this.qw = false;
        G(2);
    }

    public final void dispatchStart() {
        this.qw = false;
        G(4);
    }

    public final void dispatchResume() {
        this.qw = false;
        G(5);
    }

    public final void dispatchStop() {
        this.qw = true;
        G(3);
    }

    public final void dispatchDestroy() {
        this.qx = true;
        execPendingActions();
        G(0);
        this.ph = null;
        this.qs = null;
        this.qt = null;
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        if (this.qk != null) {
            for (int i = 0; i < this.qk.size(); i++) {
                Fragment fragment = (Fragment) this.qk.get(i);
                if (fragment != null) {
                    fragment.onConfigurationChanged(configuration);
                    if (fragment.pi != null) {
                        fragment.pi.dispatchConfigurationChanged(configuration);
                    }
                }
            }
        }
    }

    public final void dispatchLowMemory() {
        if (this.qk != null) {
            for (int i = 0; i < this.qk.size(); i++) {
                Fragment fragment = (Fragment) this.qk.get(i);
                if (fragment != null) {
                    fragment.onLowMemory();
                    if (fragment.pi != null) {
                        fragment.pi.dispatchLowMemory();
                    }
                }
            }
        }
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z;
        int i = 0;
        ArrayList arrayList = null;
        if (this.qk != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.qk.size()) {
                boolean z2;
                Fragment fragment = (Fragment) this.qk.get(i2);
                if (fragment != null) {
                    int i3;
                    if (fragment.pm) {
                        i3 = 0;
                    } else {
                        if (fragment.pq && fragment.pr) {
                            fragment.onCreateOptionsMenu(menu, menuInflater);
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (fragment.pi != null) {
                            i3 |= fragment.pi.dispatchCreateOptionsMenu(menu, menuInflater);
                        }
                    }
                    if (i3 != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        z2 = true;
                        i2++;
                        z = z2;
                    }
                }
                z2 = z;
                i2++;
                z = z2;
            }
        } else {
            z = false;
        }
        if (this.qn != null) {
            while (i < this.qn.size()) {
                fragment = (Fragment) this.qn.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    Fragment.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.qn = arrayList;
        return z;
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.qk == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.qk.size(); i++) {
            Fragment fragment = (Fragment) this.qk.get(i);
            if (fragment != null) {
                int i2;
                if (fragment.pm) {
                    i2 = 0;
                } else {
                    if (fragment.pq && fragment.pr) {
                        fragment.onPrepareOptionsMenu(menu);
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (fragment.pi != null) {
                        i2 |= fragment.pi.dispatchPrepareOptionsMenu(menu);
                    }
                }
                if (i2 != 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.qk == null) {
            return false;
        }
        for (int i = 0; i < this.qk.size(); i++) {
            Fragment fragment = (Fragment) this.qk.get(i);
            if (fragment != null) {
                boolean z;
                if (!fragment.pm) {
                    if (fragment.pq && fragment.pr && fragment.onOptionsItemSelected(menuItem)) {
                        z = true;
                        if (!z) {
                            return true;
                        }
                    } else if (fragment.pi != null && fragment.pi.dispatchOptionsItemSelected(menuItem)) {
                        z = true;
                        if (!z) {
                            return true;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.qk == null) {
            return false;
        }
        for (int i = 0; i < this.qk.size(); i++) {
            Fragment fragment = (Fragment) this.qk.get(i);
            if (fragment != null) {
                boolean z;
                if (!fragment.pm) {
                    if (fragment.onContextItemSelected(menuItem)) {
                        z = true;
                    } else if (fragment.pi != null && fragment.pi.dispatchContextItemSelected(menuItem)) {
                        z = true;
                    }
                    if (z) {
                        return true;
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.qk != null) {
            for (int i = 0; i < this.qk.size(); i++) {
                Fragment fragment = (Fragment) this.qk.get(i);
                if (!(fragment == null || fragment.pm || fragment.pi == null)) {
                    fragment.pi.dispatchOptionsMenuClosed(menu);
                }
            }
        }
    }

    public static int H(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.qN);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.c(this.ph.mContext, string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment E = resourceId != -1 ? E(resourceId) : null;
        if (E == null && string2 != null) {
            E = k(string2);
        }
        if (E == null && id != -1) {
            E = E(id);
        }
        if (DEBUG) {
            new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(resourceId)).append(" fname=").append(string).append(" existing=").append(E);
        }
        if (E == null) {
            Fragment b = Fragment.b(context, string);
            b.pc = true;
            b.pk = resourceId != 0 ? resourceId : id;
            b.pl = id;
            b.mTag = string2;
            b.pd = true;
            b.pg = this;
            b.ph = this.ph;
            Bundle bundle = b.oT;
            b.aK();
            a(b, true);
            fragment = b;
        } else if (E.pd) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            E.pd = true;
            E.ph = this.ph;
            if (!E.pp) {
                Bundle bundle2 = E.oT;
                E.aK();
            }
            fragment = E;
        }
        if (this.qr > 0 || !fragment.pc) {
            g(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }
}
