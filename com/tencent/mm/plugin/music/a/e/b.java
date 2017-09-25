package com.tencent.mm.plugin.music.a.e;

import com.tencent.mm.am.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;

public abstract class b {
    protected a fPd;
    protected h nTU;
    protected i nTV = new i();

    public abstract void BC(String str);

    public abstract boolean aOc();

    public abstract int aOd();

    public abstract String aOe();

    public abstract int getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j);

    public abstract void stop();

    public final void a(h hVar) {
        this.nTU = hVar;
    }

    public final void f(a aVar) {
        this.fPd = aVar;
    }

    protected void fW(final boolean z) {
        if (this.nTU != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ b nTX;

                public final void run() {
                    w.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[]{Boolean.valueOf(z)});
                    this.nTX.nTU.c(this.nTX.fPd, z);
                }
            });
        }
    }

    protected final void onStart() {
        if (this.nTU != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ b nTX;

                {
                    this.nTX = r1;
                }

                public final void run() {
                    w.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[]{Boolean.valueOf(this.nTX.isPlaying())});
                    this.nTX.nTU.c(this.nTX.fPd);
                }
            });
        }
    }

    protected final void qk(final int i) {
        if (this.nTU != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ b nTX;

                public final void run() {
                    if (this.nTX.aOc()) {
                        this.nTX.nTU.d(this.nTX.fPd);
                    }
                }
            });
        }
    }

    protected void fX(final boolean z) {
        if (this.nTU != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ b nTX;

                public final void run() {
                    w.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[]{Boolean.valueOf(z)});
                    this.nTX.nTU.b(this.nTX.fPd, z);
                }
            });
        }
    }
}
