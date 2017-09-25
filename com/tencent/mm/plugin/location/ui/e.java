package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends ImageView {
    private static int ndp;
    private final String TAG = "MicroMsg.MyPoiPoint";
    private boolean aJi;
    private double aKh;
    public a gKp = new a(this) {
        final /* synthetic */ e ndr;

        {
            this.ndr = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            if (this.ndr.ndq) {
                return false;
            }
            w.d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            this.ndr.ndi = true;
            this.ndr.aKh = d2;
            this.ndr.ndj = (double) f2;
            this.ndr.ndk = (double) f;
            if (this.ndr.ndm != null) {
                if (this.ndr.ndn) {
                    this.ndr.ndm.updateViewLayout(this.ndr, this.ndr.ndj, this.ndr.ndk, -2);
                } else {
                    this.ndr.ndn = true;
                    this.ndr.ndm.addView(this.ndr, this.ndr.ndj, this.ndr.ndk, -2);
                }
            }
            if (this.ndr.ndg != null) {
                this.ndr.ndg.a(z, f, f2, i, d, d2, d3);
            }
            this.ndr.invalidate();
            this.ndr.postInvalidate();
            this.ndr.requestLayout();
            this.ndr.ndq = true;
            return true;
        }
    };
    private a ndg;
    private Bitmap ndh;
    private boolean ndi;
    private double ndj;
    private double ndk;
    public c ndl;
    private d ndm;
    private boolean ndn = false;
    private final int ndo = 689208551;
    private boolean ndq = false;
    private Activity qb;

    public e(Activity activity, int i, d dVar) {
        super(activity);
        this.ndm = dVar;
        this.ndg = null;
        this.qb = activity;
        this.ndh = com.tencent.mm.sdk.platformtools.d.yp(i);
        this.aJi = false;
        this.ndi = false;
        this.ndl = c.Gk();
        ndp = b.a(activity, 80.0f);
        setImageResource(i);
        setScaleType(ScaleType.FIT_CENTER);
        w.d("MicroMsg.MyPoiPoint", "enableLocation");
        this.aJi = true;
        this.ndl.a(this.gKp);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w.d("MicroMsg.MyPoiPoint", "onDraw");
    }
}
