package com.c.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a extends d implements m {
    private final d[] aJb;
    private final Handler[] aJc = new Handler[this.aJb.length];
    private final a[] aJd = new a[this.aJc.length];

    abstract void a(Handler handler, Handler[] handlerArr);

    abstract void a(a aVar, a[] aVarArr);

    a(d... dVarArr) {
        this.aJb = dVarArr;
    }

    final void O(Context context) {
        for (d a : this.aJb) {
            try {
                a.a(context, this);
            } catch (Exception e) {
            }
        }
    }

    void a(Context context, Handler handler, a aVar) {
        a(handler, this.aJc);
        a(aVar, this.aJd);
        for (int i = 0; i < this.aJb.length; i++) {
            try {
                this.aJb[i].a(this.aJc[i], this.aJd[i]);
            } catch (Exception e) {
            }
        }
    }

    final void P(Context context) {
        for (d stop : this.aJb) {
            stop.stop();
        }
    }

    final void ne() {
        for (d nh : this.aJb) {
            nh.nh();
        }
    }
}
