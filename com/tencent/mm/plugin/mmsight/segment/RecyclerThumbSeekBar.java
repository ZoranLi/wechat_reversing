package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.memory.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class RecyclerThumbSeekBar extends RelativeLayout implements d {
    private int hTi = -1;
    private int hhC;
    private int hhD;
    private c nHA;
    private n nHB;
    private int nHC;
    private com.tencent.mm.plugin.mmsight.segment.e.a nHD = new com.tencent.mm.plugin.mmsight.segment.e.a(4, new Callable<e>(this) {
        final /* synthetic */ RecyclerThumbSeekBar nHH;

        {
            this.nHH = r1;
        }

        public final /* synthetic */ Object call() {
            e fFmpegSightJNIThumbFetcher = new FFmpegSightJNIThumbFetcher();
            fFmpegSightJNIThumbFetcher.init(this.nHH.path, this.nHH.nHw, this.nHH.hhD, this.nHH.hhC);
            return fFmpegSightJNIThumbFetcher;
        }
    });
    private Runnable nHE = new Runnable(this) {
        final /* synthetic */ RecyclerThumbSeekBar nHH;

        {
            this.nHH = r1;
        }

        public final void run() {
            if (this.nHH.getHeight() == 0 || this.nHH.getWidth() == 0) {
                this.nHH.post(this.nHH.nHE);
                return;
            }
            this.nHH.nHw = 1000;
            this.nHH.hhC = this.nHH.getHeight();
            this.nHH.hhD = (this.nHH.getWidth() - (this.nHH.nHC * 2)) / 10;
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 nHI;

                {
                    this.nHI = r1;
                }

                public final void run() {
                    int i;
                    try {
                        e aLI = this.nHI.nHH.nHD.aLI();
                        this.nHI.nHH.hTi = aLI.getDurationMs();
                        this.nHI.nHH.nHD.a(aLI);
                        i = 1;
                    } catch (Throwable e) {
                        w.printErrStackTrace("RecyclerThumbSeekBar", e, "Try to init fetcher error : %s", new Object[]{e.getMessage()});
                        i = 0;
                    }
                    if (i == 0) {
                        this.nHI.nHH.aLP();
                        return;
                    }
                    if (this.nHI.nHH.hTi >= 10000) {
                        this.nHI.nHH.nHw = 1000;
                    } else if (this.nHI.nHH.hTi > 0) {
                        this.nHI.nHH.nHw = this.nHI.nHH.hTi / 10;
                    } else {
                        w.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[]{Integer.valueOf(this.nHI.nHH.hTi)});
                        this.nHI.nHH.aLP();
                        return;
                    }
                    w.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[]{Integer.valueOf(this.nHI.nHH.hTi), Integer.valueOf(this.nHI.nHH.nHw)});
                    af.v(new Runnable(this.nHI.nHH) {
                        final /* synthetic */ RecyclerThumbSeekBar nHH;

                        {
                            this.nHH = r1;
                        }

                        public final void run() {
                            try {
                                this.nHH.nHB.Z(-1.0f);
                                this.nHH.nHA = new c(this.nHH);
                                int e = RecyclerThumbSeekBar.e(this.nHH, 10000);
                                int e2 = RecyclerThumbSeekBar.e(this.nHH, 1000);
                                this.nHH.nHC = (this.nHH.getWidth() - e) / 2;
                                this.nHH.nHB.G(e, e2, this.nHH.nHC);
                                w.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", new Object[]{Integer.valueOf(this.nHH.getWidth())});
                                this.nHH.nHA.nHN = (this.nHH.getWidth() - this.nHH.nHC) - e;
                                this.nHH.nHA.nHM = this.nHH.nHC;
                                this.nHH.nHz.a(this.nHH.nHA);
                                w.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", new Object[]{Integer.valueOf(this.nHH.nHA.getItemCount())});
                                if (this.nHH.nHx != null) {
                                    this.nHH.nHx.fH(false);
                                }
                            } catch (Throwable e3) {
                                w.printErrStackTrace("RecyclerThumbSeekBar", e3, "RecyclerThumbSeekBar notifySuccess error : %s", new Object[]{e3.getMessage()});
                                if (this.nHH.nHx != null) {
                                    this.nHH.nHx.fH(true);
                                }
                            }
                        }
                    });
                }
            }, "check duration of ");
        }
    };
    private k nHF = new k(this) {
        final /* synthetic */ RecyclerThumbSeekBar nHH;

        {
            this.nHH = r1;
        }

        public final void e(RecyclerView recyclerView, int i) {
            if (i == 0 && this.nHH.nHy != null) {
                this.nHH.nHy.v(this.nHH.aLF(), this.nHH.aLG());
            }
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.n.a nHG = new com.tencent.mm.plugin.mmsight.segment.n.a(this) {
        final /* synthetic */ RecyclerThumbSeekBar nHH;

        {
            this.nHH = r1;
        }

        public final void aLQ() {
            if (this.nHH.nHy != null && this.nHH.nHA != null) {
                com.tencent.mm.plugin.mmsight.segment.d.b o = this.nHH.nHy;
                this.nHH.aLF();
                this.nHH.aLG();
                o.aLH();
            }
        }

        public final void aLR() {
            if (this.nHH.nHy != null && this.nHH.nHA != null) {
                this.nHH.nHy.w(this.nHH.aLF(), this.nHH.aLG());
            }
        }

        public final void fI(boolean z) {
            if (!(this.nHH.nHy == null || this.nHH.nHA == null)) {
                this.nHH.nHy.x(this.nHH.aLF(), this.nHH.aLG());
            }
            if (z) {
                this.nHH.nHA.m(true, this.nHH.nHB.aLS());
            } else {
                this.nHH.nHA.m(false, this.nHH.nHB.getWidth() - this.nHH.nHB.aLT());
            }
        }
    };
    private int nHw;
    private com.tencent.mm.plugin.mmsight.segment.d.a nHx;
    private com.tencent.mm.plugin.mmsight.segment.d.b nHy;
    private RecyclerView nHz;
    private String path;

    private class a implements Runnable {
        private Bitmap bitmap;
        private ImageView fKf;
        final /* synthetic */ RecyclerThumbSeekBar nHH;
        private b nHJ;

        a(RecyclerThumbSeekBar recyclerThumbSeekBar, Bitmap bitmap, ImageView imageView, b bVar) {
            this.nHH = recyclerThumbSeekBar;
            this.bitmap = bitmap;
            this.fKf = imageView;
            this.nHJ = bVar;
        }

        public final void run() {
            boolean z = true;
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                String str = "RecyclerThumbSeekBar";
                String str2 = "bitmap is null %b in DrawBitmapOnViewTask";
                Object[] objArr = new Object[1];
                if (this.bitmap != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                w.i(str, str2, objArr);
            } else if (this.nHJ == null || this.nHJ.hKd || this.fKf == null) {
                w.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
            } else {
                ImageView imageView = this.fKf;
                imageView.setTag(null);
                ObjectAnimator.ofInt(imageView, "imageAlpha", new int[]{50, 255}).setDuration(200).start();
                imageView.setImageBitmap(this.bitmap);
            }
        }
    }

    private class b implements Runnable {
        public int cIm;
        public boolean hKd = false;
        private ae handler;
        private WeakReference<ImageView> hqr;
        final /* synthetic */ RecyclerThumbSeekBar nHH;
        private Bitmap nHK;

        b(RecyclerThumbSeekBar recyclerThumbSeekBar, int i, ImageView imageView, Bitmap bitmap, ae aeVar) {
            this.nHH = recyclerThumbSeekBar;
            this.cIm = i;
            this.hqr = new WeakReference(imageView);
            this.handler = aeVar;
            this.nHK = bitmap;
        }

        public final void run() {
            if (this.hKd) {
                o.hgW.e(this.nHK);
            } else if (((ImageView) this.hqr.get()) == null) {
                o.hgW.e(this.nHK);
            } else {
                try {
                    e aLI = this.nHH.nHD.aLI();
                    if (this.nHK == null) {
                        this.nHK = o.hgW.a(new com.tencent.mm.memory.o.b(aLI.getScaledWidth(), aLI.getScaledHeight()));
                    }
                    aLI.reuseBitmap(this.nHK);
                    if (!this.hKd) {
                        this.nHK = aLI.getFrameAtTime((long) this.cIm);
                    }
                    this.nHH.nHD.a(aLI);
                    if (this.nHK == null || this.hKd || this.hqr.get() == null) {
                        o.hgW.e(this.nHK);
                    } else {
                        this.handler.post(new a(this.nHH, this.nHK, (ImageView) this.hqr.get(), this));
                    }
                } catch (Exception e) {
                    w.e("RecyclerThumbSeekBar", "get bitmap error " + e.getMessage());
                    o.hgW.e(this.nHK);
                }
            }
        }
    }

    private class c extends android.support.v7.widget.RecyclerView.a<e> {
        final /* synthetic */ RecyclerThumbSeekBar nHH;
        public d nHL = new d(this.nHH);
        public int nHM = this.nHH.nHC;
        public int nHN = this.nHH.nHC;
        private View nHO;
        private View nHP;

        public c(RecyclerThumbSeekBar recyclerThumbSeekBar) {
            this.nHH = recyclerThumbSeekBar;
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            View view;
            if (i == 1 || i == 2) {
                view = new View(this.nHH.getContext());
                if (i == 1) {
                    this.nHO = view;
                } else {
                    this.nHP = view;
                }
                return new e(this.nHH, view, 1);
            }
            View imageView = new ImageView(this.nHH.getContext());
            imageView.setScaleType(ScaleType.CENTER_CROP);
            imageView.setMinimumWidth(this.nHH.hhD);
            imageView.setMinimumHeight(this.nHH.hhC);
            view = new LinearLayout(this.nHH.getContext());
            view.addView(imageView, this.nHH.hhD, this.nHH.hhC);
            return new e(this.nHH, view, 0);
        }

        public final /* synthetic */ void a(t tVar, int i) {
            e eVar = (e) tVar;
            if (getItemViewType(i) == 1 || getItemViewType(i) == 2) {
                if (i == 0) {
                    eVar.abf.setMinimumWidth(this.nHM);
                } else {
                    eVar.abf.setMinimumWidth(this.nHN);
                }
                eVar.abf.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                eVar.abf.setMinimumHeight(this.nHH.hhC);
            } else if (this.nHL != null) {
                d dVar = this.nHL;
                int b = this.nHH.nHw * (i - 1);
                ImageView imageView = eVar.fKf;
                if (imageView != null && b >= 0) {
                    w.i("RecyclerThumbSeekBar", "loadImageAsync() called with: time = [" + b + "], view = [" + imageView + "]");
                    Object tag = imageView.getTag();
                    b bVar = (tag == null || !(tag instanceof b)) ? null : (b) tag;
                    if (bVar == null || bVar.cIm != b) {
                        if (bVar != null) {
                            bVar.hKd = true;
                        }
                        Bitmap bitmap = (imageView.getDrawable() == null || !(imageView.getDrawable() instanceof BitmapDrawable)) ? null : ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                        imageView.setImageBitmap(null);
                        Runnable bVar2 = new b(dVar.nHH, b, imageView, bitmap, dVar.handler);
                        imageView.setTag(bVar2);
                        int i2 = dVar.nHR % dVar.nDo;
                        dVar.nHR++;
                        if (dVar.nHQ[i2] != null) {
                            new ae(dVar.nHQ[i2].getLooper()).post(bVar2);
                            return;
                        }
                        return;
                    }
                    w.i("RecyclerThumbSeekBar", "SimpleImageLoader.loadImageAsync time equals %d return directly", new Object[]{Integer.valueOf(b)});
                }
            } else {
                w.e("RecyclerThumbSeekBar", "onBindViewHolder ImageLoader invoked after released.");
            }
        }

        public final int getItemViewType(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == getItemCount() - 1) {
                return 2;
            }
            return 0;
        }

        public final void m(boolean z, int i) {
            if (z) {
                if (this.nHO != null) {
                    this.nHO.setMinimumWidth(i);
                }
                if (((LinearLayoutManager) this.nHH.nHz.Zf).fa() == 0) {
                    this.nHH.nHz.scrollBy(i - this.nHM, 0);
                }
                this.nHM = i;
                return;
            }
            this.nHN = i;
            if (this.nHP != null) {
                this.nHP.setMinimumWidth(this.nHN);
            }
        }

        public final int getItemCount() {
            return this.nHH.hTi <= 0 ? 0 : Math.max(0, (int) Math.floor((double) (((float) this.nHH.hTi) / ((float) this.nHH.nHw)))) + 2;
        }
    }

    private class d {
        ae handler = new ae();
        int nDo = 4;
        final /* synthetic */ RecyclerThumbSeekBar nHH;
        HandlerThread[] nHQ = new HandlerThread[this.nDo];
        int nHR = 0;
        private BlockingDeque<b> nHS = new LinkedBlockingDeque();

        public d(RecyclerThumbSeekBar recyclerThumbSeekBar) {
            this.nHH = recyclerThumbSeekBar;
            for (int i = 0; i < this.nHQ.length; i++) {
                this.nHQ[i] = com.tencent.mm.sdk.f.e.cE("RecyclerThumbSeekBar_SimpleImageLoader_" + i, -1);
                this.nHQ[i].start();
            }
            this.nHR = 0;
        }
    }

    private class e extends t {
        ImageView fKf;
        final /* synthetic */ RecyclerThumbSeekBar nHH;

        e(RecyclerThumbSeekBar recyclerThumbSeekBar, View view, int i) {
            this.nHH = recyclerThumbSeekBar;
            super(view);
            if (i == 0) {
                this.fKf = (ImageView) ((LinearLayout) view).getChildAt(0);
            }
        }
    }

    static /* synthetic */ int e(RecyclerThumbSeekBar recyclerThumbSeekBar, int i) {
        if (recyclerThumbSeekBar.nHA == null) {
            throw new IllegalStateException("recyclerAdapter is null");
        } else if (recyclerThumbSeekBar.hTi <= 0) {
            throw new IllegalStateException("durationMs <= 0");
        } else {
            recyclerThumbSeekBar.nHA.getItemCount();
            return (int) ((Math.min(Math.max(0.0f, ((float) i) / ((float) recyclerThumbSeekBar.hTi)), 1.0f) * ((float) recyclerThumbSeekBar.hhD)) * ((float) (recyclerThumbSeekBar.nHA.getItemCount() - 2)));
        }
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.nHz = new RecyclerView(getContext());
        getContext();
        this.nHz.a(new LinearLayoutManager(0, false));
        this.nHz.Zl = true;
        int T = com.tencent.mm.bg.a.T(getContext(), com.tencent.mm.plugin.mmsight.segment.l.b.nHo);
        this.nHC = com.tencent.mm.bg.a.T(getContext(), com.tencent.mm.plugin.mmsight.segment.l.b.nHn);
        addView(this.nHz, new LayoutParams(-1, T));
        this.nHB = new n(getContext());
        addView(this.nHB, new LayoutParams(-1, -1));
        this.nHB.nIc = this.nHG;
        this.nHz.a(this.nHF);
    }

    public final void Y(float f) {
        float f2 = 0.0f;
        n nVar = this.nHB;
        if (!(this.nHA == null || this.nHz == null)) {
            float itemCount = ((float) (this.nHA.getItemCount() - 2)) * f;
            int floor = (int) Math.floor((double) itemCount);
            itemCount -= (float) floor;
            t bb = this.nHz.bb(floor + 1);
            if (bb != null) {
                View view = bb.abf;
                f2 = ((((float) view.getWidth()) * itemCount) + ((float) view.getLeft())) / ((float) getWidth());
            }
        }
        nVar.Z(f2);
    }

    public final void AT(String str) {
        if (bg.mA(str) || !FileOp.aO(str)) {
            aLP();
            return;
        }
        this.path = str;
        post(this.nHE);
    }

    public final int getDurationMs() {
        return this.hTi;
    }

    public final void fG(boolean z) {
        if (z) {
            this.nHB.nIe = true;
        } else {
            this.nHB.nIe = false;
        }
    }

    private void aLP() {
        af.v(new Runnable(this) {
            final /* synthetic */ RecyclerThumbSeekBar nHH;

            {
                this.nHH = r1;
            }

            public final void run() {
                if (this.nHH.nHx != null) {
                    this.nHH.nHx.fH(true);
                }
            }
        });
    }

    public final void release() {
        this.hTi = -1;
        this.path = null;
        if (this.nHD != null) {
            this.nHD.destroy();
        }
        if (this.nHA != null && this.nHA.nHL != null) {
            d dVar = this.nHA.nHL;
            if (!(dVar.nHQ == null || dVar.nHQ.length == 0)) {
                for (int i = 0; i < dVar.nHQ.length; i++) {
                    if (dVar.nHQ[i] != null) {
                        dVar.nHQ[i].quit();
                        dVar.nHQ[i] = null;
                    }
                }
            }
            this.nHA.nHL = null;
        }
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.d.a aVar) {
        this.nHx = aVar;
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.d.b bVar) {
        this.nHy = bVar;
    }

    public final float aLF() {
        if (this.nHB == null) {
            return 0.0f;
        }
        return pJ(this.nHB.aLS());
    }

    public final float aLG() {
        if (this.nHB == null) {
            return 0.0f;
        }
        return pJ(this.nHB.aLT());
    }

    private float pJ(int i) {
        if (this.nHA == null || this.nHz == null) {
            return 0.0f;
        }
        View j = this.nHz.j((float) i, 0.0f);
        int ba = RecyclerView.ba(j);
        int itemCount = this.nHA.getItemCount();
        if (ba <= 0) {
            return 0.0f;
        }
        if (ba >= itemCount - 1) {
            return 1.0f;
        }
        return (((float) (ba - 1)) + (((float) (i - j.getLeft())) / ((float) j.getWidth()))) / ((float) (itemCount - 2));
    }
}
