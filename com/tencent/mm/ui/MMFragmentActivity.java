package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.j;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MMFragmentActivity extends ActionBarActivity implements com.tencent.mm.ui.widget.SwipeBackLayout.a, com.tencent.mm.ui.widget.j.a, com.tencent.mm.vending.e.b {
    String className;
    public boolean jcl;
    public SwipeBackLayout uUD;
    ArrayList<WeakReference<q>> uUJ = new ArrayList();
    private b uUK;
    private com.tencent.mm.vending.a.a uUL = new com.tencent.mm.vending.a.a();
    private a uUM = new a();
    private View uUN = null;

    public static class a {
        public static int uUP;
        public static int uUQ;
        public static int uUR;
        public static int uUS;
        public static int uUT = uUP;
        public static int uUU = uUQ;
        public static int uUV = uUR;
        public static int uUW = uUS;

        static {
            int i;
            int rX = com.tencent.mm.compatible.h.a.rX() & d.eo(19);
            uUP = rX != 0 ? com.tencent.mm.s.a.a.aRN : com.tencent.mm.s.a.a.aRm;
            uUQ = rX != 0 ? com.tencent.mm.s.a.a.aRM : com.tencent.mm.s.a.a.aQL;
            uUR = rX != 0 ? com.tencent.mm.s.a.a.aRL : com.tencent.mm.s.a.a.aQL;
            if (rX != 0) {
                i = com.tencent.mm.s.a.a.aRO;
            } else {
                i = com.tencent.mm.s.a.a.aRn;
            }
            uUS = i;
        }

        public static void bQp() {
            t tVar = p.gRh;
            boolean rQ = t.rQ();
            w.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle swipbackType = " + rQ);
            if (rQ) {
                boolean rX = com.tencent.mm.compatible.h.a.rX() & d.eo(19);
                w.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle supportSwipe = " + rX);
                uUP = rX ? com.tencent.mm.s.a.a.aRN : com.tencent.mm.s.a.a.aRm;
                uUQ = rX ? com.tencent.mm.s.a.a.aRM : com.tencent.mm.s.a.a.aQL;
                uUR = rX ? com.tencent.mm.s.a.a.aRL : com.tencent.mm.s.a.a.aQL;
                uUS = rX ? com.tencent.mm.s.a.a.aRO : com.tencent.mm.s.a.a.aRn;
                uUT = uUP;
                uUU = uUQ;
                uUV = uUR;
                uUW = uUS;
            }
        }
    }

    private final class b {
        PendingIntent ama;
        final /* synthetic */ MMFragmentActivity uUO;
        NfcAdapter uUX;
        IntentFilter[] uUY;
        String[][] uUZ;

        public b(MMFragmentActivity mMFragmentActivity) {
            this.uUO = mMFragmentActivity;
        }
    }

    public void a(com.tencent.mm.vending.e.a aVar) {
        this.uUL.wBx.a(aVar);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        this.className = getClass().getName();
        w.aC(3, this.className);
        super.onCreate(bundle);
        if (bDZ()) {
            this.uUK = new b(this);
            b bVar = this.uUK;
            bVar.uUX = NfcAdapter.getDefaultAdapter(bVar.uUO);
            Intent intent = new Intent();
            intent.setClassName(ab.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            bVar.ama = PendingIntent.getActivity(bVar.uUO, 0, intent, 0);
            try {
                new IntentFilter("android.nfc.action.NDEF_DISCOVERED").addDataType("*/*");
                new IntentFilter("android.nfc.action.TECH_DISCOVERED").addDataScheme("vnd.android.nfc");
                bVar.uUY = new IntentFilter[]{r3, r4, new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
                String[][] strArr = new String[1][];
                strArr[0] = new String[]{NfcA.class.getName(), IsoDep.class.getName()};
                bVar.uUZ = strArr;
                return;
            } catch (Throwable e) {
                throw new RuntimeException("fail", e);
            }
        }
        try {
            String str = "MicroMsg.MMFragmentActivity";
            String str2 = "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground);
            if (bundle == null) {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = getClass().getSimpleName();
            objArr[3] = Integer.valueOf(hashCode());
            w.e(str, str2, objArr);
            finish();
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.MMFragmentActivity", e2, "summerasyncinit finish:", new Object[0]);
        }
        System.exit(0);
    }

    public boolean bDZ() {
        if (ab.bJb()) {
            com.tencent.mm.sdk.b.b dVar = new com.tencent.mm.e.a.d();
            dVar.fCj.cGa = 1;
            com.tencent.mm.sdk.b.a.urY.m(dVar);
            boolean z = dVar.fCj.fCk;
            boolean z2 = dVar.fCj.isReady;
            boolean z3 = dVar.fCj.fCl;
            if (z && !(z2 && z3)) {
                w.i("MicroMsg.MMFragmentActivity", "summerasyncinit isLogin but accReady isInitializedNotifyAllDone[%b, %b] return false stack[%s]", Boolean.valueOf(z2), Boolean.valueOf(z3), bg.bJZ());
                return false;
            }
        }
        return true;
    }

    public void onDestroy() {
        this.uUL.wBx.dead();
        super.onDestroy();
    }

    public void onStop() {
        this.uUL.wBz.dead();
        super.onStop();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        w.aC(2, this.className);
        super.onPause();
        if (bQi()) {
            if (this.uUD != null) {
                this.uUD.mEnable = false;
            }
            if (!isFinishing()) {
                j.a(this);
            }
        }
        if (this.uUK != null) {
            b bVar = this.uUK;
            if (bVar.uUX != null) {
                try {
                    bVar.uUX.disableForegroundDispatch(bVar.uUO);
                } catch (IllegalStateException e) {
                    w.e("MicroMsg.MMFragmentActivity", "lo-nfc-onPause: exp:" + e.getLocalizedMessage());
                }
            }
        }
        this.uUL.wBy.dead();
    }

    public void onResume() {
        w.aC(1, this.className);
        super.onResume();
        if (bQi()) {
            j.b(this);
            O(1.0f);
            if (this.uUD != null) {
                this.uUD.mEnable = true;
                this.uUD.wuc = false;
            }
        }
        if (this.uUK != null) {
            b bVar = this.uUK;
            if (bVar.uUX != null) {
                try {
                    bVar.uUX.enableForegroundDispatch(bVar.uUO, bVar.ama, bVar.uUY, bVar.uUZ);
                } catch (IllegalStateException e) {
                    w.e("MicroMsg.MMFragmentActivity", "lo-nfc-onResume: exp:" + e.getLocalizedMessage());
                }
            }
        }
    }

    public q bPM() {
        int size = this.uUJ.size();
        if (size == 0) {
            return null;
        }
        q qVar = (q) ((WeakReference) this.uUJ.get(size - 1)).get();
        if (qVar == null || !qVar.isShowing()) {
            return null;
        }
        return qVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    private void ai(Intent intent) {
        ComponentName component = intent == null ? null : intent.getComponent();
        if (component != null) {
            Object obj;
            String className = component.getClassName().startsWith(component.getPackageName()) ? component.getClassName() : component.getPackageName() + component.getClassName();
            if ((com.tencent.mm.ui.base.b.SU(className) & 2) == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                super.overridePendingTransition(a.uUT, a.uUU);
                return;
            }
            Object obj2;
            if ((com.tencent.mm.ui.base.b.SU(className) & 4) != 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                com.tencent.mm.ui.base.b.eL(this);
            } else {
                com.tencent.mm.ui.base.b.eO(this);
            }
        }
    }

    public void finish() {
        Object obj;
        Object obj2 = 1;
        super.finish();
        if ((com.tencent.mm.ui.base.b.w(getClass()) & 2) == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            super.overridePendingTransition(a.uUV, a.uUW);
            return;
        }
        if ((com.tencent.mm.ui.base.b.w(getClass()) & 4) == 0) {
            obj2 = null;
        }
        if (obj2 == null) {
            com.tencent.mm.ui.base.b.eN(this);
        } else {
            com.tencent.mm.ui.base.b.eO(this);
        }
    }

    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        super.startActivities(intentArr, bundle);
        ai(null);
    }

    @TargetApi(11)
    public void startActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
        ai(null);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        ai(intent);
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
        ai(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
        ai(intent);
    }

    @TargetApi(16)
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
        ai(intent);
    }

    public final void a(Fragment fragment, Intent intent, int i) {
        super.a(fragment, intent, i);
        ai(intent);
    }

    private boolean bQi() {
        if (d.eo(19) && com.tencent.mm.compatible.h.a.rX() && biv() && com.tencent.mm.ui.base.b.x(getClass())) {
            return true;
        }
        return false;
    }

    public boolean biv() {
        return true;
    }

    public boolean bxV() {
        return true;
    }

    public final boolean bQn() {
        if (d.eo(19)) {
            if (com.tencent.mm.ui.base.b.x(getClass()) && bxV()) {
                af.v(new Runnable(this) {
                    final /* synthetic */ MMFragmentActivity uUO;

                    {
                        this.uUO = r1;
                    }

                    public final void run() {
                        com.tencent.mm.ui.base.b.ad(this.uUO);
                    }
                });
            } else {
                boolean z;
                if ((com.tencent.mm.ui.base.b.w(getClass()) & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ MMFragmentActivity uUO;

                        {
                            this.uUO = r1;
                        }

                        public final void run() {
                            com.tencent.mm.ui.base.b.ad(this.uUO);
                        }
                    });
                }
            }
        }
        if (!bQi()) {
            return false;
        }
        bQo();
        return true;
    }

    protected void bQo() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.uUD = (SwipeBackLayout) LayoutInflater.from(this).inflate(h.heN, viewGroup, false);
        this.uUD.init();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(com.tencent.mm.s.a.d.transparent);
        viewGroup.removeView(viewGroup2);
        this.uUD.addView(viewGroup2);
        this.uUD.Ih = viewGroup2;
        viewGroup.addView(this.uUD);
        this.uUD.wxL = this;
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            return r.b((LayoutInflater) systemService);
        }
        return systemService;
    }

    public Resources getResources() {
        if (getAssets() == null || ab.getResources() == null) {
            return super.getResources();
        }
        return ab.getResources();
    }

    public void O(float f) {
        w.v("ashutest", "ashutest::on swipe %f, duration %d", Float.valueOf(f), Long.valueOf(240));
        if (this.uUN == null) {
            this.uUN = x.a(getWindow(), cO().cP() != null ? cO().cP().getCustomView() : null);
        }
        View view = this.uUN;
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.j.n(view, 0.0f);
        } else {
            com.tencent.mm.ui.tools.j.n(view, (((float) (view.getWidth() / 4)) * (1.0f - f)) * -1.0f);
        }
    }

    public void d(boolean z, int i) {
        long j = 120;
        w.v("ashutest", "ashutest:: on settle %B, speed %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.uUN == null) {
            this.uUN = x.a(getWindow(), cO().cP().getCustomView());
        }
        View view = this.uUN;
        if (z) {
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(view, j, 0.0f, null);
            return;
        }
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(view, j, (float) ((view.getWidth() * -1) / 4), null);
    }

    public void VK() {
        if (!isFinishing()) {
            finish();
        }
        overridePendingTransition(0, 0);
        this.jcl = false;
    }

    public void onCancel() {
        this.jcl = false;
    }

    public void VL() {
        this.jcl = true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!bQi() || keyEvent.getKeyCode() != 4 || !this.uUD.caO()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
        return true;
    }

    public boolean VJ() {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (cO().cP() != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(g.JZ);
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(g.JL);
                if (findViewById != null && (findViewById instanceof Toolbar)) {
                    Toolbar toolbar = (Toolbar) findViewById;
                    LayoutParams layoutParams = toolbar.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = com.tencent.mm.compatible.util.a.e(this);
                    }
                    toolbar.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void aQ() {
        if (bPM() != null) {
            Object obj;
            q bPM = bPM();
            if (bPM.uSU.bQe()) {
                bPM.uSU.aQ();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return;
            }
        }
        super.aQ();
    }
}
