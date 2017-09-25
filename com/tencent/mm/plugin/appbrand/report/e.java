package com.tencent.mm.plugin.appbrand.report;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends d {
    public long jfZ;
    public long jga;
    private final c jgb = new c(this);
    public final b jgc = new b(this);
    public final a jgd = new a(this);
    public boolean pQ = false;

    private final class a extends c {
        private long jge;
        final /* synthetic */ e jgf;

        public a(e eVar) {
            this.jgf = eVar;
        }

        public final String getName() {
            return this.jgf.mName + "|Background";
        }

        public final boolean f(Message message) {
            if (2 != message.what) {
                return super.f(message);
            }
            this.jgf.b(this.jgf.jgc);
            return true;
        }

        public final void enter() {
            super.enter();
            this.jge = bg.Nz();
        }

        public final void exit() {
            super.exit();
            this.jgf.jfZ = bg.Nz() - this.jge;
        }
    }

    private final class b extends c {
        final /* synthetic */ e jgf;
        private long jgg;

        public b(e eVar) {
            this.jgf = eVar;
        }

        public final String getName() {
            return this.jgf.mName + "|Foreground";
        }

        public final boolean f(Message message) {
            if (1 != message.what) {
                return super.f(message);
            }
            this.jgf.b(this.jgf.jgd);
            return true;
        }

        public final void enter() {
            super.enter();
            this.jgg = bg.Nz();
        }

        public final void exit() {
            super.exit();
            this.jgf.jga = bg.Nz() - this.jgg;
        }
    }

    private final class c extends c {
        final /* synthetic */ e jgf;

        public c(e eVar) {
            this.jgf = eVar;
        }

        public final String getName() {
            return this.jgf.mName + "|Init";
        }

        public final boolean f(Message message) {
            if (2 == message.what) {
                this.jgf.b(this.jgf.jgc);
                return true;
            } else if (1 != message.what) {
                return super.f(message);
            } else {
                this.jgf.b(this.jgf.jgd);
                return true;
            }
        }
    }

    public e(String str) {
        super("MicroMsg.StayingRecorder[" + str + "]", Looper.getMainLooper());
        b(this.jgc);
        b(this.jgd);
        b(this.jgb);
        c(this.jgb);
        start();
    }

    public final void Wt() {
        w.d(this.mName, "toForeground");
        hx(2);
    }

    public final void Wu() {
        w.d(this.mName, "toBackground");
        hx(1);
    }

    private void hx(int i) {
        if (bKh() == null) {
            yw(i);
        } else {
            yx(i);
        }
    }

    public final void start() {
        if (!this.pQ) {
            super.start();
        }
    }
}
