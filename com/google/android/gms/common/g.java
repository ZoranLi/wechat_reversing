package com.google.android.gms.common;

import android.content.Intent;

public class g extends Exception {
    public final Intent PC;

    public g(String str, Intent intent) {
        super(str);
        this.PC = intent;
    }
}
