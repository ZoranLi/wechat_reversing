package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.p;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.as.n;
import com.tencent.mm.e.a.oh;
import com.tencent.mm.plugin.appbrand.b.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMTintStatusBarActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

public final class AppBrandLauncherUI extends MMTintStatusBarActivity {
    static final int jio;
    static final int jip;
    static final int jiq = g.g(jio, 0.8f);
    private static final int jir = R.h.bpc;
    private int jis;
    private String jit;
    private boolean jiu = false;
    private int jiv;
    private boolean jiw = true;
    private final com.tencent.mm.plugin.appbrand.b.c.b jix = new com.tencent.mm.plugin.appbrand.b.c.b(this) {
        final /* synthetic */ AppBrandLauncherUI jiz;

        {
            this.jiz = r1;
        }

        public final void Ra() {
            com.tencent.mm.plugin.appbrand.b.c.b(this);
            if (!com.tencent.mm.plugin.appbrand.b.c.QY()) {
                this.jiz.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jiA;

                    {
                        this.jiA = r1;
                    }

                    public final void run() {
                        if (!this.jiA.jiz.isFinishing() && !this.jiA.jiz.uSW) {
                            this.jiA.jiz.ce(true);
                        }
                    }
                });
            }
        }
    };
    public d jiy;

    public static abstract class a extends Fragment {
        public View Ih;
        public int hPi;
        private final ae jiB = new ae(Looper.getMainLooper());
        public String jiC;

        public abstract void KC();

        public void WN() {
        }

        public void WO() {
        }

        public final int is(int i) {
            Context aG = aG();
            if (aG == null) {
                aG = ab.getContext();
            }
            return com.tencent.mm.bg.a.fromDPToPix(aG, i);
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Ih = new FrameLayout(viewGroup.getContext());
            KC();
            return this.Ih;
        }

        public final void m(Runnable runnable) {
            if (runnable != null) {
                this.jiB.post(runnable);
            }
        }

        public final void runOnUiThread(Runnable runnable) {
            if (aG() != null) {
                aG().runOnUiThread(runnable);
            }
        }
    }

    private enum b {
        ;

        static {
            jiD = 1;
            jiE = 2;
            jiF = new int[]{jiD, jiE};
        }
    }

    public static abstract class c<T> extends com.tencent.mm.plugin.appbrand.m.j.a {
        public final List<T> jiG;
        public final List<T> jiH;

        public c(List<T> list, List<T> list2) {
            this.jiG = list;
            this.jiH = list2;
        }

        public final int WP() {
            return this.jiG == null ? 0 : this.jiG.size();
        }

        public final int WQ() {
            return this.jiH == null ? 0 : this.jiH.size();
        }
    }

    static {
        int color = ab.getContext().getResources().getColor(R.e.aVP);
        jio = color;
        jip = color;
    }

    public final void ce(boolean z) {
        Class cls = z ? com.tencent.mm.plugin.appbrand.ui.recents.a.class : b.class;
        Fragment E = super.aR().E(jir);
        if ((E == null || !cls.isInstance(E)) && !isFinishing() && !this.uSW) {
            Fragment aVar;
            p aV = super.aR().aV();
            if (z) {
                aVar = new com.tencent.mm.plugin.appbrand.ui.recents.a();
            } else {
                aVar = b.bg(getString(R.l.dDY), getString(R.l.dEK));
            }
            aVar.hPi = this.jis;
            aVar.jiC = this.jit;
            if (E != null) {
                aV.g(R.a.aQV, R.a.aQW);
            }
            aV.b(jir, aVar);
            aV.commit();
            if (z && this.jiy != null) {
                this.jiy.iBY[4] = "1";
            }
        }
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && !g.sf()) {
            g.a(getWindow(), true);
            return jip;
        } else if (VERSION.SDK_INT >= 21) {
            return jiq;
        } else {
            return super.getStatusBarColor();
        }
    }

    protected final void SC() {
        super.SC();
        getWindow().setSoftInputMode(3);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        com.tencent.mm.sdk.b.b ohVar = new oh();
        com.tencent.mm.sdk.b.a.urY.m(ohVar);
        if (ohVar.fVr.fVt) {
            this.jiu = true;
            this.jis = getIntent().getIntExtra("extra_enter_scene", 1);
            this.jit = getIntent().getStringExtra("extra_enter_scene_note");
            if (cO().cP() != null) {
                cO().cP().setBackgroundDrawable(new ColorDrawable(jio));
            }
            Y(new Runnable(this) {
                final /* synthetic */ AppBrandLauncherUI jiz;

                {
                    this.jiz = r1;
                }

                public final void run() {
                    if (!this.jiz.uSW && !this.jiz.isFinishing()) {
                        Fragment E = super.aR().E(AppBrandLauncherUI.jir);
                        if (E != null && (E instanceof a)) {
                            ((a) E).WN();
                        }
                    }
                }
            });
            qP(getResources().getString(R.l.dDY));
            zh(WebView.NIGHT_MODE_COLOR);
            zm(2130706432);
            a(new OnMenuItemClickListener(this) {
                final /* synthetic */ AppBrandLauncherUI jiz;

                {
                    this.jiz = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.jiz.onBackPressed();
                    return true;
                }
            }, R.g.bdk);
            if (com.tencent.mm.plugin.appbrand.h.a.Wy()) {
                int i = b.jiD - 1;
                int i2 = R.l.eYk;
                Drawable mutate = com.tencent.mm.svg.a.a.c(getResources(), R.k.dsV).mutate();
                mutate.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                this.uSU.a(i, getString(i2), mutate, new OnMenuItemClickListener(this) {
                    final /* synthetic */ AppBrandLauncherUI jiz;

                    {
                        this.jiz = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent();
                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                        intent.putExtra("neverGetA8Key", true);
                        intent.setClass(this.jiz.uSU.uTo, AppBrandSearchUI.class);
                        intent.putExtra("key_trust_url", true);
                        intent.putExtra("title", this.jiz.getString(R.l.dEf));
                        intent.putExtra("searchbar_tips", this.jiz.getString(R.l.dEf));
                        intent.putExtra("KRightBtn", true);
                        intent.putExtra("ftsneedkeyboard", true);
                        intent.putExtra("ftsType", 64);
                        intent.putExtra("ftsbizscene", bh.CTRL_INDEX);
                        intent.putExtra("rawUrl", com.tencent.mm.plugin.appbrand.h.d.m(n.a(bh.CTRL_INDEX, true, 64)));
                        intent.putExtra("key_load_js_without_delay", true);
                        intent.addFlags(67108864);
                        intent.putExtra("key_session_id", com.tencent.mm.modelappbrand.b.AK());
                        String str = "key_search_input_hint";
                        ap.yY();
                        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFW, null);
                        String str2 = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
                        intent.putExtra(str, str2);
                        this.jiz.startActivityForResult(intent, 1);
                        return true;
                    }
                });
            }
            this.uSU.ipu.setBackgroundColor(jio);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            View frameLayout = new FrameLayout(this);
            frameLayout.setId(jir);
            ((ViewGroup) this.uSU.ipu).addView(frameLayout, layoutParams);
            g.oUh.a(465, 0, 1, false);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            if (com.tencent.mm.plugin.appbrand.b.d.Rd()) {
                this.jiy = new d();
            }
            com.tencent.mm.plugin.appbrand.b.d.Rf();
            com.tencent.mm.plugin.appbrand.b.a.QK();
            return;
        }
        finish();
    }

    protected final void onResume() {
        boolean z;
        super.onResume();
        getStatusBarColor();
        if (!this.jiu) {
            if (this.jiv == 1) {
                this.jis = 7;
            } else if (this.jiv == 2) {
                this.jis = 6;
            } else if (this.jiv == 3) {
                this.jis = 9;
            } else {
                this.jis = 4;
            }
            this.jit = "";
            this.jiv = 0;
            a aVar = (a) super.aR().E(jir);
            if (aVar != null) {
                aVar.hPi = this.jis;
            }
        }
        this.jiu = false;
        if (com.tencent.mm.plugin.appbrand.b.a.QN() || com.tencent.mm.plugin.appbrand.b.a.QO()) {
            z = true;
        } else {
            z = false;
        }
        ce(z);
        if (!z && this.jiw) {
            com.tencent.mm.plugin.appbrand.b.c.a(this.jix);
            if (!com.tencent.mm.plugin.appbrand.b.c.refresh()) {
                com.tencent.mm.plugin.appbrand.b.c.b(this.jix);
            }
        }
        this.jiw = false;
    }

    protected final void onPause() {
        super.onPause();
    }

    protected final void onDestroy() {
        a aVar = (a) super.aR().E(jir);
        if (aVar != null) {
            aVar.WO();
        }
        super.onDestroy();
        com.tencent.mm.plugin.appbrand.b.c.b(this.jix);
        com.tencent.mm.plugin.appbrand.b.c.QZ();
        if (this.jiy != null) {
            g.oUh.i(14113, (Object[]) this.jiy.iBY);
            this.jiy = null;
        }
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jiv = i;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("key_session_id");
            int intExtra = intent.getIntExtra("ftsbizscene", 0);
            w.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[]{stringExtra, com.tencent.mm.modelappbrand.b.hpR});
            g.oUh.i(13929, new Object[]{stringExtra, com.tencent.mm.modelappbrand.b.hpR, Integer.valueOf(2), Integer.valueOf(intExtra)});
        }
    }

    public final void setTitle(CharSequence charSequence) {
        L(charSequence);
    }

    public final void setTitle(int i) {
        zi(i);
    }

    public final void onBackPressed() {
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
