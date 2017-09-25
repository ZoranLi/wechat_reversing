package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class a {
    public int gravity = 51;
    public TruncateAt haA = null;
    public TextDirectionHeuristic haC = null;
    public float haD = 0.0f;
    public float haE = 1.0f;
    public boolean haF = false;
    public TextPaint haK = null;
    public Alignment haz = Alignment.ALIGN_NORMAL;
    public int hbc = -1;
    public Typeface hbd = null;
    public int hbe = -1;
    public float hbf = -1.0f;
    public int linkColor = -1;
    public int maxLength = -1;
    public int maxLines = -1;
    public int minLines = -1;
    public int textColor = -1;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(String.format("maxLines: %d ", new Object[]{Integer.valueOf(this.maxLines)}));
        stringBuilder.append(String.format("maxLength: %d ", new Object[]{Integer.valueOf(this.maxLength)}));
        stringBuilder.append(String.format("textPaint: %s ", new Object[]{this.haK}));
        stringBuilder.append(String.format("alignment: %s ", new Object[]{this.haz}));
        stringBuilder.append(String.format("ellipsize: %s ", new Object[]{this.haA}));
        stringBuilder.append(String.format("gravity: %s ", new Object[]{Integer.valueOf(this.gravity)}));
        stringBuilder.append(String.format("ellipsizeWidth: %s ", new Object[]{Integer.valueOf(this.hbc)}));
        stringBuilder.append(String.format("textDirection: %s ", new Object[]{this.haC}));
        stringBuilder.append(String.format("spacingAdd: %s spacingMult: %s ", new Object[]{Float.valueOf(this.haD), Float.valueOf(this.haE)}));
        stringBuilder.append(String.format("includedPad: %b ", new Object[]{Boolean.valueOf(this.haF)}));
        stringBuilder.append(String.format("typeface: %s ", new Object[]{this.hbd}));
        stringBuilder.append(String.format("fontStyle: %d ", new Object[]{Integer.valueOf(this.hbe)}));
        stringBuilder.append(String.format("textSize: %s ", new Object[]{Float.valueOf(this.hbf)}));
        stringBuilder.append(String.format("textColor: %d", new Object[]{Integer.valueOf(this.textColor)}));
        stringBuilder.append(String.format("linkColor: %d", new Object[]{Integer.valueOf(this.linkColor)}));
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int i = ((this.maxLines * 31) + 0) + (this.maxLength * 31);
        if (this.haK != null) {
            i += this.haK.hashCode() * 31;
        }
        i += this.haz.hashCode() * 31;
        if (this.haA != null) {
            i += this.haA.hashCode() * 31;
        }
        i = (i + (this.gravity * 31)) + (this.hbc * 31);
        if (this.haC != null) {
            i += this.haC.hashCode() * 31;
        }
        i = ((this.haF ? 1 : 0) * 31) + ((int) (((float) ((int) (((float) i) + (this.haD * 31.0f)))) + (this.haE * 31.0f)));
        if (this.hbd != null) {
            i += this.hbd.hashCode() * 31;
        }
        return (((int) (((float) (i + (this.hbe * 31))) + (this.hbf * 31.0f))) + (this.textColor * 31)) + (this.linkColor * 31);
    }
}
