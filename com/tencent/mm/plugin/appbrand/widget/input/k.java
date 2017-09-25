package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

final class k extends PasswordTransformationMethod {

    private static final class a implements CharSequence {
        private CharSequence jtB;

        a(CharSequence charSequence) {
            this.jtB = charSequence;
        }

        public final int length() {
            return this.jtB.length();
        }

        public final char charAt(int i) {
            return '●';
        }

        public final CharSequence subSequence(int i, int i2) {
            return this.jtB.subSequence(i, i2);
        }
    }

    k() {
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        return new a(charSequence);
    }
}
