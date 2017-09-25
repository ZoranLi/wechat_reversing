package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class t extends i {
    public TextView itE;
    private RelativeLayout qjr;
    public ImageView qjs;

    public t(Context context, q qVar, ViewGroup viewGroup) {
        super(context, qVar, viewGroup);
        this.qib = qVar;
    }

    public final q bgy() {
        return (q) this.qib;
    }

    protected final int aTQ() {
        return g.pHc;
    }

    public final void bfO() {
        super.bfO();
    }

    protected final void bgl() {
        this.itE.setText(((q) this.qib).label);
        this.itE.setTextSize(0, ((q) this.qib).qfp);
        if (((q) this.qib).iDX != null && ((q) this.qib).iDX.length() > 0) {
            this.qjr.setBackgroundColor(Color.parseColor(((q) this.qib).iDX));
        }
        d.a(((q) this.qib).qfX, ((q) this.qib).qfJ, new a(this) {
            final /* synthetic */ t qjt;

            {
                this.qjt = r1;
            }

            public final void bgn() {
            }

            public final void bgo() {
            }

            public final void FW(String str) {
                try {
                    this.qjt.qjs.setImageBitmap(BitmapFactory.decodeFile(str));
                    TextView textView = this.qjt.itE;
                    Paint paint = new Paint();
                    String charSequence = textView.getText().toString();
                    paint.setTextSize(textView.getTextSize());
                    float measureText = (this.qjt.qib.qfO - paint.measureText(charSequence, 0, charSequence.length())) - TypedValue.applyDimension(1, 3.0f, this.qjt.context.getResources().getDisplayMetrics());
                    int i = (int) (measureText - (this.qjt.bgy().value * measureText));
                    LayoutParams layoutParams = (LayoutParams) this.qjt.qjs.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i, layoutParams.leftMargin);
                    this.qjt.qjs.setLayoutParams(layoutParams);
                } catch (Throwable e) {
                    w.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bg.g(e));
                }
            }
        });
    }

    public final View bgf() {
        View view = this.ipu;
        view.setBackgroundColor(this.backgroundColor);
        this.itE = (TextView) view.findViewById(f.pDU);
        this.qjr = (RelativeLayout) view.findViewById(f.pDS);
        this.qjs = (ImageView) view.findViewById(f.pDT);
        return view;
    }

    public final void bfP() {
        super.bfP();
    }

    public final void bfQ() {
        super.bfQ();
    }
}
