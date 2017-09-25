package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.TimeUnit;

public final class f extends FrameLayout implements OnClickListener {
    private static final long jqV = TimeUnit.SECONDS.toMillis(4);
    public TextView jqH;
    public int jqU = a.jrc;
    private final Runnable jqW = new Runnable(this) {
        final /* synthetic */ f jra;

        {
            this.jra = r1;
        }

        public final void run() {
            this.jra.dismiss();
        }
    };
    private ImageView jqX;
    public ViewPropertyAnimator jqY;
    private ViewPropertyAnimator jqZ;
    private final ae mHandler = new ae(Looper.getMainLooper());

    private enum a {
        ;

        static {
            jrb = 1;
            jrc = 2;
            jrd = 3;
            jre = 4;
            jrf = new int[]{jrb, jrc, jrd, jre};
        }
    }

    static /* synthetic */ void e(f fVar) {
        int i = ((MarginLayoutParams) fVar.jqX.getLayoutParams()).rightMargin;
        ((ViewGroup) fVar.jqX.getParent()).setTouchDelegate(new TouchDelegate(new Rect(fVar.jqX.getLeft() - (i * 2), 0, i + fVar.jqX.getRight(), fVar.getHeight()), fVar.jqX));
    }

    public f(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.i.cUh, this);
        setLayoutParams(new LayoutParams(-1, -2));
        ImageView imageView = (ImageView) findViewById(R.h.bCx);
        this.jqX = imageView;
        imageView.setOnClickListener(this);
        this.jqH = (TextView) findViewById(R.h.message);
        setOnClickListener(this);
    }

    public final void dismiss() {
        if (getTranslationY() != ((float) (-getHeight())) && this.jqZ == null) {
            this.jqU = a.jrb;
            this.mHandler.removeCallbacks(this.jqW);
            this.jqZ = animate().translationY((float) (-getHeight()));
            this.jqZ.setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ f jra;

                {
                    this.jra = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    this.jra.jqZ = null;
                    this.jra.setVisibility(8);
                    this.jra.jqU = a.jrc;
                }
            });
            this.jqZ.start();
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.bCx) {
            dismiss();
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a.jrc == this.jqU) {
            post(new Runnable(this) {
                final /* synthetic */ f jra;

                {
                    this.jra = r1;
                }

                public final void run() {
                    this.jra.setTranslationY((float) (-this.jra.getHeight()));
                    f.e(this.jra);
                    this.jra.setVisibility(8);
                }
            });
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (a.jrb == this.jqU) {
            setTranslationY((float) (-getHeight()));
            setVisibility(8);
            this.jqU = a.jrc;
        }
    }
}
