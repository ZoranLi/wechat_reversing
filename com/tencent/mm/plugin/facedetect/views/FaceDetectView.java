package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.c.a.c;

public class FaceDetectView extends RelativeLayout {
    public static long lCq = 100;
    public static int lCr = 1;
    public boolean isPaused;
    public volatile boolean kgf;
    public FaceDetectCameraView lCa;
    public FaceDetectDecorView lCb;
    public ViewGroup lCc;
    public ViewGroup lCd;
    public a lCe;
    public b lCf;
    public boolean lCg;
    public boolean lCh;
    public String lCi;
    public boolean lCj;
    public boolean lCk;
    public long lCl;
    private long lCm;
    private final int lCn;
    private Animation lCo;
    private View lCp;
    public long lwd;
    public TextView lzQ;

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ FaceDetectView lCs;
        final /* synthetic */ p lye = null;

        AnonymousClass5(FaceDetectView faceDetectView, p pVar) {
            this.lCs = faceDetectView;
        }

        public final void run() {
            this.lCs.lCa.asG();
            if (this.lye != null) {
                this.lye.b(this.lCs.lCa.asI());
            }
        }
    }

    class AnonymousClass4 implements c {
        final /* synthetic */ FaceDetectView lCs;
        final /* synthetic */ c lCv;

        public AnonymousClass4(FaceDetectView faceDetectView, c cVar) {
            this.lCs = faceDetectView;
            this.lCv = cVar;
        }

        public final void mr(int i) {
            w.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", new Object[]{Integer.valueOf(i)});
            if (i == 0) {
                this.lCs.lCh = false;
                this.lCs.asM();
            }
            if (this.lCv != null) {
                this.lCv.mr(i);
            }
        }
    }

    static /* synthetic */ void a(FaceDetectView faceDetectView, a aVar) {
        if (aVar == null) {
            w.e("MicroMsg.FaceDetectView", "hy: motion eat but no data");
            return;
        }
        Object obj;
        if (aVar == null) {
            w.e("MicroMsg.FaceDetectView", "hy: motion eat but no data");
        } else if (aVar.lxh > 0) {
            if (faceDetectView.lCe != null) {
                faceDetectView.lCe.mq(aVar.lxh);
            }
            obj = 1;
            if (obj == null) {
                faceDetectView.lCh = FaceCharacteristicsResult.mg(aVar.lxi);
                faceDetectView.vL(aVar.fPf == null ? aVar.fPf : faceDetectView.getContext().getString(h.ltE));
                if (faceDetectView.lCe != null) {
                    faceDetectView.lCe.R(aVar.lxi, aVar.fPf == null ? aVar.fPf : faceDetectView.getContext().getString(h.ltE));
                }
            }
        }
        obj = null;
        if (obj == null) {
            faceDetectView.lCh = FaceCharacteristicsResult.mg(aVar.lxi);
            if (aVar.fPf == null) {
            }
            faceDetectView.vL(aVar.fPf == null ? aVar.fPf : faceDetectView.getContext().getString(h.ltE));
            if (faceDetectView.lCe != null) {
                if (aVar.fPf == null) {
                }
                faceDetectView.lCe.R(aVar.lxi, aVar.fPf == null ? aVar.fPf : faceDetectView.getContext().getString(h.ltE));
            }
        }
    }

    static /* synthetic */ void e(FaceDetectView faceDetectView) {
        if (faceDetectView.lCf != null && faceDetectView.lCf.arX()) {
            w.i("MicroMsg.FaceDetectView", "hy: meet require");
            faceDetectView.lCa.asG();
            faceDetectView.isPaused = true;
            long aB = bg.aB(faceDetectView.lCl);
            w.i("MicroMsg.FaceDetectView", "hy: current motion used time: %d", new Object[]{Long.valueOf(aB)});
            if (aB < faceDetectView.lwd - 5) {
                af.f(new Runnable(faceDetectView) {
                    final /* synthetic */ FaceDetectView lCs;

                    {
                        this.lCs = r1;
                    }

                    public final void run() {
                        if (this.lCs.lCe != null && !this.lCs.kgf) {
                            this.lCs.lCe.R(0, "");
                        }
                    }
                }, faceDetectView.lwd - aB);
            } else if (faceDetectView.lCe != null && !faceDetectView.kgf) {
                faceDetectView.lCe.R(0, "");
            }
        }
    }

    static /* synthetic */ boolean f(FaceDetectView faceDetectView) {
        long NA = bg.NA();
        w.d("MicroMsg.FaceDetectView", "hy: tick between: %d, threshold: %d", new Object[]{Long.valueOf(NA - faceDetectView.lCm), Integer.valueOf(1500)});
        if (NA - faceDetectView.lCm <= 1500) {
            return false;
        }
        faceDetectView.lCm = NA;
        return true;
    }

    public FaceDetectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private FaceDetectView(Context context, AttributeSet attributeSet, int i, byte b) {
        Animation animation;
        super(context, attributeSet, i);
        this.lCa = null;
        this.lCb = null;
        this.lzQ = null;
        this.lCc = null;
        this.lCd = null;
        this.lCe = null;
        this.lCg = false;
        this.kgf = false;
        this.isPaused = false;
        this.lCh = false;
        this.lCi = ab.getContext().getString(h.luo);
        this.lCj = true;
        this.lCk = false;
        this.lwd = -1;
        this.lCl = -1;
        this.lCm = -1;
        this.lCn = 1500;
        this.lCp = null;
        View inflate = LayoutInflater.from(context).inflate(g.ltD, null, false);
        addView(inflate);
        this.lCa = (FaceDetectCameraView) inflate.findViewById(e.lsI);
        this.lCb = (FaceDetectDecorView) inflate.findViewById(e.ltj);
        this.lCp = inflate.findViewById(e.lti);
        this.lCa.lBo = new b(this) {
            final /* synthetic */ FaceDetectView lCs;

            {
                this.lCs = r1;
            }

            public final void b(int i, CharSequence charSequence) {
                w.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", new Object[]{Integer.valueOf(i), charSequence});
                if (this.lCs.kgf || this.lCs.isPaused) {
                    w.w("MicroMsg.FaceDetectView", "hy: already end or paused");
                } else if (this.lCs.lCf == null || !this.lCs.lCf.arY()) {
                    this.lCs.dX(false);
                    this.lCs.lCh = true;
                    this.lCs.vL(charSequence != null ? charSequence.toString() : this.lCs.getContext().getString(h.ltE));
                    if (this.lCs.lCe != null) {
                        this.lCs.lCe.R(i, charSequence != null ? charSequence.toString() : this.lCs.getContext().getString(h.ltE));
                    }
                } else {
                    w.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(this.lCs, this.lCs.lCf.asb());
                }
            }

            public final void c(FaceCharacteristicsResult faceCharacteristicsResult) {
                int i = faceCharacteristicsResult.errCode;
                String str = faceCharacteristicsResult.fPf;
                w.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", new Object[]{Integer.valueOf(i), str});
                if (this.lCs.kgf || this.lCs.isPaused) {
                    w.w("MicroMsg.FaceDetectView", "hy: already end");
                } else if (this.lCs.lCf == null || !this.lCs.lCf.a(faceCharacteristicsResult)) {
                    FaceDetectView.e(this.lCs);
                    if (!FaceDetectView.f(this.lCs)) {
                        return;
                    }
                    if (this.lCs.lCj || !(faceCharacteristicsResult.errCode == 10 || faceCharacteristicsResult.errCode == 11)) {
                        this.lCs.lCh = FaceCharacteristicsResult.mf(i);
                        FaceDetectView faceDetectView = this.lCs;
                        if (str == null) {
                            str = "";
                        }
                        faceDetectView.vL(str);
                    }
                } else {
                    w.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(this.lCs, this.lCs.lCf.asb());
                }
            }

            public final void d(FaceCharacteristicsResult faceCharacteristicsResult) {
                w.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", new Object[]{faceCharacteristicsResult.toString()});
                if (this.lCs.kgf || this.lCs.isPaused) {
                    w.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
                } else if (this.lCs.lCf == null || !this.lCs.lCf.b(faceCharacteristicsResult)) {
                    this.lCs.lCh = false;
                    if ((this.lCs.lCf != null && this.lCs.lCf.arX()) || FaceDetectView.f(this.lCs)) {
                        this.lCs.asM();
                        FaceDetectView.e(this.lCs);
                    }
                } else {
                    w.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(this.lCs, this.lCs.lCf.asb());
                }
            }
        };
        Context context2 = getContext();
        if (context2 == null) {
            w.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            animation = null;
        } else {
            animation = AnimationUtils.loadAnimation(context2, com.tencent.mm.s.a.a.hbs);
            animation.setInterpolator(new c());
        }
        this.lCo = animation;
    }

    public final void e(boolean z, final String str) {
        if (z) {
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ FaceDetectView lCs;

                public final void run() {
                    final Bitmap vH = o.vH(str);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 lCu;

                        public final void run() {
                            this.lCu.lCs.lCp.setVisibility(0);
                            this.lCu.lCs.lCp.setBackgroundDrawable(new BitmapDrawable(vH));
                        }
                    });
                }
            }, "face_detect_set_backgroud");
            return;
        }
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        this.lCp.startAnimation(alphaAnimation);
    }

    private void asM() {
        this.lzQ.setText("");
        this.lzQ.setVisibility(4);
    }

    private void vL(String str) {
        if (bg.mz(str).equals(this.lzQ.getText().toString())) {
            w.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
            return;
        }
        this.lzQ.setText(str);
        this.lzQ.setVisibility(0);
        this.lzQ.setAnimation(this.lCo);
    }

    public final int asN() {
        return this.lCa.lBG.arQ();
    }

    public final void dX(boolean z) {
        if (this.lCf != null) {
            this.lCf.arZ();
        }
        if (this.kgf) {
            w.w("MicroMsg.FaceDetectView", "hy: already end");
            return;
        }
        this.kgf = true;
        if (z) {
            if (this.lCa != null) {
                f.t(new AnonymousClass5(this, null));
            }
        } else if (this.lCa != null) {
            this.lCa.asG();
            f.lvS.lvT.lxY.arL();
        }
        w.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.lCh = false;
        asM();
    }
}
