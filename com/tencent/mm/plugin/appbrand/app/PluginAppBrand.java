package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.b.o;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.plugin.appbrand.g.j;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ac;
import com.tencent.mm.u.l;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

@android.support.a.a
public final class PluginAppBrand extends d implements g, ac {

    private static final class a extends l {
        a() {
            super(c.class);
        }

        public final void onAccountInitialized(f fVar) {
            super.onAccountInitialized(fVar);
            b.initialize();
        }
    }

    public final List<ab> getDataTransferList() {
        List linkedList = new LinkedList();
        linkedList.add(new ab(new com.tencent.mm.plugin.appbrand.config.f()) {
            final /* synthetic */ f iEO;

            {
                this.iEO = r1;
            }

            public final void transfer(int i) {
                List list = null;
                if (eX(i)) {
                    w.d("MicroMsg.AppBrandNewContactTransfer", "smoothie recover");
                    if (c.PN() != null) {
                        com.tencent.mm.bj.g PO = c.PN().PO();
                        Cursor a = PO.a("select DISTINCT tbl_name from sqlite_master where tbl_name = 'AppBrandWxaAppInfo'", null, 0);
                        int i2 = (a == null || a.getCount() <= 0) ? 0 : 1;
                        if (a != null) {
                            a.close();
                        }
                        if (i2 != 0) {
                            c.PR();
                            Cursor a2 = new l(PO).izH.a("select * from AppBrandWxaAppInfo", null, 0);
                            if (a2 != null) {
                                list = new LinkedList();
                                if (a2.moveToFirst()) {
                                    do {
                                        m mVar = new m();
                                        mVar.b(a2);
                                        list.add(mVar);
                                    } while (a2.moveToNext());
                                }
                                a2.close();
                            }
                            if (!bg.bV(r0)) {
                                long RF = c.PR().RF();
                                for (m mVar2 : r0) {
                                    if (c.PR().d(mVar2.field_brandId, "appId") == null) {
                                        c.PR().b(f.a(mVar2));
                                    }
                                }
                                c.PR().aD(RF);
                                new e().RD().transfer(637863936);
                            }
                        }
                    }
                }
            }

            public final boolean eX(int i) {
                w.d("MicroMsg.AppBrandNewContactTransfer", "smoothie may start dataTransfer ");
                return i < 637863936;
            }

            public final String getTag() {
                return "MicroMsg.AppBrandNewContactTransfer";
            }
        });
        linkedList.add(new e().RD());
        return linkedList;
    }

    final c getCore() {
        return (c) l.o(c.class);
    }

    public final void installed() {
        alias(g.class);
    }

    public final void dependency() {
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }

    public final void configure(com.tencent.mm.kernel.b.e eVar) {
    }

    public final void execute(com.tencent.mm.kernel.b.e eVar) {
        w.d("MicroMsg.PluginAppBrand", "current process name = %s", new Object[]{((com.tencent.mm.kernel.b.f) h.vF().vj()).gWO});
        h.a(com.tencent.mm.plugin.appbrand.i.c.class, new com.tencent.mm.kernel.c.c(new s()));
        h.a(com.tencent.mm.modelappbrand.e.class, new com.tencent.mm.kernel.c.c(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
        h.a(com.tencent.mm.modelappbrand.h.class, new com.tencent.mm.kernel.c.c(new com.tencent.mm.plugin.appbrand.share.a.a()));
        h.a(com.tencent.mm.plugin.appbrand.i.d.class, new com.tencent.mm.kernel.c.c(new com.tencent.mm.plugin.appbrand.launching.a.f()));
        if (isAppBrandProcess()) {
            MMToClientEvent.a(new com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a() {
                public final void aF(Object obj) {
                    if (obj instanceof AppBrandLaunchErrorAction) {
                        AppBrandLaunchErrorAction appBrandLaunchErrorAction = (AppBrandLaunchErrorAction) obj;
                        com.tencent.mm.plugin.appbrand.h mW = com.tencent.mm.plugin.appbrand.b.mW(appBrandLaunchErrorAction.appId);
                        if (mW != null && appBrandLaunchErrorAction.iPk == mW.iwn.izM) {
                            Context context;
                            com.tencent.mm.plugin.appbrand.h Ps = mW.Ps();
                            mW.finish();
                            if (Ps == null) {
                                context = com.tencent.mm.sdk.platformtools.ab.getContext();
                            } else {
                                j jVar = Ps.iwr;
                                if (jVar != null) {
                                    MMActivity mMActivity = (MMActivity) jVar.getContext();
                                    if (!mMActivity.isFinishing()) {
                                        if (mMActivity.uSW) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            appBrandLaunchErrorAction.by(context);
                        }
                    }
                }
            });
        }
        if (eVar.ej("")) {
            h.a(a.class, new com.tencent.mm.kernel.c.c(new a()));
            h.a(com.tencent.mm.plugin.appbrand.i.a.class, new com.tencent.mm.kernel.c.c(new b()));
            h.a(com.tencent.mm.plugin.appbrand.i.b.class, new com.tencent.mm.kernel.c.c(new n()));
            h.a(com.tencent.mm.plugin.appbrand.i.e.class, new com.tencent.mm.kernel.c.c(new o()));
            com.tencent.mm.pluginsdk.b.b.a(new com.tencent.mm.plugin.appbrand.c(), new String[]{"//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxatest", "//localwxalibrary"});
            com.tencent.mm.pluginsdk.b.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[]{"//widget"});
            h.vJ().a(new com.tencent.mm.kernel.api.h(this) {
                final /* synthetic */ PluginAppBrand ixL;

                {
                    this.ixL = r1;
                }

                public final void oh() {
                    com.tencent.mm.plugin.appbrand.ui.banner.b.Xk();
                    ((com.tencent.mm.modelappbrand.e) h.h(com.tencent.mm.modelappbrand.e.class)).initialize();
                }

                public final void ak(boolean z) {
                    ((com.tencent.mm.modelappbrand.e) h.h(com.tencent.mm.modelappbrand.e.class)).shutdown();
                    ((com.tencent.mm.modelappbrand.e) h.h(com.tencent.mm.modelappbrand.e.class)).AM().exit();
                }
            });
        } else if (com.tencent.mm.sdk.platformtools.ab.bJd()) {
            b.initialize();
        }
    }

    public final String name() {
        return "plugin-appbrand";
    }

    public static boolean isAppBrandProcess() {
        try {
            return ((com.tencent.mm.kernel.b.f) h.vF().vj()).gWO.startsWith(com.tencent.mm.sdk.platformtools.ab.getPackageName() + ":appbrand");
        } catch (Exception e) {
            return false;
        }
    }
}
