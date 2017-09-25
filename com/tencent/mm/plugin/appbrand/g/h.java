package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.a.c;
import com.tencent.mm.plugin.appbrand.g.m.AnonymousClass13;
import com.tencent.mm.plugin.appbrand.g.m.AnonymousClass20;
import com.tencent.mm.plugin.appbrand.g.m.AnonymousClass7;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.widget.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.svg.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends SwipeBackLayout implements a, j.a {
    private View Ih;
    j iwr;
    private boolean jck;
    public boolean jcl = false;

    public abstract m VC();

    public abstract String VD();

    protected abstract View Vw();

    public abstract void b(String str, String str2, int[] iArr);

    public abstract void loadUrl(String str);

    public abstract boolean qh(String str);

    public h(Context context, j jVar) {
        super(context);
        this.iwr = jVar;
        setLayoutParams(new LayoutParams(-1, -1));
        init();
        this.wxG = false;
        lU(true);
        this.Ih = new i(getContext());
        ((ViewGroup) this.Ih).addView(Vw(), new LayoutParams(-1, -1));
        addView(this.Ih);
        this.Ih = this.Ih;
        this.wxL = this;
    }

    public void Po() {
        j.b(this);
    }

    public void Vz() {
        boolean z = true;
        w.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[]{VD()});
        j.b(this);
        this.wuc = false;
        j jVar = this.iwr;
        if (jVar.ixr.Ps() == null && jVar.jcp.size() == 1) {
            z = false;
        }
        this.mEnable = z;
        this.jck = false;
        setVisibility(0);
        VG();
    }

    public void VA() {
        w.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[]{VD()});
        j.a(this);
        this.jck = true;
    }

    protected void VB() {
        w.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[]{VD()});
    }

    public final void hide() {
        if (this.jck) {
            setVisibility(4);
        }
    }

    public final c VF() {
        return this.iwr.ixr.iwp.nZ(o.qW(VD()));
    }

    protected final void VG() {
        c VF = VF();
        m VC = VC();
        String str = VF.iEc;
        String str2 = VF.iEb;
        if (!VC.jdh) {
            VC.jdi = d.cd(str, VC.jdi);
        }
        if (!VC.jdj) {
            VC.jdk = str2;
        }
        VC.C(VC.jdi, VC.jdk);
    }

    protected final void VH() {
        c VF = VF();
        VC().qp(VF.iEa);
        m VC = VC();
        VC.runOnUiThread(new AnonymousClass7(VC, VF.iEc));
        VC = VC();
        VC.runOnUiThread(new AnonymousClass13(VC, VF.iEb));
        VC().ca(VF.iEh);
        VC = VC();
        VC.runOnUiThread(new AnonymousClass20(VC, VF.iEi, VF.iDX));
        VC().jdb.cl(true);
        if (com.tencent.mm.plugin.appbrand.permission.c.b(VC(), b.jbT)) {
            VC = VC();
            String str = VF.iEd;
            String str2 = VF.iEe;
            boolean z = VF.iEf;
            if (VC != null) {
                if (bg.mA(str) && bg.mA(str2) && !z) {
                    com.tencent.mm.plugin.appbrand.widget.a aVar = VC.jdb;
                    AppBrandOptionButton appBrandOptionButton = aVar.jqg;
                    appBrandOptionButton.jqE = true;
                    appBrandOptionButton.jqF.setVisibility(8);
                    appBrandOptionButton.jqI.setVisibility(0);
                    if (!(appBrandOptionButton.jqI.getDrawable() instanceof b)) {
                        appBrandOptionButton.jqI.setImageResource(R.k.dty);
                    }
                    aVar.jqg.setColor(aVar.jqj);
                    return;
                }
                a.a(VC, str, str2, z);
            }
        }
    }

    private void a(String str, v vVar) {
        Map hashMap = new HashMap();
        hashMap.put("path", o.qW(VD()));
        hashMap.put("query", o.qX(VD()));
        if (vVar != null) {
            hashMap.put("openType", vVar.toString());
        }
        com.tencent.mm.plugin.appbrand.m.d.r(hashMap);
        VC().a(str, new JSONObject(hashMap).toString(), null);
    }

    public final void a(v vVar) {
        a("onAppRoute", vVar);
        w.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[]{vVar.toString(), VD()});
    }

    public final void VI() {
        a("onAppRouteDone", null);
        w.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[]{VD()});
    }

    protected static boolean c(int[] iArr, int i) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final void O(float f) {
        if (this.jck) {
            if (f != 1.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.j.n(this.Ih, 0.0f);
            return;
        }
        com.tencent.mm.ui.tools.j.n(this.Ih, (((float) (this.Ih.getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }

    public final void d(boolean z, int i) {
        long j = 120;
        if (z) {
            View view = this.Ih;
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(view, j, 0.0f, null);
            return;
        }
        view = this.Ih;
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(view, j, (float) ((this.Ih.getWidth() * -1) / 4), null);
    }

    public final boolean VJ() {
        return false;
    }

    public final void VK() {
        if (getContext() instanceof MMActivity) {
            ((MMActivity) getContext()).aHf();
        }
        this.iwr.VM();
    }

    public final void VL() {
        this.jcl = true;
    }

    public final void onCancel() {
        this.jcl = false;
    }
}
