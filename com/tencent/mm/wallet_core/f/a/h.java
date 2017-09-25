package com.tencent.mm.wallet_core.f.a;

import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bey;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class h extends g {
    public static Vector<String> wEG = new Vector();
    protected boolean wEF = false;

    public abstract int aki();

    public int bti() {
        return aki();
    }

    public void y(boolean z, boolean z2) {
        b BE;
        b bVar = this.gUA;
        if (bVar == null) {
            a aVar = new a();
            aVar.hsm = new bey();
            aVar.hsn = new bez();
            String uri = getUri();
            int zi = zi();
            aVar.uri = uri;
            aVar.hsl = zi;
            aVar.hso = 185;
            aVar.hsp = 1000000185;
            BE = aVar.BE();
            BE.hsA = !bfA();
        } else {
            BE = bVar;
        }
        bey com_tencent_mm_protocal_c_bey = (bey) BE.hsj.hsr;
        if (z) {
            com_tencent_mm_protocal_c_bey.tKk = aki();
        }
        if (z2) {
            com_tencent_mm_protocal_c_bey.tKl = 1;
        }
        this.gUA = BE;
    }

    public boolean bfA() {
        return true;
    }

    public int getType() {
        return 385;
    }

    public final String HP(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, avw com_tencent_mm_protocal_c_avw) {
        ((bey) bVar.hsj.hsr).tKm = com_tencent_mm_protocal_c_avw;
    }

    public final void b(b bVar, avw com_tencent_mm_protocal_c_avw) {
        ((bey) bVar.hsj.hsr).tUZ = com_tencent_mm_protocal_c_avw;
    }

    static {
        for (Object add : c.sYn) {
            wEG.add(add);
        }
    }

    public final l c(b bVar) {
        bez com_tencent_mm_protocal_c_bez = (bez) bVar.hsk.hsr;
        l lVar = new l();
        lVar.tKq = com_tencent_mm_protocal_c_bez.tKq;
        lVar.tKp = com_tencent_mm_protocal_c_bez.tKp;
        lVar.tKo = com_tencent_mm_protocal_c_bez.tKo;
        lVar.tKn = com_tencent_mm_protocal_c_bez.tKn;
        lVar.leS = com_tencent_mm_protocal_c_bez.tVb;
        lVar.wEg = com_tencent_mm_protocal_c_bez.tVa;
        return lVar;
    }

    private int d(b bVar) {
        bey com_tencent_mm_protocal_c_bey = (bey) bVar.hsj.hsr;
        if (com_tencent_mm_protocal_c_bey.tKm != null) {
            String str = new String(com_tencent_mm_protocal_c_bey.tKm.tZp.sYA);
        }
        if (com_tencent_mm_protocal_c_bey.tUZ != null) {
            str = new String(com_tencent_mm_protocal_c_bey.tUZ.tZp.sYA);
        }
        r.ccl();
        if (!this.wEF) {
            return -1;
        }
        bez com_tencent_mm_protocal_c_bez = (bez) bVar.hsk.hsr;
        if (com_tencent_mm_protocal_c_bez == null) {
            com_tencent_mm_protocal_c_bez = new bez();
        }
        com_tencent_mm_protocal_c_bez.tKn = new avw().bb("".getBytes());
        com_tencent_mm_protocal_c_bez.tKq = bti();
        com_tencent_mm_protocal_c_bez.tKo = 0;
        try {
            JSONObject jSONObject = new JSONObject(null);
            com_tencent_mm_protocal_c_bez.tVa = jSONObject.optInt("TenpayErrType");
            com_tencent_mm_protocal_c_bez.tVb = jSONObject.optString("TenpayErrMsg");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
        a(1, 0, 0, "", bVar, null);
        return 1;
    }

    public final void cct() {
        this.wEF = true;
    }

    public int a(e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        if (wEG.contains(this.gUA.uri)) {
            w.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[]{this.gUA.uri});
        } else {
            Object[] objArr = new Object[1];
            com.tencent.mm.wallet_core.c.a.cbV();
            objArr[0] = Integer.valueOf(com.tencent.mm.wallet_core.c.a.getLastError());
            w.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", objArr);
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.c.a.cbV();
            com.tencent.mm.wallet_core.c.a.init(ab.getContext());
            bey com_tencent_mm_protocal_c_bey = (bey) this.gUA.hsj.hsr;
            String str = "";
            String str2 = "";
            if (com_tencent_mm_protocal_c_bey.tKm != null) {
                str = new String(com_tencent_mm_protocal_c_bey.tKm.tZp.sYA);
            }
            if (com_tencent_mm_protocal_c_bey.tUZ != null) {
                str2 = new String(com_tencent_mm_protocal_c_bey.tUZ.tZp.sYA);
            }
            String str3 = new String((str + "&&" + str2).getBytes());
            q.ccj();
            String cci = q.cci();
            com.tencent.mm.wallet_core.c.a.cbV();
            if (com.tencent.mm.wallet_core.c.a.isCertExist(cci)) {
                com.tencent.mm.plugin.report.service.g.oUh.a(414, 20, 1, true);
                com.tencent.mm.wallet_core.c.a.cbV();
                String genUserSig = com.tencent.mm.wallet_core.c.a.genUserSig(cci, str3);
                com.tencent.mm.plugin.report.service.g.oUh.a(414, 21, System.currentTimeMillis() - currentTimeMillis, true);
                w.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[]{str3, genUserSig});
                com_tencent_mm_protocal_c_bey.sign = genUserSig;
                com_tencent_mm_protocal_c_bey.ufv = cci;
            } else {
                objArr = new Object[2];
                objArr[0] = cci;
                com.tencent.mm.wallet_core.c.a.cbV();
                objArr[1] = Integer.valueOf(com.tencent.mm.wallet_core.c.a.getLastError());
                w.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", objArr);
            }
            w.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), cci});
        }
        if (this.wEF) {
            int d = d(this.gUA);
            if (d != -1) {
                return d;
            }
        }
        if (m.xY()) {
            w.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
            eVar2.a(1000, -100868, "Pay Method Err", this);
            return 1;
        }
        return a(eVar, this.gUA, this);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int zi() {
        return 385;
    }
}
