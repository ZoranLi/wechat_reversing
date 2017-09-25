package com.tencent.mm.plugin.photoedit.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.photoedit.a.d;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends a {
    private float kSk;
    private float kSl;
    private float okw = 0.0f;
    private float olq = 0.0f;
    private float olr = 0.0f;
    private boolean ols = false;
    public boolean olt = false;
    public a olu;
    private d olv = new d(this);
    private Runnable olw;
    public boolean olx = true;
    public boolean oly = true;
    private PointF olz = new PointF();

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] olB = new int[com.tencent.mm.plugin.photoedit.b.a.values().length];

        static {
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojq.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojo.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojp.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojr.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                olB[com.tencent.mm.plugin.photoedit.b.a.ojn.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public interface a {
        void aSC();

        void aSD();
    }

    public b(Context context, com.tencent.mm.plugin.photoedit.c.b bVar) {
        super(context, bVar);
    }

    public final void i(Canvas canvas) {
        com.tencent.mm.plugin.photoedit.b.b aSr = aSB().aSr();
        com.tencent.mm.plugin.photoedit.b.b b = aSB().b(com.tencent.mm.plugin.photoedit.b.a.ojp);
        com.tencent.mm.plugin.photoedit.b.b b2 = aSB().b(com.tencent.mm.plugin.photoedit.b.a.ojo);
        com.tencent.mm.plugin.photoedit.b.b b3 = aSB().b(com.tencent.mm.plugin.photoedit.b.a.ojq);
        if (aSr != null) {
            switch (AnonymousClass2.olB[aSr.aRO().ordinal()]) {
                case 1:
                    if (b != null) {
                        b.f(canvas);
                    }
                    if (b2 != null) {
                        b2.f(canvas);
                    }
                    aSr.f(canvas);
                    aSr.g(canvas);
                    return;
                case 2:
                    if (b != null) {
                        b.f(canvas);
                    }
                    aSr.f(canvas);
                    aSr.g(canvas);
                    if (b3 != null) {
                        b3.f(canvas);
                        return;
                    }
                    return;
                case 3:
                    aSr.f(canvas);
                    aSr.g(canvas);
                    if (b2 != null) {
                        b2.f(canvas);
                    }
                    if (b3 != null) {
                        b3.f(canvas);
                        return;
                    }
                    return;
                case 4:
                    if (b != null) {
                        b.f(canvas);
                    }
                    if (b2 != null) {
                        b2.f(canvas);
                    }
                    if (b3 != null) {
                        b3.f(canvas);
                    }
                    aSr.f(canvas);
                    aSr.g(canvas);
                    return;
                case 5:
                    if (b != null) {
                        b.f(canvas);
                    }
                    if (b2 != null) {
                        b2.f(canvas);
                    }
                    if (b3 != null) {
                        b3.f(canvas);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        com.tencent.mm.plugin.photoedit.b.b b = aSB().b(com.tencent.mm.plugin.photoedit.b.a.ojq);
        boolean z2 = false;
        if (!(b == null || aSB().aSt() == com.tencent.mm.plugin.photoedit.b.a.ojr)) {
            z2 = b.onTouch(this, motionEvent);
            if (z2) {
                aSB().c(com.tencent.mm.plugin.photoedit.b.a.ojq);
            } else {
                com.tencent.mm.plugin.photoedit.b.a aSs = aSB().aSs();
                com.tencent.mm.plugin.photoedit.b.a aSt = aSB().aSt();
                if ((aSs == com.tencent.mm.plugin.photoedit.b.a.ojp || aSs == com.tencent.mm.plugin.photoedit.b.a.ojo) && aSt != com.tencent.mm.plugin.photoedit.b.a.ojp && aSt != com.tencent.mm.plugin.photoedit.b.a.ojo && aSt != com.tencent.mm.plugin.photoedit.b.a.ojn) {
                    aSB().c(aSB().aSs());
                } else if (aSt == com.tencent.mm.plugin.photoedit.b.a.ojq) {
                    aSB().c(com.tencent.mm.plugin.photoedit.b.a.ojn);
                }
            }
        }
        if (!z2 || motionEvent.getActionMasked() == 2) {
            if (motionEvent.getAction() == 0) {
                this.kSk = motionEvent.getX();
                this.kSl = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                removeCallbacks(this.olw);
                long j = 0;
                if (!this.olx) {
                    j = 380;
                }
                Runnable anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ b olA;

                    {
                        this.olA = r1;
                    }

                    public final void run() {
                        if (this.olA.olx) {
                            if (this.olA.olu != null) {
                                this.olA.olu.aSC();
                            }
                            this.olA.olx = false;
                            return;
                        }
                        if (this.olA.olu != null) {
                            this.olA.olu.aSD();
                        }
                        this.olA.olx = true;
                    }
                };
                this.olw = anonymousClass1;
                postDelayed(anonymousClass1, j);
            } else if (motionEvent.getAction() == 2) {
                if (Math.abs(motionEvent.getX() - this.kSk) > 5.0f || Math.abs(motionEvent.getY() - this.kSl) > 5.0f) {
                    removeCallbacks(this.olw);
                    if (this.olx) {
                        if (this.olu != null) {
                            this.olu.aSC();
                        }
                        this.olx = false;
                    }
                }
                this.kSk = motionEvent.getX();
                this.kSl = motionEvent.getY();
            }
        }
        b = aSB().aSr();
        if (b == null || z2 || b.aRO() == com.tencent.mm.plugin.photoedit.b.a.ojq) {
            z = z2;
        } else {
            z = b.onTouch(this, motionEvent);
        }
        if (!z) {
            float x = motionEvent.getX(motionEvent.getPointerCount() - 1);
            float y = motionEvent.getY(motionEvent.getPointerCount() - 1);
            float centerX;
            float aSz;
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.olz.set(x, y);
                    this.olq = 0.0f;
                    this.olr = aSx();
                    d dVar = this.olv;
                    w.d("MicroMsg.StickRoundAnim", "[cancel]");
                    if (dVar.oiP != null && (dVar.oiP.isRunning() || dVar.oiP.isStarted())) {
                        dVar.oiP.cancel();
                    }
                    this.olt = false;
                    break;
                case 1:
                    this.olq = 0.0f;
                    if (this.olt) {
                        com.tencent.mm.plugin.photoedit.a.b bVar = this.olv;
                        if (bVar.miY) {
                            w.d("MicroMsg.StickRoundAnim", "[play] start");
                            RectF aSA = bVar.ojg.aSA();
                            Rect rect = bVar.ojg.old;
                            bVar.ojh = aSA.centerX();
                            bVar.oji = aSA.centerY();
                            float centerY = ((float) rect.centerY()) - aSA.centerY();
                            centerX = ((float) rect.centerX()) - aSA.centerX();
                            float aSx = bVar.ojg.aSx();
                            float aSy = bVar.ojg.aSy();
                            aSz = bVar.ojg.aSz();
                            if (aSx > aSy) {
                                bVar.gj = aSy;
                                bVar.ojj = true;
                            } else if (aSx < aSz) {
                                bVar.gj = aSz;
                                bVar.ojj = true;
                            } else {
                                bVar.ojj = false;
                            }
                            Object obj = ((float) rect.height()) < aSA.height() ? 1 : null;
                            Object obj2 = ((float) rect.width()) < aSA.width() ? 1 : null;
                            if (obj != null) {
                                centerY = 0.0f;
                            }
                            if (obj2 != null) {
                                centerX = 0.0f;
                            }
                            aSz = (aSA.top <= ((float) rect.top) || obj == null) ? (aSA.bottom >= ((float) rect.bottom) || obj == null) ? centerY : ((float) rect.bottom) - aSA.bottom : ((float) rect.top) - aSA.top;
                            if (aSA.left > ((float) rect.left) && obj2 != null) {
                                centerX = ((float) rect.left) - aSA.left;
                            } else if (aSA.right < ((float) rect.right) && obj2 != null) {
                                centerX = ((float) rect.right) - aSA.right;
                            }
                            w.d("MicroMsg.StickRoundAnim", "%s %s ", new Object[]{Float.valueOf(centerX), Float.valueOf(aSz)});
                            if (aSx > aSy) {
                                bVar.ojk = true;
                            } else {
                                bVar.ojk = false;
                            }
                            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, aSz});
                            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, centerX});
                            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 80.0f});
                            bVar.oiP = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3});
                            bVar.oiP.addUpdateListener(new com.tencent.mm.plugin.photoedit.a.d.AnonymousClass1(bVar, aSx));
                            bVar.oiP.addListener(new AnimatorListener(bVar) {
                                final /* synthetic */ d ojm;

                                {
                                    this.ojm = r1;
                                }

                                public final void onAnimationStart(Animator animator) {
                                    this.ojm.miY = false;
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.ojm.miY = true;
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    this.ojm.miY = true;
                                }

                                public final void onAnimationRepeat(Animator animator) {
                                }
                            });
                            bVar.oiP.setInterpolator(new LinearInterpolator());
                            bVar.oiP.setDuration(80);
                            bVar.oiP.start();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (!this.ols) {
                        if (motionEvent.getPointerCount() != 2) {
                            if (motionEvent.getPointerCount() == 1 && this.oly) {
                                this.olt = true;
                                this.olv.miY = true;
                                translate(x, y);
                                postInvalidate();
                                break;
                            }
                        }
                        this.olt = true;
                        aSz = motionEvent.getX(0) - motionEvent.getX(1);
                        centerX = motionEvent.getY(0) - motionEvent.getY(1);
                        aSz = (float) Math.sqrt((double) ((aSz * aSz) + (centerX * centerX)));
                        if (this.olq != 0.0f) {
                            centerX = aSz / this.olq;
                            aSz = this.olr * centerX;
                            if (this.oli * 0.5f <= aSz) {
                                if (aSz > this.olh) {
                                    aSz = ((aSz - this.olh) * 0.2f) + this.olh;
                                }
                                this.ojv.postScale(aSz / aSx(), aSz / aSx(), x, y);
                            }
                            this.olv.miY = true;
                            translate(x, y);
                            this.okw = centerX;
                            postInvalidate();
                            break;
                        }
                        this.olq = aSz;
                        break;
                    }
                    this.ols = false;
                    return true;
                case 5:
                    this.olq = 0.0f;
                    this.olr = aSx();
                    break;
                case 6:
                    this.olq = 0.0f;
                    this.ols = true;
                    break;
            }
            this.olz.x = x;
            this.olz.y = y;
        }
        return true;
    }

    private void translate(float f, float f2) {
        RectF aSA = aSA();
        float f3 = f - this.olz.x;
        float f4 = f2 - this.olz.y;
        if (f3 > 0.0f) {
            if (((float) this.old.left) <= aSA.left) {
                f3 *= 0.5f;
            } else if (Math.abs(f3) > Math.abs(aSA.left - ((float) this.old.left))) {
                f3 = ((float) this.old.left) - aSA.left;
            }
        } else if (((float) this.old.right) >= aSA.right) {
            f3 *= 0.5f;
        } else if (Math.abs(f3) > Math.abs(((float) this.old.right) - aSA.right)) {
            f3 = ((float) this.old.right) - aSA.right;
        }
        if (f4 > 0.0f) {
            if (((float) this.old.top) <= aSA.top) {
                f4 *= 0.5f;
            } else if (Math.abs(f4) > Math.abs(aSA.top - ((float) this.old.top))) {
                f4 = ((float) this.old.top) - aSA.top;
            }
        } else if (((float) this.old.bottom) >= aSA.bottom) {
            f4 *= 0.5f;
        } else if (Math.abs(f4) > Math.abs(((float) this.old.bottom) - aSA.bottom)) {
            f4 = ((float) this.old.bottom) - aSA.bottom;
        }
        this.ojv.postTranslate(f3, f4);
    }

    public final float aSz() {
        com.tencent.mm.plugin.photoedit.b.b aSr = aSB().aSr();
        if (aSr == null || aSr.aRO() != com.tencent.mm.plugin.photoedit.b.a.ojr) {
            return super.aSz();
        }
        float width = ((float) this.old.width()) / aSA().width();
        float height = ((float) this.old.height()) / aSA().height();
        if (width <= height) {
            width = height;
        }
        return width * aSx();
    }
}
