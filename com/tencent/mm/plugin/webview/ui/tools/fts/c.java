package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.b;
import java.lang.reflect.Array;

public final class c {
    public static int nRa;
    public static int shL;
    private View jXN;
    public boolean nKt;
    public View shM;
    public View shN;
    public View shO;
    public View shP;
    public View shQ;
    public View shR;
    public float[][] shS;
    int shT = b.sic;
    public int shU;
    public int shV;
    public a sii;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] shZ = new int[b.bzd().length];

        static {
            try {
                shZ[b.sic - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                shZ[b.sid - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public interface a {
        void onAnimationEnd();
    }

    public c(Context context, final View view, final View view2, View view3, View view4, View view5, final View view6, View view7) {
        shL = com.tencent.mm.bg.a.fromDPToPix(context, 48) / 2;
        nRa = (int) context.getResources().getDimension(R.f.bbf);
        this.shS = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 2});
        this.shN = view;
        this.shM = view2;
        this.shO = view3;
        this.shR = view7;
        this.shP = view4;
        this.shQ = view5;
        this.jXN = view6;
        this.shN.post(new Runnable(this) {
            final /* synthetic */ c sij;

            public final void run() {
                this.sij.shS[0][0] = view.getY();
                this.sij.shS[0][1] = 0.0f;
                this.sij.shS[1][0] = view.getX();
                this.sij.shS[1][1] = 0.0f;
                this.sij.shS[2][0] = (float) view.getMeasuredWidth();
                this.sij.shS[2][1] = (float) (view.getMeasuredWidth() + (c.shL * 2));
            }
        });
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ c sij;

            public final boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                this.sij.shV = layoutParams.leftMargin - c.nRa;
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ c sij;

            public final boolean onPreDraw() {
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                this.sij.shU = 0;
                return true;
            }
        });
    }
}
