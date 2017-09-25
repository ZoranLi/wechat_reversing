package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import java.util.Locale;

final class c implements Formatter {
    final StringBuilder mBuilder = new StringBuilder();
    char wzp;
    java.util.Formatter wzq;
    final Object[] wzr = new Object[1];

    c() {
        d(Locale.getDefault());
    }

    private void d(Locale locale) {
        this.wzq = new java.util.Formatter(this.mBuilder, locale);
        this.wzp = '0';
    }

    public final String format(int i) {
        Locale locale = Locale.getDefault();
        if (this.wzp != '0') {
            d(locale);
        }
        this.wzr[0] = Integer.valueOf(i);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.wzq.format("%02d", this.wzr);
        return this.wzq.toString();
    }
}
