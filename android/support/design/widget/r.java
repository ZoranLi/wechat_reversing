package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class r {
    WeakReference<View> fh;
    final ArrayList<a> jA = new ArrayList();
    a jB = null;
    public Animation jC = null;
    private AnimationListener jD = new AnimationListener(this) {
        final /* synthetic */ r jE;

        {
            this.jE = r1;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.jE.jC == animation) {
                this.jE.jC = null;
            }
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    };

    static class a {
        final int[] jF;
        final Animation mAnimation;

        public a(int[] iArr, Animation animation) {
            this.jF = iArr;
            this.mAnimation = animation;
        }
    }

    r() {
    }

    public final void a(int[] iArr, Animation animation) {
        a aVar = new a(iArr, animation);
        animation.setAnimationListener(this.jD);
        this.jA.add(aVar);
    }

    final View an() {
        return this.fh == null ? null : (View) this.fh.get();
    }
}
