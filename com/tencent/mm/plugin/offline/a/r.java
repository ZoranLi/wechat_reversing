package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.e.a.rw;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class r {
    private List<WeakReference<a>> kcI = new ArrayList();
    public ArrayList<Long> oao = new ArrayList();
    public b odb = null;
    private HashSet<String> odc = new HashSet();

    public interface a {
        boolean a(c cVar);
    }

    public class c {
        final /* synthetic */ r odd;
        public int odh;

        public c(r rVar) {
            this.odd = rVar;
        }
    }

    public class h {
        public String fZb;
        public String fZc;
        public String fZd;
        public String fZe;
        public String fZf;
        final /* synthetic */ r odd;
        public boolean ods;

        public h(r rVar, Map<String, String> map) {
            this.odd = rVar;
            this.fZb = (String) map.get(".sysmsg.paymsg.guide_flag");
            this.fZc = (String) map.get(".sysmsg.paymsg.guide_wording");
            this.fZd = (String) map.get(".sysmsg.paymsg.left_button_wording");
            this.fZe = (String) map.get(".sysmsg.paymsg.right_button_wording");
            this.fZf = (String) map.get(".sysmsg.paymsg.upload_credit_url");
            this.ods = "1".equals(map.get(".sysmsg.paymsg.guide_block"));
        }
    }

    public class b extends c {
        final /* synthetic */ r odd;
        public String ode;
        public String odf;
        public String odg;

        public b(r rVar) {
            this.odd = rVar;
            super(rVar);
        }
    }

    public class d extends c {
        public String fLT;
        final /* synthetic */ r odd;

        public d(r rVar) {
            this.odd = rVar;
            super(rVar);
        }
    }

    public class e extends c {
        final /* synthetic */ r odd;
        public String odi;
        public String odj;
        public String odk;
        public String odl;
        public String odm;

        public e(r rVar) {
            this.odd = rVar;
            super(rVar);
        }
    }

    public class f extends c {
        public h fZp;
        final /* synthetic */ r odd;
        public String odn;
        public Orders odo;

        public f(r rVar) {
            this.odd = rVar;
            super(rVar);
        }
    }

    public class g extends c {
        public String fLT;
        public String id;
        final /* synthetic */ r odd;
        public String odp;
        public String odq;
        public int odr;

        public g(r rVar) {
            this.odd = rVar;
            super(rVar);
        }
    }

    public r() {
        Object aQU = com.tencent.mm.plugin.offline.c.a.aQU();
        if (!TextUtils.isEmpty(aQU)) {
            Map q = bh.q(aQU, "sysmsg");
            if (q != null) {
                int i = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                if (i >= 0 && i == 4) {
                    w.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
                    b(D(q));
                }
            }
        }
        this.oao.clear();
    }

    public final boolean cP(long j) {
        if (this.oao == null || this.oao.size() == 0) {
            w.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
            return false;
        }
        for (int i = 0; i < this.oao.size(); i++) {
            if (((Long) this.oao.get(i)).longValue() == j) {
                return true;
            }
        }
        return false;
    }

    private void b(c cVar) {
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null && aVar.a(cVar)) {
                        return;
                    }
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.kcI == null) {
            this.kcI = new ArrayList();
        }
        if (aVar != null) {
            this.kcI.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kcI != null && aVar != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kcI.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public final void BV(String str) {
        com.tencent.mm.plugin.offline.c.a.Ci("");
        com.tencent.mm.plugin.offline.c.a.Ck("");
        com.tencent.mm.plugin.offline.c.a.Cj("");
        Map q = bh.q(str, "sysmsg");
        if (q != null) {
            int i = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
            String str2 = (String) q.get(".sysmsg.paymsg.req_key");
            com.tencent.mm.plugin.offline.c.a.Ci((String) q.get(".sysmsg.paymsg.ack_key"));
            com.tencent.mm.plugin.offline.c.a.qS(i);
            com.tencent.mm.plugin.offline.c.a.Cj(str2);
            int i2 = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
            w.i("MicroMsg.WalletOfflineMsgManager", "msg type is " + i2);
            w.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[]{Integer.valueOf(i2), str});
            if (i2 >= 0 && i2 == 4) {
                b(D(q));
                com.tencent.mm.plugin.offline.c.a.BZ(str);
            } else if (i2 >= 0 && i2 == 5) {
                r1 = new e(this);
                r1.odh = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.odi = (String) q.get(".sysmsg.paymsg.cftretcode");
                r1.odj = (String) q.get(".sysmsg.paymsg.cftretmsg");
                r1.odk = (String) q.get(".sysmsg.paymsg.wxretcode");
                r1.odl = (String) q.get(".sysmsg.paymsg.wxretmsg");
                r1.odm = (String) q.get(".sysmsg.paymsg.error_detail_url");
                b(r1);
            } else if (i2 >= 0 && i2 == 6) {
                str2 = (String) q.get(".sysmsg.paymsg.transid");
                w.i("helios", "MSG_TYPE_ORDER trasid=" + str2);
                if (!bg.mA(str2)) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uEO, Boolean.valueOf(true));
                }
                r1 = new f(this);
                r1.odh = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.odn = (String) q.get(".sysmsg.paymsg.transid");
                r1.odo = com.tencent.mm.plugin.offline.c.a.E(q);
                if (r1.odo.rGe.size() > 0) {
                    com.tencent.mm.plugin.offline.c.a.Ck(((Commodity) r1.odo.rGe.get(0)).fTA);
                }
                if (q.containsKey(".sysmsg.paymsg.real_name_info")) {
                    r1.fZp = new h(this, q);
                }
                b(r1);
            } else if (i2 >= 0 && i2 == 7) {
                m.btS().aue();
            } else if (i2 >= 0 && i2 == 8) {
                r1 = new g(this);
                r1.odh = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.odp = (String) q.get(".sysmsg.paymsg.good_name");
                r1.odq = (String) q.get(".sysmsg.paymsg.total_fee");
                r1.fLT = (String) q.get(".sysmsg.paymsg.req_key");
                r1.id = (String) q.get(".sysmsg.paymsg.id");
                str2 = (String) q.get(".sysmsg.paymsg.confirm_type");
                w.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + r1.odr);
                if (TextUtils.isEmpty(str2) || !str2.equals("1")) {
                    r1.odr = 0;
                } else {
                    r1.odr = 1;
                }
                b(r1);
            } else if (i2 >= 0 && i2 == 10) {
                k.aQd();
                k.aQg().cD(4, 4);
            } else if (i2 >= 0 && i2 == 20) {
                com.tencent.mm.sdk.b.b rwVar = new rw();
                rwVar.fZo.fZp = new h(this, q);
                com.tencent.mm.sdk.b.a.urY.m(rwVar);
            } else if (i2 >= 0 && i2 == 23) {
                r1 = new d(this);
                r1.odh = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.fLT = (String) q.get(".sysmsg.paymsg.req_key");
                synchronized (this.odc) {
                    if (this.odc.contains(r1.fLT)) {
                        w.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[]{r1.fLT});
                        return;
                    }
                    this.odc.add(r1.fLT);
                    b(r1);
                }
            } else if (i2 >= 0 && i2 == 24) {
                r1 = new d(this);
                r1.odh = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.fLT = (String) q.get(".sysmsg.paymsg.req_key");
                b(r1);
            }
        }
    }

    private b D(Map<String, String> map) {
        if (this.odb == null) {
            this.odb = new b(this);
        }
        this.odb.odh = bg.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        this.odb.ode = (String) map.get(".sysmsg.paymsg.isfreeze");
        this.odb.odf = (String) map.get(".sysmsg.paymsg.freezetype");
        this.odb.odg = (String) map.get(".sysmsg.paymsg.freezemsg");
        return this.odb;
    }

    public final void BW(String str) {
        int i = bg.getInt((String) bh.q(str, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
        if (5 == i || 6 == i || 20 == i) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ r odd;

                {
                    this.odd = r1;
                }

                public final void run() {
                    w.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
                    ap.vd().a(new b(), 0);
                }
            });
        }
    }
}
