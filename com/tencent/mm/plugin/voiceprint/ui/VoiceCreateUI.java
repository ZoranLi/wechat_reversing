package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rm;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;

public class VoiceCreateUI extends BaseVoicePrintUI implements a {
    private int rcF = 1;
    private int rdA = 0;
    private c rdB = new c<rm>(this) {
        final /* synthetic */ VoiceCreateUI rdC;

        {
            this.rdC = r2;
            this.usg = rm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            w.d("MicroMsg.VoiceCreateUI", "detect finish, noise:%b", new Object[]{Boolean.valueOf(((rm) bVar).fYx.fYy)});
            if (((rm) bVar).fYx.fYy) {
                VoiceCreateUI.a(this.rdC);
            } else {
                VoiceCreateUI.b(this.rdC);
            }
            return false;
        }
    };
    private l rdu;
    private o rdv = null;
    private View rdw;
    private NoiseDetectMaskView rdx;
    private View rdy = null;
    private Button rdz = null;

    static /* synthetic */ void a(VoiceCreateUI voiceCreateUI) {
        g.oUh.i(11390, new Object[]{Integer.valueOf(4)});
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.rdx;
        if (noiseDetectMaskView.kYg != null) {
            noiseDetectMaskView.kYg.setVisibility(8);
        }
        noiseDetectMaskView.rdn.setText(R.l.faI);
        noiseDetectMaskView.rdo.setVisibility(0);
    }

