package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.e.a.qq;
import com.tencent.mm.e.a.qr;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.plugin.translate.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;
import java.util.LinkedList;

public final class a implements am {
    public ae handler = new ae(Looper.getMainLooper());
    private com.tencent.mm.plugin.translate.a.c.a rbA = new com.tencent.mm.plugin.translate.a.c.a(this) {
        final /* synthetic */ a rbD;

        {
            this.rbD = r1;
        }

        public final void a(final int i, SparseArray<c> sparseArray) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                final c cVar = (c) sparseArray.valueAt(i2);
                if (cVar != null) {
                    this.rbD.rbz.c(new com.tencent.mm.sdk.platformtools.ar.a(this) {
                        final /* synthetic */ AnonymousClass1 rbF;

                        public final boolean Bo() {
                            int i = i != 0 ? i : cVar.ret;
                            b qrVar = new qr();
                            qrVar.fXN.ret = i;
                            qrVar.fXN.fXI = cVar.fXI;
                            qrVar.fXN.id = cVar.id;
                            qrVar.fXN.fXO = cVar.fXO;
                            qrVar.fXN.type = cVar.type;
                            qrVar.fXN.aJE = cVar.aJE;
                            qrVar.fXN.fWo = cVar.fWo;
                            com.tencent.mm.sdk.b.a.urY.m(qrVar);
                            return false;
                        }

                        public final boolean Bn() {
                            w.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[]{cVar.id});
                            if (i != 0) {
                                w.e("MicroMsg.SubCoreTranslate", "translate error");
                            } else if (cVar.ret != 0) {
                                w.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[]{Integer.valueOf(cVar.ret)});
                            } else if (bg.mA(cVar.fXO)) {
                                w.e("MicroMsg.SubCoreTranslate", "translate return null");
                            } else if (cVar.type == 0 || cVar.type == 1) {
                                w.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                                String str = cVar.id;
                                String str2 = cVar.aJE;
                                String str3 = cVar.fXO;
                                String str4 = cVar.fWo;
                                ap.yY();
                                com.tencent.mm.u.c.wT().a(bg.PZ(str), str2, str3, str4);
                            }
                            return true;
                        }
                    });
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c rbB = new com.tencent.mm.sdk.b.c<qp>(this) {
        final /* synthetic */ a rbD;

        {
            this.rbD = r2;
            this.usg = qp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final qp qpVar = (qp) bVar;
            w.d("MicroMsg.SubCoreTranslate", "recieve one translate request");
            this.rbD.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 rbH;

                public final void run() {
                    com.tencent.mm.plugin.translate.a.c cVar = this.rbH.rbD.rby;
                    String str = qpVar.fXH.fXI;
                    String str2 = qpVar.fXH.id;
                    int i = qpVar.fXH.type;
                    String str3 = qpVar.fXH.aJE;
                    boolean z = qpVar.fXH.fXJ;
                    w.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", new Object[]{str2, Integer.valueOf(i)});
                    if (cVar.Hx(str2)) {
                        w.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", new Object[]{str2});
                        return;
                    }
                    c cVar2 = new c(str, str2, i, str3);
                    if (z) {
                        ((LinkedList) cVar.rbK).add(0, cVar2);
                    } else {
                        cVar.rbK.add(cVar2);
                    }
                    cVar.rbL.put(cVar2.id, Integer.valueOf(cVar2.rbN));
                    w.d("MicroMsg.TranslateServiceManager", "requestCount : %s", new Object[]{Integer.valueOf(cVar.kdg)});
                    cVar.bou();
                }
            });
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c rbC = new com.tencent.mm.sdk.b.c<qq>(this) {
        final /* synthetic */ a rbD;

        {
            this.rbD = r2;
            this.usg = qq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qq qqVar = (qq) bVar;
            qqVar.fXL.fXM = this.rbD.rby.Hx(qqVar.fXK.id);
            return true;
        }
    };
    public com.tencent.mm.plugin.translate.a.c rby = b.rbM;
    public ar rbz = new ar(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.plugin.translate.a.c cVar = this.rby;
        com.tencent.mm.plugin.translate.a.c.a aVar = this.rbA;
        if (!(aVar == null || cVar.gUN.contains(aVar))) {
            cVar.gUN.add(aVar);
        }
        com.tencent.mm.sdk.b.a.urY.b(this.rbB);
        com.tencent.mm.sdk.b.a.urY.b(this.rbC);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.rbB);
        com.tencent.mm.sdk.b.a.urY.c(this.rbC);
        com.tencent.mm.plugin.translate.a.c cVar = this.rby;
        com.tencent.mm.plugin.translate.a.c.a aVar = this.rbA;
        if (aVar != null && cVar.gUN.contains(aVar)) {
            cVar.gUN.remove(aVar);
        }
        com.tencent.mm.plugin.translate.a.c cVar2 = this.rby;
        if (cVar2.rbJ != null) {
            for (d dVar : cVar2.rbJ) {
                if (dVar != null) {
                    ap.vd().b(631, dVar);
                    if (dVar.rbS != null) {
                        dVar.rbU.KH();
                        ap.vd().c(dVar.rbS);
                    }
                    dVar.bov();
                    dVar.rbQ = null;
                }
            }
        }
        cVar2.rbL.clear();
        cVar2.rbK.clear();
        cVar2.gUN.clear();
        cVar2.kdg = 0;
    }
}
