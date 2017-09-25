package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.jt;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.i.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public abstract class q extends h implements OnAttachStateChangeListener, a {
    String className;
    public l uSU = new l(this) {
        final /* synthetic */ q uUI;

        {
            this.uUI = r1;
        }

        protected final int getLayoutId() {
            return this.uUI.getLayoutId();
        }

        protected final void bE(View view) {
            this.uUI.bE(view);
        }

        protected final String aFO() {
            return this.uUI.aFO();
        }

        protected final View bQa() {
            return this.uUI.bQa();
        }

        public final void bit() {
            this.uUI.bit();
        }

        protected final void SC() {
            q.SC();
        }

        protected final String getClassName() {
            return this.uUI.getClass().getName();
        }

        protected final boolean bPO() {
            return false;
        }

        public final boolean Xb() {
            return this.uUI.Xb();
        }
    };
    protected ActionBarActivity uUB;
    public boolean uUC = false;
    public SwipeBackLayout uUD;
    private q uUE;
    private boolean uUF = false;
    private a uUG;
    private boolean uUH = false;

    public abstract int getLayoutId();

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.uSU.uTo;
    }

    public q(boolean z) {
        super(z);
    }

    protected static void SC() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.a(bPj().getBaseContext(), (ActionBarActivity) bPj());
    }

    public final void aM() {
        if (bQi()) {
            View view = this.uSU.ipu;
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                this.uUD = (SwipeBackLayout) LayoutInflater.from(bPj()).inflate(h.heN, viewGroup, false);
                viewGroup.removeView(view);
                viewGroup.addView(this.uUD);
            } else {
                this.uUD = (SwipeBackLayout) LayoutInflater.from(bPj()).inflate(h.heN, null);
            }
            this.uUD.addView(view);
            this.uUD.Ih = view;
            this.uUD.lU(true);
            this.uUD.wxL = new SwipeBackLayout.a(this) {
                final /* synthetic */ q uUI;

                {
                    this.uUI = r1;
                }

                public final void VK() {
                    this.uUI.VK();
                }

                public final void onCancel() {
                    this.uUI.bQk();
                }

                public final void VL() {
                    this.uUI.bQj();
                }
            };
        }
        this.mView.addOnAttachStateChangeListener(this);
    }

    public final boolean bQi() {
        if (d.eo(19) && com.tencent.mm.compatible.h.a.rX()) {
            return biv();
        }
        return false;
    }

    public boolean biv() {
        return true;
    }

    public boolean Xb() {
        return false;
    }

    public void VK() {
    }

    public void bQj() {
    }

    public void bQk() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aH();
        return this.uSU.ipu;
    }

    public void bE(View view) {
    }

    public void bit() {
    }

    public final void a(ActionBarActivity actionBarActivity) {
        this.uUB = actionBarActivity;
    }

    public final Activity aYD() {
        return this.uSU.uTo;
    }

    public final void cV(boolean z) {
        this.uSU.cV(z);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.uSU.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.uSU.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        w.aC(1, this.className);
        super.onResume();
        w.v("MicroMsg.INIT", "KEVIN MMActivity super..onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.uSU.onResume();
        w.v("MicroMsg.INIT", "KEVIN MMActivity onResume :" + (System.currentTimeMillis() - currentTimeMillis));
        ky(true);
    }

    public void onDestroy() {
        super.onDestroy();
        this.uSU.onDestroy();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        w.aC(2, this.className);
        super.onPause();
        if (this.uUC) {
            this.uUC = false;
        } else {
            this.uSU.onPause();
        }
        w.v("MicroMsg.INIT", "KEVIN MMActivity onPause:" + (System.currentTimeMillis() - currentTimeMillis));
        ky(false);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (!this.uSU.onCreateOptionsMenu(menu)) {
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    public final void onPrepareOptionsMenu(Menu menu) {
        this.uSU.onPrepareOptionsMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.uSU.onOptionsItemSelected(menuItem);
    }

    public String aFO() {
        return "";
    }

    public View bQa() {
        return null;
    }

    public void qP(String str) {
        this.uSU.qP(str);
    }

    public final void SF(String str) {
        this.uSU.SF(str);
    }

    public void zi(int i) {
        this.uSU.zi(i);
    }

    public void SE(String str) {
        this.uSU.SE(str);
    }

    public void zj(int i) {
        this.uSU.zj(i);
    }

    public final void kq(boolean z) {
        this.uSU.kq(z);
    }

    public final void kr(boolean z) {
        this.uSU.a(true, -1, z);
    }

    public final void ks(boolean z) {
        this.uSU.b(true, -1, z);
    }

    public final void kw(boolean z) {
        this.uSU.b(false, 2, z);
    }

    public final void a(boolean z, p pVar) {
        this.uSU.a(z, pVar);
    }

    public final void a(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.uSU.a(i, i2, onMenuItemClickListener);
    }

    public final void a(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.uSU.a(i, i2, i3, onMenuItemClickListener);
    }

    public final void zr(int i) {
        l lVar = this.uSU;
        l.a zq = lVar.zq(2);
        if (zq != null && zq.uTS != i) {
            zq.uTS = i;
            lVar.aQ();
        }
    }

    public void b(OnMenuItemClickListener onMenuItemClickListener) {
        this.uSU.a(onMenuItemClickListener, 0);
    }

    public void zs(int i) {
        l lVar = this.uSU;
        lVar.uTn = i == 0;
        lVar.bQd();
    }

    public void zo(int i) {
        this.uSU.zo(i);
    }

    public boolean are() {
        return this.uSU.are();
    }

    public void finish() {
        super.finish();
        int intExtra = bPj().getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
        int intExtra2 = bPj().getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
        if (intExtra != -1) {
            this.uSU.uTo.overridePendingTransition(intExtra, intExtra2);
        }
    }

    public final void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    public final Resources bQl() {
        FragmentActivity aG = super.aG();
        if (aG == null) {
            return ab.getContext().getResources();
        }
        return aG.getResources();
    }

    public final FragmentActivity bPj() {
        if (this.uSU.uTo != null) {
            return this.uSU.uTo;
        }
        return super.aG();
    }

    public final Resources bQm() {
        return bPj().getResources();
    }

    public final String zt(int i) {
        return bPj().getString(i);
    }

    public final String e(int i, Object... objArr) {
        return bPj().getString(i, objArr);
    }

    public void onStart() {
        this.uSU.onStart();
        super.onStart();
        ky(true);
    }

    public void onStop() {
        super.onStop();
        ky(false);
    }

    public final void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        J(!z, z);
    }

    public void setUserVisibleHint(boolean z) {
        w.i("MicroMsg.MMFragment", "[setUserVisibleHint] isVisibleToUser:%s name:%s", Boolean.valueOf(z), getClass().getName());
        super.setUserVisibleHint(z);
        J(z, false);
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this.pj;
        if (fragment != null && (fragment instanceof q)) {
            this.uUE = (q) fragment;
            this.uUE.uUG = this;
        }
        J(true, false);
    }

    public void onDetach() {
        if (this.uUE != null) {
            this.uUE.uUG = null;
        }
        super.onDetach();
        J(false, false);
        this.uUE = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mView.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        J(true, false);
    }

    public void onViewDetachedFromWindow(View view) {
        J(false, false);
    }

    public final void kx(boolean z) {
        J(z, false);
    }

    private void ky(boolean z) {
        this.uUF = z;
        J(z, false);
    }

    private void J(boolean z, boolean z2) {
        if (z != this.uUH) {
            boolean z3;
            boolean z4;
            boolean z5 = this.uUE == null ? this.uUF : this.uUE.uUH;
            if (!isAdded() || this.pm || this.mView == null || this.mView.getWindowToken() == null || this.mView.getVisibility() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean userVisibleHint = getUserVisibleHint();
            if (z5 && z3 && userVisibleHint && !z2) {
                z4 = true;
            } else {
                z4 = false;
            }
            w.i("MicroMsg.MMFragment", "[filterAndNotifyVisibility] visible = %s parent = %s, super = %s, hint = %s name:%s", Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z3), Boolean.valueOf(userVisibleHint), getClass().getName());
            if (z4 != this.uUH) {
                this.uUH = z4;
                z3 = this.uUH;
                if (this.uUG != null) {
                    this.uUG.kx(z3);
                }
                int i = -1;
                Bundle bundle = this.oW;
                if (bundle != null && bundle.containsKey(getClass().getName())) {
                    i = bundle.getInt(getClass().getName());
                }
                w.i("MicroMsg.MMFragment", "[onVisibilityChanged] visible:%s name:%s id:%s", Boolean.valueOf(z3), getClass().getName(), Integer.valueOf(i));
                b jtVar = new jt();
                jtVar.fQh.name = getClass().getName();
                jtVar.fQh.id = i;
                jtVar.fQh.visible = z3;
                com.tencent.mm.sdk.b.a.urY.m(jtVar);
            }
        }
    }
}
