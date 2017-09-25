package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.SpannableString;

public interface d {

    public static class a {
        protected static d sTj;

        public static final void a(d dVar) {
            sTj = dVar;
        }
    }

    SpannableString b(Context context, CharSequence charSequence, int i);

    boolean x(CharSequence charSequence);

    boolean y(CharSequence charSequence);
}
