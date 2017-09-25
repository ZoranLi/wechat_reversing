package com.tencent.mm.kernel;

import com.tencent.mm.kernel.api.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ad;
import com.tencent.mm.y.n;
import com.tencent.mm.y.u;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    private static ad gXF = null;
    public final a gXB;
    public final n gXC;
    public HashSet<m> gXD = new HashSet();
    public m gXE = new com.tencent.mm.network.m.a(this) {
        final /* synthetic */ b gXG;

        {
            this.gXG = r1;
        }

        public final void cU(int i) {
            try {
                HashSet hashSet = new HashSet();
                synchronized (this.gXG.gXD) {
                    hashSet.addAll(this.gXG.gXD);
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).cU(i);
                }
            } catch (final Throwable e) {
                w.printErrStackTrace("MMKernel.CoreNetwork", e, "onNetworkChange caught crash", new Object[0]);
                new ae().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 gXI;

                    public final void run() {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    };

    static class a extends com.tencent.mm.bn.a<d> implements d {
        a() {
        }

        public final void b(final e eVar) {
            a(new com.tencent.mm.bn.a.a<d>(this) {
                final /* synthetic */ a gXL;

                public final /* synthetic */ void ao(Object obj) {
                    ((d) obj).b(eVar);
                }
            });
        }
    }

    public b(com.tencent.mm.y.n.a aVar, a aVar2) {
        this.gXC = n.a(aVar);
        this.gXC.hta = h.vL();
        u.htQ = new com.tencent.mm.y.u.b(this) {
            final /* synthetic */ b gXG;

            {
                this.gXG = r1;
            }

            public final n ve() {
                return this.gXG.gXC;
            }
        };
        this.gXB = aVar2;
    }

    public final void a(m mVar) {
        synchronized (this.gXD) {
            this.gXD.add(mVar);
        }
    }

    public final void b(m mVar) {
        synchronized (this.gXD) {
            this.gXD.remove(mVar);
        }
    }

    public static ad vb() {
        return gXF;
    }

    public static void a(ad adVar) {
        gXF = adVar;
    }

    public final byte[] vc() {
        byte[] bArr = null;
        try {
            if (!(this.gXC == null || this.gXC.hsZ == null || this.gXC.hsZ.Cc() == null)) {
                bArr = this.gXC.hsZ.Cc().vc();
            }
        } catch (Throwable e) {
            w.w("MMKernel.CoreNetwork", "get session key error, %s", e.getMessage());
            w.e("MMKernel.CoreNetwork", "exception:%s", bg.g(e));
        }
        return bArr;
    }

    public final n vd() {
        return this.gXC;
    }
}
