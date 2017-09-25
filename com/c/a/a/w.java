package com.c.a.a;

import android.content.Context;
import android.os.Handler;

final class w extends n {
    private static w aOU;
    private boolean aOV;
    private int aOW;
    private long aOX;
    private long aOY;

    static w nI() {
        if (aOU == null) {
            aOU = new w();
        }
        return aOU;
    }

    w() {
    }

    final void a(Context context, Handler handler, a aVar) {
        if (this.aOV) {
            if (k.nl().isReady) {
                k.nl().nh();
            }
        } else if (!k.nl().isReady) {
            try {
                k.nl().a(context, this);
            } catch (Exception e) {
            }
        }
        super.a(context, handler, aVar);
    }

    final synchronized void a(Handler handler, a aVar) {
        this.aOV = false;
        super.a(handler, aVar);
    }

    public final void a(p pVar) {
        Object obj;
        long j = pVar.aMb;
        if (!this.aOV || j - this.aOY <= this.aOX) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj == null) {
            super.a(pVar);
        }
    }

    final void a(x xVar, long j, long j2) {
        Object obj;
        if (xVar.aPd == null) {
            xVar.aPd = new a();
        }
        float f = xVar.aPd.aPg;
        if (!this.aOV || f < ((float) this.aOW)) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj == null) {
            super.a(xVar, j, j2);
        }
    }

    final void a(int i, String str, long j, long j2) {
        if (this.aOV) {
            stop();
        }
        super.a(i, str, j, j2);
    }
}
