package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView extends MMTextureView implements com.tencent.mm.plugin.sight.decode.a.a {
    private int hTj;
    private int hTk;
    private Surface nIX;
    private com.tencent.mm.plugin.sight.decode.a.b pvc;
    private int pve;
    private boolean pvk;
    private int pvp;

    private static final class a implements Runnable {
        Surface pvr = null;

        public final void run() {
            if (this.pvr != null) {
                this.pvr.release();
            }
        }
    }

    private static final class b extends com.tencent.mm.plugin.sight.decode.a.b {
        public WeakReference<SightPlayTextureView> pvs;

        protected final int bbY() {
            return R.a.aRJ;
        }

        public b(SightPlayTextureView sightPlayTextureView) {
            super(1, sightPlayTextureView);
            this.pvs = new WeakReference(sightPlayTextureView);
        }

        public final void bp(int i, int i2) {
            if (this.pvs.get() == null) {
                w.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
                clear();
                return;
            }
            ((SightPlayTextureView) this.pvs.get()).hTk = i;
            ((SightPlayTextureView) this.pvs.get()).hTj = i2;
            w.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(((SightPlayTextureView) this.pvs.get()).pvk)});
            final LayoutParams layoutParams = ((SightPlayTextureView) this.pvs.get()).getLayoutParams();
            if (((SightPlayTextureView) this.pvs.get()).pvk && i > 0 && i2 > 0) {
                if (i >= i2) {
                    ((SightPlayTextureView) this.pvs.get()).pve = com.tencent.mm.bg.a.fromDPToPix(((SightPlayTextureView) this.pvs.get()).getContext(), ck.CTRL_INDEX);
                } else {
                    ((SightPlayTextureView) this.pvs.get()).pve = com.tencent.mm.bg.a.fromDPToPix(((SightPlayTextureView) this.pvs.get()).getContext(), 85);
                }
            }
            if (layoutParams.height != (((SightPlayTextureView) this.pvs.get()).pve * i2) / i) {
                layoutParams.width = ((SightPlayTextureView) this.pvs.get()).pve;
                layoutParams.height = (((SightPlayTextureView) this.pvs.get()).pve * i2) / i;
                if (((SightPlayTextureView) this.pvs.get()).pvk && layoutParams.height < com.tencent.mm.bg.a.fromDPToPix(((SightPlayTextureView) this.pvs.get()).getContext(), 50)) {
                    layoutParams.height = com.tencent.mm.bg.a.fromDPToPix(((SightPlayTextureView) this.pvs.get()).getContext(), 50);
                }
                w.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
                if (af.isMainThread()) {
                    ((SightPlayTextureView) this.pvs.get()).setLayoutParams(layoutParams);
                } else {
                    af.v(new Runnable(this) {
                        final /* synthetic */ b pvt;

                        public final void run() {
                            ((SightPlayTextureView) this.pvt.pvs.get()).setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            this.ptT = com.tencent.mm.plugin.sight.decode.a.b.a(((SightPlayTextureView) this.pvs.get()).getContext(), ((SightPlayTextureView) this.pvs.get()).pvp, ((SightPlayTextureView) this.pvs.get()).pve, i, i2);
        }

        public final void A(Bitmap bitmap) {
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pvk = false;
        setOpaque(false);
        this.pvc = new b(this);
        setSurfaceTextureListener(new SurfaceTextureListener(this) {
            final /* synthetic */ SightPlayTextureView pvq;

            {
                this.pvq = r1;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                w.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + i + " height " + i2);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                w.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
                this.pvq.pvc.a(null);
                this.pvq.pvc.clear();
                Runnable aVar = new a();
                aVar.pvr = this.pvq.nIX;
                o.b(aVar, 0);
                this.pvq.nIX = null;
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                w.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Runnable aVar = new a();
                aVar.pvr = this.pvq.nIX;
                o.b(aVar, 0);
                this.pvq.nIX = new Surface(surfaceTexture);
                this.pvq.pvc.a(this.pvq.nIX);
                this.pvq.bSB();
            }
        });
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String Ls() {
        return this.pvc.ptO;
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
        w.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.pvc.clear();
        com.tencent.mm.sdk.b.a.urY.c(this.pvc.bcd());
    }

    protected void onAttachedToWindow() {
        w.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.urY.b(this.pvc.bcd());
    }

    public final void sF(int i) {
        this.pve = i;
        j(0.75d);
    }

    private void j(double d) {
        final LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((double) this.pve) * d))) {
            layoutParams.width = this.pve;
            layoutParams.height = (int) (((double) this.pve) * d);
            if (this.pvk && layoutParams.height < com.tencent.mm.bg.a.fromDPToPix(getContext(), 50)) {
                layoutParams.height = com.tencent.mm.bg.a.fromDPToPix(getContext(), 50);
            }
            w.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
            if (af.isMainThread()) {
                setLayoutParams(layoutParams);
            } else {
                af.v(new Runnable(this) {
                    final /* synthetic */ SightPlayTextureView pvq;

                    public final void run() {
                        this.pvq.setLayoutParams(layoutParams);
                    }
                });
            }
        }
    }

    public final void y(Bitmap bitmap) {
        String str = "MicroMsg.SightPlayTextureView";
        String str2 = "thumb is null? %B, surface is null? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bitmap == null);
        objArr[1] = Boolean.valueOf(this.nIX == null);
        w.d(str, str2, objArr);
        if (bitmap != null) {
            w.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            if (this.pvk) {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    this.pve = com.tencent.mm.bg.a.fromDPToPix(getContext(), ck.CTRL_INDEX);
                } else {
                    this.pve = com.tencent.mm.bg.a.fromDPToPix(getContext(), 85);
                }
            }
            Bitmap a = com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), this.pvp, this.pve, bitmap.getWidth(), bitmap.getHeight());
            j(((double) bitmap.getHeight()) / ((double) bitmap.getWidth()));
            this.pvc.ptT = a;
            this.pvc.z(bitmap);
            return;
        }
        this.pvc.z(null);
    }

    public final void bbS() {
        SightVideoJNI.drawSurfaceThumb(this.nIX, com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), R.g.bhP, this.pve, 320, 240), com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), this.pvp, this.pve, 320, 240));
    }

    public final void bbR() {
        this.pvk = true;
        if (this.hTj > 0 && this.hTk > 0) {
            if (this.hTk >= this.hTj) {
                this.pve = com.tencent.mm.bg.a.fromDPToPix(getContext(), ck.CTRL_INDEX);
            } else {
                this.pve = com.tencent.mm.bg.a.fromDPToPix(getContext(), 85);
            }
            j(0.75d);
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

    public final void cR(int i, int i2) {
        final LayoutParams layoutParams = getLayoutParams();
        this.pve = i;
        layoutParams.width = this.pve;
        layoutParams.height = (this.pve * i2) / i;
        w.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
        if (af.isMainThread()) {
            setLayoutParams(layoutParams);
        } else {
            af.v(new Runnable(this) {
                final /* synthetic */ SightPlayTextureView pvq;

                public final void run() {
                    this.pvq.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public final void gZ(boolean z) {
        this.pvc.puj = z;
    }

    public final void a(e eVar) {
        this.pvc.puu = eVar;
    }

    public final void bbX() {
    }

    public final void h(TextView textView) {
        this.pvc.h(textView);
    }

    public final void bbW() {
    }

    public final void a(f fVar) {
        this.pvc.puv = fVar;
    }
}
