package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Arrays;

public abstract class BaseVoicePrintUI extends MMActivity {
    private boolean neS = false;
    private final aj nfb = new aj(new a(this) {
        final /* synthetic */ BaseVoicePrintUI rdk;

        {
            this.rdk = r1;
        }

        public final boolean oQ() {
            if (this.rdk.rdc != null) {
                int maxAmplitude;
                p a = this.rdk.rdc;
                if (a.fyH != null) {
                    maxAmplitude = a.fyH.getMaxAmplitude();
                    if (maxAmplitude > p.fBC) {
                        p.fBC = maxAmplitude;
                    }
                    w.d("MicroMsg.VoicePrintRecoder", " map: " + maxAmplitude + " max:" + p.fBC + " per:" + ((maxAmplitude * 100) / p.fBC));
                    maxAmplitude = (maxAmplitude * 100) / p.fBC;
                } else {
                    maxAmplitude = 0;
                }
                BaseVoicePrintUI.a(this.rdk, (float) maxAmplitude);
            }
            return true;
        }
    }, true);
    String rcG = null;
    Button rcY;
    View rcZ;
    VoicePrintVolumeMeter rda;
    VoiceTipInfoView rdb;
    p rdc = null;
    String rdd = null;
    private boolean rde = false;
    private View rdf;
    private boolean rdg = false;
    private final p.a rdh = new p.a(this) {
        final /* synthetic */ BaseVoicePrintUI rdk;

        {
            this.rdk = r1;
        }

        public final void boC() {
            p a = this.rdk.rdc;
            if (a.fyH != null) {
                a.fyH.oX();
                w.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
            }
            a.fyF = "";
            a.rcQ = null;
            a.qTp = 0;
            a.lNF = 0;
            if (a.ict != null) {
                a.ict.rY();
            }
            w.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
            this.rdk.rdd = null;
            af.v(new Runnable(this.rdk) {
                final /* synthetic */ BaseVoicePrintUI rdk;

                {
                    this.rdk = r1;
                }

                public final void run() {
                    this.rdk.rdb.uI(R.l.faK);
                    this.rdk.rdb.boT();
                    this.rdk.rcY.setPressed(false);
                    this.rdk.rcY.setEnabled(false);
                    this.rdk.rda.stop();
                }
            });
        }
    };
    aj rdi = new aj(new a(this) {
        final /* synthetic */ BaseVoicePrintUI rdk;

        {
            this.rdk = r1;
        }

        public final boolean oQ() {
            VoiceTipInfoView c = this.rdk.rdb;
            if (c.rdG.getAnimation() == null) {
                View view = c.rdG;
                Context context = c.getContext();
                a.a anonymousClass1 = new a.a(c) {
                    final /* synthetic */ VoiceTipInfoView rel;

                    {
                        this.rel = r1;
                    }

                    public final void boH() {
                    }

                    public final void boI() {
                    }
                };
                float width = (float) view.getWidth();
                w.d("MicroMsg.VoiceViewAnimationHelper", "target " + width);
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i = (int) (width + ((float) iArr[0]));
                w.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i)});
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.aRR);
                loadAnimation.setDuration(200);
                loadAnimation.setStartOffset(0);
                loadAnimation.setRepeatCount(0);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass1(anonymousClass1));
                view.startAnimation(loadAnimation);
            }
            return false;
        }
    }, true);
    private ae rdj = new ae(Looper.getMainLooper(), new ae.a(this) {
        final /* synthetic */ BaseVoicePrintUI rdk;

        {
            this.rdk = r1;
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            w.d("MicroMsg.BaseVoicePrintUI", "start record");
            aq.b(ab.getContext(), R.l.eXV, new aq.a(this) {
                final /* synthetic */ AnonymousClass5 rdl;

                {
                    this.rdl = r1;
                }

                public final void oW() {
                    w.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
                }
            });
            this.rdk.rdd = "voice_pt_voice_print_record.rec";
            p a = this.rdk.rdc;
            String d = this.rdk.rdd;
            Context context = this.rdk;
            a.fyF = d;
            w.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[]{a.fyF});
            ap.yZ().a(a);
            int qG = ap.yZ().qG();
            a.qTm = false;
            a.ict = new b(context);
            if (qG != 0) {
                a.cW(100);
            } else {
                new ae(a) {
                    final /* synthetic */ p rcU;

                    {
                        this.rcU = r1;
                    }

                    public final void handleMessage(Message message) {
                        w.d("MicroMsg.VoicePrintRecoder", " Recorder handleMessage");
                        if (!this.rcU.qTm) {
                            ap.yZ().b(this.rcU);
                            ap.yZ().qH();
                            this.rcU.cW(m.CTRL_INDEX);
                        }
                    }
                }.sendEmptyMessageDelayed(0, 50);
            }
            this.rdk.nfb.v(100, 100);
            BaseVoicePrintUI baseVoicePrintUI = this.rdk;
            baseVoicePrintUI.rdb.boU();
            VoiceTipInfoView voiceTipInfoView = baseVoicePrintUI.rdb;
            w.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[]{Integer.valueOf(voiceTipInfoView.jhl.getVisibility()), Boolean.valueOf(voiceTipInfoView.reg)});
            if (voiceTipInfoView.jhl.getVisibility() != 0 || voiceTipInfoView.reg) {
                w.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
                voiceTipInfoView.jhl.clearAnimation();
                voiceTipInfoView.jhl.setVisibility(4);
                voiceTipInfoView.jhl.invalidate();
            } else {
                voiceTipInfoView.jhl.clearAnimation();
                voiceTipInfoView.reg = true;
                a.a(voiceTipInfoView.jhl, voiceTipInfoView.getContext(), new a.a(voiceTipInfoView) {
                    final /* synthetic */ VoiceTipInfoView rel;

                    {
                        this.rel = r1;
                    }

                    public final void boH() {
                    }

                    public final void boI() {
                        this.rel.jhl.setVisibility(4);
                        this.rel.reg = false;
                    }
                });
            }
            baseVoicePrintUI.rdb.HB(baseVoicePrintUI.rcG);
            baseVoicePrintUI.rdi.KH();
            baseVoicePrintUI.rdi.v(500, 500);
            baseVoicePrintUI.rcZ.setVisibility(0);
            VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI.rda;
            voicePrintVolumeMeter.reset();
            voicePrintVolumeMeter.mJX = true;
            long j = (long) VoicePrintVolumeMeter.nfU;
            voicePrintVolumeMeter.rdO.v(j, j);
            voicePrintVolumeMeter.boN();
            return true;
        }
    });

    protected abstract void aHe();

    protected abstract void boG();

    static /* synthetic */ void a(BaseVoicePrintUI baseVoicePrintUI, float f) {
        float f2 = 10.0f;
        if (f >= 10.0f) {
            f2 = f;
        }
        if (f2 > 100.0f) {
            f2 = 100.0f;
        }
        VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI.rda;
        f2 /= 100.0f;
        if (f2 > voicePrintVolumeMeter.rec) {
            voicePrintVolumeMeter.red = true;
        } else {
            voicePrintVolumeMeter.red = false;
        }
        voicePrintVolumeMeter.rec = f2;
    }

    static /* synthetic */ void i(BaseVoicePrintUI baseVoicePrintUI) {
        baseVoicePrintUI.rdf.setVisibility(0);
        if (baseVoicePrintUI.rdg) {
            baseVoicePrintUI.rdf.setVisibility(0);
            return;
        }
        baseVoicePrintUI.rdg = true;
        View view = baseVoicePrintUI.rdf;
        View view2 = baseVoicePrintUI.rcY;
        a.a anonymousClass8 = new a.a(baseVoicePrintUI) {
            final /* synthetic */ BaseVoicePrintUI rdk;

            {
                this.rdk = r1;
            }

            public final void boH() {
            }

            public final void boI() {
                this.rdk.rdf.setVisibility(0);
                this.rdk.rdg = false;
            }
        };
        view.clearAnimation();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        w.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, anchorLocation:%s", new Object[]{Arrays.toString(iArr)});
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        w.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, yStartDelta:%d", new Object[]{Integer.valueOf(iArr[1] - iArr2[1])});
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) r1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(0);
        animationSet.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass7(anonymousClass8));
        view.startAnimation(animationSet);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        this.rdb = (VoiceTipInfoView) findViewById(R.h.cID);
        this.rcY = (Button) findViewById(R.h.cwL);
        this.rcZ = findViewById(R.h.cOX);
        this.rda = (VoicePrintVolumeMeter) findViewById(R.h.cOY);
        this.rdf = findViewById(R.h.bvF);
        this.rdb.boU();
        this.rda.nfI = this.rcY;
        this.rdc = new p();
        this.rdc.rcT = this.rdh;
        this.rcY.setOnTouchListener(new OnTouchListener(this) {
            private long nfA = 0;
            final /* synthetic */ BaseVoicePrintUI rdk;
            private boolean rdm = false;

            {
                this.rdk = r3;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.rdk.neS = false;
                        if (!bg.mA(this.rdk.rcG)) {
                            this.nfA = System.currentTimeMillis();
                            this.rdk.rcY.setPressed(true);
                            this.rdk.rde = true;
                            this.rdk.boE();
                            this.rdk.rdj.sendEmptyMessageDelayed(1, 300);
                            w.i("MicroMsg.BaseVoicePrintUI", "mic press down");
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        this.rdk.rcY.setPressed(false);
                        this.rdk.rdj.removeMessages(1);
                        if (System.currentTimeMillis() - this.nfA < 300) {
                            w.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
                            this.rdk.neS = false;
                        } else {
                            this.rdk.neS = true;
                        }
                        w.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[]{Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(this.rdk.neS)});
                        this.rdk.rda.stop();
                        this.rdk.nfb.KH();
                        this.rdk.rdc.pd();
                        if (!this.rdk.neS) {
                            this.rdk.rdb.uI(R.l.faC);
                            this.rdk.rdb.boT();
                            break;
                        }
                        BaseVoicePrintUI baseVoicePrintUI = this.rdk;
                        w.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
                        if (!baseVoicePrintUI.rdc.rcS) {
                            baseVoicePrintUI.rdi.KH();
                            baseVoicePrintUI.rdb.uI(R.l.faC);
                            baseVoicePrintUI.rdb.boT();
                            baseVoicePrintUI.rdd = null;
                        }
                        baseVoicePrintUI.rcZ.setVisibility(8);
                        baseVoicePrintUI.rdb.boR();
                        baseVoicePrintUI.rdb.HB(baseVoicePrintUI.rcG);
                        w.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[]{this.rdk.rdd});
                        if (!bg.mA(this.rdk.rdd)) {
                            this.rdk.boG();
                        }
                        this.nfA = 0;
                        this.rdm = false;
                        this.rdk.neS = false;
                        break;
                }
                return false;
            }
        });
        findViewById(R.h.caZ).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BaseVoicePrintUI rdk;

            {
                this.rdk = r1;
            }

            public final void onClick(View view) {
                this.rdk.finish();
            }
        });
        aHe();
    }

    protected final void boD() {
        af.f(new Runnable(this) {
            final /* synthetic */ BaseVoicePrintUI rdk;

            {
                this.rdk = r1;
            }

            public final void run() {
                if (!this.rdk.rde) {
                    BaseVoicePrintUI.i(this.rdk);
                }
            }
        }, 1300);
    }

    protected final void boE() {
        if (this.rdf.getVisibility() != 4 && this.rdf.getVisibility() != 8) {
            if (this.rdg) {
                this.rdf.setVisibility(4);
                return;
            }
            this.rdg = true;
            a.a(this.rdf, this, new a.a(this) {
                final /* synthetic */ BaseVoicePrintUI rdk;

                {
                    this.rdk = r1;
                }

                public final void boH() {
                }

                public final void boI() {
                    this.rdk.rdf.setVisibility(4);
                    this.rdk.rdg = false;
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.dpE;
    }

    protected void onDestroy() {
        super.onDestroy();
        VoicePrintVolumeMeter voicePrintVolumeMeter = this.rda;
        voicePrintVolumeMeter.rdO.KH();
        voicePrintVolumeMeter.rdN.nJF.getLooper().quit();
        w.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
        w.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
        File file = new File(com.tencent.mm.plugin.voiceprint.model.m.at("voice_pt_voice_print_record.rec", false));
        if (file.exists()) {
            file.delete();
        }
        file = new File(com.tencent.mm.plugin.voiceprint.model.m.at("voice_pt_voice_print_noise_detect.rec", false));
        if (file.exists()) {
            file.delete();
        }
    }

    protected final void boF() {
        uG(R.l.faF);
    }

    protected final void uG(int i) {
        this.rdb.boQ();
        this.rdb.uI(i);
        this.rdb.boT();
    }
}
