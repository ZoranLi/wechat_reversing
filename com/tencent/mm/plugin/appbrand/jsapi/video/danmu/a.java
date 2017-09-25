package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;

public final class a implements d {
    private static int iXF;
    private static int iXG;
    private int RA;
    private int Rq;
    private StaticLayout haL;
    private SpannableString iXH;
    private int iXI;
    private int iXJ;
    private int iXK = -1;
    private int iXL;
    private int iXM;
    private float iXN;
    private Context mContext;
    private int xT = -1;

    public a(Context context, SpannableString spannableString, int i, int i2) {
        this.mContext = context;
        this.iXH = spannableString;
        this.iXL = b.t(this.mContext, b.iXO);
        this.xT = i;
        this.iXN = 3.0f;
        this.iXM = i2;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.xT);
        textPaint.setTextSize((float) this.iXL);
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.RA = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
        this.haL = new StaticLayout(this.iXH, textPaint, ((int) Layout.getDesiredWidth(this.iXH, 0, this.iXH.length(), textPaint)) + 1, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.Rq = this.haL.getWidth();
    }

    public final void a(Canvas canvas, boolean z) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (!(width == iXF && height == iXG)) {
            iXF = width;
            iXG = height;
        }
        canvas.save();
        canvas.translate((float) this.iXI, (float) this.iXJ);
        this.haL.draw(canvas);
        canvas.restore();
        if (!z) {
            this.iXI = (int) (((float) this.iXI) - (((float) b.UG()) * this.iXN));
        }
    }

    public final void bq(int i, int i2) {
        this.iXI = i;
        this.iXJ = i2;
    }

    public final float UD() {
        return this.iXN;
    }

    public final boolean UE() {
        return this.iXI < 0 && Math.abs(this.iXI) > this.Rq;
    }

    public final int getWidth() {
        return this.Rq;
    }

    public final int getCurrX() {
        return this.iXI;
    }

    public final int UF() {
        return this.iXM;
    }

    public final boolean hT(int i) {
        if (i >= this.iXM && i - this.iXM <= b.iXP) {
            return true;
        }
        return false;
    }

    public final boolean hU(int i) {
        return i - this.iXM > b.iXP;
    }

    public final boolean a(d dVar) {
        if (dVar.getWidth() + dVar.getCurrX() > iXF) {
            return true;
        }
        if (this.iXK < 0) {
            this.iXK = b.t(this.mContext, 20);
        }
        if (dVar.UD() >= this.iXN) {
            if (dVar.UD() != this.iXN || ((float) (iXF - (dVar.getCurrX() + dVar.getWidth()))) >= ((float) this.iXK)) {
                return false;
            }
            return true;
        } else if (((double) (((((float) (dVar.getCurrX() + dVar.getWidth())) / (dVar.UD() * ((float) b.UG()))) * this.iXN) * ((float) b.UG()))) <= ((double) iXF) - (((double) this.iXK) * 1.5d)) {
            return false;
        } else {
            return true;
        }
    }
}
