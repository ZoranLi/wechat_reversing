package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.m.h;
import java.util.Stack;

public final class d {
    public String iDc;
    public a iDd = new a();
    public a iDe = new a();
    public Stack<a> iDf;
    public Stack<a> iDg;
    public Paint iDh = new Paint();
    public Paint iDi;

    public d() {
        this.iDd.setStyle(Style.STROKE);
        this.iDe.setStyle(Style.FILL);
        this.iDd.setAntiAlias(true);
        this.iDe.setAntiAlias(true);
        this.iDd.setStrokeWidth((float) h.iD(1));
        this.iDe.setStrokeWidth((float) h.iD(1));
        this.iDf = new Stack();
        this.iDg = new Stack();
        this.iDh.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }
}
