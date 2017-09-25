package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.iq;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;

public final class b extends com.tencent.mm.pluginsdk.ui.b.b implements OnClickListener, c {
    private static boolean jlp = false;
    public View jli;
    private TextView jlj;
    public ImageView jlk;
    public String jll;
    public Drawable jlm;
    private final Runnable jln = new Runnable(this) {
        final /* synthetic */ b jlq;

        {
            this.jlq = r1;
        }

        public final void run() {
            this.jlq.jll = null;
            this.jlq.jlk.setImageDrawable(this.jlq.jlm);
            Object obj = (this.jlq.jli == null || this.jlq.jli.getVisibility() != 0) ? null : 1;
            boolean Xj = this.jlq.Xj();
            if (obj == null && Xj) {
                a.urY.m(new iq());
            }
        }
    };
    private final h jlo = new h(this) {
        final /* synthetic */ b jlq;

        {
            this.jlq = r1;
        }

        public final void Ba() {
            if (this.jlq.jlk != null) {
                this.jlq.jlk.setImageDrawable(this.jlq.jlm);
            }
        }

        public final void h(Bitmap bitmap) {
            if (this.jlq.jlk != null) {
                int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.jlq.jlk.getContext(), 5);
                Drawable layerDrawable = new LayerDrawable(new Drawable[]{new BitmapDrawable(this.jlq.jlk.getContext().getResources(), bitmap)});
                layerDrawable.setLayerInset(0, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                this.jlq.jlk.setImageDrawable(layerDrawable);
            }
        }

        public final void Bb() {
        }

        public final String Bc() {
            return "AppBrandChattingBannerLoadTarget";
        }
    };

    public static com.tencent.mm.pluginsdk.ui.b.b bC(Context context) {
        return new b(context);
    }

    private b(Context context) {
        super(context);
        if (getView() != null) {
            getView().setOnClickListener(this);
            com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.b((c) this);
            this.jli = ((ViewGroup) getView()).getChildAt(0);
            this.jlj = (TextView) getView().findViewById(R.h.bzX);
            this.jlk = (ImageView) getView().findViewById(R.h.bzW);
            if (this.jlk != null) {
                ImageView imageView = this.jlk;
                Drawable c = com.tencent.mm.svg.a.a.c(this.jlk.getResources(), R.k.dtB);
                this.jlm = c;
                imageView.setImageDrawable(c);
            }
            setVisibility(8);
        }
    }

    public final int getLayoutId() {
        return R.i.cXp;
    }

    public final boolean Xj() {
        if (!jlp) {
            com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.a(this);
            com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.Xl();
            com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.b((c) this);
            jlp = true;
        }
        BannerModel Xo = BannerModel.Xo();
        if (Xo == null || bg.mA(Xo.appId)) {
            setVisibility(8);
            return false;
        }
        CharSequence charSequence = Xo.appName;
        String str = Xo.jlG;
        String str2 = Xo.jhe;
        if (!bg.mA(str)) {
            Object obj = str;
        }
        if (bg.mA(charSequence)) {
            return false;
        }
        setVisibility(0);
        if (this.jlj != null) {
            this.jlj.setText(charSequence);
        }
        if (!bg.mA(str2)) {
            Bitmap bitmap = null;
            if (!bg.mA(this.jll)) {
                bitmap = com.tencent.mm.modelappbrand.a.b.AY().gM(this.jll);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                this.jll = com.tencent.mm.modelappbrand.a.b.AY().a(this.jlo, str2, e.hqF);
            } else {
                this.jlo.h(bitmap);
            }
        }
        return true;
    }

    public final void setVisibility(int i) {
        if (this.jli != null) {
            this.jli.setVisibility(i);
        }
    }

    public final void destroy() {
        if (this.jli != null) {
            ((ViewGroup) this.jli).removeAllViews();
            this.jli.setVisibility(8);
        }
        this.jli = null;
        this.jlj = null;
        this.jlk = null;
        com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.a(this);
    }

    public final void onClick(View view) {
        BannerModel Xo = BannerModel.Xo();
        if (Xo != null) {
            String str = Xo.appId;
            int i = Xo.iPk;
            if (bg.mA(str)) {
                Xj();
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1022;
            AppBrandLaunchProxyUI.a(view.getContext(), null, str, null, i, -1, appBrandStatObject, null, null);
        }
    }

    public static void Xk() {
        jlp = false;
    }

    public final void S(String str, int i) {
        d.runOnUiThread(this.jln);
    }
}
