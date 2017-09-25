package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.aw.e;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public class VoiceSearchLayout extends LinearLayout {
    private static final int[] jYy = new int[]{R.g.blt, R.g.blu, R.g.blv, R.g.blw, R.g.blh, R.g.bli, R.g.blj, R.g.blk, R.g.bll, R.g.blm, R.g.bln, R.g.blo, R.g.blp, R.g.blq};
    private static final int[] sLG = new int[]{R.g.blt, R.g.blt, R.g.blt, R.g.blu, R.g.blv, R.g.blu, R.g.blt, R.g.blw, R.g.blt, R.g.blt};
    private static final int[] sLH = new int[]{R.g.blr, R.g.bls, R.g.bls, R.g.bls, R.g.blr};
    private int fFr = 0;
    public boolean fOV = false;
    public final aj jYU = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ VoiceSearchLayout sLL;

        {
            this.sLL = r1;
        }

        public final boolean oQ() {
            if (this.sLL.sLE != null) {
                if (this.sLL.sLK < VoiceSearchLayout.sLH.length) {
                    VoiceSearchLayout.a(this.sLL, VoiceSearchLayout.sLH[this.sLL.sLK = this.sLL.sLK + 1]);
                } else {
                    e a = this.sLL.sLE;
                    w.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + a.icU);
                    int i = a.icU;
                    a.icU = 0;
                    if (i > e.fBC) {
                        e.fBC = i;
                    }
                    w.d("getMaxAmplitude", " map: " + i + " max:" + e.fBC + " per:" + ((i * 100) / e.fBC));
                    int i2 = (i * 100) / e.fBC;
                    w.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i2);
                    i = this.sLL.fFr;
                    if (this.sLL.fFr == this.sLL.sLI) {
                        if (i2 <= 10) {
                            VoiceSearchLayout.f(this.sLL);
                            if (this.sLL.sLJ >= VoiceSearchLayout.sLG.length) {
                                this.sLL.sLJ = 0;
                            }
                            VoiceSearchLayout.a(this.sLL, VoiceSearchLayout.sLG[this.sLL.sLJ]);
                        } else {
                            i2 /= 5;
                            if (i2 >= VoiceSearchLayout.jYy.length) {
                                i2 = VoiceSearchLayout.jYy.length - 1;
                            }
                            w.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i2);
                            this.sLL.sLI = i2;
                        }
                    } else if (this.sLL.fFr > this.sLL.sLI) {
                        VoiceSearchLayout.i(this.sLL);
                    } else {
                        VoiceSearchLayout.j(this.sLL);
                    }
                    VoiceSearchLayout.a(this.sLL, VoiceSearchLayout.jYy[i]);
                }
            }
            return true;
        }
    }, true);
    public View lmQ = null;
    public int sLA = 0;
    public b sLB;
    public View sLC;
    public AnimationDrawable sLD;
    public e sLE;
    private boolean sLF = false;
    private int sLI = 0;
    private int sLJ = 0;
    public int sLK = 0;
    public a sLx = null;
    public Button sLy;
    public boolean sLz = false;

    public interface a {
        void a(boolean z, String[] strArr, long j);

        void bER();

        void bES();
    }

    public interface b {
        void jt(boolean z);
    }

    static /* synthetic */ void a(VoiceSearchLayout voiceSearchLayout, int i) {
        if (voiceSearchLayout.sLy != null) {
            voiceSearchLayout.sLy.setBackgroundResource(i);
        }
    }

    static /* synthetic */ int f(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.sLJ + 1;
        voiceSearchLayout.sLJ = i;
        return i;
    }

    static /* synthetic */ int i(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.fFr - 1;
        voiceSearchLayout.fFr = i;
        return i;
    }

    static /* synthetic */ int j(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.fFr + 1;
        voiceSearchLayout.fFr = i;
        return i;
    }

    static /* synthetic */ void k(VoiceSearchLayout voiceSearchLayout) {
        voiceSearchLayout.sLz = true;
        voiceSearchLayout.js(true);
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceSearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.lmQ = inflate(context, R.i.cNA, this);
        this.sLy = (Button) this.lmQ.findViewById(R.h.cNC);
        this.sLC = this.lmQ.findViewById(R.h.cNz);
        js(false);
        reset();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.sLz) {
            bEN();
        }
        return true;
    }

    public final void bEN() {
        w.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.fOV);
        if (this.fOV) {
            bEB();
            this.fOV = false;
        }
    }

    public final void bEB() {
        w.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.fOV);
        if (this.fOV) {
            this.fOV = false;
            if (this.sLx != null) {
                this.sLx.bES();
            }
        }
        reset();
        if (getVisibility() == 0) {
            setVisibility(8);
            if (this.sLB != null) {
                this.sLB.jt(false);
            }
        }
        qQ();
        if (this.sLE != null) {
            this.sLE.cancel();
        }
        if (this.jYU != null) {
            this.jYU.KH();
        }
    }

    public final void reset() {
        js(false);
        this.fOV = false;
        this.sLz = false;
        this.sLy.setBackgroundResource(R.g.blg);
        this.sLC.setBackgroundDrawable(getResources().getDrawable(R.g.blf));
    }

    private void js(boolean z) {
        if (z) {
            this.sLy.setBackgroundResource(R.g.bld);
            this.sLD = (AnimationDrawable) this.sLy.getBackground();
            if (this.sLD != null) {
                this.sLD.start();
                return;
            }
            return;
        }
        this.sLy.setBackgroundResource(R.g.blg);
    }

    public void setVisibility(int i) {
        if (super.getVisibility() != i && !this.sLF) {
            Animation loadAnimation;
            if (i == 8) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.aQY);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.aQX);
            }
            startAnimation(loadAnimation);
            super.setVisibility(i);
            if (this.sLB != null) {
                this.sLB.jt(i == 0);
            }
        }
    }

    public final void xo(int i) {
        LayoutParams layoutParams = (LayoutParams) this.sLC.getLayoutParams();
        layoutParams.topMargin = i;
        this.sLC.setLayoutParams(layoutParams);
    }

    public final void a(boolean z, i iVar) {
        if (z) {
            w.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
            ap.yZ().qP();
        } else {
            qQ();
        }
        MediaPlayer iVar2 = new i();
        if (z) {
            try {
                iVar2.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.k.dyB));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                return;
            }
        }
        iVar2.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.k.dyd));
        iVar2.setAudioStreamType(5);
        iVar2.setOnCompletionListener(new OnCompletionListener(this, null) {
            final /* synthetic */ VoiceSearchLayout sLL;

            public final void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        iVar2.setOnErrorListener(new OnErrorListener(this, null) {
            final /* synthetic */ VoiceSearchLayout sLL;

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        });
        iVar2.prepare();
        iVar2.setLooping(false);
        iVar2.start();
    }

    private static void qQ() {
        w.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
        ap.yZ().qQ();
    }
}
