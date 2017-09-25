package com.tencent.mm.plugin.sns.ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    private static c qPB = new c();
    private a qPC = null;
    private a qPD = null;
    public int qPx = 0;

    public static c blK() {
        return qPB;
    }

    public final a blJ() {
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), (int) (15.0f * com.tencent.mm.bg.a.dI(ab.getContext())));
        if (this.qPC == null || ((int) this.qPC.hbf) != fromDPToPix) {
            this.qPC = b.we().eQ(19).eR(ab.getContext().getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVo)).I((float) fromDPToPix).haO;
        }
        return this.qPC;
    }

    public final a blL() {
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), (int) (15.0f * com.tencent.mm.bg.a.dI(ab.getContext())));
        if (this.qPD == null || ((int) this.qPD.hbf) != fromDPToPix) {
            b I = b.we().eQ(19).eR(ab.getContext().getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVo)).I((float) fromDPToPix);
            I.haO.maxLines = 6;
            this.qPD = I.haO;
        }
        return this.qPD;
    }

    public final int blM() {
        if (this.qPx <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int dimension = (int) (ab.getResources().getDimension(d.aXH) + ab.getResources().getDimension(d.aXH));
            int dimension2 = (int) ab.getResources().getDimension(d.pzn);
            int dimension3 = (int) ab.getResources().getDimension(d.aXH);
            this.qPx = (i - dimension2) - dimension;
            w.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.qPx + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        return this.qPx;
    }

    public static float getTextSize() {
        return (float) com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), (int) (15.0f * com.tencent.mm.bg.a.dI(ab.getContext())));
    }
}
