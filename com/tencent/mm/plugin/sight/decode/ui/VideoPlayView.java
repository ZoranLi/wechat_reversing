package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.af.a.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView extends RelativeLayout implements f, com.tencent.mm.u.d.a {
    private int duration = 0;
    public String hIN;
    private ae hgN = new ae();
    private ProgressBar kYg;
    private boolean kmK = false;
    public f kmM = null;
    public View nRW;
    private int pvA = 320;
    private int pvB = 240;
    private boolean pvC = true;
    public a pvD;
    private ViewGroup pvE;
    public a pvF;
    private double pvG = 0.0d;
    public TextView pvH;
    public String pvI = "";
    public View pvJ;
    public View pvK;
    public boolean pvL = true;
    private int pvM = 0;
    private int pvN = 0;
    private boolean pvO = false;
    private boolean pvP = false;
    private long pvQ = 0;
    private Animation pvR = new AlphaAnimation(1.0f, 0.0f);
    private Animation pvS = new AlphaAnimation(0.0f, 1.0f);
    private Runnable pvT = new Runnable(this) {
        final /* synthetic */ VideoPlayView pvV;

        {
            this.pvV = r1;
        }

        public final void run() {
            this.pvV.bcv();
        }
    };
    public int pvU = 0;

    public interface a {
        void bcA();

        void bcy();

        void bcz();

        void hf(boolean z);

        void sJ(int i);
    }

    static /* synthetic */ void m(VideoPlayView videoPlayView) {
        if (videoPlayView.pvJ.getVisibility() == 0) {
            videoPlayView.bcv();
        } else {
            videoPlayView.bcu();
        }
    }

    public final void setVideoPath(String str) {
        this.hIN = str;
        w.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[]{this.hIN});
        this.kmM.setVideoPath(this.hIN);
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.pvR.setDuration(200);
        this.pvS.setDuration(200);
        View.inflate(getContext(), com.tencent.mm.plugin.af.a.f.pGq, this);
        this.pvJ = findViewById(e.rak);
        this.pvK = findViewById(e.raj);
        this.kYg = (ProgressBar) findViewById(e.cts);
        this.pvE = (ViewGroup) findViewById(e.cLG);
        this.kmM = n.dG(getContext());
        this.kmM.bN(false);
        this.pvE.addView((View) this.kmM, 0, new LayoutParams(-1, -1));
        this.pvH = (TextView) findViewById(e.cFd);
        this.nRW = this.pvH;
        this.kmM.a(new com.tencent.mm.pluginsdk.ui.tools.f.a(this) {
            final /* synthetic */ VideoPlayView pvV;

            {
                this.pvV = r1;
            }

            public final void Uc() {
                w.d("MicroMsg.VideoPlayView", g.sc() + " onPrepared");
                this.pvV.hd(true);
            }

            public final void onError(int i, int i2) {
                w.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.pvV.kmM.stop();
            }

            public final void oW() {
                w.d("MicroMsg.VideoPlayView", "on completion " + bg.bJZ().toString());
                if (this.pvV.pvO) {
                    this.pvV.pvF.bX(false);
                    this.pvV.sI((int) this.pvV.pvG);
                    this.pvV.bcu();
                    if (this.pvV.pvD != null) {
                        this.pvV.pvD.bcA();
                        return;
                    }
                    return;
                }
                this.pvV.pvG = 0.0d;
                this.pvV.k(0.0d);
                this.pvV.pvF.bX(false);
                this.pvV.sI(0);
                this.pvV.bcu();
                if (System.currentTimeMillis() - this.pvV.pvQ < 2000) {
                    w.i("MicroMsg.VideoPlayView", "Too short onCompletion");
                    return;
                }
                this.pvV.pvQ = System.currentTimeMillis();
                if (this.pvV.pvD != null) {
                    this.pvV.pvD.bcz();
                }
            }

            public final int bI(final int i, final int i2) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pvX;

                    public final void run() {
                        w.i("MicroMsg.VideoPlayView", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            this.pvX.pvV.duration = i2;
                            if (this.pvX.pvV.pvF != null && this.pvX.pvV.pvC) {
                                this.pvX.pvV.pvC = false;
                            }
                            this.pvX.pvV.pvD.sJ(i2);
                        }
                        if (this.pvX.pvV.pvF != null) {
                            if (this.pvX.pvV.pvF.bcm() != i2) {
                                this.pvX.pvV.pvF.sH(i2);
                            }
                            this.pvX.pvV.pvF.seek(i);
                            this.pvX.pvV.pvF.bX(true);
                        }
                        if (this.pvX.pvV.kYg.getVisibility() == 0) {
                            this.pvX.pvV.kYg.setVisibility(8);
                        }
                        this.pvX.pvV.pvG = (double) i;
                    }
                });
                return 0;
            }

            public final void bp(int i, int i2) {
                this.pvV.pvA = i;
                this.pvV.pvB = i2;
                if (this.pvV.pvP) {
                    this.pvV.hgN.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 pvX;

                        {
                            this.pvX = r1;
                        }

                        public final void run() {
                            this.pvX.pvV.update(this.pvX.pvV.pvU);
                        }
                    });
                }
            }
        });
        if (this.kmM instanceof VideoSightView) {
            ((VideoSightView) this.kmM).qld = false;
        }
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ VideoPlayView pvV;

            {
                this.pvV = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayView.m(this.pvV);
                } else {
                    motionEvent.getAction();
                }
                return true;
            }
        });
        bcv();
        ((View) this.kmM).post(new Runnable(this) {
            final /* synthetic */ VideoPlayView pvV;

            {
                this.pvV = r1;
            }

            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (this.pvV.getContext() instanceof MMActivity) {
                    ((MMActivity) this.pvV.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    if (this.pvV.kmM instanceof VideoSightView) {
                        ((VideoSightView) this.pvV.kmM).sF(displayMetrics.widthPixels);
                    }
                }
                ((View) this.pvV.kmM).requestLayout();
                ((View) this.pvV.kmM).postInvalidate();
            }
        });
    }

    public final void hc(boolean z) {
        this.pvO = z;
        if (this.kmM != null && (this.kmM instanceof VideoSightView)) {
            VideoSightView videoSightView = (VideoSightView) this.kmM;
            if (videoSightView.pvc != null) {
                videoSightView.pvc.pui = !z;
            }
        }
    }

    public final void bct() {
        this.kYg.setVisibility(0);
    }

    private void bcu() {
        ((View) this.pvF).setVisibility(0);
        this.pvJ.setVisibility(0);
        if (this.pvL) {
            this.pvK.setVisibility(0);
        }
        int i = this.pvU == 2 ? 0 : bg.mA(this.pvI) ? 0 : 1;
        if (i != 0) {
            this.nRW.setVisibility(0);
        }
        this.hgN.removeCallbacks(this.pvT);
        this.hgN.postDelayed(this.pvT, 3000);
    }

    public final void bcv() {
        if (this.pvF != null) {
            ((View) this.pvF).setVisibility(4);
        }
        this.pvJ.setVisibility(8);
        this.pvK.setVisibility(8);
        this.nRW.setVisibility(8);
    }

    public final boolean start() {
        hd(true);
        return true;
    }

    public final void pause() {
        sI(-1);
    }

    private void hd(boolean z) {
        this.kmM.k(this.pvG);
        this.kmM.start();
        w.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.pvG);
        if (this.pvD != null) {
            this.pvD.hf(z);
        }
    }

    private void sI(int i) {
        this.pvG = i >= 0 ? (double) i : this.kmM.bcw();
        w.i("MicroMsg.VideoPlayView", "pause play " + this.pvG + " lastTime: " + i + " last " + this.kmM.bcw());
        this.kmM.pause();
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ VideoPlayView pvV;

            {
                this.pvV = r1;
            }

            public final void run() {
                if (this.pvV.pvF != null) {
                    this.pvV.pvF.bX(false);
                }
            }
        });
        if (this.pvD != null) {
            this.pvD.bcy();
        }
    }

    public final boolean isPlaying() {
        return this.kmM.isPlaying();
    }

    public final String Ls() {
        return this.hIN;
    }

    public final boolean i(Context context, boolean z) {
        return this.kmM.i(context, z);
    }

    public final void stop() {
        this.kmM.stop();
    }

    public final void onDetach() {
        this.kmM.onDetach();
    }

    public final void bN(boolean z) {
        this.kmM.bN(z);
    }

    public final double bcw() {
        return Math.max(this.pvG, this.kmM.bcw());
    }

    public final void a(com.tencent.mm.pluginsdk.ui.tools.f.a aVar) {
        this.kmM.a(aVar);
    }

    public final int getCurrentPosition() {
        return this.kmM.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.duration == 0) {
            return this.kmM.getDuration();
        }
        return this.duration;
    }

    public final void k(double d) {
        this.kmM.k(d);
        this.pvF.seek((int) d);
    }

    public final void he(boolean z) {
        this.kmM.he(z);
    }

    public final void update(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.pvP = true;
        if (this.pvN == 0 || this.pvM == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.pvN = displayMetrics.heightPixels;
            this.pvM = displayMetrics.widthPixels;
            if (this.pvN < this.pvM) {
                this.pvN = displayMetrics.widthPixels;
                this.pvM = displayMetrics.heightPixels;
            }
            w.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.pvN + " screen_width:" + this.pvM);
        }
        ViewGroup.LayoutParams layoutParams2 = this.pvE.getLayoutParams();
        if (this.pvF == null) {
            layoutParams = null;
        } else {
            layoutParams = (LayoutParams) ((View) this.pvF).getLayoutParams();
        }
        ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        if (i == 1) {
            layoutParams3.width = this.pvM;
            layoutParams3.height = (int) (((((double) this.pvM) * 1.0d) * ((double) this.pvB)) / ((double) this.pvA));
            if (this.pvF != null) {
                layoutParams.bottomMargin = b.a(getContext(), 0.0f);
            }
        } else {
            layoutParams3.height = this.pvM;
            layoutParams3.width = (int) (((((double) this.pvM) * 1.0d) * ((double) this.pvA)) / ((double) this.pvB));
            if (this.pvF != null) {
                layoutParams.bottomMargin = b.a(getContext(), 0.0f);
            }
        }
        if (this.pvF != null) {
            this.pvF.bcp();
            ((View) this.pvF).setLayoutParams(layoutParams);
            if (this.pvF instanceof AdVideoPlayerLoadingBar) {
                this.hgN.postDelayed(new Runnable(this) {
                    final /* synthetic */ VideoPlayView pvV;

                    {
                        this.pvV = r1;
                    }

                    public final void run() {
                        if (!this.pvV.kmM.isPlaying()) {
                            ((AdVideoPlayerLoadingBar) this.pvV.pvF).bcr();
                        }
                    }
                }, 500);
            }
        }
        w.i("MicroMsg.VideoPlayView", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.kmM).setLayoutParams(layoutParams3);
        if (this.kmM instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.kmM).cR(layoutParams3.width, layoutParams3.height);
        }
        layoutParams2.height = layoutParams3.height;
        layoutParams2.width = layoutParams3.width;
        this.pvE.setLayoutParams(layoutParams2);
        ((View) this.kmM).requestLayout();
    }

    public final long bcx() {
        return 0;
    }

    public final void bQ(boolean z) {
        this.kmK = z;
    }

    public final void c(double d, boolean z) {
        k(d);
    }

    public final void a(f.e eVar) {
    }

    public final void a(c cVar) {
    }

    public final void a(f.b bVar) {
    }

    public final void a(d dVar) {
    }
}
