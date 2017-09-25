package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c extends h {
    public final String TAG = this.mName;
    public final ae iAo = new ae(Looper.getMainLooper());
    public final d iAp;
    public final a iAq;
    public final e iAr;
    public final c iAs;
    public final b iAt;
    public final AtomicBoolean iAu = new AtomicBoolean(false);
    private final AtomicBoolean iAv = new AtomicBoolean(false);
    private final AtomicReference<com.tencent.mm.sdk.d.c> iAw = new AtomicReference(null);
    private final AtomicReference<com.tencent.mm.sdk.d.c> iAx = new AtomicReference(null);
    public final h ixr;

    private final class e extends com.tencent.mm.plugin.appbrand.report.c {
        final /* synthetic */ c iAy;

        public e(c cVar) {
            this.iAy = cVar;
        }

        public final String getName() {
            return this.iAy.mName + "|Suspend";
        }

        public final void enter() {
            super.enter();
            this.iAy.uwt.sendEmptyMessageDelayed(11, ((long) this.iAy.ixr.iwo.iFj) * 1000);
            this.iAy.ixr.iwq.ixt.pause();
        }

        public final void exit() {
            super.exit();
            this.iAy.uwt.removeMessages(11);
            this.iAy.ixr.iwq.ixt.resume();
        }

        public final boolean f(Message message) {
            switch (message.what) {
                case 3:
                    this.iAy.a(this.iAy.iAp);
                    return true;
                case 11:
                    w.i(this.iAy.TAG, "suspend timeout");
                    this.iAy.QC();
                    return true;
                default:
                    return super.f(message);
            }
        }
    }

    private final class b extends g {
        final /* synthetic */ c iAy;

        b(c cVar, h hVar) {
            this.iAy = cVar;
            super(hVar);
        }

        public final String getName() {
            return this.iAy.mName + "|BackgroundByScreenOff";
        }

        public final boolean f(Message message) {
            switch (message.what) {
                case 3:
                    this.iAy.a(this.iAy.iAp);
                    return true;
                default:
                    return super.f(message);
            }
        }
    }

    private final class c extends g {
        final /* synthetic */ c iAy;

        c(c cVar, h hVar) {
            this.iAy = cVar;
            super(hVar);
        }

        public final String getName() {
            return this.iAy.mName + "|BackgroundTemporary";
        }

        public final boolean f(Message message) {
            switch (message.what) {
                case 3:
                    this.iAy.a(this.iAy.iAp);
                    return true;
                case 4:
                    this.iAy.a(this.iAy.iAr);
                    return true;
                case 10:
                    this.iAy.a(this.iAy.iAt);
                    return true;
                default:
                    return super.f(message);
            }
        }

        public final void enter() {
            super.enter();
            this.iAy.uwt.sendEmptyMessageDelayed(4, ((long) this.iAy.ixr.iwo.iFi) * 1000);
        }

        public final void exit() {
            super.exit();
            this.iAy.uwt.removeMessages(4);
        }
    }

    private final class d extends g {
        final /* synthetic */ c iAy;

        d(c cVar, h hVar) {
            this.iAy = cVar;
            super(hVar);
        }

        public final String getName() {
            return this.iAy.mName + "|Foreground";
        }

        public final boolean f(Message message) {
            switch (message.what) {
                case 1:
                    this.iAy.a(this.iAy.iAq);
                    return true;
                default:
                    return super.f(message);
            }
        }

        public final void enter() {
            super.enter();
        }

        public final void exit() {
            super.exit();
        }
    }

    private final class a extends f {
        final /* synthetic */ c iAy;

        a(c cVar, h hVar, h hVar2) {
            this.iAy = cVar;
            super(hVar, hVar2);
        }

        public final String getName() {
            return this.iAy.mName + "|Background";
        }

        public final boolean f(Message message) {
            switch (message.what) {
                case 3:
                    this.iAy.a(this.iAy.iAp);
                    return true;
                case 12:
                    hz(16);
                    return true;
                default:
                    return super.f(message);
            }
        }

        public final void enter() {
            super.enter();
        }

        public final void exit() {
            super.exit();
        }

        final void QF() {
            if (this.iAy.bKi() == this) {
                this.iAy.a(this.iAy.iAs);
                this.iAy.hx(1000);
            }
        }
    }

    abstract void QC();

    public abstract void b(a aVar);

    c(h hVar) {
        super("MicroMsg.AppBrand.AppRunningStateMachine[" + hVar.ivH + "]", Looper.getMainLooper());
        this.ixr = hVar;
        com.tencent.mm.sdk.d.c cVar = new c(this, this);
        this.iAs = cVar;
        b(cVar);
        cVar = new b(this, this);
        this.iAt = cVar;
        b(cVar);
        cVar = new a(this, this, hVar);
        this.iAq = cVar;
        b(cVar);
        cVar = new d(this, this);
        this.iAp = cVar;
        b(cVar);
        cVar = new e(this);
        this.iAr = cVar;
        b(cVar);
        c(this.iAp);
        start();
    }

    public final void start() {
        if (!this.iAu.get()) {
            super.start();
        }
    }

    final void a(g gVar) {
        this.iAw.set(null);
        this.iAx.set(gVar);
        Message bKh = bKh();
        if (bKh == null || bKh.what != -2) {
            b(a((com.tencent.mm.sdk.d.a) gVar));
        }
    }

    public final a QD() {
        if (!this.iAv.get() || af.isMainThread()) {
            return QE();
        }
        return (a) new bb<a>(this) {
            final /* synthetic */ c iAy;

            {
                this.iAy = r1;
            }

            protected final /* synthetic */ Object run() {
                return this.iAy.QE();
            }
        }.b(this.iAo);
    }

    public final a QE() {
        if (this.iAu.get()) {
            return a.DESTROYED;
        }
        com.tencent.mm.sdk.d.a aVar = (com.tencent.mm.sdk.d.c) this.iAw.get();
        if (aVar != null) {
            return a(aVar);
        }
        aVar = (com.tencent.mm.sdk.d.c) this.iAx.get();
        if (aVar != null) {
            return a(aVar);
        }
        if (af.isMainThread()) {
            aVar = super.bKi();
        } else {
            aVar = (com.tencent.mm.sdk.d.a) new bb<com.tencent.mm.sdk.d.a>(this) {
                final /* synthetic */ c iAy;

                {
                    this.iAy = r1;
                }

                protected final /* synthetic */ Object run() {
                    return super.bKi();
                }
            }.b(this.iAo);
        }
        return a(aVar);
    }

    private a a(com.tencent.mm.sdk.d.a aVar) {
        if (aVar == this.iAq || aVar == this.iAs || aVar == this.iAt) {
            return a.BACKGROUND;
        }
        if (aVar == this.iAr) {
            return a.SUSPEND;
        }
        if (aVar == this.iAp) {
            return a.FOREGROUND;
        }
        return a.FOREGROUND;
    }

    public final void a(com.tencent.mm.sdk.d.c cVar) {
        this.iAv.set(false);
        this.iAw.set(cVar);
        this.iAx.set(null);
        super.b((com.tencent.mm.sdk.d.a) cVar);
    }

    public final void hx(int i) {
        this.iAv.set(true);
        if (bKh() == null) {
            super.yw(i);
        } else {
            super.yx(i);
        }
    }

    protected final boolean d(Message message) {
        return message.what != 1000;
    }

    protected final void e(Message message) {
        super.e(message);
        this.iAv.set(false);
    }
}
