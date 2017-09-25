package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView extends QPictureView {
    private int pve;
    private int pvf;
    private int pvg;
    private int pvh;
    public com.tencent.mm.pluginsdk.ui.tools.f.a pvi;
    public boolean pvj;
    private boolean pvk;
    private boolean pvl;
    a qkZ;

    private static final class a extends a {
        private WeakReference<AdlandingSightPlayImageView> pvd;

        protected final int bbY() {
            return com.tencent.mm.plugin.sns.i.a.aRJ;
        }

        public a(AdlandingSightPlayImageView adlandingSightPlayImageView) {
            super(0, adlandingSightPlayImageView);
            this.pvd = new WeakReference(adlandingSightPlayImageView);
        }

        public final void bp(int i, int i2) {
            final AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.pvd.get();
            if (adlandingSightPlayImageView == null) {
                w.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
            } else if (!adlandingSightPlayImageView.pvl) {
                adlandingSightPlayImageView.pvg = i;
                adlandingSightPlayImageView.pvh = i2;
                if (adlandingSightPlayImageView.pvi != null) {
                    adlandingSightPlayImageView.pvi.bp(i, i2);
                }
                if (adlandingSightPlayImageView.pvk) {
                    if (adlandingSightPlayImageView.pvg >= adlandingSightPlayImageView.pvh) {
                        adlandingSightPlayImageView.pve = com.tencent.mm.bg.a.fromDPToPix(adlandingSightPlayImageView.getContext(), ck.CTRL_INDEX);
                    } else {
                        adlandingSightPlayImageView.pve = com.tencent.mm.bg.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 85);
                    }
                }
                if (adlandingSightPlayImageView.pve > 0) {
                    final LayoutParams layoutParams = adlandingSightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == adlandingSightPlayImageView.pve && layoutParams.height == (adlandingSightPlayImageView.pve * i2) / i)) {
                        layoutParams.width = adlandingSightPlayImageView.pve;
                        layoutParams.height = (adlandingSightPlayImageView.pve * i2) / i;
                        af.v(new Runnable(this) {
                            final /* synthetic */ a qlb;

                            public final void run() {
                                adlandingSightPlayImageView.setLayoutParams(layoutParams);
                            }
                        });
                        adlandingSightPlayImageView.postInvalidate();
                    }
                    w.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
                }
                w.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[]{Integer.valueOf(adlandingSightPlayImageView.pve), Integer.valueOf(i), Integer.valueOf(i2)});
            }
        }

        public final void A(Bitmap bitmap) {
            AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.pvd.get();
            if (adlandingSightPlayImageView == null) {
                w.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                return;
            }
            adlandingSightPlayImageView.setImageBitmap(bitmap);
        }
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pvj = true;
        this.pvk = false;
        this.pvl = false;
        this.qkZ = new a(this);
        w.i("MicroMsg.SightPlayImageView", "mController %s", new Object[]{new ah().toString()});
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String Ls() {
        return this.qkZ.ptO;
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

    public final void ak(String str, boolean z) {
        a aVar = this.qkZ;
        w.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[]{Integer.valueOf(aVar.hashCode()), str, aVar.ptO, Boolean.valueOf(z), Integer.valueOf(aVar.ptQ), Boolean.valueOf(aVar.pus), Boolean.valueOf(aVar.puj)});
        if (aVar.pus) {
            aVar.ha(false);
        } else if (aVar.bca()) {
            w.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            aVar.clear();
        } else if (!aVar.puj) {
            aVar.clear();
        } else if (z) {
            aVar.ptP = str;
            aVar.ha(false);
        } else if (aVar.ptO.equals(str)) {
            aVar.ptP = "ERROR#PATH";
            aVar.ha(false);
            aVar.restart();
        } else {
            aVar.clear();
            if (str == null) {
                str = "";
            }
            aVar.ptO = str;
            if (bg.mA(aVar.ptO)) {
                w.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                aVar.bgG();
            } else if (a.Es(aVar.ptO)) {
                aVar.qkI = new h(aVar);
                o.b(aVar.qkI, 0);
            } else {
                w.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                aVar.clear();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.qkZ.clear();
        com.tencent.mm.sdk.b.a.urY.c(this.qkZ.bcd());
    }

    protected void onAttachedToWindow() {
        w.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.urY.b(this.qkZ.bcd());
    }

    public final void sF(int i) {
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

    public final void a(f fVar) {
        this.qkZ.qkR = fVar;
    }

    public final void hb(boolean z) {
        a aVar = this.qkZ;
        w.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            if (aVar.qkK != null) {
                aVar.qkK.type = 0;
                o.b(aVar.qkK, 0);
            }
            aVar.qkK = null;
        } else if (aVar.qkK == null) {
            aVar.qkK = new i(aVar);
        }
    }

    public int getDuration() {
        if (this.qkZ == null) {
            return 0;
        }
        a aVar = this.qkZ;
        return (int) (aVar.ptQ == -1 ? 0.0d : SightVideoJNI.getVideoDuration(aVar.ptQ));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
