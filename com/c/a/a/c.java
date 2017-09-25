package com.c.a.a;

import android.os.Handler;

abstract class c extends d {
    private boolean aJh;

    abstract void nf();

    abstract void ng();

    c() {
    }

    synchronized void a(Handler handler, a aVar) {
        this.aJh = false;
        super.a(handler, aVar);
    }

    final synchronized void ah(boolean z) {
        if ((this.aJh ^ z) != 0) {
            this.aJh = z;
            if (this.aJh) {
                nf();
            } else {
                ng();
            }
        }
    }
}
