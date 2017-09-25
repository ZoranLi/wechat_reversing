package com.tencent.mm.wallet_core.d;

import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.f.a.b;
import com.tencent.mm.wallet_core.f.a.c;
import com.tencent.mm.wallet_core.f.a.d;
import com.tencent.mm.wallet_core.f.a.f;
import com.tencent.mm.wallet_core.f.a.g;
import com.tencent.mm.wallet_core.f.a.i;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a implements e {
    private i wEt;
    private int wEu = 0;
    private e wEv;

    public a(e eVar) {
        this.wEv = eVar;
    }

    public final boolean a(i iVar) {
        int i = m.btS().aMo;
        w.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[]{Boolean.valueOf(iVar.ccv()), Integer.valueOf(this.wEu)});
        if (!iVar.ccv() || this.wEu >= i) {
            return false;
        }
        return true;
    }

    public final void b(i iVar) {
        w.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
        this.wEu = 0;
        c(iVar);
    }

    private void c(i iVar) {
        k eVar;
        boolean z;
        this.wEt = iVar;
        this.wEt.wES = true;
        ap.vd().a(385, this);
        af btS = m.btS();
        int i = btS.rIu > 0 ? btS.rIu : 10000;
        this.wEu++;
        Map ccu = this.wEt.ccu();
        String str = (String) ccu.get("req_key");
        if (bg.mA(str)) {
            w.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
            eVar = new com.tencent.mm.wallet_core.f.a.e(ccu);
        } else {
            w.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[]{str});
            w.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
            eVar = str.startsWith("sns_aa_") ? new com.tencent.mm.wallet_core.f.a.a(ccu) : str.startsWith("sns_tf_") ? new g(ccu) : str.startsWith("sns_ff_") ? new b(ccu) : str.startsWith("ts_") ? new c(ccu) : str.startsWith("sns_") ? new f(ccu) : str.startsWith("offline_") ? new d(ccu) : new com.tencent.mm.wallet_core.f.a.e(ccu);
        }
        eVar.wEE = true;
        if (this.wEu >= m.btS().aMo) {
            z = true;
        } else {
            z = false;
        }
        int i2 = this.wEu;
        Map hashMap = new HashMap();
        hashMap.put("is_last_query", (z ? 1 : 0));
        hashMap.put("curr_query_count", String.valueOf(i2));
        eVar.al(hashMap);
        w.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[]{Integer.valueOf(i), Integer.valueOf(r5)});
        ap.vd().a(eVar, i);
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        w.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.wEt != null && jSONObject != null && i == 0 && i2 == 0) {
            w.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
            this.wEt.a(i2, str, jSONObject);
            this.wEv.a(i, i2, str, this.wEt);
        } else if (this.wEv != null) {
            w.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
            this.wEv.a(i, i2, str, this.wEt);
        }
        w.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
        this.wEu = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar});
        if (kVar instanceof com.tencent.mm.wallet_core.f.a.e) {
            ap.vd().b(385, this);
            com.tencent.mm.wallet_core.f.a.e eVar = (com.tencent.mm.wallet_core.f.a.e) kVar;
            w.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, eVar, Integer.valueOf(eVar.wED)});
            if (eVar.wED == 1) {
                w.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
                a(i, i2, str, eVar.ccs());
                return;
            }
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
                if (eVar.wED != 2) {
                    a(i, i2, str, eVar.ccs());
                    return;
                }
            } else if (!eVar.wEd) {
                w.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
                w.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[]{m.btS().rIv});
            } else if (a(this.wEt)) {
                w.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
                c(this.wEt);
                return;
            } else {
                w.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail");
                if (eVar.wED == 1) {
                    a(i, i2, str, eVar.ccs());
                    return;
                }
            }
            a(this.wEt.wEL, this.wEt.wEM, this.wEt.wEN, this.wEt.wEO);
        } else if (kVar instanceof i) {
            ap.vd().b(385, this);
            if (!((i) kVar).wET) {
                return;
            }
            if (this.wEt.rzL) {
                w.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
                a(i, i2, str, ((i) kVar).wEO);
            } else if (this.wEt.ccv()) {
                w.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
                c(this.wEt);
            } else {
                w.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[]{m.btS().rIv});
                a(i, i2, r0, ((i) kVar).wEO);
            }
        }
    }
}
