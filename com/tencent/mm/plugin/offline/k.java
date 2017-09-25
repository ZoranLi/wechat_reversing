package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.rx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.y.d;
import java.util.HashMap;
import java.util.Map;

public final class k implements am {
    private static HashMap<Integer, c> gJr = new HashMap();
    private static Map<String, String> iGX = new HashMap();
    public static boolean oci = false;
    public static int ocj = 10;
    private b iyc;
    private a kAf = new a(this) {
        final /* synthetic */ k ocm;

        {
            this.ocm = r1;
        }

        public final void a(final d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            w.i("MicroMsg.SubCoreOffline", "OfflinePayMsg:" + a);
            this.ocm.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass4 ocn;

                public final void run() {
                    r aQe = k.aQe();
                    String str = a;
                    long j = aVar.hst.tfk;
                    w.v("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :" + j);
                    w.v("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :" + str);
                    if (!TextUtils.isEmpty(str)) {
                        if (aQe.cP(j)) {
                            w.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:" + j);
                            return;
                        }
                        String str2 = null;
                        Map q = bh.q(str, "sysmsg");
                        if (q != null) {
                            str2 = (String) q.get(".sysmsg.paymsg.ack_key");
                        }
                        if (!com.tencent.mm.plugin.offline.c.a.aRn()) {
                            g.da(str2, str);
                            aQe.BV(str);
                            aQe.BW(str);
                        } else if (g.da(str2, str)) {
                            g.oUh.a(135, 70, 1, true);
                            aQe.BV(str);
                            aQe.BW(str);
                        }
                        if (aQe.oao.size() > 10) {
                            aQe.oao.remove(aQe.oao.size() - 1);
                        }
                        aQe.oao.add(0, Long.valueOf(j));
                    }
                }
            });
        }
    };
    public ae mHandler = new ae(Looper.getMainLooper());
    private r occ = null;
    private e ocd = null;
    private i oce = null;
    private com.tencent.mm.plugin.offline.b.a ocf = null;
    private com.tencent.mm.plugin.offline.ui.d ocg = new com.tencent.mm.plugin.offline.ui.d();
    public f och = new f();
    private com.tencent.mm.sdk.b.c<rx> ock = new com.tencent.mm.sdk.b.c<rx>(this) {
        final /* synthetic */ k ocm;

        {
            this.ocm = r2;
            this.usg = rx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rx rxVar = (rx) bVar;
            if (!bg.mA(rxVar.fZq.fZr)) {
                com.tencent.mm.plugin.offline.c.a.Ca(rxVar.fZq.fZr);
            }
            return false;
        }
    };
    private m ocl;

    static {
        com.tencent.mm.wallet_core.a.g("OfflineBindCardRegProcess", d.class);
        com.tencent.mm.wallet_core.a.g("OfflineBindCardProcess", c.class);
        gJr.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.offline.b.a.gUx;
            }
        });
    }

    public static k aQd() {
        k kVar = (k) ap.yR().gs("plugin.offline");
        if (kVar != null) {
            return kVar;
        }
        w.e("MicroMsg.SubCoreOffline", "not found in MMCore, new one");
        Object kVar2 = new k();
        ap.yR().a("plugin.offline", kVar2);
        return kVar2;
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        this.iyc = ((com.tencent.mm.plugin.auth.a.b) h.j(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a(this) {
            final /* synthetic */ k ocm;

            {
                this.ocm = r1;
            }

            public final void a(f fVar, i.g gVar, boolean z) {
                w.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[]{Boolean.valueOf(z)});
                if (!z) {
                    k.aQg().cD(7, 7);
                }
            }

            public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
            }
        });
        ap.getSysCmdMsgExtension().a("paymsg", this.kAf, true);
        com.tencent.mm.sdk.b.a.urY.b(this.ocg);
        com.tencent.mm.sdk.b.a.urY.b(this.ock);
        this.occ = null;
        this.ocd = null;
        this.oce = null;
        this.ocl = new m();
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("paymsg", this.kAf, true);
        com.tencent.mm.sdk.b.a.urY.c(this.ocg);
        com.tencent.mm.sdk.b.a.urY.c(this.ock);
        if (this.ocl != null) {
            r.a aVar = this.ocl;
            aQd();
            aQe().b(aVar);
            com.tencent.mm.sdk.b.a.urY.c(aVar.nod);
        }
        this.ocl = null;
        this.iyc.dead();
    }

    public static r aQe() {
        h.vG().uQ();
        if (aQd().occ == null) {
            aQd().occ = new r();
        }
        return aQd().occ;
    }

    public static e aQf() {
        h.vG().uQ();
        if (aQd().ocd == null) {
            aQd().ocd = new e();
        }
        return aQd().ocd;
    }

    public static i aQg() {
        h.vG().uQ();
        if (aQd().oce == null) {
            aQd().oce = new i();
        }
        return aQd().oce;
    }

    public static void af(int i, String str) {
        if (str != null) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(i, str);
            ap.yY();
            com.tencent.mm.u.c.vr().jY(true);
        }
    }

    public static String qL(int i) {
        ap.yY();
        return (String) com.tencent.mm.u.c.vr().get(i, null);
    }

    public static com.tencent.mm.plugin.offline.b.a aQh() {
        if (ap.zb()) {
            if (aQd().ocf == null) {
                k aQd = aQd();
                ap.yY();
                aQd.ocf = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.u.c.wO());
            }
            return aQd().ocf;
        }
        throw new com.tencent.mm.u.b();
    }
}
