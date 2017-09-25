package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.chatting.ep;

public class SplashWelcomeView extends FrameLayout implements ep {
    private Bitmap bitmap;
    private boolean hasDrawed;
    private ImageView uWA;
    public a uWB;
    private int uWC;
    public ep uWy;
    private boolean uWz;

    public interface a {
        void on();
    }

    public SplashWelcomeView(Context context) {
        super(context);
        eD(context);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        eD(context);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        eD(context);
    }

    private void eD(Context context) {
        this.uWA = new SplashImageView(context);
        this.uWA.setImageResource(R.g.bmd);
        this.uWA.setScaleType(ScaleType.CENTER_CROP);
        ((SplashImageView) this.uWA).uWy = this;
        addView(this.uWA, new LayoutParams(-1, -1));
        try {
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("system_config_prefs", 0);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            w.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", Long.valueOf(sharedPreferences.getLong("new_launch_image_begin_time", 0)), Long.valueOf(sharedPreferences.getLong("new_launch_image_end_time", 0)), Long.valueOf(currentTimeMillis));
            final String str = com.tencent.mm.loader.stub.a.hgq + "splashWelcomeImg";
            if (currentTimeMillis <= sharedPreferences.getLong("new_launch_image_begin_time", 0) || currentTimeMillis >= r4) {
                w.i("SplashWelcomeView", "change launch image activity is finished!");
                b.deleteFile(str);
                return;
            }
            Object obj;
            this.uWC = sharedPreferences.getInt("launch_fail_times", 0);
            int i = sharedPreferences.getInt("launch_last_status", 0);
            if (i == 1) {
                w.i("SplashWelcomeView", "last launch status is 'start'.");
                this.uWC++;
                sharedPreferences.edit().putInt("launch_fail_times", this.uWC).commit();
            } else if (i == 2) {
                w.i("SplashWelcomeView", "last launch status is 'end'.");
            }
            sharedPreferences.edit().putInt("launch_last_status", 1).apply();
            if (this.uWC >= 3) {
                w.i("SplashWelcomeView", "launch exceed max failed times, %d", Integer.valueOf(this.uWC));
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                bQE();
            } else {
                e.post(new Runnable(this) {
                    final /* synthetic */ SplashWelcomeView uWE;

                    public final void run() {
                        if (com.tencent.mm.a.e.aO(str)) {
                            try {
                                byte[] c = com.tencent.mm.a.e.c(str, 0, com.tencent.mm.a.e.aN(str));
                                if (c != null && c.length > 0) {
                                    this.uWE.bitmap = BitmapFactory.decodeByteArray(c, 0, c.length);
                                    w.i("SplashWelcomeView", "ready to play animation, hasDrawed %s", Boolean.valueOf(this.uWE.hasDrawed));
                                    if (this.uWE.hasDrawed) {
                                        this.uWE.bQD();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Throwable e) {
                                w.printErrStackTrace("SplashWelcomeView", e, "decode new welcome image error: %s", e.getMessage());
                                return;
                            }
                        }
                        w.i("SplashWelcomeView", "cannot find %s", str);
                    }
                }, "readWelcomeBg");
            }
        } catch (Throwable e) {
            w.printErrStackTrace("SplashWelcomeView", e, "%s", e.getMessage());
            bQE();
        }
    }

    private synchronized void bQD() {
        if (!this.uWz) {
            this.uWz = true;
            if (this.bitmap != null) {
                try {
                    af.v(new Runnable(this) {
                        final /* synthetic */ SplashWelcomeView uWE;

                        {
                            this.uWE = r1;
                        }

                        public final void run() {
                            w.d("SplashWelcomeView", "set top imageView");
                            final View imageView = new ImageView(this.uWE.getContext());
                            imageView.setScaleType(ScaleType.CENTER_CROP);
                            imageView.setImageBitmap(this.uWE.bitmap);
                            imageView.setAlpha(0.0f);
                            this.uWE.addView(imageView, new LayoutParams(-1, -1));
                            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(1000);
                            duration.addUpdateListener(new AnimatorUpdateListener(this) {
                                final /* synthetic */ AnonymousClass2 uWG;

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    imageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                }
                            });
                            duration.start();
                            w.i("SplashWelcomeView", "start play animation");
                            new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                                final /* synthetic */ AnonymousClass2 uWG;

                                {
                                    this.uWG = r1;
                                }

                                public final boolean oQ() {
                                    w.i("SplashWelcomeView", "stop show new launch image");
                                    this.uWG.uWE.bQE();
                                    return true;
                                }
                            }, false).v(1750, 0);
                        }
                    });
                } catch (Throwable e) {
                    w.printErrStackTrace("SplashWelcomeView", e, "%s", e.getMessage());
                    bQE();
                }
            } else {
                w.i("SplashWelcomeView", "new launch bitmap is null");
                bQE();
            }
        }
    }

    private void bQE() {
        if (this.uWB != null) {
            this.uWB.on();
        }
    }

    public final void om() {
        w.i("SplashWelcomeView", "hasDrawed:%s", Boolean.valueOf(this.hasDrawed));
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (!this.uWz) {
                bQD();
            }
            if (this.uWy != null) {
                this.uWy.om();
            }
        }
    }
}
