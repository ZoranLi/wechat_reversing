package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.celltextview.g.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public class e {
    protected static Paint wyD = new Paint(1);
    protected Paint fu;
    protected int jkE;
    protected String jqT;
    protected int mType = 0;
    protected int sl;
    protected float wyB;
    protected boolean wyC;

    public e(Paint paint) {
        this.fu = paint;
    }

    private e(Paint paint, int i, int i2, float f, String str, boolean z) {
        this.sl = i;
        this.jkE = i2;
        this.wyB = f;
        this.jqT = str;
        this.wyC = z;
        this.fu = paint;
    }

    public e(Paint paint, int i, String str, float f) {
        this.mType = i;
        this.wyB = f;
        this.jqT = str;
        this.fu = paint;
    }

    public String toString() {
        return "type:" + this.mType + ", Text:" + (this.jqT == null ? "" : this.jqT) + ", Size:" + this.wyB + ", Color:" + this.sl;
    }

    public final String getText() {
        return this.jqT;
    }

    public final int getType() {
        return this.mType;
    }

    public final void setColor(int i) {
        this.sl = i;
    }

    public final void CC(int i) {
        this.jkE = i;
    }

    public final void ay(float f) {
        this.wyB = f;
    }

    public final void setText(String str) {
        this.jqT = str;
    }

    public final void setUnderlineText(boolean z) {
        this.wyC = z;
    }

    public boolean caX() {
        return true;
    }

    public final int caZ() {
        int i = 1;
        w.d("NewTextCell", "[getHashcode] mSize:%s ,mBgColor:%s,mColor:%s,mType:%s,hashCode:%s", Float.valueOf(this.wyB), Integer.valueOf(this.jkE), Integer.valueOf(this.sl), Integer.valueOf(this.mType), Integer.valueOf(this.jqT.hashCode()));
        float f = ((this.wyB + ((float) this.jkE)) + ((float) this.sl)) + ((float) this.mType);
        if (!this.wyC) {
            i = 2;
        }
        return ((int) (((float) i) + f)) * r2;
    }

    public int getLength() {
        if (this.jqT != null) {
            return this.jqT.length();
        }
        return 0;
    }

    public final void v(int i, int i2, String str) {
        if (i < 0) {
            i = 0;
        }
        if (i2 > this.jqT.length() || i2 < 0) {
            i2 = this.jqT.length();
        }
        this.jqT = this.jqT.substring(i, i2);
        if (!TextUtils.isEmpty(str)) {
            this.jqT += str;
        }
    }

    public float getWidth() {
        float f = 0.0f;
        cba();
        if (TextUtils.isEmpty(this.jqT)) {
            return 0.0f;
        }
        float measureText = wyD.measureText(this.jqT);
        if (measureText > 0.0f) {
            return measureText;
        }
        Paint paint = wyD;
        int length = this.jqT.length();
        int i = 0;
        while (i < length) {
            int charCount = Character.charCount(this.jqT.codePointAt(i));
            float measureText2 = paint.measureText(this.jqT, i, i + charCount) + f;
            i += charCount;
            f = measureText2;
        }
        return f;
    }

    public float Cy(int i) {
        cba();
        FontMetrics fontMetrics = wyD.getFontMetrics();
        return (fontMetrics.bottom - fontMetrics.top) + ((float) i);
    }

    public final int a(int i, int i2, float[] fArr) {
        if (TextUtils.isEmpty(this.jqT)) {
            return 0;
        }
        cba();
        int i3 = i + i2;
        if (i3 > this.jqT.length()) {
            i3 = this.jqT.length();
        }
        if (i < i3) {
            return wyD.getTextWidths(this.jqT, i, i3, fArr);
        }
        return 0;
    }

    public final float m(int i, float f) {
        if (TextUtils.isEmpty(this.jqT)) {
            return 0.0f;
        }
        cba();
        int i2 = i + 0;
        if (i2 > this.jqT.length()) {
            i2 = this.jqT.length();
        }
        if (i2 <= 0) {
            return 0.0f;
        }
        float[] fArr = new float[i];
        i2 = wyD.getTextWidths(this.jqT, 0, i2, fArr);
        float f2 = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            f2 += fArr[i3];
        }
        return (((float) i2) * f) + f2;
    }

    public e caY() {
        return new e(this.fu, this.sl, this.jkE, this.wyB, this.jqT, this.wyC);
    }

    public void a(Canvas canvas, RectF rectF, float f, float f2) {
        int i = 0;
        cba();
        float height = rectF.top + ((float) ((int) (((rectF.height() - wyD.descent()) - wyD.ascent()) / 2.0f)));
        float f3 = rectF.left;
        String str = this.jqT;
        Paint paint = wyD;
        canvas.save();
        char charAt = str.charAt(0);
        if (a.n(charAt)) {
            canvas.translate(-a.b(charAt, paint), 0.0f);
        }
        boolean isUnderlineText = paint.isUnderlineText();
        paint.setUnderlineText(false);
        char[] cArr = new char[str.length()];
        str.getChars(0, str.length(), cArr, 0);
        if (this.jkE != 0) {
            paint.setColor(this.jkE);
            paint.setStyle(Style.FILL);
            canvas.drawRect(rectF, paint);
            paint.setStyle(Style.STROKE);
            paint.setColor(this.sl);
        }
        int i2 = -1;
        while (i < str.length()) {
            char c = cArr[i];
            if (Character.isHighSurrogate(c)) {
                if (-1 == i2) {
                    i2 = i;
                }
                i++;
            } else {
                if (-1 != i2) {
                    String substring = str.substring(i2, i);
                    canvas.drawText(substring, f3, height, paint);
                    f3 += paint.measureText(substring) + f;
                    i2 = -1;
                }
                String ch = Character.toString(c);
                canvas.drawText(ch, f3, height, paint);
                f3 += paint.measureText(ch) + f;
            }
            i++;
        }
        if (-1 != i2) {
            String substring2 = str.substring(i2, str.length());
            canvas.drawText(substring2, f3, height, paint);
            f3 += paint.measureText(substring2) + f;
        }
        if (isUnderlineText) {
            float strokeWidth = paint.getStrokeWidth();
            Style style = paint.getStyle();
            paint.setStrokeWidth(paint.getTextSize() / 15.0f);
            paint.setStyle(Style.FILL);
            float strokeWidth2 = (paint.getStrokeWidth() * DownloadHelper.SAVE_FATOR) + (paint.getFontMetrics().leading + height);
            canvas.drawLine(f3, strokeWidth2, f3, strokeWidth2, paint);
            paint.setStrokeWidth(strokeWidth);
            paint.setStyle(style);
        }
        paint.setUnderlineText(isUnderlineText);
        canvas.restore();
    }

    public final void cba() {
        wyD.set(this.fu);
        wyD.setColor(this.sl);
        wyD.setTextSize(this.wyB);
        wyD.setUnderlineText(this.wyC);
    }
}
