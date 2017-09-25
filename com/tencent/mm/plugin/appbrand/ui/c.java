package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.d;

@SuppressLint({"ViewConstructor"})
public final class c extends i implements h {
    private h ixr;
    private a jdb;
    private Runnable jiO;

    public c(Context context, h hVar) {
        super(context);
        this.ixr = hVar;
        View aVar = new a(context);
        this.jdb = aVar;
        addView(aVar);
        this.jdb.cl(false);
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ c jiP;

            {
                this.jiP = r1;
            }

            public final void onClick(View view) {
                e.a(this.jiP.ixr.ivH, com.tencent.mm.plugin.appbrand.e.c.CLOSE);
                this.jiP.ixr.finish();
            }
        };
        this.jdb.jqm = anonymousClass1;
        this.jdb.jql = anonymousClass1;
        h(this.ixr.iwn.fGs, -1, "black");
        setBackgroundColor(-1);
    }

    private void h(String str, int i, String str2) {
        this.jdb.rg(str);
        this.jdb.setBackgroundColor(i);
        this.jdb.rh(str2);
        this.jdb.cn(true);
        C(i, "black".equals(str2));
    }

    public final void bh(String str, String str2) {
        this.jdb.rg(str2);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jiO == null) {
            this.jiO = new Runnable(this) {
                final /* synthetic */ c jiP;

                {
                    this.jiP = r1;
                }

                public final void run() {
                    if (this.jiP.jdb != null) {
                        this.jiP.jdb.cp(true);
                    }
                }
            };
            postDelayed(this.jiO, 1500);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.jiO);
    }

    public final void WT() {
        removeCallbacks(this.jiO);
        post(new Runnable(this) {
            final /* synthetic */ c jiP;

            {
                this.jiP = r1;
            }

            public final void run() {
                this.jiP.setVisibility(8);
                if (this.jiP.getParent() != null) {
                    ((ViewGroup) this.jiP.getParent()).removeView(this.jiP);
                }
            }
        });
    }

    public final void WU() {
        this.jdb.co(true);
    }

    public final void a(com.tencent.mm.plugin.appbrand.config.a.c cVar) {
        h(cVar.iEa, d.cd(cVar.iEc, -1), cVar.iEb);
        setBackgroundColor(d.cd(cVar.iDX, -1));
    }

    public final View getView() {
        return this;
    }
}
