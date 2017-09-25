package com.google.android.gms.analytics.internal;

import android.util.DisplayMetrics;
import com.google.android.gms.c.al;
import java.util.Locale;

public final class af extends o {
    af(q qVar) {
        super(qVar);
    }

    protected final void hu() {
    }

    public final al iW() {
        ie();
        DisplayMetrics displayMetrics = this.ahK.ih().mContext.getResources().getDisplayMetrics();
        al alVar = new al();
        alVar.aBe = k.c(Locale.getDefault());
        alVar.aBg = displayMetrics.widthPixels;
        alVar.aBh = displayMetrics.heightPixels;
        return alVar;
    }
}
