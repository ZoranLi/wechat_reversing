package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

public final class a {

    static class AnonymousClass1 implements AnimationListener {
        final /* synthetic */ a ren;

        AnonymousClass1(a aVar) {
            this.ren = aVar;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.ren != null) {
                this.ren.boI();
            }
            w.d("MicroMsg.VoiceViewAnimationHelper", "playTipAnim end");
        }
    }

    static class AnonymousClass4 implements AnimationListener {
        final /* synthetic */ a ren;

        AnonymousClass4(a aVar) {
            this.ren = aVar;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.ren != null) {
                this.ren.boI();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    static class AnonymousClass5 implements AnimationListener {
        final /* synthetic */ a ren;

        AnonymousClass5(a aVar) {
            this.ren = aVar;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.ren != null) {
                this.ren.boH();
            }
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.ren != null) {
                this.ren.boI();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    static class AnonymousClass6 implements AnimationListener {
        final /* synthetic */ a ren;

        AnonymousClass6(a aVar) {
            this.ren = aVar;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.ren != null) {
                this.ren.boH();
            }
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.ren != null) {
                this.ren.boI();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    static class AnonymousClass7 implements AnimationListener {
        final /* synthetic */ a ren;

        AnonymousClass7(a aVar) {
            this.ren = aVar;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.ren != null) {
                this.ren.boH();
            }
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.ren != null) {
                this.ren.boI();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public interface a {
        void boH();

        void boI();
    }

    public static void a(final View view, final a aVar) {
        float width = (float) view.getWidth();
        w.d("MicroMsg.VoiceViewAnimationHelper", "target " + width);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int i = (int) (width + ((float) iArr[0]));
        w.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i)});
        view.getParent();
        Animation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) (-i), 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset(0);
        translateAnimation.setRepeatMode(-1);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (aVar != null) {
                    aVar.boH();
                }
                w.d("MicroMsg.VoiceViewAnimationHelper", "onAnimationEnd ");
                Animation translateAnimation = new TranslateAnimation(0, (float) i, 0, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(200);
                translateAnimation.setStartOffset(0);
                translateAnimation.setRepeatMode(-1);
                translateAnimation.setRepeatCount(0);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass2 req;

                    {
                        this.req = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        w.i("MicroMsg.VoiceViewAnimationHelper", "next end");
                        if (aVar != null) {
                            aVar.boI();
                        }
                    }
                });
                view.startAnimation(translateAnimation);
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static void a(View view, Context context, final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.aQW);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (aVar != null) {
                    aVar.boI();
                }
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(loadAnimation);
    }
}
