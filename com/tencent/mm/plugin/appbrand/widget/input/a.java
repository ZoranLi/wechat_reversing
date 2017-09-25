package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.a.c;
import com.tencent.mm.plugin.appbrand.widget.input.a.g;
import com.tencent.mm.plugin.appbrand.widget.input.a.h;
import com.tencent.mm.sdk.platformtools.bg;

enum a {
    ;

    static <Input extends EditText & y> void a(Input input, h hVar) {
        if (input != null && hVar != null) {
            if (!(hVar.jxh == null || ((float) hVar.jxh.intValue()) == input.getTextSize())) {
                input.setTextSize((float) hVar.jxh.intValue());
            }
            if (hVar.jxg != null) {
                input.setTextColor(hVar.jxg.intValue());
            }
            if (!(hVar.jxf == null || (input.getBackground() != null && (input.getBackground() instanceof ColorDrawable) && ((ColorDrawable) input.getBackground()).getColor() == hVar.jxf.intValue()))) {
                input.setBackground(new ColorDrawable(hVar.jxf.intValue()));
            }
            if (!bg.mA(hVar.jxl)) {
                CharSequence spannableStringBuilder = new SpannableStringBuilder(hVar.jxl);
                int length = hVar.jxl.length();
                spannableStringBuilder.setSpan(new StyleSpan(c.rr(hVar.jxm).style), 0, length, 18);
                if (hVar.jxo != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(hVar.jxo.intValue()), 0, length, 18);
                }
                if (hVar.jxn != null) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(hVar.jxn.intValue(), false), 0, length, 18);
                }
                input.setHint(spannableStringBuilder);
            }
            if (hVar.jxj != null) {
                Typeface create = Typeface.create("sans-serif", c.rr(hVar.jxj).style);
                if (create != null) {
                    input.setTypeface(create);
                }
            }
            g.rs(hVar.jxe).a((y) input);
            if (hVar.jxq == null || !hVar.jxq.booleanValue()) {
                input.setVisibility(0);
            } else {
                input.setVisibility(8);
            }
            if (hVar.jxu != null && hVar.jxu.booleanValue()) {
                ((y) input).cA(true);
            }
        }
    }
}
