package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.mm.e.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.l.AnonymousClass2;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity extends MMFragmentActivity {
    String className;
    public boolean uST = false;
    public l uSU = new l(this) {
        final /* synthetic */ MMActivity uSX;

        {
            this.uSX = r1;
        }

        protected final int getLayoutId() {
            return this.uSX.getLayoutId();
        }

        protected final void bE(View view) {
            this.uSX.bE(view);
        }

        protected final String aFO() {
            return this.uSX.aFO();
        }

        protected final View bQa() {
            return null;
        }

        public final void bit() {
            this.uSX.bit();
        }

        protected final void SC() {
            this.uSX.SC();
        }

        protected final String getClassName() {
            return this.uSX.getClass().getName();
        }

        protected final boolean bPO() {
            return this.uSX.bPO();
        }

        public final boolean Xb() {
            return this.uSX.Xb();
        }

        public final boolean byl() {
            return this.uSX.byl();
        }
    };
    public a uSV = null;
    public boolean uSW = false;

    public interface a {
        void a(int i, int i2, Intent intent);
    }

    public abstract int getLayoutId();

    @Deprecated
    public void KC() {
    }

    public final void zf(int i) {
        l lVar = this.uSU;
        if (lVar.ipu != null) {
            if (lVar.uTd == null) {
                lVar.uTd = (FrameLayout) lVar.ipu.findViewById(g.ckh);
            }
            lVar.uTd.setBackgroundResource(i);
            lVar.uTa.setBackgroundResource(i);
        }
    }

    public static Locale et(Context context) {
        return l.et(context);
    }

    public void SC() {
    }

    public boolean bPO() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        if (bDZ()) {
            this.uSU.a(getBaseContext(), (ActionBarActivity) this);
            w.i("MicroMsg.MMActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bg.eq(this));
            bQn();
            return;
        }
        try {
            String str = "MicroMsg.MMActivity";
            String str2 = "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(b.foreground);
            if (bundle == null) {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = getClass().getSimpleName();
            objArr[3] = Integer.valueOf(hashCode());
            w.e(str, str2, objArr);
            finish();
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMActivity", th, "summerasyncinit finish:", new Object[0]);
        }
        System.exit(0);
    }

    public boolean bDZ() {
        if (ab.bJb()) {
            com.tencent.mm.sdk.b.b dVar = new d();
            dVar.fCj.cGa = 0;
            com.tencent.mm.sdk.b.a.urY.m(dVar);
            boolean z = dVar.fCj.fCk;
            boolean z2 = dVar.fCj.isReady;
            boolean z3 = dVar.fCj.fCl;
            if (z && !(z2 && z3)) {
                w.i("MicroMsg.MMActivity", "summerasyncinit isLogin but accReady isInitializedNotifyAllDone[%b, %b] return false stack[%s]", Boolean.valueOf(z2), Boolean.valueOf(z3), bg.bJZ());
                return false;
            }
        }
        return true;
    }

    public void bE(View view) {
        setContentView(view);
    }

    public boolean Xb() {
        return false;
    }

    public void bit() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void cV(boolean z) {
        this.uSU.cV(z);
    }

    public void re(int i) {
        this.uSU.ipu.setVisibility(i);
        if (i == 0) {
            bPW();
        } else {
            this.uSU.bQg();
        }
    }

    public void VK() {
        if (!byk()) {
            this.uSU.bQc();
        }
        super.VK();
    }

    public boolean byk() {
        return false;
    }

    public int Ol() {
        return -1;
    }

    public void azv() {
        if (Ol() == -1) {
            this.uST = getSharedPreferences(ab.bIX(), 0).getBoolean("settings_landscape_mode", false);
            if (this.uST) {
                setRequestedOrientation(-1);
                return;
            } else {
                setRequestedOrientation(1);
                return;
            }
        }
        setRequestedOrientation(Ol());
    }

    public void onStart() {
        azv();
        super.onStart();
    }

    @TargetApi(17)
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (!this.uSU.onKeyUp(i, keyEvent)) {
            try {
                z = super.onKeyUp(i, keyEvent);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMActivity", e, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
            }
        }
        return z;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.uSU.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean byl() {
        return true;
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        w.aC(1, this.className);
        super.onResume();
        w.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.uSU.onResume();
        w.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode()));
    }

    public final void a(Dialog dialog) {
        l lVar = this.uSU;
        if (dialog != null) {
            if (lVar.uTt == null) {
                lVar.uTt = new ArrayList();
            }
            lVar.uTt.add(dialog);
        }
    }

    public final ActionBarActivity bPP() {
        return this.uSU.uTo;
    }

    public void onDestroy() {
        w.i("MicroMsg.MMActivity", "checktask onDestroy:%s#0x%x task:%s ", getClass().getSimpleName(), Integer.valueOf(hashCode()), bg.eq(this));
        super.onDestroy();
        com.tencent.mm.sdk.platformtools.a.cU(this.uSU.ipu);
        com.tencent.mm.sdk.platformtools.a.dU(this.uSU.uTo);
        this.uSU.onDestroy();
        this.uSW = true;
    }

    public static void bPQ() {
        l.bPQ();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        w.aC(2, this.className);
        super.onPause();
        this.uSU.onPause();
        boolean isFinishing = isFinishing();
        w.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isFinishing), Integer.valueOf(hashCode()));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.uSU.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.uSU.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.uSU.onOptionsItemSelected(menuItem);
    }

    public String aFO() {
        return "";
    }

    public final void kp(boolean z) {
        this.uSU.kp(z);
    }

    public final void d(boolean z, long j) {
        this.uSU.d(z, j);
    }

    public final void zg(int i) {
        l lVar = this.uSU;
        if (lVar.Gx == null) {
            return;
        }
        if (i == 0) {
            lVar.Gx.show();
            if (VERSION.SDK_INT >= 21) {
                lVar.uTo.getWindow().setStatusBarColor(lVar.uTo.getResources().getColor(com.tencent.mm.s.a.d.aVV));
                return;
            }
            return;
        }
        lVar.Gx.hide();
        if (VERSION.SDK_INT >= 21) {
            lVar.uTo.getWindow().setStatusBarColor(lVar.uTo.getResources().getColor(com.tencent.mm.s.a.d.black));
        }
    }

    public final void zh(int i) {
        l lVar = this.uSU;
        if (lVar.Gx != null) {
            lVar.uTv.setTextColor(i);
        }
    }

    public void qP(String str) {
        this.uSU.qP(str);
    }

    public final void L(CharSequence charSequence) {
        this.uSU.L(charSequence);
    }

    public final void zi(int i) {
        this.uSU.zi(i);
    }

    public final void SE(String str) {
        this.uSU.SE(str);
    }

    public final void zj(int i) {
        this.uSU.zj(i);
    }

    public final void zk(int i) {
        this.uSU.uTv.setVisibility(i);
    }

    public final void zl(int i) {
        l lVar = this.uSU;
        if (lVar.Gx != null) {
            lVar.uTg = 0;
            lVar.uTi = null;
            if (i == 0) {
                lVar.uTh = 0;
                lVar.uTj = null;
            } else if (lVar.uTh != i) {
                lVar.uTh = i;
                lVar.uTj = lVar.dT(lVar.mContext.getResources().getDimensionPixelSize(e.aWE), lVar.uTh);
            }
            lVar.bQd();
        }
    }

    public final void bPR() {
        l lVar = this.uSU;
        if (lVar.uTu != null) {
            lVar.uTu.setVisibility(8);
        }
    }

    public final void zm(int i) {
        l lVar = this.uSU;
        if (lVar.uTu != null) {
            lVar.uTu.setBackgroundColor(i);
        }
    }

    public final void bPS() {
        l lVar = this.uSU;
        if (lVar.Gx != null) {
            lVar.Gx.setDisplayHomeAsUpEnabled(false);
            if (lVar.uTw != null && lVar.uTy != null) {
                lVar.uTw.setVisibility(8);
                lVar.uTy.setVisibility(0);
            }
        }
    }

    public final void kq(boolean z) {
        this.uSU.kq(z);
    }

    public final void kr(boolean z) {
        this.uSU.a(true, -1, z);
    }

    public final void ae(int i, boolean z) {
        this.uSU.a(false, i, z);
    }

    public final void ks(boolean z) {
        this.uSU.b(true, -1, z);
    }

    public final void af(int i, boolean z) {
        this.uSU.b(false, i, z);
    }

    public final boolean bPT() {
        Iterator it = this.uSU.uTr.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.l.a aVar = (com.tencent.mm.ui.l.a) it.next();
            if (aVar.uTR == 0) {
                return aVar.fFU;
            }
        }
        return false;
    }

    public final boolean bPU() {
        Iterator it = this.uSU.uTr.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.l.a aVar = (com.tencent.mm.ui.l.a) it.next();
            if (aVar.uTR == 0) {
                return aVar.visible;
            }
        }
        return false;
    }

    public final void a(p pVar) {
        this.uSU.a(true, pVar);
    }

    public void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.uSU.a(i, 0, str, onMenuItemClickListener, null, l.b.uTX);
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, int i2) {
        this.uSU.a(i, str, onMenuItemClickListener, null, i2);
    }

    public final void a(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.uSU.a(i, i2, onMenuItemClickListener);
    }

    public final void a(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.uSU.a(i, i2, i3, onMenuItemClickListener);
    }

    public final void aB(int i, String str) {
        l lVar = this.uSU;
        com.tencent.mm.ui.l.a zq = lVar.zq(i);
        if (zq != null && !bg.ap(str, "").equals(zq.text)) {
            zq.text = str;
            lVar.aQ();
        }
    }

    public final void a(OnMenuItemClickListener onMenuItemClickListener) {
        com.tencent.mm.ui.l.a zq = this.uSU.zq(1);
        if (zq != null) {
            zq.oUT = onMenuItemClickListener;
            zq.lLy = null;
        }
    }

    public final void Y(Runnable runnable) {
        l lVar = this.uSU;
        if (lVar.Gx != null) {
            lVar.Gx.getCustomView().setOnClickListener(new AnonymousClass2(lVar, runnable));
        }
    }

    public void b(OnMenuItemClickListener onMenuItemClickListener) {
        this.uSU.a(onMenuItemClickListener, 0);
    }

    public final void a(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.uSU.a(onMenuItemClickListener, i);
    }

    public final void kt(boolean z) {
        l lVar = this.uSU;
        if (lVar.uTx == null) {
            return;
        }
        if (z) {
            lVar.uTx.setVisibility(0);
        } else {
            lVar.uTx.setVisibility(8);
        }
    }

    public final boolean zn(int i) {
        return this.uSU.zn(i);
    }

    public final CharSequence bPV() {
        l lVar = this.uSU;
        if (lVar.Gx == null) {
            return null;
        }
        return lVar.uTf != null ? lVar.uTf : lVar.Gx.getTitle();
    }

    public final void bPW() {
        boolean z = true;
        l lVar = this.uSU;
        String str = "MicroMsg.MMActivityController";
        String str2 = "showTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (lVar.Gx == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.v(str, str2, objArr);
        if (lVar.Gx != null) {
            lVar.Gx.show();
        }
    }

    public final boolean bPX() {
        boolean z = true;
        l lVar = this.uSU;
        String str = "MicroMsg.MMActivityController";
        String str2 = "isTitleShowing hasTitle:%b";
        Object[] objArr = new Object[1];
        if (lVar.Gx == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.v(str, str2, objArr);
        return lVar.Gx == null ? false : lVar.Gx.isShowing();
    }

    public final void zo(int i) {
        this.uSU.zo(i);
    }

    public void aHf() {
        this.uSU.are();
    }

    public final void cY(View view) {
        this.uSU.cX(view);
    }

    public void aHj() {
        this.uSU.aHj();
    }

    public static void O(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    public void finish() {
        super.finish();
        int a = s.a(getIntent(), "MMActivity.OverrideEnterAnimation", -1);
        int a2 = s.a(getIntent(), "MMActivity.OverrideExitAnimation", -1);
        if (a != -1) {
            super.overridePendingTransition(a, a2);
        }
    }

    public final void v(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void a(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void a(a aVar, Intent intent, int i) {
        this.uSV = aVar;
        startActivityForResult(intent, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.uSV != null) {
            this.uSV.a(i, i2, intent);
        }
        this.uSV = null;
    }

    public final void bPY() {
        l lVar = this.uSU;
        lVar.uTy.setVisibility(0);
        lVar.uTx.setVisibility(8);
        lVar.uTw.setVisibility(8);
    }

    public final void bPZ() {
        l lVar = this.uSU;
        if (lVar.mContext != null) {
            lVar.Z(lVar.uTo);
        }
    }
}
