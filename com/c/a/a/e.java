package com.c.a.a;

import android.os.Handler;

abstract class e {
    private a aJm;
    public long aJn;
    public final Handler handler;

    private class a implements Runnable {
        boolean aJo;
        final /* synthetic */ e aJp;
        boolean started;

        public a(e eVar) {
            this.aJp = eVar;
        }

        public final void run() {
            if (!this.aJo) {
                this.aJp.ni();
                this.aJp.handler.postDelayed(this, this.aJp.aJn);
            }
        }
    }

    abstract void ni();

    e(Handler handler) {
        if (handler == null) {
            handler = new Handler();
        }
        this.handler = handler;
    }

    final void b(long j, long j2) {
        stop();
        this.aJn = j;
        this.aJm = new a(this);
        Object obj = this.aJm;
        if (!obj.started && !obj.aJo) {
            obj.aJp.handler.postDelayed(obj, j2);
            obj.started = true;
        }
    }

    final void stop() {
        if (this.aJm != null) {
            Runnable runnable = this.aJm;
            runnable.aJo = true;
            runnable.aJp.handler.removeCallbacks(runnable);
        }
    }
}
