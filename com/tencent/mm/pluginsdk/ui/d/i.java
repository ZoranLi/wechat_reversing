package com.tencent.mm.pluginsdk.ui.d;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;

public final class i implements GetChars, Spannable, CharSequence {
    private SpannableString sTz;

    public i() {
        this.sTz = null;
        this.sTz = new SpannableString("");
    }

    public i(CharSequence charSequence) {
        this.sTz = null;
        this.sTz = new SpannableString(charSequence);
    }

    public i(String str) {
        this.sTz = null;
        this.sTz = new SpannableString(str);
    }

    public i(SpannableString spannableString) {
        this.sTz = null;
        this.sTz = spannableString;
    }

    public final void a(Object obj, CharSequence charSequence, int i, int i2) {
        a(obj, i, charSequence.length() + i, 33);
    }

    public final void f(Object obj, CharSequence charSequence) {
        a(obj, charSequence, 0, 33);
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        a(obj, i, i2, i3);
    }

    private void a(Object obj, int i, int i2, int i3) {
        if (i >= 0 && i2 <= this.sTz.length()) {
            this.sTz.setSpan(obj, i, i2, i3);
        }
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.sTz.getSpans(i, i2, cls);
    }

    public final int getSpanStart(Object obj) {
        return this.sTz.getSpanStart(obj);
    }

    public final int getSpanEnd(Object obj) {
        return this.sTz.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.sTz.getSpanFlags(obj);
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.sTz.nextSpanTransition(i, i2, cls);
    }

    public final int length() {
        return this.sTz.length();
    }

    public final char charAt(int i) {
        return this.sTz.charAt(i);
    }

    public final CharSequence subSequence(int i, int i2) {
        return this.sTz.subSequence(i, i2);
    }

    public final void removeSpan(Object obj) {
        this.sTz.removeSpan(obj);
    }

    public final void getChars(int i, int i2, char[] cArr, int i3) {
        this.sTz.getChars(i, i2, cArr, i3);
    }

    public final String toString() {
        return this.sTz.toString();
    }
}
