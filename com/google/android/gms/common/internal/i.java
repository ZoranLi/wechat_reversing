package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;

public final class i implements OnClickListener {
    private final Intent PC;
    private final Fragment aqr;
    private final int aqs;
    private final Activity qb;

    public i(Activity activity, Intent intent, int i) {
        this.qb = activity;
        this.aqr = null;
        this.PC = intent;
        this.aqs = 2;
    }

    public i(Fragment fragment, Intent intent, int i) {
        this.qb = null;
        this.aqr = fragment;
        this.PC = intent;
        this.aqs = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.PC != null && this.aqr != null) {
                this.aqr.startActivityForResult(this.PC, this.aqs);
            } else if (this.PC != null) {
                this.qb.startActivityForResult(this.PC, this.aqs);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
        }
    }
}