    static /* synthetic */ void b(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.rdy.setVisibility(0);
        voiceCreateUI.rdw.setVisibility(0);
        voiceCreateUI.rcZ.setVisibility(0);
        View view = voiceCreateUI.rdx;
        a.a anonymousClass6 = new a.a(voiceCreateUI) {
            final /* synthetic */ VoiceCreateUI rdC;

            {
                this.rdC = r1;
            }

            public final void boH() {
            }

            public final void boI() {
                this.rdC.rdx.setVisibility(8);
                VoiceCreateUI.h(this.rdC);
            }
        };
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass6(anonymousClass6));
        view.startAnimation(translateAnimation);
    }

    static /* synthetic */ void h(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.rdb.boP();
        voiceCreateUI.rcF = 1;
        voiceCreateUI.rdu.rcF = 71;
        ap.vd().a(new d(71, ""), 0);
    }

    protected final void boG() {
        w.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[]{this.rdd});
        if (!bg.mA(this.rdd)) {
            this.rcY.setEnabled(false);
            this.rdb.boP();
            l lVar;
            k fVar;
            if (this.rcF == 1) {
                lVar = this.rdu;
                fVar = new f(this.rdd, 71, lVar.rcH, 0);
                fVar.rcn = true;
                ap.vd().a(fVar, 0);
                lVar.rcF = 71;
            } else if (this.rcF == 2) {
                lVar = this.rdu;
                fVar = new f(this.rdd, 72, lVar.rcH, lVar.rcq);
                fVar.rcn = true;
                ap.vd().a(fVar, 0);
                lVar.rcF = 72;
            }
        }
    }

    protected final void aHe() {
        this.rdu = new l(this);
        findViewById(R.h.cyU).setVisibility(8);
        this.rdb.uH(R.l.faJ);
        this.rdb.boS();
        this.rcY.setEnabled(false);
        this.rdv = new o();
        this.rdw = findViewById(R.h.cMM);
        this.rdx = (NoiseDetectMaskView) findViewById(R.h.mask);
        this.rdy = findViewById(R.h.caZ);
        this.rdz = (Button) findViewById(R.h.cyU);
        this.rdz.setVisibility(8);
        this.rdz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceCreateUI rdC;

            {
                this.rdC = r1;
            }

            public final void onClick(View view) {
                this.rdC.boE();
                a.a(this.rdC.rdb, new a.a(this) {
                    final /* synthetic */ AnonymousClass2 rdD;

                    {
                        this.rdD = r1;
                    }

                    public final void boH() {
                        this.rdD.rdC.rdz.setVisibility(8);
                        this.rdD.rdC.rdb.uH(R.l.faJ);
                        this.rdD.rdC.rdb.rdG.setVisibility(0);
                        this.rdD.rdC.rcY.setEnabled(true);
                        this.rdD.rdC.rcY.setVisibility(0);
                    }

                    public final void boI() {
                    }
                });
            }
        });
        this.rdx.rdp = new NoiseDetectMaskView.b(this) {
            final /* synthetic */ VoiceCreateUI rdC;

            {
                this.rdC = r1;
            }

            public final void boK() {
                g.oUh.i(11390, new Object[]{Integer.valueOf(5)});
                this.rdC.start();
            }
        };
        this.rdx.rdq = new NoiseDetectMaskView.a(this) {
            final /* synthetic */ VoiceCreateUI rdC;

            {
                this.rdC = r1;
            }

            public final void boJ() {
                this.rdC.boM();
                o f = this.rdC.rdv;
                w.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
                f.rcL.oX();
                f.rcM.KH();
                this.rdC.finish();
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(this.rdB);
        this.rdy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceCreateUI rdC;

            {
                this.rdC = r1;
            }

            public final void onClick(View view) {
                this.rdC.boM();
                this.rdC.finish();
            }
        });
        start();
    }

    private void start() {
        w.d("MicroMsg.VoiceCreateUI", "start create");
        this.rdv.reset();
        NoiseDetectMaskView noiseDetectMaskView = this.rdx;
        if (noiseDetectMaskView.kYg != null) {
            noiseDetectMaskView.kYg.setVisibility(0);
        }
        noiseDetectMaskView.rdn.setText(R.l.faG);
        noiseDetectMaskView.rdo.setVisibility(8);
        w.d("MicroMsg.VoiceCreateUI", "start noise detect");
        this.rdy.setVisibility(4);
        this.rdw.setVisibility(4);
        this.rcZ.setVisibility(4);
        this.rdx.setVisibility(0);
        o oVar = this.rdv;
        w.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
        oVar.reset();
        if (oVar.rcL.bw(m.at("voice_pt_voice_print_noise_detect.rec", true))) {
            w.d("MicroMsg.VoicePrintNoiseDetector", "start record");
        } else {
            oVar.rcL.oX();
            oVar.reset();
            w.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
        }
        oVar.rcM.v(100, 100);
    }

    public final void Hy(String str) {
        w.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
        boD();
        this.rcG = str;
        this.rdb.boQ();
        this.rdb.boR();
        this.rdb.HB(str);
        this.rcY.setEnabled(true);
    }

    public final void Hz(String str) {
        w.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
        this.rcG = str;
        this.rdb.boQ();
        this.rdb.boR();
        this.rdb.HB(str);
        this.rcY.setEnabled(true);
    }

    public final void p(boolean z, int i) {
        w.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (z) {
            switch (i) {
                case 71:
                    w.d("MicroMsg.VoiceCreateUI", "finish create step 1");
                    this.rcY.setEnabled(false);
                    this.rcF = 2;
                    boE();
                    a.a(this.rdb, new a.a(this) {
                        final /* synthetic */ VoiceCreateUI rdC;

                        {
                            this.rdC = r1;
                        }

                        public final void boH() {
                            this.rdC.rdb.reset();
                            this.rdC.rdb.boR();
                            this.rdC.rdb.boS();
                            this.rdC.rcY.setVisibility(4);
                            this.rdC.rdb.uH(R.l.faH);
                            this.rdC.rdz.setVisibility(0);
                            this.rdC.rdb.boQ();
                        }

                        public final void boI() {
                        }
                    });
                    return;
                case q.CTRL_INDEX /*72*/:
                    this.rdA = 0;
                    w.d("MicroMsg.VoiceCreateUI", "finish create step 2");
                    Intent intent = new Intent();
                    intent.putExtra("KIsCreateSuccess", true);
                    setResult(-1, intent);
                    intent = new Intent();
                    intent.setClass(this, VoicePrintFinishUI.class);
                    intent.putExtra("kscene_type", 72);
                    startActivity(intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 71:
                return;
            case q.CTRL_INDEX /*72*/:
                boM();
                this.rdA++;
                if (this.rdA >= 2) {
                    w.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
                    this.rdA = 0;
                    startActivity(new Intent(this, VoiceReCreatePromptUI.class));
                    overridePendingTransition(R.a.aRN, R.a.aRM);
                    finish();
                    return;
                }
                this.rcY.setEnabled(true);
                this.rdb.boQ();
                this.rdb.uI(R.l.faL);
                this.rdb.boT();
                return;
            default:
                return;
        }
    }

    public final void boz() {
        boF();
        boM();
    }

    private void boM() {
        Intent intent = new Intent();
        intent.putExtra("KIsCreateSuccess", false);
        setResult(-1, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        Object obj = this.rdu;
        ap.vd().b(611, obj);
        ap.vd().b(612, obj);
        obj.rcI = null;
        com.tencent.mm.sdk.b.a.urY.c(this.rdB);
    }

    public void onBackPressed() {
        super.onBackPressed();
        boM();
    }
}
