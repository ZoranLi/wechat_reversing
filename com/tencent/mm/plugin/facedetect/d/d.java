package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.a.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d implements b {
    private View kIg;
    public boolean kgf;
    private b lwZ;
    public a lxA;
    public String[] lxB;
    public int lxC;
    public int lxD;
    private FaceNumberView lxE;
    private long lxF;
    private long lxG;
    public boolean lxH;
    public boolean lxI;
    public boolean lxJ;
    public boolean lxK;
    private Animation lxL;
    private Animation lxM;
    private AnimationSet lxN;
    private Animation lxO;
    public final Object lxP;
    public boolean lxQ;
    public a lxR;
    public ae lxS;
    private CountDownTimer lxT;
    public Runnable lxU;
    public boolean lxk;
    private String lxy;
    private int lxz;

    public d(String str) {
        this.lxy = null;
        this.lxz = 0;
        this.lxA = null;
        this.lxB = null;
        this.lxC = 0;
        this.lxD = 0;
        this.kIg = null;
        this.lxE = null;
        this.lxk = false;
        this.lxF = -1;
        this.lxG = -1;
        this.lxH = false;
        this.lxI = false;
        this.lxJ = false;
        this.lxK = false;
        this.lxP = new Object();
        this.kgf = false;
        this.lxQ = false;
        this.lxR = null;
        this.lxS = new ae(this, Looper.getMainLooper()) {
            final /* synthetic */ d lxV;

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        w.i("MicroMsg.NumberFaceMotion", "hy: refresh number");
                        this.lxV.asg();
                        return;
                    default:
                        return;
                }
            }
        };
        this.lxT = new CountDownTimer(this) {
            final /* synthetic */ d lxV;

            {
                this.lxV = r5;
            }

            public final void onTick(long j) {
                w.i("MicroMsg.NumberFaceMotion", "hy: on ticked");
                if (this.lxV.kgf) {
                    w.w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
                    cancel();
                } else if (this.lxV.lxI) {
                    w.i("MicroMsg.NumberFaceMotion", "hy: suspend.");
                } else {
                    w.i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", new Object[]{Integer.valueOf(this.lxV.lxD), Integer.valueOf(this.lxV.lxB[this.lxV.lxC].length() - 1), Integer.valueOf(this.lxV.lxC), Integer.valueOf(this.lxV.lxB.length - 1)});
                    if (this.lxV.lxD < this.lxV.lxB[this.lxV.lxC].length() - 1) {
                        d dVar = this.lxV;
                        dVar.lxD++;
                        this.lxV.lxS.sendEmptyMessage(0);
                        return;
                    }
                    w.i("MicroMsg.NumberFaceMotion", "hy: last number in group");
                    af.f(this.lxV.lxU, 1500);
                    this.lxV.kgf = true;
                    cancel();
                    this.lxV.kgf = true;
                }
            }

            public final void onFinish() {
                w.i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
            }
        };
        this.lxU = new Runnable(this) {
            final /* synthetic */ d lxV;

            {
                this.lxV = r1;
            }

            public final void run() {
                synchronized (this.lxV.lxP) {
                    if (this.lxV.lxC >= this.lxV.lxB.length - 1) {
                        w.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
                        this.lxV.lxk = true;
                        f fVar = f.lvS;
                        byte[] c = FileOp.c(this.lxV.lxA.lxb, -1, -1);
                        g gVar = fVar.lvT.lxY;
                        if (gVar.lvW == null) {
                            w.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
                        } else {
                            gVar.lvW.engineSetVoiceData(c);
                        }
                    } else {
                        w.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
                        d dVar = this.lxV;
                        dVar.lxC++;
                        this.lxV.lxD = -1;
                        this.lxV.dW(true);
                        this.lxV.asg();
                    }
                }
            }
        };
        this.lwZ = new b(this) {
            final /* synthetic */ d lxV;

            {
                this.lxV = r1;
            }

            public final void arW() {
                synchronized (this.lxV.lxP) {
                    w.i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
                    if (!this.lxV.lxJ && this.lxV.lxK) {
                        this.lxV.lxJ = true;
                        this.lxV.ash();
                    }
                }
            }

            public final void onError(int i) {
                synchronized (this.lxV.lxP) {
                    w.w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", new Object[]{Integer.valueOf(i)});
                    switch (i) {
                        case 11:
                            this.lxV.lxH = true;
                            break;
                        default:
                            this.lxV.lxQ = true;
                            this.lxV.lxR = new a(ab.getResources().getString(h.eFJ));
                            break;
                    }
                }
            }
        };
        this.lxA = new a();
        this.lxA.lwZ = this.lwZ;
        this.lxL = AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.plugin.facedetect.a.a.aRN);
        this.lxM = AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.plugin.facedetect.a.a.lsg);
        this.lxO = AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.plugin.facedetect.a.a.aQX);
        this.lxO.setDuration(250);
        this.lxO.setFillAfter(true);
        this.lxy = str;
        this.lxz = this.lxy == null ? 0 : this.lxy.length();
        ase();
        if (asd()) {
            this.lxN = (AnimationSet) AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.plugin.facedetect.a.a.lsh);
        } else {
            this.lxN = (AnimationSet) AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.plugin.facedetect.a.a.lsi);
        }
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) ab.getResources().getDimensionPixelSize(c.lsn));
        translateAnimation.setDuration((long) ab.getContext().getResources().getInteger(com.tencent.mm.plugin.facedetect.a.f.ltr));
        this.lxN.addAnimation(translateAnimation);
        w.i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", new Object[]{this.lxy});
    }

    private boolean asd() {
        return this.lxz >= 6;
    }

    private void ase() {
        int i = 0;
        if (bg.mA(this.lxy) || !asd()) {
            this.lxB = new String[1];
            this.lxB[0] = this.lxy;
            return;
        }
        w.i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", new Object[]{Integer.valueOf(2)});
        this.lxB = new String[2];
        int i2 = this.lxz / 2;
        while (i < 2) {
            this.lxB[i] = this.lxy.substring(i2 * i, (i + 1) * i2);
            i++;
        }
    }

    public final boolean arX() {
        return this.lxk;
    }

    private TextView asc() {
        if (this.kIg != null) {
            return (TextView) this.kIg.findViewById(e.ltk);
        }
        return null;
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        w.d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
        this.kIg = LayoutInflater.from(context).inflate(com.tencent.mm.plugin.facedetect.a.g.ltv, viewGroup2);
        this.lxE = (FaceNumberView) this.kIg.findViewById(e.ltf);
        bU(this.lxB.length, -1);
        asc().startAnimation(this.lxL);
        if (this.lxE != null) {
            this.lxE.setVisibility(0);
            this.lxE.startAnimation(this.lxL);
            this.lxC = 0;
            dW(false);
            this.lxD = -1;
            asg();
            this.lxF = bg.NA();
            this.lxG = bg.NA();
            this.kgf = false;
        }
    }

    private static String mn(int i) {
        switch (i) {
            case 1:
                return ab.getContext().getString(h.ltS);
            case 2:
                return ab.getContext().getString(h.ltT);
            case 3:
                return ab.getContext().getString(h.ltV);
            case 4:
                return ab.getContext().getString(h.ltW);
            default:
                w.e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
                return "";
        }
    }

    private void bU(int i, int i2) {
        w.i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        if (asc() == null) {
            return;
        }
        if (i == 1) {
            asc().setText(ab.getContext().getString(h.ltZ));
            return;
        }
        CharSequence string;
        TextView asc = asc();
        if (i2 == -1) {
            String string2;
            Context context = ab.getContext();
            int i3 = h.ltY;
            Object[] objArr = new Object[1];
            switch (i) {
                case 2:
                    string2 = ab.getContext().getString(h.ltU);
                    break;
                default:
                    string2 = mn(i);
                    break;
            }
            objArr[0] = string2;
            string = context.getString(i3, objArr);
        } else {
            string = ab.getContext().getString(h.ltX, new Object[]{mn(this.lxC + 1)});
        }
        asc.setText(string);
        if (i2 > 0) {
            w.i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", new Object[]{Integer.valueOf(i2 + 1)});
            g gVar = f.lvS.lvT.lxY;
            if (gVar.lvW == null) {
                w.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            } else {
                gVar.lvW.engineGroupChange();
            }
        }
    }

    public final void dW(boolean z) {
        if (this.lxE != null) {
            bU(this.lxB.length, this.lxC);
            FaceNumberView faceNumberView = this.lxE;
            int length = this.lxB[this.lxC].length();
            if (length > 12) {
                w.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", new Object[]{Integer.valueOf(length)});
            } else if (length <= 0) {
                w.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", new Object[]{Integer.valueOf(length)});
            } else if (length == faceNumberView.lCL) {
                w.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
                faceNumberView.vM(null);
            } else {
                faceNumberView.lCJ.removeAllViews();
                faceNumberView.lCL = length;
                faceNumberView.lCK = new FaceNumberItemView[faceNumberView.lCL];
                for (int i = 0; i < length; i++) {
                    int i2;
                    int dimensionPixelSize;
                    FaceNumberItemView faceNumberItemView = (FaceNumberItemView) FaceNumberView.inflate(faceNumberView.getContext(), com.tencent.mm.plugin.facedetect.a.g.ltx, null);
                    faceNumberItemView.setImageResource(com.tencent.mm.plugin.facedetect.a.d.lsF);
                    if (i == 0) {
                        i2 = 3;
                        dimensionPixelSize = (faceNumberView.getResources().getDimensionPixelSize(c.lsp) + com.tencent.mm.bg.a.fromDPToPix(faceNumberView.getContext(), 48)) / 2;
                    } else if (i == length - 1) {
                        i2 = 5;
                        dimensionPixelSize = (faceNumberView.getResources().getDimensionPixelSize(c.lsp) + com.tencent.mm.bg.a.fromDPToPix(faceNumberView.getContext(), 48)) / 2;
                    } else {
                        i2 = 17;
                        dimensionPixelSize = faceNumberView.getResources().getDimensionPixelSize(c.lsp);
                    }
                    w.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
                    faceNumberItemView.lCC = i2;
                    faceNumberView.lCK[i] = faceNumberItemView;
                    faceNumberView.lCJ.addView(faceNumberItemView, new LayoutParams(dimensionPixelSize, faceNumberView.getResources().getDimensionPixelSize(c.lso)));
                }
            }
            this.lxK = false;
            if (z) {
                this.lxL.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ d lxV;

                    {
                        this.lxV = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        af.f(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 lxW;

                            {
                                this.lxW = r1;
                            }

                            public final void run() {
                                this.lxW.lxV.asf();
                            }
                        }, 500);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                if (this.kIg != null) {
                    this.kIg.startAnimation(this.lxL);
                    return;
                }
                return;
            }
            af.f(new Runnable(this) {
                final /* synthetic */ d lxV;

                {
                    this.lxV = r1;
                }

                public final void run() {
                    this.lxV.asf();
                }
            }, 500);
        }
    }

    public final void asf() {
        this.lxD = 0;
        this.lxJ = false;
        asg();
        this.lxK = true;
        if (this.lxC == 0) {
            w.i("MicroMsg.NumberFaceMotion", "hy: triggered start record");
            a aVar = this.lxA;
            Runnable anonymousClass6 = new Runnable(this) {
                final /* synthetic */ d lxV;

                {
                    this.lxV = r1;
                }

                public final void run() {
                    if (com.tencent.mm.plugin.facedetect.e.a.asA().lAH) {
                        this.lxV.lxA.a(com.tencent.mm.plugin.facedetect.e.a.asA().asC());
                        com.tencent.mm.plugin.facedetect.e.a asA = com.tencent.mm.plugin.facedetect.e.a.asA();
                        asA.lAz.D(new Runnable(asA) {
                            final /* synthetic */ a lAZ;

                            {
                                this.lAZ = r1;
                            }

                            public final void run() {
                                synchronized (this.lAZ.mLock) {
                                    if (this.lAZ.lAD == a.lBh) {
                                        w.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
                                        this.lAZ.asB();
                                    } else if (this.lAZ.lAD == a.lBj) {
                                        w.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
                                    } else {
                                        w.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
                                        d.aru().a(this.lAZ.lAR);
                                        this.lAZ.ivE.b(this.lAZ.lAE, this.lAZ.lAF, this.lAZ.lAG);
                                        this.lAZ.lAD = a.lBj;
                                    }
                                }
                            }
                        });
                    }
                }
            };
            w.i("MicroMsg.FaceVoiceRecordLogic", "start record");
            com.tencent.mm.sdk.f.e.b(new a(aVar, anonymousClass6), "FaceVoice_record", 10);
            g gVar = f.lvS.lvT.lxY;
            if (gVar.lvW == null) {
                w.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            } else {
                gVar.lvW.engineStartRecord();
            }
        }
        af.f(new Runnable(this) {
            final /* synthetic */ d lxV;

            {
                this.lxV = r1;
            }

            public final void run() {
                synchronized (this.lxV.lxP) {
                    if (this.lxV.lxJ) {
                        w.i("MicroMsg.NumberFaceMotion", "hy: user already start. do nothing");
                    } else {
                        w.w("MicroMsg.NumberFaceMotion", "hy: not triggered symbol. auto start");
                        this.lxV.lxJ = true;
                        this.lxV.ash();
                    }
                }
            }
        }, 2000);
    }

    public final void asg() {
        if (this.lxE == null) {
            return;
        }
        if (this.lxC >= 0) {
            this.lxE.vM(this.lxB[this.lxC].substring(0, this.lxD + 1));
        } else {
            this.lxE.vM(null);
        }
    }

    public final boolean arY() {
        this.lxI = true;
        return this.lxQ;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.lxI = true;
        return this.lxQ;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.lxI = false;
        return this.lxQ;
    }

    public final void arZ() {
        this.kgf = true;
        this.lxQ = false;
        a aVar = this.lxA;
        aVar.lxa = true;
        w.i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
        synchronized (aVar) {
            if (aVar.fzv != null) {
                aVar.fzv.oX();
                aVar.fzv = null;
            }
            if (aVar.ida != null) {
                aVar.ida.ps();
                aVar.ida = null;
            }
            if (aVar.idg != null) {
                try {
                    aVar.idg.release();
                    aVar.idg = null;
                    aVar.idC = true;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
                }
            }
            aVar.icV = 0;
        }
        a aVar2 = this.lxA;
        w.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
        aVar2.lwZ = null;
        this.lxA.arV();
        if (com.tencent.mm.plugin.facedetect.e.a.asA().lAH && com.tencent.mm.plugin.facedetect.e.a.asA().isStarted()) {
            this.lxA.lxc.remove(com.tencent.mm.plugin.facedetect.e.a.asA().asC());
            if (this.lxk) {
                com.tencent.mm.plugin.facedetect.e.a.asA().a(null);
            } else {
                com.tencent.mm.plugin.facedetect.e.a.asA().asD();
            }
        }
        this.lxT.cancel();
        this.lxS.removeCallbacksAndMessages(null);
        if (this.lxE != null) {
            FaceNumberView faceNumberView = this.lxE;
            if (faceNumberView.lCK != null && faceNumberView.lCK.length > 0) {
                for (FaceNumberItemView asO : faceNumberView.lCK) {
                    asO.asO();
                }
            }
        }
        if (this.kIg != null) {
            this.lxk = false;
            this.lxF = -1;
            this.kIg = null;
            this.lxE = null;
        }
    }

    public final b.b asa() {
        return new b.b(90004, "user cancelled in processing");
    }

    public final a asb() {
        return this.lxR;
    }

    public final void ash() {
        long aB = bg.aB(this.lxG);
        w.i("MicroMsg.NumberFaceMotion", "hy: delta after request");
        if (aB < 0) {
            w.w("MicroMsg.NumberFaceMotion", "hy: too fast. regard as fake");
        } else if (aB < 1000) {
            w.w("MicroMsg.NumberFaceMotion", "hy: too fast. wait until normal");
            af.f(new Runnable(this) {
                final /* synthetic */ d lxV;

                {
                    this.lxV = r1;
                }

                public final void run() {
                    this.lxV.asi();
                }
            }, 1000 - aB);
        } else {
            asi();
        }
    }

    public final void asi() {
        this.lxT.start();
    }
}
