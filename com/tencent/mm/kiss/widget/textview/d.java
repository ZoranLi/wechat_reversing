package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    private static e has = new e();
    private static final SpannableString hat = new SpannableString("");
    int gravity = 51;
    TruncateAt haA = null;
    int haB = -1;
    TextDirectionHeuristic haC = null;
    float haD = 0.0f;
    float haE = 1.0f;
    boolean haF = false;
    LengthFilter haG = null;
    CharSequence hau = null;
    CharSequence hav = null;
    int haw = 0;
    int hax = 0;
    TextPaint hay = null;
    Alignment haz = Alignment.ALIGN_NORMAL;
    int maxLength = -1;
    int maxLines = Integer.MAX_VALUE;
    int width = 0;

    public static d a(CharSequence charSequence, int i, a aVar) {
        boolean z = false;
        if (charSequence == null) {
            charSequence = "";
        }
        int length = charSequence.length();
        if (charSequence == null) {
            charSequence = "";
        }
        d vX = has.vX();
        if (vX == null) {
            vX = new d();
        }
        vX.hau = charSequence.toString();
        vX.hav = charSequence;
        vX.haw = 0;
        vX.hax = length;
        vX.width = i;
        vX.hay = new TextPaint();
        if (aVar.maxLines != -1) {
            length = aVar.maxLines;
            if (length >= 0) {
                vX.maxLines = length;
            }
        }
        if (aVar.maxLength != -1) {
            length = aVar.maxLength;
            if (length >= 0) {
                vX.maxLength = length;
                vX.haG = new LengthFilter(vX.maxLength);
            }
        }
        Alignment alignment = aVar.haz;
        if (alignment != null) {
            vX.haz = alignment;
        }
        if (aVar.haA != null) {
            TruncateAt truncateAt = aVar.haA;
            if (truncateAt != null) {
                vX.haA = truncateAt;
            }
        }
        vX.gravity = aVar.gravity;
        if (aVar.hbc != -1) {
            length = aVar.hbc;
            if (length >= 0) {
                vX.haB = length;
            }
        }
        if (aVar.haC != null) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.haC;
            if (VERSION.SDK_INT >= 18) {
                vX.haC = textDirectionHeuristic;
            }
        }
        float f = aVar.haD;
        float f2 = aVar.haE;
        vX.haD = f;
        vX.haE = f2;
        vX.haF = aVar.haF;
        if (aVar.hbd != null) {
            if (aVar.hbe != -1) {
                Typeface typeface = aVar.hbd;
                int i2 = aVar.hbe;
                if (i2 > 0) {
                    typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                    vX.a(typeface);
                    length = ((typeface != null ? typeface.getStyle() : 0) ^ -1) & i2;
                    TextPaint textPaint = vX.hay;
                    if ((length & 1) != 0) {
                        z = true;
                    }
                    textPaint.setFakeBoldText(z);
                    vX.hay.setTextSkewX((length & 2) != 0 ? -0.25f : 0.0f);
                } else {
                    vX.hay.setFakeBoldText(false);
                    vX.hay.setTextSkewX(0.0f);
                    vX.a(typeface);
                }
            } else {
                vX.a(aVar.hbd);
            }
        }
        if (aVar.hbf != -1.0f) {
            vX.hay.setTextSize(aVar.hbf);
        }
        if (aVar.textColor != -1) {
            vX.hay.setColor(aVar.textColor);
        }
        if (aVar.linkColor != -1) {
            vX.hay.linkColor = aVar.linkColor;
        }
        if (aVar.haK != null) {
            vX.hay = aVar.haK;
        }
        return vX;
    }

    private d a(Typeface typeface) {
        this.hay.setTypeface(typeface);
        return this;
    }

    @TargetApi(18)
    public final f vW() {
        int i;
        boolean z;
        StaticLayout a;
        if (this.haA == null || this.haB <= 0) {
            i = this.width;
        } else {
            i = this.haB;
        }
        if (this.haA == null && this.maxLines == 1) {
            this.haA = TruncateAt.END;
        }
        if (this.maxLength > 0 && this.haG != null) {
            CharSequence filter = this.haG.filter(this.hav, 0, this.hav.length(), hat, 0, 0);
            if (filter != null) {
                this.hav = filter;
                if (this.hax > this.hav.length()) {
                    this.hax = this.hav.length();
                }
            }
        }
        if (h.DEBUG) {
            w.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.hav + " " + this.width);
        }
        if (this.haz == Alignment.ALIGN_NORMAL) {
            switch (this.gravity & 8388615) {
                case 1:
                    this.haz = Alignment.ALIGN_CENTER;
                    break;
                case 3:
                case 8388611:
                    this.haz = Alignment.ALIGN_NORMAL;
                    break;
                case 5:
                case 8388613:
                    this.haz = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    this.haz = Alignment.ALIGN_NORMAL;
                    break;
            }
        }
        this.hay.setAntiAlias(true);
        StaticLayout staticLayout = null;
        if ((this.haC == null || (com.tencent.mm.compatible.util.d.eo(18) && this.haC == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && (this.maxLines == Integer.MAX_VALUE || this.maxLines == -1)) {
            z = true;
        } else {
            z = false;
        }
        try {
            a = a(this.hav, z, i);
        } catch (Exception e) {
            w.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e.getMessage());
            int i2 = 0;
            while (i2 < 3) {
                try {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(this.hav);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                    if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                        i2 = 100;
                    } else {
                        spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                        i2++;
                    }
                    this.hav = spannableStringBuilder;
                    staticLayout = a(this.hav, z, i);
                    w.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i2));
                    a = staticLayout;
                } catch (Exception e2) {
                    w.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e2.getMessage(), Integer.valueOf(i2));
                }
            }
            a = staticLayout;
        }
        if (a == null) {
            this.hav = this.hav.toString();
            a = a(this.hav, z, i);
        }
        f fVar = new f(a);
        fVar.haJ = this.hau;
        fVar.text = this.hav;
        fVar.maxLength = this.maxLength;
        fVar.maxLines = this.maxLines;
        fVar.haz = this.haz;
        fVar.haA = this.haA;
        fVar.haK = this.hay;
        fVar.gravity = this.gravity;
        has.a(this);
        return fVar;
    }

    private StaticLayout a(CharSequence charSequence, boolean z, int i) {
        if (z) {
            return new StaticLayout(charSequence, this.haw, this.hax, this.hay, this.width, this.haz, this.haE, this.haD, this.haF, this.haA, i);
        } else if (VERSION.SDK_INT >= 18) {
            if (this.haC == null) {
                this.haC = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.haw, this.hax, this.hay, this.width, this.haz, this.haC, this.haE, this.haD, this.haF, this.haA, i, this.maxLines);
        } else {
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.haw, this.hax, this.hay, this.width, this.haz, this.haE, this.haD, this.haF, this.haA, i, this.maxLines);
        }
    }
}
