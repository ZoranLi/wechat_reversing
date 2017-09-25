package com.tencent.mm.plugin.favorite.ui.post;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.c.b.j;
import com.tencent.mm.plugin.favorite.b.m;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.r;
import java.io.File;

public class FavPostVoiceUI extends MMBaseActivity {
    private static final int[] jYx = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] jYy = new int[]{R.g.bbG, R.g.bbH, R.g.bbI, R.g.bbJ, R.g.bbK, R.g.bbL, R.g.bbM};
    private long duration;
    private long jYB = -1;
    private Toast jYC;
    private ImageView jYG;
    private boolean jYO;
    private boolean jYP;
    private final aj jYU = new aj(new a(this) {
        final /* synthetic */ FavPostVoiceUI lNO;

        {
            this.lNO = r1;
        }

        public final boolean oQ() {
            int maxAmplitude;
            int i = 0;
            j a = this.lNO.lNM;
            if (a.status == 1) {
                maxAmplitude = a.fBA.getMaxAmplitude();
                if (maxAmplitude > j.fBC) {
                    j.fBC = maxAmplitude;
                }
                maxAmplitude = (maxAmplitude * 100) / j.fBC;
            } else {
                maxAmplitude = 0;
            }
            while (i < FavPostVoiceUI.jYy.length) {
                if (maxAmplitude >= FavPostVoiceUI.jYx[i] && maxAmplitude < FavPostVoiceUI.jYx[i + 1]) {
                    this.lNO.jYG.setBackgroundResource(FavPostVoiceUI.jYy[i]);
                    break;
                }
                i++;
            }
            return true;
        }
    }, true);
    private final aj jYV = new aj(new a(this) {
        final /* synthetic */ FavPostVoiceUI lNO;

        {
            this.lNO = r1;
        }

        public final boolean oQ() {
            if (this.lNO.jYB == -1) {
                this.lNO.jYB = bg.NA();
            }
            long aB = bg.aB(this.lNO.jYB);
            if (aB >= 3590000 && aB <= 3600000) {
                if (this.lNO.jYC == null) {
                    this.lNO.jYC = Toast.makeText(this.lNO, this.lNO.getString(R.l.dsh, new Object[]{Integer.valueOf((int) ((3600000 - aB) / 1000))}), 0);
                } else {
                    this.lNO.jYC.setText(this.lNO.getString(R.l.dsh, new Object[]{Integer.valueOf((int) ((3600000 - aB) / 1000))}));
                }
                this.lNO.jYC.show();
            }
            if (aB < 3600000) {
                return true;
            }
            w.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
            this.lNO.jYP = true;
            this.lNO.auK();
            return false;
        }
    }, true);
    private final ae jYX = new ae(this) {
        final /* synthetic */ FavPostVoiceUI lNO;

        {
            this.lNO = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.lNO.auL();
            this.lNO.lNE.setBackgroundResource(R.g.bja);
            this.lNO.lNE.setEnabled(true);
        }
    };
    private int jYq;
    private Button lNE;
    private long lNF;
    private View lNG;
    private View lNH;
    private View lNI;
    private View lNJ;
    private TextView lNK;
    private View lNL;
    private j lNM;
    boolean lNN = false;
    private String path;

    static /* synthetic */ void j(FavPostVoiceUI favPostVoiceUI) {
        favPostVoiceUI.lNE.setKeepScreenOn(true);
        favPostVoiceUI.lNE.setBackgroundResource(R.g.bja);
        favPostVoiceUI.lNE.setText(R.l.ejj);
        favPostVoiceUI.jYP = false;
        favPostVoiceUI.lNM = favPostVoiceUI.auJ();
        if (favPostVoiceUI.lNM.by(favPostVoiceUI.path)) {
            favPostVoiceUI.lNF = bg.NA();
            favPostVoiceUI.jYV.v(200, 200);
            favPostVoiceUI.jYG.setVisibility(0);
            favPostVoiceUI.jYU.v(100, 100);
            favPostVoiceUI.lNK.setText(R.l.eiK);
            return;
        }
        favPostVoiceUI.lNF = 0;
    }

    static /* synthetic */ void n(FavPostVoiceUI favPostVoiceUI) {
        favPostVoiceUI.lNE.setKeepScreenOn(false);
        favPostVoiceUI.lNM.oX();
        favPostVoiceUI.jYU.KH();
        favPostVoiceUI.jYV.KH();
        favPostVoiceUI.auM();
        favPostVoiceUI.auL();
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(r.eC(this).inflate(R.i.dcy, null));
        this.jYG = (ImageView) findViewById(R.h.cNm);
        this.lNI = findViewById(R.h.cNn);
        this.lNJ = findViewById(R.h.cNp);
        this.lNG = findViewById(R.h.cNt);
        this.lNH = findViewById(R.h.cNu);
        this.lNK = (TextView) findViewById(R.h.cNv);
        this.lNL = findViewById(R.h.cNo);
        findViewById(R.h.cNl).setVisibility(8);
        this.lNL.setVisibility(8);
        findViewById(R.h.cNl).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavPostVoiceUI lNO;

            {
                this.lNO = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lNO.auN();
                return false;
            }
        });
        findViewById(R.h.bON).setVisibility(8);
        this.lNM = auJ();
        this.lNE = (Button) findViewById(R.h.bOM);
        this.lNE.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavPostVoiceUI lNO;

            {
                this.lNO = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == this.lNO.lNE) {
                    int rawY = (int) motionEvent.getRawY();
                    int[] iArr = new int[2];
                    this.lNO.jYq = this.lNO.getResources().getDisplayMetrics().heightPixels;
                    this.lNO.lNE.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (!this.lNO.jYO) {
                                this.lNO.jYO = true;
                                FavPostVoiceUI.j(this.lNO);
                                break;
                            }
                            break;
                        case 1:
                            if (this.lNO.jYO) {
                                if (this.lNO.lNJ.getVisibility() != 0) {
                                    if (!this.lNO.jYP) {
                                        this.lNO.auK();
                                        break;
                                    }
                                }
                                w.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                                FavPostVoiceUI.n(this.lNO);
                                break;
                            }
                            break;
                        case 2:
                            if (rawY <= this.lNO.jYq - b.a(this.lNO, 60.0f) && rawY < i) {
                                this.lNO.lNI.setVisibility(8);
                                this.lNO.lNJ.setVisibility(0);
                                break;
                            }
                            this.lNO.lNI.setVisibility(0);
                            this.lNO.lNJ.setVisibility(8);
                            break;
                        case 3:
                            w.w("MicroMsg.FavPostVoiceUI", "action cancel");
                            FavPostVoiceUI.n(this.lNO);
                            break;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        auL();
        String atz = x.atz();
        File file = new File(atz);
        if (!file.exists()) {
            file.mkdirs();
        }
        do {
            str = atz + "/" + System.currentTimeMillis();
        } while (new File(str).exists());
        this.path = str;
        this.lNK.post(new Runnable(this) {
            final /* synthetic */ FavPostVoiceUI lNO;

            {
                this.lNO = r1;
            }

            public final void run() {
                this.lNO.findViewById(R.h.cNl).setVisibility(0);
                this.lNO.lNL.setVisibility(0);
                this.lNO.findViewById(R.h.bON).setVisibility(0);
                Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300);
                Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(300);
                this.lNO.lNL.startAnimation(alphaAnimation);
                this.lNO.findViewById(R.h.cNl).startAnimation(alphaAnimation);
                this.lNO.findViewById(R.h.bON).startAnimation(translateAnimation);
            }
        });
    }

    private j auJ() {
        com.tencent.mm.compatible.b.b.a aVar = com.tencent.mm.compatible.b.b.a.gNj;
        j jVar = new j();
        jVar.fBB = new j.a(this) {
            final /* synthetic */ FavPostVoiceUI lNO;

            {
                this.lNO = r1;
            }

            public final void onError() {
                this.lNO.jYU.KH();
                this.lNO.jYV.KH();
            }
        };
        return jVar;
    }

    private void auK() {
        long j = 0;
        if (this.jYO) {
            boolean z;
            this.lNE.setKeepScreenOn(true);
            this.lNE.setBackgroundResource(R.g.biZ);
            this.lNE.setText(R.l.eiV);
            this.lNM.oX();
            if (this.lNF != 0) {
                j = bg.aB(this.lNF);
            }
            this.duration = j;
            if (this.duration < 800) {
                z = true;
            } else {
                z = false;
            }
            this.jYU.KH();
            this.jYV.KH();
            if (z) {
                auM();
                this.lNE.setEnabled(false);
                this.lNE.setBackgroundResource(R.g.biY);
                this.lNH.setVisibility(0);
                this.lNG.setVisibility(8);
                this.jYX.sendEmptyMessageDelayed(0, 500);
            } else {
                String str = this.path;
                int i = (int) this.duration;
                if (bg.mA(str)) {
                    w.e("MicroMsg.FavPostLogic", "postVoice path null");
                } else {
                    com.tencent.mm.plugin.favorite.b.j jVar = new com.tencent.mm.plugin.favorite.b.j();
                    jVar.field_type = 3;
                    jVar.field_sourceType = 6;
                    m.f(jVar);
                    rm rmVar = new rm();
                    rmVar.NZ(str);
                    rmVar.ya(i);
                    rmVar.jK(true);
                    rmVar.yb(jVar.field_type);
                    rmVar.NV("amr");
                    jVar.field_favProto.tzn.add(rmVar);
                    com.tencent.mm.plugin.favorite.c.a.w(jVar);
                    g.oUh.i(10648, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                }
                setResult(-1);
                finish();
                overridePendingTransition(0, 0);
            }
            this.jYO = false;
        }
    }

    public final void auL() {
        this.lNG.setVisibility(0);
        this.lNH.setVisibility(8);
        this.lNJ.setVisibility(8);
        this.lNI.setVisibility(0);
        this.lNK.setText(R.l.eGR);
        this.lNE.setBackgroundResource(R.g.bja);
        this.lNE.setText(R.l.eiV);
        this.jYG.setVisibility(4);
        this.jYO = false;
    }

    private void auM() {
        File file = new File(this.path);
        if (file.exists()) {
            file.delete();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        auK();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        auN();
        return true;
    }

    private void auN() {
        if (!this.lNN) {
            this.lNN = true;
            Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(300);
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            translateAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ FavPostVoiceUI lNO;

                {
                    this.lNO = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.lNO.lNI.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 lNP;

                        {
                            this.lNP = r1;
                        }

                        public final void run() {
                            this.lNP.lNO.setResult(0);
                            this.lNP.lNO.finish();
                            this.lNP.lNO.overridePendingTransition(0, 0);
                        }
                    });
                }
            });
            findViewById(R.h.cNl).setVisibility(8);
            findViewById(R.h.bON).setVisibility(8);
            this.lNL.setVisibility(8);
            this.lNL.startAnimation(alphaAnimation);
            findViewById(R.h.cNl).startAnimation(alphaAnimation);
            findViewById(R.h.bON).startAnimation(translateAnimation);
        }
    }
}
