package com.tencent.mm.plugin.bbom;

import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ay.a;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class n implements r {
    private static List<ai> jPZ = new ArrayList();
    private boolean jQa;
    private boolean jQb;
    private List<au> jQc;

    public static void a(ai aiVar) {
        synchronized (jPZ) {
            if (!jPZ.contains(aiVar)) {
                jPZ.add(aiVar);
            }
        }
    }

    public static void b(ai aiVar) {
        synchronized (jPZ) {
            jPZ.remove(aiVar);
        }
    }

    public n() {
        this(false);
    }

    public n(boolean z) {
        this.jQa = false;
        this.jQb = false;
        this.jQc = new LinkedList();
        this.jQa = z;
        this.jQb = false;
        this.jQc = new LinkedList();
    }

    public final void acR() {
        final List linkedList = new LinkedList();
        linkedList.addAll(this.jQc);
        this.jQc.clear();
        if (linkedList.size() != 0) {
            List<ai> arrayList = new ArrayList();
            synchronized (jPZ) {
                for (ai add : jPZ) {
                    arrayList.add(add);
                }
            }
            for (final ai add2 : arrayList) {
                new ae(add2.getLooper()).post(new Runnable(this) {
                    final /* synthetic */ n jQf;

                    public final void run() {
                        add2.p(linkedList);
                    }
                });
            }
        }
    }

    public final void a(final au auVar, final bu buVar) {
        if (this.jQa) {
            w.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
        } else if (jPZ.isEmpty()) {
            w.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        } else if (auVar.field_isSend != 0 || auVar.field_status == 4) {
            w.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        } else {
            String a = com.tencent.mm.platformtools.n.a(buVar.tfd);
            ap.yY();
            ay AH = c.wZ().AH(new a(a).RU(""));
            if (AH != null && !AH.bMS()) {
                w.d("MicroMsg.SyncMessageNotifier", "account no notification");
            } else if (this.jQb) {
                this.jQc.add(auVar);
            } else {
                this.jQb = true;
                List<ai> arrayList = new ArrayList();
                synchronized (jPZ) {
                    for (ai add : jPZ) {
                        arrayList.add(add);
                    }
                }
                for (final ai add2 : arrayList) {
                    new ae(add2.getLooper()).post(new Runnable(this) {
                        final /* synthetic */ n jQf;

                        public final void run() {
                            if (buVar.mtd == 49) {
                                f.a ek = f.a.ek(j.c(buVar));
                                if (ek.hiK != 1 || bg.mA(ek.hiL) || bg.mA(ek.hiM)) {
                                    add2.a(auVar);
                                    return;
                                } else {
                                    add2.a(39, ek.hiM, "", ek.hiL, null, null);
                                    return;
                                }
                            }
                            add2.a(auVar);
                        }
                    });
                }
            }
        }
    }
}
