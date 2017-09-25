package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.h;
import android.support.v4.app.l;
import com.google.android.gms.common.internal.w;

public final class f extends h {
    private OnCancelListener amb = null;
    private Dialog oL = null;

    public static f b(Dialog dialog, OnCancelListener onCancelListener) {
        f fVar = new f();
        Dialog dialog2 = (Dialog) w.h(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        fVar.oL = dialog2;
        if (onCancelListener != null) {
            fVar.amb = onCancelListener;
        }
        return fVar;
    }

    public final void a(l lVar, String str) {
        super.a(lVar, str);
    }

    public final Dialog aF() {
        if (this.oL == null) {
            this.oJ = false;
        }
        return this.oL;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.amb != null) {
            this.amb.onCancel(dialogInterface);
        }
    }
}
