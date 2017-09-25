package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.e.b.af;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.s;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements com.tencent.mm.plugin.zero.a.f {
    private r nyD;

    static class b implements Runnable {
        private String TAG;
        private final s hKS;
        private final LinkedList<lu> lFB;
        private int nyE;

        public b(String str, s sVar, LinkedList<lu> linkedList) {
            this.TAG = str;
            this.hKS = sVar;
            this.lFB = linkedList;
        }

        public final void run() {
            if (this.hKS != null) {
                int i = this.hKS.hMM;
                if (i != 3) {
                    if (!this.hKS.hML) {
                        if (!(i == 1 || i == 2 || i == 8)) {
                            return;
                        }
                    }
                    return;
                }
                this.nyE = 0;
                Iterator it = this.lFB.iterator();
                while (it.hasNext()) {
                    lu luVar = (lu) it.next();
                    byte[] a = n.a(luVar.tsb);
                    if (luVar.tsa == 5) {
                        try {
                            String com_tencent_mm_protocal_c_avx = ((bu) new bu().aD(a)).tfd.toString();
                            af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(com_tencent_mm_protocal_c_avx);
                            if (com_tencent_mm_protocal_c_avx.endsWith("@chatroom") && Rc.gkz == 0) {
                                this.nyE++;
                            }
                        } catch (IOException e) {
                            w.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + e.getMessage());
                        }
                    }
                }
                if (this.nyE > 0) {
                    if (this.nyE <= 5) {
                        c.oTb.a(202, (long) this.nyE, 1, false);
                    } else if (this.nyE <= 10) {
                        c.oTb.a(202, 6, 1, false);
                    } else if (this.nyE <= 15) {
                        c.oTb.a(202, 7, 1, false);
                    } else if (this.nyE <= 20) {
                        c.oTb.a(202, 8, 1, false);
                    } else {
                        c.oTb.a(202, 9, 1, false);
                    }
                    w.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.nyE);
                    switch (i) {
                        case 1:
                            c.oTb.a(202, 11, 1, false);
                            break;
                        case 2:
                            c.oTb.a(202, 12, 1, false);
                            break;
                        case 3:
                            c.oTb.a(202, 10, 1, false);
                            break;
                        case 8:
                            c.oTb.a(202, 13, 1, false);
                            break;
                    }
                    w.i(this.TAG, "muteroom idkeyStat:aiScene = " + i);
                }
            }
        }
    }

    private static class a implements r {
        public final void acR() {
        }

        public final void a(au auVar, bu buVar) {
        }
    }

    public final void aX(Object obj) {
        com.tencent.mm.bn.b aJY = com.tencent.mm.plugin.messenger.foundation.a.s.aJY();
        if (aJY != null) {
            this.nyD = (r) aJY.get();
        }
        if (this.nyD == null) {
            this.nyD = new a();
        }
        if (obj instanceof l) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ae(((l) obj).TAG);
        } else if (obj instanceof String) {
            if (obj.equals("NetSceneInit")) {
                ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ae((String) obj);
            }
        } else if (obj instanceof com.tencent.mm.modelmulti.r.c) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ae(obj.toString());
        }
    }

    public final void a(lu luVar, byte[] bArr, boolean z) {
        p pk = com.tencent.mm.plugin.messenger.foundation.a.p.a.pk(luVar.tsa);
        if (pk != null) {
            try {
                pk.a(luVar, bArr, z, this.nyD);
                return;
            } catch (IOException e) {
                w.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + e.getMessage());
                throw new RuntimeException("docmd: parse protobuf error");
            }
        }
        w.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", Integer.valueOf(luVar.tsa));
    }

    public final void aY(Object obj) {
        if (obj instanceof l) {
            this.nyD.acR();
            ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Af(((l) obj).TAG);
            com.tencent.mm.sdk.platformtools.af vL = com.tencent.mm.kernel.h.vL();
            String str = ((l) obj).TAG;
            s sVar = ((l) obj).hKS;
            l lVar = (l) obj;
            LinkedList linkedList = (lVar.hLa == null || lVar.hLa.tad.toe == null) ? null : lVar.hLa.tad.toe.jNe;
            vL.D(new b(str, sVar, linkedList));
        } else if ((obj instanceof String) && obj.equals("NetSceneInit")) {
            this.nyD.acR();
            ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Af((String) obj);
        } else if (obj instanceof com.tencent.mm.modelmulti.r.c) {
            this.nyD.acR();
            ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Af(obj.toString());
        }
    }

    public final void aZ(Object obj) {
        if (obj instanceof l) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Af(((l) obj).TAG);
        }
    }
}
