package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.NoCopySpan;
import android.text.Spannable;
import android.widget.TextView;

final class ac {

    private static class a implements NoCopySpan {
        public float agA;
        public float agB;
        public int jvE;
        public int jvF;
        public boolean jvG;
        public boolean jvH;
        public boolean jvI;
        @Deprecated
        public boolean jvJ;

        public a(float f, float f2, int i, int i2) {
            this.agA = f;
            this.agB = f2;
            this.jvE = i;
            this.jvF = i2;
        }
    }

    static a[] e(TextView textView) {
        int i = 0;
        a[] aVarArr = null;
        if (textView != null && (textView.getText() instanceof Spannable)) {
            Spannable spannable = (Spannable) textView.getText();
            aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
            int length = aVarArr.length;
            while (i < length) {
                spannable.removeSpan(aVarArr[i]);
                i++;
            }
        }
        return aVarArr;
    }
}
