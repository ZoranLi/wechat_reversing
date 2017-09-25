package com.tencent.mm.plugin.fts.d;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {

    public static final class a {
        public static final int mcA = Color.parseColor("#661AAD19");
        public static final int mcB = Color.parseColor("#801AAD19");
        public static final int mcz = Color.parseColor("#45C01A");
    }

    public static final class b {
        public static final int mcC = com.tencent.mm.bg.a.T(ab.getContext(), com.tencent.mm.plugin.fts.d.j.b.aXI);
        public static final TextPaint mcD = new TextPaint();
        public static final int mcE = com.tencent.mm.bg.a.T(ab.getContext(), com.tencent.mm.plugin.fts.d.j.b.aXs);
        public static final TextPaint mcF = new TextPaint();
        public static final int mcG = com.tencent.mm.bg.a.T(ab.getContext(), com.tencent.mm.plugin.fts.d.j.b.aXU);
        public static final TextPaint mcH = new TextPaint();

        static {
            mcD.setTextSize((float) mcC);
            mcF.setTextSize((float) mcE);
            mcH.setTextSize((float) mcG);
        }
    }
}
