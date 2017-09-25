package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    public static final Handler ji = new Handler(Looper.getMainLooper(), new Callback() {
        public final boolean handleMessage(Message message) {
            Snackbar snackbar;
            switch (message.what) {
                case 0:
                    snackbar = (Snackbar) message.obj;
                    if (snackbar.jk.getParent() == null) {
                        LayoutParams layoutParams = snackbar.jk.getLayoutParams();
                        if (layoutParams instanceof d) {
                            Behavior aVar = new a(snackbar);
                            aVar.jL = s.l(0.1f);
                            aVar.jM = s.l(0.6f);
                            aVar.jJ = 0;
                            aVar.jG = new android.support.design.widget.s.a(snackbar) {
                                final /* synthetic */ Snackbar jo;

                                {
                                    this.jo = r1;
                                }

                                public final void onDismiss(View view) {
                                    view.setVisibility(8);
                                    Snackbar snackbar = this.jo;
                                    q am = q.am();
                                    a aVar = snackbar.jm;
                                    synchronized (am.mLock) {
                                        if (am.d(aVar)) {
                                            am.a(am.jw);
                                        } else if (am.e(aVar)) {
                                            am.a(am.jx);
                                        }
                                    }
                                }

                                public final void w(int i) {
                                    switch (i) {
                                        case 0:
                                            q.am().b(this.jo.jm);
                                            return;
                                        case 1:
                                        case 2:
                                            q.am().a(this.jo.jm);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                            ((d) layoutParams).a(aVar);
                        }
                        snackbar.jj.addView(snackbar.jk);
                    }
                    snackbar.jk.ju = new a(snackbar) {
                        final /* synthetic */ Snackbar jo;

                        {
                            this.jo = r1;
                        }

                        public final void ak() {
                            if (q.am().c(this.jo.jm)) {
                                Snackbar.ji.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 jp;

                                    {
                                        this.jp = r1;
                                    }

                                    public final void run() {
                                        this.jp.jo.ai();
                                    }
                                });
                            }
                        }
                    };
                    if (!z.aj(snackbar.jk)) {
                        snackbar.jk.jt = new b(snackbar) {
                            final /* synthetic */ Snackbar jo;

                            {
                                this.jo = r1;
                            }

                            public final void al() {
                                this.jo.jk.jt = null;
                                if (this.jo.aj()) {
                                    this.jo.ag();
                                } else {
                                    this.jo.ah();
                                }
                            }
                        };
                    } else if (snackbar.aj()) {
                        snackbar.ag();
                    } else {
                        snackbar.ah();
                    }
                    return true;
                case 1:
                    snackbar = (Snackbar) message.obj;
                    int i = message.arg1;
                    if (!snackbar.aj() || snackbar.jk.getVisibility() != 0) {
                        snackbar.ai();
                    } else if (VERSION.SDK_INT >= 14) {
                        z.V(snackbar.jk).r((float) snackbar.jk.getHeight()).b(a.et).c(250).a(new AnonymousClass8(snackbar, i)).start();
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snackbar.jk.getContext(), android.support.design.a.a.W);
                        loadAnimation.setInterpolator(a.et);
                        loadAnimation.setDuration(250);
                        loadAnimation.setAnimationListener(new AnonymousClass2(snackbar, i));
                        snackbar.jk.startAnimation(loadAnimation);
                    }
                    return true;
                default:
                    return false;
            }
        }
    });
    final ViewGroup jj;
    public final SnackbarLayout jk;
    private final AccessibilityManager jl;
    public final a jm;

    class AnonymousClass2 implements AnimationListener {
        final /* synthetic */ int jn;
        final /* synthetic */ Snackbar jo;

        AnonymousClass2(Snackbar snackbar, int i) {
            this.jo = snackbar;
            this.jn = i;
        }

        public final void onAnimationEnd(Animation animation) {
            this.jo.ai();
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public static class SnackbarLayout extends LinearLayout {
        private int iO;
        TextView jq;
        Button jr;
        private int js;
        b jt;
        a ju;

        interface a {
            void ak();
        }

        interface b {
            void al();
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cI);
            this.iO = obtainStyledAttributes.getDimensionPixelSize(i.cJ, -1);
            this.js = obtainStyledAttributes.getDimensionPixelSize(i.cL, -1);
            if (obtainStyledAttributes.hasValue(i.cK)) {
                z.g((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(i.cK, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(f.ay, this);
            z.O(this);
            z.i(this, 1);
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.jq = (TextView) findViewById(e.au);
            this.jr = (Button) findViewById(e.at);
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.iO > 0 && getMeasuredWidth() > this.iO) {
                i = MeasureSpec.makeMeasureSpec(this.iO, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(android.support.design.a.d.an);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(android.support.design.a.d.am);
            int i3 = this.jq.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.js <= 0 || this.jr.getMeasuredWidth() <= this.js) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (c(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (c(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.jt != null) {
                this.jt.al();
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.ju != null) {
                this.ju.ak();
            }
        }

        private boolean c(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.jq.getPaddingTop() == i2 && this.jq.getPaddingBottom() == i3) {
                return z;
            }
            View view = this.jq;
            if (z.ae(view)) {
                z.c(view, z.P(view), i2, z.Q(view), i3);
            } else {
                view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
            }
            return true;
        }
    }

    class AnonymousClass8 extends an {
        final /* synthetic */ int jn;
        final /* synthetic */ Snackbar jo;

        AnonymousClass8(Snackbar snackbar, int i) {
            this.jo = snackbar;
            this.jn = i;
        }

        public final void p(View view) {
            SnackbarLayout snackbarLayout = this.jo.jk;
            z.d(snackbarLayout.jq, 1.0f);
            z.V(snackbarLayout.jq).p(0.0f).c(180).d(0).start();
            if (snackbarLayout.jr.getVisibility() == 0) {
                z.d(snackbarLayout.jr, 1.0f);
                z.V(snackbarLayout.jr).p(0.0f).c(180).d(0).start();
            }
        }

        public final void q(View view) {
            this.jo.ai();
        }
    }

    final class a extends s<SnackbarLayout> {
        final /* synthetic */ Snackbar jo;

        a(Snackbar snackbar) {
            this.jo = snackbar;
        }

        public final boolean r(View view) {
            return view instanceof SnackbarLayout;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.b(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        q.am().a(this.jo.jm);
                        break;
                    case 1:
                    case 3:
                        q.am().b(this.jo.jm);
                        break;
                }
            }
            return super.a(coordinatorLayout, snackbarLayout, motionEvent);
        }
    }

    public final void ag() {
        if (VERSION.SDK_INT >= 14) {
            z.c(this.jk, (float) this.jk.getHeight());
            z.V(this.jk).r(0.0f).b(a.et).c(250).a(new an(this) {
                final /* synthetic */ Snackbar jo;

                {
                    this.jo = r1;
                }

                public final void p(View view) {
                    SnackbarLayout snackbarLayout = this.jo.jk;
                    z.d(snackbarLayout.jq, 0.0f);
                    z.V(snackbarLayout.jq).p(1.0f).c(180).d(70).start();
                    if (snackbarLayout.jr.getVisibility() == 0) {
                        z.d(snackbarLayout.jr, 0.0f);
                        z.V(snackbarLayout.jr).p(1.0f).c(180).d(70).start();
                    }
                }

                public final void q(View view) {
                    this.jo.ah();
                }
            }).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.jk.getContext(), android.support.design.a.a.V);
        loadAnimation.setInterpolator(a.et);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ Snackbar jo;

            {
                this.jo = r1;
            }

            public final void onAnimationEnd(Animation animation) {
                this.jo.ah();
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.jk.startAnimation(loadAnimation);
    }

    public final void ah() {
        q am = q.am();
        a aVar = this.jm;
        synchronized (am.mLock) {
            if (am.d(aVar)) {
                am.b(am.jw);
            }
        }
    }

    public final void ai() {
        q am = q.am();
        a aVar = this.jm;
        synchronized (am.mLock) {
            if (am.d(aVar)) {
                am.jw = null;
                if (!(am.jx == null || am.jx == null)) {
                    am.jw = am.jx;
                    am.jx = null;
                    if (((a) am.jw.jz.get()) == null) {
                        am.jw = null;
                    }
                }
            }
        }
        ViewParent parent = this.jk.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jk);
        }
    }

    public final boolean aj() {
        return !this.jl.isEnabled();
    }
}
