package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.collect.b.b;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.collect.b.l;
import com.tencent.mm.plugin.collect.b.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.y.g;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a implements am {
    private com.tencent.mm.u.bp.a kAf = new com.tencent.mm.u.bp.a(this) {
        final /* synthetic */ a kAh;

        {
            this.kAh = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            a.ajY();
            if (a.ajZ() != null) {
                String a = n.a(aVar.hst.tff);
                a.ajY();
                b ajZ = a.ajZ();
                w.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:" + a);
                if (bg.mA(a)) {
                    w.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
                    return;
                }
                Map q = bh.q(a, "sysmsg");
                int i = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), 0);
                if (i == 9 || i == 26) {
                    q qVar = new q();
                    qVar.username = bg.mz((String) q.get(".sysmsg.paymsg.username"));
                    qVar.kBc = bg.getDouble((String) q.get(".sysmsg.paymsg.fee"), 0.0d) / 100.0d;
                    qVar.fFd = bg.mz((String) q.get(".sysmsg.paymsg.feetype"));
                    qVar.kBd = bg.getInt((String) q.get(".sysmsg.paymsgtimestamp"), (int) bg.Ny());
                    qVar.fTA = bg.mz((String) q.get(".sysmsg.paymsg.transid"));
                    qVar.gMX = bg.mz((String) q.get(".sysmsg.paymsg.displayname"));
                    qVar.scene = bg.getInt((String) q.get(".sysmsg.paymsg.scene"), 1);
                    qVar.status = bg.getInt((String) q.get(".sysmsg.paymsg.status"), 0);
                    qVar.msgType = i;
                    qVar.kBe = bg.mz((String) q.get(".sysmsg.paymsg.outtradeno"));
                    ajZ.a(qVar);
                    return;
                }
                w.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=" + i);
                return;
            }
            w.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
        }
    };
    private e kAg = new e();

    public static a ajY() {
        a aVar = (a) ap.yR().gs("plugin.collect");
        if (aVar != null) {
            return aVar;
        }
        w.w("MicroMsg.SubCoreCollect", "not found in MMCore, new one");
        Object aVar2 = new a();
        ap.yR().a("plugin.collect", aVar2);
        return aVar2;
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        ap.getSysCmdMsgExtension().a("paymsg", this.kAf, true);
        com.tencent.mm.y.e eVar = this.kAg;
        eVar.bIy();
        eVar.fyE = new com.tencent.mm.c.a.a(ab.getContext());
        eVar.kAp = new ConcurrentLinkedQueue();
        eVar.fyE.fyW = false;
        eVar.fyE.fzb = new com.tencent.mm.y.g.a(eVar) {
            final /* synthetic */ e kAs;

            {
                this.kAs = r1;
            }

            public final void oW() {
                w.i("MicroMsg.F2fRcvVoiceListener", "player complete");
                this.kAs.kAq = false;
                if (this.kAs.kAp.isEmpty()) {
                    e.akd();
                } else {
                    this.kAs.ake();
                }
            }
        };
        eVar.fyE.fza = new g.b(eVar) {
            final /* synthetic */ e kAs;

            {
                this.kAs = r1;
            }

            public final void onError() {
                w.e("MicroMsg.F2fRcvVoiceListener", "player error");
                this.kAs.kAq = false;
                if (this.kAs.kAp.isEmpty()) {
                    e.akd();
                } else {
                    this.kAs.ake();
                }
            }
        };
        ap.vd().a(1384, eVar);
        ap.vd().a(1317, eVar);
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("paymsg", this.kAf, true);
        Object obj = this.kAg;
        obj.dead();
        ap.vd().b(1384, obj);
        ap.vd().b(1317, obj);
        obj.fyE.ap(false);
        e.akd();
    }

    public static b ajZ() {
        h.vG().uQ();
        return b.kAk;
    }

    public static boolean aka() {
        String str = (String) h.vI().vr().get(com.tencent.mm.storage.w.a.uFU, "");
        long xQ = m.xQ();
        if (bg.mA(str) || str.equals("in.caf")) {
            return (xQ & 32768) != 0;
        } else {
            w.i("MicroMsg.SubCoreCollect", "old version switch is open");
            return true;
        }
    }

    public final void akb() {
        tA("cash.caf");
        h.vI().vr().a(com.tencent.mm.storage.w.a.uFU, "cash.caf");
    }

    public final void akc() {
        tA("in.caf");
        h.vI().vr().a(com.tencent.mm.storage.w.a.uFU, "in.caf");
    }

    private void tA(String str) {
        ap.vd().a(304, new com.tencent.mm.y.e(this) {
            final /* synthetic */ a kAh;

            {
                this.kAh = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                ap.vd().b(304, this);
                if (i != 0 || i2 != 0) {
                    w.i("MicroMsg.SubCoreCollect", "set sound fail!");
                }
            }
        });
        ap.vd().a(new l(bg.ap(str, "")), 0);
    }
}
