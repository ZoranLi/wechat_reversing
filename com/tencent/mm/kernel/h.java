package com.tencent.mm.kernel;

import android.app.Application;
import com.tencent.mm.a.o;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ac;
import com.tencent.mm.u.br;
import com.tencent.mm.y.n;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class h {
    private static h gYI;
    public final a gXB = new a();
    public final b gXX = new b();
    public final c gXY = new c();
    public final a gXZ = new a();
    public i<f> gYJ;
    private af gYK;
    private br gYL = null;
    public e gYM;
    public a gYN;
    public b gYO;
    public final a gYP = new a();
    public final b gYQ = new b();
    public final List<ac> gYR = new ArrayList();
    private final boolean gYS;
    public volatile boolean gYT = false;
    public final List<com.tencent.mm.kernel.api.a> gYc = new ArrayList();

    private static class a extends com.tencent.mm.bn.a<c> implements c {
        public final void onAccountInitialized(final e.f fVar) {
            a(new com.tencent.mm.bn.a.a<c>(this) {
                final /* synthetic */ a gYX;

                public final /* synthetic */ void ao(Object obj) {
                    ((c) obj).onAccountInitialized(fVar);
                }
            });
        }

        public final void onAccountRelease() {
            a(new com.tencent.mm.bn.a.a<c>(this) {
                final /* synthetic */ a gYX;

                {
                    this.gYX = r1;
                }

                public final /* synthetic */ void ao(Object obj) {
                    ((c) obj).onAccountRelease();
                }
            });
        }
    }

    private static class b extends com.tencent.mm.bn.a<com.tencent.mm.y.n.a> implements com.tencent.mm.y.n.a {
        public final void a(final n nVar, final boolean z) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.y.n.a>(this) {
                final /* synthetic */ b gZa;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.y.n.a) obj).a(nVar, z);
                }
            });
        }

        public final void a(final n nVar) {
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.y.n.a>(this) {
                final /* synthetic */ b gZa;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.y.n.a) obj).a(nVar);
                }
            });
        }
    }

    private h(final f fVar) {
        this.gYJ = i.b((e) fVar);
        this.gYS = ((f) this.gYJ.vF().vj()).ej("");
        if (this.gYS) {
            this.gYL = new br();
            this.gYK = new af();
            this.gYK.D(new Runnable(this) {
                final /* synthetic */ h gYU;

                {
                    this.gYU = r1;
                }

                public final void run() {
                    am.ei(ab.getContext());
                }
            });
        }
        i.vE().gXS = new com.tencent.mm.kernel.c.a(this) {
            final /* synthetic */ h gYU;

            public final void b(d dVar) {
                this.gYU.a(fVar, (Object) dVar);
            }

            public final void a(com.tencent.mm.kernel.c.a aVar) {
                this.gYU.a(fVar, (Object) aVar);
            }

            public final void b(com.tencent.mm.kernel.c.a aVar) {
                h hVar = this.gYU;
                f fVar = fVar;
                if (aVar instanceof ApplicationLifeCycle) {
                    fVar.gZB.remove((ApplicationLifeCycle) aVar);
                }
                if (aVar instanceof c) {
                    hVar.gYP.remove((c) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.a) {
                    hVar.gYc.remove(aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.b) {
                    hVar.gXZ.remove((com.tencent.mm.kernel.api.b) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.e) {
                    hVar.gXX.remove((com.tencent.mm.kernel.api.e) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.f) {
                    hVar.gXY.remove((com.tencent.mm.kernel.api.f) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.d) {
                    hVar.gXB.remove((com.tencent.mm.kernel.api.d) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.h) {
                    hVar.gYJ.b((com.tencent.mm.kernel.api.h) aVar);
                }
                if (aVar instanceof ac) {
                    hVar.gYR.remove(aVar);
                }
            }
        };
    }

    public final void a(f fVar, Object obj) {
        if (obj instanceof ApplicationLifeCycle) {
            fVar.gZB.bI((ApplicationLifeCycle) obj);
        }
        if (obj instanceof c) {
            this.gYP.bI((c) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.a) {
            this.gYc.add((com.tencent.mm.kernel.api.a) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.b) {
            this.gXZ.bI((com.tencent.mm.kernel.api.b) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.e) {
            this.gXX.bI((com.tencent.mm.kernel.api.e) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.f) {
            this.gXY.bI((com.tencent.mm.kernel.api.f) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.d) {
            this.gXB.bI((com.tencent.mm.kernel.api.d) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.h) {
            this.gYJ.a((com.tencent.mm.kernel.api.h) obj);
        }
        if (obj instanceof ac) {
            this.gYR.add((ac) obj);
        }
    }

    public final void a(com.tencent.mm.kernel.api.h hVar) {
        this.gYJ.a(hVar);
    }

    public final void b(com.tencent.mm.kernel.api.h hVar) {
        this.gYJ.b(hVar);
    }

    public static c vE() {
        vJ();
        Assert.assertNotNull("mCorePlugins not initialized!", i.vE());
        vJ();
        return i.vE();
    }

    public static d<f> vF() {
        Assert.assertNotNull("mCoreProcess not initialized!", vJ().gYJ.vF());
        return vJ().gYJ.vF();
    }

    public static a vG() {
        Assert.assertNotNull("mCoreAccount not initialized!", vJ().gYN);
        return vJ().gYN;
    }

    public static b vH() {
        Assert.assertNotNull("mCoreNetwork not initialized!", vJ().gYO);
        return vJ().gYO;
    }

    public static e vI() {
        Assert.assertNotNull("mCoreStorage not initialized!", vJ().gYM);
        return vJ().gYM;
    }

    public static h vJ() {
        Assert.assertNotNull("Kernel not initialized by MMApplication!", gYI);
        return gYI;
    }

    public static <T extends com.tencent.mm.kernel.b.a> T j(Class<T> cls) {
        vJ();
        return vE().j(cls);
    }

    public static <T extends com.tencent.mm.kernel.c.a> T h(Class<T> cls) {
        vJ();
        return vE().h(cls);
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, N n) {
        vJ();
        vE().a(cls, new com.tencent.mm.kernel.c.c(n));
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.b<N> bVar) {
        vJ();
        vE().a(cls, bVar);
    }

    public static n vd() {
        vJ();
        return vH().gXC;
    }

    public static br vK() {
        Assert.assertTrue(vJ().gYS);
        return vJ().gYL;
    }

    public static af vL() {
        Assert.assertTrue(vJ().gYS);
        return vJ().gYK;
    }

    public static synchronized void a(String str, Application application, MMApplicationLike mMApplicationLike) {
        synchronized (h.class) {
            if (gYI != null) {
                f fVar = (f) gYI.gYJ.vF().vj();
                fVar.gZA = mMApplicationLike;
                fVar.gZz = application;
                w.i("MicroMsg.MMKernel", "Kernel not null, has initialized.");
            } else {
                j.a(new com.tencent.mm.kernel.j.a() {
                    public final void e(String str, String str2, Object... objArr) {
                        w.e(str, str2, objArr);
                    }

                    public final void w(String str, String str2, Object... objArr) {
                        w.w(str, str2, objArr);
                    }

                    public final void i(String str, String str2, Object... objArr) {
                        w.i(str, str2, objArr);
                    }

                    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                        w.printErrStackTrace(str, th, str2, objArr);
                    }
                });
                w.i("MicroMsg.MMKernel", "Initialize kernel, create whole WeChat world.");
                gYI = new h(new f(str, application, mMApplicationLike));
            }
        }
    }

    public static void eO(int i) {
        a vG = vG();
        if (a.eL(i) && a.gXg.uH() == i && vG.uV()) {
            w.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", Integer.valueOf(i));
            return;
        }
        synchronized (vG.gXf) {
            a.gXg.dj(i);
            vG.uN();
            vG.aP(true);
        }
    }

    public final void eh(String str) {
        w.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", o.getString(a.uH()), str, bg.bJZ());
        a.eb(bg.bJZ().toString() + str);
        this.gYN.gXc.T((long) a.uH());
        releaseAll();
        a.uL();
        a.aQ(false);
    }

    public final void releaseAll() {
        String str = "MicroMsg.MMKernel";
        String str2 = "release uin:%s ";
        Object[] objArr = new Object[1];
        objArr[0] = this.gYN != null ? o.getString(a.uH()) : "-1";
        w.w(str, str2, objArr);
        if (this.gYO.gXC != null) {
            this.gYO.gXC.reset();
        }
        if (this.gYK != null) {
            this.gYK.a(new com.tencent.mm.sdk.platformtools.af.b(this) {
                final /* synthetic */ h gYU;

                {
                    this.gYU = r1;
                }

                public final void vM() {
                    if (this.gYU.gYN != null) {
                        this.gYU.gYN.release();
                    }
                }
            });
        }
    }
}
