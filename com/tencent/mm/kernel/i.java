package com.tencent.mm.kernel;

import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class i<_Profile extends e> {
    private static i gZb;
    private c gZc = new c();
    private d<_Profile> gZd;
    public byte[] gZe = new byte[0];
    public volatile boolean gZf = false;
    public a gZg = new a();

    class AnonymousClass1 implements b<Void> {
        final /* synthetic */ long gKe;
        final /* synthetic */ i gZh;

        public AnonymousClass1(i iVar, long j) {
            this.gZh = iVar;
            this.gKe = j;
        }

        public final /* synthetic */ void ar(Object obj) {
            synchronized (this.gZh.gZe) {
                this.gZh.gZf = true;
            }
            com.tencent.mm.kernel.a.a.a("summerboot mmskeleton boot startup finished in [%s]!", com.tencent.mm.kernel.a.a.H(this.gKe));
            this.gZh.gZg.oh();
        }
    }

    private static class a extends com.tencent.mm.bn.a<h> implements h {
        public a() {
            super(d.wDA);
        }

        public final void oh() {
            a(new com.tencent.mm.bn.a.a<h>(this) {
                final /* synthetic */ a gZi;

                {
                    this.gZi = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((h) obj).oh();
                }
            });
        }

        public final void ak(final boolean z) {
            a(new com.tencent.mm.bn.a.a<h>(this) {
                final /* synthetic */ a gZi;

                public final /* synthetic */ void ao(Object obj) {
                    ((h) obj).ak(z);
                }
            });
        }
    }

    private i(_Profile _Profile) {
        this.gZd = new d(_Profile);
    }

    public static c vE() {
        Assert.assertNotNull("mCorePlugins not initialized!", vN().gZc);
        return vN().gZc;
    }

    public final d<_Profile> vF() {
        Assert.assertNotNull("mCoreProcess not initialized!", vN().gZd);
        return this.gZd;
    }

    public static <_Profile extends e> i<_Profile> vN() {
        Assert.assertNotNull("Skeleton not initialized!", gZb);
        return gZb;
    }

    public final void a(h hVar) {
        Object obj = null;
        synchronized (this.gZe) {
            if (this.gZf) {
                obj = 1;
            }
        }
        if (obj != null) {
            hVar.oh();
        } else {
            this.gZg.bI(hVar);
        }
    }

    public final void b(h hVar) {
        this.gZg.remove(hVar);
    }

    public static synchronized <_Profile extends e> i<_Profile> b(_Profile _Profile) {
        i<_Profile> iVar;
        synchronized (i.class) {
            if (gZb != null) {
                j.i("MicroMsg.MMSkeleton", "Kernel not null, has initialized.", new Object[0]);
                iVar = gZb;
            } else {
                j.i("MicroMsg.MMSkeleton", "Initialize skeleton, create whole world.", new Object[0]);
                iVar = new i(_Profile);
                gZb = iVar;
            }
        }
        return iVar;
    }
}
