package com.tencent.mm.plugin.game.gamewebview.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.game.widget.b;
import com.tencent.mm.plugin.game.widget.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends FrameLayout {
    private GameWebViewBaseActivity mmc;
    private b mmg;
    private b mmh;
    b<b> mmi;
    private Intent mmj;

    static /* synthetic */ void a(c cVar, b bVar) {
        if (bVar != null) {
            bVar.bringToFront();
            cVar.requestLayout();
            cVar.invalidate();
            bVar.Vz();
            Animator ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{(float) bVar.getWidth(), 0.0f});
            ofFloat.setDuration(250);
            cVar.a(ofFloat, null);
        }
    }

    static /* synthetic */ void a(c cVar, b bVar, final b bVar2, boolean z) {
        if (bVar2 != null && bVar != null) {
            if (z) {
                Runnable anonymousClass7;
                Animator ofFloat;
                if (bVar2.jcl) {
                    cVar.a(bVar2);
                } else {
                    anonymousClass7 = new Runnable(cVar) {
                        final /* synthetic */ c mmk;

                        public final void run() {
                            this.mmk.a(bVar2);
                        }
                    };
                    ofFloat = ObjectAnimator.ofFloat(bVar2, "translationX", new float[]{0.0f, (float) bVar2.getWidth()});
                    ofFloat.setDuration(250);
                    cVar.a(ofFloat, anonymousClass7);
                }
                bVar.Vz();
                if (!bVar2.jcl) {
                    anonymousClass7 = new Runnable(cVar) {
                        final /* synthetic */ c mmk;

                        {
                            this.mmk = r1;
                        }

                        public final void run() {
                        }
                    };
                    ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{-(((float) bVar.getWidth()) * 0.25f), 0.0f});
                    ofFloat.setDuration(250);
                    cVar.a(ofFloat, anonymousClass7);
                    return;
                }
                return;
            }
            cVar.a(bVar2);
            bVar.Vz();
        }
    }

    static /* synthetic */ void a(c cVar, final b bVar, final boolean z, final boolean z2) {
        if (bVar != null) {
            if (z) {
                cVar.mmi.remove(bVar);
            }
            Runnable anonymousClass5 = new Runnable(cVar) {
                final /* synthetic */ c mmk;

                public final void run() {
                    if (z2) {
                        bVar.ez(true);
                        bVar.hide();
                    }
                    if (z) {
                        this.mmk.a(bVar);
                    }
                }
            };
            ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f, -(((float) bVar.getWidth()) * 0.25f)}).setDuration(250);
            ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f}).setDuration(0);
            Animator animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{r1, r2});
            cVar.a(animatorSet, anonymousClass5);
        }
    }

    public c(final GameWebViewBaseActivity gameWebViewBaseActivity) {
        super(gameWebViewBaseActivity);
        this.mmc = gameWebViewBaseActivity;
        this.mmi = new b(new a(this) {
            final /* synthetic */ c mmk;

            public final void azF() {
                gameWebViewBaseActivity.nz(this.mmk.mmi.size());
            }

            public final void azG() {
                gameWebViewBaseActivity.nz(this.mmk.mmi.size());
            }
        });
    }

    public final void Po() {
        while (!this.mmi.isEmpty()) {
            ((b) this.mmi.pop()).VB();
        }
        if (this.mmh != null) {
            this.mmh.VB();
        }
    }

    public final void c(Intent intent, boolean z) {
        this.mmj = intent;
        String stringExtra = intent.getStringExtra("rawUrl");
        if (!bg.mA(stringExtra)) {
            b bVar = (b) this.mmi.peek();
            if (bVar != null && bg.mz(bVar.azx().mlI).equals(stringExtra)) {
                bVar.uT.putBoolean("is_from_keep_top", azB());
            } else if (!azB() || this.mmg == null) {
                boolean z2;
                View view;
                if (z || !intent.getBooleanExtra("needAnimation", true)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                w.d("MicroMsg.GameWebPageContainer", "createPage");
                final long currentTimeMillis = System.currentTimeMillis();
                if (this.mmh != null) {
                    view = this.mmh;
                    this.mmh = null;
                } else {
                    view = new e(this.mmc, this);
                }
                view.uT = this.mmj.getExtras();
                view.loadUrl(stringExtra);
                final b bVar2 = (b) this.mmi.peek();
                this.mmi.push(view);
                if (z2) {
                    addView(view, 0);
                    final boolean[] zArr = new boolean[]{false};
                    Runnable anonymousClass2 = new Runnable(this) {
                        final /* synthetic */ c mmk;

                        public final void run() {
                            w.i("MicroMsg.GameWebPageContainer", "loadUrl costTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (!zArr[0]) {
                                zArr[0] = true;
                                view.w(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass2 mmo;

                                    {
                                        this.mmo = r1;
                                    }

                                    public final void run() {
                                        boolean z = false;
                                        synchronized (this.mmo.mmk) {
                                            if (bVar2 != null) {
                                                c cVar = this.mmo.mmk;
                                                b bVar = bVar2;
                                                boolean booleanExtra = this.mmo.mmk.mmj.getBooleanExtra("finish_recent_page", false);
                                                if (!this.mmo.mmk.mmj.getBooleanExtra("transparent_page", false)) {
                                                    z = true;
                                                }
                                                c.a(cVar, bVar, booleanExtra, z);
                                            }
                                            c.a(this.mmo.mmk, view);
                                        }
                                    }
                                });
                            }
                        }
                    };
                    final long j = currentTimeMillis;
                    final boolean[] zArr2 = zArr;
                    final Runnable runnable = anonymousClass2;
                    view.azx().mmZ = new b.a(this) {
                        final /* synthetic */ c mmk;

                        public final void azD() {
                            w.d("MicroMsg.GameWebPageContainer", "onLoadFinish, costTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - j)});
                            if (!zArr2[0]) {
                                w.d("MicroMsg.GameWebPageContainer", "removeCallback, %d", new Object[]{Integer.valueOf(runnable.hashCode())});
                                this.mmk.removeCallbacks(runnable);
                                this.mmk.post(runnable);
                            }
                        }
                    };
                    postDelayed(anonymousClass2, 200);
                    return;
                }
                addView(view);
                view.Vz();
            } else {
                while (!this.mmi.isEmpty()) {
                    a((b) this.mmi.pop());
                }
                if (this.mmg.getParent() == null) {
                    addView(this.mmg);
                }
                this.mmg.Vz();
                this.mmi.push(this.mmg);
            }
        }
    }

    public final void eA(final boolean z) {
        if (this.mmi.size() <= 1) {
            this.mmc.finish();
            return;
        }
        Runnable anonymousClass4 = new Runnable(this) {
            final /* synthetic */ c mmk;

            public final void run() {
                b bVar = (b) this.mmk.mmi.peek();
                c.a(this.mmk, bVar, (b) this.mmk.mmi.pop(), z);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass4.run();
        } else {
            post(anonymousClass4);
        }
    }

    final void a(b bVar) {
        if (bVar != null) {
            bVar.ez(false);
            bVar.setVisibility(8);
            removeView(bVar);
            if (bVar != this.mmg) {
                bVar.VB();
                return;
            }
            Animator ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f});
            ofFloat.setDuration(0);
            a(ofFloat, null);
        }
    }

    private void a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ c mmk;

            public final void onAnimationEnd(Animator animator) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        animator.start();
    }

    private boolean azB() {
        return this.mmj.getBooleanExtra("is_from_keep_top", false);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b bVar = (b) this.mmi.peek();
        if (bVar != null) {
            if (bVar.azx().onKeyDown(i, keyEvent)) {
                return true;
            }
            if (i == 4 && bVar.azx().azQ()) {
                return true;
            }
        }
        return false;
    }

    public final void b(b bVar) {
        w.d("MicroMsg.GameWebPageContainer", "keepPageTop");
        if (this.mmg != bVar) {
            if (this.mmg != null && !this.mmi.contains(this.mmg)) {
                this.mmg.VB();
            } else if (this.mmg != null) {
                this.mmg.azA();
            }
            this.mmg = bVar;
        }
    }

    public final void azE() {
        w.d("MicroMsg.GameWebPageContainer", "cancelPageTop");
        if (this.mmg != null && !this.mmi.contains(this.mmg)) {
            this.mmg.VB();
        } else if (this.mmg != null) {
            this.mmg.azA();
        }
        this.mmg = null;
    }
}
