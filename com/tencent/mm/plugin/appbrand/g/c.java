package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c extends h {
    private String jbX;
    private LinearLayout jbY;
    private FrameLayout jbZ;
    private e jca;
    private FrameLayout jcb;
    private m jcc = this.iwr.VO();
    private Map<String, m> jcd = new HashMap();
    private LinkedList<a> jce = new LinkedList();

    private static abstract class a implements Runnable {
        boolean RE = false;
        private boolean jch = false;

        public abstract void VE();

        public void run() {
            boolean z = (this.jch || this.RE) ? false : true;
            if (z) {
                this.jch = true;
                VE();
            }
        }
    }

    public c(Context context, j jVar) {
        super(context, jVar);
    }

    protected final View Vw() {
        if (this.jbY == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            this.jbZ = new FrameLayout(getContext());
            this.jbZ.setLayoutParams(new FrameLayout.LayoutParams(-1, b.bG(getContext())));
            this.jcb = new FrameLayout(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.jcb.setLayoutParams(layoutParams);
            this.jca = Vx();
            if ("top".equals(this.iwr.ixr.iwp.iDO.iDV)) {
                linearLayout.addView(this.jbZ);
                linearLayout.addView(this.jca);
                linearLayout.addView(this.jcb);
            } else {
                linearLayout.addView(this.jbZ);
                linearLayout.addView(this.jcb);
                linearLayout.addView(this.jca);
            }
            this.jbY = linearLayout;
        }
        return this.jbY;
    }

    private e Vx() {
        int i;
        e eVar = new e(getContext());
        d dVar = this.iwr.ixr.iwp.iDO;
        eVar.jqL = dVar.iDV;
        String str = dVar.hib;
        String str2 = dVar.iDW;
        String str3 = dVar.iDX;
        String str4 = dVar.iDY;
        eVar.jqM = com.tencent.mm.plugin.webview.ui.tools.d.cd(str, eVar.getResources().getColor(R.e.aVo));
        eVar.jqN = com.tencent.mm.plugin.webview.ui.tools.d.cd(str2, eVar.getResources().getColor(R.e.aWu));
        float fromDPToPix = (float) com.tencent.mm.bg.a.fromDPToPix(eVar.getContext(), 1);
        if (fromDPToPix / 2.0f > 1.0f) {
            i = (int) (fromDPToPix / 2.0f);
        } else {
            i = 1;
        }
        new GradientDrawable().setColor(com.tencent.mm.plugin.webview.ui.tools.d.cd(str3, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        if ("white".equals(str4)) {
            gradientDrawable.setStroke(i, Color.parseColor("#33ffffff"));
        } else {
            gradientDrawable.setStroke(i, Color.parseColor("#33000000"));
        }
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{r2, gradientDrawable});
        if ("top".equals(eVar.jqL)) {
            layerDrawable.setLayerInset(1, -i, -i, -i, -i);
        } else {
            layerDrawable.setLayerInset(1, -i, 0, -i, -i);
        }
        eVar.jqK.setImageDrawable(layerDrawable);
        Iterator it = dVar.fQx.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.appbrand.config.a.e eVar2 = (com.tencent.mm.plugin.appbrand.config.a.e) it.next();
            str2 = eVar2.url;
            str3 = eVar2.text;
            str4 = eVar2.fSl;
            str = eVar2.iDZ;
            a aVar = new a();
            try {
                aVar.uL = e.ri(str4);
                aVar.jqS = e.ri(str);
            } catch (Exception e) {
                w.e("MicroMsg.AppBrandPageTabBar", e.getMessage());
            }
            aVar.jqT = str3;
            aVar.mUrl = str2;
            if (aVar.jqT == null && (aVar.uL == null || aVar.jqS == null)) {
                w.e("MicroMsg.AppBrandPageTabBar", "illegal data");
            } else {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(eVar.getContext()).inflate(R.i.cUx, eVar.jqJ, false);
                eVar.a(linearLayout, aVar, false);
                linearLayout.setOnClickListener(new OnClickListener(eVar) {
                    final /* synthetic */ e jqR;

                    {
                        this.jqR = r1;
                    }

                    public final void onClick(View view) {
                        this.jqR.iJ(this.jqR.jqJ.indexOfChild(view));
                        e.b(this.jqR);
                    }
                });
                eVar.jqO.add(aVar);
                eVar.jqJ.addView(linearLayout);
            }
        }
        eVar.jqQ = new e.b(this) {
            final /* synthetic */ c jcf;

            {
                this.jcf = r1;
            }

            public final void qi(String str) {
                this.jcf.iwr.qk(str);
            }
        };
        return eVar;
    }

    public final void loadUrl(final String str) {
        if (!str.equals(this.jbX)) {
            int rj = this.jca.rj(str);
            if (rj >= 0) {
                this.jbX = str;
                this.jca.iJ(rj);
                if (this.jcd.get(o.qW(str)) == null) {
                    final m qf = qf(o.qW(str));
                    VH();
                    final Runnable anonymousClass2 = new a(this) {
                        final /* synthetic */ c jcf;

                        public final void VE() {
                            this.jcf.qg(str);
                            this.jcf.iwr.VP();
                        }
                    };
                    final long currentTimeMillis = System.currentTimeMillis();
                    qf.a(new m.e(this) {
                        final /* synthetic */ c jcf;

                        public final void onReady() {
                            qf.b((m.e) this);
                            anonymousClass2.run();
                            long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                            w.i("MicroMsg.AppBrandMultiplePage", "Tab page onReady received, time: %d", new Object[]{Long.valueOf(currentTimeMillis)});
                        }
                    });
                    if (this.jcd.size() > 1) {
                        this.jce.add(anonymousClass2);
                        postDelayed(anonymousClass2, 500);
                    }
                    qf.qo(str);
                    return;
                }
                Vy();
                qg(str);
            }
        }
    }

    private synchronized m qf(String str) {
        m mVar;
        if (this.jcc != null) {
            mVar = this.jcc;
            this.jcc = null;
        } else {
            mVar = this.iwr.VO();
        }
        this.jcd.put(str, mVar);
        mVar.jbY.removeView(mVar.jdb);
        this.jcb.addView(mVar.jbY, 0);
        return mVar;
    }

    private void qg(String str) {
        m mVar = (m) this.jcd.get(o.qW(str));
        mVar.jbY.setVisibility(4);
        m mVar2 = null;
        for (m mVar3 : this.jcd.values()) {
            m mVar32;
            if (mVar32.jbY.getVisibility() != 0) {
                mVar32 = mVar2;
            }
            mVar2 = mVar32;
        }
        mVar.jbY.setVisibility(0);
        if (this.jbZ.indexOfChild(mVar.jdb) == -1) {
            this.jbZ.addView(mVar.jdb, 0);
        }
        if (mVar2 != null) {
            mVar2.jbY.setVisibility(4);
            this.jbZ.removeView(mVar2.jdb);
        }
        mVar.UA();
        if (mVar2 != null) {
            mVar2.SY();
        }
        VG();
    }

    private void Vy() {
        Iterator it = this.jce.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            removeCallbacks(aVar);
            aVar.RE = true;
        }
        this.jce.clear();
    }

    public final boolean qh(String str) {
        return this.jca.rj(str) != -1;
    }

    public final void Vz() {
        super.Vz();
        VC().UA();
    }

    public final void VA() {
        super.VA();
        VC().SY();
    }

    protected final void VB() {
        super.VB();
        if (this.jcc != null) {
            this.jcc.onDestroy();
        }
        for (m onDestroy : this.jcd.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void b(String str, String str2, int[] iArr) {
        if (this.jcc != null && h.c(iArr, this.jcc.hashCode())) {
            this.jcc.f(str, str2, 0);
        }
        for (m mVar : this.jcd.values()) {
            if (h.c(iArr, mVar.hashCode())) {
                mVar.f(str, str2, 0);
            }
        }
    }

    public final void Po() {
        super.Po();
        if (this.jcc != null) {
            this.jcc.Po();
        }
        for (m Po : this.jcd.values()) {
            Po.Po();
        }
        Vy();
    }

    public final synchronized m VC() {
        m mVar;
        if (this.jcc != null) {
            mVar = this.jcc;
        } else {
            mVar = (m) this.jcd.get(o.qW(this.jbX));
        }
        return mVar;
    }

    public final String VD() {
        return this.jbX;
    }
}
