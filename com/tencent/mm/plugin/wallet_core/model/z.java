package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.c;
import com.tencent.mm.y.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class z {
    public static ArrayList<i> lxc = null;
    private static z rHN = null;
    a kAf = new a(this) {
        final /* synthetic */ z rHO;

        {
            this.rHO = r1;
        }

        public final void a(d.a aVar) {
            int i;
            String a = n.a(aVar.hst.tff);
            w.i("MicroMsg.WalletPushNotifyManager", "PayMsg:" + a);
            Map q = bh.q(a, "sysmsg");
            int i2 = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
            z zVar = this.rHO;
            if (q == null) {
                w.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
                i = 1;
            } else if (i2 < 0) {
                w.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
                i = 1;
            } else if (i2 == 12) {
                int i3 = bg.getInt((String) q.get(".sysmsg.paymsg.avail_balance"), -1);
                long j = bg.getLong((String) q.get(".sysmsg.paymsg.balance_version"), -1);
                String[] strArr = new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"};
                e.a(strArr, new AnonymousClass3(zVar, bg.getLong((String) q.get(".sysmsg.paymsg.time_out"), 7200), j, i3, i2, q));
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                z.e(i2, q);
            }
        }
    };

    class AnonymousClass3 implements e.a {
        final /* synthetic */ z rHO;
        final /* synthetic */ Map rHQ;
        final /* synthetic */ long rHR;
        final /* synthetic */ long rHS;
        final /* synthetic */ int rHT;
        final /* synthetic */ int rHU;

        AnonymousClass3(z zVar, long j, long j2, int i, int i2, Map map) {
            this.rHO = zVar;
            this.rHR = j;
            this.rHS = j2;
            this.rHT = i;
            this.rHU = i2;
            this.rHQ = map;
        }

        public final void J(Map<String, Object> map) {
            if (map != null) {
                long a = bg.a((Long) map.get("wallet_balance_version"), -1);
                long a2 = bg.a((Long) map.get("wallet_balance_last_update_time"), -1);
                if (a2 < 0 || a < 0 || a2 + this.rHR > bg.NA() || this.rHS >= a) {
                    e.a(new c[]{new c("wallet_balance_version", Long.valueOf(this.rHS)), new c("wallet_balance_last_update_time", Long.valueOf(bg.NA())), new c("wallet_balance", Double.valueOf(((double) this.rHT) / 100.0d))});
                    z.e(this.rHU, this.rHQ);
                    return;
                }
                w.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
            }
        }
    }

    public static void e(final int i, final Map<String, String> map) {
        af.v(new Runnable() {
            public final void run() {
                if (z.lxc != null) {
                    Iterator it = z.lxc.iterator();
                    while (it.hasNext()) {
                        i iVar = (i) it.next();
                        if (iVar != null) {
                            iVar.pg(i);
                        }
                    }
                }
            }
        });
    }

    private z() {
    }

    public static z buc() {
        if (rHN == null) {
            rHN = new z();
        }
        return rHN;
    }

    public static boolean a(i iVar) {
        if (iVar == null) {
            w.e("MicroMsg.WalletPushNotifyManager", "hy: the callback for registering is null. register failed");
            return false;
        }
        if (lxc == null) {
            lxc = new ArrayList();
        }
        lxc.add(iVar);
        return true;
    }

    public static boolean b(i iVar) {
        if (lxc == null) {
            w.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
            return false;
        }
        lxc.remove(iVar);
        return true;
    }
}
