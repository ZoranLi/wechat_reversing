package com.tencent.mm.plugin.luckymoney.a;

import android.text.TextUtils;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.b;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public final class a implements am {
    private com.tencent.mm.u.bp.a kAf = new com.tencent.mm.u.bp.a(this) {
        final /* synthetic */ a njk;

        {
            this.njk = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            Map q = bh.q(n.a(aVar.hst.tff), "sysmsg");
            w.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
            if (q == null) {
                w.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
                return;
            }
            if ("14".equals((String) q.get(".sysmsg.paymsg.PayMsgType"))) {
                String decode = URLDecoder.decode((String) q.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    w.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
                    return;
                }
                Map q2 = bh.q(decode, "msg");
                if (q2 == null) {
                    w.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
                    return;
                }
                String str = (String) q2.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (bg.mA(str)) {
                    w.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
                    return;
                }
                String str2 = (String) q.get(".sysmsg.paymsg.tousername");
                if (bg.mA(decode) || bg.mA(str2)) {
                    w.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                } else if (this.njk.aHJ().zJ(str)) {
                    w.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
                    if (!com.tencent.mm.plugin.luckymoney.b.n.z(decode, str2, 1)) {
                        this.njk.aHJ().zK(str);
                    }
                }
            }
        }
    };
    private d njg;
    private f njh;
    private b nji = new b();
    private ah njj;

    public static a aHG() {
        a aVar = (a) ap.yR().gs("plugin.luckymoney");
        if (aVar != null) {
            return aVar;
        }
        w.w("MicroMsg.SubCoreLuckyMoney", "not found in MMCore, new one");
        Object aVar2 = new a();
        ap.yR().a("plugin.luckymoney", aVar2);
        return aVar2;
    }

    public a() {
        File file = new File(aHI());
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(e.gSI);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        boolean z2 = true;
        Object bDn = ao.bDn();
        if (ap.zb()) {
            an.aBG().a(4, bDn);
            ap.vd().a(1060, bDn);
        }
        ap.getSysCmdMsgExtension().a("paymsg", this.kAf, true);
        ap.yY();
        if (System.currentTimeMillis() - com.tencent.mm.u.c.vr().yB(352276) < 43200000) {
            z2 = false;
        }
        w.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + z2 + ", isUpdate=" + z);
        if (z || z2) {
            w.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
            ao.bDn().dA(ab.getContext());
        }
        com.tencent.mm.plugin.q.a.b.njf = new com.tencent.mm.plugin.luckymoney.sns.a.a();
        com.tencent.mm.sdk.b.a.urY.b(this.nji);
        this.njj = new ah();
    }

    public final void onAccountRelease() {
        ao bDn = ao.bDn();
        if (ap.zb()) {
            an.aBG().b(4, bDn);
            ap.vd().b(1060, bDn);
            bDn.sEv = false;
            bDn.sEw = false;
        }
        ap.getSysCmdMsgExtension().b("paymsg", this.kAf, true);
        this.njh = null;
        com.tencent.mm.plugin.q.a.b.njf = null;
        com.tencent.mm.sdk.b.a.urY.c(this.nji);
        if (this.njj != null) {
            ah ahVar = this.njj;
            com.tencent.mm.sdk.b.a.urY.c(ahVar.nod);
            if (ahVar.noa != null) {
                ap.vd().c(ahVar.noa);
                ahVar.noa = null;
            }
            if (ahVar.nob != null) {
                ap.vd().c(ahVar.nob);
                ahVar.nob = null;
            }
        }
    }

    public static d aHH() {
        h.vG().uQ();
        if (aHG().njg == null) {
            aHG().njg = new d();
        }
        return aHG().njg;
    }

    public static String aHI() {
        if (!ap.zb()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(com.tencent.mm.u.c.xb()).append("luckymoney").toString();
    }

    public final synchronized f aHJ() {
        if (this.njh == null) {
            this.njh = new f();
        }
        return this.njh;
    }
}
