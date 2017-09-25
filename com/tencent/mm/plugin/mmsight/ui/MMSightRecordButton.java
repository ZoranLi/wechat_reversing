package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;

public class MMSightRecordButton extends FrameLayout {
    private static final float nKl = (((float) ab.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.nNC)) / ((float) ab.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.nNB)));
    private static final int wE = ViewConfiguration.getTapTimeout();
    private boolean fFU = true;
    private ae hgN = new ae(Looper.getMainLooper());
    private float jWC = -1.0f;
    b nKA;
    c nKB;
    a nKC;
    private Drawable nKD;
    private Drawable nKE;
    private boolean nKF = false;
    private boolean nKG = false;
    private Runnable nKH = new Runnable(this) {
        final /* synthetic */ MMSightRecordButton nKK;

        {
            this.nKK = r1;
        }

        public final void run() {
            w.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[]{Boolean.valueOf(this.nKK.nKr), Boolean.valueOf(this.nKK.nKs)});
            if (!this.nKK.nKr) {
                this.nKK.nKs = true;
                if (this.nKK.nKA != null) {
                    this.nKK.nKA.aMb();
                }
            }
        }
    };
    private Runnable nKI = new Runnable(this) {
        final /* synthetic */ MMSightRecordButton nKK;

        {
            this.nKK = r1;
        }

        public final void run() {
            w.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[]{Boolean.valueOf(this.nKK.nKy)});
            if (this.nKK.nKy) {
                MMSightRecordButton.f(this.nKK);
            }
        }
    };
    private long nKm = -1;
    private View nKn;
    private View nKo;
    View nKp;
    MMSightCircularProgressBar nKq;
    private boolean nKr = false;
    private boolean nKs = false;
    private boolean nKt = false;
    private ViewPropertyAnimator nKu;
    private ViewPropertyAnimator nKv;
    private ViewPropertyAnimator nKw;
    private ViewPropertyAnimator nKx;
    private boolean nKy = false;
    d nKz;

    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ MMSightRecordButton nKK;
        final /* synthetic */ AnimatorListenerAdapter nKM = null;

        AnonymousClass2(MMSightRecordButton mMSightRecordButton, AnimatorListenerAdapter animatorListenerAdapter) {
            this.nKK = mMSightRecordButton;
        }

        public final void onAnimationStart(Animator animator) {
            this.nKK.nKt = true;
            if (this.nKM != null) {
                this.nKM.onAnimationStart(animator);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            this.nKK.nKt = false;
            if (this.nKM != null) {
                this.nKM.onAnimationEnd(animator);
            }
        }
    }

    class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ MMSightRecordButton nKK;
        final /* synthetic */ AnimatorListenerAdapter nKM = null;

        AnonymousClass3(MMSightRecordButton mMSightRecordButton, AnimatorListenerAdapter animatorListenerAdapter) {
            this.nKK = mMSightRecordButton;
        }

        public final void onAnimationStart(Animator animator) {
            this.nKK.nKt = true;
            if (this.nKM != null) {
                this.nKM.onAnimationStart(animator);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            this.nKK.nKt = false;
            if (this.nKM != null) {
                this.nKM.onAnimationEnd(animator);
            }
        }
    }

    public interface a {
        void aLZ();
    }

    public interface b {
        void aMa();

        void aMb();

        void aMc();
    }

    public interface c {
        void pL(int i);

        void pM(int i);
    }

    public interface d {
        void aMd();
    }

    class AnonymousClass1 implements com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a {
        final /* synthetic */ com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a nKJ;
        final /* synthetic */ MMSightRecordButton nKK;

        AnonymousClass1(MMSightRecordButton mMSightRecordButton, com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a aVar) {
            this.nKK = mMSightRecordButton;
            this.nKJ = aVar;
        }

        public final void aLX() {
            w.j("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
            this.nKK.aLY();
            this.nKK.a(new AnimatorListenerAdapter(this) {
                final /* synthetic */ AnonymousClass1 nKL;

                {
                    this.nKL = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    w.j("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
                    if (this.nKL.nKJ != null) {
                        this.nKL.nKJ.aLX();
                    }
                }
            });
        }
    }

    static /* synthetic */ void f(MMSightRecordButton mMSightRecordButton) {
        mMSightRecordButton.nKt = true;
        if (mMSightRecordButton.nKu != null) {
            mMSightRecordButton.nKu.cancel();
            mMSightRecordButton.nKu = null;
        }
        mMSightRecordButton.nKu = mMSightRecordButton.nKn.animate().scaleX(0.67f).scaleY(0.67f);
        mMSightRecordButton.nKu.setListener(new AnonymousClass2(mMSightRecordButton, null)).setDuration(150).start();
        if (mMSightRecordButton.nKv != null) {
            mMSightRecordButton.nKv.cancel();
            mMSightRecordButton.nKv = null;
        }
        mMSightRecordButton.nKv = mMSightRecordButton.nKo.animate().scaleX(nKl).scaleY(nKl);
        mMSightRecordButton.nKv.setListener(new AnonymousClass3(mMSightRecordButton, null)).setDuration(150).start();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        w.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[]{Integer.valueOf(500), Integer.valueOf(wE)});
        this.nKD = getContext().getResources().getDrawable(com.tencent.mm.plugin.u.a.c.nNF);
        this.nKE = getContext().getResources().getDrawable(com.tencent.mm.plugin.u.a.c.nNG);
        r.eC(getContext()).inflate(e.nOc, this, true);
        this.nKn = findViewById(com.tencent.mm.plugin.u.a.d.nNP);
        this.nKo = findViewById(com.tencent.mm.plugin.u.a.d.nNR);
        this.nKp = findViewById(com.tencent.mm.plugin.u.a.d.ctp);
        this.nKq = (MMSightCircularProgressBar) findViewById(com.tencent.mm.plugin.u.a.d.nNI);
        this.nKn.setBackgroundDrawable(this.nKD);
        this.nKo.setBackgroundDrawable(this.nKE);
        this.fFU = true;
    }

    public final void fK(boolean z) {
        w.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[]{Boolean.valueOf(z)});
        this.fFU = z;
    }

    public final void aLY() {
        MMSightCircularProgressBar mMSightCircularProgressBar = this.nKq;
        mMSightCircularProgressBar.nKh = null;
        mMSightCircularProgressBar.nKd = 0;
        mMSightCircularProgressBar.nKe = 0;
        mMSightCircularProgressBar.duration = 0;
        mMSightCircularProgressBar.fOV = false;
        if (mMSightCircularProgressBar.nKg != null) {
            a aVar = mMSightCircularProgressBar.nKg;
            aVar.fOV = false;
            aVar.nKR = 0;
            mMSightCircularProgressBar.nKg = null;
        }
        this.nKq.setVisibility(8);
    }

    private void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        this.nKt = true;
        if (this.nKw != null) {
            this.nKw.cancel();
            this.nKw = null;
        }
        this.nKw = this.nKn.animate().scaleX(1.0f).scaleY(1.0f);
        this.nKw.setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ MMSightRecordButton nKK;

            public final void onAnimationStart(Animator animator) {
                this.nKK.nKt = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                this.nKK.nKt = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
        if (this.nKx != null) {
            this.nKx.cancel();
            this.nKx = null;
        }
        this.nKx = this.nKo.animate().scaleX(1.0f).scaleY(1.0f);
        this.nKx.setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ MMSightRecordButton nKK;

            public final void onAnimationStart(Animator animator) {
                this.nKK.nKt = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                this.nKK.nKt = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
    }

    public void setVisibility(final int i) {
        w.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[]{Boolean.valueOf(this.nKt)});
        if (this.nKt) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ MMSightRecordButton nKK;

                public final void run() {
                    super.setVisibility(i);
                }
            }, 150);
        } else {
            super.setVisibility(i);
        }
    }

    public final void reset() {
        setClipChildren(false);
        this.fFU = true;
        this.nKn.setScaleX(1.0f);
        this.nKn.setScaleY(1.0f);
        this.nKo.setScaleX(1.0f);
        this.nKo.setScaleY(1.0f);
        this.nKp.setVisibility(8);
        aLY();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fFU) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nKy = true;
                    this.nKm = System.currentTimeMillis();
                    this.nKr = false;
                    this.nKs = false;
                    this.jWC = motionEvent.getRawY();
                    if (this.nKA != null) {
                        this.nKA.aMa();
                    }
                    this.hgN.postDelayed(this.nKH, 550);
                    this.hgN.postDelayed(this.nKI, 250);
                    this.nKG = true;
                    this.nKF = true;
                    break;
                case 1:
                case 3:
                    this.nKy = false;
                    this.hgN.removeCallbacks(this.nKI, Integer.valueOf(wE));
                    this.hgN.removeCallbacks(this.nKH);
                    if (!(this.nKu == null || this.nKv == null)) {
                        this.nKu.cancel();
                        this.nKv.cancel();
                    }
                    final long currentTimeMillis = System.currentTimeMillis() - this.nKm;
                    w.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[]{Boolean.valueOf(this.nKs), Boolean.valueOf(this.nKr), Long.valueOf(this.nKm), Long.valueOf(currentTimeMillis)});
                    aLY();
                    a(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ MMSightRecordButton nKK;

                        public final void onAnimationEnd(Animator animator) {
                            if (this.nKK.nKm > 0 && currentTimeMillis <= 500) {
                                w.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[]{Boolean.valueOf(this.nKK.nKr), Boolean.valueOf(this.nKK.nKs)});
                                this.nKK.nKr = true;
                                if (!this.nKK.nKs && this.nKK.nKz != null) {
                                    this.nKK.nKz.aMd();
                                }
                            } else if (this.nKK.nKs) {
                                w.i("MicroMsg.MMSightRecordButton", "on Long Press finish");
                                if (this.nKK.nKA != null) {
                                    this.nKK.nKA.aMc();
                                }
                            } else {
                                w.i("MicroMsg.MMSightRecordButton", "error action up");
                                if (this.nKK.nKC != null) {
                                    this.nKK.nKC.aLZ();
                                }
                            }
                        }
                    });
                    break;
                case 2:
                    w.d("MicroMsg.MMSightRecordButton", "move, x: %s, y: %s, top: %s", new Object[]{Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()), Integer.valueOf(getTop())});
                    float rawY = motionEvent.getRawY();
                    if (rawY < ((float) getTop()) && this.nKs) {
                        if (this.jWC > 0.0f) {
                            float abs = Math.abs(rawY - this.jWC);
                            int min;
                            c cVar;
                            if (rawY >= this.jWC || abs < 10.0f) {
                                if (rawY > this.jWC && abs >= 10.0f) {
                                    w.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[]{Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.nKG)});
                                    min = Math.min(min, 3);
                                    if (this.nKB != null) {
                                        cVar = this.nKB;
                                        if (this.nKG) {
                                            min = 1;
                                        }
                                        cVar.pM(min);
                                    }
                                    this.nKG = false;
                                    this.jWC = rawY;
                                    break;
                                }
                            }
                            w.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[]{Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.nKF)});
                            min = Math.min(min, 3);
                            if (this.nKB != null) {
                                cVar = this.nKB;
                                if (this.nKF) {
                                    min = 1;
                                }
                                cVar.pL(min);
                            }
                            this.jWC = rawY;
                            this.nKF = false;
                            break;
                        }
                        this.jWC = motionEvent.getRawY();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        w.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
        return true;
    }
}
