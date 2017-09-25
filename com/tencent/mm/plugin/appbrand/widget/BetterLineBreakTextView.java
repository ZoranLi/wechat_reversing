package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint({"AppCompatCustomView"})
class BetterLineBreakTextView extends TextView {
    private int jri;
    private int jrj;

    public BetterLineBreakTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        Paint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.jrj = getMeasuredWidth();
        Object charSequence = getText().toString();
        this.jri = 0;
        this.jri = (int) (((float) this.jri) + getTextSize());
        Layout layout = getLayout();
        if (layout != null) {
            FontMetrics fontMetrics = paint.getFontMetrics();
            int ceil = (int) ((((float) ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent)))) * layout.getSpacingMultiplier()) + layout.getSpacingAdd());
            int i = 0;
            while (i < layout.getLineCount()) {
                int lineStart = layout.getLineStart(i);
                int lineEnd = layout.getLineEnd(i);
                float desiredWidth = StaticLayout.getDesiredWidth(charSequence, lineStart, lineEnd, getPaint());
                String substring = charSequence.substring(lineStart, lineEnd);
                Object obj = (substring == null || substring.length() == 0) ? null : substring.charAt(substring.length() + -1) != '\n' ? 1 : null;
                if (obj == null || i >= layout.getLineCount() - 1) {
                    canvas.drawText(substring, 0.0f, (float) this.jri, paint);
                } else {
                    float desiredWidth2;
                    float f;
                    float f2 = 0.0f;
                    Object obj2 = (substring.length() > 3 && substring.charAt(0) == ' ' && substring.charAt(1) == ' ') ? 1 : null;
                    if (obj2 != null) {
                        CharSequence charSequence2 = "  ";
                        canvas.drawText(charSequence2, 0.0f, (float) this.jri, getPaint());
                        f2 = StaticLayout.getDesiredWidth(charSequence2, getPaint()) + 0.0f;
                        substring = substring.substring(3);
                    }
                    int length = substring.length() - 1;
                    if (substring.length() > 2 && substring.charAt(0) == '　' && substring.charAt(1) == '　') {
                        obj2 = substring.substring(0, 2);
                        desiredWidth2 = StaticLayout.getDesiredWidth(obj2, getPaint());
                        canvas.drawText(obj2, f2, (float) this.jri, getPaint());
                        f = f2 + desiredWidth2;
                        lineStart = 2;
                    } else {
                        f = f2;
                        lineStart = 0;
                    }
                    desiredWidth = (((float) this.jrj) - desiredWidth) / ((float) length);
                    for (lineStart = 
/*
Method generation error in method: com.tencent.mm.plugin.appbrand.widget.BetterLineBreakTextView.onDraw(android.graphics.Canvas):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_22 'lineStart' int) = (r1_21 'lineStart' int), (r1_25 'lineStart' int) binds: {(r1_21 'lineStart' int)=B:28:0x00d8, (r1_25 'lineStart' int)=B:40:0x0147} in method: com.tencent.mm.plugin.appbrand.widget.BetterLineBreakTextView.onDraw(android.graphics.Canvas):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:128)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:217)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 31 more

*/
                }
