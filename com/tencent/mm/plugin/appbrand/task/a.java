package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.plugin.appbrand.f.l;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashSet;
import java.util.Iterator;

public final class a {
    private static boolean jhq = false;
    private static boolean jhr = false;
    private static HashSet<a> jhs = new HashSet();

    public interface a {
        void onReady();
    }

    public static synchronized void a(a aVar) {
        synchronized (a.class) {
            if (jhq) {
                if (aVar != null) {
                    jhs.add(aVar);
                }
            } else if (!jhr) {
                jhq = true;
                if (aVar != null) {
                    jhs.add(aVar);
                }
                new l().init();
                d.vL().D(new Runnable() {
                    public final void run() {
                        if (QbSdk.isTbsCoreInited()) {
                            a.done();
                        } else {
                            QbSdk.preInit(ab.getContext(), new com.tencent.smtt.sdk.QbSdk.a(this) {
                                private boolean jht = false;
                                private boolean jhu = false;
                                final /* synthetic */ AnonymousClass1 jhv;

                                {
                                    this.jhv = r2;
                                }

                                public final void ot() {
                                    this.jht = true;
                                    if (this.jht && this.jhu) {
                                        a.done();
                                    }
                                }

                                public final void al(boolean z) {
                                    this.jhu = true;
                                    if (this.jht && this.jhu) {
                                        a.done();
                                    }
                                }
                            });
                        }
                    }
                });
            } else if (aVar != null) {
                aVar.onReady();
            }
        }
    }

    public static synchronized void done() {
        synchronized (a.class) {
            jhr = true;
            jhq = false;
            Iterator it = jhs.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            jhs.clear();
        }
    }

    public static boolean WC() {
        return jhr;
    }
}
