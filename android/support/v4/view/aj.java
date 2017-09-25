package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class aj {

    static class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ am zF;
        final /* synthetic */ View zG;

        AnonymousClass1(am amVar, View view) {
            this.zF = amVar;
            this.zG = view;
        }

        public final void onAnimationCancel(Animator animator) {
            this.zF.as(this.zG);
        }

        public final void onAnimationEnd(Animator animator) {
            this.zF.q(this.zG);
        }

        public final void onAnimationStart(Animator animator) {
            this.zF.p(this.zG);
        }
    }
}
