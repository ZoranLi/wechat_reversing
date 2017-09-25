package com.tencent.mm.bi;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.pluginsdk.ui.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bg;

public final class g implements d {
    private static g uyO;
    private int uyN = e.CTRL_INDEX;

    private g() {
    }

    public static g bKH() {
        if (uyO == null) {
            uyO = new g();
        }
        return uyO;
    }

    public final SpannableString b(Context context, CharSequence charSequence, int i) {
        if (charSequence == null || bg.mA(charSequence.toString())) {
            return new SpannableString("");
        }
        if (charSequence == null || bg.mA(charSequence.toString())) {
            return new SpannableString("");
        }
        charSequence = charSequence instanceof SpannableString ? (SpannableString) charSequence : new SpannableString(charSequence);
        PInt pInt = new PInt();
        pInt.value = this.uyN;
        return f.bKE().a(b.bKy().a(charSequence, i, pInt), i, pInt.value);
    }

    public final SpannableString d(Context context, CharSequence charSequence, float f) {
        if (charSequence == null || bg.mA(charSequence.toString())) {
            return new SpannableString("");
        }
        return b(context, charSequence, (int) f);
    }

    public final boolean x(CharSequence charSequence) {
        return f.bKE().Qz(charSequence.toString()) != null;
    }

    public final boolean y(CharSequence charSequence) {
        b.bKy();
        return b.Qx(charSequence.toString());
    }
}
