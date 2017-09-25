package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.mm.e.a.jm;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.e.a.kn;
import com.tencent.mm.e.a.l;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.a.si;
import com.tencent.mm.e.a.sl;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.f;
import com.tencent.mm.plugin.wear.model.f.h;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.plugin.wear.model.f.j;
import com.tencent.mm.plugin.wear.model.f.k;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public final class e {
    c gLi = new c<nd>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = nd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nd ndVar = (nd) bVar;
            if (this.rTQ.bvN()) {
                ap.yY();
                aj Rm = com.tencent.mm.u.c.wW().Rm(ndVar.fUm.fTk.field_talker);
                if (Rm != null) {
                    int i = Rm.field_unReadCount;
                    f IC = a.bvG().rTq.IC(ndVar.fUm.fTk.field_talker);
                    if (i - IC.rTW > 0) {
                        e.n(ndVar.fUm.fTk.field_talker, i, false);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(IC.id));
                        a.bvG().rTu.a(new i(arrayList));
                    }
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.platformtools.aj irQ = new com.tencent.mm.sdk.platformtools.aj(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r1;
        }

        public final boolean oQ() {
            a.bvG().rTu.a(new com.tencent.mm.plugin.wear.model.f.a());
            return true;
        }
    }, true);
    com.tencent.mm.plugin.messenger.foundation.a.a.c.a lpR = new com.tencent.mm.plugin.messenger.foundation.a.a.c.a(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r1;
        }

        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
            if (cVar2 != null && cVar2.nyR > 0 && a.bvG().rTo.rTG.rUu.equals(cVar2.fJL)) {
                a.bvG().rTu.a(new com.tencent.mm.plugin.wear.model.f.c(this) {
                    final /* synthetic */ AnonymousClass2 rTR;

                    {
                        this.rTR = r1;
                    }

                    protected final void send() {
                        try {
                            a.bvG();
                            r.a(20007, a.bvG().rTo.rTG.rUu.getBytes("utf8"), false);
                        } catch (UnsupportedEncodingException e) {
                        }
                    }

                    public final String getName() {
                        return "SendMsgSyncTask";
                    }
                });
            }
        }
    };
    c nod = new c<si>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = si.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            si siVar = (si) bVar;
            switch (siVar.fZQ.action) {
                case 2:
                    a.bvG().rTu.a(new h(siVar.fZR.fEU, siVar.fZR.fZT, siVar.fZR.fZU, siVar.fZR.fZV));
                    break;
                case 4:
                    if (g.sV().getInt("WearPayBlock", 0) == 0) {
                        a.bvG().rTu.a(new k(siVar.fZQ.fZS, siVar.fZQ.content));
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    c qrv = new c<jm>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = jm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jm jmVar = (jm) bVar;
            if (this.rTQ.bvN() && !"gh_3dfda90e39d6".equals(jmVar.fPU.fJL)) {
                ap.yY();
                au Ai = com.tencent.mm.u.c.wT().Ai(jmVar.fPU.fJL);
                boolean z = g.sV().getInt("WearLuckyBlock", 0) == 0 && (Ai.bMa() || Ai.bMb());
                if (z) {
                    a.bvG().rTu.a(new com.tencent.mm.plugin.wear.model.f.g(Ai));
                    if (jmVar.fPU.fCK > 1) {
                        e.n(jmVar.fPU.fJL, jmVar.fPU.fCK, false);
                    }
                } else {
                    e.n(jmVar.fPU.fJL, jmVar.fPU.fCK, true);
                }
            }
            return false;
        }
    };
    private PowerManager rTI;
    private KeyguardManager rTJ;
    c rTK = new c<l>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((l) bVar).fCE.fCF) {
                a.bvG().rTu.a(new i());
            }
            return false;
        }
    };
    c rTL = new c<kn>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = kn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kn knVar = (kn) bVar;
            a.bvG().rTq.ID(knVar.fQY.fJL);
            f IC = a.bvG().rTq.IC(knVar.fQY.fJL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(IC.id));
            a.bvG().rTu.a(new i(arrayList));
            if (knVar.fQY.fJL.equals("gh_43f2581f6fd6")) {
                bnp com_tencent_mm_protocal_c_bnp = a.bvG().rTo.rTF.rUt;
                if (com_tencent_mm_protocal_c_bnp != null) {
                    boolean z = com_tencent_mm_protocal_c_bnp != null && a.bvG().rTr.rTy && b.IB(com_tencent_mm_protocal_c_bnp.umA);
                    if (z) {
                        a.bvG();
                        b.a(com_tencent_mm_protocal_c_bnp);
                    } else {
                        a.bvG().rTr.connect();
                    }
                }
            }
            return false;
        }
    };
    c rTM = new c<rr>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = rr.class.getName().hashCode();
        }

        private static boolean a(rr rrVar) {
            switch (rrVar.fYI.fJK) {
                case 3:
                    Object obj = rrVar.fYI.fYC;
                    if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                        bla com_tencent_mm_protocal_c_bla;
                        Object obj2 = new byte[(obj.length - 1)];
                        System.arraycopy(obj, 1, obj2, 0, obj2.length);
                        try {
                            com_tencent_mm_protocal_c_bla = (bla) new bla().aD(obj2);
                        } catch (IOException e) {
                            com_tencent_mm_protocal_c_bla = null;
                        }
                        if (com_tencent_mm_protocal_c_bla != null) {
                            String str = com_tencent_mm_protocal_c_bla.ukr;
                            int i = com_tencent_mm_protocal_c_bla.ukj;
                            w.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", new Object[]{str, Integer.valueOf(i)});
                            a.bvG().rTu.a(new com.tencent.mm.plugin.wear.model.f.l(20010, str));
                            break;
                        }
                    }
                    break;
            }
            return false;
        }
    };
    c rTN = new c<sl>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = sl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            switch (((sl) bVar).gad.fEG) {
                case 5:
                    a.bvG().rTu.a(new com.tencent.mm.plugin.wear.model.f.l(20011, ""));
                    break;
                case 6:
                case 7:
                    a.bvG().rTu.a(new com.tencent.mm.plugin.wear.model.f.l(20012, ""));
                    break;
            }
            return false;
        }
    };
    c rTO = new c<jv>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = jv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jv jvVar = (jv) bVar;
            if (this.rTQ.bvN()) {
                a.bvG().rTu.a(new f(jvVar.fQj.userName, jvVar.fQj.aIO, jvVar.fQj.type));
            }
            return false;
        }
    };
    c rTP = new c<nw>(this) {
        final /* synthetic */ e rTQ;

        {
            this.rTQ = r2;
            this.usg = nw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.rTQ.bvN()) {
                a.bvG().rTu.a(new com.tencent.mm.plugin.wear.model.f.e());
            }
            return false;
        }
    };

    public e() {
        w.i("MicroMsg.Wear.WearLogic", "Create!");
        this.qrv.bIy();
        this.rTK.bIy();
        this.rTL.bIy();
        this.rTM.bIy();
        this.rTN.bIy();
        this.rTO.bIy();
        this.rTP.bIy();
        this.gLi.bIy();
        this.nod.bIy();
        this.irQ.v(1800000, 1800000);
        this.rTI = (PowerManager) ab.getContext().getSystemService("power");
        this.rTJ = (KeyguardManager) ab.getContext().getSystemService("keyguard");
        ap.yY();
        com.tencent.mm.u.c.wT().a(this.lpR, null);
    }

    public static void n(String str, int i, boolean z) {
        a.bvG().rTu.a(new j(str, i, z));
    }

    public final boolean bvN() {
        return this.rTJ.inKeyguardRestrictedInputMode() || !this.rTI.isScreenOn();
    }
}
