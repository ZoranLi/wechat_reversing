package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;

public final class b {
    ValueAnimator jsj;
    public float nNg = 0.0f;
    a nNh;
    public a nNi;
    public boolean nNj = false;
    public a nNk;
    PointF nNl;
    PointF nNm;
    PointF nNn;
    PointF nNo;
    PointF nNp;
    PointF nNq;
    float nNr = 0.0f;
    float nNs = 0.0f;
    float nNt = 0.0f;
    float nNu = 0.0f;
    Path nNv;
    private Paint nNw = null;

    public interface a {
        void a(a aVar);

        void aMp();
    }

    public b(a aVar, a aVar2, a aVar3) {
        this.nNh = aVar;
        this.nNi = aVar2;
        this.nNk = aVar3;
        this.nNs = ((float) MMSightProgressBar.loq) * 2.0f;
        this.nNt = ((float) (-MMSightProgressBar.loq)) * 0.5f;
        this.nNv = new Path();
        this.nNw = new Paint();
        this.nNw.setAntiAlias(true);
        this.nNw.setStyle(Style.FILL);
    }
}
