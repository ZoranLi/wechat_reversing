package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.af.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public class SightPlayImageView extends QPictureView implements com.tencent.mm.plugin.sight.decode.a.a {
    public b pvc;
    private int pve;
    private int pvf;
    private int pvg;
    private int pvh;
    public com.tencent.mm.pluginsdk.ui.tools.f.a pvi;
    public boolean pvj;
    private boolean pvk;
    public boolean pvl;

    private static final class a extends b {
        private WeakReference<SightPlayImageView> pvd;

        protected final int bbY() {
            return com.tencent.mm.plugin.af.a.a.aRJ;
        }

        public a(SightPlayImageView sightPlayImageView) {
            super(0, sightPlayImageView);
            this.pvd = new WeakReference(sightPlayImageView);
        }

        public final void bp(int i, int i2) {
            final SightPlayImageView sightPlayImageView = (SightPlayImageView) this.pvd.get();
            if (sightPlayImageView == null) {
                w.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
            } else if (!sightPlayImageView.pvl) {
                sightPlayImageView.pvg = i;
                sightPlayImageView.pvh = i2;
                if (sightPlayImageView.pvi != null) {
                    sightPlayImageView.pvi.bp(i, i2);
                }
                if (sightPlayImageView.pvk) {
                    if (sightPlayImageView.pvg >= sightPlayImageView.pvh) {
                        sightPlayImageView.pve = com.tencent.mm.bg.a.fromDPToPix(sightPlayImageView.getContext(), ck.CTRL_INDEX);
                    } else {
                        sightPlayImageView.pve = com.tencent.mm.bg.a.fromDPToPix(sightPlayImageView.getContext(), 85);
                    }
                }
                if (sightPlayImageView.pve > 0) {
                    final LayoutParams layoutParams = sightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == sightPlayImageView.pve && layoutParams.height == (sightPlayImageView.pve * i2) / i)) {
                        layoutParams.width = sightPlayImageView.pve;
                        layoutParams.height = (sightPlayImageView.pve * i2) / i;
                        af.v(new Runnable(this) {
                            final /* synthetic */ a pvo;

                            public final void run() {
                                sightPlayImageView.setLayoutParams(layoutParams);
                            }
                        });
                        sightPlayImageView.postInvalidate();
                    }
                    w.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                w.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(sightPlayImageView.pve), Integer.valueOf(i), Integer.valueOf(i2));
            }
        }

        public final void A(Bitmap bitmap) {
            SightPlayImageView sightPlayImageView = (SightPlayImageView) this.pvd.get();
            if (sightPlayImageView == null) {
                w.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                return;
            }
            sightPlayImageView.setImageBitmap(bitmap);
        }
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pvj = true;
        this.pvk = false;
        this.pvl = false;
        this.pvc = new a(this);
        w.i("MicroMsg.SightPlayImageView", "mController %s", new ah().toString());
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightPlayImageView(Context context) {
        this(context, null, 0);
    }

    public final String Ls() {
        return this.pvc.ptO;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (!this.pvl) {
            int height = bitmap == null ? this.pvf == 0 ? 240 : this.pvf : bitmap.getHeight();
            int width = bitmap == null ? this.pve == 0 ? 320 : this.pve : bitmap.getWidth();
            LayoutParams layoutParams = getLayoutParams();
            if (((float) layoutParams.height) != ((float) (this.pve * height)) / ((float) width)) {
                layoutParams.width = this.pve;
                layoutParams.height = (int) ((((float) height) * ((float) this.pve)) / ((float) width));
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (!this.pvl) {
            int intrinsicHeight = drawable == null ? this.pvf == 0 ? 240 : this.pvf : drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable == null ? this.pve == 0 ? 320 : this.pve : drawable.getIntrinsicWidth();
            if (intrinsicHeight != 0 && intrinsicWidth != 0) {
                LayoutParams layoutParams = getLayoutParams();
                if (((float) layoutParams.height) != (((float) this.pve) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)) {
                    layoutParams.width = this.pve;
                    layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.pve)) / ((float) intrinsicWidth));
                    setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void B(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public final void clear() {
        this.pvc.clear();
    }

    public final void ak(String str, boolean z) {
        this.pvc.ak(str, z);
    }

    public final boolean bbV() {
        return this.pvc.bca();
    }

    public final void kj(int i) {
        this.pvc.position = i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.pvc.clear();
        com.tencent.mm.sdk.b.a.urY.c(this.pvc.bcd());
    }

    protected void onAttachedToWindow() {
        w.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.urY.b(this.pvc.bcd());
    }

    public void sF(int i) {
        this.pvj = false;
        this.pve = i;
        if (this.pvg > 0 && this.pvh > 0) {
            LayoutParams layoutParams = getLayoutParams();
            this.pvf = (this.pve * this.pvh) / this.pvg;
            if (layoutParams.width != this.pve || layoutParams.height != this.pvf) {
                layoutParams.width = this.pve;
                layoutParams.height = this.pvf;
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void y(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void bbS() {
        setImageBitmap(null);
        setImageResource(d.bhP);
    }

    public final void bbR() {
        this.pvk = true;
        if (this.pvh > 0 && this.pvg > 0) {
            if (this.pvg >= this.pvh) {
                this.pve = com.tencent.mm.bg.a.fromDPToPix(getContext(), ck.CTRL_INDEX);
            } else {
                this.pve = com.tencent.mm.bg.a.fromDPToPix(getContext(), 85);
            }
            LayoutParams layoutParams = getLayoutParams();
            this.pvf = (this.pve * this.pvh) / this.pvg;
            if (layoutParams.width != this.pve || layoutParams.height != this.pvf) {
                layoutParams.width = this.pve;
                layoutParams.height = this.pvf;
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void bi(Object obj) {
        setTag(obj);
    }

    public final Object bbT() {
        return getTag();
    }

    public final Context bbU() {
        return getContext();
    }

    public void cR(int i, int i2) {
        this.pvj = false;
        LayoutParams layoutParams = getLayoutParams();
        this.pve = i;
        this.pvf = (this.pve * i2) / i;
        layoutParams.width = this.pve;
        layoutParams.height = this.pvf;
        setLayoutParams(layoutParams);
        postInvalidate();
    }

    public final void gZ(boolean z) {
        this.pvc.puj = z;
    }

    public final void a(e eVar) {
        this.pvc.puu = eVar;
    }

    public final void bbX() {
        this.pvc.puw = null;
    }

    public final void a(f fVar) {
        this.pvc.puv = fVar;
    }

    public final void h(TextView textView) {
        this.pvc.h(textView);
    }

    public final void hb(boolean z) {
        b bVar = this.pvc;
        w.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.pud != null) {
                bVar.pud.type = 0;
                o.b(bVar.pud, 0);
            }
            bVar.pud = null;
        } else if (bVar.pud == null) {
            bVar.pud = new i(bVar);
        }
    }

    public final void bbW() {
    }

    public int getDuration() {
        if (this.pvc == null) {
            return 0;
        }
        return (int) this.pvc.bce();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
