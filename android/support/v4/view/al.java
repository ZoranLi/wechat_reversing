package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class al {

    static class AnonymousClass1 implements AnimatorUpdateListener {
        final /* synthetic */ View zG;
        final /* synthetic */ ao zH;

        AnonymousClass1(ao aoVar, View view) {
            this.zH = aoVar;
            this.zG = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.zH.bZ();
        }
    }
}
