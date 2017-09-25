package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.widget.e.a;

@SuppressLint({"AppCompatCustomView"})
public final class g extends TextView implements e {
    private boolean jqC;
    public a jrg;

    public g(Context context) {
        super(context);
        super.setIncludeFontPadding(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setSpannableFactory(new Factory(this) {
            final /* synthetic */ g jrh;

            {
                this.jrh = r1;
            }

            public final Spannable newSpannable(CharSequence charSequence) {
                Spannable newSpannable = super.newSpannable(charSequence);
                if (!(this.jrh.jrg == null || TextUtils.isEmpty(newSpannable))) {
                    newSpannable.setSpan(this.jrh.jrg, 0, newSpannable.length(), 18);
                }
                return newSpannable;
            }
        });
    }

    public final void setText(CharSequence charSequence, BufferType bufferType) {
        if (bufferType == BufferType.NORMAL) {
            bufferType = BufferType.SPANNABLE;
        }
        super.setText(charSequence, bufferType);
    }

    public final boolean Tt() {
        return this.jqC;
    }
}
